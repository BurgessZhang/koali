package com.clover.koali.wechat.miniapp.util;

import com.clover.koali.wechat.common.util.PKCS7Encoder;
import com.clover.koali.wechat.common.util.WxCryptUtils;
import com.clover.koali.wechat.miniapp.config.WechatMiniConfig;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.miniapp.util
 * @file WechatMiniCryptUtils.java
 * @time 15:19/2018-12-19
 * @desc
 */
public class WechatMiniCryptUtils extends WxCryptUtils {

    public WechatMiniCryptUtils(WechatMiniConfig config) {
        this.appidOrCorpid = config.getAppid();
        this.token = config.getToken();
        this.aesKey = Base64.decodeBase64(config.getAesKey() + "=");
    }

    /**
     * AES解密
     *
     * @param encryptedData 消息密文
     * @param ivStr         iv字符串
     */
    public static String decrypt(String sessionKey, String encryptedData, String ivStr) {
        try {
            AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
            params.init(new IvParameterSpec(Base64.decodeBase64(ivStr)));

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(Base64.decodeBase64(sessionKey), "AES"), params);

            return new String(PKCS7Encoder.decode(cipher.doFinal(Base64.decodeBase64(encryptedData))), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("AES解密失败", e);
        }
    }


}

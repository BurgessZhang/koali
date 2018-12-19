package com.clover.koali.wechat.common.util;


import java.util.ArrayList;

/**
 * @author 番薯(Koali)
 * @project koali
 * @package com.clover.koali.wechat.common.util
 * @file ByteGroup.java
 * @time 15:22/2018-12-19
 * @desc
 */
public class ByteGroup {

    ArrayList<Byte> byteContainer = new ArrayList<>();

    public byte[] toBytes() {
        byte[] bytes = new byte[this.byteContainer.size()];
        for (int i = 0; i < this.byteContainer.size(); i++) {
            bytes[i] = this.byteContainer.get(i);
        }
        return bytes;
    }

    public ByteGroup addBytes(byte[] bytes) {
        for (byte b : bytes) {
            this.byteContainer.add(b);
        }
        return this;
    }

    public int size() {
        return this.byteContainer.size();
    }
}

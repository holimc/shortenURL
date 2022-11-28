package com.holimc.urlshortener.util;

import org.springframework.stereotype.Component;

@Component
public class Base62 {
    private final int base62 = 62;
    private final String base62_char = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public String encode(int id){
        StringBuilder sb = new StringBuilder();
        while(id>0){
            sb.append(base62_char.charAt((int) id % base62));
            id /= base62;
        }
        return sb.toString();
    }

    public int decode(String shorten) {
        int sum = 0;
        int power = 1;
        for (int i = 0; i < shorten.length(); i++) {
            sum += base62_char.indexOf(shorten.charAt(i)) * power;
            power *= base62;
        }
        return sum;
    }
}

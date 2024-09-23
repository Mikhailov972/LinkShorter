package com.pet.shortlink.service;

import org.springframework.stereotype.Service;

@Service
public class HashService {

    public int hashFnv(byte[] data) {
        int hash = 0x811c9dc5;
        for (byte b : data) {
            hash ^= (b & 0xff);
            hash *= 0x01000193;
        }
        return hash;
    }

    public String hashUrl(String longUrl) {
        int fnvHash = hashFnv(longUrl.getBytes());
        return Integer.toHexString(fnvHash);
    }
}

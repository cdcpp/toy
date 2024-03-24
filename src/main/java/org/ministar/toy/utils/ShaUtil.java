package org.ministar.toy.utils;

import com.google.common.hash.Hashing;
import org.springframework.boot.SpringBootConfiguration;

import java.nio.charset.StandardCharsets;

public class ShaUtil {


    public String sha256Encode(String pwd){

        return Hashing.sha256()
                .hashString(pwd , StandardCharsets.UTF_8)
                .toString();
    }



}

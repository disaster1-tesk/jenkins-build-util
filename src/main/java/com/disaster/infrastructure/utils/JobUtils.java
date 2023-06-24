package com.disaster.infrastructure.utils;


import com.disaster.infrastructure.props.EnvProperties;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class JobUtils {

    private static EnvProperties envProperties;

    @Autowired
    public JobUtils(EnvProperties envProperties) {
        JobUtils.envProperties = envProperties;
    }

    public static Map<String, String> testAddress = new ConcurrentHashMap<>();

    public static Map<String, String> releaseAddress = new ConcurrentHashMap<>();


    public static Map<String,String> tokenCache = new ConcurrentHashMap<>();


    public static List<String> allJobInfo = new LinkedList<>();

    


    public static String getApiToken(String url){
       return envProperties.getTokens().get(url);
//        return tokenCache.get(url);
    }

    public static Map<String, String> getTestAddress() {
        return envProperties.getTestAddress();
//        return testAddress;
    }

    public static Map<String, String> getReleaseAddress() {
        return envProperties.getReleaseAddress();
//        return releaseAddress;
    }

    public static List<String> getAllJobInfo() {
        return allJobInfo;
    }
}

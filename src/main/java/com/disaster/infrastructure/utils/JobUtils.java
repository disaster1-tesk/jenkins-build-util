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

    static {
        testAddress.put("weaver-customer-service-mysql", "http://10.12.101.10:8080/job/weaver-customer-service");
        testAddress.put("weaver-operation-platform-mysql", "http://10.12.101.10:8080/job/weaver-operation-platform");
        testAddress.put("weaver-customer-service-sqlserver", "http://10.12.101.37:8080/job/weaver-customer-service");
        testAddress.put("weaver-operation-platform-sqlserver", "http://10.12.101.37:8080/job/weaver-operation-platform");
        testAddress.put("weaver-customer-service-oracle", "http://10.12.101.34:8080/job/weaver-customer-service");
        testAddress.put("weaver-operation-platform-oracle", "http://10.12.101.34:8080/job/weaver-operation-platform");
        testAddress.put("weaver-customer-service-PG", "http://10.12.101.43:8080/job/weaver-customer-service");
        testAddress.put("weaver-operation-platform-PG", "http://10.12.101.43:8080/job/weaver-operation-platform");
        testAddress.put("weaver-customer-service-达梦", "http://10.12.101.40:8080/job/weaver-customer-service");
        testAddress.put("weaver-operation-platform-达梦", "http://10.12.101.40:8080/job/weaver-operation-platform");
        testAddress.put("weaver-customer-service-神通", "http://10.12.101.41:8080/job/weaver-customer-service");
        testAddress.put("weaver-operation-platform-神通", "http://10.12.101.41:8080/job/weaver-operation-platform");

        releaseAddress.put("weaver-customer-service-mysql", "http://10.12.102.100:8080/job/weaver-customer-service");
        releaseAddress.put("weaver-operation-platform-mysql", "http://10.12.102.100:8080/job/weaver-operation-platform");
        releaseAddress.put("weaver-customer-service-sqlserver", "http://10.12.106.140:8080/job/weaver-customer-service");
        releaseAddress.put("weaver-operation-platform-sqlserver", "http://10.12.106.140:8080/job/weaver-operation-platform");
        releaseAddress.put("weaver-customer-service-oracle", "http://10.12.106.130:8080/job/weaver-customer-service");
        releaseAddress.put("weaver-operation-platform-oracle", "http://10.12.106.130:8080/job/weaver-operation-platform");
        releaseAddress.put("weaver-customer-service-PG", "http://10.12.106.150:8080/job/weaver-customer-service");
        releaseAddress.put("weaver-operation-platform-PG", "http://10.12.106.150:8080/job/weaver-operation-platform");
        releaseAddress.put("weaver-customer-service-达梦", "http://10.12.106.160:8080/job/weaver-customer-service");
        releaseAddress.put("weaver-operation-platform-达梦", "http://10.12.106.160:8080/job/weaver-operation-platform");
        releaseAddress.put("weaver-customer-service-神通", "http://10.12.106.170:8080/job/weaver-customer-service");
        releaseAddress.put("weaver-operation-platform-神通", "http://10.12.106.170:8080/job/weaver-operation-platform");


        tokenCache.put("http://10.12.101.10:8080","11ec8c8e3e021ffcfc48f91f758fe6d40d");
        tokenCache.put("http://10.12.101.37:8080","118894759ed2e2815e795d8cdee2fe09ab");
        tokenCache.put("http://10.12.101.34:8080","1117b5544962eafd0187a82d6e784d5f26");
        tokenCache.put("http://10.12.101.43:8080","11351527f2f4bb99109e36971a769b3e21");
        tokenCache.put("http://10.12.101.41:8080","114c4de9eac19d7c914dcd0763856c3466");
        tokenCache.put("http://10.12.101.40:8080","1180ad38c514aec9ed945765fa051c1d58");
        tokenCache.put("http://10.12.102.100:8080","117c50c13d50a9492817eb0009191a5c4f");
        tokenCache.put("http://10.12.106.140:8080","11e995f294993610f6dc04c02dbc968433");
        tokenCache.put("http://10.12.106.130:8080","116f1a33cdf6e951127dcebb254db50971");
        tokenCache.put("http://10.12.106.170:8080","11f691ae7e621024015f69126a5f89ee93");
        allJobInfo.add("weaver-customer-service");
        allJobInfo.add("weaver-operation-platform");
    }


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

package com.disaster.infrastructure.client;

import com.cdancy.jenkins.rest.JenkinsClient;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.client.JenkinsHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ConcurrentHashMap;

public class JenkinsFactory {
    private JenkinsFactory() {
    }

    private static ConcurrentHashMap<String, JenkinsServer> serverCache = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, JenkinsClient> clientCache = new ConcurrentHashMap<>();


    /**
     * Http 客户端工具
     * <p>
     * 如果有些 API 该Jar工具包未提供，可以用此Http客户端操作远程接口，执行命令
     *
     * @return
     */
    public static JenkinsClient getClient(String url, String userName, String password, String apiToken) {
        JenkinsClient jenkinsHttpClient = null;
        try {
            if (clientCache.containsKey(url)) {
                jenkinsHttpClient = clientCache.get(url);
            } else {
                jenkinsHttpClient = JenkinsClient.builder()
                        .endPoint(url)
                        .credentials(userName + ":" + password)
                        .apiToken(userName + ":" + apiToken)
                        .build();
                clientCache.put(url, jenkinsHttpClient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jenkinsHttpClient;
    }

    /**
     * 连接 Jenkins
     */
    public static JenkinsServer connection(String url, String userName, String password) {
        JenkinsServer jenkinsServer = null;
        try {
            if (serverCache.containsKey(url)) {
                jenkinsServer = serverCache.get(url);
            } else {
                jenkinsServer = new JenkinsServer(new URI(url), userName, password);
                serverCache.put(url, jenkinsServer);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return jenkinsServer;
    }
}

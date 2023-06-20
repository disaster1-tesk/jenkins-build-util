package com.disaster.infrastructure.config;

import cn.dev33.satoken.config.SaCookieConfig;
import cn.dev33.satoken.config.SaTokenConfig;
import com.disaster.infrastructure.constant.GlobalConstant;
import com.disaster.infrastructure.props.EnvProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
@EnableConfigurationProperties(EnvProperties.class)
@Slf4j
public class GlobalConfig implements WebMvcConfigurer {
    @Bean
    @Primary
    public SaTokenConfig getSaTokenConfigPrimary() {
        SaTokenConfig config = new SaTokenConfig();
        config.setTokenName(GlobalConstant.tokenName);          // token名称 (同时也是cookie名称)
        config.setTimeout(24 * 60 * 60);                    // token有效期，单位s 默认30天
        config.setActivityTimeout(30 * 60 * 60);         // token临时有效期 (指定时间内无操作就视为token过期) 单位: 秒
        config.setIsConcurrent(false);               // 是否y]允许同一账号并发登录 (为true时允许一起登录, 为false时新登录挤掉旧登录)
        config.setIsShare(false);                   // 在多人登录同一账号时，是否共用一个token (为true时所有登录共用一个token, 为false时每次登录新建一个token)
        config.setTokenStyle("uuid");               // token风格
        config.setIsLog(true);                      // 是否输出操作日志
        config.setTokenStyle("random-64");          // 设置token风格
        config.setTokenSessionCheckLogin(true);     // 获取 Token-Session 时是否必须登录
        config.setIsReadCookie(true);               // 读取cookie
        config.setIsReadHeader(true);               // 读取请求头中的token
        config.setDataRefreshPeriod(30);            // 默认数据持久组件实现类中，每次清理过期数据间隔的时间 （单位: 秒） ，默认值30秒，设置为-1代表不启动定时清理
        config.setAutoRenew(true);                  // 是否打开自动续签 （如果此值为true, 框架会在每次直接或间接调用 getLoginId() 时进行一次过期检查与续签操作）
        config.setCookie(new SaCookieConfig()
                .setHttpOnly(true)
                .setSecure(true)
                .setSameSite("Strict")
                .setPath("/")
                .setDomain("localhost")
        );
        return config;
    }



}

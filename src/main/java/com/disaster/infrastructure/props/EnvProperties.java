package com.disaster.infrastructure.props;

import com.disaster.infrastructure.constant.GlobalConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = GlobalConstant.ENV_PREFIX)
@Data
public class EnvProperties {
    private String username = "admin";
    private String password = "admin";
    private Map<String, String> testAddress;
    private Map<String, String> releaseAddress;
    private Map<String,String> tokens;
}

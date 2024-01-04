package com.roadjava.student.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author zhaodaowen
 * @see <a href="http://www.roadjava.com">乐之者java</a>
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "auth")
public class AuthrizationProperties {
    /**
     * 不需要权限校验的url列表
     */
    private List<String> ignoreUrls;
}

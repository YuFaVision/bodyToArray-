package org.apache.shenyu.plugin.body.to.array;

import org.apache.shenyu.plugin.api.ShenyuPlugin;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "shenyu.plugins.body-to-array.enabled", havingValue = "true")
public class BodyToArrayPluginConfiguration {

    @Bean
    public ShenyuPlugin bodyToArrayPlugin() {
        return new BodyToArrayPlugin();
    }
}

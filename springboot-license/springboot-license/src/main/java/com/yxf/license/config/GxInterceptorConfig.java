package com.yxf.license.config;

import com.yxf.license.interceptor.LicenseCheckInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>拦截器配置类</p>
 *
 * @author yixiangfeng
 * @blob http://www.wxsstudy.top
 * @date 2:21 2020-05-13
 */
@Configuration
public class GxInterceptorConfig implements WebMvcConfigurer {

    @Bean
    public LicenseCheckInterceptor getLicenseCheckInterceptor() {
        return new LicenseCheckInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.getLicenseCheckInterceptor()).addPathPatterns(new String[]{"/**"});
    }
}

package com.bt.course.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MybatiesPlusConfig {
    /**
     * 新的分页插件
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatiesPlusInterceptor(){
        MybatisPlusInterceptor mybatiesPlusInterceptor = new MybatisPlusInterceptor();
        mybatiesPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return mybatiesPlusInterceptor;

    }
}

package com.ddockddack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.config.BootstrapMode;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableJpaAuditing
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaRepositories(basePackages = {"com.ddockddack.domain.bestcut.repository",
        "com.ddockddack.domain.multigame.repository",
        "com.ddockddack.domain.singlegame.repository",
    "com.ddockddack.domain.member.repository",
    "com.ddockddack.domain.report.repository",
    "com.ddockddack.domain.ranking.repository"}, bootstrapMode = BootstrapMode.DEFERRED)
@EnableRedisRepositories(basePackages = {"com.ddockddack.domain.gameroom.repository"})
public class DdockddackApplication {

    static {
        System.setProperty("com.amazonaws.sdk.disableEc2Metadata", "true");
    }

    public static void main(String[] args) {
        SpringApplication.run(DdockddackApplication.class, args);
    }

}



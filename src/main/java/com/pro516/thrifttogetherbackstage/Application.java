package com.pro516.thrifttogetherbackstage;

import com.pro516.thrifttogetherbackstage.util.PortUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@EnableElasticsearchRepositories(basePackages = "com.pro516.thrifttogetherbackstage.elasticsearch")
public class Application {

    static {
        PortUtil.checkPort(9300, "ElasticSearch 服务端", true);
        PortUtil.checkPort(5601, "Kibana 工具", true);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

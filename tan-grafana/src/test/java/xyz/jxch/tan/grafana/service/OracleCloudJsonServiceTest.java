package xyz.jxch.tan.grafana.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class OracleCloudJsonServiceTest {
    @Autowired
    private OracleCloudJsonService oracleCloudJsonService;

    @Test
    void select() {
        log.info(oracleCloudJsonService.select("select * from index_fund"));
    }
}
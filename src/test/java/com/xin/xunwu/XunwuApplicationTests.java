package com.xin.xunwu;

import com.xin.xunwu.entity.House;
import com.xin.xunwu.mapper.HouseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class XunwuApplicationTests {

    @Resource
    HouseMapper houseMapper;


    @Test
    void contextLoads() {
    }

}

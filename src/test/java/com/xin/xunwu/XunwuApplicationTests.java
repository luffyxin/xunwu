package com.xin.xunwu;

import com.xin.xunwu.entity.EsEntity;
import com.xin.xunwu.entity.House;
import com.xin.xunwu.mapper.HouseMapper;
import com.xin.xunwu.util.EsUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class XunwuApplicationTests {

    @Resource
    EsUtil esUtil;

    @Resource
    HouseMapper houseMapper;


    @Test
    void contextLoads() {
        try {
            House house = new House();
            house.setId(15);
            House mysqlHouse = houseMapper.selectOne(house);
            EsEntity<House> entity = new EsEntity<>();
            entity.setId(mysqlHouse.getId().toString());
            entity.setData(mysqlHouse);
             esUtil.insertOrUpdateOne("house",entity);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

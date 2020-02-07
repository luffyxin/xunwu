package com.xin.xunwu.service;


import com.xin.xunwu.constant.ComConstant;
import com.xin.xunwu.entity.EsEntity;
import com.xin.xunwu.entity.House;
import com.xin.xunwu.entity.HouseDetail;
import com.xin.xunwu.mapper.HouseDetailMapper;
import com.xin.xunwu.mapper.HouseMapper;
import com.xin.xunwu.mapper.HouseTagMapper;
import com.xin.xunwu.util.EsUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Slf4j
@Service
public class SearchService {

    @Resource
    private EsUtil esUtil;

    @Resource
    private HouseMapper houseMapper;


    @Resource
    private HouseDetailMapper houseDetailMapper;

    @Resource
    private HouseTagMapper houseTagMapper;


    public void index(Long houseId){
        ModelMapper modelMapper = new ModelMapper();

        House house = houseMapper.selectByPrimaryKey(houseId);
        if(house == null){
            log.error("house index {} does not exist",houseId);
            return;
        }

        HouseIndexTemplate indexTemplate = new HouseIndexTemplate();
        modelMapper.map(house,indexTemplate);

        HouseDetail houseDetail  = houseDetailMapper.findByHouseId(houseId);
        if(houseDetail == null){
            log.warn("houseDetail is empty");
        }

        modelMapper.map(houseDetail,indexTemplate);
        



        EsEntity<HouseIndexTemplate> entity = new EsEntity<>();
        entity.setId(indexTemplate.getHouseId().toString());
        entity.setData(indexTemplate);



    }


    public boolean create(EsEntity entity){

        try {
           return esUtil.insertOrUpdateOne(ComConstant.INDEX_NAME,entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


}

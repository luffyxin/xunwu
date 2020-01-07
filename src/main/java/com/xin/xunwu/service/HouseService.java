package com.xin.xunwu.service;

import com.xin.xunwu.entity.House;
import com.xin.xunwu.mapper.HouseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * copyright:
 * Company: 上海悟泰信息科技有限公司
 *
 * @author dx
 * @since 2020/1/7 16:42
 */
@Service
public class HouseService {


    @Resource
    private HouseMapper houseMapper;

    public List<House> getAllHouse(){
        return houseMapper.selectAll();
    }

}

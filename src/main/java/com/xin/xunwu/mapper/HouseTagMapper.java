package com.xin.xunwu.mapper;

import com.xin.xunwu.entity.HouseTag;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface HouseTagMapper extends Mapper<HouseTag> {

    HouseTag findByNameAndHouseId(@Param("name") String name,@Param("houseId") Long houseId);

    List<HouseTag> findAllByHouseId(Long houseId);

    List<HouseTag> findAllByHouseIdIn(List<Long> houseIds);

}
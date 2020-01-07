package com.xin.xunwu.web.controller;

import com.xin.xunwu.base.ApiResponse;
import com.xin.xunwu.entity.House;
import com.xin.xunwu.service.HouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * copyright:
 * Company: 上海悟泰信息科技有限公司
 *
 * @author dx
 * @since 2020/1/7 16:40
 */
@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @Resource
    private HouseService houseService;

    @GetMapping("/corss")
    public ApiResponse test (){


    return new ApiResponse(200,"成功获取房屋信息",houseService.getAllHouse());
    }

}

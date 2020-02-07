package com.xin.xunwu.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.xin.xunwu.base.Verifys;
import com.xin.xunwu.base.response.ApiParam;
import com.xin.xunwu.base.response.ApiResult;
import com.xin.xunwu.entity.House;
import com.xin.xunwu.service.HouseService;
import com.xin.xunwu.util.RestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

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

    @Value("${elasticsearch.url}")
    String esUrl;



    @Verifys
    @GetMapping("/corss")
    public ApiParam test(House house) {
        return new ApiParam(ApiResult.getErrorResult("10001"));
    }


    @PostMapping("/elastic")
    public String elasticTest(@RequestBody JSONObject jsonObject) {

        String url = esUrl + jsonObject.getString("url");


        jsonObject.remove("url");
        RestUtil restUtil = new RestUtil();
        if (url.contains("/_search")) {

            ResponseEntity<JSONObject> responseEntity = restUtil.restQuery(url, jsonObject);

            if (responseEntity != null) {
                return responseEntity.getBody().toJSONString();

            }

        }
        return null;
    }


    @PostMapping("download")
    public void download(@RequestBody  JSONObject jsonObject){
        String urlStr = jsonObject.getString("url");

        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();


            InputStreamReader inputStreamReader = new InputStreamReader(inStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


            String str;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

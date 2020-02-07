package com.xin.xunwu.util;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.StandardCharsets;
import java.util.List;


/**
 * @author Administrator
 */
@Slf4j
public class RestUtil {


    public ResponseEntity<JSONObject> restQuery(String url, JSONObject data) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<JSONObject> responseEntity = null;
        // 转换编码格式
        List<HttpMessageConverter<?>> list = restTemplate.getMessageConverters();
        for (HttpMessageConverter<?> httpMessageConverter : list) {
            if (httpMessageConverter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter)
                        httpMessageConverter).setDefaultCharset(StandardCharsets.UTF_8);
                break;
            }
        }


        // 设置头信息
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Lists.newArrayList(MediaType.APPLICATION_JSON));


        HttpEntity<String> entity = new HttpEntity<>(data.toString(), headers);
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, JSONObject.class);
        } catch (Exception e) {
            // 查询数据失败
            log.warn("query elasticsearch error [message] {}", e.getMessage());
        }

        return responseEntity;

    }


}

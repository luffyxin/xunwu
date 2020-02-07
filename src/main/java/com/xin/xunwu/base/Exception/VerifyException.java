package com.xin.xunwu.base.Exception;

import com.xin.xunwu.base.response.ApiResult;

/**
 * @Author: dx
 * @Description: 参数验证异常
 * @Date: 2020/2/7 0007
 * @Version: 1.0
 */
public class VerifyException extends BizException {

    public VerifyException(ApiResult apiResult) {
        super(apiResult);
    }

}

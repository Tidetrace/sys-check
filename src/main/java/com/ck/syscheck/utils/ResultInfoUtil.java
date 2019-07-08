package com.ck.syscheck.utils;


import com.ck.syscheck.model.ResultInfo;

/**
 * 返回结果工具类
 *
 * @author ck
 * @date 2019/7/1
 */
public class ResultInfoUtil {

    public static ResultInfo success(Object object) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setData(object);
        resultInfo.setCode(0);
        resultInfo.setMsg("成功");
        return resultInfo;
    }

    public static ResultInfo success() {
        return success(null);
    }

    public static ResultInfo error(Integer code, String msg) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(code);
        resultInfo.setMsg(msg);
        return resultInfo;
    }
}
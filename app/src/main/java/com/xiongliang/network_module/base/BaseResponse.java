package com.xiongliang.network_module.base;

import java.util.List;

public class BaseResponse<T> {
    /**
     * 错误码
     */
    public int error_code;

    /**
     * 错误描述
     */
    public String reason;

    /**
     * 数据体
     */
    public List<T> result;

    public int getErrno() {
        return error_code;
    }

    public void setErrno(int errno) {
        this.error_code = errno;
    }

    public String getDesc() {
        return reason;
    }

    public void setDesc(String desc) {
        this.reason = desc;
    }

    public List<T> getData() {
        return result;
    }

    public void setData(List<T> data) {
        this.result = data;
    }
}

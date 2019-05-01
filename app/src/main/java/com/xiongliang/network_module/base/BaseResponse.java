package com.xiongliang.network_module.base;

public class BaseResponse<T> {
    /**
     * 错误码
     */
    public int errno;

    /**
     * 错误描述
     */
    public String desc;

    public T data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

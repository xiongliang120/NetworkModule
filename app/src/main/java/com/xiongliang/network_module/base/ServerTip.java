package com.xiongliang.network_module.base;



public class ServerTip {
    /**
     * 错误码
     */
    public int errno;

    /**
     * 错误描述
     */
    public String desc;

    public ServerTip() {

    }

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

    @Override
    public String toString() {
        return errno + " : " + getDesc();
    }


}

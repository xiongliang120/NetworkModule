package com.xiongliang.network_module.bean.request;

public class ArticlePage {
    private int page_size;

    private int page_num;

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public int getPage_num() {
        return page_num;
    }

    public void setPage_num(int page_num) {
        this.page_num = page_num;
    }

    @Override
    public String toString() {
        return "page_size:"+page_size+"page_num:"+page_num;
    }
}

package com.zhangchao.spider.bean;

import java.io.Serializable;

/**
 * Created by zhangchao19 on 2015/10/29.
 */

public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    private String shortUrl;

    private String originUrl;

    private String title;

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

package com.news.entity;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private Integer cid;
    private Integer cnid;
    private String ccontent;
    private Date cdate;
    private String cip;
    private String cauthor;

    private News news;
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCnid() {
        return cnid;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }

    public void setCnid(Integer cnid) {
        this.cnid = cnid;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getCauthor() {
        return cauthor;
    }

    public void setCauthor(String cauthor) {
        this.cauthor = cauthor;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }



}

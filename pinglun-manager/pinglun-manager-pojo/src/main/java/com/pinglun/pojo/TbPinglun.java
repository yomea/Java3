package com.pinglun.pojo;

import java.util.Date;

public class TbPinglun {
    private Integer id;

    private Integer shuoshuoId;

    private Integer pid;

    private Integer userId;

    private Date created;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShuoshuoId() {
        return shuoshuoId;
    }

    public void setShuoshuoId(Integer shuoshuoId) {
        this.shuoshuoId = shuoshuoId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
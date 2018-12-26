package com.jxky.bgxs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.DatabaseMetaData;
import java.util.Date;

public class Notice {
    private Integer id;

    private String matter;

    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date createtime;

    private Integer mattertype;

    public Integer getMattertype() {
        return mattertype;
    }

    public void setMattertype(Integer mattertype) {
        this.mattertype = mattertype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}

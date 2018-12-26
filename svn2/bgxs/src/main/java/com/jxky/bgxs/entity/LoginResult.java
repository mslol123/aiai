package com.jxky.bgxs.entity;

import java.io.Serializable;

public class LoginResult implements Serializable {
    private int code;
    private String msg;

    @Override
    public String toString() {
        return "LoginResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

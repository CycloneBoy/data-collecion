package com.cycloneboy.utils;

/**
 * Created by CycloneBoy on 2017/7/15.
 */
public class HelmetMsg {
    private int errcode;
    private String errmsg;
    private Object helmetdata;

    public HelmetMsg(int errcode, String errmsg, Object helmetdata) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.helmetdata = helmetdata;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getHelmetdata() {
        return helmetdata;
    }

    public void setHelmetdata(Object helmetdata) {
        this.helmetdata = helmetdata;
    }
}

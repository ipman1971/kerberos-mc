package com.ipman1971.kerberos.mc.domain;

/**
 * Created by jcorredera on 25/01/17 - 14:16.
 */
public class ControllerErrorInfo {
    public final String detail;
    public final String message;

    public ControllerErrorInfo(Exception ex, String detail) {
        this.message = ex.getLocalizedMessage();
        this.detail = detail;
    }
}

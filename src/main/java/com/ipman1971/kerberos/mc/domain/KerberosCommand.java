package com.ipman1971.kerberos.mc.domain;

import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by jcorredera on 26/01/17 - 12:12.
 */
@ApiModel(description = "described command executed in Kerberos server")
public class KerberosCommand {

    private String command;
    private String msg;

    public KerberosCommand(String command, String msg) {
        this.command = command;
        this.msg = msg;
    }

    public KerberosCommand() {}

    @ApiModelProperty(name = "command", dataType = "string", required = true)
    public String getCommnad() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @ApiModelProperty(name = "msg", dataType = "string", required = true)
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).
                add("command",command).
                add("msg",msg).
                omitNullValues().
                toString();
    }

}

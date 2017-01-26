package com.ipman1971.kerberos.mc.domain;

import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by jcorredera on 25/01/17 - 8:49.
 *
 * Modelo de dominio para: <service-name>/<hostname>@<realm>
 *
 * Referencia: http://www.microhowto.info/howto/create_a_service_principal_using_mit_kerberos.html
 *
 */
@ApiModel(description = "model representation for Kerberos Principal")
public class Principal {

    public String serviceName;
    public String hostName;
    public String realm;

    public Principal() {}

    public Principal(String serviceName, String hostName, String realm) {
        this.serviceName = serviceName;
        this.hostName = hostName;
        this.realm = realm;
    }

    public Principal(String serviceName, String hostName) {
        this(serviceName, hostName, null);
    }

    @ApiModelProperty(name = "serviceName",dataType = "string", required = true)
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @ApiModelProperty(name = "hostName",dataType = "string", required = true)
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @ApiModelProperty(name = "realm",dataType = "string",required = false)
    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).
                add("serviceName",serviceName).
                add("hostName",hostName).
                add("realm",realm).
                omitNullValues().
                toString();
    }

}

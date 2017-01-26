package com.ipman1971.kerberos.mc.services.impl;

import com.ipman1971.kerberos.mc.domain.KerberosCommand;
import com.ipman1971.kerberos.mc.exceptions.KerberosInternalOperationException;
import com.ipman1971.kerberos.mc.domain.Principal;
import com.ipman1971.kerberos.mc.services.KerberosOperations;
import org.springframework.stereotype.Service;

/**
 * Created by jcorredera on 24/01/17 - 12:59.
 */
@Service
public class KerberosOperationsImpl implements KerberosOperations {

    private static final String CREATE_PRINCIPAL_COMMAND="kadmin -q 'addprinc ";

    @Override
    public KerberosCommand createPrincipal(Principal principal) throws KerberosInternalOperationException {
        if("STRATIO.COM".equalsIgnoreCase(principal.getRealm())) {
            throw new KerberosInternalOperationException("Stratio not is realm allowed");
        }
        StringBuffer command=new StringBuffer(CREATE_PRINCIPAL_COMMAND).
                append(principal.getServiceName()).append("/").
                append(principal.getHostName()).append("@").
                append(principal.getRealm()).append("'");
        return new KerberosCommand(command.toString(),"Add principal in Kerberos");
    }

    @Override
    public boolean checkPrincipal(Principal principal) throws KerberosInternalOperationException {
        return false;
    }

}

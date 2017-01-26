package com.ipman1971.kerberos.mc.services;

import com.ipman1971.kerberos.mc.domain.KerberosCommand;
import com.ipman1971.kerberos.mc.exceptions.KerberosInternalOperationException;
import com.ipman1971.kerberos.mc.domain.Principal;

/**
 * Created by jcorredera on 24/01/17 - 12:55.
 */
public interface KerberosOperations {

    /**
     * Define la operacion para permitir la creacion de un principal de Kerberos
     *
     * COMANDO: kadmin -q "addprinc -randkey HTTP/www.example.com"
     * Referencia: http://www.microhowto.info/howto/create_a_service_principal_using_mit_kerberos.html
     *
     * @param principal
     * @return
     * @throws KerberosInternalOperationException
     */
    public KerberosCommand createPrincipal(Principal principal) throws KerberosInternalOperationException;

    /**
     * Define la operacion que verifica que un principal existe ya
     *
     * COMANDO: kadmin -q "getprinc HTTP/www.example.com"
     * Referencia: http://www.microhowto.info/howto/create_a_service_principal_using_mit_kerberos.html
     *
     * @param principal
     * @return
     * @throws KerberosInternalOperationException
     */
    public boolean checkPrincipal(Principal principal) throws KerberosInternalOperationException;
}

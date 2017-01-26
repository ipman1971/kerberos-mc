package com.ipman1971.kerberos.mc.controllers;

import com.ipman1971.kerberos.mc.domain.KerberosCommand;
import com.ipman1971.kerberos.mc.domain.Principal;
import com.ipman1971.kerberos.mc.exceptions.KerberosInternalOperationException;
import com.ipman1971.kerberos.mc.services.KerberosOperations;
import com.google.common.base.Preconditions;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jcorredera on 25/01/17 - 14:51.
 */
@RestController
@RequestMapping(value = "/kerberos/v1")
@Api(value = "KERBEROS-MC", description = "Kerberos-mc API")
public class KerberosController extends AbstractControllerHandler {

    @Autowired
    private KerberosOperations operations;

    @RequestMapping(value = "/principal", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a Principal in Kerberos server",nickname = "createPrincipal")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = KerberosCommand.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public KerberosCommand createPrincipal(@RequestBody Principal principal, HttpServletRequest request, HttpServletResponse response) throws KerberosInternalOperationException {
        return operations.createPrincipal(principal);
    }

    @RequestMapping(value = "/principal", method = RequestMethod.HEAD, consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Verify a Kerberos Principal.", notes = "Return Error Http - 404 if not exists")
    public boolean checkPrincipal(@RequestBody Principal principal, HttpServletRequest request, HttpServletResponse response) throws KerberosInternalOperationException {
        Preconditions.checkNotNull(principal);
        return operations.checkPrincipal(principal);
    }

}

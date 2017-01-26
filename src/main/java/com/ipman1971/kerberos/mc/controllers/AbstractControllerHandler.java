package com.ipman1971.kerberos.mc.controllers;

import com.ipman1971.kerberos.mc.domain.ControllerErrorInfo;
import com.ipman1971.kerberos.mc.exceptions.DataFormatException;
import com.ipman1971.kerberos.mc.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;


/**
 * Created by jcorredera on 25/01/17 - 14:10.
 * <p>
 * Debe ser extendida por todos los controllers, añade mapeo de excepciones y cualquier
 * funcionalidad comun a todos los controllers
 * <p>
 *
 * OFF-TOPIC: "Me di cuenta, tras unos segundos, de que esa no era mi habitación (vivía en un piso de estudiantes con dos amigos) ni mi casa.
 * Lo más  llegó cuando haciendo un esfuerzo sobrehumano, pude girar poco a poco la cabeza hacia delante y vi como una jodida gorda estaba a
 * cuatro patas sobre mí lamiéndome el rabo, que por supuesto no reaccionaba de su estado semi-muerto (como lo estaba yo en ese momento)."
 * Referencia: http://www.forocoches.com/foro/showthread.php?t=2945385
 *
 */
public abstract class AbstractControllerHandler implements ApplicationEventPublisherAware {

    protected final Logger LOG = LoggerFactory.getLogger(this.getClass());
    protected ApplicationEventPublisher eventPublisher;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataFormatException.class)
    public @ResponseBody ControllerErrorInfo handleDataStoreException(DataFormatException ex, WebRequest request, HttpServletResponse response) {
        LOG.info("Problemas al convertir los datos de la request : " + ex.getMessage());
        return new ControllerErrorInfo(ex, "Problemas al convertir los datos de la request");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public @ResponseBody ControllerErrorInfo handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request, HttpServletResponse response) {
        LOG.info("Recurso no encontrado:" + ex.getMessage());
        return new ControllerErrorInfo(ex, "Recurso no encontrado");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

/*
    //todo: replace with exception mapping
    public static <T> T checkResourceFound(final T resource) throws ResourceNotFoundException {
        if (resource == null) {
            throw new ResourceNotFoundException("resource not found");
        }
        return resource;
    }
*/

}

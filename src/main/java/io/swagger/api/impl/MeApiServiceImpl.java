package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.api.common.UserBO;
import io.swagger.api.persistence.HibernateUtil;
import io.swagger.model.*;

import io.swagger.model.Me;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;
import java.util.logging.Logger;

import org.apache.log4j.LogManager;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-05T22:51:34.212Z")
public class MeApiServiceImpl extends MeApiService {

    private static final org.apache.log4j.Logger logger = LogManager.getLogger(MeApiServiceImpl.class);

    @Override
    public Response meTokenGet(String token, SecurityContext securityContext) throws NotFoundException {
        Me me = new Me();
        logger.info("User recherché :" + token);

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from UserBO where token = :token");
            query.setParameter("token",token);
            List<UserBO> userBOs = query.getResultList();
            if(userBOs.size() != 0){
                me.setLogin(userBOs.get(0).getLogin());
                me.setToken(userBOs.get(0).getToken());
                me.setEmail(userBOs.get(0).getEmail());
                return Response.status(Constants.OK).entity(me).build();
            }
            return Response.status(Constants.BAD_REQUEST).build();

        }
        catch (ExceptionInInitializerError ex)
        {
            logger.info("Erreur avec la base de donnée : " + ex);
        }
        return Response.status(Constants.ERROR).build();
    }
}

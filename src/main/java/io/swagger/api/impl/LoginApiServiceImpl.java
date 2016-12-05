package io.swagger.api.impl;

import io.swagger.api.Constants;
import io.swagger.api.LoginApiService;
import io.swagger.api.common.UserBO;
import io.swagger.api.persistence.HibernateUtil;
import io.swagger.model.Me;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.glassfish.jersey.internal.util.Base64;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-04T16:40:19.632Z")
public class LoginApiServiceImpl extends LoginApiService {

    private static final Logger logger = LogManager.getLogger(LoginApiServiceImpl.class);

    @Override
    public Response loginGet(String login, String password, SecurityContext securityContext) {

        Me me = new Me();

        String token = Base64.encodeAsString(login+":"+password);
        logger.info("token demandé :" + token);

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

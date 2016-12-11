package io.swagger.api.impl;

import io.swagger.api.Constants;
import io.swagger.api.NotFoundException;
import io.swagger.api.SigninApiService;
import io.swagger.api.common.UserBO;
import io.swagger.api.persistence.HibernateUtil;
import io.swagger.model.Inscription;
import io.swagger.model.Me;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.glassfish.jersey.internal.util.Base64;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-27T09:59:00.389Z")
public class SigninApiServiceImpl extends SigninApiService {

    private static final Logger logger = LogManager.getLogger(SigninApiService.class);

    @Override
    public Response signinPost(Inscription inscription, SecurityContext securityContext) throws NotFoundException {

        logger.info("Procédure d'inscription");
        String token = "";

        //recherche disponibilité sur le login
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from UserBO where login = :login");
            query.setParameter("login",inscription.getLogin());
            List<UserBO> userBOs = query.getResultList();
            if(userBOs.size() != 0){
                logger.info("Login déjà utilisé");
                return Response.status(Constants.BAD_REQUEST).build();
            }
        }
        catch (ExceptionInInitializerError ex)
        {
            logger.info("Erreur avec la base de donnée : " + ex);
            return Response.status(Constants.ERROR).build();
        }

        //création de l'utilisateur en base
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            UserBO me = new UserBO();

            me.setLogin(inscription.getLogin());
            me.setEmail(inscription.getEmail());
            String password_crypte = Base64.encodeAsString(inscription.getPassword());
            me.setPassword(password_crypte);
            token = Base64.encodeAsString(inscription.getLogin()+":"+inscription.getPassword());
            me.setToken(token);
            session.save(me);
            session.getTransaction().commit();

        }
        catch (ExceptionInInitializerError ex)
        {
            logger.info("Erreur avec la base de donnée : " + ex);
            return Response.status(Constants.ERROR).build();
        }

        //si tout c'est bien passé renvoie des infos de l'utilisateur
        Me user = new Me();
        user.setLogin(inscription.getLogin());
        user.setEmail(inscription.getEmail());
        user.setToken(token);

        return Response.status(Constants.CREATED).entity(user).build();
    }
}

package io.swagger.api.impl;

import io.swagger.api.Constants;
import io.swagger.api.NotFoundException;
import io.swagger.api.UserApiService;
import io.swagger.api.common.UserBO;
import io.swagger.api.persistence.HibernateUtil;
import io.swagger.model.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-27T09:59:00.389Z")
public class UserApiServiceImpl extends UserApiService {

    private static final Logger logger = LogManager.getLogger(UserApiServiceImpl.class);
    @Override
    public Response userGet(SecurityContext securityContext) throws NotFoundException {

        ArrayList<User> users = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from UserBO");
            List<UserBO> userBOs = query.getResultList();
            for(UserBO userBO : userBOs){
                User user = new User();
                user.setLogin(userBO.getLogin());
                user.setEmail(userBO.getEmail());
                users.add(user);
            }
            return Response.status(Constants.OK).entity(users).build();
        }
        catch (ExceptionInInitializerError ex)
        {
            logger.info("Erreur avec la base de donnée : " + ex);

        }
        return Response.status(Constants.ERROR).build();
    }
    @Override
    public Response userLoginGet(String login, SecurityContext securityContext) throws NotFoundException {

        User user = new User();

        logger.info("Utilisateur demandé : " + login);

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from UserBO where login = :login");
            query.setParameter("login",login);
            List<UserBO> userBOs = query.getResultList();
            if(userBOs.size() != 0){
                logger.info("Utilisateur trouvé");
                user.setLogin(userBOs.get(0).getLogin());
                user.setEmail(userBOs.get(0).getEmail());
                return Response.status(Constants.OK).entity(user).build();
            }

                logger.info("Utilisateur non trouvé");
                return Response.status(Constants.BAD_REQUEST).build();

        }
        catch (ExceptionInInitializerError ex)
        {
            logger.info("Erreur avec la base de donnée : " + ex);

        }
        return Response.status(Constants.ERROR).build();
    }

}

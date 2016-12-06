package io.swagger.api;/**
 * Created by Guillaume on 29/11/2016.
 */

import org.apache.log4j.Logger;

/**
 * Classe non instanciable référencant les constante du service ProxyImgFlip
 */
public class Constants {

    private static final Logger log = Logger.getLogger(Constants.class);

    public static final int ERROR = 503;
    public static final int OK = 200;
    public static final int CREATED = 201;
    public static final int BAD_REQUEST = 400;
    public static final int NOT_FOUND = 404;
    public static final int FORBIDDEN = 401;
    public static final int UNAUTHORIZE = 403;

    public static final String API_LOGIN ="ServiceUtilisateur";
    public static final String API_PASSWORD ="epsi2016";
}

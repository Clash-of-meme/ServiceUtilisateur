package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.LoginApiService;
import io.swagger.api.factories.LoginApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.User;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/login")
@Consumes({ "application/json", "application/xml" })
@Produces({ "application/json", "application/xml" })
@io.swagger.annotations.Api(description = "the login API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-05T21:52:39.785Z")
public class LoginApi  {
   private final LoginApiService delegate = LoginApiServiceFactory.getLoginApi();

    @GET
    
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Connexion", notes = "Endpoint de connexion. ", response = Me.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "API key")
    }, tags={ "login", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Le token de l'utilisateur", response = Me.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request. No user.", response = Me.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Vous devez être identifié.", response = Me.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Vous n'êtes pas autorisé à utiliser cette ressource.", response = Me.class),
        
        @io.swagger.annotations.ApiResponse(code = 503, message = "Erreur de connexion à la base de donnée.", response = Me.class) })
    public Response loginGet(@ApiParam(value = "Identifiant de l'utilisateur.",required=true) @QueryParam("login") String login
,@ApiParam(value = "Password de l'utilisateur.",required=true) @QueryParam("password") String password
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.loginGet(login,password,securityContext);
    }
}

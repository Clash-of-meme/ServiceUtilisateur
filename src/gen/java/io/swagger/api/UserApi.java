package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.UserApiService;
import io.swagger.api.factories.UserApiServiceFactory;

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

@Path("/user")
@Consumes({ "application/json", "application/xml" })
@Produces({ "application/json", "application/xml" })
@io.swagger.annotations.Api(description = "the user API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-05T21:52:39.785Z")
public class UserApi  {
   private final UserApiService delegate = UserApiServiceFactory.getUserApi();

    @GET
    
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Recupérer la liste des utilisateurs", notes = "", response = User.class, responseContainer = "List", authorizations = {
        @io.swagger.annotations.Authorization(value = "API key")
    }, tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "ArrayOfUser", response = User.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Vous devez être identifié.", response = User.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Vous n'êtes pas autorisé à utiliser cette ressource.", response = User.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 503, message = "Erreur de connexion à la base de donnée.", response = User.class, responseContainer = "List") })
    public Response userGet(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.userGet(securityContext);
    }
    @GET
    @Path("/{login}")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Recupérer les informations d'un utilisateur", notes = "", response = User.class, authorizations = {
        @io.swagger.annotations.Authorization(value = "API key")
    }, tags={ "User", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Information utilisateur", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad request. No user.", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 401, message = "Vous devez être identifié.", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Vous n'êtes pas autorisé à utiliser cette ressource.", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 503, message = "Erreur de connexion à la base de donnée", response = User.class) })
    public Response userLoginGet(@ApiParam(value = "ID d'un utilisateur",required=true) @PathParam("login") String login
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.userLoginGet(login,securityContext);
    }
}

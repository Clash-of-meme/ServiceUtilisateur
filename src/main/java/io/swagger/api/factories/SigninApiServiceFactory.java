package io.swagger.api.factories;

import io.swagger.api.SigninApiService;
import io.swagger.api.impl.SigninApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-05T21:52:39.785Z")
public class SigninApiServiceFactory {
    private final static SigninApiService service = new SigninApiServiceImpl();

    public static SigninApiService getSigninApi() {
        return service;
    }
}

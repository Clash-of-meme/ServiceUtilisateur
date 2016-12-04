package io.swagger.api.factories;

import io.swagger.api.SigninApiService;
import io.swagger.api.impl.SigninApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-27T09:59:00.389Z")
public class SigninApiServiceFactory {
    private final static SigninApiService service = new SigninApiServiceImpl();

    public static SigninApiService getSigninApi() {
        return service;
    }
}

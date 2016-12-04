package io.swagger.api.factories;

import io.swagger.api.LoginApiService;
import io.swagger.api.impl.LoginApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-27T09:59:00.389Z")
public class LoginApiServiceFactory {
    private final static LoginApiService service = new LoginApiServiceImpl();

    public static LoginApiService getLoginApi() {
        return service;
    }
}

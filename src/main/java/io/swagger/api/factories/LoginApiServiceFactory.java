package io.swagger.api.factories;

import io.swagger.api.LoginApiService;
import io.swagger.api.impl.LoginApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-05T21:52:39.785Z")
public class LoginApiServiceFactory {
    private final static LoginApiService service = new LoginApiServiceImpl();

    public static LoginApiService getLoginApi() {
        return service;
    }
}

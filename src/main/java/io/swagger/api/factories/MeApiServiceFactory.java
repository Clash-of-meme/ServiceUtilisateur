package io.swagger.api.factories;

import io.swagger.api.MeApiService;
import io.swagger.api.impl.MeApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-12-05T22:51:34.212Z")
public class MeApiServiceFactory {
    private final static MeApiService service = new MeApiServiceImpl();

    public static MeApiService getMeApi() {
        return service;
    }
}

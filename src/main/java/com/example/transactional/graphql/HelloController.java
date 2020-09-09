package com.example.transactional.graphql;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 */
@Path("/hello")
public class HelloController {
    @GET
    public String sayHello() {
        return "Hello World";
    }
}

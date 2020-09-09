package com.example.transactional.graphql;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless @GraphQLApi
public class GraphQlBoundary {
    @Inject Service service;

    @Query public Result foo() { return new Result(service.foo()); }

    public String bar(@Source Result result) {
        return service.foo();
    }
}

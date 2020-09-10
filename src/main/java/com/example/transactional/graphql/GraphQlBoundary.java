package com.example.transactional.graphql;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
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


    @Mutation public String foo(String input) { return input + service.foo(); }

    @Mutation public String bar(String input) { return input + service.foo(); }


    @Mutation public MutationWrapper combined(MutationWrapper wrapper) {
        if (wrapper.foo != null) wrapper.foo = "wrapped:" + foo(wrapper.foo);
        if (wrapper.bar != null) wrapper.bar = "wrapped:" + bar(wrapper.bar);
        return wrapper;
    }

    public static class MutationWrapper {
        public String foo;
        public String bar;
    }
}

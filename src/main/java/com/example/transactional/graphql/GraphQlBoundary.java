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

    @Mutation public String bar(String s, Integer i) { return s + "-" + i + service.foo(); }


    @Mutation public Mutations mutations(MutationsInput input) { return new Mutations().apply(input); }


    public class Mutations {
        public String foo;
        public String bar;

        public Mutations apply(MutationsInput input) {
            if (input.foo != null) this.foo = foo(input.foo);
            if (input.barS != null || input.barI != null) this.bar = bar(input.barS, input.barI);
            return this;
        }
    }

    public static class MutationsInput {
        public String foo;
        public String barS;
        public Integer barI;
    }
}

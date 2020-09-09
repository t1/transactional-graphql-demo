package com.example.transactional.graphql;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
public class GraphQlBoundary {
    @Query public String foo() { return "bar"; }
}

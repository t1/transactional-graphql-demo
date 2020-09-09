package com.example.transactional.graphql;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class RequestScopedBean {
    private static int nextId = 0;

    private final int id = nextId++;

    public int getId() { return id; }
}

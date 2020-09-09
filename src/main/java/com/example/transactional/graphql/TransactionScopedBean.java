package com.example.transactional.graphql;

import javax.transaction.TransactionScoped;
import java.io.Serializable;

@TransactionScoped
public class TransactionScopedBean implements Serializable {
    private static int nextId = 0;

    private final int id = nextId++;

    public int getId() { return id; }
}

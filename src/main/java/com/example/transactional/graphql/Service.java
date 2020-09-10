package com.example.transactional.graphql;

import javax.inject.Inject;

public class Service {

    @Inject TransactionScopedBean transactionScopedBean;
    @Inject RequestScopedBean requestScopedBean;

    public String foo() {
        return "[" +
            "transaction:" + transactionScopedBean.getId() + " " +
            "request:" + requestScopedBean.getId() +
            "]";
    }
}

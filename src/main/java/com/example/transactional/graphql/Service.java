package com.example.transactional.graphql;

import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import static javax.ejb.TransactionAttributeType.MANDATORY;

public class Service {

    @Inject TransactionScopedBean transactionScopedBean;
    @Inject RequestScopedBean requestScopedBean;

    @TransactionAttribute(MANDATORY)
    public String foo() {
        return "[" +
            "transaction:" + transactionScopedBean.getId() + " " +
            "request:" + requestScopedBean.getId() +
            "]";
    }
}

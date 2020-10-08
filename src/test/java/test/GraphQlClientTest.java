package test;

import io.smallrye.graphql.client.typesafe.api.GraphQlClientBuilder;
import org.eclipse.microprofile.graphql.Mutation;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class GraphQlClientTest {
    interface Api {
        @Mutation String foo(String input);
    }

    @Test void shouldCallFoo() {
        Api api = GraphQlClientBuilder.newBuilder()
            .endpoint("http://localhost:8080/transactional-graphql/graphql")
            .build(Api.class);

        String foo = api.foo("glubbi-ö༄\uD83E\uDD2A");

        then(foo).isEqualTo("glubbi-ö༄\uD83E\uDD2A");
    }
}

package com.ToDoListApp.ToDoListApp.Config;

import graphql.GraphQL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;

@Configuration
public class GraphQLConfig {

    @Bean
    public GraphQL graphQL(GraphQLSchema schema) {
        return GraphQL.newGraphQL(schema).build();
    }

    @Bean
    public GraphQLSchema schema() {
        // Define and return your GraphQL schema here
        // Example:
        // return GraphQLSchema.newSchema()
        //          .query(queryType)
        //          .mutation(mutationType)
        //          .build();
        //
        // Replace the above example with the actual implementation of your schema
        // You need to define your types, queries, mutations, and subscriptions
        // using GraphQL Java library or graphql-java-tools
        //
        // Example schema definition:
        //
        // return new GraphQLSchema.Builder()
        //         .query(newQuery())
        //         .mutation(newMutation())
        //         .build();

        // Here's a basic example using GraphQL Java library
        String schemaDefinition = "type Query {\n" +
                "    getUserInfoById(userId: ID!): UserInfo\n" +
                "    getAllUsers: [UserInfo!]!\n" +
                "}\n" +
                "\n" +
                "type Mutation {\n" +
                "    checkValidity(email: String!, password: String!): Boolean!\n" +
                "    registerUser(email: String!, password: String!, name:String!): String!\n" +
                "}\n" +
                "\n" +
                "type UserInfo {\n" +
                "    userId: ID!\n" +
                "    name: String!\n" +
                "    password: String!\n" +
                "    role: Role!\n" +
                "}\n" +
                "\n" +
                "enum Role {\n" +
                "    ROLE_USER\n" +
                "    ROLE_ADMIN\n" +
                "}";

        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaDefinition);
        RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring().build();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);

        return schema;
    }
}

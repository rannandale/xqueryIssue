package com.example;

import org.apache.camel.builder.RouteBuilder;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        // here is a sample which processes the input files
        // (leaving them in place - see the 'noop' flag)
        // then performs content based routing on the message using XPath
        from("file:src/data1?noop=true")
                .to("xquery:transformBodyNoFunction.xquery")
                .to("file:target1/data");

        from("file:src/data2?noop=true")
                .to("xquery:transformBody.xquery")
                .to("file:target2/data");

    }

}

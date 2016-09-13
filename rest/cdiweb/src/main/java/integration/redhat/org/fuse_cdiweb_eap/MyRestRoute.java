package integration.redhat.org.fuse_cdiweb_eap;

import javax.inject.Inject;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.model.rest.RestBindingMode;

@ContextName("MyRestCamelContext")
public class MyRestRoute extends RouteBuilder {


    @Override
    public void configure() {
        // you can configure the route rule with Java DSL here

    	restConfiguration().bindingMode(RestBindingMode.json);

        rest("/rest")
            .produces("text/plain")
            .get("/test")
                .route()
                .log("GET Rest endpoint using CDI")
                .setBody().constant("Ok --returned by Rest CDI endpoint")
                .endRest();
    }
    

}

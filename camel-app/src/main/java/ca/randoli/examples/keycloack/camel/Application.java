package ca.randoli.examples.keycloack.camel;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.camel.CamelContext;
import org.apache.camel.Header;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

public class Application {

    @ContextName("medicare")
    public static class HelloRoute extends RouteBuilder {

        @Override
        public void configure() {
            rest("/patient")
                .produces("text/plain")
                .get("/history/{id}").to("bean:patient?method=getHistory")
                .get("/info/{id}").to("bean:patient?method=getInfo");
        }
    }

    @Named("patient")
    public static class Patient {

        @Inject
        CamelContext context;

        public String getInfo(@Header("id") String id) {
            return "id=" + id + " first-name=John, last-name=Wayne"; 
        }
        
        public String getHistory(@Header("id") String id) {
        	return "id=" + id + " patient history bla bla bla";
        }
    }
}
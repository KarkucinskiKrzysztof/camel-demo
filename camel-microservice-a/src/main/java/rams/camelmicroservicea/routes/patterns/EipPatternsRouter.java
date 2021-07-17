package rams.camelmicroservicea.routes.patterns;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rams.camelmicroservicea.services.SplitterComponent;

@Component
public class EipPatternsRouter extends RouteBuilder {

    private final SplitterComponent splitterComponent;
    public EipPatternsRouter(SplitterComponent splitterComponent) {
        this.splitterComponent = splitterComponent;
    }


    @Override
    public void configure() throws Exception {

        from("timer:multicast?period=10000")
                .multicast()
                .to("log:something1", "log:something1", "activemq:my-activemq-timer-queue");

//        from("file:files/csv")
//                .unmarshal().csv()
//                .split(body())
//                .to("activemq:my-activemq-csv-queue");

//          wymaga w pom.xml
//          <groupId>org.apache.camel.springboot</groupId>
//		    <artifactId>camel-csv-starter</artifactId>

//        from("file:files/csv")
//                .convertBodyTo(String.class)
//                .split(body(), ",")
//                .to("activemq:my-activemq-csv-queue");
        from("file:files/csv")
                .convertBodyTo(String.class)
                .split(method(splitterComponent))
                .to("activemq:my-activemq-csv-queue" , "log:sdf");
    }
}

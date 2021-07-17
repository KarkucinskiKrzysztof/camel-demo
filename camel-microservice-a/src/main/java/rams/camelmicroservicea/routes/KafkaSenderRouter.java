package rams.camelmicroservicea.routes;

import org.apache.camel.builder.RouteBuilder;

//@Component //java.net.UnknownHostException: 4c265f00e5f0 błąd związany z OS
public class KafkaSenderRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:files/kafka")
                .log("${body}")
                .to("kafka:myKafkaTopic");
    }
}

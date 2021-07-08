package rams.camelmicroservicea.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaSenderRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:files/kafka")
                .log("${body}")
                .to("kafka:myKafkaTopic");
    }
}
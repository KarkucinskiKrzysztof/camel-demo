package rams.camelmicroserviceb.routes;

import org.apache.camel.builder.RouteBuilder;

//@Component //java.net.UnknownHostException: 4c265f00e5f0 błąd związany z OS
public class KafkaReceiverRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("kafka:myKafkaTopic")
                .to("log:recived-message-from-kafka");
    }
}

package rams.camelmicroserviceb.route.a;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;
import rams.camelmicroserviceb.pojo.CurrencyExchange;
import rams.camelmicroserviceb.services.MyCurrencyExchangeProcessor;
import rams.camelmicroserviceb.services.MyCurrencyExchangeTransform;

//@Component
public class KafkaReceiverRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:myKafkaTopic")
                .to("log:recived-message-from-kafka");


    }
}

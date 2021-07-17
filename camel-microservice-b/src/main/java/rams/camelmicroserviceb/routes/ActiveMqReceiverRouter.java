package rams.camelmicroserviceb.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;
import rams.camelmicroserviceb.pojo.CurrencyExchange;
import rams.camelmicroserviceb.services.MyCurrencyExchangeProcessor;
import rams.camelmicroserviceb.services.MyCurrencyExchangeTransform;

@Component
public class ActiveMqReceiverRouter extends RouteBuilder {

    private final MyCurrencyExchangeProcessor ceProcessor;
    private final MyCurrencyExchangeTransform ceTransform;

    public ActiveMqReceiverRouter(MyCurrencyExchangeProcessor ceProcessor, MyCurrencyExchangeTransform ceTransform) {
        this.ceProcessor = ceProcessor;
        this.ceTransform = ceTransform;
    }

    @Override
    public void configure() throws Exception {
        from("activemq:my-activemq-timer-queue")
                .to("log:recived-message-from-active-mq");

        from("activemq:my-activemq-json-queue")
                .unmarshal().json(JsonLibrary.Jackson, CurrencyExchange.class)
                .bean(ceProcessor)
                .bean(ceTransform)
                .to("log:recived-message-from-active-mq");
//          unmarshall czyli deserializacja za pomocą jacksona a wiadomość z kolejki jest zmieniana na instancje klasy CurrencyExchange


        from("activemq:my-activemq-xml-queue")
                .unmarshal()
                .jacksonxml(CurrencyExchange.class)
                .to("log:recived-message-from-active-mq-xml");
//                wymaga "camel-jacksonxml-starter" w pom.xml

    }
}

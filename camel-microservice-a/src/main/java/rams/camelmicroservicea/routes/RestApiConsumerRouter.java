package rams.camelmicroservicea.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


//@Component
public class RestApiConsumerRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        restConfiguration().host("localhost").port(8000);
        from("timer:rest-api-consumer?period=10000")
                .setHeader("from", ()-> "PLN")
                .setHeader("to", ()-> "USD")  // hedery można wymagają suplayera i można je wykorzystać w innych czesciach ruty.
                .log("${body}")
                .to("rest:get:/currency-exchange/form/{from}/to/{to}")
                .log("${body}");  // tu mamy odpowiedz jaką dostaliśmy po HTTP  np {"id":1000,"from":"PLN","to":"USD","conversionMultiple":10}

    }
}

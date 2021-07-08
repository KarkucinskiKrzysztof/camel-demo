package rams.camelmicroservicea.route.a;

import java.time.LocalDateTime;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import rams.camelmicroservicea.pojo.SimpleLoogingPeocessor;

//@Component
public class MyFirstTimerRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:MyNameForTimer")
                .log("${body}")  // wyswietla null
                .transform().constant("My Constant Message")
                .transform().constant("Time from transform() is: " + LocalDateTime.now())
                .log("${body}")
                .bean("getCurrentTime", "getTime1")
                .bean("logProcessingComponent")
                .process(new SimpleLoogingPeocessor())
                .to("log:MyNameForTimer");
    }
}



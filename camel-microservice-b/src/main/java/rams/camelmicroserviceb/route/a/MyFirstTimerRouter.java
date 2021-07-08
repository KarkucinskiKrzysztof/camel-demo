package rams.camelmicroserviceb.route.a;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFirstTimerRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

//        from("timer:sdsd").to("log:sdsd");
    }
}

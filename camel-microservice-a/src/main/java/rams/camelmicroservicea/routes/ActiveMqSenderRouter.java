package rams.camelmicroservicea.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMqSenderRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

// działająca ruta wysyłająca co 10 s wiadomość na kolejke my-activemq-queue
        from("timer:active-mq-timer?period=20000")
                .transform().constant("My message for Active MQ")
                .log("${body}")
                .to("activemq:my-activemq-timer-queue");

        from("file:files/json")
                .log("${body}")
                .to("activemq:my-activemq-json-queue");

        from("file:files/xml")
                .log("${body}")
                .to("activemq:my-activemq-xml-queue");
    }
}
// period=10000  wiadomożć jest wysyłana co 10 s
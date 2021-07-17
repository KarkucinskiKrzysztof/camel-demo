package rams.camelmicroservicea.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rams.camelmicroservicea.services.DeciderBean;

@Component
public class MySecondFileRouter extends RouteBuilder {

    private final DeciderBean deciderBean;
    public MySecondFileRouter(DeciderBean deciderBean) {
        this.deciderBean = deciderBean;
    }


    @Override
    public void configure() throws Exception {
        from("file:files/inputSecond")
                .choice()
                    .when(simple("${file:ext} == 'xml'"))
                        .log("XML file")
                    .when(method(deciderBean))
                        .log("DeciderBean true")
                    .otherwise()
                        .log("Not an XML file")
                .end()
                .to("file:files/output");
    }
}
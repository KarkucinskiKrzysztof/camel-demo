package rams.camelmicroservicea.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFileRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:files/input")
                .routeId("Files-Input-Route")
//                .log("${body}")
                .transform().body(String.class)
                .choice()
                    .when(simple("${body} contains 'USD'"))
                        .log("Not XML file but contains USD")
                    .when(simple("${file:ext} == 'xml'"))
                        .log("XML file")
                    .when(simple("${file:ext} == 'json'"))
                        .log("JSON file")
                    .otherwise()
                        .log("Not an XML file")
                .end()
//                .log("${messageHistory}")
//                .log("${headers.CamelFileAbsolute} ${file:absolute.path}")
                .to("direct://log-file-values")
                .to("file:files/output");

        from("direct://log-file-values")
                .routeId("Files-Input-Route-Logs")
                .log("${messageHistory} ${file:absolute.path}")
                .log("${file:name} ${file:name.ext}")
                .log("${file:onlyname.noext} ${file:parent} ${file:path} ${file:absolute}")
                .log("${file:size} ${file:modified}")
                .log("${routeId} ${camelId} ${body}");
    }
}
// może byś kilka warunków when() jeden po drugim ale tylko pierwszy zostanie wykonany.
// można tu stosowac również zmienne z file a nie tylko wartości z simlple langue.
// https://camel.apache.org/components/latest/languages/simple-language.html
// https://camel.apache.org/components/latest/languages/file-language.html
//.transform().body(String.class) // wymagane wo sprawdzenia warunku .when(simple("${body} contains 'USD'"))
//.log("${messageHistory}") sporo informacji w tym hedery
// istnieją ruty typu direct można je stosowac miedzyinnymi do logowanie i umieszczać w innych rutach. Pewien problem pojawia sie jedynie jeśli chcemy wyśeiwtlić orginalne routeID
// taka ruta typu direct fo logoeanie może być użwana w wielu rutach jednocześnie
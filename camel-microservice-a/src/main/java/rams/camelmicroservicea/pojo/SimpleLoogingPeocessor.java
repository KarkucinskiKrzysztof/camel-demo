package rams.camelmicroservicea.pojo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleLoogingPeocessor implements Processor {
    private Logger logger = LoggerFactory.getLogger(SimpleLoogingPeocessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("SimpleLoogingPeocessor {}", exchange.getMessage().getBody());
    }
}

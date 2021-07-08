package rams.camelmicroserviceb.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import rams.camelmicroserviceb.pojo.CurrencyExchange;

@Component
public class MyCurrencyExchangeProcessor {
    Logger logger = LoggerFactory.getLogger(MyCurrencyExchangeProcessor.class);

    public void processMessage(CurrencyExchange currencyExchange){
        logger.info("Do some processing with CurrencyExchange.getConversionMultiple() {} ",
        currencyExchange.getConversionMultiple());
    }
}

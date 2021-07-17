package rams.camelmicroserviceb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import rams.camelmicroserviceb.pojo.CurrencyExchange;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @GetMapping("/currency-exchange/form/{from}/to/{to}")
    public CurrencyExchange findConversationValue(
            @PathVariable String from,
            @PathVariable String to) {
        logger.info("Controller action for /currency-exchange/form/{}/to/{}", from, to );
        return new CurrencyExchange(1000L, from, to, BigDecimal.TEN);
    }

}

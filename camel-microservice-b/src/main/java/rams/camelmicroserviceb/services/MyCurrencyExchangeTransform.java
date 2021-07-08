package rams.camelmicroserviceb.services;

import org.springframework.stereotype.Component;
import rams.camelmicroserviceb.pojo.CurrencyExchange;

import java.math.BigDecimal;

@Component
public class MyCurrencyExchangeTransform {

    public CurrencyExchange processMessage(CurrencyExchange currencyExchange) {
        currencyExchange.setConversionMultiple(
                currencyExchange.getConversionMultiple().multiply(BigDecimal.TEN));
        return currencyExchange;
        // przy transformacjach należy zwracać typ przyjmowany w parametrze przy processowaniu może być void
    }
}
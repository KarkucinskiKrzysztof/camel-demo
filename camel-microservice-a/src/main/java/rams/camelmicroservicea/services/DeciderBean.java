package rams.camelmicroservicea.services;

import org.apache.camel.Body;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Header;
import org.apache.camel.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DeciderBean {
    Logger logger = LoggerFactory.getLogger(DeciderBean.class);
    public boolean isThisConditionMet(
            @Body String body,
            @Headers Map<String,String> headers,
            @Header("CamelFileAbsolutePath") String headerPath,
            @ExchangeProperties Map<String,String> exchangeProperties
            ){
        logger.info("Info {} \n {} \n {} \n {}", body, headers, headerPath, exchangeProperties );
            return true;
    }
}

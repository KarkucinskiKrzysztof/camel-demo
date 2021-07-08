package rams.camelmicroservicea.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogProcessingComponent {
    private Logger logger = LoggerFactory.getLogger(LogProcessingComponent.class);
    public void process(String message) {
        logger.info("LogProcessingComponent {}", message);
    }
}
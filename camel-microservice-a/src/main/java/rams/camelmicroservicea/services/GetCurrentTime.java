package rams.camelmicroservicea.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
@Component
public class GetCurrentTime {

    public String getTime1() {
        return "Time from GetCurrentTime.getTime1 is: " + LocalDateTime.now();
    }

    public String getTime2() {
        return "Time from GetCurrentTime.getTime2 is: " + LocalDateTime.now();
    }
}
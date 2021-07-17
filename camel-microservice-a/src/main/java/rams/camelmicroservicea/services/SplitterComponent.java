package rams.camelmicroservicea.services;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SplitterComponent {

    public List<String> doSplitting(String body){
        // logika która na podstawie body decyduja na jakie części je podzielić.
        return List.of("ACB", "DEF","GHI");
    }
}

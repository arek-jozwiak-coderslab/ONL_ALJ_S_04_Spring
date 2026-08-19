package pl.visa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomController {
    @GetMapping("/random/{max}")
    public String random(@PathVariable int max) {
        Random random = new Random();
        int next = random.nextInt(max) + 1;
        return "Użytkownik podał wartość max." + max +
                " Wylosowano liczbę: wylosowana " + next;
    }
}

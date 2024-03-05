package testRun;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ty {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
    }
}

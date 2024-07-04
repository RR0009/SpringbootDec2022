package owu.com.ua.springbootdec2022.models;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@Async
@EnableScheduling
public class Schedules {

    @Scheduled( cron = "******")
    public void scheduledTask() {
        System.out.println("Scheduled Task");
    }
}

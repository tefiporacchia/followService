package endpoints.follow.jibberjabber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.metrics.export.datadog.EnableDatadogMetrics;

@EnableDatadogMetrics
@SpringBootApplication
public class FollowApplication {

	public static void main(String[] args) {
		SpringApplication.run(FollowApplication.class, args);
	}

}

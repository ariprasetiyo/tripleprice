package tripleprice.aggregator.thrift;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringApplicationMain {
	static Logger log = LoggerFactory.getLogger(SpringApplicationMain.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringApplicationMain.class, args);
	}
}

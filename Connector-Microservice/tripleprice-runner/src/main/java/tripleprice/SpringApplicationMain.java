package tripleprice;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
/**
 * Enable proxyTargetClass=true in @EnableTransactionManagement if there isn't
 * have class interface E.g cases UserDaoImpl
 * 
 * @see {https://github.com/spring-projects/spring-boot/issues/5423} We should
 *      use @EnableTransactionManagement(proxyTargetClass = true) to prevent
 *      nasty proxy issues when people aren't using interfaces.
 */
@EnableTransactionManagement(proxyTargetClass = true)
/*
 * If want to application configuration XML outside jar, can be use "file:"
 * Otherwise, can be use classpath: for placement XML inside jar
 * 
 */
@ImportResource({ "file:resources/applicationContext.xml" })
// @ImportResource("classpath:applicationContext.xml")
@EnableAutoConfiguration
public class SpringApplicationMain {

	static Logger log = LoggerFactory.getLogger(SpringApplicationMain.class);

	public static void main(String[] args) {

		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringApplicationMain.class);
		builder.properties("spring.config.name:resources/application");
		builder.build().run(args);
		/*
		 * If use this, by default configuration application.properties
		 */
		/*
		 * ApplicationContext ctx =
		 * SpringApplication.run(SpringApplicationMain.class, args);
		 * SpringApplication.run(SpringApplicationMain.class, args);
		 */
		/*
		 * String[] profiles =
		 * builder.context().getEnvironment().getActiveProfiles(); for (String
		 * profile : profiles) { if (profile.equals("maven-start")) {
		 * System.out.println("xxxxxxx\n\n\n\n");
		 * builder.properties("spring.config.name:application"); } else {
		 * System.out.println("yyyy\n\n\n\n");
		 * builder.properties("spring.config.name:resources/application"); } }
		 */

		/*
		 * new SpringApplicationBuilder(SpringApplicationMain.class).properties(
		 * "spring.config.name:resources/application") .build().run(args);
		 */
		Authentication auth2 = SecurityContextHolder.getContext().getAuthentication();
		if (auth2 != null) {

			Collection<?> auths = auth2.getAuthorities();

			for (Object da : auths) {
				log.debug("{}", da);
			}

			log.debug("name : " + auth2.getName());
			log.debug("principle : " + auth2.getPrincipal());
			log.debug("principle : " + auth2.getDetails());
			log.debug("principle : " + auth2.getCredentials());
		}
	}
}

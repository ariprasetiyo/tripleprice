package tripleprice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import tripleprice.beans.TestProperties;

//@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
@Configuration
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith (SpringRunner.class)
public class TriplepricePropertiesTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(TriplepricePropertiesTest.class);

	@Autowired
	TestProperties TripepriceProperties;

	@Test
	public void propertiesTest() {
		LOGGER.debug("asasas");
		//LOGGER.debug("Result test={}", TripepriceProperties.getUrlFlightSearchFindKey());
	}
}

package connector;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import tripleprice.flight.traveloka.TravelokaConnector;

@SpringBootTest
@EnableAutoConfiguration
@Configuration
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith (SpringRunner.class)
public class TravelokaConnectorTest {

	@Autowired
	TravelokaConnector travelokaConnector;
	
	@Test
	public void connectorTest(){
		travelokaConnector.getSearch(null);
	}
}

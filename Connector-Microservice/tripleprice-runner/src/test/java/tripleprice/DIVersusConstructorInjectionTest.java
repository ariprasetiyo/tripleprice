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

import tripleprice.aggregator.AggregatorService;

/*@SpringBootTest
@EnableAutoConfiguration
@Configuration
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(SpringRunner.class)*/
public class DIVersusConstructorInjectionTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(TriplepricePropertiesTest.class);

	/*
	 * @Autowired AggregatorService aggregatorService;
	 */
	@Test
	public void benchmarkInejectionTest() {
		long startTime = System.currentTimeMillis();
		// aggregatorService.getFlightSearch();
		LOGGER.debug("Result=duration", System.currentTimeMillis() - startTime);
	}
	
	@Test
	public void test() {
		String sas = "asas";
		sas += "coba";
		LOGGER.debug("Result={}", sas);
	}

	@Test
	public void benchmarkStringBuilderTest() {
		StringBuilder stringBuilder = new StringBuilder();
		String prefix = "prefix";
		for (int ab = 0; ab < 5; ab++) {
			long startTime = System.currentTimeMillis();
			for (int a = 0; a < 100000000; a++) {
					stringBuilder.append("ariprasetiyo");
					stringBuilder.insert(0, prefix.toCharArray());
					String asas = sas(stringBuilder.toString());
					stringBuilder.delete(0, stringBuilder.length());
			}
			LOGGER.debug("Result=duration{}", System.currentTimeMillis() - startTime);
		}
	}

	@Test
	public void benchmarkStringTest() {
		String prefix = "prefix";
		for (int ab = 0; ab < 5; ab++) {
			long startTime = System.currentTimeMillis();
			for (int a = 0; a < 100000000; a++) {
				String string = "ariprasetiyo";
				string = prefix + string;
				sas(string);
			}
			LOGGER.debug("Result=duration{}", System.currentTimeMillis() - startTime);
		}
	}

	private String sas(String sas) {
		return "a";
	}

}

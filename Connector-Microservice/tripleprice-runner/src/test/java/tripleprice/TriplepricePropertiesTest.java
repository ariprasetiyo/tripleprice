package tripleprice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource(locations = "file:resources/application.properties")
/*
 * @ContextConfiguration( locations = { "classpath:applicationContext.xml" },
 * classes={RedisCacheChannel.class, String.class, short.class})
 */
// @ImportResource({ "spring.config.name:resources/application" })
// @ActiveProfiles("local")
public class TriplepricePropertiesTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(TriplepricePropertiesTest.class);

	/*
	 * @Autowired TestProperties TripepriceProperties;
	 */

	@Test
	public void propertiesTest() {
		LOGGER.debug("\n\nlnlnlasasas");
		// LOGGER.debug("Result test={}",
		// TripepriceProperties.getUrlFlightSearchFindKey());
	}
}

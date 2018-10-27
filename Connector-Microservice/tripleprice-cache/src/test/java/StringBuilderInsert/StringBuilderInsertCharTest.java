package StringBuilderInsert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringBuilderInsertCharTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(StringBuilderInsertCharTest.class);

	@Test
	public void insertTest() {
		StringBuilder stringBuilder = new StringBuilder("Hello world!!");
		String prefixWord = "Say ";
		stringBuilder.insert(0, prefixWord.toCharArray());
		LOGGER.debug("Result test={}", stringBuilder.toString());
	}

}

package tripleprice.json.benchmark.test;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonBenchamrkJacksonTest {

	private static final ObjectMapper objectMapper = new ObjectMapper();
	private static final ObjectWriter objectWriter = objectMapper.writerFor(ParentClass.class);
	private static final ObjectReader objectReader = objectMapper.readerFor(ParentClass.class);

	@Test
	public void benchamerJsonTest() throws IOException, InterruptedException {

		ParentClass parentClass = new ParentClass();
		parentClass.setFatherName("Ayah");
		parentClass.setMotherName("Ibu");
		parentClass.setAliasSample("alias_sample");
		parentClass.setDefaultValue("sasas");
		parentClass.setExcludeSample("sasas");

		ChildClass childClass = new ChildClass();
		childClass.setFirstChild("Anak ke 1");
		childClass.setSecondChild("Anak ke 1");
		childClass.setThirdChild("Anak ke 1");
		parentClass.setChildClass(childClass);

		long startTime = System.currentTimeMillis();
		try {
			for (int a = 0; a < 1000000; a++) {
				String jsonResult = objectWriter.writeValueAsString(parentClass);
				ParentClass parentClasss = objectReader.readValue(jsonResult);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() - startTime);

	}

}

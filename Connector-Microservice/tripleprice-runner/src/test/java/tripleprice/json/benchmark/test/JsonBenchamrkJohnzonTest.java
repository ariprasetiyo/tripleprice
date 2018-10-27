package tripleprice.json.benchmark.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.johnzon.mapper.JohnzonIgnore;
import org.apache.johnzon.mapper.JohnzonProperty;
import org.apache.johnzon.mapper.Mapper;
import org.apache.johnzon.mapper.MapperBuilder;
import org.junit.Test;

public class JsonBenchamrkJohnzonTest {

	private static final Mapper mapper = new MapperBuilder().build();

	@Test
	public void benchamerJsonTest() {

		ParentClass parentClass = new ParentClass();
		parentClass.setFatherName("Ayah");
		parentClass.setMotherName("Ibu");
		parentClass.setAliasSample("alias_sample");

		ChildClass childClass = new ChildClass();
		childClass.setFirstChild("Anak ke 1");
		childClass.setSecondChild("Anak ke 1");
		childClass.setThirdChild("Anak ke 1");
		
		List<ChildClass> sass = new ArrayList<>();
		parentClass.setChildClass(sass);

		long startTime = System.currentTimeMillis();
		for (int a = 0; a < 1000000; a++) {
			String jsonResult = mapper.writeObjectAsString(parentClass);
			//mapper.readObject(jsonResult, ParentClass.class);
		}
		System.out.println(System.currentTimeMillis() - startTime);
		/*
		 * System.out.println(jsonResult);
		 * 
		 * final Mapper mappers = new MapperBuilder().build(); final ParentClass
		 * otherObject = mappers.readObject(jsonResult, ParentClass.class);
		 */

		// System.out.println(jsonString);
	}

	public class ParentClass {

		private String fatherName;
		private String motherName;
		@JohnzonProperty("childClass")
		private List<ChildClass> childClass;
		@JohnzonIgnore
		private String excludeSample;
		private String defaultValue = null;

		public String getDefaultValue() {
			return defaultValue;
		}

		public void setDefaultValue(String defaultValue) {
			this.defaultValue = defaultValue;
		}

		@JohnzonProperty("property_name")
		private String aliasSample;

		public String getAliasSample() {
			return aliasSample;
		}

		public void setAliasSample(String aliasSample) {
			this.aliasSample = aliasSample;
		}

		public String getExcludeSample() {
			return excludeSample;
		}

		public void setExcludeSample(String excludeSample) {
			this.excludeSample = excludeSample;
		}

		public String getFatherName() {
			return fatherName;
		}

		public void setFatherName(String fatherName) {
			this.fatherName = fatherName;
		}

		public String getMotherName() {
			return motherName;
		}

		public void setMotherName(String motherName) {
			this.motherName = motherName;
		}

		public List<ChildClass> getChildClass() {
			return childClass;
		}

		public void setChildClass(List<ChildClass> childClass) {
			this.childClass = childClass;
		}



	}

	public class ChildClass {
		private String firstChild;
		private String secondChild;
		private String thirdChild;

		public String getFirstChild() {
			return firstChild;
		}

		public void setFirstChild(String firstChild) {
			this.firstChild = firstChild;
		}

		public String getSecondChild() {
			return secondChild;
		}

		public void setSecondChild(String secondChild) {
			this.secondChild = secondChild;
		}

		public String getThirdChild() {
			return thirdChild;
		}

		public void setThirdChild(String thirdChild) {
			this.thirdChild = thirdChild;
		}

	}
}

package tripleprice.json.benchmark.test;

import java.lang.reflect.Type;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonBenchamrkGsonTest {

	private static final Gson gson = new Gson();
	private static final Type type = ParentClass.class;
	// Jsonb jsonb = JsonbBuilder.create();

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
		parentClass.setChildClass(childClass);
		
		
		long startTime = System.currentTimeMillis();
		for (int a = 0; a < 1000000; a++) {
			String jsonResult = gson.toJson(parentClass);
			ParentClass parentClasss = gson.fromJson(jsonResult, type );
		}
		System.out.println(System.currentTimeMillis() - startTime);

	}

	public class ParentClass {

		private String fatherName;
		private String motherName;
		private ChildClass childClass;
		@Expose(serialize = false)
		private String excludeSample;
		private String defaultValue = null;

		public String getDefaultValue() {
			return defaultValue;
		}

		public void setDefaultValue(String defaultValue) {
			this.defaultValue = defaultValue;
		}

		@SerializedName("alias_Sample")
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

		public ChildClass getChildClass() {
			return childClass;
		}

		public void setChildClass(ChildClass childClass) {
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

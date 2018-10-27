package tripleprice.json.benchmark.test;

import java.util.List;

import org.junit.Test;

import flexjson.JSON;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
/**
 * 
 * tutorial flaxjson:http://flexjson.sourceforge.net/
 * 
 * @author ari.prasetiyo
 *
 */
import flexjson.TypeContext;
import flexjson.transformer.AbstractTransformer;
public class JsonBanchmarkFlexjsonTest {

	@Test
	public void benchamerJsonTest() {

		ParentClass parentClass = new ParentClass();
		parentClass.setFatherName("Ayah");
		parentClass.setMotherName("Ibu");

		ChildClass childClass = new ChildClass();
		childClass.setFirstChild("Anak ke 1");
		childClass.setSecondChild("Anak ke 1");
		childClass.setThirdChild("Anak ke 1");
		parentClass.setChildClass(childClass);

		String jsonString = new JSONSerializer().exclude("*.class", "description")
				.transform(new FieldNameTransformer("fatherName"), "father_name2").
				serialize(parentClass);

		System.out.println(jsonString);
	}

	@Test
	public void sasa() {
		ProductInfo p1 = new ProductInfo();
		p1.setId(1);
		p1.setName("sasa");
		/*
		 * ProductInfo p2 = new ProductInfo(2, "Overflow"); List<ProductInfo>
		 * infos = Arrays.asList(p1, p2);
		 */
		String s = new JSONSerializer().exclude("*.class", "description")
				// .include("productId", "name")
				// EDIT: the "include" call is irrelevant for this example.
				.serialize(p1);
		System.out.println(s);
		// => [{"name":"Stack","productId":1},{"name":"Overflow","productId":2}]
		List<ProductInfo> ls = new JSONDeserializer<List<ProductInfo>>().deserialize(s);
		System.out.println(ls);
		// => [{name=Stack, productId=1}, {name=Overflow, productId=2}]
	}

	public static class ProductInfo {
		private int id;
		private String name;
		private String desc; // Not used, to demonstrate "exclude".

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

	}
	
	

	public class ParentClass {

		@JSON(name = "father_name")
		private String fatherName;
		private String motherName;
		private ChildClass childClass;
		private String excludeSample;
		private String aliasSample;

		// @JSON(jsonname = "genus")
		public String getAliasSample() {
			return aliasSample;
		}

		public void setAliasSample(String aliasSample) {
			this.aliasSample = aliasSample;
		}

		@JSON(include = false)
		public String getExcludeSample() {
			return excludeSample;
		}

		public void setExcludeSample(String excludeSample) {
			this.excludeSample = excludeSample;
		}

		@JSON(name = "father_name")
		public String getFatherName() {
			return fatherName;
		}

		@JSON(name = "father_name")
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

	public static class ChildClass {
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
	
	public class FieldNameTransformer extends AbstractTransformer {
	    private String transformedFieldName;

	    public FieldNameTransformer(String transformedFieldName) {
	        this.transformedFieldName = transformedFieldName;
	    }

	    public void transform(Object object) {
	        boolean setContext = false;

	        TypeContext typeContext = getContext().peekTypeContext();

	        //Write comma before starting to write field name if this
	        //isn't first property that is being transformed
	        if (!typeContext.isFirst())
	            getContext().writeComma();

//	        typeContext.setFirst(false);

	        getContext().writeName(getTransformedFieldName());
	        getContext().writeQuoted(object.toString());

	        if (setContext) {
	            getContext().writeCloseObject();
	        }
	    }

	    /***
	     * TRUE tells the JSONContext that this class will be handling 
	     * the writing of our property name by itself. 
	     */
	    @Override
	    public Boolean isInline() {
	        return Boolean.TRUE;
	    }

	    public String getTransformedFieldName() {
	        return this.transformedFieldName;
	    }
	}


}

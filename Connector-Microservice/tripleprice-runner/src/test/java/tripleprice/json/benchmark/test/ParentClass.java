package tripleprice.json.benchmark.test;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class ParentClass {

	private String fatherName;
	private String motherName;
	@JsonProperty("childClass")
	private ChildClass childClass;
	// @JsonIgnore
	private String excludeSample;
	private String defaultValue = null;

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	@JsonProperty("alias_Sample")
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

package tripleprice.json.benchmark.test;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
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
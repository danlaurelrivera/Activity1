package resource;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class CalculatorRequest implements Serializable{
	private Float firstNumber;
	private Float secondNumber;
	private String operation;
}

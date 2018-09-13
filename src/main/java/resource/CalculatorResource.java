package resource;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/_calculator")
public class CalculatorResource {
	@POST
	@Produces (MediaType.APPLICATION_JSON)
	public Response postNumber (CalculatorRequest request) {	
		Float firstNumber = request.getFirstNumber();
		Float secondNumber = request.getSecondNumber();
		String operation = request.getOperation();
		Float answer = null;
		BigDecimal result = null;
		String operationTxt = null;
		
		try {
			if (firstNumber.isNaN() == false || secondNumber.isNaN() == false || operation.isEmpty() == false) {
				switch (operation) {
			        case "+": answer = firstNumber + secondNumber; operationTxt = "addition"; 		result = BigDecimal.valueOf(answer); break;
			        case "-": answer = firstNumber - secondNumber; operationTxt = "subtraction";  	result = BigDecimal.valueOf(answer); break;
			        case "*": answer = firstNumber * secondNumber; operationTxt = "multiplication";	result = BigDecimal.valueOf(answer); break;
			        case "/": if (secondNumber == 0) {break;} answer = firstNumber / secondNumber; operationTxt = "division";		        
				        String[] output = answer.toString().split("\\.");
				        if (Integer.parseInt(output[1]) == 0) {result = new BigDecimal(String.format("%.0f", answer));}
				    	else { result = new BigDecimal(String.format("%.5f", answer));}
				        break;        
			        default: return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(HttpServletResponse.SC_BAD_REQUEST).build();
				}	
			}else{
				return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(HttpServletResponse.SC_BAD_REQUEST).build();
			}
			CalculatorResponse calculatorResponse = new CalculatorResponse();
    		System.out.println(" "+ result);
			calculatorResponse.setAction(String.format(operationTxt));
			calculatorResponse.setResult(result);		
			return Response.ok().entity(calculatorResponse).build();
		
		}catch(Exception e){
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(HttpServletResponse.SC_BAD_REQUEST).build();
		}
	}
}
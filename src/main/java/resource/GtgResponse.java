package resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GtgResponse {

	public static final String OK = "ok";
	public static final String NOT_OK = "ok";
	
	private final String mode;
	private final String status;
		
	public GtgResponse (String mode, String status) {
		this.mode = mode;
		this.status = status;
	}
}
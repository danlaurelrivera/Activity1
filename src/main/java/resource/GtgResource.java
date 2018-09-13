package resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/_gtg")
public class GtgResource {
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public Response gtg() {
		final GtgResponse gtgResponse = new GtgResponse("local", GtgResponse.OK);
		return Response.ok(gtgResponse).status(Response.Status.OK).build();
	}

}

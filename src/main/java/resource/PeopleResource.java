package resource;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Path("/_people")
public class PeopleResource {	
	List<PeopleResponse> peopleList = new ArrayList<PeopleResponse>();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response postPeople (PeopleRequest request) {
		PeopleResponse peopleResponse = new PeopleResponse();
		String firstName = request.getFirstName();
		String lastName = request.getLastName();
		String birthDate = new SimpleDateFormat("MM-dd-yyyy").format(request.getBirthDate());	
				
		if (StringUtils.isEmpty(firstName) || StringUtils.isEmpty(lastName) || StringUtils.isEmpty(birthDate)) {
			return Response.status(Response.Status.BAD_REQUEST).entity(HttpServletResponse.SC_BAD_REQUEST).type( MediaType.TEXT_PLAIN).build();
		} else {
			peopleResponse.setFirstName(firstName);
			peopleResponse.setLastName(lastName);		
			peopleResponse.setBirthDate(birthDate);			
			peopleList.add(peopleResponse);			
			
			return Response.status(HttpServletResponse.SC_CREATED).entity(HttpServletResponse.SC_CREATED).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPeople () {
		return Response.ok().entity(peopleList).build();		
	}
}

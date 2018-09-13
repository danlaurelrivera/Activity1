package resource;

import java.io.Serializable;
import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class PeopleRequest implements Serializable{
	private String firstName;
	private String lastName;
	private Date birthDate;
}

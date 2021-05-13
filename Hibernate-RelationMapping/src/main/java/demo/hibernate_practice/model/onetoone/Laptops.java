package demo.hibernate_practice.model.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Laptops {
	@Id
	private int laptopId;
	private String laptopName;
}

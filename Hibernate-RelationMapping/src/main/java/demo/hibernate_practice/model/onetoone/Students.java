package demo.hibernate_practice.model.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Students {
	@Id
	private int studentRollNumber;
	private String studentName;
	private int marks;
	@OneToOne
	private Laptops laptops;
}

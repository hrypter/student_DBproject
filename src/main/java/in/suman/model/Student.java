package in.suman.model;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentId")
	@SequenceGenerator(name = "studentId_seq", sequenceName = "studentId_seq", allocationSize = 1)
	private long id;
	@Column(name="first_name",nullable=false)
   private String firstName;
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	@Column(name="last_name")
   private String lastName;
	@Column(name="email")
   private String email;
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}

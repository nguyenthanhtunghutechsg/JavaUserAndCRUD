package LTJava.S5.Ngay4.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	@Column(nullable = false,unique = true,length = 255)
	private String UserName;
	@Column(nullable = false,unique = true,length = 255)
	private String Email;
	@Column(nullable = false,length = 255)
	private String FirstName;
	@Column(nullable = false,length = 255)
	private String LastName;
	@Column(nullable = false,length = 64)
	private String Password;

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public User() {

	}

	public User(Integer id, String userName, String email, String firstName, String lastName) {
		super();
		Id = id;
		UserName = userName;
		Email = email;
		FirstName = firstName;
		LastName = lastName;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}
}

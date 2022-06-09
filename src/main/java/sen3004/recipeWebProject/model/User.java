package sen3004.recipeWebProject.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import sen3004.recipeWebProject.model.Recipe;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Size(min = 3, max = 50)
	@Column(name = "fname")
	private String firstName;

	@Size(min = 3, max = 50)
	@Column(name = "lname")
	private String lastName;
	
	@Size(min = 3, max = 50)
	@Column(name = "email")
	private String email;
	
	@Past
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	@Column(name = "dob")
	private LocalDate dateOfBirth;

	@OneToMany(mappedBy = "user")
	@OrderBy("id")
	private Set<Recipe> recipes = new HashSet<Recipe>();

	public String getFullName() {
		return String.format("%s %s", firstName, lastName);
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Set<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}
}

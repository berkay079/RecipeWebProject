package sen3004.recipeWebProject.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import sen3004.recipeWebProject.model.User;

@Entity
@Table(name = "food_recipes")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	@Size(min = 3, max = 2000)
	@Column(name = "ingredients")
	private String ingredients;

	
	@Size(min = 3, max = 50)
	@Column(name = "food")
	private String food;
	
	@Size(min = 3, max = 2000)
	@Column(name = "reciper")
	private String reciper;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	public Recipe() {
		
	}
	
	public Recipe(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getReciper() {
		return reciper;
	}

	public void setReciper(String reciper) {
		this.reciper = reciper;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}

package sen3004.recipeWebProject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sen3004.recipeWebProject.model.User;
import sen3004.recipeWebProject.model.Recipe;
import sen3004.recipeWebProject.dao.RecipeWebProjectUserRepository;
import sen3004.recipeWebProject.dao.RecipeWebProjectRecipeRepository;


@Service
@Transactional
public class RecipeWebProjectService {

	@Autowired
	RecipeWebProjectUserRepository userRepository;

	@Autowired
	RecipeWebProjectRecipeRepository recipeRepository;

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	public User findUserById(long id) {
		return userRepository.findById(id);
	}

	public void createUser(User user) {
		userRepository.create(user);
	}

	public void createRecipe(Recipe recipe) {

		recipeRepository.create(recipe);
	}

	public void deleteUser(long id) {
		recipeRepository.deleteByUserId(id);
		userRepository.delete(id);
	}

	public void deleteRecipe(long id) {
		recipeRepository.delete(id);
	}

}

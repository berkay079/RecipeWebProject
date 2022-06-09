package sen3004.recipeWebProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import sen3004.recipeWebProject.model.Recipe;

@Repository
public class RecipeWebProjectRecipeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Recipe> findAll() {
		return entityManager.createQuery("from Recipe", Recipe.class).getResultList();
	}

	public Recipe findById(long id) {
		return entityManager.find(Recipe.class, id);
	}

	public List<Recipe> findByUserId(long id) {
		return entityManager.createQuery("from Recipe where user.id = :id", Recipe.class).setParameter("id", id)
				.getResultList();
	}

	public void create(Recipe recipe) {
		entityManager.persist(recipe);
	}

	public void delete(long id) {
		entityManager.remove(entityManager.getReference(Recipe.class, id));
	}

	public void deleteByUserId(long id) {
		entityManager.createQuery("delete from Recipe where user.id = :id").setParameter("id", id).executeUpdate();

	}

}

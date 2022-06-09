package sen3004.recipeWebProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import sen3004.recipeWebProject.model.User;

@Repository
public class RecipeWebProjectUserRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public List<User> findAll() {
		return entityManager.createQuery("from User", User.class).getResultList();
	}

	public User findById(long id) {
		return entityManager.find(User.class, id);
	}

	public List<User> findByLastName(String lastName) {
		return entityManager.createQuery("from User where lastName = :last", User.class).setParameter("last", lastName).getResultList();
	}

	public void create(User user) {
		entityManager.persist(user);

	}

	public void delete(long id) {
		entityManager.remove(entityManager.getReference(User.class, id));

	}

	public void update(User user) {
		entityManager.merge(user);

	}

}

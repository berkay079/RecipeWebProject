package sen3004.recipeWebProject.controller;

	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;

	import sen3004.recipeWebProject.model.User;
	import sen3004.recipeWebProject.model.Recipe;
	import sen3004.recipeWebProject.service.RecipeWebProjectService;

	@Controller
	public class recipeWebProjectController {
		
		@Autowired
		RecipeWebProjectService service;

		@RequestMapping(value = { "/user/new", "new_user.html" }, method = RequestMethod.GET)
		public ModelAndView newUser() {
			ModelAndView mv = new ModelAndView("new-user");
			mv.addObject("user", new User());

			return mv;
		}

		@RequestMapping(value = "/user/add", method = RequestMethod.POST)
		public ModelAndView addUser(@Valid @ModelAttribute User user, BindingResult result) {
			ModelAndView mv = new ModelAndView();
			mv.addObject("user", user);

			if (result.hasErrors())
				mv.setViewName("new-user");
			else {
				mv.setViewName("user-list");
				service.createUser(user);
				mv.addObject("users", service.findAllUsers());
			}

			return mv;
		}

		@RequestMapping(value = { "/list-users", "list.html" }, method = RequestMethod.GET)
		public ModelAndView list() {
			ModelAndView mv = new ModelAndView("user-list");
			mv.addObject("users", service.findAllUsers());

			return mv;
		}

		@RequestMapping(value = { "/user/view/{id}", "/user/{id}" }, method = RequestMethod.GET)
		public ModelAndView viewuser(@PathVariable long id) {
			ModelAndView mv = new ModelAndView("view-user");
			User user = service.findUserById(id);
			mv.addObject("user", user);
			mv.addObject("recipe", new Recipe(user));

			return mv;
		}

		@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
		public ModelAndView deleteUser(@PathVariable long id) {
			ModelAndView mv = new ModelAndView("user-list");
			service.deleteUser(id);
			mv.addObject("users", service.findAllUsers());

			return mv;
		}

		@RequestMapping(value = "/user/recipe/add", method = RequestMethod.POST)
		public ModelAndView addRecipeToUser(@Valid @ModelAttribute Recipe recipe, BindingResult result) {
			ModelAndView mv = new ModelAndView("view-user");
			User user = service.findUserById(recipe.getUser().getId());
			
			if (result.hasErrors() == false) {
				service.createRecipe(recipe);
				mv.addObject("recipe", new Recipe(user));
			} 
			else {
				mv.addObject("recipe", recipe);
			}

			mv.addObject("user", user);

			return mv;
		}

		@RequestMapping(value = "/user/recipe/delete/{uid}/{rid}", method = RequestMethod.GET)
		public ModelAndView deleteRecipe(@PathVariable long uid, @PathVariable long rid) {
			ModelAndView mv = new ModelAndView("view-user");
			service.deleteRecipe(rid);
			User user = service.findUserById(uid);
			mv.addObject("user", user);
			mv.addObject("recipe", new Recipe(user));

			return mv;
		}


	}

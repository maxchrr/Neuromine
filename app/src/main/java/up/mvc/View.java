package up.mvc;

/**
 * Defines the interface for user interface components (Text or Graphical).
 * The View is responsible for displaying the Model's data and capturing user
 * inputs.
 */
public interface View {

	/**
	 * Updates the visual representation of the provided model.
	 * 
	 * @param model The current state of the application to be displayed.
	 */
	public void render(Model model);

	/**
	 * Makes the view visible to the user.
	 */
	public void show();

	/**
	 * Hides the view from the user.
	 */
	public void hide();
}

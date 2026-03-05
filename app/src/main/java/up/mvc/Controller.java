package up.mvc;

/**
 * The Mediator that coordinates communication between the Model and the View.
 * It intercepts actions from the View, queries the Model, and updates both
 * components.
 */
public abstract class Controller {

	protected final Model model;
	protected final View view;

	/**
	 * Constructs a Controller with its associated Model and View.
	 * 
	 * @param model The application logic component.
	 * @param view  The user interface component.
	 */
	protected Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Entry point for the View to signal a user action.
	 * Corresponds to the "signals an action" arrow in the design schema.
	 * 
	 * @param action The action performed by the user.
	 */
	public abstract void handleAction(Action action);

	/**
	 * Internal method to handle signals coming from the Model.
	 * Corresponds to the "signals a modification" arrow in the design schema.
	 * 
	 * @param signal The signal emitted by the model.
	 */
	protected abstract void handleSignal(Signal signal);

	/**
	 * Triggers a manual refresh of the View using the current Model state.
	 * Corresponds to the "modifies" arrow targeting the View.
	 */
	protected void updateView() {
		view.render(model);
	}

	/** @return The managed Model instance. */
	public Model getModel() {
		return model;
	}

	/** @return The managed View instance. */
	public View getView() {
		return view;
	}
}

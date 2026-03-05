package up.mvc;

/**
 * Represents the application state and business logic.
 * The Model is passive and responds to requests from the Controller.
 */
public interface Model {

	/**
	 * Processes a request triggered by an action and returns a signal
	 * describing the result of the operation.
	 * 
	 * @param action The action requested by the controller.
	 * @return A Signal representing the outcome or state change.
	 */
	public Signal processRequest(Action action);

	/**
	 * Starts the internal lifecycle or execution loop of the model if necessary.
	 */
	public void run();
}

package up.mvc;

public abstract class Controller<M extends Model, A extends Action, S extends Signal> {

	protected M model;
	protected View<M, A> view;

	public Controller(M model, View<M, A> view) {
		this.model = model;
		this.view = view;
	}

	/** 1. Action : La vue appelle cette méthode */
	public abstract void handleAction(A action);

	/** 2 & 3. Requête et Signal : Le contrôleur traite avec le modèle */
	protected abstract void handleSignal(S signal);

	/** 4. Modification : Le contrôleur met à jour la vue */
	protected void updateView() {
	view.render(model);
	}

}

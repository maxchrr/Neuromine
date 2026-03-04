package up.mvc;

public interface View<M extends Model, A extends Action> {

	void render(M model); // Mise à jour de l'affichage
	void setController(Controller<M, A, ?> controller);

}

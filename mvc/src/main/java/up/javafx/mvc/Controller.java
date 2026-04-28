package up.javafx.mvc;

public abstract class Controller<M extends Model, V extends View> {

    protected final M model;
    protected final V view;

    public Controller(M model, V view) {
        this.model = model;
        this.view = view;
        init();
    }

    protected abstract void init();

    public M getModel() { return model; }
    public V getView()  { return view;  }
}

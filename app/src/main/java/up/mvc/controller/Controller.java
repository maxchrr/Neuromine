package up.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import up.mvc.model.Model;
import up.mvc.view.View;

public abstract class Controller {
	protected final List<Controller> subControllers = new ArrayList<>();
	
	protected final Model model;
	protected final View view;
	
	protected Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	public Model getModel() {
		return model;
	}
	
	public View getView() {
		return view;
	}
}

package up.neuromine.controller;

import java.util.ArrayList;
import java.util.List;

import up.neuromine.model.BaseModel;
import up.neuromine.view.BaseView;

public abstract class BaseController {
	protected final List<BaseController> subControllers = new ArrayList<>();

	protected final BaseModel model;
	protected final BaseView view;

	protected BaseController(BaseModel model, BaseView view) {
		this.model = model;
		this.view = view;
	}

	public BaseModel getModel() {
		return this.model;
	}

	public BaseView getView() {
		return this.view;
	}
}

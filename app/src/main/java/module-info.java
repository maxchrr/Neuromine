module up.neuromine {
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	
	exports up.neuromine;
	exports up.neuromine.model;
	exports up.neuromine.view;
	exports up.neuromine.controller;
}
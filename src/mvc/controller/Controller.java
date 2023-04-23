package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.model.Person;
import mvc.view.Screen;

public class Controller {

	private Screen view;
	private ActionListener actionListener;
	
	public Controller(Screen view) {
		this.view = view;
	}
	
	public void control() {
		actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				//TODO
			}
		}
	}
	
	public void enterData() {
		
	}
	
	private void alterAge() {
		
	}
	
	private void clearFields() {
		
	}
	
	private Person getData() {
		return null;
	}
	
	private void insertData() {
		
	}
	
	private void listData() {
		
	}
	
	private void removeData() {
		
	}
}

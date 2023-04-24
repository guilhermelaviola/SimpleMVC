package com.java.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import com.java.mvc.model.Hobby;
import com.java.mvc.model.Person;
import com.java.mvc.view.Screen;

public class Controller {
	// Two attributes only: Screen and ActionListener
	private Screen view;
	private ActionListener actionListener;
	
	public Controller(Screen view) {
		this.view = view;
	}
	
	// Creating a control mechanism
	public void control() {
		actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				// Check if it's the 'Clear' button
				if (ev.getSource() == view.getBtnClear()) {
					clearFields();
				}else if (ev.getSource() == view.getBtnInput()) {
					enterData();
				}else if (ev.getSource() == view.getBtnAlter()) {
					alterAge();
				}else if (ev.getSource() == view.getBtnRemove()) {
					removeData();
				}else if (ev.getSource() == view.getBtnList()) {
					listData();
				}	
			}
		};
		view.getBtnClear().addActionListener(actionListener);
		view.getBtnInput().addActionListener(actionListener);
		view.getBtnInsert().addActionListener(actionListener);
		view.getBtnAlter().addActionListener(actionListener);
		view.getBtnRemove().addActionListener(actionListener);
		view.getBtnList().addActionListener(actionListener);
	}
	
	public void enterData() {
		try {
			String name = view.getTxtName().getText();
			String temp = view.getTxtAge().getText();
			int age = Integer.parseInt(temp);
			temp = view.getTxtHeight().getText();
			double height = Double.parseDouble(temp);
			temp = view.getTxtWeight().getText();
			double weight = Double.parseDouble(temp);
			String gender;
			if (view.getRadioFemale().isSelected()) {
				gender = "female";
			}else {
				gender = "male";
			}
			String from = "";
			from += (String) view.getComboState().getSelectedItem();
			Person person = new Person(name, age, height, weight, gender, from, null);
			String hobbies =  "";
			for (JCheckBox x : view.getHobby()) {
				if (x.isSelected()) {
					hobbies += x.getText();
					hobbies += " ";
				}
			}
			Hobby hobby = new Hobby(hobbies);
			person.setHobby(hobby);
			view.getExitArea().setText(person.toString());
		} catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(view, "Enter valid numbers for age, height and weight", "INVALID NUMBER", 0);
		}
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
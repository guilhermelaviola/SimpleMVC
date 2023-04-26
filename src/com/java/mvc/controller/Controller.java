package com.java.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import com.java.mvc.model.Hobby;
import com.java.mvc.model.Person;
import com.java.mvc.model.PersonDAO;
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
				}else if (ev.getSource() == view.getBtnInsert()) {
					insertData();
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
		try {
			String name = view.getTxtName().getText();
			int age = Integer.parseInt(view.getTxtAge().getText());
			PersonDAO personDAO1 = new PersonDAO();
			if (personDAO1.alterAge(name, age)) {
				JOptionPane.showMessageDialog(null, "Age changed sucessfully!");
			} else {
				JOptionPane.showMessageDialog(null, "Age not changed!", "ERROR", 0);
			}
		} catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(view, "Enter a valid age number", "INVALID NUMBER", 0);
		}
		listData();
	}
	
	private void clearFields() {
		view.getTxtName().setText("");
		view.getTxtAge().setText("");
		view.getTxtWeight().setText("");
		view.getTxtHeight().setText("");
		view.getBtnGender().clearSelection();
		view.getComboState().setSelectedIndex(0);
		for (JCheckBox x : view.getHobby()) {
			x.setSelected(false);
		}
		view.getExitArea().setText("");
	}
	
	private Person getData() {
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
				gender = "Female";
			} else {
				gender = "Male";
			}
			String from = (String) view.getComboState().getSelectedItem();
			Person person = new Person(name, age, height, weight, gender, from, null);
			return person;
		} catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(view, "Enter valid numbers for age, height and weight: " + error.getMessage(), "INVALID NUMBER", 0);
			return null;
		}
	}
	
	private void insertData() {
		Person person1 = getData();
		if (person1 != null) {
			PersonDAO personDAO1 = new PersonDAO();
			if (personDAO1.insertPerson(person1)) {
				JOptionPane.showMessageDialog(view, "The data was sucessfully inserted!");
			} else {
				JOptionPane.showMessageDialog(null, "Data not inserted", "ERROR", 0);
			}
			listData();
		}
	}
	
	private void listData() {
		PersonDAO personDAO1 = new PersonDAO();
		try {
			ResultSet rs = personDAO1.searchAllPeople();
			view.getExitArea().setText("");
			while (rs.next()) {
				String list = ("ID: " + rs.getInt("PERSONID") + "\tName: "
                        + rs.getString("NAME") + "\tAge: "
                        + rs.getInt("AGE") + "\tHeight: "
                        + rs.getDouble("HEIGHT") + "\tWeight: "
                        + rs.getDouble("WEIGHT") + "Gender: "
                        + rs.getString("GENDER") + "\tState: "
                        + rs.getString("STATE") + "\n");
				view.getExitArea().append(list);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(view, "It was not possible to list the data!", "ERROR", 0);
		}
	}
	
	private void removeData() {
		String name = view.getTxtName().getText();
		PersonDAO personDAO1 = new PersonDAO();
		if (personDAO1.removePerson(name)) {
			JOptionPane.showMessageDialog(view, "Data removed sucessfully!");
		} else {
			JOptionPane.showMessageDialog(view, "It was not possible to remove the data!", "ERROR", 0);
		}
		listData();
	}
}
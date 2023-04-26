package com.java.mvc;

import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import com.java.mvc.controller.Controller;
import com.java.mvc.view.Screen;

public class Main {
	public static void main(String[] args) {
		/* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) "> 
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel. 
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        */
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, e);
		} catch (InstantiationException e) {
			Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, e);
		} catch (IllegalAccessException e) {
			Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, e);
		} catch (UnsupportedLookAndFeelException e) {
			Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, e);
		}//</editor-fold>
        // Creating and displaying the form
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Screen view = new Screen();
				Controller controller = new Controller(view);
				controller.control();
				view.setVisible(true);
			}
		});
	}
}

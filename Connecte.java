package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Connecte implements Initializable {
	@FXML private TextField txtF;
	@FXML private PasswordField passF;
	@FXML private Label lbl;
	
	public void connect(ActionEvent event) throws SQLException  {
        Connection con= LoginController.login();
        PreparedStatement stat = null;
        ResultSet rs= null;
         String sql = "SELECT FROM users WHERE name=? AND password=?";
         try {
        	 stat= con.prepareStatement(sql);
 			stat.setString(1, txtF.getText().toString());
 			stat.setString(2, passF.getText().toString());
 			rs=stat.executeQuery();
 			if(rs.next()) {
 				lbl.setText("connecté");
 			}
 				else {
 					lbl.setText("pas correcte!");

 				}
		} catch (Exception e) {
		}


}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		 LoginController.login();
	}
}



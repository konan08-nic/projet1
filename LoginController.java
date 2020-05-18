package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class LoginController implements Initializable {
	
	@FXML
	
	public  Connection login()  {
		String url = "jdbc:mysql://localhost:3306/aibs ?use Timezoe=true&serverTimezone=UTC  ";
		String user="root";		
		String password="";
            try {
            	Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=DriverManager.getConnection(url, user, password);
				
				System.out.println("connecte");

				return conn;
                }
            catch (Exception e) {
            	e.printStackTrace();
				System.out.println("erreur");
				System.exit(0);

           }
			return null;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		login();
	}

}

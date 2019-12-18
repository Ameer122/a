package application;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.net.ssl.SSLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class SignUpController  {
	
	  @FXML
	    private TextField tf_username1;

	    @FXML
	    private TextField tf_email1;

	    @FXML
	    private PasswordField pf_password1;


    @FXML
    void login(MouseEvent event) {
try {
	Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
Node node = (Node)event.getSource();
Stage stage = (Stage)node.getScene().getWindow();
stage.setScene(new Scene(root));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
    }

    @FXML
    void signup1(ActionEvent event) throws SSLException, SQLException  {
DbConnect conne = new DbConnect();
Connection connection = conne.getConnection();

	
	

		String username = tf_username1.getText();
		String email = tf_email1.getText();
		String password = pf_password1.getText();
		String sql = "INSERT INTO users VALUES('"+username+"','"+email+"','"+password+"')";
		Statement stmt = connection.createStatement();
		System.out.println(username + " " + email + " " + password);
	
	
		
	//int status =	
		stmt.executeUpdate(sql);
	//if(status > 0)
	{
		System.out.println("user registered!");
	}
	//} catch (SQLException e) {
		// TODO Auto-generated catch block
	//	e.printStackTrace();
//	}
	
//} //catch (SSLException e1) {
	// TODO Auto-generated catch block
//	e1.printStackTrace();
//}
    
    //}*/
//}
	stmt.close();
	connection.close();
    }
}
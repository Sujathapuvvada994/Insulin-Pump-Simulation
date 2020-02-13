package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login {
	
	@FXML
	private Label status;
	
	@FXML
	private TextField username;
	
	@FXML
	private TextField password;
	
	@FXML
	private TextField doctorname;
	
	@FXML
	private TextField doctorpassword;
	
	@FXML Label doctorStatus;
	
	public void login(ActionEvent event) throws Exception 
	{
		if (username.getText().equalsIgnoreCase("John") && password.getText().equals("123")) 
		{
			//status.setText("Login Success!");
			Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			primaryStage.close();
			//Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Insulin Glucgon Pump");
			primaryStage.show();

		}
		else
		{
			status.setText("Invalid Credentials!!!");
		}
	}
	
	public void doctorLogin(ActionEvent event) throws Exception 
	{
		if(doctorname.getText().equalsIgnoreCase("Doctor") && doctorpassword.getText().equalsIgnoreCase("123")) 
		{
			MonitorController.isAutoMode = false;
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.close();
		}
		else {
			doctorStatus.setText("Login Failed!!!");
		}
	}
	
	public void cancelDoctorLogin(ActionEvent event) {
		MonitorController.isAutoMode = true;
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.close();
	}
	
	public void stop(ActionEvent event) throws Exception 
	{
		System.out.println("Application Terminated....");
		System.exit(0);
	}

}

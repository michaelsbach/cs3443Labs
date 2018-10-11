package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.House;
import application.model.School;
import application.model.Student;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class MainFXMLController implements EventHandler<ActionEvent> , Initializable {

	//call School class to load data needed to populate view
	// need class variables for names
	@FXML
	private Label school, h1, h2, h3, h4;
	@FXML
	private TextArea t1, t2, t3, t4;
	@FXML
	private Button save;
	
	@Override 
	public void initialize(URL arg0, ResourceBundle arg1) {
		School hog = new School("Hogwarts School of Witchcraft and Wizardry");
		hog = hog.load();
		school.setText(hog.getName());
		ArrayList<House> houses = hog.getHouses();
		
		House ho1 = houses.get(0);
		h1.setText(ho1.getName());
		ArrayList<Student> students1 = ho1.getStudents();
		for (Student currStudent : students1)
		{
			t1.setText(t1.getText() + currStudent.toString());
		}
		
		House ho2 = houses.get(1);
		h2.setText(ho2.getName());
		ArrayList<Student> students2 = ho2.getStudents();
		for (Student currStudent : students2)
		{
			t2.setText(t2.getText() + currStudent.toString());
		}
		House ho3 = houses.get(2);
		h3.setText(ho3.getName());
		ArrayList<Student> students3 = ho3.getStudents();
		for (Student currStudent : students3)
		{
			t3.setText(t3.getText() + currStudent.toString());
		}
		House ho4 = houses.get(3);
		h4.setText(ho4.getName());
		ArrayList<Student> students4 = ho4.getStudents();
		for (Student currStudent : students4)
		{
			t4.setText(t4.getText() + currStudent.toString());
		}

	}
	@Override
	public void handle(ActionEvent event) {
		System.out.println("ayy");
		//.save();
		
	}
}

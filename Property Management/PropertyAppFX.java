/*
 * Class: CMSC203 
 * Instructor: Grigority Grinberg
 * Description: This program is about managing properties
 * Due: 03/30/2026
 * Platform/compiler: Javadoc 21
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Abdullah Khan */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PropertyAppFX extends Application {
	private ManagementCompany mc = new ManagementCompany("Campus Reality", "123-45-6789");
	
	@Override
	public void start(Stage stage) {
		
		TextField nameField = new TextField();
		TextField cityField = new TextField();
		TextField rentField = new TextField();
		TextField ownerField = new TextField();
		
		TextArea outputArea = new TextArea();
		outputArea.setEditable(false);
		
		Button addButton = new Button ("Add Property");
		Button totalButton = new Button("Show Total Rent");
		Button showButton = new Button("Show All Properties");
		
		addButton.setOnAction(e->{
			try {
				String name = nameField.getText();
				String city = cityField.getText();
				double rent = Double.parseDouble(rentField.getText());
				String owner = ownerField.getText();
				
				Property p = new Property(name, city, rent, owner);
				int result = mc.addProperty(p);
				
				if (result == -1) {
					outputArea.setText("Cannot add more properties.");
				}else {
					outputArea.setText("Property added at index: " + result);
				}
				
			} catch (Exception ex) {
				outputArea.setText("Invalid input.");
			}
		});
		
		totalButton.setOnAction(e-> {
			outputArea.setText("Total Rent: " + mc.totalRent());
		});
		
		showButton.setOnAction(e-> {
			outputArea.setText(mc.toString());
		});
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		grid.add(new Label("Property Name:"), 0, 0);
		grid.add(nameField, 1, 0);
		
		grid.add(new Label("City:"), 0, 1);
		grid.add(cityField, 1, 1);
		
		grid.add(new Label("Rent:"), 0, 2);
		grid.add(rentField, 1, 2);
		
		grid.add(new Label("Owner:"), 0, 3);
		grid.add(ownerField, 1, 3);
		
		grid.add(addButton, 0, 4);
		grid.add(totalButton, 1, 4);
		grid.add(showButton, 2, 4);
		
		grid.add(outputArea, 0, 5, 3, 1);
		
		Scene scene = new Scene(grid, 500, 400);
		stage.setTitle("Property Management App");
		stage.setScene(scene);
		stage.show();
}
	public static void main(String[] args) {
		launch(args);
	}

}

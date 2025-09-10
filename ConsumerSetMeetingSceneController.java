/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelclass.Consumer;
import modelclass.Lawyer;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ConsumerSetMeetingSceneController implements Initializable {

    @FXML
    private ComboBox<String> meetingTypeComboBox;
    @FXML
    private DatePicker meetingDateDatePicker;
    @FXML
    private TextField meetingTimeTextField;
    @FXML
    private TextField meetingLocationTextField;
    @FXML
    private TextField meetingLinkTextField;
    @FXML
    private ComboBox<String> setByComboBox2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           meetingTypeComboBox.getItems().addAll("Offline Meeting", "Online Meeting");
           setByComboBox2.getItems().addAll("chairman", "Employee", "Lawyer", "Tariff officer","consumer" ,"Finance officer","District Manager","Government Authorities");
        // TODO
    }    

    @FXML
    private void saveButtonOnAction(ActionEvent event) throws IOException {
          Boolean addstatus= 
                Consumer.meetingset(
                       
                        meetingLocationTextField.getText(),
                        meetingLinkTextField.getText(),
                        meetingTypeComboBox.getValue(),
                        meetingTimeTextField.getText(),
                        setByComboBox2.getValue(),
                        meetingDateDatePicker.getValue()
                        
                   
                );
        if(addstatus){

            Alert a=new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Meeting are Added Sucussfully");
            a.showAndWait();
        }
        else{

            Alert a =new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error");
            a.showAndWait();
        
    }
    
        }
        

    

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("ConsumerHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
         window.setScene(scene2);
         window.show();
    }
    
}

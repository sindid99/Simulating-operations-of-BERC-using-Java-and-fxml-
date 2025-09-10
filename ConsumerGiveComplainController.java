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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelclass.Consumer;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ConsumerGiveComplainController implements Initializable {

    @FXML
    private ComboBox<String> combobox;
    @FXML
    private DatePicker datepicker;
    @FXML
    private TextArea textarea;
    @FXML
    private TextField NIDTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          combobox.getItems().addAll("Water", "Electricity", "Gas");
        // TODO
    }    

    @FXML
    private void backbutton(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("ConsumerHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
         window.setScene(scene2);
         window.show();
        
        
        
    }

    @FXML
    private void sendbutton(ActionEvent event) throws IOException {
          Boolean addstatus= 
                Consumer.givecomplain(
                      
                        combobox.getValue(),
                        datepicker.getValue(),
                        NIDTF.getText(),
                        textarea.getText()
                        

                );
        if(addstatus){

            Alert a=new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Your Complain is Sent For Selected Sector");
            a.showAndWait();
        }
        else{

            Alert a =new Alert(Alert.AlertType.ERROR);
            a.setContentText("Error");
            a.showAndWait();
        
    }
    
        }
    
    
    
}

    
    


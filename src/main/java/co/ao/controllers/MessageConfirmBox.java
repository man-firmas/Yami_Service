package co.ao.controllers;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;

/**
 *
 * @author Bernardo Tchi
 */
public class MessageConfirmBox extends Application {
int WIDTH = 450;
int HEIGHT = 190;
static Stage stage; 
public boolean btnYesClicked;
StackPane layout3;
public  boolean start(String titulo, String msg, String SbtnYes, String SbtnNao) {
   layout3 = new StackPane();
   Stage primaryStage = new Stage(); 
   //layout3.setStyle("-fx-background-color: #3793CC");  
   Scene sceneMsgBox = new Scene(layout3, WIDTH, HEIGHT);
    JFXDialogLayout messageDialo = new JFXDialogLayout();
   messageDialo.setHeading(new Text(titulo));
  //  FontAwesomeIcon icon = new FontAwesome(FontAwesomeIcon.WARNING);
   /* icon.setSize("24");
    icon.setFill(javafx.scene.paint.Paint.valueOf("#ffbb00"));
   messageDialo.setHeading(icon);
   messageDialo.setBody(new Text(msg));    
   JFXDialog msgDialog = new JFXDialog(layout3, messageDialo, JFXDialog.DialogTransition.CENTER); */
   
  if("".equals(SbtnNao)){
        JFXButton btnYes= new  JFXButton(SbtnYes);
       btnYes.setOnAction((ActionEvent e) -> {
       btnYes_Clicked();
       //msgDialog.close();
       layout3.setStyle("");
       primaryStage.close();
   });
  messageDialo.setActions(btnYes);
  //msgDialog.show();
  } else {   
   JFXButton btnNo= new JFXButton(SbtnNao);
     btnNo.setOnAction((ActionEvent e)-> {
     btnNo_Clicked();
       // msgDialog.close();
        layout3.setStyle("");    
        primaryStage.close();
     });
       JFXButton btnYes= new  JFXButton(SbtnYes);
        btnYes.setOnAction((ActionEvent e)-> {
        btnYes_Clicked();
        //msgDialog.close();
        layout3.setStyle("");
        primaryStage.close();
   });  
      messageDialo.setActions(btnNo, btnYes);
     // msgDialog.show();
  }
  primaryStage.initStyle(StageStyle.UNDECORATED);
  primaryStage.initModality(Modality.APPLICATION_MODAL);
  primaryStage.setScene(sceneMsgBox);
  primaryStage.centerOnScreen();
  primaryStage.showAndWait(); 
    return btnYesClicked;
    }

  @Override
  public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
private boolean btnYes_Clicked() 
{
btnYesClicked = true;
    return btnYesClicked;
}
private  boolean  btnNo_Clicked() 
{
btnYesClicked = false;
    return btnYesClicked;
}
}

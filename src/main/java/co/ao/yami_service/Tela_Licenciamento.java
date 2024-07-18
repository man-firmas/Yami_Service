package co.ao.yami_service;

import co.ao.controllers.Buscar_Hardware_ID;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 *
 * @author Man_firmas
 */
public class Tela_Licenciamento implements Initializable{
    
    @FXML
    private TextField TextField_HardwareCode,TextField_Licenca;
    @FXML
    private Button Btn_close, btn_copiar,btn_colar;
     Object userData;
    private  Buscar_Hardware_ID String_H = new Buscar_Hardware_ID();
     Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard() ;
     ClipboardOwner clipboardOwner ;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        chamar_TextField_HardwareId();     
    }
    
     @FXML
    private void handleclose(ActionEvent event) { 
      if(event.getSource()== Btn_close){ 
       Launch_Service.ChengeScreen("tela_Login");
       Tela_LoginController.stage_registar.close();
     }
  }
    
@FXML
private void funcaoCopiar (ActionEvent event){
    // Implement Copy operation  
    StringSelection contents = new StringSelection(TextField_HardwareCode.getText());
    clipboard.setContents(contents, clipboardOwner);
        FlavorListener lis = (FlavorEvent e) -> {
            System.out.println(e);
        };
    clipboard.addFlavorListener(lis);
    clipboard.removeFlavorListener(lis);       
}

@FXML
private void funcaoColar (ActionEvent event){
    // Implement Paste operation
    Transferable content = clipboard.getContents(this);
    String dstData;
    try {
    dstData = (String) content.getTransferData(DataFlavor.stringFlavor);
    TextField_Licenca.setText(dstData);
    } catch (UnsupportedFlavorException | IOException e) {
    }
}
 @FXML
private void chamar_TextField_HardwareId() {
     try {
    String_H = new Buscar_Hardware_ID();
    String numeroHD = Buscar_Hardware_ID.getSerialNumber();
    TextField_HardwareCode.setText(numeroHD);
     } catch (Exception e) {
         System.out.println(e);
   }
}

}

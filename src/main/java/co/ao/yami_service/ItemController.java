/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ao.yami_service;

import co.ao.controllers.MyListner;
import co.ao.controllers.ListaOrdemServico;
import javafx.scene.control.CheckBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 *
 * @author Man_firmas
 */
public class ItemController implements  Initializable{

    @FXML
    private HBox Hbox_tab_ordemServ;
    @FXML
    private Pane painelPgmt;
    @FXML
    public CheckBox Checkbox;
    @FXML
    private TextField TextField_qnt;
    @FXML
    private TextField TextField_DescricaoItem;
    @FXML
    private TextField textField_Serie;
    @FXML
    private TextField TextField_precoUnit;
    @FXML
    private TextField TextField_Montante;
    private ListaOrdemServico listarOrdem = new ListaOrdemServico();
   private MyListner myListner;  
   float montante;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   //  setData(listarOrdem, myListner );
  //  montante = listarOrdem.getPreco_unit();
    }
    
   public void setData(ListaOrdemServico listarOrdem, MyListner myListner){
   this.listarOrdem = listarOrdem;
   this.myListner = myListner;

   TextField_qnt.setText(String.valueOf(listarOrdem.getQnt_item()));
   TextField_DescricaoItem.setText(listarOrdem.getDescricao_item());
   textField_Serie.setText(listarOrdem.getSerie_produto());
   TextField_precoUnit.setText(String.valueOf(listarOrdem.getPreco_unit()+Launch_Service.CURRENCY ));
   TextField_Montante.setText(String.valueOf(listarOrdem.getMontante_listaOrdem()+Launch_Service.CURRENCY));
   Checkbox.setId(String.valueOf(listarOrdem.getCod_ListaOrdemServic()));
  if(listarOrdem.isItemPago()==1){
    painelPgmt.setStyle("-fx-background-color: #2555AD"); 
   //   fontAwesame_1 .setGlyphName("HAND_PEACE_ALT");
      Checkbox.setIndeterminate(true);
      Checkbox.setDisable(true);
  }else{
    painelPgmt.setStyle("-fx-background-color: #DA787A"); 
   // fontAwesame_1 .setGlyphName("HAND_STOP_ALT");
    montante = listarOrdem.getPreco_unit();
   }  
 }
 

  
@FXML   
 public void  Metd_mont (ActionEvent event){
   boolean chkeckboxResult = Checkbox.isSelected();
   myListner.onClickListner(listarOrdem, chkeckboxResult);
   
 }
}
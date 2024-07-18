/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ao.yami_service;

import co.ao.bd.Mysql;
import co.ao.controllers.Clientes;
import co.ao.controllers.Usuario;
import com.jfoenix.controls.JFXButton;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author Man_firmas
 */
public class Controller_SetCliente implements Initializable {
    @FXML
    private TableView<Clientes> Tabela_setCliente;
    @FXML
    private TextField TextFild_Cod_cliente,TextFild_Descric_cliente;
    @FXML
    private JFXButton Btn_carregar_cliente;
    private final Usuario  user = new Usuario();
    Clientes setCliente = new Clientes();
     private final Configuracoes conf_pos = new Configuracoes();
    String UsuarioLocal ;
     Alert alert = new Alert(Alert.AlertType.NONE);
// Variaveis em java para logar com a base de dado.----------------------
 private final Mysql BD_conect = new Mysql();   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    // TODO
    lerConfig2();
    setCliente.setColuna(Tabela_setCliente);    
    carregar_tabelaClien(); 
    }    
public ObservableList<Clientes> loadDataClien() throws ClassNotFoundException, SQLException {
Mysql.getConnection();
ObservableList<Clientes> data =
FXCollections.observableArrayList();     
   String  SQL1 = "SELECT  cod_cliente,  nome_cliente, perso_juridica_tab.nome_perso_juridica,  email_cliente, endereco_cliente, contacto1_cliente, contacto2_cliente, credito_cliente, debito_cliente,  "
               + " descricao_cliente, nif_cliente, imagem_cliente, status_cliente FROM clientes_tab, perso_juridica_tab WHERE perso_juridica_tab.cod_perso_juridica = clientes_tab.perso_juridica";
   BD_conect.executaSQL(SQL1);        
    try {
    while(BD_conect.resultset.next()){
        data.add(new Clientes(BD_conect.resultset.getInt(1), BD_conect.resultset.getString(2), BD_conect.resultset.getString(3), BD_conect.resultset.getString(4), BD_conect.resultset.getString(5), 
        BD_conect.resultset.getInt(6), BD_conect.resultset.getInt(7), BD_conect.resultset.getFloat(8), BD_conect.resultset.getFloat(9), 
        BD_conect.resultset.getString(10), BD_conect.resultset.getString(11), BD_conect.resultset.getString(12), BD_conect.resultset.getBoolean(13)));
    }
    } catch (SQLException ex) {
       Logger.getLogger(Tela_LoginController.class.getName()).log(Level.SEVERE, null, ex);
    }
return data; 
}
 // Permite carregar e recarregar a tabela setCliente   
public void carregar_tabelaClien(){
    try {
    Tabela_setCliente.setItems(loadDataClien());  
        } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(Controller_SetCliente.class.getName()).log(Level.SEVERE, null, ex);
    }
 }  
@FXML   //Método que permite preencher componentes  do cadastro de produtos.
private void ler_TabelaSetCliente(MouseEvent event){     
    try {
   setCliente = (Clientes) Tabela_setCliente.getSelectionModel().getSelectedItem();
   TextFild_Cod_cliente.setText(String.valueOf(setCliente.getCod_Cliente()));
   TextFild_Descric_cliente.setText(String.valueOf(setCliente.getNome_Cliente()));
    } catch (NullPointerException e) {
  }
}
@FXML //Método que permite preencher os componentes do estoque e a variavel prod. para eviar no POS.
private void Medt_CarregarSetCliente(MouseEvent event) {      
if(event.getSource()==Btn_carregar_cliente){
    if(!"".equals(TextFild_Descric_cliente.getText())){ 
 setCliente = (Clientes) Tabela_setCliente.getSelectionModel().getSelectedItem(); 
    Launch_Service.ChengeScreen("tela_Principal", user, setCliente, null, null);
    Tela_principalController.stage_TelaCliente.close();
 } else {
   Clientes clientDiverso = new Clientes();  
   Launch_Service.ChengeScreen("tela_Principal", user,clientDiverso, null,null);
   Tela_principalController.stage_TelaCliente.close();
    }
  }}   

@FXML   //Método que permite preencher componentes  do cadastro de produtos.
private void Medt_CarregarSetCliente2(KeyEvent event) {      
if(event.getCode()==KeyCode.ENTER ||event.getCode()==KeyCode.SPACE ){
  if(!"".equals(TextFild_Cod_cliente.getText())){
    if(!"".equals(TextFild_Descric_cliente.getText())){ 
    setCliente = (Clientes) Tabela_setCliente.getSelectionModel().getSelectedItem(); 
    Launch_Service.ChengeScreen("tela_Principal", user, setCliente,null,null);
    Tela_principalController.stage_TelaCliente.close();
  } else {
        Clientes clientDiverso = new Clientes();
     Launch_Service.ChengeScreen("tela_Principal", user,clientDiverso, null,null);
     Tela_principalController.stage_TelaCliente.close();    
    }
  }
}} 
private void lerConfig2(){    
   //      System.out.println("Resuldado do Objet usuario na tela setCliente_1 = " +user.toString());
     try {
        FileInputStream arquivo = new FileInputStream("src/co/ao/ficheiros/config.dat");
        ObjectInputStream obj_dados = new ObjectInputStream(arquivo);
        Configuracoes obj_leitura = (Configuracoes) obj_dados.readObject();    
        user.setCod_user(1);
        user.setNome_user(obj_leitura.nome_user);
        user.setUser_ID(obj_leitura.user_ID);
        user.setImagem_user(obj_leitura.imagema_user);
        user.setPrioridade(obj_leitura.prioridade_user);
     //   System.out.println("Resuldado do Objet usuario na tela setCliente_2 = " +user.toString());
        } catch (FileNotFoundException e) {
       alert.setAlertType(Alert.AlertType.ERROR);
         alert.setContentText(e.getMessage());
         alert.show();
        } catch (IOException | ClassNotFoundException ex) {
 //             System.out.println("Resuldado do catch suario na tela setCliente = " +ex.getMessage());
     }    
       
    } 
  
}

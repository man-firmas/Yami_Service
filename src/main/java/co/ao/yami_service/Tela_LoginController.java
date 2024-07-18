/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ao.yami_service;

import co.ao.bd.Mysql;
import co.ao.controllers.Clientes;
import co.ao.controllers.EncriptorAndDecriptor_Class;
import co.ao.controllers.Usuario;
import static co.ao.yami_service.Launch_Service.Primary_stage;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/**
 *
 * @author Man_firmas
 */
public class Tela_LoginController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private AnchorPane parent_login;
    private String texto_senha;
    Connection conect; 
    // Variaveis em java para logar com a base de dado.----------------------
    private final Mysql BD_conect = new Mysql();   
    private final Usuario user = new Usuario();
    private double xoffSet =0;
    private double yoffSet = 0; 
    @FXML
    private TextField textField_user;
    @FXML
    private PasswordField textField_senha;
    @FXML
    private AnchorPane painel_users, painel_keyboard;
     @FXML
    private Button btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_Ok,btn_Del,btn_A,btn_B,btn_C,btn_D,btn_E,btn_F
             ,btn_G,btn_H,btn_I,btn_J,btn_K,btn_L,btn_N,btn_M,btn_O,btn_P,btn_Q,btn_R,btn_S,btn_T,btn_U,btn_V,btn_X,btn_Z, Btn_registoProd;

    @FXML
    private HBox top;
    @FXML
    private HBox Hbox_image1,Hbox_image2,Hbox_image3,Hbox_image4,Hbox_image5,Hbox_image6,Hbox_image7,Hbox_image8;
    @FXML
    private ImageView image_view1,image_view2,image_view3,image_view4,image_view5,image_view6,image_view7,image_view8;
    @FXML
    public Label user_label_name_1,user_label_name_2,user_label_name_3, user_label_name_4,user_label_name_5,
            user_label_name_6,user_label_name_7,user_label_name_8;

    int orden_1=1;int orden_2=2;int orden_3=3; int orden_4=4; int orden_5=5;int orden_6=6;int orden_7=7;int orden_8=8;int O_escolhido=0; 
    private final Configuracoes conf = new Configuracoes();
    Alert alert = new Alert(Alert.AlertType.NONE); 
 private File fis1 = new File("src/imagens/User_1.png");
 private File fis2 = new File("src/imagens/User_1.png");
 private File fis3 = new File("src/imagens/User_1.png");
 private File fis4 = new File("src/imagens/User_1.png");
 private File fis5 = new File("src/imagens/User_1.png");
 private File fis6 = new File("src/imagens/User_1.png");
 private File fis7 = new File("src/imagens/User_1.png");
 private File fis8 = new File("src/imagens/User_1.png");
 private javafx.scene.image.Image icon1 , icon2, icon3, icon4, icon5,icon6,icon7,icon8;
 int ordensUser =7;
 String userLbaName ;
@FXML
public Scene Scene_regista;   
@FXML
public static Stage stage_registar= null; 


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       //  textField_user.requestFocus();
        setVisible_painelUser();
         try {
           ConsultarDeLogin();
       } catch (ClassNotFoundException | SQLException | IOException ex) {
           Logger.getLogger(Tela_LoginController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }    
    @FXML
 private void makeStageDragable(){
   parent_login.setOnMousePressed((event)->{
       xoffSet= event.getSceneX();
       yoffSet= event.getSceneY(); 
   });

    parent_login.setOnMouseDragged((event)->{  
    Launch_Service.Primary_stage.setX(event.getScreenX()- xoffSet);
    Launch_Service.Primary_stage.setY(event.getScreenY()- yoffSet);
    });
     parent_login.setOnDragDone((event) -> {
       Launch_Service.Primary_stage.setOpacity(1.0f);
   });
      parent_login.setOnMouseReleased((event)->{
      Launch_Service.Primary_stage.setOpacity(1.0f);
      }); 
   
   parent_login.setOnDragDone((event) -> {
      Launch_Service.Primary_stage.setOpacity(1.0f);
   });
   parent_login.setOnMouseReleased((event) -> {
       Launch_Service.Primary_stage.setOpacity(1.0f);
   });
   } 
       @FXML
    private void handleclose(MouseEvent event) { 
       System.exit(0);
    }
      @FXML
    private void handleRegisto(ActionEvent event) throws IOException { 
      if(event.getSource()== Btn_registoProd){
      Launch_Service.ChengeScreen("tela_Login_1");
    Parent tela_setRegisto= FXMLLoader.load(getClass().getResource("/co/ao/telas/Tela_Licenciamento.fxml"));                   
    Scene_regista = new Scene(tela_setRegisto);
    stage_registar= new Stage();
    stage_registar.initStyle(StageStyle.UNDECORATED);
    stage_registar.initModality(Modality.APPLICATION_MODAL);
    stage_registar.setScene(Scene_regista);
    stage_registar.showAndWait(); 
     }
    }
    @FXML
    private void minimize_stage(MouseEvent event) { 
      
      Launch_Service.Primary_stage = (Stage)parent_login.getScene().getWindow();
    //Launch_Service.Primary_stage = (Stage)((Button)event.getSource()).getScene().getWindow();
    
     Launch_Service.Primary_stage.setIconified(true);
    }
  private void UpdateOrderLogin(String userId ,int ordenador) throws SQLException, ClassNotFoundException {  
    try {
   Mysql.getConnection();
   conect = Mysql.getConnection();
   String query ="UPDATE usuario_tab SET ordenadorDeLogin =? WHERE user_ID=? ORDER BY ordenadorDeLogin DESC ";
   PreparedStatement ps = conect.prepareStatement(query);
        ps.setInt(1,ordenador);  
        ps.setString(2,userId);  
        int n = ps.executeUpdate();     
    } catch ( NullPointerException | SQLException ex) {
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setContentText(ex.getMessage());
        alert.show();
  }    
  }
  //
    private void AbrirTelaLicenca() throws SQLException, ClassNotFoundException {  
  
       Launch_Service.ChengeScreen("tela_Licenca", user, null,null,null);
  }
  
   //---------------------- Método que consulta a posição do usuario e ensire a imagens  
  @FXML
   @SuppressWarnings("UseSpecificCatch")
    public void ConsultarDeLogin() throws ClassNotFoundException, SQLException, IOException {     
try{ 
    leitura_settings();
    Mysql.getConnection();
   
    BD_conect.executaSQL("SELECT imagem_usuario, user_ID, ordenadorDeLogin FROM usuario_tab WHERE ordenadorDeLogin = 1");  
    while(BD_conect.resultset.next()){
      user.setImagem_user(BD_conect.resultset.getString(1));
     
       if(user.getImagem_user()!=null){    
    fis1 =  new File("src/co/ao/foto_src/"+ user.getImagem_user()); 
    image_view1.setImage(user.setFoto2(icon1,fis1)); 
  //  Circle_1.se;
            }  else{
    image_view1.setImage(user.reset_foto(icon1)); 
      }  
 user_label_name_1.setText( BD_conect.resultset.getString(2) );
   userLbaName =   BD_conect.resultset.getString(2) ;
    }
     BD_conect.executaSQL("SELECT imagem_usuario, user_ID, ordenadorDeLogin  FROM usuario_tab WHERE ordenadorDeLogin = 2");  
    while(BD_conect.resultset.next()){
      user.setImagem_user(BD_conect.resultset.getString(1));
       if(user.getImagem_user()!=null){    
    fis2 =  new File("src/co/ao/foto_src/"+ user.getImagem_user()); 
    image_view2.setImage(user.setFoto2(icon2,fis2));      
            }  else{
    image_view2.setImage(user.reset_foto(icon2)); 
      }  
    user_label_name_2.setText(BD_conect.resultset.getString(2));
    }
     BD_conect.executaSQL("SELECT imagem_usuario, user_ID,ordenadorDeLogin FROM usuario_tab WHERE ordenadorDeLogin =3");  
    while(BD_conect.resultset.next()){
      user.setImagem_user(BD_conect.resultset.getString(1));
       if(user.getImagem_user()!=null){    
    fis3 =  new File("src/co/ao/foto_src/"+ user.getImagem_user()); 
    image_view3.setImage(user.setFoto2(icon3,fis3));      
            }  else{
    image_view3.setImage(user.reset_foto(icon3)); 
      }  
    user_label_name_3.setText(BD_conect.resultset.getString(2));
    }   
  BD_conect.executaSQL("SELECT imagem_usuario, user_ID,ordenadorDeLogin FROM usuario_tab WHERE ordenadorDeLogin =4");  
    while(BD_conect.resultset.next()){
      user.setImagem_user(BD_conect.resultset.getString(1));
       if(user.getImagem_user()!=null){    
    fis4 =  new File("src/co/ao/foto_src/"+ user.getImagem_user()); 
    image_view4.setImage(user.setFoto2(icon4,fis4));      
            }  else{
    image_view4.setImage(user.reset_foto(icon4)); 
      }  
    user_label_name_4.setText(BD_conect.resultset.getString(2));
    }
     BD_conect.executaSQL("SELECT imagem_usuario, user_ID,ordenadorDeLogin FROM usuario_tab WHERE ordenadorDeLogin =5");  
    while(BD_conect.resultset.next()){
      user.setImagem_user(BD_conect.resultset.getString(1));
       if(user.getImagem_user()!=null){    
    fis5 =  new File("src/co/ao/foto_src/"+ user.getImagem_user()); 
    image_view5.setImage(user.setFoto2(icon5,fis5));      
            }  else{
    image_view5.setImage(user.reset_foto(icon5)); 
      }  
    user_label_name_5.setText(BD_conect.resultset.getString(2));
    }
     BD_conect.executaSQL("SELECT imagem_usuario, user_ID,ordenadorDeLogin FROM usuario_tab WHERE ordenadorDeLogin =6");  
    while(BD_conect.resultset.next()){
      user.setImagem_user(BD_conect.resultset.getString(1));
       if(user.getImagem_user()!=null){    
    fis6 =  new File("src/co/ao/foto_src/"+ user.getImagem_user()); 
    image_view6.setImage(user.setFoto2(icon6,fis6));      
            }  else{
    image_view6.setImage(user.reset_foto(icon6)); 
      }  
    user_label_name_6.setText(BD_conect.resultset.getString(2));
    }
     BD_conect.executaSQL("SELECT imagem_usuario, user_ID,ordenadorDeLogin FROM usuario_tab WHERE ordenadorDeLogin =7");  
    while(BD_conect.resultset.next()){
      user.setImagem_user(BD_conect.resultset.getString(1));
       if(user.getImagem_user()!=null){    
    fis7 =  new File("src/co/ao/foto_src/"+ user.getImagem_user()); 
    image_view7.setImage(user.setFoto2(icon7,fis7));      
            }  else{
    image_view7.setImage(user.reset_foto(icon7)); 
      }  
    user_label_name_7.setText(BD_conect.resultset.getString(2));
    }
     BD_conect.executaSQL("SELECT imagem_usuario, user_ID,ordenadorDeLogin FROM usuario_tab WHERE ordenadorDeLogin =8");  
    while(BD_conect.resultset.next()){
      user.setImagem_user(BD_conect.resultset.getString(1));
       if(user.getImagem_user()!=null){    
    fis8 =  new File("src/co/ao/foto_src/"+ user.getImagem_user()); 
    image_view8.setImage(user.setFoto2(icon8,fis8));      
        }  else{
    image_view8.setImage(user.reset_foto(icon8)); 
     }  
    user_label_name_8.setText(BD_conect.resultset.getString(2));
     }
   } catch ( NullPointerException | SQLException ex) {
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setContentText(ex.getMessage());
        alert.show();
      }
  }
    
    // ---------- Método que ordena os ultimos usuário na princípio da fila ------------
     @SuppressWarnings({"UnusedAssignment", "SillyAssignment"})
 private int OrdenadorDeLogin(int OndeEstouAgora, int OEscolhido) throws ClassNotFoundException, SQLException, IOException { 
   try {       
    switch(OEscolhido){
        case 1:  // O case representa a posição dos user's na grelha                  
       if(OEscolhido == OndeEstouAgora){
          OndeEstouAgora = 1; return OndeEstouAgora; }
       if(OEscolhido > OndeEstouAgora ){
         OndeEstouAgora = OndeEstouAgora; return OndeEstouAgora; }      
        
       case 2:   
       if(OEscolhido == OndeEstouAgora){
         OndeEstouAgora = OndeEstouAgora - 1; return OndeEstouAgora; } 
       if(OEscolhido > OndeEstouAgora){
         OndeEstouAgora = OndeEstouAgora +1; return OndeEstouAgora; }  
       if(OEscolhido < OndeEstouAgora ){
         OndeEstouAgora = OndeEstouAgora ; return OndeEstouAgora; }
   
       case 3:       
       if(OEscolhido == OndeEstouAgora){
          OndeEstouAgora = OndeEstouAgora -2; return OndeEstouAgora;}
       if(OEscolhido > OndeEstouAgora){
         OndeEstouAgora = OndeEstouAgora +1; return OndeEstouAgora;}  
          if(OEscolhido < OndeEstouAgora ){
         OndeEstouAgora = OndeEstouAgora; return OndeEstouAgora;} 
  
       case 4:          
       if(OEscolhido == OndeEstouAgora){
          OndeEstouAgora = OndeEstouAgora -3; return OndeEstouAgora;}
       if(OEscolhido > OndeEstouAgora ){
         OndeEstouAgora = OndeEstouAgora +1;  return OndeEstouAgora;}  
       if(OEscolhido < OndeEstouAgora ){
         OndeEstouAgora = OndeEstouAgora ;
          return OndeEstouAgora; }     

        case 5:        
       if(OEscolhido == OndeEstouAgora){
          OndeEstouAgora = OndeEstouAgora -4;return OndeEstouAgora;}
       if(OEscolhido > OndeEstouAgora ){
         OndeEstouAgora = OndeEstouAgora + 1; return OndeEstouAgora;}  
        if(OEscolhido < OndeEstouAgora ){
         OndeEstouAgora = OndeEstouAgora ; return OndeEstouAgora;}  
       case 6:        
       if(OEscolhido == OndeEstouAgora){
          OndeEstouAgora = OndeEstouAgora -5;return OndeEstouAgora;}
       if(OEscolhido > OndeEstouAgora ){
         OndeEstouAgora = OndeEstouAgora + 1; return OndeEstouAgora;}  
       if(OEscolhido < OndeEstouAgora ){
         OndeEstouAgora = OndeEstouAgora ; return OndeEstouAgora;}  
          
         case 7:        
       if(OEscolhido == OndeEstouAgora){
          OndeEstouAgora = OndeEstouAgora -6;return OndeEstouAgora;}
       if(OEscolhido > OndeEstouAgora ){
         OndeEstouAgora = OndeEstouAgora + 1; return OndeEstouAgora;}  
       if(OEscolhido < OndeEstouAgora ){
         OndeEstouAgora = OndeEstouAgora ; return OndeEstouAgora;}   
  
       case 8:        
       if(OEscolhido == OndeEstouAgora){
          OndeEstouAgora = OndeEstouAgora -7;return OndeEstouAgora;}
       if(OEscolhido > OndeEstouAgora ){
         OndeEstouAgora = OndeEstouAgora + 1; return OndeEstouAgora;}  
      
    }
     } catch (NullPointerException e) {
       // Codigo se a variavel views escolhida for 0 
            }
  return 0; 
    }
  
 //---------------- Consutador de Ordenador na base de Dado -----------------
 @FXML
 @SuppressWarnings("UseSpecificCatch")
 private int ConsultarBD_Ordenador(String userID) throws ClassNotFoundException, SQLException, IOException {     
try{ 
    Mysql.getConnection();
    BD_conect.executaSQL("SELECT ordenadorDeLogin FROM usuario_tab WHERE user_ID= '"+userID+"' ");  
 
    while(BD_conect.resultset.next()){
  ordensUser = BD_conect.resultset.getInt(1);
    }       
   } catch ( NullPointerException | SQLException ex) {
          alert.setAlertType(Alert.AlertType.ERROR);
          alert.setContentText(ex.getMessage());
          alert.show();
            }
   return ordensUser;
    }
    
    //----------------- Método que consulte a a senha da base de Dado -----------------
 @FXML
 private void handle_Login(MouseEvent event) throws IOException, SQLException, ClassNotFoundException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {       
    if (textField_user.getText().equals("")|| textField_senha.getText().equals("")){        
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Por Favor, Insira suas Credenciais !!! ");
            alert.show();
        } else{
            // condigo que nos permitira aceder o bd e permitir o login
    try {   
      EncriptorAndDecriptor_Class encriptar = new EncriptorAndDecriptor_Class();
      @SuppressWarnings("static-access")
      String AESencript = encriptar.AESencript(textField_senha.getText(), "user_ID");
    BD_conect.executaSQL("SELECT * FROM usuario_tab WHERE user_ID= '"+ textField_user.getText() +"' AND  senha_pin_usuario='"+ AESencript +"'");
    BD_conect.resultset.next();
      if(textField_user.getText().equals(BD_conect.resultset.getString("user_ID"))&& AESencript.equals(BD_conect.resultset.getString("senha_pin_usuario"))){            
     user.setCod_user(BD_conect.resultset.getInt("cod_usuario"));
     user.setNome_user(BD_conect.resultset.getString("nome_usuario"));
     user.setUser_ID(BD_conect.resultset.getString("user_ID"));
     user.setEmail_user(BD_conect.resultset.getString("email_usuario"));
     user.setPrioridade(BD_conect.resultset.getString("prioridade_usuario")); 
     user.setLocal_a_Operar(BD_conect.resultset.getString("local_a_operar")); 
     user.setFuncao(BD_conect.resultset.getString("cod_funcao")); 
     user.setStatus(BD_conect.resultset.getBoolean("status_usuario"));
     user.setPrioridade(BD_conect.resultset.getString("prioridade_usuario")); 
     user.setOrdenadorDeLogin(BD_conect.resultset.getInt("ordenadorDeLogin"));
     user.setImagem_user(BD_conect.resultset.getString("imagem_usuario"));
  
    // Codigo se por ventura digitarmos um usuário que já tenha um ordenador
  if(O_escolhido == 0 && user.getOrdenadorDeLogin() != 0){
          
    ConsultarBD_Ordenador(user.getUser_ID());
    UpdateOrderLogin(user.getUser_ID(), OrdenadorDeLogin(orden_1, ordensUser));
    UpdateOrderLogin(user_label_name_1.getText(), OrdenadorDeLogin(orden_1, ordensUser));
    UpdateOrderLogin(user_label_name_2.getText(),OrdenadorDeLogin(orden_2, ordensUser));
    UpdateOrderLogin(user_label_name_3.getText(), OrdenadorDeLogin(orden_3, ordensUser));
    UpdateOrderLogin(user_label_name_4.getText(),OrdenadorDeLogin(orden_4, ordensUser));
    UpdateOrderLogin(user_label_name_5.getText(), OrdenadorDeLogin(orden_5,ordensUser));     
    UpdateOrderLogin(user_label_name_6.getText(), OrdenadorDeLogin(orden_6,ordensUser));     
    UpdateOrderLogin(user_label_name_7.getText(), OrdenadorDeLogin(orden_7,ordensUser));        
    UpdateOrderLogin(user_label_name_8.getText(), OrdenadorDeLogin(orden_8,ordensUser));         
   
  }else{// Codigo se caso o usuário a digitar ainda não tem um ordenador  
   if(O_escolhido == 0 && user.getOrdenadorDeLogin()==0){
      UpdateOrderLogin(user.getUser_ID(), 1);
      UpdateOrderLogin(user_label_name_1.getText(), OrdenadorDeLogin(orden_1, 8));
      UpdateOrderLogin(user_label_name_2.getText(),OrdenadorDeLogin(orden_2, 8));
      UpdateOrderLogin(user_label_name_3.getText(), OrdenadorDeLogin(orden_3, 8));
      UpdateOrderLogin(user_label_name_4.getText(),OrdenadorDeLogin(orden_4, 8));
      UpdateOrderLogin(user_label_name_5.getText(), OrdenadorDeLogin(orden_5, 8));  
      UpdateOrderLogin(user_label_name_6.getText(), OrdenadorDeLogin(orden_6, 8));
      UpdateOrderLogin(user_label_name_7.getText(), OrdenadorDeLogin(orden_7, 8));
      UpdateOrderLogin(user_label_name_8.getText(), OrdenadorDeLogin(orden_8, 8));
         
   }else{
// Codigo se por ventura seleccionarmos um usuário na lista de user.
   UpdateOrderLogin(user.getUser_ID(), OrdenadorDeLogin(orden_1, O_escolhido));
        UpdateOrderLogin(user_label_name_1.getText(), OrdenadorDeLogin(orden_1, O_escolhido));
        UpdateOrderLogin(user_label_name_2.getText(),OrdenadorDeLogin(orden_2, O_escolhido));
        UpdateOrderLogin(user_label_name_3.getText(), OrdenadorDeLogin(orden_3, O_escolhido));
        UpdateOrderLogin(user_label_name_4.getText(),OrdenadorDeLogin(orden_4, O_escolhido));
        UpdateOrderLogin(user_label_name_5.getText(), OrdenadorDeLogin(orden_5, O_escolhido));
        UpdateOrderLogin(user_label_name_6.getText(), OrdenadorDeLogin(orden_6, O_escolhido));
        UpdateOrderLogin(user_label_name_7.getText(), OrdenadorDeLogin(orden_7, O_escolhido));
        UpdateOrderLogin(user_label_name_8.getText(), OrdenadorDeLogin(orden_8, O_escolhido));  
   }
  }  
     gravar_arquivo();   
        Launch_Service.ChengeScreen("tela_Principal", user, null,null, null);
        Primary_stage.centerOnScreen();
       
        textField_user.setText("");
        textField_senha.setText("");   
     
            }else {
          alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Usuário ou senha invalida !!!");
            alert.show();
            }          
            } catch (SQLException ex) {
           alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Usuário ou senha invalida !!!");
            alert.show();
            } catch (IOException ex) {
            Logger.getLogger(Launch_Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
  }
 
   
 @FXML
   private void setVisible_painelUser(){
     painel_keyboard.setVisible(false);
     painel_users.setVisible(true);
    TranslateTransition t = new TranslateTransition(
    Duration.millis(1500), painel_users);
    t.setFromX(400);
    t.setToX(0);
    t.setAutoReverse(false);
    t.setInterpolator(Interpolator.LINEAR);
    t.play();
    } 
 @FXML
   private void setVisible_painelKeyboard(){
     painel_keyboard.setVisible(true);
     painel_users.setVisible(false);
    TranslateTransition t = new TranslateTransition(
    Duration.millis(1500), painel_keyboard);
    t.setFromX(400);
    t.setToX(0);
    t.setAutoReverse(false);
    t.setInterpolator(Interpolator.LINEAR);
    t.play();
    }
   
 @FXML
    private void handle_User1(MouseEvent event) {
    String username1 = user_label_name_1.getText();
       if(event.getSource()==Hbox_image1){            
       textField_user.setText( username1);
 O_escolhido=1;
       }
       setVisible_painelKeyboard();
    }
    
    @FXML
    private void handle_User2(MouseEvent event) {
    String username2 = user_label_name_2.getText();
       if(event.getSource()==Hbox_image2){            
       textField_user.setText(username2);
O_escolhido=2; 
       }
       setVisible_painelKeyboard();
    }
    @FXML
    private void handle_User3(MouseEvent event) {
    String username3 = user_label_name_3.getText();
       if(event.getSource()==Hbox_image3){            
       textField_user.setText(username3);
   O_escolhido=3;     
       }
          setVisible_painelKeyboard();
    }
    @FXML
    private void handle_User4(MouseEvent event) {
    String username4 = user_label_name_4.getText();
       if(event.getSource()==Hbox_image4){            
       textField_user.setText(username4);
    O_escolhido=4; 
       }
          setVisible_painelKeyboard();
    }
    @FXML
    private void handle_User5(MouseEvent event) {
    String username5 = user_label_name_5.getText();
       if(event.getSource()==Hbox_image5){            
       textField_user.setText(username5);
 O_escolhido=5;
       }
    }
       @FXML
    private void handle_User6(MouseEvent event) {
    String username6 = user_label_name_6.getText();
       if(event.getSource()==Hbox_image6){            
       textField_user.setText(username6);
 O_escolhido=6;
       }
          setVisible_painelKeyboard();
    }
       @FXML
    private void handle_User7(MouseEvent event) {
    String username7 = user_label_name_7.getText();
       if(event.getSource()==Hbox_image7){            
       textField_user.setText(username7);
 O_escolhido=7;
       }
          setVisible_painelKeyboard();
    }
       @FXML
    private void handle_User8(MouseEvent event) {
    String username8 = user_label_name_8.getText();
       if(event.getSource()==Hbox_image8){            
       textField_user.setText(username8);
 O_escolhido=8;
       }
          setVisible_painelKeyboard();
    }
      // --------------------- Acção dos botões letras e números --------------------
     @FXML
    private void handle_Senha(ActionEvent event) {
      texto_senha = textField_senha.getText();
    
    if(event.getSource()==btn_0){   
       String senha = texto_senha.concat("0");
        textField_senha.setText(senha);  
      }    
      if(event.getSource()==btn_1){
        String senha=  texto_senha.concat("1");
        textField_senha.setText(senha);
      }     
     if(event.getSource()==btn_2){
        String senha = texto_senha.concat("2");
        textField_senha.setText(senha);
      }   
  if(event.getSource()==btn_3){
        String senha = texto_senha.concat("3");
        textField_senha.setText(senha);
      }  
  if(event.getSource()==btn_4){
        String senha = texto_senha.concat("4");
        textField_senha.setText(senha);
      }   
  if(event.getSource()==btn_5){
        String senha = texto_senha.concat("5");
        textField_senha.setText(senha);
      }   
  if(event.getSource()==btn_6){
        String senha = texto_senha.concat("6");
        textField_senha.setText(senha);
      }     
  if(event.getSource()==btn_7){
        String senha = texto_senha.concat("7");
        textField_senha.setText(senha);
      }   
  if(event.getSource()==btn_8){
        String senha = texto_senha.concat("8");
        textField_senha.setText(senha);
      }   
  if(event.getSource()==btn_9){
        String senha = texto_senha.concat("9");
        textField_senha.setText(senha);
      }
  if(event.getSource()==btn_Del){
        String senha= texto_senha.replace(texto_senha,"");
        textField_senha.setText(senha);
      }     
    }
  
 // Metodos que lé os dados digitados na folha txt, para Logar com a base lá inserido  -------------------------   
    void leitura_settings() throws IOException{   
  Path caminho_Arquivo = Paths.get("src/main/resources/ficheiros/config.txt");
  Charset utf_8 = StandardCharsets.UTF_8;
  try (BufferedReader read = Files.newBufferedReader(caminho_Arquivo, utf_8)) {      
  @SuppressWarnings("UnusedAssignment")
  String linha = null;
   while((linha = read.readLine())!=null){  
          String [] t = linha.split(";");
          Mysql.setDb(t[0]);Mysql.setUrl(t[1]); Mysql.setDriver(t[2]); Mysql.setPorta_Servidor((t[3]));
          Mysql.setIpServer(t[4]);Mysql.setBD_user(t[5]);Mysql.setBD_Pass(t[6]);
        //  System.out.println(Arrays.toString(t));
      } 
    }
  }    

private void gravar_arquivo() throws IOException{
// usando o objecto da classe serializavel configuracoes , vamos criar um arquivo e guardar os dados necesarios
    Path caminho_Arquivo = Paths.get("src/main/resources/ficheiros/config.txt");
    Charset utf_8 = StandardCharsets.UTF_8;
    try (BufferedWriter  write = Files.newBufferedWriter(caminho_Arquivo, utf_8)){  
        write.write(Mysql.getDb()+";"+Mysql.getUrl()+";"+Mysql.getDriver()+";"+Mysql.getPorta_Servidor()+
                ";"+Mysql.getIpServer()+";"+Mysql.getBD_User()+";"+Mysql.getBD_pass());
        write.flush();
        write.close();
        
       // Aqui guardamos dados ocultos de configuracao em objecto para dados, e seram ilegivel no exterior.  
           conf.nome_user = user.getNome_user();
    conf.userId_user = user.getUser_ID();
    conf.id_user = user.getCod_user();
    conf.prioridade_user = user.getPrioridade();
    conf.nome_Bd = Mysql.getDb();
    conf.url = Mysql.getUrl();
    conf.driver_bd = Mysql.getDriver();
    conf.porta_server = String.valueOf(Mysql.getPorta_Servidor());
    conf.ip_server = Mysql.getIpServer();
    conf.BD_user = Mysql.getBD_User();
    conf.BD_pass = Mysql.getBD_pass();
       FileOutputStream arquivo = new FileOutputStream("src/main/resources/ficheiros/config.dat");
       ObjectOutputStream obj_dados = new ObjectOutputStream(arquivo);
       obj_dados.writeObject(conf);
       obj_dados.flush();       
       
    // Aqui vamos guardar o dado de usuário, com o método que passa parametro apartir da mudança de tela.    
   } catch (HeadlessException | IOException e) {
            System.out.println(conf.nome_user);          
     } 
  }    
}

class Configuracoes  implements Serializable  {
 String tipo_Bd, nome_Bd, userId_user, BD_pass, BD_user, url, driver_bd, 
        senha_user, nome_user, imagema_user, descr_user, email_user, 
        prioridade_user,  ip_server,porta_server, nome_Repositorio, user_ID;
 int cliente_descontos, id_user;
 float valor_notaFiscal, totalNF, valor_Entregue, troco;
 String modo_pagamento, imagemLogo;      
  ObservableList<Clientes>  lista_Recuperar;
}

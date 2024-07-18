/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ao.yami_service;

import co.ao.bd.Mysql;
import co.ao.controllers.Clientes;
import co.ao.controllers.NotaFiscal;
import co.ao.controllers.Usuario;
import com.jfoenix.controls.JFXButton;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Man_firmas
 */
public class Tela_Cobrar implements Initializable {

    private Button Btn_Cancelar;
    private final Usuario  user = new Usuario();
    Clientes cliente = new Clientes();
    String UsuarioLocal ;
// Variaveis em java para logar com a base de dado.----------------------
 private final Mysql BD_conect = new Mysql();   
    @FXML
    private TextField TextFild_PainelCobrar;
    @FXML
    private JFXButton Btn_Calcular;
    @FXML
    private Label label_TatalNF;
    @FXML
    private Label label_ValorEntrgNF;
    @FXML
    private Label label_TrocoNF;
    @FXML
    private JFXButton Btn_EuroBonos;
    @FXML
    private JFXButton Btn_MultiMasterCart;
    @FXML
    private JFXButton Btn_MultVisa;
    @FXML
    private TextField TextFild_NumMultiCaixa;
    @FXML
    private RadioButton RadioCash_cobrar, RadioRequisicao_cobrar,RadioCredito_cobrar,RadioDebito_cobrar;
   @FXML
    private JFXButton Btn_Cobrar;
    @FXML
    private NotaFiscal notaFiscal = new NotaFiscal();
    private final Configuracoes conf_pos = new Configuracoes(); 
    ToggleGroup tg_btn ;
    int var_RadioButton;
    int codItensImp =0;
    float vl_totalNF=0;
    float vl_pamento=0;
    float vl_troco=0;
    float Lbl_TatalNF=0; 
    float Lbl_TrocoNF = 0; 
    float floatl_ValorEntrgNF =0;
    float resultCalculo =0;
    float vl_1 =1; float vl_5 =5;float vl_10 =10; float vl_20 =20;float vl_50 =50; float vl_100 = 100;float vl_200 = 200; float vl_500=500; float vl_1000 =1000; 
    float vl_2000 = 2000; float vl_5000=5000;
    NumberFormat f = NumberFormat.getNumberInstance();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // formatando a variável que dos valores monetários.
       RadioButton();
       f.setGroupingUsed(true);
       f.setMaximumFractionDigits(2);
       f.setMinimumFractionDigits(2);
     lerConfig();
     label_TatalNF.setText(String.valueOf(f.format(vl_totalNF))); 
    }    
    private void handleclose(ActionEvent event) { 
    if(event.getSource()== Btn_Cancelar){  
    
    Tela_principalController.stage_TelaCliente.close();
     }
  }
    @FXML    
   private void CalcularTroco (ActionEvent event){
    label_ValorEntrgNF.setText(String.valueOf(f.format(vl_pamento)));
    floatl_ValorEntrgNF = vl_pamento;
    vl_troco = vl_pamento-vl_totalNF; 
  if(vl_totalNF > 0 && vl_pamento >= 0){         
      if(vl_troco < 0 && vl_pamento < vl_totalNF){             
        label_TrocoNF.setStyle("-fx-text-fill: #E45652; -fx-font: 12pt tahoma");
        label_TrocoNF.setText("Valor Insuficiente");    
  }else{  
        Btn_Cobrar.setText("Cobrar"); 
  //      fontawesame_fechar.getName("CIRCLE_ALT");
        label_TrocoNF.setText(String.valueOf(f.format(vl_troco)));
        label_TrocoNF.setStyle("-fx-text-fill: #2e261d; -fx-font:15pt tahoma");
        Btn_Cobrar.setStyle("-fx-background-color: #4795a5"); 
        tg_btn.getSelectedToggle().toString();
        resultCalculo = vl_totalNF;   
       }    }  else{
        label_TrocoNF.setStyle("-fx-text-fill: #E45652; -fx-font: 12pt tahoma");
        label_TrocoNF.setText("Venda Inexistente");   }
 }
@FXML
 private void Medt_btn_1 (ActionEvent event){
Medt_soma(TextFild_PainelCobrar, vl_1);
 } 
  @FXML
 private void Medt_btn_5 (ActionEvent event){
Medt_soma(TextFild_PainelCobrar, vl_5);
 } 
   @FXML
 private void Medt_btn_10 (ActionEvent event){
Medt_soma(TextFild_PainelCobrar, vl_10);
 }
   @FXML
 private void Medt_btn_20 (ActionEvent event){
Medt_soma(TextFild_PainelCobrar, vl_20);
 } 
   @FXML
 private void Medt_btn_50 (ActionEvent event){
Medt_soma(TextFild_PainelCobrar, vl_50);
 } 
 @FXML
 private void Medt_btn_100 (ActionEvent event){
Medt_soma(TextFild_PainelCobrar, vl_100);
 }
  @FXML
 private void Medt_btn_200 (ActionEvent event){
Medt_soma(TextFild_PainelCobrar, vl_200);
 }
 @FXML
 private void Medt_btn_500 (ActionEvent event){
  Medt_soma(TextFild_PainelCobrar, vl_500);
 }
 @FXML
 private void Medt_btn_1000 (ActionEvent event){
 Medt_soma(TextFild_PainelCobrar, vl_1000);
 }
 @FXML
 private void Medt_btn_2000 (ActionEvent event){
Medt_soma(TextFild_PainelCobrar, vl_2000);
 }
  @FXML
 private void Medt_btn_5000 (ActionEvent event){
 Medt_soma(TextFild_PainelCobrar, vl_5000);
 }

 private float Medt_soma(TextField tela, float btn){
  vl_pamento =  vl_pamento +  btn;  
  tela.setText(String.valueOf(f.format(vl_pamento)));
        return 0;
 }
 @FXML
  private void Medt_Cobrar(ActionEvent event){  
   Calendar c = Calendar.getInstance();
   Date data = c.getTime();
   SimpleDateFormat f3 = new SimpleDateFormat("yyyy/MM/dd");
   String time_set = f3.format(data);      
        if(resultCalculo > 0 && vl_troco >=0){
        notaFiscal = new NotaFiscal(time_set, 0, 0, resultCalculo, vl_troco, floatl_ValorEntrgNF, var_RadioButton, var_RadioButton,0,0,0,0,"");
        Launch_Service.ChengeScreen("tela_Principal", user, null, notaFiscal,vl_totalNF); // Aqui vai tambem as variáveis 
        Tela_principalController.stage_TelaCobrar.close();  
        }else{
         notaFiscal = new NotaFiscal();
         vl_totalNF =0;
         cliente = new Clientes();
         Launch_Service.ChengeScreen("tela_Principal", user, cliente, null, null); // Aqui vai tambem as variaveis notaFiscal, vl_totalNF
         Tela_principalController.stage_TelaCobrar.close();
        }
 }
   private void RadioButton() {      
        tg_btn = new ToggleGroup();
        RadioCash_cobrar.setToggleGroup(tg_btn);
        RadioCredito_cobrar.setToggleGroup(tg_btn);
        RadioDebito_cobrar.setToggleGroup(tg_btn);
        RadioRequisicao_cobrar.setToggleGroup(tg_btn);
        RadioCash_cobrar.setSelected(true);
   if(RadioCash_cobrar.isSelected())
        var_RadioButton = 1 ;
   if(RadioCredito_cobrar.isSelected())
        var_RadioButton = 2 ;
   if(RadioDebito_cobrar.isSelected())
        var_RadioButton = 3;
   if(RadioRequisicao_cobrar.isSelected())
        var_RadioButton = 4;
    } 
  private void lerConfig() {      
     try {
        FileInputStream arquivo = new FileInputStream("src/co/ao/ficheiros/config.dat"); 
        ObjectInputStream obj_dados = new ObjectInputStream(arquivo);
        Configuracoes obj_leitura = (Configuracoes) obj_dados.readObject();               
        vl_totalNF = obj_leitura.valor_notaFiscal;   
        user.setCod_user(1);
        user.setNome_user(obj_leitura.nome_user);
        user.setUser_ID(obj_leitura.user_ID);
        user.setImagem_user(obj_leitura.imagema_user);
        user.setPrioridade(obj_leitura.prioridade_user);   
        } catch (FileNotFoundException e) {
    //        JOptionPane.showMessageDialog(null, "Erro, arquivo nao encontrado= " + e);
        } catch (IOException | ClassNotFoundException ex) {
         //   Logger.getLogger(Controller_telaLogin.class.getName()).log(Level.SEVERE, null, ex);
     }    
  } 
}

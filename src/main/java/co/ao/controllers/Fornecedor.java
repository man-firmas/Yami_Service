/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ao.controllers;

import co.ao.bd.Mysql;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author firmi
 */
@SuppressWarnings("InitializerMayBeStatic")
public class  Fornecedor extends controller_foto {
private int cod_fornecedor;
private String nome_fornecedor;
private String perso_juridica;
private String email_fornecedor;
private int contact1_fornecedor;
private int contact2_fornecedor;
private float valor_credito_forn;
private float valor_extorno_forn;
private String endereco_fornecedor;
private String nif;
private String descricao_fornec;
private String imagem_fornecedor;
private boolean status;
Connection conect; 
NumberFormat f = NumberFormat.getCurrencyInstance();
Alert alert = new Alert(Alert.AlertType.NONE);
    
  public Fornecedor(){};
    public Fornecedor(int cod_fornecedor, String nome_fornecedor, String perso_juridica, String email_fornecedor, int contact1_fornecedor, int contact2_fornecedor, float valor_credito_forn, float valor_extorno_forn, String endereco_fornecedor, String nif, String descricao_fornec, String imagem_fornecedor, boolean status) {
        this.cod_fornecedor = cod_fornecedor;
        this.nome_fornecedor = nome_fornecedor;
        this.perso_juridica = perso_juridica;
        this.email_fornecedor = email_fornecedor;
        this.contact1_fornecedor = contact1_fornecedor;
        this.contact2_fornecedor = contact2_fornecedor;
        this.valor_credito_forn = valor_credito_forn;
        this.valor_extorno_forn = valor_extorno_forn;
        this.endereco_fornecedor = endereco_fornecedor;
        this.nif = nif;
        this.descricao_fornec = descricao_fornec;
        this.imagem_fornecedor = imagem_fornecedor;
        this.status = status; 
    }

@Override
    public String toString() {
        return "Fornecedor{" + "cod_fornecedor=" + cod_fornecedor + ", nome_fornecedor=" + nome_fornecedor + ", perso_juridica=" + perso_juridica + ", email_fornecedor=" + email_fornecedor + ", contact1_fornecedor=" + contact1_fornecedor + ", contact2_fornecedor=" + contact2_fornecedor + ", valor_credito_forn=" + valor_credito_forn + ", valor_extorno_forn=" + valor_extorno_forn + ", endereco_fornecedor=" + endereco_fornecedor + ", nif=" + nif + ", descricao_fornec=" + descricao_fornec + ", imagem_fornecedor=" + imagem_fornecedor + ", status=" + status + '}';
    }

   
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCod_fornecedor() {
        return cod_fornecedor;
    }

    public void setCod_fornecedor(int cod_fornecedor) {
        this.cod_fornecedor = cod_fornecedor;
    }

    public String getNome_fornecedor() {
        return nome_fornecedor;
    }

    public void setNome_fornecedor(String nome_fornecedor) {
        this.nome_fornecedor = nome_fornecedor;
    }

    public String getPerso_juridica() {
        return perso_juridica;
    }

    public void setPerso_juridica(String perso_juridica) {
        this.perso_juridica = perso_juridica;
    }

    public String getEmail_fornecedor() {
        return email_fornecedor;
    }

    public void setEmail_fornecedor(String email_fornecedor) {
        this.email_fornecedor = email_fornecedor;
    }

    public int getContact1_fornecedor() {
        return contact1_fornecedor;
    }

    public void setContact1_fornecedor(int contact1_fornecedor) {
        this.contact1_fornecedor = contact1_fornecedor;
    }

    public int getContact2_fornecedor() {
        return contact2_fornecedor;
    }

    public void setContact2_fornecedor(int contact2_fornecedor) {
        this.contact2_fornecedor = contact2_fornecedor;
    }

    public float getValor_credito_forn() {
        return valor_credito_forn;
    }

    public void setValor_credito_forn(float valor_credito_forn) {
        this.valor_credito_forn = valor_credito_forn;
    }

    public float getValor_extorno_forn() {
        return valor_extorno_forn;
    }

    public void setValor_extorno_forn(float valor_extorno_forn) {
        this.valor_extorno_forn = valor_extorno_forn;
    }

    public String getEndereco_fornecedor() {
        return endereco_fornecedor;
    }

    public void setEndereco_fornecedor(String endereco_fornecedor) {
        this.endereco_fornecedor = endereco_fornecedor;
    }

    public String getDescricao_fornec() {
        return descricao_fornec;
    }

    public void setDescricao_fornec(String descricao_fornec) {
        this.descricao_fornec = descricao_fornec;
    }

    public String getImagem_fornecedor() {
        return imagem_fornecedor;
    }

    public void setImagem_fornecedor(String imagem_fornecedor) {
        this.imagem_fornecedor = imagem_fornecedor;
    }
    
 public void copia_Foto (String src, String nome){
   if(nome.length()<45){
      try {       
          Path original = Paths.get(src); 
          Path caminho_copia = Paths.get("src/co/ao/foto_src/"+nome);
          Files.copy(original, caminho_copia);
      } catch (IOException | NullPointerException ex) {
          alert.setAlertType(Alert.AlertType.ERROR);
          alert.setContentText("Erro ao quardar imagem na pasta src");
          alert.show();
      }
    }  else{
      setImagem_fornecedor("/img_indisponivel.png"); 
       alert.setAlertType(Alert.AlertType.ERROR);
       alert.setContentText("Nome de Imagem Muito extensa");
       alert.show();
     } 
 }
 public void setColuna(TableView tabela){
   TableColumn<Fornecedor, Integer> colID =
new TableColumn<>("ID");     
        colID.setMinWidth(40);
        colID.setCellValueFactory(
new PropertyValueFactory<>("Cod_fornecedor"));
        
TableColumn<Fornecedor, String> colNome =
new TableColumn("Nome");
colNome.setMinWidth(160);
colNome.setCellValueFactory(
new PropertyValueFactory<>("Nome_fornecedor"));
   
TableColumn<Fornecedor, String> persoJuridica =
new TableColumn("Perso_juridica");
persoJuridica.setMinWidth(180);
persoJuridica.setCellValueFactory(
new PropertyValueFactory<>("Perso_juridica"));

TableColumn<Fornecedor, String> contacto =
new TableColumn("Contacto");
contacto.setMinWidth(95);
contacto.setCellValueFactory(
new PropertyValueFactory<>("Contact1_fornecedor"));

TableColumn<Fornecedor, String> credito =
new TableColumn("Crédito");
credito.setMinWidth(95);
credito.setCellValueFactory(
new PropertyValueFactory<>("Valor_credito_forn"));

TableColumn<Fornecedor, String> extorno =
new TableColumn("Extorno");
extorno.setMinWidth(95);
extorno.setCellValueFactory(
new PropertyValueFactory<>("Valor_extorno_forn"));

TableColumn<Fornecedor, String> status_forn =
new TableColumn("Status");
status_forn.setMinWidth(70);
status_forn.setCellValueFactory(
new PropertyValueFactory<>("Status"));
tabela.getColumns().addAll(colID, colNome, persoJuridica,contacto, credito,extorno, status_forn);     
   }
 
@SuppressWarnings("IncompatibleEquals")
public int actualizar_forn(TableView<Fornecedor> tabela, TextField textField_nome_cad_fornec, int combo_perso_juridica_fornec, TextField textField_email_cad_fornec,
TextField textField_enderec_cad_forn, TextField textField_contac1_cad_forn, TextField textField_contac2_cad_forn, 
String text_src_foto_forn, ToggleButton togglebtn_activ_cad_forn, TextField TextField_nif_forn, TextField textField_credito_cad_forn,
 TextField textField_extorno_cad_forn, TextArea textArea_cadast_forn, File fis3)  throws ClassNotFoundException, SQLException, IOException, ParseException{  
     Number myNumber1 = f.parse(textField_credito_cad_forn.getText());
     Number myNumber2 = f.parse(textField_extorno_cad_forn.getText());  
  
    if(!"img_indisponivel.png".equals(fis3.getName()) && fis3.getName() != null ){    
 conect = Mysql.getConnection();     
 String query ="UPDATE fornecedor_tab SET  nome_fornecedor = ?, perso_juridica = ?, status_fornec =?,email_fornec =?, endereco_fornec=?, contactoMovel_forn=? , contactoFixo_forn =?, nif_fornec =?, valor_credito_fornec =?, valor_extorno_fornec=?, descricao_fornec=?, imagem_fornec=? "
         + "WHERE cod_fornecedor=?";
 String id = String.valueOf(tabela.getSelectionModel().getSelectedItem().getCod_fornecedor()) ; 
        PreparedStatement ps = conect.prepareStatement(query);
        ps.setString(1, textField_nome_cad_fornec.getText());  
        ps.setString(2, String.valueOf(combo_perso_juridica_fornec));
        ps.setBoolean(3, togglebtn_activ_cad_forn.isSelected());
        ps.setString(4, textField_email_cad_fornec.getText());
        ps.setString(5, textField_enderec_cad_forn.getText());
        ps.setString(6, textField_contac1_cad_forn.getText());
        ps.setString(7, textField_contac2_cad_forn.getText());
        ps.setString(8, TextField_nif_forn.getText());
        ps.setFloat(9,Integer.valueOf(myNumber1.toString()));
        ps.setFloat(10,Integer.valueOf(myNumber2.toString()));                
        ps.setString(11, textArea_cadast_forn.getText());
        ps.setString(12, fis3.getName());
        ps.setString(13, id);
       int n = ps.executeUpdate();     
    return n;      
 }else{
    conect = Mysql.getConnection();     
 String query ="UPDATE fornecedor_tab SET  nome_fornecedor = ?, perso_juridica = ?,status_fornec =?,email_fornec =?, endereco_fornec=?, contactoMovel_forn=? , contactoFixo_forn =?, nif_fornec =?,valor_credito_fornec =?, valor_extorno_fornec=?, descricao_fornec=? "
         + "WHERE cod_fornecedor=?";
String id = String.valueOf(tabela.getSelectionModel().getSelectedItem().getCod_fornecedor()) ; 
PreparedStatement ps = conect.prepareStatement(query);
            ps.setString(1, textField_nome_cad_fornec.getText());  
            ps.setString(2, String.valueOf(combo_perso_juridica_fornec));
            ps.setBoolean(3, togglebtn_activ_cad_forn.isSelected());
            ps.setString(4, textField_email_cad_fornec.getText());
            ps.setString(5, textField_enderec_cad_forn.getText());
            ps.setString(6, textField_contac1_cad_forn.getText());
            ps.setString(7, textField_contac2_cad_forn.getText());
            ps.setString(8, TextField_nif_forn.getText());
            ps.setFloat(9,Integer.valueOf(myNumber1.toString()));
            ps.setFloat(10,Integer.valueOf(myNumber2.toString()));                  
            ps.setString(11, textArea_cadast_forn.getText());
            ps.setString(12, id);
     int n = ps.executeUpdate();     
    return n; 
      }         
}

@SuppressWarnings("UnusedAssignment")
public void actulizar_foto_forn(String text_src_foto_forn,File fis3, File fis1_3) throws IOException{
try {
    if(("img_indisponivel.png").equals(fis1_3.getName())){
        } else {
        Files.deleteIfExists(Paths.get("src/co/ao/foto_src/"+ fis1_3.getName()));
        }
  
    if(text_src_foto_forn != null) {
    copia_Foto(text_src_foto_forn, fis3.getName());
    setImagem_fornecedor(fis3.getName()); 
      }else {
    setImagem_fornecedor("Fornec_"+fis3.getName());
       }      
            
    } catch (ClassCastException| NullPointerException e) {
       alert.setAlertType(Alert.AlertType.ERROR);
       alert.setContentText("Imagem não encontrada"+ e.getMessage());
       alert.show();
        }
    } 

public void eliminar_Cad_forn(TableView<Fornecedor> tabela, javafx.scene.image.Image icon_forn, File fis1_3){
   alert.setAlertType(Alert.AlertType.CONFIRMATION);
   alert.setContentText("Tem Certeza Que Deseja Eliminar Estes Dados?");
   alert.showAndWait().ifPresent((ButtonType resposta) -> {
       Connection con;
       if(resposta==ButtonType.OK){
           try {
               con = Mysql.getConnection();
               String SQL = "DELETE FROM fornecedor_tab WHERE fornecedor_tab.cod_fornecedor = "+ tabela.getSelectionModel().getSelectedItem().getCod_fornecedor();
               PreparedStatement ps = con.prepareStatement(SQL);
               int n = ps.executeUpdate(SQL);
               if(n>0){
                   alert.setAlertType(Alert.AlertType.INFORMATION);
                   alert.setContentText("Eliminacao bem sucedida");
                   alert.show();
               }
           } catch (SQLException e) {
               alert.setAlertType(Alert.AlertType.ERROR);
               alert.setContentText(e.getMessage());
               alert.show();
           }             
        try {
           if(!("img_indisponivel.png").equals(getImagem_fornecedor())&& !("").equals(fis1_3.getName())){
             
                   Files.deleteIfExists(Paths.get("src/co/ao/foto_src/"+ fis1_3.getName()));
               
           }  
           } catch (IOException ex) {
                   Logger.getLogger(Fornecedor.class.getName()).log(Level.SEVERE, null, ex);
               }
       } else{
           alert.setAlertType(Alert.AlertType.INFORMATION);
           alert.setContentText("Eliminacao Cancelada");
           alert.show();
       }
   });
  }

public int cadastrar_forn(TextField textField_nome_cad_fornec, int combo_perso_juridica_fornec, TextField textField_email_cad_fornec,
TextField textField_enderec_cad_forn, TextField textField_contac1_cad_forn, TextField textField_contac2_cad_forn, 
String text_src_foto_forn, ToggleButton togglebtn_activ_cad_forn, TextField TextField_nif_forn, TextField textField_credito_cad_forn,
 TextField textField_extorno_cad_forn, TextArea textArea_cadast_forn, javafx.scene.image.Image icon1, File fis3) throws ClassNotFoundException, ParseException{
 int n = 0;  
 Number myNumber1 = f.parse(textField_credito_cad_forn.getText());
 Number myNumber2 = f.parse(textField_extorno_cad_forn.getText());  
    if("img_indisponivel.png".equals(fis3.getName())){   
           setImagem_fornecedor("/img_indisponivel.png");    
     }                                  
   try {  
    conect = Mysql.getConnection();
    Mysql.getDriver();

    String SQL = "INSERT INTO fornecedor_tab (nome_fornecedor, perso_juridica ,status_fornec, email_fornec, endereco_fornec, "
            + "contactoMovel_forn, contactoFixo_forn, nif_fornec, valor_credito_fornec, valor_extorno_fornec , descricao_fornec, imagem_fornec) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";      
    PreparedStatement ps = conect.prepareStatement(SQL);
    ps.setString(1, textField_nome_cad_fornec.getText());  
    ps.setString(2, String.valueOf(combo_perso_juridica_fornec));
    ps.setBoolean(3, togglebtn_activ_cad_forn.isSelected());
    ps.setString(4, textField_email_cad_fornec.getText());
    ps.setString(5, textField_enderec_cad_forn.getText());
    ps.setString(6, textField_contac1_cad_forn.getText());
    ps.setString(7, textField_contac2_cad_forn.getText());
    ps.setString(8, TextField_nif_forn.getText());
    ps.setFloat(9,Integer.valueOf(myNumber1.toString()));
    ps.setFloat(10,Integer.valueOf(myNumber2.toString()));                   
    ps.setString(11, textArea_cadast_forn.getText());
    ps.setString(12, fis3.getName());
   n =   ps.executeUpdate();   
        if (n > 0) {                
           alert.setAlertType(Alert.AlertType.INFORMATION);
           alert.setContentText("Dados de Cliente Quardado com Sucesso !!!");
           alert.show();
     }  
  }
  catch (SQLException | NumberFormatException ex ) {  
      alert.setAlertType(Alert.AlertType.INFORMATION);
      alert.setContentText(ex.getMessage());
      alert.show();
        }                               
         return n;                                     
        }                             
}

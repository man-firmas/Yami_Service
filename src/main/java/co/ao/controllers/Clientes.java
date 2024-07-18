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

public class Clientes extends controller_foto{
private int cod_Cliente;
private String nome_Cliente;
private String perso_juridica;
private String email_Cliente;
private String endereco_Cliente;
private int contact1_Cliente;
private int contact2_Cliente;
private float debito_Cliente;
private float credito_Cliente;
private String nif;
private String descricao_Cliente;
private String imagem_Cliente;
private boolean status_Cliente;
Connection conect; 
  NumberFormat f = NumberFormat.getCurrencyInstance();
    Alert alert1 = new Alert(Alert.AlertType.NONE);
    public Clientes() {
    }  
    @Override
    public String toString() {
        return "Cliente{" + "cod_Cliente=" + cod_Cliente + ", nome_Cliente=" + nome_Cliente + ", perso_juridica=" + perso_juridica + ", email_Cliente=" + email_Cliente + ", endereco_Cliente=" + endereco_Cliente + ", contact1_Cliente=" + contact1_Cliente + ", contact2_Cliente=" + contact2_Cliente + ", debito_Cliente=" + debito_Cliente + ", credito_Cliente=" + credito_Cliente + ", nif=" + nif + ", descricao_Cliente=" + descricao_Cliente + ", imagem_Cliente=" + imagem_Cliente + ", status_Cliente=" + status_Cliente + '}';
    }

public Clientes(int cod_Cliente, String nome_Cliente, String perso_juridica, String email_Cliente, String endereco_Cliente, int contact1_Cliente, int contact2_Cliente,  float credito_Cliente,  float debito_Cliente, String descricao_Cliente, String nif, String imagem_Cliente, boolean status_Cliente) {
    this.cod_Cliente = cod_Cliente;
    this.nome_Cliente = nome_Cliente;
    this.perso_juridica = perso_juridica;
    this.email_Cliente = email_Cliente;
    this.endereco_Cliente = endereco_Cliente;
    this.contact1_Cliente = contact1_Cliente;
    this.contact2_Cliente = contact2_Cliente;
    this.debito_Cliente = debito_Cliente;
    this.credito_Cliente = credito_Cliente;
    this.nif = nif;
    this.descricao_Cliente = descricao_Cliente;
    this.imagem_Cliente = imagem_Cliente;
    this.status_Cliente = status_Cliente;
}

    public int getCod_Cliente() {
        return cod_Cliente;
    }

    public void setCod_Cliente(int cod_Cliente) {
        this.cod_Cliente = cod_Cliente;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEndereco_Cliente() {
        return endereco_Cliente;
    }

    public void setEndereco_Cliente(String endereco_Cliente) {
        this.endereco_Cliente = endereco_Cliente;
    }

    public float getDebito_Cliente() {
        return debito_Cliente;
    }

    public void setDebito_Cliente(float debito_Cliente) {
        this.debito_Cliente = debito_Cliente;
    }

    public float getCredito_Cliente() {
        return credito_Cliente;
    }

    public void setCredito_Cliente(float credito_Cliente) {
        this.credito_Cliente = credito_Cliente;
    }
 
    public boolean getStatus_Cliente() {
        return status_Cliente;
    }

    public void setStatus_Cliente(boolean status_Cliente) {
        this.status_Cliente = status_Cliente;
    }

    public String getNome_Cliente() {
        return nome_Cliente;
    }

    public void setNome_Cliente(String nome_Cliente) {
        this.nome_Cliente = nome_Cliente;
        
    }

    public String getPerso_juridica() {
        
        return perso_juridica;
    }

    public void setPerso_juridica(String perso_juridica) {
        this.perso_juridica = perso_juridica;
    }

    public String getEmail_Cliente() {
        return email_Cliente;
    }

    public void setEmail_Cliente(String email_Cliente) {
        this.email_Cliente = email_Cliente;
    }

    public int getContact1_Cliente() {
        return contact1_Cliente;
    }

    public void setContact1_Cliente(int contact1_Cliente) {
        this.contact1_Cliente = contact1_Cliente;
    }

    public int getContact2_Cliente() {
        return contact2_Cliente;
    }

    public void setContact2_Cliente(int contact2_Cliente) {
        this.contact2_Cliente = contact2_Cliente;
    }


    public String getDescricao_Cliente() {
        return descricao_Cliente;
    }

    public void setDescricao_Cliente(String descricao_Cliente) {
        this.descricao_Cliente = descricao_Cliente;
    }

    public String getImagem_Cliente() {
        return imagem_Cliente;
    }

    public void setImagem_Cliente(String imagem_Cliente) {
        this.imagem_Cliente = imagem_Cliente;
    }

public void copía_Foto (String src, String nome){
   if(nome.length()<45){
      try {       
          Path original = Paths.get(src); 
          Path caminho_copia = Paths.get("src/co/ao/foto_src/"+nome);
          Files.copy(original, caminho_copia);
      } catch (IOException | NullPointerException ex) {
          alert1.setAlertType(Alert.AlertType.ERROR);
          alert1.setContentText("Erro ao quardar imagem na pasta src");
          alert1.show();
      }
    }  else{
      setImagem_Cliente("/img_indisponivel.png"); 
       alert1.setAlertType(Alert.AlertType.ERROR);
       alert1.setContentText("Nome de Imagem Muito extensa");
       alert1.show();
     }
  }    

 public void setColuna(TableView tabela){
   TableColumn<Clientes, Integer> colID =
new TableColumn<>("ID");     
        colID.setMinWidth(40);
        colID.setCellValueFactory(
new PropertyValueFactory<>("Cod_Cliente"));
        
TableColumn<Clientes, String> colNome =
new TableColumn("Nome");
colNome.setMinWidth(160);
colNome.setCellValueFactory(
new PropertyValueFactory<>("Nome_Cliente"));
   
TableColumn<Clientes, String> persoJuridica =
new TableColumn("Perso_juridica");
persoJuridica.setMinWidth(140);
persoJuridica.setCellValueFactory(
new PropertyValueFactory<>("Perso_juridica"));

TableColumn<Clientes, String> contacto =
new TableColumn("Contacto");
contacto.setMinWidth(95);
contacto.setCellValueFactory(
new PropertyValueFactory<>("Contact1_Cliente"));

TableColumn<Clientes, String> credito =
new TableColumn("Crédito");
credito.setMinWidth(95);
credito.setCellValueFactory(
new PropertyValueFactory<>("Credito_Cliente"));

TableColumn<Clientes, String> extorno =
new TableColumn("Débito");
extorno.setMinWidth(95);
extorno.setCellValueFactory(
new PropertyValueFactory<>("Debito_Cliente"));

TableColumn<Clientes, String> status_clien =
new TableColumn("Status");
status_clien.setMinWidth(70);
status_clien.setCellValueFactory(
new PropertyValueFactory<>("Status_Cliente"));
tabela.getColumns().addAll(colID, colNome, persoJuridica,contacto, credito,extorno, status_clien);     
   }
 
@SuppressWarnings("IncompatibleEquals")
public int actualizar_Client(TableView<Clientes> tabela, TextField textField_nome_Clien, int combobox_cat_perso_clien, TextField textField_email_cad_clien,
TextField textField_enderec_cad_clien, TextField textField_contac1_cad_clien, TextField textField_contac2_cad_clien, 
String text_src_foto_clien, ToggleButton togglebtn_activ_cad_clien, TextField TextField_nif_clien, TextField textField_credito_cad_clien,
 TextField textField_debito_cad_clien,TextArea textArea_cadast_client, File fis2) throws ClassNotFoundException, SQLException, IOException, ParseException{  
   
    if(!"img_indisponivel.png".equals(fis2.getName()) && fis2.getName() != null ){
       Number myNumber1 = f.parse(textField_credito_cad_clien.getText());
       Number myNumber2 = f.parse(textField_debito_cad_clien.getText());  
    conect = Mysql.getConnection();     
 String query ="UPDATE clientes_tab SET  nome_cliente = ?, perso_juridica = ?,status_cliente =?,email_cliente =?, endereco_cliente=?, contacto1_cliente=? , contacto2_cliente =?, nif_cliente =?, credito_cliente =?, debito_cliente=?, descricao_cliente=?, imagem_cliente=? "
         + "WHERE cod_cliente=?";
 String id = String.valueOf(tabela.getSelectionModel().getSelectedItem().getCod_Cliente()) ; 
            PreparedStatement ps = conect.prepareStatement(query);
            ps.setString(1, textField_nome_Clien.getText());  
            ps.setString(2, String.valueOf(combobox_cat_perso_clien)); 
            ps.setBoolean(3, togglebtn_activ_cad_clien.isSelected());
            ps.setString(4, textField_email_cad_clien.getText());
            ps.setString(5, textField_enderec_cad_clien.getText());
            ps.setString(6, textField_contac1_cad_clien.getText());
            ps.setString(7, textField_contac2_cad_clien.getText());
            ps.setString(8, TextField_nif_clien.getText());       
            ps.setInt(9, Integer.valueOf(myNumber1.toString()) );
            ps.setInt(10, Integer.valueOf(myNumber2.toString()) );
            ps.setString(11, textArea_cadast_client.getText());
            ps.setString(12, fis2.getName());
            ps.setString(13, id);
        int n = ps.executeUpdate(); 
    return n;   
    
 }else{
    conect = Mysql.getConnection();     
 String query ="UPDATE clientes_tab SET  nome_cliente = ?, perso_juridica = ?,status_cliente =?,email_cliente =?, endereco_cliente=?, contacto1_cliente=? , contacto2_cliente =?, nif_cliente =?, credito_cliente =?, debito_cliente=?, descricao_cliente=?"
         + "WHERE cod_cliente=?";
String id = String.valueOf(tabela.getSelectionModel().getSelectedItem().getCod_Cliente()) ; 
PreparedStatement ps = conect.prepareStatement(query);
      ps.setString(1, textField_nome_Clien.getText());  
           ps.setString(1, textField_nome_Clien.getText());  
            ps.setString(2, String.valueOf(combobox_cat_perso_clien));
            ps.setBoolean(3, togglebtn_activ_cad_clien.isSelected());
            ps.setString(4, textField_email_cad_clien.getText());
            ps.setString(5, textField_enderec_cad_clien.getText());
            ps.setString(6, textField_contac1_cad_clien.getText());
            ps.setString(7, textField_contac2_cad_clien.getText());
            ps.setString(8, TextField_nif_clien.getText());
            Number myNumber1 = f.parse(textField_credito_cad_clien.getText());
            Number myNumber2 = f.parse(textField_debito_cad_clien.getText());
            ps.setInt(9, Integer.valueOf(myNumber1.toString()) );
           ps.setInt(10, Integer.valueOf(myNumber2.toString()) );
            ps.setString(11, textArea_cadast_client.getText());
            ps.setString(12, id);
        int n = ps.executeUpdate();     
    return n; 
      }      
   }

@SuppressWarnings("UnusedAssignment")
public void actulizar_foto_Client(String text_src_foto_client,File fis2, File fis1_2) throws IOException{
try {
    if(("img_indisponivel.png").equals(fis1_2.getName())){
        } else {
        Files.deleteIfExists(Paths.get("src/co/ao/foto_src/"+ fis1_2.getName()));
        }  
    if(text_src_foto_client != null) {
    copía_Foto(text_src_foto_client, fis2.getName());    
    setImagem_Cliente(fis2.getName()); 
      }else {
    setImagem_Cliente("Clien_"+fis2.getName());
       }      
            
    } catch (ClassCastException| NullPointerException e) {
       alert1.setAlertType(Alert.AlertType.ERROR);
       alert1.setContentText("Imagem não encontrada"+ e.getMessage());
       alert1.show();
        }
    } 

public void eliminar_Cad_Client(TableView<Clientes> tabela, javafx.scene.image.Image icon_client, File fis1_2){
   alert1.setAlertType(Alert.AlertType.CONFIRMATION);
   alert1.setContentText("Tem Certeza Que Deseja Eliminar Estes Dados?");
   alert1.showAndWait().ifPresent(resposta->{
      Connection con;       
    if(resposta==ButtonType.OK){      
   try {       
   con = Mysql.getConnection();            
   String SQL = "DELETE FROM clientes_tab WHERE clientes_tab.cod_cliente = "+ tabela.getSelectionModel().getSelectedItem().getCod_Cliente();  
   PreparedStatement ps = con.prepareStatement(SQL);            
        int n = ps.executeUpdate(SQL);
        if(n>0){             
          alert1.setAlertType(Alert.AlertType.INFORMATION);
          alert1.setContentText("Eliminacao bem sucedida");
          alert1.show();
        }
        } catch (SQLException e) {
             alert1.setAlertType(Alert.AlertType.ERROR);
             alert1.setContentText(e.getMessage());
             alert1.show();
        }     
   try {      
   if(!("img_indisponivel.png").equals(getImagem_Cliente())&& !"".equals(fis1_2.getName()) ){
        
           Files.deleteIfExists(Paths.get("src/co/ao/foto_src/"+ fis1_2.getName()));
        } 
    } catch (IOException ex) {
           Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
       }
     } else{
         alert1.setAlertType(Alert.AlertType.INFORMATION);
         alert1.setContentText("Eliminacao Cancelada");
         alert1.show();
     }  
   });     
   }

public int cadastrar_Client(TextField textField_nome_cad_clien, int combo_perso_juridica_clien, TextField textField_email_cad_clien,
TextField textField_enderec_cad_clien, TextField textField_contac1_cad_clien, TextField textField_contac2_cad_clien, 
String text_src_foto_clien, ToggleButton togglebtn_activ_cad_clien, TextField TextField_nif_clien, TextField textField_credito_cad_clien,
TextField textField_debito_cad_clien, TextArea textArea_cadast_clien, File fis2) throws ParseException, ClassNotFoundException{
 int n = 0;  
     Number myNumber1 = f.parse(textField_credito_cad_clien.getText());
     Number myNumber2 = f.parse(textField_debito_cad_clien.getText());                                
   if("img_indisponivel.png".equals(fis2.getName())){   
           setImagem_Cliente("/img_indisponivel.png");  
     }                                      
   try {    
            conect = Mysql.getConnection();
            Mysql.getDriver();            
            String SQL = "INSERT INTO clientes_tab (nome_cliente, perso_juridica, status_cliente, email_cliente, endereco_cliente, contacto1_cliente, contacto2_cliente, nif_cliente,credito_cliente, debito_cliente, descricao_cliente, imagem_cliente) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";      
            PreparedStatement ps = conect.prepareStatement(SQL);
            ps.setString(1, textField_nome_cad_clien.getText());  
            ps.setString(2, String.valueOf(combo_perso_juridica_clien));
            ps.setBoolean(3, togglebtn_activ_cad_clien.isSelected());
            ps.setString(4, textField_email_cad_clien.getText());
            ps.setString(5, textField_enderec_cad_clien.getText());
            ps.setString(6, textField_contac1_cad_clien.getText());
            ps.setString(7, textField_contac2_cad_clien.getText());
            ps.setString(8, TextField_nif_clien.getText());       
            ps.setInt(9, Integer.valueOf(myNumber1.toString()));
            ps.setInt(10, Integer.valueOf(myNumber2.toString()));
            ps.setString(11, textArea_cadast_clien.getText());
            ps.setString(12, fis2.getName());         
           n = ps.executeUpdate();
        if (n > 0) {    
            
           alert1.setAlertType(Alert.AlertType.INFORMATION);
           alert1.setContentText("Dados de Cliente Quardado com Sucesso !!!");
           alert1.show();
     }  
  }
  catch (SQLException | NumberFormatException ex ) {  
      alert1.setAlertType(Alert.AlertType.INFORMATION);
      alert1.setContentText(ex.getMessage());
      alert1.show();
        }                               
         return n;                          
        } 
}

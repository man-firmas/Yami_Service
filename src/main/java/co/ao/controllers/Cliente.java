package co.ao.controllers;

import co.ao.bd.Mysql;
import co.ao.yami_service.Tela_principalController;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
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
public class Cliente {
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
private int descontos_Cliente;
private String descricao_Cliente;
private String imagem_Cliente;
private boolean status_Cliente;
Connection conect; 
        Alert msg ;
    public Cliente() {
    }  
    @Override
    public String toString() {
        return "Cliente{" + "cod_Cliente=" + cod_Cliente + ", nome_Cliente=" + nome_Cliente + ", perso_juridica=" + perso_juridica + ", email_Cliente=" + email_Cliente + ", endereco_Cliente=" + endereco_Cliente + ", contact1_Cliente=" + contact1_Cliente + ", contact2_Cliente=" + contact2_Cliente + ", debito_Cliente=" + debito_Cliente + ", credito_Cliente=" + credito_Cliente + ", nif=" + nif + ", descontos_Cliente=" + descontos_Cliente + ", descricao_Cliente=" + descricao_Cliente + ", imagem_Cliente=" + imagem_Cliente + ", status_Cliente=" + status_Cliente + '}';
    }

public Cliente(int cod_Cliente, String nome_Cliente, String perso_juridica, String email_Cliente, String endereco_Cliente, int contact1_Cliente, int contact2_Cliente,  float credito_Cliente,  float debito_Cliente, int descontos_Cliente, String descricao_Cliente, String nif, String imagem_Cliente, boolean status_Cliente) {
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
    this.descontos_Cliente = descontos_Cliente;
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


    public int getDescontos_Cliente() {
        return descontos_Cliente;
    }

    public void setDescontos_Cliente(int descontos_Cliente) {
        this.descontos_Cliente = descontos_Cliente;
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

public void copia_Foto(String src, String nome){
      try {
          Path original = Paths.get(src); 
          Path caminho_copia = Paths.get("src/foto_src/"+nome);
          Files.copy(original, caminho_copia);
      } catch (IOException | NullPointerException ex) {
      //    msg.start("ERRO", "Ao quardar imagem na pasta src", "Ok", "");
          msg.setAlertType(Alert.AlertType.ERROR);
          msg.setContentText(" Ao quardar imagem na pasta src");
      }
  }    
 public void setColuna(TableView tabela){
   TableColumn<Cliente, Integer> colID =
new TableColumn<>("ID");     
        colID.setMinWidth(40);
        colID.setCellValueFactory(
new PropertyValueFactory<>("Cod_Cliente"));
        
TableColumn<Cliente, String> colNome =
new TableColumn("Nome");
colNome.setMinWidth(160);
colNome.setCellValueFactory(
new PropertyValueFactory<>("Nome_Cliente"));
   
TableColumn<Cliente, String> persoJuridica =
new TableColumn("Perso_juridica");
persoJuridica.setMinWidth(140);
persoJuridica.setCellValueFactory(
new PropertyValueFactory<>("Perso_juridica"));

TableColumn<Cliente, String> contacto =
new TableColumn("Contacto");
contacto.setMinWidth(95);
contacto.setCellValueFactory(
new PropertyValueFactory<>("Contact1_Cliente"));

TableColumn<Cliente, String> credito =
new TableColumn("Crédito");
credito.setMinWidth(95);
credito.setCellValueFactory(
new PropertyValueFactory<>("Credito_Cliente"));

TableColumn<Cliente, String> extorno =
new TableColumn("Débito");
extorno.setMinWidth(95);
extorno.setCellValueFactory(
new PropertyValueFactory<>("Debito_Cliente"));

TableColumn<Cliente, String> status_clien =
new TableColumn("Status");
status_clien.setMinWidth(70);
status_clien.setCellValueFactory(
new PropertyValueFactory<>("Status_Cliente"));
tabela.getColumns().addAll(colID, colNome, persoJuridica,contacto, credito,extorno, status_clien);     
   }
 
@SuppressWarnings("IncompatibleEquals")
public int actualizar_Client(TableView<Cliente> tabela, TextField textField_nome_Clien, int combobox_cat_perso_clien, TextField textField_email_cad_clien,
TextField textField_enderec_cad_clien, TextField textField_contac1_cad_clien, TextField textField_contac2_cad_clien, 
String text_src_foto_clien, ToggleButton togglebtn_activ_cad_clien, TextField TextField_nif_clien, TextField textField_credito_cad_clien,
 TextField textField_debito_cad_clien,TextField textField_desconto_cad_clien, TextArea textArea_cadast_client, File fis3) throws ClassNotFoundException, SQLException, IOException{  
if(!"img_indisponivel.png".equals(fis3.getName()) && fis3.getName() != null ){
    conect = Mysql.getConnection();     
 String query ="UPDATE cliente_tab SET  nome_cliente = ?, perso_juridica_cliente = ?,status_cliente =?,email_cliente =?, endereco_cliente=?, contacto1_cliente=? , contacto2_cliente =?, nif_cliente =?, credito_cliente =?, debito_cliente=?, descontos_cliente=?, descricao_cliente=?, imagem_cliente=? "
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
            ps.setFloat(9,((Float.parseFloat(textField_credito_cad_clien.getText()))));
            ps.setFloat(10,((Float.parseFloat(textField_debito_cad_clien.getText())))); 
            ps.setString(11, textField_desconto_cad_clien.getText()); 
            ps.setString(12, textArea_cadast_client.getText());
            ps.setString(13, getImagem_Cliente());
            ps.setString(14, id);
        int n = ps.executeUpdate(); 
    
    return n;
       
 }else{
    conect = Mysql.getConnection();     
 String query ="UPDATE cliente_tab SET  nome_cliente = ?, perso_juridica_cliente = ?,status_cliente =?,email_cliente =?, endereco_cliente=?, contacto1_cliente=? , contacto2_cliente =?, nif_cliente =?, credito_cliente =?, debito_cliente=?, descontos_cliente=?, descricao_cliente=?"
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
            ps.setFloat(9,((Float.parseFloat(textField_credito_cad_clien.getText()))));
            ps.setFloat(10,((Float.parseFloat(textField_debito_cad_clien.getText()))));
             ps.setString(11, textField_desconto_cad_clien.getText());
            ps.setString(12, textArea_cadast_client.getText());
            ps.setString(13, id);
        int n = ps.executeUpdate();     
    return n; 
      }      
   }

@SuppressWarnings("UnusedAssignment")
public void actulizar_foto_Client(String text_src_foto_client,File file_client, File Fs1_3) throws IOException{
copia_Foto(text_src_foto_client, file_client.getName());
    setImagem_Cliente(file_client.getName()); 
    if(("img_indisponivel.png").equals(Fs1_3.getName())){
        } else {
        Files.deleteIfExists(Paths.get("src/foto_src/"+ Fs1_3.getName()));
        }
    } 

public void eliminar_Cad_Client(TableView<Cliente> tabela, javafx.scene.image.Image icon_client, File fis1_4){
   // msg.start("Atenção", "Tem certeza que deseja eliminar todos os Item na Base de Dado?","Sim","Não");
  boolean yes = true;
   Connection con;       
    if(yes ==true){      
   try {     
        try {  
   con = Mysql.getConnection();            
   String SQL = "DELETE FROM cliente_tab WHERE cliente_tab.cod_cliente = "+ tabela.getSelectionModel().getSelectedItem().getCod_Cliente();  
   PreparedStatement ps = con.prepareStatement(SQL);            
        int n = ps.executeUpdate(SQL);
        if(n>0){             
       //   reset_foto(icon_client);
        }
        } catch (SQLException e) {
     //        msg.start("ERRO", e.getMessage(), "Ok", "");
        }        
     //   msg.start("SUCESSO", "Eliminacao bem sucedida", "Ok", "");    
        if(!("img_indisponivel.png").equals(getImagem_Cliente()) ){
        Files.deleteIfExists(Paths.get("src/foto_src/"+ fis1_4.getName()));
        }     
    } catch (IOException ex) {
                Logger.getLogger(Tela_principalController.class.getName()).log(Level.SEVERE,null, ex);
    }     
     } else{
  //    msg.start("ERRO", "Eliminacao negada?", "Ok", "");
     } 
   }

public int cadastrar_Client(TextField textField_nome_cad_clien, int combo_perso_juridica_clien, TextField textField_email_cad_clien,
TextField textField_enderec_cad_clien, TextField textField_contac1_cad_clien, TextField textField_contac2_cad_clien, 
String text_src_foto_clien, ToggleButton togglebtn_activ_cad_clien, TextField TextField_nif_clien, TextField textField_credito_cad_clien,
TextField textField_debito_cad_clien, TextField textField_descon_cad_clien, TextArea textArea_cadast_clien, File fis3){
 int n = 0;  
    if ("".equals(textField_nome_cad_clien.getText())) {
        //            msg.start("ATENÇÃO", "Campo Obrigatorio, insere o nome do produto", "Ok", "");
                } else {
                    if ("".equals(String.valueOf(combo_perso_juridica_clien))) {
         //            msg.start("ATENÇÃO", "Campo Obrigatorio, selecione uma categoria...", "Ok", "");  
                    } else {
                        if ("".equals(textField_email_cad_clien.getText())) {                            
          //             msg.start("ATENÇÃO", "Campo Obrigatorio, Inseria endereço Electronico.", "Ok", "");           
                        } else {
                            if ("".equals(textField_enderec_cad_clien.getText())) {
           //                 msg.start("ATENÇÃO", "Campo Obrigatorio,Preencher compo endereço.", "Ok", "");           
                            } else {
                                if("".equals(textField_contac1_cad_clien.getText())){ 
                //                 msg.start("ATENÇÃO", "Preencher compo contacto 1", "Ok", "");                     
                               }else{
                                    if("".equals(textField_contac2_cad_clien.getText())){
               //                    msg.start("ATENÇÃO", "Preencher compo contacto 2", "Ok", "");                     
                                          }                                    
                                    else{ 
   if("img_indisponivel.png".equals(fis3.getName())){   
           setImagem_Cliente("/img_indisponivel.png");    
     }                                      
   try {       
            conect = Mysql.getConnection();
            Mysql.getDriver();            
            String SQL = "INSERT INTO cliente_tab (nome_cliente, perso_juridica_cliente, status_cliente, email_cliente, endereco_cliente, contacto1_cliente, contacto2_cliente, nif_cliente,credito_cliente, debito_cliente, descontos_cliente, descricao_cliente, imagem_cliente) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";      
            PreparedStatement ps = conect.prepareStatement(SQL);
            ps.setString(1, textField_nome_cad_clien.getText());  
            ps.setString(2, String.valueOf(combo_perso_juridica_clien));
            ps.setBoolean(3, togglebtn_activ_cad_clien.isSelected());
            ps.setString(4, textField_email_cad_clien.getText());
            ps.setString(5, textField_enderec_cad_clien.getText());
            ps.setString(6, textField_contac1_cad_clien.getText());
            ps.setString(7, textField_contac2_cad_clien.getText());
            ps.setInt(8, Integer.valueOf(TextField_nif_clien.getText()));
            ps.setFloat(9,((Float.parseFloat(textField_credito_cad_clien.getText()))));
            ps.setFloat(10,((Float.parseFloat(textField_debito_cad_clien.getText()))));
            ps.setString(11, textField_descon_cad_clien.getText());
            ps.setString(12, textArea_cadast_clien.getText());
            ps.setString(13, getImagem_Cliente());         
        n = ps.executeUpdate();
        if (n > 0) {
 //      msg.start("SUCESSO", "Dados Quardados Correctamente!", "Ok", "");                                     
     }  
    }
  catch (SQLException ex ) {
  //         msg.start("ERRO", "Variavel não Encontrada", "Ok", "");      
        }     
                                    }      
                                  }   
                            }
                        }
                    }
                }  
    return n;
 }
}

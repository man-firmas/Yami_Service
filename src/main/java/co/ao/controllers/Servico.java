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
import java.text.ParseException;
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
public class Servico extends controller_foto{
private int cod_servico;
private String nome_servico;
private int cod_categoria;
private int identificador;
private String descricao_servico;
private float preco_unit;
private int fornecedor;
private String imagem_servicos;
private int status_servico;
private Connection conect;
   Alert alert = new Alert(Alert.AlertType.NONE);
public Servico(){}; 

    public Servico(int cod_servico, String nome_servico, int cod_categoria, int identificador, String descricao_servico, float preco_unit, String imagem_servicos, int fornecedor, int status_servico) {
        this.cod_servico = cod_servico;
        this.nome_servico = nome_servico;
        this.cod_categoria = cod_categoria;
        this.identificador = identificador;
        this.descricao_servico = descricao_servico;
        this.preco_unit = preco_unit;
        this.fornecedor = fornecedor;
        this.status_servico = status_servico;
        this.imagem_servicos=imagem_servicos;
    }

    public int getCod_servico() {
        return cod_servico;
    }

    public void setCod_servico(int cod_servico) {
        this.cod_servico = cod_servico;
    }

    public String getNome_servico() {
        return nome_servico;
    }

    public void setNome_servico(String nome_servico) {
        this.nome_servico = nome_servico;
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getDescricao_servico() {
        return descricao_servico;
    }

    public void setDescricao_servico(String descricao_servico) {
        this.descricao_servico = descricao_servico;
    }

    public float getPreco_unit() {
        return preco_unit;
    }

    public void setPreco_unit(float preco_unit) {
        this.preco_unit = preco_unit;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getStatus_servico() {
        return status_servico;
    }

    public void setStatus_servico(int status_servico) {
        this.status_servico = status_servico;
    }

    public Connection getConect() {
        return conect;
    }

    public void setConect(Connection conect) {
        this.conect = conect;
    }

    public String getImagem_servicos() {
        return imagem_servicos;
    }

    public void setImagem_servicos(String imagem_servicos) {
        this.imagem_servicos = imagem_servicos;
    }

    public void copía_Foto (String src, String nome){
      try {
          Path original = Paths.get(src); 
          Path caminho_copia = Paths.get("src/foto_src/"+nome);
          Files.copy(original, caminho_copia);
      } catch (IOException | NullPointerException ex) {
       //   msg.start("ERRO", "Ao quardar imagem na pasta src", "Ok", "");
      }
  }   
 
     
 public void setColuna(TableView tabela){
   TableColumn<Servico, Integer> colID =
new TableColumn<>("ID");     
        colID.setMinWidth(40);
        colID.setCellValueFactory(
new PropertyValueFactory<>("Cod_Ordem_Serviço"));
        
TableColumn<Servico, String> colNome =
new TableColumn("Nome");
colNome.setMinWidth(170);
colNome.setCellValueFactory(
new PropertyValueFactory<>("Cod_categoria"));
   
TableColumn<Servico, String> userID =
new TableColumn("User_ID");
userID.setMinWidth(95);
userID.setCellValueFactory(
new PropertyValueFactory<>("User_ID"));

TableColumn<Servico, String> Colun_funcao =
new TableColumn("Função");
Colun_funcao.setMinWidth(150);
Colun_funcao.setCellValueFactory(
new PropertyValueFactory<>("Funcao"));

TableColumn<Servico, String> extorno =
new TableColumn("Prioridade");
extorno.setMinWidth(150);
extorno.setCellValueFactory(
new PropertyValueFactory<>("Prioridade"));

TableColumn<Servico, String> status_user =
new TableColumn("Status");
status_user.setMinWidth(40);
status_user.setCellValueFactory(
new PropertyValueFactory<>("Status"));
tabela.getColumns().addAll(colID, colNome, userID, Colun_funcao, extorno, status_user);     
   }
 
@SuppressWarnings("IncompatibleEquals")
public int actualizar_User(TableView<Servico> tabela, TextField textField_nome_user, int combobox_priorid_user, TextField textField_email_user,
TextField textField_user_ID, TextField textField_senha_pin_user, String text_src_foto_user, ToggleButton togglebtn_activ_cad_user,
TextArea textArea_descrcao_user, int textField_funcao_user, javafx.scene.image.Image icon5, File fis5, int local_a_operar ) throws ClassNotFoundException, SQLException, IOException{  
if(!"img_indisponivel.png".equals(fis5.getName()) && fis5.getName() != null ){
    conect = Mysql.getConnection();     
 String query ="UPDATE usuario_tab SET  nome_usuario = ?, prioridade_usuario =?, status_usuario =?, email_usuario =?, user_ID =?, senha_pin_usuario=? , descricao_usuario =?, cod_funcao=?, imagem_usuario =?, local_a_operar =? "
         + "WHERE cod_usuario=?";
 String id = String.valueOf(tabela.getSelectionModel().getSelectedItem().getCod_servico()) ; 
    PreparedStatement ps = conect.prepareStatement(query);
    ps.setString(1, textField_nome_user.getText());  
    ps.setString(2, String.valueOf(combobox_priorid_user)); 
    ps.setBoolean(3,togglebtn_activ_cad_user.isSelected());
    ps.setString(4, textField_email_user.getText());
    ps.setString(5, textField_user_ID.getText());
    ps.setString(6, textField_senha_pin_user.getText());
    ps.setString(7, textArea_descrcao_user.getText());
    ps.setInt(8, textField_funcao_user); 
    ps.setString(9, getImagem_servicos());
    ps.setInt(10, local_a_operar); 
    ps.setString(11, id);
    int n = ps.executeUpdate();     
    return n;
       
 }else{
    conect = Mysql.getConnection();     
 String query ="UPDATE usuario_tab SET  nome_usuario = ?, prioridade_usuario =?, status_usuario =?, email_usuario =?, user_ID =?, senha_pin_usuario=? , descricao_usuario =?, cod_funcao=?,local_a_operar=?, fechamento_log =0 "
         + "WHERE cod_usuario=?";    
    String id = String.valueOf(tabela.getSelectionModel().getSelectedItem().getCod_servico()) ; 
    PreparedStatement ps = conect.prepareStatement(query);
        ps.setString(1, textField_nome_user.getText());  
        ps.setString(2, String.valueOf(combobox_priorid_user)); 
        ps.setBoolean(3,togglebtn_activ_cad_user.isSelected());
        ps.setString(4, textField_email_user.getText());
        ps.setString(5, textField_user_ID.getText());
        ps.setString(6, textField_senha_pin_user.getText());
        ps.setString(7, textArea_descrcao_user.getText());
        ps.setInt(8, textField_funcao_user);  
        ps.setInt(9, local_a_operar);  
        ps.setString(10, id);
        int n = ps.executeUpdate();     
    return n; 
      }      
   }
public int actualizar_UserFechamentoLog(int Id_user, int fechamentolog) throws SQLException, ClassNotFoundException{
     
  conect = Mysql.getConnection();  
 String query ="UPDATE usuario_tab SET  fechamento_log = ? "
         + "WHERE cod_usuario=?";    
    PreparedStatement ps = conect.prepareStatement(query);
    ps.setInt(1, fechamentolog);    
    ps.setInt(2, Id_user); 
     int n = ps.executeUpdate();  
     return n; 
}


@SuppressWarnings("UnusedAssignment")
public void actulizar_foto_User(String text_src_foto_user,File file_user, File fis1_5) throws IOException{
try {
      if(text_src_foto_user != null) {
    copía_Foto(text_src_foto_user, file_user.getName());    
    setImagem_servicos(file_user.getName()); 
      if(("img_indisponivel.png").equals(fis1_5.getName())){
        } else {
        Files.deleteIfExists(Paths.get("src/foto_src/"+ fis1_5.getName()));
        }  
      }else {
       }        
    } catch (ClassCastException| NullPointerException e) {
      // msg.start("ERRO",  "Imagem não encontrada" + e, "Ok", "");
        }
    } 

public void eliminar_BD_User(TableView<Servico> tabela, javafx.scene.image.Image icon_user, File fis1_5){
  // msg.start("Atenção", "Tem Certeza que Deseja Eliminar este Item na Base de Dado?","Sim","Não");
   boolean yes = true ;//msg.btnYesClicked;
   Connection con;       
    if(yes ==true){     
   try {     
        try {  
   con = Mysql.getConnection();            
   String SQL = "DELETE FROM usuario_tab WHERE usuario_tab.cod_usuario = "+ tabela.getSelectionModel().getSelectedItem().getCod_servico();  
   PreparedStatement ps = con.prepareStatement(SQL);            
        int n = ps.executeUpdate(SQL);
        if(n>0){             
          reset_foto(icon_user);
        }
        } catch (SQLException e) {
       //  msg.start("ERRO",  "Erro na eliminacao de registo "+ e, "Ok", "");
        }        
        // msg.start("SUCESSO", "Eliminacao bem sucedida", "Ok", ""); 
        if(!("img_indisponivel.png").equals(getImagem_servicos()) ){
        Files.deleteIfExists(Paths.get("src/foto_src/"+ fis1_5.getName()));
        }
       
    } catch (IOException ex) {
               
    }     
     } else{
 //     msg.start("ERRO", "Eliminacao negada", "Ok", "");
     } 
   }

public int cadastrar_serivico(TextField textField_nomeServic, int combobox_categ_serv, TextField TextField_codBarra, 
            int combobox_codSerie, TextField textField_precCompraAcess, TextField textField_precVendaAcess, 
TextArea textA_descriçãoAcess,TextField textField_FornecAcess, String imageView_cadaAcess,
ToggleButton togglebtn_activ_cadAcess, File fis4) throws ParseException, ClassNotFoundException{
 int n = 0;  
                              
   if("img_indisponivel.png".equals(fis4.getName())){   
           setImagem_servicos("/img_indisponivel.png");  
     }                                      
   try {    
            conect = Mysql.getConnection();
            Mysql.getDriver();            
            String SQL = "INSERT INTO acessorios_tab (nome_acessorio, cod_categoria, cod_barra, preco_unit, preco_compra, descricao_acessorio, fornecedor, imagem_acessorio, status_acessorios, serie_acessorio) VALUES (?,?,?,?,?,?,?,?,?,?)";      
            PreparedStatement ps = conect.prepareStatement(SQL);
          //  ps.setInt(2, combobox_categ_acess);
            ps.setString(3, TextField_codBarra.getText() );           

            ps.setString(6, textA_descriçãoAcess.getText());
            ps.setString(7, textField_FornecAcess.getText()); 
            ps.setString(8,  fis4.getName());              
            ps.setBoolean(9, togglebtn_activ_cadAcess.isSelected());
            ps.setInt(10, combobox_codSerie);        
            n = ps.executeUpdate();
        if (n > 0) {    
            
           alert.setAlertType(Alert.AlertType.INFORMATION);
           alert.setContentText("Dados de Âcessório Quardado com Sucesso !!!");
           alert.show();
     }  
  }
  catch (SQLException | NumberFormatException ex ) {  
      alert.setAlertType(Alert.AlertType.ERROR);
      alert.setContentText(ex.getMessage());
      alert.show();
    }                               
     return n;                          
    } 

 
   
  
}

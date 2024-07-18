package co.ao.controllers;

import co.ao.bd.Mysql;
import co.ao.yami_service.Tela_LoginController;
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
public class Usuario extends controller_foto{
private String nome_user;
private String prioridade;
private int cod_user;
private String email_user;
private String senha_pin;
private String imagem_user;
private boolean status;
private String user_ID;
private String descricao;
private String funcao;
private String local_a_Operar;
private int contact_1;
int ordenadorDeLogin;
Connection conect;
 private final Mysql BD_conect = new Mysql();
Alert alert = new Alert(Alert.AlertType.NONE);
  private static final Tela_LoginController telaLogin2 = new Tela_LoginController();
public Usuario(){}; 

    public Usuario(String nome_user, String prioridade, int cod_user, String email_user, String senha_pin, String imagem_user, boolean status, String user_ID, String descricao, String funcao, String local_a_Operar, int contact_1, int ordenadorDeLogin) {
        this.nome_user = nome_user;
        this.prioridade = prioridade;
        this.cod_user = cod_user;
        this.email_user = email_user;
        this.senha_pin = senha_pin;
        this.imagem_user = imagem_user;
        this.status = status;
        this.user_ID = user_ID;
        this.descricao = descricao;
        this.funcao = funcao;
        this.local_a_Operar = local_a_Operar;
        this.contact_1 = contact_1;
        this.ordenadorDeLogin = ordenadorDeLogin;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome_user=" + nome_user + ", prioridade=" + prioridade + ", cod_user=" + cod_user + ", email_user=" + email_user + ", senha_pin=" + senha_pin + ", imagem_user=" + imagem_user + ", status=" + status + ", user_ID=" + user_ID + ", descricao=" + descricao + ", funcao=" + funcao + ", local_a_Operar=" + local_a_Operar + ", contact_1=" + contact_1 + ", ordenadorDeLogin=" + ordenadorDeLogin + '}';
    } 

    public int getContact_1() {
        return contact_1;
    }

    public void setContact_1(int contact_1) {
        this.contact_1 = contact_1;
    }


    public int getOrdenadorDeLogin() {
        return ordenadorDeLogin;
    }

    public void setOrdenadorDeLogin(int ordenadorDeLogin) {
        this.ordenadorDeLogin = ordenadorDeLogin;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getNome_user() {
        return nome_user;
    }

    public void setNome_user(String nome) {
        this.nome_user = nome;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public int getCod_user() {
        return cod_user;
    }

    public void setCod_user(int cod_user) {
        this.cod_user = cod_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getSenha_pin() {
        return senha_pin;
    }

    public void setSenha_pin(String senha_pin) {
        this.senha_pin = senha_pin;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getImagem_user() {
        return imagem_user;
    }

    public void setImagem_user(String imagem) {
        this.imagem_user = imagem;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal_a_Operar() {
        return local_a_Operar;
    }

    public void setLocal_a_Operar(String local_a_Operar) {
        this.local_a_Operar = local_a_Operar;
    }

public void copía_Foto (String src, String nome){
        if(nome.length()<45){
     try {       
         Path original = Paths.get(src);                                       
         Path caminho_copia = Paths.get("src/co/ao/foto_src/"+nome);
         Files.copy(original, caminho_copia);
     } catch (IOException | NullPointerException ex) {
       alert.setAlertType(Alert.AlertType.ERROR);
       alert.setContentText("Erro ao quardar imagem = " +ex.getMessage());
       alert.show();
      }
      }  else{
      setImagem_user("/img_indisponivel.png"); 
       alert.setAlertType(Alert.AlertType.ERROR);
       alert.setContentText("Nome de Imagem Muito extensa");
       alert.show();
     }
  }    
 public void setColuna(TableView tabela){
   TableColumn<Usuario, Integer> colID =
new TableColumn<>("ID");     
        colID.setMinWidth(40);
        colID.setCellValueFactory(
new PropertyValueFactory<>("Cod_user"));
        
TableColumn<Usuario, String> colNome =
new TableColumn("Nome");
colNome.setMinWidth(170);
colNome.setCellValueFactory(
new PropertyValueFactory<>("Nome_user"));
   
TableColumn<Usuario, String> userID =
new TableColumn("User_ID");
userID.setMinWidth(95);
userID.setCellValueFactory(
new PropertyValueFactory<>("User_ID"));

TableColumn<Usuario, String> Colun_funcao =
new TableColumn("Função");
Colun_funcao.setMinWidth(150);
Colun_funcao.setCellValueFactory(
new PropertyValueFactory<>("Funcao"));

TableColumn<Usuario, String> extorno =
new TableColumn("Prioridade");
extorno.setMinWidth(150);
extorno.setCellValueFactory(
new PropertyValueFactory<>("Prioridade"));

TableColumn<Usuario, String> status_user =
new TableColumn("Status");
status_user.setMinWidth(40);
status_user.setCellValueFactory(
new PropertyValueFactory<>("Status"));
tabela.getColumns().addAll(colID, colNome, userID, Colun_funcao, extorno, status_user);     
   }
 
@SuppressWarnings("IncompatibleEquals")
public int actualizar_User(TableView<Usuario> tabela, TextField textField_nome_user, int combobox_priorid_user, TextField textField_email_user,
TextField textField_user_ID,String textField_senha_pin_user, String text_src_foto_user, ToggleButton togglebtn_activ_cad_user,
TextArea textArea_descrcao_user, int textField_funcao_user, javafx.scene.image.Image icon5, File fis5, int local_a_operar ) throws ClassNotFoundException, SQLException, IOException{  
if(!"img_indisponivel.png".equals(fis5.getName()) && fis5.getName() != null ){
    conect = Mysql.getConnection();     
 String query ="UPDATE usuario_tab SET  nome_usuario = ?, prioridade_usuario =?, status_usuario =?, email_usuario =?, user_ID =?, senha_pin_usuario=? , descricao_usuario =?, cod_funcao=?, imagem_usuario =?, local_a_operar =? "
         + "WHERE cod_usuario=?";
 String id = String.valueOf(tabela.getSelectionModel().getSelectedItem().getCod_user()) ; 
    PreparedStatement ps = conect.prepareStatement(query);
    ps.setString(1, textField_nome_user.getText());  
    ps.setString(2, String.valueOf(combobox_priorid_user)); 
    ps.setBoolean(3,togglebtn_activ_cad_user.isSelected());
    ps.setString(4, textField_email_user.getText());
    ps.setString(5, textField_user_ID.getText());
    ps.setString(6, textField_senha_pin_user);
    ps.setString(7, textArea_descrcao_user.getText());
    ps.setInt(8, textField_funcao_user); 
    ps.setString(9, fis5.getName());
    ps.setInt(10, local_a_operar); 
    ps.setString(11, id);
    int n = ps.executeUpdate();     
    return n;    
 }else{
    conect = Mysql.getConnection();     
 String query ="UPDATE usuario_tab SET  nome_usuario = ?, prioridade_usuario =?, status_usuario =?, email_usuario =?, user_ID =?, senha_pin_usuario=? , descricao_usuario =?, cod_funcao=?,local_a_operar=?, fechamento_log =0 "
         + "WHERE cod_usuario=?";    
    String id = String.valueOf(tabela.getSelectionModel().getSelectedItem().getCod_user()) ; 
    PreparedStatement ps = conect.prepareStatement(query);
        ps.setString(1, textField_nome_user.getText());  
        ps.setString(2, String.valueOf(combobox_priorid_user)); 
        ps.setBoolean(3,togglebtn_activ_cad_user.isSelected());
        ps.setString(4, textField_email_user.getText());
        ps.setString(5, textField_user_ID.getText());
        ps.setString(6, textField_senha_pin_user);
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
    if(("img_indisponivel.png").equals(fis1_5.getName())){
        } else {
        Files.deleteIfExists(Paths.get("src/co/ao/foto_src/"+ fis1_5.getName()));
        }  
    if(text_src_foto_user!= null) {
    copía_Foto(text_src_foto_user, file_user.getName());    
    setImagem_user(file_user.getName()); 
      }else {
    setImagem_user("User_"+file_user.getName());
       }          
    } catch (ClassCastException| NullPointerException e) {
       alert.setAlertType(Alert.AlertType.ERROR);
       alert.setContentText("Imagem não encontrada"+ e.getMessage());
       alert.show();
        }
    } 


public void eliminar_BD_User(TableView<Usuario> tabela, javafx.scene.image.Image icon_user, File fis1_5){
  alert.setAlertType(Alert.AlertType.CONFIRMATION);
  alert.setContentText("Tem Certeza Que Deseja Eliminar Estes Dados?");
  alert.showAndWait().ifPresent(resposta->{
  Connection con;       
   if(resposta==ButtonType.OK){ 

   try {  
   con = Mysql.getConnection();            
   String SQL = "DELETE FROM usuario_tab WHERE usuario_tab.cod_usuario = "+ tabela.getSelectionModel().getSelectedItem().getCod_user();  
   PreparedStatement ps = con.prepareStatement(SQL);            
        int n = ps.executeUpdate(SQL);
        if(n>0){             
          alert.setAlertType(Alert.AlertType.INFORMATION);
          alert.setContentText("Eliminacao bem sucedida");
          alert.show();
        } else{  alert.setAlertType(Alert.AlertType.ERROR);
          alert.setContentText("eleminação não foi efectuada");
          alert.show();}
        } catch (SQLException e) {
          alert.setAlertType(Alert.AlertType.ERROR);
          alert.setContentText(e.getMessage());
          alert.show();
       }   
   if(!("img_indisponivel.png").equals(getImagem_user()) ){
       try {     
           Files.deleteIfExists(Paths.get("src/co/ao/foto_src/"+ fis1_5.getName()));
       } catch (IOException ex) {
           Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
       }
        }     
    } else{
    alert.setAlertType(Alert.AlertType.INFORMATION);
    alert.setContentText("Eliminacao Cancelada");
    alert.show();
    }  
  });  
  
 }

    
public void ordenadorConsult(int ordendadorEscolhido) throws ClassNotFoundException, SQLException{
     
try {
    String query= ("SELECT cod_usuario, ordenadorDeLogin FROM usuario_tab");
    BD_conect.executaSQL(query);
    while (BD_conect.resultset.next()) {
      int codUser = BD_conect.resultset.getInt(1);
      int ordenadorLogin = BD_conect.resultset.getInt(2);
      if(ordendadorEscolhido < ordenadorLogin){
            ordenadorLogin -= 1;     
   String SQL ="UPDATE usuario_tab SET ordenadorDeLogin =? WHERE cod_usuario=?  ";
   PreparedStatement ps = Mysql.getConnection().prepareStatement(SQL);
   ps.setInt(1,ordenadorLogin);  
   ps.setInt(2,codUser); 
   ps.executeUpdate();     
         }
       }        
    }
    catch (NumberFormatException | SQLException exception) {
        this.alert.setAlertType(Alert.AlertType.ERROR);
        this.alert.setContentText(exception.getMessage());
        this.alert.show();
    }
    this.BD_conect.statement.close();        
}
public int cadastrar_User(TableView<Usuario> tabela, TextField textField_nome_user, int combobox_priorid_user, int combobox_cod_funcao_user, TextField textField_email_user,
TextField textField_user_ID,  String textField_senha_pin_user, String text_src_foto_user, 
ToggleButton togglebtn_activ_cad_user, TextArea textArea_descrcao_user, File fis5, int local_a_operar) throws ClassNotFoundException{
 int n = 0;  
   if("img_indisponivel.png".equals(fis5.getName())){   
           setImagem_user("/img_indisponivel.png");  
     }                                      
   try {    
            conect = Mysql.getConnection();
            Mysql.getDriver();                        
            String SQL = "INSERT INTO usuario_tab (nome_usuario, prioridade_usuario, status_usuario, email_usuario, user_ID, senha_pin_usuario, descricao_usuario,cod_funcao, imagem_usuario, local_a_operar) VALUES (?,?,?,?,?,?,?,?,?,?)";      
            PreparedStatement ps = conect.prepareStatement(SQL);
            ps.setString(1, textField_nome_user.getText());  
            ps.setString(2, String.valueOf(combobox_priorid_user)); 
            ps.setBoolean(3,togglebtn_activ_cad_user.isSelected());
            ps.setString(4, textField_email_user.getText());
            ps.setString(5, textField_user_ID.getText());
            ps.setString(6, textField_senha_pin_user);
            ps.setString(7, textArea_descrcao_user.getText());
            ps.setInt(8, combobox_cod_funcao_user);
            ps.setString(9, fis5.getName());  
            ps.setInt(10, local_a_operar);
        n = ps.executeUpdate();
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

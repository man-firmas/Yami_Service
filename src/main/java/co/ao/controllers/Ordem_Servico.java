package co.ao.controllers;

import co.ao.bd.Mysql;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
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
public class Ordem_Servico extends controller_foto{

private String cod_OrdemServ;
private String nome_categoria;
private String nome_cliente;
private String local_de_execução;
private String relatorio_diag;
private int qnt_itens;
private float total_notafiscal;
private String data_abertura;

private Connection conect;
Alert msg = new Alert(Alert.AlertType.NONE);
public Ordem_Servico(){}; 


public Ordem_Servico(String cod_OrdemServ, String cod_categoria, String nome_cliente, String local_de_execução, String relatorio_diag, int qnt_itens, float total_notafiscal, String data_abertura) {
    this.cod_OrdemServ = cod_OrdemServ;
    this.nome_categoria = cod_categoria;
    this.nome_cliente = nome_cliente;
    this.local_de_execução = local_de_execução;
    this.relatorio_diag = relatorio_diag;
    this.qnt_itens = qnt_itens;
    this.total_notafiscal = total_notafiscal;
    this.data_abertura = data_abertura;
}

    @Override
    public String toString() {
        return "Ordem_Servico{" + "cod_Ordem_Servi\u00e7o=" + cod_OrdemServ + ", cod_categoria=" + nome_categoria + ", nome_cliente=" + nome_cliente + ", local_de_execu\u00e7\u00e3o=" + local_de_execução + ", relatorio_diag=" + relatorio_diag + ", qnt_itens=" + qnt_itens + ", total_notafiscal=" + total_notafiscal + ", data_abertura=" + data_abertura + '}';
    }

    
   public String getCod_OrdemServ() {
        return cod_OrdemServ;
    }

    public void setCod_OrdemServ(String cod_OrdemServ) {
        this.cod_OrdemServ = cod_OrdemServ;
    }

    public String getCod_categoria() {
        return nome_categoria;
    }

    public void setCod_categoria(String cod_categoria) {
        this.nome_categoria = cod_categoria;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getLocal_de_execução() {
        return local_de_execução;
    }

    public void setLocal_de_execução(String local_de_execução) {
        this.local_de_execução = local_de_execução;
    }

    public String getRelatorio_diag() {
        return relatorio_diag;
    }

    public void setRelatorio_diag(String relatorio_diag) {
        this.relatorio_diag = relatorio_diag;
    }

    public int getQnt_itens() {
        return qnt_itens;
    }

    public void setQnt_itens(int qnt_itens) {
        this.qnt_itens = qnt_itens;
    }

    public float getTotal_notafiscal() {
        return total_notafiscal;
    }

    public void setTotal_notafiscal(float total_notafiscal) {
        this.total_notafiscal = total_notafiscal;
    }

    public String getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(String data_abertura) {
        this.data_abertura = data_abertura;
    }

    public Connection getConect() {
        return conect;
    }

    public void setConect(Connection conect) {
        this.conect = conect;
    }

     
 public void setColuna(TableView tabela){
   TableColumn<Ordem_Servico, Integer> colID =
new TableColumn<>("ID");     
        colID.setMinWidth(40);
        colID.setCellValueFactory(
new PropertyValueFactory<>("Cod_Ordem_Serviço"));
        
TableColumn<Ordem_Servico, String> colNome =
new TableColumn("Nome");
colNome.setMinWidth(170);
colNome.setCellValueFactory(
new PropertyValueFactory<>("Cod_categoria"));
   
TableColumn<Ordem_Servico, String> userID =
new TableColumn("User_ID");
userID.setMinWidth(95);
userID.setCellValueFactory(
new PropertyValueFactory<>("User_ID"));

TableColumn<Ordem_Servico, String> Colun_funcao =
new TableColumn("Função");
Colun_funcao.setMinWidth(150);
Colun_funcao.setCellValueFactory(
new PropertyValueFactory<>("Funcao"));

TableColumn<Ordem_Servico, String> extorno =
new TableColumn("Prioridade");
extorno.setMinWidth(150);
extorno.setCellValueFactory(
new PropertyValueFactory<>("Prioridade"));

TableColumn<Ordem_Servico, String> status_user =
new TableColumn("Status");
status_user.setMinWidth(40);
status_user.setCellValueFactory(
new PropertyValueFactory<>("Status"));
tabela.getColumns().addAll(colID, colNome, userID, Colun_funcao, extorno, status_user);     
   }
 
@SuppressWarnings("IncompatibleEquals")
public int actualizar_OrdemServico(TableView<Ordem_Servico> tabela, TextField textField_nome_user, int combobox_priorid_user, TextField textField_email_user,
TextField textField_user_ID, TextField textField_senha_pin_user, String text_src_foto_user, ToggleButton togglebtn_activ_cad_user,
TextArea textArea_descrcao_user, int textField_funcao_user, javafx.scene.image.Image icon5, File fis5, int local_a_operar ) throws ClassNotFoundException, SQLException, IOException{  
if(!"img_indisponivel.png".equals(fis5.getName()) && fis5.getName() != null ){
    conect = Mysql.getConnection();     
 String query ="UPDATE usuario_tab SET  nome_usuario = ?, prioridade_usuario =?, status_usuario =?, email_usuario =?, user_ID =?, senha_pin_usuario=? , descricao_usuario =?, cod_funcao=?, imagem_usuario =?, local_a_operar =? "
         + "WHERE cod_usuario=?";
 String id = String.valueOf(tabela.getSelectionModel().getSelectedItem().getCod_OrdemServ()) ; 
    PreparedStatement ps = conect.prepareStatement(query);
    ps.setString(1, textField_nome_user.getText());  
    ps.setString(2, String.valueOf(combobox_priorid_user)); 
    ps.setBoolean(3,togglebtn_activ_cad_user.isSelected());
    ps.setString(4, textField_email_user.getText());
    ps.setString(5, textField_user_ID.getText());
    ps.setString(6, textField_senha_pin_user.getText());
    ps.setString(7, textArea_descrcao_user.getText());
    ps.setInt(8, textField_funcao_user); 
    ps.setInt(10, local_a_operar); 
    ps.setString(11, id);
    int n = ps.executeUpdate();     
    return n;
       
 }else{
    conect = Mysql.getConnection();     
 String query ="UPDATE usuario_tab SET  nome_usuario = ?, prioridade_usuario =?, status_usuario =?, email_usuario =?, user_ID =?, senha_pin_usuario=? , descricao_usuario =?, cod_funcao=?,local_a_operar=?, fechamento_log =0 "
         + "WHERE cod_usuario=?";    
    String id = String.valueOf(tabela.getSelectionModel().getSelectedItem().getCod_OrdemServ()) ; 
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
 //   copía_Foto(text_src_foto_user, file_user.getName());    
   // setImagem_user(file_user.getName()); 
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

public void eliminar_BD_User(TableView<Ordem_Servico> tabela, javafx.scene.image.Image icon_user, File fis1_5){
  // msg.start("Atenção", "Tem Certeza que Deseja Eliminar este Item na Base de Dado?","Sim","Não");
   boolean yes = true ;//msg.btnYesClicked;
   Connection con;       
    if(yes ==true){     
        try {
            con = Mysql.getConnection();
            String SQL = "DELETE FROM usuario_tab WHERE usuario_tab.cod_usuario = "+ tabela.getSelectionModel().getSelectedItem().getCod_OrdemServ();
            PreparedStatement ps = con.prepareStatement(SQL);
            int n = ps.executeUpdate(SQL);
            if(n>0){
                reset_foto(icon_user);
            }
        } catch (SQLException e) {
            //  msg.start("ERRO",  "Erro na eliminacao de registo "+ e, "Ok", "");
        }        
        // msg.start("SUCESSO", "Eliminacao bem sucedida", "Ok", ""); 
     
     } else{
 //     msg.start("ERRO", "Eliminacao negada", "Ok", "");
     } 
   }

public int cadastrar_OrdemServico( TextField referencia_equipamento, ComboBox nome_categoria, TextField nome_cliente, ComboBox combobox_localExecucao, TextArea relatorio_diagnostico,
int qnt_totalItens, String DataVenda, int cod_tecnicoOS){
 int n = 0;  
    if ("".equals(referencia_equipamento.getText())) {  
        msg.setAlertType(Alert.AlertType.ERROR);
        msg.setContentText("Campo Obrigatorio, Mencione uma referencia para Equipamento !!!");
        msg.show();
                } else {
                    if (combobox_localExecucao.getSelectionModel().isEmpty()) {     
             msg.setAlertType(Alert.AlertType.ERROR);
             msg.setContentText("Campo Obrigatorio, Selecione o Local de Execução");
             msg.show();
                    } else {
                        if (!"".equals(nome_cliente.getText()) ) {                            
                 msg.setAlertType(Alert.AlertType.ERROR);
                 msg.setContentText("Campo Obrigatorio, O nome do Cliente");
                 msg.show();                                   
                        } else {
                                if ( qnt_totalItens ==0) {                            
               msg.setAlertType(Alert.AlertType.ERROR);
               msg.setContentText("Campo Obrigatorio, Define uma quantidade");
               msg.show();                                   
                        } else {    
   try {       
            conect = Mysql.getConnection();
            Mysql.getDriver();            
            String SQL = "INSERT INTO ordemdeserviço_tab (referencia_equipamento, noem_Categoria, nome_cliente, local_de_execucao, relatorio_diagnostico, qnt_totalItens, data_venda, cod_tecnicoOS) VALUES (?,?,?,?,?,?,?)";      
            PreparedStatement ps = conect.prepareStatement(SQL);
            ps.setString(1, referencia_equipamento.getText()); 
            ps.setString(2, nome_categoria.getSelectionModel().getSelectedItem().toString());
            ps.setString(3, nome_cliente.getText() ); 
            ps.setString(4,combobox_localExecucao.getSelectionModel().getSelectedItem().toString());
            ps.setString(5,relatorio_diagnostico.getText());
            ps.setInt(6, qnt_totalItens);
           if(DataVenda ==null){ps.setDate(7, null);}
           else {ps.setString(7,DataVenda );}
            ps.setInt(8, cod_tecnicoOS);

        n = ps.executeUpdate();
   if (n > 0) {                                           
         
      } 
   
   }
        catch (SQLException ex ) {
      
            System.out.println(ex.getMessage());
            
        }     
                                    }      
                                  }   
                            }
    }
    return n;
   }
}

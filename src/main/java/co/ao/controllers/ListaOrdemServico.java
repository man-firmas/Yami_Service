package co.ao.controllers;

import co.ao.bd.Mysql;
import co.ao.yami_service.Tela_principalController;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
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
public class ListaOrdemServico extends controller_foto{

private int cod_ListaOrdemServic;
private String nome_categoria;
private String descricao_item;
private int qnt_item;
private float preco_unit;
private float montante_listaOrdem;
private String tipo_de_item;
private String serie_produto;
private int cod_OrdemDeServic;
private  String fontAwesame;
private int ItemPago; 
private Connection conect;
 
Alert msg = new Alert(Alert.AlertType.NONE);
public ListaOrdemServico(){}; 

    public ListaOrdemServico(int cod_ListaOrdemServic,  String nome_categoria, String descricao_item , int cod_OrdemDeServic,  int qnt_item, float preco_unit, float montante_listaOrdem, String tipo_de_item, String serie_produto, int ItemPago) {
        this.cod_ListaOrdemServic = cod_ListaOrdemServic;
        this.nome_categoria = nome_categoria;
        this.descricao_item = descricao_item;
         this.cod_OrdemDeServic = cod_OrdemDeServic;
        this.qnt_item = qnt_item;
        this.preco_unit = preco_unit;
        this.montante_listaOrdem = montante_listaOrdem;
        this.tipo_de_item = tipo_de_item;
        this.serie_produto = serie_produto;
        this.ItemPago = ItemPago;
    }

    @Override
    public String toString() {
        return "ListaOrdemServico{" + "cod_ListaOrdemServic=" + cod_ListaOrdemServic + ", nome_categoria=" + nome_categoria + ", descricao_item=" + descricao_item + ", qnt_item=" + qnt_item + ", preco_unit=" + preco_unit + ", montante_listaOrdem=" + montante_listaOrdem + ", tipo_de_item=" + tipo_de_item + ", serie_produto=" + serie_produto + ", cod_OrdemDeServic=" + cod_OrdemDeServic + ", fontAwesame=" + fontAwesame + ", ItemPago=" + ItemPago + ", conect=" + conect + '}';
    }



 public int isItemPago() {
        return ItemPago;
    }

    public void setItemPago(int ItemPago) {
        this.ItemPago = ItemPago;
    }
     public String getFontAwesame() {
        return fontAwesame;
    }

    public void setFontAwesame(String fontAwesame) {
        this.fontAwesame = fontAwesame;
    }
    
    public int getCod_ListaOrdemServic() {
        return cod_ListaOrdemServic;
    }

    public void setCod_ListaOrdemServic(int cod_ListaOrdemServic) {
        this.cod_ListaOrdemServic = cod_ListaOrdemServic;
    }

    public String getNome_categoria() {
        return nome_categoria;
    }

    public void setNome_categoria(String nome_categoria) {
        this.nome_categoria = nome_categoria;
    }

    public String getDescricao_item() {
        return descricao_item;
    }

    public void setDescricao_item(String descricao_item) {
        this.descricao_item = descricao_item;
    }

    public int getCod_OrdemDeServic() {
        return cod_OrdemDeServic;
    }

    public void setCod_OrdemDeServic(int cod_OrdemDeServic) {
        this.cod_OrdemDeServic = cod_OrdemDeServic;
    }

    public int getQnt_item() {
        return qnt_item;
    }

    public void setQnt_item(int qnt_item) {
        this.qnt_item = qnt_item;
    }

    public float getPreco_unit() {
        return preco_unit;
    }

    public void setPreco_unit(float preco_unit) {
        this.preco_unit = preco_unit;
    }

    public float getMontante_listaOrdem() {
        return montante_listaOrdem;
    }

    public void setMontante_listaOrdem(float montante_listaOrdem) {
        this.montante_listaOrdem = montante_listaOrdem;
    }

    public String getTipo_de_item() {
        return tipo_de_item;
    }

    public void setTipo_de_item(String tipo_de_item) {
        this.tipo_de_item = tipo_de_item;
    }

    public Connection getConect() {
        return conect;
    }

    public void setConect(Connection conect) {
        this.conect = conect;
    }

    public String getSerie_produto() {
        return serie_produto;
    }

    public void setSerie_produto(String serie_produto) {
        this.serie_produto = serie_produto;
    }

   
     
 public void setColuna(TableView tabela){
   TableColumn<ListaOrdemServico, Integer> colID =
new TableColumn<>("ID");     
        colID.setMinWidth(30);
        colID.setCellValueFactory(
new PropertyValueFactory<>("Cod_ListaOrdemServic"));
        
TableColumn<ListaOrdemServico, String> colNome =
new TableColumn("Descrição");
colNome.setMinWidth(200);
colNome.setCellValueFactory(
new PropertyValueFactory<>("Descricao_item"));

TableColumn<ListaOrdemServico, String> colPrecoUnit =
new TableColumn("Preço Unit.");
colPrecoUnit.setMinWidth(140);
colPrecoUnit.setCellValueFactory(
new PropertyValueFactory<>("Preco_unit"));

TableColumn<ListaOrdemServico, String> userQnt =
new TableColumn("Qnt");
userQnt.setMinWidth(95);
userQnt.setCellValueFactory(
new PropertyValueFactory<>("Qnt_item"));

TableColumn<ListaOrdemServico, String> Colun_Montante =
new TableColumn("Montante");
Colun_Montante.setMinWidth(150);
Colun_Montante.setCellValueFactory(
new PropertyValueFactory<>("Montante_listaOrdem"));

TableColumn<ListaOrdemServico, String> Colun_categoria =
new TableColumn("Categoria");
Colun_categoria.setMinWidth(150);
Colun_categoria.setCellValueFactory(
new PropertyValueFactory<>("Nome_categoria"));

TableColumn<ListaOrdemServico, String> Colun_serieProduto=
new TableColumn("Serie");
Colun_serieProduto.setMinWidth(150);
Colun_serieProduto.setCellValueFactory(
new PropertyValueFactory<>("Serie_produto"));

TableColumn<ListaOrdemServico, String> Colum_tipo =
new TableColumn("Tipo");
Colum_tipo.setMinWidth(150);
Colum_tipo.setCellValueFactory(
new PropertyValueFactory<>("Tipo_de_item"));

tabela.getColumns().addAll(colID, colNome, Colun_categoria,Colun_serieProduto, Colum_tipo,colPrecoUnit, userQnt, Colun_Montante);     
   }
 
@SuppressWarnings("IncompatibleEquals")
public int actualizar_User(TableView<ListaOrdemServico> tabela, TextField textField_nome_user, int combobox_priorid_user, TextField textField_email_user,
TextField textField_user_ID, TextField textField_senha_pin_user, String text_src_foto_user, ToggleButton togglebtn_activ_cad_user,
TextArea textArea_descrcao_user, int textField_funcao_user, javafx.scene.image.Image icon5, File fis5, int local_a_operar ) throws ClassNotFoundException, SQLException, IOException{  
if(!"img_indisponivel.png".equals(fis5.getName()) && fis5.getName() != null ){
    conect = Mysql.getConnection();     
 String query ="UPDATE usuario_tab SET  nome_usuario = ?, prioridade_usuario =?, status_usuario =?, email_usuario =?, user_ID =?, senha_pin_usuario=? , descricao_usuario =?, cod_funcao=?, imagem_usuario =?, local_a_operar =? "
         + "WHERE cod_usuario=?";
 String id = String.valueOf(tabela.getSelectionModel().getSelectedItem().getCod_ListaOrdemServic()) ; 
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
    String id = String.valueOf(tabela.getSelectionModel().getSelectedItem().getCod_ListaOrdemServic()) ; 
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


public void eliminar_BD_User(TableView<ListaOrdemServico> tabela, javafx.scene.image.Image icon_user, File fis1_5){
  // msg.start("Atenção", "Tem Certeza que Deseja Eliminar este Item na Base de Dado?","Sim","Não");
   boolean yes = true ;//msg.btnYesClicked;
   Connection con;       
    if(yes ==true){     
        try {
            con = Mysql.getConnection();
            String SQL = "DELETE FROM usuario_tab WHERE usuario_tab.cod_usuario = "+ tabela.getSelectionModel().getSelectedItem().getCod_ListaOrdemServic();
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

@SuppressWarnings("IncompatibleEquals")
public int inserir_listaOS(int combobox_categoria_servic, ComboBox combobox_servic,
          float precoUnit, int cod_OrdemdeServico, Spinner Spinner_qntItem, String cod_tipoProduto,
          ComboBox combobox_serie, int cod_ItemAvenda){
 int n = 0;  
    if ("".equals(combobox_categoria_servic)) {
        msg.setAlertType(Alert.AlertType.ERROR);
        msg.setContentText("Campo Obrigatorio, selecione uma categoria...");
        msg.show();
   } else {
       if (combobox_servic.getSelectionModel().isEmpty()) {
        msg.setAlertType(Alert.AlertType.ERROR);
        msg.setContentText( "Campo Obrigatorio, selecione um Serviço");
        msg.show();
       } else { 
                    if( "".equals(Spinner_qntItem.getValue().toString()) ){             
        msg.setAlertType(Alert.AlertType.ERROR);
        msg.setContentText("Campo Obrigatorio, selecione uma Qnt.");
        msg.show();
            }                                    
             else{                            
   try {    
    conect = Mysql.getConnection();
    Mysql.getDriver();       
        String SQL = "INSERT INTO listarordemservico_tab (cod_categoria, descricao_produto, cod_OrdemDeServic, qnt_item, preco_unit, tipo_produto, serie_produtoOS, cod_ItemAvenda,ItemPago) VALUES (?,?,?,?,?,?,?,?,?)";      
        PreparedStatement ps = conect.prepareStatement(SQL);
        ps.setInt(1,combobox_categoria_servic); 
        ps.setString(2,combobox_servic.getSelectionModel().getSelectedItem().toString());        
        ps.setInt(3, cod_OrdemdeServico); 
        ps.setInt(4, Integer.parseInt(Spinner_qntItem.getValue().toString())); 
        ps.setFloat(5,precoUnit); 
        ps.setString(6, cod_tipoProduto);
        ps.setString(7, combobox_serie.getSelectionModel().getSelectedItem().toString()); 
        ps.setInt(8,cod_ItemAvenda); 
        ps.setInt(9,0); 
    n = ps.executeUpdate();
     
        } catch (SQLException ex ) {
        msg.setAlertType(Alert.AlertType.ERROR);
        msg.setContentText(ex.getMessage());
        msg.show();
        }     
                        }   
                      }    
                }
                                  
    return n;
}

  
}

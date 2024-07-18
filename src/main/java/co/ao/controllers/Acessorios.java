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
public class Acessorios extends controller_foto{

private int cod_acessorios;
private String nome_acessorio;
private String cod_categoria;
private String cod_Serie;
private String cod_barra;
private String descricao_acessorio;
private String imagem_acessorio;
private String fornecedor;
private boolean status_acessorio;
private float precCompraAcess;
private float precVendaAcess;
private Connection conect;
NumberFormat f = NumberFormat.getCurrencyInstance();
  Alert msg = new Alert(Alert.AlertType.NONE);
public Acessorios(){}; 

    public Acessorios(int cod_acessorios, String nome_acessorio, String cod_categoria,String cod_Serie, String cod_barra, String descricao_acessorio, String imagem_acessorio, String fornecedor, boolean status_acessorio, float precCompraAcess, float precVendaAcess) {
        this.cod_acessorios = cod_acessorios;
        this.nome_acessorio = nome_acessorio;
        this.cod_categoria = cod_categoria;
         this.cod_Serie = cod_Serie;
        this.cod_barra = cod_barra;
        this.descricao_acessorio = descricao_acessorio;
        this.imagem_acessorio = imagem_acessorio;
        this.fornecedor = fornecedor;
        this.status_acessorio = status_acessorio;
        this.precCompraAcess = precCompraAcess;
        this.precVendaAcess = precVendaAcess;
    }

    public String getCod_Serie() {
        return cod_Serie;
    }

    public void setCod_Serie(String cod_Serie) {
        this.cod_Serie = cod_Serie;
    }

    public float getPrecCompraAcess() {
        return precCompraAcess;
    }

    public void setPrecCompraAcess(float precCompraAcess) {
        this.precCompraAcess = precCompraAcess;
    }

    public float getPrecVendaAcess() {
        return precVendaAcess;
    }

    public void setPrecVendaAcess(float precVendaAcess) {
        this.precVendaAcess = precVendaAcess;
    }

    public int getCod_acessorios() {
        return cod_acessorios;
    }

    public void setCod_acessorios(int cod_acessorios) {
        this.cod_acessorios = cod_acessorios;
    }

    public String getNome_acessorio() {
        return nome_acessorio;
    }

    public void setNome_acessorio(String nome_acessorio) {
        this.nome_acessorio = nome_acessorio;
    }

    public String getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(String cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public String getCod_barra() {
        return cod_barra;
    }

    public void setCod_barra(String cod_barra) {
        this.cod_barra = cod_barra;
    }

  
    public String getDescricao_acessorio() {
        return descricao_acessorio;
    }

    public void setDescricao_acessorio(String descricao_acessorio) {
        this.descricao_acessorio = descricao_acessorio;
    }


    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public boolean isStatus_acessorio() {
        return status_acessorio;
    }

    public void setStatus_acessorio(boolean status_acessorio) {
        this.status_acessorio = status_acessorio;
    }
 
 public String getImagem_acessorio() {
        return imagem_acessorio;
    }

    public void setImagem_acessorio(String imagem_acessorio) {
        this.imagem_acessorio = imagem_acessorio;
    }
   
  public void copía_Foto (String src, String nome){
     if(nome.length()<45){
      try {       
          Path original = Paths.get(src); 
          Path caminho_copia = Paths.get("src/co/ao/foto_src/"+nome);
          Files.copy(original, caminho_copia);
      } catch (IOException | NullPointerException ex) {
          msg.setAlertType(Alert.AlertType.ERROR);
          msg.setContentText("Erro ao quardar imagem na pasta src");
          msg.show();
      }
    }  else{
      setImagem_acessorio("/img_indisponivel.png"); 
       msg.setAlertType(Alert.AlertType.ERROR);
       msg.setContentText("Nome de Imagem Muito extensa!");
       msg.show();
     }
  }

 public void setColuna(TableView tabela){
   TableColumn<ListaOrdemServico, Integer> colID =
new TableColumn<>("ID");     
        colID.setMinWidth(30);
        colID.setCellValueFactory(
new PropertyValueFactory<>("Cod_acessorios"));
        
TableColumn<ListaOrdemServico, String> colNome =
new TableColumn("Descrição");
colNome.setMinWidth(200);
colNome.setCellValueFactory(
new PropertyValueFactory<>("Nome_acessorio"));

TableColumn<ListaOrdemServico, String> colPrecoUnit =
new TableColumn("Preço Unit.");
colPrecoUnit.setMinWidth(140);
colPrecoUnit.setCellValueFactory(
new PropertyValueFactory<>("PrecVendaAcess"));

TableColumn<ListaOrdemServico, String> userQnt =
new TableColumn("Preço Comp.");
userQnt.setMinWidth(95);
userQnt.setCellValueFactory(
new PropertyValueFactory<>("PrecCompraAcess"));

TableColumn<ListaOrdemServico, String> Colun_Montante =
new TableColumn("Categoria");
Colun_Montante.setMinWidth(150);
Colun_Montante.setCellValueFactory(
new PropertyValueFactory<>("Cod_categoria"));

TableColumn<ListaOrdemServico, String> Colun_categoria =
new TableColumn("Categoria");
Colun_categoria.setMinWidth(150);
Colun_categoria.setCellValueFactory(
new PropertyValueFactory<>("Cod_categoria"));

TableColumn<ListaOrdemServico, String> Colun_serieProduto=
new TableColumn("Serie");
Colun_serieProduto.setMinWidth(150);
Colun_serieProduto.setCellValueFactory(
new PropertyValueFactory<>("Cod_Serie"));

TableColumn<ListaOrdemServico, String> Colum_tipo =
new TableColumn("Fornecedor");
Colum_tipo.setMinWidth(150);
Colum_tipo.setCellValueFactory(
new PropertyValueFactory<>("Fornecedor"));

tabela.getColumns().addAll(colID, colNome, Colun_categoria,Colun_serieProduto, Colum_tipo,colPrecoUnit, userQnt, Colun_Montante);     
   }  
 
@SuppressWarnings("IncompatibleEquals")
public int actualizar_Acess(TableView<Acessorios> tabela, TextField textField_nomeAcess, int combobox_categ_acess, TextField TextField_codBarra, 
int combobox_codSerie, TextField textField_precCompraAcess, 
TextField textField_precVendaAcess, TextArea textA_descriçãoAcess,TextField TextField_fornecedor,
ToggleButton togglebtn_activ_cadAcess, String combobox_IdentifcadorAcess, File fis4) throws ClassNotFoundException, SQLException, IOException, ParseException{  
     Number myNumber1 = f.parse(textField_precCompraAcess.getText());
     Number myNumber2 = f.parse(textField_precVendaAcess.getText());  
  
    if(!"img_indisponivel.png".equals(fis4.getName()) && fis4.getName() != null ){
      
    conect = Mysql.getConnection();     
 String query ="UPDATE acessorios_tab SET  nome_acessorio = ?, cod_categoria = ?,cod_barra =?,preco_unit =?, preco_compra=?, descricao_acessorio=? , fornecedor =?, imagem_acessorio =?, status_acessorios =?, serie_acessorio=?, cod_identificador=?"
         + "WHERE cod_acessorio=?";
 int id = tabela.getSelectionModel().getSelectedItem().getCod_acessorios() ; 
            PreparedStatement ps = conect.prepareStatement(query);
            ps.setString(1, textField_nomeAcess.getText());  
            ps.setInt(2, combobox_categ_acess);
            ps.setString(3, TextField_codBarra.getText());           
            ps.setInt(4, Integer.valueOf(myNumber1.toString()));
            ps.setInt(5, Integer.valueOf(myNumber2.toString()));
            ps.setString(6, textA_descriçãoAcess.getText());
            ps.setString(7, TextField_fornecedor.getText());    
            ps.setString(8, fis4.getName());   
            ps.setBoolean(9, togglebtn_activ_cadAcess.isSelected());
            ps.setInt(10, combobox_codSerie);
            ps.setString(11, combobox_IdentifcadorAcess );    
            ps.setInt(12,id); 
        int n = ps.executeUpdate(); 

    return n;
       
 }else{
    conect = Mysql.getConnection();     
 String query ="UPDATE acessorios_tab SET  nome_acessorio = ?, cod_categoria = ?,cod_barra =?,preco_unit =?, preco_compra=?, descricao_acessorio=? , fornecedor =?, status_acessorios =?, serie_acessorio=?, cod_identificador=?"
            + "WHERE cod_cliente=?";
 String id = String.valueOf(tabela.getSelectionModel().getSelectedItem().getCod_acessorios()) ; 
            PreparedStatement ps = conect.prepareStatement(query);
            ps.setString(1, textField_nomeAcess.getText());  
            ps.setInt(2, combobox_categ_acess);
            ps.setString(3, TextField_codBarra.getText());           
            ps.setInt(4, Integer.valueOf(myNumber1.toString()));
            ps.setInt(5, Integer.valueOf(myNumber2.toString()));
            ps.setString(6, textA_descriçãoAcess.getText());
            ps.setString(7, TextField_fornecedor.getText());              
            ps.setBoolean(8, togglebtn_activ_cadAcess.isSelected());
            ps.setInt(9, combobox_codSerie);
            ps.setString(10, combobox_IdentifcadorAcess);    
            ps.setString(11, id); 
    int n = ps.executeUpdate();     
    return n; 
      }      
   }

@SuppressWarnings("UnusedAssignment")
public void actulizar_foto_Acess(String text_src_foto_acess, File fis4, File fis1_4) throws IOException{  
try {
    if(("img_indisponivel.png").equals(fis1_4.getName())){
        } else {
        Files.deleteIfExists(Paths.get("src/co/ao/foto_src/"+ fis1_4.getName()));
        }  
    if(text_src_foto_acess!= null) {
    copía_Foto(text_src_foto_acess, fis4.getName());    
    setImagem_acessorio(fis4.getName()); 
      }else {
    setImagem_acessorio("Acess_"+fis4.getName());
       }          
    } catch (ClassCastException| NullPointerException e) {
       msg.setAlertType(Alert.AlertType.ERROR);
       msg.setContentText("Imagem não encontrada"+ e.getMessage());
       msg.show();
        }
} 

public void eliminar_CadAcessorio(TableView<Acessorios> tabela, javafx.scene.image.Image icon_acessorio, File fis1_4){
   msg.setAlertType(Alert.AlertType.CONFIRMATION);
   msg.setContentText("Tem Certeza Que Deseja Eliminar Estes Dados?");
   msg.showAndWait().ifPresent(resposta->{
   Connection con;       
    if(resposta==ButtonType.OK){      
   try {     
       
   con = Mysql.getConnection();            
   String SQL = "DELETE FROM acessorios_tab WHERE acessorios_tab.cod_acessorio = "+ tabela.getSelectionModel().getSelectedItem().getCod_acessorios();  
   PreparedStatement ps = con.prepareStatement(SQL);            
        int n = ps.executeUpdate(SQL);
        if(n>0){             
          msg.setAlertType(Alert.AlertType.INFORMATION);
          msg.setContentText("Eliminacao bem sucedida");
          msg.show();
        }
        } catch (SQLException e) {
            msg.setAlertType(Alert.AlertType.ERROR);
            msg.setContentText(e.getMessage());
            msg.show();
       }                if(!("img_indisponivel.png").equals(getImagem_acessorio()) ){
       try {     
           Files.deleteIfExists(Paths.get("src/co/ao/foto_src/"+ fis1_4.getName()));
       } catch (IOException ex) {
           Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
       }
        }     
     } else{
         msg.setAlertType(Alert.AlertType.INFORMATION);
         msg.setContentText("Eliminacao Cancelada");
         msg.show();
     }  
   });     
   }

public int cadastrar_Acessorio(TextField textField_nomeAcess, int combobox_categ_acess, TextField TextField_codBarra, 
            int combobox_codSerie, TextField textField_precCompraAcess, TextField textField_precVendaAcess, 
TextArea textA_descriçãoAcess,TextField textField_FornecAcess, String imageView_cadaAcess,
ToggleButton togglebtn_activ_cadAcess, File fis4) throws ParseException, ClassNotFoundException{
 int n = 0;  
     Number myNumber1 = f.parse(textField_precCompraAcess.getText());
     Number myNumber2 = f.parse(textField_precVendaAcess.getText());                                
   if("img_indisponivel.png".equals(fis4.getName())){   
           setImagem_acessorio("/img_indisponivel.png");  
     }                                      
   try {    
            conect = Mysql.getConnection();
            Mysql.getDriver();            
            String SQL = "INSERT INTO acessorios_tab (nome_acessorio, cod_categoria, cod_barra, preco_unit, preco_compra, descricao_acessorio, fornecedor, imagem_acessorio, status_acessorios, serie_acessorio) VALUES (?,?,?,?,?,?,?,?,?,?)";      
            PreparedStatement ps = conect.prepareStatement(SQL);
            ps.setString(1, textField_nomeAcess.getText());  
            ps.setInt(2, combobox_categ_acess);
            ps.setString(3, TextField_codBarra.getText() );           
            ps.setInt(4, Integer.valueOf(myNumber1.toString()));
            ps.setInt(5, Integer.valueOf(myNumber2.toString()));
            ps.setString(6, textA_descriçãoAcess.getText());
            ps.setString(7, textField_FornecAcess.getText()); 
            ps.setString(8,  fis4.getName());              
            ps.setBoolean(9, togglebtn_activ_cadAcess.isSelected());
            ps.setInt(10, combobox_codSerie);        
            n = ps.executeUpdate();
        if (n > 0) {    
            
           msg.setAlertType(Alert.AlertType.INFORMATION);
           msg.setContentText("Dados de Âcessório Quardado com Sucesso !!!");
           msg.show();
     }  
  }
  catch (SQLException | NumberFormatException ex ) {  
      msg.setAlertType(Alert.AlertType.ERROR);
      msg.setContentText(ex.getMessage());
      msg.show();
    }                               
     return n;                          
    } 
  
}

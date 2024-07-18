package co.ao.controllers;

import co.ao.bd.Mysql;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 *
 * @author firmi
 */
public class Pagamento {   
private int cod_pagamento; 
private int cod_cliente;
private int cod_modoPagameto;
private int cod_doOperador;
private int descontoClinte;
private int qnt_itensVendido;
private float ValorTotal;
private Date data_venda;
private int cod_abertura;

private Mysql BD_conect = new Mysql();
Connection conect;
MessageConfirmBox comfirBox= new MessageConfirmBox() ;
public Pagamento(){}; 

    public Pagamento(int cod_vendas, int cod_cliente, int cod_modoPagameto, int cod_doOperador, int descontoClinte, int qnt_itensVendido, float ValorTotal, Date data_venda, int cod_abertura) {
        this.cod_pagamento = cod_vendas;
        this.cod_cliente = cod_cliente;
        this.cod_modoPagameto = cod_modoPagameto;
        this.cod_doOperador = cod_doOperador;
        this.descontoClinte = descontoClinte;
        this.qnt_itensVendido = qnt_itensVendido;
        this.ValorTotal = ValorTotal;
        this.data_venda = data_venda;
        this.cod_abertura= cod_abertura;
    }

    @Override
    public String toString() {
        return "Venda{" + "cod_vendas=" + cod_pagamento + ", cod_cliente=" + cod_cliente + ", cod_modoPagameto=" + cod_modoPagameto + ", cod_doOperador=" + cod_doOperador + ", descontoClinte=" + descontoClinte + ", qnt_itensVendido=" + qnt_itensVendido + ", ValorTotal=" + ValorTotal + ", data_venda=" + data_venda + ", cod_abertura=" + cod_abertura + ", BD_conect=" + BD_conect + '}';
    }

    public int getCod_abertura() {
        return cod_abertura;
    }

    public void setCod_abertura(int cod_abertura) {
        this.cod_abertura = cod_abertura;
    }

    public int getCod_pagamento() {
        return cod_pagamento;
    }

    public void setCod_pagamento(int cod_pagamento) {
        this.cod_pagamento = cod_pagamento;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getCod_modoPagameto() {
        return cod_modoPagameto;
    }

    public void setCod_modoPagameto(int cod_modoPagameto) {
        this.cod_modoPagameto = cod_modoPagameto;
    }

    public int getCod_doOperador() {
        return cod_doOperador;
    }

    public void setCod_doOperador(int cod_doOperador) {
        this.cod_doOperador = cod_doOperador;
    }

    public int getDescontoClinte() {
        return descontoClinte;
    }

    public void setDescontoClinte(int descontoClinte) {
        this.descontoClinte = descontoClinte;
    }

    public int getQnt_itensVendido() {
        return qnt_itensVendido;
    }

    public void setQnt_itensVendido(int qnt_itensVendido) {
        this.qnt_itensVendido = qnt_itensVendido;
    }

    public float getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(float ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public Mysql getBD_conect() {
        return BD_conect;
    }

    public void setBD_conect(Mysql BD_conect) {
        this.BD_conect = BD_conect;
    }

    public MessageConfirmBox getComfirBox() {
        return comfirBox;
    }

    public void setComfirBox(MessageConfirmBox comfirBox) {
        this.comfirBox = comfirBox;
    }

 public void setColuna(TableView tabela){
   TableColumn<Pagamento, Integer> Colum_NumItemVenda =
    new TableColumn<>("Nº");     
    Colum_NumItemVenda.setMinWidth(5);
    Colum_NumItemVenda.setCellValueFactory(
    new PropertyValueFactory<>("NumItemVenda"));
     
    TableColumn<Pagamento, Integer> colID =
    new TableColumn<>("ID");     
    colID.setMinWidth(20);
    colID.setCellValueFactory(
    new PropertyValueFactory<>("Cod_vendas"));

    TableColumn<Pagamento, String> Colum_nomeProd =
    new TableColumn("Descrição");
    Colum_nomeProd.setMinWidth(190);
    Colum_nomeProd.setCellValueFactory(
    new PropertyValueFactory<>("Cod_prod_vendas"));

        TableColumn<Pagamento, String> Colum_unid =
    new TableColumn("Unid");
    Colum_unid.setMinWidth(80);
    Colum_unid.setCellValueFactory(
    new PropertyValueFactory<>("Unid_vendas"));    
        
    TableColumn<Pagamento, String> Colum_precUnit =
    new TableColumn("Preço Unid");
    Colum_precUnit.setMinWidth(130);
    Colum_precUnit.setCellValueFactory(
    new PropertyValueFactory<>("PrecoUnit_vendas"));

    TableColumn<Pagamento, String> Colum_qnt =
    new TableColumn("Qnt.");
    Colum_qnt.setMinWidth(50);
    Colum_qnt.setCellValueFactory(
    new PropertyValueFactory<>("Qnt_prod_vendas"));

    TableColumn<Pagamento, String> Colum_total =
    new TableColumn("Total");
    Colum_total.setMinWidth(90);
    Colum_total.setCellValueFactory(
    new PropertyValueFactory<>("Total_vendas"));

tabela.getColumns().addAll(Colum_NumItemVenda, colID, Colum_nomeProd, Colum_unid, Colum_precUnit, Colum_qnt, Colum_total);     
   }
 
@SuppressWarnings("IncompatibleEquals")
public int actualizar_Vendas(TableView<Pagamento> tabela, int combobox_modo_venda,int cod_barra_vendas, 
        int unid_vendas, int cod_prod_vendas,int precoUnit_vendas) throws ClassNotFoundException, SQLException, IOException{  

 conect = Mysql.getConnection();     
 String query ="UPDATE vendas_tab SET  cod_cliente = ?, cod_modoPagameto = ?, cod_doOperador =?, descontoClinte =?, qnt_itensVendido =?, ValorTotal=? , data_venda=? "
         + "WHERE cod_vendas=?";
 String id = String.valueOf(tabela.getSelectionModel().getSelectedItem().getCod_pagamento()) ; 
        PreparedStatement ps = conect.prepareStatement(query);
        ps.setInt(1,getCod_cliente());
        ps.setInt(2,getCod_modoPagameto());
        ps.setInt(3,getCod_doOperador());
        ps.setInt(4,getDescontoClinte());
        ps.setInt(5, getQnt_itensVendido());
        ps.setFloat(6, getValorTotal());
        ps.setDate(7, (java.sql.Date) getData_venda());           
        ps.setString(8, id);            
    int n = ps.executeUpdate();      
    return n;    
   }

public void eliminar_BD_Vendas(TableView<Pagamento> tabela){
    comfirBox.start("Atenção", "Tem certeza que deseja eliminar este Item na Base de Dado?","Sim","Não");
  boolean yes = comfirBox.btnYesClicked;
   Connection con;       
    if(yes ==true){        
    try {
        con = Mysql.getConnection();
        String SQL = "DELETE FROM listadevendas_tab WHERE listadevendas_tab.cod_vendas = "+ tabela.getSelectionModel().getSelectedItem().getCod_pagamento();
        PreparedStatement ps = con.prepareStatement(SQL);
        int n = ps.executeUpdate(SQL);
    if(n>0){            
     comfirBox.start("REMOVER", "Eliminacao bem sucedida","Ok","");
        }
        } catch (SQLException e) {
     comfirBox.start("REMOVER","Erro na eliminacao de registo ","Ok",""+ e);
        }
    } else{
      comfirBox.start("REMOVER", "Eliminacao negada","Ok","");
     } 
   }
public void eliminarTudo_BD_Vendas(int VarCod_docVendas){
       comfirBox.start("Atenção", "Tem certeza que deseja eliminar todos os Item na Base de Dado?","Sim","Não");
  boolean yes = comfirBox.btnYesClicked;
   Connection con;       
    if(yes ==true){       
      try {con = Mysql.getConnection();
        String SQL = "DELETE FROM listadevendas_tab WHERE listadevendas_tab.cod_doc_vendas = "+VarCod_docVendas+"  ";
        PreparedStatement ps = con.prepareStatement(SQL);
       int n = ps.executeUpdate(SQL);
       if(n>0){            
       comfirBox.start("LIMPAR", "Eliminacao bem sucedida","Ok","");
        }  } catch (SQLException e) {
       comfirBox.start("LIMPAR","Erro na eliminacao de registo","Ok",""+ e);
        }  } else{
   //    comfirBox.start("LIMPAR", "Eliminacao negada","Ok","");
     } 
   }

public int inserir_Vendas( int cod_cliente,  int cod_ModoPagameto, int cod_doOperador, 
int descontoCliente, int Qnt_ItensVendido, float ValorTotalVenda, String DataVenda, int cod_abertura){
 int n = 0;  
    if ("".equals(String.valueOf(cod_ModoPagameto))) {
    comfirBox.start("ERRO", "Selecione um modo de Pagamento","Ok","");
    } else {
      if("".equals(String.valueOf(cod_doOperador))){
           comfirBox.start("ERRO", "Codigo de Operador Inexistente","Ok","");
       }else{
       if(Qnt_ItensVendido <= 0){
          comfirBox.start("ERRO", "Quantidade de Itens Inválido","Ok","");
          }                                    
          else{                                        
   try {       
    conect = Mysql.getConnection();
    Mysql.getDriver();            
    String SQL = "INSERT INTO vendas_tab (cod_cliente, cod_modoPagameto, cod_doOperador, "
                + " descontoClinte, qnt_itensVendido, ValorTotal, data_venda, cod_abertura) VALUES (?,?,?,?,?,?,?,?)";      
        PreparedStatement ps = conect.prepareStatement(SQL);
        ps.setInt(1,cod_cliente);
        ps.setInt(2, cod_ModoPagameto);
        ps.setInt(3, cod_doOperador);
        ps.setInt(4, descontoCliente);
        ps.setInt(5, Qnt_ItensVendido);
        ps.setFloat(6, ValorTotalVenda); 
         if(DataVenda ==null){ps.setDate(7, null);}
        else {ps.setString(7,DataVenda );}
        ps.setInt(8, cod_abertura);
    n = ps.executeUpdate();
    if (n > 0) {           
            } else{
     comfirBox.start("ERROR", "Erro ao quardar Dados!","Ok","");   
    }
        }
        catch (SQLException ex ) {
      comfirBox.start("ERROR", ex.getMessage(),"Ok","");          
        }     
                            }      
                        }   
                    }
     return n;
    }
  }

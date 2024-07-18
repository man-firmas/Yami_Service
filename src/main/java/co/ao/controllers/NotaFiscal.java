package co.ao.controllers;

import co.ao.bd.Mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

/**
 *
 * @author firmi
 */
public class NotaFiscal {
private int cod_notaF=0;
private String data_venda;
private int cod_cliente;
private int qnt_ItensVendidoNF;
private float total_notaF;
private float troco_a_receber;
private float valor_entregue;
private int cod_tipoDePagamento;
private int cod_formaDePagamento;
private int qnt;
private float n_produto;
private float preco_unit;
private float montante;
private String nome_operador;
//MessageConfirmBox comfirBox;
Connection conect;
public NotaFiscal(){};

    public NotaFiscal(String data_venda, int cod_cliente, int qnt_ItensVendidoNF, float total_notaF, float troco_a_receber, float valor_entregue, int cod_tipoDePagamento, int cod_formaDePagamento, int qnt, float n_produto, float preco_unit, float montante, String nome_operador) {
        this.data_venda = data_venda;
        this.cod_cliente = cod_cliente;
        this.qnt_ItensVendidoNF = qnt_ItensVendidoNF;
        this.total_notaF = total_notaF;
        this.troco_a_receber = troco_a_receber;
        this.valor_entregue = valor_entregue;
        this.cod_tipoDePagamento = cod_tipoDePagamento;
        this.cod_formaDePagamento = cod_formaDePagamento;
        this.qnt = qnt;
        this.n_produto = n_produto;
        this.preco_unit = preco_unit;
        this.montante = montante;
        this.nome_operador = nome_operador;
    }

    @Override
    public String toString() {
        return "NotaFiscal{" + "cod_notaF=" + cod_notaF + ", data_venda=" + data_venda + ", cod_cliente=" + cod_cliente + ", qnt_ItensVendidoNF=" + qnt_ItensVendidoNF + ", total_notaF=" + total_notaF + ", troco_a_receber=" + troco_a_receber + ", valor_entregue=" + valor_entregue + ", cod_tipoDePagamento=" + cod_tipoDePagamento + ", cod_formaDePagamento=" + cod_formaDePagamento + ", qnt=" + qnt + ", n_produto=" + n_produto + ", preco_unit=" + preco_unit + ", montante=" + montante + ", nome_operador=" + nome_operador + '}';
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public float getN_produto() {
        return n_produto;
    }

    public void setN_produto(float n_produto) {
        this.n_produto = n_produto;
    }

    public float getPreco_unit() {
        return preco_unit;
    }

    public void setPreco_unit(float preco_unit) {
        this.preco_unit = preco_unit;
    }

    public float getMontante() {
        return montante;
    }

    public void setMontante(float montante) {
        this.montante = montante;
    }

    public String getNome_operador() {
        return nome_operador;
    }

    public void setNome_operador(String nome_operador) {
        this.nome_operador = nome_operador;
    }

    public int getCod_notaF() {
        return cod_notaF;
    }

    public void setCod_notaF(int cod_notaF) {
        this.cod_notaF = cod_notaF;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getQnt_ItensVendidoNF() {
        return qnt_ItensVendidoNF;
    }

    public void setQnt_ItensVendidoNF(int qnt_ItensVendidoNF) {
        this.qnt_ItensVendidoNF = qnt_ItensVendidoNF;
    }

    public float getTotal_notaF() {
        return total_notaF;
    }

    public void setTotal_notaF(float total_notaF) {
        this.total_notaF = total_notaF;
    }

    public float getTroco_a_receber() {
        return troco_a_receber;
    }

    public void setTroco_a_receber(float troco_a_receber) {
        this.troco_a_receber = troco_a_receber;
    }

    public float getValor_entregue() {
        return valor_entregue;
    }

    public void setValor_entregue(float valor_entregue) {
        this.valor_entregue = valor_entregue;
    }

    public int getCod_tipoDePagamento() {
        return cod_tipoDePagamento;
    }

    public void setCod_tipoDePagamento(int cod_tipoDePagamento) {
        this.cod_tipoDePagamento = cod_tipoDePagamento;
    }

    public int getCod_formaDePagamento() {
        return cod_formaDePagamento;
    }

    public void setCod_formaDePagamento(int cod_formaDePagamento) {
        this.cod_formaDePagamento = cod_formaDePagamento;
    }
public int inserir_ListaNotafiscal( int cod_codBarraVendas,  int cod_UnidVendas, TextField cod_prodVvendas, 
TextField textField_precUnit_cad_vendas, Spinner Spinner_qnt_vendas, float textField_total_cad_vendas, int cod_doc_venda, int cod_Repositorio){
 int n = 0;  
    if ("".equals(String.valueOf(cod_UnidVendas))) {
  //  comfirBox.start("ATENÇÃO", "Preencher campo unidade.","Ok","");
    } else {
      if("".equals(String.valueOf(cod_prodVvendas))){
//           comfirBox.start("ATENÇÃO", "Preencher campo Produto.","Ok","");
       }else{
       if("0".equals(Spinner_qnt_vendas.getValue().toString())){
   //       comfirBox.start("ATENÇÃO", "Selecione um numero.","Ok","");
          }                                    
          else{                                        
   try {       
    conect = Mysql.getConnection();
    Mysql.getDriver();            
    String SQL = "INSERT INTO listadevendas_tab (cod_barra_vendas, unid_vendas, cod_prod_vendas, "
                + " precoUnit_vendas, qnt_prod_vendas, total_vendas, cod_doc_vendas, ref_codReposit_vendas) VALUES (?,?,?,?,?,?,?,?)";      
        PreparedStatement ps = conect.prepareStatement(SQL);
        ps.setInt(1,cod_codBarraVendas);
        ps.setInt(2, cod_UnidVendas);
        ps.setInt(3, Integer.parseInt(cod_prodVvendas.getText()));
        ps.setString(4, textField_precUnit_cad_vendas.getText());
        ps.setInt(5, (int) Spinner_qnt_vendas.getValue());
        ps.setFloat(6, textField_total_cad_vendas); 
        ps.setInt(7, cod_doc_venda); 
        ps.setInt(8, cod_Repositorio); 
    n = ps.executeUpdate();
    if (n > 0) {           
            } else{
//     comfirBox.start("ERROR", "Erro ao quardar Dados!","Ok","");   
    }
        }
        catch (SQLException ex ) {
    //  comfirBox.start("ERROR", ex.getMessage(),"Ok","");          
        }     
                            }      
                        }   
                    }
     return n;
    }
}
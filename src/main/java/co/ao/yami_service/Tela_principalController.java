/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ao.yami_service;

import co.ao.bd.Mysql;
import co.ao.controllers.Acessorios;
import co.ao.controllers.Clientes;
import co.ao.controllers.EncriptorAndDecriptor_Class;
import co.ao.controllers.Fornecedor;
import co.ao.controllers.ListaOrdemServico;
import co.ao.controllers.MyListner;
import co.ao.controllers.NotaFiscal;
import co.ao.controllers.Ordem_Servico;
import co.ao.controllers.Usuario;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


public class Tela_principalController
implements Initializable {

    public VBox btnLateral_10_Config1;
    @FXML
    private BorderPane parent;
    @FXML
    private AnchorPane anchoPane;
    @FXML
    private AnchorPane Painel_Inicio;
    @FXML
    private AnchorPane Painel_Cadastro;
    @FXML
    private AnchorPane Painel_OrdemServico;
    @FXML
    private AnchorPane Painel_Imprimir_OS;
    @FXML
    private AnchorPane painel_NovaOrdem;
    @FXML
    private ContextMenu MenuContexto_User;
    @FXML
    private MenuButton label_usuario_local;
    @FXML
    private ToggleButton togglebtn_activ_cad_clien;
    @FXML
    private ToggleButton togglebtn_activ_cad_forn;
    @FXML
    private ToggleButton togglebtn_activ_cadAcess;
    @FXML
    private ToggleButton togglebtn_activ_cad_User;
     @FXML
    private ToggleButton togglebtn_activ_cadServic;
    @FXML
    private VBox pn_report;
    @FXML
    private VBox Vbox_MenuLateral;
    @FXML
    private GridPane GridPane;
    @FXML
    private SplitMenuButton SplitBtnPainel_imprimir;
    @FXML
    private TextArea textA_Relator_Queixa;
    @FXML
    private TextArea textA_descricaoCliente;
    @FXML
    private TextArea textA_descricao_forn;
    @FXML
    private TextArea textA_descricaoAcess;
    @FXML
    private TextArea textA_descridescricaoUser;
    @FXML
    private Button btn_inserir_servico;
    @FXML
    private Button btn_inserir_acessorio;
    @FXML
    private Button Btn_nova_OS;
    @FXML
    private Button Btn_editar_OS;
    @FXML
    private Button Btn_consulta_OS;
    @FXML
    private Button Btn_eliminar_OS;
    @FXML
    private Button btn_eliminar_clien;
    @FXML
    private Button btn_actualizar_clien;
    @FXML
    private Button btn_ConsultClient;
    @FXML
    private Button btn_novo_clien;
    @FXML
    private Button btn_guardar_clien;
    @FXML
    private Button btn_novo_forn;
    @FXML
    private Button btn_guardar_forn;
    @FXML
    private Button btn_actualizar_forn;
    @FXML
    private Button btn_eliminar_forn;
    @FXML
    private Button btn_Consult_forn;
    @FXML
    private Button Btn_GuardaOS;
    @FXML
    private Button btn_novo_acess;
    @FXML
    private Button btn_actualizar_acess;
    @FXML
    private Button btn_eliminar_acess;
    @FXML
    private Button btn_guardar_acess;
    @FXML
    private Button btn_ChamarCliente;
    @FXML
    private Button Btn_DedTroco;
    @FXML
    private Button btn_novo_User;
    @FXML
    private Button btn_guardar_User;
    @FXML
    private Button btn_actualizar_User;
    @FXML
    private Button btn_eliminar_User;
    @FXML
    private Button btn_Consult_User;
    @FXML
    private TableView<ListaOrdemServico> tableview_nova_SO;
    @FXML
    private TableView<Clientes> tableView_Cliente;
    @FXML
    private TableView<Fornecedor> tableView_forn;
    @FXML
    private TableView<Usuario> tableView_Servic;
    @FXML
    private ImageView imageView_cad_clien;
    @FXML
    private ImageView imageView_cad_forn;
    @FXML
    private ImageView imageView_cadaAcess;
    @FXML
    private ImageView imageView_cad_User;
    @FXML
    private ImageView image_view_actual;
    @FXML
    private ImageView imageView_cadaServic;
    @FXML
    private TableView<Acessorios> tableView_Acess;
    @FXML
    private TableView<Usuario> tableView_User;
    @FXML
    private Spinner Spinner_qnt_servic;
    @FXML
    private Spinner Spinner_qnt_acessorio;
    @FXML
    private TextField textFild_cliente;
    @FXML
    private TextField textFild_ref_equipamento;
    @FXML
    private TextField textFild_precoUnit_serv;
    @FXML
    private TextField textFild_precoUnit_acess;
    @FXML
    private TextField textField_codCliente;
    @FXML
    private TextField textField_nomeCliente;
    @FXML
    private TextField textField_contactMovClient;
    @FXML
    private TextField textField_contactFixClient;
    @FXML
    private TextField textField_enderecClliente;
    @FXML
    private TextField textField_nif_clinte;
    @FXML
    private TextField textField_emailClinte;
    @FXML
    private TextField textField_credit_cliente;
    @FXML
    private TextField textField_debito;
    @FXML
    private TextField textField_codForn;
    @FXML
    private TextField textField_nomeForn;
    @FXML
    private TextField textField_extorno;
    @FXML
    private TextField textField_email_Forn;
    @FXML
    private TextField textField_FornecAcess;
    @FXML
    private TextField textField_precCompraAcess;
    @FXML
    private TextField Textfield_Status_SO;
    @FXML
    private TextField textField_enderecForn;
    @FXML
    private TextField textField_contactMovForn;
    @FXML
    private TextField textField_contactFix_forn;
    @FXML
    private TextField textField_nif_forn;
    @FXML
    private TextField textField_credit_forn;
    @FXML
    private TextField textField_codBarraAcess;
    @FXML
    private TextField textField_nomeAcess;
    @FXML
    private TextField textField_precVendaAcess;
    @FXML
    private TextField textField_codAcess;
    @FXML
    private TextField TextFieldl_MontanteItens;
    @FXML
    private TextField textField_codUser;
    @FXML
    private TextField textField_nomeUser;
    @FXML
    private TextField textField_UserId;
    @FXML
    private TextField textField_codServic;
    @FXML
    private TextField textField_contactMovUser;
    @FXML
    private TextField textField_emailUser;
    @FXML
    private TextField textField_nomeServic;
    @FXML
    private TextField textField_precoServic;
   /*
    @FXML
    private FontAwesome Indicador_1;
    @FXML
    private FontAwesome Indicador_2;
    @FXML
    private FontAwesome Indicador_3;
    @FXML
    private FontAwesome Indicador_4;
    @FXML
    private FontAwesome Indicador_5;
    @FXML
    private FontAwesome  Indicador_6;
    @FXML
    private FontAwesome  Indicador_7;
    @FXML
    private FontAwesome  Indicador_8;
    @FXML
    private FontAwesome Indicador_9;
    @FXML
    private FontAwesome Indicador_10;
    @FXML
    private FontAwesome fontAwesome_categorias;
    @FXML
    private FontAwesome fontAwesome_acess;
    @FXML
    private FontAwesome FontAwIconVie_Imprimir;
    **/
    @FXML
    private VBox btnLateral_1_home;
    @FXML
    private VBox btnLateral_2_Cadastro;
    @FXML
    private VBox btnLateral_3_Servicos;
    @FXML
    private VBox btnLateral_4_Ordem;
    @FXML
    private VBox btnLateral_5_Proformas;
    @FXML
    private VBox btnLateral_6_Acessorios;
    @FXML
    private VBox btnLateral_7_Finaceira;
    @FXML
    private VBox btnLateral_8_Fornecedor;
    @FXML
    private VBox btnLateral_9_Comissoes;
    @FXML
    private VBox btnLateral_10_Config;
    @FXML
    private Label Lbl_ValorPorPagar;
    @FXML
    private Label Lbl_Data;
    @FXML
    private Label Label_fotoCliente;
    @FXML
    private Label Lbl_nomeCliente_Impr;
    @FXML
    private Label Lbl_descric_Item_Impri;
    @FXML
    private Label Label_NomeTipo;
    @FXML
    private Label Lbl_NumOrdemServic;
    @FXML
    private Label Lbl_DataImpr;
    @FXML
    private Label Lbl_codNovaOrdem;
    @FXML
    private Label Lbl_vPago;
    @FXML
    private Label Label_foto_servic;
    @FXML
    private JFXHamburger Hamburger;
    @FXML
    private JFXDrawer Drawer;
    @FXML
    private ComboBox combobox_categoria_servic;
    @FXML
    private ComboBox combobox_servic;
    @FXML
    private ComboBox combobox_acessorios;
    @FXML
    private ComboBox combobox_serie;
    @FXML
    private ComboBox combobox_local_exec;
    @FXML
    private ComboBox combobox_tecnico;
    @FXML
    private ComboBox combobox_PersonJuri;
    @FXML
    private ComboBox combobox_loja_a_operar;
    @FXML
    private ComboBox combobox_PersonJuri_forn;
    @FXML
    private ComboBox combobox_categ_acess;
    @FXML
    private ComboBox combobox_tipo_acess;
    @FXML
    private ComboBox combobox_IdentifcadorAcess;
    @FXML
    private ComboBox combobox_SerieAcess;
    @FXML
    private ComboBox combobox_funcao_user;
    @FXML
    private ComboBox combobox_PrioridadeUser;
    @FXML
    private JFXComboBox Combobox_listarOrd_Impr;
    @FXML
    private ComboBox combobox_categ_servic;
    @FXML
    private ComboBox combo_fornecedor_servic;
    @FXML
    private ComboBox combo_IdentifcadorServic;
    @FXML
    public JFXCheckBox Checkbox_selectAll;
    @FXML
    Label labelData = new Label();
    @FXML
    ScrollPane scrollPane;
    @FXML
    private PasswordField passwordField_user;
    @FXML
    private PasswordField passwordFieldRepita_user;
    private double xOffSet = 0.0;
    private double yOffSet = 0.0;
    float precoUnitTextServ = 0.0f;
    float precoUnitTextAcess = 0.0f;
    private Image icon_local;
    private Image icon1;
    private Image icon2;
    private Image icon3;
    private Image icon4;
    private Image icon5;
    private File fis1_1;
    private File fis1_2;
    private File fis1_3;
    private File fis1_4;
    private File fis1_5;
    private File fis1_6;
    private File fis_local = new File("src/co/ao/imagens/User_1.png");
    private final File fis1 = new File("src/co/ao/foto_src/img_indisponivel.png");
    private File fis2 = new File("src/co/ao/foto_src/img_indisponivel.png");
    private File fis3 = new File("src/co/ao/foto_src/img_indisponivel.png");
    private File fis4 = new File("src/co/ao/foto_src/img_indisponivel.png");
    private File fis5 = new File("src/co/ao/foto_src/img_indisponivel.png");
    private final FileChooser busca_foto_fornec = new FileChooser();
    private final FileChooser busca_foto_Cliente = new FileChooser();
    private final FileChooser busca_foto_User = new FileChooser();
    private final FileChooser busca_foto_Acess = new FileChooser();
    private final Ordem_Servico OrdemServ = new Ordem_Servico();
    private Usuario usuario_actual = new Usuario();
    private String text_src_foto_clien;
    private String text_src_foto_forn;
    private String text_src_foto_acess;
    private String text_src_foto_user;
    private static final Tela_LoginController telaLogin = new Tela_LoginController();
    private Clientes cliente = new Clientes();
    private Acessorios acessorio = new Acessorios();
    private Fornecedor fornecedor = new Fornecedor();
    private Usuario usuario = new Usuario();
    private final ListaOrdemServico listarOrdem = new ListaOrdemServico();
    private final NotaFiscal classNotaFiscal = new NotaFiscal();
    Configuracoes config = new Configuracoes(); 
    private MyListner myListner;
    Alert alert = new Alert(Alert.AlertType.NONE);
    private final Mysql BD_conect = new Mysql();
    private String cod_categoria;
    private String cod_categoria_CadasAcess;
    private String cod_identificador;
    private String cod_identificador_Categ_acess;
    String varNome;
    String precUnit;
    String NomeAcess;
    int codCat;
    int codServ;
    int codAcess_listar;
    int Qnt_montante;
    int CodCliente = 0;
    int codCategoria_cadastrar;
    int cod_listarOrdemServico = 0;
    int codItensImp = 0;
    int cod_prioridade;
    int OrdendandorLoging;
    private float vlorNotaFiscal = 0.0f;
    private float mont = 0.0f;
    private float montant;
    private float mon;
    private float vPago = 0.0f;
    public Scene Scene_ChamarCliente;
    public static Stage stage_TelaCliente = null;
    public Scene Scene_telaCobrar;
    public static Stage stage_TelaCobrar = null;
    ArrayList<String> listaCliente = new ArrayList();
    private int intCodPersoJurid_Clie;
    private int combox_int_perso_forn;
    private int imagens_BDClient;
    private int imagens_BDFor;
    private int imagens_BDAces;
    private int imagens_BDUser;
    Connection conect;
    NumberFormat f = NumberFormat.getNumberInstance();
   // private AutoCompletionBinding<String> autoComBind;
    private final String[] _possibleSugestion = new String[]{"Firmino", "Loureiro", "Qu\u00e9ria", "Cl\u00e1udia", "Gouveia", "Augusto", "Jo\u00e3o"};
    private Set<String> possibleSugestion = new HashSet<>(Arrays.asList(this._possibleSugestion));
    ItemController itenController = new ItemController();
    private List<ListaOrdemServico> listOrd = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        f.setGroupingUsed(true);
        f.setMaximumFractionDigits(2);
        f.setMinimumFractionDigits(2);
       //this.limpar_Dados_Clien();
        this.get_Data();
        this.Mtd_Humburguer();
        try {
            telaLogin.leitura_settings();
            this.carregar_combobox();
            this.TextFieldSugestion();
            this.cliente.setColuna(this.tableView_Cliente);
            this.carregar_tabelaClien();
            this.fornecedor.setColuna(this.tableView_forn);
            this.carregar_tabelaForn();
            this.acessorio.setColuna(this.tableView_Acess);
            this.carregar_tabelaAcess();
            this.usuario.setColuna(this.tableView_User);
            this.carregar_tabelaUser();
        }
        catch (IOException | SQLException ex) {
            Logger.getLogger(Tela_principalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SpinnerValueFactory.IntegerSpinnerValueFactory spininServic = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 1);
        this.Spinner_qnt_servic.setValueFactory((SpinnerValueFactory)spininServic);
        SpinnerValueFactory.IntegerSpinnerValueFactory spininAcess = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 1);
        this.Spinner_qnt_acessorio.setValueFactory((SpinnerValueFactory)spininAcess);
        this.Carregar_usuario_local();
      //  this.set__Enable_btn_lateral_1();
        Node[] nodes = new Node[13];
        for (int i = 0; i < nodes.length; ++i) {
            try {
                nodes[i] = (Node)FXMLLoader.load((URL)this.getClass().getResource("Telas/Iten_relatorio.fxml"));
                pn_report.getChildren().add(nodes[i]);
               
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        this.listarOrdem.setColuna(this.tableview_nova_SO);
        try {
            this.carregar_tabela_listarOrdem();
        }
        catch (SQLException ex) {
            Logger.getLogger(Tela_principalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.Lbl_codNovaOrdem.setText(String.valueOf(this.cod_listarOrdemServico));
        try {
            this.listOrd.addAll((Collection<ListaOrdemServico>)this.Load_ListarServOrdemiMPRIMIR());
            this.Medt_ListarItensImprimir_2();
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Tela_principalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.Checkbox_selectAll.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.booleanValue()) {
                this.mon = this.montant;
            } else {
                this.mon = 0.0f;
                this.vlorNotaFiscal = this.montant;
            }
        });
        this.myListner = (listaOrdem, ckeckbox) -> {
            this.setChosenOrdem(listaOrdem, ckeckbox);
            this.Checkbox_selectAll.setSelected(false);
            if (ckeckbox && listaOrdem.isItemPago() == 0) {
                ListaOrdemServico OrdensNaoPago = new ListaOrdemServico();
                OrdensNaoPago.setMontante_listaOrdem(listaOrdem.getMontante_listaOrdem());
                this.mon += listaOrdem.getMontante_listaOrdem();
            } else {
                this.mon -= listaOrdem.getMontante_listaOrdem();
            }
            this.Lbl_ValorPorPagar.setText(String.valueOf(this.f.format(this.mon)));
            this.vlorNotaFiscal = this.mon;
        };
    }

    @FXML
    public void Chebox() throws SQLException, ClassNotFoundException {
        if (this.Checkbox_selectAll.isSelected()) {
            this.Medt_ListarItensImprimir();
        } else {
            this.Medt_ListarItensImprimir_2();
        }
    }

    @FXML
    private void makeStageDragable() {
        this.parent.setOnMousePressed(event -> {
            this.xOffSet = event.getSceneX();
            this.yOffSet = event.getSceneY();
        });
        this.parent.setOnMouseDragged(event -> {
            Launch_Service.Primary_stage.setX(event.getScreenX() - this.xOffSet);
            Launch_Service.Primary_stage.setY(event.getScreenY() - this.yOffSet);
        });
        this.parent.setOnDragDone(event -> Launch_Service.Primary_stage.setOpacity(1.0));
        this.parent.setOnMouseReleased(event -> Launch_Service.Primary_stage.setOpacity(1.0));
    }

    public void get_Data() {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        DateFormat f1 = DateFormat.getDateInstance(0);
        DateFormat f2 = DateFormat.getDateInstance(3);
        SimpleDateFormat f3 = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat f4 = new SimpleDateFormat("dd/MM/yyyy");
        this.Lbl_Data.setText(f1.format(data));
        this.labelData.setText(f3.format(data));
    }

    @FXML
    private void tfContactoKeyRelased() {
    }

    @FXML
    private void getContactSpace(MouseEvent event) throws ParseException {
        if (event.getSource() == this.textField_contactMovClient) {
            // empty if block
        }
    }

    @FXML
    private void getMenuContexto() {
        Menu menuMaxim = new Menu("Maximizar");
        Menu menuMin = new Menu("Minimizar");
        Menu menuSair = new Menu("Sair");
        MenuContexto_User.getItems().addAll(menuMaxim, menuMin, menuSair);
    }

    @FXML
    public void maximize_stage(ActionEvent event) {
        Launch_Service.Primary_stage.setFullScreen(true);
    }

    @FXML
    public void minimize_stage(ActionEvent event) {
        Launch_Service.Primary_stage.setIconified(true);
    }

    @FXML
    private void LogOutPos(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setContentText("Tem certeza que Deseja Fazer Logout?");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Launch_Service.ChengeScreen((String)"tela_Login");
            }
        });
    }

    @FXML
    private void handleclose(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setContentText("Tem certeza que Deseja Encerrar o Aplicativo?");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                System.exit(0);
            }
        });
    }

    @FXML
    private void Mtd_Humburguer() {
        this.Drawer.setSidePane(new Node[]{this.Vbox_MenuLateral});
        JFXHamburger burgerTask2 = new JFXHamburger();
        burgerTask2.setRotate(-1.0);
        this.Drawer.open();
        this.Hamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            burgerTask2.setRotate(burgerTask2.getRotate() * -1.0);
            burgerTask2.getAnimation();
            if (this.Drawer.isOpened()) {
                this.Drawer.close();
                this.Drawer.setPrefWidth(0.0);
            } else {
                this.Drawer.open();
                this.Drawer.setPrefWidth(222.0);
            }
        });
    }

    private void TextFieldSugestion() {
//TextFields.bindAutoCompletion((TextField)this.textFild_cliente, this.listaCliente);
    }

    private void carregar_combobox() throws IOException, SQLException {
        Mysql.getConnection();
        this.BD_conect.executaSQL("SELECT * FROM categoria_tab ");
        while (this.BD_conect.resultset.next()) {
            this.combobox_categoria_servic.getItems().addAll(new Object[]{this.BD_conect.resultset.getString("nome_categoria")});
            this.combobox_categ_acess.getItems().addAll(new Object[]{this.BD_conect.resultset.getString("nome_categoria")});
        }
        this.BD_conect.executaSQL("SELECT * FROM tecnicos_tab ");
        while (this.BD_conect.resultset.next()) {
            this.combobox_tecnico.getItems().addAll(new Object[]{this.BD_conect.resultset.getString("nome_tecnico")});
        }
        this.BD_conect.executaSQL("SELECT nome_cliente FROM clientes_tab ");
        while (this.BD_conect.resultset.next()) {
            this.listaCliente.add(this.BD_conect.resultset.getString("nome_cliente"));
        }
        this.BD_conect.executaSQL("SELECT lojas_tab.descricao_loja, localizacao_tab.nome_local  FROM lojas_tab INNER JOIN localizacao_tab ON lojas_tab.endereco_loja = localizacao_tab.cod_local ");
        while (this.BD_conect.resultset.next()) {
            this.combobox_local_exec.getItems().addAll(new Object[]{this.BD_conect.resultset.getString(1)});
        }
        this.BD_conect.executaSQL("SELECT * FROM perso_juridica_tab");
        while (this.BD_conect.resultset.next()) {
            this.combobox_PersonJuri.getItems().addAll(new Object[]{this.BD_conect.resultset.getString("nome_perso_juridica")});
            this.combobox_PersonJuri_forn.getItems().addAll(new Object[]{this.BD_conect.resultset.getString("nome_perso_juridica")});
        }
        this.BD_conect.executaSQL("SELECT * FROM ordemdeservi\u00e7o_tab");
        while (this.BD_conect.resultset.next()) {
            this.cod_listarOrdemServico = this.BD_conect.resultset.getInt("cod_ordemServico") + 1;
            this.Combobox_listarOrd_Impr.getItems().addAll(new Object[]{this.BD_conect.resultset.getString("nome_cliente")});
        }
        this.BD_conect.executaSQL("SELECT descricao_loja FROM lojas_tab");
        while (BD_conect.resultset.next()) {
            combobox_loja_a_operar.getItems().addAll(new Object[]{this.BD_conect.resultset.getString(1)});
        }
        this.BD_conect.executaSQL("SELECT nome_prioridade FROM prioridade_tab");
        while (BD_conect.resultset.next()) {
            combobox_PrioridadeUser.getItems().addAll(new Object[]{this.BD_conect.resultset.getString(1)});
        }
        BD_conect.executaSQL("Select count(cod_usuario) FROM usuario_tab ");

        BD_conect.statement.close();
    }

    private void Carregar_usuario_local() {
        Launch_Service.addChangeListener((newScreen, newObject, userdata2, userdata3, userdata4) -> {
            if (newScreen.equals("tela_Principal")) {
                this.usuario_actual = (Usuario)newObject;
                this.label_usuario_local.setText(String.valueOf(this.usuario_actual.getUser_ID()));
                this.fis_local = new File("src/co/ao/foto_src/" + this.usuario_actual.getImagem_user());
                this.image_view_actual.setImage(this.usuario_actual.setFoto2(this.icon_local, this.fis_local));
                Launch_Service.scenePrincipal.getRoot().setEffect(null);
                if (userdata2 != null) {
                    this.cliente = (Clientes)userdata2;
                    this.textFild_cliente.setText(this.cliente.getNome_Cliente());
                }
            }
        });
    }
/*
    //Submétodo que Abilitar os botões da barra lateral.  
 private void set_Enable_Indicador(FontAwesome [] ind, VBox [] btn, AnchorPane[] painel){
for(FontAwesome btn1: ind)
    {
  //     btn1.setVisible(true);
        }
    for(VBox btn1: btn)
        {
        btn1.setDisable(true);
        }
    for(AnchorPane painel1: painel)
    {
        painel1.setVisible(true);
    }
} 
 //Submétodo que desabilitar os botões da barra lateral.  
private void set_Desable_Indicador(FontAwesome [] ind, VBox [] btnDis, AnchorPane[] painel){
for(FontAwesome btn1: ind)
    {
     //  btn1.set(false);
    }
for(VBox btn2: btnDis)
    {
     btn2.setDisable(false);
    }
for(AnchorPane painel1: painel){
painel1.setVisible(false);
  }
} 

    private void set__Enable_btn_lateral_1() {
        this.set_Enable_Indicador(new FontAwesome[]{this.Indicador_1}, new VBox[]{this.btnLateral_1_home}, new AnchorPane[]{this.Painel_Inicio});
        this.set_Desable_Indicador(new FontAwesome[]{this.Indicador_2, this.Indicador_3, this.Indicador_4, this.Indicador_5, this.Indicador_6, this.Indicador_7, this.Indicador_8, this.Indicador_9, this.Indicador_10}, new VBox[]{this.btnLateral_2_Cadastro, this.btnLateral_3_Servicos, this.btnLateral_4_Ordem, this.btnLateral_5_Proformas, this.btnLateral_6_Acessorios, this.btnLateral_7_Finaceira, this.btnLateral_9_Comissoes, this.btnLateral_8_Fornecedor, this.btnLateral_10_Config}, new AnchorPane[]{this.Painel_OrdemServico, this.Painel_Cadastro});
    }


    @FXML
    private void setEnable_bnt(MouseEvent event) {
        if (event.getSource() == this.btnLateral_1_home) {
            this.set_Enable_Indicador(new FontAwesome[]{this.Indicador_1}, new VBox[]{this.btnLateral_1_home}, new AnchorPane[]{this.Painel_Inicio});
            this.set_Desable_Indicador(new FontAwesome[]{this.Indicador_2, this.Indicador_3, this.Indicador_4, this.Indicador_5, this.Indicador_6, this.Indicador_7, this.Indicador_8, this.Indicador_9, this.Indicador_10}, new VBox[]{this.btnLateral_2_Cadastro, this.btnLateral_3_Servicos, this.btnLateral_4_Ordem, this.btnLateral_5_Proformas, this.btnLateral_6_Acessorios, this.btnLateral_7_Finaceira, this.btnLateral_8_Fornecedor, this.btnLateral_9_Comissoes, this.btnLateral_10_Config}, new AnchorPane[]{this.Painel_OrdemServico, this.Painel_Cadastro});
        }
        if (event.getSource() == this.btnLateral_2_Cadastro) {
            this.set_Enable_Indicador(new FontAwesome[]{this.Indicador_2}, new VBox[]{this.btnLateral_2_Cadastro}, new AnchorPane[]{this.Painel_Cadastro});
            this.set_Desable_Indicador(new FontAwesome[]{this.Indicador_1, this.Indicador_3, this.Indicador_4, this.Indicador_5, this.Indicador_6, this.Indicador_7, this.Indicador_8, this.Indicador_9, this.Indicador_10}, new VBox[]{this.btnLateral_1_home, this.btnLateral_3_Servicos, this.btnLateral_4_Ordem, this.btnLateral_5_Proformas, this.btnLateral_6_Acessorios, this.btnLateral_7_Finaceira, this.btnLateral_8_Fornecedor, this.btnLateral_9_Comissoes, this.btnLateral_10_Config}, new AnchorPane[]{this.Painel_Inicio, this.Painel_OrdemServico});
        }
        if (event.getSource() == this.btnLateral_3_Servicos) {
            this.set_Enable_Indicador(new FontAwesome[]{this.Indicador_3}, new VBox[]{this.btnLateral_3_Servicos}, new AnchorPane[0]);
            this.set_Desable_Indicador(new FontAwesome[]{this.Indicador_1, this.Indicador_2, this.Indicador_4, this.Indicador_5, this.Indicador_6, this.Indicador_7, this.Indicador_8, this.Indicador_9, this.Indicador_10}, new VBox[]{this.btnLateral_1_home, this.btnLateral_2_Cadastro, this.btnLateral_4_Ordem, this.btnLateral_5_Proformas, this.btnLateral_6_Acessorios, this.btnLateral_7_Finaceira, this.btnLateral_8_Fornecedor, this.btnLateral_9_Comissoes, this.btnLateral_10_Config}, new AnchorPane[0]);
        }
        if (event.getSource() == this.btnLateral_4_Ordem) {
            this.set_Enable_Indicador(new FontAwesome[]{this.Indicador_4}, new VBox[]{this.btnLateral_4_Ordem}, new AnchorPane[]{this.Painel_OrdemServico});
            this.set_Desable_Indicador(new FontAwesome[]{this.Indicador_1, this.Indicador_2, this.Indicador_3, this.Indicador_5, this.Indicador_6, this.Indicador_7, this.Indicador_8, this.Indicador_9, this.Indicador_10}, new VBox[]{this.btnLateral_1_home, this.btnLateral_2_Cadastro, this.btnLateral_3_Servicos, this.btnLateral_5_Proformas, this.btnLateral_6_Acessorios, this.btnLateral_7_Finaceira, this.btnLateral_8_Fornecedor, this.btnLateral_9_Comissoes, this.btnLateral_10_Config}, new AnchorPane[]{this.Painel_Cadastro});
        }
        if (event.getSource() == this.btnLateral_5_Proformas) {
            this.set_Enable_Indicador(new FontAwesome[]{this.Indicador_5}, new VBox[]{this.btnLateral_5_Proformas}, new AnchorPane[0]);
            this.set_Desable_Indicador(new FontAwesome[]{this.Indicador_1, this.Indicador_2, this.Indicador_3, this.Indicador_4, this.Indicador_6, this.Indicador_7, this.Indicador_8, this.Indicador_9, this.Indicador_10}, new VBox[]{this.btnLateral_1_home, this.btnLateral_2_Cadastro, this.btnLateral_3_Servicos, this.btnLateral_4_Ordem, this.btnLateral_6_Acessorios, this.btnLateral_7_Finaceira, this.btnLateral_8_Fornecedor, this.btnLateral_9_Comissoes, this.btnLateral_10_Config}, new AnchorPane[0]);
        }
        if (event.getSource() == this.btnLateral_6_Acessorios) {
            this.set_Enable_Indicador(new FontAwesome[]{this.Indicador_6}, new VBox[]{this.btnLateral_6_Acessorios}, new AnchorPane[0]);
            this.set_Desable_Indicador(new FontAwesome[]{this.Indicador_1, this.Indicador_2, this.Indicador_3, this.Indicador_4, this.Indicador_5, this.Indicador_7, this.Indicador_8, this.Indicador_9, this.Indicador_10}, new VBox[]{this.btnLateral_1_home, this.btnLateral_2_Cadastro, this.btnLateral_3_Servicos, this.btnLateral_4_Ordem, this.btnLateral_5_Proformas, this.btnLateral_7_Finaceira, this.btnLateral_8_Fornecedor, this.btnLateral_9_Comissoes, this.btnLateral_10_Config}, new AnchorPane[0]);
        }
        if (event.getSource() == this.btnLateral_7_Finaceira) {
            this.set_Enable_Indicador(new FontAwesome[]{this.Indicador_7}, new VBox[]{this.btnLateral_7_Finaceira}, new AnchorPane[0]);
            this.set_Desable_Indicador(new FontAwesome[]{this.Indicador_1, this.Indicador_2, this.Indicador_3, this.Indicador_4, this.Indicador_5, this.Indicador_6, this.Indicador_8, this.Indicador_9, this.Indicador_10}, new VBox[]{this.btnLateral_1_home, this.btnLateral_2_Cadastro, this.btnLateral_3_Servicos, this.btnLateral_4_Ordem, this.btnLateral_5_Proformas, this.btnLateral_6_Acessorios, this.btnLateral_8_Fornecedor, this.btnLateral_9_Comissoes, this.btnLateral_10_Config}, new AnchorPane[0]);
        }
        if (event.getSource() == this.btnLateral_8_Fornecedor) {
            this.set_Enable_Indicador(new FontAwesome []{this.Indicador_8}, new VBox[]{this.btnLateral_8_Fornecedor}, new AnchorPane[0]);
            this.set_Desable_Indicador(new FontAwesome[]{this.Indicador_1, this.Indicador_2, this.Indicador_3, this.Indicador_4, this.Indicador_5, this.Indicador_6, this.Indicador_7, this.Indicador_9, this.Indicador_10}, new VBox[]{this.btnLateral_1_home, this.btnLateral_2_Cadastro, this.btnLateral_3_Servicos, this.btnLateral_4_Ordem, this.btnLateral_5_Proformas, this.btnLateral_6_Acessorios, this.btnLateral_7_Finaceira, this.btnLateral_9_Comissoes, this.btnLateral_10_Config}, new AnchorPane[0]);
        }
        if (event.getSource() == this.btnLateral_9_Comissoes) {
            this.set_Enable_Indicador(new FontAwesome[]{this.Indicador_9}, new VBox[]{this.btnLateral_9_Comissoes}, new AnchorPane[0]);
            this.set_Desable_Indicador(new FontAwesome[]{this.Indicador_1, this.Indicador_2, this.Indicador_3, this.Indicador_4, this.Indicador_5, this.Indicador_6, this.Indicador_7, this.Indicador_8, this.Indicador_10}, new VBox[]{this.btnLateral_1_home, this.btnLateral_2_Cadastro, this.btnLateral_3_Servicos, this.btnLateral_4_Ordem, this.btnLateral_5_Proformas, this.btnLateral_6_Acessorios, this.btnLateral_7_Finaceira, this.btnLateral_8_Fornecedor, this.btnLateral_10_Config}, new AnchorPane[0]);
        }
        if (event.getSource() == this.btnLateral_10_Config) {
            this.set_Enable_Indicador(new FontAwesome[]{this.Indicador_10}, new VBox[]{this.btnLateral_10_Config}, new AnchorPane[0]);
            this.set_Desable_Indicador(new FontAwesome[]{this.Indicador_1, this.Indicador_2, this.Indicador_3, this.Indicador_4, this.Indicador_5, this.Indicador_6, this.Indicador_7, this.Indicador_8, this.Indicador_9}, new VBox[]{this.btnLateral_1_home, this.btnLateral_2_Cadastro, this.btnLateral_3_Servicos, this.btnLateral_4_Ordem, this.btnLateral_5_Proformas, this.btnLateral_6_Acessorios, this.btnLateral_7_Finaceira, this.btnLateral_8_Fornecedor, this.btnLateral_9_Comissoes}, new AnchorPane[0]);
        }
    }
**/
    @FXML
    private void abilitarBtnOS(ActionEvent event) {
        if (event.getSource() == this.Btn_nova_OS) {
            this.Btn_nova_OS.setDisable(false);
            this.Painel_Imprimir_OS.setVisible(false);
            this.painel_NovaOrdem.setVisible(true);
        }
        if (event.getSource() == this.SplitBtnPainel_imprimir) {
            this.painel_NovaOrdem.setVisible(false);
            this.Painel_Imprimir_OS.setVisible(true);
            this.Btn_nova_OS.setVisible(true);
        }
    }

    @FXML
    private void enserirServicos(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (event.getSource() == this.btn_inserir_servico) {
            String NaturezaProduto = "servi\u00e7o";
            this.BD_conect.executaSQL("SELECT cod_categoria FROM categoria_tab where nome_categoria='" + this.combobox_categoria_servic.getValue() + "'");
            while (this.BD_conect.resultset.next()) {
                this.codCat = Integer.valueOf(this.BD_conect.resultset.getString("cod_categoria"));
            }
            this.BD_conect.executaSQL("SELECT cod_servico FROM servicos_tab where nome_servico='" + this.combobox_servic.getValue() + "'");
            while (this.BD_conect.resultset.next()) {
                this.codServ = Integer.valueOf(this.BD_conect.resultset.getString(1));
            }
            int UpdatIserirServic = 0;
            UpdatIserirServic = this.listarOrdem.inserir_listaOS(this.codCat, this.combobox_servic, this.precoUnitTextServ, this.cod_listarOrdemServico, this.Spinner_qnt_servic, NaturezaProduto, this.combobox_serie, this.codServ);
            if (UpdatIserirServic > 0) {
                this.carregar_tabela_listarOrdem();
                this.limpar_Dados_InserirServic();
            }
        }
    }

    @FXML
    private void enserirAcessorios() throws SQLException {
        int spinerQntSeAcess = Integer.parseInt(this.Spinner_qnt_acessorio.getValue().toString());
        String NaturezaProduto = "acessorios";
        this.BD_conect.executaSQL("SELECT cod_categoria FROM categoria_tab where nome_categoria='" + this.combobox_categoria_servic.getValue() + "'");
        while (this.BD_conect.resultset.next()) {
            this.codCat = Integer.valueOf(this.BD_conect.resultset.getString("cod_categoria"));
        }
        this.BD_conect.executaSQL("SELECT cod_acessorio FROM acessorios_tab where nome_acessorio='" + this.combobox_acessorios.getValue() + "'");
        while (this.BD_conect.resultset.next()) {
            this.codAcess_listar = Integer.valueOf(this.BD_conect.resultset.getString(1));
        }
        int UpdatIserirAcess = 0;
        UpdatIserirAcess = this.listarOrdem.inserir_listaOS(this.codCat, this.combobox_acessorios, this.precoUnitTextAcess, this.cod_listarOrdemServico, this.Spinner_qnt_acessorio, NaturezaProduto, this.combobox_serie, this.codAcess_listar);
        if (UpdatIserirAcess > 0) {
            this.carregar_tabela_listarOrdem();
            this.limpar_Dados_InserirAcess();
        }
    }

    @FXML
    private void Btn_ListaOrdem(ActionEvent event) throws SQLException {
        if (event.getSource() == this.Btn_GuardaOS) {
            this.BD_conect.executaSQL("select SUM(listarordemservico_tab.qnt_item) from listarordemservico_tab where listarordemservico_tab.cod_OrdemDeServic ='" + this.cod_listarOrdemServico + "'");
            while (this.BD_conect.resultset.next()) {
                this.Qnt_montante = this.BD_conect.resultset.getInt(1);
            }
            int UpdatICadastrarOS = 0;
            UpdatICadastrarOS = this.OrdemServ.cadastrar_OrdemServico(this.textFild_ref_equipamento, this.combobox_categoria_servic, this.textFild_cliente, this.combobox_local_exec, this.textA_Relator_Queixa, this.Qnt_montante, this.labelData.getText(), this.cod_listarOrdemServico);
            if (UpdatICadastrarOS > 0) {
                this.alert.setAlertType(Alert.AlertType.INFORMATION);
                this.alert.setContentText("Ordem De Servi\u00e7o Cadastrado Com Sucesso!!!");
                this.alert.show();
                this.BD_conect.executaSQL("SELECT * FROM ordemdeservi\u00e7o_tab");
                while (this.BD_conect.resultset.next()) {
                    this.cod_listarOrdemServico = this.BD_conect.resultset.getInt("cod_ordemServico") + 1;
                    this.Lbl_codNovaOrdem.setText(String.valueOf(this.cod_listarOrdemServico));
                }
                this.limpar_Dados_OrdemServc();
                this.carregar_tabela_listarOrdem();
            } else {
                this.alert.setAlertType(Alert.AlertType.ERROR);
                this.alert.setContentText("Erro na Emis\u00e3o de Uma O.S, Priencha os formul\u00e1rio Correctamente!!!");
                this.alert.show();
            }
        }
    }

    @FXML
    private void Selecionar_Image_CatListar(ActionEvent event) throws IOException, SQLException {
        if (event.getSource() == this.combobox_categoria_servic) {
            String nomecat_listar;
            switch (nomecat_listar = this.combobox_categoria_servic.getSelectionModel().getSelectedItem().toString()) {
                case "Print Service": {
               //     this.fontAwesome_categorias.setGlyphName("PRINT");
                    this.cod_categoria = "1";
                    break;
                }
                case "Pc Service": {
             //       this.fontAwesome_categorias.setGlyphName("LAPTOP");
                    this.cod_categoria = "2";
                    break;
                }
                case "Monitor Service": {
                //    this.fontAwesome_categorias.setGlyphName("TELEVISION");
                    this.cod_categoria = "3";
                    break;
                }
                case "Syber Service": {
          //          this.fontAwesome_categorias.setGlyphName("WIFI");
                    this.cod_categoria = "4";
                    break;
                }
                case "Network Service": {
           //         this.fontAwesome_categorias.setGlyphName("TTY");
                    this.cod_categoria = "5";
                }
            }
            this.combobox_servic.getItems().clear();
            this.combobox_serie.getItems().clear();
            this.BD_conect.executaSQL("SELECT nome_serie FROM series_tab WHERE cod_categoria = " + this.cod_categoria + " ");
            while (this.BD_conect.resultset.next()) {
                this.combobox_serie.getItems().addAll(new Object[]{this.BD_conect.resultset.getString("nome_serie")});
            }
        }
    }

    @FXML
    private void chamar_Combobox_Servicos(ActionEvent event) throws SQLException {
        if (event.getSource() == this.combobox_serie) {
            this.combobox_servic.getItems().clear();
            this.combobox_acessorios.getItems().clear();
            String nome_SerieLstar = "";
            nome_SerieLstar = (String)this.combobox_serie.getSelectionModel().getSelectedItem();
            if (!"".equals(nome_SerieLstar)) {
                this.BD_conect.executaSQL("SELECT * FROM series_tab WHERE nome_serie = '" + nome_SerieLstar + "'");
                while (this.BD_conect.resultset.next()) {
                    this.cod_identificador = this.BD_conect.resultset.getString("cod_identificador");
                }
            }
            this.BD_conect.executaSQL("SELECT * FROM servicos_tab WHERE cod_identificador = '" + this.cod_identificador + "'");
            while (this.BD_conect.resultset.next()) {
                this.combobox_servic.getItems().addAll(new Object[]{this.BD_conect.resultset.getString("nome_servico")});
            }
            this.BD_conect.executaSQL("SELECT * FROM acessorios_tab WHERE cod_identificador = '" + this.cod_identificador + "'");
            while (this.BD_conect.resultset.next()) {
                this.combobox_acessorios.getItems().addAll(new Object[]{this.BD_conect.resultset.getString("nome_acessorio")});
            }
        }
        this.BD_conect.statement.close();
    }

    @FXML
    private void Chamar_PrecoUnitServ(ActionEvent event) throws SQLException {
        if (!this.combobox_servic.getSelectionModel().isEmpty() && event.getSource() == this.combobox_servic) {
            this.textFild_precoUnit_serv.setText("");
            String text_servic = this.combobox_servic.getSelectionModel().getSelectedItem().toString();
            this.BD_conect.executaSQL("SELECT * FROM servicos_tab WHERE nome_servico = '" + text_servic + "'  AND cod_identificador = '" + this.cod_identificador + "'");
            while (this.BD_conect.resultset.next()) {
                this.textFild_precoUnit_serv.setText(this.f.format(this.BD_conect.resultset.getFloat("preco_unit")));
                this.precoUnitTextServ = this.BD_conect.resultset.getFloat("preco_unit");
            }
        }
        this.BD_conect.statement.close();
    }

    @FXML
    private void Chamar_PrecoUnitAcess(ActionEvent event) throws SQLException {
        if (event.getSource() == this.combobox_acessorios && !this.combobox_acessorios.getSelectionModel().isEmpty()) {
            this.textFild_precoUnit_acess.setText("");
            String text_assec = this.combobox_acessorios.getSelectionModel().getSelectedItem().toString();
            this.BD_conect.executaSQL("SELECT * FROM acessorios_tab WHERE nome_acessorio = '" + text_assec + "'AND cod_identificador = '" + this.cod_identificador + "'");
            while (this.BD_conect.resultset.next()) {
                this.textFild_precoUnit_acess.setText(this.f.format(this.BD_conect.resultset.getFloat("preco_unit")));
                this.precoUnitTextAcess = this.BD_conect.resultset.getFloat("preco_unit");
            }
        }
        this.BD_conect.statement.close();
    }

    public ObservableList<ListaOrdemServico> Load_ListarServOrdem() throws ClassNotFoundException, SQLException {
        Mysql.getConnection();
        ObservableList data = FXCollections.observableArrayList();
        String SQL_lista = "SELECT listarordemservico_tab.cod_listaordem,  categoria_tab.nome_categoria,  listarordemservico_tab.descricao_produto ,\n listarordemservico_tab.cod_OrdemDeServic,\n listarordemservico_tab.qnt_item, \n listarordemservico_tab.preco_unit, \n (listarordemservico_tab.preco_unit * listarordemservico_tab.qnt_item),\n listarordemservico_tab.tipo_produto, \n listarordemservico_tab.serie_produtoOS  \nFROM listarordemservico_tab,  ordemdeservi\u00e7o_tab, categoria_tab,  naturezaproduto_tab,  servicos_tab\nWHERE listarordemservico_tab.cod_OrdemDeServic = " + this.cod_listarOrdemServico + " \nAND categoria_tab.cod_categoria = listarordemservico_tab.cod_categoria\nGROUP BY listarordemservico_tab.cod_listaordem";
        try {
            this.BD_conect.executaSQL(SQL_lista);
            while (this.BD_conect.resultset.next()) {
                String tipo_de_item = this.BD_conect.resultset.getString(5);
                if (tipo_de_item.equals("servicos")) {
                    data.addAll((Object[])new ListaOrdemServico[]{new ListaOrdemServico(this.BD_conect.resultset.getInt(1), this.BD_conect.resultset.getString(2), this.BD_conect.resultset.getString(3), this.BD_conect.resultset.getInt(4), this.BD_conect.resultset.getInt(5), this.BD_conect.resultset.getFloat(6), this.BD_conect.resultset.getFloat(7), this.BD_conect.resultset.getString(8), this.BD_conect.resultset.getString(9), this.BD_conect.resultset.getInt(10))});
                    continue;
                }
                data.addAll((Object[])new ListaOrdemServico[]{new ListaOrdemServico(this.BD_conect.resultset.getInt(1), this.BD_conect.resultset.getString(2), this.BD_conect.resultset.getString(3), this.BD_conect.resultset.getInt(4), this.BD_conect.resultset.getInt(5), this.BD_conect.resultset.getFloat(6), this.BD_conect.resultset.getFloat(7), this.BD_conect.resultset.getString(8), this.BD_conect.resultset.getString(9), this.BD_conect.resultset.getInt(10))});
            }
        }
        catch (SQLException sQLException) {
            // empty catch block
        }
        this.BD_conect.statement.close();
        return data;
    }

    public void carregar_tabela_listarOrdem() throws SQLException {
        try {
            this.tableview_nova_SO.setItems(this.Load_ListarServOrdem());
            this.Lbl_codNovaOrdem.setText(String.valueOf(this.cod_listarOrdemServico));
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
    }

    private void limpar_Dados_InserirServic() {
        this.combobox_servic.getSelectionModel().select((Object)"");
        this.textFild_precoUnit_serv.setText("");
        SpinnerValueFactory.IntegerSpinnerValueFactory spininteger = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 1);
        this.Spinner_qnt_servic.setValueFactory((SpinnerValueFactory)spininteger);
    }

    private void limpar_Dados_InserirAcess() {
        this.combobox_acessorios.getSelectionModel().select((Object)"");
        this.textFild_precoUnit_acess.setText("");
        SpinnerValueFactory.IntegerSpinnerValueFactory spininteger = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 1);
        this.Spinner_qnt_acessorio.setValueFactory((SpinnerValueFactory)spininteger);
    }

    private void limpar_Dados_OrdemServc() {
        this.combobox_categoria_servic.getSelectionModel().select((Object)"");
        this.combobox_serie.getSelectionModel().select((Object)"");
        this.combobox_local_exec.getSelectionModel().select((Object)"");
        this.combobox_tecnico.getSelectionModel().select((Object)"");
        this.textA_Relator_Queixa.setText("");
        this.textFild_cliente.setText("");
        this.textFild_ref_equipamento.setText("");
        SpinnerValueFactory.IntegerSpinnerValueFactory spininteger = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 1);
        this.Spinner_qnt_acessorio.setValueFactory((SpinnerValueFactory)spininteger);
    }

    private boolean Numero_validation() {
        Pattern p = Pattern.compile("[a-zA-Z0-9]{12}");
        Matcher m = p.matcher(this.textField_nif_clinte.getText());
        if (m.find() && m.group().equals(this.textField_nif_clinte.getText())) {
            return true;
        }
        this.alert.setAlertType(Alert.AlertType.ERROR);
        this.alert.setContentText("Entroduza um NIF v\u00e1lido!");
        this.alert.show();
        return false;
    }

    private boolean email_validation() {
        Pattern p3 = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m3 = p3.matcher(this.textField_emailClinte.getText());
        if (m3.find() && m3.group().equals(this.textField_emailClinte.getText())) {
            return true;
        }
        this.alert.setAlertType(Alert.AlertType.ERROR);
        this.alert.setContentText("Entroduza Por Favor um Email V\u00e1lido!");
        this.alert.show();
        return false;
    }

    private boolean contact_validation() {
        Pattern p = Pattern.compile("(222|9)?[2-9][0-9]{8}");
        Matcher m = p.matcher(this.textField_contactMovClient.getText());
        Matcher m2 = p.matcher(this.textField_contactFixClient.getText());
        if (m.find() && m.group().equals(this.textField_contactMovClient.getText()) && m2.find() && m2.group().equals(this.textField_contactFixClient.getText())) {
            return true;
        }
        this.alert.setAlertType(Alert.AlertType.ERROR);
        this.alert.setContentText("Por Favor, Entroduza um Contacto Telefonico V\u00e1lido!");
        this.alert.show();
        return false;
    }

    @FXML
    private void setValorCorrete(MouseEvent event) throws ParseException {
        if (event.getSource() == this.textField_credit_cliente) {
            this.Metod_SetValorCorrete(this.textField_credit_cliente);
        }
        if (event.getSource() == this.textField_debito) {
            this.Metod_SetValorCorrete(this.textField_debito);
        }
        if (event.getSource() == this.textField_precCompraAcess) {
            this.Metod_SetValorCorrete(this.textField_precCompraAcess);
        }
        if (event.getSource() == this.textField_precVendaAcess) {
            this.Metod_SetValorCorrete(this.textField_precVendaAcess);
        }
        if (event.getSource() == this.textField_credit_forn) {
            this.Metod_SetValorCorrete(this.textField_credit_forn);
        }
        if (event.getSource() == this.textField_extorno) {
            this.Metod_SetValorCorrete(this.textField_extorno);
        }
    }

    @FXML
    private void setValor_naoCorrete(MouseEvent event) throws ParseException {
        if (event.getSource() == this.textField_credit_cliente) {
            this.Metod_SetNaoValorCorrete(this.textField_credit_cliente);
        }
        if (event.getSource() == this.textField_debito) {
            this.Metod_SetNaoValorCorrete(this.textField_debito);
        }
        if (event.getSource() == this.textField_precCompraAcess) {
            this.Metod_SetNaoValorCorrete(this.textField_precCompraAcess);
        }
        if (event.getSource() == this.textField_precVendaAcess) {
            this.Metod_SetNaoValorCorrete(this.textField_precVendaAcess);
        }
        if (event.getSource() == this.textField_credit_forn) {
            this.Metod_SetNaoValorCorrete(this.textField_credit_forn);
        }
        if (event.getSource() == this.textField_extorno) {
            this.Metod_SetNaoValorCorrete(this.textField_extorno);
        }
    }

    private void Metod_SetNaoValorCorrete(TextField textfield) throws ParseException {
        if (!"".equals(textfield.getText())) {
            try {
                Number myNumber1 = this.f.parse(textfield.getText());
                int v1 = Integer.valueOf(myNumber1.toString());
                textfield.setText(String.valueOf(v1));
            }
            catch (NumberFormatException | ParseException e) {
                this.alert.setAlertType(Alert.AlertType.ERROR);
                this.alert.setContentText(e.getMessage());
                this.alert.show();
            }
        }
    }

    private void Metod_SetValorCorrete(TextField textfield) throws ParseException {
        try {
            int v2 = Integer.parseInt(textfield.getText());
            if (!"".equals(textfield.getText())) {
                textfield.setText(String.valueOf(this.f.format(v2)));
            }
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }

    @FXML
    private void cadastra_Cliente(ActionEvent event) throws IOException, SQLException, ParseException, ClassNotFoundException {
        if (event.getSource() == this.btn_guardar_clien && this.contact_validation() && this.email_validation() && this.Numero_validation()) {
            this.cadastrar_Cliente();
        }
        if (event.getSource() == this.btn_novo_clien) {
            this.limpar_Dados_Clien();
        }
        if (event.getSource() == this.btn_eliminar_clien) {
            this.cliente.eliminar_Cad_Client(this.tableView_Cliente, this.icon2, this.fis1_2);
            this.carregar_tabelaClien();
            this.limpar_Dados_Clien();
        }
    }

    private void cadastrar_Cliente() throws IOException, SQLException, ParseException, ClassNotFoundException {
        this.BD_conect.executaSQL("SELECT * FROM perso_juridica_tab where nome_perso_juridica='" + this.combobox_PersonJuri.getValue() + "'");
        while (this.BD_conect.resultset.next()) {
            this.intCodPersoJurid_Clie = Integer.valueOf(this.BD_conect.resultset.getString("cod_perso_juridica"));
            int n = 0;
            n = this.cliente.cadastrar_Client(this.textField_nomeCliente, this.intCodPersoJurid_Clie, this.textField_emailClinte, this.textField_enderecClliente, this.textField_contactMovClient, this.textField_contactFixClient, this.text_src_foto_clien, (ToggleButton)this.togglebtn_activ_cad_clien, this.textField_nif_clinte, this.textField_credit_cliente, this.textField_debito, this.textA_descricaoCliente, this.fis2);
            if (n <= 0) continue;
            try {
                if (!"img_indisponivel.png".equals(this.fis2.getName()) && this.fis2.getName() != null) {
                    this.cliente.copía_Foto(this.text_src_foto_clien, this.fis2.getName());
                }
            }
            catch (ClassCastException | NullPointerException e) {
                this.alert.setAlertType(Alert.AlertType.ERROR);
                this.alert.setContentText("Imagem nao encontrada");
                this.alert.show();
            }
            this.carregar_tabelaClien();
            this.limpar_Dados_Clien();
        }
        this.BD_conect.resultset.close();
    }

    @FXML
    private void selectTable_Clien(MouseEvent event) throws ClassNotFoundException, SQLException {
        try {
            this.cliente = (Clientes)this.tableView_Cliente.getSelectionModel().getSelectedItem();
            this.textField_codCliente.setText(String.valueOf(this.cliente.getCod_Cliente()));
            this.textField_nomeCliente.setText(this.cliente.getNome_Cliente());
            this.textField_emailClinte.setText(this.cliente.getEmail_Cliente());
            this.textField_enderecClliente.setText(this.cliente.getEndereco_Cliente());
            this.textField_contactMovClient.setText(String.valueOf(this.cliente.getContact1_Cliente()));
            this.textField_contactFixClient.setText(String.valueOf(this.cliente.getContact2_Cliente()));
            this.textField_nif_clinte.setText(this.cliente.getNif());
            this.textField_credit_cliente.setText(String.valueOf(this.f.format(this.cliente.getCredito_Cliente())));
            this.textField_debito.setText(String.valueOf(this.f.format(this.cliente.getDebito_Cliente())));
            this.togglebtn_activ_cad_clien.setSelected(this.cliente.getStatus_Cliente());
            this.textA_descricaoCliente.setText(this.cliente.getDescricao_Cliente());
            this.combobox_PersonJuri.getSelectionModel().select((Object)this.cliente.getPerso_juridica());
            if ("".equals(this.cliente.getImagem_Cliente()) || "img_indisponivel.png".equals(this.cliente.getImagem_Cliente()) || null == this.cliente.getImagem_Cliente()) {
                this.cliente.setImagem_Cliente("img_indisponivel.png");
                this.imageView_cad_clien.setImage(this.cliente.reset_foto(this.icon2));
            } else {
                this.fis1_2 = new File("src/co/ao/foto_src/" + this.cliente.getImagem_Cliente());
                this.imageView_cad_clien.setImage(this.cliente.setFoto(this.icon2, this.fis1_2));
                this.fornecedor.setImagem_fornecedor(this.fornecedor.getImagem_fornecedor());
            }
        }
        catch (NullPointerException e) {
            this.alert.setAlertType(Alert.AlertType.INFORMATION);
            this.alert.setContentText("Selecione um Dado na Tabela");
            this.alert.show();
        }
        this.BD_conect.statement.close();
    }

    @FXML
    public void actualizar_cadast_client(ActionEvent event) throws IOException, ClassNotFoundException, SQLException, ParseException {
        if (event.getSource() == this.btn_actualizar_clien) {
            try {
                if (!"img_indisponivel.png".equals(this.fis2.getName()) && this.fis2.getName() != null) {
                    this.cliente.actulizar_foto_Client(this.text_src_foto_clien, this.fis2, this.fis1_2);
                }
            }
            catch (ClassCastException | NullPointerException e) {
                this.alert.setAlertType(Alert.AlertType.ERROR);
                this.alert.setContentText("Imagem n\u00e3o encontrada" + e.getMessage());
                this.alert.show();
            }
            if (!this.tableView_Cliente.isDisabled()) {
                try {
                    this.BD_conect.executaSQL("SELECT * FROM perso_juridica_tab where nome_perso_juridica='" + this.combobox_PersonJuri.getValue() + "'");
                    while (this.BD_conect.resultset.next()) {
                        this.intCodPersoJurid_Clie = Integer.valueOf(this.BD_conect.resultset.getString("cod_perso_juridica"));
                        int n = this.cliente.actualizar_Client(this.tableView_Cliente, this.textField_nomeCliente, this.intCodPersoJurid_Clie, this.textField_emailClinte, this.textField_enderecClliente, this.textField_contactMovClient, this.textField_contactFixClient, this.text_src_foto_clien, (ToggleButton)this.togglebtn_activ_cad_clien, this.textField_nif_clinte, this.textField_credit_cliente, this.textField_debito, this.textA_descricaoCliente, this.fis2);
                        if (n <= 0) continue;
                        this.carregar_tabelaClien();
                        this.alert.setAlertType(Alert.AlertType.INFORMATION);
                        this.alert.setContentText("Dados Actualizado Correctamente!");
                        this.alert.show();
                        this.limpar_Dados_Clien();
                        this.carregar_tabelaClien();
                    }
                }
                catch (SQLException e) {
                    this.alert.setAlertType(Alert.AlertType.ERROR);
                    this.alert.setContentText("ERRO" + e.getMessage());
                    this.alert.show();
                }
            }
        }
        this.BD_conect.statement.close();
    }

    @FXML
    public void carregar_foto_Clien(MouseEvent event) {
        try {
            Window FileChooser2 = null;
            this.text_src_foto_clien = this.busca_foto_Cliente.showOpenDialog(FileChooser2).getPath();
            this.fis2 = new File(this.text_src_foto_clien);
            this.icon2 = new Image(this.fis2.toURI().toString());
            if (this.text_src_foto_clien != null) {
                this.imageView_cad_clien.setImage(this.icon2);
                this.BD_conect.executaSQL("Select count(imagem_cliente) AS contagem FROM clientes_tab WHERE imagem_cliente LIKE 'Clien_%'");
                while (this.BD_conect.resultset.next()) {
                    this.imagens_BDClient = this.BD_conect.resultset.getInt(1);
                }
                this.fis2 = this.imagens_BDClient != 0 ? new File("Clien_".concat(String.valueOf(this.imagens_BDClient + 1)) + this.fis2.getName()) : new File("Clien_".concat(String.valueOf(this.imagens_BDClient + 1)) + this.fis2.getName());
            }
        }
        catch (NullPointerException | SQLException exception) {
            // empty catch block
        }
    }

    public ObservableList<Clientes> loadDataClien() throws ClassNotFoundException, SQLException {
        Mysql.getConnection();
        ObservableList data = FXCollections.observableArrayList();
        String SQL1 = "SELECT  cod_cliente,  nome_cliente, perso_juridica_tab.nome_perso_juridica,  email_cliente, endereco_cliente, contacto1_cliente, contacto2_cliente, credito_cliente, debito_cliente,   descricao_cliente, nif_cliente, imagem_cliente, status_cliente FROM clientes_tab, perso_juridica_tab WHERE perso_juridica_tab.cod_perso_juridica = clientes_tab.perso_juridica";
        this.BD_conect.executaSQL(SQL1);
        try {
            while (this.BD_conect.resultset.next()) {
                data.add((Object)new Clientes(this.BD_conect.resultset.getInt(1), this.BD_conect.resultset.getString(2), this.BD_conect.resultset.getString(3), this.BD_conect.resultset.getString(4), this.BD_conect.resultset.getString(5), this.BD_conect.resultset.getInt(6), this.BD_conect.resultset.getInt(7), this.BD_conect.resultset.getFloat(8), this.BD_conect.resultset.getFloat(9), this.BD_conect.resultset.getString(10), this.BD_conect.resultset.getString(11), this.BD_conect.resultset.getString(12), this.BD_conect.resultset.getBoolean(13)));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Tela_LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public void carregar_tabelaClien() {
        try {
            this.tableView_Cliente.setItems(this.loadDataClien());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void limpar_Dados_Clien() {
        this.combobox_PersonJuri.getSelectionModel().select((Object)"");
        this.textField_codCliente.setText("");
        this.textField_nomeCliente.setText("");
        this.textField_emailClinte.setText("");
        this.textField_enderecClliente.setText("");
        this.textField_contactMovClient.setText("");
        this.textField_contactFixClient.setText("");
        this.textField_nif_clinte.setText("");
        this.textField_credit_cliente.setText(String.valueOf(this.f.format(0L)));
        this.textField_debito.setText(String.valueOf(this.f.format(0L)));
       // this.togglebtn_activ_cad_clien.setSelected(false);
        this.textA_descricaoCliente.setText("");
        this.imageView_cad_clien.setImage(this.cliente.reset_foto(this.icon1));
        fis2 = new File("src/co/ao/foto_src/img_indisponivel.png");
        icon2 = new Image(fis2.toURI().toString());
        this.carregar_tabelaClien();
    }

    private void cadastrarForn_Bd() throws IOException, SQLException, ClassNotFoundException, ParseException {
        this.BD_conect.executaSQL("SELECT * FROM perso_juridica_tab where nome_perso_juridica='" + this.combobox_PersonJuri_forn.getValue() + "'");
        while (this.BD_conect.resultset.next()) {
            this.combox_int_perso_forn = Integer.valueOf(this.BD_conect.resultset.getString("cod_perso_juridica"));
            int n = 0;
            n = this.fornecedor.cadastrar_forn(this.textField_nomeForn, this.combox_int_perso_forn, this.textField_email_Forn, this.textField_enderecForn, this.textField_contactMovForn, this.textField_contactFix_forn, this.text_src_foto_forn, (ToggleButton)this.togglebtn_activ_cad_forn, this.textField_nif_forn, this.textField_credit_forn, this.textField_extorno, this.textA_descricao_forn, this.icon3, this.fis3);
            if (n <= 0) continue;
            try {
                if (!"img_indisponivel.png".equals(this.fis3.getName()) && this.fis3.getName() != null) {
                    this.fornecedor.copia_Foto(this.text_src_foto_forn, this.fis3.getName());
                }
            }
            catch (ClassCastException | NullPointerException e) {
                this.alert.setAlertType(Alert.AlertType.ERROR);
                this.alert.setContentText("Imagem nao encontrada");
                this.alert.show();
            }
            this.carregar_tabelaForn();
            this.limpar_Dados_Forn();
        }
        this.BD_conect.resultset.close();
    }

    @FXML
    private void selectTable_fornc(MouseEvent event) throws ClassNotFoundException, SQLException {
        try {
            this.fornecedor = (Fornecedor)this.tableView_forn.getSelectionModel().getSelectedItem();
            this.textField_nomeForn.setText(this.fornecedor.getNome_fornecedor());
            this.textField_email_Forn.setText(this.fornecedor.getEmail_fornecedor());
            this.textField_enderecForn.setText(this.fornecedor.getEndereco_fornecedor());
            this.textField_contactMovForn.setText(String.valueOf(this.fornecedor.getContact1_fornecedor()));
            this.textField_contactFix_forn.setText(String.valueOf(this.fornecedor.getContact2_fornecedor()));
            this.textField_nif_forn.setText(String.valueOf(this.fornecedor.getNif()));
            this.textField_codForn.setText(String.valueOf(this.fornecedor.getCod_fornecedor()));
            this.textField_credit_forn.setText(String.valueOf(this.f.format(this.fornecedor.getValor_credito_forn())));
            this.textField_extorno.setText(String.valueOf(this.f.format(this.fornecedor.getValor_extorno_forn())));
            this.togglebtn_activ_cad_forn.setSelected(this.fornecedor.isStatus());
            this.textA_descricao_forn.setText(this.fornecedor.getDescricao_fornec());
            this.combobox_PersonJuri_forn.getSelectionModel().select((Object)this.fornecedor.getPerso_juridica());
            if ("".equals(this.fornecedor.getImagem_fornecedor()) || "img_indisponivel.png".equals(this.fornecedor.getImagem_fornecedor()) || null == this.fornecedor.getImagem_fornecedor()) {
                this.fornecedor.setImagem_fornecedor("img_indisponivel.png");
                this.imageView_cad_forn.setImage(this.fornecedor.reset_foto(this.icon3));
            } else {
                this.fis1_3 = new File("src/co/ao/foto_src/" + this.fornecedor.getImagem_fornecedor());
                this.imageView_cad_forn.setImage(this.fornecedor.setFoto(this.icon3, this.fis1_3));
                this.fornecedor.setImagem_fornecedor(this.fornecedor.getImagem_fornecedor());
            }
        }
        catch (NullPointerException e) {
            this.alert.setAlertType(Alert.AlertType.INFORMATION);
            this.alert.setContentText("Selecione um Dado na Tabela");
            this.alert.show();
        }
        this.BD_conect.statement.close();
    }

    @FXML
    public void actualizar_cadast_for(ActionEvent event) throws IOException, ClassNotFoundException, SQLException, ParseException {
        block7: {
            if (event.getSource() == this.btn_actualizar_forn) {
                try {
                    if (this.tableView_forn.isDisabled()) break block7;
                    try {
                        this.BD_conect.executaSQL("SELECT * FROM perso_juridica_tab where nome_perso_juridica='" + this.combobox_PersonJuri_forn.getValue() + "'");
                        while (this.BD_conect.resultset.next()) {
                            this.combox_int_perso_forn = Integer.valueOf(this.BD_conect.resultset.getString("cod_perso_juridica"));
                            int n = this.fornecedor.actualizar_forn(this.tableView_forn, this.textField_nomeForn, this.combox_int_perso_forn, this.textField_email_Forn, this.textField_enderecForn, this.textField_contactMovForn, this.textField_contactFix_forn, this.text_src_foto_forn, (ToggleButton)this.togglebtn_activ_cad_forn, this.textField_nif_forn, this.textField_credit_forn, this.textField_extorno, this.textA_descricao_forn, this.fis3);
                            if (n <= 0) continue;
                            if (!"img_indisponivel.png".equals(this.fis3.getName()) && this.fis3.getName() != null) {
                                this.fornecedor.actulizar_foto_forn(this.text_src_foto_forn, this.fis3, this.fis1_3);
                            }
                            this.alert.setAlertType(Alert.AlertType.INFORMATION);
                            this.alert.setContentText("Dados Actualizado Correctamente!");
                            this.alert.show();
                            this.limpar_Dados_Forn();
                            this.carregar_tabelaForn();
                        }
                    }
                    catch (SQLException e) {
                        this.alert.setAlertType(Alert.AlertType.ERROR);
                        this.alert.setContentText(e.getMessage());
                        this.alert.show();
                    }
                }
                catch (ClassCastException | NullPointerException e) {
                    this.alert.setAlertType(Alert.AlertType.ERROR);
                    this.alert.setContentText("Imagem n\u00e3o encontrada" + e.getMessage());
                    this.alert.show();
                }
            }
        }
        this.BD_conect.statement.close();
    }

    public ObservableList<Fornecedor> loadDataForn() throws ClassNotFoundException, SQLException {
        try {
            Mysql.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ObservableList data = FXCollections.observableArrayList();
        String SQL1 = "SELECT  cod_fornecedor,  nome_fornecedor, perso_juridica_tab.nome_perso_juridica, email_fornec, contactoMovel_forn, contactoFixo_forn, valor_credito_fornec, valor_extorno_fornec, endereco_fornec, nif_fornec,  descricao_fornec, imagem_fornec, status_fornec FROM fornecedor_tab, perso_juridica_tab WHERE perso_juridica_tab.cod_perso_juridica = fornecedor_tab.perso_juridica";
        this.BD_conect.executaSQL(SQL1);
        try {
            while (this.BD_conect.resultset.next()) {
                data.add((Object)new Fornecedor(this.BD_conect.resultset.getInt(1), this.BD_conect.resultset.getString(2), this.BD_conect.resultset.getString(3), this.BD_conect.resultset.getString(4), this.BD_conect.resultset.getInt(5), this.BD_conect.resultset.getInt(6), this.BD_conect.resultset.getFloat(7), this.BD_conect.resultset.getFloat(8), this.BD_conect.resultset.getString(9), this.BD_conect.resultset.getString(10), this.BD_conect.resultset.getString(11), this.BD_conect.resultset.getString(12), this.BD_conect.resultset.getBoolean(13)));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Tela_LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public void carregar_tabelaForn() {
        try {
            this.tableView_forn.setItems(this.loadDataForn());
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Tela_LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void carregar_foto_Forn(MouseEvent event) {
        try {
            Window FileChooser2 = null;
            this.text_src_foto_forn = this.busca_foto_fornec.showOpenDialog(FileChooser2).getPath();
            this.fis3 = new File(this.text_src_foto_forn);
            this.icon3 = new Image(this.fis3.toURI().toString());
            if (this.text_src_foto_forn != null) {
                this.imageView_cad_forn.setImage(this.icon3);
                this.BD_conect.executaSQL("Select count(imagem_fornec) AS contagem FROM Fornecedor_tab WHERE imagem_fornec LIKE 'Fornec_%'");
                while (this.BD_conect.resultset.next()) {
                    this.imagens_BDFor = this.BD_conect.resultset.getInt(1);
                }
                this.fis3 = this.imagens_BDFor != 0 ? new File("Fornec_".concat(String.valueOf(this.imagens_BDFor + 1)) + this.fis3.getName()) : new File("Fornec_".concat(String.valueOf(this.imagens_BDFor + 1)) + this.fis3.getName());
            }
        }
        catch (NullPointerException | SQLException exception) {
            // empty catch block
        }
    }

    @FXML
    private void cadastra_forn(ActionEvent event) throws IOException, SQLException, ClassNotFoundException, ParseException {
        if (event.getSource() == this.btn_guardar_forn) {
            this.cadastrarForn_Bd();
        }
        if (event.getSource() == this.btn_novo_forn) {
            this.limpar_Dados_Forn();
        }
        if (event.getSource() == this.btn_eliminar_forn) {
            this.fornecedor.eliminar_Cad_forn(this.tableView_forn, this.icon3, this.fis1_3);
            this.carregar_tabelaForn();
            this.limpar_Dados_Forn();
        }
    }

    public void limpar_Dados_Forn() {
        this.combobox_PersonJuri_forn.getSelectionModel().select((Object)"");
        this.textField_nomeForn.setText("");
        this.textField_email_Forn.setText("");
        this.textField_enderecForn.setText("");
        this.textField_contactMovForn.setText("");
        this.textField_contactFix_forn.setText("");
        this.textField_nif_forn.setText("");
        this.textField_credit_forn.setText(String.valueOf(this.f.format(0L)));
        this.textField_extorno.setText(String.valueOf(this.f.format(0L)));
        this.textField_codForn.setText("");
        this.togglebtn_activ_cad_forn.setSelected(false);
        this.textA_descricao_forn.setText("");
        this.imageView_cad_forn.setImage(this.fornecedor.reset_foto(this.icon1));
        fis3 = new File("src/co/ao/foto_src/img_indisponivel.png");
        icon3 = new Image(fis3.toURI().toString());
        this.carregar_tabelaForn();
        
    }

    @FXML
    private void chamar_ComboboxSerieCadastro(ActionEvent event) throws IOException, SQLException {
        if (event.getSource() == combobox_categ_acess) {
            String nomecat;
            switch (nomecat = this.combobox_categ_acess.getSelectionModel().getSelectedItem().toString()) {
                case "Print Service": {
                 //   fontAwesome_acess.setGlyphName("PRINT");
                    cod_categoria_CadasAcess = "1";
                    break;
                }
                case "Pc Service": {
     //               fontAwesome_acess.setGlyphName("LAPTOP");
                    cod_categoria_CadasAcess = "2";
                    break;
                }
                case "Monitor Service": {
           //         fontAwesome_acess.setGlyphName("TELEVISION");
                    cod_categoria_CadasAcess = "3";
                    break;
                }
                case "Syber Service": {
              //      fontAwesome_acess.setGlyphName("WIFI");
                    cod_categoria_CadasAcess = "4";
                    break;
                }
                case "Network Service": {
             //       this.fontAwesome_acess.setGlyphName("TTY");
                    this.cod_categoria_CadasAcess = "5";
                }
            }
            this.combobox_SerieAcess.getItems().clear();
            this.BD_conect.executaSQL("SELECT * FROM series_tab WHERE cod_categoria = " + this.cod_categoria_CadasAcess + " ");
            while (this.BD_conect.resultset.next()) {
                combobox_SerieAcess.getItems().addAll(new Object[]{this.BD_conect.resultset.getString("nome_serie")});
            }
        }
        this.BD_conect.statement.close();
    }

    public ObservableList<Acessorios> loadDataAcess() throws ClassNotFoundException, SQLException {
        try {
            Mysql.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ObservableList data = FXCollections.observableArrayList();
        String SQL1 = "SELECT  cod_acessorio,  nome_acessorio, categoria_tab.nome_categoria, series_tab.nome_serie, cod_barra,  descricao_acessorio, imagem_acessorio, fornecedor, status_acessorios, preco_compra, preco_unit FROM acessorios_tab, categoria_tab, series_tab WHERE acessorios_tab.cod_categoria = categoria_tab.cod_categoria  AND acessorios_tab.serie_acessorio = series_tab.cod_serie ";
        this.BD_conect.executaSQL(SQL1);
        try {
            while (BD_conect.resultset.next()) {
                data.add((Object)new Acessorios(BD_conect.resultset.getInt(1), BD_conect.resultset.getString(2), BD_conect.resultset.getString(3), BD_conect.resultset.getString(4), BD_conect.resultset.getString(5), this.BD_conect.resultset.getString(6), BD_conect.resultset.getString(7), BD_conect.resultset.getString(8), BD_conect.resultset.getBoolean(9), BD_conect.resultset.getFloat(10), BD_conect.resultset.getFloat(11)));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Tela_LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public void carregar_tabelaAcess() {
        try {
            tableView_Acess.setItems(loadDataAcess());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void carregar_Identificador() throws SQLException {
    try {
        combobox_IdentifcadorAcess.getItems().clear();
        BD_conect.executaSQL("SELECT series_tab.cod_identificador FROM series_tab WHERE nome_serie = '" + combobox_SerieAcess.getValue() + "'");
        while (BD_conect.resultset.next()) {
            String Identificador = BD_conect.resultset.getString(1);
            combobox_IdentifcadorAcess.getSelectionModel().select((Object)Identificador);
        }
    }
    catch (SQLException sQLException) {
        // empty catch block
    }
  }

    @FXML
    private void selectTable_Acess(MouseEvent event) throws ClassNotFoundException, SQLException {
    try {
        acessorio = (Acessorios)tableView_Acess.getSelectionModel().getSelectedItem();
        textField_codAcess.setText(String.valueOf(acessorio.getCod_acessorios()));
        textField_nomeAcess.setText(acessorio.getNome_acessorio());
        textField_FornecAcess.setText(acessorio.getFornecedor());
        textField_codBarraAcess.setText(String.valueOf(acessorio.getCod_barra()));
        textField_precCompraAcess.setText(String.valueOf(f.format(acessorio.getPrecCompraAcess())));
        textField_precVendaAcess.setText(String.valueOf(this.f.format(acessorio.getPrecVendaAcess())));
        togglebtn_activ_cadAcess.setSelected(acessorio.isStatus_acessorio());
        textA_descridescricaoUser.setText(acessorio.getDescricao_acessorio());
        combobox_categ_acess.getSelectionModel().select((Object)acessorio.getCod_categoria());
        combobox_SerieAcess.getSelectionModel().select((Object)acessorio.getCod_Serie());
        if ("".equals(acessorio.getImagem_acessorio()) || "img_indisponivel.png".equals(acessorio.getImagem_acessorio()) || null == acessorio.getImagem_acessorio()) {
            acessorio.setImagem_acessorio("img_indisponivel.png");
            imageView_cadaAcess.setImage(acessorio.reset_foto(icon4));
        } else {
            fis1_4 = new File("src/co/ao/foto_src/" + acessorio.getImagem_acessorio());
            imageView_cadaAcess.setImage(acessorio.setFoto(icon4, fis1_4));
            acessorio.setImagem_acessorio(acessorio.getImagem_acessorio());
        }
    }
    catch (NullPointerException e) {
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setContentText("Selecione um Dado na Tabela");
        alert.show();
    }
    this.BD_conect.statement.close();
    }

    @FXML
    private void Btns_Acessorios(ActionEvent event) throws IOException, SQLException, ClassNotFoundException, ParseException {
        if (event.getSource() == btn_guardar_acess) {
            cadastrar_Acessorio();
        }
        if (event.getSource() == btn_novo_acess) {
            limpar_DadosAcess();
        }
        if (event.getSource() == btn_eliminar_acess) {
            acessorio.eliminar_CadAcessorio(tableView_Acess, icon_local, fis1_4);
            carregar_tabelaAcess();
            limpar_DadosAcess();
        }
        if (event.getSource() == btn_actualizar_acess) {
            actualizar_cadast_Acess();
            carregar_tabelaAcess();
            limpar_DadosAcess();
        }
    }

    private void cadastrar_Acessorio() throws IOException, SQLException, ParseException, ClassNotFoundException {
        BD_conect.executaSQL("SELECT cod_categoria FROM categoria_tab where nome_categoria='" + combobox_categ_acess.getValue() + "'");
        while (BD_conect.resultset.next()) {
            codCategoria_cadastrar = Integer.valueOf(BD_conect.resultset.getString(1));
            BD_conect.executaSQL("SELECT cod_serie FROM series_tab where nome_serie='" + combobox_SerieAcess.getValue() + "'");
            while (BD_conect.resultset.next()) {
                int codSerie_cadastrar = Integer.valueOf(BD_conect.resultset.getString(1));
                int n = 0;
                n = acessorio.cadastrar_Acessorio(textField_nomeAcess, codCategoria_cadastrar, textField_codBarraAcess, codSerie_cadastrar, textField_precCompraAcess, textField_precVendaAcess, textA_descridescricaoUser, textField_FornecAcess, cod_categoria_CadasAcess, (ToggleButton)togglebtn_activ_cadAcess, fis4);
                if (n <= 0) continue;
                try {
                    if (!"img_indisponivel.png".equals(fis4.getName()) && fis4.getName() != null) {
                        acessorio.copía_Foto(text_src_foto_acess, fis4.getName());
                    }
                }
                catch (ClassCastException | NullPointerException e) {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("Imagem nao encontrada");
                    alert.show();
                }
                carregar_tabelaAcess();
                limpar_DadosAcess();
            }
        }
        BD_conect.resultset.close();
    }

    public void actualizar_cadast_Acess() throws IOException, ClassNotFoundException, SQLException, ParseException {
        
            try {
                if (tableView_Acess.isDisabled()) 
                try {
                    BD_conect.executaSQL("SELECT cod_categoria FROM categoria_tab where nome_categoria='" + combobox_categ_acess.getValue() + "'");
                    while (BD_conect.resultset.next()) {
                        int codCategori = Integer.valueOf(BD_conect.resultset.getString(1));
                        BD_conect.executaSQL("SELECT cod_serie, cod_identificador FROM series_tab where nome_serie='" + combobox_SerieAcess.getValue() + "'");
                        while (BD_conect.resultset.next()) {
                            String codSerie_identific;
                            int codSerie_cadastrar = Integer.valueOf(BD_conect.resultset.getString(1));
                            int n = acessorio.actualizar_Acess(tableView_Acess, textField_nomeAcess, codCategori, textField_codBarraAcess, codSerie_cadastrar, textField_precCompraAcess, textField_precVendaAcess, textA_descricaoAcess, this.textField_FornecAcess, (ToggleButton)this.togglebtn_activ_cadAcess, codSerie_identific = this.BD_conect.resultset.getString(2), this.fis4);
                            if (n <= 0) continue;
                            alert.setAlertType(Alert.AlertType.INFORMATION);
                            alert.setContentText("Dados Actualizado Correctamente!");
                            alert.show();
                            try {
                                if (!"img_indisponivel.png".equals(fis4.getName()) && fis4.getName() != null) {
                                    acessorio.actulizar_foto_Acess(text_src_foto_acess, fis4, fis1_4);
                                }
                            }
                            catch (ClassCastException | NullPointerException e) {
                                alert.setAlertType(Alert.AlertType.ERROR);
                                alert.setContentText("Imagem nao encontrada" + e.getMessage());
                                alert.show();
                            }
                            limpar_DadosAcess();
                            carregar_tabelaAcess();
                        }
                    }
                }
                catch (SQLException e) {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText(e.getMessage());
                    alert.show();
                }
            }
            catch (ClassCastException | NullPointerException e) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Erro ao Actualizar:" + e.getMessage());
                alert.show();
            
        }
        this.BD_conect.statement.close();
    }

    @FXML
    public void carregar_foto_Acessorio(MouseEvent event) {
        try {
            Window FileChooser2 = null;
            text_src_foto_acess = busca_foto_Acess.showOpenDialog(FileChooser2).getPath();
            fis4 = new File(text_src_foto_acess);
            icon4 = new Image(fis4.toURI().toString());
            if (text_src_foto_acess != null) {
                imageView_cadaAcess.setImage(icon4);
                BD_conect.executaSQL("Select count(imagem_acessorio) AS contagem FROM acessorios_tab WHERE imagem_acessorio LIKE 'Acess_%'");
                while (BD_conect.resultset.next()) {
                    imagens_BDAces = BD_conect.resultset.getInt(1);
                }
                fis4 = imagens_BDAces != 0 ? new File("Acess_".concat(String.valueOf(imagens_BDAces + 1)) + fis4.getName()) : new File("Acess_".concat(String.valueOf(imagens_BDAces + 1)) + fis4.getName());
            }
        }
        catch (NullPointerException | SQLException exception) {
            // empty catch block
        }
    }

    @FXML
    private void limpar_DadosAcess() throws IOException, SQLException, ClassNotFoundException {
        textField_codAcess.setText("");
        combobox_categ_acess.getSelectionModel().select((Object)"");
        combobox_SerieAcess.getSelectionModel().select((Object)"");
        textField_nomeAcess.setText("");
        textField_FornecAcess.setText("");
        textField_codBarraAcess.setText("");
        textField_precCompraAcess.setText(String.valueOf(f.format(0L)));
        textField_precVendaAcess.setText(String.valueOf(f.format(0L)));
        textA_descridescricaoUser.setText("");
        imageView_cadaAcess.setImage(acessorio.reset_foto(icon1));
        carregar_tabelaAcess();
        fis4 = new File("src/co/ao/foto_src/img_indisponivel.png");
        icon4 = new Image(fis4.toURI().toString());
    }

    @FXML
    public void ChamarTelaCliente(ActionEvent event) throws IOException, NullPointerException, SQLException {
        if (event.getSource() == btn_ChamarCliente) {
            try {
                config.id_user = usuario_actual.getCod_user();
                config.user_ID = usuario_actual.getUser_ID();
                config.nome_user = usuario_actual.getNome_user();
                config.imagema_user = usuario_actual.getImagem_user();
                config.prioridade_user = usuario_actual.getPrioridade();
                FileOutputStream arquivo = new FileOutputStream("src/co/ao/ficheiros/config.dat");
                ObjectOutputStream obj_dados = new ObjectOutputStream(arquivo);
                obj_dados.writeObject((Object)config);
                obj_dados.flush();
            }
            catch (IOException arquivo) {
                // empty catch block
            }
            GaussianBlur blur_2 = new GaussianBlur();
            blur_2.setRadius(10.0);
            Launch_Service.scenePrincipal.getRoot().setEffect((Effect)blur_2);
            Launch_Service.Primary_stage.setScene(Launch_Service.scenePrincipal);
            try {
                Parent tela_cliente = (Parent)FXMLLoader.load((URL)getClass().getResource("/co/ao/telas/Tela_SetCliente.fxml"));
                Scene_ChamarCliente = new Scene(tela_cliente);
                stage_TelaCliente = new Stage();
                stage_TelaCliente.initStyle(StageStyle.UNDECORATED);
                stage_TelaCliente.initModality(Modality.APPLICATION_MODAL);
                stage_TelaCliente.setScene(Scene_ChamarCliente);
                stage_TelaCliente.showAndWait();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

     
      //----------------------- PAINEL CADASTRO USUÁRIO --------------------------------
    @FXML
    public void carregar_foto_Usuario(MouseEvent event) {
        try {
            Window FileChooser2 = null;
            text_src_foto_user = busca_foto_User.showOpenDialog(FileChooser2).getPath();
            fis5 = new File(text_src_foto_user);
            icon5 = new Image(fis5.toURI().toString());
            if (text_src_foto_user != null) {
            imageView_cad_User.setImage(icon5);
            BD_conect.executaSQL("Select count(imagem_usuario) AS contagem FROM usuario_tab WHERE imagem_usuario LIKE 'User_%'");
            while (BD_conect.resultset.next()) {
                imagens_BDUser = BD_conect.resultset.getInt(1);
                }
                fis5 = imagens_BDUser != 0 ? new File("User_".concat(String.valueOf(imagens_BDUser + 1)) + fis5.getName()) : new File("User_".concat(String.valueOf(imagens_BDUser + 1)) + fis5.getName());
            }
        }
        catch (NullPointerException | SQLException exception) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Erro ao Carregar imagem:" + exception.getMessage());
            alert.show();
        }
    }

    public ObservableList<Usuario> loadDataUser() throws ClassNotFoundException, SQLException {
        Mysql.getConnection();
        ObservableList data = FXCollections.observableArrayList();
        String SQL1 = "SELECT nome_usuario, prioridade_tab.nome_prioridade, cod_usuario,  email_usuario, senha_pin_usuario,  \nimagem_usuario, status_usuario, user_ID, descricao_usuario, funcao_tab.nome_funcao, lojas_tab.descricao_loja, contact_user, ordenadorDeLogin\n"
                    + "FROM usuario_tab, prioridade_tab, funcao_tab, lojas_tab \n"
                    + "WHERE usuario_tab.prioridade_usuario =  prioridade_tab.cod_prioridade \n"
                    + "AND usuario_tab.cod_funcao  =  funcao_tab.cod_funcao "
                    + "AND usuario_tab.local_a_operar = lojas_tab.cod_loja ";
        BD_conect.executaSQL(SQL1);
        try {
            while (BD_conect.resultset.next()) {
             data.add((Object)new Usuario(BD_conect.resultset.getString(1), BD_conect.resultset.getString(2), BD_conect.resultset.getInt(3), BD_conect.resultset.getString(4), BD_conect.resultset.getString(5), BD_conect.resultset.getString(6), BD_conect.resultset.getBoolean(7), BD_conect.resultset.getString(8), this.BD_conect.resultset.getString(9), BD_conect.resultset.getString(10), BD_conect.resultset.getString(11), BD_conect.resultset.getInt(12), BD_conect.resultset.getInt(13)));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Tela_LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public void carregar_tabelaUser() {
        try {
            tableView_User.setItems(loadDataUser());
        }
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Tela_LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Btns_Usuarios(ActionEvent event) throws IOException, SQLException, ClassNotFoundException, ParseException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        if (event.getSource() == btn_guardar_User) {
            cadastrar_User();
            carregar_tabelaUser();
            limpar_DadosUser();
        }
        if (event.getSource() == btn_novo_User) {
            limpar_DadosUser();
        }
        if (event.getSource() == btn_eliminar_User) {
            usuario.eliminar_BD_User(tableView_User, icon_local,fis1_5);
            // Neste codigo Eliminamos o user do ordenador de usuario no login e actualizamos os restantes       
            usuario.ordenadorConsult(tableView_User.getSelectionModel().getSelectedItem().getOrdenadorDeLogin());
            carregar_tabelaUser();
            limpar_DadosUser();
        }
        if (event.getSource() == btn_actualizar_User) {
            actualizar_cadastUser();
            carregar_tabelaUser();
            limpar_DadosUser();
        }
    }



    public ObservableList<String> loadDatacombo() throws ClassNotFoundException {
        ObservableList data = FXCollections.observableArrayList();
        try {
            BD_conect.executaSQL("SELECT * FROM prioridade_tab where nome_prioridade= '" + combobox_PrioridadeUser.getValue() + "'");
            while (BD_conect.resultset.next()) {
                cod_prioridade = Integer.valueOf(BD_conect.resultset.getString("cod_prioridade"));
            }
            BD_conect.executaSQL("SELECT nome_funcao FROM funcao_tab WHERE cod_prioridade='" + cod_prioridade + "'");
            while (BD_conect.resultset.next()) {
                data.addAll((Object[])new String[]{BD_conect.resultset.getString(1)});
            }
        }
        catch (NumberFormatException | SQLException exception) {
            this.alert.setAlertType(Alert.AlertType.ERROR);
            this.alert.setContentText(exception.getMessage());
            this.alert.show();
        }
        return data;
    }

    private void combopri() {
        try {
            combobox_funcao_user.setItems(loadDatacombo());
            combobox_funcao_user.getSelectionModel().select(0);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Tela_principalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void combobox_prioridade(ActionEvent event) {
        if (event.getSource() == combobox_PrioridadeUser) {
            this.combopri();
        }
    }

private void cadastrar_User() throws IOException, SQLException, ParseException, ClassNotFoundException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
    EncriptorAndDecriptor_Class encriptar = new EncriptorAndDecriptor_Class();
    String AESencript = EncriptorAndDecriptor_Class.AESencript((String) passwordField_user.getText(), (String)"user_ID");

    BD_conect.executaSQL("SELECT cod_loja FROM lojas_tab where descricao_loja='" + combobox_loja_a_operar.getValue() + "'");
    while (BD_conect.resultset.next()) {
     int cod_loja = Integer.valueOf(BD_conect.resultset.getString(1));
        BD_conect.executaSQL("SELECT cod_funcao FROM funcao_tab where nome_funcao='" + combobox_funcao_user.getValue() + "'");
        while (BD_conect.resultset.next()) {
            int cod_funcaouUser = Integer.valueOf(BD_conect.resultset.getString(1));
            BD_conect.executaSQL("SELECT cod_prioridade FROM prioridade_tab where nome_prioridade='" + combobox_PrioridadeUser.getValue() + "'");
            while (BD_conect.resultset.next()) {
                int combox_int_prioridade = Integer.valueOf(BD_conect.resultset.getString(1));
                int n = 0;
                n = usuario.cadastrar_User(tableView_User, textField_nomeUser, combox_int_prioridade, cod_funcaouUser, textField_emailUser, textField_UserId, AESencript,
                                           text_src_foto_user, (ToggleButton)togglebtn_activ_cad_User, textA_descridescricaoUser, fis5, cod_loja);
                if (n <= 0);
                try {
                    if (!"img_indisponivel.png".equals(fis5.getName()) && fis5.getName() != null) {
                        usuario.copía_Foto(text_src_foto_user, fis5.getName());
                    }
                }
                catch (ClassCastException | NullPointerException e) {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("Imagem n\u00e3o encontrada");
                    alert.show();
                }
                carregar_tabelaAcess();
                limpar_DadosAcess();
            }
        }
    }
   BD_conect.resultset.close();
    }

    public void actualizar_cadastUser() throws IOException, ClassNotFoundException, SQLException, ParseException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, BadPaddingException {
        block8: {
            try {
                if (tableView_Acess.isDisabled()) break block8;
                EncriptorAndDecriptor_Class encriptar = new EncriptorAndDecriptor_Class();
                String AESencript = EncriptorAndDecriptor_Class.AESencript((String)passwordField_user.getText(), (String)"user_ID");
                BD_conect.executaSQL("SELECT cod_loja FROM lojas_tab where descricao_loja='" + combobox_loja_a_operar.getValue() + "'");
                while (BD_conect.resultset.next()) {
                    int cod_loja = Integer.valueOf(BD_conect.resultset.getString(1));
                    BD_conect.executaSQL("SELECT cod_funcao FROM funcao_tab where nome_funcao='" + combobox_funcao_user.getValue() + "'");
                    while (BD_conect.resultset.next()) {
                        int cod_funcaouUser = Integer.valueOf(BD_conect.resultset.getString(1));
                        BD_conect.executaSQL("SELECT cod_prioridade FROM prioridade_tab where nome_prioridade='" + combobox_PrioridadeUser.getValue() + "'");
                        while (BD_conect.resultset.next()) {
                            int combox_int_prioridade = Integer.valueOf(BD_conect.resultset.getString(1));
                            int n = 0;
                            n = usuario.actualizar_User(tableView_User, textField_nomeUser, combox_int_prioridade, textField_emailUser, textField_UserId, AESencript, text_src_foto_user, (ToggleButton)togglebtn_activ_cad_User, textA_descridescricaoUser, cod_funcaouUser, icon5, fis5, cod_loja);
                            if (n <= 0) continue;
                            try {
                                if (!"img_indisponivel.png".equals(fis5.getName()) && fis5.getName() != null) {
                                    acessorio.actulizar_foto_Acess(text_src_foto_user, fis5, fis1_5);
                                }
                            }
                            catch (ClassCastException | NullPointerException e) {
                                alert.setAlertType(Alert.AlertType.ERROR);
                                alert.setContentText("Imagem n\u00e3o encontrada" + e.getMessage());
                                alert.show();
                            }
                            this.carregar_tabelaAcess();
                            this.limpar_DadosAcess();
                        }
                    }
                }
                BD_conect.resultset.close();
            }
            catch (ClassCastException | NullPointerException e) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Erro ao Actualizar:" + e.getMessage());
                alert.show();
            }
        }
        BD_conect.statement.close();
    }

    @FXML
    private void selectTable_User(MouseEvent event) throws ClassNotFoundException, SQLException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException {
        EncriptorAndDecriptor_Class dencriptar = new EncriptorAndDecriptor_Class();
        try {
            usuario = (Usuario)tableView_User.getSelectionModel().getSelectedItem();
            String AESDencript = EncriptorAndDecriptor_Class.AESdecript((String)usuario.getSenha_pin(), (String)"user_ID");
            textField_codUser.setText(String.valueOf(usuario.getCod_user()));
            textField_nomeUser.setText(usuario.getNome_user());
            combobox_PrioridadeUser.getSelectionModel().select((Object)usuario.getPrioridade());
            textField_UserId.setText(usuario.getUser_ID());
            textField_contactMovUser.setText(String.valueOf(usuario.getContact_1()));
            combobox_loja_a_operar.getSelectionModel().select((Object)usuario.getLocal_a_Operar());
            textField_emailUser.setText(usuario.getEmail_user());
            combobox_funcao_user.getSelectionModel().select((Object)usuario.getFuncao());
            passwordField_user.setText(AESDencript);
            passwordFieldRepita_user.setText(AESDencript);
            togglebtn_activ_cad_User.setSelected(usuario.isStatus());
            textA_descridescricaoUser.setText(usuario.getDescricao());
            if ("".equals(usuario.getImagem_user()) || "img_indisponivel.png".equals(usuario.getImagem_user()) || null == usuario.getImagem_user()) {
                usuario.setImagem_user("img_indisponivel.png");
                imageView_cad_User.setImage(usuario.reset_foto(icon5));
            } else {
                fis1_5 = new File("src/co/ao/foto_src/" + usuario.getImagem_user());
                imageView_cad_User.setImage(usuario.setFoto(icon5, fis1_5));
                usuario.setImagem_user(usuario.getImagem_user());
            }
        }
        catch (NullPointerException e) {
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setContentText("Selecione um Dado na Tabela" + e.getMessage());
            alert.show();
        }
        BD_conect.statement.close();
    }

    @FXML
    private void limpar_DadosUser() throws IOException, SQLException, ClassNotFoundException {
        textField_codUser.setText("");
        textField_nomeUser.setText("");
        combobox_PrioridadeUser.getSelectionModel().select((Object)"");
        textField_UserId.setText(usuario.getUser_ID());
        textField_contactMovUser.setText("");
        combobox_loja_a_operar.getSelectionModel().select((Object)"");
        textField_emailUser.setText("");
        combobox_funcao_user.getSelectionModel().select((Object)"");
        passwordField_user.setText("");
        passwordFieldRepita_user.setText("");
        togglebtn_activ_cad_User.setSelected(false);
        textA_descridescricaoUser.setText("");
        textField_UserId.setText("");
        imageView_cad_User.setImage(usuario.reset_foto(icon1));
        fis5 = new File("src/co/ao/foto_src/img_indisponivel.png");
        icon5 = new Image(fis5.toURI().toString());
        carregar_tabelaAcess();
    }

    public ObservableList<ListaOrdemServico> Load_ListarServOrdemiMPRIMIR() throws ClassNotFoundException, SQLException {
        Mysql.getConnection();
        ObservableList data = FXCollections.observableArrayList();
        String SQL_lista = "SELECT listarordemservico_tab.cod_listaordem,  categoria_tab.nome_categoria,  listarordemservico_tab.descricao_produto ,\n listarordemservico_tab.cod_OrdemDeServic,\n listarordemservico_tab.qnt_item, \n listarordemservico_tab.preco_unit, \n (listarordemservico_tab.preco_unit * listarordemservico_tab.qnt_item),\n listarordemservico_tab.tipo_produto, \n listarordemservico_tab.serie_produtoOS , \n listarordemservico_tab.ItemPago  \n FROM listarordemservico_tab,  ordemdeservi\u00e7o_tab, categoria_tab,  naturezaproduto_tab,  servicos_tab\nWHERE listarordemservico_tab.cod_OrdemDeServic = " + this.codItensImp + " \nAND categoria_tab.cod_categoria = listarordemservico_tab.cod_categoria\nGROUP BY listarordemservico_tab.cod_listaordem";
        try {
            BD_conect.executaSQL(SQL_lista);
            while (BD_conect.resultset.next()) {
                String tipo_de_item = BD_conect.resultset.getString(5);
                if (tipo_de_item.equals("servi\u00e7os")) {
                    data.addAll((Object[])new ListaOrdemServico[]{new ListaOrdemServico(BD_conect.resultset.getInt(1), BD_conect.resultset.getString(2), this.BD_conect.resultset.getString(3), this.BD_conect.resultset.getInt(4), this.BD_conect.resultset.getInt(5), this.BD_conect.resultset.getFloat(6), this.BD_conect.resultset.getFloat(7), this.BD_conect.resultset.getString(8), this.BD_conect.resultset.getString(9), this.BD_conect.resultset.getInt(10))});
                    continue;
                }
                data.addAll((Object[])new ListaOrdemServico[]{new ListaOrdemServico(BD_conect.resultset.getInt(1), BD_conect.resultset.getString(2), this.BD_conect.resultset.getString(3), this.BD_conect.resultset.getInt(4), this.BD_conect.resultset.getInt(5), this.BD_conect.resultset.getFloat(6), this.BD_conect.resultset.getFloat(7), this.BD_conect.resultset.getString(8), this.BD_conect.resultset.getString(9), this.BD_conect.resultset.getInt(10))});
            }
        }
        catch (SQLException sQLException) {
            // empty catch block
        }
        this.BD_conect.statement.close();
        return data;
    }

    private void Medt_ConsultImprimir() throws SQLException {
        this.listOrd.clear();
        this.BD_conect.executaSQL("SELECT ordemdeservi\u00e7o_tab.cod_ordemServico, categoria_tab.nome_categoria, categoria_tab.imagem_cat, ordemdeservi\u00e7o_tab.referencia_equipamento, ordemdeservi\u00e7o_tab.nome_cliente,ordemdeservi\u00e7o_tab.StatusOS\n FROM ordemdeservi\u00e7o_tab, categoria_tab where ordemdeservi\u00e7o_tab.nome_cliente= '" + this.Combobox_listarOrd_Impr.getValue() + "' AND\nordemdeservi\u00e7o_tab.nome_Categoria = categoria_tab.nome_categoria\nGROUP BY ordemdeservi\u00e7o_tab.cod_ordemServico");
        while (BD_conect.resultset.next()) {
            codItensImp = BD_conect.resultset.getInt(1);
            Label_NomeTipo.setText(BD_conect.resultset.getString(2));
          //  FontAwIconVie_Imprimir.setGlyphName(BD_conect.resultset.getString(3));
            Lbl_descric_Item_Impri.setText(BD_conect.resultset.getString(4));
            Lbl_nomeCliente_Impr.setText(BD_conect.resultset.getString(5));
            Textfield_Status_SO.setText(BD_conect.resultset.getString(6));
        }
    }

    @FXML
    private void Medt_ListarItensImprimir() throws SQLException, ClassNotFoundException {
        montant = 0.0f;
        vPago = 0.0f;
        mont = 0.0f;
        listOrd.clear();
        Checkbox_selectAll.setSelected(true);
        Medt_ConsultImprimir();
        Lbl_NumOrdemServic.setText(String.valueOf(codItensImp));
        Load_ListarServOrdemiMPRIMIR();
        int column = 0;
        int row = 0;
        GridPane.getChildren().clear();
        listOrd.addAll((Collection<ListaOrdemServico>)Load_ListarServOrdemiMPRIMIR());
        ArrayList list = new ArrayList();
        for (int i = 0; i < listOrd.size(); ++i) {
            try {
                FXMLLoader fxmloader = new FXMLLoader();
                fxmloader.setLocation(this.getClass().getResource("/co/ao/telas/Iten.fxml"));
                anchoPane = new AnchorPane();
                anchoPane = (AnchorPane)fxmloader.load();
                itenController = (ItemController)fxmloader.getController();
                itenController.setData(listOrd.get(i), myListner);
                itenController.Checkbox.setSelected(true);
                mont += listOrd.get(i).getMontante_listaOrdem();
                column = 0;
            }
            catch (IOException ex) {
                ex.getMessage();
            }
            int n = ++row;
            ++row;
            this.GridPane.add((Node)anchoPane, column, n);
            javafx.scene.layout.GridPane.setMargin((Node)anchoPane, (Insets)new Insets(5.0));
            this.GridPane.setMinWidth(-1.0);
            this.GridPane.setPrefWidth(-1.0);
            this.GridPane.setMaxWidth(-1.0);
            this.GridPane.setMinHeight(-1.0);
            this.GridPane.setPrefHeight(-1.0);
            this.GridPane.setMaxHeight(-1.0);
            this.montant += this.itenController.montante;
            if (listOrd.get(i).isItemPago() != 1) continue;
            this.vPago += this.listOrd.get(i).getMontante_listaOrdem();
        }
        this.TextFieldl_MontanteItens.setText(String.valueOf(this.f.format(this.mont)) + " Kz");
        if (this.montant > 0.0f) {
            this.Lbl_ValorPorPagar.setText(String.valueOf(this.f.format(this.montant)));
            this.Lbl_ValorPorPagar.setStyle("-fx-text-fill: #D75764");
            this.vlorNotaFiscal = this.montant;
        } else {
            this.Lbl_ValorPorPagar.setText(String.valueOf(this.f.format(this.montant)));
            this.Lbl_ValorPorPagar.setStyle("-fx-text-fill: #546BAA");
            this.vlorNotaFiscal = this.montant;
        }
        this.Lbl_vPago.setStyle("-fx-text-fill: #546BAA");
        this.Lbl_vPago.setText(String.valueOf(this.vPago));
    }

    @FXML
    private void Medt_ListarItensImprimir_2() throws SQLException, ClassNotFoundException {
        this.listOrd.clear();
        this.mon = 0.0f;
        this.Medt_ConsultImprimir();
        this.Lbl_NumOrdemServic.setText(String.valueOf(this.codItensImp));
        this.Load_ListarServOrdemiMPRIMIR();
        int column = 0;
        int row = 0;
        this.GridPane.getChildren().clear();
        this.listOrd.addAll((Collection<ListaOrdemServico>)this.Load_ListarServOrdemiMPRIMIR());
        for (int i = 0; i < this.listOrd.size(); ++i) {
            try {
                FXMLLoader fxmloader = new FXMLLoader();
                fxmloader.setLocation(this.getClass().getResource("/co/ao/telas/Iten.fxml"));
                this.anchoPane = new AnchorPane();
                this.anchoPane = (AnchorPane)fxmloader.load();
                this.itenController = (ItemController)fxmloader.getController();
                this.itenController.setData(this.listOrd.get(i), this.myListner);
                if (this.listOrd.get(i).isItemPago() == 0) {
                    this.itenController.Checkbox.setSelected(false);
                    ListaOrdemServico OrdensNaoPago = new ListaOrdemServico();
                    OrdensNaoPago.setMontante_listaOrdem(this.listOrd.get(i).getMontante_listaOrdem());
                    this.mont -= this.listOrd.get(i).getMontante_listaOrdem();
                    column = 0;
                }
            }
            catch (IOException ex) {
                ex.getMessage();
            }
            int n = ++row;
            ++row;
            this.GridPane.add((Node)this.anchoPane, column, n);
            javafx.scene.layout.GridPane.setMargin((Node)this.anchoPane, (Insets)new Insets(5.0));
            this.GridPane.setMinWidth(-1.0);
            this.GridPane.setPrefWidth(-1.0);
            this.GridPane.setMaxWidth(-1.0);
            this.GridPane.setMinHeight(-1.0);
            this.GridPane.setPrefHeight(-1.0);
            this.GridPane.setMaxHeight(-1.0);
        }
        this.TextFieldl_MontanteItens.setText(String.valueOf(this.f.format(this.mont)) + " Kz");
    }

    private void setChosenOrdem(ListaOrdemServico ListOrdemServico, boolean checkbox) {
        this.mont = checkbox ? (this.mont += ListOrdemServico.getMontante_listaOrdem()) : (this.mont -= ListOrdemServico.getMontante_listaOrdem());
        this.TextFieldl_MontanteItens.setText(this.f.format(this.mont) + " Kz");
    }

    private void ConsultaDValorNotF() throws SQLException {
    }

    @FXML
    private void ChamarTelaCobrar(ActionEvent event) throws IOException, NullPointerException, SQLException {
        if (event.getSource() == this.Btn_DedTroco) {
            try {
                this.config.id_user = this.usuario_actual.getCod_user();
                this.config.user_ID = this.usuario_actual.getUser_ID();
                this.config.nome_user = this.usuario_actual.getNome_user();
                this.config.imagema_user = this.usuario_actual.getImagem_user();
                this.config.prioridade_user = this.usuario_actual.getPrioridade();
                this.config.valor_notaFiscal = this.vlorNotaFiscal;
                FileOutputStream arquivo = new FileOutputStream("src/co/ao/ficheiros/config.dat");
                ObjectOutputStream obj_dados = new ObjectOutputStream(arquivo);
                obj_dados.writeObject((Object)this.config);
                obj_dados.flush();
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
            GaussianBlur blur_2 = new GaussianBlur();
            blur_2.setRadius(10.0);
            Launch_Service.scenePrincipal.getRoot().setEffect((Effect)blur_2);
            Launch_Service.Primary_stage.setScene(Launch_Service.scenePrincipal);
            try {
                Parent tela_pagmt = (Parent)FXMLLoader.load((URL)this.getClass().getResource("/co/ao/telas/Tela_Cobrar.fxml"));
                this.Scene_telaCobrar = new Scene(tela_pagmt);
                stage_TelaCobrar = new Stage();
                stage_TelaCobrar.initStyle(StageStyle.UNDECORATED);
                stage_TelaCobrar.initModality(Modality.APPLICATION_MODAL);
                stage_TelaCobrar.setScene(this.Scene_telaCobrar);
                stage_TelaCobrar.showAndWait();
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @FXML
    private void MetdRegistarPgmt() {
    }
}
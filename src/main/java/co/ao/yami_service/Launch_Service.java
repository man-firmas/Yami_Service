package co.ao.yami_service;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Launch_Service extends Application {
    public static Stage Primary_stage = null;
    public static Scene scenePrincipal;
    public static Scene scenePrincipal_2;
    public static Scene sceneLogin;
    public static Scene sceneLogin_1;
    public static final String CURRENCY = " Kz";

    @Override
    public void start(Stage stage) throws IOException {
      Primary_stage = stage;
         Image imagemIcon = new Image("/sistel_logo.png");
       Primary_stage.getIcons().add(imagemIcon);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Telas/Tela_Login.fxml")));
        sceneLogin = new Scene(root);

        Parent root_1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Telas/Tela_principal.fxml")));
        sceneLogin_1 = new Scene(root_1);

        Parent telaPrincipal = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Telas/Tela_Login.fxml")));
        scenePrincipal = new Scene(telaPrincipal);

        Parent telaPrincipal_2 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Telas/Tela_Login.fxml")));
        scenePrincipal_2 = new Scene(telaPrincipal_2);


        stage.initStyle(StageStyle.UNDECORATED);
        stage.centerOnScreen();
        stage.setScene(sceneLogin);
        stage.show();

        /* Codigo que permiteu minimizar o aplicativo apartir da barra de tarefa (Rackeado)
       long lhwnd = com.sun.glass.ui.Window.getWindows().get(0).getNativeWindow();
        PointerInfo lpVoid = new Pointer(lhwnd);
        WinDef.HWND hwnd = new WinDef.HWND(lpVoid);
        final User32 user32 = User32.INSTANCE;
        int oldStyle = user32.GetWindowLong(hwnd, WinUser.GWL_STYLE);
        //   System.out.println(Integer.toBinaryString(oldStyle));
        int newStyle = oldStyle | 0x00020000;//WS_MINIMIZEBOX
        //     System.out.println(Integer.toBinaryString(newStyle));
        user32.SetWindowLong(hwnd, WinUser.GWL_STYLE, newStyle);*/
    }

    public static void ChengeScreen(String src, Object userData, Object userData2, Object userData3, Object userData4){
        switch(src){
            case "tela_Login":
                Primary_stage.setScene(sceneLogin);
                Primary_stage.centerOnScreen();
                notifyListiners("tela_Login", userData, null,null, null);
                break;
            case "tela_Login_1":
                GaussianBlur blur = new GaussianBlur();
                blur.setRadius(15);
                sceneLogin_1.getRoot().setEffect(blur);
                Primary_stage.setScene(sceneLogin_1);
                Primary_stage.centerOnScreen();
                notifyListiners("tela_Login_1", userData,null,null, null);
                break;
            case "tela_Principal":
                Primary_stage.setScene(scenePrincipal);
                Primary_stage.centerOnScreen();
                notifyListiners("tela_Principal",userData ,userData2,userData3, userData4);
                break;
            case "tela_Principal_2":
                GaussianBlur blur_2 = new GaussianBlur();
                blur_2.setRadius(15);
                scenePrincipal_2.getRoot().setEffect(blur_2);
                Primary_stage.setScene(scenePrincipal_2);
                Primary_stage.centerOnScreen();
                notifyListiners("tela_Principal_2", userData, null,null, null);
                break;

        }
    }
    public static void ChengeScreen(String src){
        ChengeScreen(src, null,null,null, null);
    }

    private static final ArrayList<onChangeScreen> listeners=new ArrayList<>();

    public interface onChangeScreen{
        void onScreenChange(String newCreen, Object object_1, Object object_2, Object object_3, Object object_4 );
    }

    public static void addChangeListener(onChangeScreen newListiners){
        listeners.add(newListiners);
    }

    private static void notifyListiners(String newString, Object userData_1, Object object_2, Object object_3,Object object_4){
        listeners.forEach((l) -> l.onScreenChange(newString, userData_1, object_2, object_3,object_4));
    }

    //
    public static void main(String[] args) {
        launch();
    }
}
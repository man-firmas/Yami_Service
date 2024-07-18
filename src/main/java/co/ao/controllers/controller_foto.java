
package co.ao.controllers;

import java.io.File;
import javafx.scene.image.Image;

/**
 *
 * @author firmi
 */
public class controller_foto {
    
    public Image reset_foto (Image icon){
       File file = new File("src/co/ao/foto_src/img_indisponivel.png");
        icon = new Image(file.toURI().toString());
     return icon;
   }
   public Image setFoto (Image icon, File file){
   icon = new Image(file.toURI().toString(),false);
  
    return icon;
   }
   
 public Image setFoto2 (Image icon, File file){
   icon = new Image(file.toURI().toString(), 60, 68, false, false);
  
    return icon;
   }
   
}

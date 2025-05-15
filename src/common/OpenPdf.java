package common;

import deo.StoreUtils;
import java.io.File;
import javax.swing.JOptionPane;

public class OpenPdf {
    
    public static void OpenByID(String id) {
        try {
          
            File pdfFile = new File(StoreUtils.billpath + id + ".pdf");
            if (pdfFile.exists()) {
                String os = System.getProperty("os.name").toLowerCase();
                
                if (os.contains("win")) {
                    
                    Runtime.getRuntime().exec("cmd /c start " + pdfFile.getAbsolutePath());
                } else if (os.contains("mac")) {
                  
                    Runtime.getRuntime().exec("open " + pdfFile.getAbsolutePath());
                } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
                    
                    Runtime.getRuntime().exec("xdg-open " + pdfFile.getAbsolutePath());
                } else {
                    JOptionPane.showMessageDialog(null, "Unsupported OS");
                }
            } else {
                JOptionPane.showMessageDialog(null, "File doesn't exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

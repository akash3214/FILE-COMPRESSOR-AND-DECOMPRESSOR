/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compressor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
/**
 *
 * @author Admin
 */
public class compressor {
    public static void method(File file, String name) throws IOException{
        String filedirectory = file.getParent();
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(filedirectory+"//"+name+".gz");
        GZIPOutputStream gzip = new GZIPOutputStream(fos);
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer))!=-1){
            gzip.write(buffer, 0, len);
        }
        gzip.close();
        fis.close();
        fos.close();
    }
}

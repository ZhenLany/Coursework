package Model;


import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.*;
import java.util.ArrayList;


public class ReadWriteFile {
    Window window;
    Factory f =new Factory();
    public ReadWriteFile(Window w){
        window=w;
    }
    public void Save(ArrayList<ObjPackage> AOR){
        FileChooser fileChooser = new FileChooser();
        File path = new File("Saves");
       fileChooser.initialDirectoryProperty().set(path);
        fileChooser.setTitle("Выберите файл...");
        fileChooser.setInitialFileName("Package");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Date Files", "*.dat"),
                new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file=fileChooser.showSaveDialog(window);
        if (file != null) {
            try(FileOutputStream fos=new FileOutputStream( file)) {
                for (var a:AOR) {
                    byte[] buffer =(f.NumObjPackage(a.getClass().toString())+":/"+a.h+":/"+a.w+":/"+a.c+":/"+a.ox+":/"+a.oy+":/"+a.Name+":/"+a.Place+"\n").getBytes();
                    fos.write(buffer);
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        //Image image = new Image(loadImageFile.toURI().toString());
       // Pn.getChildren().add(new ImageView(image));
    }
    public ArrayList<ObjPackage> Load(){
        ArrayList<ObjPackage> AOR=new ArrayList<ObjPackage>();
        FileChooser fileChooser = new FileChooser();
        File path = new File("Saves");
        fileChooser.initialDirectoryProperty().set(path);
        fileChooser.setTitle("Загрузка диаграмм в формате dat");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Date Files", "*.dat"),
               new FileChooser.ExtensionFilter("Text Files", "*.txt"));
//                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
//                new FileChooser.ExtensionFilter("All Files", "*.*"));
        //fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Текст", "*.txt"));
        //fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Изображение", "*.png"));
        File file = fileChooser.showOpenDialog(window);
        if (file != null) {
            try{BufferedReader fos = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(file), "UTF-8")) ;
//                FileInputStream fos=new FileInputStream(file);
                    int i=-1;
                    String s="";
                    while((i=fos.read())!=-1){
                        System.out.print((char)i);
                      s+=(char)i;
                      if((char)i=='\n'){
                          String[] temp=s.split(":/");
                          s="";
                          AOR.add(f.getObjPackage(Integer.parseInt(temp[0]) ,Double.parseDouble(temp[1]),Double.parseDouble(temp[2]),Color.web(temp[3]),Double.parseDouble(temp[4]),Double.parseDouble(temp[5]),temp[6],1+""));
                      }
                    }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return AOR;
    }

}

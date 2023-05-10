package Model;

import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.text.Text;


public class ObjPackage1S extends ObjPackage {

    public ObjPackage1S(){
        Name="Папка";
    }
    @Override
    public void draw(Pane p) {
//        Rectangle rname=new Rectangle(w/3,h/5,c);
//        rname.setLayoutX(ox);
//        rname.setLayoutY(oy);
//        Rectangle r=new Rectangle(w,h,c);
//        r.setLayoutX(ox);
//        r.setLayoutY(oy);
//        p.getChildren().add(r);
//        shape =r;

        Path path=new Path();
        path.getElements().addAll(
                new MoveTo(0,20),
                new LineTo(0,0),
                new LineTo(75,0),
                new LineTo(75,20),
                new LineTo(w,20),
                new LineTo(w,h),
                new LineTo(0,h),
                new LineTo(0,20),
                new LineTo(75,20),
                new ClosePath());
        path.setLayoutX(ox);
        path.setLayoutY(oy);
        path.setFill(c);
        p.getChildren().add(path);
        Text l=new Text(Name);
        l.setLayoutX(ox+3);
        l.setLayoutY(oy+13);
        p.getChildren().add(l);
        shape =path;
    }
}

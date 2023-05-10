package Model;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ObjPackage4S extends ObjPackage {

    public ObjPackage4S() {
        Name="Надпись";
    }
    @Override
    public void draw(Pane p) {
        Text text=new Text();
        text.setText(Name);
        if(w!=60. && h!=15.)
        if (Place.equals("1")){

            ox=ox+w;
            oy=oy+h-15;
        }
        else if (Place.equals("2")){
            ox=ox+w;
            oy=oy-15;
        }
        else if (Place.equals("3")){
            oy=oy+h-15;
        }
        else if(Place.equals("6")) {
            oy=oy-15;
        }
        w=60.;
        h=15.;
        //text.strokeWidthProperty().set(5);
        text.setStroke(c);
        //text.wrappingWidthProperty().set(75);
//        text.setX(45);
        text.setY(15);
//        text.minWidth(45);
//        text.minHeight(15);
        text.setLayoutX(ox);
        text.setLayoutY(oy);
        text.setFill(c);
        p.getChildren().add(text);
        shape =text;
    }
}

package Model;

import javafx.scene.layout.Pane;
import javafx.scene.shape.*;


public class ObjPackage2S extends ObjPackage {

    public ObjPackage2S() {
        Name = "Стрелка";
    }

    @Override
    public void draw(Pane p) {
//        Rectangle r=new Rectangle(w,h,c);
//        r.setLayoutX(ox);
//        r.setLayoutY(oy);
//        p.getChildren().add(r);
        Path path = new Path();
        Path lines = new Path();

        path.getStrokeDashArray().addAll(10d, 20d);
        if (Place.equals("1")) {
            path.getElements().addAll(
                    new MoveTo(0, 0),
                    new LineTo(w, h),
                    new ClosePath());
            lines=drawArrowend(0, 0,w, h);
        }
        else if (Place.equals("2")){
            path.getElements().addAll(
                    new MoveTo(0, h),
                    new LineTo(w, 0),
                    new ClosePath());
            lines=drawArrowend(0, h,w, 0);
        }
        else if (Place.equals("3")){
            path.getElements().addAll(
                    new MoveTo(w, 0),
                    new LineTo(0, h),
                    new ClosePath());
            lines=drawArrowend(w, 0,0, h);

        }
        else if (Place.equals("6")) {
            path.getElements().addAll(
                    new MoveTo(w, h),
                    new LineTo(0, 0),
                    new ClosePath());
            lines=drawArrowend(w, h,0, 0);
        }
        path.setStroke(c);
        lines.setStroke(c);
        path.setLayoutX(ox);
        path.setLayoutY(oy);
        lines.setLayoutX(ox);
        lines.setLayoutY(oy);
        path.setStrokeWidth(2);
        // path.setStrokeType();setLineDashes
        p.getChildren().add(path);
        p.getChildren().add(lines);
        shape = path;

    }


    public Path drawArrowend(double startX,double startY,double endX,double endY) {
        Path lines = new Path();
        double angle = Math.atan2((endY - startY), (endX - startX)) - Math.PI / 2.0;

        double sin = Math.sin(angle);

        double cos = Math.cos(angle);

        //point1
        double arrowHeadSize = 12;

        double x1 = (-1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + endX;

        double y1 = (-1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + endY;

        //point2

        double x2 = (1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + endX;

        double y2 = (1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + endY;
        lines.getElements().addAll(
                new MoveTo(endX, endY),
                new LineTo(x1, y1),
                new MoveTo(x2, y2),
                new LineTo(endX, endY),
                new ClosePath());
        return lines;
    }

}
//
//public class ArrowAssotioon extends Shape {
//
//    double arrowHeadSize;// размер кончика стрелки
//
//    public ArrowAssotioon() {
//        this.color = Color.BLACK;
//
//
//// определение пропорций кончика стрелки
//
//        //arrowHeadSize=1.5*Math.sqrt((startX-endX)*(startX-endX)+(startX-endX)*(startX-endX));
//        //  if (arrowHeadSize<2)arrowHeadSize=0.146*start.distance(end);
//        //  if (arrowHeadSize<2)arrowHeadSize=0.236*start.distance(end);
//        arrowHeadSize=12.5;
//    }
//    @Override
//    public void draw(GraphicsContext gc) {
//
//        drawArrowstart( gc);//начало стрелки
//
//        drawLine(gc);//линия
//
//        drawArrowend(gc);//коней стрелки
//
//    }
//
//    public String toString() {
//
//        return "Зависимость";   }
//
//    public void drawArrowstart(GraphicsContext gc) {
//        gc.beginPath();
//        gc.setFill(color);
//
//        gc.strokeOval(startX-width, startY-width, 2*width, 2*width);   }
//
//
//
//    public void drawLine(GraphicsContext gc) {
//
//        gc.setStroke(color);
//
//        gc.setLineWidth(width);
//
//        gc.setLineDashes();
//
//
//        gc.moveTo(startX, startY);
//
//        gc.lineTo(endX, endY);
//
//        gc.stroke();// соединить точки
//
//    }
//
//    public void drawArrowend(GraphicsContext gc) {
//
//        gc.moveTo(endX, endY);
//
//        double angle = Math.atan2((endY - startY), (endX - startX)) - Math.PI / 2.0;
//
//        double sin = Math.sin(angle);
//
//        double cos = Math.cos(angle);
//
//        //point1
//
//        double x1 = (- 1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + endX;
//
//        double y1 = (- 1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + endY;
//
//        //point2
//
//        double x2 = (1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + endX;
//
//        double y2 = (1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + endY;
//
//        gc.lineTo(x1, y1);
//
//        gc.moveTo(x2, y2);
//
//        gc.lineTo(endX, endY);
//
//        gc.stroke();
//        gc.closePath();
//    }
//
//}
//

package Model;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Factory {
   // Map<Integer, Obj> decor ;new HashMap<Integer, Obj>()
    //HashSet<Obj> decor = new HashSet<Obj>();

   // HashMap<Integer,Obj>();
    ArrayList<ObjPackage> decor;
    public Factory(){
        decor = new ArrayList<>();
        decor.add(new ObjPackage1S());
        decor.add(new ObjPackage2S());
        decor.add(new ObjPackage4S());
    }
    public ObjPackage getObjPackage(int i, Double h, Double w, Color c, Double ox, Double oy, String name, String place)
    {
        if(i>2 || i<0)return null;
        decor.get(i).setParam(h,w,c,ox,oy,name,place);
        return decor.get(i).clone();
        //тут только задавать значения mapset
    }
    public int NumObjPackage(String s){
        for (int i=0;i<decor.size();i++) {
            if(decor.get(i).getClass().toString().equals(s))
            {
                return i;
            }
        }
        return -1;
    }
}

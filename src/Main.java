import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        //DBaccess.getDB();
        ArrayList<Renters> renters = new ArrayList();
        DBaccess.getRenters(renters);
        for(Renters i: renters){
            System.out.println(i);
        }
    }
}


import java.util.ArrayList;

public class BaseTest {
    public static void main(String[] args) {

    }
    public static boolean areLocationsSame(Location l1, Location l2){
        if (l1.getLocation()[0] == l2.getLocation()[0] && l1.getLocation()[1] == l2.getLocation()[1]){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean compare2Arrays(ArrayList<Location> Array1, ArrayList<Location> Array2){

        if (Array1.size() != Array2.size()){
            return false;
        }

        for (int i = 0; i < Array1.size(); i++){

            boolean found = false;

            for (int j = 0; j < Array2.size(); j++){
                if (areLocationsSame(Array1.get(i), Array2.get(j))){
                    found = true;
                    break;
                }
            }
            if (found == false){
                return false;
            }
        }
        return true;
    }
}

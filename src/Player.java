
public abstract class Player extends Location{
    public boolean sideWhite;
    public boolean isHuman;



    public boolean isSidewhite() {
        return this.sideWhite = true;
        // Later have to change to input from Human to decide sides
    }

}

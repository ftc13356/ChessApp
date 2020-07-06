public abstract class Player {
    public boolean sideWhite;
    public boolean isHuman;

    public boolean isSidewhite() {
        return this.sideWhite = true;
        // Later have to change to input from Human to decide sides
    }
    public boolean isHumanPlayer() {
        return this.isHuman = true;
    }
}

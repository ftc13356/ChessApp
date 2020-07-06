public abstract class Player {
    public boolean sidewhite;
    public boolean ishuman;

    public boolean isSidewhite() {
        return this.sidewhite = true;
        // Later have to change to input from Human to decide sides
    }
    public boolean isHumanPlayer() {
        return this.ishuman = true;
    }
}

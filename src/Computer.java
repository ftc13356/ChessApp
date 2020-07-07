public class Computer extends Player{
    public Computer(boolean sidewhite) {
        if (sidewhite == true)
                this.sideWhite = false;
        else
            this.sideWhite = true;

        this.isHuman = false;
    }
}

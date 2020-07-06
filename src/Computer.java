public class Computer extends Player{
    public Computer(boolean sidewhite) {
        if (sidewhite == true)
                this.sidewhite = false;
        else
            this.sidewhite = true;

        this.ishuman = false;
    }
}

public class Location {
    private int horizontal;
    private int vertical;

    //constructor with default location
    public Location() {
        horizontal = 1;
        vertical = 1;
    }

    //constructor with any location
    public Location(int x, int y) {
        horizontal = x;
        vertical = y;
    }

    //setLocation function
    public void setLocation(int x, int y) {
        horizontal = x;
        vertical = y;
    }

    //getLocation function return position as array
    public int[] getLocation() {
        int[] tmp = {horizontal, vertical};
        return tmp;
    }
}

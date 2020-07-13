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
        if (x < 0 || x > 7) {
            throw new IllegalArgumentException("X value is less than 0 or more than 7: " + x);
        }
        if (y < 0 || y > 7) {
            throw new IllegalArgumentException("Y value is less than 0 or more than 7: " + y);
        }
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

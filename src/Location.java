public class Location {
    private int horizontal;
    private int vertical;

    //constructor with default location
    public Location() {
        horizontal = 1;
        vertical = 1;
    }

    @Override
    public String toString() {
        return horizontal+" "+vertical;
    }

    //constructor with any location
    public Location(int x, int y) {
        if (x < 1 || x > 8) {
            throw new IllegalArgumentException("X value is less than 1 or more than 8: " + x);
        }
        if (y < 1 || y > 8) {
            throw new IllegalArgumentException("Y value is less than 1 or more than 8: " + y);
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

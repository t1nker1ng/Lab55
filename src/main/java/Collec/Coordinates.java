package Collec;

public class Coordinates {
    private final Float x;
    private final Float y;

    public Coordinates(Float x, Float y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Coordinates o) {
        if (o == null) {
            return 1;
        }
        int r = this.x.compareTo(o.x);
        if (r == 0) {
            r = this.y.compareTo(o.y);
        }
        return r;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

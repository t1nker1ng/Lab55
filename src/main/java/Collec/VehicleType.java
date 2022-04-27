package Collec;

public enum VehicleType {
    PLANE,
    CHOPPER,
    HOVERBOARD;

    public static boolean isType(String s) {
        try {
            VehicleType.valueOf(s);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static String enumToStr() {
        String s = " ";
        for (VehicleType o: VehicleType.values())
            s += o.name() + " ";
        return s;
    }
}

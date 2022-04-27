package Collec;

public enum FuelType {
    GASOLINE,
    DIESEL,
    MANPOWER,
    ANTIMATTER;

    public static boolean isFuelType(String s) {
        try {
            FuelType.valueOf(s);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static String enumToStr() {
        String s = "";
        for (FuelType o : FuelType.values())
            s += o.name() + " ";
        return s;
    }
}

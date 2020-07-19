package pl.oliwier975.liczydlogui;

public abstract class Util {
    public static boolean
            ADDITION_OPENED,
            DIVISION_OPENED,
            MULTIPLICATION_OPENED,
            POWER_OPENED
                    = false;

    public static boolean isAllowed(String floatValue, String secondFloatValue, String integerValue) {
        try {
            Float.parseFloat(floatValue);
            Float.parseFloat(secondFloatValue);
            Integer.parseInt(integerValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void commandArgument(String name, String description) {
        System.out.println(" " + name);
        System.out.println("    ↳ " + description);
    }
}

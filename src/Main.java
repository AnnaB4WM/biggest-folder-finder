import java.io.File;
import java.util.HashMap;

public class Main {

    private static char[] sizeMultipliers = {'B', 'K','M','G','T',};

    public static void main(String[] args) {

        System.out.println(getSizeFromHumanReadable("235K"));
        System.out.println(getHumanReadableSize(240640));
        System.exit(0);
    }

    public static long getSizeFromHumanReadable(String size) {
        HashMap<Character, Integer> char2multiplier = getMultipliers();
        char sizeFactor = size
                .replaceAll("[0-9\\s+]+", "")
                .charAt(0);
        int multiplier = char2multiplier.get(sizeFactor);
        long length = multiplier * Long.valueOf(size.replaceAll("[^0-9]", ""));
        return length;
    }

    private static HashMap<Character, Integer> getMultipliers() {
        char[] multipliers = {'B', 'K','M','G','T',};
        HashMap<Character, Integer> char2multiplier = new HashMap<>();
        for (int i = 0; i < sizeMultipliers.length; i++) {
            char2multiplier.put(sizeMultipliers[i], (int) Math.pow(1024, i));
        }
        return char2multiplier;
    }

    public static String getHumanReadableSize(long size) {
        for (int i = 0; i < sizeMultipliers.length; i++) {
            double value = size / Math.pow(1024 , i);
            if (value < 1024) {
                return Math.round(value) + " " + sizeMultipliers[i] +
                        ((i > 0 ? "b" : ""));
            }
        }
        return "Big number!";
    }
}

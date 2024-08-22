import java.io.File;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        System.out.println(getSizeFromHumanReadable("235K"));
        System.out.println(getHumanReadableSize(240640));
        System.exit(0);

//        String folderPath = "C:/Users/Anna/Desktop/DATA";
//        File file = new File(folderPath);
//        System.out.println(getFolderSize(file));
    }

    // ручной обходчик файлов
//    public static long getFolderSize(File folder) {
//        if (folder.isFile()) { // проверяем является ли переданный в параметре метода файл, файлом
//            return folder.length(); // или это все таки папка, если является, то возвращает размер файла
//        }
//        long sum = 0;
//        File[] files = folder.listFiles(); // если не является, то получает методом listFiles все файлы,
//        for (File file : files) { // содержащиеся и папки содержащиеся в этой папке(Desktop/DATA)
//            sum += getFolderSize(file); // и для них так же вызывает этот же самый метод, вызывает сам себя
//        } // (рекурсия), который возвращает число long - это размер в байтах, указанных папок или файлов
//        return sum; // таким образом рекурсивно собирается информация о размере той или иной папки, или файла
//    }

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
        for (int i = 0; i < multipliers.length; i++) {
            char2multiplier.put(multipliers[i], (int) Math.pow(1024, i));
        }
        return char2multiplier;
    }

    public static String getHumanReadableSize(long length) {
        int power = (int) (Math.log(length) / Math.log(1024));
        double value = length / Math.pow(1024 , power);
        double roundValue = Math.round(value * 100) / 100;
        return roundValue + " " + power;
    }
}

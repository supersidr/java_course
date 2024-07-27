import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        В папке Games создайте несколько директорий: src, res, savegames, temp.
//        В каталоге src создайте две директории: main, test.
//        В подкаталоге main создайте два файла: Main.java, Utils.java.
//        В каталог res создайте три директории: drawables, vectors, icons.
//        В директории temp создайте файл temp.txt.
        StringBuilder log = new StringBuilder();
        String rootDir = "/Users/igor/Games";
        String[] gamesDirs = new String[] {"src/main", "src/test", "res/drawables", "res/vectors", "res/icons", "savegames", "temp"};
        for (var d: gamesDirs) {
            String fullDirPath = rootDir+"/"+d;
            File dir = new File(fullDirPath);
            if (dir.mkdirs()) {
                String message = "Cоздан каталог " + fullDirPath + "\n";
                log.append(message);
                System.out.println(message);
            }
        }

        String[] gamesFiles = new String[] {"src/main/Main.java", "src/main/Utils.java", "temp/temp.txt"};
        // определяем объект для файла
        for (var f: gamesFiles) {
            String fullFilePath = rootDir+"/"+f;
            File gameFile = new File(fullFilePath);
            try {
                if (gameFile.createNewFile()) {
                    String message = "Был создан " + fullFilePath + "\n";
                    log.append(message);
                    System.out.println(message);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        File file = new File(rootDir + "/temp/temp.txt");
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(log.toString());
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

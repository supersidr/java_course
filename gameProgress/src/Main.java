import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        GameProgress gameProgress1 = new GameProgress(94, 10, 2, 254.32);
        GameProgress gameProgress2 = new GameProgress(100, 15, 3, 284.32);
        GameProgress gameProgress3 = new GameProgress(115, 18, 4, 354.32);
        String[] savePath = {
                "/Users/igor/Games/savegames/save1.dat",
                "/Users/igor/Games/savegames/save2.dat",
                "/Users/igor/Games/savegames/save3.dat"
        };

        saveGame(savePath[0], gameProgress1);
        saveGame(savePath[1], gameProgress2);
        saveGame(savePath[2], gameProgress3);
        zipFiles("/Users/igor/Games/savegames/saves.zip", savePath);

    }

    public static void saveGame(String filePath, GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            // запишем экземпляр класса в файл
            oos.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void zipFiles(String zipFilePath, String[] filesPathsToZip) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(zipFilePath))) {
            for (var file : filesPathsToZip) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    File fileToDelete = new File(file);
                    try (FileInputStream fileInputStream = new FileInputStream(file)) {
                        ZipEntry entry = new ZipEntry(file);
                        zout.putNextEntry(entry);
                        int length;
                        byte[] buffer = new byte[fis.available()];
                        while ((length = fileInputStream.read(buffer)) > 0) {
                            zout.write(buffer, 0, length);
                        }

                        fis.read(buffer);
                        zout.write(buffer);
                        zout.closeEntry();
                        fileToDelete.deleteOnExit();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
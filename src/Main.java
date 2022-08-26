import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String drive = "E:"; // если у проверяющего диск отличный от E
        StringBuilder builder = new StringBuilder();

        File dirSrc = new File(drive + "//Games/src");
        creatDir(dirSrc, builder);

        File dirRes = new File(drive + "//Games/res");
        creatDir(dirRes, builder);

        File dirSaveGames = new File(drive + "//Games/savegames");
        creatDir(dirSaveGames, builder);

        File dirTemp = new File(drive + "//Games/temp");
        creatDir(dirTemp, builder);

        File subDirSrcMain = new File(drive + "//Games/src/main");
        creatDir(subDirSrcMain, builder);

        File subDirSrcTest = new File(drive + "//Games/src/test");
        creatDir(subDirSrcTest, builder);

        File fileMain = new File(drive + "//Games/src/main/Main.java");
        creatFile(fileMain, builder);

        File fileUtils = new File(drive + "//Games/src/main/Utils.java");
        creatFile(fileUtils, builder);

        File subDirResDrawables = new File(drive + "//Games/res/drawables");
        creatDir(subDirResDrawables, builder);

        File subDirResVectors = new File(drive + "//Games/res/vectors");
        creatDir(subDirResVectors, builder);

        File subDirResIcons = new File(drive + "//Games/res/icons");
        creatDir(subDirResIcons, builder);

        File fileTemp = new File(drive + "//Games/temp/temp.txt");
        creatFile(fileTemp, builder);

        try (FileWriter writer = new FileWriter(drive + "//Games/temp/temp.txt")){
            writer.write(String.valueOf(builder)); // вызов однократно, поэтому не в переменную
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void creatDir(File dir, StringBuilder builder) {
        if (dir.mkdir()) {
            String result = "Каталог " + dir.getName() + " coздан \n";
            builder.append(result);
        } else {
            String result = "Каталог " + dir.getName() + " не coздан \n";
            builder.append(result);
        }
    }

    public static void creatFile(File file, StringBuilder builder) {
        try {
            if (file.createNewFile()) {
                String result = "Файл " + file.getName() + " был создан\n";
                builder.append(result);
            } else {
                String result = "Файл " + file.getName() + " не был создан\n";
                builder.append(result);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
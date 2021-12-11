import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.out.println("Введите путь до файла который нужно скопировать и имя нового файла");
            return;
        }

        File pathToFile = new File(args[0]);
        File newFile = new File(args[1]);

        copyFile(pathToFile, newFile);
    }

    private static void copyFile(File pathToFile, File newFile) {
        try (InputStream is = new FileInputStream(pathToFile);
             OutputStream os = new FileOutputStream(newFile)) {
            byte[] buffer = new byte[is.available()];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (IOException e) {
            System.out.println("Файл не найден или не может быть прочитан");
        }
    }
}
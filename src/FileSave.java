import java.io.FileWriter;
import java.io.IOException;

/*      класс для записи текста в файл по указанным в параметрах пути
 */


public class FileSave {

    public static void save(String file_path, String text_to_process) throws IOException {

        FileWriter writer = new FileWriter(file_path, false);

        writer.write(text_to_process);

        writer.flush();
    }
}
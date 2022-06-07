import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*      класс для чтения текста из файла по указанным в параметрах пути
 */


public class FileRead {

    public static String read(String file_path) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(file_path));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                //sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            br.close();
        }
    }
}
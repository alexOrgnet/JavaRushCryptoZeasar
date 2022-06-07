
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;


/*      класс для раскодировки текста
 */

public class Decode {

    public static String decodes(String text, int key) throws IOException {

        StringReader reader = new StringReader(text);

        if (reader == null) {

            return "";

        }

        StringBuilder str_builder = new StringBuilder();

        BufferedReader bufferedReader = new BufferedReader(reader);

        String str = bufferedReader.readLine();


        for (char c : str.toCharArray()) {
            str_builder.append((char) (c + key));
        }

        return str_builder.toString();
    }
}
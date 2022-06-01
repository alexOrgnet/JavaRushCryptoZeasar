
import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;


/* класс для кодировки текста
 */

public class Encode {

        public static String encodes(String text, int key)  throws IOException  {

                StringReader reader = new StringReader(text);

                 if (reader == null) {

                        return "";

                }

                StringBuilder str_builder = new StringBuilder();

                BufferedReader bufferedReader = new BufferedReader(reader);

                String string = bufferedReader.readLine();


                for (char c: string.toCharArray()) {

                    str_builder.append((char)(c-key));

                }

                return str_builder.toString();
        }
}
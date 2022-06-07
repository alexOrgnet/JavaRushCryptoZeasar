import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/*
 * Шифр Цезаря


 */

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader1 = new StringReader("Khoor#Dpljr#&C,₷B'3");
        StringReader reader2 = new StringReader("Hello Amigo #@)₴?$");
        System.out.println(decode(reader1, -3));  //Hello Amigo #@)₴?$0
        System.out.println(decode(reader2, 3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        if (reader==null) return "";
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(reader);

        String string = bufferedReader.readLine();


        for (char c: string.toCharArray()
        ) {
            sb.append((char)(c+key));
        }

        return sb.toString();
    }
}
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  throws IOException {

            //здесь вводим текст который нужно будет закодировать
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите текст который будет закодирован");
            String plain_text = sc.nextLine();


            //здесь вводим ключ с помощью которого закодируем текст
            System.out.println("Введите ключ шифра в виде целого числа для шифрования текста");
            int code = sc.nextInt();


            //здесь наужно закодировать текст и потом его раскодировать
            String encrypted_text = Encode.encodes(plain_text,code);
            //FileSave.save("C:\\Encodedtext.txt", encrypted_text);
            System.out.println("Вы закодировали текст в следующий шифр -> "+encrypted_text);


            //здесь пытаемся раскодировать текст
            System.out.println("Если вы хотите раскодировать текст введите ключ в виде любого числа. Для выхода из программы введите команду quit ");

            while (sc.hasNextInt()) {

                int key_input = sc.nextInt();

                    String decoded_text = Decode.decodes(encrypted_text,key_input);
                    if (decoded_text.equals(plain_text)) {
                        System.out.println("Вы успешно декодировали текст в следующее содержание "+plain_text);
                        break;
                    }
                    else {
                        System.out.println("Текст не раскодирован -> " +decoded_text+", попробуйте еще раз ввести ключ шифра. Для выхода из программы введите команду quit ");
                    }
            }
    }
}
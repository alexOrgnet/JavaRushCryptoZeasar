import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        System.out.print("Введите в виде целого числа режим работы программы: " + "\n" +
                "1 - закодировать текст по шифру цезаря" + "\n" +
                "2 - раскодировать текст по шифру цезаря путем ввода ключа " + "\n" +
                "3 - раскодировать текст по шифру простым перебором " + "\n" +
                "");

        Scanner sc = new Scanner(System.in);
        int variant = sc.nextInt();

        String text_to_decode = FileRead.read("C:\\Users\\HP\\Downloads\\Encodedtext.txt");

        //строим командное меню
        switch (variant) {

            case (1):
                //здесь вводим текст который нужно будет закодировать

                System.out.println("Введите текст который будет закодирован");
                Scanner sc2 = new Scanner(System.in);
                String plain_text = sc2.nextLine();

                //сохраняем файл с первичным текстом

                FileSave.save("C:\\Users\\HP\\Downloads\\Plaintext.txt", plain_text);

                //здесь вводим ключ с помощью которого закодируем текст
                System.out.println("Введите ключ шифра в виде целого числа для шифрования текста");
                int code = sc.nextInt();

                //здесь кодируем текст и сохраняем его в файл
                String encrypted_text = Encode.encodes(plain_text, code);
                FileSave.save("C:\\Users\\HP\\Downloads\\Encodedtext.txt", encrypted_text);
                System.out.println("Вы закодировали текст в следующий шифр -> " + encrypted_text);
                break;

            case (2):

                //здесь пытаемся раскодировать текст к ключом



                System.out.println("Если вы хотите раскодировать текст введите ключ в виде любого числа. Для выхода из программы введите команду quit ");

                while (sc.hasNextInt()) {

                    int key_input = sc.nextInt();

                    String decoded_text = Decode.decodes(text_to_decode, key_input);

                    String text_from_file = FileRead.read("C:\\Users\\HP\\Downloads\\Plaintext.txt");

                    if (decoded_text.equals(text_from_file)) {
                        System.out.println("Вы успешно декодировали текст в следующее содержание " + decoded_text);
                        break;
                    } else {
                        System.out.println("Текст не раскодирован -> " + decoded_text + ", попробуйте еще раз ввести ключ шифра. Для выхода из программы введите команду quit ");
                    }
                }
                break;
            case (3):

                //здесь пытаемся раскодировать текст методом перебора

                int key_input = 0; //начинаем использовать ключи с единицы

                System.out.println("Введите количество попыток перебора вариантов расшифровки ");

                int code2 = sc.nextInt();

                while (key_input<=code2) {

                    key_input++;

                    String decoded_text = Decode.decodes(text_to_decode, key_input);

                    String text_from_file = FileRead.read("C:\\Users\\HP\\Downloads\\Plaintext.txt");

                    if (decoded_text.equals(text_from_file)) {
                        System.out.println("Вы успешно декодировали текст в следующее содержание " + decoded_text);
                        break;
                    } else {
                        System.out.println("Попытка не удачна, текст не раскодирован -> " + decoded_text );
                    }
                }
                break;
            default:
                break;


        }
    }
}
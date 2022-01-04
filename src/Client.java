import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

            Socket clientSocket = new Socket("https://www.google.com/", 80);

            //            Scanner scanner = new Scanner(System.in); // считываем с клавиатуры
//
//
//            //запись в сервер
//            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream()); //создаем врайтера для отправки сообщения серверу
////        writer.write("Number of client?\n"); // отправляем сообщение серверу
//            writer.write(scanner.nextLine() + "\n");  //пишем на клавиатуре запросы
//            writer.flush();


            //чтение из сервера
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));    //создаем ридера для нашего клиента что читать с сервера информацию
            String response = reader.readLine();
            System.out.println(response);      //читаем что нам пишет сервер


//            writer.close();
            reader.close();
            clientSocket.close();

    }
}

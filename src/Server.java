import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);     //создали сокет на 8000 порту
        int count =0;
        while (true) {
            Socket clientSocket = serverSocket.accept();      //создаем клиент сокет и направляем в него  сервер сокет в режиме ожидания


            //отправка сообщения клиенту
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            writer.write("you are client #" + count + "\n"); // отправляем клиенту сообщение
            writer.flush();




            //чтение сообщения от клиента
            BufferedReader reader =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));    //создаем ридера для нашего сервера чтобы читать от клиента информацию
            String request =reader.readLine();
            if (request.equals("exit")) {
                reader.close();
                writer.close();
                clientSocket.close();
                serverSocket.close();       //закрыть сокет после обработки запроса
            return;
            }
            System.out.println(request);      //читаем что нам пишет клиент






            reader.close();
            writer.close();
            clientSocket.close();
            System.out.println("Next connect..."+ count++ +"\n");
        }
//

    }

}







// отправка  по http на браузер
//            writer.write("HTTP/1.0 200 OK\r\n"+
//                         "Content-type: text/html\r\n"+
//                         "\r\n"+
//                         "<h2>HELLO FROM JAVA</h2>");
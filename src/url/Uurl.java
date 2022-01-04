package url;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Uurl {
    public static void main(String[] args) throws IOException {

                String url ="https://google.com/";
                URLConnection connection =new URL(url).openConnection();

             try (Scanner scanner =new Scanner(connection.getInputStream())) {
                 scanner.useDelimiter("\\Z");

                 Map<String, List<String>> map =connection.getHeaderFields();
                 for (Map.Entry<String, List<String>> headers:map.entrySet()){
                     System.out.println(headers.getKey()+" : "+headers.getValue());
                 }
//                 while (scanner.hasNextLine()) {
//                     System.out.println(scanner.nextLine());
//                 }
             }

    }

}


import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//http://172.16.3.65:2000
public class STcpEchoUpper {

    public static void main(String[] args) throws IOException {
        while (true) {
            int PORTA = 2000;  // porta di ascolto
            ServerSocket S;

            S = new ServerSocket(PORTA);
            Socket ss = S.accept();
            // ss connesso con client

            BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
            PrintWriter bw = new PrintWriter(new OutputStreamWriter(ss.getOutputStream()), true);
            BufferedReader fr = new BufferedReader(new FileReader("new.html"));

            String riga;
            riga = br.readLine();
            String linea;
            System.out.println(">" + riga);
            bw.println("HTTP/1.0 200 OK \n \n");                          //riga.toUpperCase()
            while ((linea = fr.readLine()) != null) {                     // if (riga.equals("fine"))      // ss.close();
                bw.println(linea);
            }
            ss.close();
            S.close();
        }
    }
}

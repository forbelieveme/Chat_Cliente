
package prueba.chat.maquinas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class PruebaChatMaquinas {


    public static void main(String[] args) throws IOException {
        
        Scanner scan = new Scanner (System.in);
        Socket socket = new Socket ("10.20.151.160", 8081);
        
        InputStream it;
        InputStreamReader ent;
        BufferedReader entrada;
        
        it= socket.getInputStream();
        ent = new InputStreamReader(it);
        entrada = new BufferedReader(ent);
        
        OutputStream ot;
        OutputStreamWriter s;
        PrintWriter salida;
        
        ot = socket.getOutputStream();
        s = new OutputStreamWriter(ot);
        salida = new PrintWriter(s, true);
        
        for (int i= 0; i<4; i++){
            System.out.println("digte");
            String dato = scan.nextLine();
            salida.println(""+dato);
            String m = entrada.readLine();
            
            if (m==null){
                break;
            }
            
            System.out.println(m);
        }
        socket.close();
    }
    
}

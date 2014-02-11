import java.io.*;
import java.net.*;
import java.util.Scanner;

class EchoClient{
    public static void main(String[] args){
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        Socket s1;

        try{
            // Open socket between given host and port
            s1 = new Socket(host, port);

            // Opens input and output streams to listen on and write to
            InputStreamReader isr = new InputStreamReader(s1.getInputStream());
            PrintWriter output = new PrintWriter(s1.getOutputStream(), true);
            BufferedReader ibr = new BufferedReader(isr);

            // Gets the input from the user
            System.out.println("Please enter a message: ");
            Scanner input = new Scanner(System.in);
            String message = input.nextLine();

            // Send the output to the server
            output.println(message);
            // Get response from server
            System.out.println("RESPONSE: " + ibr.readLine());

            // Close all readers/sockets
            s1.close();
            input.close();
            output.close();
            ibr.close();
        } catch(Exception e) {
            return;
        }
    }
}

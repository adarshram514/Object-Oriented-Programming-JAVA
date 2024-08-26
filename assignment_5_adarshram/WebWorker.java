import java.net.Socket;
import java.lang.Runnable;
import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.util.TimeZone;

public class WebWorker implements Runnable{

   private Socket socket;

   public WebWorker(Socket s){
   
      socket = s;
   }

   
   public void run(){
   
      String address = "";
      
      System.err.println("Configuring connection...");
      
      try {
         InputStream  is = socket.getInputStream();
         OutputStream os = socket.getOutputStream();
         
         address = readHTTPRequest(is);
         
         writeHTTPHeader(os,"text/html", address);
         writeContent(os,"text/html", address);
         os.flush();
         socket.close();
      
      } catch (Exception e) {
         System.err.println("Output error: "+e);
      }
      
      System.err.println("Done configuring connection.");
      
      return;
      
   }

   private String readHTTPRequest(InputStream is){
      
      String line;
      BufferedReader r = new BufferedReader(new InputStreamReader(is));
      
      String address = "";
      
      while (true) {
         try {
            while (!r.ready()) Thread.sleep(1);
            line = r.readLine();
            
            if(line.contains("GET ")){
               address = line.substring(4);
               for(int i = 0; i < address.length(); i++){
                  if(address.charAt(i) == ' '){
                     address = address.substring(0, i);
                  } 
               } 
            } 
            
            System.err.println("Request line: ("+ line +")");
            if (line.length() == 0) break;
         
         } catch (Exception e) {
            System.err.println("Request error: " + e);
            break;
         }
      }
      return address;
      
   } 

   private void writeHTTPHeader(OutputStream os, String contentType, String address) throws Exception{
      
      Date d = new Date();
      DateFormat df = DateFormat.getDateTimeInstance();
      df.setTimeZone(TimeZone.getTimeZone("GMT-6"));
      
      String copy = '.' + address;
      File f1 = new File(copy);
      
      try{
         FileReader file = new FileReader(f1);
         BufferedReader r = new BufferedReader(file);
      }catch(FileNotFoundException e){
         System.out.println("File not found: " + address);
         os.write("HTTP/1.1 404 Error: Not Found\n".getBytes());
      }
      
      os.write("HTTP/1.1 200 OK\n".getBytes());
      os.write("Date: ".getBytes());
      os.write((df.format(d)).getBytes());
      os.write("\n".getBytes());
      os.write("Server: Xiana's very own server\n".getBytes());
      os.write("Connection: close\n".getBytes());
      os.write("Content-Type: ".getBytes());
      os.write(contentType.getBytes());
      os.write("\n\n".getBytes()); 
      return;
      
   } 

   private void writeContent(OutputStream os, String contentType, String address) throws Exception{
      
      // date info
      Date d = new Date();
      DateFormat dformat = DateFormat.getDateTimeInstance();
      dformat.setTimeZone(TimeZone.getTimeZone("GMT-6"));

      String fcont = "";
      String copy = "." + address.substring(0, address.length());
      String date = dformat.format(d);
      File f1 = new File(copy);

      try{
         FileReader fRead = new FileReader(f1);
         BufferedReader fBuff = new BufferedReader(fRead);
         
         while((fcont = fBuff.readLine()) != null) {
            os.write(fcont.getBytes());
            os.write("\n".getBytes());
            
            if (fcont.contains("<cs371date>")) {
               os.write(date.getBytes());
            }
            
            if (fcont.contains("<cs371server>")){
               os.write("It works! \n".getBytes());
            }
              
         }
           
      }catch(FileNotFoundException e) {
         System.err.println("File not found: " + address);
         os.write("<h1>Error: 404 Not found<h1>\n".getBytes());
      }
      
   }

} 
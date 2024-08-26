import java.io.UnsupportedEncodingException;

public class HuffmanTester 
   public static void main(String args[]) {
       String test = "My Test works fine";
       System.out.println("Testing String: " + test);
       int size = 0;
       try {
           size = test.getBytes("utf8").length * Byte.SIZE;         
       } catch (UnsupportedEncodingException e) {
           System.out.println("Not proper encoding...");
       }
       HuffmanTable test2 = new HuffmanTable(test);
       Twiddle test3 = new Twiddle(test2.getTable());
       Huff tst4 = new Huff(test3, test2.getTable());
       String test5 = tst4.result(test);
       tst4.print();
       int sizeb = test5.length();
       System.out.println("Encoded bit stream:");
       System.out.println(test5);
       System.out.println("Total number of bits without Huffman coding: " + size);
       System.out.println("Total number of bits with Huffman coding: " + sizeb);
       System.out.println("Decoded String: " + Decoder.decode(test5, test3));
      
   }

}
public class HuffmanTableItem {
   char key;
   int freq;
   String Enc;
   public HuffmanTableItem(char theKey, int thefreq, String theEnc){
       key = theKey;
       freq = thefreq;
       Enc = theEnc;
   }
   public char getKey() {
       return key;
   }
   public String getEnc(){
       return Enc;
   }
   public int getfreq() {
       return freq;
   }
   public String toString() {
       return ("Char: " + key + " Freq: " + freq + " Enc: " + Enc + "\n");
   }
}
import java.util.HashMap;
import java.util.Map;

public class HuffmanTable {
   private Map<Character, Integer> HuffColl;
   public HuffmanTable(String theInput){
       HuffColl = new HashMap<Character, Integer>();
       checkandadd(theInput);
   }
   private final void checkandadd(String theInput){
       if(theInput.length() < 2) {
           System.out.println("Length of input is less than 2.");
       } else {
           for(int i = 0; i < theInput.length(); i++) {
               char temp = theInput.charAt(i);
               if(HuffColl.containsKey(theInput.charAt(i))){
                   HuffColl.put(temp, HuffColl.get(temp) + 1);
               } else {
                   HuffColl.put(temp, 1);
               }
           }
       }  
   }

   public Map<Character, Integer> getTable(){
       return HuffColl;
   }
}
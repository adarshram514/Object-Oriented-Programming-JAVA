import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Huff {

   private HuffmanTreeNode myTree;
   private List<HuffmanTableItem> result;
   public Huff(HuffmanTree theTree, Map<Character, Integer> theInput){
       myTree = theTree.theHead();
       result = new ArrayList<>();
       encode(theInput);
   }
   private final void encode(Map<Character, Integer> theInput) {
       for (Entry<Character, Integer> entry :
           theInput.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            String temp = traverse(key, myTree);
            result.add(new HuffmanTableItem(key, value, temp));
       }
   }

   private String traverse(char e, HuffmanTreeNode a) {
       String L = traversedetail(e, a.getLeft(), String.valueOf(1));
       String R = traversedetail(e, a.getRight(), String.valueOf(0));
       if(L == null) {
           return R;
       } else {
           return L;
       }
   }

   private String traversedetail(char e, HuffmanTreeNode a, String encode){
       if(a == null){
           return null;
       } else if(a.getLetter() == e) {
           return encode;
       } else {
           String L = traversedetail(e, a.getLeft(), encode + String.valueOf(1));
           String R = traversedetail(e, a.getRight(), encode + String.valueOf(0));
           if(L == null) {
               return R;
           } else {
               return L;
           }
       }
   }

   public String result(String Input){
       String re = null;
       Map<Character, String> temp = new HashMap<>();
       for(int i = 0; i < result.size(); i++) {
           temp.put(result.get(i).getKey(), result.get(i).getEnc());
       }
       re = temp.get(Input.charAt(0));
       for(int i = 1; i < Input.length(); i++) {
           re = re + temp.get(Input.charAt(i));
       }
       return re;
   }

   public void print() {
       for(int i = 0; i < 50; i ++) {
           System.out.print("=");
       }
       System.out.println("\nChar \t\tfrequency \t\tcode");
       for(int i = 0; i < 50; i ++) {
           System.out.print("-");
       }
       for(int i = 0; i < result.size(); i ++) {
           System.out.printf("\n%c\t\t%d\t\t\t%s", result.get(i).getKey(),
                   result.get(i).getfreq(), result.get(i).getEnc());
       }
       System.out.println();
       for(int i = 0; i < 50; i ++) {
           System.out.print("=");
       }
       System.out.println();
   }
  

}
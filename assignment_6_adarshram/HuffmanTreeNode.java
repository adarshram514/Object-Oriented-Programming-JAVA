public class HuffmanTreeNode {

   private int freq;
   private HuffmanTreeNode left;
   private HuffmanTreeNode right;
   private char letter;
   private String cumulative;

   public HuffmanTreeNode(HuffmanTreeNode a, HuffmanTreeNode b) {
       freq = a.freq + b.freq;
       letter = 0;
       left = a;
       right = b;
       cumulative = a.cumulative + " + " + b.cumulative;
   }

   public HuffmanTreeNode(int theFreq, char theletter) {
       freq = theFreq;
       letter = theletter;
       left = null;
       right = null;
       cumulative = Character.toString(theletter);
   }

   public int getFreq() {
       return freq;
   }

   public HuffmanTreeNode getLeft() {
       return left;
   }

   public HuffmanTreeNode getRight() {
       return right;
   }

   public char getLetter() {
       return letter;
   }
   public String toString(){
       String re = "Cumulative: " + cumulative + " freq: " +freq;
       return re;
   }

}
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;


public class Twiddle {
   private Map<Character, Integer> mytable;
   private HuffmanTreeNode myhead;
   private Queue<HuffmanTreeNode> collect;
   public Twiddle( Map<Character, Integer> thetable) {
       mytable = thetable;
       Comparator<HuffmanTreeNode> fornode = new Comparator<HuffmanTreeNode>(){
           @Override
           public int compare(HuffmanTreeNode arg0, HuffmanTreeNode arg1) {
               int temp = 0;
               if(arg0.getFreq() > arg1.getFreq()){
                   temp = 1;
               } else if (arg0.getFreq() < arg1.getFreq()){
                   temp = -1;
               }
               return temp;
           }          
       };
       collect = new PriorityQueue<>(3, fornode);
       load();  
   }
   public HuffmanTreeNode theHead() {
       return myhead;
   }
   private void load(){
       for (Entry<Character, Integer> entry : mytable.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            collect.add(new HuffmanTreeNode(value, key));
       }
       while(collect.size() > 1) {
           HuffmanTreeNode temp1 = collect.poll();
           HuffmanTreeNode temp2 = collect.poll();
           collect.add(new HuffmanTreeNode(temp1, temp2));  
       }
       myhead = collect.peek();
   }
  
}
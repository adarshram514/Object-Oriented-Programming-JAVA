public class Puff {

   public static String decode(String Input, HuffmanTree theTree) {
       StringBuffer temp = new StringBuffer();
       HuffmanTreeNode scan = theTree.theHead();
       for(int i = 0; i < Input.length(); i ++){
           if(Input.charAt(i) == '1'){
               scan = scan.getLeft();
           } else {
               scan = scan.getRight();
           }
           if(scan.getLetter() != 0){
               temp.append(scan.getLetter());
               scan = theTree.theHead();
           }
       }
       String re = temp.toString();
       return re;
   }

}
package prob0719;

class InBuffer {
   private String inString;
   private String line;
   private int lineIndex;

   public InBuffer(String string) {
      inString = string + "\n\n";
      // To guarantee inString.length() == 0 eventually
   }

   public void getLine() {
      int i = inString.indexOf('\n');
      line = inString.substring(0, i + 1);
      inString = inString.substring(i + 1);
      lineIndex = 0;
   }

   public boolean inputRemains() {
      return inString.length() != 0;
   }

   public char advanceInput() {
      return line.charAt(lineIndex++);
   }

   public void backUpInput() {
      lineIndex--;
   }
}

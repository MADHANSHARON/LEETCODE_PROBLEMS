public class Reverse_words_in_string {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");  // Corrected split method
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);  // Corrected variable name
            if (i > 0) {  // To avoid adding an extra space at the end
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
 {
    
}

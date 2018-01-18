package ua.dubovslyi.custom;

public class ReverseString {

    public static void main(String[] args) {

    }


    private String reverse1(String word){

      char [] chars = word.toCharArray();

      char [] reverse = new char [chars.length];

      int j =0;
      for(int i =chars.length; i>= 0;i--){

          reverse[j] = chars[i];
          j++;
      }
        return reverse.toString();
    }
}

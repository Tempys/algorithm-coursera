package ua.dubovslyi.custom;

public class ReverseString {

    public String myReverseAlgorithms(String word){

      char [] chars = word.toCharArray();

      char [] reverse = new char [chars.length];

      int j =0;

      for(int i =chars.length-1; i>= 0;i--){

          reverse[j] = chars[i];
          j++;
      }
        return new String(reverse);
    }


    /**
     * For example,
     Given s = "the sky is blue",
     return "blue is sky the".

     */
    public void reverseWords(char[] s) {
        int i=0;
        for(int j=0; j<s.length; j++){

            if(s[j]==' '){
                reverse(s, i, j-1);
                i=j+1;
            }
        }

        reverse(s, i, s.length-1);

        reverse(s, 0, s.length-1);
    }

    public void reverse(char[] s, int i, int j){
        while(i<j){

            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;

        }
    }
}

package com.brettdavisgame.main;

/**
 * Created by Family on 4/18/2017.
 */
public class stupidTestingShit {

    public static void main(String[] args){

        String test = "2-4a0r7-4k";
        int k = 3;
        String outputTest = stringReformat(test, 4);
        System.out.println(outputTest);



    }

    private static String stringReformat(String s, int k){

        StringBuilder string = new StringBuilder(s);

        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == '-'){
                string.delete(i, i+1);
            }
        }

        int remainder = s.length() % k;

        if(remainder > 0){
            string.insert(remainder, "-");
            string.insert(remainder + k, "-");
        }else if(remainder == 0){
            string.insert(k, "-");
        }

        return string.toString();
    }
}

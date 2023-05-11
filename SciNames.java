import java.util.*;

public class SciNames {

    static String[] alph = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    static String[] notVocals = {"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","y","z"};
    static String[] vocals = {"a","e","i","o","u"};
    static String[] vocalsTsh = {"a","e","i","o","u","t","s","h","r"};
    static String[] vocalsG = {"a","e","i","o","u", "g"};
    static String[] vocalsL = {"a","e","i","o","u", "l"};

    static Random rand = new Random();

    public static String choice(String[] ar){
        String s = ar[rand.nextInt(ar.length-1)];
        return s;
    }

    private static String letterAt(String s, int o){
        String f;
        if (o<0){f = String.valueOf(s.charAt(s.length()+o));}
        else{f = String.valueOf(s.charAt(o));}
        return f;
    }



    private static String gen(Integer len){
        String string = alph[rand.nextInt(alph.length-1)];
        boolean repeater = true;

        while (string.length() < len){
            String last = letterAt(string, -1);
            String newLetter = "";
            if ("tsprk".contains(last)){
                if (repeater){
                    newLetter = choice(vocalsTsh);
                    if (last.equals("r") & newLetter.equals("h")){continue;}
                    if (last.equals("k") & newLetter.equals("k")){continue;}
                    repeater = false;
                }
                else {
                    newLetter = choice(vocals);
                    repeater = true;
                }
            }

            else if (last.equals("n")){newLetter = choice(vocalsG);}

            else if (last.equals("l")){newLetter = choice(vocalsL);}

            else if ("aeiou".contains(last)){
                if (string.length() > 2){
                    if ("aeiou".contains(letterAt(string, -2)) & "aeiou".contains(letterAt(string, -3))){newLetter = choice(notVocals);}
                    else {newLetter = choice(alph); if ("aeiou".contains(newLetter)){repeater = true;}}
                }
                else{newLetter = choice(alph); if ("aeiou".contains(newLetter)){repeater = true;}}
            }

            else if (!("aeiou".contains(last))){newLetter = choice(vocals);}

            string = string + newLetter;
        }

        return string;
    }

    public static String lenName(Integer l){
        return gen(l);
    }

    public static String name(){
        return gen(3 + rand.nextInt(5));
    }

    public static String rangeLenName(Integer l, Integer h){
        return gen(l + rand.nextInt(h-l));
    }

}
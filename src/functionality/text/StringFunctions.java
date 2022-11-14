package functionality.text;

import java.util.ArrayList;
import java.util.Arrays;

public class StringFunctions {

    public static final String[] conj = {
            "and", "as", "but", "for", "if", "nor", "or", "so", "yet", "a", "an", "the", "as", "at", "by", "for",
            "in", "of", "off", "on", "per", "to", "up", "via"
    };

//    public static final String[] conj = {"aboard", "about", "above", "across", "after", "against", "along", "amid", "among", "anti", "around", "as", "at",
//            "before", "behind", "below", "beneath", "beside", "besides", "between", "beyond", "but", "by", "concerning",
//            "considering", "despite", "down", "during", "except", "excepting", "excluding", "following", "for", "from", "in",
//            "inside", "into", "like", "minus", "near", "of", "off", "on", "onto", "opposite", "outside", "over", "past", "per",
//            "plus", "regarding", "round", "save", "since", "than", "through", "to", "toward", "towards", "under", "underneath",
//            "unlike", "until", "up", "upon", "versus", "via", "with", "within", "without", "and", "but", "is", "not"};

    public static String toTitle(String string) {
        StringBuilder out = new StringBuilder();
        String[] inSentence = string.split(" ");
        ArrayList<String> conjunctions = new ArrayList<>(Arrays.stream(conj).toList());
        for(String s: inSentence) {
            if(conjunctions.contains(s.toLowerCase())) out.append(s.toLowerCase());
            else {
                out.append((char) (s.charAt(0) & ~32));
                out.append(s.substring(1).toLowerCase());
            }
            out.append(' ');
        }
        return out.toString().strip();
    }

    public static String toSen(String string) {
        StringBuilder out = new StringBuilder();
        String[] in = string.split(" ");
        out.append((char) (in[0].charAt(0) & ~32));
        out.append(in[0].substring(1).toLowerCase());
        out.append(' ');
        for(int i = 1; i < in.length; i++) {
            out.append(in[i].toLowerCase());
            if(i == (in.length -1)) break;
            out.append(' ');
        }
        return out.toString();
    }
}

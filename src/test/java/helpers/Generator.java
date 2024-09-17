package helpers;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    private static String postCode = "";
    private static String firstName = "";

    public static void main(String[] args) {
     //   System.out.println(getPostCode(postCode));
        System.out.println(getFirstName(getFirstName(postCode)));
    }
    public static String getPostCode(String postCode) {
        for(int i = 0; i < 10; i++) {
            postCode = postCode + (int)(Math.random()*9);
        }
        return postCode;
    }
    public static String getFirstName(String postCode) {
        System.out.println(postCode);
        char[] chars = postCode.toCharArray();
        String s = "";
        for(int i = 0; i < postCode.length() - 1; i += 2){
            s = s + chars[i] + chars[i+1];
            System.out.println(chars[i] + "+" + chars[i+1]);
        }
//        for(String a : res)
//        System.out.println(a);
//        for (int i = 0; i < chars.length-1; i++) {
//             s = s + chars[i] + chars[i + 1];
//           System.out.println(s);
////            switch (s) {
//                case "00":
//                    s = "a";
//                    break;
//                case "01":
//                    s = "b";
//                    break;
//            }
//        }
        return s;//firstName;
    }
}



// 7373836010
// 4188201518
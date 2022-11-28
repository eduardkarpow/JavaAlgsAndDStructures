package HW7;

public class StringTester {
    public static void main(String[] args) {
        StringOperations so = new StringOperations();
        System.out.println(so.countChars("ASDHADJ"));
        System.out.println(so.makeOdd("123456789"));
        System.out.println(so.reverse("123456789"));
    }
}

interface StringOperetable{
    int countChars(String str);
    String makeOdd(String str);
    String reverse(String str);
}
class StringOperations implements StringOperetable{
    public int countChars(String str){
        return str.length();
    }
    public String makeOdd(String str){
        String newStr = "";
        for(int i = 1; i < str.length(); i+=2){
            newStr+=String.valueOf(str.charAt(i));
        }
        return newStr;
    }
    public String reverse(String str){
        String newStr="";
        for(int i = 0; i < str.length(); i++){
            newStr += String.valueOf(str.charAt(str.length()-i-1));

        }
        return newStr;
    }
}

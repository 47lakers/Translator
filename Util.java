package prob0719;

public class Util {
    public static boolean isDigit(char ch){
        return ('1' <= ch) && (ch <= '9');
    }
    public static boolean isAlpha(char ch){
        return (('a' <= ch) && (ch <= 'z') || ('A' <= ch) && (ch <= 'Z'));
    }
    public static boolean isHex(char ch){
        return (('a' <= ch) && (ch <= 'f') || ('A' <= ch) && (ch <= 'F') || ('0' <= ch) && (ch <= '9'));
    }
}

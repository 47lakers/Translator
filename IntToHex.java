package prob0719;

public class IntToHex {
    public static String StringToHex(int decimal){
        int rem;
        String hex="";
        char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(decimal>0)
        {
            rem=decimal%16;
            hex=hexchars[rem]+hex;
            decimal=decimal/16;
        }
        return hex;
    }

    public static String ReturnString(int num){
        String str;
        if(num == 0){
            str = String.format("0000%s", StringToHex(num));
        }else if(num < 16) {
            str = String.format("000%s", StringToHex(num));
        }else if(num < 256) {
            str = String.format("00%s", StringToHex(num));
        }else if(num < 4096) {
            str = String.format("0%s", StringToHex(num));
        }else{
            str = String.format("%s", StringToHex(num));
        }
        return str;
    }

    public static String ReturnString2(int num){
        String str;
        if(num == 0){
            str = String.format("0000%s", StringToHex(num));
        }else if(num < 16) {
            str = String.format("000%s", StringToHex(num));
        }else if(num < 256) {
            str = String.format("00%s", StringToHex(num));
        }else if(num < 4096) {
            str = String.format("0%s", StringToHex(num));
        }else{
            str = String.format("%s", StringToHex(num));
        }
        return str;
    }
}

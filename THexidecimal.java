package prob0719;

public class THexidecimal extends AToken{
    private final int hexValue;


    public THexidecimal(int i){
        hexValue = i;
    }

    public int getHexValue(){
        return hexValue;
    }

    @Override
    public String getDescription(){
        return String.format("Hexadecimal Constant = %d", hexValue);
    }
}

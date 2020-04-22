package prob0719;

import static prob0719.IntToHex.StringToHex;

public class HexArg extends AArg{
    private final int hexValue;
    public HexArg(int hex){
        hexValue = hex;
    }


    @Override
    public String generateCode() {
        return IntToHex.ReturnString(hexValue);
    }

    public int returnNum(){
        return hexValue;
    }
}

package prob0719;

public class Tokenizer {
    private final InBuffer b;

    public Tokenizer(InBuffer inBuffer){
        b = inBuffer;
    }

    public AToken getToken(){
        char nextChar;
        StringBuffer localStringValue = new StringBuffer("");
        int localIntValue = 0;
        int localHexValue = 0;
        int sign = +1;
        AToken aToken = new TEmpty();
        LexState state = LexState.LS_START;
        do{
            nextChar = b.advanceInput();
            switch(state){
                case LS_START:
                    if(nextChar == '0'){
                        state = LexState.LS_INT1;
                    }else  if(Util.isDigit(nextChar)){
                        localIntValue = nextChar - '0';
                        state = LexState.LS_INT2;
                    }else if (nextChar == '-'){
                        sign = -1;
                        state = LexState.LS_SIGN;
                    }else if(nextChar == '+'){
                        sign = +1;
                        state = LexState.LS_SIGN;
                    }else if(Util.isAlpha(nextChar)){
                        localStringValue.append(nextChar);
                        state = LexState.LS_IDENT;
                    } else if(nextChar == '.'){
                        state = LexState.LS_DOT1;
                    }else if(nextChar == ','){
                        state = LexState.LS_ADDR1;
                    }else if(nextChar == '\n'){
                        state = LexState.LS_STOP;
                    }else if(nextChar != ' '){
                        aToken = new TInvalid();
                    }
                    break;
                case LS_INT1:
                    if(nextChar == 'X' || nextChar == 'x'){
                        state = LexState.LS_HEX1;
                    }else if(Util.isDigit(nextChar) || nextChar == '0'){
                        localIntValue = 10 * localIntValue + nextChar - '0';
                        state = LexState.LS_INT2;
                    } else{
                        b.backUpInput();
                        aToken = new TInteger(localIntValue);
                        state = LexState.LS_STOP;
                    }
                    break;
                case LS_INT2:
                    if(Util.isDigit(nextChar) || nextChar == '0'){
                        localIntValue = 10 * localIntValue + nextChar - '0';
                    }else{
                        b.backUpInput();
                        int x = sign * localIntValue;
                        if(x > 65535 || x < -32768){
                            aToken = new TInvalid();
                        }else{
                            aToken = new TInteger(x);
                        }
                        state = LexState.LS_STOP;
                    }
                    break;
                case LS_SIGN:
                    if(Util.isDigit(nextChar) || nextChar == 0){
                        localIntValue = 10 * localIntValue + nextChar - '0';
                        state = LexState.LS_INT2;
                    }else{
                        aToken = new TInvalid();
                    }
                    break;
                case LS_HEX1:
                    if(Util.isHex(nextChar)){
                        if(nextChar == 'a' || nextChar == 'A'){
                            localHexValue = 16 * localHexValue + 10;
                        }else if(nextChar == 'b' || nextChar == 'B'){
                            localHexValue = 16 * localHexValue + 11;
                        }else if(nextChar == 'c' || nextChar == 'C'){
                            localHexValue = 16 * localHexValue + 12;
                        }else if(nextChar == 'd' || nextChar == 'D'){
                            localHexValue = 16 * localHexValue + 13;
                        }else if(nextChar == 'e' || nextChar == 'E'){
                            localHexValue = 16 * localHexValue + 14;
                        }else if(nextChar == 'f' || nextChar == 'F'){
                            localHexValue = 16 * localHexValue + 15;
                        }else{
                            localHexValue = 16 * localHexValue + nextChar - '0';
                        }
                        state = LexState.LS_HEX2;
                    }else{
                        aToken = new TInvalid();
                    }
                    break;
                case LS_HEX2:
                    if(Util.isHex(nextChar)){
                        if(nextChar == 'a' || nextChar == 'A'){
                            localHexValue = 16 * localHexValue + 10;
                        }else if(nextChar == 'b' || nextChar == 'B'){
                            localHexValue = 16 * localHexValue + 11;
                        }else if(nextChar == 'c' || nextChar == 'C'){
                            localHexValue = 16 * localHexValue + 12;
                        }else if(nextChar == 'd' || nextChar == 'D'){
                            localHexValue = 16 * localHexValue + 13;
                        }else if(nextChar == 'e' || nextChar == 'E'){
                            localHexValue = 16 * localHexValue + 14;
                        }else if(nextChar == 'f' || nextChar == 'F'){
                            localHexValue = 16 * localHexValue + 15;
                        }else{
                            localHexValue = 16 * localHexValue + nextChar - '0';
                        }
                    }else{
                        b.backUpInput();
                        if(localHexValue > 65535){
                            aToken = new TInvalid();
                        }else {
                            aToken = new THexidecimal(localHexValue);
                        }
                        state = LexState.LS_STOP;
                    }
                    break;
                case LS_IDENT:
                    if(Util.isAlpha(nextChar)){
                        localStringValue.append(nextChar);
                    }else if(Util.isDigit(nextChar) || nextChar == '0'){
                        localStringValue.append(nextChar);
                    }else{
                        b.backUpInput();
                        aToken = new TIdentifier(localStringValue);
                        state = LexState.LS_STOP;
                    }
                    break;
                case LS_DOT1:
                    if(Util.isAlpha(nextChar)){
                        localStringValue.append(nextChar);
                        state = LexState.LS_DOT2;
                    }else{
                        aToken = new TInvalid();
                    }
                    break;
                case LS_DOT2:
                    if(Util.isAlpha(nextChar)){
                        localStringValue.append(nextChar);
                    }else{
                        b.backUpInput();
                        aToken = new TDotCommand(localStringValue);
                        state = LexState.LS_STOP;
                    }
                    break;
                case LS_ADDR1:
                    if(Util.isAlpha(nextChar)){
                        localStringValue.append(nextChar);
                        state = LexState.LS_ADDR2;
                    }else if(nextChar != ' '){
                        aToken = new TInvalid();
                    }
                    break;
                case LS_ADDR2:
                    if(Util.isAlpha(nextChar)){
                        localStringValue.append(nextChar);
                        state = LexState.LS_ADDR2;
                    }else{
                        b.backUpInput();
                        aToken = new TAddress(localStringValue);
                        state = LexState.LS_STOP;
                    }
            }
        } while((state != LexState.LS_STOP) && !(aToken instanceof TInvalid));
        return aToken;
    }
}

/*
alpha .beta
     b7 0x23ab ,SfX
,i , cat
-32768 65535


alpha$beta
0xQ
0x12345
-32769
65536
<empty line>
 */
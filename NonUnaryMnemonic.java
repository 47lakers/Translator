package prob0719;

public class NonUnaryMnemonic extends ACode{
    private final Mnemon instruction;
    private final AArg aArg;
    private final Mnemon address;
    public NonUnaryMnemonic(Mnemon instr, AArg aArg, Mnemon add){
        instruction = instr;
        this.aArg = aArg;
        address = add;
    }

    @Override
    public String generateListing(){
        String br;
        if(Maps.mnemonStringTable.get(instruction) == "BR"){
            br = String.format("%s          %s,%s", Maps.mnemonStringTable.get(instruction), aArg.generateCode(), Maps.mnemonStringTable.get(address)) + "\n";
        }else{
            br = String.format("%s        %s,%s", Maps.mnemonStringTable.get(instruction), aArg.generateCode(), Maps.mnemonStringTable.get(address)) + "\n";
        }
        return br;
    }
    public String generateCode(){
        String string;
        switch(instruction){
            case M_BR:
                int br = 18;
                if(address == Mnemon.M_X){
                    br+=1;
                }
                int num = aArg.returnNum();
                string = IntToHex.StringToHex(br) + IntToHex.ReturnString2(num) + "\n";
                break;
            case M_DECI:
                int deci = 48 + (address.ordinal() - 16);
                int num1 = aArg.returnNum();
                string = IntToHex.StringToHex(deci) + IntToHex.ReturnString2(num1) + "\n";
                break;
            case M_DECO:
                int deco = 56 + (address.ordinal() - 16);
                int num2 = aArg.returnNum();
                string = IntToHex.StringToHex(deco) + IntToHex.ReturnString2(num2) + "\n";
                break;
            case M_ADDA:
                int adda = 96 + (address.ordinal() - 16);
                int num3 = aArg.returnNum();
                string = IntToHex.StringToHex(adda) + IntToHex.ReturnString2(num3) + "\n";
                break;
            case M_SUBA:
                int suba = 112 + (address.ordinal() - 16);
                int num4 = aArg.returnNum();
                string = IntToHex.StringToHex(suba) + IntToHex.ReturnString2(num4) + "\n";
                break;
            case M_STWA:
                int stwa = 224 + (address.ordinal() - 16);
                int num5 = aArg.returnNum();
                string = IntToHex.StringToHex(stwa) + IntToHex.ReturnString2(num5) + "\n";
                break;
            case M_LDWA:
                int ldwa = 192 + (address.ordinal() - 16);
                int num6 = aArg.returnNum();
                string = IntToHex.StringToHex(ldwa) + IntToHex.ReturnString2(num6) + "\n";
                break;
            case M_CPWA:
                int cpwa = 160 + (address.ordinal() - 16);
                int num7 = aArg.returnNum();
                string = IntToHex.StringToHex(cpwa) + IntToHex.ReturnString2(num7) + "\n";
                break;
            case M_BRLE:
                int brle = 20;
                if(address == Mnemon.M_X){
                    brle+=1;
                }
                int num8 = aArg.returnNum();
                string = IntToHex.StringToHex(brle) + IntToHex.ReturnString2(num8) + "\n";
                break;
            case M_BRLT:
                int brlt = 22;
                if(address == Mnemon.M_X){
                    brlt+=1;
                }
                int num9 = aArg.returnNum();
                string = IntToHex.StringToHex(brlt) + IntToHex.ReturnString2(num9) + "\n";
                break;
            case M_BREQ:
                int breq = 24;
                if(address == Mnemon.M_X){
                    breq+=1;
                }
                int num10 = aArg.returnNum();
                string = IntToHex.StringToHex(breq) + IntToHex.ReturnString2(num10) + "\n";
                break;
            default:
                return "";

        }
        return string;
    }
}

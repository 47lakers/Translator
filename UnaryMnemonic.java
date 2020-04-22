package prob0719;

public class UnaryMnemonic extends ACode{
    private final Mnemon mnemonic;
    public UnaryMnemonic(Mnemon mn){
        mnemonic = mn;
    }
    @Override
    public String generateListing(){
        return Maps.mnemonStringTable.get(mnemonic) + "\n";
    }
    public String generateCode(){
        String string;
        switch(mnemonic){
            case M_STOP:
                string = "00\n";
                break;
            case M_ASLA:
                string = "0A\n";
                break;
            case M_ASRA:
                string = "0C\n";
                break;
            default:
                return ""; 

        }
        return string;
    }
}

package prob0719;

public class End extends ACode{
    private final Mnemon mnemonic;
    public End(Mnemon mn){
        mnemonic = mn;
    }
    @Override
    public String generateListing(){
        return Maps.mnemonStringTable.get(mnemonic) + "\n";
    }
    public String generateCode(){
        return "";
    }
}

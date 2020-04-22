package prob0719;

public class Block extends ACode{
    private final Mnemon mnemonic;
    private final AArg aArg;
    public Block(Mnemon mn, AArg aArg){
        mnemonic = mn;
        this.aArg = aArg;
    }
    @Override
    public String generateListing(){
        return String.format("%s      %s", Maps.mnemonStringTable.get(mnemonic), aArg.generateCode()) + "\n";
    }
    public String generateCode(){
        int num = aArg.returnNum() * 2;
        String string = "";
        for(int i = 0; i < num; i++){
            string += "0";
        }
        string += "\n";
        return string;
    }
}

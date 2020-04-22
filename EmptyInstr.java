package prob0719;

public class EmptyInstr extends ACode {
    //for an empty source line
    @Override
    public String generateListing(){
        return "\n";
    }
    public String generateCode(){
        return "";
    }
}

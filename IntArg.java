package prob0719;

public class IntArg extends AArg{
    private final int intValue;
    public IntArg(int i){
        intValue = i;
    }
    @Override
    public String generateCode(){
        return String.format("%d", intValue);
    }

    public int returnNum(){
        return intValue;
    }
}

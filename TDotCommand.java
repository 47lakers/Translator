package prob0719;

public class TDotCommand extends AToken{
    private final String dotValue;

    public TDotCommand(StringBuffer stringBuffer){
        dotValue = new String(stringBuffer);
    }

    public String getDotValue(){
        return dotValue;
    }


    @Override
    public String getDescription(){
        return String.format("Dot command = %s", dotValue);
    }
}

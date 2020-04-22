package prob0719;
import java.util.ArrayList;

public class Translator {
    private final InBuffer b;
    private Tokenizer t;
    private ACode aCode;

    public Translator(InBuffer inBuffer){
        b = inBuffer;
    }

    //Sets aCode and returns boolean true if end statement is processed.
    private boolean parseLine() {
        boolean terminate = false;
        AArg localSpecifier = new IntArg(0);
        Mnemon localAddress = Mnemon.M_END;
        Mnemon localMnemon = Mnemon.M_END;
        AToken aToken;
        aCode = new EmptyInstr();
        ParseState state = ParseState.PS_START;
        do {
            aToken = t.getToken();
            switch (state) {
                case PS_START:
                    if (aToken instanceof TIdentifier) {
                        TIdentifier localTIdentifier = (TIdentifier) aToken;
                        String tempStr = localTIdentifier.getStringValue();
                        if (Maps.unaryMnemonTable.containsKey(tempStr.toUpperCase())) {
                            localMnemon = Maps.unaryMnemonTable.get(tempStr.toUpperCase());
                            aCode = new UnaryMnemonic(localMnemon);
                            terminate = localMnemon == Mnemon.M_END;
                            state = ParseState.PS_EMPTY;
                        }else if(Maps.nonUnaryMnemonTable.containsKey(tempStr.toUpperCase())){
                            localMnemon = Maps.nonUnaryMnemonTable.get(tempStr.toUpperCase());
                            state = ParseState.PS_IDENT;
                        }else{
                            aCode = new Error("Not a valid mnemonic.");
                        }
                    }else if(aToken instanceof TEmpty){
                        aCode = new EmptyInstr();
                        state = ParseState.PS_FINISH;
                    }else if(aToken instanceof TDotCommand){
                        TDotCommand localTDotCommand = (TDotCommand) aToken;
                        String tempStr = localTDotCommand.getDotValue();
                        if(Maps.end.containsKey(tempStr.toUpperCase())) {
                            localMnemon = Maps.end.get(tempStr.toUpperCase());
                            aCode = new End(localMnemon);
                            terminate = localMnemon == Mnemon.M_END;
                            state = ParseState.PS_EMPTY;
                        }else if(Maps.block.containsKey(tempStr.toUpperCase())){
                            localMnemon = Maps.block.get(tempStr.toUpperCase());
                            state = ParseState.PS_DOT1;
                        }else{
                            aCode = new Error("Not a valid dot command.");
                        }
                    }else{
                        aCode = new Error("Line must begin with mnemonic or dot command.");
                    }
                    break;
                case PS_DOT1:
                    if(aToken instanceof TInteger){
                        TInteger localTInteger = (TInteger) aToken;
                        localSpecifier = new IntArg(localTInteger.getIntValue());
                        if(localSpecifier.returnNum() < 0){
                            aCode = new Error("Not a valid number for .BLOCK.");
                        }else {
                            aCode = new Block(localMnemon, localSpecifier);
                        }
                        state = ParseState.PS_EMPTY;
                    }else if(aToken instanceof THexidecimal){
                        THexidecimal localTHexidecimal = (THexidecimal) aToken;
                        localSpecifier = new HexArg(localTHexidecimal.getHexValue());
                        aCode = new Block(localMnemon, localSpecifier);
                        state = ParseState.PS_EMPTY;
                    }else{
                        aCode = new Error("Not a valid dot command.");
                    }
                    break;
                case PS_IDENT:
                    if(aToken instanceof TInteger){
                        TInteger localTInteger = (TInteger) aToken;
                        localSpecifier = new IntArg(localTInteger.getIntValue());
                        state = ParseState.PS_OPERAND;
                    }else if(aToken instanceof THexidecimal){
                        THexidecimal localTHexidecimal = (THexidecimal) aToken;
                        localSpecifier = new HexArg(localTHexidecimal.getHexValue());
                        state = ParseState.PS_OPERAND;
                    }else{
                        aCode = new Error("Operand specifier has to be either a hexidecimal or a decimal.");
                    }
                    break;
                case PS_OPERAND:
                    if(aToken instanceof TAddress){
                        TAddress localTAddress = (TAddress) aToken;
                        String add = localTAddress.getAddressValue();
                        if (Maps.addressingModes.containsKey(add.toLowerCase())) {
                            localAddress = Maps.addressingModes.get(add.toLowerCase());
                            aCode = new NonUnaryMnemonic(localMnemon, localSpecifier, localAddress);
                            terminate = localMnemon == Mnemon.M_END;
                            state = ParseState.PS_EMPTY;
                        }else{
                            aCode = new Error("Not a valid addressing mode.");
                        }
                    }else {
                        aCode = new Error("Please type in an addressing mode.");
                    }
                    break;
                case PS_EMPTY:
                    if(aToken instanceof TEmpty){
                        state = ParseState.PS_FINISH;
                    }else{
                        aCode = new Error("Illegal trailing character.");
                    }
                    break;
            }
        } while (state != ParseState.PS_FINISH && !(aCode instanceof Error));
        return terminate;
    }
    public void translate() {
        ArrayList<ACode> codeTable = new ArrayList<>();
        int numErrors = 0;
        t = new Tokenizer(b);
        boolean terminateWithEnd = false;
        b.getLine();
        while (b.inputRemains() && !terminateWithEnd) {
            terminateWithEnd = parseLine(); // Sets aCode and returns boolean.
            codeTable.add(aCode);
            if (aCode instanceof Error) {
                numErrors++;
            }
            b.getLine();
        }
        if (!terminateWithEnd) {
            aCode = new Error("Missing \"end\" sentinel.");
            codeTable.add(aCode);
            numErrors++;
        }
        if (numErrors == 0) {
            System.out.printf("Object code:\n");
            for (int i = 0; i < codeTable.size(); i++) {
                System.out.printf("%s", codeTable.get(i).generateCode());
            }
        }
        if (numErrors == 1) {
            System.out.printf("One error was detected.\n");
        } else if (numErrors > 1) {
            System.out.printf("%d errors were detected.\n", numErrors);
        }
        System.out.printf("\nProgram listing:\n");
        for (int i = 0; i < codeTable.size(); i++) {
            System.out.printf("%s", codeTable.get(i).generateListing());
        }
    }
}

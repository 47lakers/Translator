package prob0719;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public final class Maps {
    public static final Map<String, Mnemon> unaryMnemonTable;
    public static final Map<String, Mnemon> nonUnaryMnemonTable;
    public static final Map<String, Mnemon> end;
    public static final Map<String, Mnemon> block;
    public static final Map<String, Mnemon> addressingModes;
    public static final Map<Mnemon, String> mnemonStringTable;
    public static final Map<Mnemon, Integer> mnemonHexTable;

    static{
        unaryMnemonTable = new HashMap<>();
        unaryMnemonTable.put("STOP", Mnemon.M_STOP);
        unaryMnemonTable.put("ASLA", Mnemon.M_ASLA);
        unaryMnemonTable.put("ASRA", Mnemon.M_ASRA);

        nonUnaryMnemonTable = new HashMap<>();
        nonUnaryMnemonTable.put("BR", Mnemon.M_BR);
        nonUnaryMnemonTable.put("BRLT", Mnemon.M_BRLT);
        nonUnaryMnemonTable.put("BREQ", Mnemon.M_BREQ);
        nonUnaryMnemonTable.put("BRLE", Mnemon.M_BRLE);
        nonUnaryMnemonTable.put("CPWA", Mnemon.M_CPWA);
        nonUnaryMnemonTable.put("DECI", Mnemon.M_DECI);
        nonUnaryMnemonTable.put("DECO", Mnemon.M_DECO);
        nonUnaryMnemonTable.put("ADDA", Mnemon.M_ADDA);
        nonUnaryMnemonTable.put("SUBA", Mnemon.M_SUBA);
        nonUnaryMnemonTable.put("STWA", Mnemon.M_STWA);
        nonUnaryMnemonTable.put("LDWA", Mnemon.M_LDWA);

        end = new HashMap<>();
        end.put("END", Mnemon.M_END);

        block = new HashMap<>();
        block.put("BLOCK", Mnemon.M_BLOCK);

        addressingModes = new HashMap<>();
        addressingModes.put("i", Mnemon.M_I);
        addressingModes.put("d", Mnemon.M_D);
        addressingModes.put("n", Mnemon.M_N);
        addressingModes.put("s", Mnemon.M_S);
        addressingModes.put("sf", Mnemon.M_SF);
        addressingModes.put("x", Mnemon.M_X);
        addressingModes.put("sx", Mnemon.M_SX);
        addressingModes.put("sfx", Mnemon.M_SFX);

        mnemonStringTable = new EnumMap<>(Mnemon.class);
        mnemonStringTable.put(Mnemon.M_STOP, "STOP");
        mnemonStringTable.put(Mnemon.M_ASLA, "ASLA");
        mnemonStringTable.put(Mnemon.M_ASRA, "ASRA");
        mnemonStringTable.put(Mnemon.M_BR, "BR");
        mnemonStringTable.put(Mnemon.M_BRLT, "BRLT");
        mnemonStringTable.put(Mnemon.M_BREQ, "BREQ");
        mnemonStringTable.put(Mnemon.M_BRLE, "BRLE");
        mnemonStringTable.put(Mnemon.M_CPWA, "CPWA");
        mnemonStringTable.put(Mnemon.M_DECI, "DECI");
        mnemonStringTable.put(Mnemon.M_DECO, "DECO");
        mnemonStringTable.put(Mnemon.M_ADDA, "ADDA");
        mnemonStringTable.put(Mnemon.M_SUBA, "SUBA");
        mnemonStringTable.put(Mnemon.M_STWA, "STWA");
        mnemonStringTable.put(Mnemon.M_LDWA, "LDWA");
        mnemonStringTable.put(Mnemon.M_BLOCK, ".BLOCK");
        mnemonStringTable.put(Mnemon.M_END, ".END");
        mnemonStringTable.put(Mnemon.M_I, "i");
        mnemonStringTable.put(Mnemon.M_D, "d");
        mnemonStringTable.put(Mnemon.M_N, "n");
        mnemonStringTable.put(Mnemon.M_S, "s");
        mnemonStringTable.put(Mnemon.M_SF, "sf");
        mnemonStringTable.put(Mnemon.M_X, "x");
        mnemonStringTable.put(Mnemon.M_SX, "sx");
        mnemonStringTable.put(Mnemon.M_SFX, "sfx");

        mnemonHexTable = new EnumMap<>(Mnemon.class);
        mnemonHexTable.put(Mnemon.M_STOP, 0);
        mnemonHexTable.put(Mnemon.M_ASLA, 10);
        mnemonHexTable.put(Mnemon.M_ASRA, 12);
        mnemonHexTable.put(Mnemon.M_BR, 18);
        mnemonHexTable.put(Mnemon.M_BRLT, 22);
        mnemonHexTable.put(Mnemon.M_BREQ, 24);
        mnemonHexTable.put(Mnemon.M_BRLE, 20);
        mnemonHexTable.put(Mnemon.M_CPWA, 160);
        mnemonHexTable.put(Mnemon.M_DECI, 48);
        mnemonHexTable.put(Mnemon.M_DECO, 56);
        mnemonHexTable.put(Mnemon.M_ADDA, 80);
        mnemonHexTable.put(Mnemon.M_SUBA, 88);
        mnemonHexTable.put(Mnemon.M_STWA, 224);
        mnemonHexTable.put(Mnemon.M_LDWA, 192);
    }

}

package com.google.zxing.common;

import com.google.zxing.FormatException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public enum CharacterSetECI {
    Cp437(new int[]{0, 2}, new String[0]),
    ISO8859_1(new int[]{1, 3}, "ISO-8859-1"),
    ISO8859_2(4, "ISO-8859-2"),
    ISO8859_3(5, "ISO-8859-3"),
    ISO8859_4(6, "ISO-8859-4"),
    ISO8859_5(7, "ISO-8859-5"),
    ISO8859_6(8, "ISO-8859-6"),
    ISO8859_7(9, "ISO-8859-7"),
    ISO8859_8(10, "ISO-8859-8"),
    ISO8859_9(11, "ISO-8859-9"),
    ISO8859_10(12, "ISO-8859-10"),
    ISO8859_11(13, "ISO-8859-11"),
    ISO8859_13(15, "ISO-8859-13"),
    ISO8859_14(16, "ISO-8859-14"),
    ISO8859_15(17, "ISO-8859-15"),
    ISO8859_16(18, "ISO-8859-16"),
    SJIS(20, "Shift_JIS"),
    Cp1250(21, "windows-1250"),
    Cp1251(22, "windows-1251"),
    Cp1252(23, "windows-1252"),
    Cp1256(24, "windows-1256"),
    UnicodeBigUnmarked(25, "UTF-16BE", "UnicodeBig"),
    UTF8(26, "UTF-8"),
    ASCII(new int[]{27, 170}, "US-ASCII"),
    Big5(28),
    GB18030(29, "GB2312", "EUC_CN", "GBK"),
    EUC_KR(30, "EUC-KR");


    /* renamed from: G, reason: collision with root package name */
    public static final Map<Integer, CharacterSetECI> f25034G = new HashMap();

    /* renamed from: H, reason: collision with root package name */
    public static final Map<String, CharacterSetECI> f25035H = new HashMap();
    private final String[] otherEncodingNames;
    private final int[] values;

    static {
        for (CharacterSetECI characterSetECI : values()) {
            for (int i10 : characterSetECI.values) {
                f25034G.put(Integer.valueOf(i10), characterSetECI);
            }
            f25035H.put(characterSetECI.name(), characterSetECI);
            for (String str : characterSetECI.otherEncodingNames) {
                f25035H.put(str, characterSetECI);
            }
        }
    }

    CharacterSetECI(int i10) {
        this(new int[]{i10}, new String[0]);
    }

    public static CharacterSetECI a(String str) {
        return f25035H.get(str);
    }

    public static CharacterSetECI b(int i10) {
        if (i10 >= 0 && i10 < 900) {
            return f25034G.get(Integer.valueOf(i10));
        }
        throw FormatException.a();
    }

    public int c() {
        return this.values[0];
    }

    CharacterSetECI(int i10, String... strArr) {
        this.values = new int[]{i10};
        this.otherEncodingNames = strArr;
    }

    CharacterSetECI(int[] iArr, String... strArr) {
        this.values = iArr;
        this.otherEncodingNames = strArr;
    }
}

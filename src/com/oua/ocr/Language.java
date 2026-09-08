package com.oua.ocr;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class Language {
    public static final int Chinese_Simp = 5;
    public static final int Chinese_Trad = 6;
    public static final int Danish = 46;
    public static final int Default = 100;
    public static final int Dutch = 47;
    public static final int English = 11;
    public static final int Finnish = 48;
    public static final int French = 49;
    public static final int German = 50;
    public static final int Hungarian = 61;
    public static final int Italian = 52;
    public static final int Japanese = 22;
    public static final int Korean = 23;
    public static final Map<Integer, String> LANGUAGE_NAMES;
    public static final int NA = -1;
    public static final int Norwegian = 53;
    public static final int Number = 0;
    public static final int Portuguese = 54;
    public static final int Russian = 59;
    public static final int Spanish = 55;
    public static final int Swedish = 56;

    static {
        HashMap hashMap = new HashMap();
        LANGUAGE_NAMES = hashMap;
        hashMap.put(5, "Chinese_Simp");
        hashMap.put(6, "Chinese_Trad");
        hashMap.put(11, "English");
        hashMap.put(22, "Japanese");
        hashMap.put(23, "Korean");
        hashMap.put(46, "Danish");
        hashMap.put(47, "Dutch");
        hashMap.put(48, "Finnish");
        hashMap.put(49, "French");
        hashMap.put(50, "German");
        hashMap.put(52, "Italian");
        hashMap.put(53, "Norwegian");
        hashMap.put(54, "Portuguese");
        hashMap.put(55, "Spanish");
        hashMap.put(56, "Swedish");
        hashMap.put(59, "Russian");
        hashMap.put(61, "Hungarian");
    }

    public static String toString(int i10) {
        return LANGUAGE_NAMES.getOrDefault(Integer.valueOf(i10), "Unknown");
    }
}

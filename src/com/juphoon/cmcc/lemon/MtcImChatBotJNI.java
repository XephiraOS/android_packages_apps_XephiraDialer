package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcImChatBotJNI {
    public static final native long MtcByteArray_data_get(long j10, MtcByteArray mtcByteArray);

    public static final native void MtcByteArray_data_set(long j10, MtcByteArray mtcByteArray, long j11);

    public static final native long MtcByteArray_size_get(long j10, MtcByteArray mtcByteArray);

    public static final native void MtcByteArray_size_set(long j10, MtcByteArray mtcByteArray, long j11);

    public static final native byte[] MtcByteArray_value_get(long j10, MtcByteArray mtcByteArray);

    public static final native void MtcByteArray_value_set(long j10, MtcByteArray mtcByteArray, byte[] bArr);

    public static final native int MtcNumber_value_get(long j10, MtcNumber mtcNumber);

    public static final native void MtcNumber_value_set(long j10, MtcNumber mtcNumber, int i10);

    public static final native String MtcString_value_get(long j10, MtcString mtcString);

    public static final native void MtcString_value_set(long j10, MtcString mtcString, String str);

    public static final native Object Mtc_ImGetChatBotCookie(int i10);

    public static final native String Mtc_ImGetChatBotInfGetBody(int i10);

    public static final native int Mtc_ImGetChatBotInfGetVersion(int i10);

    public static final native int Mtc_ImGetChatBotInformation(Object obj, int i10, String str, String str2, String str3);

    public static final native boolean Mtc_ImGetChatBotIsBlackLst(int i10);

    public static final native int Mtc_ImGetChatBotList(Object obj, String str, int i10, int i11, boolean z10);

    public static final native String Mtc_ImGetChatBotListGetBody(int i10);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

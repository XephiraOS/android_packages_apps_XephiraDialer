package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcImImdnJNI {
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

    public static final native Object Mtc_ImdnGetCookie(int i10);

    public static final native String Mtc_ImdnGetIMsgId(int i10);

    public static final native int Mtc_ImdnGetPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImdnSendBurn(Object obj, String str, String str2, String str3, String str4);

    public static final native int Mtc_ImdnSendDeli(Object obj, String str, String str2);

    public static final native int Mtc_ImdnSendDeliG(Object obj, String str, String str2, String str3, String str4);

    public static final native int Mtc_ImdnSendDeliX(Object obj, int i10, String str, String str2);

    public static final native int Mtc_ImdnSendDisp(Object obj, String str, String str2);

    public static final native int Mtc_ImdnSendDispG(Object obj, String str, String str2, String str3, String str4);

    public static final native int Mtc_ImdnSendDispX(Object obj, int i10, String str, String str2);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

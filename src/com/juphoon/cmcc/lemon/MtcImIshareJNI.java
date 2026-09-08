package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcImIshareJNI {
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

    public static final native int Mtc_ImIShareAccept(int i10, String str);

    public static final native int Mtc_ImIShareCancel(int i10);

    public static final native Object Mtc_ImIShareGetCookie(int i10);

    public static final native int Mtc_ImIShareGetDateTime(int i10);

    public static final native String Mtc_ImIShareGetName(int i10);

    public static final native int Mtc_ImIShareGetOrigIdPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImIShareGetOrigPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImIShareGetPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImIShareGetPartpLstId(int i10);

    public static final native int Mtc_ImIShareGetPartpType(int i10);

    public static final native int Mtc_ImIShareGetRecvSize(int i10);

    public static final native int Mtc_ImIShareGetSentSize(int i10);

    public static final native int Mtc_ImIShareGetSize(int i10);

    public static final native int Mtc_ImIShareGetSysDateTime(int i10, long j10);

    public static final native int Mtc_ImIShareGetType(int i10);

    public static final native int Mtc_ImIShareReject(int i10);

    public static final native int Mtc_ImIShareRelease(int i10);

    public static final native int Mtc_ImIShareSend(Object obj, String str, String str2, int i10);

    public static final native int Mtc_ImIShareSetCookie(int i10, Object obj);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

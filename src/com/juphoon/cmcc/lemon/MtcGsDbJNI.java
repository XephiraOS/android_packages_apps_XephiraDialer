package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcGsDbJNI {
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

    public static final native int Mtc_GsDbGetAllowedSmsType();

    public static final native int Mtc_GsDbGetBlockTimer();

    public static final native String Mtc_GsDbGetHslpAddr();

    public static final native String Mtc_GsDbGetHslpAddrType();

    public static final native int Mtc_GsDbGetLocInfoMaxValidTime();

    public static final native int Mtc_GsDbGetMediaProtoType();

    public static final native String Mtc_GsDbGetOneApiHost();

    public static final native short Mtc_GsDbGetOneApiPort();

    public static final native String Mtc_GsDbGetOneApiRoot();

    public static final native String Mtc_GsDbGetOneApiVers();

    public static final native boolean Mtc_GsDbGetPullOpen();

    public static final native int Mtc_GsDbGetPullType();

    public static final native boolean Mtc_GsDbGetPushEnable();

    public static final native int Mtc_GsDbGetTxtMaxLen();

    public static final native int Mtc_GsDbSetAllowedSmsType(int i10);

    public static final native int Mtc_GsDbSetBlockTimer(int i10);

    public static final native int Mtc_GsDbSetMediaProtoType(int i10);

    public static final native int Mtc_GsDbSetOneApiHost(String str);

    public static final native int Mtc_GsDbSetOneApiPort(short s10);

    public static final native int Mtc_GsDbSetOneApiRoot(String str);

    public static final native int Mtc_GsDbSetOneApiVers(String str);

    public static final native int Mtc_GsDbSetPullOpen(boolean z10);

    public static final native int Mtc_GsDbSetPullType(int i10);

    public static final native int Mtc_GsDbSetPushEnable(boolean z10);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

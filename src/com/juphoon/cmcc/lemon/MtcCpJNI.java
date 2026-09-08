package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcCpJNI {
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

    public static final native int Mtc_Cp(int i10, String str);

    public static final native int Mtc_CpAD();

    public static final native int Mtc_CpADPromptOTP(int i10, String str);

    public static final native int Mtc_CpADPromptPIN(int i10, String str);

    public static final native int Mtc_CpADWithOTP(String str);

    public static final native int Mtc_CpAct(int i10, int i11);

    public static final native int Mtc_CpEUCRAct(int i10, int i11, String str);

    public static final native int Mtc_CpGetRetryTimeLen(int i10);

    public static final native int Mtc_CpPromptMSISDN(int i10, String str);

    public static final native int Mtc_CpPromptOTP(int i10, String str);

    public static final native int Mtc_CpPromptToken(int i10, String str);

    public static final native int Mtc_CpReCfg(int i10);

    public static final native int Mtc_CpValidSMS(String str);

    public static final native int Mtc_CpX(int i10, String str, int i11);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

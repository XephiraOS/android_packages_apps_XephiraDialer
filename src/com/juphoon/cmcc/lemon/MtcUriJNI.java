package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcUriJNI {
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

    public static final native String Mtc_UriFormat(String str, String str2, boolean z10);

    public static final native String Mtc_UriFormatInt(String str);

    public static final native String Mtc_UriFormatNat(String str);

    public static final native String Mtc_UriFormatTelUri(String str);

    public static final native String Mtc_UriFormatX(String str, boolean z10);

    public static final native String Mtc_UriGetDirectUri(String str);

    public static final native String Mtc_UriGetHostPart(String str);

    public static final native String Mtc_UriGetName(String str, int i10);

    public static final native String Mtc_UriGetTmnlType(String str);

    public static final native String Mtc_UriGetUserPart(String str);

    public static final native boolean Mtc_UriIsValid(String str);

    public static final native String Mtc_UriWebFormat(String str);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcImStfwdJNI {
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

    public static final native int Mtc_ImStFwdAccept(int i10);

    public static final native String Mtc_ImStFwdGetContId(int i10);

    public static final native String Mtc_ImStFwdGetConvId(int i10);

    public static final native int Mtc_ImStFwdGetDateTime(int i10);

    public static final native int Mtc_ImStFwdGetOrigIdPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImStFwdGetOrigPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImStFwdGetPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImStFwdGetPartpLstId(int i10);

    public static final native int Mtc_ImStFwdGetPartpType(int i10);

    public static final native String Mtc_ImStFwdGetSubject(int i10);

    public static final native int Mtc_ImStFwdGetSysDateTime(int i10, long j10);

    public static final native String Mtc_ImStFwdMsgGetContent(int i10, int i11);

    public static final native int Mtc_ImStFwdMsgGetContentLen(int i10, int i11);

    public static final native int Mtc_ImStFwdMsgGetContentType(int i10, int i11);

    public static final native int Mtc_ImStFwdMsgGetDateTime(int i10, int i11);

    public static final native String Mtc_ImStFwdMsgGetDeviceId(int i10, int i11);

    public static final native int Mtc_ImStFwdMsgGetGInfoId(int i10, int i11);

    public static final native String Mtc_ImStFwdMsgGetImdnMsgId(int i10, int i11);

    public static final native int Mtc_ImStFwdMsgGetImdnType(int i10, int i11);

    public static final native int Mtc_ImStFwdMsgGetMContent(int i10, int i11, MtcByteArray mtcByteArray);

    public static final native int Mtc_ImStFwdMsgGetPartp(int i10, int i11, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImStFwdMsgGetSysDateTime(int i10, int i11, long j10);

    public static final native int Mtc_ImStFwdReject(int i10);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

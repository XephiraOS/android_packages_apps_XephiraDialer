package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcImMsJNI {
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

    public static final native int Mtc_ImMsBackupAppend(int i10, int i11);

    public static final native int Mtc_ImMsBackupBegin(int i10, String str);

    public static final native int Mtc_ImMsBackupEnd(int i10);

    public static final native int Mtc_ImMsCreate();

    public static final native int Mtc_ImMsDelete(int i10);

    public static final native Object Mtc_ImMsGetCookie(int i10);

    public static final native boolean Mtc_ImMsGetEmptyRestoreInd(int i10);

    public static final native int Mtc_ImMsGetObjCount(int i10);

    public static final native int Mtc_ImMsObjAddChild(int i10, int i11);

    public static final native int Mtc_ImMsObjAddData(int i10, int i11, byte[] bArr);

    public static final native int Mtc_ImMsObjAddInt(int i10, int i11, long j10);

    public static final native int Mtc_ImMsObjAddStr(int i10, int i11, String str);

    public static final native int Mtc_ImMsObjCreate(int i10);

    public static final native int Mtc_ImMsObjDelete(int i10);

    public static final native int Mtc_ImMsObjEnumChild(int i10, int i11);

    public static final native int Mtc_ImMsObjGetChildCount(int i10);

    public static final native int Mtc_ImMsObjGetData(int i10, int i11, MtcByteArray mtcByteArray);

    public static final native long Mtc_ImMsObjGetInt(int i10, int i11);

    public static final native String Mtc_ImMsObjGetStr(int i10, int i11);

    public static final native int Mtc_ImMsObjGetType(int i10);

    public static final native int Mtc_ImMsRestoreBegin(int i10, String str);

    public static final native int Mtc_ImMsRestoreEnd(int i10);

    public static final native int Mtc_ImMsSetCookie(int i10, Object obj);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

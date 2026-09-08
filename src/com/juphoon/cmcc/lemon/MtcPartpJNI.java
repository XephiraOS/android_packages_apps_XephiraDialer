package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcPartpJNI {
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

    public static final native int Mtc_PartpGetAccNetType(int i10);

    public static final native int Mtc_PartpGetCmccConfStat(int i10);

    public static final native short Mtc_PartpGetCompsStat(int i10);

    public static final native int Mtc_PartpGetEtype(int i10);

    public static final native int Mtc_PartpGetLogId(int i10);

    public static final native String Mtc_PartpGetName(int i10);

    public static final native int Mtc_PartpGetReason(int i10);

    public static final native int Mtc_PartpGetRoles(int i10);

    public static final native boolean Mtc_PartpGetSelected(int i10);

    public static final native int Mtc_PartpGetSessId(int i10);

    public static final native int Mtc_PartpGetStat(int i10);

    public static final native String Mtc_PartpGetUri(int i10);

    public static final native int Mtc_PartpGetUserLevel(int i10);

    public static final native int Mtc_PartpGetVideoStrmId(int i10);

    public static final native int Mtc_PartpGetVideoStrmState(int i10);

    public static final native int Mtc_PartpLstAddPartp(int i10, String str, String str2);

    public static final native int Mtc_PartpLstClone(int i10);

    public static final native int Mtc_PartpLstCreate(int i10);

    public static final native void Mtc_PartpLstDelete(int i10);

    public static final native int Mtc_PartpLstFindPartp(int i10, String str);

    public static final native int Mtc_PartpLstGetPartp(int i10, int i11, MtcString mtcString, MtcString mtcString2, MtcNumber mtcNumber);

    public static final native int Mtc_PartpLstGetSize(int i10);

    public static final native int Mtc_PartpLstGetType(int i10);

    public static final native int Mtc_PartpLstRmvPartp(int i10, int i11);

    public static final native int Mtc_PartpLstSetType(int i10, int i11);

    public static final native int Mtc_PartpSetLogId(int i10, int i11);

    public static final native int Mtc_PartpSetSessId(int i10, int i11);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcImConfJNI {
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

    public static final native boolean Mtc_ImConfGetActive(int i10);

    public static final native String Mtc_ImConfGetDepartmentId(int i10);

    public static final native String Mtc_ImConfGetDispName(int i10);

    public static final native String Mtc_ImConfGetEnterpriseId(int i10);

    public static final native int Mtc_ImConfGetGroupType(int i10);

    public static final native String Mtc_ImConfGetGrpSessId(int i10);

    public static final native int Mtc_ImConfGetGrpStatus(int i10);

    public static final native boolean Mtc_ImConfGetIsChange(int i10);

    public static final native boolean Mtc_ImConfGetLocked(int i10);

    public static final native int Mtc_ImConfGetMaxUsrCnt(int i10);

    public static final native int Mtc_ImConfGetOfflineSm(int i10);

    public static final native int Mtc_ImConfGetPartpLstId(int i10);

    public static final native String Mtc_ImConfGetSubject(int i10);

    public static final native int Mtc_ImConfGetUsrCnt(int i10);

    public static final native int Mtc_ImConfGetVersion(int i10);

    public static final native int Mtc_ImConfGrpLstAdd(int i10, String str, int i11);

    public static final native int Mtc_ImConfGrpLstCreate();

    public static final native int Mtc_ImConfHttpGetConfId(int i10, int i11);

    public static final native int Mtc_ImConfHttpGetInfoLstSize(int i10);

    public static final native int Mtc_ImConfHttpSubsInfoLst(int i10, boolean z10, String str);

    public static final native String Mtc_ImConfMGetConfConvId(int i10);

    public static final native int Mtc_ImConfMGetConfGrpId(int i10);

    public static final native String Mtc_ImConfMGetConfGrpSessId(int i10);

    public static final native int Mtc_ImConfMGetConfGrpSize();

    public static final native int Mtc_ImConfMGetConfGrpType(int i10);

    public static final native int Mtc_ImConfMGetConfGrpVer(int i10);

    public static final native String Mtc_ImConfMGetConfName(int i10);

    public static final native int Mtc_ImConfMSubsConf(String str);

    public static final native int Mtc_ImConfMSubsConfLst(int i10);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

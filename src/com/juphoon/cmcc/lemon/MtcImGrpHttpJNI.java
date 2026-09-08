package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcImGrpHttpJNI {
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

    public static final native int Mtc_ImGrpHttpAddPartp(Object obj, String str, String str2, String str3, int i10, String str4);

    public static final native int Mtc_ImGrpHttpCancel(Object obj, int i10);

    public static final native int Mtc_ImGrpHttpEplPartp(Object obj, String str, String str2, String str3, String str4, String str5);

    public static final native String Mtc_ImGrpHttpGetBulletin(int i10);

    public static final native int Mtc_ImGrpHttpGetCommand(int i10);

    public static final native String Mtc_ImGrpHttpGetCommandId(int i10);

    public static final native String Mtc_ImGrpHttpGetConvId(int i10);

    public static final native Object Mtc_ImGrpHttpGetCookie(int i10);

    public static final native String Mtc_ImGrpHttpGetCreatorUri(int i10);

    public static final native String Mtc_ImGrpHttpGetDispname(int i10);

    public static final native int Mtc_ImGrpHttpGetGrpType(int i10);

    public static final native String Mtc_ImGrpHttpGetGrpUri(int i10);

    public static final native int Mtc_ImGrpHttpGetGrpVersion(int i10);

    public static final native String Mtc_ImGrpHttpGetIdentifier(int i10);

    public static final native double Mtc_ImGrpHttpGetLatitude(int i10);

    public static final native double Mtc_ImGrpHttpGetLongitude(int i10);

    public static final native int Mtc_ImGrpHttpGetMaxUsrCnt(int i10);

    public static final native boolean Mtc_ImGrpHttpGetNeedPermit(int i10);

    public static final native int Mtc_ImGrpHttpGetPartpLstId(int i10);

    public static final native String Mtc_ImGrpHttpGetSubject(int i10);

    public static final native int Mtc_ImGrpHttpGetTimestamp(int i10);

    public static final native int Mtc_ImGrpHttpGetValidTime(int i10);

    public static final native int Mtc_ImGrpHttpGetValidType(int i10);

    public static final native int Mtc_ImGrpHttpGrpCreate(Object obj, String str, String str2, String str3, String str4, int i10, String str5);

    public static final native int Mtc_ImGrpHttpGrpDelete(Object obj, String str, String str2, String str3, String str4);

    public static final native int Mtc_ImGrpHttpJoinGrp(Object obj, String str, String str2, double d10, double d11, int i10, String str3);

    public static final native int Mtc_ImGrpHttpJoinIconWall(Object obj, String str, String str2, double d10, double d11, int i10);

    public static final native String Mtc_ImGrpHttpLstGetGrpConvId(int i10);

    public static final native int Mtc_ImGrpHttpLstGetGrpId(int i10, int i11);

    public static final native int Mtc_ImGrpHttpLstGetGrpLstVer(int i10);

    public static final native int Mtc_ImGrpHttpLstGetGrpSize(int i10);

    public static final native String Mtc_ImGrpHttpLstGetGrpSubject(int i10);

    public static final native int Mtc_ImGrpHttpLstGetGrpType(int i10);

    public static final native String Mtc_ImGrpHttpLstGetGrpUri(int i10);

    public static final native int Mtc_ImGrpHttpMdfyChairMan(Object obj, String str, String str2, String str3, String str4, String str5);

    public static final native int Mtc_ImGrpHttpMdfyDispName(Object obj, String str, String str2, String str3, String str4, String str5);

    public static final native int Mtc_ImGrpHttpMdfySubject(Object obj, String str, String str2, String str3, String str4, String str5);

    public static final native int Mtc_ImGrpHttpQuitIconWall(Object obj, String str, String str2, double d10, double d11, int i10, String str3);

    public static final native int Mtc_ImGrpHttpSubsGrpInfo(Object obj, String str, String str2, String str3, int i10, String str4);

    public static final native int Mtc_ImGrpHttpSubsGrpLst(Object obj, String str, String str2, int i10, int i11, String str3);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

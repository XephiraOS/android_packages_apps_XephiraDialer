package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcGsGinfoJNI {
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

    public static final native int Mtc_CreatGsGInfoPushTextFile(Object obj, String str, String str2, String str3);

    public static final native int Mtc_CreateGsGInfoPushBothFile(Object obj, String str, double d10, double d11, float f10, String str2, String str3);

    public static final native int Mtc_CreateGsGInfoPushCoordFile(Object obj, double d10, double d11, float f10, String str, String str2);

    public static final native int Mtc_GInfoFetchViaMsrp(Object obj, String str, String str2);

    public static final native int Mtc_GInfoFetchViaMsrpX(Object obj, String str, String str2, String str3);

    public static final native int Mtc_GsGInfoCancel(int i10);

    public static final native String Mtc_GsGInfoGetContId(int i10);

    public static final native String Mtc_GsGInfoGetConvId(int i10);

    public static final native Object Mtc_GsGInfoGetCookie(int i10);

    public static final native long Mtc_GsGInfoGetDateTime(int i10);

    public static final native String Mtc_GsGInfoGetDeviceId(int i10);

    public static final native String Mtc_GsGInfoGetFreeText(int i10);

    public static final native String Mtc_GsGInfoGetGrpChatId(int i10);

    public static final native String Mtc_GsGInfoGetImdnMsgId(int i10);

    public static final native int Mtc_GsGInfoGetImdnType(int i10);

    public static final native boolean Mtc_GsGInfoGetIsFocus(int i10);

    public static final native String Mtc_GsGInfoGetLabel(int i10);

    public static final native double Mtc_GsGInfoGetLatitude(int i10);

    public static final native double Mtc_GsGInfoGetLongitude(int i10);

    public static final native int Mtc_GsGInfoGetOrigPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_GsGInfoGetOwnerPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_GsGInfoGetPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_GsGInfoGetPartpLstId(int i10);

    public static final native int Mtc_GsGInfoGetPartpType(int i10);

    public static final native float Mtc_GsGInfoGetRadius(int i10);

    public static final native String Mtc_GsGInfoGetSubject(int i10);

    public static final native int Mtc_GsGInfoGetTimestamp(int i10);

    public static final native String Mtc_GsGInfoGetTrsfId(int i10);

    public static final native int Mtc_GsGInfoGetType(int i10);

    public static final native int Mtc_GsGInfoGetUntilTime(int i10);

    public static final native boolean Mtc_GsGInfoHasCcInd(int i10);

    public static final native boolean Mtc_GsGInfoHasDirectInd(int i10);

    public static final native boolean Mtc_GsGInfoHasLabel(int i10);

    public static final native boolean Mtc_GsGInfoHasOffInd(int i10);

    public static final native boolean Mtc_GsGInfoHasPubInd(int i10);

    public static final native boolean Mtc_GsGInfoHasSilenceInd(int i10);

    public static final native boolean Mtc_GsGInfoHasSpamInd(int i10);

    public static final native int Mtc_GsGInfoLoadData(Object obj, String str, String str2);

    public static final native int Mtc_GsGInfoPullAcpt(int i10, int i11, String str, double d10, double d11, float f10, String str2);

    public static final native int Mtc_GsGInfoPullDeny(int i10);

    public static final native int Mtc_GsGInfoPullViaFt(Object obj, String str);

    public static final native int Mtc_GsGInfoPushAcpt(int i10);

    public static final native int Mtc_GsGInfoPushBoth(Object obj, String str, double d10, double d11, float f10, String str2, String str3);

    public static final native int Mtc_GsGInfoPushBothP(Object obj, String str, double d10, double d11, float f10, String str2, String str3);

    public static final native int Mtc_GsGInfoPushBothS(Object obj, String str, double d10, double d11, float f10, String str2, String str3, String str4, long j10);

    public static final native int Mtc_GsGInfoPushBothST(Object obj, String str, double d10, double d11, float f10, String str2, String str3, String str4, long j10, int i10);

    public static final native int Mtc_GsGInfoPushBothU(Object obj, String str, double d10, double d11, float f10, int i10, String str2);

    public static final native int Mtc_GsGInfoPushBothX(Object obj, String str, double d10, double d11, float f10, String str2, String str3, String str4, String str5);

    public static final native int Mtc_GsGInfoPushCoord(Object obj, double d10, double d11, float f10, String str, String str2);

    public static final native int Mtc_GsGInfoPushCoordP(Object obj, double d10, double d11, float f10, String str, String str2);

    public static final native int Mtc_GsGInfoPushCoordS(Object obj, double d10, double d11, float f10, String str, String str2, String str3, long j10);

    public static final native int Mtc_GsGInfoPushCoordST(Object obj, double d10, double d11, float f10, String str, String str2, String str3, long j10, int i10);

    public static final native int Mtc_GsGInfoPushCoordU(Object obj, double d10, double d11, float f10, int i10, String str);

    public static final native int Mtc_GsGInfoPushCoordX(Object obj, double d10, double d11, float f10, String str, String str2, String str3, String str4);

    public static final native int Mtc_GsGInfoPushDeny(int i10);

    public static final native int Mtc_GsGInfoPushText(Object obj, String str, String str2, String str3);

    public static final native int Mtc_GsGInfoPushTextP(Object obj, String str, String str2, String str3);

    public static final native int Mtc_GsGInfoPushTextS(Object obj, String str, String str2, String str3, String str4, long j10);

    public static final native int Mtc_GsGInfoPushTextST(Object obj, String str, String str2, String str3, String str4, long j10, int i10);

    public static final native int Mtc_GsGInfoPushTextU(Object obj, String str, int i10, String str2);

    public static final native int Mtc_GsGInfoPushTextX(Object obj, String str, String str2, String str3, String str4, String str5);

    public static final native int Mtc_GsGInfoRePushBoth(Object obj, String str, double d10, double d11, float f10, String str2, String str3, String str4, String str5);

    public static final native int Mtc_GsGInfoRePushBothP(Object obj, String str, double d10, double d11, float f10, String str2, String str3, String str4, String str5);

    public static final native int Mtc_GsGInfoRePushBothS(Object obj, String str, double d10, double d11, float f10, String str2, String str3, String str4, String str5, String str6, long j10);

    public static final native int Mtc_GsGInfoRePushBothST(Object obj, String str, double d10, double d11, float f10, String str2, String str3, String str4, String str5, String str6, long j10, int i10);

    public static final native int Mtc_GsGInfoRePushBothU(Object obj, String str, double d10, double d11, float f10, int i10, String str2, String str3, String str4);

    public static final native int Mtc_GsGInfoRePushBothX(Object obj, String str, double d10, double d11, float f10, String str2, String str3, String str4, String str5, String str6, String str7);

    public static final native int Mtc_GsGInfoRePushCoord(Object obj, double d10, double d11, float f10, String str, String str2, String str3, String str4);

    public static final native int Mtc_GsGInfoRePushCoordP(Object obj, double d10, double d11, float f10, String str, String str2, String str3, String str4);

    public static final native int Mtc_GsGInfoRePushCoordS(Object obj, double d10, double d11, float f10, String str, String str2, String str3, String str4, String str5, long j10);

    public static final native int Mtc_GsGInfoRePushCoordST(Object obj, double d10, double d11, float f10, String str, String str2, String str3, String str4, String str5, long j10, int i10);

    public static final native int Mtc_GsGInfoRePushCoordU(Object obj, double d10, double d11, float f10, int i10, String str, String str2, String str3);

    public static final native int Mtc_GsGInfoRePushCoordX(Object obj, double d10, double d11, float f10, String str, String str2, String str3, String str4, String str5, String str6);

    public static final native int Mtc_GsGInfoRePushText(Object obj, String str, String str2, String str3, String str4, String str5);

    public static final native int Mtc_GsGInfoRePushTextP(Object obj, String str, String str2, String str3, String str4, String str5);

    public static final native int Mtc_GsGInfoRePushTextS(Object obj, String str, String str2, String str3, String str4, String str5, String str6, long j10);

    public static final native int Mtc_GsGInfoRePushTextST(Object obj, String str, String str2, String str3, String str4, String str5, String str6, long j10, int i10);

    public static final native int Mtc_GsGInfoRePushTextU(Object obj, String str, int i10, String str2, String str3, String str4);

    public static final native int Mtc_GsGInfoRePushTextX(Object obj, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    public static final native void Mtc_GsGInfoRelease(int i10);

    public static final native String Mtc_GsGInfoSaveData(Object obj, int i10, String str, double d10, double d11, float f10, String str2, String str3);

    public static final native int Mtc_GsGInfoSetCookie(int i10, Object obj);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

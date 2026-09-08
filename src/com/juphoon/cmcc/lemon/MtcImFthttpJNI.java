package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcImFthttpJNI {
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

    public static final native String Mtc_FtHttpGsGInfoGetFreeText(int i10);

    public static final native String Mtc_FtHttpGsGInfoGetLabel(int i10);

    public static final native double Mtc_FtHttpGsGInfoGetLatitude(int i10);

    public static final native double Mtc_FtHttpGsGInfoGetLongitude(int i10);

    public static final native float Mtc_FtHttpGsGInfoGetRadius(int i10);

    public static final native int Mtc_FtHttpGsGInfoGetTimestamp(int i10);

    public static final native int Mtc_FtHttpGsGInfoGetType(int i10);

    public static final native int Mtc_FtHttpGsGInfoGetUntilTime(int i10);

    public static final native boolean Mtc_FtHttpGsGInfoHasLabel(int i10);

    public static final native void Mtc_FtHttpGsGInfoRelease(int i10);

    public static final native boolean Mtc_ImFtHttpAllowResume(int i10);

    public static final native int Mtc_ImFtHttpCancel(int i10);

    public static final native int Mtc_ImFtHttpDownload(Object obj, String str, String str2, String str3, String str4, int i10, String str5, boolean z10);

    public static final native Object Mtc_ImFtHttpGetCookie(int i10);

    public static final native int Mtc_ImFtHttpGetDuration(int i10);

    public static final native String Mtc_ImFtHttpGetFileInfoXml(int i10);

    public static final native int Mtc_ImFtHttpGetGInfoId(int i10);

    public static final native String Mtc_ImFtHttpGetHashValue(int i10);

    public static final native String Mtc_ImFtHttpGetMsgData(int i10);

    public static final native String Mtc_ImFtHttpGetName(int i10);

    public static final native String Mtc_ImFtHttpGetPath(int i10);

    public static final native int Mtc_ImFtHttpGetRecvSize(int i10);

    public static final native int Mtc_ImFtHttpGetSentSize(int i10);

    public static final native int Mtc_ImFtHttpGetSize(int i10);

    public static final native int Mtc_ImFtHttpGetStartOffset(int i10);

    public static final native int Mtc_ImFtHttpGetStopOffset(int i10);

    public static final native int Mtc_ImFtHttpGetThumbSize(int i10);

    public static final native String Mtc_ImFtHttpGetThumbType(int i10);

    public static final native String Mtc_ImFtHttpGetThumbUrl(int i10);

    public static final native int Mtc_ImFtHttpGetThumbValidity(int i10);

    public static final native String Mtc_ImFtHttpGetTransId(int i10);

    public static final native int Mtc_ImFtHttpGetTransState(String str);

    public static final native String Mtc_ImFtHttpGetType(int i10);

    public static final native String Mtc_ImFtHttpGetUrl(int i10);

    public static final native boolean Mtc_ImFtHttpHasThumb(int i10);

    public static final native boolean Mtc_ImFtHttpIsThumb(int i10);

    public static final native int Mtc_ImFtHttpRefresh(Object obj, String str, String str2, String str3, String str4, int i10, String str5, byte[] bArr);

    public static final native int Mtc_ImFtHttpResumeDown(Object obj, String str, String str2, String str3, String str4, int i10, int i11, int i12, String str5);

    public static final native int Mtc_ImFtHttpResumeUp(Object obj, String str, String str2, String str3, String str4, int i10);

    public static final native int Mtc_ImFtHttpSetCookie(int i10, Object obj);

    public static final native int Mtc_ImFtHttpUpload(Object obj, String str, String str2, String str3, int i10, byte[] bArr);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

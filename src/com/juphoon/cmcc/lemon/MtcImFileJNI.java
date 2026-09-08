package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcImFileJNI {
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

    public static final native int Mtc_ImFileAccept(int i10, String str);

    public static final native int Mtc_ImFileAcceptResume(int i10, String str, int i11, int i12);

    public static final native int Mtc_ImFileCancel(int i10);

    public static final native int Mtc_ImFileClrThumbData(int i10);

    public static final native int Mtc_ImFileFetchViaMsrp(Object obj, String str, String str2, String str3, String str4);

    public static final native int Mtc_ImFileFetchViaMsrpX(Object obj, String str, String str2, String str3, String str4, String str5, String str6);

    public static final native int Mtc_ImFileFw(Object obj, String str, String str2, String str3, int i10, String str4, int i11);

    public static final native int Mtc_ImFileFwCThumb(Object obj, String str, String str2, String str3, int i10, String str4, int i11, byte[] bArr);

    public static final native int Mtc_ImFileFwCThumbP(Object obj, String str, String str2, String str3, int i10, String str4, int i11, byte[] bArr);

    public static final native int Mtc_ImFileFwCThumbU(Object obj, int i10, String str, String str2, int i11, String str3, int i12, byte[] bArr);

    public static final native int Mtc_ImFileFwCThumbX(Object obj, String str, String str2, String str3, String str4, String str5, int i10, String str6, int i11, byte[] bArr);

    public static final native int Mtc_ImFileFwP(Object obj, String str, String str2, String str3, int i10, String str4, int i11);

    public static final native int Mtc_ImFileFwU(Object obj, int i10, String str, String str2, int i11, String str3, int i12);

    public static final native int Mtc_ImFileFwX(Object obj, String str, String str2, String str3, String str4, String str5, int i10, String str6, int i11);

    public static final native int Mtc_ImFileGetBurnTimeLen(int i10);

    public static final native String Mtc_ImFileGetContId(int i10);

    public static final native String Mtc_ImFileGetConvId(int i10);

    public static final native Object Mtc_ImFileGetCookie(int i10);

    public static final native long Mtc_ImFileGetDateTime(int i10);

    public static final native String Mtc_ImFileGetDeviceId(int i10);

    public static final native int Mtc_ImFileGetDuration(int i10);

    public static final native String Mtc_ImFileGetGrpChatId(int i10);

    public static final native String Mtc_ImFileGetHashValue(int i10);

    public static final native String Mtc_ImFileGetImdnMsgId(int i10);

    public static final native int Mtc_ImFileGetImdnType(int i10);

    public static final native boolean Mtc_ImFileGetIsFocus(int i10);

    public static final native String Mtc_ImFileGetName(int i10);

    public static final native int Mtc_ImFileGetOrigIdPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImFileGetOrigPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImFileGetPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImFileGetPartpLstId(int i10);

    public static final native int Mtc_ImFileGetPartpType(int i10);

    public static final native String Mtc_ImFileGetPath(int i10);

    public static final native int Mtc_ImFileGetRecvSize(int i10);

    public static final native int Mtc_ImFileGetSentSize(int i10);

    public static final native int Mtc_ImFileGetSize(int i10);

    public static final native int Mtc_ImFileGetStartOffset(int i10);

    public static final native int Mtc_ImFileGetStopOffset(int i10);

    public static final native String Mtc_ImFileGetSubject(int i10);

    public static final native int Mtc_ImFileGetSysDateTime(int i10, long j10);

    public static final native int Mtc_ImFileGetThumbData(int i10, MtcByteArray mtcByteArray);

    public static final native int Mtc_ImFileGetTransState(String str);

    public static final native int Mtc_ImFileGetTrsfDirect(int i10);

    public static final native String Mtc_ImFileGetTrsfId(int i10);

    public static final native String Mtc_ImFileGetType(int i10);

    public static final native boolean Mtc_ImFileHasBurnInd(int i10);

    public static final native boolean Mtc_ImFileHasCcInd(int i10);

    public static final native boolean Mtc_ImFileHasDirectInd(int i10);

    public static final native boolean Mtc_ImFileHasOffInd(int i10);

    public static final native boolean Mtc_ImFileHasPubInd(int i10);

    public static final native boolean Mtc_ImFileHasSilenceInd(int i10);

    public static final native boolean Mtc_ImFileHasSpamInd(int i10);

    public static final native boolean Mtc_ImFileHasThumb(int i10);

    public static final native int Mtc_ImFileReject(int i10, int i11);

    public static final native int Mtc_ImFileRelease(int i10);

    public static final native int Mtc_ImFileResumeByRecver(Object obj, String str, String str2, String str3, String str4, String str5, int i10, int i11);

    public static final native int Mtc_ImFileResumeByRecverB(Object obj, String str, String str2, String str3, String str4, String str5, int i10, int i11);

    public static final native int Mtc_ImFileResumeByRecverX(Object obj, String str, String str2, String str3, String str4, String str5, String str6, int i10, int i11);

    public static final native int Mtc_ImFileResumeBySender(Object obj, String str, String str2, String str3, String str4, String str5, String str6, int i10, int i11, int i12, byte[] bArr);

    public static final native int Mtc_ImFileResumeBySenderB(Object obj, String str, String str2, String str3, String str4, String str5, String str6, int i10, int i11, int i12);

    public static final native int Mtc_ImFileResumeBySenderP(Object obj, String str, String str2, String str3, String str4, String str5, String str6, int i10, int i11, int i12, byte[] bArr);

    public static final native int Mtc_ImFileResumeBySenderS(Object obj, String str, String str2, String str3, String str4, String str5, int i10, int i11, int i12, String str6, String str7, long j10);

    public static final native int Mtc_ImFileResumeBySenderST(Object obj, String str, String str2, String str3, String str4, String str5, int i10, int i11, int i12, String str6, String str7, long j10, int i13);

    public static final native int Mtc_ImFileResumeBySenderU(Object obj, String str, int i10, String str2, String str3, String str4, String str5, int i11, int i12, int i13, byte[] bArr);

    public static final native int Mtc_ImFileResumeBySenderX(Object obj, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, int i11, int i12, byte[] bArr);

    public static final native int Mtc_ImFileSetCookie(int i10, Object obj);

    public static final native int Mtc_ImFileTrsf(Object obj, String str, String str2, String str3, String str4, int i10);

    public static final native int Mtc_ImFileTrsfB(Object obj, String str, String str2, String str3, String str4, int i10);

    public static final native int Mtc_ImFileTrsfCThumb(Object obj, String str, String str2, String str3, int i10, byte[] bArr);

    public static final native int Mtc_ImFileTrsfCThumbP(Object obj, String str, String str2, String str3, int i10, byte[] bArr);

    public static final native int Mtc_ImFileTrsfCThumbU(Object obj, int i10, String str, String str2, int i11, byte[] bArr);

    public static final native int Mtc_ImFileTrsfCThumbX(Object obj, String str, String str2, String str3, String str4, String str5, int i10, byte[] bArr);

    public static final native int Mtc_ImFileTrsfP(Object obj, String str, String str2, String str3, String str4, int i10);

    public static final native int Mtc_ImFileTrsfS(Object obj, String str, String str2, String str3, int i10, String str4, String str5, long j10);

    public static final native int Mtc_ImFileTrsfST(Object obj, String str, String str2, String str3, int i10, String str4, String str5, long j10, int i11);

    public static final native int Mtc_ImFileTrsfU(Object obj, int i10, String str, String str2, int i11);

    public static final native int Mtc_ImFileTrsfX(Object obj, String str, String str2, String str3, String str4, String str5, int i10);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

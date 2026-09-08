package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcImLargeJNI {
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

    public static final native int Mtc_ImLMsgGetAppPushType(int i10);

    public static final native int Mtc_ImLMsgGetBurnTimeLen(int i10);

    public static final native String Mtc_ImLMsgGetContId(int i10);

    public static final native String Mtc_ImLMsgGetContent(int i10);

    public static final native int Mtc_ImLMsgGetContentType(int i10);

    public static final native String Mtc_ImLMsgGetConvId(int i10);

    public static final native Object Mtc_ImLMsgGetCookie(int i10);

    public static final native long Mtc_ImLMsgGetDateTime(int i10);

    public static final native String Mtc_ImLMsgGetDeviceId(int i10);

    public static final native String Mtc_ImLMsgGetFontInfo(int i10);

    public static final native String Mtc_ImLMsgGetImdnMsgId(int i10);

    public static final native int Mtc_ImLMsgGetImdnType(int i10);

    public static final native String Mtc_ImLMsgGetIrtContId(int i10);

    public static final native int Mtc_ImLMsgGetMContent(int i10, MtcByteArray mtcByteArray);

    public static final native int Mtc_ImLMsgGetOrigIdPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImLMsgGetOrigPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImLMsgGetPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImLMsgGetPartpLst(int i10);

    public static final native int Mtc_ImLMsgGetPartpType(int i10);

    public static final native String Mtc_ImLMsgGetRevokeFromAddr(int i10);

    public static final native String Mtc_ImLMsgGetRevokeMsgId(int i10);

    public static final native short Mtc_ImLMsgGetRevokeResult(int i10);

    public static final native String Mtc_ImLMsgGetRevokeToAddr(int i10);

    public static final native int Mtc_ImLMsgGetSysDateTime(int i10, long j10);

    public static final native boolean Mtc_ImLMsgHasBurnInd(int i10);

    public static final native boolean Mtc_ImLMsgHasCcInd(int i10);

    public static final native boolean Mtc_ImLMsgHasDirectInd(int i10);

    public static final native boolean Mtc_ImLMsgHasOffInd(int i10);

    public static final native boolean Mtc_ImLMsgHasPubInd(int i10);

    public static final native boolean Mtc_ImLMsgHasRevokeMsgInd(int i10);

    public static final native boolean Mtc_ImLMsgHasSilenceInd(int i10);

    public static final native boolean Mtc_ImLMsgHasSpamInd(int i10);

    public static final native int Mtc_ImLMsgReSend(Object obj, String str, String str2, int i10, String str3);

    public static final native int Mtc_ImLMsgReSendB(Object obj, String str, String str2, int i10, String str3);

    public static final native int Mtc_ImLMsgReSendF(Object obj, String str, int i10, String str2, int i11, String str3, boolean z10, String str4);

    public static final native int Mtc_ImLMsgReSendFB(Object obj, String str, String str2, String str3);

    public static final native int Mtc_ImLMsgReSendM(Object obj, String str, byte[] bArr, int i10, String str2);

    public static final native int Mtc_ImLMsgReSendP(Object obj, String str, String str2, int i10, String str3);

    public static final native int Mtc_ImLMsgReSendS(Object obj, String str, int i10, String str2, String str3, long j10, String str4);

    public static final native int Mtc_ImLMsgReSendST(Object obj, String str, int i10, String str2, String str3, long j10, String str4, int i11);

    public static final native int Mtc_ImLMsgReSendU(Object obj, int i10, String str, int i11, String str2);

    public static final native int Mtc_ImLMsgReply(Object obj, String str, String str2, int i10, String str3, String str4);

    public static final native int Mtc_ImLMsgSend(Object obj, String str, String str2, int i10);

    public static final native int Mtc_ImLMsgSendB(Object obj, String str, String str2, int i10);

    public static final native int Mtc_ImLMsgSendF(Object obj, String str, int i10, String str2, int i11, String str3, boolean z10);

    public static final native int Mtc_ImLMsgSendFB(Object obj, String str, String str2);

    public static final native int Mtc_ImLMsgSendM(Object obj, String str, byte[] bArr, int i10);

    public static final native int Mtc_ImLMsgSendP(Object obj, String str, String str2, int i10);

    public static final native int Mtc_ImLMsgSendS(Object obj, String str, int i10, String str2, String str3, long j10);

    public static final native int Mtc_ImLMsgSendST(Object obj, String str, int i10, String str2, String str3, long j10, int i11);

    public static final native int Mtc_ImLMsgSendU(Object obj, int i10, String str, int i11);

    public static final native int Mtc_ImLMsgSetCookie(int i10, Object obj);

    public static final native int Mtc_ImLMsgUniReSend(Object obj, String str, int i10, String str2, int i11, String str3, String str4);

    public static final native int Mtc_ImLMsgUniSend(Object obj, String str, int i10, String str2, int i11, String str3);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

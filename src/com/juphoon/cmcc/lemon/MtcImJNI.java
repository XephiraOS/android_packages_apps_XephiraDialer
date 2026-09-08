package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcImJNI {
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

    public static final native String Mtc_ImPMsGetMutiContent(int i10, int i11);

    public static final native String Mtc_ImPMsgCreateRevokeXml(String str, String str2, String str3, String str4);

    public static final native int Mtc_ImPMsgGetAppPushType(int i10);

    public static final native int Mtc_ImPMsgGetBotMsgContentType(int i10);

    public static final native int Mtc_ImPMsgGetBurnTimeLen(int i10);

    public static final native String Mtc_ImPMsgGetChatBotVer(int i10);

    public static final native String Mtc_ImPMsgGetContId(int i10);

    public static final native String Mtc_ImPMsgGetContent(int i10);

    public static final native int Mtc_ImPMsgGetContentLen(int i10);

    public static final native int Mtc_ImPMsgGetContentType(int i10);

    public static final native String Mtc_ImPMsgGetConvId(int i10);

    public static final native Object Mtc_ImPMsgGetCookie(int i10);

    public static final native int Mtc_ImPMsgGetCpimPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native long Mtc_ImPMsgGetDateTime(int i10);

    public static final native String Mtc_ImPMsgGetDeviceId(int i10);

    public static final native String Mtc_ImPMsgGetFontInfo(int i10);

    public static final native int Mtc_ImPMsgGetFtHttpId(int i10);

    public static final native String Mtc_ImPMsgGetImdnMsgId(int i10);

    public static final native int Mtc_ImPMsgGetImdnType(int i10);

    public static final native String Mtc_ImPMsgGetIrtContId(int i10);

    public static final native boolean Mtc_ImPMsgGetIsChatBot(int i10);

    public static final native int Mtc_ImPMsgGetMContent(int i10, MtcByteArray mtcByteArray);

    public static final native int Mtc_ImPMsgGetPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImPMsgGetPartpLstId(int i10);

    public static final native int Mtc_ImPMsgGetPartpType(int i10);

    public static final native String Mtc_ImPMsgGetQrcodeGrpName(int i10);

    public static final native String Mtc_ImPMsgGetQrcodeGrpProposer(int i10);

    public static final native String Mtc_ImPMsgGetQrcodeGrpUri(int i10);

    public static final native int Mtc_ImPMsgGetQrcodeOptionType(int i10);

    public static final native String Mtc_ImPMsgGetQrcodeReason(int i10);

    public static final native String Mtc_ImPMsgGetRevokeFromAddr(int i10);

    public static final native String Mtc_ImPMsgGetRevokeMsgId(int i10);

    public static final native short Mtc_ImPMsgGetRevokeResult(int i10);

    public static final native String Mtc_ImPMsgGetRevokeToAddr(int i10);

    public static final native int Mtc_ImPMsgGetStatCode(int i10);

    public static final native int Mtc_ImPMsgGetSysDateTime(int i10, long j10);

    public static final native boolean Mtc_ImPMsgHasBurnInd(int i10);

    public static final native boolean Mtc_ImPMsgHasCallComposerInd(int i10);

    public static final native boolean Mtc_ImPMsgHasCcInd(int i10);

    public static final native boolean Mtc_ImPMsgHasDirectInd(int i10);

    public static final native boolean Mtc_ImPMsgHasGrpMInd(int i10);

    public static final native boolean Mtc_ImPMsgHasOffInd(int i10);

    public static final native boolean Mtc_ImPMsgHasOmaIm(int i10);

    public static final native boolean Mtc_ImPMsgHasOmaImSys(int i10);

    public static final native boolean Mtc_ImPMsgHasPubInd(int i10);

    public static final native boolean Mtc_ImPMsgHasRcsSms(int i10);

    public static final native boolean Mtc_ImPMsgHasRevokeMsgInd(int i10);

    public static final native boolean Mtc_ImPMsgHasSilenceInd(int i10);

    public static final native boolean Mtc_ImPMsgHasSmsInd(int i10);

    public static final native boolean Mtc_ImPMsgHasSpamInd(int i10);

    public static final native int Mtc_ImPMsgReSend(Object obj, String str, String str2, boolean z10, boolean z11, String str3);

    public static final native int Mtc_ImPMsgReSendB(Object obj, String str, String str2, String str3);

    public static final native int Mtc_ImPMsgReSendC(Object obj, String str, String str2, boolean z10, String str3);

    public static final native int Mtc_ImPMsgReSendCU(Object obj, int i10, String str, boolean z10, String str2);

    public static final native int Mtc_ImPMsgReSendChatBot(Object obj, String str, String str2, int i10, String str3);

    public static final native int Mtc_ImPMsgReSendD(Object obj, String str, String str2, String str3);

    public static final native int Mtc_ImPMsgReSendDU(Object obj, int i10, String str, String str2);

    public static final native int Mtc_ImPMsgReSendE(Object obj, String str, String str2, String str3);

    public static final native int Mtc_ImPMsgReSendF(Object obj, String str, int i10, String str2, int i11, String str3, boolean z10, String str4);

    public static final native int Mtc_ImPMsgReSendFB(Object obj, String str, String str2, String str3);

    public static final native int Mtc_ImPMsgReSendG(Object obj, String str, String str2, boolean z10, String str3);

    public static final native int Mtc_ImPMsgReSendM(Object obj, String str, byte[] bArr, int i10, String str2);

    public static final native int Mtc_ImPMsgReSendN(Object obj, String str, String str2, int i10, String str3);

    public static final native int Mtc_ImPMsgReSendP(Object obj, String str, String str2, boolean z10, String str3);

    public static final native int Mtc_ImPMsgReSendR(Object obj, String str, String str2, String str3);

    public static final native int Mtc_ImPMsgReSendS(Object obj, String str, int i10, String str2, String str3, long j10, String str4);

    public static final native int Mtc_ImPMsgReSendST(Object obj, String str, int i10, String str2, String str3, long j10, String str4, int i11);

    public static final native int Mtc_ImPMsgReSendU(Object obj, int i10, String str, boolean z10, boolean z11, String str2);

    public static final native int Mtc_ImPMsgReSendUN(Object obj, int i10, String str, int i11, String str2);

    public static final native int Mtc_ImPMsgReSendV(Object obj, String str, String str2, boolean z10, String str3);

    public static final native int Mtc_ImPMsgReSendVU(Object obj, int i10, String str, boolean z10, String str2);

    public static final native int Mtc_ImPMsgReSendX(Object obj, String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13, String str3);

    public static final native int Mtc_ImPMsgReply(Object obj, String str, String str2, int i10, int i11, String str3, String str4);

    public static final native int Mtc_ImPMsgRevoke(Object obj, String str, String str2, String str3, String str4);

    public static final native int Mtc_ImPMsgSend(Object obj, String str, String str2, boolean z10, boolean z11);

    public static final native int Mtc_ImPMsgSendB(Object obj, String str, String str2);

    public static final native int Mtc_ImPMsgSendBgmMix(Object obj, String str, String str2);

    public static final native int Mtc_ImPMsgSendC(Object obj, String str, String str2, boolean z10);

    public static final native int Mtc_ImPMsgSendCU(Object obj, int i10, String str, boolean z10);

    public static final native int Mtc_ImPMsgSendChatBot(Object obj, String str, String str2, int i10);

    public static final native int Mtc_ImPMsgSendD(Object obj, String str, String str2);

    public static final native int Mtc_ImPMsgSendDU(Object obj, int i10, String str);

    public static final native int Mtc_ImPMsgSendE(Object obj, String str, String str2);

    public static final native int Mtc_ImPMsgSendExvcard(Object obj, String str, String str2);

    public static final native int Mtc_ImPMsgSendF(Object obj, String str, int i10, String str2, int i11, String str3, boolean z10);

    public static final native int Mtc_ImPMsgSendFB(Object obj, String str, String str2);

    public static final native int Mtc_ImPMsgSendG(Object obj, String str, String str2, boolean z10);

    public static final native int Mtc_ImPMsgSendM(Object obj, String str, byte[] bArr, int i10);

    public static final native int Mtc_ImPMsgSendN(Object obj, String str, String str2, int i10);

    public static final native int Mtc_ImPMsgSendP(Object obj, String str, String str2, boolean z10);

    public static final native int Mtc_ImPMsgSendR(Object obj, String str, String str2);

    public static final native int Mtc_ImPMsgSendRS(Object obj, String str, String str2);

    public static final native int Mtc_ImPMsgSendS(Object obj, String str, int i10, String str2, String str3, long j10);

    public static final native int Mtc_ImPMsgSendST(Object obj, String str, int i10, String str2, String str3, long j10, int i11);

    public static final native int Mtc_ImPMsgSendSms(Object obj, String str, String str2);

    public static final native int Mtc_ImPMsgSendU(Object obj, int i10, String str, boolean z10, boolean z11);

    public static final native int Mtc_ImPMsgSendUN(Object obj, int i10, String str, int i11);

    public static final native int Mtc_ImPMsgSendV(Object obj, String str, String str2, boolean z10);

    public static final native int Mtc_ImPMsgSendVU(Object obj, int i10, String str, boolean z10);

    public static final native int Mtc_ImPMsgSendX(Object obj, String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13);

    public static final native int Mtc_ImPMsgSendXvcard(Object obj, String str, String str2, String str3);

    public static final native int Mtc_ImPMsgSetCookie(int i10, Object obj);

    public static final native boolean Mtc_ImPMsgSuptMsgRevoke(int i10);

    public static final native int Mtc_ImPMsgUniReSend(Object obj, String str, int i10, String str2, int i11, String str3, String str4, String str5);

    public static final native int Mtc_ImPMsgUniSend(Object obj, String str, int i10, String str2, int i11, String str3, String str4);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcImCmccJNI {
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

    public static final native int Mtc_ImCmccGetGrpDataId(int i10);

    public static final native short Mtc_ImCmccGetGrpManResult(int i10);

    public static final native int Mtc_ImCmccGrpAccept(int i10, String str);

    public static final native int Mtc_ImCmccGrpAddPartp(String str, String str2, String str3);

    public static final native int Mtc_ImCmccGrpAddPartpU(String str, String str2, int i10);

    public static final native int Mtc_ImCmccGrpCancel(int i10);

    public static final native int Mtc_ImCmccGrpCreat(Object obj, String str, String str2, int i10);

    public static final native int Mtc_ImCmccGrpCreateGrpDataXml(String str, short s10, MtcString mtcString);

    public static final native int Mtc_ImCmccGrpDissolve(int i10);

    public static final native int Mtc_ImCmccGrpEplPartp(String str, String str2, String str3);

    public static final native int Mtc_ImCmccGrpEplPartpU(String str, String str2, int i10);

    public static final native Object Mtc_ImCmccGrpGetCookie(int i10);

    public static final native long Mtc_ImCmccGrpGetDateTime(int i10);

    public static final native String Mtc_ImCmccGrpGetDispName(int i10);

    public static final native boolean Mtc_ImCmccGrpGetEnterPriseGrpInd(int i10);

    public static final native String Mtc_ImCmccGrpGetGrpChatId(int i10);

    public static final native String Mtc_ImCmccGrpGetGrpIdent(int i10);

    public static final native int Mtc_ImCmccGrpGetIvtType(int i10);

    public static final native int Mtc_ImCmccGrpGetOrigIdPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImCmccGrpGetPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImCmccGrpGetPartpLstId(int i10);

    public static final native boolean Mtc_ImCmccGrpGetPartyGrpInd(int i10);

    public static final native String Mtc_ImCmccGrpGetSubject(int i10);

    public static final native int Mtc_ImCmccGrpGetSysDateTime(int i10, long j10);

    public static final native int Mtc_ImCmccGrpGetVersionId(int i10);

    public static final native boolean Mtc_ImCmccGrpInfoGetActive(int i10);

    public static final native int Mtc_ImCmccGrpInfoGetGroupType(int i10);

    public static final native String Mtc_ImCmccGrpInfoGetGrpChatId(int i10);

    public static final native String Mtc_ImCmccGrpInfoGetGrpIdent(int i10);

    public static final native boolean Mtc_ImCmccGrpInfoGetLocked(int i10);

    public static final native int Mtc_ImCmccGrpInfoGetMaxUsrCnt(int i10);

    public static final native int Mtc_ImCmccGrpInfoGetPartpLstId(int i10);

    public static final native String Mtc_ImCmccGrpInfoGetSubject(int i10);

    public static final native int Mtc_ImCmccGrpInfoGetUsrCnt(int i10);

    public static final native int Mtc_ImCmccGrpInfoGetVersion(int i10);

    public static final native int Mtc_ImCmccGrpLeave(int i10);

    public static final native int Mtc_ImCmccGrpMdfyChairMan(String str, String str2, String str3);

    public static final native int Mtc_ImCmccGrpMdfyDispName(String str, String str2, String str3);

    public static final native String Mtc_ImCmccGrpPMsgGetContId(int i10);

    public static final native String Mtc_ImCmccGrpPMsgGetContent(int i10);

    public static final native int Mtc_ImCmccGrpPMsgGetContentType(int i10);

    public static final native String Mtc_ImCmccGrpPMsgGetConvId(int i10);

    public static final native Object Mtc_ImCmccGrpPMsgGetCookie(int i10);

    public static final native long Mtc_ImCmccGrpPMsgGetDateTime(int i10);

    public static final native String Mtc_ImCmccGrpPMsgGetFontInfo(int i10);

    public static final native String Mtc_ImCmccGrpPMsgGetGrpChatId(int i10);

    public static final native String Mtc_ImCmccGrpPMsgGetGrpIdent(int i10);

    public static final native String Mtc_ImCmccGrpPMsgGetImdnMsgId(int i10);

    public static final native int Mtc_ImCmccGrpPMsgGetImdnType(int i10);

    public static final native int Mtc_ImCmccGrpPMsgGetPeerPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native String Mtc_ImCmccGrpPMsgGetRevokeFromAddr(int i10);

    public static final native String Mtc_ImCmccGrpPMsgGetRevokeMsgId(int i10);

    public static final native short Mtc_ImCmccGrpPMsgGetRevokeResult(int i10);

    public static final native String Mtc_ImCmccGrpPMsgGetRevokeToAddr(int i10);

    public static final native boolean Mtc_ImCmccGrpPMsgHasAtInd(int i10);

    public static final native boolean Mtc_ImCmccGrpPMsgHasCcInd(int i10);

    public static final native boolean Mtc_ImCmccGrpPMsgHasGrpDataInd(int i10);

    public static final native boolean Mtc_ImCmccGrpPMsgHasOffInd(int i10);

    public static final native boolean Mtc_ImCmccGrpPMsgHasRevokeMsgInd(int i10);

    public static final native boolean Mtc_ImCmccGrpPMsgHasSilenceInd(int i10);

    public static final native int Mtc_ImCmccGrpPMsgReSend(Object obj, String str, String str2, int i10, String str3, int i11, int i12, String str4, String str5);

    public static final native int Mtc_ImCmccGrpPMsgReSendO(Object obj, String str, String str2, String str3, int i10, String str4, String str5, String str6);

    public static final native int Mtc_ImCmccGrpPMsgSend(Object obj, String str, String str2, int i10, String str3, int i11, int i12, String str4);

    public static final native int Mtc_ImCmccGrpPMsgSendO(Object obj, String str, String str2, String str3, int i10, String str4, String str5);

    public static final native int Mtc_ImCmccGrpPMsgSetCookie(int i10, Object obj);

    public static final native int Mtc_ImCmccGrpReJoin(Object obj, String str, String str2, String str3, String str4, int i10);

    public static final native int Mtc_ImCmccGrpReject(int i10);

    public static final native String Mtc_ImCmccGrpRferGetChairMan(int i10);

    public static final native String Mtc_ImCmccGrpRferGetDispName(int i10);

    public static final native String Mtc_ImCmccGrpRferGetGrpChatId(int i10);

    public static final native String Mtc_ImCmccGrpRferGetGrpIdent(int i10);

    public static final native int Mtc_ImCmccGrpRferGetPartpLstId(int i10);

    public static final native int Mtc_ImCmccGrpSetCookie(int i10, Object obj);

    public static final native int Mtc_ImCmccGrpSetVersionId(int i10, int i11);

    public static final native int Mtc_ImCmccGrpSilence(int i10);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcImSessJNI {
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

    public static final native int Mtc_ImSessAccept(int i10, String str);

    public static final native int Mtc_ImSessAcptMdfyChairMan(int i10);

    public static final native int Mtc_ImSessAddPartp(int i10, String str);

    public static final native int Mtc_ImSessAddPartpU(int i10, int i11);

    public static final native int Mtc_ImSessCancel(int i10);

    public static final native int Mtc_ImSessDissolve(int i10);

    public static final native int Mtc_ImSessEplPartp(int i10, String str);

    public static final native int Mtc_ImSessEplPartpU(int i10, int i11);

    public static final native int Mtc_ImSessEstab(Object obj, String str, String str2);

    public static final native int Mtc_ImSessEstabChatBot(Object obj, String str, String str2);

    public static final native int Mtc_ImSessEstabM(Object obj, String str, String str2, int i10, String str3, MtcNumber mtcNumber);

    public static final native int Mtc_ImSessEstabMM(Object obj, String str, byte[] bArr, int i10, String str2, MtcNumber mtcNumber);

    public static final native int Mtc_ImSessEstabP(Object obj, String str, String str2);

    public static final native int Mtc_ImSessEstabPostCall(Object obj, String str, String str2, String str3, int i10, int i11);

    public static final native int Mtc_ImSessEstabPreCall(Object obj, String str, String str2);

    public static final native int Mtc_ImSessEstabSharedMap(Object obj, String str, String str2);

    public static final native int Mtc_ImSessEstabSharedSketch(Object obj, String str, String str2);

    public static final native int Mtc_ImSessEstabU(Object obj, String str, String str2, int i10);

    public static final native int Mtc_ImSessExtend(Object obj, int i10, int i11);

    public static final native boolean Mtc_ImSessGetActive(int i10);

    public static final native String Mtc_ImSessGetContId(int i10);

    public static final native String Mtc_ImSessGetConvId(int i10);

    public static final native Object Mtc_ImSessGetCookie(int i10);

    public static final native long Mtc_ImSessGetDateTime(int i10);

    public static final native String Mtc_ImSessGetDispName(int i10);

    public static final native boolean Mtc_ImSessGetEnterPriseGrpInd(int i10);

    public static final native boolean Mtc_ImSessGetFtHttpSupport(int i10);

    public static final native int Mtc_ImSessGetGroupType(int i10);

    public static final native String Mtc_ImSessGetGrpChatId(int i10);

    public static final native String Mtc_ImSessGetGrpIdent(int i10);

    public static final native int Mtc_ImSessGetGrpSessType(int i10);

    public static final native String Mtc_ImSessGetGrpUri(int i10);

    public static final native boolean Mtc_ImSessGetImdnSupport(int i10);

    public static final native boolean Mtc_ImSessGetIsChairman(int i10);

    public static final native boolean Mtc_ImSessGetIsFocus(int i10);

    public static final native boolean Mtc_ImSessGetLocked(int i10);

    public static final native int Mtc_ImSessGetMaxUsrCnt(int i10);

    public static final native boolean Mtc_ImSessGetOffline(int i10);

    public static final native boolean Mtc_ImSessGetOfflineIvt(int i10);

    public static final native boolean Mtc_ImSessGetOfflineMsg(int i10);

    public static final native int Mtc_ImSessGetOrigIdPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImSessGetOrigPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native boolean Mtc_ImSessGetOutgoing(int i10);

    public static final native int Mtc_ImSessGetPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImSessGetPartpLstId(int i10);

    public static final native int Mtc_ImSessGetPartpType(int i10);

    public static final native boolean Mtc_ImSessGetPartyGrpInd(int i10);

    public static final native String Mtc_ImSessGetRevokeFromAddr(int i10, int i11);

    public static final native String Mtc_ImSessGetRevokeMsgId(int i10, int i11);

    public static final native short Mtc_ImSessGetRevokeResult(int i10, int i11);

    public static final native String Mtc_ImSessGetRevokeToAddr(int i10, int i11);

    public static final native int Mtc_ImSessGetRplSessId(int i10);

    public static final native int Mtc_ImSessGetSessType(int i10);

    public static final native int Mtc_ImSessGetState(int i10);

    public static final native String Mtc_ImSessGetSubject(int i10);

    public static final native int Mtc_ImSessGetSysDateTime(int i10, long j10);

    public static final native int Mtc_ImSessGetUsrCnt(int i10);

    public static final native int Mtc_ImSessGetVersionId(int i10);

    public static final native boolean Mtc_ImSessHasFirstMsg(int i10);

    public static final native boolean Mtc_ImSessHasRevokeMsgInd(int i10, int i11);

    public static final native int Mtc_ImSessLeave(int i10);

    public static final native int Mtc_ImSessMdfyChairMan(int i10, String str);

    public static final native int Mtc_ImSessMdfyDispName(int i10, String str);

    public static final native int Mtc_ImSessMdfySubject(int i10, String str);

    public static final native int Mtc_ImSessMsgFmtGrpDataIcon(byte[] bArr, MtcByteArray mtcByteArray);

    public static final native String Mtc_ImSessMsgFmtGrpDataSubject(String str);

    public static final native int Mtc_ImSessMsgFmtGrpDataType(int i10, int i11);

    public static final native String Mtc_ImSessMsgFormatCallData(String str, MtcNumber mtcNumber, String str2, String str3, String str4, String str5);

    public static final native int Mtc_ImSessMsgGetBotMsgContentType(int i10, int i11);

    public static final native boolean Mtc_ImSessMsgGetBotSug(int i10, int i11);

    public static final native String Mtc_ImSessMsgGetCallDataComposerId(int i10, int i11);

    public static final native boolean Mtc_ImSessMsgGetCallDataImportance(int i10, int i11);

    public static final native String Mtc_ImSessMsgGetCallDataLocation(int i10, int i11);

    public static final native String Mtc_ImSessMsgGetCallDataNote(int i10, int i11);

    public static final native String Mtc_ImSessMsgGetCallDataPictureUrl(int i10, int i11);

    public static final native String Mtc_ImSessMsgGetCallDataSubject(int i10, int i11);

    public static final native String Mtc_ImSessMsgGetContent(int i10, int i11);

    public static final native int Mtc_ImSessMsgGetContentLen(int i10, int i11);

    public static final native int Mtc_ImSessMsgGetContentType(int i10, int i11);

    public static final native Object Mtc_ImSessMsgGetCookie(int i10, int i11);

    public static final native long Mtc_ImSessMsgGetDateTime(int i10, int i11);

    public static final native String Mtc_ImSessMsgGetDeviceId(int i10, int i11);

    public static final native String Mtc_ImSessMsgGetFontInfo(int i10, int i11);

    public static final native int Mtc_ImSessMsgGetFtHttpId(int i10, int i11);

    public static final native int Mtc_ImSessMsgGetGInfoId(int i10, int i11);

    public static final native int Mtc_ImSessMsgGetGrpDataIcon(int i10, int i11, MtcByteArray mtcByteArray);

    public static final native String Mtc_ImSessMsgGetGrpDataSubject(int i10, int i11);

    public static final native String Mtc_ImSessMsgGetImdnMsgId(int i10, int i11);

    public static final native int Mtc_ImSessMsgGetImdnType(int i10, int i11);

    public static final native int Mtc_ImSessMsgGetMContent(int i10, int i11, MtcByteArray mtcByteArray);

    public static final native String Mtc_ImSessMsgGetMutiContent(int i10, int i11, int i12);

    public static final native int Mtc_ImSessMsgGetPartp(int i10, int i11, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImSessMsgGetSharedDataId(int i10, int i11);

    public static final native int Mtc_ImSessMsgGetSysDateTime(int i10, int i11, long j10);

    public static final native boolean Mtc_ImSessMsgHasAtAllInd(int i10, int i11);

    public static final native boolean Mtc_ImSessMsgHasAtInd(int i10, int i11);

    public static final native boolean Mtc_ImSessMsgHasCcInd(int i10, int i11);

    public static final native boolean Mtc_ImSessMsgHasOffInd(int i10, int i11);

    public static final native boolean Mtc_ImSessMsgHasSilenceInd(int i10, int i11);

    public static final native int Mtc_ImSessMsgReSend(int i10, Object obj, String str, int i11, String str2);

    public static final native int Mtc_ImSessMsgReSendAt(int i10, Object obj, String str, int i11, int i12, int i13, String str2);

    public static final native int Mtc_ImSessMsgReSendF(int i10, Object obj, String str, int i11, String str2, int i12, int i13, String str3);

    public static final native int Mtc_ImSessMsgReSendGeoBoth(int i10, Object obj, String str, double d10, double d11, float f10, String str2, boolean z10, String str3);

    public static final native int Mtc_ImSessMsgReSendGeoCoord(int i10, Object obj, double d10, double d11, float f10, String str, boolean z10, String str2);

    public static final native int Mtc_ImSessMsgReSendGeoText(int i10, Object obj, String str, String str2, boolean z10, String str3);

    public static final native int Mtc_ImSessMsgReSendM(int i10, Object obj, byte[] bArr, int i11, String str);

    public static final native int Mtc_ImSessMsgReSendO(int i10, Object obj, String str, String str2, int i11, String str3);

    public static final native int Mtc_ImSessMsgSend(int i10, Object obj, String str, int i11);

    public static final native int Mtc_ImSessMsgSendAt(int i10, Object obj, String str, int i11, int i12, int i13);

    public static final native int Mtc_ImSessMsgSendF(int i10, Object obj, String str, int i11, String str2, int i12, int i13);

    public static final native int Mtc_ImSessMsgSendGeoBoth(int i10, Object obj, String str, double d10, double d11, float f10, String str2, boolean z10);

    public static final native int Mtc_ImSessMsgSendGeoCoord(int i10, Object obj, double d10, double d11, float f10, String str, boolean z10);

    public static final native int Mtc_ImSessMsgSendGeoText(int i10, Object obj, String str, String str2, boolean z10);

    public static final native int Mtc_ImSessMsgSendM(int i10, Object obj, byte[] bArr, int i11);

    public static final native int Mtc_ImSessMsgSendO(int i10, Object obj, String str, String str2, int i11);

    public static final native int Mtc_ImSessMsgSetCookie(int i10, int i11, Object obj);

    public static final native int Mtc_ImSessReJoinG(Object obj, String str, String str2, String str3, String str4, int i10);

    public static final native int Mtc_ImSessReJoinGEP(Object obj, String str, String str2, String str3, String str4, int i10);

    public static final native int Mtc_ImSessReJoinGP(Object obj, String str, String str2, String str3, String str4, int i10);

    public static final native int Mtc_ImSessReStartG(Object obj, String str, String str2, int i10);

    public static final native int Mtc_ImSessReject(int i10, int i11);

    public static final native int Mtc_ImSessRjctMdfyChairMan(int i10);

    public static final native int Mtc_ImSessSetCookie(int i10, Object obj);

    public static final native int Mtc_ImSessSetVersionId(int i10, int i11);

    public static final native int Mtc_ImSessStartCompsing(int i10);

    public static final native int Mtc_ImSessStopCompsing(int i10);

    public static final native boolean Mtc_ImSessSuptMsgRevoke(int i10);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

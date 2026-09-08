package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcPaJNI {
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

    public static final native String Mtc_PaArtMsgGetAuthor(int i10);

    public static final native String Mtc_PaArtMsgGetBodyLink(int i10);

    public static final native String Mtc_PaArtMsgGetMainText(int i10);

    public static final native String Mtc_PaArtMsgGetMediaUuid(int i10);

    public static final native String Mtc_PaArtMsgGetOrigLink(int i10);

    public static final native String Mtc_PaArtMsgGetSrcLink(int i10);

    public static final native String Mtc_PaArtMsgGetThumbLink(int i10);

    public static final native String Mtc_PaArtMsgGetTitle(int i10);

    public static final native int Mtc_PaBscGetIdType(int i10);

    public static final native String Mtc_PaBscGetIntro(int i10);

    public static final native String Mtc_PaBscGetLogoUrl(int i10);

    public static final native String Mtc_PaBscGetName(int i10);

    public static final native String Mtc_PaBscGetPaUuid(int i10);

    public static final native int Mtc_PaBscGetRecmdLv(int i10);

    public static final native int Mtc_PaBscGetSubsStat(int i10);

    public static final native int Mtc_PaBscMsgGetCreateTime(int i10);

    public static final native int Mtc_PaBscMsgGetFileDuration(int i10);

    public static final native int Mtc_PaBscMsgGetFileSize(int i10);

    public static final native String Mtc_PaBscMsgGetFileType(int i10);

    public static final native String Mtc_PaBscMsgGetMediaUuid(int i10);

    public static final native String Mtc_PaBscMsgGetOrigLink(int i10);

    public static final native String Mtc_PaBscMsgGetThumbLink(int i10);

    public static final native String Mtc_PaBscMsgGetTitle(int i10);

    public static final native String Mtc_PaCardMsgGetAuthor(int i10);

    public static final native String Mtc_PaCardMsgGetBodyLink(int i10);

    public static final native String Mtc_PaCardMsgGetMainText(int i10);

    public static final native String Mtc_PaCardMsgGetMediaUuid(int i10);

    public static final native String Mtc_PaCardMsgGetOrigLink(int i10);

    public static final native String Mtc_PaCardMsgGetSrcLink(int i10);

    public static final native String Mtc_PaCardMsgGetThumbLink(int i10);

    public static final native String Mtc_PaCardMsgGetTitle(int i10);

    public static final native int Mtc_PaDetailGetAcptStat(int i10);

    public static final native int Mtc_PaDetailGetActiveStat(int i10);

    public static final native String Mtc_PaDetailGetAddr(int i10);

    public static final native String Mtc_PaDetailGetCompany(int i10);

    public static final native String Mtc_PaDetailGetEmail(int i10);

    public static final native String Mtc_PaDetailGetField(int i10);

    public static final native int Mtc_PaDetailGetIdType(int i10);

    public static final native String Mtc_PaDetailGetIntro(int i10);

    public static final native String Mtc_PaDetailGetLogoUrl(int i10);

    public static final native int Mtc_PaDetailGetMenuTimestamp(int i10);

    public static final native int Mtc_PaDetailGetMenuType(int i10);

    public static final native String Mtc_PaDetailGetName(int i10);

    public static final native String Mtc_PaDetailGetPaUuid(int i10);

    public static final native String Mtc_PaDetailGetQrCode(int i10);

    public static final native int Mtc_PaDetailGetRecmdLv(int i10);

    public static final native int Mtc_PaDetailGetSubsStat(int i10);

    public static final native String Mtc_PaDetailGetTel(int i10);

    public static final native String Mtc_PaDetailGetType(int i10);

    public static final native int Mtc_PaDetailGetUpdTime(int i10);

    public static final native String Mtc_PaDetailGetZip(int i10);

    public static final native String Mtc_PaKeyNoteGetName(int i10);

    public static final native int Mtc_PaKeyNoteGetValueColor(int i10);

    public static final native String Mtc_PaKeyNoteGetValueText(int i10);

    public static final native String Mtc_PaMenuGetCmdId(int i10);

    public static final native int Mtc_PaMenuGetCmdType(int i10);

    public static final native int Mtc_PaMenuGetPriority(int i10);

    public static final native int Mtc_PaMenuGetSubmenuId(int i10, int i11);

    public static final native int Mtc_PaMenuGetSubmenuSize(int i10);

    public static final native String Mtc_PaMenuGetTitle(int i10);

    public static final native int Mtc_PaMsgGetActiveStat(int i10);

    public static final native int Mtc_PaMsgGetArtMsgId(int i10, int i11);

    public static final native int Mtc_PaMsgGetArtMsgSize(int i10);

    public static final native int Mtc_PaMsgGetCreateTime(int i10);

    public static final native int Mtc_PaMsgGetFwdable(int i10);

    public static final native int Mtc_PaMsgGetGInfoId(int i10);

    public static final native int Mtc_PaMsgGetMediaType(int i10);

    public static final native String Mtc_PaMsgGetMsgUuid(int i10);

    public static final native String Mtc_PaMsgGetPaUuid(int i10);

    public static final native String Mtc_PaMsgGetSmsDigest(int i10);

    public static final native String Mtc_PaMsgGetText(int i10);

    public static final native int Mtc_PaSessAddSubs(String str);

    public static final native int Mtc_PaSessCancelSubs(String str);

    public static final native int Mtc_PaSessComplainPub(String str, int i10, String str2, String str3, String str4);

    public static final native int Mtc_PaSessDecodeMsg(String str);

    public static final native String Mtc_PaSessEncodeMsg(String str);

    public static final native int Mtc_PaSessGetMenuId(int i10, int i11);

    public static final native int Mtc_PaSessGetMenuSize(int i10);

    public static final native int Mtc_PaSessGetMsgId(int i10, int i11);

    public static final native int Mtc_PaSessGetMsgSize(int i10);

    public static final native int Mtc_PaSessGetPaId(int i10, int i11);

    public static final native int Mtc_PaSessGetPaSize(int i10);

    public static final native String Mtc_PaSessGetPaUuid(int i10);

    public static final native int Mtc_PaSessGetPrevMsg(String str, int i10, int i11, int i12, int i13);

    public static final native int Mtc_PaSessGetPubDetail(String str, int i10);

    public static final native int Mtc_PaSessGetPubLst(String str, int i10, int i11, int i12);

    public static final native int Mtc_PaSessGetPubLstRecmd(int i10, int i11, int i12);

    public static final native int Mtc_PaSessGetPubMenu(String str, int i10);

    public static final native String Mtc_PaSessGetResult(int i10);

    public static final native String Mtc_PaSessGetXmlMsg(int i10);

    public static final native boolean Mtc_PaSessHasData(int i10);

    public static final native int Mtc_PaSessQryUsrSubs(int i10, int i11, int i12);

    public static final native void Mtc_PaSessRelease(int i10);

    public static final native int Mtc_PaSessSetAcptStat(String str, boolean z10);

    public static final native int Mtc_PaTmplMsgGetFirstColor(int i10);

    public static final native String Mtc_PaTmplMsgGetFirstText(int i10);

    public static final native int Mtc_PaTmplMsgGetKeyNoteId(int i10, int i11);

    public static final native int Mtc_PaTmplMsgGetKeyNoteSize(int i10);

    public static final native int Mtc_PaTmplMsgGetLastColor(int i10);

    public static final native String Mtc_PaTmplMsgGetLastText(int i10);

    public static final native String Mtc_PaTmplMsgGetTitle(int i10);

    public static final native int Mtc_PaTmplMsgGetTopColor(int i10);

    public static final native String Mtc_PaTmplMsgGetUrl(int i10);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

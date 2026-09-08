package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcImDeferJNI {
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

    public static final native int Mtc_DmsgConfGetLstEntry(int i10, int i11, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_DmsgConfGetLstEntrySize(int i10);

    public static final native int Mtc_DmsgConfGetLstGrp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native String Mtc_DmsgConfGetRecdName(int i10);

    public static final native int Mtc_DmsgConfGetTimeEnd(int i10, long j10);

    public static final native int Mtc_DmsgConfGetTimeStart(int i10, long j10);

    public static final native String Mtc_DmsgFileGetFileName(int i10);

    public static final native String Mtc_DmsgFileGetFrom(int i10);

    public static final native int Mtc_DmsgFileGetSysTimeStamp(int i10, long j10);

    public static final native String Mtc_DmsgFileGetTo(int i10);

    public static final native int Mtc_DmsgGetHis(int i10);

    public static final native int Mtc_DmsgGetSize();

    public static final native String Mtc_DmsgGroupGetFrom(int i10);

    public static final native String Mtc_DmsgGroupGetGrpId(int i10);

    public static final native int Mtc_DmsgGroupGetSysTimeStamp(int i10, long j10);

    public static final native int Mtc_DmsgGroupGetTimeStamp(int i10);

    public static final native String Mtc_DmsgGroupGetTo(int i10);

    public static final native String Mtc_DmsgHisGetDate(int i10);

    public static final native int Mtc_DmsgHisGetExpiry(int i10, long j10);

    public static final native String Mtc_DmsgHisGetRef(int i10);

    public static final native int Mtc_DmsgHisGetSize(int i10);

    public static final native String Mtc_DmsgHisGetSubject(int i10);

    public static final native int Mtc_DmsgHisGetType(int i10);

    public static final native int Mtc_DmsgLoadAll();

    public static final native String Mtc_DmsgPagerGetAuthId(int i10);

    public static final native String Mtc_DmsgPagerGetFrom(int i10);

    public static final native int Mtc_DmsgPagerGetLstEntry(int i10, int i11, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_DmsgPagerGetLstEntrySize(int i10);

    public static final native int Mtc_DmsgPagerGetLstGrp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_DmsgPagerGetSysTimeStamp(int i10, long j10);

    public static final native int Mtc_DmsgPagerGetTimeStamp(int i10);

    public static final native String Mtc_DmsgPagerGetTo(int i10);

    public static final native int Mtc_DmsgRmvAll();

    public static final native int Mtc_DmsgRmvAllL();

    public static final native int Mtc_DmsgRmvHis(int i10);

    public static final native int Mtc_DmsgRmvHisL(int i10);

    public static final native String Mtc_ImDeferFileGetFileName(int i10);

    public static final native int Mtc_ImDeferFileGetPartp(int i10, MtcString mtcString, MtcString mtcString2);

    public static final native String Mtc_ImDeferMsgGetContent(int i10, long j10);

    public static final native int Mtc_ImDeferMsgGetContentLen(int i10, long j10);

    public static final native String Mtc_ImDeferMsgGetContentType(int i10, long j10);

    public static final native int Mtc_ImDeferMsgGetDateTime(int i10, long j10);

    public static final native int Mtc_ImDeferMsgGetImdnType(int i10, long j10);

    public static final native int Mtc_ImDeferMsgGetPartp(int i10, long j10, MtcString mtcString, MtcString mtcString2);

    public static final native int Mtc_ImDeferMsgGetSysDateTime(int i10, long j10, long j11);

    public static final native boolean Mtc_ImDeferMsgHasRcsSms(int i10, long j10);

    public static final native long Mtc_ImDeferMsgsGetMsg(int i10, int i11);

    public static final native int Mtc_ImDeferMsgsGetSize(int i10);

    public static final native int Mtc_ImDeferRelease(int i10);

    public static final native int Mtc_ImDeferRetrieveAll();

    public static final native int Mtc_ImDeferRetrieveFile(int i10, String str);

    public static final native int Mtc_ImDeferRetrieveLst(int i10);

    public static final native int Mtc_ImDeferRetrievePager(int i10);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

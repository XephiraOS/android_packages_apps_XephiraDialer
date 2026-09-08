package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcGrpJNI {
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

    public static final native int Mtc_GrpAddEntry(int i10, Object obj, String str, String str2);

    public static final native int Mtc_GrpAddEntryL(int i10, Object obj, String str, String str2);

    public static final native Object Mtc_GrpEntryGetCookie(int i10);

    public static final native String Mtc_GrpEntryGetDispName(int i10);

    public static final native int Mtc_GrpEntryGetGrpId(int i10);

    public static final native String Mtc_GrpEntryGetUri(int i10);

    public static final native int Mtc_GrpEntrySetCookie(int i10, Object obj);

    public static final native int Mtc_GrpEntrySetDispName(int i10, String str);

    public static final native int Mtc_GrpEntrySetDispNameL(int i10, String str);

    public static final native int Mtc_GrpFindEntry(int i10, String str);

    public static final native Object Mtc_GrpGetCookie(int i10);

    public static final native String Mtc_GrpGetDispName(int i10);

    public static final native int Mtc_GrpGetEntry(int i10, int i11);

    public static final native int Mtc_GrpGetMaxPartCount(int i10);

    public static final native int Mtc_GrpGetMinPartCount(int i10);

    public static final native boolean Mtc_GrpGetOwner(int i10);

    public static final native int Mtc_GrpGetSize(int i10);

    public static final native String Mtc_GrpGetUri(int i10);

    public static final native int Mtc_GrpRmvEntry(int i10);

    public static final native int Mtc_GrpRmvEntryL(int i10);

    public static final native int Mtc_GrpSetCookie(int i10, Object obj);

    public static final native int Mtc_GrpSetDispName(int i10, String str);

    public static final native int Mtc_GrpSetDispNameL(int i10, String str);

    public static final native int Mtc_GrpSetMaxPartCountL(int i10, int i11);

    public static final native int Mtc_GrpSetMinPartCountL(int i10, int i11);

    public static final native int Mtc_GrpsAddGrp(Object obj, String str, String str2);

    public static final native int Mtc_GrpsAddGrpL(Object obj, String str, String str2);

    public static final native int Mtc_GrpsFindGrp(String str);

    public static final native int Mtc_GrpsGetGrp(int i10);

    public static final native int Mtc_GrpsGetSize();

    public static final native int Mtc_GrpsLoadAllGrp();

    public static final native int Mtc_GrpsLoadGrp(int i10);

    public static final native int Mtc_GrpsLoadGrpU(String str);

    public static final native int Mtc_GrpsRmvGrp(int i10);

    public static final native int Mtc_GrpsUploadGrp(int i10);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

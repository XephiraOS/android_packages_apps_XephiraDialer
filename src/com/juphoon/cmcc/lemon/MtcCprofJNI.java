package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcCprofJNI {
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

    public static final native int Mtc_CprofPccAddAddr();

    public static final native int Mtc_CprofPccAddName();

    public static final native String Mtc_CprofPccAddrGetAddr(int i10);

    public static final native String Mtc_CprofPccAddrGetLabel(int i10);

    public static final native int Mtc_CprofPccAddrGetPref(int i10);

    public static final native int Mtc_CprofPccAddrGetType(int i10);

    public static final native int Mtc_CprofPccAddrSetAddr(int i10, String str);

    public static final native int Mtc_CprofPccAddrSetLabel(int i10, String str);

    public static final native int Mtc_CprofPccAddrSetPref(int i10, int i11);

    public static final native int Mtc_CprofPccAddrSetType(int i10, int i11);

    public static final native int Mtc_CprofPccBirthGetCalType();

    public static final native String Mtc_CprofPccBirthGetDate();

    public static final native String Mtc_CprofPccBirthGetNonGregDate();

    public static final native String Mtc_CprofPccBirthGetPlace();

    public static final native int Mtc_CprofPccBirthSetCalType(int i10);

    public static final native int Mtc_CprofPccBirthSetDate(String str);

    public static final native int Mtc_CprofPccBirthSetNonGregDate(String str);

    public static final native int Mtc_CprofPccBirthSetPlace(String str);

    public static final native String Mtc_CprofPccCareerGetDuty();

    public static final native String Mtc_CprofPccCareerGetEmployer();

    public static final native int Mtc_CprofPccCareerSetDuty(String str);

    public static final native int Mtc_CprofPccCareerSetEmployer(String str);

    public static final native int Mtc_CprofPccCommAddrAddTel();

    public static final native int Mtc_CprofPccCommAddrAddUri();

    public static final native int Mtc_CprofPccCommAddrGetTelId(int i10);

    public static final native int Mtc_CprofPccCommAddrGetTelSize();

    public static final native int Mtc_CprofPccCommAddrGetUriId(int i10);

    public static final native int Mtc_CprofPccCommAddrGetUriSize();

    public static final native int Mtc_CprofPccCommAddrRmvTel(int i10);

    public static final native int Mtc_CprofPccCommAddrRmvUri(int i10);

    public static final native int Mtc_CprofPccGetAddrId(int i10);

    public static final native int Mtc_CprofPccGetAddrSize();

    public static final native int Mtc_CprofPccGetNameId(int i10);

    public static final native int Mtc_CprofPccGetNameSize();

    public static final native int Mtc_CprofPccGetPccType();

    public static final native int Mtc_CprofPccIconExportFile(String str);

    public static final native String Mtc_CprofPccIconGetData();

    public static final native String Mtc_CprofPccIconGetDesc();

    public static final native int Mtc_CprofPccIconGetEncodingType();

    public static final native String Mtc_CprofPccIconGetEtag();

    public static final native int Mtc_CprofPccIconGetMimeType();

    public static final native int Mtc_CprofPccIconGetXResolution();

    public static final native int Mtc_CprofPccIconImportFile(String str);

    public static final native int Mtc_CprofPccIconSetData(String str);

    public static final native int Mtc_CprofPccIconSetDesc(String str);

    public static final native int Mtc_CprofPccIconSetEncodingType(int i10);

    public static final native int Mtc_CprofPccIconSetMimeType(int i10);

    public static final native int Mtc_CprofPccLoadAddr();

    public static final native int Mtc_CprofPccLoadAll();

    public static final native int Mtc_CprofPccLoadBirth();

    public static final native int Mtc_CprofPccLoadCareer();

    public static final native int Mtc_CprofPccLoadCommAddr();

    public static final native int Mtc_CprofPccLoadIcon(int i10, String str);

    public static final native int Mtc_CprofPccLoadName();

    public static final native String Mtc_CprofPccNameGetDispName(int i10);

    public static final native String Mtc_CprofPccNameGetFamily(int i10);

    public static final native String Mtc_CprofPccNameGetFirst(int i10);

    public static final native String Mtc_CprofPccNameGetGiven(int i10);

    public static final native String Mtc_CprofPccNameGetMiddle(int i10);

    public static final native int Mtc_CprofPccNameGetPref(int i10);

    public static final native int Mtc_CprofPccNameGetType(int i10);

    public static final native int Mtc_CprofPccNameSetDispName(int i10, String str);

    public static final native int Mtc_CprofPccNameSetFamily(int i10, String str);

    public static final native int Mtc_CprofPccNameSetFirst(int i10, String str);

    public static final native int Mtc_CprofPccNameSetGiven(int i10, String str);

    public static final native int Mtc_CprofPccNameSetMiddle(int i10, String str);

    public static final native int Mtc_CprofPccNameSetPref(int i10, int i11);

    public static final native int Mtc_CprofPccNameSetType(int i10, int i11);

    public static final native int Mtc_CprofPccRmvAddr(int i10);

    public static final native int Mtc_CprofPccRmvName(int i10);

    public static final native int Mtc_CprofPccSetPccType(int i10);

    public static final native String Mtc_CprofPccTelGetLabel(int i10);

    public static final native int Mtc_CprofPccTelGetPref(int i10);

    public static final native String Mtc_CprofPccTelGetTel(int i10);

    public static final native int Mtc_CprofPccTelGetTelType(int i10);

    public static final native int Mtc_CprofPccTelGetXuiType(int i10);

    public static final native int Mtc_CprofPccTelSetLabel(int i10, String str);

    public static final native int Mtc_CprofPccTelSetPref(int i10, int i11);

    public static final native int Mtc_CprofPccTelSetTel(int i10, String str);

    public static final native int Mtc_CprofPccTelSetTelType(int i10, int i11);

    public static final native int Mtc_CprofPccTelSetXuiType(int i10, int i11);

    public static final native int Mtc_CprofPccUploadAddr();

    public static final native int Mtc_CprofPccUploadAll();

    public static final native int Mtc_CprofPccUploadBirth();

    public static final native int Mtc_CprofPccUploadCareer();

    public static final native int Mtc_CprofPccUploadCommAddr();

    public static final native int Mtc_CprofPccUploadIcon();

    public static final native int Mtc_CprofPccUploadName();

    public static final native String Mtc_CprofPccUriGetLabel(int i10);

    public static final native int Mtc_CprofPccUriGetPref(int i10);

    public static final native int Mtc_CprofPccUriGetType(int i10);

    public static final native String Mtc_CprofPccUriGetUri(int i10);

    public static final native int Mtc_CprofPccUriSetLabel(int i10, String str);

    public static final native int Mtc_CprofPccUriSetPref(int i10, int i11);

    public static final native int Mtc_CprofPccUriSetType(int i10, int i11);

    public static final native int Mtc_CprofPccUriSetUri(int i10, String str);

    public static final native int Mtc_CprofQrCardCttExportFile(String str);

    public static final native String Mtc_CprofQrCardCttGetData();

    public static final native String Mtc_CprofQrCardCttGetDesc();

    public static final native int Mtc_CprofQrCardCttGetEncodingType();

    public static final native int Mtc_CprofQrCardCttGetMimeType();

    public static final native boolean Mtc_CprofQrCardGetBusinessFlag();

    public static final native int Mtc_CprofQrCardLoadAll();

    public static final native int Mtc_CprofQrCardLoadFlag();

    public static final native int Mtc_CprofQrCardLoadPcc(String str);

    public static final native int Mtc_CprofQrCardLoadPccIcon(String str, int i10, String str2);

    public static final native String Mtc_CprofQrCardPccAddrGetAddr(int i10);

    public static final native String Mtc_CprofQrCardPccAddrGetLabel(int i10);

    public static final native int Mtc_CprofQrCardPccAddrGetPref(int i10);

    public static final native int Mtc_CprofQrCardPccAddrGetType(int i10);

    public static final native int Mtc_CprofQrCardPccBirthGetCalType(int i10);

    public static final native String Mtc_CprofQrCardPccBirthGetDate(int i10);

    public static final native String Mtc_CprofQrCardPccBirthGetNonGregDate(int i10);

    public static final native String Mtc_CprofQrCardPccBirthGetPlace(int i10);

    public static final native String Mtc_CprofQrCardPccCareerGetDuty(int i10);

    public static final native String Mtc_CprofQrCardPccCareerGetEmployer(int i10);

    public static final native int Mtc_CprofQrCardPccCommAddrGetTelId(int i10, int i11);

    public static final native int Mtc_CprofQrCardPccCommAddrGetTelSize(int i10);

    public static final native int Mtc_CprofQrCardPccCommAddrGetUriId(int i10, int i11);

    public static final native int Mtc_CprofQrCardPccCommAddrGetUriSize(int i10);

    public static final native int Mtc_CprofQrCardPccGetAddrId(int i10, int i11);

    public static final native int Mtc_CprofQrCardPccGetAddrSize(int i10);

    public static final native int Mtc_CprofQrCardPccGetMediaId(int i10, int i11);

    public static final native int Mtc_CprofQrCardPccGetMediaSize(int i10);

    public static final native int Mtc_CprofQrCardPccGetNameId(int i10, int i11);

    public static final native int Mtc_CprofQrCardPccGetNameSize(int i10);

    public static final native int Mtc_CprofQrCardPccGetPccType(int i10);

    public static final native String Mtc_CprofQrCardPccGetUrl(int i10);

    public static final native String Mtc_CprofQrCardPccGetVcard(int i10);

    public static final native boolean Mtc_CprofQrCardPccHasVcard(int i10);

    public static final native int Mtc_CprofQrCardPccIconClrData(int i10);

    public static final native int Mtc_CprofQrCardPccIconExportFile(int i10, String str);

    public static final native String Mtc_CprofQrCardPccIconGetData(int i10);

    public static final native String Mtc_CprofQrCardPccIconGetDesc(int i10);

    public static final native int Mtc_CprofQrCardPccIconGetEncodingType(int i10);

    public static final native String Mtc_CprofQrCardPccIconGetEtag(int i10);

    public static final native int Mtc_CprofQrCardPccIconGetMimeType(int i10);

    public static final native String Mtc_CprofQrCardPccIconGetUri(int i10);

    public static final native int Mtc_CprofQrCardPccIconGetXResolution(int i10);

    public static final native boolean Mtc_CprofQrCardPccIconHasData(int i10);

    public static final native String Mtc_CprofQrCardPccMediaGetLabel(int i10);

    public static final native String Mtc_CprofQrCardPccMediaGetMediaUrl(int i10);

    public static final native int Mtc_CprofQrCardPccMediaGetPref(int i10);

    public static final native String Mtc_CprofQrCardPccMediaGetType(int i10);

    public static final native String Mtc_CprofQrCardPccNameGetDispName(int i10);

    public static final native String Mtc_CprofQrCardPccNameGetFamily(int i10);

    public static final native String Mtc_CprofQrCardPccNameGetFirst(int i10);

    public static final native String Mtc_CprofQrCardPccNameGetGiven(int i10);

    public static final native String Mtc_CprofQrCardPccNameGetMiddle(int i10);

    public static final native int Mtc_CprofQrCardPccNameGetPref(int i10);

    public static final native int Mtc_CprofQrCardPccNameGetType(int i10);

    public static final native String Mtc_CprofQrCardPccTelGetLabel(int i10);

    public static final native int Mtc_CprofQrCardPccTelGetPref(int i10);

    public static final native String Mtc_CprofQrCardPccTelGetTel(int i10);

    public static final native int Mtc_CprofQrCardPccTelGetTelType(int i10);

    public static final native int Mtc_CprofQrCardPccTelGetXuiType(int i10);

    public static final native String Mtc_CprofQrCardPccUriGetLabel(int i10);

    public static final native int Mtc_CprofQrCardPccUriGetPref(int i10);

    public static final native int Mtc_CprofQrCardPccUriGetType(int i10);

    public static final native String Mtc_CprofQrCardPccUriGetUri(int i10);

    public static final native int Mtc_CprofQrCardSetBusinessFlag(boolean z10);

    public static final native int Mtc_CprofQrCardUploadFlag();

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

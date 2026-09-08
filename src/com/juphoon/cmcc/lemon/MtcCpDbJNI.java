package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcCpDbJNI {
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

    public static final native int Mtc_CliDbGetCpTlsPort();

    public static final native int Mtc_CliDbSetCpTlsPort(int i10);

    public static final native String Mtc_CpDbGetCc();

    public static final native int Mtc_CpDbGetDefSMSApp();

    public static final native String Mtc_CpDbGetFdName();

    public static final native String Mtc_CpDbGetImsi();

    public static final native String Mtc_CpDbGetMsisdn();

    public static final native String Mtc_CpDbGetProvVers();

    public static final native int Mtc_CpDbGetRcsState();

    public static final native String Mtc_CpDbGetSipUri();

    public static final native String Mtc_CpDbGetSrvAddr();

    public static final native String Mtc_CpDbGetSrvRoot();

    public static final native boolean Mtc_CpDbGetSuptHdrCmpl();

    public static final native int Mtc_CpDbGetTmrLenWaitCp();

    public static final native int Mtc_CpDbGetTmrLenWaitPt();

    public static final native String Mtc_CpDbGetToken();

    public static final native int Mtc_CpDbGetVer();

    public static final native int Mtc_CpDbGetVerTimestamp();

    public static final native int Mtc_CpDbGetVerValidTime();

    public static final native int Mtc_CpDbSetCc(String str);

    public static final native int Mtc_CpDbSetDefSMSApp(int i10);

    public static final native int Mtc_CpDbSetFdName(String str);

    public static final native int Mtc_CpDbSetImsi(String str);

    public static final native int Mtc_CpDbSetMsisdn(String str);

    public static final native int Mtc_CpDbSetProvVers(String str);

    public static final native int Mtc_CpDbSetRcsState(int i10);

    public static final native int Mtc_CpDbSetSipUri(String str);

    public static final native int Mtc_CpDbSetSrvAddr(String str);

    public static final native int Mtc_CpDbSetSrvRoot(String str);

    public static final native int Mtc_CpDbSetSuptHdrCmpl(boolean z10);

    public static final native int Mtc_CpDbSetTmrLenWaitCp(int i10);

    public static final native int Mtc_CpDbSetTmrLenWaitPt(int i10);

    public static final native int Mtc_CpDbSetToken(String str);

    public static final native int Mtc_CpDbSetVer(int i10);

    public static final native int Mtc_CpDbSetVerTimestamp(int i10);

    public static final native int Mtc_CpDbSetVerValidTime(int i10);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcCliJNI {
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

    public static final native int Mtc_CliCallCbNetChanged(int i10);

    public static final native int Mtc_CliChkApp();

    public static final native void Mtc_CliClose();

    public static final native void Mtc_CliDestroy();

    public static final native int Mtc_CliDetLclIp();

    public static final native int Mtc_CliDetLclIpv6(MtcNumber mtcNumber);

    public static final native int Mtc_CliDrive(long j10);

    public static final native int Mtc_CliEnterAkaRsp(int i10, String str, String str2, String str3, String str4);

    public static final native int Mtc_CliEnterDgstPwd(int i10, String str);

    public static final native String Mtc_CliGetDevId();

    public static final native String Mtc_CliGetDevIdX(int i10);

    public static final native boolean Mtc_CliGetDidReg();

    public static final native int Mtc_CliGetRegDate();

    public static final native int Mtc_CliGetRegServType();

    public static final native int Mtc_CliGetRegState();

    public static final native int Mtc_CliGetSyncResult();

    public static final native int Mtc_CliGetTimeDiff();

    public static final native int Mtc_CliInfo(String str, String str2);

    public static final native int Mtc_CliInit(String str);

    public static final native int Mtc_CliInitHeartbeatDetect(int i10);

    public static final native int Mtc_CliKeepAlive();

    public static final native int Mtc_CliLogin(int i10, String str);

    public static final native int Mtc_CliLogout();

    public static final native int Mtc_CliNetUnavailable();

    public static final native int Mtc_CliOpen(String str);

    public static final native int Mtc_CliRefresh();

    public static final native int Mtc_CliRegDisc();

    public static final native int Mtc_CliRelogin(int i10, String str);

    public static final native int Mtc_CliSetLclIpAddrType();

    public static final native int Mtc_CliStart();

    public static final native void Mtc_CliStop();

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

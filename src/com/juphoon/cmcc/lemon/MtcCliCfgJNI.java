package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcCliCfgJNI {
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

    public static final native int Mtc_CliCfgClrCmccExtRegCap(int i10);

    public static final native int Mtc_CliCfgClrRegCap(int i10);

    public static final native boolean Mtc_CliCfgGetBuriedDataPointEnable();

    public static final native String Mtc_CliCfgGetBuriedDataPointServerAddr();

    public static final native int Mtc_CliCfgGetCmccExtRegCap();

    public static final native boolean Mtc_CliCfgGetFileEncrypt();

    public static final native String Mtc_CliCfgGetLogDir();

    public static final native int Mtc_CliCfgGetLogFileCount();

    public static final native int Mtc_CliCfgGetLogFileSize();

    public static final native boolean Mtc_CliCfgGetLogcatPrint();

    public static final native int Mtc_CliCfgGetRegCap();

    public static final native int Mtc_CliCfgGetRegSrvType();

    public static final native boolean Mtc_CliCfgGetSocketReuseEnable();

    public static final native boolean Mtc_CliCfgGetStsHttpsEnable();

    public static final native boolean Mtc_CliCfgGetSuptEncPwd();

    public static final native boolean Mtc_CliCfgGetSuptImsSingleLogin();

    public static final native boolean Mtc_CliCfgGetSuptNetDetect();

    public static final native boolean Mtc_CliCfgGetSuptRefreshBefExpr();

    public static final native boolean Mtc_CliCfgGetTimerSelfDrvEnable();

    public static final native int Mtc_CliCfgGetTmrLenWaitReg();

    public static final native boolean Mtc_CliCfgGetUdpConnectEnable();

    public static final native boolean Mtc_CliCfgGetUploadLogFileEnable();

    public static final native boolean Mtc_CliCfgGetUseDetLclIp();

    public static final native boolean Mtc_CliCfgGetUseMobile();

    public static final native int Mtc_CliCfgSetAesKey(String str);

    public static final native int Mtc_CliCfgSetBuriedDataPointEnable(boolean z10);

    public static final native int Mtc_CliCfgSetBuriedDataPointServerAddr(String str);

    public static final native int Mtc_CliCfgSetChkDevIdType(int i10);

    public static final native int Mtc_CliCfgSetCmccExtRegCap(int i10);

    public static final native int Mtc_CliCfgSetContext(Object obj);

    public static final native int Mtc_CliCfgSetFileEncrypt(boolean z10);

    public static final native int Mtc_CliCfgSetLicenseFileName(String str);

    public static final native int Mtc_CliCfgSetLogDir(String str);

    public static final native int Mtc_CliCfgSetLogFileCount(int i10);

    public static final native int Mtc_CliCfgSetLogFileSize(int i10);

    public static final native void Mtc_CliCfgSetLogLevel(int i10);

    public static final native void Mtc_CliCfgSetLogLevelX(int i10);

    public static final native int Mtc_CliCfgSetLogPrint(boolean z10);

    public static final native int Mtc_CliCfgSetLogcatPrint(boolean z10);

    public static final native void Mtc_CliCfgSetPrintLogLevel(int i10);

    public static final native void Mtc_CliCfgSetPrintLogLevelX(int i10);

    public static final native int Mtc_CliCfgSetRegCap(int i10);

    public static final native int Mtc_CliCfgSetRegSrvType(int i10);

    public static final native int Mtc_CliCfgSetSocketReuseEnable(boolean z10);

    public static final native int Mtc_CliCfgSetStsHttpsEnable(boolean z10);

    public static final native int Mtc_CliCfgSetSuptEncPwd(boolean z10);

    public static final native int Mtc_CliCfgSetSuptImsSingleLogin(boolean z10);

    public static final native int Mtc_CliCfgSetSuptNetDetect(boolean z10);

    public static final native int Mtc_CliCfgSetSuptRefreshBefExpr(boolean z10);

    public static final native int Mtc_CliCfgSetTimerSelfDrvEnable(boolean z10);

    public static final native int Mtc_CliCfgSetTmrLenWaitReg(int i10);

    public static final native int Mtc_CliCfgSetUdpConnectEnable(boolean z10);

    public static final native int Mtc_CliCfgSetUploadLogFileEnable(boolean z10);

    public static final native int Mtc_CliCfgSetUseDetLclIp(boolean z10);

    public static final native int Mtc_CliCfgSetUseMobile(boolean z10);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

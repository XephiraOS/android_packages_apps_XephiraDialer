package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcProvDbJNI {
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

    public static final native int Mtc_ProvDbAddExtnParm(String str, String str2);

    public static final native int Mtc_ProvDbAddExtnParmN(String str, int i10, String str2, int i11);

    public static final native int Mtc_ProvDbFlush();

    public static final native String Mtc_ProvDbGetChnnlId();

    public static final native String Mtc_ProvDbGetCliVendor();

    public static final native String Mtc_ProvDbGetCliVer();

    public static final native String Mtc_ProvDbGetCurProfUser();

    public static final native int Mtc_ProvDbGetDeviceType();

    public static final native boolean Mtc_ProvDbGetDftAuthNameInRealm();

    public static final native int Mtc_ProvDbGetDftDtmfType();

    public static final native String Mtc_ProvDbGetDftProxyAddr();

    public static final native String Mtc_ProvDbGetDftRegRealm();

    public static final native String Mtc_ProvDbGetDftRingDir();

    public static final native boolean Mtc_ProvDbGetDftSubRegEvnt();

    public static final native String Mtc_ProvDbGetEmgAddr();

    public static final native String Mtc_ProvDbGetEmgRealm();

    public static final native int Mtc_ProvDbGetExtnParm(String str, MtcString mtcString);

    public static final native int Mtc_ProvDbGetExtnParmBool(String str, MtcNumber mtcNumber);

    public static final native int Mtc_ProvDbGetExtnParmCount(String str);

    public static final native int Mtc_ProvDbGetExtnParmInt(String str, MtcNumber mtcNumber);

    public static final native int Mtc_ProvDbGetExtnParmUint(String str, MtcNumber mtcNumber);

    public static final native String Mtc_ProvDbGetExtnParmX(String str, int i10);

    public static final native boolean Mtc_ProvDbGetGuiShowDbg();

    public static final native String Mtc_ProvDbGetImei();

    public static final native boolean Mtc_ProvDbGetLoginOnPC();

    public static final native boolean Mtc_ProvDbGetManualIp();

    public static final native String Mtc_ProvDbGetMcc();

    public static final native boolean Mtc_ProvDbGetMmeDumpDbg();

    public static final native short Mtc_ProvDbGetMmeLogLevel();

    public static final native String Mtc_ProvDbGetMnc();

    public static final native boolean Mtc_ProvDbGetMvcRecVoice();

    public static final native boolean Mtc_ProvDbGetMvdRecVideo();

    public static final native boolean Mtc_ProvDbGetMvdSyncAudio();

    public static final native int Mtc_ProvDbGetRcsProfile();

    public static final native int Mtc_ProvDbGetRcsVer();

    public static final native boolean Mtc_ProvDbGetRingMute();

    public static final native int Mtc_ProvDbGetSmsPort();

    public static final native int Mtc_ProvDbGetSrvTmpl();

    public static final native String Mtc_ProvDbGetSrvTmplX();

    public static final native String Mtc_ProvDbGetSrvType();

    public static final native String Mtc_ProvDbGetTmnlModel();

    public static final native String Mtc_ProvDbGetTmnlSwVer();

    public static final native String Mtc_ProvDbGetTmnlType();

    public static final native String Mtc_ProvDbGetTmnlVendor();

    public static final native int Mtc_ProvDbSetChnnlId(String str);

    public static final native int Mtc_ProvDbSetCliVendor(String str);

    public static final native int Mtc_ProvDbSetCliVer(String str);

    public static final native int Mtc_ProvDbSetCurProfUser(String str);

    public static final native int Mtc_ProvDbSetDeviceType(int i10);

    public static final native int Mtc_ProvDbSetDftRingDir(String str);

    public static final native int Mtc_ProvDbSetExtnParm(String str, String str2);

    public static final native int Mtc_ProvDbSetExtnParmBool(String str, boolean z10);

    public static final native int Mtc_ProvDbSetExtnParmInt(String str, int i10);

    public static final native int Mtc_ProvDbSetExtnParmUint(String str, int i10);

    public static final native int Mtc_ProvDbSetImei(String str);

    public static final native int Mtc_ProvDbSetLoginOnPC(boolean z10);

    public static final native int Mtc_ProvDbSetManualIp(boolean z10);

    public static final native int Mtc_ProvDbSetMcc(String str);

    public static final native int Mtc_ProvDbSetMmeDumpDbg(boolean z10);

    public static final native int Mtc_ProvDbSetMmeLogLevel(short s10);

    public static final native int Mtc_ProvDbSetMnc(String str);

    public static final native int Mtc_ProvDbSetRcsProfile(int i10);

    public static final native int Mtc_ProvDbSetRcsVer(int i10);

    public static final native int Mtc_ProvDbSetRingMute(boolean z10);

    public static final native int Mtc_ProvDbSetSmsPort(int i10);

    public static final native int Mtc_ProvDbSetSrvTmpl(int i10);

    public static final native int Mtc_ProvDbSetSrvTmplX(String str);

    public static final native int Mtc_ProvDbSetSrvType(String str);

    public static final native int Mtc_ProvDbSetTmnlModel(String str);

    public static final native int Mtc_ProvDbSetTmnlSwVer(String str);

    public static final native int Mtc_ProvDbSetTmnlType(String str);

    public static final native int Mtc_ProvDbSetTmnlVendor(String str);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

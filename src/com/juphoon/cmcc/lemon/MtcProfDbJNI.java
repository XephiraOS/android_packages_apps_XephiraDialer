package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcProfDbJNI {
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

    public static final native int Mtc_ProfDbAddExtnParm(String str, String str2);

    public static final native int Mtc_ProfDbAddExtnParmN(String str, int i10, String str2, int i11);

    public static final native String Mtc_ProfDbGetAppVer();

    public static final native String Mtc_ProfDbGetAreaCode();

    public static final native boolean Mtc_ProfDbGetAutoLogin();

    public static final native String Mtc_ProfDbGetAvatarFile();

    public static final native String Mtc_ProfDbGetCountryCode();

    public static final native boolean Mtc_ProfDbGetCpEnable();

    public static final native int Mtc_ProfDbGetExtnParm(String str, MtcString mtcString);

    public static final native int Mtc_ProfDbGetExtnParmBool(String str, MtcNumber mtcNumber);

    public static final native int Mtc_ProfDbGetExtnParmCount(String str);

    public static final native int Mtc_ProfDbGetExtnParmInt(String str, MtcNumber mtcNumber);

    public static final native int Mtc_ProfDbGetExtnParmUint(String str, MtcNumber mtcNumber);

    public static final native String Mtc_ProfDbGetExtnParmX(String str, int i10);

    public static final native boolean Mtc_ProfDbGetRemPwd();

    public static final native int Mtc_ProfDbSetAppVer(String str);

    public static final native int Mtc_ProfDbSetAreaCode(String str);

    public static final native int Mtc_ProfDbSetAutoLogin(boolean z10);

    public static final native int Mtc_ProfDbSetAvatarFile(String str);

    public static final native int Mtc_ProfDbSetCountryCode(String str);

    public static final native int Mtc_ProfDbSetCpEnable(boolean z10);

    public static final native int Mtc_ProfDbSetExtnParm(String str, String str2);

    public static final native int Mtc_ProfDbSetExtnParmBool(String str, boolean z10);

    public static final native int Mtc_ProfDbSetExtnParmInt(String str, int i10);

    public static final native int Mtc_ProfDbSetExtnParmUint(String str, int i10);

    public static final native int Mtc_ProfDbSetRemPwd(boolean z10);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

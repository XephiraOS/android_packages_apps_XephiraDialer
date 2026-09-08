package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcCapDbJNI {
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

    public static final native boolean Mtc_CapDbGetCapBurnEn();

    public static final native int Mtc_CapDbGetCapBurnTimeLen();

    public static final native boolean Mtc_CapDbGetCapCallComposerEn();

    public static final native boolean Mtc_CapDbGetCapCallUnansweredEn();

    public static final native boolean Mtc_CapDbGetCapChatBotEn();

    public static final native boolean Mtc_CapDbGetCapChatBotSAEn();

    public static final native boolean Mtc_CapDbGetCapCloudFileEn();

    public static final native boolean Mtc_CapDbGetCapCpmFtEn();

    public static final native boolean Mtc_CapDbGetCapCpmLargeEn();

    public static final native boolean Mtc_CapDbGetCapCpmMsgEn();

    public static final native boolean Mtc_CapDbGetCapCpmSessEn();

    public static final native boolean Mtc_CapDbGetCapDPEn();

    public static final native boolean Mtc_CapDbGetCapDefaultDisc();

    public static final native boolean Mtc_CapDbGetCapDisableInitAddrBookScan();

    public static final native boolean Mtc_CapDbGetCapDiscCommonStack();

    public static final native boolean Mtc_CapDbGetCapDiscViaPresEnable();

    public static final native boolean Mtc_CapDbGetCapFTEn();

    public static final native boolean Mtc_CapDbGetCapFTHTTPEn();

    public static final native boolean Mtc_CapDbGetCapFTStFwdEn();

    public static final native boolean Mtc_CapDbGetCapFTThumbEn();

    public static final native boolean Mtc_CapDbGetCapFtsmsEn();

    public static final native boolean Mtc_CapDbGetCapGeoPullEn();

    public static final native boolean Mtc_CapDbGetCapGeoPullFTEn();

    public static final native boolean Mtc_CapDbGetCapGeoPushEn();

    public static final native boolean Mtc_CapDbGetCapGeosmsEn();

    public static final native boolean Mtc_CapDbGetCapGpChatFStFwdEn();

    public static final native boolean Mtc_CapDbGetCapGrpManEn();

    public static final native boolean Mtc_CapDbGetCapIMEn();

    public static final native boolean Mtc_CapDbGetCapISEn();

    public static final native int Mtc_CapDbGetCapInfoExpire();

    public static final native int Mtc_CapDbGetCapMsgCapValidity();

    public static final native int Mtc_CapDbGetCapNonRcsInfoExpire();

    public static final native int Mtc_CapDbGetCapPollingPeriod();

    public static final native int Mtc_CapDbGetCapPollingRate();

    public static final native int Mtc_CapDbGetCapPollingRatePeriod();

    public static final native boolean Mtc_CapDbGetCapSPEn();

    public static final native boolean Mtc_CapDbGetCapServAvailabilityInfoExpiry();

    public static final native boolean Mtc_CapDbGetCapSharedMapEn();

    public static final native boolean Mtc_CapDbGetCapSharedSketchEn();

    public static final native boolean Mtc_CapDbGetCapStandMsgEn();

    public static final native boolean Mtc_CapDbGetCapTagConverg();

    public static final native boolean Mtc_CapDbGetCapVSEn();

    public static final native boolean Mtc_CapDbGetCapVSOutVCEn();

    public static final native boolean Mtc_CapDbGetCapVemEn();

    public static final native boolean Mtc_CapDbGetCapVideoCallEn();

    public static final native boolean Mtc_CapDbGetCapVoicCallEn();

    public static final native int Mtc_CapDbGetMaxSubsNum();

    public static final native int Mtc_CapDbRestoreProvision(int i10);

    public static final native int Mtc_CapDbSetCapBurnEn(boolean z10);

    public static final native int Mtc_CapDbSetCapBurnTimeLen(int i10);

    public static final native int Mtc_CapDbSetCapCallComposerEn(boolean z10);

    public static final native int Mtc_CapDbSetCapCallUnansweredEn(boolean z10);

    public static final native int Mtc_CapDbSetCapChatBotEn(boolean z10);

    public static final native int Mtc_CapDbSetCapChatBotSAEn(boolean z10);

    public static final native int Mtc_CapDbSetCapCloudFileEn(boolean z10);

    public static final native int Mtc_CapDbSetCapCpmFtEn(boolean z10);

    public static final native int Mtc_CapDbSetCapCpmLargeEn(boolean z10);

    public static final native int Mtc_CapDbSetCapCpmMsgEn(boolean z10);

    public static final native int Mtc_CapDbSetCapCpmSessEn(boolean z10);

    public static final native int Mtc_CapDbSetCapDPEn(boolean z10);

    public static final native int Mtc_CapDbSetCapDefaultDisc(boolean z10);

    public static final native int Mtc_CapDbSetCapDisableInitAddrBookScan(boolean z10);

    public static final native int Mtc_CapDbSetCapDiscCommonStack(boolean z10);

    public static final native int Mtc_CapDbSetCapDiscViaPresEnable(boolean z10);

    public static final native int Mtc_CapDbSetCapFTEn(boolean z10);

    public static final native int Mtc_CapDbSetCapFTHTTPEn(boolean z10);

    public static final native int Mtc_CapDbSetCapFTStFwdEn(boolean z10);

    public static final native int Mtc_CapDbSetCapFTThumbEn(boolean z10);

    public static final native int Mtc_CapDbSetCapFtsmsEn(boolean z10);

    public static final native int Mtc_CapDbSetCapGeoPullEn(boolean z10);

    public static final native int Mtc_CapDbSetCapGeoPullFTEn(boolean z10);

    public static final native int Mtc_CapDbSetCapGeoPushEn(boolean z10);

    public static final native int Mtc_CapDbSetCapGeosmsEn(boolean z10);

    public static final native int Mtc_CapDbSetCapGpChatFStFwdEn(boolean z10);

    public static final native int Mtc_CapDbSetCapGrpManEn(boolean z10);

    public static final native int Mtc_CapDbSetCapIMEn(boolean z10);

    public static final native int Mtc_CapDbSetCapISEn(boolean z10);

    public static final native int Mtc_CapDbSetCapInfoExpire(int i10);

    public static final native int Mtc_CapDbSetCapMsgCapValidity(int i10);

    public static final native int Mtc_CapDbSetCapNonRcsInfoExpire(int i10);

    public static final native int Mtc_CapDbSetCapPollingPeriod(int i10);

    public static final native int Mtc_CapDbSetCapPollingRate(int i10);

    public static final native int Mtc_CapDbSetCapPollingRatePeriod(int i10);

    public static final native int Mtc_CapDbSetCapSPEn(boolean z10);

    public static final native int Mtc_CapDbSetCapServAvailabilityInfoExpiry(int i10);

    public static final native int Mtc_CapDbSetCapSharedMapEn(boolean z10);

    public static final native int Mtc_CapDbSetCapSharedSketchEn(boolean z10);

    public static final native int Mtc_CapDbSetCapStdMsgEn(boolean z10);

    public static final native int Mtc_CapDbSetCapTagConverg(boolean z10);

    public static final native int Mtc_CapDbSetCapVSEn(boolean z10);

    public static final native int Mtc_CapDbSetCapVSOutVCEn(boolean z10);

    public static final native int Mtc_CapDbSetCapVemEn(boolean z10);

    public static final native int Mtc_CapDbSetCapVideoCallEn(boolean z10);

    public static final native int Mtc_CapDbSetCapVoicCallEn(boolean z10);

    public static final native int Mtc_CapDbSetMaxSubsNum(int i10);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();
}

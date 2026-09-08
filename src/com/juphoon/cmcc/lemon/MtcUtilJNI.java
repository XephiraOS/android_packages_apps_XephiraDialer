package com.juphoon.cmcc.lemon;

/* loaded from: classes3.dex */
public class MtcUtilJNI {
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

    public static final native void Mtc_AnyLogDbgStr(String str, String str2);

    public static final native void Mtc_AnyLogErrStr(String str, String str2);

    public static final native int Mtc_AnyLogFlush();

    public static final native void Mtc_AnyLogInfoStr(String str, String str2);

    public static final native int Mtc_CmdRun(String str);

    public static final native int Mtc_GetAccessNetType();

    public static final native String Mtc_GetImdnMsgId();

    public static final native String Mtc_GetLclIp(int i10);

    public static final native int Mtc_GetLclIpCnt();

    public static final native int Mtc_SysTime2Time(long j10, ST_MTC_SYS_TIME st_mtc_sys_time, MtcNumber mtcNumber);

    public static final native int Mtc_TestHttpDecode(String str);

    public static final native int Mtc_TestSipDecode(String str);

    public static final native int Mtc_Time2SysTime(int i10, long j10, ST_MTC_SYS_TIME st_mtc_sys_time);

    public static final native int Mtc_TimerCreate(int i10, boolean z10, long j10, MtcNumber mtcNumber);

    public static final native int Mtc_TimerDelete(int i10);

    public static final native boolean Mtc_TimerIsRun(int i10);

    public static final native int Mtc_TimerSchedule(int i10, long j10, int i11);

    public static final native int Mtc_TimerStart(int i10, int i11);

    public static final native int Mtc_TimerStop(int i10);

    public static final native int Mtc_UtilLeave(long j10, long j11);

    public static final native long Mtc_ZjsonObjectGet(long j10, String str);

    public static final native long Mtc_ZjsonObjectGetNumber(long j10, String str);

    public static final native String Mtc_ZjsonObjectGetString(long j10, String str);

    public static final native long Mtc_ZjsonParse(long j10, String str, int i10);

    public static final native int ST_MTC_SYS_TIME_iTzOffset_get(long j10, ST_MTC_SYS_TIME st_mtc_sys_time);

    public static final native void ST_MTC_SYS_TIME_iTzOffset_set(long j10, ST_MTC_SYS_TIME st_mtc_sys_time, int i10);

    public static final native short ST_MTC_SYS_TIME_ucDay_get(long j10, ST_MTC_SYS_TIME st_mtc_sys_time);

    public static final native void ST_MTC_SYS_TIME_ucDay_set(long j10, ST_MTC_SYS_TIME st_mtc_sys_time, short s10);

    public static final native short ST_MTC_SYS_TIME_ucHour_get(long j10, ST_MTC_SYS_TIME st_mtc_sys_time);

    public static final native void ST_MTC_SYS_TIME_ucHour_set(long j10, ST_MTC_SYS_TIME st_mtc_sys_time, short s10);

    public static final native short ST_MTC_SYS_TIME_ucMinute_get(long j10, ST_MTC_SYS_TIME st_mtc_sys_time);

    public static final native void ST_MTC_SYS_TIME_ucMinute_set(long j10, ST_MTC_SYS_TIME st_mtc_sys_time, short s10);

    public static final native short ST_MTC_SYS_TIME_ucMonth_get(long j10, ST_MTC_SYS_TIME st_mtc_sys_time);

    public static final native void ST_MTC_SYS_TIME_ucMonth_set(long j10, ST_MTC_SYS_TIME st_mtc_sys_time, short s10);

    public static final native short ST_MTC_SYS_TIME_ucSecond_get(long j10, ST_MTC_SYS_TIME st_mtc_sys_time);

    public static final native void ST_MTC_SYS_TIME_ucSecond_set(long j10, ST_MTC_SYS_TIME st_mtc_sys_time, short s10);

    public static final native short ST_MTC_SYS_TIME_ucWeekDay_get(long j10, ST_MTC_SYS_TIME st_mtc_sys_time);

    public static final native void ST_MTC_SYS_TIME_ucWeekDay_set(long j10, ST_MTC_SYS_TIME st_mtc_sys_time, short s10);

    public static final native int ST_MTC_SYS_TIME_wYear_get(long j10, ST_MTC_SYS_TIME st_mtc_sys_time);

    public static final native void ST_MTC_SYS_TIME_wYear_set(long j10, ST_MTC_SYS_TIME st_mtc_sys_time, int i10);

    public static final native void delete_MtcByteArray(long j10);

    public static final native void delete_MtcNumber(long j10);

    public static final native void delete_MtcString(long j10);

    public static final native void delete_ST_MTC_SYS_TIME(long j10);

    public static final native long new_MtcByteArray();

    public static final native long new_MtcNumber();

    public static final native long new_MtcString();

    public static final native long new_ST_MTC_SYS_TIME();
}

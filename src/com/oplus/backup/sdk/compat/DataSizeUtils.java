package com.oplus.backup.sdk.compat;

/* loaded from: classes3.dex */
public class DataSizeUtils {
    private static final long ACCOUNT_FILE_SIZE = 620;
    private static final long BROWSER_FILE_SIZE = 350;
    private static final long CALENDAR_FILE_SIZE = 700;
    private static final long CALLRECORD_FILE_SIZE = 450;
    private static final long CLOCK_FILE_SIZE = 250;
    private static final long CONTACTS_BLACKLIST_FILE_SIZE = 170;
    private static final long CONTACTS_HEAD_SIZE = 30720;
    private static final long CONTACTS_TEXT_SIZE = 400;
    private static final long LAUNCHER_FILE_SIZE = 450560;
    private static final long MMS_FILE_SIZE = 256000;
    private static final long SMS_FILE_SIZE = 750;
    private static final long SYSTEM_SETTING_FILE_SIZE = 81920;
    private static final long WEATHER_FILE_SIZE = 320;

    public static long estimateSize(int i10, int i11) {
        long j10;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 4) {
                    if (i10 != 8) {
                        if (i10 != 272) {
                            if (i10 != 288) {
                                if (i10 != 304) {
                                    if (i10 != 320) {
                                        if (i10 != 336) {
                                            if (i10 != 352) {
                                                if (i10 != 384) {
                                                    if (i10 != 592) {
                                                        return 0L;
                                                    }
                                                    j10 = CONTACTS_BLACKLIST_FILE_SIZE;
                                                } else {
                                                    return SYSTEM_SETTING_FILE_SIZE;
                                                }
                                            } else {
                                                return LAUNCHER_FILE_SIZE;
                                            }
                                        } else {
                                            return ACCOUNT_FILE_SIZE;
                                        }
                                    } else {
                                        j10 = WEATHER_FILE_SIZE;
                                    }
                                } else {
                                    j10 = BROWSER_FILE_SIZE;
                                }
                            } else {
                                j10 = CLOCK_FILE_SIZE;
                            }
                        } else {
                            j10 = CALLRECORD_FILE_SIZE;
                        }
                    } else {
                        j10 = CALENDAR_FILE_SIZE;
                    }
                } else {
                    j10 = MMS_FILE_SIZE;
                }
            } else {
                j10 = SMS_FILE_SIZE;
            }
            return i11 * j10;
        }
        return ((i11 / 2) * CONTACTS_HEAD_SIZE) + (i11 * CONTACTS_TEXT_SIZE);
    }
}

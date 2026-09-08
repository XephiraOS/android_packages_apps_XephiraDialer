package com.coui.appcompat.lunarutil;

import android.text.TextUtils;
import android.util.Log;
import com.coui.appcompat.calendar.COUIDateMonthView;
import com.coui.appcompat.picker.COUILunarDatePicker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class COUILunarUtil {
    public static final int DECREATE_A_LUANR_YEAR = -1;
    private static final int DEFAULT_END_YEAR = 2100;
    private static final int DEFAULT_START_YEAR = 1900;
    private static final int HIGH_BIT_VALUE = 32768;
    public static final int INCREASE_A_LUANR_YEAR = 1;
    private static final int LAUN_LEAP_MONTH_DAYS = 29;
    private static final int LAUN_MONTH_DAYS = 30;
    private static final int LEAPMONTH_BIT_FLAG = 15;
    private static final int LEAPMONTH_BIT_MASK = 65536;
    public static final int LEAP_MONTH = 0;
    private static final int LOW_BIT_VALUE = 8;
    private static final int MAX_YEAR = 2100;
    private static final int MIN_YEAR = 1900;
    public static final int NORMAL_MONTH = 1;
    private static final int ONE = 1;
    private static final int[][] SOLAR_TERM_DAYS;
    private static final String START_DATE = "19000130";
    private static final String TAG = "COUILunar";
    private static final int THIRTY = 30;
    private static final int TWELVE = 12;
    private static final int YEAR_OF_MONTH = 12;
    private static final String[] CHINESE_NUMBER = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"};
    private static final String[] ALL_SC_SOLAR_TERM_NAMES = {"小寒", "大寒", "立春", "雨水", "惊蛰", "春分", "清明", "谷雨", "立夏", "小满", "芒种", "夏至", "小暑", "大暑", "立秋", "处暑", "白露", "秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至"};
    private static final String[] ALL_TC_SOLAR_TERM_NAMES = {"小寒", "大寒", "立春", "雨水", "驚蟄", "春分", "清明", "穀雨", "立夏", "小滿", "芒種", "夏至", "小暑", "大暑", "立秋", "處暑", "白露", "秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至"};
    private static final long[] LUNAR_INFO = {19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 92821, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42416, 83315, 21168, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 23232, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448, 84835, 37744, 18936, 18800, 25776, 92326, 59984, 27424, 108228, 43744, 37600, 53987, 51552, 54615, 54432, 55888, 23893, 22176, 42704, 21972, 21200, 43448, 43344, 46240, 46758, 44368, 21920, 43940, 42416, 21168, 45683, 26928, 29495, 27296, 44368, 84821, 19296, 42352, 21732, 53600, 59752, 54560, 55968, 92838, 22224, 19168, 43476, 41680, 53584, 62034, 54560};
    private static SimpleDateFormat sChineseDateFormat = new SimpleDateFormat("yyyy年MM月dd日");

    static {
        int[] iArr = new int[24];
        // fill-array-data instruction
        iArr[0] = 6;
        iArr[1] = 21;
        iArr[2] = 4;
        iArr[3] = 19;
        iArr[4] = 5;
        iArr[5] = 20;
        iArr[6] = 4;
        iArr[7] = 20;
        iArr[8] = 5;
        iArr[9] = 21;
        iArr[10] = 5;
        iArr[11] = 21;
        iArr[12] = 7;
        iArr[13] = 23;
        iArr[14] = 7;
        iArr[15] = 23;
        iArr[16] = 7;
        iArr[17] = 23;
        iArr[18] = 8;
        iArr[19] = 23;
        iArr[20] = 7;
        iArr[21] = 22;
        iArr[22] = 7;
        iArr[23] = 21;
        SOLAR_TERM_DAYS = new int[][]{new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 6, 21, 5, 21, 6, 22, 6, 22, 8, 23, 8, 24, 8, 24, 9, 24, 8, 23, 8, 22}, new int[]{6, 21, 5, 19, 5, 20, 5, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 21, 6, 22, 6, 22, 8, 23, 8, 24, 8, 24, 9, 24, 8, 23, 8, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 5, 21, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 24, 8, 23, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 21, 6, 22, 6, 22, 8, 23, 8, 24, 8, 23, 9, 24, 8, 23, 8, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 19, 5, 21, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 8, 23, 8, 24, 8, 23, 9, 24, 8, 23, 8, 22}, iArr, new int[]{5, 20, 4, 19, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 8, 23, 8, 24, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 9, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 24, 8, 23, 7, 22}, new int[]{6, 21, 4, 19, 5, 20, 4, 20, 5, 20, 5, 21, 7, 22, 7, 23, 7, 22, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 5, 21, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 7, 22, 7, 23, 7, 22, 8, 23, 7, 22, 6, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 24, 8, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 7, 22, 7, 23, 7, 22, 8, 23, 7, 22, 6, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 22, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 6, 22, 7, 23, 7, 22, 8, 23, 7, 22, 6, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 6, 22, 7, 22, 7, 22, 8, 23, 7, 22, 6, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 6, 21, 6, 21, 7, 23, 8, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 6, 22, 7, 22, 7, 22, 8, 23, 7, 22, 6, 21}, new int[]{5, 20, 3, 18, 5, 20, 4, 20, 5, 21, 5, 21, 7, 22, 7, 23, 7, 23, 8, 23, 7, 22, 7, 21}, new int[]{5, 20, 4, 18, 5, 20, 5, 20, 5, 21, 5, 21, 7, 23, 7, 23, 7, 23, 8, 23, 7, 22, 7, 22}, new int[]{5, 20, 4, 19, 6, 21, 5, 20, 5, 21, 6, 21, 7, 23, 7, 23, 8, 23, 8, 23, 7, 22, 7, 22}, new int[]{6, 20, 4, 19, 5, 20, 4, 19, 5, 20, 5, 21, 6, 22, 7, 22, 7, 22, 8, 23, 7, 22, 6, 21}};
    }

    public static int[] calculateLunarByGregorian(int i10, int i11, int i12) {
        Date date;
        int i13 = 0;
        int[] iArr = {2000, 1, 1, 1};
        if (i10 == Integer.MIN_VALUE) {
            iArr[0] = i10;
            int i14 = i11 - 1;
            iArr[1] = (i14 % 12) + 1;
            iArr[2] = i12;
            if (i14 / 12 <= 0) {
                i13 = 1;
            }
            iArr[3] = i13;
            return iArr;
        }
        Date date2 = null;
        try {
            date = sChineseDateFormat.parse("1900年1月31日");
        } catch (ParseException e10) {
            Log.e(TAG, "calculateLunarByGregorian(),parse baseDate error.");
            e10.printStackTrace();
            date = null;
        }
        if (date == null) {
            Log.e(TAG, "baseDate is null,return lunar date:2000.1.1");
            return iArr;
        }
        try {
            date2 = sChineseDateFormat.parse(i10 + "年" + i11 + "月" + i12 + "日");
        } catch (ParseException e11) {
            Log.e(TAG, "calculateLunarByGregorian(),parse currentDate error.");
            e11.printStackTrace();
        }
        if (date2 == null) {
            Log.e(TAG, "currentDate is null,return lunar date:2000.1.1");
            return iArr;
        }
        int round = Math.round(((float) (date2.getTime() - date.getTime())) / 8.64E7f);
        int i15 = COUIDateMonthView.MIN_YEAR;
        int i16 = 0;
        while (i15 < 10000 && round > 0) {
            i16 = daysOfLunarYear(i15);
            round -= i16;
            i15++;
        }
        if (round < 0) {
            round += i16;
            i15--;
        }
        int leapMonth = leapMonth(i15);
        int i17 = 0;
        int i18 = 0;
        int i19 = 1;
        while (i19 < 13 && round > 0) {
            if (leapMonth > 0 && i19 == leapMonth + 1 && i17 == 0) {
                i19--;
                i18 = daysOfLeapMonthInLunarYear(i15);
                i17 = 1;
            } else {
                i18 = daysOfALunarMonth(i15, i19);
            }
            round -= i18;
            if (i17 != 0 && i19 == leapMonth + 1) {
                i17 = 0;
            }
            i19++;
        }
        if (round == 0 && leapMonth > 0 && i19 == leapMonth + 1) {
            if (i17 != 0) {
                i17 = 0;
            } else {
                i19--;
                i17 = 1;
            }
        }
        if (round < 0) {
            round += i18;
            i19--;
        }
        iArr[0] = i15;
        iArr[1] = i19;
        iArr[2] = round + 1;
        iArr[3] = i17 ^ 1;
        return iArr;
    }

    public static COUILunarDatePicker.IncompleteDate changeALunarYear(int i10, int i11, int i12, int i13) {
        boolean z10;
        int[] clampMonth = clampMonth(i10, i11, i13);
        boolean z11 = false;
        int i14 = clampMonth[0];
        if (clampMonth[1] == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int clampDay = clampDay(i10, i14, i12, z10);
        int i15 = clampMonth[0];
        if (clampMonth[1] == 0) {
            z11 = true;
        }
        Date lunarToSolar = lunarToSolar(i10, i15, clampDay, z11);
        COUILunarDatePicker.IncompleteDate incompleteDate = new COUILunarDatePicker.IncompleteDate();
        if (lunarToSolar != null) {
            incompleteDate.setTimeInMillis(lunarToSolar.getTime());
        }
        return incompleteDate;
    }

    @Deprecated
    public static Calendar changeALunarYearByOne(Calendar calendar, int i10, int i11, int i12, int i13, int i14) {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(calendar.getTimeInMillis());
        int days = getDays(i13, i10, i11, i12);
        int days2 = getDays(i14, i10, i11, i12);
        if (i13 > i14) {
            calendar2.add(5, -((daysOfLunarYear(i14) - days2) + days));
        } else if (i13 < i14) {
            calendar2.add(5, (daysOfLunarYear(i13) + days2) - days);
        }
        return calendar2;
    }

    public static String chineseStringOfALunarDay(int i10) {
        int i11;
        String[] strArr = {"初", "十", "廿", "卅"};
        int i12 = i10 % 10;
        if (i12 == 0) {
            i11 = 9;
        } else {
            i11 = i12 - 1;
        }
        if (i10 > 30) {
            return "";
        }
        if (i10 == 10) {
            return "初十";
        }
        if (i10 == 20) {
            return "二十";
        }
        if (i10 == 30) {
            return "三十";
        }
        return strArr[i10 / 10] + CHINESE_NUMBER[i11];
    }

    public static int clampDay(int i10, int i11, int i12, boolean z10) {
        int daysOfLeapMonthInLunarYear;
        if (!z10) {
            daysOfLeapMonthInLunarYear = daysOfALunarMonth(i10, i11);
        } else {
            daysOfLeapMonthInLunarYear = daysOfLeapMonthInLunarYear(i10);
        }
        if (i12 > daysOfLeapMonthInLunarYear) {
            return daysOfLeapMonthInLunarYear;
        }
        return i12;
    }

    private static int[] clampMonth(int i10, int i11, int i12) {
        int i13;
        int leapMonth = leapMonth(i10);
        if (i12 == 0 && leapMonth == i11) {
            i13 = 1;
        } else {
            i13 = 0;
        }
        return new int[]{i11, i13 ^ 1};
    }

    public static int daysOfALunarMonth(int i10, int i11) {
        if (i10 != Integer.MIN_VALUE && i10 >= 1900) {
            if (((65536 >> i11) & LUNAR_INFO[i10 - COUIDateMonthView.MIN_YEAR]) == 0) {
                return 29;
            }
        }
        return 30;
    }

    public static int daysOfLeapMonthInLunarYear(int i10) {
        if (leapMonth(i10) != 0) {
            if ((LUNAR_INFO[i10 - 1900] & 65536) != 0) {
                return 30;
            }
            return 29;
        }
        return 0;
    }

    public static int daysOfLunarYear(int i10) {
        if (i10 == Integer.MIN_VALUE) {
            return 0;
        }
        int i11 = 348;
        for (int i12 = 32768; i12 > 8; i12 >>= 1) {
            int i13 = i10 - 1900;
            if (i13 >= 0) {
                long[] jArr = LUNAR_INFO;
                if (i13 < jArr.length && (jArr[i13] & i12) != 0) {
                    i11++;
                }
            }
        }
        return i11 + daysOfLeapMonthInLunarYear(i10);
    }

    private static int[] getAMonthSolarTermDays(int i10, int i11) {
        int i12 = (i11 - 1) * 2;
        int[] iArr = {0, 0};
        if (i10 > 1969 && i10 < 2037) {
            int[] iArr2 = SOLAR_TERM_DAYS[i10 - 1970];
            int i13 = iArr2[i12];
            int i14 = iArr2[i12 + 1];
            iArr[0] = i13;
            iArr[1] = i14;
        }
        return iArr;
    }

    private static String[] getAMonthSolarTermNames(int i10) {
        if (i10 >= 1 && i10 <= 12) {
            int i11 = (i10 - 1) * 2;
            String[] strArr = ALL_TC_SOLAR_TERM_NAMES;
            return new String[]{strArr[i11], strArr[i11 + 1]};
        }
        Log.e(TAG, "getAMonthSolarTermNames(),param gregorianMonth:" + i10 + " is error");
        return new String[]{"", ""};
    }

    public static int getDays(int i10, int i11, int i12, int i13) {
        int daysOfALunarMonth;
        if (i10 == Integer.MIN_VALUE) {
            return 0;
        }
        for (int i14 = 1; i14 < i11; i14++) {
            i12 += daysOfALunarMonth(i10, i14);
        }
        if (leapMonth(i10) < i11) {
            daysOfALunarMonth = daysOfLeapMonthInLunarYear(i10);
        } else if (leapMonth(i10) == i11 && i13 == 0) {
            daysOfALunarMonth = daysOfALunarMonth(i10, i11);
        } else {
            return i12;
        }
        return i12 + daysOfALunarMonth;
    }

    private static String getGregFestival(int i10, int i11) {
        if (i10 == 1 && i11 == 1) {
            return "";
        }
        if (i10 == 5 && i11 == 1) {
            return "";
        }
        if (i10 == 10 && i11 == 1) {
            return "";
        }
        return null;
    }

    public static String getLunarDateString(Calendar calendar) {
        int[] calculateLunarByGregorian = calculateLunarByGregorian(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
        return getLunarDateString(calculateLunarByGregorian[0], calculateLunarByGregorian[1], calculateLunarByGregorian[2], calculateLunarByGregorian[3]);
    }

    private static String getLunarFestival(int i10, int i11) {
        if (i10 == 1 && i11 == 1) {
            return "春節";
        }
        if (i10 == 5 && i11 == 5) {
            return "端午";
        }
        if (i10 == 8 && i11 == 15) {
            return "中秋";
        }
        return null;
    }

    public static String getLunarFestivalChineseString(int i10, int i11, int i12) {
        boolean z10;
        String gregFestival = getGregFestival(i11, i12);
        if (!TextUtils.isEmpty(gregFestival)) {
            return gregFestival;
        }
        int[] calculateLunarByGregorian = calculateLunarByGregorian(i10, i11, i12);
        String lunarFestival = getLunarFestival(calculateLunarByGregorian[1], calculateLunarByGregorian[2]);
        if (!TextUtils.isEmpty(lunarFestival)) {
            return lunarFestival;
        }
        String solarTerm = getSolarTerm(i10, i11, i12);
        if (!TextUtils.isEmpty(solarTerm)) {
            return solarTerm;
        }
        if (calculateLunarByGregorian[3] == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        return getLunarNumber(calculateLunarByGregorian[1], calculateLunarByGregorian[2], z10);
    }

    private static String getLunarNumber(int i10, int i11, boolean z10) {
        if (i11 == 1) {
            if (z10) {
                return "闰" + CHINESE_NUMBER[i10 - 1];
            }
            return CHINESE_NUMBER[i10 - 1] + "月";
        }
        return chineseStringOfALunarDay(i11);
    }

    public static String getSolarTerm(int i10, int i11, int i12) {
        int[] aMonthSolarTermDays = getAMonthSolarTermDays(i10, i11);
        if (i12 != aMonthSolarTermDays[0] && i12 != aMonthSolarTermDays[1]) {
            return null;
        }
        String[] aMonthSolarTermNames = getAMonthSolarTermNames(i11);
        if (i12 == aMonthSolarTermDays[0]) {
            return aMonthSolarTermNames[0];
        }
        if (i12 != aMonthSolarTermDays[1]) {
            return null;
        }
        return aMonthSolarTermNames[1];
    }

    private static int getYearDays(int i10) {
        int i11 = 348;
        for (int i12 = 32768; i12 >= 8; i12 >>= 1) {
            if ((LUNAR_INFO[i10 - 1900] & 65520 & i12) != 0) {
                i11++;
            }
        }
        return i11 + daysOfLeapMonthInLunarYear(i10);
    }

    private static boolean isLunarDate(int i10, int i11, int i12, boolean z10) {
        if (i10 < 1900 || i10 > 2100 || i11 < 1 || i11 > 12 || i12 < 1 || i12 > 30) {
            return false;
        }
        int leapMonth = leapMonth(i10);
        if (z10 && i11 != leapMonth) {
            return false;
        }
        return true;
    }

    public static int leapMonth(int i10) {
        if (i10 >= 1900 && i10 <= 2100) {
            return (int) (LUNAR_INFO[i10 - COUIDateMonthView.MIN_YEAR] & 15);
        }
        Log.e(TAG, "get leapMonth:" + i10 + "is out of range.return 0.");
        return 0;
    }

    public static Date lunarToSolar(int i10, int i11, int i12, boolean z10) {
        if (!isLunarDate(i10, i11, i12, z10)) {
            return null;
        }
        int i13 = 0;
        for (int i14 = COUIDateMonthView.MIN_YEAR; i14 < i10; i14++) {
            i13 += getYearDays(i14);
        }
        int leapMonth = leapMonth(i10);
        if (z10 && leapMonth != i11) {
            return null;
        }
        int i15 = 1;
        if (leapMonth != 0 && i11 >= leapMonth && (i11 != leapMonth || z10)) {
            while (i15 < i11) {
                i13 += daysOfALunarMonth(i10, i15);
                i15++;
            }
            if (i11 > leapMonth) {
                i13 += daysOfLeapMonthInLunarYear(i10);
                if (i12 > daysOfALunarMonth(i10, i11)) {
                    return null;
                }
            } else {
                i13 += daysOfALunarMonth(i10, i11);
                if (i12 > daysOfLeapMonthInLunarYear(i10)) {
                    return null;
                }
            }
        } else {
            while (i15 < i11) {
                i13 += daysOfALunarMonth(i10, i15);
                i15++;
            }
            if (i12 > daysOfALunarMonth(i10, i11)) {
                return null;
            }
        }
        int i16 = i13 + i12;
        try {
            Date parse = new SimpleDateFormat("yyyyMMdd").parse(START_DATE);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            calendar.add(5, i16);
            return calendar.getTime();
        } catch (ParseException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String getLunarDateString(int i10, int i11, int i12) {
        int[] calculateLunarByGregorian = calculateLunarByGregorian(i10, i11, i12);
        return getLunarDateString(calculateLunarByGregorian[0], calculateLunarByGregorian[1], calculateLunarByGregorian[2], calculateLunarByGregorian[3]);
    }

    private static String getLunarDateString(int i10, int i11, int i12, int i13) {
        if (i10 != Integer.MIN_VALUE) {
            StringBuilder sb = new StringBuilder();
            sb.append(i10);
            sb.append("年");
            sb.append(i13 == 0 ? "闰" : "");
            sb.append(CHINESE_NUMBER[i11 - 1]);
            sb.append("月");
            sb.append(chineseStringOfALunarDay(i12));
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i13 == 0 ? "闰" : "");
        sb2.append(CHINESE_NUMBER[i11 - 1]);
        sb2.append("月");
        sb2.append(chineseStringOfALunarDay(i12));
        return sb2.toString();
    }
}

package com.customize.contacts.util;

import Z3.g;
import android.content.Context;
import android.content.res.Resources;
import com.coui.appcompat.calendar.COUIDateMonthView;
import com.oplus.dialer.R;
import java.util.Calendar;
import java.util.Date;

/* compiled from: LunarUtils.java */
/* loaded from: classes3.dex */
public class N {
    public static int a(int i10, int i11) {
        if (i11 > 0 && i11 < 13) {
            int i12 = i11 + 1;
            if (i12 == i10) {
                return i11 + 12;
            }
            if (i10 > i12) {
                return i10 - 1;
            }
            return i10;
        }
        return i10;
    }

    public static String b(Context context, int i10) {
        String[] stringArray = context.getResources().getStringArray(R.array.chinese_ten);
        String[] stringArray2 = context.getResources().getStringArray(R.array.chinese_day_number);
        int i11 = i10 % 10;
        if (i11 == 0) {
            i11 = 10;
        }
        if (i10 > 30) {
            return "";
        }
        if (i10 == 10) {
            return stringArray[0] + stringArray2[10];
        }
        if (i10 == 20) {
            return stringArray2[2] + stringArray2[10];
        }
        if (i10 == 30) {
            return stringArray2[3] + stringArray2[10];
        }
        return stringArray[i10 / 10] + stringArray2[i11];
    }

    public static boolean c(int[] iArr, int i10, int i11, int i12) {
        int[] o10;
        boolean z10;
        if (i10 == 1900) {
            Calendar calendar = Calendar.getInstance();
            o10 = D7.a.o(Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
        } else {
            o10 = D7.a.o(Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
        }
        int a10 = a(o10[1], D7.a.e(Integer.valueOf(o10[0])));
        o10[1] = a10;
        if (a10 > 12) {
            o10[1] = a10 - 12;
            z10 = true;
        } else {
            z10 = false;
        }
        if (i11 > 12) {
            i11 -= 12;
            z10 = true;
        }
        if (iArr != null && iArr.length >= 3) {
            if (i10 == 1900) {
                iArr[0] = i10;
                iArr[1] = i11;
                iArr[2] = i12;
            } else {
                iArr[0] = o10[0];
                iArr[1] = o10[1];
                iArr[2] = o10[2];
            }
        }
        return z10;
    }

    public static String d(Context context, int i10) {
        String[] stringArray = context.getResources().getStringArray(R.array.chinese_lunar_sky_branch);
        String[] stringArray2 = context.getResources().getStringArray(R.array.chinese_lunar_earth_branch);
        if (i10 < 4) {
            H7.b.c("LunarUtils", "The starting year must be greater than 4");
            i10 = 5;
        }
        int i11 = i10 - 4;
        return stringArray[i11 % 10] + stringArray2[i11 % 12];
    }

    public static String e(Context context, int i10, int i11, int i12) {
        int[] iArr = new int[3];
        return g.c.b(iArr[0], iArr[1], iArr[2], c(iArr, i10, i11, i12));
    }

    public static String f(Context context, int i10, int i11, int i12, boolean z10) {
        return g(context, i10, i11, i12, z10, false);
    }

    public static String g(Context context, int i10, int i11, int i12, boolean z10, boolean z11) {
        Resources resources = context.getResources();
        String[] stringArray = resources.getStringArray(R.array.chinese_month_number);
        StringBuilder sb = new StringBuilder();
        if (i10 != 1900 && !z11) {
            sb.append(U7.a.b(i10));
            sb.append(d(context, i10) + resources.getString(R.string.lunar_year));
        }
        if (z10) {
            sb.append(resources.getString(R.string.lunar_leap));
            sb.append(stringArray[i11 - 1]);
            sb.append(resources.getString(R.string.lunar_month));
        } else {
            sb.append(stringArray[i11 - 1]);
            sb.append(resources.getString(R.string.lunar_month));
        }
        sb.append(b(context, i12));
        return sb.toString();
    }

    public static String h(Context context, int i10, int i11, int i12) {
        int[] iArr = new int[3];
        return f(context, iArr[0], iArr[1], iArr[2], c(iArr, i10, i11, i12));
    }

    public static String i(Context context, String str) {
        String b10;
        Date r10 = F7.b.r(str);
        if (r10 != null) {
            b10 = e(context, r10.getYear() + COUIDateMonthView.MIN_YEAR, r10.getMonth() + 1, r10.getDate());
        } else {
            b10 = F7.b.b(context, str);
        }
        Calendar calendar = Calendar.getInstance();
        String e10 = e(context, calendar.get(1), calendar.get(2) + 1, calendar.get(5));
        String substring = b10.substring(4);
        try {
            if (Integer.parseInt(e10.substring(4)) > Integer.parseInt(substring)) {
                e10 = String.valueOf(Integer.parseInt(e10.substring(0, 4)) + 1) + substring;
            } else {
                e10 = e10.substring(0, 4) + substring;
            }
        } catch (Exception e11) {
            H7.b.c("LunarUtils", "e = " + e11);
            e10 = e10.substring(0, 4) + substring;
        }
        return j(e10);
    }

    public static String j(String str) {
        int[] iArr = new int[4];
        try {
            iArr[0] = Integer.parseInt(str.substring(0, 4));
            iArr[1] = Integer.parseInt(str.substring(4, 6));
            iArr[2] = Integer.parseInt(str.substring(6, 8));
            iArr[3] = Integer.parseInt(str.substring(8));
        } catch (Exception e10) {
            H7.b.c("LunarUtils", "e = " + e10);
        }
        int[] iArr2 = new int[3];
        F7.c.a(iArr, iArr2);
        return g.c.c(iArr2[0], iArr2[1], iArr2[2]);
    }
}

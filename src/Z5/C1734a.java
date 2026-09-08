package z5;

import com.oplus.util.OplusChineseDateAndSolarDate;
import com.oppo.util.OppoChineseDateAndSolarDate;

/* compiled from: OplusChineseDateAndSolarDate.java */
/* renamed from: z5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1734a {
    public static int[] a(int i10, int i11, int i12) {
        if (A5.a.b()) {
            return OplusChineseDateAndSolarDate.ChineseDateToSunDate(i10, i11, i12);
        }
        return OppoChineseDateAndSolarDate.ChineseDateToSunDate(i10, i11, i12);
    }

    public static int b(int i10) {
        if (A5.a.b()) {
            return OplusChineseDateAndSolarDate.GetChLeapMonth(i10);
        }
        return OppoChineseDateAndSolarDate.GetChLeapMonth(i10);
    }

    public static int c(int i10, int i11) {
        if (A5.a.b()) {
            return OplusChineseDateAndSolarDate.GetChMonthDays(i10, i11);
        }
        return OppoChineseDateAndSolarDate.GetChMonthDays(i10, i11);
    }

    public static int[] d(int i10, int i11, int i12) {
        if (A5.a.b()) {
            return OplusChineseDateAndSolarDate.SunDateToChineseDate(i10, i11, i12);
        }
        return OppoChineseDateAndSolarDate.SunDateToChineseDate(i10, i11, i12);
    }
}

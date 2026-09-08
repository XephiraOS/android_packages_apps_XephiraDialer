package M6;

import android.os.VibrationEffect;
import android.os.Vibrator;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import com.oplus.os.OplusVibratorConstant;

/* compiled from: VibratorNative.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static int f1784a = ((Integer) k()).intValue();

    /* renamed from: b, reason: collision with root package name */
    public static int f1785b = ((Integer) c()).intValue();

    /* renamed from: c, reason: collision with root package name */
    public static int f1786c = ((Integer) j()).intValue();

    /* renamed from: d, reason: collision with root package name */
    public static long f1787d = ((Long) i()).longValue();

    /* renamed from: e, reason: collision with root package name */
    public static long f1788e = ((Long) d()).longValue();

    /* renamed from: f, reason: collision with root package name */
    public static long f1789f = ((Long) a()).longValue();

    /* renamed from: g, reason: collision with root package name */
    public static long f1790g = ((Long) b()).longValue();

    /* renamed from: h, reason: collision with root package name */
    public static long[] f1791h = (long[]) f();

    /* renamed from: i, reason: collision with root package name */
    public static int[] f1792i = (int[]) e();

    /* renamed from: j, reason: collision with root package name */
    public static long[] f1793j = (long[]) h();

    /* renamed from: k, reason: collision with root package name */
    public static int[] f1794k = (int[]) g();

    public static Object a() {
        if (S6.c.j()) {
            return 150L;
        }
        return g.a();
    }

    public static Object b() {
        if (S6.c.j()) {
            return 400L;
        }
        return g.b();
    }

    public static Object c() {
        if (S6.c.j()) {
            return 175;
        }
        return g.c();
    }

    public static Object d() {
        if (S6.c.j()) {
            return 50L;
        }
        return g.d();
    }

    public static Object e() {
        if (S6.c.j()) {
            return OplusVibratorConstant.RAPID_MIDDLE_WAVEFORM_AMPLITUDE;
        }
        return g.e();
    }

    public static Object f() {
        if (S6.c.j()) {
            return OplusVibratorConstant.RAPID_MIDDLE_WAVEFORM_TIME;
        }
        return g.f();
    }

    public static Object g() {
        if (S6.c.j()) {
            return OplusVibratorConstant.RAPID_STRONG_WAVEFORM_AMPLITUDE;
        }
        return g.g();
    }

    public static Object h() {
        if (S6.c.j()) {
            return OplusVibratorConstant.RAPID_STRONG_WAVEFORM_TIME;
        }
        return g.h();
    }

    public static Object i() {
        if (S6.c.j()) {
            return 25L;
        }
        return g.i();
    }

    public static Object j() {
        if (S6.c.j()) {
            return 250;
        }
        return g.j();
    }

    public static Object k() {
        if (S6.c.j()) {
            return 100;
        }
        return g.k();
    }

    @Deprecated
    public static void l(Vibrator vibrator, VibrationEffect vibrationEffect) {
        if (!S6.c.m()) {
            if (S6.c.l()) {
                m(vibrator, vibrationEffect);
                return;
            }
            throw new UnSupportedApiVersionException("not supported before Q");
        }
        throw new UnSupportedApiVersionException("not supported in R because of not exist");
    }

    public static void m(Vibrator vibrator, VibrationEffect vibrationEffect) {
        g.l(vibrator, vibrationEffect);
    }
}

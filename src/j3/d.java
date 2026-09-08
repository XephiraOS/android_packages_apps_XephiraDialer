package J3;

import M6.f;
import android.os.VibrationEffect;
import android.os.Vibrator;
import kotlin.jvm.internal.i;

/* compiled from: VibratorCustomize.kt */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1582a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final long f1583b = f.f1787d;

    /* renamed from: c, reason: collision with root package name */
    public static final int f1584c = f.f1784a;

    public static final void a(Vibrator vibrator, VibrationEffect vibe) {
        i.f(vibrator, "vibrator");
        i.f(vibe, "vibe");
        try {
            f.l(vibrator, vibe);
        } catch (Exception e10) {
            H7.b.c("VibratorCustomize", "linerMotorVibrate error :" + e10);
        }
    }
}

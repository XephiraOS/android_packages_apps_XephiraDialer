package M6;

import android.media.AudioAttributes;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.color.inner.os.VibratorWrapper;

/* compiled from: VibratorNativeOplusCompat.java */
/* loaded from: classes3.dex */
public class g {
    public static Object a() {
        return 150L;
    }

    public static Object b() {
        return 400L;
    }

    public static Object c() {
        return 175;
    }

    public static Object d() {
        return 50L;
    }

    public static Object e() {
        return VibratorWrapper.RAPID_MIDDLE_WAVEFORM_AMPLITUDE;
    }

    public static Object f() {
        return VibratorWrapper.RAPID_MIDDLE_WAVEFORM_TIME;
    }

    public static Object g() {
        return VibratorWrapper.RAPID_STRONG_WAVEFORM_AMPLITUDE;
    }

    public static Object h() {
        return VibratorWrapper.RAPID_STRONG_WAVEFORM_TIME;
    }

    public static Object i() {
        return 25L;
    }

    public static Object j() {
        return 250;
    }

    public static Object k() {
        return 100;
    }

    public static void l(Vibrator vibrator, VibrationEffect vibrationEffect) {
        VibratorWrapper.linerMotorVibrate(vibrator, vibrationEffect, (AudioAttributes) null);
    }
}

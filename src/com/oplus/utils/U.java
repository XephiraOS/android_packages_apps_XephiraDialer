package com.oplus.utils;

import android.media.AudioAttributes;
import android.media.SoundPool;

/* compiled from: SoundLoadUtil.java */
/* loaded from: classes3.dex */
public class U {

    /* renamed from: b, reason: collision with root package name */
    public static U f29103b;

    /* renamed from: a, reason: collision with root package name */
    public SoundPool f29104a;

    public U() {
        b();
    }

    public static synchronized U a() {
        U u10;
        synchronized (U.class) {
            try {
                if (f29103b == null) {
                    f29103b = new U();
                }
                u10 = f29103b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return u10;
    }

    public final void b() {
        SoundPool.Builder builder = new SoundPool.Builder();
        AudioAttributes build = new AudioAttributes.Builder().setLegacyStreamType(1).build();
        builder.setMaxStreams(1);
        builder.setAudioAttributes(build);
        this.f29104a = builder.build();
    }

    public int c(String str, int i10) {
        return this.f29104a.load(str, i10);
    }

    public void d(int i10, float f10, float f11, int i11, int i12, float f12) {
        this.f29104a.play(i10, f10, f11, i11, i12, f12);
    }

    public void e(SoundPool.OnLoadCompleteListener onLoadCompleteListener) {
        this.f29104a.setOnLoadCompleteListener(onLoadCompleteListener);
    }
}

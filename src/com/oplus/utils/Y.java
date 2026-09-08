package com.oplus.utils;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.Log;
import com.oplus.blacklistapp.framework.baseui.util.CommonFeatureOption;

/* compiled from: VibrateFeedback.java */
/* loaded from: classes3.dex */
public final class Y {

    /* renamed from: a, reason: collision with root package name */
    public Vibrator f29110a;

    /* renamed from: b, reason: collision with root package name */
    public W5.a f29111b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f29112c;

    /* renamed from: d, reason: collision with root package name */
    public VibrationEffect f29113d;

    /* renamed from: e, reason: collision with root package name */
    public com.heytap.addon.os.d f29114e;

    /* renamed from: f, reason: collision with root package name */
    public final Context f29115f;

    /* renamed from: g, reason: collision with root package name */
    public final ContentObserver f29116g = new a(new Handler());

    /* compiled from: VibrateFeedback.java */
    /* loaded from: classes3.dex */
    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            Y y10 = Y.this;
            y10.b(y10.f29115f);
        }
    }

    public Y(Context context) {
        this.f29110a = null;
        this.f29111b = null;
        this.f29115f = context;
        b(context);
        c();
        try {
            this.f29111b = new W5.a(context);
            if (C0846g.c()) {
                Log.d("VibrateFeedback", "is linear vibrate support : " + this.f29111b);
            }
            W5.a aVar = this.f29111b;
            if (aVar != null && aVar.a()) {
                if (C0846g.c()) {
                    Log.d("VibrateFeedback", "is linear vibrate support : true ");
                }
                this.f29114e = W5.b.a();
            } else if (this.f29110a == null) {
                Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
                this.f29110a = vibrator;
                if (vibrator != null && CommonFeatureOption.c()) {
                    this.f29113d = VibrationEffect.createOneShot(M6.f.f1787d, M6.f.f1784a);
                }
            }
        } catch (Throwable unused) {
            Log.e("VibrateFeedback", "VibrateFeedback init service error!");
        }
    }

    public void b(Context context) {
        boolean z10;
        try {
            if (z6.b.c(context, 0, "haptic_feedback_enabled", 0) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f29112c = z10;
            if (C0846g.c()) {
                Log.d("VibrateFeedback", "mVibrateEnabled " + this.f29112c);
            }
        } catch (Exception unused) {
            this.f29112c = false;
        }
    }

    public void c() {
        try {
            this.f29115f.getContentResolver().registerContentObserver(Settings.System.getUriFor("haptic_feedback_enabled"), false, this.f29116g);
        } catch (Exception e10) {
            Log.e("VibrateFeedback", "registerObserver : " + e10);
        }
    }
}

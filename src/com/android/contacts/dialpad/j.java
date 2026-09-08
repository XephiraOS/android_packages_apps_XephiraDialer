package com.android.contacts.dialpad;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import com.android.contacts.ContactsApplication;

/* compiled from: VibrateFeedback.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public Vibrator f14959a;

    /* renamed from: b, reason: collision with root package name */
    public D7.b f14960b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14961c;

    /* renamed from: d, reason: collision with root package name */
    public VibrationEffect f14962d;

    /* renamed from: e, reason: collision with root package name */
    public com.heytap.addon.os.d f14963e;

    /* renamed from: f, reason: collision with root package name */
    public final ContentObserver f14964f = new a(new Handler());

    /* compiled from: VibrateFeedback.java */
    /* loaded from: classes.dex */
    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            j.this.a(ContactsApplication.h());
        }
    }

    public j(Context context) {
        this.f14959a = null;
        this.f14960b = null;
        a(context);
        b();
        try {
            this.f14960b = D7.a.c(context);
            if (H7.a.b()) {
                H7.b.b("VibrateFeedback", "is linear vibrate support : " + this.f14960b);
            }
            D7.b bVar = this.f14960b;
            if (bVar != null && bVar.a()) {
                if (H7.a.b()) {
                    H7.b.b("VibrateFeedback", "is linear vibrate support : true ");
                }
                this.f14963e = D7.d.a();
            } else if (this.f14959a == null) {
                Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
                this.f14959a = vibrator;
                if (vibrator != null && B3.a.l()) {
                    this.f14962d = VibrationEffect.createOneShot(J3.d.f1583b, J3.d.f1584c);
                }
            }
        } catch (Throwable unused) {
            H7.b.c("VibrateFeedback", "VibrateFeedback init service error!");
        }
    }

    public void a(Context context) {
        boolean z10;
        try {
            if (G0.c.d(context, 0, "haptic_feedback_enabled", 0) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f14961c = z10;
            if (H7.a.b()) {
                H7.b.b("VibrateFeedback", "mVibrateEnabled " + this.f14961c);
            }
        } catch (Exception unused) {
            this.f14961c = false;
        }
    }

    public void b() {
        try {
            ContactsApplication.h().getContentResolver().registerContentObserver(Settings.System.getUriFor("haptic_feedback_enabled"), false, this.f14964f);
        } catch (Exception e10) {
            H7.b.c("VibrateFeedback", "registerObserver : " + e10);
        }
    }

    public void c() {
        try {
            if (this.f14961c) {
                if (H7.a.b()) {
                    H7.b.b("VibrateFeedback", "tryVibrate() == begin");
                }
                D7.b bVar = this.f14960b;
                if (bVar != null && bVar.a()) {
                    this.f14960b.b(this.f14963e);
                } else if (this.f14959a != null) {
                    if (B3.a.l()) {
                        J3.d.a(this.f14959a, this.f14962d);
                    } else {
                        this.f14959a.vibrate(50L);
                    }
                }
                if (H7.a.b()) {
                    H7.b.b("VibrateFeedback", "tryVibrate() == end");
                }
            }
        } catch (Throwable th) {
            H7.b.c("VibrateFeedback", "th = " + th);
        }
    }

    public void d() {
        try {
            ContactsApplication.h().getContentResolver().unregisterContentObserver(this.f14964f);
        } catch (Exception e10) {
            H7.b.c("VibrateFeedback", "unregisterObserver : " + e10);
        }
    }
}

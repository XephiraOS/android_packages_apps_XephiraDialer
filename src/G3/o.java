package g3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import s3.C1541l;

/* compiled from: HardwareConfigState.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f31857e = false;

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f31858f = true;

    /* renamed from: g, reason: collision with root package name */
    public static final File f31859g = new File("/proc/self/fd");

    /* renamed from: h, reason: collision with root package name */
    public static volatile o f31860h;

    /* renamed from: b, reason: collision with root package name */
    public int f31862b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f31863c = true;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f31864d = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    public final int f31861a = 20000;

    public static o b() {
        if (f31860h == null) {
            synchronized (o.class) {
                try {
                    if (f31860h == null) {
                        f31860h = new o();
                    }
                } finally {
                }
            }
        }
        return f31860h;
    }

    public static boolean e() {
        return false;
    }

    public final boolean a() {
        if (f31857e && !this.f31864d.get()) {
            return true;
        }
        return false;
    }

    public final int c() {
        if (e()) {
            return 500;
        }
        return this.f31861a;
    }

    public final synchronized boolean d() {
        try {
            boolean z10 = true;
            int i10 = this.f31862b + 1;
            this.f31862b = i10;
            if (i10 >= 50) {
                this.f31862b = 0;
                int length = f31859g.list().length;
                long c10 = c();
                if (length >= c10) {
                    z10 = false;
                }
                this.f31863c = z10;
                if (!z10 && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + c10);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f31863c;
    }

    public boolean f(int i10, int i11, boolean z10, boolean z11) {
        if (!z10) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!f31858f) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (a()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z11) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        if (i10 >= 0 && i11 >= 0) {
            if (!d()) {
                if (Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
                }
                return false;
            }
            return true;
        }
        if (Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed because of invalid dimensions");
        }
        return false;
    }

    public boolean g(int i10, int i11, BitmapFactory.Options options, boolean z10, boolean z11) {
        boolean f10 = f(i10, i11, z10, z11);
        if (f10) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return f10;
    }

    public void h() {
        C1541l.a();
        this.f31864d.set(true);
    }
}

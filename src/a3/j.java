package a3;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBitmapPool.java */
/* loaded from: classes.dex */
public class j implements d {

    /* renamed from: k, reason: collision with root package name */
    public static final Bitmap.Config f6372k = Bitmap.Config.ARGB_8888;

    /* renamed from: a, reason: collision with root package name */
    public final k f6373a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Bitmap.Config> f6374b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6375c;

    /* renamed from: d, reason: collision with root package name */
    public final a f6376d;

    /* renamed from: e, reason: collision with root package name */
    public long f6377e;

    /* renamed from: f, reason: collision with root package name */
    public long f6378f;

    /* renamed from: g, reason: collision with root package name */
    public int f6379g;

    /* renamed from: h, reason: collision with root package name */
    public int f6380h;

    /* renamed from: i, reason: collision with root package name */
    public int f6381i;

    /* renamed from: j, reason: collision with root package name */
    public int f6382j;

    /* compiled from: LruBitmapPool.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    public j(long j10, k kVar, Set<Bitmap.Config> set) {
        this.f6375c = j10;
        this.f6377e = j10;
        this.f6373a = kVar;
        this.f6374b = set;
        this.f6376d = new b();
    }

    public static void f(Bitmap.Config config) {
        if (config != Bitmap.Config.HARDWARE) {
            return;
        }
        throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    }

    public static Bitmap g(int i10, int i11, Bitmap.Config config) {
        if (config == null) {
            config = f6372k;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    public static Set<Bitmap.Config> k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        hashSet.remove(Bitmap.Config.HARDWARE);
        return Collections.unmodifiableSet(hashSet);
    }

    public static k l() {
        return new m();
    }

    public static void o(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    public static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    @Override // a3.d
    public void a(int i10) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i10);
        }
        if (i10 < 40 && i10 < 20) {
            if (i10 >= 20 || i10 == 15) {
                q(n() / 2);
                return;
            }
            return;
        }
        b();
    }

    @Override // a3.d
    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        q(0L);
    }

    @Override // a3.d
    public synchronized void c(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.f6373a.b(bitmap) <= this.f6377e && this.f6374b.contains(bitmap.getConfig())) {
                        int b10 = this.f6373a.b(bitmap);
                        this.f6373a.c(bitmap);
                        this.f6376d.b(bitmap);
                        this.f6381i++;
                        this.f6378f += b10;
                        if (Log.isLoggable("LruBitmapPool", 2)) {
                            Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f6373a.e(bitmap));
                        }
                        h();
                        j();
                        return;
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f6373a.e(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f6374b.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // a3.d
    public Bitmap d(int i10, int i11, Bitmap.Config config) {
        Bitmap m10 = m(i10, i11, config);
        if (m10 != null) {
            m10.eraseColor(0);
            return m10;
        }
        return g(i10, i11, config);
    }

    @Override // a3.d
    public Bitmap e(int i10, int i11, Bitmap.Config config) {
        Bitmap m10 = m(i10, i11, config);
        if (m10 == null) {
            return g(i10, i11, config);
        }
        return m10;
    }

    public final void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    public final void i() {
        Log.v("LruBitmapPool", "Hits=" + this.f6379g + ", misses=" + this.f6380h + ", puts=" + this.f6381i + ", evictions=" + this.f6382j + ", currentSize=" + this.f6378f + ", maxSize=" + this.f6377e + "\nStrategy=" + this.f6373a);
    }

    public final void j() {
        q(this.f6377e);
    }

    public final synchronized Bitmap m(int i10, int i11, Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap d10;
        try {
            f(config);
            k kVar = this.f6373a;
            if (config != null) {
                config2 = config;
            } else {
                config2 = f6372k;
            }
            d10 = kVar.d(i10, i11, config2);
            if (d10 == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Missing bitmap=" + this.f6373a.a(i10, i11, config));
                }
                this.f6380h++;
            } else {
                this.f6379g++;
                this.f6378f -= this.f6373a.b(d10);
                this.f6376d.a(d10);
                p(d10);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Get bitmap=" + this.f6373a.a(i10, i11, config));
            }
            h();
        } catch (Throwable th) {
            throw th;
        }
        return d10;
    }

    public long n() {
        return this.f6377e;
    }

    public final synchronized void q(long j10) {
        while (this.f6378f > j10) {
            try {
                Bitmap removeLast = this.f6373a.removeLast();
                if (removeLast == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        i();
                    }
                    this.f6378f = 0L;
                    return;
                }
                this.f6376d.a(removeLast);
                this.f6378f -= this.f6373a.b(removeLast);
                this.f6382j++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Evicting bitmap=" + this.f6373a.e(removeLast));
                }
                h();
                removeLast.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public j(long j10) {
        this(j10, l(), k());
    }

    /* compiled from: LruBitmapPool.java */
    /* loaded from: classes.dex */
    public static final class b implements a {
        @Override // a3.j.a
        public void a(Bitmap bitmap) {
        }

        @Override // a3.j.a
        public void b(Bitmap bitmap) {
        }
    }
}

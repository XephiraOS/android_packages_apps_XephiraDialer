package b3;

import V2.a;
import android.util.Log;
import b3.InterfaceC0520a;
import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCacheWrapper.java */
/* loaded from: classes.dex */
public class e implements InterfaceC0520a {

    /* renamed from: b, reason: collision with root package name */
    public final File f12112b;

    /* renamed from: c, reason: collision with root package name */
    public final long f12113c;

    /* renamed from: e, reason: collision with root package name */
    public V2.a f12115e;

    /* renamed from: d, reason: collision with root package name */
    public final C0522c f12114d = new C0522c();

    /* renamed from: a, reason: collision with root package name */
    public final j f12111a = new j();

    @Deprecated
    public e(File file, long j10) {
        this.f12112b = file;
        this.f12113c = j10;
    }

    public static InterfaceC0520a c(File file, long j10) {
        return new e(file, j10);
    }

    @Override // b3.InterfaceC0520a
    public void a(X2.b bVar, InterfaceC0520a.b bVar2) {
        V2.a d10;
        String b10 = this.f12111a.b(bVar);
        this.f12114d.a(b10);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + b10 + " for for Key: " + bVar);
            }
            try {
                d10 = d();
            } catch (IOException e10) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e10);
                }
            }
            if (d10.S(b10) != null) {
                return;
            }
            a.c I10 = d10.I(b10);
            if (I10 != null) {
                try {
                    if (bVar2.a(I10.f(0))) {
                        I10.e();
                    }
                    I10.b();
                    return;
                } catch (Throwable th) {
                    I10.b();
                    throw th;
                }
            }
            throw new IllegalStateException("Had two simultaneous puts for: " + b10);
        } finally {
            this.f12114d.b(b10);
        }
    }

    @Override // b3.InterfaceC0520a
    public File b(X2.b bVar) {
        String b10 = this.f12111a.b(bVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + b10 + " for for Key: " + bVar);
        }
        try {
            a.e S10 = d().S(b10);
            if (S10 == null) {
                return null;
            }
            return S10.a(0);
        } catch (IOException e10) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e10);
            return null;
        }
    }

    public final synchronized V2.a d() {
        try {
            if (this.f12115e == null) {
                this.f12115e = V2.a.U(this.f12112b, 1, 1, this.f12113c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f12115e;
    }
}

package b3;

import b3.InterfaceC0520a;
import java.io.File;

/* compiled from: DiskLruCacheFactory.java */
/* renamed from: b3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0523d implements InterfaceC0520a.InterfaceC0145a {

    /* renamed from: a, reason: collision with root package name */
    public final long f12109a;

    /* renamed from: b, reason: collision with root package name */
    public final a f12110b;

    /* compiled from: DiskLruCacheFactory.java */
    /* renamed from: b3.d$a */
    /* loaded from: classes.dex */
    public interface a {
        File a();
    }

    public C0523d(a aVar, long j10) {
        this.f12109a = j10;
        this.f12110b = aVar;
    }

    @Override // b3.InterfaceC0520a.InterfaceC0145a
    public InterfaceC0520a build() {
        File a10 = this.f12110b.a();
        if (a10 == null) {
            return null;
        }
        if (!a10.isDirectory() && !a10.mkdirs()) {
            return null;
        }
        return e.c(a10, this.f12109a);
    }
}

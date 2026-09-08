package androidx.room;

import e0.h;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* compiled from: SQLiteCopyOpenHelperFactory.java */
/* loaded from: classes.dex */
public class A implements h.c {

    /* renamed from: a, reason: collision with root package name */
    public final String f11223a;

    /* renamed from: b, reason: collision with root package name */
    public final File f11224b;

    /* renamed from: c, reason: collision with root package name */
    public final Callable<InputStream> f11225c;

    /* renamed from: d, reason: collision with root package name */
    public final h.c f11226d;

    public A(String str, File file, Callable<InputStream> callable, h.c cVar) {
        this.f11223a = str;
        this.f11224b = file;
        this.f11225c = callable;
        this.f11226d = cVar;
    }

    @Override // e0.h.c
    public e0.h a(h.b bVar) {
        return new z(bVar.f30548a, this.f11223a, this.f11224b, this.f11225c, bVar.f30550c.f30547a, this.f11226d.a(bVar));
    }
}

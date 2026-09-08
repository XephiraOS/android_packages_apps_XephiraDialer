package e3;

import com.bumptech.glide.load.data.j;
import d3.h;
import d3.n;
import d3.o;
import d3.p;
import d3.s;
import java.io.InputStream;

/* compiled from: HttpGlideUrlLoader.java */
/* renamed from: e3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0970a implements o<h, InputStream> {

    /* renamed from: b, reason: collision with root package name */
    public static final X2.c<Integer> f30587b = X2.c.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a, reason: collision with root package name */
    public final n<h, h> f30588a;

    /* compiled from: HttpGlideUrlLoader.java */
    /* renamed from: e3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0294a implements p<h, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        public final n<h, h> f30589a = new n<>(500);

        @Override // d3.p
        public o<h, InputStream> d(s sVar) {
            return new C0970a(this.f30589a);
        }
    }

    public C0970a(n<h, h> nVar) {
        this.f30588a = nVar;
    }

    @Override // d3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<InputStream> b(h hVar, int i10, int i11, X2.d dVar) {
        n<h, h> nVar = this.f30588a;
        if (nVar != null) {
            h a10 = nVar.a(hVar, 0, 0);
            if (a10 == null) {
                this.f30588a.b(hVar, 0, 0, hVar);
            } else {
                hVar = a10;
            }
        }
        return new o.a<>(hVar, new j(hVar, ((Integer) dVar.c(f30587b)).intValue()));
    }

    @Override // d3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(h hVar) {
        return true;
    }
}

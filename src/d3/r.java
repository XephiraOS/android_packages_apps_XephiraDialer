package d3;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.GlideException;
import d3.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import s3.C1540k;

/* compiled from: MultiModelLoader.java */
/* loaded from: classes.dex */
public class r<Model, Data> implements o<Model, Data> {

    /* renamed from: a, reason: collision with root package name */
    public final List<o<Model, Data>> f29997a;

    /* renamed from: b, reason: collision with root package name */
    public final I.e<List<Throwable>> f29998b;

    /* compiled from: MultiModelLoader.java */
    /* loaded from: classes.dex */
    public static class a<Data> implements com.bumptech.glide.load.data.d<Data>, d.a<Data> {

        /* renamed from: a, reason: collision with root package name */
        public final List<com.bumptech.glide.load.data.d<Data>> f29999a;

        /* renamed from: b, reason: collision with root package name */
        public final I.e<List<Throwable>> f30000b;

        /* renamed from: c, reason: collision with root package name */
        public int f30001c;

        /* renamed from: d, reason: collision with root package name */
        public Priority f30002d;

        /* renamed from: e, reason: collision with root package name */
        public d.a<? super Data> f30003e;

        /* renamed from: f, reason: collision with root package name */
        public List<Throwable> f30004f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f30005g;

        public a(List<com.bumptech.glide.load.data.d<Data>> list, I.e<List<Throwable>> eVar) {
            this.f30000b = eVar;
            C1540k.c(list);
            this.f29999a = list;
            this.f30001c = 0;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<Data> a() {
            return this.f29999a.get(0).a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            List<Throwable> list = this.f30004f;
            if (list != null) {
                this.f30000b.a(list);
            }
            this.f30004f = null;
            Iterator<com.bumptech.glide.load.data.d<Data>> it = this.f29999a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void c(Exception exc) {
            ((List) C1540k.d(this.f30004f)).add(exc);
            g();
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.f30005g = true;
            Iterator<com.bumptech.glide.load.data.d<Data>> it = this.f29999a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource d() {
            return this.f29999a.get(0).d();
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(Priority priority, d.a<? super Data> aVar) {
            this.f30002d = priority;
            this.f30003e = aVar;
            this.f30004f = this.f30000b.b();
            this.f29999a.get(this.f30001c).e(priority, this);
            if (this.f30005g) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void f(Data data) {
            if (data != null) {
                this.f30003e.f(data);
            } else {
                g();
            }
        }

        public final void g() {
            if (this.f30005g) {
                return;
            }
            if (this.f30001c < this.f29999a.size() - 1) {
                this.f30001c++;
                e(this.f30002d, this.f30003e);
            } else {
                C1540k.d(this.f30004f);
                this.f30003e.c(new GlideException("Fetch failed", new ArrayList(this.f30004f)));
            }
        }
    }

    public r(List<o<Model, Data>> list, I.e<List<Throwable>> eVar) {
        this.f29997a = list;
        this.f29998b = eVar;
    }

    @Override // d3.o
    public boolean a(Model model) {
        Iterator<o<Model, Data>> it = this.f29997a.iterator();
        while (it.hasNext()) {
            if (it.next().a(model)) {
                return true;
            }
        }
        return false;
    }

    @Override // d3.o
    public o.a<Data> b(Model model, int i10, int i11, X2.d dVar) {
        o.a<Data> b10;
        int size = this.f29997a.size();
        ArrayList arrayList = new ArrayList(size);
        X2.b bVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            o<Model, Data> oVar = this.f29997a.get(i12);
            if (oVar.a(model) && (b10 = oVar.b(model, i10, i11, dVar)) != null) {
                bVar = b10.f29990a;
                arrayList.add(b10.f29992c);
            }
        }
        if (arrayList.isEmpty() || bVar == null) {
            return null;
        }
        return new o.a<>(bVar, new a(arrayList, this.f29998b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f29997a.toArray()) + '}';
    }
}

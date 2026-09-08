package d3;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import d3.o;
import r3.C1508b;

/* compiled from: UnitModelLoader.java */
/* loaded from: classes.dex */
public class x<Model> implements o<Model, Model> {

    /* renamed from: a, reason: collision with root package name */
    public static final x<?> f30026a = new x<>();

    /* compiled from: UnitModelLoader.java */
    /* loaded from: classes.dex */
    public static class a<Model> implements p<Model, Model> {

        /* renamed from: a, reason: collision with root package name */
        public static final a<?> f30027a = new a<>();

        @Deprecated
        public a() {
        }

        public static <T> a<T> a() {
            return (a<T>) f30027a;
        }

        @Override // d3.p
        public o<Model, Model> d(s sVar) {
            return x.c();
        }
    }

    @Deprecated
    public x() {
    }

    public static <T> x<T> c() {
        return (x<T>) f30026a;
    }

    @Override // d3.o
    public boolean a(Model model) {
        return true;
    }

    @Override // d3.o
    public o.a<Model> b(Model model, int i10, int i11, X2.d dVar) {
        return new o.a<>(new C1508b(model), new b(model));
    }

    /* compiled from: UnitModelLoader.java */
    /* loaded from: classes.dex */
    public static class b<Model> implements com.bumptech.glide.load.data.d<Model> {

        /* renamed from: a, reason: collision with root package name */
        public final Model f30028a;

        public b(Model model) {
            this.f30028a = model;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<Model> a() {
            return (Class<Model>) this.f30028a.getClass();
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(Priority priority, d.a<? super Model> aVar) {
            aVar.f(this.f30028a);
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }
}

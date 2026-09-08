package d3;

import java.util.Collections;
import java.util.List;
import s3.C1540k;

/* compiled from: ModelLoader.java */
/* loaded from: classes.dex */
public interface o<Model, Data> {

    /* compiled from: ModelLoader.java */
    /* loaded from: classes.dex */
    public static class a<Data> {

        /* renamed from: a, reason: collision with root package name */
        public final X2.b f29990a;

        /* renamed from: b, reason: collision with root package name */
        public final List<X2.b> f29991b;

        /* renamed from: c, reason: collision with root package name */
        public final com.bumptech.glide.load.data.d<Data> f29992c;

        public a(X2.b bVar, com.bumptech.glide.load.data.d<Data> dVar) {
            this(bVar, Collections.emptyList(), dVar);
        }

        public a(X2.b bVar, List<X2.b> list, com.bumptech.glide.load.data.d<Data> dVar) {
            this.f29990a = (X2.b) C1540k.d(bVar);
            this.f29991b = (List) C1540k.d(list);
            this.f29992c = (com.bumptech.glide.load.data.d) C1540k.d(dVar);
        }
    }

    boolean a(Model model);

    a<Data> b(Model model, int i10, int i11, X2.d dVar);
}

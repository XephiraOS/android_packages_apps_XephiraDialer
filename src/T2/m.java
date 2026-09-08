package T2;

import T2.d;
import android.content.Context;
import java.io.File;

/* compiled from: Volley.java */
/* loaded from: classes.dex */
public class m {

    /* compiled from: Volley.java */
    /* loaded from: classes.dex */
    public class a implements d.c {

        /* renamed from: a, reason: collision with root package name */
        public File f3747a = null;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f3748b;

        public a(Context context) {
            this.f3748b = context;
        }

        @Override // T2.d.c
        public File get() {
            if (this.f3747a == null) {
                this.f3747a = new File(this.f3748b.getCacheDir(), "volley");
            }
            return this.f3747a;
        }
    }

    public static S2.f a(Context context, S2.d dVar) {
        S2.f fVar = new S2.f(new d(new a(context.getApplicationContext())), dVar);
        fVar.g();
        return fVar;
    }

    public static S2.f b(Context context, T2.a aVar) {
        b bVar;
        if (aVar == null) {
            bVar = new b(new h());
        } else {
            bVar = new b(aVar);
        }
        return a(context, bVar);
    }
}

package G;

import G.g;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import com.oplus.backup.sdk.common.utils.Constants;
import i0.C1089a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import p.C1422h;
import p.i;

/* compiled from: FontRequestWorker.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final C1422h<String, Typeface> f1051a = new C1422h<>(16);

    /* renamed from: b, reason: collision with root package name */
    public static final ExecutorService f1052b = h.a("fonts-androidx", 10, 10000);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f1053c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final i<String, ArrayList<I.a<e>>> f1054d = new i<>();

    /* compiled from: FontRequestWorker.java */
    /* loaded from: classes.dex */
    public class a implements Callable<e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1055a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f1056b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ G.e f1057c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f1058d;

        public a(String str, Context context, G.e eVar, int i10) {
            this.f1055a = str;
            this.f1056b = context;
            this.f1057c = eVar;
            this.f1058d = i10;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return f.c(this.f1055a, this.f1056b, List.of(this.f1057c), this.f1058d);
        }
    }

    /* compiled from: FontRequestWorker.java */
    /* loaded from: classes.dex */
    public class b implements I.a<e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ G.a f1059a;

        public b(G.a aVar) {
            this.f1059a = aVar;
        }

        @Override // I.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f1059a.b(eVar);
        }
    }

    /* compiled from: FontRequestWorker.java */
    /* loaded from: classes.dex */
    public class c implements Callable<e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1060a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f1061b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f1062c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f1063d;

        public c(String str, Context context, List list, int i10) {
            this.f1060a = str;
            this.f1061b = context;
            this.f1062c = list;
            this.f1063d = i10;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return f.c(this.f1060a, this.f1061b, this.f1062c, this.f1063d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    /* compiled from: FontRequestWorker.java */
    /* loaded from: classes.dex */
    public class d implements I.a<e> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1064a;

        public d(String str) {
            this.f1064a = str;
        }

        @Override // I.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (f.f1053c) {
                try {
                    i<String, ArrayList<I.a<e>>> iVar = f.f1054d;
                    ArrayList<I.a<e>> arrayList = iVar.get(this.f1064a);
                    if (arrayList == null) {
                        return;
                    }
                    iVar.remove(this.f1064a);
                    for (int i10 = 0; i10 < arrayList.size(); i10++) {
                        arrayList.get(i10).accept(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static String a(List<G.e> list, int i10) {
        StringBuilder sb = new StringBuilder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            sb.append(list.get(i11).d());
            sb.append("-");
            sb.append(i10);
            if (i11 < list.size() - 1) {
                sb.append(Constants.DataMigration.SPLIT_TAG);
            }
        }
        return sb.toString();
    }

    public static int b(g.a aVar) {
        int i10 = 1;
        if (aVar.e() != 0) {
            if (aVar.e() != 1) {
                return -3;
            }
            return -2;
        }
        g.b[] c10 = aVar.c();
        if (c10 != null && c10.length != 0) {
            i10 = 0;
            for (g.b bVar : c10) {
                int b10 = bVar.b();
                if (b10 != 0) {
                    if (b10 < 0) {
                        return -3;
                    }
                    return b10;
                }
            }
        }
        return i10;
    }

    public static e c(String str, Context context, List<G.e> list, int i10) {
        Typeface b10;
        C1089a.a("getFontSync");
        try {
            C1422h<String, Typeface> c1422h = f1051a;
            Typeface typeface = c1422h.get(str);
            if (typeface != null) {
                return new e(typeface);
            }
            g.a e10 = G.d.e(context, list, null);
            int b11 = b(e10);
            if (b11 != 0) {
                return new e(b11);
            }
            if (e10.f()) {
                b10 = B.e.c(context, null, e10.d(), i10);
            } else {
                b10 = B.e.b(context, null, e10.c(), i10);
            }
            if (b10 != null) {
                c1422h.put(str, b10);
                return new e(b10);
            }
            return new e(-3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        } finally {
            C1089a.b();
        }
    }

    public static Typeface d(Context context, List<G.e> list, int i10, Executor executor, G.a aVar) {
        String a10 = a(list, i10);
        Typeface typeface = f1051a.get(a10);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(aVar);
        synchronized (f1053c) {
            try {
                i<String, ArrayList<I.a<e>>> iVar = f1054d;
                ArrayList<I.a<e>> arrayList = iVar.get(a10);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList<I.a<e>> arrayList2 = new ArrayList<>();
                arrayList2.add(bVar);
                iVar.put(a10, arrayList2);
                c cVar = new c(a10, context, list, i10);
                if (executor == null) {
                    executor = f1052b;
                }
                h.c(executor, cVar, new d(a10));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Typeface e(Context context, G.e eVar, G.a aVar, int i10, int i11) {
        String a10 = a(List.of(eVar), i10);
        Typeface typeface = f1051a.get(a10);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        if (i11 == -1) {
            e c10 = c(a10, context, List.of(eVar), i10);
            aVar.b(c10);
            return c10.f1065a;
        }
        try {
            e eVar2 = (e) h.d(f1052b, new a(a10, context, eVar, i10), i11);
            aVar.b(eVar2);
            return eVar2.f1065a;
        } catch (InterruptedException unused) {
            aVar.b(new e(-3));
            return null;
        }
    }

    /* compiled from: FontRequestWorker.java */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final Typeface f1065a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1066b;

        public e(int i10) {
            this.f1065a = null;
            this.f1066b = i10;
        }

        public boolean a() {
            if (this.f1066b == 0) {
                return true;
            }
            return false;
        }

        public e(Typeface typeface) {
            this.f1065a = typeface;
            this.f1066b = 0;
        }
    }
}

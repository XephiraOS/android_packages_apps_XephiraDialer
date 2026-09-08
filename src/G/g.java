package G;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import java.util.Collections;
import java.util.List;

/* compiled from: FontsContractCompat.java */
/* loaded from: classes.dex */
public class g {

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f1069a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1070b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1071c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f1072d;

        /* renamed from: e, reason: collision with root package name */
        public final int f1073e;

        @Deprecated
        public b(Uri uri, int i10, int i11, boolean z10, int i12) {
            this.f1069a = (Uri) I.h.e(uri);
            this.f1070b = i10;
            this.f1071c = i11;
            this.f1072d = z10;
            this.f1073e = i12;
        }

        public static b a(Uri uri, int i10, int i11, boolean z10, int i12) {
            return new b(uri, i10, i11, z10, i12);
        }

        public int b() {
            return this.f1073e;
        }

        public int c() {
            return this.f1070b;
        }

        public Uri d() {
            return this.f1069a;
        }

        public int e() {
            return this.f1071c;
        }

        public boolean f() {
            return this.f1072d;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class c {
        public void a(int i10) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return B.e.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, e eVar) {
        return d.e(context, List.of(eVar), cancellationSignal);
    }

    public static Typeface c(Context context, List<e> list, int i10, boolean z10, int i11, Handler handler, c cVar) {
        G.a aVar = new G.a(cVar, h.b(handler));
        if (z10) {
            if (list.size() <= 1) {
                return f.e(context, list.get(0), aVar, i10, i11);
            }
            throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
        }
        return f.d(context, list, i10, null, aVar);
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f1067a;

        /* renamed from: b, reason: collision with root package name */
        public final List<b[]> f1068b;

        @Deprecated
        public a(int i10, b[] bVarArr) {
            this.f1067a = i10;
            this.f1068b = Collections.singletonList(bVarArr);
        }

        public static a a(int i10, List<b[]> list) {
            return new a(i10, list);
        }

        public static a b(int i10, b[] bVarArr) {
            return new a(i10, bVarArr);
        }

        public b[] c() {
            return this.f1068b.get(0);
        }

        public List<b[]> d() {
            return this.f1068b;
        }

        public int e() {
            return this.f1067a;
        }

        public boolean f() {
            if (this.f1068b.size() > 1) {
                return true;
            }
            return false;
        }

        public a(int i10, List<b[]> list) {
            this.f1067a = i10;
            this.f1068b = list;
        }
    }
}

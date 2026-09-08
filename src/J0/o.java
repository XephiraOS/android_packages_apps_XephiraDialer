package J0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* compiled from: Selection.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final String f1468a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f1469b;

    /* compiled from: Selection.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f1472a;

        public o a(String str) {
            return o.f(this.f1472a + " " + ((String) J0.b.b(str)), new String[0]);
        }

        public o b(String str, Object obj) {
            return o.f(this.f1472a + " " + ((String) J0.b.b(str)) + " ?", obj.toString());
        }

        public b(String str) {
            this.f1472a = (String) J0.b.b(str);
        }
    }

    public static a d() {
        return new a();
    }

    public static b e(String str) {
        return new b(str);
    }

    public static o f(String str, String... strArr) {
        List asList;
        if (strArr == null) {
            asList = Collections.emptyList();
        } else {
            asList = Arrays.asList(strArr);
        }
        return new a(str, asList).b();
    }

    public static String j(String str) {
        if (str.isEmpty()) {
            return "";
        }
        if (!str.startsWith("(")) {
            return "(" + str + ")";
        }
        boolean z10 = true;
        int i10 = 1;
        for (int i11 = 1; i11 < str.length() - 1; i11++) {
            char charAt = str.charAt(i11);
            if (charAt != '(') {
                if (charAt == ')' && i10 - 1 == 0) {
                    return "(" + str + ")";
                }
            } else {
                i10++;
            }
        }
        if (i10 != 1) {
            z10 = false;
        }
        J0.b.a(z10);
        return str;
    }

    public a c() {
        return new a();
    }

    public String g() {
        return this.f1468a;
    }

    public String[] h() {
        return this.f1469b;
    }

    public boolean i() {
        return this.f1468a.isEmpty();
    }

    public o(String str, String[] strArr) {
        this.f1468a = str;
        this.f1469b = strArr;
    }

    /* compiled from: Selection.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final StringBuilder f1470a;

        /* renamed from: b, reason: collision with root package name */
        public final List<String> f1471b;

        public static void c(String str, Collection<String> collection) {
            int size;
            boolean z10 = false;
            int i10 = 0;
            for (int i11 = 0; i11 < str.length(); i11++) {
                if (str.charAt(i11) == '?') {
                    i10++;
                }
            }
            if (collection == null) {
                size = 0;
            } else {
                size = collection.size();
            }
            if (i10 == size) {
                z10 = true;
            }
            J0.b.a(z10);
        }

        public a a(o oVar) {
            if (oVar.i()) {
                return this;
            }
            if (this.f1470a.length() > 0) {
                this.f1470a.append(" AND ");
            }
            this.f1470a.append(oVar.g());
            Collections.addAll(this.f1471b, oVar.h());
            return this;
        }

        public o b() {
            if (this.f1470a.length() != 0) {
                String j10 = o.j(this.f1470a.toString());
                List<String> list = this.f1471b;
                return new o(j10, (String[]) list.toArray(new String[list.size()]));
            }
            return new o("", new String[0]);
        }

        public a d(o oVar) {
            if (oVar.i()) {
                return this;
            }
            if (this.f1470a.length() > 0) {
                this.f1470a.append(" OR ");
            }
            this.f1470a.append(oVar.g());
            Collections.addAll(this.f1471b, oVar.h());
            return this;
        }

        public a() {
            this.f1470a = new StringBuilder();
            this.f1471b = new ArrayList();
        }

        public a(String str, Collection<String> collection) {
            StringBuilder sb = new StringBuilder();
            this.f1470a = sb;
            ArrayList arrayList = new ArrayList();
            this.f1471b = arrayList;
            if (str == null) {
                return;
            }
            c(str, collection);
            sb.append(o.j(str));
            if (collection != null) {
                arrayList.addAll(collection);
            }
        }

        public a(o oVar) {
            StringBuilder sb = new StringBuilder();
            this.f1470a = sb;
            ArrayList arrayList = new ArrayList();
            this.f1471b = arrayList;
            sb.append(oVar.g());
            Collections.addAll(arrayList, oVar.f1469b);
        }
    }
}

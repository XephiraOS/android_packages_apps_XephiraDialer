package R3;

import android.text.TextUtils;
import com.oplus.backup.sdk.common.utils.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: MeCard.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f3315a;

    /* renamed from: b, reason: collision with root package name */
    public String f3316b;

    /* renamed from: c, reason: collision with root package name */
    public List<String> f3317c;

    /* renamed from: d, reason: collision with root package name */
    public List<String> f3318d;

    /* renamed from: e, reason: collision with root package name */
    public List<String> f3319e;

    /* renamed from: f, reason: collision with root package name */
    public List<String> f3320f;

    /* renamed from: g, reason: collision with root package name */
    public String f3321g;

    /* renamed from: h, reason: collision with root package name */
    public String f3322h;

    /* renamed from: i, reason: collision with root package name */
    public String f3323i;

    /* renamed from: j, reason: collision with root package name */
    public String f3324j;

    /* renamed from: k, reason: collision with root package name */
    public StringBuilder f3325k;

    /* compiled from: MeCard.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f3326a;

        /* renamed from: b, reason: collision with root package name */
        public String f3327b;

        /* renamed from: c, reason: collision with root package name */
        public List<String> f3328c;

        /* renamed from: d, reason: collision with root package name */
        public List<String> f3329d;

        /* renamed from: e, reason: collision with root package name */
        public List<String> f3330e;

        /* renamed from: f, reason: collision with root package name */
        public List<String> f3331f;

        /* renamed from: g, reason: collision with root package name */
        public String f3332g;

        /* renamed from: h, reason: collision with root package name */
        public String f3333h;

        /* renamed from: i, reason: collision with root package name */
        public String f3334i;

        /* renamed from: j, reason: collision with root package name */
        public String f3335j;

        public a a(List<String> list, int i10) {
            return c(list, i10, this.f3328c);
        }

        public a b(List<String> list, int i10) {
            return c(g(list), i10, this.f3329d);
        }

        public final a c(List<String> list, int i10, List<String> list2) {
            if (list != null) {
                int i11 = 0;
                for (String str : list) {
                    if (i11 >= i10) {
                        break;
                    }
                    list2.add(str);
                    i11++;
                }
            }
            return this;
        }

        public a d(List<String> list, int i10) {
            return c(g(list), i10, this.f3330e);
        }

        public a e(List<String> list, int i10) {
            return c(list, i10, this.f3331f);
        }

        public b f() {
            return new b(this.f3326a, this.f3327b, this.f3328c, this.f3329d, this.f3330e, this.f3331f, this.f3332g, this.f3333h, this.f3334i, this.f3335j);
        }

        public final List<String> g(List<String> list) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                int indexOf = str.indexOf("<-&&&&&&&&&&->");
                if (indexOf != -1) {
                    arrayList.add(str.substring(0, indexOf));
                } else {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }

        public a h(String str) {
            this.f3326a = str;
            return this;
        }

        public a i(String str) {
            this.f3334i = str;
            return this;
        }

        public a j(String str) {
            this.f3335j = str;
            return this;
        }

        public a() {
            this.f3328c = new ArrayList();
            this.f3329d = new ArrayList();
            this.f3330e = new ArrayList();
            this.f3331f = new ArrayList();
        }
    }

    public static a e() {
        return new a();
    }

    public static b m(String str) {
        String str2;
        String str3;
        H7.b.b("MeCard", "after content");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        String str4 = "";
        String trim = str.trim().replaceAll("MECARD:", "").trim();
        ArrayList<String> arrayList8 = new ArrayList();
        StringBuilder sb = new StringBuilder();
        while (!trim.isEmpty()) {
            int indexOf = trim.indexOf(Constants.DataMigration.SPLIT_TAG);
            String substring = trim.substring(0, indexOf);
            trim = trim.substring(indexOf + 1);
            sb.append(substring);
            Iterator<String> it = d.f3336a.iterator();
            while (it.hasNext()) {
                if (trim.startsWith(it.next()) || "".equals(trim)) {
                    arrayList8.add(sb.toString());
                    sb = new StringBuilder();
                    H7.b.b("MeCard", "meCardContent start with keyword");
                    break;
                }
            }
            sb.append(Constants.DataMigration.SPLIT_TAG);
            H7.b.b("MeCard", "meCardContent start with ;");
        }
        for (String str5 : arrayList8) {
            if (str5.startsWith("N:")) {
                H7.b.b("MeCard", "add name");
                arrayList.add(str5.replaceAll("N:", ""));
            } else if (str5.startsWith("TEL:")) {
                H7.b.b("MeCard", "add phone");
                arrayList2.add(str5.replaceAll("TEL:", ""));
            } else if (str5.startsWith("EMAIL:")) {
                H7.b.b("MeCard", "add email");
                arrayList3.add(str5.replaceAll("EMAIL:", ""));
            } else if (str5.startsWith("ADR:")) {
                H7.b.b("MeCard", "add address");
                arrayList4.add(str5.replaceAll("ADR:", ""));
            } else if (str5.startsWith("ORG:")) {
                H7.b.b("MeCard", "add org");
                arrayList5.add(str5.replaceAll("ORG:", ""));
            } else if (str5.startsWith("TIL:")) {
                H7.b.b("MeCard", "add title");
                arrayList6.add(str5.replaceAll("TIL:", ""));
            } else if (str5.startsWith("URL:")) {
                H7.b.b("MeCard", "add url");
                arrayList7.add(str5.replaceAll("URL:", ""));
            }
        }
        H7.b.b("MeCard", "parseContent success");
        a e10 = e();
        if (arrayList.size() <= 0) {
            str2 = "";
        } else {
            str2 = (String) arrayList.get(0);
        }
        a a10 = e10.h(str2).d(arrayList2, arrayList2.size()).b(arrayList3, arrayList3.size()).e(arrayList7, arrayList7.size()).a(arrayList4, arrayList4.size());
        if (arrayList5.size() <= 0) {
            str3 = "";
        } else {
            str3 = (String) arrayList5.get(0);
        }
        a i10 = a10.i(str3);
        if (arrayList6.size() > 0) {
            str4 = (String) arrayList6.get(0);
        }
        return i10.j(str4).f();
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = this.f3325k;
            sb.append(str2);
            sb.append(str);
            sb.append(Constants.DataMigration.SPLIT_TAG);
        }
    }

    public final void b(List<String> list, String str) {
        if (list != null && list.size() != 0) {
            for (String str2 : list) {
                StringBuilder sb = this.f3325k;
                sb.append(str);
                sb.append(str2);
                sb.append(Constants.DataMigration.SPLIT_TAG);
            }
        }
    }

    public final void c() {
        if (!TextUtils.isEmpty(this.f3315a)) {
            if (!TextUtils.isEmpty(this.f3316b)) {
                StringBuilder sb = this.f3325k;
                sb.append("N:");
                sb.append(this.f3316b);
                sb.append(",");
                sb.append(this.f3315a);
                sb.append(Constants.DataMigration.SPLIT_TAG);
                return;
            }
            StringBuilder sb2 = this.f3325k;
            sb2.append("N:");
            sb2.append(this.f3315a);
            sb2.append(Constants.DataMigration.SPLIT_TAG);
        }
    }

    public String d() {
        StringBuilder sb = new StringBuilder();
        this.f3325k = sb;
        sb.append("MECARD:");
        c();
        b(this.f3319e, "TEL:");
        b(this.f3318d, "EMAIL:");
        b(this.f3317c, "ADR:");
        b(this.f3320f, "URL:");
        a(this.f3321g, "NOTE:");
        a(this.f3322h, "DAY:");
        a(this.f3323i, "ORG:");
        a(this.f3324j, "TIL:");
        return this.f3325k.toString();
    }

    public List<String> f() {
        return this.f3317c;
    }

    public List<String> g() {
        return this.f3318d;
    }

    public String h() {
        return this.f3315a;
    }

    public String i() {
        return this.f3323i;
    }

    public List<String> j() {
        return this.f3319e;
    }

    public String k() {
        return this.f3324j;
    }

    public List<String> l() {
        return this.f3320f;
    }

    public b(String str, String str2, List<String> list, List<String> list2, List<String> list3, List<String> list4, String str3, String str4, String str5, String str6) {
        this.f3315a = str;
        this.f3316b = str2;
        this.f3317c = list;
        this.f3318d = list2;
        this.f3319e = list3;
        this.f3320f = list4;
        this.f3321g = str3;
        this.f3322h = str4;
        this.f3323i = str5;
        this.f3324j = str6;
    }
}

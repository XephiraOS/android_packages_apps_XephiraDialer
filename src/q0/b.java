package Q0;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: CallLogInfo.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: g, reason: collision with root package name */
    public static final a f3095g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public String f3096a;

    /* renamed from: b, reason: collision with root package name */
    public String f3097b;

    /* renamed from: c, reason: collision with root package name */
    public String f3098c;

    /* renamed from: d, reason: collision with root package name */
    public String f3099d;

    /* renamed from: e, reason: collision with root package name */
    public String f3100e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList<d> f3101f;

    /* compiled from: CallLogInfo.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final b a(Cursor cursor, int i10, Integer num, Integer num2, Integer num3, Integer num4) {
            i.f(cursor, "cursor");
            b bVar = new b(null, null, null, null, null, null, 63, null);
            bVar.k(cursor.getString(i10));
            if (num != null) {
                bVar.j(cursor.getString(num.intValue()));
            }
            if (num2 != null) {
                bVar.i(cursor.getString(num2.intValue()));
            }
            if (num3 != null) {
                bVar.g(cursor.getString(num3.intValue()));
            }
            if (num4 != null) {
                bVar.h(cursor.getString(num4.intValue()));
            }
            return bVar;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public b() {
        this(null, null, null, null, null, null, 63, null);
    }

    public final ArrayList<d> a() {
        return this.f3101f;
    }

    public final String b() {
        return this.f3099d;
    }

    public final String c() {
        return this.f3097b;
    }

    public final String d() {
        return this.f3096a;
    }

    public final boolean e() {
        Iterator<d> it = this.f3101f.iterator();
        while (it.hasNext()) {
            if (it.next().e()) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (i.b(this.f3096a, bVar.f3096a) && i.b(this.f3097b, bVar.f3097b) && i.b(this.f3098c, bVar.f3098c) && i.b(this.f3099d, bVar.f3099d) && i.b(this.f3100e, bVar.f3100e) && i.b(this.f3101f, bVar.f3101f)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        Iterator<d> it = this.f3101f.iterator();
        while (it.hasNext()) {
            if (it.next().d()) {
                return true;
            }
        }
        return false;
    }

    public final void g(String str) {
        this.f3099d = str;
    }

    public final void h(String str) {
        this.f3100e = str;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        String str = this.f3096a;
        int i10 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i11 = hashCode * 31;
        String str2 = this.f3097b;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        String str3 = this.f3098c;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        String str4 = this.f3099d;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        String str5 = this.f3100e;
        if (str5 != null) {
            i10 = str5.hashCode();
        }
        return ((i14 + i10) * 31) + this.f3101f.hashCode();
    }

    public final void i(String str) {
        this.f3098c = str;
    }

    public final void j(String str) {
        this.f3097b = str;
    }

    public final void k(String str) {
        this.f3096a = str;
    }

    public String toString() {
        return "CallLogInfo(number=" + this.f3096a + ", normalizedNumber=" + this.f3097b + ", name=" + this.f3098c + ", countryIso=" + this.f3099d + ", location=" + this.f3100e + ", calls=" + this.f3101f + ")";
    }

    public b(String str, String str2, String str3, String str4, String str5, ArrayList<d> calls) {
        i.f(calls, "calls");
        this.f3096a = str;
        this.f3097b = str2;
        this.f3098c = str3;
        this.f3099d = str4;
        this.f3100e = str5;
        this.f3101f = calls;
    }

    public /* synthetic */ b(String str, String str2, String str3, String str4, String str5, ArrayList arrayList, int i10, f fVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4, (i10 & 16) != 0 ? "" : str5, (i10 & 32) != 0 ? new ArrayList() : arrayList);
    }
}

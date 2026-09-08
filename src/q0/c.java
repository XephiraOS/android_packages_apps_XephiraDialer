package Q0;

import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: CallRecording.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: l, reason: collision with root package name */
    public static final a f3102l = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f3103a;

    /* renamed from: b, reason: collision with root package name */
    public String f3104b;

    /* renamed from: c, reason: collision with root package name */
    public long f3105c;

    /* renamed from: d, reason: collision with root package name */
    public String f3106d;

    /* renamed from: e, reason: collision with root package name */
    public int f3107e;

    /* renamed from: f, reason: collision with root package name */
    public String f3108f;

    /* renamed from: g, reason: collision with root package name */
    public String f3109g;

    /* renamed from: h, reason: collision with root package name */
    public long f3110h;

    /* renamed from: i, reason: collision with root package name */
    public long f3111i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3112j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3113k;

    /* compiled from: CallRecording.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final c a(Cursor cursor, boolean z10) {
            c cVar;
            i.f(cursor, "cursor");
            if (z10) {
                cVar = new c(cursor.getLong(0), cursor.getString(1), cursor.getLong(2), cursor.getString(3), cursor.getInt(4), cursor.getString(5), cursor.getString(6), cursor.getLong(7), cursor.getLong(8));
            } else {
                cVar = new c(cursor.getLong(0), cursor.getString(1), cursor.getLong(2), null, 0, null, null, 0L, 0L, 504, null);
            }
            c cVar2 = cVar;
            cVar2.o(z10);
            cVar2.n(z10);
            return cVar2;
        }

        public final ArrayList<c> b(Context context, boolean z10) {
            i.f(context, "context");
            return c(context, z10, null, null);
        }

        public final ArrayList<c> c(Context context, boolean z10, String str, String[] strArr) {
            Object b10;
            String[] strArr2;
            i.f(context, "context");
            ArrayList<c> arrayList = new ArrayList<>();
            try {
                Result.a aVar = Result.f34166a;
                long currentTimeMillis = System.currentTimeMillis();
                if (z10) {
                    strArr2 = com.android.contacts.framework.baseui.calllog.a.f15770e;
                } else {
                    strArr2 = com.android.contacts.framework.baseui.calllog.a.f15769d;
                }
                Cursor it = context.getContentResolver().query(com.android.contacts.framework.baseui.calllog.a.f15766a, strArr2, str, strArr, null);
                if (it != null) {
                    while (it.moveToNext()) {
                        try {
                            a aVar2 = c.f3102l;
                            i.e(it, "it");
                            arrayList.add(aVar2.a(it, z10));
                        } finally {
                        }
                    }
                    q qVar = q.f35511a;
                    kotlin.io.a.a(it, null);
                }
                H7.b.e("CallRecording", "queryCallRecordings: fullInfo: " + z10 + ", count: " + arrayList.size() + ", take: " + (System.currentTimeMillis() - currentTimeMillis));
                b10 = Result.b(q.f35511a);
            } catch (Throwable th) {
                Result.a aVar3 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("CallRecording", "queryCallRecordings: exception: " + d10);
            }
            return arrayList;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public c(long j10, String str, long j11, String str2, int i10, String str3, String str4, long j12, long j13) {
        this.f3103a = j10;
        this.f3104b = str;
        this.f3105c = j11;
        this.f3106d = str2;
        this.f3107e = i10;
        this.f3108f = str3;
        this.f3109g = str4;
        this.f3110h = j12;
        this.f3111i = j13;
    }

    public static final c a(Cursor cursor, boolean z10) {
        return f3102l.a(cursor, z10);
    }

    public static final ArrayList<c> m(Context context, boolean z10, String str, String[] strArr) {
        return f3102l.c(context, z10, str, strArr);
    }

    public final long b() {
        return this.f3105c;
    }

    public final String c() {
        return this.f3108f;
    }

    public final String d() {
        return this.f3109g;
    }

    public final long e() {
        return this.f3110h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f3103a == cVar.f3103a && i.b(this.f3104b, cVar.f3104b) && this.f3105c == cVar.f3105c && i.b(this.f3106d, cVar.f3106d) && this.f3107e == cVar.f3107e && i.b(this.f3108f, cVar.f3108f) && i.b(this.f3109g, cVar.f3109g) && this.f3110h == cVar.f3110h && this.f3111i == cVar.f3111i) {
            return true;
        }
        return false;
    }

    public final long f() {
        return this.f3111i;
    }

    public final long g() {
        return this.f3103a;
    }

    public final String h() {
        return this.f3104b;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4 = Long.hashCode(this.f3103a) * 31;
        String str = this.f3104b;
        int i10 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode5 = (((hashCode4 + hashCode) * 31) + Long.hashCode(this.f3105c)) * 31;
        String str2 = this.f3106d;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int hashCode6 = (((hashCode5 + hashCode2) * 31) + Integer.hashCode(this.f3107e)) * 31;
        String str3 = this.f3108f;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i11 = (hashCode6 + hashCode3) * 31;
        String str4 = this.f3109g;
        if (str4 != null) {
            i10 = str4.hashCode();
        }
        return ((((i11 + i10) * 31) + Long.hashCode(this.f3110h)) * 31) + Long.hashCode(this.f3111i);
    }

    public final String i() {
        return this.f3106d;
    }

    public final int j() {
        return this.f3107e;
    }

    public final boolean k() {
        return this.f3113k;
    }

    public final boolean l() {
        return this.f3112j;
    }

    public final void n(boolean z10) {
        this.f3113k = z10;
    }

    public final void o(boolean z10) {
        this.f3112j = z10;
    }

    public String toString() {
        return "CallRecording(id=" + this.f3103a + ", number=" + this.f3104b + ", callLogMapping=" + this.f3105c + ", path=" + this.f3106d + ", secRecord=" + this.f3107e + ", data1=" + this.f3108f + ", data2=" + this.f3109g + ", data3=" + this.f3110h + ", data4=" + this.f3111i + ")";
    }

    public /* synthetic */ c(long j10, String str, long j11, String str2, int i10, String str3, String str4, long j12, long j13, int i11, f fVar) {
        this(j10, str, (i11 & 4) != 0 ? 0L : j11, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? 0 : i10, (i11 & 32) != 0 ? null : str3, (i11 & 64) != 0 ? null : str4, (i11 & 128) != 0 ? 0L : j12, (i11 & 256) != 0 ? 0L : j13);
    }
}

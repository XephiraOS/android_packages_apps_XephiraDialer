package Q0;

import android.database.Cursor;
import android.text.TextUtils;
import com.android.incallui.OplusPhoneCapabilities;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: SingleCall.kt */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: f, reason: collision with root package name */
    public static final a f3114f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f3115a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3116b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3117c;

    /* renamed from: d, reason: collision with root package name */
    public long f3118d;

    /* renamed from: e, reason: collision with root package name */
    public String f3119e;

    /* compiled from: SingleCall.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final d a(Cursor cursor, int i10, int i11, int i12, int i13, Integer num) {
            i.f(cursor, "cursor");
            d dVar = new d(cursor.getLong(i10), cursor.getLong(i11), cursor.getInt(i12), cursor.getLong(i13), null, 16, null);
            if (num != null) {
                dVar.g(cursor.getString(num.intValue()));
            }
            return dVar;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public d(long j10, long j11, int i10, long j12, String str) {
        this.f3115a = j10;
        this.f3116b = j11;
        this.f3117c = i10;
        this.f3118d = j12;
        this.f3119e = str;
    }

    public final long a() {
        return this.f3116b;
    }

    public final long b() {
        return this.f3115a;
    }

    public final String c() {
        return this.f3119e;
    }

    public final boolean d() {
        if ((((int) this.f3118d) & OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE) == 268435456 && !TextUtils.isEmpty(this.f3119e)) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        if ((((int) this.f3118d) & OplusPhoneCapabilities.MTK_CAPABILITY_VIDEO_RINGTONE) == 536870912 && !TextUtils.isEmpty(this.f3119e)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f3115a == dVar.f3115a && this.f3116b == dVar.f3116b && this.f3117c == dVar.f3117c && this.f3118d == dVar.f3118d && i.b(this.f3119e, dVar.f3119e)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        if (this.f3117c == 3) {
            return true;
        }
        return false;
    }

    public final void g(String str) {
        this.f3119e = str;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((Long.hashCode(this.f3115a) * 31) + Long.hashCode(this.f3116b)) * 31) + Integer.hashCode(this.f3117c)) * 31) + Long.hashCode(this.f3118d)) * 31;
        String str = this.f3119e;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public String toString() {
        return "SingleCall(id=" + this.f3115a + ", date=" + this.f3116b + ", type=" + this.f3117c + ", features=" + this.f3118d + ", virtualCallId=" + this.f3119e + ")";
    }

    public /* synthetic */ d(long j10, long j11, int i10, long j12, String str, int i11, f fVar) {
        this(j10, j11, i10, j12, (i11 & 16) != 0 ? null : str);
    }
}

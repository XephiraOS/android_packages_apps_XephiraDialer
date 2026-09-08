package F0;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: RequestData.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public String f796a;

    /* renamed from: b, reason: collision with root package name */
    public Integer f797b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f798c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f799d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f800e;

    /* renamed from: f, reason: collision with root package name */
    public Long f801f;

    /* renamed from: g, reason: collision with root package name */
    public Integer f802g;

    /* renamed from: h, reason: collision with root package name */
    public Integer f803h;

    /* renamed from: i, reason: collision with root package name */
    public Integer f804i;

    /* renamed from: j, reason: collision with root package name */
    public Long f805j;

    /* renamed from: k, reason: collision with root package name */
    public Long f806k;

    /* renamed from: l, reason: collision with root package name */
    public Integer f807l;

    /* compiled from: RequestData.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final c f808a = new c(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);

        public final c a() {
            return this.f808a;
        }

        public final a b(Boolean bool) {
            this.f808a.a(bool);
            return this;
        }

        public final a c(Integer num) {
            this.f808a.b(num);
            return this;
        }

        public final a d(Integer num) {
            this.f808a.c(num);
            return this;
        }

        public final a e(Long l10) {
            this.f808a.d(l10);
            return this;
        }

        public final a f(Boolean bool) {
            this.f808a.e(bool);
            return this;
        }

        public final a g(Boolean bool) {
            this.f808a.f(bool);
            return this;
        }

        public final a h(String str) {
            this.f808a.g(str);
            return this;
        }

        public final a i(Long l10) {
            this.f808a.h(l10);
            return this;
        }

        public final a j(Integer num) {
            this.f808a.i(num);
            return this;
        }

        public final a k(Integer num) {
            this.f808a.j(num);
            return this;
        }

        public final a l(Integer num) {
            this.f808a.k(num);
            return this;
        }

        public final a m(Long l10) {
            this.f808a.l(l10);
            return this;
        }
    }

    public c() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public final void a(Boolean bool) {
        this.f800e = bool;
    }

    public final void b(Integer num) {
        this.f807l = num;
    }

    public final void c(Integer num) {
        this.f802g = num;
    }

    public final void d(Long l10) {
        this.f805j = l10;
    }

    public final void e(Boolean bool) {
        this.f799d = bool;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (i.b(this.f796a, cVar.f796a) && i.b(this.f797b, cVar.f797b) && i.b(this.f798c, cVar.f798c) && i.b(this.f799d, cVar.f799d) && i.b(this.f800e, cVar.f800e) && i.b(this.f801f, cVar.f801f) && i.b(this.f802g, cVar.f802g) && i.b(this.f803h, cVar.f803h) && i.b(this.f804i, cVar.f804i) && i.b(this.f805j, cVar.f805j) && i.b(this.f806k, cVar.f806k) && i.b(this.f807l, cVar.f807l)) {
            return true;
        }
        return false;
    }

    public final void f(Boolean bool) {
        this.f798c = bool;
    }

    public final void g(String str) {
        this.f796a = str;
    }

    public final void h(Long l10) {
        this.f806k = l10;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int hashCode11;
        String str = this.f796a;
        int i10 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i11 = hashCode * 31;
        Integer num = this.f797b;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        Boolean bool = this.f798c;
        if (bool == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = bool.hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        Boolean bool2 = this.f799d;
        if (bool2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = bool2.hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        Boolean bool3 = this.f800e;
        if (bool3 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = bool3.hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        Long l10 = this.f801f;
        if (l10 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = l10.hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        Integer num2 = this.f802g;
        if (num2 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = num2.hashCode();
        }
        int i17 = (i16 + hashCode7) * 31;
        Integer num3 = this.f803h;
        if (num3 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = num3.hashCode();
        }
        int i18 = (i17 + hashCode8) * 31;
        Integer num4 = this.f804i;
        if (num4 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = num4.hashCode();
        }
        int i19 = (i18 + hashCode9) * 31;
        Long l11 = this.f805j;
        if (l11 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = l11.hashCode();
        }
        int i20 = (i19 + hashCode10) * 31;
        Long l12 = this.f806k;
        if (l12 == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = l12.hashCode();
        }
        int i21 = (i20 + hashCode11) * 31;
        Integer num5 = this.f807l;
        if (num5 != null) {
            i10 = num5.hashCode();
        }
        return i21 + i10;
    }

    public final void i(Integer num) {
        this.f803h = num;
    }

    public final void j(Integer num) {
        this.f804i = num;
    }

    public final void k(Integer num) {
        this.f797b = num;
    }

    public final void l(Long l10) {
        this.f801f = l10;
    }

    public String toString() {
        return "RequestData(number=" + this.f796a + ", slotId=" + this.f797b + ", netAccessable=" + this.f798c + ", fromCallLog=" + this.f799d + ", isBlockedCallType=" + this.f800e + ", timeout=" + this.f801f + ", dataType=" + this.f802g + ", ringTime=" + this.f803h + ", simId=" + this.f804i + ", duration=" + this.f805j + ", recordTime=" + this.f806k + ", callType=" + this.f807l + ")";
    }

    public c(String str, Integer num, Boolean bool, Boolean bool2, Boolean bool3, Long l10, Integer num2, Integer num3, Integer num4, Long l11, Long l12, Integer num5) {
        this.f796a = str;
        this.f797b = num;
        this.f798c = bool;
        this.f799d = bool2;
        this.f800e = bool3;
        this.f801f = l10;
        this.f802g = num2;
        this.f803h = num3;
        this.f804i = num4;
        this.f805j = l11;
        this.f806k = l12;
        this.f807l = num5;
    }

    public /* synthetic */ c(String str, Integer num, Boolean bool, Boolean bool2, Boolean bool3, Long l10, Integer num2, Integer num3, Integer num4, Long l11, Long l12, Integer num5, int i10, f fVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : bool, (i10 & 8) != 0 ? null : bool2, (i10 & 16) != 0 ? null : bool3, (i10 & 32) != 0 ? null : l10, (i10 & 64) != 0 ? null : num2, (i10 & 128) != 0 ? null : num3, (i10 & 256) != 0 ? null : num4, (i10 & 512) != 0 ? null : l11, (i10 & 1024) != 0 ? null : l12, (i10 & 2048) != 0 ? null : num5);
    }
}

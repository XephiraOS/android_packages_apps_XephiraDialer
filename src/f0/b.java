package F0;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: MarkNumberData.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public String f790a;

    /* renamed from: b, reason: collision with root package name */
    public String f791b;

    /* renamed from: c, reason: collision with root package name */
    public Integer f792c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f793d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f794e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f795f;

    public b() {
        this(null, null, null, null, null, null, 63, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (i.b(this.f790a, bVar.f790a) && i.b(this.f791b, bVar.f791b) && i.b(this.f792c, bVar.f792c) && i.b(this.f793d, bVar.f793d) && i.b(this.f794e, bVar.f794e) && i.b(this.f795f, bVar.f795f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        String str = this.f790a;
        int i10 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i11 = hashCode * 31;
        String str2 = this.f791b;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        Integer num = this.f792c;
        if (num == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = num.hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        Integer num2 = this.f793d;
        if (num2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = num2.hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        Integer num3 = this.f794e;
        if (num3 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = num3.hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        Boolean bool = this.f795f;
        if (bool != null) {
            i10 = bool.hashCode();
        }
        return i15 + i10;
    }

    public String toString() {
        return "MarkNumberData(telNum=" + this.f790a + ", mark=" + this.f791b + ", dataType=" + this.f792c + ", optType=" + this.f793d + ", iType=" + this.f794e + ", isBlockedCallType=" + this.f795f + ")";
    }

    public b(String str, String str2, Integer num, Integer num2, Integer num3, Boolean bool) {
        this.f790a = str;
        this.f791b = str2;
        this.f792c = num;
        this.f793d = num2;
        this.f794e = num3;
        this.f795f = bool;
    }

    public /* synthetic */ b(String str, String str2, Integer num, Integer num2, Integer num3, Boolean bool, int i10, f fVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : num2, (i10 & 16) != 0 ? null : num3, (i10 & 32) != 0 ? null : bool);
    }
}

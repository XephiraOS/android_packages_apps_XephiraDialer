package S9;

import com.heytap.accessory.constant.FastPairConstants;
import org.apache.james.mime4j.util.MimeUtil;

/* compiled from: RawField.java */
/* loaded from: classes4.dex */
public final class r implements i {

    /* renamed from: a, reason: collision with root package name */
    public final T9.b f3677a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3678b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3679c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3680d;

    public r(T9.b bVar, int i10, String str, String str2) {
        if (str != null) {
            this.f3677a = bVar;
            this.f3678b = i10;
            this.f3679c = str.trim();
            this.f3680d = str2;
            return;
        }
        throw new IllegalArgumentException("Field may not be null");
    }

    @Override // S9.i
    public T9.b a() {
        return this.f3677a;
    }

    @Override // S9.i
    public String b() {
        String str = this.f3680d;
        if (str != null) {
            return str;
        }
        T9.b bVar = this.f3677a;
        if (bVar != null) {
            int length = bVar.length();
            int i10 = this.f3678b;
            int i11 = i10 + 1;
            int i12 = i10 + 2;
            if (length > i12 && T9.c.a((char) (this.f3677a.byteAt(i11) & FastPairConstants.GO_INTENT_NOT_SET))) {
                i11 = i12;
            }
            return MimeUtil.f(T9.d.b(this.f3677a, i11, length - i11));
        }
        return null;
    }

    public int c() {
        return this.f3678b;
    }

    @Override // S9.i
    public String getName() {
        return this.f3679c;
    }

    public String toString() {
        T9.b bVar = this.f3677a;
        if (bVar != null) {
            return T9.d.a(bVar);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3679c);
        sb.append(": ");
        String str = this.f3680d;
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }

    public r(String str, String str2) {
        this(null, -1, str, str2);
    }
}

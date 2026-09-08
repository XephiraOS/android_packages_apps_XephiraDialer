package S9;

import java.util.BitSet;
import org.apache.james.mime4j.MimeException;
import org.apache.james.mime4j.io.MaxHeaderLengthLimitException;

/* compiled from: DefaultFieldBuilder.java */
/* loaded from: classes4.dex */
public class e implements j {

    /* renamed from: c, reason: collision with root package name */
    public static final BitSet f3615c = new BitSet();

    /* renamed from: a, reason: collision with root package name */
    public final T9.a f3616a = new T9.a(1024);

    /* renamed from: b, reason: collision with root package name */
    public final int f3617b;

    static {
        for (int i10 = 33; i10 <= 57; i10++) {
            f3615c.set(i10);
        }
        for (int i11 = 59; i11 <= 126; i11++) {
            f3615c.set(i11);
        }
    }

    public e(int i10) {
        this.f3617b = i10;
    }

    @Override // S9.j
    public T9.a a() {
        return this.f3616a;
    }

    @Override // S9.j
    public void b(T9.a aVar) {
        if (aVar == null) {
            return;
        }
        int length = aVar.length();
        if (this.f3617b > 0 && this.f3616a.length() + length >= this.f3617b) {
            throw new MaxHeaderLengthLimitException("Maximum header length limit exceeded");
        }
        this.f3616a.b(aVar.c(), 0, aVar.length());
    }

    @Override // S9.j
    public r build() {
        int length = this.f3616a.length();
        if (length > 0) {
            if (this.f3616a.byteAt(length - 1) == 10) {
                length--;
            }
            if (this.f3616a.byteAt(length - 1) == 13) {
                length--;
            }
        }
        r d10 = s.f3684d.d(new T9.a(this.f3616a.c(), length, false));
        String name = d10.getName();
        for (int i10 = 0; i10 < name.length(); i10++) {
            if (!f3615c.get(name.charAt(i10))) {
                throw new MimeException("MIME field name contains illegal characters: " + d10.getName());
            }
        }
        return d10;
    }

    @Override // S9.j
    public void reset() {
        this.f3616a.d();
    }
}

package S9;

import com.heytap.accessory.constant.FastPairConstants;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.apache.james.mime4j.MimeException;

/* compiled from: RawFieldParser.java */
/* loaded from: classes4.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public static final BitSet f3681a = a(58);

    /* renamed from: b, reason: collision with root package name */
    public static final BitSet f3682b = a(61, 59);

    /* renamed from: c, reason: collision with root package name */
    public static final BitSet f3683c = a(59);

    /* renamed from: d, reason: collision with root package name */
    public static final s f3684d = new s();

    public static BitSet a(int... iArr) {
        BitSet bitSet = new BitSet(iArr.length);
        for (int i10 : iArr) {
            bitSet.set(i10);
        }
        return bitSet;
    }

    public void b(T9.b bVar, o oVar, BitSet bitSet, StringBuilder sb) {
        int b10 = oVar.b();
        int c10 = oVar.c();
        for (int b11 = oVar.b(); b11 < c10; b11++) {
            char byteAt = (char) (bVar.byteAt(b11) & FastPairConstants.GO_INTENT_NOT_SET);
            if ((bitSet != null && bitSet.get(byteAt)) || T9.c.a(byteAt) || byteAt == '(') {
                break;
            }
            b10++;
            sb.append(byteAt);
        }
        oVar.d(b10);
    }

    public void c(T9.b bVar, o oVar, StringBuilder sb) {
        if (oVar.a()) {
            return;
        }
        int b10 = oVar.b();
        int b11 = oVar.b();
        int c10 = oVar.c();
        if (((char) (bVar.byteAt(b10) & FastPairConstants.GO_INTENT_NOT_SET)) != '\"') {
            return;
        }
        int i10 = b10 + 1;
        int i11 = b11 + 1;
        boolean z10 = false;
        while (true) {
            if (i11 >= c10) {
                break;
            }
            char byteAt = (char) (bVar.byteAt(i11) & FastPairConstants.GO_INTENT_NOT_SET);
            if (z10) {
                if (byteAt != '\"' && byteAt != '\\') {
                    sb.append('\\');
                }
                sb.append(byteAt);
                z10 = false;
            } else if (byteAt == '\"') {
                i10++;
                break;
            } else if (byteAt == '\\') {
                z10 = true;
            } else if (byteAt != '\r' && byteAt != '\n') {
                sb.append(byteAt);
            }
            i11++;
            i10++;
        }
        oVar.d(i10);
    }

    public r d(T9.b bVar) {
        if (bVar == null) {
            return null;
        }
        o oVar = new o(0, bVar.length());
        String i10 = i(bVar, oVar, f3681a);
        if (!oVar.a()) {
            return new r(bVar, oVar.b(), i10, null);
        }
        throw new MimeException("Invalid MIME field: no name/value separator found: " + bVar.toString());
    }

    public n e(T9.b bVar, o oVar) {
        String i10 = i(bVar, oVar, f3682b);
        if (oVar.a()) {
            return new n(i10, null);
        }
        byte byteAt = bVar.byteAt(oVar.b());
        oVar.d(oVar.b() + 1);
        if (byteAt == 59) {
            return new n(i10, null);
        }
        String j10 = j(bVar, oVar, f3683c);
        if (!oVar.a()) {
            oVar.d(oVar.b() + 1);
        }
        return new n(i10, j10);
    }

    public List<n> f(T9.b bVar, o oVar) {
        ArrayList arrayList = new ArrayList();
        l(bVar, oVar);
        while (!oVar.a()) {
            arrayList.add(e(bVar, oVar));
        }
        return arrayList;
    }

    public p g(r rVar) {
        T9.b a10 = rVar.a();
        int c10 = rVar.c() + 1;
        if (a10 == null) {
            String b10 = rVar.b();
            if (b10 == null) {
                return new p("", null);
            }
            a10 = T9.d.c(b10);
            c10 = 0;
        }
        return h(a10, new o(c10, a10.length()));
    }

    public p h(T9.b bVar, o oVar) {
        String i10 = i(bVar, oVar, f3683c);
        if (oVar.a()) {
            return new p(i10, new ArrayList());
        }
        oVar.d(oVar.b() + 1);
        return new p(i10, f(bVar, oVar));
    }

    public String i(T9.b bVar, o oVar, BitSet bitSet) {
        StringBuilder sb = new StringBuilder();
        loop0: while (true) {
            boolean z10 = false;
            while (!oVar.a()) {
                char byteAt = (char) (bVar.byteAt(oVar.b()) & FastPairConstants.GO_INTENT_NOT_SET);
                if (bitSet != null && bitSet.get(byteAt)) {
                    break loop0;
                }
                if (T9.c.a(byteAt)) {
                    l(bVar, oVar);
                    z10 = true;
                } else if (byteAt == '(') {
                    k(bVar, oVar);
                } else {
                    if (sb.length() > 0 && z10) {
                        sb.append(' ');
                    }
                    b(bVar, oVar, bitSet, sb);
                }
            }
            break loop0;
        }
        return sb.toString();
    }

    public String j(T9.b bVar, o oVar, BitSet bitSet) {
        StringBuilder sb = new StringBuilder();
        loop0: while (true) {
            boolean z10 = false;
            while (!oVar.a()) {
                char byteAt = (char) (bVar.byteAt(oVar.b()) & FastPairConstants.GO_INTENT_NOT_SET);
                if (bitSet != null && bitSet.get(byteAt)) {
                    break loop0;
                }
                if (T9.c.a(byteAt)) {
                    l(bVar, oVar);
                    z10 = true;
                } else if (byteAt == '(') {
                    k(bVar, oVar);
                } else if (byteAt == '\"') {
                    if (sb.length() > 0 && z10) {
                        sb.append(' ');
                    }
                    c(bVar, oVar, sb);
                } else {
                    if (sb.length() > 0 && z10) {
                        sb.append(' ');
                    }
                    b(bVar, oVar, bitSet, sb);
                }
            }
            break loop0;
        }
        return sb.toString();
    }

    public void k(T9.b bVar, o oVar) {
        if (oVar.a()) {
            return;
        }
        int b10 = oVar.b();
        int b11 = oVar.b();
        int c10 = oVar.c();
        if (((char) (bVar.byteAt(b10) & FastPairConstants.GO_INTENT_NOT_SET)) != '(') {
            return;
        }
        int i10 = b10 + 1;
        int i11 = b11 + 1;
        int i12 = 1;
        boolean z10 = false;
        while (true) {
            if (i11 >= c10) {
                break;
            }
            char byteAt = (char) (bVar.byteAt(i11) & FastPairConstants.GO_INTENT_NOT_SET);
            if (z10) {
                z10 = false;
            } else if (byteAt == '\\') {
                z10 = true;
            } else if (byteAt == '(') {
                i12++;
            } else if (byteAt == ')') {
                i12--;
            }
            if (i12 <= 0) {
                i10++;
                break;
            } else {
                i11++;
                i10++;
            }
        }
        oVar.d(i10);
    }

    public void l(T9.b bVar, o oVar) {
        int b10 = oVar.b();
        int c10 = oVar.c();
        for (int b11 = oVar.b(); b11 < c10 && T9.c.a((char) (bVar.byteAt(b11) & FastPairConstants.GO_INTENT_NOT_SET)); b11++) {
            b10++;
        }
        oVar.d(b10);
    }
}

package d5;

import com.google.zxing.NotFoundException;

/* compiled from: AI01392xDecoder.java */
/* loaded from: classes3.dex */
public final class c extends h {
    public c(S4.a aVar) {
        super(aVar);
    }

    @Override // d5.j
    public String d() {
        if (c().k() >= 48) {
            StringBuilder sb = new StringBuilder();
            f(sb, 8);
            int f10 = b().f(48, 2);
            sb.append("(392");
            sb.append(f10);
            sb.append(')');
            sb.append(b().c(50, null).b());
            return sb.toString();
        }
        throw NotFoundException.a();
    }
}

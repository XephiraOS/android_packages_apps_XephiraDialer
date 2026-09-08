package d5;

import com.google.zxing.NotFoundException;

/* compiled from: AI013x0xDecoder.java */
/* loaded from: classes3.dex */
public abstract class f extends i {
    public f(S4.a aVar) {
        super(aVar);
    }

    @Override // d5.j
    public String d() {
        if (c().k() == 60) {
            StringBuilder sb = new StringBuilder();
            f(sb, 5);
            j(sb, 45, 15);
            return sb.toString();
        }
        throw NotFoundException.a();
    }
}

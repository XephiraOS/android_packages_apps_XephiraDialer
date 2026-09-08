package d5;

/* compiled from: AI01320xDecoder.java */
/* loaded from: classes3.dex */
public final class b extends f {
    public b(S4.a aVar) {
        super(aVar);
    }

    @Override // d5.i
    public void h(StringBuilder sb, int i10) {
        if (i10 < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // d5.i
    public int i(int i10) {
        if (i10 < 10000) {
            return i10;
        }
        return i10 - 10000;
    }
}

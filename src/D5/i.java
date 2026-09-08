package d5;

/* compiled from: AI01weightDecoder.java */
/* loaded from: classes3.dex */
public abstract class i extends h {
    public i(S4.a aVar) {
        super(aVar);
    }

    public abstract void h(StringBuilder sb, int i10);

    public abstract int i(int i10);

    public final void j(StringBuilder sb, int i10, int i11) {
        int f10 = b().f(i10, i11);
        h(sb, f10);
        int i12 = i(f10);
        int i13 = 100000;
        for (int i14 = 0; i14 < 5; i14++) {
            if (i12 / i13 == 0) {
                sb.append('0');
            }
            i13 /= 10;
        }
        sb.append(i12);
    }
}

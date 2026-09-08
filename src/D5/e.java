package d5;

import com.google.zxing.NotFoundException;

/* compiled from: AI013x0x1xDecoder.java */
/* loaded from: classes3.dex */
public final class e extends i {

    /* renamed from: c, reason: collision with root package name */
    public final String f30036c;

    /* renamed from: d, reason: collision with root package name */
    public final String f30037d;

    public e(S4.a aVar, String str, String str2) {
        super(aVar);
        this.f30036c = str2;
        this.f30037d = str;
    }

    @Override // d5.j
    public String d() {
        if (c().k() == 84) {
            StringBuilder sb = new StringBuilder();
            f(sb, 8);
            j(sb, 48, 20);
            k(sb, 68);
            return sb.toString();
        }
        throw NotFoundException.a();
    }

    @Override // d5.i
    public void h(StringBuilder sb, int i10) {
        sb.append('(');
        sb.append(this.f30037d);
        sb.append(i10 / 100000);
        sb.append(')');
    }

    @Override // d5.i
    public int i(int i10) {
        return i10 % 100000;
    }

    public final void k(StringBuilder sb, int i10) {
        int f10 = b().f(i10, 16);
        if (f10 == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.f30036c);
        sb.append(')');
        int i11 = f10 % 32;
        int i12 = f10 / 32;
        int i13 = (i12 % 12) + 1;
        int i14 = i12 / 12;
        if (i14 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i14);
        if (i13 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i13);
        if (i11 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i11);
    }
}

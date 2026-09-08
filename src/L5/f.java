package l5;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;

/* compiled from: QRCode.java */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public Mode f34699a;

    /* renamed from: b, reason: collision with root package name */
    public ErrorCorrectionLevel f34700b;

    /* renamed from: c, reason: collision with root package name */
    public j5.f f34701c;

    /* renamed from: d, reason: collision with root package name */
    public int f34702d = -1;

    /* renamed from: e, reason: collision with root package name */
    public C1294b f34703e;

    public static boolean b(int i10) {
        if (i10 >= 0 && i10 < 8) {
            return true;
        }
        return false;
    }

    public C1294b a() {
        return this.f34703e;
    }

    public void c(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f34700b = errorCorrectionLevel;
    }

    public void d(int i10) {
        this.f34702d = i10;
    }

    public void e(C1294b c1294b) {
        this.f34703e = c1294b;
    }

    public void f(Mode mode) {
        this.f34699a = mode;
    }

    public void g(j5.f fVar) {
        this.f34701c = fVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f34699a);
        sb.append("\n ecLevel: ");
        sb.append(this.f34700b);
        sb.append("\n version: ");
        sb.append(this.f34701c);
        sb.append("\n maskPattern: ");
        sb.append(this.f34702d);
        if (this.f34703e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f34703e);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}

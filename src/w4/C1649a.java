package w4;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* compiled from: ShadowRenderer.java */
/* renamed from: w4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1649a {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f37603i = new int[3];

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f37604j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f37605k = new int[4];

    /* renamed from: l, reason: collision with root package name */
    public static final float[] f37606l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public final Paint f37607a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f37608b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f37609c;

    /* renamed from: d, reason: collision with root package name */
    public int f37610d;

    /* renamed from: e, reason: collision with root package name */
    public int f37611e;

    /* renamed from: f, reason: collision with root package name */
    public int f37612f;

    /* renamed from: g, reason: collision with root package name */
    public final Path f37613g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f37614h;

    public C1649a() {
        this(-16777216);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i10, float f10, float f11) {
        boolean z10;
        if (f11 < 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        Path path = this.f37613g;
        if (z10) {
            int[] iArr = f37605k;
            iArr[0] = 0;
            iArr[1] = this.f37612f;
            iArr[2] = this.f37611e;
            iArr[3] = this.f37610d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f10, f11);
            path.close();
            float f12 = -i10;
            rectF.inset(f12, f12);
            int[] iArr2 = f37605k;
            iArr2[0] = 0;
            iArr2[1] = this.f37610d;
            iArr2[2] = this.f37611e;
            iArr2[3] = this.f37612f;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f13 = 1.0f - (i10 / width);
        float[] fArr = f37606l;
        fArr[1] = f13;
        fArr[2] = ((1.0f - f13) / 2.0f) + f13;
        this.f37608b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, f37605k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z10) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f37614h);
        }
        canvas.drawArc(rectF, f10, f11, true, this.f37608b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i10) {
        rectF.bottom += i10;
        rectF.offset(0.0f, -i10);
        int[] iArr = f37603i;
        iArr[0] = this.f37612f;
        iArr[1] = this.f37611e;
        iArr[2] = this.f37610d;
        Paint paint = this.f37609c;
        float f10 = rectF.left;
        paint.setShader(new LinearGradient(f10, rectF.top, f10, rectF.bottom, iArr, f37604j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f37609c);
        canvas.restore();
    }

    public Paint c() {
        return this.f37607a;
    }

    public void d(int i10) {
        this.f37610d = B.a.w(i10, 68);
        this.f37611e = B.a.w(i10, 20);
        this.f37612f = B.a.w(i10, 0);
        this.f37607a.setColor(this.f37610d);
    }

    public C1649a(int i10) {
        this.f37613g = new Path();
        Paint paint = new Paint();
        this.f37614h = paint;
        this.f37607a = new Paint();
        d(i10);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f37608b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f37609c = new Paint(paint2);
    }
}

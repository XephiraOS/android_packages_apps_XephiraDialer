package Z0;

import N0.f;
import N0.g;
import N0.h;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.android.contacts.model.Account;
import com.google.common.base.k;

/* compiled from: LetterTileDrawable.java */
/* loaded from: classes.dex */
public class e extends Drawable {

    /* renamed from: A, reason: collision with root package name */
    public static final char[] f5833A;

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f5834i;

    /* renamed from: j, reason: collision with root package name */
    public static volatile TypedArray f5835j;

    /* renamed from: k, reason: collision with root package name */
    public static int f5836k;

    /* renamed from: l, reason: collision with root package name */
    public static int f5837l;

    /* renamed from: m, reason: collision with root package name */
    public static float f5838m;

    /* renamed from: n, reason: collision with root package name */
    public static float f5839n;

    /* renamed from: o, reason: collision with root package name */
    public static int f5840o;

    /* renamed from: p, reason: collision with root package name */
    public static int f5841p;

    /* renamed from: q, reason: collision with root package name */
    public static int f5842q;

    /* renamed from: r, reason: collision with root package name */
    public static Bitmap f5843r;

    /* renamed from: s, reason: collision with root package name */
    public static Bitmap f5844s;

    /* renamed from: t, reason: collision with root package name */
    public static Bitmap f5845t;

    /* renamed from: u, reason: collision with root package name */
    public static Bitmap f5846u;

    /* renamed from: v, reason: collision with root package name */
    public static Bitmap f5847v;

    /* renamed from: w, reason: collision with root package name */
    public static Bitmap f5848w;

    /* renamed from: x, reason: collision with root package name */
    public static Bitmap[] f5849x;

    /* renamed from: y, reason: collision with root package name */
    public static ThreadLocal<Paint> f5850y;

    /* renamed from: z, reason: collision with root package name */
    public static final Rect f5851z;

    /* renamed from: a, reason: collision with root package name */
    public int f5852a;

    /* renamed from: b, reason: collision with root package name */
    public float f5853b;

    /* renamed from: c, reason: collision with root package name */
    public float f5854c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5855d;

    /* renamed from: e, reason: collision with root package name */
    public int f5856e;

    /* renamed from: f, reason: collision with root package name */
    public int f5857f;

    /* renamed from: g, reason: collision with root package name */
    public Character f5858g;

    /* renamed from: h, reason: collision with root package name */
    public Account f5859h;

    static {
        int i10 = g.f1915o;
        int[] iArr = {i10, i10};
        f5834i = iArr;
        f5840o = -1;
        f5841p = -1;
        f5842q = -1;
        f5849x = new Bitmap[iArr.length];
        f5850y = new ThreadLocal<>();
        f5851z = new Rect();
        f5833A = new char[1];
    }

    public e(Resources resources) {
        this(resources, null);
    }

    public static Paint a() {
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        return paint;
    }

    public static Paint e() {
        Paint paint = f5850y.get();
        if (paint == null) {
            Paint a10 = a();
            f5850y.set(a10);
            return a10;
        }
        return paint;
    }

    public static int g(String str, String str2) {
        if (str == null || str2 == null || !str.equals("com.android.sim")) {
            return -1;
        }
        if (!str2.equals("SIM") && !str2.equals("SIM1")) {
            if (!str2.equals("SIM2")) {
                return -1;
            }
            return 1;
        }
        return 0;
    }

    public static void h(Resources resources) {
        if (f5835j != null) {
            return;
        }
        synchronized (e.class) {
            try {
                if (f5835j != null) {
                    return;
                }
                f5836k = resources.getColor(N0.e.f1858g);
                f5837l = resources.getColor(N0.e.f1859h);
                f5838m = resources.getFraction(h.f1918b, 1, 1);
                f5839n = resources.getFraction(h.f1917a, 1, 1);
                f5840o = resources.getDimensionPixelOffset(f.f1885k);
                f5841p = resources.getDimensionPixelOffset(f.f1899y);
                f5842q = resources.getDimensionPixelOffset(f.f1887m);
                Drawable drawable = resources.getDrawable(g.f1915o, null);
                Bitmap c10 = I7.a.c(drawable, drawable.getIntrinsicHeight());
                Drawable drawable2 = resources.getDrawable(g.f1914n, null);
                f5843r = I7.a.c(drawable2, drawable2.getIntrinsicHeight());
                Drawable drawable3 = resources.getDrawable(g.f1913m, null);
                f5844s = I7.a.c(drawable3, drawable3.getIntrinsicHeight());
                Drawable drawable4 = resources.getDrawable(g.f1912l, null);
                f5845t = I7.a.c(drawable4, drawable4.getIntrinsicHeight());
                f5846u = c10;
                f5847v = c10;
                f5848w = c10;
                int i10 = 0;
                while (true) {
                    int[] iArr = f5834i;
                    if (i10 < iArr.length) {
                        f5849x[i10] = I7.a.c(resources.getDrawable(iArr[i10], null), resources.getDrawable(iArr[i10], null).getIntrinsicHeight());
                        i10++;
                    } else {
                        f5835j = resources.obtainTypedArray(N0.b.f1839a);
                        return;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean i(char c10) {
        if (('A' <= c10 && c10 <= 'Z') || ('a' <= c10 && c10 <= 'z')) {
            return true;
        }
        return false;
    }

    public static void l() {
        f5850y.set(a());
    }

    public final void b(Bitmap bitmap, int i10, int i11, Canvas canvas, Paint paint) {
        Rect copyBounds = copyBounds();
        int min = (int) ((this.f5853b * Math.min(copyBounds.width(), copyBounds.height())) / 2.0f);
        copyBounds.set(copyBounds.centerX() - min, (int) ((copyBounds.centerY() - min) + (this.f5854c * copyBounds.height())), copyBounds.centerX() + min, (int) (copyBounds.centerY() + min + (this.f5854c * copyBounds.height())));
        int width = (copyBounds.width() - i10) / 2;
        int height = (copyBounds.height() - i11) / 2;
        Rect rect = f5851z;
        rect.set(width, height, i10 + width, i11 + height);
        paint.setColor(this.f5857f);
        canvas.drawRect(copyBounds, paint);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
    }

    public final void c(Canvas canvas, Paint paint) {
        paint.setColor(this.f5857f);
        Rect bounds = getBounds();
        int min = Math.min(bounds.width(), bounds.height());
        if (this.f5855d) {
            canvas.drawCircle(bounds.centerX(), bounds.centerY(), min / 2, paint);
        } else {
            canvas.drawRect(bounds, paint);
        }
        Character ch = this.f5858g;
        if (ch != null) {
            char[] cArr = f5833A;
            cArr[0] = ch.charValue();
            if (this.f5856e == 3) {
                paint.setTextSize(this.f5853b * f5839n * min);
            } else {
                paint.setTextSize(this.f5853b * f5838m * min);
            }
            Rect rect = f5851z;
            paint.getTextBounds(cArr, 0, 1, rect);
            paint.setColor(f5837l);
            canvas.drawText(cArr, 0, 1, bounds.centerX(), (bounds.centerY() + (this.f5854c * bounds.height())) - rect.exactCenterY(), paint);
            return;
        }
        Bitmap d10 = d(this.f5852a, this.f5859h);
        b(d10, d10.getWidth(), d10.getHeight(), canvas, paint);
    }

    public final Bitmap d(int i10, Account account) {
        if (account != null && "com.android.sim".equals(account.f16942b)) {
            if (account.f16941a.equals("SIM")) {
                return f5848w;
            }
            int g10 = g("com.android.sim", account.f16941a);
            if (g10 >= 0 && g10 <= f5834i.length) {
                return f5849x[g10];
            }
            return f5843r;
        }
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    return f5843r;
                }
                return f5847v;
            }
            return f5846u;
        }
        int i11 = this.f5856e;
        if (i11 == 3) {
            return f5845t;
        }
        if (i11 == 2) {
            return f5844s;
        }
        return f5843r;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBounds().isEmpty()) {
            return;
        }
        c(canvas, e());
    }

    public final int f() {
        int i10 = this.f5856e;
        if (i10 == 3) {
            return f5840o;
        }
        if (i10 == 2) {
            return f5841p;
        }
        return f5842q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return f();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return f();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    public final boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Character.isLetterOrDigit(Character.codePointAt(str, 0));
    }

    public final int k(String str) {
        if (!TextUtils.isEmpty(str) && this.f5852a != 3) {
            return f5835j.getColor(Math.abs(str.hashCode()) % f5835j.length(), f5836k);
        }
        return f5836k;
    }

    public e m(int i10) {
        this.f5852a = i10;
        return this;
    }

    public e n(boolean z10) {
        this.f5855d = z10;
        return this;
    }

    public e o(String str, String str2) {
        if (str != null && str.length() > 0 && i(str.charAt(0))) {
            this.f5858g = Character.valueOf(Character.toUpperCase(str.charAt(0)));
        } else if (str != null && str.length() > 0) {
            Character valueOf = Character.valueOf(str.charAt(0));
            if (j(str)) {
                this.f5858g = valueOf;
            } else {
                this.f5858g = null;
            }
        } else {
            this.f5858g = null;
        }
        this.f5857f = k(str2);
        return this;
    }

    public e p(float f10) {
        boolean z10;
        if (f10 >= -0.5f && f10 <= 0.5f) {
            z10 = true;
        } else {
            z10 = false;
        }
        k.d(z10);
        this.f5854c = f10;
        return this;
    }

    public e q(int i10) {
        this.f5856e = i10;
        return this;
    }

    public e r(float f10) {
        this.f5853b = f10;
        return this;
    }

    public e(Resources resources, Account account) {
        this.f5852a = 1;
        this.f5853b = 1.0f;
        this.f5854c = 0.0f;
        this.f5855d = false;
        this.f5856e = 1;
        this.f5858g = null;
        h(resources);
        this.f5857f = f5836k;
        this.f5859h = account;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}

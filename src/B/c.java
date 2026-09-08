package B;

import android.graphics.Paint;
import android.graphics.Rect;

/* compiled from: PaintCompat.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<I.d<Rect, Rect>> f211a = new ThreadLocal<>();

    /* compiled from: PaintCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        public static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    public static boolean a(Paint paint, String str) {
        return a.a(paint, str);
    }
}

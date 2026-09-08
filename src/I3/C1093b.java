package i3;

import A.h;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import f.C0991a;
import j.C1147d;

/* compiled from: DrawableDecoderCompat.java */
/* renamed from: i3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1093b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f32154a = true;

    public static Drawable a(Context context, int i10, Resources.Theme theme) {
        return c(context, context, i10, theme);
    }

    public static Drawable b(Context context, Context context2, int i10) {
        return c(context, context2, i10, null);
    }

    public static Drawable c(Context context, Context context2, int i10, Resources.Theme theme) {
        try {
            if (f32154a) {
                return e(context2, i10, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e10) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return androidx.core.content.b.e(context2, i10);
            }
            throw e10;
        } catch (NoClassDefFoundError unused2) {
            f32154a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i10, theme);
    }

    public static Drawable d(Context context, int i10, Resources.Theme theme) {
        return h.f(context.getResources(), i10, theme);
    }

    public static Drawable e(Context context, int i10, Resources.Theme theme) {
        if (theme != null) {
            C1147d c1147d = new C1147d(context, theme);
            c1147d.a(theme.getResources().getConfiguration());
            context = c1147d;
        }
        return C0991a.b(context, i10);
    }
}

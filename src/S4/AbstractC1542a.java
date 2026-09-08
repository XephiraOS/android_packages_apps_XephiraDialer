package s4;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import e4.C0977c;

/* compiled from: MaterialBackAnimationHelper.java */
/* renamed from: s4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1542a<V extends View> {

    /* renamed from: a, reason: collision with root package name */
    public final TimeInterpolator f36779a;

    /* renamed from: b, reason: collision with root package name */
    public final V f36780b;

    /* renamed from: c, reason: collision with root package name */
    public final int f36781c;

    /* renamed from: d, reason: collision with root package name */
    public final int f36782d;

    /* renamed from: e, reason: collision with root package name */
    public final int f36783e;

    /* renamed from: f, reason: collision with root package name */
    public androidx.activity.b f36784f;

    public AbstractC1542a(V v10) {
        this.f36780b = v10;
        Context context = v10.getContext();
        this.f36779a = C1550i.g(context, C0977c.f30668g0, K.a.a(0.0f, 0.0f, 0.0f, 1.0f));
        this.f36781c = C1550i.f(context, C0977c.f30650V, 300);
        this.f36782d = C1550i.f(context, C0977c.f30654Z, 150);
        this.f36783e = C1550i.f(context, C0977c.f30653Y, 100);
    }

    public float a(float f10) {
        return this.f36779a.getInterpolation(f10);
    }

    public androidx.activity.b b() {
        if (this.f36784f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        androidx.activity.b bVar = this.f36784f;
        this.f36784f = null;
        return bVar;
    }

    public androidx.activity.b c() {
        androidx.activity.b bVar = this.f36784f;
        this.f36784f = null;
        return bVar;
    }

    public void d(androidx.activity.b bVar) {
        this.f36784f = bVar;
    }

    public androidx.activity.b e(androidx.activity.b bVar) {
        if (this.f36784f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        androidx.activity.b bVar2 = this.f36784f;
        this.f36784f = bVar;
        return bVar2;
    }
}

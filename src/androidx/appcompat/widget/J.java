package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* compiled from: TintResources.java */
/* loaded from: classes.dex */
public class J extends B {

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f7723b;

    public J(Context context, Resources resources) {
        super(resources);
        this.f7723b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i10) {
        Drawable a10 = a(i10);
        Context context = this.f7723b.get();
        if (a10 != null && context != null) {
            A.g().w(context, i10, a10);
        }
        return a10;
    }
}

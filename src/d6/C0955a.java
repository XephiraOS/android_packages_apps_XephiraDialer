package d6;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.oplus.anim.L;
import e6.C0984c;
import e6.h;
import java.util.HashMap;
import java.util.Map;
import l6.e;

/* compiled from: FontAssetManager.java */
/* renamed from: d6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0955a {

    /* renamed from: d, reason: collision with root package name */
    public final AssetManager f30060d;

    /* renamed from: a, reason: collision with root package name */
    public final h<String> f30057a = new h<>();

    /* renamed from: b, reason: collision with root package name */
    public final Map<h<String>, Typeface> f30058b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, Typeface> f30059c = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public String f30061e = ".ttf";

    public C0955a(Drawable.Callback callback, L l10) {
        if (!(callback instanceof View)) {
            e.c("EffectiveAnimationDrawable must be inside of a view for images to work.");
            this.f30060d = null;
        } else {
            this.f30060d = ((View) callback).getContext().getAssets();
        }
    }

    public final Typeface a(C0984c c0984c) {
        String a10 = c0984c.a();
        Typeface typeface = this.f30059c.get(a10);
        if (typeface != null) {
            return typeface;
        }
        c0984c.c();
        c0984c.b();
        if (c0984c.d() != null) {
            return c0984c.d();
        }
        Typeface createFromAsset = Typeface.createFromAsset(this.f30060d, "fonts/" + a10 + this.f30061e);
        this.f30059c.put(a10, createFromAsset);
        return createFromAsset;
    }

    public Typeface b(C0984c c0984c) {
        this.f30057a.b(c0984c.a(), c0984c.c());
        Typeface typeface = this.f30058b.get(this.f30057a);
        if (typeface != null) {
            return typeface;
        }
        Typeface e10 = e(a(c0984c), c0984c.c());
        this.f30058b.put(this.f30057a, e10);
        return e10;
    }

    public void c(String str) {
        this.f30061e = str;
    }

    public final Typeface e(Typeface typeface, String str) {
        int i10;
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        if (contains && contains2) {
            i10 = 3;
        } else if (contains) {
            i10 = 2;
        } else if (contains2) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        if (typeface.getStyle() == i10) {
            return typeface;
        }
        return Typeface.create(typeface, i10);
    }

    public void d(L l10) {
    }
}

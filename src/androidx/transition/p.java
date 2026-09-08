package androidx.transition;

import android.view.ViewGroup;

/* compiled from: Scene.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f11736a;

    /* renamed from: b, reason: collision with root package name */
    public Runnable f11737b;

    public static p b(ViewGroup viewGroup) {
        return (p) viewGroup.getTag(C0511n.f11730f);
    }

    public static void c(ViewGroup viewGroup, p pVar) {
        viewGroup.setTag(C0511n.f11730f, pVar);
    }

    public void a() {
        Runnable runnable;
        if (b(this.f11736a) == this && (runnable = this.f11737b) != null) {
            runnable.run();
        }
    }
}

package com.bumptech.glide.manager;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import s3.C1541l;

/* compiled from: FirstFrameWaiter.java */
/* loaded from: classes.dex */
public final class h implements i {

    /* renamed from: a, reason: collision with root package name */
    public final Set<Activity> f19693a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f19694b;

    /* compiled from: FirstFrameWaiter.java */
    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnDrawListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f19695a;

        /* compiled from: FirstFrameWaiter.java */
        /* renamed from: com.bumptech.glide.manager.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0195a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnDrawListener f19697a;

            public RunnableC0195a(ViewTreeObserver.OnDrawListener onDrawListener) {
                this.f19697a = onDrawListener;
            }

            @Override // java.lang.Runnable
            public void run() {
                g3.o.b().h();
                h.this.f19694b = true;
                h.b(a.this.f19695a, this.f19697a);
                h.this.f19693a.clear();
            }
        }

        public a(View view) {
            this.f19695a = view;
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            C1541l.u(new RunnableC0195a(this));
        }
    }

    public static void b(View view, ViewTreeObserver.OnDrawListener onDrawListener) {
        view.getViewTreeObserver().removeOnDrawListener(onDrawListener);
    }

    @Override // com.bumptech.glide.manager.i
    public void a(Activity activity) {
        if (this.f19694b || !this.f19693a.add(activity)) {
            return;
        }
        View decorView = activity.getWindow().getDecorView();
        decorView.getViewTreeObserver().addOnDrawListener(new a(decorView));
    }
}

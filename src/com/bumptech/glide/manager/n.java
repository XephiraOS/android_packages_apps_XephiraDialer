package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import p.C1415a;
import s3.C1541l;

/* compiled from: RequestManagerRetriever.java */
/* loaded from: classes.dex */
public class n implements Handler.Callback {

    /* renamed from: f, reason: collision with root package name */
    public static final b f19705f = new a();

    /* renamed from: a, reason: collision with root package name */
    public volatile com.bumptech.glide.i f19706a;

    /* renamed from: b, reason: collision with root package name */
    public final b f19707b;

    /* renamed from: c, reason: collision with root package name */
    public final C1415a<View, Fragment> f19708c = new C1415a<>();

    /* renamed from: d, reason: collision with root package name */
    public final i f19709d;

    /* renamed from: e, reason: collision with root package name */
    public final l f19710e;

    /* compiled from: RequestManagerRetriever.java */
    /* loaded from: classes.dex */
    public class a implements b {
        @Override // com.bumptech.glide.manager.n.b
        public com.bumptech.glide.i a(com.bumptech.glide.b bVar, j jVar, o oVar, Context context) {
            return new com.bumptech.glide.i(bVar, jVar, oVar, context);
        }
    }

    /* compiled from: RequestManagerRetriever.java */
    /* loaded from: classes.dex */
    public interface b {
        com.bumptech.glide.i a(com.bumptech.glide.b bVar, j jVar, o oVar, Context context);
    }

    public n(b bVar) {
        bVar = bVar == null ? f19705f : bVar;
        this.f19707b = bVar;
        this.f19710e = new l(bVar);
        this.f19709d = b();
    }

    public static void a(Activity activity) {
        if (!activity.isDestroyed()) {
        } else {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    public static i b() {
        if (g3.o.f31858f && g3.o.f31857e) {
            return new h();
        }
        return new f();
    }

    public static Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean g(Context context) {
        Activity c10 = c(context);
        if (c10 != null && c10.isFinishing()) {
            return false;
        }
        return true;
    }

    public com.bumptech.glide.i d(Context context) {
        if (context != null) {
            if (C1541l.r() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return e((FragmentActivity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return d(contextWrapper.getBaseContext());
                    }
                }
            }
            return f(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public com.bumptech.glide.i e(FragmentActivity fragmentActivity) {
        if (C1541l.q()) {
            return d(fragmentActivity.getApplicationContext());
        }
        a(fragmentActivity);
        this.f19709d.a(fragmentActivity);
        boolean g10 = g(fragmentActivity);
        return this.f19710e.b(fragmentActivity, com.bumptech.glide.b.c(fragmentActivity.getApplicationContext()), fragmentActivity.getLifecycle(), fragmentActivity.getSupportFragmentManager(), g10);
    }

    public final com.bumptech.glide.i f(Context context) {
        if (this.f19706a == null) {
            synchronized (this) {
                try {
                    if (this.f19706a == null) {
                        this.f19706a = this.f19707b.a(com.bumptech.glide.b.c(context.getApplicationContext()), new com.bumptech.glide.manager.a(), new g(), context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return this.f19706a;
    }

    @Override // android.os.Handler.Callback
    @Deprecated
    public boolean handleMessage(Message message) {
        return false;
    }
}

package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.e;
import androidx.appcompat.widget.Toolbar;
import j.AbstractC1145b;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;
import p.C1416b;

/* compiled from: AppCompatDelegate.java */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static c f7368a = new c(new d());

    /* renamed from: b, reason: collision with root package name */
    public static int f7369b = -100;

    /* renamed from: c, reason: collision with root package name */
    public static F.e f7370c = null;

    /* renamed from: d, reason: collision with root package name */
    public static F.e f7371d = null;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f7372e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f7373f = false;

    /* renamed from: g, reason: collision with root package name */
    public static final C1416b<WeakReference<e>> f7374g = new C1416b<>();

    /* renamed from: h, reason: collision with root package name */
    public static final Object f7375h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public static final Object f7376i = new Object();

    /* compiled from: AppCompatDelegate.java */
    /* loaded from: classes.dex */
    public static class a {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* compiled from: AppCompatDelegate.java */
    /* loaded from: classes.dex */
    public static class b {
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    /* compiled from: AppCompatDelegate.java */
    /* loaded from: classes.dex */
    public static class c implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public final Object f7377a = new Object();

        /* renamed from: b, reason: collision with root package name */
        public final Queue<Runnable> f7378b = new ArrayDeque();

        /* renamed from: c, reason: collision with root package name */
        public final Executor f7379c;

        /* renamed from: d, reason: collision with root package name */
        public Runnable f7380d;

        public c(Executor executor) {
            this.f7379c = executor;
        }

        public final /* synthetic */ void b(Runnable runnable) {
            try {
                runnable.run();
            } finally {
                c();
            }
        }

        public void c() {
            synchronized (this.f7377a) {
                try {
                    Runnable poll = this.f7378b.poll();
                    this.f7380d = poll;
                    if (poll != null) {
                        this.f7379c.execute(poll);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            synchronized (this.f7377a) {
                try {
                    this.f7378b.add(new Runnable() { // from class: androidx.appcompat.app.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            e.c.this.b(runnable);
                        }
                    });
                    if (this.f7380d == null) {
                        c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* compiled from: AppCompatDelegate.java */
    /* loaded from: classes.dex */
    public static class d implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    public static void C(e eVar) {
        synchronized (f7375h) {
            D(eVar);
        }
    }

    public static void D(e eVar) {
        synchronized (f7375h) {
            try {
                Iterator<WeakReference<e>> it = f7374g.iterator();
                while (it.hasNext()) {
                    e eVar2 = it.next().get();
                    if (eVar2 == eVar || eVar2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void O(Context context) {
        ComponentName componentName = new ComponentName(context, "androidx.appcompat.app.AppLocalesMetadataHolderService");
        if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
            if (i().d()) {
                String a10 = androidx.core.app.c.a(context);
                Object systemService = context.getSystemService("locale");
                if (systemService != null) {
                    b.b(systemService, a.a(a10));
                }
            }
            context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        }
    }

    public static void P(final Context context) {
        if (s(context) && !f7373f) {
            f7368a.execute(new Runnable() { // from class: androidx.appcompat.app.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.t(context);
                }
            });
        }
    }

    public static void b(e eVar) {
        synchronized (f7375h) {
            D(eVar);
            f7374g.add(new WeakReference<>(eVar));
        }
    }

    public static e f(Activity activity, androidx.appcompat.app.c cVar) {
        return new AppCompatDelegateImpl(activity, cVar);
    }

    public static e g(Dialog dialog, androidx.appcompat.app.c cVar) {
        return new AppCompatDelegateImpl(dialog, cVar);
    }

    public static F.e i() {
        Object n10 = n();
        if (n10 != null) {
            return F.e.f(b.a(n10));
        }
        return F.e.c();
    }

    public static int k() {
        return f7369b;
    }

    public static Object n() {
        Context j10;
        Iterator<WeakReference<e>> it = f7374g.iterator();
        while (it.hasNext()) {
            e eVar = it.next().get();
            if (eVar != null && (j10 = eVar.j()) != null) {
                return j10.getSystemService("locale");
            }
        }
        return null;
    }

    public static boolean s(Context context) {
        if (f7372e == null) {
            try {
                Bundle bundle = AppLocalesMetadataHolderService.a(context).metaData;
                if (bundle != null) {
                    f7372e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f7372e = Boolean.FALSE;
            }
        }
        return f7372e.booleanValue();
    }

    public static /* synthetic */ void t(Context context) {
        O(context);
        f7373f = true;
    }

    public abstract void A();

    public abstract void B();

    public abstract boolean E(int i10);

    public abstract void F(int i10);

    public abstract void G(View view);

    public abstract void H(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void I(int i10);

    public abstract void K(Toolbar toolbar);

    public abstract void M(CharSequence charSequence);

    public abstract AbstractC1145b N(AbstractC1145b.a aVar);

    public abstract void c(View view, ViewGroup.LayoutParams layoutParams);

    public Context e(Context context) {
        d(context);
        return context;
    }

    public abstract <T extends View> T h(int i10);

    public Context j() {
        return null;
    }

    public abstract androidx.appcompat.app.a l();

    public int m() {
        return -100;
    }

    public abstract MenuInflater o();

    public abstract ActionBar p();

    public abstract void q();

    public abstract void r();

    public abstract void u(Configuration configuration);

    public abstract void v(Bundle bundle);

    public abstract void w();

    public abstract void x(Bundle bundle);

    public abstract void y();

    public abstract void z(Bundle bundle);

    public void J(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public void L(int i10) {
    }

    @Deprecated
    public void d(Context context) {
    }
}

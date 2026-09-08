package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: TintContextWrapper.java */
/* loaded from: classes.dex */
public class H extends ContextWrapper {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f7715c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static ArrayList<WeakReference<H>> f7716d;

    /* renamed from: a, reason: collision with root package name */
    public final Resources f7717a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources.Theme f7718b;

    public H(Context context) {
        super(context);
        if (Q.c()) {
            Q q10 = new Q(this, context.getResources());
            this.f7717a = q10;
            Resources.Theme newTheme = q10.newTheme();
            this.f7718b = newTheme;
            newTheme.setTo(context.getTheme());
            return;
        }
        this.f7717a = new J(this, context.getResources());
        this.f7718b = null;
    }

    public static boolean a(Context context) {
        if (!(context instanceof H) && !(context.getResources() instanceof J) && !(context.getResources() instanceof Q)) {
            return Q.c();
        }
        return false;
    }

    public static Context b(Context context) {
        H h10;
        if (a(context)) {
            synchronized (f7715c) {
                try {
                    ArrayList<WeakReference<H>> arrayList = f7716d;
                    if (arrayList == null) {
                        f7716d = new ArrayList<>();
                    } else {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            WeakReference<H> weakReference = f7716d.get(size);
                            if (weakReference == null || weakReference.get() == null) {
                                f7716d.remove(size);
                            }
                        }
                        for (int size2 = f7716d.size() - 1; size2 >= 0; size2--) {
                            WeakReference<H> weakReference2 = f7716d.get(size2);
                            if (weakReference2 != null) {
                                h10 = weakReference2.get();
                            } else {
                                h10 = null;
                            }
                            if (h10 != null && h10.getBaseContext() == context) {
                                return h10;
                            }
                        }
                    }
                    H h11 = new H(context);
                    f7716d.add(new WeakReference<>(h11));
                    return h11;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return context;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f7717a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f7717a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f7718b;
        if (theme == null) {
            return super.getTheme();
        }
        return theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        Resources.Theme theme = this.f7718b;
        if (theme == null) {
            super.setTheme(i10);
        } else {
            theme.applyStyle(i10, true);
        }
    }
}

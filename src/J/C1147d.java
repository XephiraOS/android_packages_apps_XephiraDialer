package j;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* compiled from: ContextThemeWrapper.java */
/* renamed from: j.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1147d extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    public static Configuration f33674f;

    /* renamed from: a, reason: collision with root package name */
    public int f33675a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f33676b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f33677c;

    /* renamed from: d, reason: collision with root package name */
    public Configuration f33678d;

    /* renamed from: e, reason: collision with root package name */
    public Resources f33679e;

    public C1147d() {
        super(null);
    }

    public static boolean e(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f33674f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f33674f = configuration2;
        }
        return configuration.equals(f33674f);
    }

    public void a(Configuration configuration) {
        if (this.f33679e == null) {
            if (this.f33678d == null) {
                this.f33678d = new Configuration(configuration);
                return;
            }
            throw new IllegalStateException("Override configuration has already been set");
        }
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final Resources b() {
        if (this.f33679e == null) {
            Configuration configuration = this.f33678d;
            if (configuration != null && !e(configuration)) {
                this.f33679e = createConfigurationContext(this.f33678d).getResources();
            } else {
                this.f33679e = super.getResources();
            }
        }
        return this.f33679e;
    }

    public int c() {
        return this.f33675a;
    }

    public final void d() {
        boolean z10;
        if (this.f33676b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f33676b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f33676b.setTo(theme);
            }
        }
        f(this.f33676b, this.f33675a, z10);
    }

    public void f(Resources.Theme theme, int i10, boolean z10) {
        theme.applyStyle(i10, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f33677c == null) {
                this.f33677c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f33677c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f33676b;
        if (theme != null) {
            return theme;
        }
        if (this.f33675a == 0) {
            this.f33675a = e.i.f30281e;
        }
        d();
        return this.f33676b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        if (this.f33675a != i10) {
            this.f33675a = i10;
            d();
        }
    }

    public C1147d(Context context, int i10) {
        super(context);
        this.f33675a = i10;
    }

    public C1147d(Context context, Resources.Theme theme) {
        super(context);
        this.f33676b = theme;
    }
}

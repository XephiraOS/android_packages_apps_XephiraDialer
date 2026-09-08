package androidx.appcompat.app;

import A.h;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0433g;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.InterfaceC0444s;
import androidx.appcompat.widget.S;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.C0456k;
import androidx.core.view.C0457l;
import androidx.core.view.K;
import androidx.core.view.Q;
import androidx.core.view.T;
import androidx.core.view.X;
import androidx.core.view.z;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import com.google.android.material.internal.ViewUtils;
import e.C0961a;
import f.C0991a;
import j.AbstractC1145b;
import j.C1147d;
import j.C1149f;
import j.C1150g;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class AppCompatDelegateImpl extends androidx.appcompat.app.e implements MenuBuilder.Callback, LayoutInflater.Factory2 {

    /* renamed from: o0, reason: collision with root package name */
    public static final p.i<String, Integer> f7262o0 = new p.i<>();

    /* renamed from: p0, reason: collision with root package name */
    public static final boolean f7263p0 = false;

    /* renamed from: q0, reason: collision with root package name */
    public static final int[] f7264q0 = {R.attr.windowBackground};

    /* renamed from: r0, reason: collision with root package name */
    public static final boolean f7265r0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: A, reason: collision with root package name */
    public ActionBarContextView f7266A;

    /* renamed from: B, reason: collision with root package name */
    public PopupWindow f7267B;

    /* renamed from: C, reason: collision with root package name */
    public Runnable f7268C;

    /* renamed from: D, reason: collision with root package name */
    public Q f7269D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f7270E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f7271F;

    /* renamed from: G, reason: collision with root package name */
    public ViewGroup f7272G;

    /* renamed from: H, reason: collision with root package name */
    public TextView f7273H;

    /* renamed from: I, reason: collision with root package name */
    public View f7274I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f7275J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f7276K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f7277L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f7278M;

    /* renamed from: N, reason: collision with root package name */
    public boolean f7279N;

    /* renamed from: O, reason: collision with root package name */
    public boolean f7280O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f7281P;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f7282Q;

    /* renamed from: R, reason: collision with root package name */
    public PanelFeatureState[] f7283R;

    /* renamed from: S, reason: collision with root package name */
    public PanelFeatureState f7284S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f7285T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f7286U;

    /* renamed from: V, reason: collision with root package name */
    public boolean f7287V;

    /* renamed from: W, reason: collision with root package name */
    public boolean f7288W;

    /* renamed from: X, reason: collision with root package name */
    public Configuration f7289X;

    /* renamed from: Y, reason: collision with root package name */
    public int f7290Y;

    /* renamed from: Z, reason: collision with root package name */
    public int f7291Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f7292a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f7293b0;

    /* renamed from: c0, reason: collision with root package name */
    public p f7294c0;

    /* renamed from: d0, reason: collision with root package name */
    public p f7295d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f7296e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f7297f0;

    /* renamed from: g0, reason: collision with root package name */
    public final Runnable f7298g0;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f7299h0;

    /* renamed from: i0, reason: collision with root package name */
    public Rect f7300i0;

    /* renamed from: j, reason: collision with root package name */
    public final Object f7301j;

    /* renamed from: j0, reason: collision with root package name */
    public Rect f7302j0;

    /* renamed from: k, reason: collision with root package name */
    public final Context f7303k;

    /* renamed from: k0, reason: collision with root package name */
    public androidx.appcompat.app.k f7304k0;

    /* renamed from: l, reason: collision with root package name */
    public Window f7305l;

    /* renamed from: l0, reason: collision with root package name */
    public androidx.appcompat.app.l f7306l0;

    /* renamed from: m, reason: collision with root package name */
    public n f7307m;

    /* renamed from: m0, reason: collision with root package name */
    public OnBackInvokedDispatcher f7308m0;

    /* renamed from: n, reason: collision with root package name */
    public final androidx.appcompat.app.c f7309n;

    /* renamed from: n0, reason: collision with root package name */
    public OnBackInvokedCallback f7310n0;

    /* renamed from: o, reason: collision with root package name */
    public ActionBar f7311o;

    /* renamed from: p, reason: collision with root package name */
    public MenuInflater f7312p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f7313q;

    /* renamed from: r, reason: collision with root package name */
    public InterfaceC0444s f7314r;

    /* renamed from: x, reason: collision with root package name */
    public h f7315x;

    /* renamed from: y, reason: collision with root package name */
    public s f7316y;

    /* renamed from: z, reason: collision with root package name */
    public AbstractC1145b f7317z;

    /* loaded from: classes.dex */
    public static final class PanelFeatureState {

        /* renamed from: a, reason: collision with root package name */
        public int f7318a;

        /* renamed from: b, reason: collision with root package name */
        public int f7319b;

        /* renamed from: c, reason: collision with root package name */
        public int f7320c;

        /* renamed from: d, reason: collision with root package name */
        public int f7321d;

        /* renamed from: e, reason: collision with root package name */
        public int f7322e;

        /* renamed from: f, reason: collision with root package name */
        public int f7323f;

        /* renamed from: g, reason: collision with root package name */
        public ViewGroup f7324g;

        /* renamed from: h, reason: collision with root package name */
        public View f7325h;

        /* renamed from: i, reason: collision with root package name */
        public View f7326i;

        /* renamed from: j, reason: collision with root package name */
        public MenuBuilder f7327j;

        /* renamed from: k, reason: collision with root package name */
        public ListMenuPresenter f7328k;

        /* renamed from: l, reason: collision with root package name */
        public Context f7329l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f7330m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f7331n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f7332o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f7333p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f7334q = false;

        /* renamed from: r, reason: collision with root package name */
        public boolean f7335r;

        /* renamed from: s, reason: collision with root package name */
        public Bundle f7336s;

        /* loaded from: classes.dex */
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* renamed from: a, reason: collision with root package name */
            public int f7337a;

            /* renamed from: b, reason: collision with root package name */
            public boolean f7338b;

            /* renamed from: c, reason: collision with root package name */
            public Bundle f7339c;

            /* loaded from: classes.dex */
            public class a implements Parcelable.ClassLoaderCreator<SavedState> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.b(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.b(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i10) {
                    return new SavedState[i10];
                }
            }

            public static SavedState b(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f7337a = parcel.readInt();
                boolean z10 = true;
                if (parcel.readInt() != 1) {
                    z10 = false;
                }
                savedState.f7338b = z10;
                if (z10) {
                    savedState.f7339c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f7337a);
                parcel.writeInt(this.f7338b ? 1 : 0);
                if (this.f7338b) {
                    parcel.writeBundle(this.f7339c);
                }
            }
        }

        public PanelFeatureState(int i10) {
            this.f7318a = i10;
        }

        public MenuView a(MenuPresenter.Callback callback) {
            if (this.f7327j == null) {
                return null;
            }
            if (this.f7328k == null) {
                ListMenuPresenter listMenuPresenter = new ListMenuPresenter(this.f7329l, e.g.f30251l);
                this.f7328k = listMenuPresenter;
                listMenuPresenter.setCallback(callback);
                this.f7327j.addMenuPresenter(this.f7328k);
            }
            return this.f7328k.getMenuView(this.f7324g);
        }

        public boolean b() {
            if (this.f7325h == null) {
                return false;
            }
            if (this.f7326i == null && this.f7328k.getAdapter().getCount() <= 0) {
                return false;
            }
            return true;
        }

        public void c(MenuBuilder menuBuilder) {
            ListMenuPresenter listMenuPresenter;
            MenuBuilder menuBuilder2 = this.f7327j;
            if (menuBuilder == menuBuilder2) {
                return;
            }
            if (menuBuilder2 != null) {
                menuBuilder2.removeMenuPresenter(this.f7328k);
            }
            this.f7327j = menuBuilder;
            if (menuBuilder != null && (listMenuPresenter = this.f7328k) != null) {
                menuBuilder.addMenuPresenter(listMenuPresenter);
            }
        }

        public void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0961a.f30102a, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                newTheme.applyStyle(i10, true);
            }
            newTheme.resolveAttribute(C0961a.f30090H, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                newTheme.applyStyle(i11, true);
            } else {
                newTheme.applyStyle(e.i.f30279c, true);
            }
            C1147d c1147d = new C1147d(context, 0);
            c1147d.getTheme().setTo(newTheme);
            this.f7329l = c1147d;
            TypedArray obtainStyledAttributes = c1147d.obtainStyledAttributes(e.j.f30283A0);
            this.f7319b = obtainStyledAttributes.getResourceId(e.j.f30298D0, 0);
            this.f7323f = obtainStyledAttributes.getResourceId(e.j.f30293C0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.f7297f0 & 1) != 0) {
                appCompatDelegateImpl.h0(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.f7297f0 & 4096) != 0) {
                appCompatDelegateImpl2.h0(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.f7296e0 = false;
            appCompatDelegateImpl3.f7297f0 = 0;
        }
    }

    /* loaded from: classes.dex */
    public class b implements z {
        public b() {
        }

        @Override // androidx.core.view.z
        public X onApplyWindowInsets(View view, X x10) {
            int m10 = x10.m();
            int d12 = AppCompatDelegateImpl.this.d1(x10, null);
            if (m10 != d12) {
                x10 = x10.s(x10.k(), d12, x10.l(), x10.j());
            }
            return K.V(view, x10);
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* loaded from: classes.dex */
        public class a extends T {
            public a() {
            }

            @Override // androidx.core.view.S
            public void b(View view) {
                AppCompatDelegateImpl.this.f7266A.setAlpha(1.0f);
                AppCompatDelegateImpl.this.f7269D.i(null);
                AppCompatDelegateImpl.this.f7269D = null;
            }

            @Override // androidx.core.view.T, androidx.core.view.S
            public void c(View view) {
                AppCompatDelegateImpl.this.f7266A.setVisibility(0);
            }
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.f7267B.showAtLocation(appCompatDelegateImpl.f7266A, 55, 0, 0);
            AppCompatDelegateImpl.this.i0();
            if (AppCompatDelegateImpl.this.T0()) {
                AppCompatDelegateImpl.this.f7266A.setAlpha(0.0f);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f7269D = K.d(appCompatDelegateImpl2.f7266A).b(1.0f);
                AppCompatDelegateImpl.this.f7269D.i(new a());
                return;
            }
            AppCompatDelegateImpl.this.f7266A.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f7266A.setVisibility(0);
        }
    }

    /* loaded from: classes.dex */
    public class e extends T {
        public e() {
        }

        @Override // androidx.core.view.S
        public void b(View view) {
            AppCompatDelegateImpl.this.f7266A.setAlpha(1.0f);
            AppCompatDelegateImpl.this.f7269D.i(null);
            AppCompatDelegateImpl.this.f7269D = null;
        }

        @Override // androidx.core.view.T, androidx.core.view.S
        public void c(View view) {
            AppCompatDelegateImpl.this.f7266A.setVisibility(0);
            if (AppCompatDelegateImpl.this.f7266A.getParent() instanceof View) {
                K.f0((View) AppCompatDelegateImpl.this.f7266A.getParent());
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements androidx.appcompat.app.a {
        public f() {
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        boolean a(int i10);

        View onCreatePanelView(int i10);
    }

    /* loaded from: classes.dex */
    public final class h implements MenuPresenter.Callback {
        public h() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
            AppCompatDelegateImpl.this.Y(menuBuilder);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback u02 = AppCompatDelegateImpl.this.u0();
            if (u02 != null) {
                u02.onMenuOpened(108, menuBuilder);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class i implements AbstractC1145b.a {

        /* renamed from: a, reason: collision with root package name */
        public AbstractC1145b.a f7348a;

        /* loaded from: classes.dex */
        public class a extends T {
            public a() {
            }

            @Override // androidx.core.view.S
            public void b(View view) {
                AppCompatDelegateImpl.this.f7266A.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.f7267B;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.f7266A.getParent() instanceof View) {
                    K.f0((View) AppCompatDelegateImpl.this.f7266A.getParent());
                }
                AppCompatDelegateImpl.this.f7266A.k();
                AppCompatDelegateImpl.this.f7269D.i(null);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.f7269D = null;
                K.f0(appCompatDelegateImpl2.f7272G);
            }
        }

        public i(AbstractC1145b.a aVar) {
            this.f7348a = aVar;
        }

        @Override // j.AbstractC1145b.a
        public boolean a(AbstractC1145b abstractC1145b, Menu menu) {
            return this.f7348a.a(abstractC1145b, menu);
        }

        @Override // j.AbstractC1145b.a
        public void b(AbstractC1145b abstractC1145b) {
            this.f7348a.b(abstractC1145b);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.f7267B != null) {
                appCompatDelegateImpl.f7305l.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.f7268C);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.f7266A != null) {
                appCompatDelegateImpl2.i0();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.f7269D = K.d(appCompatDelegateImpl3.f7266A).b(0.0f);
                AppCompatDelegateImpl.this.f7269D.i(new a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            androidx.appcompat.app.c cVar = appCompatDelegateImpl4.f7309n;
            if (cVar != null) {
                cVar.onSupportActionModeFinished(appCompatDelegateImpl4.f7317z);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.f7317z = null;
            K.f0(appCompatDelegateImpl5.f7272G);
            AppCompatDelegateImpl.this.b1();
        }

        @Override // j.AbstractC1145b.a
        public boolean c(AbstractC1145b abstractC1145b, MenuItem menuItem) {
            return this.f7348a.c(abstractC1145b, menuItem);
        }

        @Override // j.AbstractC1145b.a
        public boolean d(AbstractC1145b abstractC1145b, Menu menu) {
            K.f0(AppCompatDelegateImpl.this.f7272G);
            return this.f7348a.d(abstractC1145b, menu);
        }
    }

    /* loaded from: classes.dex */
    public static class j {
        public static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        public static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    /* loaded from: classes.dex */
    public static class k {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (!locales.equals(locales2)) {
                configuration3.setLocales(locales2);
                configuration3.locale = configuration2.locale;
            }
        }

        public static F.e b(Configuration configuration) {
            return F.e.b(configuration.getLocales().toLanguageTags());
        }

        public static void c(F.e eVar) {
            LocaleList.setDefault(LocaleList.forLanguageTags(eVar.e()));
        }

        public static void d(Configuration configuration, F.e eVar) {
            configuration.setLocales(LocaleList.forLanguageTags(eVar.e()));
        }
    }

    /* loaded from: classes.dex */
    public static class l {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i10 = configuration.colorMode & 3;
            int i11 = configuration2.colorMode;
            if (i10 != (i11 & 3)) {
                configuration3.colorMode |= i11 & 3;
            }
            int i12 = configuration.colorMode & 12;
            int i13 = configuration2.colorMode;
            if (i12 != (i13 & 12)) {
                configuration3.colorMode |= i13 & 12;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class m {
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback b(Object obj, final AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.g
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    AppCompatDelegateImpl.this.C0();
                }
            };
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        public static void c(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* loaded from: classes.dex */
    public class n extends j.i {

        /* renamed from: b, reason: collision with root package name */
        public g f7351b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f7352c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f7353d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f7354e;

        public n(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f7353d = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f7353d = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.f7352c = true;
                callback.onContentChanged();
            } finally {
                this.f7352c = false;
            }
        }

        public void d(Window.Callback callback, int i10, Menu menu) {
            try {
                this.f7354e = true;
                callback.onPanelClosed(i10, menu);
            } finally {
                this.f7354e = false;
            }
        }

        @Override // j.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.f7353d) {
                return a().dispatchKeyEvent(keyEvent);
            }
            if (!AppCompatDelegateImpl.this.g0(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
                return false;
            }
            return true;
        }

        @Override // j.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (!super.dispatchKeyShortcutEvent(keyEvent) && !AppCompatDelegateImpl.this.F0(keyEvent.getKeyCode(), keyEvent)) {
                return false;
            }
            return true;
        }

        public void e(g gVar) {
            this.f7351b = gVar;
        }

        public final ActionMode f(ActionMode.Callback callback) {
            C1149f.a aVar = new C1149f.a(AppCompatDelegateImpl.this.f7303k, callback);
            AbstractC1145b N10 = AppCompatDelegateImpl.this.N(aVar);
            if (N10 != null) {
                return aVar.e(N10);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.f7352c) {
                a().onContentChanged();
            }
        }

        @Override // j.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i10, Menu menu) {
            if (i10 == 0 && !(menu instanceof MenuBuilder)) {
                return false;
            }
            return super.onCreatePanelMenu(i10, menu);
        }

        @Override // j.i, android.view.Window.Callback
        public View onCreatePanelView(int i10) {
            View onCreatePanelView;
            g gVar = this.f7351b;
            if (gVar != null && (onCreatePanelView = gVar.onCreatePanelView(i10)) != null) {
                return onCreatePanelView;
            }
            return super.onCreatePanelView(i10);
        }

        @Override // j.i, android.view.Window.Callback
        public boolean onMenuOpened(int i10, Menu menu) {
            super.onMenuOpened(i10, menu);
            AppCompatDelegateImpl.this.I0(i10);
            return true;
        }

        @Override // j.i, android.view.Window.Callback
        public void onPanelClosed(int i10, Menu menu) {
            if (this.f7354e) {
                a().onPanelClosed(i10, menu);
            } else {
                super.onPanelClosed(i10, menu);
                AppCompatDelegateImpl.this.J0(i10);
            }
        }

        @Override // j.i, android.view.Window.Callback
        public boolean onPreparePanel(int i10, View view, Menu menu) {
            MenuBuilder menuBuilder;
            if (menu instanceof MenuBuilder) {
                menuBuilder = (MenuBuilder) menu;
            } else {
                menuBuilder = null;
            }
            if (i10 == 0 && menuBuilder == null) {
                return false;
            }
            boolean z10 = true;
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            g gVar = this.f7351b;
            if (gVar == null || !gVar.a(i10)) {
                z10 = false;
            }
            if (!z10) {
                z10 = super.onPreparePanel(i10, view, menu);
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return z10;
        }

        @Override // j.i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i10) {
            MenuBuilder menuBuilder;
            PanelFeatureState s02 = AppCompatDelegateImpl.this.s0(0, true);
            if (s02 != null && (menuBuilder = s02.f7327j) != null) {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i10);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i10);
            }
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // j.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
            if (AppCompatDelegateImpl.this.A0() && i10 == 0) {
                return f(callback);
            }
            return super.onWindowStartingActionMode(callback, i10);
        }
    }

    /* loaded from: classes.dex */
    public class o extends p {

        /* renamed from: c, reason: collision with root package name */
        public final PowerManager f7356c;

        public o(Context context) {
            super();
            this.f7356c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public int c() {
            if (j.a(this.f7356c)) {
                return 2;
            }
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public void d() {
            AppCompatDelegateImpl.this.S();
        }
    }

    /* loaded from: classes.dex */
    public abstract class p {

        /* renamed from: a, reason: collision with root package name */
        public BroadcastReceiver f7358a;

        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                p.this.d();
            }
        }

        public p() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.f7358a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f7303k.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f7358a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter b10 = b();
            if (b10 != null && b10.countActions() != 0) {
                if (this.f7358a == null) {
                    this.f7358a = new a();
                }
                AppCompatDelegateImpl.this.f7303k.registerReceiver(this.f7358a, b10);
            }
        }
    }

    /* loaded from: classes.dex */
    public class q extends p {

        /* renamed from: c, reason: collision with root package name */
        public final androidx.appcompat.app.o f7361c;

        public q(androidx.appcompat.app.o oVar) {
            super();
            this.f7361c = oVar;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public int c() {
            if (this.f7361c.d()) {
                return 2;
            }
            return 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.p
        public void d() {
            AppCompatDelegateImpl.this.S();
        }
    }

    /* loaded from: classes.dex */
    public class r extends ContentFrameLayout {
        public r(Context context) {
            super(context);
        }

        public final boolean b(int i10, int i11) {
            if (i10 >= -5 && i11 >= -5 && i10 <= getWidth() + 5 && i11 <= getHeight() + 5) {
                return false;
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (!AppCompatDelegateImpl.this.g0(keyEvent) && !super.dispatchKeyEvent(keyEvent)) {
                return false;
            }
            return true;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                AppCompatDelegateImpl.this.a0(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i10) {
            setBackgroundDrawable(C0991a.b(getContext(), i10));
        }
    }

    /* loaded from: classes.dex */
    public final class s implements MenuPresenter.Callback {
        public s() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
            boolean z11;
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            if (rootMenu != menuBuilder) {
                z11 = true;
            } else {
                z11 = false;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z11) {
                menuBuilder = rootMenu;
            }
            PanelFeatureState l02 = appCompatDelegateImpl.l0(menuBuilder);
            if (l02 != null) {
                if (z11) {
                    AppCompatDelegateImpl.this.X(l02.f7318a, l02, rootMenu);
                    AppCompatDelegateImpl.this.b0(l02, true);
                } else {
                    AppCompatDelegateImpl.this.b0(l02, z10);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback u02;
            if (menuBuilder == menuBuilder.getRootMenu()) {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                if (appCompatDelegateImpl.f7277L && (u02 = appCompatDelegateImpl.u0()) != null && !AppCompatDelegateImpl.this.f7288W) {
                    u02.onMenuOpened(108, menuBuilder);
                    return true;
                }
                return true;
            }
            return true;
        }
    }

    public AppCompatDelegateImpl(Activity activity, androidx.appcompat.app.c cVar) {
        this(activity, null, cVar, activity);
    }

    public static Configuration m0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f10 = configuration.fontScale;
            float f11 = configuration2.fontScale;
            if (f10 != f11) {
                configuration3.fontScale = f11;
            }
            int i10 = configuration.mcc;
            int i11 = configuration2.mcc;
            if (i10 != i11) {
                configuration3.mcc = i11;
            }
            int i12 = configuration.mnc;
            int i13 = configuration2.mnc;
            if (i12 != i13) {
                configuration3.mnc = i13;
            }
            k.a(configuration, configuration2, configuration3);
            int i14 = configuration.touchscreen;
            int i15 = configuration2.touchscreen;
            if (i14 != i15) {
                configuration3.touchscreen = i15;
            }
            int i16 = configuration.keyboard;
            int i17 = configuration2.keyboard;
            if (i16 != i17) {
                configuration3.keyboard = i17;
            }
            int i18 = configuration.keyboardHidden;
            int i19 = configuration2.keyboardHidden;
            if (i18 != i19) {
                configuration3.keyboardHidden = i19;
            }
            int i20 = configuration.navigation;
            int i21 = configuration2.navigation;
            if (i20 != i21) {
                configuration3.navigation = i21;
            }
            int i22 = configuration.navigationHidden;
            int i23 = configuration2.navigationHidden;
            if (i22 != i23) {
                configuration3.navigationHidden = i23;
            }
            int i24 = configuration.orientation;
            int i25 = configuration2.orientation;
            if (i24 != i25) {
                configuration3.orientation = i25;
            }
            int i26 = configuration.screenLayout & 15;
            int i27 = configuration2.screenLayout;
            if (i26 != (i27 & 15)) {
                configuration3.screenLayout |= i27 & 15;
            }
            int i28 = configuration.screenLayout & 192;
            int i29 = configuration2.screenLayout;
            if (i28 != (i29 & 192)) {
                configuration3.screenLayout |= i29 & 192;
            }
            int i30 = configuration.screenLayout & 48;
            int i31 = configuration2.screenLayout;
            if (i30 != (i31 & 48)) {
                configuration3.screenLayout |= i31 & 48;
            }
            int i32 = configuration.screenLayout & ViewUtils.EDGE_TO_EDGE_FLAGS;
            int i33 = configuration2.screenLayout;
            if (i32 != (i33 & ViewUtils.EDGE_TO_EDGE_FLAGS)) {
                configuration3.screenLayout |= i33 & ViewUtils.EDGE_TO_EDGE_FLAGS;
            }
            l.a(configuration, configuration2, configuration3);
            int i34 = configuration.uiMode & 15;
            int i35 = configuration2.uiMode;
            if (i34 != (i35 & 15)) {
                configuration3.uiMode |= i35 & 15;
            }
            int i36 = configuration.uiMode & 48;
            int i37 = configuration2.uiMode;
            if (i36 != (i37 & 48)) {
                configuration3.uiMode |= i37 & 48;
            }
            int i38 = configuration.screenWidthDp;
            int i39 = configuration2.screenWidthDp;
            if (i38 != i39) {
                configuration3.screenWidthDp = i39;
            }
            int i40 = configuration.screenHeightDp;
            int i41 = configuration2.screenHeightDp;
            if (i40 != i41) {
                configuration3.screenHeightDp = i41;
            }
            int i42 = configuration.smallestScreenWidthDp;
            int i43 = configuration2.smallestScreenWidthDp;
            if (i42 != i43) {
                configuration3.smallestScreenWidthDp = i43;
            }
            int i44 = configuration.densityDpi;
            int i45 = configuration2.densityDpi;
            if (i44 != i45) {
                configuration3.densityDpi = i45;
            }
        }
        return configuration3;
    }

    @Override // androidx.appcompat.app.e
    public void A() {
        R(true, false);
    }

    public boolean A0() {
        return this.f7270E;
    }

    @Override // androidx.appcompat.app.e
    public void B() {
        ActionBar p10 = p();
        if (p10 != null) {
            p10.y(false);
        }
    }

    public int B0(Context context, int i10) {
        if (i10 == -100) {
            return -1;
        }
        if (i10 != -1) {
            if (i10 != 0) {
                if (i10 != 1 && i10 != 2) {
                    if (i10 == 3) {
                        return p0(context).c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            } else {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return q0(context).c();
            }
        }
        return i10;
    }

    public boolean C0() {
        boolean z10 = this.f7285T;
        this.f7285T = false;
        PanelFeatureState s02 = s0(0, false);
        if (s02 != null && s02.f7332o) {
            if (!z10) {
                b0(s02, true);
            }
            return true;
        }
        AbstractC1145b abstractC1145b = this.f7317z;
        if (abstractC1145b != null) {
            abstractC1145b.a();
            return true;
        }
        ActionBar p10 = p();
        if (p10 == null || !p10.h()) {
            return false;
        }
        return true;
    }

    public boolean D0(int i10, KeyEvent keyEvent) {
        boolean z10 = true;
        if (i10 != 4) {
            if (i10 == 82) {
                E0(0, keyEvent);
                return true;
            }
        } else {
            if ((keyEvent.getFlags() & 128) == 0) {
                z10 = false;
            }
            this.f7285T = z10;
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public boolean E(int i10) {
        int Q02 = Q0(i10);
        if (this.f7281P && Q02 == 108) {
            return false;
        }
        if (this.f7277L && Q02 == 1) {
            this.f7277L = false;
        }
        if (Q02 != 1) {
            if (Q02 != 2) {
                if (Q02 != 5) {
                    if (Q02 != 10) {
                        if (Q02 != 108) {
                            if (Q02 != 109) {
                                return this.f7305l.requestFeature(Q02);
                            }
                            X0();
                            this.f7278M = true;
                            return true;
                        }
                        X0();
                        this.f7277L = true;
                        return true;
                    }
                    X0();
                    this.f7279N = true;
                    return true;
                }
                X0();
                this.f7276K = true;
                return true;
            }
            X0();
            this.f7275J = true;
            return true;
        }
        X0();
        this.f7281P = true;
        return true;
    }

    public final boolean E0(int i10, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState s02 = s0(i10, true);
            if (!s02.f7332o) {
                return O0(s02, keyEvent);
            }
            return false;
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void F(int i10) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.f7272G.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f7303k).inflate(i10, viewGroup);
        this.f7307m.c(this.f7305l.getCallback());
    }

    public boolean F0(int i10, KeyEvent keyEvent) {
        ActionBar p10 = p();
        if (p10 != null && p10.p(i10, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.f7284S;
        if (panelFeatureState != null && N0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.f7284S;
            if (panelFeatureState2 != null) {
                panelFeatureState2.f7331n = true;
            }
            return true;
        }
        if (this.f7284S == null) {
            PanelFeatureState s02 = s0(0, true);
            O0(s02, keyEvent);
            boolean N02 = N0(s02, keyEvent.getKeyCode(), keyEvent, 1);
            s02.f7330m = false;
            if (N02) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void G(View view) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.f7272G.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f7307m.c(this.f7305l.getCallback());
    }

    public boolean G0(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            if (i10 == 82) {
                H0(0, keyEvent);
                return true;
            }
        } else if (C0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void H(View view, ViewGroup.LayoutParams layoutParams) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.f7272G.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f7307m.c(this.f7305l.getCallback());
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x005a, code lost:
    
        if (O0(r2, r6) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean H0(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            j.b r0 = r4.f7317z
            r1 = 0
            if (r0 == 0) goto L6
            return r1
        L6:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r4.s0(r5, r0)
            if (r5 != 0) goto L43
            androidx.appcompat.widget.s r5 = r4.f7314r
            if (r5 == 0) goto L43
            boolean r5 = r5.d()
            if (r5 == 0) goto L43
            android.content.Context r5 = r4.f7303k
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            if (r5 != 0) goto L43
            androidx.appcompat.widget.s r5 = r4.f7314r
            boolean r5 = r5.b()
            if (r5 != 0) goto L3c
            boolean r5 = r4.f7288W
            if (r5 != 0) goto L60
            boolean r5 = r4.O0(r2, r6)
            if (r5 == 0) goto L60
            androidx.appcompat.widget.s r5 = r4.f7314r
            boolean r0 = r5.g()
            goto L66
        L3c:
            androidx.appcompat.widget.s r5 = r4.f7314r
            boolean r0 = r5.f()
            goto L66
        L43:
            boolean r5 = r2.f7332o
            if (r5 != 0) goto L62
            boolean r3 = r2.f7331n
            if (r3 == 0) goto L4c
            goto L62
        L4c:
            boolean r5 = r2.f7330m
            if (r5 == 0) goto L60
            boolean r5 = r2.f7335r
            if (r5 == 0) goto L5c
            r2.f7330m = r1
            boolean r5 = r4.O0(r2, r6)
            if (r5 == 0) goto L60
        L5c:
            r4.L0(r2, r6)
            goto L66
        L60:
            r0 = r1
            goto L66
        L62:
            r4.b0(r2, r0)
            r0 = r5
        L66:
            if (r0 == 0) goto L83
            android.content.Context r4 = r4.f7303k
            android.content.Context r4 = r4.getApplicationContext()
            java.lang.String r5 = "audio"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.media.AudioManager r4 = (android.media.AudioManager) r4
            if (r4 == 0) goto L7c
            r4.playSoundEffect(r1)
            goto L83
        L7c:
            java.lang.String r4 = "AppCompatDelegate"
            java.lang.String r5 = "Couldn't get audio manager"
            android.util.Log.w(r4, r5)
        L83:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.H0(int, android.view.KeyEvent):boolean");
    }

    @Override // androidx.appcompat.app.e
    public void I(int i10) {
        if (this.f7290Y != i10) {
            this.f7290Y = i10;
            if (this.f7286U) {
                S();
            }
        }
    }

    public void I0(int i10) {
        ActionBar p10;
        if (i10 == 108 && (p10 = p()) != null) {
            p10.i(true);
        }
    }

    @Override // androidx.appcompat.app.e
    public void J(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.J(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.f7308m0;
        if (onBackInvokedDispatcher2 != null && (onBackInvokedCallback = this.f7310n0) != null) {
            m.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.f7310n0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.f7301j;
            if ((obj instanceof Activity) && ((Activity) obj).getWindow() != null) {
                this.f7308m0 = m.a((Activity) this.f7301j);
                b1();
            }
        }
        this.f7308m0 = onBackInvokedDispatcher;
        b1();
    }

    public void J0(int i10) {
        if (i10 == 108) {
            ActionBar p10 = p();
            if (p10 != null) {
                p10.i(false);
                return;
            }
            return;
        }
        if (i10 == 0) {
            PanelFeatureState s02 = s0(i10, true);
            if (s02.f7332o) {
                b0(s02, false);
            }
        }
    }

    @Override // androidx.appcompat.app.e
    public void K(Toolbar toolbar) {
        if (!(this.f7301j instanceof Activity)) {
            return;
        }
        ActionBar p10 = p();
        if (!(p10 instanceof androidx.appcompat.app.p)) {
            this.f7312p = null;
            if (p10 != null) {
                p10.o();
            }
            this.f7311o = null;
            if (toolbar != null) {
                androidx.appcompat.app.m mVar = new androidx.appcompat.app.m(toolbar, t0(), this.f7307m);
                this.f7311o = mVar;
                this.f7307m.e(mVar.f7392c);
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.f7307m.e(null);
            }
            r();
            return;
        }
        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }

    @Override // androidx.appcompat.app.e
    public void L(int i10) {
        this.f7291Z = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void L0(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.L0(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    @Override // androidx.appcompat.app.e
    public final void M(CharSequence charSequence) {
        this.f7313q = charSequence;
        InterfaceC0444s interfaceC0444s = this.f7314r;
        if (interfaceC0444s != null) {
            interfaceC0444s.setWindowTitle(charSequence);
            return;
        }
        if (M0() != null) {
            M0().B(charSequence);
            return;
        }
        TextView textView = this.f7273H;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final ActionBar M0() {
        return this.f7311o;
    }

    @Override // androidx.appcompat.app.e
    public AbstractC1145b N(AbstractC1145b.a aVar) {
        androidx.appcompat.app.c cVar;
        if (aVar != null) {
            AbstractC1145b abstractC1145b = this.f7317z;
            if (abstractC1145b != null) {
                abstractC1145b.a();
            }
            i iVar = new i(aVar);
            ActionBar p10 = p();
            if (p10 != null) {
                AbstractC1145b D10 = p10.D(iVar);
                this.f7317z = D10;
                if (D10 != null && (cVar = this.f7309n) != null) {
                    cVar.onSupportActionModeStarted(D10);
                }
            }
            if (this.f7317z == null) {
                this.f7317z = W0(iVar);
            }
            b1();
            return this.f7317z;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public final boolean N0(PanelFeatureState panelFeatureState, int i10, KeyEvent keyEvent, int i11) {
        MenuBuilder menuBuilder;
        boolean z10 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f7330m || O0(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.f7327j) != null) {
            z10 = menuBuilder.performShortcut(i10, keyEvent, i11);
        }
        if (z10 && (i11 & 1) == 0 && this.f7314r == null) {
            b0(panelFeatureState, true);
        }
        return z10;
    }

    public final boolean O0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        boolean z10;
        InterfaceC0444s interfaceC0444s;
        int i10;
        boolean z11;
        InterfaceC0444s interfaceC0444s2;
        InterfaceC0444s interfaceC0444s3;
        if (this.f7288W) {
            return false;
        }
        if (panelFeatureState.f7330m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.f7284S;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            b0(panelFeatureState2, false);
        }
        Window.Callback u02 = u0();
        if (u02 != null) {
            panelFeatureState.f7326i = u02.onCreatePanelView(panelFeatureState.f7318a);
        }
        int i11 = panelFeatureState.f7318a;
        if (i11 != 0 && i11 != 108) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10 && (interfaceC0444s3 = this.f7314r) != null) {
            interfaceC0444s3.c();
        }
        if (panelFeatureState.f7326i == null && (!z10 || !(M0() instanceof androidx.appcompat.app.m))) {
            MenuBuilder menuBuilder = panelFeatureState.f7327j;
            if (menuBuilder == null || panelFeatureState.f7335r) {
                if (menuBuilder == null && (!y0(panelFeatureState) || panelFeatureState.f7327j == null)) {
                    return false;
                }
                if (z10 && this.f7314r != null) {
                    if (this.f7315x == null) {
                        this.f7315x = new h();
                    }
                    this.f7314r.a(panelFeatureState.f7327j, this.f7315x);
                }
                panelFeatureState.f7327j.stopDispatchingItemsChanged();
                if (!u02.onCreatePanelMenu(panelFeatureState.f7318a, panelFeatureState.f7327j)) {
                    panelFeatureState.c(null);
                    if (z10 && (interfaceC0444s = this.f7314r) != null) {
                        interfaceC0444s.a(null, this.f7315x);
                    }
                    return false;
                }
                panelFeatureState.f7335r = false;
            }
            panelFeatureState.f7327j.stopDispatchingItemsChanged();
            Bundle bundle = panelFeatureState.f7336s;
            if (bundle != null) {
                panelFeatureState.f7327j.restoreActionViewStates(bundle);
                panelFeatureState.f7336s = null;
            }
            if (!u02.onPreparePanel(0, panelFeatureState.f7326i, panelFeatureState.f7327j)) {
                if (z10 && (interfaceC0444s2 = this.f7314r) != null) {
                    interfaceC0444s2.a(null, this.f7315x);
                }
                panelFeatureState.f7327j.startDispatchingItemsChanged();
                return false;
            }
            if (keyEvent != null) {
                i10 = keyEvent.getDeviceId();
            } else {
                i10 = -1;
            }
            if (KeyCharacterMap.load(i10).getKeyboardType() != 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            panelFeatureState.f7333p = z11;
            panelFeatureState.f7327j.setQwertyMode(z11);
            panelFeatureState.f7327j.startDispatchingItemsChanged();
        }
        panelFeatureState.f7330m = true;
        panelFeatureState.f7331n = false;
        this.f7284S = panelFeatureState;
        return true;
    }

    public final void P0(boolean z10) {
        InterfaceC0444s interfaceC0444s = this.f7314r;
        if (interfaceC0444s != null && interfaceC0444s.d() && (!ViewConfiguration.get(this.f7303k).hasPermanentMenuKey() || this.f7314r.e())) {
            Window.Callback u02 = u0();
            if (this.f7314r.b() && z10) {
                this.f7314r.f();
                if (!this.f7288W) {
                    u02.onPanelClosed(108, s0(0, true).f7327j);
                    return;
                }
                return;
            }
            if (u02 != null && !this.f7288W) {
                if (this.f7296e0 && (this.f7297f0 & 1) != 0) {
                    this.f7305l.getDecorView().removeCallbacks(this.f7298g0);
                    this.f7298g0.run();
                }
                PanelFeatureState s02 = s0(0, true);
                MenuBuilder menuBuilder = s02.f7327j;
                if (menuBuilder != null && !s02.f7335r && u02.onPreparePanel(0, s02.f7326i, menuBuilder)) {
                    u02.onMenuOpened(108, s02.f7327j);
                    this.f7314r.g();
                    return;
                }
                return;
            }
            return;
        }
        PanelFeatureState s03 = s0(0, true);
        s03.f7334q = true;
        b0(s03, false);
        L0(s03, null);
    }

    public final boolean Q(boolean z10) {
        return R(z10, true);
    }

    public final int Q0(int i10) {
        if (i10 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i10 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
        return i10;
    }

    public final boolean R(boolean z10, boolean z11) {
        if (this.f7288W) {
            return false;
        }
        int W10 = W();
        boolean a12 = a1(B0(this.f7303k, W10), null, z10);
        if (W10 == 0) {
            q0(this.f7303k).e();
        } else {
            p pVar = this.f7294c0;
            if (pVar != null) {
                pVar.a();
            }
        }
        if (W10 == 3) {
            p0(this.f7303k).e();
        } else {
            p pVar2 = this.f7295d0;
            if (pVar2 != null) {
                pVar2.a();
            }
        }
        return a12;
    }

    public void R0(Configuration configuration, F.e eVar) {
        k.d(configuration, eVar);
    }

    public boolean S() {
        return Q(true);
    }

    public void S0(F.e eVar) {
        k.c(eVar);
    }

    public final void T() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f7272G.findViewById(R.id.content);
        View decorView = this.f7305l.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f7303k.obtainStyledAttributes(e.j.f30283A0);
        obtainStyledAttributes.getValue(e.j.f30343M0, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(e.j.f30348N0, contentFrameLayout.getMinWidthMinor());
        int i10 = e.j.f30333K0;
        if (obtainStyledAttributes.hasValue(i10)) {
            obtainStyledAttributes.getValue(i10, contentFrameLayout.getFixedWidthMajor());
        }
        int i11 = e.j.f30338L0;
        if (obtainStyledAttributes.hasValue(i11)) {
            obtainStyledAttributes.getValue(i11, contentFrameLayout.getFixedWidthMinor());
        }
        int i12 = e.j.f30323I0;
        if (obtainStyledAttributes.hasValue(i12)) {
            obtainStyledAttributes.getValue(i12, contentFrameLayout.getFixedHeightMajor());
        }
        int i13 = e.j.f30328J0;
        if (obtainStyledAttributes.hasValue(i13)) {
            obtainStyledAttributes.getValue(i13, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public final boolean T0() {
        ViewGroup viewGroup;
        if (this.f7271F && (viewGroup = this.f7272G) != null && viewGroup.isLaidOut()) {
            return true;
        }
        return false;
    }

    public final void U(Window window) {
        if (this.f7305l == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof n)) {
                n nVar = new n(callback);
                this.f7307m = nVar;
                window.setCallback(nVar);
                androidx.appcompat.widget.K v10 = androidx.appcompat.widget.K.v(this.f7303k, null, f7264q0);
                Drawable h10 = v10.h(0);
                if (h10 != null) {
                    window.setBackgroundDrawable(h10);
                }
                v10.y();
                this.f7305l = window;
                if (this.f7308m0 == null) {
                    J(null);
                    return;
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public final boolean U0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f7305l.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ((View) viewParent).isAttachedToWindow()) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    public F.e V(Context context) {
        return null;
    }

    public boolean V0() {
        if (this.f7308m0 == null) {
            return false;
        }
        PanelFeatureState s02 = s0(0, false);
        if ((s02 == null || !s02.f7332o) && this.f7317z == null) {
            return false;
        }
        return true;
    }

    public final int W() {
        int i10 = this.f7290Y;
        if (i10 == -100) {
            return androidx.appcompat.app.e.k();
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public j.AbstractC1145b W0(j.AbstractC1145b.a r8) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.W0(j.b$a):j.b");
    }

    public void X(int i10, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i10 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.f7283R;
                if (i10 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i10];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f7327j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f7332o) && !this.f7288W) {
            this.f7307m.d(this.f7305l.getCallback(), i10, menu);
        }
    }

    public final void X0() {
        if (!this.f7271F) {
        } else {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public void Y(MenuBuilder menuBuilder) {
        if (this.f7282Q) {
            return;
        }
        this.f7282Q = true;
        this.f7314r.i();
        Window.Callback u02 = u0();
        if (u02 != null && !this.f7288W) {
            u02.onPanelClosed(108, menuBuilder);
        }
        this.f7282Q = false;
    }

    public final AppCompatActivity Y0() {
        for (Context context = this.f7303k; context != null; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    public final void Z() {
        p pVar = this.f7294c0;
        if (pVar != null) {
            pVar.a();
        }
        p pVar2 = this.f7295d0;
        if (pVar2 != null) {
            pVar2.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z0(Configuration configuration) {
        Activity activity = (Activity) this.f7301j;
        if (activity instanceof InterfaceC0492o) {
            if (((InterfaceC0492o) activity).getLifecycle().b().b(Lifecycle.State.CREATED)) {
                activity.onConfigurationChanged(configuration);
            }
        } else if (this.f7287V && !this.f7288W) {
            activity.onConfigurationChanged(configuration);
        }
    }

    public void a0(int i10) {
        b0(s0(i10, true), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a1(int r10, F.e r11, boolean r12) {
        /*
            r9 = this;
            android.content.Context r1 = r9.f7303k
            r4 = 0
            r5 = 0
            r0 = r9
            r2 = r10
            r3 = r11
            android.content.res.Configuration r0 = r0.c0(r1, r2, r3, r4, r5)
            android.content.Context r1 = r9.f7303k
            int r1 = r9.o0(r1)
            android.content.res.Configuration r2 = r9.f7289X
            if (r2 != 0) goto L1f
            android.content.Context r2 = r9.f7303k
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
        L1f:
            int r3 = r2.uiMode
            r3 = r3 & 48
            int r4 = r0.uiMode
            r4 = r4 & 48
            F.e r2 = r9.r0(r2)
            r5 = 0
            if (r11 != 0) goto L30
            r6 = r5
            goto L34
        L30:
            F.e r6 = r9.r0(r0)
        L34:
            r7 = 0
            if (r3 == r4) goto L3a
            r3 = 512(0x200, float:7.175E-43)
            goto L3b
        L3a:
            r3 = r7
        L3b:
            if (r6 == 0) goto L45
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L45
            r3 = r3 | 8196(0x2004, float:1.1485E-41)
        L45:
            int r2 = ~r1
            r2 = r2 & r3
            r8 = 1
            if (r2 == 0) goto L86
            if (r12 == 0) goto L86
            boolean r12 = r9.f7286U
            if (r12 == 0) goto L86
            boolean r12 = androidx.appcompat.app.AppCompatDelegateImpl.f7265r0
            if (r12 != 0) goto L58
            boolean r12 = r9.f7287V
            if (r12 == 0) goto L86
        L58:
            java.lang.Object r12 = r9.f7301j
            boolean r2 = r12 instanceof android.app.Activity
            if (r2 == 0) goto L86
            android.app.Activity r12 = (android.app.Activity) r12
            boolean r12 = r12.isChild()
            if (r12 != 0) goto L86
            r12 = r3 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L7d
            java.lang.Object r12 = r9.f7301j
            android.app.Activity r12 = (android.app.Activity) r12
            android.view.Window r12 = r12.getWindow()
            android.view.View r12 = r12.getDecorView()
            int r0 = r0.getLayoutDirection()
            r12.setLayoutDirection(r0)
        L7d:
            java.lang.Object r12 = r9.f7301j
            android.app.Activity r12 = (android.app.Activity) r12
            androidx.core.app.a.p(r12)
            r12 = r8
            goto L87
        L86:
            r12 = r7
        L87:
            if (r12 != 0) goto L94
            if (r3 == 0) goto L94
            r12 = r3 & r1
            if (r12 != r3) goto L90
            r7 = r8
        L90:
            r9.c1(r4, r6, r7, r5)
            goto L95
        L94:
            r8 = r12
        L95:
            if (r8 == 0) goto Lb1
            java.lang.Object r12 = r9.f7301j
            boolean r0 = r12 instanceof androidx.appcompat.app.AppCompatActivity
            if (r0 == 0) goto Lb1
            r0 = r3 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto La6
            androidx.appcompat.app.AppCompatActivity r12 = (androidx.appcompat.app.AppCompatActivity) r12
            r12.onNightModeChanged(r10)
        La6:
            r10 = r3 & 4
            if (r10 == 0) goto Lb1
            java.lang.Object r10 = r9.f7301j
            androidx.appcompat.app.AppCompatActivity r10 = (androidx.appcompat.app.AppCompatActivity) r10
            r10.onLocalesChanged(r11)
        Lb1:
            if (r6 == 0) goto Lc4
            android.content.Context r10 = r9.f7303k
            android.content.res.Resources r10 = r10.getResources()
            android.content.res.Configuration r10 = r10.getConfiguration()
            F.e r10 = r9.r0(r10)
            r9.S0(r10)
        Lc4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.a1(int, F.e, boolean):boolean");
    }

    public void b0(PanelFeatureState panelFeatureState, boolean z10) {
        ViewGroup viewGroup;
        InterfaceC0444s interfaceC0444s;
        if (z10 && panelFeatureState.f7318a == 0 && (interfaceC0444s = this.f7314r) != null && interfaceC0444s.b()) {
            Y(panelFeatureState.f7327j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f7303k.getSystemService("window");
        if (windowManager != null && panelFeatureState.f7332o && (viewGroup = panelFeatureState.f7324g) != null) {
            windowManager.removeView(viewGroup);
            if (z10) {
                X(panelFeatureState.f7318a, panelFeatureState, null);
            }
        }
        panelFeatureState.f7330m = false;
        panelFeatureState.f7331n = false;
        panelFeatureState.f7332o = false;
        panelFeatureState.f7325h = null;
        panelFeatureState.f7334q = true;
        if (this.f7284S == panelFeatureState) {
            this.f7284S = null;
        }
        if (panelFeatureState.f7318a == 0) {
            b1();
        }
    }

    public void b1() {
        OnBackInvokedCallback onBackInvokedCallback;
        boolean V02 = V0();
        if (V02 && this.f7310n0 == null) {
            this.f7310n0 = m.b(this.f7308m0, this);
        } else if (!V02 && (onBackInvokedCallback = this.f7310n0) != null) {
            m.c(this.f7308m0, onBackInvokedCallback);
            this.f7310n0 = null;
        }
    }

    @Override // androidx.appcompat.app.e
    public void c(View view, ViewGroup.LayoutParams layoutParams) {
        j0();
        ((ViewGroup) this.f7272G.findViewById(R.id.content)).addView(view, layoutParams);
        this.f7307m.c(this.f7305l.getCallback());
    }

    public final Configuration c0(Context context, int i10, F.e eVar, Configuration configuration, boolean z10) {
        int i11;
        if (i10 != 1) {
            if (i10 != 2) {
                if (z10) {
                    i11 = 0;
                } else {
                    i11 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
                }
            } else {
                i11 = 32;
            }
        } else {
            i11 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i11 | (configuration2.uiMode & (-49));
        if (eVar != null) {
            R0(configuration2, eVar);
        }
        return configuration2;
    }

    public final void c1(int i10, F.e eVar, boolean z10, Configuration configuration) {
        Resources resources = this.f7303k.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i10 | (resources.getConfiguration().uiMode & (-49));
        if (eVar != null) {
            R0(configuration2, eVar);
        }
        resources.updateConfiguration(configuration2, null);
        int i11 = this.f7291Z;
        if (i11 != 0) {
            this.f7303k.setTheme(i11);
            this.f7303k.getTheme().applyStyle(this.f7291Z, true);
        }
        if (z10 && (this.f7301j instanceof Activity)) {
            Z0(configuration2);
        }
    }

    public final ViewGroup d0() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.f7303k.obtainStyledAttributes(e.j.f30283A0);
        int i10 = e.j.f30308F0;
        if (obtainStyledAttributes.hasValue(i10)) {
            if (obtainStyledAttributes.getBoolean(e.j.f30353O0, false)) {
                E(1);
            } else if (obtainStyledAttributes.getBoolean(i10, false)) {
                E(108);
            }
            if (obtainStyledAttributes.getBoolean(e.j.f30313G0, false)) {
                E(109);
            }
            if (obtainStyledAttributes.getBoolean(e.j.f30318H0, false)) {
                E(10);
            }
            this.f7280O = obtainStyledAttributes.getBoolean(e.j.f30288B0, false);
            obtainStyledAttributes.recycle();
            k0();
            this.f7305l.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f7303k);
            if (!this.f7281P) {
                if (this.f7280O) {
                    viewGroup = (ViewGroup) from.inflate(e.g.f30247h, (ViewGroup) null);
                    this.f7278M = false;
                    this.f7277L = false;
                } else if (this.f7277L) {
                    TypedValue typedValue = new TypedValue();
                    this.f7303k.getTheme().resolveAttribute(C0961a.f30107f, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        context = new C1147d(this.f7303k, typedValue.resourceId);
                    } else {
                        context = this.f7303k;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(e.g.f30257r, (ViewGroup) null);
                    InterfaceC0444s interfaceC0444s = (InterfaceC0444s) viewGroup.findViewById(e.f.f30230q);
                    this.f7314r = interfaceC0444s;
                    interfaceC0444s.setWindowCallback(u0());
                    if (this.f7278M) {
                        this.f7314r.h(109);
                    }
                    if (this.f7275J) {
                        this.f7314r.h(2);
                    }
                    if (this.f7276K) {
                        this.f7314r.h(5);
                    }
                } else {
                    viewGroup = null;
                }
            } else {
                viewGroup = this.f7279N ? (ViewGroup) from.inflate(e.g.f30256q, (ViewGroup) null) : (ViewGroup) from.inflate(e.g.f30255p, (ViewGroup) null);
            }
            if (viewGroup != null) {
                K.z0(viewGroup, new b());
                if (this.f7314r == null) {
                    this.f7273H = (TextView) viewGroup.findViewById(e.f.f30210R);
                }
                S.c(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(e.f.f30215b);
                ViewGroup viewGroup2 = (ViewGroup) this.f7305l.findViewById(R.id.content);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(R.id.content);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground(null);
                    }
                }
                this.f7305l.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new c());
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f7277L + ", windowActionBarOverlay: " + this.f7278M + ", android:windowIsFloating: " + this.f7280O + ", windowActionModeOverlay: " + this.f7279N + ", windowNoTitle: " + this.f7281P + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    public final int d1(X x10, Rect rect) {
        int i10;
        boolean z10;
        int k10;
        int l10;
        boolean z11;
        int i11 = 0;
        if (x10 != null) {
            i10 = x10.m();
        } else if (rect != null) {
            i10 = rect.top;
        } else {
            i10 = 0;
        }
        ActionBarContextView actionBarContextView = this.f7266A;
        if (actionBarContextView != null && (actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f7266A.getLayoutParams();
            boolean z12 = true;
            if (this.f7266A.isShown()) {
                if (this.f7300i0 == null) {
                    this.f7300i0 = new Rect();
                    this.f7302j0 = new Rect();
                }
                Rect rect2 = this.f7300i0;
                Rect rect3 = this.f7302j0;
                if (x10 == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(x10.k(), x10.m(), x10.l(), x10.j());
                }
                S.a(this.f7272G, rect2, rect3);
                int i12 = rect2.top;
                int i13 = rect2.left;
                int i14 = rect2.right;
                X C10 = K.C(this.f7272G);
                if (C10 == null) {
                    k10 = 0;
                } else {
                    k10 = C10.k();
                }
                if (C10 == null) {
                    l10 = 0;
                } else {
                    l10 = C10.l();
                }
                if (marginLayoutParams.topMargin == i12 && marginLayoutParams.leftMargin == i13 && marginLayoutParams.rightMargin == i14) {
                    z11 = false;
                } else {
                    marginLayoutParams.topMargin = i12;
                    marginLayoutParams.leftMargin = i13;
                    marginLayoutParams.rightMargin = i14;
                    z11 = true;
                }
                if (i12 > 0 && this.f7274I == null) {
                    View view = new View(this.f7303k);
                    this.f7274I = view;
                    view.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = k10;
                    layoutParams.rightMargin = l10;
                    this.f7272G.addView(this.f7274I, -1, layoutParams);
                } else {
                    View view2 = this.f7274I;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i15 = marginLayoutParams2.height;
                        int i16 = marginLayoutParams.topMargin;
                        if (i15 != i16 || marginLayoutParams2.leftMargin != k10 || marginLayoutParams2.rightMargin != l10) {
                            marginLayoutParams2.height = i16;
                            marginLayoutParams2.leftMargin = k10;
                            marginLayoutParams2.rightMargin = l10;
                            this.f7274I.setLayoutParams(marginLayoutParams2);
                        }
                    }
                }
                View view3 = this.f7274I;
                if (view3 == null) {
                    z12 = false;
                }
                if (z12 && view3.getVisibility() != 0) {
                    e1(this.f7274I);
                }
                if (!this.f7279N && z12) {
                    i10 = 0;
                }
                z10 = z12;
                z12 = z11;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z10 = false;
            } else {
                z10 = false;
                z12 = false;
            }
            if (z12) {
                this.f7266A.setLayoutParams(marginLayoutParams);
            }
        } else {
            z10 = false;
        }
        View view4 = this.f7274I;
        if (view4 != null) {
            if (!z10) {
                i11 = 8;
            }
            view4.setVisibility(i11);
        }
        return i10;
    }

    @Override // androidx.appcompat.app.e
    public Context e(Context context) {
        Configuration configuration;
        this.f7286U = true;
        int B02 = B0(context, W());
        if (androidx.appcompat.app.e.s(context)) {
            androidx.appcompat.app.e.P(context);
        }
        F.e V10 = V(context);
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(c0(context, B02, V10, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof C1147d) {
            try {
                ((C1147d) context).a(c0(context, B02, V10, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f7265r0) {
            return super.e(context);
        }
        Configuration configuration2 = new Configuration();
        configuration2.uiMode = -1;
        configuration2.fontScale = 0.0f;
        Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
        Configuration configuration4 = context.getResources().getConfiguration();
        configuration3.uiMode = configuration4.uiMode;
        if (!configuration3.equals(configuration4)) {
            configuration = m0(configuration3, configuration4);
        } else {
            configuration = null;
        }
        Configuration c02 = c0(context, B02, V10, configuration, true);
        C1147d c1147d = new C1147d(context, e.i.f30280d);
        c1147d.a(c02);
        try {
            if (context.getTheme() != null) {
                h.f.a(c1147d.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.e(c1147d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View e0(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z10;
        if (this.f7304k0 == null) {
            TypedArray obtainStyledAttributes = this.f7303k.obtainStyledAttributes(e.j.f30283A0);
            String string = obtainStyledAttributes.getString(e.j.f30303E0);
            obtainStyledAttributes.recycle();
            if (string == null) {
                this.f7304k0 = new androidx.appcompat.app.k();
            } else {
                try {
                    this.f7304k0 = (androidx.appcompat.app.k) this.f7303k.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f7304k0 = new androidx.appcompat.app.k();
                }
            }
        }
        boolean z11 = f7263p0;
        boolean z12 = false;
        if (z11) {
            if (this.f7306l0 == null) {
                this.f7306l0 = new androidx.appcompat.app.l();
            }
            if (this.f7306l0.a(attributeSet)) {
                z10 = true;
                return this.f7304k0.createView(view, str, context, attributeSet, z10, z11, true, androidx.appcompat.widget.Q.c());
            }
            if (attributeSet instanceof XmlPullParser) {
                if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    z12 = true;
                }
            } else {
                z12 = U0((ViewParent) view);
            }
        }
        z10 = z12;
        return this.f7304k0.createView(view, str, context, attributeSet, z10, z11, true, androidx.appcompat.widget.Q.c());
    }

    public final void e1(View view) {
        int c10;
        if ((K.H(view) & 8192) != 0) {
            c10 = androidx.core.content.b.c(this.f7303k, e.c.f30130b);
        } else {
            c10 = androidx.core.content.b.c(this.f7303k, e.c.f30129a);
        }
        view.setBackgroundColor(c10);
    }

    public void f0() {
        MenuBuilder menuBuilder;
        InterfaceC0444s interfaceC0444s = this.f7314r;
        if (interfaceC0444s != null) {
            interfaceC0444s.i();
        }
        if (this.f7267B != null) {
            this.f7305l.getDecorView().removeCallbacks(this.f7268C);
            if (this.f7267B.isShowing()) {
                try {
                    this.f7267B.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f7267B = null;
        }
        i0();
        PanelFeatureState s02 = s0(0, false);
        if (s02 != null && (menuBuilder = s02.f7327j) != null) {
            menuBuilder.close();
        }
    }

    public boolean g0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f7301j;
        if (((obj instanceof C0456k.a) || (obj instanceof androidx.appcompat.app.i)) && (decorView = this.f7305l.getDecorView()) != null && C0456k.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f7307m.b(this.f7305l.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            return D0(keyCode, keyEvent);
        }
        return G0(keyCode, keyEvent);
    }

    @Override // androidx.appcompat.app.e
    public <T extends View> T h(int i10) {
        j0();
        return (T) this.f7305l.findViewById(i10);
    }

    public void h0(int i10) {
        PanelFeatureState s02;
        PanelFeatureState s03 = s0(i10, true);
        if (s03.f7327j != null) {
            Bundle bundle = new Bundle();
            s03.f7327j.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                s03.f7336s = bundle;
            }
            s03.f7327j.stopDispatchingItemsChanged();
            s03.f7327j.clear();
        }
        s03.f7335r = true;
        s03.f7334q = true;
        if ((i10 == 108 || i10 == 0) && this.f7314r != null && (s02 = s0(0, false)) != null) {
            s02.f7330m = false;
            O0(s02, null);
        }
    }

    public void i0() {
        Q q10 = this.f7269D;
        if (q10 != null) {
            q10.c();
        }
    }

    @Override // androidx.appcompat.app.e
    public Context j() {
        return this.f7303k;
    }

    public final void j0() {
        if (!this.f7271F) {
            this.f7272G = d0();
            CharSequence t02 = t0();
            if (!TextUtils.isEmpty(t02)) {
                InterfaceC0444s interfaceC0444s = this.f7314r;
                if (interfaceC0444s != null) {
                    interfaceC0444s.setWindowTitle(t02);
                } else if (M0() != null) {
                    M0().B(t02);
                } else {
                    TextView textView = this.f7273H;
                    if (textView != null) {
                        textView.setText(t02);
                    }
                }
            }
            T();
            K0(this.f7272G);
            this.f7271F = true;
            PanelFeatureState s02 = s0(0, false);
            if (!this.f7288W) {
                if (s02 == null || s02.f7327j == null) {
                    z0(108);
                }
            }
        }
    }

    public final void k0() {
        if (this.f7305l == null) {
            Object obj = this.f7301j;
            if (obj instanceof Activity) {
                U(((Activity) obj).getWindow());
            }
        }
        if (this.f7305l != null) {
        } else {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    @Override // androidx.appcompat.app.e
    public final androidx.appcompat.app.a l() {
        return new f();
    }

    public PanelFeatureState l0(Menu menu) {
        int i10;
        PanelFeatureState[] panelFeatureStateArr = this.f7283R;
        if (panelFeatureStateArr != null) {
            i10 = panelFeatureStateArr.length;
        } else {
            i10 = 0;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i11];
            if (panelFeatureState != null && panelFeatureState.f7327j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.e
    public int m() {
        return this.f7290Y;
    }

    public final Context n0() {
        Context context;
        ActionBar p10 = p();
        if (p10 != null) {
            context = p10.k();
        } else {
            context = null;
        }
        if (context == null) {
            return this.f7303k;
        }
        return context;
    }

    @Override // androidx.appcompat.app.e
    public MenuInflater o() {
        Context context;
        if (this.f7312p == null) {
            v0();
            ActionBar actionBar = this.f7311o;
            if (actionBar != null) {
                context = actionBar.k();
            } else {
                context = this.f7303k;
            }
            this.f7312p = new C1150g(context);
        }
        return this.f7312p;
    }

    public final int o0(Context context) {
        if (!this.f7293b0 && (this.f7301j instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f7301j.getClass()), 269221888);
                if (activityInfo != null) {
                    this.f7292a0 = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e10) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e10);
                this.f7292a0 = 0;
            }
        }
        this.f7293b0 = true;
        return this.f7292a0;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return e0(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState l02;
        Window.Callback u02 = u0();
        if (u02 != null && !this.f7288W && (l02 = l0(menuBuilder.getRootMenu())) != null) {
            return u02.onMenuItemSelected(l02.f7318a, menuItem);
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        P0(true);
    }

    @Override // androidx.appcompat.app.e
    public ActionBar p() {
        v0();
        return this.f7311o;
    }

    public final p p0(Context context) {
        if (this.f7295d0 == null) {
            this.f7295d0 = new o(context);
        }
        return this.f7295d0;
    }

    @Override // androidx.appcompat.app.e
    public void q() {
        LayoutInflater from = LayoutInflater.from(this.f7303k);
        if (from.getFactory() == null) {
            C0457l.a(from, this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final p q0(Context context) {
        if (this.f7294c0 == null) {
            this.f7294c0 = new q(androidx.appcompat.app.o.a(context));
        }
        return this.f7294c0;
    }

    @Override // androidx.appcompat.app.e
    public void r() {
        if (M0() != null && !p().m()) {
            z0(0);
        }
    }

    public F.e r0(Configuration configuration) {
        return k.b(configuration);
    }

    public PanelFeatureState s0(int i10, boolean z10) {
        PanelFeatureState[] panelFeatureStateArr = this.f7283R;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i10) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i10 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.f7283R = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i10];
        if (panelFeatureState == null) {
            PanelFeatureState panelFeatureState2 = new PanelFeatureState(i10);
            panelFeatureStateArr[i10] = panelFeatureState2;
            return panelFeatureState2;
        }
        return panelFeatureState;
    }

    public final CharSequence t0() {
        Object obj = this.f7301j;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.f7313q;
    }

    @Override // androidx.appcompat.app.e
    public void u(Configuration configuration) {
        ActionBar p10;
        if (this.f7277L && this.f7271F && (p10 = p()) != null) {
            p10.n(configuration);
        }
        C0433g.b().g(this.f7303k);
        this.f7289X = new Configuration(this.f7303k.getResources().getConfiguration());
        R(false, false);
    }

    public final Window.Callback u0() {
        return this.f7305l.getCallback();
    }

    @Override // androidx.appcompat.app.e
    public void v(Bundle bundle) {
        String str;
        this.f7286U = true;
        Q(false);
        k0();
        Object obj = this.f7301j;
        if (obj instanceof Activity) {
            try {
                str = androidx.core.app.g.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                ActionBar M02 = M0();
                if (M02 == null) {
                    this.f7299h0 = true;
                } else {
                    M02.s(true);
                }
            }
            androidx.appcompat.app.e.b(this);
        }
        this.f7289X = new Configuration(this.f7303k.getResources().getConfiguration());
        this.f7287V = true;
    }

    public final void v0() {
        j0();
        if (this.f7277L && this.f7311o == null) {
            Object obj = this.f7301j;
            if (obj instanceof Activity) {
                this.f7311o = new androidx.appcompat.app.p((Activity) this.f7301j, this.f7278M);
            } else if (obj instanceof Dialog) {
                this.f7311o = new androidx.appcompat.app.p((Dialog) this.f7301j);
            }
            ActionBar actionBar = this.f7311o;
            if (actionBar != null) {
                actionBar.s(this.f7299h0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    @Override // androidx.appcompat.app.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void w() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f7301j
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            androidx.appcompat.app.e.C(r3)
        L9:
            boolean r0 = r3.f7296e0
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.f7305l
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f7298g0
            r0.removeCallbacks(r1)
        L18:
            r0 = 1
            r3.f7288W = r0
            int r0 = r3.f7290Y
            r1 = -100
            if (r0 == r1) goto L45
            java.lang.Object r0 = r3.f7301j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L45
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L45
            p.i<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.f7262o0
            java.lang.Object r1 = r3.f7301j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f7290Y
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L54
        L45:
            p.i<java.lang.String, java.lang.Integer> r0 = androidx.appcompat.app.AppCompatDelegateImpl.f7262o0
            java.lang.Object r1 = r3.f7301j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L54:
            androidx.appcompat.app.ActionBar r0 = r3.f7311o
            if (r0 == 0) goto L5b
            r0.o()
        L5b:
            r3.Z()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.w():void");
    }

    public final boolean w0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f7326i;
        if (view != null) {
            panelFeatureState.f7325h = view;
            return true;
        }
        if (panelFeatureState.f7327j == null) {
            return false;
        }
        if (this.f7316y == null) {
            this.f7316y = new s();
        }
        View view2 = (View) panelFeatureState.a(this.f7316y);
        panelFeatureState.f7325h = view2;
        if (view2 != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void x(Bundle bundle) {
        j0();
    }

    public final boolean x0(PanelFeatureState panelFeatureState) {
        panelFeatureState.d(n0());
        panelFeatureState.f7324g = new r(panelFeatureState.f7329l);
        panelFeatureState.f7320c = 81;
        return true;
    }

    @Override // androidx.appcompat.app.e
    public void y() {
        ActionBar p10 = p();
        if (p10 != null) {
            p10.y(true);
        }
    }

    public final boolean y0(PanelFeatureState panelFeatureState) {
        Resources.Theme theme;
        Context context = this.f7303k;
        int i10 = panelFeatureState.f7318a;
        if ((i10 == 0 || i10 == 108) && this.f7314r != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme2 = context.getTheme();
            theme2.resolveAttribute(C0961a.f30107f, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme = context.getResources().newTheme();
                theme.setTo(theme2);
                theme.applyStyle(typedValue.resourceId, true);
                theme.resolveAttribute(C0961a.f30108g, typedValue, true);
            } else {
                theme2.resolveAttribute(C0961a.f30108g, typedValue, true);
                theme = null;
            }
            if (typedValue.resourceId != 0) {
                if (theme == null) {
                    theme = context.getResources().newTheme();
                    theme.setTo(theme2);
                }
                theme.applyStyle(typedValue.resourceId, true);
            }
            if (theme != null) {
                C1147d c1147d = new C1147d(context, 0);
                c1147d.getTheme().setTo(theme);
                context = c1147d;
            }
        }
        MenuBuilder menuBuilder = new MenuBuilder(context);
        menuBuilder.setCallback(this);
        panelFeatureState.c(menuBuilder);
        return true;
    }

    public final void z0(int i10) {
        this.f7297f0 = (1 << i10) | this.f7297f0;
        if (!this.f7296e0) {
            K.a0(this.f7305l.getDecorView(), this.f7298g0);
            this.f7296e0 = true;
        }
    }

    public AppCompatDelegateImpl(Dialog dialog, androidx.appcompat.app.c cVar) {
        this(dialog.getContext(), dialog.getWindow(), cVar, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public AppCompatDelegateImpl(Context context, Window window, androidx.appcompat.app.c cVar, Object obj) {
        p.i<String, Integer> iVar;
        Integer num;
        AppCompatActivity Y02;
        this.f7269D = null;
        this.f7270E = true;
        this.f7290Y = -100;
        this.f7298g0 = new a();
        this.f7303k = context;
        this.f7309n = cVar;
        this.f7301j = obj;
        if (this.f7290Y == -100 && (obj instanceof Dialog) && (Y02 = Y0()) != null) {
            this.f7290Y = Y02.getDelegate().m();
        }
        if (this.f7290Y == -100 && (num = (iVar = f7262o0).get(obj.getClass().getName())) != null) {
            this.f7290Y = num.intValue();
            iVar.remove(obj.getClass().getName());
        }
        if (window != null) {
            U(window);
        }
        C0433g.h();
    }

    /* loaded from: classes.dex */
    public class c implements ContentFrameLayout.a {
        public c() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.f0();
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }
    }

    public void K0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.e
    public void z(Bundle bundle) {
    }
}

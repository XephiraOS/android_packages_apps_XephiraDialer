package com.android.incallui.mvvm.repository.dynamic;

import L1.c;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.Display;
import com.android.incallui.Log;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt;
import com.android.incallui.mvvm.utils.h;
import com.android.incallui.mvvm.utils.y;
import com.coui.appcompat.baseview.util.FoldSettingsHelper;
import com.internal_dependency.InternalSdkDepends;
import com.internal_dependency.SettingsUtils;
import d2.InterfaceC0949b;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.o;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.F;
import kotlinx.coroutines.S;
import v9.InterfaceC1637a;
import v9.l;

/* compiled from: ResponsiveConfigRepository.kt */
/* loaded from: classes.dex */
public final class ResponsiveConfigRepository implements InterfaceC0949b {

    /* renamed from: a, reason: collision with root package name */
    public static final ResponsiveConfigRepository f18540a;

    /* renamed from: b, reason: collision with root package name */
    public static final h<BitmapDrawable> f18541b;

    /* renamed from: c, reason: collision with root package name */
    public static final ResponsiveConfigRepository$wallpaperChangeReceiver$1 f18542c;

    /* renamed from: d, reason: collision with root package name */
    public static final h<Integer> f18543d;

    /* renamed from: e, reason: collision with root package name */
    public static final b f18544e;

    /* renamed from: f, reason: collision with root package name */
    public static final h<Configuration> f18545f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f18546g;

    /* renamed from: h, reason: collision with root package name */
    public static final y<Integer> f18547h;

    /* renamed from: i, reason: collision with root package name */
    public static final y<Boolean> f18548i;

    /* renamed from: j, reason: collision with root package name */
    public static final y<Pair<Integer, Integer>> f18549j;

    /* renamed from: k, reason: collision with root package name */
    public static final y<DisplayMetrics> f18550k;

    /* renamed from: l, reason: collision with root package name */
    public static final h<Integer> f18551l;

    /* renamed from: m, reason: collision with root package name */
    public static final h<Integer> f18552m;

    /* renamed from: n, reason: collision with root package name */
    public static y<Double> f18553n;

    /* compiled from: ResponsiveConfigRepository.kt */
    /* loaded from: classes.dex */
    public static final class b extends ContentObserver {
        public b() {
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            SettingsUtils settingsUtils = SettingsUtils.INSTANCE;
            ResponsiveConfigRepository responsiveConfigRepository = ResponsiveConfigRepository.f18540a;
            ContentResolver contentResolver = responsiveConfigRepository.G().getContentResolver();
            i.e(contentResolver, "application.contentResolver");
            int globalSettingsInt = settingsUtils.getGlobalSettingsInt(contentResolver, FoldSettingsHelper.SYSTEM_FOLDING_MODE_KEY, 0);
            responsiveConfigRepository.h1().m(Integer.valueOf(globalSettingsInt));
            Log.d("ResponsiveConfigRepository", "folding mode change: " + globalSettingsInt);
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository$wallpaperChangeReceiver$1] */
    static {
        List j10;
        ResponsiveConfigRepository responsiveConfigRepository = new ResponsiveConfigRepository();
        f18540a = responsiveConfigRepository;
        f18541b = new h<>(true);
        f18542c = new BroadcastReceiver() { // from class: com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository$wallpaperChangeReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                i.f(context, "context");
                i.f(intent, "intent");
                Log.d("ResponsiveConfigRepository", "onReceive: intent = " + intent);
                ResponsiveConfigRepository.f18540a.B();
            }
        };
        SettingsUtils settingsUtils = SettingsUtils.INSTANCE;
        ContentResolver contentResolver = responsiveConfigRepository.G().getContentResolver();
        i.e(contentResolver, "application.contentResolver");
        f18543d = new h<>(Integer.valueOf(settingsUtils.getGlobalSettingsInt(contentResolver, FoldSettingsHelper.SYSTEM_FOLDING_MODE_KEY, 0)), false, 2, null);
        f18544e = new b();
        h<Configuration> hVar = new h<>(responsiveConfigRepository.k0().getResources().getConfiguration(), false);
        f18545f = hVar;
        f18546g = new a();
        f18547h = IgnoreEqualsLiveDataKt.u(hVar, true, new l<Configuration, Integer>() { // from class: com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository$defaultDisplayOrientation$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke(Configuration configuration) {
                return Integer.valueOf(ResponsiveConfigRepository.f18540a.e0().getValue().orientation);
            }
        });
        f18548i = IgnoreEqualsLiveDataKt.u(hVar, true, new l<Configuration, Boolean>() { // from class: com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository$isDefaultDisplayNightModeActive$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Configuration configuration) {
                return Boolean.valueOf(ResponsiveConfigRepository.f18540a.e0().getValue().isNightModeActive());
            }
        });
        f18549j = IgnoreEqualsLiveDataKt.u(hVar, true, new l<Configuration, Pair<? extends Integer, ? extends Integer>>() { // from class: com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository$defaultDisplaySize$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Pair<Integer, Integer> invoke(Configuration configuration) {
                ResponsiveConfigRepository responsiveConfigRepository2 = ResponsiveConfigRepository.f18540a;
                return new Pair<>(Integer.valueOf(responsiveConfigRepository2.e0().getValue().screenWidthDp), Integer.valueOf(responsiveConfigRepository2.e0().getValue().screenHeightDp));
            }
        });
        y<DisplayMetrics> u10 = IgnoreEqualsLiveDataKt.u(hVar, true, new l<Configuration, DisplayMetrics>() { // from class: com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository$defaultDisplayMetrics$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final DisplayMetrics invoke(Configuration configuration) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                displayMetrics.setTo(ResponsiveConfigRepository.f18540a.k0().getResources().getDisplayMetrics());
                return displayMetrics;
            }
        });
        f18550k = u10;
        h<Integer> hVar2 = new h<>(Integer.valueOf(OplusPhoneUtils.getNavigationBarHeight(responsiveConfigRepository.k0())), true);
        f18551l = hVar2;
        h<Integer> hVar3 = new h<>(Integer.valueOf(OplusPhoneUtils.getStatusBarHeight(responsiveConfigRepository.k0())), true);
        f18552m = hVar3;
        j10 = o.j(u10, hVar2, hVar3);
        f18553n = IgnoreEqualsLiveDataKt.E(j10, false, new InterfaceC1637a<Double>() { // from class: com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository$mSpacingHeightChangeRate$1
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Double invoke() {
                ResponsiveConfigRepository responsiveConfigRepository2 = ResponsiveConfigRepository.f18540a;
                float f10 = responsiveConfigRepository2.L().getValue().density;
                try {
                    Display display = responsiveConfigRepository2.k0().getDisplay();
                    Point point = new Point();
                    if (display != null) {
                        display.getRealSize(point);
                    }
                    float f11 = point.y / f10;
                    double d10 = f11;
                    double d11 = 800.0d;
                    if (d10 <= 800.0d) {
                        d10 -= 464.0d;
                        d11 = 336.0d;
                    }
                    Double valueOf = Double.valueOf(d10 / d11);
                    Double valueOf2 = Double.valueOf(0.0d);
                    if (valueOf.compareTo(valueOf) <= 0 && valueOf.compareTo(valueOf2) < 0) {
                        valueOf = valueOf2;
                    }
                    Log.d("ResponsiveConfigRepository", "density: " + f10 + " phoneTotalHeight: " + f11 + " mScreenSize: " + responsiveConfigRepository2.c0().getValue() + "mNavigationBarHeight: " + responsiveConfigRepository2.N0().getValue().intValue() + " mStatusBarHeight: " + responsiveConfigRepository2.r1().getValue().intValue() + " mSpacingHeightChangeRate: " + valueOf.doubleValue() + ' ');
                    return valueOf;
                } catch (Exception e10) {
                    Log.d("ResponsiveConfigRepository", "cannot count mSpacingHeightChangeRate: " + e10);
                    return Double.valueOf(1.0d);
                }
            }
        }, 1, null);
    }

    public final void B() {
        if (OplusFeatureOption.VERSION_STORE && InternalSdkDepends.Companion.getSInstance().isNotSystemUser()) {
            return;
        }
        C1244g.d(F.a(S.a()), null, null, new ResponsiveConfigRepository$captureWallpaperAsync$1(null), 3, null);
    }

    @Override // d2.InterfaceC0949b
    public OplusInCallPresenter C0() {
        return InterfaceC0949b.a.j(this);
    }

    public final h<BitmapDrawable> D1() {
        return f18541b;
    }

    public final boolean E1() {
        boolean z10 = false;
        if (c.f() && !F1()) {
            Log.d("ResponsiveConfigRepository", "isDefaultScreenSize: isDisplayOfDragonfly close");
            return false;
        }
        int intValue = f18547h.getValue().intValue();
        if (intValue == 1 ? f18549j.getValue().c().intValue() < 600 : !(intValue != 2 || f18549j.getValue().d().intValue() >= 500)) {
            z10 = true;
        }
        Log.d("ResponsiveConfigRepository", "isDefaultScreenSize: isDisplayOfDragonfly " + z10);
        return z10;
    }

    public final boolean F1() {
        if (f18543d.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public Application G() {
        return InterfaceC0949b.a.b(this);
    }

    public final y<DisplayMetrics> L() {
        return f18550k;
    }

    public final h<Integer> N0() {
        return f18551l;
    }

    public final y<Boolean> a0() {
        return f18548i;
    }

    public final y<Pair<Integer, Integer>> c0() {
        return f18549j;
    }

    public final h<Configuration> e0() {
        return f18545f;
    }

    @Override // d2.InterfaceC0949b
    public void f() {
        Log.d("ResponsiveConfigRepository", "setUp: ");
        OplusPhoneUtils.setDefaultDisplayResources(k0().getResources());
        G().getContentResolver().registerContentObserver(SettingsUtils.INSTANCE.getGlobalUriFor(FoldSettingsHelper.SYSTEM_FOLDING_MODE_KEY), false, f18544e);
        G().registerReceiver(f18542c, new IntentFilter("android.intent.action.WALLPAPER_CHANGED"), 2);
        B();
        k0().registerComponentCallbacks(f18546g);
    }

    public final y<Integer> f1() {
        return f18547h;
    }

    public final h<Integer> h1() {
        return f18543d;
    }

    public Context k0() {
        return InterfaceC0949b.a.h(this);
    }

    public final y<Double> o1() {
        return f18553n;
    }

    public final h<Integer> r1() {
        return f18552m;
    }

    /* compiled from: ResponsiveConfigRepository.kt */
    /* loaded from: classes.dex */
    public static final class a implements ComponentCallbacks {
        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration newConfig) {
            i.f(newConfig, "newConfig");
            Log.d("ResponsiveConfigRepository", "default display onConfigurationChanged: ");
            ResponsiveConfigRepository responsiveConfigRepository = ResponsiveConfigRepository.f18540a;
            OplusPhoneUtils.setDefaultDisplayResources(responsiveConfigRepository.k0().getResources());
            responsiveConfigRepository.e0().o(responsiveConfigRepository.k0().getResources().getConfiguration());
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }
}

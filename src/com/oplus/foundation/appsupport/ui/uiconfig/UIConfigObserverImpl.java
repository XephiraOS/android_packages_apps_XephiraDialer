package com.oplus.foundation.appsupport.ui.uiconfig;

import C9.j;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.Log;
import androidx.lifecycle.InterfaceC0480c;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.w;
import com.coui.responsiveui.config.ResponsiveUIConfig;
import com.coui.responsiveui.config.UIConfig;
import com.oplus.foundation.appsupport.ui.uiconfig.UIConfigObserverImpl;
import com.oplus.foundation.util.display.DisplayUtil;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;
import u7.InterfaceC1611a;
import y9.c;

/* compiled from: UIConfigObserverImpl.kt */
/* loaded from: classes3.dex */
public final class UIConfigObserverImpl implements InterfaceC0480c {

    /* renamed from: a, reason: collision with root package name */
    public UIConfig f28211a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f28212b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC1611a f28213c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f28214d;

    /* renamed from: e, reason: collision with root package name */
    public int f28215e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference<Activity> f28216f;

    /* renamed from: h, reason: collision with root package name */
    public ResponsiveUIConfig f28218h;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ j<Object>[] f28210k = {k.d(new MutablePropertyReference1Impl(UIConfigObserverImpl.class, "currUiMode", "getCurrUiMode()I", 0))};

    /* renamed from: j, reason: collision with root package name */
    public static final a f28209j = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public final c f28217g = y9.a.f38157a.a();

    /* renamed from: i, reason: collision with root package name */
    public final w<UIConfig> f28219i = new w() { // from class: u7.b
        @Override // androidx.lifecycle.w
        public final void onChanged(Object obj) {
            UIConfigObserverImpl.g(UIConfigObserverImpl.this, (UIConfig) obj);
        }
    };

    /* compiled from: UIConfigObserverImpl.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private final boolean e() {
        UIConfig.Status status;
        ResponsiveUIConfig responsiveUIConfig = this.f28218h;
        Integer num = null;
        if (responsiveUIConfig == null) {
            i.q("responsiveUIConfig");
            responsiveUIConfig = null;
        }
        UIConfig value = responsiveUIConfig.getUiConfig().getValue();
        if (value != null) {
            status = value.getStatus();
        } else {
            status = null;
        }
        ResponsiveUIConfig responsiveUIConfig2 = this.f28218h;
        if (responsiveUIConfig2 == null) {
            i.q("responsiveUIConfig");
            responsiveUIConfig2 = null;
        }
        UIConfig value2 = responsiveUIConfig2.getUiConfig().getValue();
        if (value2 != null) {
            num = Integer.valueOf(value2.getOrientation());
        }
        return DisplayUtil.q(status, num, this.f28214d, this.f28215e);
    }

    public static final void g(UIConfigObserverImpl this$0, UIConfig newConfig) {
        i.f(this$0, "this$0");
        i.f(newConfig, "newConfig");
        this$0.l(newConfig);
    }

    public final void b(int i10, int i11) {
        boolean z10;
        int i12 = i11 & 48;
        if ((i10 & 48) != i12) {
            if (i12 == 32) {
                z10 = true;
            } else {
                z10 = false;
            }
            Log.i("UIConfigObserverImpl", "night mode change: " + z10);
            InterfaceC1611a interfaceC1611a = this.f28213c;
            if (interfaceC1611a != null) {
                interfaceC1611a.A0(z10);
            }
        }
    }

    public final int c() {
        return ((Number) this.f28217g.a(this, f28210k[0])).intValue();
    }

    public void d(Activity activity, InterfaceC0492o owner) {
        i.f(activity, "activity");
        i.f(owner, "owner");
        this.f28216f = new WeakReference<>(activity);
        this.f28214d = activity.isInMultiWindowMode();
        this.f28215e = activity.getResources().getConfiguration().screenWidthDp;
        ResponsiveUIConfig responsiveUIConfig = ResponsiveUIConfig.getDefault(activity);
        i.e(responsiveUIConfig, "getDefault(activity)");
        this.f28218h = responsiveUIConfig;
        j(activity.getResources().getConfiguration().uiMode);
        owner.getLifecycle().a(this);
        ResponsiveUIConfig responsiveUIConfig2 = this.f28218h;
        if (responsiveUIConfig2 == null) {
            i.q("responsiveUIConfig");
            responsiveUIConfig2 = null;
        }
        responsiveUIConfig2.getUiConfig().i(owner, this.f28219i);
    }

    public boolean f() {
        return e();
    }

    public void h(Configuration newConfig) {
        UIConfig value;
        Activity activity;
        i.f(newConfig, "newConfig");
        WeakReference<Activity> weakReference = this.f28216f;
        if (weakReference != null && (activity = weakReference.get()) != null) {
            this.f28214d = activity.isInMultiWindowMode();
        }
        this.f28215e = newConfig.screenWidthDp;
        ResponsiveUIConfig responsiveUIConfig = this.f28218h;
        ResponsiveUIConfig responsiveUIConfig2 = null;
        if (responsiveUIConfig == null) {
            i.q("responsiveUIConfig");
            responsiveUIConfig = null;
        }
        responsiveUIConfig.onActivityConfigChanged(newConfig);
        b(c(), newConfig.uiMode);
        j(newConfig.uiMode);
        ResponsiveUIConfig responsiveUIConfig3 = this.f28218h;
        if (responsiveUIConfig3 == null) {
            i.q("responsiveUIConfig");
        } else {
            responsiveUIConfig2 = responsiveUIConfig3;
        }
        LiveData<UIConfig> uiConfig = responsiveUIConfig2.getUiConfig();
        if (uiConfig != null && (value = uiConfig.getValue()) != null) {
            l(value);
        }
    }

    public void i(InterfaceC1611a listener) {
        i.f(listener, "listener");
        this.f28213c = listener;
    }

    public final void j(int i10) {
        this.f28217g.b(this, f28210k[0], Integer.valueOf(i10));
    }

    public void k(InterfaceC1611a listener) {
        i.f(listener, "listener");
        this.f28213c = null;
    }

    public final void l(UIConfig uIConfig) {
        if (!uIConfig.equals(this.f28211a)) {
            Log.i("UIConfigObserverImpl", ": config changed:" + uIConfig);
            InterfaceC1611a interfaceC1611a = this.f28213c;
            if (interfaceC1611a != null) {
                interfaceC1611a.w0(this.f28211a, uIConfig);
            }
            this.f28211a = uIConfig;
        }
        boolean e10 = e();
        if (!i.b(Boolean.valueOf(e10), this.f28212b)) {
            Log.i("UIConfigObserverImpl", ": config changed tmpIsShowChild:" + e10);
            InterfaceC1611a interfaceC1611a2 = this.f28213c;
            if (interfaceC1611a2 != null) {
                interfaceC1611a2.j0(e10);
            }
            this.f28212b = Boolean.valueOf(e10);
        }
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onDestroy(InterfaceC0492o owner) {
        i.f(owner, "owner");
        ResponsiveUIConfig responsiveUIConfig = null;
        this.f28213c = null;
        ResponsiveUIConfig responsiveUIConfig2 = this.f28218h;
        if (responsiveUIConfig2 == null) {
            i.q("responsiveUIConfig");
        } else {
            responsiveUIConfig = responsiveUIConfig2;
        }
        responsiveUIConfig.getUiConfig().n(this.f28219i);
        owner.getLifecycle().d(this);
    }
}

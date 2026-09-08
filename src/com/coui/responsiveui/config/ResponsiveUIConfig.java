package com.coui.responsiveui.config;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import com.coui.responsiveui.config.UIConfig;
import d9.C0960b;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
public class ResponsiveUIConfig {

    /* renamed from: j, reason: collision with root package name */
    public static ResponsiveUIConfig f20045j = null;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f20046k = false;

    /* renamed from: l, reason: collision with root package name */
    public static HashMap<Integer, ResponsiveUIConfig> f20047l = new LinkedHashMap();

    /* renamed from: g, reason: collision with root package name */
    public int f20054g;

    /* renamed from: h, reason: collision with root package name */
    public Context f20055h;

    /* renamed from: a, reason: collision with root package name */
    public int f20048a = -1;

    /* renamed from: b, reason: collision with root package name */
    public v<UIConfig> f20049b = new v<>();

    /* renamed from: c, reason: collision with root package name */
    public v<UIConfig.Status> f20050c = new v<>();

    /* renamed from: d, reason: collision with root package name */
    public v<Integer> f20051d = new v<>();

    /* renamed from: e, reason: collision with root package name */
    public v<UIScreenSize> f20052e = new v<>();

    /* renamed from: f, reason: collision with root package name */
    public v<Integer> f20053f = new v<>();

    /* renamed from: i, reason: collision with root package name */
    public UIConfig.WindowType f20056i = UIConfig.WindowType.SMALL;

    public ResponsiveUIConfig(Context context) {
        g(context);
    }

    public static ResponsiveUIConfig getDefault(Context context) {
        if (f20045j == null) {
            f20045j = new ResponsiveUIConfig(context);
        }
        int hashCode = context.hashCode();
        if (hashCode != f20045j.f20048a) {
            Log.d("ResponsiveUIConfig", "getDefault context hash change from " + f20045j.f20048a + " to " + hashCode);
            f20045j.g(context);
        }
        return f20045j;
    }

    public static ResponsiveUIConfig newInstance(Context context) {
        if (!f20046k && (context.getApplicationContext() instanceof Application)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new LifecycleCallbacks());
            f20046k = true;
        }
        int hashCode = context.hashCode();
        if (f20047l.containsKey(Integer.valueOf(hashCode))) {
            Log.v("ResponsiveUIConfig", "newInstance return the kept instance " + hashCode);
            return f20047l.get(Integer.valueOf(hashCode));
        }
        ResponsiveUIConfig responsiveUIConfig = new ResponsiveUIConfig(context);
        f20047l.put(Integer.valueOf(hashCode), responsiveUIConfig);
        Log.v("ResponsiveUIConfig", "newInstance return the new instance " + hashCode + ", size " + f20047l.size());
        return responsiveUIConfig;
    }

    public final int b(int i10) {
        int integer = this.f20055h.getResources().getInteger(C0960b.f30078b);
        int integer2 = this.f20055h.getResources().getInteger(C0960b.f30079c);
        int integer3 = this.f20055h.getResources().getInteger(C0960b.f30077a);
        int i11 = integer / 2;
        if (i10 >= integer2 - i11) {
            if (i10 < integer2 || i10 < integer3 - i11) {
                return integer2;
            }
            return integer3;
        }
        return integer;
    }

    public final void c(Resources resources) {
        this.f20054g = resources.getInteger(C0960b.f30078b);
    }

    public final void d(Resources resources) {
        Integer value = this.f20053f.getValue();
        int integer = resources.getInteger(C0960b.f30082f);
        float widthDp = this.f20052e.getValue().getWidthDp() / f();
        if (widthDp > 1.0f) {
            widthDp = 1.0f;
        }
        int b10 = b((int) (integer * widthDp));
        if (value == null || value.intValue() != b10) {
            this.f20053f.o(Integer.valueOf(b10));
        }
    }

    public final UIConfig.Status e(int i10, UIScreenSize uIScreenSize) {
        UIConfig.Status status = UIConfig.Status.UNKNOWN;
        int widthDp = uIScreenSize.getWidthDp();
        int heightDp = uIScreenSize.getHeightDp();
        if (widthDp < 600) {
            this.f20056i = UIConfig.WindowType.SMALL;
        } else if (widthDp < 840) {
            this.f20056i = UIConfig.WindowType.MEDIUM;
        } else {
            this.f20056i = UIConfig.WindowType.LARGE;
        }
        if (i10 != 1) {
            if (i10 != 2) {
                Log.d("ResponsiveUIConfig", "undefined orientation Status unknown !!! ");
                return status;
            }
            if (heightDp >= 500) {
                return UIConfig.Status.UNFOLD;
            }
            return UIConfig.Status.FOLD;
        }
        if (widthDp >= 600) {
            return UIConfig.Status.UNFOLD;
        }
        return UIConfig.Status.FOLD;
    }

    public final int f() {
        return this.f20055h.getResources().getConfiguration().screenWidthDp;
    }

    public void flush(Context context) {
        g(context);
    }

    public final void g(Context context) {
        this.f20048a = context.hashCode();
        Context applicationContext = context.getApplicationContext();
        this.f20055h = applicationContext;
        c(applicationContext.getResources());
        h(context.getResources().getConfiguration());
        d(context.getResources());
        Log.d("ResponsiveUIConfig", "init uiConfig " + this.f20049b.getValue() + ", columns count " + this.f20053f.getValue());
        Log.d("ResponsiveUIConfig", "init addContent [" + getExtendHierarchyParentWidthDp() + ":" + getExtendHierarchyChildWidthDp() + "] - [" + getExtendHierarchyParentColumnsCount() + ":" + getExtendHierarchyChildColumnsCount() + "]");
    }

    public int getExtendHierarchyChildColumnsCount() {
        return this.f20053f.getValue().intValue() - getExtendHierarchyParentColumnsCount();
    }

    public int getExtendHierarchyChildWidthDp() {
        return this.f20052e.getValue().getWidthDp() - getExtendHierarchyParentWidthDp();
    }

    public int getExtendHierarchyParentColumnsCount() {
        return b((int) (this.f20053f.getValue().intValue() * (getExtendHierarchyParentWidthDp() / this.f20052e.getValue().getWidthDp())));
    }

    public int getExtendHierarchyParentWidthDp() {
        if (this.f20052e.getValue().getWidthDp() >= 840) {
            return this.f20055h.getResources().getInteger(C0960b.f30081e);
        }
        if (this.f20052e.getValue().getWidthDp() >= 600) {
            return this.f20055h.getResources().getInteger(C0960b.f30080d);
        }
        return this.f20052e.getValue().getWidthDp();
    }

    public UIConfig.WindowType getScreenType() {
        return this.f20049b.getValue().getWindowType();
    }

    public LiveData<Integer> getUiColumnsCount() {
        return this.f20053f;
    }

    public LiveData<UIConfig> getUiConfig() {
        return this.f20049b;
    }

    public LiveData<Integer> getUiOrientation() {
        return this.f20051d;
    }

    public LiveData<UIScreenSize> getUiScreenSize() {
        return this.f20052e;
    }

    public LiveData<UIConfig.Status> getUiStatus() {
        return this.f20050c;
    }

    public final boolean h(Configuration configuration) {
        int i10 = configuration.orientation;
        UIScreenSize uIScreenSize = new UIScreenSize(configuration.screenWidthDp, configuration.screenHeightDp, configuration.smallestScreenWidthDp);
        UIConfig uIConfig = new UIConfig(e(i10, uIScreenSize), uIScreenSize, i10, this.f20056i);
        UIConfig value = this.f20049b.getValue();
        boolean z10 = false;
        if (uIConfig.equals(value)) {
            return false;
        }
        if (value == null || uIConfig.getStatus() != value.getStatus()) {
            this.f20050c.o(uIConfig.getStatus());
        }
        if (value == null || uIConfig.getOrientation() != value.getOrientation()) {
            this.f20051d.o(Integer.valueOf(uIConfig.getOrientation()));
            z10 = true;
        }
        if (value == null || !uIConfig.getScreenSize().equals(value.getScreenSize())) {
            int widthDp = uIConfig.getScreenSize().getWidthDp();
            int f10 = f();
            if (Math.abs(widthDp - f10) < 50) {
                this.f20052e.o(uIConfig.getScreenSize());
            } else {
                Log.d("ResponsiveUIConfig", "update ScreenSize few case newWidth " + widthDp + " appWidth " + f10);
                UIScreenSize value2 = this.f20052e.getValue();
                if (value2 != null) {
                    if (z10) {
                        widthDp = value2.getHeightDp();
                    } else {
                        widthDp = value2.getWidthDp();
                    }
                }
                UIScreenSize uIScreenSize2 = new UIScreenSize(widthDp, uIConfig.getScreenSize().getHeightDp(), uIConfig.getScreenSize().a());
                this.f20052e.o(uIScreenSize2);
                uIConfig.b(e(this.f20051d.getValue().intValue(), uIScreenSize2));
                uIConfig.c(this.f20056i);
            }
            uIConfig.a(this.f20052e.getValue());
        }
        this.f20049b.o(uIConfig);
        return true;
    }

    public void onActivityConfigChanged(Configuration configuration) {
        if (h(configuration)) {
            d(this.f20055h.getResources());
            Log.d("ResponsiveUIConfig", "onUIConfigChanged uiConfig " + this.f20049b.getValue() + ", columns count " + this.f20053f.getValue());
            Log.d("ResponsiveUIConfig", "onUIConfigChanged addContent [" + getExtendHierarchyParentWidthDp() + ":" + getExtendHierarchyChildWidthDp() + "] - [" + getExtendHierarchyParentColumnsCount() + ":" + getExtendHierarchyChildColumnsCount() + "]");
        }
    }

    public int spanCountBaseColumns(int i10, int i11) {
        return (this.f20053f.getValue().intValue() / i10) * i11;
    }

    public int spanCountBaseWidth(int i10) {
        return spanCountBaseWidth(360, i10);
    }

    public int spanCountBaseColumns(int i10) {
        return spanCountBaseColumns(this.f20054g, i10);
    }

    public int spanCountBaseWidth(int i10, int i11) {
        return (getUiScreenSize().getValue().getWidthDp() >= 600 || i10 >= 600) ? (int) ((this.f20052e.getValue().getWidthDp() / i10) * Math.max(i11, 1)) : i11;
    }

    /* loaded from: classes3.dex */
    public static class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostDestroyed(Activity activity) {
            int hashCode = activity.hashCode();
            if (ResponsiveUIConfig.f20047l.containsKey(Integer.valueOf(hashCode))) {
                ResponsiveUIConfig.f20047l.remove(Integer.valueOf(hashCode));
                Log.v("ResponsiveUIConfig", "newInstance remove the kept instance " + hashCode + ", size " + ResponsiveUIConfig.f20047l.size());
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}

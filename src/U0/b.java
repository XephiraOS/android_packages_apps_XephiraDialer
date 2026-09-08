package U0;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.b;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import m9.q;

/* compiled from: AutoConfigAlertDialogBuilder.kt */
/* loaded from: classes.dex */
public final class b extends COUIAlertDialogBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final ComponentCallbacks f3793a;

    /* renamed from: b, reason: collision with root package name */
    public Configuration f3794b;

    /* renamed from: c, reason: collision with root package name */
    public androidx.appcompat.app.b f3795c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3796d;

    /* renamed from: e, reason: collision with root package name */
    public View f3797e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f3798f;

    /* renamed from: g, reason: collision with root package name */
    public int f3799g;

    /* compiled from: AutoConfigAlertDialogBuilder.kt */
    /* loaded from: classes.dex */
    public static final class a implements ComponentCallbacks {
        public a() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            kotlin.jvm.internal.i.f(configuration, "configuration");
            int i10 = configuration.densityDpi;
            Integer num = b.this.f3798f;
            if (num != null && i10 == num.intValue()) {
                b.this.f3794b = configuration;
                b.this.n(configuration);
                b.this.m(configuration);
            } else {
                H7.b.b("AutoConfigAlertDialogBuilder", "onConfigurationChanged  configuration.densityDpi != densityDpi; return");
                androidx.appcompat.app.b bVar = b.this.f3795c;
                if (bVar != null) {
                    bVar.dismiss();
                }
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            H7.b.b("AutoConfigAlertDialogBuilder", "onLowMemory");
        }
    }

    /* compiled from: AutoConfigAlertDialogBuilder.kt */
    /* renamed from: U0.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class ViewTreeObserverOnWindowAttachListenerC0070b implements ViewTreeObserver.OnWindowAttachListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f3801a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f3802b;

        public ViewTreeObserverOnWindowAttachListenerC0070b(View view, b bVar) {
            this.f3801a = view;
            this.f3802b = bVar;
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowAttached() {
            this.f3801a.getContext().registerComponentCallbacks(this.f3802b.f3793a);
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowDetached() {
            ViewTreeObserver viewTreeObserver = this.f3801a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnWindowAttachListener(this);
            }
            this.f3801a.getContext().unregisterComponentCallbacks(this.f3802b.f3793a);
            this.f3802b.f3796d = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, int i10) {
        super(context, i10);
        kotlin.jvm.internal.i.f(context, "context");
        this.f3793a = new a();
        this.f3799g = context.getResources().getConfiguration().orientation;
    }

    public static final void o(b this$0) {
        Button button;
        ColorStateList colorStateList;
        Boolean bool;
        ViewParent parent;
        Window window;
        View decorView;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        androidx.appcompat.app.b bVar = this$0.f3795c;
        if (bVar != null && (window = bVar.getWindow()) != null && (decorView = window.getDecorView()) != null && !decorView.isAttachedToWindow()) {
            androidx.appcompat.app.b bVar2 = this$0.f3795c;
            if (bVar2 != null) {
                bVar2.dismiss();
            }
            H7.b.b("AutoConfigAlertDialogBuilder", "dialog?.window?.decorView?.isAttachedToWindow == false; return");
            return;
        }
        androidx.appcompat.app.b bVar3 = this$0.f3795c;
        Button button2 = null;
        if (bVar3 != null) {
            button = bVar3.b(-1);
        } else {
            button = null;
        }
        if (button != null) {
            colorStateList = button.getTextColors();
        } else {
            colorStateList = null;
        }
        if (button != null) {
            bool = Boolean.valueOf(button.isEnabled());
        } else {
            bool = null;
        }
        androidx.appcompat.app.b bVar4 = this$0.f3795c;
        if (bVar4 != null) {
            bVar4.dismiss();
        }
        View view = this$0.f3797e;
        if (view != null && (parent = view.getParent()) != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this$0.f3797e);
        }
        androidx.appcompat.app.b show = this$0.show();
        this$0.f3795c = show;
        if (show != null) {
            button2 = show.b(-1);
        }
        if (button2 != null) {
            if (colorStateList != null) {
                button2.setTextColor(colorStateList);
            }
            if (bool != null) {
                button2.setEnabled(bool.booleanValue());
            }
        }
    }

    @Override // com.coui.appcompat.dialog.COUIAlertDialogBuilder, androidx.appcompat.app.b.a
    public androidx.appcompat.app.b create() {
        this.f3795c = super.create();
        l();
        this.f3798f = Integer.valueOf(getContext().getResources().getConfiguration().densityDpi);
        androidx.appcompat.app.b bVar = this.f3795c;
        kotlin.jvm.internal.i.c(bVar);
        return bVar;
    }

    public final androidx.appcompat.app.b j() {
        return this.f3795c;
    }

    public final void k(int i10, boolean z10) {
        Button button;
        androidx.appcompat.app.b bVar = this.f3795c;
        if (bVar != null) {
            button = bVar.b(i10);
        } else {
            button = null;
        }
        if (button != null) {
            button.setEnabled(z10);
        }
    }

    public final void l() {
        androidx.appcompat.app.b bVar;
        Window window;
        View decorView;
        ViewTreeObserver viewTreeObserver;
        if (!this.f3796d && (bVar = this.f3795c) != null && (window = bVar.getWindow()) != null && (decorView = window.getDecorView()) != null && (viewTreeObserver = decorView.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnWindowAttachListener(new ViewTreeObserverOnWindowAttachListenerC0070b(decorView, this));
            q qVar = q.f35511a;
            this.f3796d = true;
        }
    }

    public final void m(Configuration configuration) {
        int i10;
        ViewParent parent;
        View view = this.f3797e;
        if (view != null && this.f3799g != (i10 = configuration.orientation)) {
            if (view != null && (parent = view.getParent()) != null && (parent instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.removeView(this.f3797e);
                viewGroup.addView(this.f3797e);
            }
            this.f3799g = i10;
        }
    }

    public final void n(Configuration configuration) {
        Integer num;
        Window window;
        View decorView;
        Window window2;
        Window window3;
        WindowManager.LayoutParams attributes;
        androidx.appcompat.app.b bVar = this.f3795c;
        if (bVar != null && bVar.isShowing()) {
            androidx.appcompat.app.b bVar2 = this.f3795c;
            if (bVar2 != null && (window3 = bVar2.getWindow()) != null && (attributes = window3.getAttributes()) != null) {
                num = Integer.valueOf(attributes.gravity);
            } else {
                num = null;
            }
            Context context = getContext();
            kotlin.jvm.internal.i.e(context, "context");
            int c10 = com.oplus.foundation.util.ui.b.c(context, configuration);
            if (num == null || num.intValue() != c10) {
                androidx.appcompat.app.b bVar3 = this.f3795c;
                if (bVar3 != null && (window2 = bVar3.getWindow()) != null) {
                    window2.setWindowAnimations(0);
                }
                androidx.appcompat.app.b bVar4 = this.f3795c;
                if (bVar4 != null && (window = bVar4.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                    decorView.post(new Runnable() { // from class: U0.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.o(b.this);
                        }
                    });
                }
            }
        }
    }

    @Override // com.coui.appcompat.dialog.COUIAlertDialogBuilder, androidx.appcompat.app.b.a
    public b.a setView(View view) {
        this.f3797e = view;
        b.a view2 = super.setView(view);
        kotlin.jvm.internal.i.e(view2, "super.setView(view)");
        return view2;
    }
}

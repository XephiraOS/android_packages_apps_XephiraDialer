package S8;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.b;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.oplus.utils.C0857s;

/* compiled from: AutoConfigAlertDialogBuilder.kt */
/* loaded from: classes4.dex */
public final class b extends COUIAlertDialogBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final ComponentCallbacks f3526a;

    /* renamed from: b, reason: collision with root package name */
    public Configuration f3527b;

    /* renamed from: c, reason: collision with root package name */
    public androidx.appcompat.app.b f3528c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3529d;

    /* renamed from: e, reason: collision with root package name */
    public View f3530e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f3531f;

    /* compiled from: AutoConfigAlertDialogBuilder.kt */
    /* loaded from: classes4.dex */
    public static final class a implements ComponentCallbacks {
        public a() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            kotlin.jvm.internal.i.f(configuration, "configuration");
            int i10 = configuration.densityDpi;
            Integer num = b.this.f3531f;
            if (num != null && i10 == num.intValue()) {
                b.this.f3527b = configuration;
                b.this.l(configuration);
                return;
            }
            Log.d("AutoConfigAlertDialogBuilder", "onConfigurationChanged  configuration.densityDpi != densityDpi; return");
            androidx.appcompat.app.b bVar = b.this.f3528c;
            if (bVar != null) {
                bVar.dismiss();
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            Log.d("AutoConfigAlertDialogBuilder", "onLowMemory");
        }
    }

    /* compiled from: AutoConfigAlertDialogBuilder.kt */
    /* renamed from: S8.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class ViewTreeObserverOnWindowAttachListenerC0065b implements ViewTreeObserver.OnWindowAttachListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f3533a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f3534b;

        public ViewTreeObserverOnWindowAttachListenerC0065b(View view, b bVar) {
            this.f3533a = view;
            this.f3534b = bVar;
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowAttached() {
            this.f3533a.getContext().registerComponentCallbacks(this.f3534b.f3526a);
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowDetached() {
            ViewTreeObserver viewTreeObserver = this.f3533a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnWindowAttachListener(this);
            }
            this.f3533a.getContext().unregisterComponentCallbacks(this.f3534b.f3526a);
            this.f3534b.f3529d = false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Context context, int i10) {
        this(context, i10, 0, 4, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    private final void k() {
        androidx.appcompat.app.b bVar;
        Window window;
        View decorView;
        ViewTreeObserver viewTreeObserver;
        if (!this.f3529d && (bVar = this.f3528c) != null && (window = bVar.getWindow()) != null && (decorView = window.getDecorView()) != null && (viewTreeObserver = decorView.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnWindowAttachListener(new ViewTreeObserverOnWindowAttachListenerC0065b(decorView, this));
            m9.q qVar = m9.q.f35511a;
            this.f3529d = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Configuration configuration) {
        Integer num;
        Window window;
        View decorView;
        Window window2;
        Window window3;
        WindowManager.LayoutParams attributes;
        androidx.appcompat.app.b bVar = this.f3528c;
        if (bVar != null && bVar.isShowing()) {
            androidx.appcompat.app.b bVar2 = this.f3528c;
            if (bVar2 != null && (window3 = bVar2.getWindow()) != null && (attributes = window3.getAttributes()) != null) {
                num = Integer.valueOf(attributes.gravity);
            } else {
                num = null;
            }
            Context context = getContext();
            kotlin.jvm.internal.i.e(context, "context");
            int a10 = C0857s.a(context, configuration);
            if (num == null || num.intValue() != a10) {
                androidx.appcompat.app.b bVar3 = this.f3528c;
                if (bVar3 != null && (window2 = bVar3.getWindow()) != null) {
                    window2.setWindowAnimations(0);
                }
                androidx.appcompat.app.b bVar4 = this.f3528c;
                if (bVar4 != null && (window = bVar4.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                    decorView.post(new Runnable() { // from class: S8.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.m(b.this);
                        }
                    });
                }
            }
        }
    }

    public static final void m(b this$0) {
        ViewParent parent;
        Window window;
        View decorView;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        androidx.appcompat.app.b bVar = this$0.f3528c;
        if (bVar != null && (window = bVar.getWindow()) != null && (decorView = window.getDecorView()) != null && !decorView.isAttachedToWindow()) {
            androidx.appcompat.app.b bVar2 = this$0.f3528c;
            if (bVar2 != null) {
                bVar2.dismiss();
            }
            Log.d("AutoConfigAlertDialogBuilder", "dialog?.window?.decorView?.isAttachedToWindow == false; return");
            return;
        }
        androidx.appcompat.app.b bVar3 = this$0.f3528c;
        if (bVar3 != null) {
            bVar3.dismiss();
        }
        View view = this$0.f3530e;
        if (view != null && (parent = view.getParent()) != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this$0.f3530e);
        }
        this$0.f3528c = this$0.show();
    }

    @Override // com.coui.appcompat.dialog.COUIAlertDialogBuilder, androidx.appcompat.app.b.a
    public androidx.appcompat.app.b create() {
        this.f3528c = super.create();
        k();
        this.f3531f = Integer.valueOf(getContext().getResources().getConfiguration().densityDpi);
        androidx.appcompat.app.b bVar = this.f3528c;
        kotlin.jvm.internal.i.d(bVar, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        return bVar;
    }

    public final androidx.appcompat.app.b i() {
        return this.f3528c;
    }

    public final void j(int i10, boolean z10) {
        Button button;
        androidx.appcompat.app.b bVar = this.f3528c;
        if (bVar != null) {
            button = bVar.b(i10);
        } else {
            button = null;
        }
        if (button != null) {
            button.setEnabled(z10);
        }
    }

    @Override // com.coui.appcompat.dialog.COUIAlertDialogBuilder, androidx.appcompat.app.b.a
    public b.a setView(View view) {
        this.f3530e = view;
        b.a view2 = super.setView(view);
        kotlin.jvm.internal.i.e(view2, "super.setView(view)");
        return view2;
    }

    public /* synthetic */ b(Context context, int i10, int i11, int i12, kotlin.jvm.internal.f fVar) {
        this(context, (i12 & 2) != 0 ? 0 : i10, (i12 & 4) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, int i10, int i11) {
        super(context, i10, i11);
        kotlin.jvm.internal.i.f(context, "context");
        this.f3526a = new a();
    }
}

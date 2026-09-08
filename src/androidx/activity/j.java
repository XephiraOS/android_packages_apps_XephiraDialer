package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewTreeLifecycleOwner;

/* compiled from: ComponentDialog.kt */
/* loaded from: classes.dex */
public class j extends Dialog implements InterfaceC0492o, p, d0.d {
    private androidx.lifecycle.q _lifecycleRegistry;
    private final OnBackPressedDispatcher onBackPressedDispatcher;
    private final d0.c savedStateRegistryController;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(Context context) {
        this(context, 0, 2, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    private final androidx.lifecycle.q getLifecycleRegistry() {
        androidx.lifecycle.q qVar = this._lifecycleRegistry;
        if (qVar == null) {
            androidx.lifecycle.q qVar2 = new androidx.lifecycle.q(this);
            this._lifecycleRegistry = qVar2;
            return qVar2;
        }
        return qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackPressedDispatcher$lambda$1(j this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.i.f(view, "view");
        initializeViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.lifecycle.InterfaceC0492o
    public Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    @Override // androidx.activity.p
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    @Override // d0.d
    public androidx.savedstate.a getSavedStateRegistry() {
        return this.savedStateRegistryController.b();
    }

    public void initializeViewTreeOwners() {
        Window window = getWindow();
        kotlin.jvm.internal.i.c(window);
        View decorView = window.getDecorView();
        kotlin.jvm.internal.i.e(decorView, "window!!.decorView");
        ViewTreeLifecycleOwner.b(decorView, this);
        Window window2 = getWindow();
        kotlin.jvm.internal.i.c(window2);
        View decorView2 = window2.getDecorView();
        kotlin.jvm.internal.i.e(decorView2, "window!!.decorView");
        s.a(decorView2, this);
        Window window3 = getWindow();
        kotlin.jvm.internal.i.c(window3);
        View decorView3 = window3.getDecorView();
        kotlin.jvm.internal.i.e(decorView3, "window!!.decorView");
        d0.e.a(decorView3, this);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.onBackPressedDispatcher.l();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        OnBackPressedDispatcher onBackPressedDispatcher = this.onBackPressedDispatcher;
        OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
        kotlin.jvm.internal.i.e(onBackInvokedDispatcher, "onBackInvokedDispatcher");
        onBackPressedDispatcher.o(onBackInvokedDispatcher);
        this.savedStateRegistryController.d(bundle);
        getLifecycleRegistry().i(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        kotlin.jvm.internal.i.e(onSaveInstanceState, "super.onSaveInstanceState()");
        this.savedStateRegistryController.e(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        getLifecycleRegistry().i(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        getLifecycleRegistry().i(Lifecycle.Event.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i10) {
        initializeViewTreeOwners();
        super.setContentView(i10);
    }

    public /* synthetic */ j(Context context, int i10, int i11, kotlin.jvm.internal.f fVar) {
        this(context, (i11 & 2) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, int i10) {
        super(context, i10);
        kotlin.jvm.internal.i.f(context, "context");
        this.savedStateRegistryController = d0.c.f29919d.a(this);
        this.onBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.i
            @Override // java.lang.Runnable
            public final void run() {
                j.onBackPressedDispatcher$lambda$1(j.this);
            }
        });
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        kotlin.jvm.internal.i.f(view, "view");
        initializeViewTreeOwners();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.i.f(view, "view");
        initializeViewTreeOwners();
        super.setContentView(view, layoutParams);
    }

    public static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }
}

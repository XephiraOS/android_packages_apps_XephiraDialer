package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.s;
import androidx.core.view.C0456k;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import e.C0961a;
import j.AbstractC1145b;

/* compiled from: AppCompatDialog.java */
/* loaded from: classes.dex */
public class i extends androidx.activity.j implements c {
    private e mDelegate;
    private final C0456k.a mKeyDispatcher;

    public i(Context context) {
        this(context, 0);
    }

    private static int getThemeResId(Context context, int i10) {
        if (i10 == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(C0961a.f30083A, typedValue, true);
            return typedValue.resourceId;
        }
        return i10;
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.b(getWindow().getDecorView(), this);
        d0.e.a(getWindow().getDecorView(), this);
        s.a(getWindow().getDecorView(), this);
    }

    @Override // androidx.activity.j, android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().c(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        getDelegate().w();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return C0456k.b(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i10) {
        return (T) getDelegate().h(i10);
    }

    public e getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = e.g(this, this);
        }
        return this.mDelegate;
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().p();
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().r();
    }

    @Override // androidx.activity.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        getDelegate().q();
        super.onCreate(bundle);
        getDelegate().v(bundle);
    }

    @Override // androidx.activity.j, android.app.Dialog
    public void onStop() {
        super.onStop();
        getDelegate().B();
    }

    @Override // androidx.appcompat.app.c
    public AbstractC1145b onWindowStartingSupportActionMode(AbstractC1145b.a aVar) {
        return null;
    }

    @Override // androidx.activity.j, android.app.Dialog
    public void setContentView(int i10) {
        initViewTreeOwners();
        getDelegate().F(i10);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().M(charSequence);
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean supportRequestWindowFeature(int i10) {
        return getDelegate().E(i10);
    }

    public i(Context context, int i10) {
        super(context, getThemeResId(context, i10));
        this.mKeyDispatcher = new C0456k.a() { // from class: androidx.appcompat.app.h
            @Override // androidx.core.view.C0456k.a
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return i.this.superDispatchKeyEvent(keyEvent);
            }
        };
        e delegate = getDelegate();
        delegate.L(getThemeResId(context, i10));
        delegate.v(null);
    }

    @Override // androidx.activity.j, android.app.Dialog
    public void setContentView(View view) {
        initViewTreeOwners();
        getDelegate().G(view);
    }

    @Override // android.app.Dialog
    public void setTitle(int i10) {
        super.setTitle(i10);
        getDelegate().M(getContext().getString(i10));
    }

    @Override // androidx.activity.j, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().H(view, layoutParams);
    }

    public i(Context context, boolean z10, DialogInterface.OnCancelListener onCancelListener) {
        super(context);
        this.mKeyDispatcher = new C0456k.a() { // from class: androidx.appcompat.app.h
            @Override // androidx.core.view.C0456k.a
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return i.this.superDispatchKeyEvent(keyEvent);
            }
        };
        setCancelable(z10);
        setOnCancelListener(onCancelListener);
    }

    @Override // androidx.appcompat.app.c
    public void onSupportActionModeFinished(AbstractC1145b abstractC1145b) {
    }

    @Override // androidx.appcompat.app.c
    public void onSupportActionModeStarted(AbstractC1145b abstractC1145b) {
    }
}

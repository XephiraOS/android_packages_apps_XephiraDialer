package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;
import e.C0961a;

/* compiled from: AlertDialog.java */
/* loaded from: classes.dex */
public class b extends i implements DialogInterface {

    /* renamed from: a, reason: collision with root package name */
    public final AlertController f7365a;

    /* compiled from: AlertDialog.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: P, reason: collision with root package name */
        private final AlertController.b f7366P;
        private final int mTheme;

        public a(Context context) {
            this(context, b.resolveDialogTheme(context, 0));
        }

        public b create() {
            b bVar = new b(this.f7366P.f7221a, this.mTheme);
            this.f7366P.a(bVar.f7365a);
            bVar.setCancelable(this.f7366P.f7238r);
            if (this.f7366P.f7238r) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.f7366P.f7239s);
            bVar.setOnDismissListener(this.f7366P.f7240t);
            DialogInterface.OnKeyListener onKeyListener = this.f7366P.f7241u;
            if (onKeyListener != null) {
                bVar.setOnKeyListener(onKeyListener);
            }
            return bVar;
        }

        public Context getContext() {
            return this.f7366P.f7221a;
        }

        public a setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7366P;
            bVar.f7243w = listAdapter;
            bVar.f7244x = onClickListener;
            return this;
        }

        public a setCancelable(boolean z10) {
            this.f7366P.f7238r = z10;
            return this;
        }

        public a setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.b bVar = this.f7366P;
            bVar.f7215K = cursor;
            bVar.f7216L = str;
            bVar.f7244x = onClickListener;
            return this;
        }

        public a setCustomTitle(View view) {
            this.f7366P.f7227g = view;
            return this;
        }

        public a setIcon(int i10) {
            this.f7366P.f7223c = i10;
            return this;
        }

        public a setIconAttribute(int i10) {
            TypedValue typedValue = new TypedValue();
            this.f7366P.f7221a.getTheme().resolveAttribute(i10, typedValue, true);
            this.f7366P.f7223c = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public a setInverseBackgroundForced(boolean z10) {
            this.f7366P.f7218N = z10;
            return this;
        }

        public a setItems(int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7366P;
            bVar.f7242v = bVar.f7221a.getResources().getTextArray(i10);
            this.f7366P.f7244x = onClickListener;
            return this;
        }

        public a setMessage(int i10) {
            AlertController.b bVar = this.f7366P;
            bVar.f7228h = bVar.f7221a.getText(i10);
            return this;
        }

        public a setMultiChoiceItems(int i10, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.b bVar = this.f7366P;
            bVar.f7242v = bVar.f7221a.getResources().getTextArray(i10);
            AlertController.b bVar2 = this.f7366P;
            bVar2.f7214J = onMultiChoiceClickListener;
            bVar2.f7210F = zArr;
            bVar2.f7211G = true;
            return this;
        }

        public a setNegativeButton(int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7366P;
            bVar.f7232l = bVar.f7221a.getText(i10);
            this.f7366P.f7234n = onClickListener;
            return this;
        }

        public a setNegativeButtonIcon(Drawable drawable) {
            this.f7366P.f7233m = drawable;
            return this;
        }

        public a setNeutralButton(int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7366P;
            bVar.f7235o = bVar.f7221a.getText(i10);
            this.f7366P.f7237q = onClickListener;
            return this;
        }

        public a setNeutralButtonIcon(Drawable drawable) {
            this.f7366P.f7236p = drawable;
            return this;
        }

        public a setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f7366P.f7239s = onCancelListener;
            return this;
        }

        public a setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f7366P.f7240t = onDismissListener;
            return this;
        }

        public a setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f7366P.f7219O = onItemSelectedListener;
            return this;
        }

        public a setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.f7366P.f7241u = onKeyListener;
            return this;
        }

        public a setPositiveButton(int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7366P;
            bVar.f7229i = bVar.f7221a.getText(i10);
            this.f7366P.f7231k = onClickListener;
            return this;
        }

        public a setPositiveButtonIcon(Drawable drawable) {
            this.f7366P.f7230j = drawable;
            return this;
        }

        public a setRecycleOnMeasureEnabled(boolean z10) {
            this.f7366P.f7220P = z10;
            return this;
        }

        public a setSingleChoiceItems(int i10, int i11, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7366P;
            bVar.f7242v = bVar.f7221a.getResources().getTextArray(i10);
            AlertController.b bVar2 = this.f7366P;
            bVar2.f7244x = onClickListener;
            bVar2.f7213I = i11;
            bVar2.f7212H = true;
            return this;
        }

        public a setTitle(int i10) {
            AlertController.b bVar = this.f7366P;
            bVar.f7226f = bVar.f7221a.getText(i10);
            return this;
        }

        public a setView(int i10) {
            AlertController.b bVar = this.f7366P;
            bVar.f7246z = null;
            bVar.f7245y = i10;
            bVar.f7209E = false;
            return this;
        }

        public b show() {
            b create = create();
            create.show();
            return create;
        }

        public a(Context context, int i10) {
            this.f7366P = new AlertController.b(new ContextThemeWrapper(context, b.resolveDialogTheme(context, i10)));
            this.mTheme = i10;
        }

        public a setIcon(Drawable drawable) {
            this.f7366P.f7224d = drawable;
            return this;
        }

        public a setMessage(CharSequence charSequence) {
            this.f7366P.f7228h = charSequence;
            return this;
        }

        public a setTitle(CharSequence charSequence) {
            this.f7366P.f7226f = charSequence;
            return this;
        }

        public a setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7366P;
            bVar.f7242v = charSequenceArr;
            bVar.f7244x = onClickListener;
            return this;
        }

        public a setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7366P;
            bVar.f7232l = charSequence;
            bVar.f7234n = onClickListener;
            return this;
        }

        public a setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7366P;
            bVar.f7235o = charSequence;
            bVar.f7237q = onClickListener;
            return this;
        }

        public a setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7366P;
            bVar.f7229i = charSequence;
            bVar.f7231k = onClickListener;
            return this;
        }

        public a setView(View view) {
            AlertController.b bVar = this.f7366P;
            bVar.f7246z = view;
            bVar.f7245y = 0;
            bVar.f7209E = false;
            return this;
        }

        public a setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.b bVar = this.f7366P;
            bVar.f7242v = charSequenceArr;
            bVar.f7214J = onMultiChoiceClickListener;
            bVar.f7210F = zArr;
            bVar.f7211G = true;
            return this;
        }

        public a setSingleChoiceItems(Cursor cursor, int i10, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7366P;
            bVar.f7215K = cursor;
            bVar.f7244x = onClickListener;
            bVar.f7213I = i10;
            bVar.f7216L = str;
            bVar.f7212H = true;
            return this;
        }

        @Deprecated
        public a setView(View view, int i10, int i11, int i12, int i13) {
            AlertController.b bVar = this.f7366P;
            bVar.f7246z = view;
            bVar.f7245y = 0;
            bVar.f7209E = true;
            bVar.f7205A = i10;
            bVar.f7206B = i11;
            bVar.f7207C = i12;
            bVar.f7208D = i13;
            return this;
        }

        public a setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.b bVar = this.f7366P;
            bVar.f7215K = cursor;
            bVar.f7214J = onMultiChoiceClickListener;
            bVar.f7217M = str;
            bVar.f7216L = str2;
            bVar.f7211G = true;
            return this;
        }

        public a setSingleChoiceItems(CharSequence[] charSequenceArr, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7366P;
            bVar.f7242v = charSequenceArr;
            bVar.f7244x = onClickListener;
            bVar.f7213I = i10;
            bVar.f7212H = true;
            return this;
        }

        public a setSingleChoiceItems(ListAdapter listAdapter, int i10, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f7366P;
            bVar.f7243w = listAdapter;
            bVar.f7244x = onClickListener;
            bVar.f7213I = i10;
            bVar.f7212H = true;
            return this;
        }
    }

    public b(Context context) {
        this(context, 0);
    }

    public static int resolveDialogTheme(Context context, int i10) {
        if (((i10 >>> 24) & 255) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0961a.f30116o, typedValue, true);
        return typedValue.resourceId;
    }

    public Button b(int i10) {
        return this.f7365a.c(i10);
    }

    public ListView c() {
        return this.f7365a.e();
    }

    public void d(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f7365a.k(i10, charSequence, onClickListener, null, null);
    }

    public void e(View view) {
        this.f7365a.l(view);
    }

    public void f(int i10) {
        this.f7365a.m(i10);
    }

    public void g(Drawable drawable) {
        this.f7365a.n(drawable);
    }

    public void h(CharSequence charSequence) {
        this.f7365a.o(charSequence);
    }

    @Override // androidx.appcompat.app.i, androidx.activity.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7365a.f();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (this.f7365a.g(i10, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (this.f7365a.h(i10, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // androidx.appcompat.app.i, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f7365a.q(charSequence);
    }

    public b(Context context, int i10) {
        super(context, resolveDialogTheme(context, i10));
        this.f7365a = new AlertController(getContext(), this, getWindow());
    }
}

package com.oplus.blacklistapp.callintercept;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/* compiled from: LocalAlertDialog.java */
/* loaded from: classes3.dex */
public class b extends androidx.appcompat.app.b {

    /* compiled from: LocalAlertDialog.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Context f26585a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f26586b;

        /* renamed from: c, reason: collision with root package name */
        public View f26587c;

        /* renamed from: d, reason: collision with root package name */
        public CharSequence f26588d;

        /* renamed from: e, reason: collision with root package name */
        public int f26589e;

        /* renamed from: f, reason: collision with root package name */
        public Drawable f26590f;

        /* renamed from: g, reason: collision with root package name */
        public CharSequence f26591g;

        /* renamed from: h, reason: collision with root package name */
        public DialogInterface.OnClickListener f26592h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f26593i;

        /* renamed from: j, reason: collision with root package name */
        public DialogInterface.OnClickListener f26594j;

        /* renamed from: k, reason: collision with root package name */
        public CharSequence f26595k;

        /* renamed from: l, reason: collision with root package name */
        public DialogInterface.OnClickListener f26596l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f26597m = true;

        /* renamed from: n, reason: collision with root package name */
        public DialogInterface.OnCancelListener f26598n;

        /* renamed from: o, reason: collision with root package name */
        public DialogInterface.OnDismissListener f26599o;

        /* renamed from: p, reason: collision with root package name */
        public DialogInterface.OnKeyListener f26600p;

        public a(Context context) {
            this.f26585a = context;
        }

        public void a(androidx.appcompat.app.b bVar) {
            View view = this.f26587c;
            if (view != null) {
                bVar.e(view);
            } else {
                CharSequence charSequence = this.f26586b;
                if (charSequence != null) {
                    bVar.setTitle(charSequence);
                }
                Drawable drawable = this.f26590f;
                if (drawable != null) {
                    bVar.g(drawable);
                }
                int i10 = this.f26589e;
                if (i10 != 0) {
                    bVar.f(i10);
                }
            }
            CharSequence charSequence2 = this.f26588d;
            if (charSequence2 != null) {
                bVar.h(charSequence2);
            }
            CharSequence charSequence3 = this.f26591g;
            if (charSequence3 != null) {
                bVar.d(-1, charSequence3, this.f26592h);
            }
            CharSequence charSequence4 = this.f26593i;
            if (charSequence4 != null) {
                bVar.d(-2, charSequence4, this.f26594j);
            }
            CharSequence charSequence5 = this.f26595k;
            if (charSequence5 != null) {
                bVar.d(-3, charSequence5, this.f26596l);
            }
        }

        public b b() {
            b bVar = new b(this.f26585a);
            a(bVar);
            bVar.setCancelable(this.f26597m);
            if (this.f26597m) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.f26598n);
            bVar.setOnDismissListener(this.f26599o);
            DialogInterface.OnKeyListener onKeyListener = this.f26600p;
            if (onKeyListener != null) {
                bVar.setOnKeyListener(onKeyListener);
            }
            return bVar;
        }

        public a c(int i10, DialogInterface.OnClickListener onClickListener) {
            this.f26593i = this.f26585a.getText(i10);
            this.f26594j = onClickListener;
            return this;
        }

        public a d(DialogInterface.OnDismissListener onDismissListener) {
            this.f26599o = onDismissListener;
            return this;
        }

        public a e(DialogInterface.OnKeyListener onKeyListener) {
            this.f26600p = onKeyListener;
            return this;
        }

        public a f(int i10, DialogInterface.OnClickListener onClickListener) {
            this.f26591g = this.f26585a.getText(i10);
            this.f26592h = onClickListener;
            return this;
        }

        public a g(CharSequence charSequence) {
            this.f26586b = charSequence;
            return this;
        }
    }

    public b(Context context) {
        super(context);
    }

    @Override // androidx.appcompat.app.b, androidx.appcompat.app.i, androidx.activity.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TextView textView = (TextView) findViewById(R.id.message);
        if (textView != null) {
            textView.setGravity(17);
        }
    }
}

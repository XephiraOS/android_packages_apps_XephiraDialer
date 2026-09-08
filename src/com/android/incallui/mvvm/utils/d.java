package com.android.incallui.mvvm.utils;

import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.incallui.mvvm.command_model.CommandModelPipeLineKt;
import g2.InterfaceC1038e;
import java.io.Serializable;
import v9.InterfaceC1637a;

/* compiled from: BindingAdapterUtil.kt */
/* loaded from: classes.dex */
public final class d {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(View view, com.android.incallui.oplus.answerview.protocol.a aVar) {
        InterfaceC1038e interfaceC1038e;
        kotlin.jvm.internal.i.f(view, "view");
        if (view instanceof InterfaceC1038e) {
            interfaceC1038e = (InterfaceC1038e) view;
        } else {
            interfaceC1038e = null;
        }
        if (interfaceC1038e != null) {
            interfaceC1038e.setMViewUserAction(aVar);
        }
        if (aVar != null) {
            aVar.b(view);
        }
    }

    public static final void c(CompoundButton view, boolean z10) {
        kotlin.jvm.internal.i.f(view, "view");
        view.setChecked(z10);
    }

    public static final void d(View view, int i10) {
        kotlin.jvm.internal.i.f(view, "view");
        view.setBackground(new ColorDrawable(i10));
    }

    public static final void e(View view, int i10) {
        kotlin.jvm.internal.i.f(view, "view");
        view.setContentDescription(view.getContext().getString(i10));
    }

    public static final void f(View view, boolean z10) {
        kotlin.jvm.internal.i.f(view, "view");
        view.setEnabled(z10);
    }

    public static final void g(ImageView view, Integer num) {
        kotlin.jvm.internal.i.f(view, "view");
        if (num == null) {
            view.setImageDrawable(null);
        } else {
            view.setImageResource(num.intValue());
        }
    }

    public static final void h(View view, int i10) {
        ConstraintLayout.LayoutParams layoutParams;
        kotlin.jvm.internal.i.f(view, "view");
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 instanceof ConstraintLayout.LayoutParams) {
            layoutParams = (ConstraintLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.goneTopMargin = i10;
        }
        view.requestLayout();
    }

    public static final void i(View view, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        kotlin.jvm.internal.i.f(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = i10;
        }
        view.requestLayout();
    }

    public static final void j(View view, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        kotlin.jvm.internal.i.f(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = i10;
        }
        view.requestLayout();
    }

    public static final void k(View view, int i10) {
        kotlin.jvm.internal.i.f(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i10;
        }
        view.requestLayout();
    }

    public static final void l(View view, final InterfaceC1637a<m9.q> onClick) {
        kotlin.jvm.internal.i.f(view, "view");
        kotlin.jvm.internal.i.f(onClick, "onClick");
        view.setOnClickListener(new View.OnClickListener() { // from class: com.android.incallui.mvvm.utils.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.m(InterfaceC1637a.this, view2);
            }
        });
    }

    public static final void m(InterfaceC1637a onClick, View view) {
        kotlin.jvm.internal.i.f(onClick, "$onClick");
        CommandModelPipeLineKt.c(onClick, null, 1, null);
    }

    public static final void n(View view, int i10) {
        kotlin.jvm.internal.i.f(view, "view");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i10);
    }

    public static final void o(View view, int i10) {
        kotlin.jvm.internal.i.f(view, "view");
        view.setPadding(view.getPaddingLeft(), i10, view.getPaddingRight(), view.getPaddingBottom());
    }

    public static final void p(View view, boolean z10) {
        kotlin.jvm.internal.i.f(view, "view");
        view.setSelected(z10);
    }

    public static final void q(TextView view, Serializable resIdOrString) {
        kotlin.jvm.internal.i.f(view, "view");
        kotlin.jvm.internal.i.f(resIdOrString, "resIdOrString");
        if (resIdOrString instanceof String) {
            view.setText((CharSequence) resIdOrString);
        } else if ((resIdOrString instanceof Integer) && !kotlin.jvm.internal.i.b(resIdOrString, 0)) {
            view.setText(((Number) resIdOrString).intValue());
        } else {
            view.setText((CharSequence) null);
        }
    }

    public static final void r(EditText view, String text) {
        kotlin.jvm.internal.i.f(view, "view");
        kotlin.jvm.internal.i.f(text, "text");
        view.setText(text);
        view.setSelection(text.length());
    }

    public static final void s(View view, boolean z10) {
        int i10;
        kotlin.jvm.internal.i.f(view, "view");
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        view.setVisibility(i10);
    }

    public static final void t(View view, boolean z10) {
        kotlin.jvm.internal.i.f(view, "view");
        Log.d("BindingAdapterUtil", "showAnimationWhenIncoming " + z10);
        if (z10) {
            com.android.incallui.anim.b.c().k(view, true);
        }
    }
}

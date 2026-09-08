package com.android.contacts.framework.baseui.widget;

import android.R;
import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.coui.appcompat.preference.COUISwitchPreference;

/* compiled from: ContactsSwitchPreference.kt */
/* loaded from: classes.dex */
public class ContactsSwitchPreference extends COUISwitchPreference {

    /* renamed from: a, reason: collision with root package name */
    public View.OnClickListener f16008a;

    /* renamed from: b, reason: collision with root package name */
    public W0.c f16009b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16010c;

    public ContactsSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static final void b(ContactsSwitchPreference this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.f16008a;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.coui.appcompat.preference.COUISwitchPreference, androidx.preference.SwitchPreference, androidx.preference.Preference
    public void onBindViewHolder(androidx.preference.l holder) {
        TextView textView;
        W0.c cVar;
        kotlin.jvm.internal.i.f(holder, "holder");
        super.onBindViewHolder(holder);
        View e10 = holder.e(R.id.summary);
        if (e10 instanceof TextView) {
            textView = (TextView) e10;
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.android.contacts.framework.baseui.widget.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ContactsSwitchPreference.b(ContactsSwitchPreference.this, view);
                }
            });
        }
        View view = holder.itemView;
        if (view != null && this.f16009b == null) {
            this.f16009b = new W0.c(view);
        }
        if (this.f16010c && (cVar = this.f16009b) != null) {
            cVar.i();
        }
        this.f16010c = false;
    }
}

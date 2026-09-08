package com.customize.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.InterfaceC0480c;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.K;
import com.oplus.dialer.R;

/* loaded from: classes3.dex */
public class ContactTouchSearchView extends TouchSearchView implements InterfaceC0480c {

    /* renamed from: V0, reason: collision with root package name */
    public InterfaceC0492o f22281V0;

    public ContactTouchSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22281V0 = null;
        T(context);
    }

    public void T(Context context) {
        String a10 = K.a();
        if ((a10.equalsIgnoreCase("zh-HK") || a10.startsWith("zh-Hant")) && FeatureOption.o()) {
            setPopupWindowTextSize((int) (context.getResources().getDimensionPixelSize(R.dimen.SP_18) / context.getResources().getConfiguration().fontScale));
        }
    }

    @Override // com.customize.contacts.widget.TouchSearchView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f22281V0 == null) {
            this.f22281V0 = ViewTreeLifecycleOwner.a(this);
        }
        InterfaceC0492o interfaceC0492o = this.f22281V0;
        if (interfaceC0492o != null) {
            interfaceC0492o.getLifecycle().a(this);
        }
    }

    @Override // com.customize.contacts.widget.TouchSearchView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC0492o interfaceC0492o = this.f22281V0;
        if (interfaceC0492o != null) {
            interfaceC0492o.getLifecycle().d(this);
        }
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onPause(InterfaceC0492o interfaceC0492o) {
        r();
    }
}

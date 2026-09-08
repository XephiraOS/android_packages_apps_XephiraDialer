package com.customize.contacts.viewmodel;

import G0.c;
import H7.b;
import android.content.Context;
import androidx.lifecycle.I;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import com.android.contacts.dialpad.d;
import com.customize.contacts.FeatureOption;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: DialPadFragmentViewModel.kt */
/* loaded from: classes3.dex */
public final class DialPadFragmentViewModel extends I {

    /* renamed from: e, reason: collision with root package name */
    public static final a f22207e = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public final v<Integer> f22208d = new v<>(-1);

    /* compiled from: DialPadFragmentViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final int a(Context context) {
            i.f(context, "context");
            if (FeatureOption.o()) {
                return d.a();
            }
            return c.d(context, 0, "DialOption", 0);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final int g() {
        Integer value = this.f22208d.getValue();
        if (value == null) {
            return -1;
        }
        return value.intValue();
    }

    public final void h(InterfaceC0492o owner, w<? super Integer> observer) {
        i.f(owner, "owner");
        i.f(observer, "observer");
        this.f22208d.i(owner, observer);
    }

    public final void i(int i10) {
        Integer value = this.f22208d.getValue();
        if (value == null || value.intValue() != i10) {
            b.b("DialPadFragmentViewModel", "setSilkType preType = " + this.f22208d.getValue() + ", silkType = " + this.f22208d);
            this.f22208d.o(Integer.valueOf(i10));
        }
    }

    public final void j(Context context) {
        if (context != null) {
            i(f22207e.a(context));
        }
    }
}

package com.oplus.contacts.list.dialog.delete;

import androidx.lifecycle.I;
import androidx.lifecycle.J;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.m;
import kotlinx.coroutines.flow.n;

/* compiled from: DeleteConfirmCountDownDialogViewModel.kt */
/* loaded from: classes3.dex */
public final class DeleteConfirmCountDownDialogViewModel extends I {

    /* renamed from: g, reason: collision with root package name */
    public static final a f27913g = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public i<Integer> f27914d;

    /* renamed from: e, reason: collision with root package name */
    public final m<Integer> f27915e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f27916f;

    /* compiled from: DeleteConfirmCountDownDialogViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public DeleteConfirmCountDownDialogViewModel() {
        i<Integer> a10 = n.a(null);
        this.f27914d = a10;
        this.f27915e = a10;
    }

    public final m<Integer> h() {
        return this.f27915e;
    }

    public final void i(int i10) {
        if (this.f27916f) {
            return;
        }
        this.f27916f = true;
        C1248i.d(J.a(this), S.a(), null, new DeleteConfirmCountDownDialogViewModel$startCountDown$1(i10, this, null), 2, null);
    }
}

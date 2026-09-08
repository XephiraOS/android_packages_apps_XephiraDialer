package com.android.contacts.framework.omoji.viewmodel;

import H7.b;
import android.content.Context;
import androidx.lifecycle.I;
import androidx.lifecycle.J;
import androidx.lifecycle.v;
import kotlin.jvm.internal.f;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;

/* compiled from: OmojiViewModule.kt */
/* loaded from: classes.dex */
public final class OmojiViewModule extends I {

    /* renamed from: e, reason: collision with root package name */
    public static final a f16307e = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public final v<com.android.contacts.framework.omoji.viewmodel.a> f16308d = new v<>();

    /* compiled from: OmojiViewModule.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final v<com.android.contacts.framework.omoji.viewmodel.a> g() {
        return this.f16308d;
    }

    public final void h(Context context, boolean z10, boolean z11) {
        Context context2;
        OmojiRepository omojiRepository = OmojiRepository.f16303a;
        if (omojiRepository.a().a() != null && z11) {
            this.f16308d.o(omojiRepository.a());
            b.e("OmojiViewModule", "has cache -------");
        }
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        C1248i.d(J.a(this), S.b(), null, new OmojiViewModule$getOmojiList$1(context2, z10, this, null), 2, null);
    }
}

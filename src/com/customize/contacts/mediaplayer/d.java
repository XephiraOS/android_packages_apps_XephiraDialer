package com.customize.contacts.mediaplayer;

import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import kotlin.jvm.internal.i;

/* compiled from: PlayerController.kt */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: e, reason: collision with root package name */
    public static final a f21702e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0492o f21703a;

    /* renamed from: b, reason: collision with root package name */
    public v<PlayState> f21704b;

    /* renamed from: c, reason: collision with root package name */
    public w<PlayState> f21705c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f21706d;

    /* compiled from: PlayerController.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public d(InterfaceC0492o owner) {
        i.f(owner, "owner");
        this.f21703a = owner;
        this.f21704b = new v<>(PlayState.PLAYER_STATE_INIT);
    }

    public static final void e(PlayState it) {
        i.f(it, "it");
        H7.b.b("PlayerController", "onChange: current play status is:" + it);
    }

    public final boolean b() {
        return this.f21706d;
    }

    public final v<PlayState> c() {
        return this.f21704b;
    }

    public final void d() {
        if (this.f21705c == null) {
            this.f21705c = new w() { // from class: com.customize.contacts.mediaplayer.c
                @Override // androidx.lifecycle.w
                public final void onChanged(Object obj) {
                    d.e((PlayState) obj);
                }
            };
        }
        w<PlayState> wVar = this.f21705c;
        if (wVar != null) {
            this.f21704b.i(this.f21703a, wVar);
        }
        this.f21706d = true;
    }

    public final void f() {
        w<PlayState> wVar = this.f21705c;
        if (wVar != null) {
            this.f21704b.n(wVar);
        }
        this.f21705c = null;
        this.f21706d = false;
    }
}

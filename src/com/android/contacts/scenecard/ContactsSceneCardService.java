package com.android.contacts.scenecard;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.oplus.scenecard.SceneCardService;

/* compiled from: ContactsSceneCardService.kt */
/* loaded from: classes.dex */
public final class ContactsSceneCardService extends SceneCardService {

    /* renamed from: j, reason: collision with root package name */
    public static final a f17078j = new a(null);

    /* compiled from: ContactsSceneCardService.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    @Override // com.oplus.scenecard.SceneCardService
    public View f(Context context, int i10, int i11, int i12) {
        H7.b.e("ContactsSceneCardService", "getCardView " + i10);
        return C0670d.f17264a.f(i10);
    }

    @Override // com.oplus.scenecard.SceneCardService
    public void i(Configuration configuration) {
        super.i(configuration);
        if (configuration != null) {
            H7.b.c("ContactsSceneCardService", "onCardConfigurationChanged");
            C0670d.f17264a.c(configuration);
        }
    }

    @Override // com.oplus.scenecard.SceneCardService
    public void k(Context context, int i10) {
        super.k(context, i10);
        C0670d.f17264a.d(i10);
    }

    @Override // com.oplus.scenecard.SceneCardService
    public void l(int i10) {
        super.l(i10);
        C0670d.f17264a.e(i10);
    }

    @Override // com.oplus.scenecard.SceneCardService
    public void m(int i10) {
        super.m(i10);
        C0670d.f17264a.h(i10);
    }

    @Override // com.oplus.scenecard.SceneCardService
    public void o(int i10) {
        super.o(i10);
        C0670d.f17264a.i(i10);
    }

    @Override // com.oplus.scenecard.SceneCardService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        H7.b.c("ContactsSceneCardService", "onDestroy");
        C0670d.f17264a.a();
    }

    @Override // com.oplus.scenecard.SceneCardService
    public void p(int i10) {
        super.p(i10);
        C0670d.f17264a.b(i10);
    }

    @Override // com.oplus.scenecard.SceneCardService
    public void q(Context context) {
        super.q(context);
        C0670d.f17264a.g(context);
        if (H7.a.b()) {
            FragmentManager.a0(true);
        }
    }
}

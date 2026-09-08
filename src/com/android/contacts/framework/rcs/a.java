package com.android.contacts.framework.rcs;

import android.content.Context;
import com.android.contacts.framework.api.rcs.IRcsApi;
import com.juphoon.helper.RcsBroadcastHelper;
import com.juphoon.helper.b;
import com.juphoon.helper.c;
import com.juphoon.rcs.tool.RcsGroupChatManager;
import com.juphoon.rcs.tool.RcsServiceManager;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: RcsApiImpl.kt */
/* loaded from: classes.dex */
public final class a implements IRcsApi {

    /* renamed from: c, reason: collision with root package name */
    public static final C0168a f16321c = new C0168a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final a f16322d = new a();

    /* renamed from: b, reason: collision with root package name */
    public boolean f16323b;

    /* compiled from: RcsApiImpl.kt */
    /* renamed from: com.android.contacts.framework.rcs.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0168a {
        public C0168a() {
        }

        public final a a() {
            return a.f16322d;
        }

        public /* synthetic */ C0168a(f fVar) {
            this();
        }
    }

    public static final void i(IRcsApi.a listener, String phoneNumber, boolean z10, String cap, boolean z11) {
        i.f(listener, "$listener");
        i.e(phoneNumber, "phoneNumber");
        i.e(cap, "cap");
        listener.a(phoneNumber, z10, cap, z11);
    }

    @Override // com.android.contacts.framework.api.rcs.IRcsApi
    public boolean a(String str) {
        return com.juphoon.helper.a.e(str);
    }

    @Override // com.android.contacts.framework.api.rcs.IRcsApi
    public void b(String phoneNumber, final IRcsApi.a listener, boolean z10) {
        i.f(phoneNumber, "phoneNumber");
        i.f(listener, "listener");
        com.juphoon.helper.a.g(phoneNumber, new RcsBroadcastHelper.a() { // from class: i1.a
            @Override // com.juphoon.helper.RcsBroadcastHelper.a
            public final void a(String str, boolean z11, String str2, boolean z12) {
                com.android.contacts.framework.rcs.a.i(IRcsApi.a.this, str, z11, str2, z12);
            }
        }, z10);
    }

    @Override // com.android.contacts.framework.api.rcs.IRcsApi
    public String c() {
        String B10 = RcsServiceManager.B();
        i.e(B10, "getUserName()");
        return B10;
    }

    @Override // com.android.contacts.framework.api.rcs.IRcsApi
    public boolean d() {
        return RcsServiceManager.D();
    }

    @Override // com.android.contacts.framework.api.rcs.IRcsApi
    public void e(Context context, boolean z10) {
        i.f(context, "context");
        if (!this.f16323b && z10) {
            this.f16323b = true;
            RcsServiceManager.C(context, "com.android.mms");
            RcsGroupChatManager.d(context);
            c.f(context);
            RcsBroadcastHelper.d(context, Boolean.FALSE);
            com.juphoon.helper.a.c(context);
            b.f(context);
        }
    }

    @Override // com.android.contacts.framework.api.rcs.IRcsApi
    public String f(String phoneNumber) {
        i.f(phoneNumber, "phoneNumber");
        String c10 = com.juphoon.rcs.tool.b.c(phoneNumber);
        i.e(c10, "formatPhoneNoCountryPrefix(phoneNumber)");
        return c10;
    }
}

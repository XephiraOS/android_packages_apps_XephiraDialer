package com.oplus.contacts.googlecontacts;

import P7.a;
import R7.b;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.android.contacts.framework.api.togoogle.MoveToGoogleApi;
import com.android.incallui.OplusPhoneCapabilities;
import com.heytap.accessory.constant.FastPairConstants;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.contacts.googlecontacts.GoogleContactsImpl;
import com.oplus.contacts.googlecontacts.actvities.MoveContactsToGoogleActivity;
import com.oplus.foundation.util.ui.c;
import kotlin.Result;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.d;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: GoogleContactsImpl.kt */
/* loaded from: classes3.dex */
public final class GoogleContactsImpl implements MoveToGoogleApi {

    /* renamed from: c, reason: collision with root package name */
    public static final a f27813c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final GoogleContactsImpl f27814d = new GoogleContactsImpl();

    /* renamed from: b, reason: collision with root package name */
    public final d f27815b;

    /* compiled from: GoogleContactsImpl.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final GoogleContactsImpl a() {
            return GoogleContactsImpl.f27814d;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public GoogleContactsImpl() {
        d b10;
        b10 = kotlin.a.b(new InterfaceC1637a<SharedPreferences>() { // from class: com.oplus.contacts.googlecontacts.GoogleContactsImpl$sp$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final SharedPreferences invoke() {
                return a.f2961a.a().getSharedPreferences("google_contacts", 0);
            }
        });
        this.f27815b = b10;
    }

    public static final void i(GoogleContactsImpl this$0, Context context, AccountManagerFuture accountManagerFuture) {
        Object b10;
        Object obj;
        i.f(this$0, "this$0");
        i.f(context, "$context");
        try {
            Result.a aVar = Result.f34166a;
            Intent intent = (Intent) ((Bundle) accountManagerFuture.getResult()).getParcelable(Constants.MessagerConstants.INTENT_KEY, Intent.class);
            if (intent != null) {
                intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE).addFlags(FastPairConstants.PAIR_TYPE_BLE_IN_PAIR);
                obj = Boolean.valueOf(b.f(context, intent, 0, null, 6, null));
            } else {
                c.d(context, B7.a.f261a);
                obj = q.f35511a;
            }
            b10 = Result.b(obj);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("GoogleContactsImpl", "startLoginGoogleAccount error: " + d10.getMessage());
        }
    }

    @Override // com.android.contacts.framework.api.togoogle.MoveToGoogleApi
    public void a(Context context) {
        i.f(context, "context");
        h(context);
    }

    @Override // com.android.contacts.framework.api.togoogle.MoveToGoogleApi
    public boolean b() {
        boolean z10 = g().getBoolean("move_contacts_used", false);
        boolean z11 = g().getBoolean("ignore_tips", false);
        H7.b.b("GoogleContactsImpl", "isNeedMoveToGoogle used : " + z10 + ", ignore : " + z11);
        if (z10 || z11) {
            return false;
        }
        return true;
    }

    @Override // com.android.contacts.framework.api.togoogle.MoveToGoogleApi
    public void c() {
        g().edit().putBoolean("ignore_tips", true).apply();
    }

    @Override // com.android.contacts.framework.api.togoogle.MoveToGoogleApi
    public void d(Context context) {
        i.f(context, "context");
        g().edit().putBoolean("move_contacts_used", true).apply();
        b.f(context, new Intent(context, (Class<?>) MoveContactsToGoogleActivity.class), 0, null, 6, null);
    }

    public final SharedPreferences g() {
        Object value = this.f27815b.getValue();
        i.e(value, "<get-sp>(...)");
        return (SharedPreferences) value;
    }

    public final void h(final Context context) {
        i.f(context, "context");
        AccountManager.get(context).addAccount("com.google", null, null, null, null, new AccountManagerCallback() { // from class: Y6.a
            @Override // android.accounts.AccountManagerCallback
            public final void run(AccountManagerFuture accountManagerFuture) {
                GoogleContactsImpl.i(GoogleContactsImpl.this, context, accountManagerFuture);
            }
        }, null);
    }
}

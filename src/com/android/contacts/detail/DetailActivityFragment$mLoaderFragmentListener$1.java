package com.android.contacts.detail;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Entity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.android.contacts.ContactLoader;
import com.android.contacts.activities.ContactEditorActivity;
import com.android.contacts.detail.ContactLoaderFragment;
import com.android.contacts.framework.baseui.sim.SimContactInfo;
import com.android.contacts.framework.baseui.util.C0636a;
import com.android.contacts.framework.baseui.util.C0637b;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import java.util.Iterator;
import kotlinx.coroutines.C1248i;

/* compiled from: DetailActivityFragment.kt */
/* loaded from: classes.dex */
public final class DetailActivityFragment$mLoaderFragmentListener$1 implements ContactLoaderFragment.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DetailActivityFragment f14466a;

    public DetailActivityFragment$mLoaderFragmentListener$1(DetailActivityFragment detailActivityFragment) {
        this.f14466a = detailActivityFragment;
    }

    public static final void h(DetailActivityFragment this$0, ContactLoader.Result result) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(result, "$result");
        if (this$0.D1()) {
            return;
        }
        this$0.o4(result);
        this$0.f14416Q = result.L();
        this$0.i4(this$0.n3());
        this$0.m4(this$0.f14416Q);
        Uri uri = this$0.f14416Q;
        if (uri != null) {
            this$0.f14422W = ContentUris.parseId(uri);
        }
        if (kotlin.jvm.internal.i.b("com.oplus.contacts.sim", result.p())) {
            this$0.f14422W = result.M();
        }
        this$0.z1();
        this$0.f14445t0 = S3.n.a(this$0.f14422W, this$0.o3(), this$0.n3());
    }

    @Override // com.android.contacts.detail.ContactLoaderFragment.d
    public void a() {
        boolean z10;
        if (!this.f14466a.r3()) {
            z10 = this.f14466a.f14418S;
            if (!z10) {
                com.oplus.foundation.util.ui.c.d(this.f14466a.o3(), R.string.contact_does_not_exist);
            }
            this.f14466a.o1();
            return;
        }
        Intent intent = new Intent("com.oplus.contacts.CONTACT_NOT_FIND");
        X.a b10 = X.a.b(this.f14466a.o3());
        kotlin.jvm.internal.i.e(b10, "getInstance(mContext)");
        b10.d(intent);
    }

    @Override // com.android.contacts.detail.ContactLoaderFragment.d
    public void b(Uri uri) {
        String str;
        String str2;
        String str3;
        Intent intent = new Intent();
        if (C0637b.h()) {
            intent.putExtra("edit_page_start_source", 3);
        }
        intent.putExtra("finishActivityOnSaveCompleted", true);
        ContactLoader.Result n32 = this.f14466a.n3();
        if (n32 != null && kotlin.jvm.internal.i.b("com.oplus.contacts.sim", n32.p())) {
            String str4 = null;
            if (40 == n32.C()) {
                str = n32.B();
            } else {
                str = null;
            }
            int O10 = n32.O();
            if (O10 != 1) {
                if (O10 != 2) {
                    str2 = null;
                    str3 = null;
                } else {
                    String str5 = n32.P().get(0);
                    str3 = n32.P().get(1);
                    str2 = str5;
                }
            } else {
                str2 = n32.P().get(0);
                str3 = null;
            }
            Iterator<Entity.NamedContentValues> it = n32.D().get(0).getSubValues().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ContentValues contentValues = it.next().values;
                if (kotlin.jvm.internal.i.b("vnd.android.cursor.item/email_v2", contentValues.getAsString("mimetype"))) {
                    str4 = contentValues.getAsString("data1");
                    break;
                }
            }
            SimContactInfo simContactInfo = new SimContactInfo(n32.M(), str, str2, str3, str4);
            simContactInfo.f(n32.o());
            simContactInfo.j(n32.M());
            intent.setClass(this.f14466a.o3(), ContactEditorActivity.class);
            intent.putExtra("sim_contacts_info", simContactInfo);
        } else {
            intent.setAction("com.oplus.contacts.EDIT_CONTACTS");
            intent.setData(this.f14466a.f14416Q);
            if (this.f14466a.K3()) {
                intent.putExtra("newLocalProfile", true);
            }
            ContactLoaderFragment w32 = this.f14466a.w3();
            if (w32 != null) {
                w32.j1();
            }
        }
        S7.b.b(this.f14466a, intent, 123, 0);
        C0636a.a(this.f14466a.requireActivity());
    }

    @Override // com.android.contacts.detail.ContactLoaderFragment.d
    public void c(ContactLoader.Result result) {
        z0 p32;
        if (result == null) {
            return;
        }
        if (CommonFeatureOption.o(this.f14466a.getContext()) && (p32 = this.f14466a.p3()) != null && p32.Y1()) {
            C1248i.d(androidx.lifecycle.p.a(this.f14466a), kotlinx.coroutines.S.a(), null, new DetailActivityFragment$mLoaderFragmentListener$1$onDetailsLoaded$1(this.f14466a, result, this, null), 2, null);
        } else {
            g(result);
        }
    }

    public final void g(final ContactLoader.Result result) {
        Handler handler = this.f14466a.f14420U;
        if (handler == null) {
            kotlin.jvm.internal.i.q("mHandler");
            handler = null;
        }
        final DetailActivityFragment detailActivityFragment = this.f14466a;
        handler.post(new Runnable() { // from class: com.android.contacts.detail.h0
            @Override // java.lang.Runnable
            public final void run() {
                DetailActivityFragment$mLoaderFragmentListener$1.h(DetailActivityFragment.this, result);
            }
        });
    }

    @Override // com.android.contacts.detail.ContactLoaderFragment.d
    public void d(Uri uri) {
    }
}

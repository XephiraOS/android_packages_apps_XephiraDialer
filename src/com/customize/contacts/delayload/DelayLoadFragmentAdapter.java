package com.customize.contacts.delayload;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.customize.contacts.activities.ContactsTabActivity;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;

/* compiled from: DelayLoadFragmentAdapter.kt */
/* loaded from: classes3.dex */
public final class DelayLoadFragmentAdapter extends b {

    /* renamed from: e, reason: collision with root package name */
    public static final a f20945e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public final Fragment f20946c;

    /* renamed from: d, reason: collision with root package name */
    public final String f20947d;

    /* compiled from: DelayLoadFragmentAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public DelayLoadFragmentAdapter(Fragment delayLoadFragment, String fragmentTag) {
        i.f(delayLoadFragment, "delayLoadFragment");
        i.f(fragmentTag, "fragmentTag");
        this.f20946c = delayLoadFragment;
        this.f20947d = fragmentTag;
    }

    @Override // com.customize.contacts.delayload.b
    public void b(ContactsTabActivity contactsTabActivity, FragmentManager fragmentManager, ContactsTabActivity.l lVar) {
        if (!this.f20948a) {
            H7.b.b("DelayLoadFragmentAdapter", "delay to replaced tag:" + this.f20947d);
            C1248i.d(C1241e0.f34422a, S.c(), null, new DelayLoadFragmentAdapter$replace$1(this, contactsTabActivity, fragmentManager, lVar, null), 2, null);
        }
    }
}

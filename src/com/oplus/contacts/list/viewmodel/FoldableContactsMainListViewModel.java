package com.oplus.contacts.list.viewmodel;

import android.net.Uri;
import androidx.lifecycle.J;
import com.oplus.contacts.list.uistate.ContactsMainListRightFragmentUiState;
import kotlin.jvm.internal.f;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.m;
import kotlinx.coroutines.flow.n;

/* compiled from: FoldableContactsMainListViewModel.kt */
/* loaded from: classes3.dex */
public final class FoldableContactsMainListViewModel extends ContactsMainListViewModel {

    /* renamed from: x, reason: collision with root package name */
    public static final a f28092x = new a(null);

    /* renamed from: n, reason: collision with root package name */
    public final i<ContactsMainListRightFragmentUiState> f28093n;

    /* renamed from: o, reason: collision with root package name */
    public final m<ContactsMainListRightFragmentUiState> f28094o;

    /* renamed from: p, reason: collision with root package name */
    public ContactsMainListRightFragmentUiState f28095p;

    /* renamed from: q, reason: collision with root package name */
    public Uri f28096q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f28097r;

    /* compiled from: FoldableContactsMainListViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public FoldableContactsMainListViewModel() {
        i<ContactsMainListRightFragmentUiState> a10 = n.a(null);
        this.f28093n = a10;
        this.f28094o = a10;
    }

    public final ContactsMainListRightFragmentUiState G() {
        return this.f28095p;
    }

    public final boolean H() {
        return this.f28097r;
    }

    public final m<ContactsMainListRightFragmentUiState> I() {
        return this.f28094o;
    }

    public final void J(ContactsMainListRightFragmentUiState contactsMainListRightFragmentUiState) {
        this.f28095p = contactsMainListRightFragmentUiState;
    }

    public final void K(boolean z10) {
        this.f28097r = z10;
    }

    public final void L(Uri uri) {
        this.f28096q = uri;
    }

    public final void M(ContactsMainListRightFragmentUiState contactsMainListRightFragmentUiState) {
        C1248i.d(J.a(this), null, null, new FoldableContactsMainListViewModel$updateRightFragmentState$1(contactsMainListRightFragmentUiState, this, null), 3, null);
    }
}

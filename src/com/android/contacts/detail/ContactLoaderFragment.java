package com.android.contacts.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.loader.app.a;
import com.android.contacts.ContactLoader;
import com.android.contacts.Y0;
import com.android.contacts.detail.CallDetailActivityFragment;
import com.android.contacts.framework.baseui.sim.SimContactInfo;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.fragment.BaseActivityFragment;
import com.customize.contacts.util.ContactDataUtils;
import com.oplus.dialer.R;
import w0.C1641a;

/* loaded from: classes.dex */
public class ContactLoaderFragment extends Fragment implements CallDetailActivityFragment.e {

    /* renamed from: a, reason: collision with root package name */
    public String f14374a;

    /* renamed from: b, reason: collision with root package name */
    public String f14375b;

    /* renamed from: c, reason: collision with root package name */
    public Context f14376c;

    /* renamed from: d, reason: collision with root package name */
    public Uri f14377d;

    /* renamed from: e, reason: collision with root package name */
    public d f14378e;

    /* renamed from: f, reason: collision with root package name */
    public ContactLoader.Result f14379f;

    /* renamed from: g, reason: collision with root package name */
    public W.c<ContactLoader.Result> f14380g;

    /* renamed from: h, reason: collision with root package name */
    public SimContactInfo f14381h = null;

    /* renamed from: i, reason: collision with root package name */
    public boolean f14382i = false;

    /* renamed from: j, reason: collision with root package name */
    public String f14383j = null;

    /* renamed from: k, reason: collision with root package name */
    public final a.InterfaceC0129a<ContactLoader.Result> f14384k = new a();

    /* renamed from: l, reason: collision with root package name */
    public final a.InterfaceC0129a<ContactLoader.Result> f14385l = new b();

    /* renamed from: m, reason: collision with root package name */
    public ContactDataUtils.a f14386m = new c();

    /* loaded from: classes.dex */
    public class c implements ContactDataUtils.a {
        public c() {
        }

        @Override // com.customize.contacts.util.ContactDataUtils.a
        public void a() {
            ContactLoaderFragment.this.r1();
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b(Uri uri);

        void c(ContactLoader.Result result);

        void d(Uri uri);
    }

    public void j1() {
        W.c<ContactLoader.Result> cVar = this.f14380g;
        if (cVar instanceof ContactLoader) {
            ((ContactLoader) cVar).c0();
        }
    }

    public void k1(Uri uri) {
        if (uri != null && !com.customize.contacts.manager.i.j(uri)) {
            this.f14374a = uri.toString();
        } else {
            this.f14374a = null;
        }
        ContactDataUtils.a(this.f14376c, this.f14377d, this.f14374a, this.f14386m);
    }

    public void l1(int i10, String str) {
        if (H7.a.b()) {
            H7.b.b("ContactLoaderFragment", "handleVibrationPicked: pickedType = " + i10 + ", pickedStr = " + str);
        }
        if (com.customize.contacts.manager.h.h(i10, str)) {
            String b10 = com.customize.contacts.manager.h.b(Integer.valueOf(i10), str);
            this.f14375b = b10;
            ContactDataUtils.c(this.f14376c, this.f14377d, b10, this.f14386m);
        }
    }

    public void m1(SimContactInfo simContactInfo) {
        this.f14381h = simContactInfo;
        if (getActivity() != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("sim_contacts_info", this.f14381h);
            this.f14380g = getLoaderManager().g(2, bundle, this.f14385l);
        }
    }

    public void n1(Uri uri) {
        String str;
        if (com.google.common.base.h.a(uri, this.f14377d)) {
            return;
        }
        if (uri != null) {
            str = uri.getAuthority();
        } else {
            str = null;
        }
        if (!TextUtils.equals("com.android.contacts", str) && !TextUtils.equals("contacts", str)) {
            uri = null;
        }
        this.f14377d = uri;
        if (uri == null) {
            getLoaderManager().a(1);
            this.f14379f = null;
            d dVar = this.f14378e;
            if (dVar != null) {
                dVar.c(null);
                return;
            }
            return;
        }
        if (getActivity() != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("contactUri", this.f14377d);
            this.f14380g = getLoaderManager().g(1, bundle, this.f14384k);
        }
    }

    public void o1(boolean z10, String str) {
        this.f14382i = z10;
        this.f14383j = str;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i11 == -1 && i10 == 1) {
            k1((Uri) C7.e.j(intent, "android.intent.extra.ringtone.PICKED_URI"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f14376c = activity;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f14377d = (Uri) bundle.getParcelable("contactUri");
            this.f14381h = (SimContactInfo) bundle.getParcelable("sim_contacts_info");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(true);
        return layoutInflater.inflate(R.layout.contact_detail_loader_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("contactUri", this.f14377d);
        bundle.putParcelable("sim_contacts_info", this.f14381h);
    }

    public void p1(d dVar) {
        this.f14378e = dVar;
    }

    @Override // com.android.contacts.detail.CallDetailActivityFragment.e
    public boolean q0(int i10) {
        if (i10 != 67) {
            return false;
        }
        d dVar = this.f14378e;
        if (dVar != null) {
            dVar.d(this.f14377d);
            return true;
        }
        return true;
    }

    public void q1(Uri uri) {
        this.f14377d = uri;
    }

    public void r1() {
        if (getActivity() != null && this.f14377d != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("contactUri", this.f14377d);
            bundle.putBoolean("load_together", true);
            bundle.putParcelable("sim_contacts_info", this.f14381h);
            this.f14380g = getLoaderManager().g(1, bundle, this.f14384k);
        }
    }

    /* loaded from: classes.dex */
    public class a implements a.InterfaceC0129a<ContactLoader.Result> {
        public a() {
        }

        @Override // androidx.loader.app.a.InterfaceC0129a
        public W.c<ContactLoader.Result> Z(int i10, Bundle bundle) {
            Uri uri = (Uri) bundle.getParcelable("contactUri");
            boolean z10 = bundle.getBoolean("load_together", false);
            H7.b.b("ContactLoaderFragment", "lookupUri = " + uri);
            SimContactInfo simContactInfo = (SimContactInfo) bundle.getParcelable("sim_contacts_info");
            if (simContactInfo != null) {
                return new Y0(ContactLoaderFragment.this.f14376c, simContactInfo);
            }
            if (C1641a.l(ContactLoaderFragment.this.f14376c, FeatureOption.o())) {
                return new ContactLoader(ContactLoaderFragment.this.f14376c, uri, z10, ContactLoaderFragment.this.f14382i, ContactLoaderFragment.this.f14383j);
            }
            return new ContactLoader(ContactLoaderFragment.this.f14376c, uri, z10);
        }

        @Override // androidx.loader.app.a.InterfaceC0129a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void S0(W.c<ContactLoader.Result> cVar, ContactLoader.Result result) {
            H7.b.b("ContactLoaderFragment", "mLookupUri = " + ContactLoaderFragment.this.f14377d);
            if (ContactLoaderFragment.this.f14377d == null) {
                return;
            }
            H7.b.b("ContactLoaderFragment", "data.getRequestedUri() : " + result.U());
            try {
                if (!result.U().getLastPathSegment().equals(ContactLoaderFragment.this.f14377d.getLastPathSegment())) {
                    return;
                }
            } catch (Exception e10) {
                H7.b.c("ContactLoaderFragment", "Exception e: " + e10);
            }
            if (result.c0()) {
                H7.b.e("ContactLoaderFragment", "Error loading the contact: " + result.E());
                ContactLoaderFragment.this.f14379f = null;
            } else if (!result.e0()) {
                ContactLoaderFragment.this.f14379f = result;
            } else {
                H7.b.e("ContactLoaderFragment", "No contact found: " + ((ContactLoader) cVar).d0());
                ContactLoaderFragment.this.f14379f = null;
            }
            if (ContactLoaderFragment.this.f14378e != null) {
                if (ContactLoaderFragment.this.f14379f == null) {
                    ContactLoaderFragment.this.f14378e.a();
                } else {
                    ContactLoaderFragment.this.f14378e.c(ContactLoaderFragment.this.f14379f);
                }
            }
            if (ContactLoaderFragment.this.f14379f == null) {
                return;
            }
            Fragment parentFragment = ContactLoaderFragment.this.getParentFragment();
            if (parentFragment instanceof BaseActivityFragment) {
                ((BaseActivityFragment) parentFragment).z1();
            } else {
                ContactLoaderFragment.this.getActivity().invalidateOptionsMenu();
            }
        }

        @Override // androidx.loader.app.a.InterfaceC0129a
        public void Q(W.c<ContactLoader.Result> cVar) {
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.InterfaceC0129a<ContactLoader.Result> {
        public b() {
        }

        @Override // androidx.loader.app.a.InterfaceC0129a
        public W.c<ContactLoader.Result> Z(int i10, Bundle bundle) {
            SimContactInfo simContactInfo = (SimContactInfo) bundle.getParcelable("sim_contacts_info");
            H7.b.b("ContactLoaderFragment", "simInfo = ");
            return new Y0(ContactLoaderFragment.this.f14376c, simContactInfo);
        }

        @Override // androidx.loader.app.a.InterfaceC0129a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void S0(W.c<ContactLoader.Result> cVar, ContactLoader.Result result) {
            ContactLoaderFragment.this.f14379f = result;
            if (ContactLoaderFragment.this.f14378e != null) {
                if (ContactLoaderFragment.this.f14379f == null) {
                    ContactLoaderFragment.this.f14378e.a();
                } else {
                    ContactLoaderFragment.this.f14378e.c(ContactLoaderFragment.this.f14379f);
                }
            }
            if (ContactLoaderFragment.this.f14379f == null) {
                return;
            }
            Fragment parentFragment = ContactLoaderFragment.this.getParentFragment();
            if (parentFragment instanceof BaseActivityFragment) {
                ((BaseActivityFragment) parentFragment).z1();
            } else {
                ContactLoaderFragment.this.getActivity().invalidateOptionsMenu();
            }
        }

        @Override // androidx.loader.app.a.InterfaceC0129a
        public void Q(W.c<ContactLoader.Result> cVar) {
        }
    }
}

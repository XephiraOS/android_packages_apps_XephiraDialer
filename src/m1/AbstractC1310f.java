package m1;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.widget.a;
import com.android.contacts.list.ContactListFilter;
import com.android.contacts.widget.AutoScrollListView;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: ContactBrowseListFragment.java */
/* renamed from: m1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1310f extends AbstractViewOnFocusChangeListenerC1314j<AbstractC1315k> {

    /* renamed from: A0, reason: collision with root package name */
    public String f34876A0;

    /* renamed from: B0, reason: collision with root package name */
    public long f34877B0;

    /* renamed from: C0, reason: collision with root package name */
    public boolean f34878C0;

    /* renamed from: E0, reason: collision with root package name */
    public boolean f34880E0;

    /* renamed from: F0, reason: collision with root package name */
    public ContactListFilter f34881F0;

    /* renamed from: H0, reason: collision with root package name */
    public a f34883H0;

    /* renamed from: I0, reason: collision with root package name */
    public boolean f34884I0;

    /* renamed from: q0, reason: collision with root package name */
    public L f34885q0;

    /* renamed from: r0, reason: collision with root package name */
    public SharedPreferences f34886r0;

    /* renamed from: s0, reason: collision with root package name */
    public Handler f34887s0;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f34888t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f34889u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f34890v0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f34891w0;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f34892x0;

    /* renamed from: y0, reason: collision with root package name */
    public Uri f34893y0;

    /* renamed from: z0, reason: collision with root package name */
    public long f34894z0;

    /* renamed from: D0, reason: collision with root package name */
    public int f34879D0 = -1;

    /* renamed from: G0, reason: collision with root package name */
    public String f34882G0 = "defaultContactBrowserSelection";

    /* compiled from: ContactBrowseListFragment.java */
    /* renamed from: m1.f$a */
    /* loaded from: classes.dex */
    public static class a extends com.android.contacts.util.D<Void, Void, Uri, AbstractC1310f> {

        /* renamed from: b, reason: collision with root package name */
        public final Uri f34895b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f34896c;

        public void d() {
            super.cancel(true);
            this.f34896c = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
        @Override // com.android.contacts.util.D
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Uri a(AbstractC1310f abstractC1310f, Void... voidArr) {
            Cursor cursor;
            ?? r02 = 0;
            if (abstractC1310f != null) {
                try {
                    if (abstractC1310f.isAdded()) {
                        try {
                            ContentResolver contentResolver = abstractC1310f.getContext().getContentResolver();
                            cursor = contentResolver.query(com.android.contacts.util.h.a(contentResolver, this.f34895b), new String[]{BreenoCallContract.BaseColumns._ID, "lookup"}, null, null, null);
                            if (cursor != null) {
                                try {
                                    if (cursor.moveToFirst()) {
                                        long j10 = cursor.getLong(0);
                                        String string = cursor.getString(1);
                                        if (j10 != 0 && !TextUtils.isEmpty(string)) {
                                            Uri lookupUri = ContactsContract.Contacts.getLookupUri(j10, string);
                                            cursor.close();
                                            return lookupUri;
                                        }
                                    }
                                } catch (Exception e10) {
                                    e = e10;
                                    H7.b.c("ContactBrowseFragment", "Exception e: " + e);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return null;
                                }
                            }
                            H7.b.c("ContactBrowseFragment", "Error: No contact ID or lookup key for contact " + this.f34895b);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        } catch (Exception e11) {
                            e = e11;
                            cursor = null;
                        } catch (Throwable th) {
                            th = th;
                            if (r02 != 0) {
                                r02.close();
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r02 = abstractC1310f;
                }
            }
            return null;
        }

        @Override // com.android.contacts.util.D
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(AbstractC1310f abstractC1310f, Uri uri) {
            if (!this.f34896c && abstractC1310f != null && abstractC1310f.isAdded()) {
                abstractC1310f.E2(uri);
            }
        }

        public a(AbstractC1310f abstractC1310f, Uri uri) {
            super(abstractC1310f);
            this.f34895b = uri;
        }
    }

    /* compiled from: ContactBrowseListFragment.java */
    /* renamed from: m1.f$b */
    /* loaded from: classes.dex */
    public static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<AbstractC1310f> f34897a;

        public b(AbstractC1310f abstractC1310f) {
            this.f34897a = new WeakReference<>(abstractC1310f);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AbstractC1310f abstractC1310f = this.f34897a.get();
            if (abstractC1310f != null && message.what == 1) {
                abstractC1310f.M2();
            }
        }
    }

    private Handler B2() {
        if (this.f34887s0 == null) {
            this.f34887s0 = new b(this);
        }
        return this.f34887s0;
    }

    public ContactListFilter A2() {
        return this.f34881F0;
    }

    public final String C2() {
        if (this.f34881F0 == null) {
            return this.f34882G0;
        }
        return this.f34882G0 + "-" + this.f34881F0.j();
    }

    public final void D2() {
        L l10 = this.f34885q0;
        if (l10 != null) {
            l10.d();
        }
    }

    public void E2(Uri uri) {
        this.f34880E0 = false;
        this.f34893y0 = uri;
        F2();
        z2();
    }

    public final void F2() {
        long parseLong;
        Uri uri = this.f34893y0;
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("directory");
            if (TextUtils.isEmpty(queryParameter)) {
                parseLong = 0;
            } else {
                parseLong = Long.parseLong(queryParameter);
            }
            this.f34894z0 = parseLong;
            if (this.f34893y0.toString().startsWith(ContactsContract.Contacts.CONTENT_LOOKUP_URI.toString())) {
                List<String> pathSegments = this.f34893y0.getPathSegments();
                this.f34876A0 = Uri.encode(pathSegments.get(2));
                if (pathSegments.size() == 4) {
                    this.f34877B0 = ContentUris.parseId(this.f34893y0);
                    return;
                }
                return;
            }
            if (this.f34893y0.toString().startsWith(ContactsContract.Contacts.CONTENT_URI.toString()) && this.f34893y0.getPathSegments().size() >= 2) {
                this.f34876A0 = null;
                this.f34877B0 = ContentUris.parseId(this.f34893y0);
                return;
            }
            H7.b.c("ContactBrowseFragment", "Unsupported contact URI: " + this.f34893y0);
            this.f34876A0 = null;
            this.f34877B0 = 0L;
            return;
        }
        this.f34894z0 = 0L;
        this.f34876A0 = null;
        this.f34877B0 = 0L;
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public boolean G1() {
        if (!this.f34880E0 && !super.G1()) {
            return false;
        }
        return true;
    }

    public void G2() {
        a aVar = this.f34883H0;
        if (aVar != null) {
            aVar.d();
        }
        if (!L1()) {
            return;
        }
        this.f34880E0 = true;
        Uri uri = this.f34893y0;
        if (uri == null) {
            E2(null);
            return;
        }
        long j10 = this.f34894z0;
        if (j10 != 0 && j10 != 1) {
            E2(uri);
            return;
        }
        a aVar2 = new a(this.f34893y0);
        this.f34883H0 = aVar2;
        aVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }

    public void H2(int i10) {
        if (i10 != -1) {
            AutoScrollListView autoScrollListView = (AutoScrollListView) u1();
            autoScrollListView.b(i10 + autoScrollListView.getHeaderViewsCount(), this.f34891w0);
            this.f34890v0 = false;
        }
    }

    public void I2() {
        this.f34881F0 = ContactListFilter.n(this.f34886r0);
    }

    public final void J2(boolean z10) {
        if (this.f34889u0) {
            return;
        }
        String string = this.f34886r0.getString(C2(), null);
        if (string == null) {
            R2(null, false, false, false, z10);
        } else {
            R2(Uri.parse(string), false, false, false, z10);
        }
    }

    public final void K2() {
        ContactListFilter.t(this.f34886r0, this.f34881F0);
    }

    public final void L2(Uri uri) {
        if (J1()) {
            return;
        }
        ContactListFilter.t(this.f34886r0, this.f34881F0);
        SharedPreferences.Editor edit = this.f34886r0.edit();
        if (uri == null) {
            edit.remove(C2());
        } else {
            edit.putString(C2(), uri.toString());
        }
        edit.apply();
    }

    public void M2() {
        Uri uri;
        AbstractC1315k m12 = m1();
        if (this.f34879D0 != -1) {
            int count = m12.getCount();
            int i10 = this.f34879D0;
            if (i10 >= count && count > 0) {
                i10 = count - 1;
            }
            uri = m12.S0(i10);
        } else {
            uri = null;
        }
        if (uri == null) {
            uri = m12.U0();
        }
        R2(uri, false, this.f34891w0, false, false);
    }

    public void N2() {
        Handler B22 = B2();
        B22.removeMessages(1);
        String v12 = v1();
        if (v12 != null && v12.length() >= 2) {
            B22.sendEmptyMessageDelayed(1, 500L);
        } else {
            R2(null, false, false, false, false);
        }
    }

    public void O2(ContactListFilter contactListFilter) {
        P2(contactListFilter, true);
    }

    public void P2(ContactListFilter contactListFilter, boolean z10) {
        ContactListFilter contactListFilter2 = this.f34881F0;
        if (contactListFilter2 == null && contactListFilter == null) {
            return;
        }
        if (contactListFilter2 != null && contactListFilter2.equals(contactListFilter)) {
            return;
        }
        H7.b.h("ContactBrowseFragment", "New filter: " + contactListFilter);
        this.f34881F0 = contactListFilter;
        this.f34879D0 = -1;
        K2();
        if (z10) {
            this.f34893y0 = null;
            J2(true);
        }
        V1();
    }

    public void Q2(L l10) {
        this.f34885q0 = l10;
    }

    public final void R2(Uri uri, boolean z10, boolean z11, boolean z12, boolean z13) {
        AbstractC1315k m12;
        this.f34891w0 = z11;
        this.f34890v0 = true;
        Uri uri2 = this.f34893y0;
        if ((uri2 == null && uri != null) || (uri2 != null && !uri2.equals(uri))) {
            this.f34878C0 = false;
            this.f34889u0 = z10;
            this.f34892x0 = z12;
            this.f34893y0 = uri;
            F2();
            if (!z13 && (m12 = m1()) != null) {
                m12.e1(this.f34894z0, this.f34876A0, this.f34877B0);
                u1().invalidateViews();
            }
            G2();
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.loader.app.a.InterfaceC0129a
    /* renamed from: S1 */
    public void S0(W.c<Cursor> cVar, Cursor cursor) {
        if (cursor != null && !(cursor instanceof C1322s)) {
            cursor = new C1322s(cursor);
        }
        super.S0(cVar, cursor);
        this.f34878C0 = false;
        G2();
    }

    public void S2(Uri uri) {
        R2(uri, false, false, true, false);
        L l10 = this.f34885q0;
        if (l10 != null) {
            l10.b(uri);
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void V1() {
        if (this.f34888t0) {
            this.f34878C0 = false;
            this.f34879D0 = -1;
            super.V1();
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void X1(Bundle bundle) {
        super.X1(bundle);
        if (bundle == null) {
            return;
        }
        this.f34893y0 = (Uri) bundle.getParcelable("selectedUri");
        this.f34878C0 = bundle.getBoolean("selectionVerified");
        this.f34879D0 = bundle.getInt("lastSelected");
        F2();
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void g1() {
        super.g1();
        AbstractC1315k m12 = m1();
        if (m12 == null) {
            return;
        }
        boolean J12 = J1();
        ContactListFilter contactListFilter = this.f34881F0;
        if (contactListFilter != null) {
            m12.y0(contactListFilter);
            if (!J12 && (this.f34889u0 || this.f34881F0.f16738b == -6)) {
                m12.e1(this.f34894z0, this.f34876A0, this.f34877B0);
            }
        }
        m12.z0(!J12);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void m2(String str, boolean z10) {
        this.f34884I0 = z10;
        super.m2(str, z10);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void o2(boolean z10) {
        if (J1() != z10) {
            if (!z10) {
                J2(true);
            }
            super.o2(z10);
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f34886r0 = PreferenceManager.getDefaultSharedPreferences(activity);
        I2();
        J2(false);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("filter", this.f34881F0);
        bundle.putParcelable("selectedUri", this.f34893y0);
        bundle.putBoolean("selectionVerified", this.f34878C0);
        bundle.putInt("lastSelected", this.f34879D0);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void w2() {
        this.f34888t0 = true;
        this.f34878C0 = false;
        super.w2();
    }

    public final void z2() {
        AbstractC1315k m12;
        if (this.f34878C0 || this.f34880E0 || H1() || (m12 = m1()) == null) {
            return;
        }
        int r10 = m12.r();
        for (int i10 = 0; i10 < r10; i10++) {
            a.C0167a q10 = m12.q(i10);
            if (q10 instanceof D) {
                D d10 = (D) q10;
                if (d10.b() == this.f34894z0) {
                    if (!d10.e()) {
                        m12.e1(this.f34894z0, this.f34876A0, this.f34877B0);
                        int Z02 = m12.Z0();
                        if (Z02 != -1) {
                            this.f34879D0 = Z02;
                        } else {
                            if (J1()) {
                                if (this.f34884I0) {
                                    N2();
                                    L l10 = this.f34885q0;
                                    if (l10 != null) {
                                        l10.a();
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                if (this.f34889u0) {
                                    this.f34889u0 = false;
                                    ContactListFilter contactListFilter = this.f34881F0;
                                    if (contactListFilter != null && contactListFilter.f16738b == -6) {
                                        V1();
                                        return;
                                    } else {
                                        D2();
                                        return;
                                    }
                                }
                                ContactListFilter contactListFilter2 = this.f34881F0;
                                if (contactListFilter2 != null && contactListFilter2.f16738b == -6) {
                                    D2();
                                    return;
                                }
                            }
                            L2(null);
                            M2();
                        }
                        this.f34889u0 = false;
                        this.f34878C0 = true;
                        if (this.f34892x0) {
                            L2(this.f34893y0);
                            this.f34892x0 = false;
                        }
                        if (this.f34890v0) {
                            H2(Z02);
                        }
                        u1().invalidateViews();
                        L l11 = this.f34885q0;
                        if (l11 != null) {
                            l11.a();
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.loader.app.a.InterfaceC0129a
    public void Q(W.c<Cursor> cVar) {
    }
}

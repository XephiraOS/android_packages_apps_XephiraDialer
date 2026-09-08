package m1;

import Z0.b;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.widget.a;
import com.android.contacts.list.ContactListFilter;
import com.android.contacts.list.ContactListItemView;
import com.android.contacts.list.ContactListPinnedHeaderView;
import com.oplus.dialer.R;
import java.util.HashSet;

/* compiled from: ContactEntryListAdapter.java */
/* renamed from: m1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1311g extends E1.a {

    /* renamed from: A, reason: collision with root package name */
    public boolean f34898A;

    /* renamed from: B, reason: collision with root package name */
    public Z0.b f34899B;

    /* renamed from: C, reason: collision with root package name */
    public String f34900C;

    /* renamed from: D, reason: collision with root package name */
    public char[] f34901D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f34902E;

    /* renamed from: F, reason: collision with root package name */
    public int f34903F;

    /* renamed from: G, reason: collision with root package name */
    public int f34904G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f34905H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f34906I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f34907J;

    /* renamed from: K, reason: collision with root package name */
    public ContactListFilter f34908K;

    /* renamed from: L, reason: collision with root package name */
    public String f34909L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f34910M;

    /* renamed from: N, reason: collision with root package name */
    public int f34911N;

    /* renamed from: O, reason: collision with root package name */
    public int f34912O;

    /* renamed from: P, reason: collision with root package name */
    public int f34913P;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f34914Q;

    /* renamed from: o, reason: collision with root package name */
    public int f34915o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f34916p;

    /* renamed from: q, reason: collision with root package name */
    public int f34917q;

    /* renamed from: r, reason: collision with root package name */
    public int f34918r;

    /* renamed from: x, reason: collision with root package name */
    public boolean f34919x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f34920y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f34921z;

    public AbstractC1311g(Context context) {
        super(context);
        this.f34915o = -1;
        this.f34916p = true;
        this.f34904G = Integer.MAX_VALUE;
        this.f34905H = true;
        this.f34906I = true;
        this.f34909L = "";
        this.f34910M = false;
        this.f34911N = -1;
        this.f34912O = -1;
        this.f34913P = -1;
        this.f34914Q = false;
        Q();
        this.f34913P = context.getResources().getDimensionPixelOffset(R.dimen.DP_24);
        this.f34912O = context.getResources().getDimensionPixelOffset(R.dimen.DP_14);
        this.f34911N = context.getResources().getDimensionPixelOffset(R.dimen.SP_12);
    }

    public void A0(Z0.b bVar) {
        this.f34899B = bVar;
    }

    public void B0(boolean z10) {
        SectionIndexer J10;
        this.f34898A = z10;
        if (z10 && (J10 = J()) != null) {
            ((C1320p) J10).b(k().getString(R.string.user_profile_contacts_list_header));
        }
    }

    public void C0(String str) {
        this.f34900C = str;
        char[] cArr = null;
        if (TextUtils.isEmpty(str)) {
            this.f34901D = null;
            return;
        }
        String trim = str.trim();
        if (!TextUtils.isEmpty(trim)) {
            cArr = trim.toUpperCase().toCharArray();
        }
        this.f34901D = cArr;
    }

    public void D0(boolean z10) {
        this.f34916p = z10;
    }

    public void E0(boolean z10) {
        this.f34920y = false;
    }

    public void F0(boolean z10) {
        this.f34902E = z10;
    }

    @Override // E1.a
    public void G(View view) {
        ((ContactListPinnedHeaderView) view).setCountView(null);
    }

    public void G0(boolean z10) {
        this.f34907J = z10;
    }

    @Override // E1.a
    public View H(Context context, ViewGroup viewGroup) {
        return new ContactListPinnedHeaderView(context, null);
    }

    public void H0(int i10) {
        this.f34918r = i10;
    }

    public final void I0(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            Bundle extras = cursor.getExtras();
            if (extras == null) {
                return;
            }
            if (extras.containsKey("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES")) {
                N(new C1320p(extras.getStringArray("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES"), extras.getIntArray("android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS")));
                return;
            } else {
                N(null);
                return;
            }
        }
        N(null);
    }

    @Override // E1.a
    public void O(View view, String str) {
        ((ContactListPinnedHeaderView) view).setSectionHeader(str);
    }

    public void Q() {
        e(W());
    }

    public void R(Cursor cursor) {
        h(0, cursor);
    }

    public void S(Cursor cursor) {
        if (cursor != null && cursor.getCount() != 0 && !cursor.isClosed()) {
            HashSet hashSet = new HashSet();
            int columnIndex = cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID);
            int columnIndex2 = cursor.getColumnIndex("directoryType");
            int columnIndex3 = cursor.getColumnIndex("displayName");
            int columnIndex4 = cursor.getColumnIndex("photoSupport");
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                long j10 = cursor.getLong(columnIndex);
                hashSet.add(Long.valueOf(j10));
                if (d0(j10) == -1) {
                    boolean z10 = false;
                    D d10 = new D(false, true);
                    d10.h(j10);
                    d10.i(cursor.getString(columnIndex2));
                    d10.j(cursor.getString(columnIndex3));
                    int i10 = cursor.getInt(columnIndex4);
                    if (i10 == 1 || i10 == 3) {
                        z10 = true;
                    }
                    d10.k(z10);
                    e(d10);
                }
            }
            int r10 = r();
            while (true) {
                r10--;
                if (r10 >= 0) {
                    a.C0167a q10 = q(r10);
                    if ((q10 instanceof D) && !hashSet.contains(Long.valueOf(((D) q10).b()))) {
                        B(r10);
                    }
                } else {
                    w();
                    notifyDataSetChanged();
                    return;
                }
            }
        } else {
            H7.b.c("ContactEntryListAdapter", "Directory search loader returned an empty cursor, which implies we have no directory entries.");
        }
    }

    public void T(boolean z10, boolean z11) {
        int r10 = r();
        int i10 = 0;
        while (true) {
            if (i10 < r10) {
                a.C0167a q10 = q(i10);
                if ((q10 instanceof D) && ((D) q10).b() == 0) {
                    break;
                } else {
                    i10++;
                }
            } else {
                i10 = -1;
                break;
            }
        }
        if (i10 != -1) {
            D(i10, z10);
            C(i10, z11);
        }
    }

    public void U(C c10) {
        c10.N(this.f34903F);
        c10.O(false);
    }

    public abstract void V(W.b bVar, long j10);

    public D W() {
        D d10 = new D(true, true);
        d10.h(0L);
        d10.i(k().getString(R.string.contactsList));
        d10.l(true);
        d10.k(true);
        return d10;
    }

    public boolean X() {
        return this.f34914Q;
    }

    public int Y() {
        return this.f34917q;
    }

    public String Z() {
        return this.f34909L;
    }

    public b.c a0(Cursor cursor, int i10, int i11, int i12) {
        return new b.c(cursor.getString(i10), String.valueOf(cursor.getLong(i12)), this.f34914Q);
    }

    public int b0() {
        return this.f34904G;
    }

    public ContactListFilter c0() {
        return this.f34908K;
    }

    public final int d0(long j10) {
        int r10 = r();
        for (int i10 = 0; i10 < r10; i10++) {
            a.C0167a q10 = q(i10);
            if ((q10 instanceof D) && ((D) q10).b() == j10) {
                return i10;
            }
        }
        return -1;
    }

    public Z0.b e0() {
        return this.f34899B;
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public void f(View view, int i10, Cursor cursor) {
        a.C0167a q10 = q(i10);
        if (!(q10 instanceof D)) {
            return;
        }
        D d10 = (D) q10;
        long b10 = d10.b();
        TextView textView = (TextView) view.findViewById(R.id.title);
        if (A7.a.a()) {
            view.setBackground(null);
        }
        textView.setTextColor(this.f472i.getColor(R.color.coui_color_label_secondary));
        int i11 = 0;
        textView.setTextSize(0, this.f34911N);
        if (d10.e()) {
            textView.setText(R.string.search_results_searching);
            return;
        }
        if (cursor != null) {
            i11 = cursor.getCount();
        }
        if (b10 != 0 && b10 != 1) {
            if (i11 >= b0()) {
                textView.setText(this.f472i.getString(R.string.foundTooManyContactstoShow, Integer.valueOf(b0()), d10.c()));
                return;
            } else {
                textView.setText(g0(i11, d10.c(), R.string.listFoundAllContactsZero, R.plurals.searchFoundContactstoShow));
                return;
            }
        }
        textView.setText(f0(i11, R.string.listFoundAllContactsZero, R.plurals.list_total_all_contacts_count));
    }

    public String f0(int i10, int i11, int i12) {
        if (i10 == 0) {
            return k().getString(i11);
        }
        return String.format(k().getResources().getQuantityText(i12, i10).toString(), Integer.valueOf(i10));
    }

    public String g0(int i10, String str, int i11, int i12) {
        if (i10 == 0) {
            return k().getString(i11);
        }
        return k().getResources().getQuantityString(i12, i10, Integer.valueOf(i10), str);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return (o() * 2) + 1;
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public void h(int i10, Cursor cursor) {
        if (i10 < r() && cursor != null && !cursor.isClosed()) {
            if (cursor.getCount() > 0) {
                this.f34915o = cursor.getColumnIndex("highlights");
            }
            a.C0167a q10 = q(i10);
            if (q10 instanceof D) {
                ((D) q10).m(2);
            }
            if (this.f34919x && this.f34899B != null && l0(i10)) {
                this.f34899B.t();
            }
            super.h(i10, cursor);
            if (M() && i10 == I()) {
                I0(cursor);
            }
        }
    }

    public String h0() {
        return this.f34900C;
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public void i() {
        int r10 = r();
        for (int i10 = 0; i10 < r10; i10++) {
            a.C0167a q10 = q(i10);
            if (q10 instanceof D) {
                ((D) q10).m(0);
            }
        }
        super.i();
    }

    public int i0() {
        return this.f34918r;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        if (!this.f34906I) {
            return false;
        }
        if (n0()) {
            return TextUtils.isEmpty(h0());
        }
        if (this.f34905H) {
            return false;
        }
        return super.isEmpty();
    }

    public char[] j0() {
        return this.f34901D;
    }

    public boolean k0() {
        int r10 = r();
        for (int i10 = 0; i10 < r10; i10++) {
            a.C0167a q10 = q(i10);
            if ((q10 instanceof D) && ((D) q10).e()) {
                return true;
            }
        }
        return false;
    }

    public boolean l0(int i10) {
        a.C0167a q10 = q(i10);
        if (q10 instanceof D) {
            return ((D) q10).f();
        }
        return true;
    }

    public boolean m0() {
        return this.f34920y;
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public int n(int i10, int i11) {
        int n10 = super.n(i10, i11);
        if (!p0(i11) && M() && i10 == I() && !K(i11).f478a) {
            return n10 + o();
        }
        return n10;
    }

    public boolean n0() {
        return this.f34902E;
    }

    public boolean o0() {
        return this.f34907J;
    }

    public boolean p0(int i10) {
        int s10;
        boolean z10 = false;
        if (i10 == 0 && (s10 = s(i10)) >= 0) {
            int position = l(s10).getPosition();
            Cursor cursor = (Cursor) getItem(i10);
            if (cursor != null && !cursor.isClosed()) {
                int columnIndex = cursor.getColumnIndex("is_user_profile");
                if (columnIndex != -1 && cursor.getInt(columnIndex) == 1) {
                    z10 = true;
                }
                cursor.moveToPosition(position);
            }
        }
        return z10;
    }

    public void q0() {
        int r10 = r();
        boolean z10 = false;
        for (int i10 = 0; i10 < r10; i10++) {
            a.C0167a q10 = q(i10);
            if (q10 instanceof D) {
                D d10 = (D) q10;
                if (!d10.e()) {
                    z10 = true;
                }
                d10.m(0);
            }
        }
        if (z10) {
            notifyDataSetChanged();
        }
    }

    public void r0(ContactListItemView contactListItemView, boolean z10) {
        contactListItemView.setBottomDividerVisible(z10);
    }

    public void s0(int i10) {
        this.f34917q = i10;
    }

    public void t0(boolean z10) {
        this.f34910M = z10;
    }

    public void u0(int i10) {
        this.f34904G = i10;
    }

    public void v0(int i10) {
        this.f34903F = i10;
    }

    public void w0(boolean z10) {
        this.f34919x = z10;
    }

    public void x0(boolean z10) {
        this.f34906I = z10;
    }

    public void y0(ContactListFilter contactListFilter) {
        this.f34908K = contactListFilter;
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public View z(Context context, int i10, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.contact_listitem_title, viewGroup, false);
    }

    public void z0(boolean z10) {
        this.f34921z = z10;
    }
}

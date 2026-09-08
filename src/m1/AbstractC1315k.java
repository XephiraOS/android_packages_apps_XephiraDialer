package m1;

import E1.a;
import Z0.b;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.list.ContactListItemView;
import com.android.contacts.model.Account;
import com.customize.contacts.util.C0806q;
import com.oplus.dialer.R;

/* compiled from: ContactListAdapter.java */
/* renamed from: m1.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1315k extends AbstractC1311g {

    /* renamed from: R, reason: collision with root package name */
    public C0806q f34990R;

    /* renamed from: S, reason: collision with root package name */
    public int f34991S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f34992T;

    /* renamed from: U, reason: collision with root package name */
    public CharSequence f34993U;

    /* renamed from: V, reason: collision with root package name */
    public long f34994V;

    /* renamed from: W, reason: collision with root package name */
    public String f34995W;

    /* renamed from: X, reason: collision with root package name */
    public long f34996X;

    /* compiled from: ContactListAdapter.java */
    /* renamed from: m1.k$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f34997a = {BreenoCallContract.BaseColumns._ID, "display_name", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", "starred", "account_type", "account_name", "organization"};

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f34998b = {BreenoCallContract.BaseColumns._ID, "display_name", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", "starred", "account_type", "account_name", "organization", "phonenumber"};

        /* renamed from: c, reason: collision with root package name */
        public static final String[] f34999c = {BreenoCallContract.BaseColumns._ID, "display_name_alt", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", "starred", "account_type", "account_name", "organization"};

        /* renamed from: d, reason: collision with root package name */
        public static final String[] f35000d = {BreenoCallContract.BaseColumns._ID, "display_name_alt", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", "starred", "account_type", "account_name", "organization", "phonenumber"};

        /* renamed from: e, reason: collision with root package name */
        public static final String[] f35001e = {BreenoCallContract.BaseColumns._ID, "display_name", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", "starred", "account_type", "account_name", "snippet", "highlights"};

        /* renamed from: f, reason: collision with root package name */
        public static final String[] f35002f = {BreenoCallContract.BaseColumns._ID, "display_name", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", "starred", "account_type", "account_name", "snippet", "highlights", "phonenumber"};

        /* renamed from: g, reason: collision with root package name */
        public static final String[] f35003g = {BreenoCallContract.BaseColumns._ID, "display_name_alt", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", "starred", "account_type", "account_name", "snippet", "highlights"};

        /* renamed from: h, reason: collision with root package name */
        public static final String[] f35004h = {BreenoCallContract.BaseColumns._ID, "display_name_alt", "contact_presence", "contact_status", "photo_id", "photo_thumb_uri", "lookup", "is_user_profile", "starred", "account_type", "account_name", "snippet", "highlights", "phonenumber"};
    }

    public AbstractC1315k(Context context) {
        super(context);
        this.f34990R = null;
        this.f34991S = 0;
        this.f34992T = false;
        this.f34993U = context.getText(R.string.missing_name);
        this.f34991S = context.getResources().getDimensionPixelOffset(R.dimen.sim_contact_list_padding);
    }

    public static Uri O0(Uri uri) {
        return uri.buildUpon().appendQueryParameter("android.provider.extra.ADDRESS_BOOK_INDEX", "true").build();
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public View A(Context context, int i10, Cursor cursor, int i11, ViewGroup viewGroup) {
        ContactListItemView contactListItemView = new ContactListItemView(context, null);
        contactListItemView.setUnknownNameText(this.f34993U);
        contactListItemView.setQuickContactEnabled(m0());
        contactListItemView.setActivatedStateSupported(o0());
        return contactListItemView;
    }

    public void J0(ContactListItemView contactListItemView, Cursor cursor) {
        contactListItemView.m(cursor, 1, Y());
    }

    public void K0(ContactListItemView contactListItemView, int i10, Cursor cursor) {
        long j10;
        Account account;
        Uri parse;
        if (!l0(i10)) {
            contactListItemView.d();
            return;
        }
        if (!cursor.isNull(4)) {
            j10 = cursor.getLong(4);
        } else {
            j10 = 0;
        }
        b.c cVar = null;
        if (!cursor.isNull(9) && !cursor.isNull(10)) {
            account = new Account(cursor.getString(10), cursor.getString(9));
        } else {
            account = null;
        }
        if (j10 != 0) {
            e0().o(contactListItemView.getPhotoView(), j10, account, false, X(), null);
            return;
        }
        String string = cursor.getString(5);
        if (string == null) {
            parse = null;
        } else {
            parse = Uri.parse(string);
        }
        if (parse == null) {
            cVar = a0(cursor, 1, 6, 0);
        }
        e0().i(contactListItemView.getPhotoView(), parse, account, false, X(), cVar);
    }

    public void L0(ContactListItemView contactListItemView, Cursor cursor) {
        contactListItemView.p(cursor, 2, 3);
    }

    public void M0(ContactListItemView contactListItemView, Cursor cursor, long j10, long j11) {
        contactListItemView.s(cursor, 11, 1, j10, this.f34915o, j11);
    }

    public void N0(ContactListItemView contactListItemView, int i10, Cursor cursor) {
        if (M()) {
            a.C0010a K10 = K(i10);
            if (i10 == 0 && cursor.getInt(7) == 1) {
                contactListItemView.setCountView(Z());
            } else {
                contactListItemView.setCountView(null);
            }
            contactListItemView.setSectionHeader(K10.f480c);
            contactListItemView.setDividerVisible(!K10.f479b);
            int i11 = i10 + 1;
            int count = cursor.getCount();
            if (i11 < count) {
                if (!TextUtils.isEmpty(K(i11).f480c)) {
                    contactListItemView.setDividerPaddingLeft(false);
                    contactListItemView.setDividerVisible(false);
                } else {
                    contactListItemView.setDividerPaddingLeft(true);
                    contactListItemView.setDividerVisible(true);
                }
            }
            if (i10 == count - 1) {
                contactListItemView.setDividerPaddingLeft(true);
                contactListItemView.setDividerVisible(true);
                return;
            }
            return;
        }
        contactListItemView.setSectionHeader(null);
        contactListItemView.setDividerVisible(true);
        contactListItemView.setCountView(null);
        contactListItemView.setDividerPaddingLeft(true);
    }

    public String P0(int i10) {
        Cursor cursor = (Cursor) getItem(i10);
        if (cursor != null) {
            return cursor.getString(9);
        }
        return null;
    }

    public String Q0(int i10) {
        return ((Cursor) getItem(i10)).getString(1);
    }

    public String R0(int i10) {
        Cursor cursor = (Cursor) getItem(i10);
        if (cursor != null) {
            return cursor.getString(6);
        }
        return null;
    }

    public Uri S0(int i10) {
        int s10 = s(i10);
        Cursor cursor = (Cursor) getItem(i10);
        if (cursor != null) {
            return T0(s10, cursor);
        }
        return null;
    }

    public Uri T0(int i10, Cursor cursor) {
        Uri lookupUri = ContactsContract.Contacts.getLookupUri(cursor.getLong(0), cursor.getString(6));
        long b10 = ((D) q(i10)).b();
        if (b10 != 0 && lookupUri != null) {
            return lookupUri.buildUpon().appendQueryParameter("directory", String.valueOf(b10)).build();
        }
        return lookupUri;
    }

    public Uri U0() {
        Cursor l10;
        int r10 = r();
        for (int i10 = 0; i10 < r10; i10++) {
            if (!((D) q(i10)).e() && (l10 = l(i10)) != null && l10.moveToFirst()) {
                return T0(i10, l10);
            }
        }
        return null;
    }

    public final String[] V0(boolean z10) {
        int Y9 = Y();
        return z10 ? Y9 == 1 ? (B3.a.d0() && com.android.contacts.framework.api.rcs.a.e()) ? a.f35002f : a.f35001e : (B3.a.d0() && com.android.contacts.framework.api.rcs.a.e()) ? a.f35004h : a.f35003g : Y9 == 1 ? (B3.a.d0() && com.android.contacts.framework.api.rcs.a.e()) ? a.f34998b : a.f34997a : (B3.a.d0() && com.android.contacts.framework.api.rcs.a.e()) ? a.f35000d : a.f34999c;
    }

    public long W0() {
        return this.f34994V;
    }

    public long X0() {
        return this.f34996X;
    }

    public String Y0() {
        return this.f34995W;
    }

    public int Z0() {
        Cursor l10;
        int i10;
        if (this.f34995W == null && this.f34996X == 0) {
            return -1;
        }
        int r10 = r();
        int i11 = 0;
        while (true) {
            if (i11 < r10) {
                if (((D) q(i11)).b() == this.f34994V) {
                    break;
                }
                i11++;
            } else {
                i11 = -1;
                break;
            }
        }
        if (i11 == -1 || (l10 = l(i11)) == null) {
            return -1;
        }
        l10.moveToPosition(-1);
        while (true) {
            if (l10.moveToNext()) {
                if (this.f34995W != null) {
                    if (this.f34995W.equals(l10.getString(6))) {
                        i10 = l10.getPosition();
                        break;
                    }
                }
                if (this.f34996X != 0) {
                    long j10 = this.f34994V;
                    if (j10 == 0 || j10 == 1) {
                        if (l10.getLong(0) == this.f34996X) {
                            i10 = l10.getPosition();
                            break;
                        }
                    }
                }
            } else {
                i10 = -1;
                break;
            }
        }
        if (i10 == -1) {
            return -1;
        }
        int t10 = t(i11) + i10;
        if (v(i11)) {
            return t10 + 1;
        }
        return t10;
    }

    public boolean a1(int i10) {
        if (((Cursor) getItem(i10)).getLong(8) == 1) {
            return true;
        }
        return false;
    }

    public boolean b1(int i10, Cursor cursor) {
        long b10 = ((D) q(i10)).b();
        if (W0() != b10) {
            return false;
        }
        String Y02 = Y0();
        if (Y02 != null && TextUtils.equals(Y02, cursor.getString(6))) {
            return true;
        }
        if (b10 == 0 || b10 == 1 || X0() != cursor.getLong(0)) {
            return false;
        }
        return true;
    }

    public void c1(C0806q c0806q) {
        this.f34990R = c0806q;
    }

    public void d1(boolean z10) {
        this.f34992T = z10;
    }

    public void e1(long j10, String str, long j11) {
        this.f34994V = j10;
        this.f34995W = str;
        this.f34996X = j11;
    }

    @Override // m1.AbstractC1311g, com.android.contacts.framework.baseui.widget.a
    public void h(int i10, Cursor cursor) {
        super.h(i10, cursor);
        if (cursor != null && cursor.getCount() > 0 && cursor.getColumnIndex("is_user_profile") != -1) {
            cursor.moveToFirst();
            int i11 = cursor.getInt(7);
            boolean z10 = true;
            if (i11 != 1) {
                z10 = false;
            }
            B0(z10);
        }
    }
}

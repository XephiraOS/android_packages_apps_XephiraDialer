package com.android.contacts.list;

import E1.a;
import Z0.b;
import android.R;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.phonenumber.PhoneNumberUtils;
import com.android.contacts.list.ContactListItemView;
import com.android.contacts.model.Account;
import com.android.incallui.OplusPhoneUtils;
import h1.C1074c;
import m1.AbstractC1311g;

/* compiled from: PhoneNumberListAdapter.java */
/* loaded from: classes.dex */
public class d extends AbstractC1311g {

    /* renamed from: U, reason: collision with root package name */
    public static final String f16900U = "d";

    /* renamed from: R, reason: collision with root package name */
    public StringBuilder f16901R;

    /* renamed from: S, reason: collision with root package name */
    public final CharSequence f16902S;

    /* renamed from: T, reason: collision with root package name */
    public ContactListItemView.PhotoPosition f16903T;

    /* compiled from: PhoneNumberListAdapter.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f16904a = {BreenoCallContract.BaseColumns._ID, "data2", "data3", "data1", "contact_id", "lookup", "photo_id", "display_name", "photo_thumb_uri", "account_type", "account_name", "sort_key"};

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f16905b = {BreenoCallContract.BaseColumns._ID, "data2", "data3", "data1", "contact_id", "lookup", "photo_id", "display_name_alt", "photo_thumb_uri", "account_type", "account_name", "sort_key"};

        /* renamed from: c, reason: collision with root package name */
        public static final String[] f16906c = {BreenoCallContract.BaseColumns._ID, "data2", "data3", "data1", "contact_id", "lookup", "photo_id", "display_name", "photo_thumb_uri", "account_type", "account_name", "sort_key", "highlights"};

        /* renamed from: d, reason: collision with root package name */
        public static final String[] f16907d = {BreenoCallContract.BaseColumns._ID, "data2", "data3", "data1", "contact_id", "lookup", "photo_id", "display_name_alt", "photo_thumb_uri", "account_type", "account_name", "sort_key", "highlights"};
    }

    public d(Context context) {
        super(context);
        this.f16903T = ContactListItemView.f16756I0;
        this.f16902S = context.getText(R.string.unknownName);
    }

    public static Uri N0(Uri uri) {
        return uri.buildUpon().appendQueryParameter("android.provider.extra.ADDRESS_BOOK_INDEX", "true").build();
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public View A(Context context, int i10, Cursor cursor, int i11, ViewGroup viewGroup) {
        ContactListItemView contactListItemView = new ContactListItemView(context, null);
        contactListItemView.setUnknownNameText(this.f16902S);
        contactListItemView.setQuickContactEnabled(m0());
        contactListItemView.setPhotoPosition(this.f16903T);
        return contactListItemView;
    }

    public void J0(ContactListItemView contactListItemView, Cursor cursor) {
        contactListItemView.n(cursor, 7, cursor.getLong(4), Y(), this.f34915o);
    }

    public void K0(ContactListItemView contactListItemView, Cursor cursor) {
        CharSequence charSequence;
        if (!cursor.isNull(1)) {
            charSequence = ContactsContract.CommonDataKinds.Phone.getTypeLabel(k().getResources(), cursor.getInt(1), cursor.getString(2));
        } else {
            charSequence = null;
        }
        contactListItemView.setLabel(charSequence);
        contactListItemView.l(cursor, 3);
    }

    public void L0(ContactListItemView contactListItemView, Cursor cursor) {
        long j10;
        Account account;
        Uri parse;
        if (!cursor.isNull(6)) {
            j10 = cursor.getLong(6);
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
        String string = cursor.getString(8);
        if (string == null) {
            parse = null;
        } else {
            parse = Uri.parse(string);
        }
        if (parse == null) {
            cVar = new b.c(cursor.getString(7), String.valueOf(cursor.getLong(4)), X());
        }
        e0().i(contactListItemView.getPhotoView(), parse, account, false, X(), cVar);
    }

    public void M0(ContactListItemView contactListItemView, int i10, Cursor cursor) {
        String str = null;
        if (M()) {
            a.C0010a K10 = K(i10);
            if (K10.f478a) {
                str = K10.f480c;
            }
            contactListItemView.setSectionHeader(str);
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
        contactListItemView.setDividerPaddingLeft(true);
    }

    public void O0() {
        StringBuilder sb = this.f16901R;
        sb.append(" AND ");
        sb.append("has_phone_number");
        sb.append("=1");
        StringBuilder sb2 = this.f16901R;
        sb2.append(" AND ");
        sb2.append("mimetype_id");
        sb2.append("=5");
    }

    public void P0(W.b bVar, long j10, ContactListFilter contactListFilter) {
        int i10;
        if (contactListFilter != null && j10 == 0 && (i10 = contactListFilter.f16738b) != -5) {
            if (i10 != -3) {
                if (i10 != -2 && i10 != -1) {
                    if (i10 != 0) {
                        H7.b.i(f16900U, "Unsupported filter type came (type: " + contactListFilter.f16738b + ", toString: " + contactListFilter + ") showing all contacts.");
                        return;
                    }
                    this.f16901R.append("(");
                    this.f16901R.append("contact_id IN (SELECT contact_id FROM raw_contacts WHERE account_id IN (SELECT _id FROM accounts WHERE (");
                    if (contactListFilter.f16740d == null && contactListFilter.f16739c == null) {
                        this.f16901R.append("account_type IS NULL AND account_name IS NULL");
                    } else {
                        this.f16901R.append("account_type='" + contactListFilter.f16739c + "' AND account_name='" + contactListFilter.f16740d + "'");
                    }
                    if (contactListFilter.f16741e != null) {
                        this.f16901R.append(" AND data_set='" + contactListFilter.f16741e + "'");
                    } else {
                        this.f16901R.append(" AND data_set IS NULL");
                    }
                    this.f16901R.append(")))");
                    O0();
                    this.f16901R.append(")");
                    return;
                }
                StringBuilder sb = this.f16901R;
                sb.append("(");
                sb.append("data1<>''");
                O0();
                this.f16901R.append(")");
                return;
            }
            this.f16901R.append("in_visible_group=1");
            O0();
        }
    }

    public Uri Q0(int i10) {
        Cursor cursor = (Cursor) getItem(i10);
        if (cursor != null) {
            return ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, cursor.getLong(0));
        }
        H7.b.i(f16900U, "Cursor was null in getDataUri() call. Returning null instead.");
        return null;
    }

    public void R0(ContactListItemView.PhotoPosition photoPosition) {
        this.f16903T = photoPosition;
    }

    @Override // m1.AbstractC1311g
    public void V(W.b bVar, long j10) {
        Uri uri;
        boolean z10;
        if (j10 != 0) {
            H7.b.i(f16900U, "PhoneNumberListAdapter is not ready for non-default directory ID (directoryId: " + j10 + ")");
        }
        this.f16901R = new StringBuilder();
        if (n0()) {
            String d10 = PhoneNumberUtils.d(h0(), C1074c.b(this.f472i));
            Uri.Builder buildUpon = ContactsContract.CommonDataKinds.Phone.CONTENT_FILTER_URI.buildUpon();
            if (TextUtils.isEmpty(d10)) {
                buildUpon.appendPath("");
            } else {
                buildUpon.appendPath(d10);
            }
            P0(bVar, j10, c0());
            buildUpon.appendQueryParameter("directory", String.valueOf(j10));
            buildUpon.appendQueryParameter("QUERY_NAME_WITHOUT_SEARCH_INDEX", OplusPhoneUtils.DeviceState.LOCK_DEVICE);
            buildUpon.appendQueryParameter(R0.c.f3185c, "true");
            if (Y() == 2) {
                z10 = true;
            } else {
                z10 = false;
            }
            buildUpon.appendQueryParameter("is_display_alt", String.valueOf(z10));
            uri = buildUpon.build();
            if (Y() == 1) {
                bVar.P(a.f16906c);
            } else {
                bVar.P(a.f16907d);
            }
        } else {
            Uri build = ContactsContract.CommonDataKinds.Phone.CONTENT_URI.buildUpon().appendQueryParameter("directory", String.valueOf(0L)).appendQueryParameter(R0.c.f3185c, "true").build();
            if (M()) {
                build = N0(build);
            }
            P0(bVar, j10, c0());
            if (Y() == 1) {
                bVar.P(a.f16904a);
            } else {
                bVar.P(a.f16905b);
            }
            uri = build;
        }
        bVar.T(uri.buildUpon().appendQueryParameter("remove_duplicate_entries", "true").build());
        bVar.Q(this.f16901R.toString());
        if (i0() == 1) {
            bVar.S("sort_key");
        } else {
            bVar.S("sort_key_alt");
        }
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public void g(View view, int i10, Cursor cursor, int i11) {
        char[] cArr;
        ContactListItemView contactListItemView = (ContactListItemView) view;
        if (n0()) {
            cArr = j0();
        } else {
            cArr = null;
        }
        contactListItemView.setHighlightedPrefix(cArr);
        cursor.moveToPosition(i11);
        M0(contactListItemView, i11, cursor);
        J0(contactListItemView, cursor);
        L0(contactListItemView, cursor);
        K0(contactListItemView, cursor);
        if (n0()) {
            contactListItemView.g(null, 0);
            contactListItemView.setSnippet(cursor.getString(3));
        } else {
            contactListItemView.setSnippet(null);
        }
        r0(contactListItemView, !cursor.isLast());
    }
}

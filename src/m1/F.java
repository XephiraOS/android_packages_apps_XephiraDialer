package m1;

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
import com.android.contacts.list.ContactListItemView;
import com.android.incallui.OplusPhoneUtils;

/* compiled from: EmailAddressListAdapter.java */
/* loaded from: classes.dex */
public class F extends AbstractC1311g {

    /* renamed from: R, reason: collision with root package name */
    public final CharSequence f34837R;

    /* compiled from: EmailAddressListAdapter.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final String[] f34838a = {BreenoCallContract.BaseColumns._ID, "data2", "data3", "data1", "photo_id", "lookup", "display_name", "contact_id", "account_name", "account_type"};

        /* renamed from: b, reason: collision with root package name */
        public static final String[] f34839b = {BreenoCallContract.BaseColumns._ID, "data2", "data3", "data1", "photo_id", "lookup", "display_name_alt", "contact_id", "account_name", "account_type"};
    }

    public F(Context context) {
        super(context);
        this.f34837R = context.getText(R.string.unknownName);
    }

    public static Uri.Builder N0(Uri uri) {
        return uri.buildUpon().appendQueryParameter("android.provider.extra.ADDRESS_BOOK_INDEX", "true");
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public View A(Context context, int i10, Cursor cursor, int i11, ViewGroup viewGroup) {
        ContactListItemView contactListItemView = new ContactListItemView(context, null);
        contactListItemView.setUnknownNameText(this.f34837R);
        contactListItemView.setQuickContactEnabled(m0());
        return contactListItemView;
    }

    public void J0(ContactListItemView contactListItemView, Cursor cursor) {
        CharSequence charSequence;
        if (!cursor.isNull(1)) {
            charSequence = ContactsContract.CommonDataKinds.Email.getTypeLabel(k().getResources(), cursor.getInt(1), cursor.getString(2));
        } else {
            charSequence = null;
        }
        contactListItemView.setLabel(charSequence);
        contactListItemView.l(cursor, 3);
    }

    public void K0(ContactListItemView contactListItemView, Cursor cursor) {
        contactListItemView.n(cursor, 6, cursor.getLong(7), Y(), this.f34915o);
    }

    public void L0(ContactListItemView contactListItemView, Cursor cursor) {
        long j10;
        b.c cVar;
        if (!cursor.isNull(4)) {
            j10 = cursor.getLong(4);
        } else {
            j10 = 0;
        }
        if (j10 == 0) {
            cVar = a0(cursor, 6, 5, 7);
        } else {
            cVar = null;
        }
        e0().q(contactListItemView.getPhotoView(), j10, false, X(), cVar);
    }

    public void M0(ContactListItemView contactListItemView, int i10) {
        int sectionForPosition = getSectionForPosition(i10);
        if (getPositionForSection(sectionForPosition) == i10) {
            contactListItemView.setSectionHeader((String) getSections()[sectionForPosition]);
        } else {
            contactListItemView.setDividerVisible(false);
            contactListItemView.setSectionHeader(null);
        }
        if (getPositionForSection(sectionForPosition + 1) - 1 == i10) {
            contactListItemView.setDividerVisible(false);
        } else {
            contactListItemView.setDividerVisible(true);
        }
    }

    public Uri O0(int i10) {
        return ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, ((Cursor) getItem(i10)).getLong(0));
    }

    @Override // m1.AbstractC1311g
    public void V(W.b bVar, long j10) {
        Uri.Builder buildUpon;
        if (n0()) {
            buildUpon = ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI.buildUpon();
            String h02 = h0();
            if (TextUtils.isEmpty(h02)) {
                h02 = "";
            }
            buildUpon.appendPath(h02);
            buildUpon.appendQueryParameter("QUERY_NAME_WITHOUT_SEARCH_INDEX", OplusPhoneUtils.DeviceState.LOCK_DEVICE);
            buildUpon.appendQueryParameter(R0.c.f3185c, "true");
        } else {
            buildUpon = ContactsContract.CommonDataKinds.Email.CONTENT_URI.buildUpon();
        }
        buildUpon.appendQueryParameter("directory", String.valueOf(j10));
        buildUpon.appendQueryParameter("remove_duplicate_entries", "true");
        if (M()) {
            bVar.T(N0(buildUpon.build()).build());
        } else {
            bVar.T(buildUpon.build());
        }
        if (Y() == 1) {
            bVar.P(a.f34838a);
        } else {
            bVar.P(a.f34839b);
        }
        if (i0() == 1) {
            bVar.S("sort_key");
        } else {
            bVar.S("sort_key_alt");
        }
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public void g(View view, int i10, Cursor cursor, int i11) {
        ContactListItemView contactListItemView = (ContactListItemView) view;
        M0(contactListItemView, i11);
        K0(contactListItemView, cursor);
        L0(contactListItemView, cursor);
        J0(contactListItemView, cursor);
        r0(contactListItemView, !cursor.isLast());
    }
}

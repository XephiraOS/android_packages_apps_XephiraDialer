package m1;

import android.R;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.list.ContactListItemView;

/* compiled from: LegacyContactListAdapter.java */
/* loaded from: classes.dex */
public class I extends AbstractC1311g {

    /* renamed from: S, reason: collision with root package name */
    public static final String[] f34844S = {BreenoCallContract.BaseColumns._ID, "display_name", "phonetic_name", "starred", "mode"};

    /* renamed from: R, reason: collision with root package name */
    public CharSequence f34845R;

    public I(Context context) {
        super(context);
        this.f34845R = context.getText(R.string.unknownName);
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public View A(Context context, int i10, Cursor cursor, int i11, ViewGroup viewGroup) {
        ContactListItemView contactListItemView = new ContactListItemView(context, null);
        contactListItemView.setUnknownNameText(this.f34845R);
        return contactListItemView;
    }

    public void J0(ContactListItemView contactListItemView, Cursor cursor) {
        contactListItemView.m(cursor, 1, Y());
        contactListItemView.o(cursor, 2);
    }

    public void K0(ContactListItemView contactListItemView, Cursor cursor) {
        contactListItemView.p(cursor, 4, 0);
    }

    public Uri L0(int i10) {
        return ContentUris.withAppendedId(Contacts.People.CONTENT_URI, ((Cursor) getItem(i10)).getLong(0));
    }

    @Override // m1.AbstractC1311g
    public void V(W.b bVar, long j10) {
        bVar.T(Contacts.People.CONTENT_URI);
        bVar.P(f34844S);
        bVar.S("display_name");
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public void g(View view, int i10, Cursor cursor, int i11) {
        ContactListItemView contactListItemView = (ContactListItemView) view;
        J0(contactListItemView, cursor);
        K0(contactListItemView, cursor);
        r0(contactListItemView, !cursor.isLast());
    }
}

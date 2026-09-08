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
import com.android.incallui.OplusAutoRedialNotificationUI;

/* compiled from: LegacyPhoneNumberListAdapter.java */
/* loaded from: classes.dex */
public class J extends AbstractC1311g {

    /* renamed from: S, reason: collision with root package name */
    public static final String[] f34846S = {BreenoCallContract.BaseColumns._ID, OplusAutoRedialNotificationUI.TYPE, "label", "number", "display_name", "phonetic_name"};

    /* renamed from: R, reason: collision with root package name */
    public CharSequence f34847R;

    public J(Context context) {
        super(context);
        this.f34847R = context.getText(R.string.unknownName);
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public View A(Context context, int i10, Cursor cursor, int i11, ViewGroup viewGroup) {
        ContactListItemView contactListItemView = new ContactListItemView(context, null);
        contactListItemView.setUnknownNameText(this.f34847R);
        return contactListItemView;
    }

    public void J0(ContactListItemView contactListItemView, Cursor cursor) {
        contactListItemView.m(cursor, 4, Y());
        contactListItemView.o(cursor, 5);
    }

    public void K0(ContactListItemView contactListItemView, Cursor cursor) {
        contactListItemView.l(cursor, 3);
    }

    public Uri L0(int i10) {
        return ContentUris.withAppendedId(Contacts.Phones.CONTENT_URI, ((Cursor) getItem(i10)).getLong(0));
    }

    @Override // m1.AbstractC1311g
    public void V(W.b bVar, long j10) {
        bVar.T(Contacts.Phones.CONTENT_URI);
        bVar.P(f34846S);
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

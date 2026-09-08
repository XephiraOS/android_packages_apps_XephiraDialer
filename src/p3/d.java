package P3;

import E1.a;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.list.ContactListItemView;
import m1.AbstractC1315k;

/* compiled from: CountryOrAreaListAdapter.java */
/* loaded from: classes3.dex */
public class d extends AbstractC1315k {

    /* renamed from: Y, reason: collision with root package name */
    public int f2904Y;

    public d(Context context) {
        super(context);
        this.f2904Y = 0;
        P(true);
        G0(false);
    }

    @Override // m1.AbstractC1315k
    public void J0(ContactListItemView contactListItemView, Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("country_iso"));
        if (string != null && !string.isEmpty()) {
            contactListItemView.getNameTextView().setText(string.substring(0, string.length() - 3));
        }
    }

    @Override // m1.AbstractC1315k
    public void N0(ContactListItemView contactListItemView, int i10, Cursor cursor) {
        if (M()) {
            a.C0010a K10 = K(i10);
            contactListItemView.setCountView(null);
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

    @Override // com.android.contacts.framework.baseui.widget.a
    public void g(View view, int i10, Cursor cursor, int i11) {
        ContactListItemView contactListItemView = (ContactListItemView) view;
        N0(contactListItemView, i11, cursor);
        J0(contactListItemView, cursor);
        r0(contactListItemView, !cursor.isLast());
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public View m(int i10, Cursor cursor, View view, ViewGroup viewGroup) {
        return new View(k());
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public int p(int i10) {
        int i11;
        int p10 = super.p(i10);
        if (p10 == 0 && (i11 = this.f2904Y) < 2) {
            this.f2904Y = i11 + 1;
            return -1;
        }
        return p10;
    }

    @Override // m1.AbstractC1311g
    public void V(W.b bVar, long j10) {
    }

    @Override // m1.AbstractC1311g, com.android.contacts.framework.baseui.widget.a
    public void f(View view, int i10, Cursor cursor) {
    }
}

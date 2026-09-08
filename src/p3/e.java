package P3;

import E1.a;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.CheckBox;
import com.android.contacts.list.ContactListItemView;
import com.customize.contacts.model.IdRecord;
import m1.F;

/* compiled from: CustomizeEmailAddressListAdapter.java */
/* loaded from: classes3.dex */
public class e extends F {

    /* renamed from: S, reason: collision with root package name */
    public boolean f2905S;

    /* renamed from: T, reason: collision with root package name */
    public com.customize.contacts.manager.g f2906T;

    public e(Context context) {
        super(context);
        this.f2905S = false;
        this.f2906T = null;
    }

    @Override // m1.F
    public void J0(ContactListItemView contactListItemView, Cursor cursor) {
        contactListItemView.l(cursor, 3);
    }

    @Override // m1.F
    public void M0(ContactListItemView contactListItemView, int i10) {
        String str = null;
        if (M()) {
            a.C0010a K10 = K(i10);
            if (K10.f478a) {
                str = K10.f480c;
            }
            contactListItemView.setSectionHeader(str);
            contactListItemView.setDividerVisible(!K10.f479b);
            return;
        }
        contactListItemView.setSectionHeader(null);
        contactListItemView.setDividerVisible(true);
    }

    public void P0(com.customize.contacts.manager.g gVar) {
        this.f2906T = gVar;
    }

    @Override // m1.F, com.android.contacts.framework.baseui.widget.a
    public void g(View view, int i10, Cursor cursor, int i11) {
        char[] cArr;
        ContactListItemView contactListItemView = (ContactListItemView) view;
        cursor.moveToPosition(i11);
        if (n0()) {
            cArr = j0();
        } else {
            cArr = null;
        }
        contactListItemView.setHighlightedPrefix(cArr);
        M0(contactListItemView, i11);
        K0(contactListItemView, cursor);
        long j10 = cursor.getLong(7);
        L0(contactListItemView, cursor);
        J0(contactListItemView, cursor);
        if (n0()) {
            contactListItemView.g(null, 0);
            contactListItemView.setSnippet(cursor.getString(3));
        } else {
            contactListItemView.setSnippet(null);
        }
        IdRecord idRecord = (IdRecord) contactListItemView.getTag();
        String string = cursor.getString(3);
        String string2 = cursor.getString(6);
        if (idRecord == null) {
            idRecord = new IdRecord(j10, string2, string, false);
            contactListItemView.setTag(idRecord);
        } else {
            idRecord.m(j10);
            idRecord.p(string2);
            idRecord.q(string);
        }
        CheckBox checkView = contactListItemView.getCheckView();
        if (this.f2905S) {
            checkView.setVisibility(0);
            checkView.setTag(idRecord);
            checkView.setChecked(this.f2906T.b(j10, string2, string));
        } else {
            checkView.setVisibility(4);
        }
        r0(contactListItemView, !cursor.isLast());
    }
}

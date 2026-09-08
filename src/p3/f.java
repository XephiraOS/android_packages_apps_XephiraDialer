package P3;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import com.android.contacts.list.ContactListItemView;
import com.customize.contacts.model.IdRecord;

/* compiled from: CustomizePhoneNumberListAdapter.java */
/* loaded from: classes3.dex */
public class f extends com.android.contacts.list.d {

    /* renamed from: V, reason: collision with root package name */
    public ListView f2907V;

    /* renamed from: W, reason: collision with root package name */
    public boolean f2908W;

    /* renamed from: X, reason: collision with root package name */
    public boolean f2909X;

    /* renamed from: Y, reason: collision with root package name */
    public com.customize.contacts.manager.g f2910Y;

    public f(Context context) {
        super(context);
        this.f2907V = null;
        this.f2908W = false;
        this.f2909X = false;
        this.f2910Y = null;
    }

    @Override // com.android.contacts.list.d
    public void K0(ContactListItemView contactListItemView, Cursor cursor) {
        contactListItemView.setIsRcsMode(this.f2909X);
        contactListItemView.l(cursor, 3);
    }

    public void S0(com.customize.contacts.manager.g gVar) {
        this.f2910Y = gVar;
    }

    public void T0() {
        this.f2908W = true;
    }

    @Override // com.android.contacts.list.d, com.android.contacts.framework.baseui.widget.a
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
        long j10 = cursor.getLong(4);
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
        IdRecord idRecord = (IdRecord) contactListItemView.getTag();
        String string = cursor.getString(3);
        String string2 = cursor.getString(7);
        if (idRecord == null) {
            idRecord = new IdRecord(j10, string2, string, false);
            contactListItemView.setTag(idRecord);
        } else {
            idRecord.m(j10);
            idRecord.p(string2);
            idRecord.q(string);
        }
        CheckBox checkView = contactListItemView.getCheckView();
        if (this.f2908W) {
            checkView.setVisibility(0);
            checkView.setTag(idRecord);
            checkView.setChecked(this.f2910Y.b(j10, string2, string));
            contactListItemView.setChecked(this.f2910Y.b(j10, string2, string));
        } else {
            checkView.setVisibility(4);
            contactListItemView.setChecked(false);
        }
        r0(contactListItemView, !cursor.isLast());
    }
}

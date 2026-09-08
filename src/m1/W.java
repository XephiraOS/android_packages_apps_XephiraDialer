package m1;

import E1.a;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.list.ContactListItemView;
import com.customize.contacts.model.IdRecord;
import com.customize.contacts.util.AnimationAnimationListenerC0813y;
import com.customize.contacts.util.C0806q;
import com.oplus.dialer.R;

/* compiled from: SimContactListAdapter.java */
/* loaded from: classes.dex */
public class W extends AbstractC1315k {

    /* renamed from: Y, reason: collision with root package name */
    public int f34871Y;

    /* renamed from: Z, reason: collision with root package name */
    public boolean f34872Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f34873a0;

    public W(Context context) {
        super(context);
        this.f34871Y = 0;
        this.f34872Z = true;
        this.f34873a0 = true;
        P(true);
        G0(false);
    }

    @Override // m1.AbstractC1315k
    public void J0(ContactListItemView contactListItemView, Cursor cursor) {
        String string = cursor.getString(cursor.getColumnIndex("name"));
        if (string != null && !string.isEmpty()) {
            if (C0637b.h()) {
                string = C0637b.c(string);
            }
            contactListItemView.getNameTextView().setText(string);
            return;
        }
        String string2 = cursor.getString(cursor.getColumnIndex("number"));
        if (string2 != null && !string2.isEmpty()) {
            if (C0637b.h()) {
                string2 = C0637b.c(string2);
            }
            contactListItemView.getNameTextView().setText(string2);
            return;
        }
        String string3 = cursor.getString(cursor.getColumnIndex("additionalNumber"));
        if (string3 != null && !string3.isEmpty()) {
            contactListItemView.getNameTextView().setText(string3);
            return;
        }
        String string4 = cursor.getString(cursor.getColumnIndex("emails"));
        if (string4 != null && !string4.isEmpty()) {
            contactListItemView.getNameTextView().setText(string4);
        } else {
            contactListItemView.getNameTextView().setText(k().getText(R.string.missing_name));
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

    @Override // m1.AbstractC1315k
    public String Q0(int i10) {
        Cursor cursor = (Cursor) getItem(i10);
        return cursor.getString(cursor.getColumnIndex("name"));
    }

    public void f1(boolean z10) {
        this.f34872Z = z10;
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public void g(View view, int i10, Cursor cursor, int i11) {
        ContactListItemView contactListItemView = (ContactListItemView) view;
        contactListItemView.setBackgroundResource(R.drawable.select_list_item_background_seletor);
        N0(contactListItemView, i11, cursor);
        J0(contactListItemView, cursor);
        IdRecord idRecord = (IdRecord) contactListItemView.getTag();
        int i12 = cursor.getInt(cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID));
        if (idRecord == null) {
            idRecord = new IdRecord(i12);
        } else {
            idRecord.m(i12);
        }
        contactListItemView.getCheckView().setTag(idRecord);
        if (this.f34990R != null) {
            contactListItemView.getCheckView().setChecked(this.f34990R.f().e(i12));
        }
        C0806q c0806q = this.f34990R;
        boolean z10 = false;
        if (c0806q != null && c0806q.i()) {
            if (contactListItemView.getCheckView().getVisibility() != 0) {
                if (this.f34872Z) {
                    AnimationAnimationListenerC0813y.i(this.f472i, null, 0).u(false, null, contactListItemView.getCheckView());
                    contactListItemView.getCheckView().setVisibility(0);
                } else {
                    contactListItemView.getCheckView().setVisibility(0);
                    contactListItemView.getCheckView().setAlpha(1.0f);
                }
            } else {
                contactListItemView.getCheckView().setVisibility(0);
                contactListItemView.getCheckView().setAlpha(1.0f);
            }
            contactListItemView.setChecked(contactListItemView.getCheckView().isChecked());
        } else {
            if (contactListItemView.getCheckView().getVisibility() == 0) {
                if (this.f34873a0) {
                    AnimationAnimationListenerC0813y.n(this.f472i, null, 0).u(false, null, contactListItemView.getCheckView());
                    contactListItemView.getCheckView().setVisibility(8);
                } else {
                    contactListItemView.getCheckView().setVisibility(8);
                }
            }
            contactListItemView.setChecked(false);
        }
        if (i11 != cursor.getCount() - 1) {
            z10 = true;
        }
        r0(contactListItemView, z10);
    }

    public void g1(boolean z10) {
        this.f34873a0 = z10;
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public View m(int i10, Cursor cursor, View view, ViewGroup viewGroup) {
        return new View(k());
    }

    @Override // com.android.contacts.framework.baseui.widget.a
    public int p(int i10) {
        int i11;
        int p10 = super.p(i10);
        if (p10 == 0 && (i11 = this.f34871Y) < 2) {
            this.f34871Y = i11 + 1;
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

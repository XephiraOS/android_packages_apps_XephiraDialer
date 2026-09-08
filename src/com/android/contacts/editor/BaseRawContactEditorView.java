package com.android.contacts.editor;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.android.contacts.editor.ContactEditorFragment;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.EntityDelta;
import com.customize.contacts.widget.EditRingtoneView;
import com.oplus.dialer.R;

/* loaded from: classes.dex */
public abstract class BaseRawContactEditorView extends LinearLayout {

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f15080h = {"vnd.android.cursor.item/phone_v2"};

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f15081i = {"vnd.android.cursor.item/name", "vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/organization", "vnd.android.cursor.item/group_membership", "vnd.android.cursor.item/postal-address_v2", "vnd.android.cursor.item/im", "vnd.android.cursor.item/contact_event", "vnd.android.cursor.item/relation", "vnd.android.cursor.item/nickname", "vnd.android.cursor.item/website", "vnd.android.cursor.item/note", "vnd.android.cursor.item/custom_ringtone", "vnd.android.cursor.item/custom_vibration"};

    /* renamed from: j, reason: collision with root package name */
    public static String[] f15082j = {"vnd.android.cursor.item/organization", "vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/contact_event", "vnd.android.cursor.item/relation", "vnd.android.cursor.item/note", "vnd.android.cursor.item/website", "vnd.android.cursor.item/postal-address_v2", "vnd.android.cursor.item/im", "vnd.android.cursor.item/nickname"};

    /* renamed from: a, reason: collision with root package name */
    public PhotoEditorView f15083a;

    /* renamed from: b, reason: collision with root package name */
    public EditRingtoneView f15084b;

    /* renamed from: c, reason: collision with root package name */
    public com.customize.contacts.manager.z f15085c;

    /* renamed from: d, reason: collision with root package name */
    public ContactEditorFragment.u f15086d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15087e;

    /* renamed from: f, reason: collision with root package name */
    public View f15088f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15089g;

    public BaseRawContactEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15086d = null;
        this.f15087e = false;
        this.f15089g = true;
    }

    public static String[] getNeedAddKinds() {
        return f15082j;
    }

    public static void setNeedAddKinds(String[] strArr) {
        f15082j = strArr;
    }

    public boolean a() {
        return this.f15083a.w();
    }

    public void b(EntityDelta entityDelta, Bundle bundle) {
        this.f15083a.D(entityDelta, bundle);
    }

    public abstract void c(EntityDelta entityDelta, AccountType accountType, ViewIdGenerator viewIdGenerator, boolean z10);

    public void d() {
        setNeedAddKinds(f15081i);
    }

    public void e() {
        setNeedAddKinds(f15080h);
    }

    public EditRingtoneView getEditRingtone() {
        return this.f15084b;
    }

    public PhotoEditorView getPhotoEditor() {
        return this.f15083a;
    }

    public abstract long getRawContactId();

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f15088f = findViewById(R.id.body);
        PhotoEditorView photoEditorView = (PhotoEditorView) findViewById(R.id.edit_photo);
        this.f15083a = photoEditorView;
        if (photoEditorView != null) {
            photoEditorView.setEnabled(isEnabled());
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    public void setEditRingtone(EditRingtoneView editRingtoneView) {
        this.f15084b = editRingtoneView;
    }

    public void setExpanded(boolean z10) {
        int i10;
        if ((getParent() instanceof ViewGroup) && ((ViewGroup) getParent()).getChildCount() == 1) {
            z10 = true;
        }
        if (z10 == this.f15089g) {
            return;
        }
        this.f15089g = z10;
        View view = this.f15088f;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        view.setVisibility(i10);
    }

    public void setHasPhotoEditor(boolean z10) {
        int i10;
        this.f15087e = z10;
        PhotoEditorView photoEditorView = this.f15083a;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        photoEditorView.setVisibility(i10);
    }

    public void setListener(ContactEditorFragment.u uVar) {
        this.f15086d = uVar;
    }

    public void setOnActivityResultManager(com.customize.contacts.manager.z zVar) {
        this.f15085c = zVar;
    }

    public void setPhotoBitmap(Bitmap bitmap) {
        this.f15083a.setPhotoBitmap(bitmap);
    }

    public void setGroupMetaData(Cursor cursor) {
    }
}

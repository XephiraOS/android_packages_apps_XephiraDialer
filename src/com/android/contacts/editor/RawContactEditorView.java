package com.android.contacts.editor;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.business.calllog.breenocall.detail.widget.ChipGroupView;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.EntityDelta;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.widget.EditRingtoneView;
import com.customize.contacts.widget.EditVibrationView;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import n1.AbstractC1362a;

/* loaded from: classes.dex */
public class RawContactEditorView extends BaseRawContactEditorView {

    /* renamed from: J, reason: collision with root package name */
    public static final HashMap<String, Integer> f15377J = new HashMap<>();

    /* renamed from: K, reason: collision with root package name */
    public static final HashMap<String, Integer> f15378K = new HashMap<>();

    /* renamed from: A, reason: collision with root package name */
    public com.android.contacts.model.c f15379A;

    /* renamed from: B, reason: collision with root package name */
    public EntityDelta f15380B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f15381C;

    /* renamed from: D, reason: collision with root package name */
    public androidx.appcompat.app.b f15382D;

    /* renamed from: E, reason: collision with root package name */
    public long f15383E;

    /* renamed from: F, reason: collision with root package name */
    public com.android.contacts.util.s f15384F;

    /* renamed from: G, reason: collision with root package name */
    public AbstractC1362a f15385G;

    /* renamed from: H, reason: collision with root package name */
    public ChipGroupView f15386H;

    /* renamed from: I, reason: collision with root package name */
    public ChipGroupView f15387I;

    /* renamed from: k, reason: collision with root package name */
    public LayoutInflater f15388k;

    /* renamed from: l, reason: collision with root package name */
    public StructuredNameEditorView f15389l;

    /* renamed from: m, reason: collision with root package name */
    public PhoneticNameEditorView f15390m;

    /* renamed from: n, reason: collision with root package name */
    public GroupMembershipView f15391n;

    /* renamed from: o, reason: collision with root package name */
    public CustomizeKindSectionView f15392o;

    /* renamed from: p, reason: collision with root package name */
    public ViewGroup f15393p;

    /* renamed from: q, reason: collision with root package name */
    public ViewGroup f15394q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f15395r;

    /* renamed from: x, reason: collision with root package name */
    public long f15396x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f15397y;

    /* renamed from: z, reason: collision with root package name */
    public Cursor f15398z;

    /* loaded from: classes.dex */
    public class a implements b {
        public a() {
        }

        @Override // com.android.contacts.editor.RawContactEditorView.b
        public void a(String str) {
            RawContactEditorView.this.i(str);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(String str);
    }

    public RawContactEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15396x = -1L;
        this.f15397y = true;
        this.f15381C = true;
        this.f15383E = -1L;
        this.f15385G = AbstractC1362a.h(context);
    }

    private long getDefaultGroupId() {
        String z10 = this.f15380B.N().z("account_type");
        String z11 = this.f15380B.N().z("account_name");
        String z12 = this.f15380B.N().z("data_set");
        this.f15398z.moveToPosition(-1);
        while (this.f15398z.moveToNext()) {
            String string = this.f15398z.getString(0);
            String string2 = this.f15398z.getString(1);
            String string3 = this.f15398z.getString(2);
            if (string.equals(z11) && string2.equals(z10) && com.google.common.base.h.a(string3, z12)) {
                long j10 = this.f15398z.getLong(3);
                if (!this.f15398z.isNull(5) && this.f15398z.getInt(5) != 0) {
                    return j10;
                }
            }
        }
        return -1L;
    }

    public static HashMap<String, Integer> getLunarDaysMap() {
        return f15378K;
    }

    public static HashMap<String, Integer> getLunarMonthsMap() {
        return f15377J;
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView
    public void c(EntityDelta entityDelta, AccountType accountType, ViewIdGenerator viewIdGenerator, boolean z10) {
        boolean z11;
        boolean z12;
        this.f15393p.removeAllViews();
        this.f15380B = entityDelta;
        if (entityDelta != null && accountType != null) {
            setId(viewIdGenerator.d(entityDelta, null, null, -1));
            com.android.contacts.model.d.e(entityDelta, accountType, "vnd.android.cursor.item/name");
            boolean z13 = false;
            for (String str : BaseRawContactEditorView.getNeedAddKinds()) {
                com.android.contacts.model.d.e(entityDelta, accountType, str);
            }
            if (BaseRawContactEditorView.getNeedAddKinds().length == BaseRawContactEditorView.f15080h.length) {
                this.f15381C = false;
                com.android.contacts.model.d.K(entityDelta);
            } else {
                this.f15381C = true;
            }
            EntityDelta.ValuesDelta N10 = entityDelta.N();
            if (N10 != null && N10.j(BreenoCallContract.BaseColumns._ID)) {
                this.f15396x = N10.x(BreenoCallContract.BaseColumns._ID).longValue();
                String z14 = N10.z("account_name");
                if (!z10) {
                    String z15 = N10.z("account_type");
                    if (TextUtils.equals(R0.a.f3165a, z14)) {
                        this.f15395r.setVisibility(0);
                        this.f15395r.setText(getContext().getString(R.string.contact_editor_account_storage_phone));
                    } else if (!TextUtils.isEmpty(z14)) {
                        this.f15395r.setVisibility(0);
                        if (TextUtils.equals("com.android.oplus.sim", z15)) {
                            String f10 = com.customize.contacts.simcontacts.b.f(getContext(), com.customize.contacts.simcontacts.b.j(z14));
                            if (!TextUtils.isEmpty(f10)) {
                                this.f15395r.setText(f10.toString());
                            } else {
                                this.f15395r.setText(z14);
                            }
                        } else {
                            this.f15395r.setText(z14);
                        }
                    } else {
                        this.f15395r.setVisibility(8);
                    }
                }
                com.android.contacts.model.d.e(entityDelta, accountType, "vnd.android.cursor.item/photo");
                if (accountType.j("vnd.android.cursor.item/photo") != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                setHasPhotoEditor(z11);
                getPhotoEditor().setEnabled(isEnabled());
                this.f15389l.setEnabled(isEnabled());
                this.f15390m.setEnabled(isEnabled());
                this.f15393p.setVisibility(0);
                this.f15394q.setVisibility(0);
                this.f15379A = accountType.j("vnd.android.cursor.item/group_membership");
                a aVar = new a();
                h();
                Iterator<com.android.contacts.model.c> it = accountType.l().iterator();
                while (it.hasNext()) {
                    com.android.contacts.model.c next = it.next();
                    if (next.f17010i) {
                        String str2 = next.f17004c;
                        if ("vnd.android.cursor.item/name".equals(str2)) {
                            EntityDelta.ValuesDelta H10 = entityDelta.H(str2);
                            this.f15389l.g(accountType.j("#displayName"), H10, entityDelta, false, viewIdGenerator);
                            this.f15390m.g(accountType.j("#phoneticName"), H10, entityDelta, false, viewIdGenerator);
                            this.f15389l.setOnReadyToContentAssociateListener(this.f15384F);
                        } else if ("vnd.android.cursor.item/photo".equals(str2)) {
                            getPhotoEditor().g(next, entityDelta.H(str2), entityDelta, false, viewIdGenerator);
                            getPhotoEditor().setVisibility(z13 ? 1 : 0);
                        } else if ("vnd.android.cursor.item/group_membership".equals(str2)) {
                            if (this.f15379A != null) {
                                GroupMembershipView groupMembershipView = (GroupMembershipView) this.f15388k.inflate(R.layout.item_group_membership, this.f15393p, z13);
                                this.f15391n = groupMembershipView;
                                groupMembershipView.setEnabled(isEnabled());
                                this.f15391n.setState(entityDelta);
                            }
                            if (this.f15391n != null) {
                                z12 = true;
                            } else {
                                z12 = z13 ? 1 : 0;
                            }
                            if ((z12 & (!z10)) && entityDelta.Q(str2)) {
                                this.f15393p.addView(this.f15391n);
                            }
                        } else if ("vnd.android.cursor.item/organization".equals(str2)) {
                            CustomizeKindSectionView customizeKindSectionView = (CustomizeKindSectionView) this.f15388k.inflate(R.layout.customize_item_kind_section, this.f15393p, z13);
                            this.f15392o = customizeKindSectionView;
                            customizeKindSectionView.setEnabled(isEnabled());
                            this.f15392o.setShowOnlyDialogListener(aVar);
                            this.f15392o.i(next, entityDelta, z13, viewIdGenerator);
                            this.f15393p.addView(this.f15392o);
                            View inflate = this.f15388k.inflate(R.layout.chipgroup_layout, this.f15393p, z13);
                            this.f15393p.addView(inflate);
                            this.f15386H = (ChipGroupView) inflate.findViewById(R.id.candidates);
                            View inflate2 = this.f15388k.inflate(R.layout.chipgroup_layout, this.f15393p, z13);
                            this.f15393p.addView(inflate2);
                            this.f15387I = (ChipGroupView) inflate2.findViewById(R.id.candidates);
                        } else if ("vnd.android.cursor.item/custom_vibration".equals(str2)) {
                            if (!z10) {
                                View inflate3 = this.f15388k.inflate(R.layout.editor_separator, this.f15393p, z13);
                                EditVibrationView editVibrationView = (EditVibrationView) this.f15388k.inflate(R.layout.item_edit_custom_vibration_view, this.f15393p, z13);
                                EntityDelta entityDelta2 = this.f15380B;
                                editVibrationView.m(entityDelta2, entityDelta2.N());
                                editVibrationView.l(next, entityDelta);
                                this.f15393p.addView(inflate3);
                                this.f15393p.addView(editVibrationView);
                            }
                        } else if ("vnd.android.cursor.item/custom_ringtone".equals(str2)) {
                            if (!z10 && CommonFeatureOption.j()) {
                                View inflate4 = this.f15388k.inflate(R.layout.editor_separator, this.f15393p, z13);
                                EditRingtoneView editRingtoneView = (EditRingtoneView) this.f15388k.inflate(R.layout.item_edit_custom_ringtone_view, this.f15393p, z13);
                                EntityDelta entityDelta3 = this.f15380B;
                                editRingtoneView.n(entityDelta3, entityDelta3.N());
                                editRingtoneView.m(next, entityDelta);
                                this.f15393p.addView(inflate4);
                                this.f15393p.addView(editRingtoneView);
                                setEditRingtone(editRingtoneView);
                                this.f15084b.setVisibility(z13 ? 1 : 0);
                            }
                        } else if (next.f17018q != null) {
                            KindSectionView kindSectionView = (KindSectionView) this.f15388k.inflate(R.layout.item_kind_section, this.f15393p, z13);
                            if ("vnd.android.cursor.item/email_v2".equals(str2) || "vnd.android.cursor.item/phone_v2".equals(str2)) {
                                kindSectionView.setOnReadyToContentAssociateListener(this.f15384F);
                            }
                            if ("vnd.android.cursor.item/relation".equals(str2)) {
                                kindSectionView.setOnActivityResultManager(this.f15085c);
                            }
                            kindSectionView.setEnabled(isEnabled());
                            kindSectionView.setShowOnlyDialogListener(aVar);
                            kindSectionView.w(next, entityDelta, false, viewIdGenerator, z10);
                            this.f15393p.addView(kindSectionView);
                        }
                        z13 = false;
                    }
                }
                j();
                g();
                f();
            }
        }
    }

    public final void f() {
        com.android.contacts.model.c cVar;
        EntityDelta entityDelta;
        if (this.f15383E > 0 && (cVar = this.f15379A) != null && (entityDelta = this.f15380B) != null) {
            com.android.contacts.model.d.t(entityDelta, cVar).d0("data1", this.f15383E);
        }
    }

    public final void g() {
        Cursor cursor;
        EntityDelta entityDelta;
        if (this.f15397y && (cursor = this.f15398z) != null && !cursor.isClosed() && (entityDelta = this.f15380B) != null) {
            ArrayList<EntityDelta.ValuesDelta> D10 = entityDelta.D("vnd.android.cursor.item/group_membership");
            if (D10 != null) {
                Iterator<EntityDelta.ValuesDelta> it = D10.iterator();
                while (it.hasNext()) {
                    Long x10 = it.next().x("data1");
                    if (x10 != null && x10.longValue() != 0) {
                        return;
                    }
                }
            }
            long defaultGroupId = getDefaultGroupId();
            if (defaultGroupId != -1) {
                com.android.contacts.model.d.t(this.f15380B, this.f15379A).d0("data1", defaultGroupId);
            }
        }
    }

    public GroupMembershipView getGroupMembershipView() {
        return this.f15391n;
    }

    public TextFieldsEditorView getNameEditor() {
        return this.f15389l;
    }

    public ChipGroupView getOrgChipGroupView() {
        return this.f15386H;
    }

    public CustomizeKindSectionView getOrganizationEditor() {
        return this.f15392o;
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView
    public long getRawContactId() {
        return this.f15396x;
    }

    public ChipGroupView getTitleChipGroupView() {
        return this.f15387I;
    }

    public final void h() {
        f15377J.clear();
        f15378K.clear();
        String[] stringArray = getContext().getResources().getStringArray(R.array.oplus_lunar_month);
        String[] stringArray2 = getContext().getResources().getStringArray(R.array.oplus_lunar_day);
        int i10 = 0;
        int i11 = 0;
        while (i11 < stringArray.length) {
            HashMap<String, Integer> hashMap = f15377J;
            int i12 = i11 + 1;
            hashMap.put(stringArray[i11], Integer.valueOf(i12));
            hashMap.put("闰" + stringArray[i11], Integer.valueOf(i12));
            i11 = i12;
        }
        while (i10 < stringArray2.length) {
            HashMap<String, Integer> hashMap2 = f15378K;
            String str = stringArray2[i10];
            i10++;
            hashMap2.put(str, Integer.valueOf(i10));
        }
    }

    public void i(String str) {
        String string = getContext().getResources().getString(R.string.cannot_modify_read_only_contacts_tablet, str);
        if (!TextUtils.isEmpty(string)) {
            androidx.appcompat.app.b bVar = this.f15382D;
            if (bVar == null) {
                this.f15382D = new COUIAlertDialogBuilder(getContext()).setPositiveButton(R.string.oplus_know, (DialogInterface.OnClickListener) null).setTitle((CharSequence) string).show();
                return;
            }
            bVar.setTitle(string);
            if (!this.f15382D.isShowing()) {
                this.f15382D.show();
            }
        }
    }

    public final void j() {
        if ((!FeatureOption.o() || !getContext().getResources().getBoolean(R.bool.config_editor_include_phonetic_name)) && !this.f15390m.o0() && !this.f15381C) {
            this.f15390m.setVisibility(8);
        } else {
            this.f15390m.setVisibility(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        f15377J.clear();
        f15378K.clear();
        super.onDetachedFromWindow();
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f15388k = (LayoutInflater) getContext().getSystemService("layout_inflater");
        StructuredNameEditorView structuredNameEditorView = (StructuredNameEditorView) findViewById(R.id.edit_name);
        this.f15389l = structuredNameEditorView;
        structuredNameEditorView.setDeletable(false);
        PhoneticNameEditorView phoneticNameEditorView = (PhoneticNameEditorView) findViewById(R.id.edit_phonetic_name);
        this.f15390m = phoneticNameEditorView;
        phoneticNameEditorView.setDeletable(false);
        this.f15393p = (ViewGroup) findViewById(R.id.sect_fields);
        this.f15394q = (ViewGroup) findViewById(R.id.edit_name_fields);
        this.f15395r = (TextView) findViewById(R.id.account_name);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setAutoAddToDefaultGroup(boolean z10) {
        this.f15397y = z10;
    }

    public void setBusinessCardGroupId(long j10) {
        this.f15383E = j10;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        PhotoEditorView photoEditor = getPhotoEditor();
        if (photoEditor != null) {
            photoEditor.setEnabled(z10);
        }
        CustomizeKindSectionView customizeKindSectionView = this.f15392o;
        if (customizeKindSectionView != null) {
            customizeKindSectionView.setEnabled(z10);
        }
        StructuredNameEditorView structuredNameEditorView = this.f15389l;
        if (structuredNameEditorView != null) {
            structuredNameEditorView.setEnabled(z10);
        }
        PhoneticNameEditorView phoneticNameEditorView = this.f15390m;
        if (phoneticNameEditorView != null) {
            phoneticNameEditorView.setEnabled(z10);
        }
        ViewGroup viewGroup = this.f15393p;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                this.f15393p.getChildAt(i10).setEnabled(z10);
            }
        }
        GroupMembershipView groupMembershipView = this.f15391n;
        if (groupMembershipView != null) {
            groupMembershipView.setEnabled(z10);
        }
    }

    @Override // com.android.contacts.editor.BaseRawContactEditorView
    public void setGroupMetaData(Cursor cursor) {
        this.f15398z = cursor;
        g();
        GroupMembershipView groupMembershipView = this.f15391n;
        if (groupMembershipView != null) {
            groupMembershipView.setBusinessCardGroupId(this.f15383E);
            this.f15391n.setGroupMetaData(cursor);
        }
    }

    public void setOnReadyToContentAssociateListener(com.android.contacts.util.s sVar) {
        this.f15384F = sVar;
    }
}

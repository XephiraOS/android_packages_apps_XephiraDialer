package com.android.contacts.list;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.list.CustomContactListFilterActivity;
import com.android.contacts.list.b;
import com.android.contacts.model.AccountType;
import com.android.contacts.util.C;
import com.coui.appcompat.checkbox.COUICheckBox;
import com.coui.appcompat.expandable.COUIExpandableRecyclerView;
import com.customize.contacts.util.b0;
import com.oplus.dialer.R;
import kotlin.jvm.internal.i;
import n1.AbstractC1362a;

/* compiled from: DisplayAdapter.kt */
/* loaded from: classes.dex */
public final class b extends COUIExpandableRecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final Context f16875a;

    /* renamed from: b, reason: collision with root package name */
    public CustomContactListFilterActivity.AccountSet f16876b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractC1362a f16877c;

    /* compiled from: DisplayAdapter.kt */
    /* loaded from: classes.dex */
    public final class a extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f16878a;

        /* renamed from: b, reason: collision with root package name */
        public final CheckBox f16879b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f16880c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, View itemView) {
            super(itemView);
            i.f(itemView, "itemView");
            this.f16880c = bVar;
            this.f16878a = (TextView) itemView.findViewById(R.id.group_name);
            this.f16879b = (CheckBox) itemView.findViewById(R.id.check_box);
        }

        public final CheckBox e() {
            return this.f16879b;
        }

        public final TextView f() {
            return this.f16878a;
        }
    }

    /* compiled from: DisplayAdapter.kt */
    /* renamed from: com.android.contacts.list.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0171b extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f16881a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f16882b;

        /* renamed from: c, reason: collision with root package name */
        public final COUICheckBox f16883c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f16884d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0171b(b bVar, View itemView) {
            super(itemView);
            i.f(itemView, "itemView");
            this.f16884d = bVar;
            this.f16881a = (TextView) itemView.findViewById(R.id.account_name);
            this.f16882b = (TextView) itemView.findViewById(R.id.account_type);
            this.f16883c = (COUICheckBox) itemView.findViewById(R.id.check_box);
        }

        public final TextView e() {
            return this.f16881a;
        }

        public final TextView f() {
            return this.f16882b;
        }

        public final COUICheckBox g() {
            return this.f16883c;
        }
    }

    public b(Context context, CustomContactListFilterActivity.AccountSet accountSet) {
        i.f(context, "context");
        this.f16875a = context;
        this.f16876b = accountSet;
        AbstractC1362a h10 = AbstractC1362a.h(context);
        i.e(h10, "getInstance(context)");
        this.f16877c = h10;
    }

    public static final void d(C0171b this_apply, b this$0, int i10, View view) {
        boolean z10;
        i.f(this_apply, "$this_apply");
        i.f(this$0, "this$0");
        if (this_apply.g().getState() == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        CustomContactListFilterActivity.AccountSet accountSet = this$0.f16876b;
        i.c(accountSet);
        CustomContactListFilterActivity.a aVar = accountSet.get(i10);
        int childrenCount = this$0.getChildrenCount(i10);
        int size = aVar.f16860e.size();
        for (int i11 = 0; i11 < childrenCount && i11 < size; i11++) {
            CustomContactListFilterActivity.GroupDelta groupDelta = aVar.f16860e.get(i11);
            if (groupDelta != null) {
                groupDelta.D0(z10);
                groupDelta.E0(z10);
            }
        }
        this$0.notifyDataSetChanged();
    }

    public final CustomContactListFilterActivity.AccountSet b() {
        return this.f16876b;
    }

    public final int c(int i10) {
        CustomContactListFilterActivity.GroupDelta groupDelta;
        int childrenCount = getChildrenCount(i10);
        if (childrenCount == 0) {
            return 2;
        }
        boolean z10 = false;
        boolean z11 = true;
        for (int i11 = 0; i11 < childrenCount; i11++) {
            Object child = getChild(i10, i11);
            if (child instanceof CustomContactListFilterActivity.GroupDelta) {
                groupDelta = (CustomContactListFilterActivity.GroupDelta) child;
            } else {
                groupDelta = null;
            }
            if (groupDelta != null && groupDelta.A0()) {
                z10 = true;
            } else {
                z11 = false;
            }
        }
        if (z11) {
            return 2;
        }
        if (!z10) {
            return 0;
        }
        return 1;
    }

    public final void e(CustomContactListFilterActivity.AccountSet accountSet) {
        this.f16876b = accountSet;
    }

    @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
    public Object getChild(int i10, int i11) {
        CustomContactListFilterActivity.AccountSet accountSet = this.f16876b;
        i.c(accountSet);
        CustomContactListFilterActivity.a aVar = accountSet.get(i10);
        if (i11 >= 0 && i11 < aVar.f16860e.size()) {
            return aVar.f16860e.get(i11);
        }
        return null;
    }

    @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
    public int getChildrenCount(int i10) {
        int i11;
        CustomContactListFilterActivity.AccountSet accountSet = this.f16876b;
        i.c(accountSet);
        CustomContactListFilterActivity.a aVar = accountSet.get(i10);
        if (aVar.f16861f.size() > 0) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        return aVar.f16860e.size() + i11;
    }

    @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
    public Object getGroup(int i10) {
        CustomContactListFilterActivity.AccountSet accountSet = this.f16876b;
        i.c(accountSet);
        CustomContactListFilterActivity.a aVar = accountSet.get(i10);
        i.e(aVar, "accounts!![groupPosition]");
        return aVar;
    }

    @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
    public int getGroupCount() {
        CustomContactListFilterActivity.AccountSet accountSet = this.f16876b;
        if (accountSet != null) {
            return accountSet.size();
        }
        return 0;
    }

    @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
    public void onBindChildView(int i10, int i11, boolean z10, RecyclerView.B b10) {
        if (b10 instanceof a) {
            a aVar = (a) b10;
            CustomContactListFilterActivity.GroupDelta groupDelta = (CustomContactListFilterActivity.GroupDelta) getChild(i10, i11);
            if (groupDelta != null) {
                CheckBox e10 = aVar.e();
                if (e10 != null) {
                    e10.setVisibility(0);
                }
                CheckBox e11 = aVar.e();
                if (e11 != null) {
                    e11.setChecked(groupDelta.A0());
                }
                CheckBox e12 = aVar.e();
                if (e12 != null) {
                    e12.jumpDrawablesToCurrentState();
                }
                C.b(aVar.itemView, groupDelta.A0());
                CharSequence C02 = groupDelta.C0(this.f16875a);
                if (TextUtils.equals("Vip in ColorOS", C02)) {
                    C02 = this.f16875a.getResources().getString(R.string.oplus_vip_group);
                }
                if (TextUtils.equals("Business Card in ColorOS", C02)) {
                    C02 = this.f16875a.getResources().getString(R.string.oplus_business_card);
                }
                TextView f10 = aVar.f();
                if (f10 != null) {
                    f10.setText(C02);
                }
                TextView f11 = aVar.f();
                if (f11 != null) {
                    f11.setPaddingRelative(0, 0, 0, 0);
                }
            } else {
                CheckBox e13 = aVar.e();
                if (e13 != null) {
                    e13.setVisibility(8);
                }
                TextView f12 = aVar.f();
                if (f12 != null) {
                    f12.setText(R.string.display_more_groups);
                }
                TextView f13 = aVar.f();
                if (f13 != null) {
                    f13.setPaddingRelative(this.f16875a.getResources().getDimensionPixelSize(R.dimen.padding_left), 0, 0, 0);
                }
                C.b(aVar.itemView, false);
            }
            aVar.itemView.jumpDrawablesToCurrentState();
        }
    }

    @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
    public void onBindGroupView(final int i10, boolean z10, RecyclerView.B b10) {
        String c10;
        if (b10 instanceof C0171b) {
            final C0171b c0171b = (C0171b) b10;
            COUICheckBox g10 = c0171b.g();
            if (g10 != null) {
                g10.setOnClickListener(new View.OnClickListener() { // from class: m1.E
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        com.android.contacts.list.b.d(b.C0171b.this, this, i10, view);
                    }
                });
            }
            Object group = getGroup(i10);
            i.d(group, "null cannot be cast to non-null type com.android.contacts.list.CustomContactListFilterActivity.AccountDisplay");
            CustomContactListFilterActivity.a aVar = (CustomContactListFilterActivity.a) group;
            AccountType c11 = this.f16877c.c(aVar.f16857b, aVar.f16858c);
            String str = aVar.f16856a;
            boolean z11 = true;
            int i11 = 8;
            if (TextUtils.equals(R0.a.f3166b, aVar.f16857b)) {
                str = this.f16875a.getResources().getString(R.string.contact_editor_account_storage_phone);
                TextView f10 = c0171b.f();
                if (f10 != null) {
                    f10.setVisibility(8);
                }
            } else if (TextUtils.equals(aVar.f16857b, "com.android.oplus.sim")) {
                int j10 = com.customize.contacts.simcontacts.b.j(aVar.f16856a);
                if (b0.m0(this.f16875a, 0) && b0.m0(this.f16875a, 1)) {
                    c10 = com.customize.contacts.simcontacts.b.f(this.f16875a, j10);
                } else {
                    c10 = com.customize.contacts.simcontacts.b.c(this.f16875a);
                }
                str = c10;
                TextView f11 = c0171b.f();
                if (f11 != null) {
                    f11.setVisibility(8);
                }
            } else {
                TextView f12 = c0171b.f();
                if (f12 != null) {
                    f12.setVisibility(0);
                }
            }
            TextView e10 = c0171b.e();
            if (e10 != null) {
                e10.setText(str);
            }
            TextView e11 = c0171b.e();
            if (e11 != null) {
                if (str != null) {
                    i11 = 0;
                }
                e11.setVisibility(i11);
            }
            TextView f13 = c0171b.f();
            if (f13 != null) {
                f13.setText(c11.f(this.f16875a));
            }
            int c12 = c(i10);
            COUICheckBox g11 = c0171b.g();
            if (g11 != null) {
                g11.setState(c12);
            }
            View view = c0171b.itemView;
            if (c12 == 0) {
                z11 = false;
            }
            C.b(view, z11);
            c0171b.itemView.jumpDrawablesToCurrentState();
            COUICheckBox g12 = c0171b.g();
            if (g12 != null) {
                g12.jumpDrawablesToCurrentState();
            }
        }
    }

    @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
    public RecyclerView.B onCreateChildView(ViewGroup viewGroup, int i10) {
        View inflate = LayoutInflater.from(this.f16875a).inflate(R.layout.filter_list_item_child, viewGroup, false);
        i.e(inflate, "from(context).inflate(R.…tem_child, parent, false)");
        return new a(this, inflate);
    }

    @Override // com.coui.appcompat.expandable.COUIExpandableRecyclerAdapter
    public RecyclerView.B onCreateGroupView(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        View inflate = LayoutInflater.from(this.f16875a).inflate(R.layout.filter_list_item_group, parent, false);
        i.e(inflate, "from(context).inflate(R.…tem_group, parent, false)");
        return new C0171b(this, inflate);
    }
}

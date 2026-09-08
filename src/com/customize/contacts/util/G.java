package com.customize.contacts.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.widget.CheckBox;
import androidx.fragment.app.Fragment;
import com.android.contacts.group.GroupBrowserActivityFragment;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: GroupsEditModeHandler.java */
/* loaded from: classes3.dex */
public class G {

    /* renamed from: a, reason: collision with root package name */
    public GroupBrowserActivityFragment f21878a;

    /* renamed from: b, reason: collision with root package name */
    public Activity f21879b;

    /* renamed from: d, reason: collision with root package name */
    public com.android.contacts.group.c f21881d;

    /* renamed from: m, reason: collision with root package name */
    public Z3.h f21890m;

    /* renamed from: c, reason: collision with root package name */
    public boolean f21880c = false;

    /* renamed from: e, reason: collision with root package name */
    public long[] f21882e = null;

    /* renamed from: f, reason: collision with root package name */
    public Cursor f21883f = null;

    /* renamed from: g, reason: collision with root package name */
    public List<com.android.contacts.group.j> f21884g = null;

    /* renamed from: h, reason: collision with root package name */
    public HashSet<Long> f21885h = null;

    /* renamed from: i, reason: collision with root package name */
    public int f21886i = 0;

    /* renamed from: j, reason: collision with root package name */
    public Dialog f21887j = null;

    /* renamed from: k, reason: collision with root package name */
    public String f21888k = null;

    /* renamed from: l, reason: collision with root package name */
    public int f21889l = 0;

    /* renamed from: n, reason: collision with root package name */
    public boolean f21891n = false;

    /* compiled from: GroupsEditModeHandler.java */
    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            G.this.m();
            G g10 = G.this;
            g10.doDeleteGroupAndRemoveGroupMember(g10.f21882e);
        }

        public a() {
        }
    }

    public G(Fragment fragment, com.android.contacts.group.c cVar, Z3.h hVar) {
        this.f21881d = null;
        GroupBrowserActivityFragment groupBrowserActivityFragment = (GroupBrowserActivityFragment) fragment;
        this.f21878a = groupBrowserActivityFragment;
        this.f21879b = groupBrowserActivityFragment.getActivity();
        this.f21881d = cVar;
        this.f21890m = hVar;
    }

    public long[] b(HashSet<Long> hashSet) {
        long[] jArr = new long[hashSet.size()];
        Iterator<Long> it = hashSet.iterator();
        int i10 = -1;
        while (it.hasNext()) {
            i10++;
            jArr[i10] = it.next().longValue();
        }
        return jArr;
    }

    public int c() {
        return this.f21886i;
    }

    public String d() {
        int c10 = c();
        if (c10 == 0) {
            return this.f21879b.getString(R.string.select_item);
        }
        if (this.f21888k == null) {
            this.f21888k = this.f21879b.getString(R.string.select_items);
        }
        return String.format(this.f21888k, Integer.valueOf(U7.a.b(c10)));
    }

    public void doDeleteGroupAndRemoveGroupMember(long[] jArr) {
        Intent intent = new Intent("com.oplus.contacts.ui.DELELE_AND_REMOVE_GROUP");
        intent.putExtra("DELETE_AND_REMOVE_GROUP", jArr);
        intent.setPackage(C7.e.g());
        R7.b.c(this.f21879b, intent);
    }

    public final int e() {
        List<com.android.contacts.group.j> list = this.f21884g;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public boolean f(long j10) {
        HashSet<Long> hashSet = this.f21885h;
        if (hashSet == null) {
            this.f21885h = new HashSet<>();
            return false;
        }
        return hashSet.contains(Long.valueOf(j10));
    }

    public boolean g() {
        return this.f21891n;
    }

    public boolean h() {
        return this.f21880c;
    }

    public void i() {
        if (!this.f21880c) {
            o(true);
            this.f21880c = true;
        } else {
            o(false);
            this.f21880c = false;
        }
    }

    public final void j() {
        u();
        this.f21881d.notifyDataSetChanged();
    }

    public void k(CheckBox checkBox, boolean z10) {
        if (g() && checkBox != null && checkBox.getTag() != null) {
            long d10 = ((com.android.contacts.group.j) checkBox.getTag()).d();
            if (z10) {
                p(d10, !f(d10));
            } else {
                r(d10, checkBox.isChecked());
            }
        }
    }

    public void l() {
        i();
    }

    public void m() {
        this.f21890m.c();
        o(false);
    }

    public void n(boolean z10) {
        if (this.f21884g.size() <= 0) {
            com.oplus.foundation.util.ui.c.b(this.f21879b, R.string.oplus_group_is_not_exist);
            return;
        }
        HashSet<Long> hashSet = this.f21885h;
        if (hashSet != null && hashSet.size() > 0) {
            long[] b10 = b(this.f21885h);
            this.f21882e = b10;
            t(b10.length);
            return;
        }
        com.oplus.foundation.util.ui.c.b(this.f21879b, R.string.oplus_please_select_group);
    }

    public void o(boolean z10) {
        int size;
        if (this.f21885h == null) {
            this.f21885h = new HashSet<>();
        }
        this.f21885h.clear();
        List<com.android.contacts.group.j> list = this.f21884g;
        int i10 = 0;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        if (size == 0) {
            return;
        }
        if (z10) {
            for (int i11 = 0; i11 < size; i11++) {
                this.f21885h.add(Long.valueOf(this.f21884g.get(i11).d()));
            }
        }
        if (z10) {
            i10 = size;
        }
        this.f21886i = i10;
        j();
    }

    public void p(long j10, boolean z10) {
        HashSet<Long> hashSet = this.f21885h;
        if (hashSet == null) {
            this.f21885h = new HashSet<>();
            return;
        }
        if (z10) {
            hashSet.add(Long.valueOf(j10));
            this.f21886i++;
        } else {
            hashSet.remove(Long.valueOf(j10));
            this.f21886i--;
        }
        j();
    }

    public void q(boolean z10) {
        this.f21891n = z10;
    }

    public final void r(long j10, boolean z10) {
        if (z10) {
            if (!this.f21885h.contains(Long.valueOf(j10))) {
                this.f21885h.add(Long.valueOf(j10));
                this.f21886i++;
            }
        } else if (this.f21885h.contains(Long.valueOf(j10))) {
            this.f21885h.remove(Long.valueOf(j10));
            this.f21886i--;
        }
        u();
    }

    public void s(int i10) {
        this.f21889l = i10;
    }

    public final void t(int i10) {
        String c10 = X.c(this.f21879b, i10, e());
        U0.b bVar = new U0.b(this.f21879b, 2132083073);
        bVar.setTitle((CharSequence) c10).setNeutralButton(X.a(i10, e()), (DialogInterface.OnClickListener) new a()).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null);
        androidx.appcompat.app.b show = bVar.show();
        this.f21887j = show;
        U0.n.d(show);
        if (CommonFeatureOption.o(this.f21879b)) {
            U0.m.a(bVar);
        }
    }

    public void u() {
        if (c() == e()) {
            this.f21880c = true;
        } else {
            this.f21880c = false;
        }
        if (this.f21891n) {
            if (c() == 0) {
                this.f21878a.q3(false, true);
            } else {
                this.f21878a.q3(true, true);
            }
            this.f21890m.d();
        }
    }

    public void v(List<com.android.contacts.group.j> list) {
        this.f21884g = list;
        if (this.f21885h == null) {
            this.f21885h = new HashSet<>();
        }
        int size = this.f21884g.size();
        if (H7.a.b()) {
            H7.b.b("GroupsActionModeHandler", "count = " + size);
        }
        HashSet hashSet = new HashSet();
        if (this.f21885h.size() > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                long d10 = list.get(i10).d();
                if (this.f21885h.contains(Long.valueOf(d10))) {
                    hashSet.add(Long.valueOf(d10));
                }
            }
        }
        this.f21885h.clear();
        this.f21885h.addAll(hashSet);
        hashSet.clear();
    }
}

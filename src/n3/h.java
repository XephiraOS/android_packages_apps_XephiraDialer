package N3;

import U0.l;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.baseui.util.B;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.util.C;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.widget.p;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: GroupSelectDialog.java */
/* loaded from: classes3.dex */
public class h extends l implements Y0.b, w7.b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2336a;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet<Integer> f2337b;

    /* renamed from: c, reason: collision with root package name */
    public final HashSet<Integer> f2338c;

    /* renamed from: d, reason: collision with root package name */
    public f f2339d;

    /* renamed from: e, reason: collision with root package name */
    public final List<a> f2340e;

    /* renamed from: f, reason: collision with root package name */
    public final EntityDelta f2341f;

    /* renamed from: g, reason: collision with root package name */
    public final p.a f2342g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList<EntityDelta.ValuesDelta> f2343h;

    /* renamed from: i, reason: collision with root package name */
    public Long f2344i;

    /* compiled from: GroupSelectDialog.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f2345a;

        /* renamed from: b, reason: collision with root package name */
        public String f2346b;

        /* renamed from: c, reason: collision with root package name */
        public EntityDelta.ValuesDelta f2347c = null;

        public String toString() {
            return this.f2346b + this.f2345a;
        }
    }

    public h(Context context, EntityDelta entityDelta, List<a> list, int i10, p.a aVar) {
        super(context, i10);
        this.f2337b = new HashSet<>();
        this.f2338c = new HashSet<>();
        this.f2343h = new ArrayList<>();
        B.c(context, getWindow(), 3);
        this.f2341f = entityDelta;
        this.f2342g = aVar;
        this.f2343h = entityDelta.D("vnd.android.cursor.item/group_membership");
        ArrayList arrayList = new ArrayList(list);
        this.f2340e = arrayList;
        this.f2336a = context;
        a aVar2 = new a();
        aVar2.f2345a = -2;
        aVar2.f2346b = c(R.string.oplus_create_new_group);
        arrayList.add(aVar2);
    }

    private String c(int i10) {
        return getContext().getString(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean d(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.save) {
            int f10 = f();
            HashMap hashMap = new HashMap();
            hashMap.put("selected_count", Integer.valueOf(f10));
            A.a(this.f2336a, 2000310, 200030080, hashMap, false);
            dismiss();
            return true;
        }
        if (menuItem.getItemId() == R.id.cancel) {
            int size = this.f2340e.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size - 2; i11++) {
                if (this.f2337b.contains(Integer.valueOf(i11))) {
                    i10++;
                }
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("selected_count", Integer.valueOf(i10));
            A.a(this.f2336a, 2000310, 200030079, hashMap2, false);
            dismiss();
            return true;
        }
        return true;
    }

    @Override // w7.b
    public void K(int i10, int i11, List<? extends View> list) {
        for (View view : list) {
            Object tag = view.getTag(R.id.group_list_item_position);
            if (tag instanceof Integer) {
                g(view, ((Integer) tag).intValue());
            }
        }
    }

    @Override // w7.b
    public boolean Z0(View view, int i10) {
        return g(view, i10);
    }

    public final void e(EntityDelta.ValuesDelta valuesDelta) {
        int intValue = valuesDelta.v("data1").intValue();
        Iterator<EntityDelta.ValuesDelta> it = this.f2343h.iterator();
        while (it.hasNext()) {
            EntityDelta.ValuesDelta next = it.next();
            if (next.w("data1", -1).intValue() == intValue) {
                next.Y();
            }
        }
    }

    public final int f() {
        int size = this.f2340e.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            a aVar = this.f2340e.get(i11);
            boolean contains = this.f2337b.contains(Integer.valueOf(i11));
            EntityDelta.ValuesDelta valuesDelta = aVar.f2347c;
            if (valuesDelta != null) {
                if (contains) {
                    i10++;
                    valuesDelta.b0("data1", aVar.f2345a);
                    valuesDelta.e0("mimetype", "vnd.android.cursor.item/group_membership");
                    Long l10 = this.f2344i;
                    if (l10 != null && -1 != l10.longValue()) {
                        valuesDelta.d0("raw_contact_id", this.f2344i.longValue());
                    }
                } else {
                    e(valuesDelta);
                }
            } else if (contains) {
                i10++;
                ContentValues contentValues = new ContentValues(2);
                contentValues.put("data1", Integer.valueOf(aVar.f2345a));
                contentValues.put("mimetype", "vnd.android.cursor.item/group_membership");
                EntityDelta.ValuesDelta m10 = EntityDelta.ValuesDelta.m(contentValues);
                Long l11 = this.f2344i;
                if (l11 != null && -1 != l11.longValue()) {
                    m10.d0("raw_contact_id", this.f2344i.longValue());
                }
                this.f2341f.d(m10);
            } else if (H7.a.b()) {
                H7.b.b("GroupSelectDialog", "onClick, there is no change in this value");
            }
        }
        return i10;
    }

    public boolean g(View view, int i10) {
        CheckBox checkBox;
        if (view == null || (checkBox = (CheckBox) view.findViewById(R.id.check_box)) == null || checkBox.getVisibility() == 8) {
            return false;
        }
        boolean z10 = !checkBox.isChecked();
        checkBox.setChecked(z10);
        if (z10) {
            this.f2337b.add(Integer.valueOf(i10));
            this.f2338c.remove(Integer.valueOf(i10));
        } else {
            this.f2337b.remove(Integer.valueOf(i10));
            this.f2338c.add(Integer.valueOf(i10));
        }
        C.b(view, z10);
        return true;
    }

    public final void h() {
        int i10 = 0;
        for (a aVar : this.f2340e) {
            EntityDelta.ValuesDelta valuesDelta = aVar.f2347c;
            if (valuesDelta != null && !valuesDelta.H()) {
                Integer v10 = aVar.f2347c.v("data1");
                if (v10 != null && v10.intValue() == aVar.f2345a && !this.f2338c.contains(Integer.valueOf(i10))) {
                    this.f2337b.add(Integer.valueOf(i10));
                } else {
                    H7.b.i("GroupSelectDialog", "onSetInitChecked(), this should never happen");
                }
            }
            i10++;
        }
        this.f2339d.notifyDataSetChanged();
    }

    public void i(List<a> list, int i10) {
        this.f2340e.clear();
        this.f2340e.addAll(list);
        a aVar = new a();
        aVar.f2345a = -2;
        aVar.f2346b = c(R.string.oplus_create_new_group);
        this.f2337b.add(Integer.valueOf(i10));
        this.f2340e.add(aVar);
        h();
    }

    public void j(Long l10) {
        this.f2344i = l10;
    }

    @Override // androidx.appcompat.app.i, androidx.activity.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        LayoutInflater layoutInflater = getLayoutInflater();
        View b10 = B.b(this.f2336a, false);
        setContentView(b10);
        ViewGroup viewGroup = (ViewGroup) b10.getParent();
        View inflate = layoutInflater.inflate(R.layout.group_select_dlg_view, viewGroup, false);
        ((CoordinatorLayout) inflate.findViewById(R.id.coordinator)).setStatusBarBackgroundResource(2131231683);
        HeaderFooterRecyclerView headerFooterRecyclerView = (HeaderFooterRecyclerView) inflate.findViewById(R.id.group_select_dlg_list);
        headerFooterRecyclerView.setNestedScrollingEnabled(true);
        headerFooterRecyclerView.setLayoutManager(new LinearLayoutManager(this.f2336a));
        C.c(this.f2336a, headerFooterRecyclerView, 0);
        COUIToolbar cOUIToolbar = (COUIToolbar) inflate.findViewById(R.id.toolbar);
        cOUIToolbar.setTitle(R.string.oplus_contact_edit_select_group);
        cOUIToolbar.inflateMenu(R.menu.cancel_save_menu);
        cOUIToolbar.setIsTitleCenterStyle(true);
        cOUIToolbar.setOnMenuItemClickListener(new Toolbar.g() { // from class: N3.g
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean d10;
                d10 = h.this.d(menuItem);
                return d10;
            }
        });
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = B.a(this.f2336a);
        viewGroup.addView(inflate, 0, layoutParams);
        f fVar = new f(this.f2336a, this.f2340e, this, this.f2337b);
        this.f2339d = fVar;
        headerFooterRecyclerView.setAdapter(fVar);
        headerFooterRecyclerView.setDragSelectListener(this);
        headerFooterRecyclerView.i(this.f2336a.getResources().getDimensionPixelSize(R.dimen.DP_60), 0, 0, 0);
        h();
        super.onCreate(bundle);
    }

    @Override // Y0.b
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        if (view == null) {
            return;
        }
        if (i10 == this.f2340e.size() - 1) {
            this.f2337b.add(Integer.valueOf(i10));
            this.f2342g.c();
            C.b(view, false);
            return;
        }
        g(view, i10);
    }

    @Override // Y0.b
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        return false;
    }

    @Override // w7.b
    public void T() {
    }

    @Override // w7.b
    public void p0() {
    }
}

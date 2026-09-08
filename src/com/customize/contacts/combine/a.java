package com.customize.contacts.combine;

import Z0.b;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.contacts.ContactsApplication;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.util.C;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.customize.contacts.util.U;
import com.oplus.dialer.R;
import java.util.ArrayList;

/* compiled from: MergeContactsListAdapter.java */
/* loaded from: classes3.dex */
public class a extends ArrayAdapter {

    /* renamed from: a, reason: collision with root package name */
    public int f20923a;

    /* renamed from: b, reason: collision with root package name */
    public c f20924b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<View> f20925c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<View> f20926d;

    /* renamed from: e, reason: collision with root package name */
    public Context f20927e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<G3.b> f20928f;

    /* renamed from: g, reason: collision with root package name */
    public Z0.b f20929g;

    /* renamed from: h, reason: collision with root package name */
    public int f20930h;

    /* renamed from: i, reason: collision with root package name */
    public int f20931i;

    /* compiled from: MergeContactsListAdapter.java */
    /* renamed from: com.customize.contacts.combine.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class ViewOnClickListenerC0201a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f20932a;

        public ViewOnClickListenerC0201a(d dVar) {
            this.f20932a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((G3.b) a.this.f20928f.get(((Integer) this.f20932a.f20940e.getTag()).intValue())).f1102l = this.f20932a.f20940e.isChecked();
            d dVar = this.f20932a;
            C.b(dVar.f20942g, dVar.f20940e.isChecked());
            a.this.f20924b.a();
        }
    }

    /* compiled from: MergeContactsListAdapter.java */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f20934a;

        public b(d dVar) {
            this.f20934a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f20924b.s(((Integer) this.f20934a.f20941f.getTag()).intValue());
            A.a(a.this.f20927e, 2000317, 200030166, null, false);
        }
    }

    /* compiled from: MergeContactsListAdapter.java */
    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void s(int i10);
    }

    /* compiled from: MergeContactsListAdapter.java */
    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f20936a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f20937b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f20938c;

        /* renamed from: d, reason: collision with root package name */
        public LinearLayout f20939d;

        /* renamed from: e, reason: collision with root package name */
        public CheckBox f20940e;

        /* renamed from: f, reason: collision with root package name */
        public TextView f20941f;

        /* renamed from: g, reason: collision with root package name */
        public COUICardListSelectedItemLayout f20942g;

        /* renamed from: h, reason: collision with root package name */
        public View f20943h;

        /* renamed from: i, reason: collision with root package name */
        public View f20944i;
    }

    public a(Context context, int i10, ArrayList<G3.b> arrayList) {
        super(context, i10);
        this.f20923a = 0;
        this.f20925c = new ArrayList<>();
        this.f20926d = new ArrayList<>();
        this.f20929g = null;
        this.f20930h = -1;
        this.f20931i = -1;
        this.f20928f = arrayList;
        this.f20927e = context;
        this.f20929g = Z0.b.g(context);
        this.f20930h = this.f20927e.getResources().getDimensionPixelSize(R.dimen.DP_20);
        this.f20931i = this.f20927e.getResources().getDimensionPixelSize(R.dimen.DP_12);
    }

    public void d() {
        this.f20925c.clear();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public G3.b getItem(int i10) {
        return this.f20928f.get(i10);
    }

    public void f() {
        Z0.b bVar = this.f20929g;
        if (bVar != null) {
            bVar.r();
        }
    }

    public void g() {
        Z0.b bVar = this.f20929g;
        if (bVar != null) {
            bVar.w();
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        ArrayList<G3.b> arrayList = this.f20928f;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        int i11;
        View view2;
        int i12;
        int i13;
        long j10;
        LayoutInflater layoutInflater;
        b.c cVar;
        boolean z10 = false;
        View inflate = view == null ? LayoutInflater.from(this.f20927e).inflate(R.layout.merge_contacts_list_item, viewGroup, false) : view;
        d dVar = new d();
        View findViewById = inflate.findViewById(R.id.main_view);
        dVar.f20936a = (ImageView) findViewById.findViewById(R.id.quick_contact_photo);
        dVar.f20937b = (TextView) findViewById.findViewById(R.id.name);
        dVar.f20938c = (TextView) findViewById.findViewById(R.id.number);
        dVar.f20940e = (CheckBox) inflate.findViewById(R.id.check);
        dVar.f20941f = (TextView) inflate.findViewById(R.id.manual_merge);
        dVar.f20939d = (LinearLayout) inflate.findViewById(R.id.attach_view);
        dVar.f20942g = (COUICardListSelectedItemLayout) inflate.findViewById(R.id.cardItem);
        int i14 = R.id.bottom_divider;
        dVar.f20943h = inflate.findViewById(R.id.bottom_divider);
        dVar.f20944i = inflate.findViewById(R.id.name_and_number);
        G3.b bVar = this.f20928f.get(i10);
        dVar.f20937b.setText(bVar.f1093c);
        int i15 = 8;
        if (TextUtils.isEmpty(bVar.f1095e)) {
            dVar.f20938c.setVisibility(8);
            View view3 = dVar.f20944i;
            int i16 = this.f20930h;
            view3.setPaddingRelative(0, i16, 0, i16);
        } else {
            View view4 = dVar.f20944i;
            int i17 = this.f20931i;
            view4.setPaddingRelative(0, i17, 0, i17);
            dVar.f20938c.setVisibility(0);
            dVar.f20938c.setText(bVar.f1095e);
            if (ContactsApplication.f13094j) {
                dVar.f20938c.setTextDirection(3);
                dVar.f20938c.setGravity(5);
            }
        }
        if (U.d()) {
            dVar.f20936a.setVisibility(0);
            if (this.f20929g != null) {
                this.f20929g.q(dVar.f20936a, bVar.f1097g, false, false, bVar.f1097g <= 0 ? new b.c(bVar.f1093c, String.valueOf(bVar.f1091a), false) : null);
            }
        } else {
            dVar.f20936a.setVisibility(8);
        }
        dVar.f20939d.removeAllViews();
        int size = this.f20925c.size();
        int size2 = bVar.f1101k.size();
        this.f20926d.clear();
        if (H7.a.b()) {
            H7.b.b("MergeContactsListAdp", "viewCount = " + size + ", mergeCount = " + size2);
        }
        LayoutInflater from = LayoutInflater.from(this.f20927e);
        int i18 = 0;
        int i19 = 0;
        while (i18 < size2) {
            int i20 = i19;
            while (true) {
                if (i20 >= size) {
                    view2 = null;
                    break;
                }
                view2 = this.f20925c.get(i20);
                if (!this.f20926d.contains(view2) && view2.getParent() == null) {
                    break;
                }
                if (!this.f20926d.contains(view2) && view2.getParent().getParent().getParent() == null) {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                    break;
                }
                i20++;
            }
            if (view2 == null) {
                view2 = from.inflate(R.layout.merge_attach_view, (ViewGroup) dVar.f20939d, false);
                this.f20925c.add(view2);
            }
            if (i18 == size2 - 1) {
                int i21 = this.f20923a;
                if (i21 == 0) {
                    view2.findViewById(i14).setVisibility(i15);
                } else if (i21 == 2) {
                    view2.findViewById(i14).setVisibility(0);
                }
            } else {
                view2.findViewById(i14).setVisibility(0);
            }
            View findViewById2 = view2.findViewById(R.id.name_and_number);
            G3.a aVar = bVar.f1101k.get(i18);
            ((TextView) view2.findViewById(R.id.name)).setText(aVar.f1093c);
            if (TextUtils.isEmpty(aVar.f1095e)) {
                int i22 = this.f20930h;
                findViewById2.setPaddingRelative(0, i22, 0, i22);
                ((TextView) view2.findViewById(R.id.number)).setVisibility(8);
                i12 = R.id.quick_contact_photo;
            } else {
                int i23 = this.f20931i;
                findViewById2.setPaddingRelative(0, i23, 0, i23);
                TextView textView = (TextView) view2.findViewById(R.id.number);
                textView.setVisibility(0);
                textView.setText(aVar.f1095e);
                if (ContactsApplication.f13094j) {
                    textView.setTextDirection(3);
                    textView.setGravity(5);
                }
                i12 = R.id.quick_contact_photo;
            }
            ImageView imageView = (ImageView) view2.findViewById(i12);
            if (U.d()) {
                imageView.setVisibility(0);
                i13 = i20;
                if (this.f20929g != null) {
                    j10 = 0;
                    if (aVar.f1097g <= 0) {
                        layoutInflater = from;
                        cVar = new b.c(aVar.f1093c, String.valueOf(aVar.f1091a), false);
                    } else {
                        layoutInflater = from;
                        cVar = null;
                    }
                    this.f20929g.q(imageView, aVar.f1097g, false, false, cVar);
                } else {
                    j10 = 0;
                    layoutInflater = from;
                }
            } else {
                i13 = i20;
                j10 = 0;
                layoutInflater = from;
                imageView.setVisibility(8);
            }
            dVar.f20939d.addView(view2);
            this.f20926d.add(view2);
            i18++;
            i19 = i13;
            from = layoutInflater;
            i14 = R.id.bottom_divider;
            i15 = 8;
        }
        int i24 = this.f20923a;
        if (i24 == 0) {
            dVar.f20941f.setVisibility(8);
            if (size2 > 0) {
                dVar.f20940e.setVisibility(0);
                dVar.f20940e.setChecked(bVar.f1102l);
                dVar.f20940e.setTag(Integer.valueOf(i10));
                dVar.f20940e.setOnClickListener(new ViewOnClickListenerC0201a(dVar));
                i11 = 8;
            } else {
                i11 = 8;
                dVar.f20940e.setVisibility(8);
            }
            if (size2 == 0) {
                dVar.f20943h.setVisibility(i11);
            }
        } else if (1 == i24 || 3 == i24) {
            dVar.f20941f.setVisibility(8);
            dVar.f20943h.setVisibility(8);
            dVar.f20940e.setVisibility(8);
        } else if (2 == i24) {
            dVar.f20940e.setVisibility(8);
            if (size2 > 0) {
                dVar.f20941f.setVisibility(0);
                dVar.f20943h.setVisibility(0);
                dVar.f20941f.setTag(Integer.valueOf(i10));
                dVar.f20941f.setOnClickListener(new b(dVar));
            } else {
                dVar.f20941f.setVisibility(8);
                dVar.f20943h.setVisibility(8);
            }
        }
        inflate.setClickable(false);
        inflate.setFocusable(false);
        COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = dVar.f20942g;
        if (dVar.f20940e.getVisibility() == 0 && dVar.f20940e.isChecked()) {
            z10 = true;
        }
        C.b(cOUICardListSelectedItemLayout, z10);
        return inflate;
    }

    public void h(c cVar) {
        this.f20924b = cVar;
    }

    public void i(int i10) {
        if (i10 > 3) {
            i10 = 0;
        }
        this.f20923a = i10;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i10) {
        return false;
    }

    public void j() {
    }
}

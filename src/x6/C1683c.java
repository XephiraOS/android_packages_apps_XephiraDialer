package x6;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.r;
import com.oplus.utils.Z;
import java.util.ArrayList;
import x6.C1681a;

/* compiled from: PhoneNoInquireForCountrySelectAdapter.java */
/* renamed from: x6.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1683c extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public LayoutInflater f38035a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<C1681a.c> f38036b = new ArrayList<>();

    /* compiled from: PhoneNoInquireForCountrySelectAdapter.java */
    /* renamed from: x6.c$a */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f38037a;

        public a(int i10) {
            this.f38037a = i10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1681a.c item = C1683c.this.getItem(this.f38037a);
            if (item != null) {
                if (item.c().equals("OTHERS")) {
                    item.f(!item.e());
                    C1681a.p(item);
                    if (!item.e()) {
                        C1681a.i();
                    } else {
                        C1681a.q();
                    }
                } else {
                    item.f(!item.e());
                    C1681a.s(item);
                }
            }
            C1683c.this.notifyDataSetChanged();
        }
    }

    /* compiled from: PhoneNoInquireForCountrySelectAdapter.java */
    /* renamed from: x6.c$b */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public TextView f38039a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f38040b;

        /* renamed from: c, reason: collision with root package name */
        public CheckBox f38041c;

        /* renamed from: d, reason: collision with root package name */
        public View f38042d;
    }

    public C1683c(Context context) {
        this.f38035a = LayoutInflater.from(context);
    }

    public void a(ArrayList<C1681a.c> arrayList) {
        this.f38036b.addAll(0, arrayList);
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1681a.c getItem(int i10) {
        if (this.f38036b.size() <= 0) {
            return null;
        }
        return this.f38036b.get(i10);
    }

    public void c(ArrayList<C1681a.c> arrayList) {
        this.f38036b = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f38036b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        b bVar;
        C1681a.c item = getItem(i10);
        if (item == null) {
            return null;
        }
        if (view == null) {
            view = this.f38035a.inflate(r.f27441M, viewGroup, false);
            bVar = new b();
            bVar.f38039a = (TextView) view.findViewById(p.f27418v);
            bVar.f38040b = (TextView) view.findViewById(p.f27407p0);
            bVar.f38041c = (CheckBox) view.findViewById(p.f27370X);
            bVar.f38042d = view.findViewById(p.f27390h);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (!TextUtils.isEmpty(item.d())) {
            bVar.f38039a.setText(item.d());
        }
        if (item.c().equals("OTHERS")) {
            bVar.f38039a.setPadding(0, 0, 0, 0);
            bVar.f38040b.setVisibility(0);
        } else {
            bVar.f38039a.setPadding(0, 4, 0, 0);
            bVar.f38040b.setVisibility(8);
        }
        if (i10 == getCount() - 1) {
            bVar.f38042d.setVisibility(8);
        } else {
            bVar.f38042d.setVisibility(0);
        }
        bVar.f38041c.setChecked(item.e());
        C1681a.c item2 = getItem(0);
        if (item2 != null && item2.e()) {
            if (i10 == 0) {
                bVar.f38041c.setEnabled(true);
                TextView textView = bVar.f38039a;
                textView.setTextColor(textView.getTextColors().withAlpha(255));
            } else {
                bVar.f38041c.setEnabled(false);
                bVar.f38041c.setChecked(false);
                TextView textView2 = bVar.f38039a;
                textView2.setTextColor(textView2.getTextColors().withAlpha(77));
                item.f(false);
            }
        } else {
            bVar.f38041c.setEnabled(true);
            TextView textView3 = bVar.f38039a;
            textView3.setTextColor(textView3.getTextColors().withAlpha(255));
        }
        Z.a(view, bVar.f38041c.isChecked());
        bVar.f38041c.setOnClickListener(new a(i10));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i10) {
        if (this.f38036b.get(0).e()) {
            if (i10 != 0) {
                return false;
            }
            return true;
        }
        return super.isEnabled(i10);
    }
}

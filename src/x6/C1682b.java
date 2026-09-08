package x6;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.oplus.blacklistapp.BlackListAppUtil;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.r;
import com.oplus.utils.AnimationAnimationListenerC0842c;
import com.oplus.utils.Z;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import x6.C1681a;

/* compiled from: PhoneNoInquireForCountryAdapter.java */
/* renamed from: x6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1682b extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public boolean f38021a;

    /* renamed from: b, reason: collision with root package name */
    public final LayoutInflater f38022b;

    /* renamed from: d, reason: collision with root package name */
    public final Context f38024d;

    /* renamed from: g, reason: collision with root package name */
    public boolean f38027g;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<C1681a.c> f38023c = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public boolean f38025e = true;

    /* renamed from: f, reason: collision with root package name */
    public ConcurrentHashMap<Integer, C1681a.c> f38026f = new ConcurrentHashMap<>();

    /* compiled from: PhoneNoInquireForCountryAdapter.java */
    /* renamed from: x6.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0380b {

        /* renamed from: a, reason: collision with root package name */
        public TextView f38031a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f38032b;

        /* renamed from: c, reason: collision with root package name */
        public CheckBox f38033c;

        /* renamed from: d, reason: collision with root package name */
        public View f38034d;
    }

    public C1682b(Context context, boolean z10) {
        this.f38022b = LayoutInflater.from(context);
        this.f38021a = z10;
        this.f38024d = context;
    }

    public final void b(boolean z10, CheckBox checkBox) {
        a aVar = new a(z10, checkBox);
        if (z10) {
            if (!BlackListAppUtil.f26245b) {
                AnimationAnimationListenerC0842c.l(this.f38024d, null, 0).r(false, aVar, checkBox);
                return;
            } else {
                AnimationAnimationListenerC0842c.j(this.f38024d, null, 0).r(false, aVar, checkBox);
                return;
            }
        }
        if (!BlackListAppUtil.f26245b) {
            AnimationAnimationListenerC0842c.m(this.f38024d, null, 8).r(false, aVar, checkBox);
        } else {
            AnimationAnimationListenerC0842c.k(this.f38024d, null, 8).r(false, aVar, checkBox);
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C1681a.c getItem(int i10) {
        if (this.f38023c.size() <= 0 || i10 >= this.f38023c.size()) {
            return null;
        }
        return this.f38023c.get(i10);
    }

    public void d(boolean z10) {
        this.f38021a = z10;
    }

    public void e(ArrayList<C1681a.c> arrayList) {
        this.f38023c = arrayList;
    }

    public void f(boolean z10) {
        this.f38027g = z10;
    }

    public void g(ConcurrentHashMap<Integer, C1681a.c> concurrentHashMap) {
        this.f38026f = concurrentHashMap;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f38023c.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        C0380b c0380b;
        C1681a.c item = getItem(i10);
        if (view == null) {
            view = this.f38022b.inflate(r.f27439K, viewGroup, false);
            c0380b = new C0380b();
            c0380b.f38031a = (TextView) view.findViewById(p.f27418v);
            c0380b.f38032b = (TextView) view.findViewById(p.f27407p0);
            c0380b.f38033c = (CheckBox) view.findViewById(p.f27370X);
            c0380b.f38034d = view.findViewById(p.f27390h);
            view.setTag(c0380b);
        } else {
            c0380b = (C0380b) view.getTag();
        }
        if (item == null) {
            return view;
        }
        if (!TextUtils.isEmpty(item.d())) {
            c0380b.f38031a.setText(item.d());
        }
        c0380b.f38031a.setEnabled(this.f38027g);
        if (item.f38012a.equals("OTHERS")) {
            c0380b.f38031a.setPadding(0, 0, 0, 0);
            c0380b.f38032b.setVisibility(0);
            c0380b.f38032b.setEnabled(this.f38027g);
        } else {
            c0380b.f38031a.setPadding(0, 4, 0, 0);
            c0380b.f38032b.setVisibility(8);
        }
        if (i10 == getCount() - 1) {
            c0380b.f38034d.setVisibility(8);
        } else {
            c0380b.f38034d.setVisibility(0);
        }
        if (this.f38021a) {
            c0380b.f38033c.setChecked(this.f38026f.containsKey(Integer.valueOf(i10)));
            if (c0380b.f38033c.getVisibility() != 0) {
                if (this.f38025e) {
                    b(this.f38021a, c0380b.f38033c);
                } else {
                    c0380b.f38033c.setVisibility(0);
                }
            }
            Z.a(view, c0380b.f38033c.isChecked());
        } else {
            if (c0380b.f38033c.getVisibility() == 0) {
                b(this.f38021a, c0380b.f38033c);
            }
            Z.a(view, false);
        }
        return view;
    }

    /* compiled from: PhoneNoInquireForCountryAdapter.java */
    /* renamed from: x6.b$a */
    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f38028a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CheckBox f38029b;

        public a(boolean z10, CheckBox checkBox) {
            this.f38028a = z10;
            this.f38029b = checkBox;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (!this.f38028a) {
                C1682b.this.f38025e = true;
                this.f38029b.setChecked(false);
                this.f38029b.setVisibility(8);
            } else {
                C1682b.this.f38025e = false;
                this.f38029b.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f38029b.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}

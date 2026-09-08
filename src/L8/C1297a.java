package l8;

import android.content.Context;
import android.database.Cursor;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import b9.C0534d;
import com.oplus.blacklistapp.BlackListAppUtil;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.r;
import com.oplus.blacklistapp.u;
import com.oplus.utils.AnimationAnimationListenerC0842c;
import com.oplus.utils.C0846g;
import com.oplus.utils.Z;
import java.text.DateFormat;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: PseudoBaseStationAdapter.java */
/* renamed from: l8.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1297a extends ResourceCursorAdapter {

    /* renamed from: a, reason: collision with root package name */
    public boolean f34759a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f34760b;

    /* renamed from: c, reason: collision with root package name */
    public DateFormat f34761c;

    /* renamed from: d, reason: collision with root package name */
    public DateFormat f34762d;

    /* renamed from: e, reason: collision with root package name */
    public int f34763e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f34764f;

    /* renamed from: g, reason: collision with root package name */
    public Context f34765g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f34766h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f34767i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f34768j;

    /* renamed from: k, reason: collision with root package name */
    public ConcurrentHashMap<Long, String> f34769k;

    /* compiled from: PseudoBaseStationAdapter.java */
    /* renamed from: l8.a$b */
    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animation.AnimationListener f34775a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CheckBox f34776b;

        public b(Animation.AnimationListener animationListener, CheckBox checkBox) {
            this.f34775a = animationListener;
            this.f34776b = checkBox;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!BlackListAppUtil.f26245b) {
                AnimationAnimationListenerC0842c.l(C1297a.this.f34765g, null, 0).r(false, this.f34775a, this.f34776b);
            } else {
                AnimationAnimationListenerC0842c.j(C1297a.this.f34765g, null, 0).r(false, this.f34775a, this.f34776b);
            }
        }
    }

    /* compiled from: PseudoBaseStationAdapter.java */
    /* renamed from: l8.a$c */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public TextView f34778a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f34779b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f34780c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f34781d;

        /* renamed from: e, reason: collision with root package name */
        public CheckBox f34782e;

        /* renamed from: f, reason: collision with root package name */
        public View f34783f;

        /* renamed from: g, reason: collision with root package name */
        public View f34784g;
    }

    public C1297a(Context context) {
        super(context, r.f27466u, null);
        this.f34759a = false;
        this.f34760b = true;
        this.f34764f = true;
        this.f34766h = false;
        this.f34767i = false;
        this.f34768j = true;
        this.f34769k = new ConcurrentHashMap<>();
        this.f34765g = context;
        this.f34763e = context.getColor(C0534d.f12363a);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.f34766h;
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        CharSequence charSequence;
        if (cursor.getPosition() >= 0 && cursor.getPosition() < cursor.getCount()) {
            c cVar = (c) view.getTag();
            int i10 = 0;
            long j10 = cursor.getLong(0);
            String string = cursor.getString(2);
            int i11 = cursor.getInt(6);
            String string2 = cursor.getString(3);
            String e10 = e(cursor.getLong(4));
            int i12 = cursor.getInt(5);
            String str = context.getResources().getString(u.f27698u2) + string;
            if (i12 > 0) {
                charSequence = c(str, this.f34763e);
            } else {
                charSequence = str;
            }
            if (C0846g.c()) {
                Log.d("PseudoBaseAdapter", "name = " + str + " ,count = " + i11 + " ,location = " + string2 + " ,date = " + e10);
            }
            cVar.f34778a.setText(charSequence);
            cVar.f34781d.setText(e10);
            if (!TextUtils.isEmpty(string2)) {
                cVar.f34780c.setText(string2);
            } else {
                cVar.f34780c.setText(context.getString(u.f27703v2));
            }
            if (i11 > 1) {
                cVar.f34779b.setText(" (" + String.format(this.f34765g.getString(u.f27495B), Integer.valueOf(i11)) + ")");
                cVar.f34779b.setVisibility(0);
            } else {
                cVar.f34779b.setVisibility(8);
            }
            if (this.f34769k.containsKey(Long.valueOf(j10))) {
                cVar.f34782e.setChecked(true);
            } else {
                cVar.f34782e.setChecked(false);
            }
            if (this.f34767i) {
                if (cVar.f34782e.getVisibility() != 0) {
                    if (this.f34768j) {
                        d(this.f34767i, cVar.f34782e, cVar.f34781d);
                    } else {
                        cVar.f34782e.setVisibility(0);
                        cVar.f34781d.setVisibility(8);
                    }
                } else {
                    cVar.f34782e.setVisibility(0);
                    cVar.f34781d.setVisibility(8);
                }
                Z.a(view, cVar.f34782e.isChecked());
            } else {
                if (cVar.f34782e.getVisibility() == 0) {
                    d(this.f34767i, cVar.f34782e, cVar.f34781d);
                } else {
                    cVar.f34781d.setVisibility(0);
                }
                Z.a(view, false);
            }
            View view2 = cVar.f34784g;
            if (cursor.isLast()) {
                i10 = 8;
            }
            view2.setVisibility(i10);
        }
    }

    public final CharSequence c(CharSequence charSequence, int i10) {
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i10), 0, charSequence.length(), 18);
        return spannableString;
    }

    public final void d(boolean z10, CheckBox checkBox, View view) {
        AnimationAnimationListenerC0331a animationAnimationListenerC0331a = new AnimationAnimationListenerC0331a(z10, checkBox, view);
        if (z10) {
            view.setVisibility(8);
            view.postDelayed(new b(animationAnimationListenerC0331a, checkBox), 50L);
        } else if (!BlackListAppUtil.f26245b) {
            AnimationAnimationListenerC0842c.m(this.f34765g, null, 8).r(false, animationAnimationListenerC0331a, checkBox);
        } else {
            AnimationAnimationListenerC0842c.k(this.f34765g, null, 8).r(false, animationAnimationListenerC0331a, checkBox);
        }
    }

    public String e(long j10) {
        String str;
        DateFormat dateFormat = this.f34762d;
        String str2 = "";
        if (dateFormat == null) {
            str = "";
        } else {
            str = dateFormat.format(Long.valueOf(j10));
        }
        DateFormat dateFormat2 = this.f34761c;
        if (dateFormat2 != null) {
            str2 = dateFormat2.format(Long.valueOf(j10));
        }
        return str + " " + str2;
    }

    public boolean f() {
        return this.f34767i;
    }

    public void g() {
        this.f34766h = true;
        notifyDataSetChanged();
    }

    public void h(boolean z10) {
        this.f34767i = z10;
    }

    public void i(DateFormat dateFormat) {
        this.f34762d = dateFormat;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        if (this.f34764f) {
            return false;
        }
        return super.isEmpty();
    }

    public void j(boolean z10) {
        this.f34764f = z10;
    }

    public void k(ConcurrentHashMap<Long, String> concurrentHashMap) {
        this.f34769k = concurrentHashMap;
    }

    public void l(DateFormat dateFormat) {
        this.f34761c = dateFormat;
    }

    @Override // android.widget.ResourceCursorAdapter, android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        c cVar = new c();
        cVar.f34778a = (TextView) newView.findViewById(p.f27341I0);
        cVar.f34779b = (TextView) newView.findViewById(p.f27337G0);
        cVar.f34780c = (TextView) newView.findViewById(p.f27372Y);
        cVar.f34781d = (TextView) newView.findViewById(p.f27420w);
        cVar.f34782e = (CheckBox) newView.findViewById(p.f27370X);
        cVar.f34783f = newView.findViewById(p.f27339H0);
        cVar.f34784g = newView.findViewById(p.f27390h);
        newView.setTag(cVar);
        return newView;
    }

    /* compiled from: PseudoBaseStationAdapter.java */
    /* renamed from: l8.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class AnimationAnimationListenerC0331a implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f34770a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CheckBox f34771b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f34772c;

        /* compiled from: PseudoBaseStationAdapter.java */
        /* renamed from: l8.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0332a implements Runnable {
            public RunnableC0332a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AnimationAnimationListenerC0331a.this.f34772c.setVisibility(0);
            }
        }

        public AnimationAnimationListenerC0331a(boolean z10, CheckBox checkBox, View view) {
            this.f34770a = z10;
            this.f34771b = checkBox;
            this.f34772c = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            C1297a c1297a = C1297a.this;
            c1297a.f34759a = false;
            if (!this.f34770a) {
                c1297a.f34768j = true;
                this.f34771b.setVisibility(8);
                this.f34772c.postDelayed(new RunnableC0332a(), 50L);
            } else {
                c1297a.f34768j = false;
                this.f34771b.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            C1297a.this.f34759a = true;
            this.f34771b.setVisibility(0);
            if (this.f34770a) {
                this.f34772c.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}

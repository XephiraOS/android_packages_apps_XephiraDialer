package com.ted.number.ui;

import C7.e;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.framework.api.numberidentify.interfaces.IRelevantNumber;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.util.C;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.util.h0;
import com.customize.contacts.widget.i;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import com.ted.number.s;
import com.ted.number.ui.RelevantNumberActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class RelevantNumberActivity extends BasicActivity implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public String f29737o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<IRelevantNumber> f29738p;

    /* renamed from: q, reason: collision with root package name */
    public i f29739q = null;

    /* renamed from: r, reason: collision with root package name */
    public GestureDetector f29740r = null;

    /* renamed from: x, reason: collision with root package name */
    public a f29741x = null;

    /* renamed from: y, reason: collision with root package name */
    public View.OnTouchListener f29742y = null;

    /* loaded from: classes4.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        public View f29743a;

        public void a(View view) {
            this.f29743a = view;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            RelevantNumberActivity.this.z1(this.f29743a, motionEvent);
        }

        public a() {
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.Adapter<RecyclerView.B> {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<RelevantNumberActivity> f29745a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<IRelevantNumber> f29746b;

        public b(RelevantNumberActivity relevantNumberActivity, ArrayList<IRelevantNumber> arrayList) {
            this.f29745a = new WeakReference<>(relevantNumberActivity);
            this.f29746b = arrayList;
        }

        public IRelevantNumber g(int i10) {
            ArrayList<IRelevantNumber> arrayList = this.f29746b;
            if (arrayList == null) {
                return null;
            }
            return arrayList.get(i10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            ArrayList<IRelevantNumber> arrayList = this.f29746b;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.B b10, int i10) {
            if (b10 instanceof c) {
                c cVar = (c) b10;
                if (g(i10) != null) {
                    cVar.f29748a.setText(g(i10).s());
                    cVar.f29749b.setText(g(i10).y());
                    cVar.f29750c.setTag(R.id.yellow_detail_number, g(i10).s());
                    cVar.f29750c.setOnTouchListener(RelevantNumberActivity.this.f29742y);
                    cVar.f29750c.setOnClickListener(this.f29745a.get());
                    cVar.f29751d.setTag(g(i10).s());
                    cVar.f29751d.setOnClickListener(this.f29745a.get());
                    cVar.f29751d.setContentDescription(RelevantNumberActivity.this.getString(R.string.send_sms));
                }
                int positionInGroup = COUICardListHelper.getPositionInGroup(getItemCount(), i10);
                COUICardListHelper.setItemCardBackground(cVar.itemView, positionInGroup);
                if (positionInGroup != 1 && positionInGroup != 2) {
                    cVar.f29752e.setVisibility(8);
                } else {
                    cVar.f29752e.setVisibility(0);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.B onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new c(LayoutInflater.from(this.f29745a.get()).inflate(R.layout.ted_yellowpage_phone_number_item, viewGroup, false));
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f29748a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f29749b;

        /* renamed from: c, reason: collision with root package name */
        public final View f29750c;

        /* renamed from: d, reason: collision with root package name */
        public final View f29751d;

        /* renamed from: e, reason: collision with root package name */
        public final View f29752e;

        public c(View view) {
            super(view);
            this.f29748a = (TextView) view.findViewById(R.id.main_text);
            this.f29749b = (TextView) view.findViewById(R.id.sub_text);
            this.f29751d = view.findViewById(R.id.sms);
            this.f29750c = view.findViewById(R.id.number_info);
            this.f29752e = view.findViewById(R.id.bottom_divider);
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean H0() {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.number_info) {
            if (id == R.id.sms) {
                s.c(this, view.getTag().toString(), null);
            }
        } else {
            i iVar = this.f29739q;
            if (iVar != null && iVar.i()) {
                return;
            }
            A.a(this, 2000305, 200031810, h0.b0(this), false);
            s.a(this, view.getTag(R.id.yellow_detail_number).toString());
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f29737o = e.l(getIntent(), "extra_relevant_name");
        this.f29738p = e.i(getIntent(), "extra_relevant_list");
        this.f29741x = new a();
        this.f29740r = new GestureDetector(this, this.f29741x);
        this.f29739q = new i(this);
        this.f29742y = new View.OnTouchListener() { // from class: g9.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean y12;
                y12 = RelevantNumberActivity.this.y1(view, motionEvent);
                return y12;
            }
        };
        v1();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        u1();
    }

    public void u1() {
        i iVar = this.f29739q;
        if (iVar != null && iVar.i()) {
            this.f29739q.h();
        }
    }

    public final void v1() {
        setContentView(R.layout.more_call_log_activity);
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(R.id.toolbar);
        cOUIToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: g9.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RelevantNumberActivity.this.w1(view);
            }
        });
        cOUIToolbar.setNavigationIcon(R.drawable.coui_back_arrow);
        cOUIToolbar.setTitle(this.f29737o);
        findViewById(R.id.navigation_view).setVisibility(8);
        HeaderFooterRecyclerView headerFooterRecyclerView = (HeaderFooterRecyclerView) findViewById(R.id.list);
        headerFooterRecyclerView.setScrollBarStyle(33554432);
        headerFooterRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        headerFooterRecyclerView.setNestedScrollingEnabled(true);
        headerFooterRecyclerView.setAdapter(new b(this, this.f29738p));
        C.c(this, headerFooterRecyclerView, headerFooterRecyclerView.getPaddingBottom());
        headerFooterRecyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: g9.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean x12;
                x12 = RelevantNumberActivity.this.x1(view, motionEvent);
                return x12;
            }
        });
    }

    public final /* synthetic */ void w1(View view) {
        finish();
    }

    public final /* synthetic */ boolean x1(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            u1();
            return false;
        }
        return false;
    }

    public final /* synthetic */ boolean y1(View view, MotionEvent motionEvent) {
        this.f29741x.a(view);
        return this.f29740r.onTouchEvent(motionEvent);
    }

    public final void z1(View view, MotionEvent motionEvent) {
        i iVar = this.f29739q;
        if (iVar != null) {
            iVar.x(view);
            this.f29739q.v(view, (int) motionEvent.getX(), (int) motionEvent.getY(), true);
        }
    }
}

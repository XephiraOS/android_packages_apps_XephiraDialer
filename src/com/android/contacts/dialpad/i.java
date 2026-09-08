package com.android.contacts.dialpad;

import Z0.b;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.framework.baseui.util.C0637b;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.oplus.dialer.R;
import java.util.ArrayList;

/* compiled from: SpeedDialRecyclerViewAdapter.kt */
/* loaded from: classes.dex */
public final class i extends RecyclerView.Adapter<c> {

    /* renamed from: f, reason: collision with root package name */
    public static final a f14950f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Context f14951a;

    /* renamed from: b, reason: collision with root package name */
    public ContactInfoForSpeedDial[] f14952b;

    /* renamed from: c, reason: collision with root package name */
    public final Z0.b f14953c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<String> f14954d;

    /* renamed from: e, reason: collision with root package name */
    public b f14955e;

    /* compiled from: SpeedDialRecyclerViewAdapter.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SpeedDialRecyclerViewAdapter.kt */
    /* loaded from: classes.dex */
    public interface b {
        void onItemClick(View view, int i10);
    }

    /* compiled from: SpeedDialRecyclerViewAdapter.kt */
    /* loaded from: classes.dex */
    public static final class c extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f14956a;

        /* renamed from: b, reason: collision with root package name */
        public final COUIRoundImageView f14957b;

        /* renamed from: c, reason: collision with root package name */
        public final TextView f14958c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            kotlin.jvm.internal.i.f(view, "view");
            View findViewById = view.findViewById(R.id.number);
            kotlin.jvm.internal.i.d(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.f14956a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.contact_photo);
            kotlin.jvm.internal.i.d(findViewById2, "null cannot be cast to non-null type com.coui.appcompat.imageview.COUIRoundImageView");
            this.f14957b = (COUIRoundImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.name);
            kotlin.jvm.internal.i.d(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            this.f14958c = (TextView) findViewById3;
        }

        public final TextView e() {
            return this.f14958c;
        }

        public final TextView f() {
            return this.f14956a;
        }

        public final COUIRoundImageView g() {
            return this.f14957b;
        }
    }

    public i(Context mContext, ContactInfoForSpeedDial[] mContactInfoDetails) {
        kotlin.jvm.internal.i.f(mContext, "mContext");
        kotlin.jvm.internal.i.f(mContactInfoDetails, "mContactInfoDetails");
        this.f14951a = mContext;
        this.f14952b = mContactInfoDetails;
        Z0.b g10 = Z0.b.g(mContext);
        kotlin.jvm.internal.i.e(g10, "getInstance(mContext)");
        this.f14953c = g10;
        this.f14954d = h();
    }

    public static final void j(i this$0, c viewHolder, int i10, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(viewHolder, "$viewHolder");
        b bVar = this$0.f14955e;
        if (bVar == null) {
            kotlin.jvm.internal.i.q("mOnItemClickListener");
            bVar = null;
        }
        View view2 = viewHolder.itemView;
        kotlin.jvm.internal.i.e(view2, "viewHolder.itemView");
        bVar.onItemClick(view2, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f14952b.length;
    }

    public final ArrayList<String> h() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i10 = 1; i10 < 10; i10++) {
            arrayList.add(U7.a.b(i10));
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final c viewHolder, final int i10) {
        String f10;
        kotlin.jvm.internal.i.f(viewHolder, "viewHolder");
        ContactInfoForSpeedDial contactInfoForSpeedDial = this.f14952b[i10];
        viewHolder.f().setText(this.f14954d.get(i10));
        if (contactInfoForSpeedDial.i() != -1) {
            if (contactInfoForSpeedDial.i() <= 0) {
                b.c cVar = new b.c(contactInfoForSpeedDial.f(), String.valueOf(contactInfoForSpeedDial.b()), false);
                cVar.f5789g = 3;
                this.f14953c.j(viewHolder.g(), contactInfoForSpeedDial.j(), -1, false, false, cVar);
            } else if (contactInfoForSpeedDial.j() != null) {
                this.f14953c.j(viewHolder.g(), contactInfoForSpeedDial.j(), -1, false, false, null);
            } else {
                this.f14953c.q(viewHolder.g(), contactInfoForSpeedDial.i(), false, false, null);
            }
            if (C0637b.h()) {
                f10 = C0637b.c(contactInfoForSpeedDial.f());
            } else {
                f10 = contactInfoForSpeedDial.f();
            }
            viewHolder.e().setText(f10);
        } else if (i10 == 0) {
            viewHolder.e().setText(this.f14951a.getString(R.string.oplus_voicemail));
            viewHolder.g().setImageResource(R.drawable.pb_ic_speed_dial_voicemail);
        } else if (2 == i10 && B3.a.E()) {
            viewHolder.e().setText(this.f14951a.getString(R.string.consumer_hotline));
            viewHolder.g().setImageResource(R.drawable.pb_ic_speed_dial_photo);
        } else {
            viewHolder.e().setText(this.f14951a.getString(R.string.confirm_description));
            viewHolder.g().setImageResource(R.drawable.pb_ic_speed_dial_add);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.android.contacts.dialpad.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.j(i.this, viewHolder, i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup parent, int i10) {
        kotlin.jvm.internal.i.f(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.speed_dial_recyclerview_item, parent, false);
        kotlin.jvm.internal.i.e(view, "view");
        return new c(view);
    }

    public final void l(ContactInfoForSpeedDial[] details) {
        kotlin.jvm.internal.i.f(details, "details");
        this.f14952b = details;
        notifyDataSetChanged();
    }

    public final void m(b listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        this.f14955e = listener;
    }
}

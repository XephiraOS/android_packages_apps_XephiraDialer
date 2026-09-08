package com.oplus.blacklistapp.callintercept.settings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.checkbox.COUICheckBox;
import com.coui.appcompat.couiswitch.COUISwitch;
import com.oplus.blacklistapp.callintercept.settings.l;
import com.oplus.utils.C0846g;
import h9.C1087a;
import java.util.List;

/* compiled from: CallHarassInterceptMarkedNumberAdapter.kt */
/* loaded from: classes3.dex */
public class l extends RecyclerView.Adapter<RecyclerView.B> {

    /* renamed from: d, reason: collision with root package name */
    public static final f f26897d = new f(null);

    /* renamed from: a, reason: collision with root package name */
    public List<com.oplus.blacklistapp.callintercept.settings.f> f26898a;

    /* renamed from: b, reason: collision with root package name */
    public Context f26899b;

    /* renamed from: c, reason: collision with root package name */
    public g f26900c;

    /* compiled from: CallHarassInterceptMarkedNumberAdapter.kt */
    /* loaded from: classes3.dex */
    public final class a extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public View f26901a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f26902b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, View contentView) {
            super(contentView);
            kotlin.jvm.internal.i.f(contentView, "contentView");
            this.f26902b = lVar;
            this.f26901a = contentView.findViewById(com.oplus.blacklistapp.p.f27326B);
        }
    }

    /* compiled from: CallHarassInterceptMarkedNumberAdapter.kt */
    /* loaded from: classes3.dex */
    public final class b extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public COUICheckBox f26903a;

        /* renamed from: b, reason: collision with root package name */
        public View f26904b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f26905c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f26906d;

        /* renamed from: e, reason: collision with root package name */
        public View f26907e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f26908f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ l f26909g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l lVar, View contentView) {
            super(contentView);
            kotlin.jvm.internal.i.f(contentView, "contentView");
            this.f26909g = lVar;
            this.f26904b = contentView;
            this.f26903a = (COUICheckBox) contentView.findViewById(com.oplus.blacklistapp.p.f27402n);
            this.f26905c = (TextView) contentView.findViewById(com.oplus.blacklistapp.p.f27359R0);
            this.f26906d = (TextView) contentView.findViewById(com.oplus.blacklistapp.p.f27357Q0);
            this.f26907e = contentView.findViewById(com.oplus.blacklistapp.p.f27390h);
            this.f26908f = (ImageView) contentView.findViewById(com.oplus.blacklistapp.p.f27348M);
        }

        public final View e() {
            return this.f26907e;
        }

        public final COUICheckBox f() {
            return this.f26903a;
        }

        public final View g() {
            return this.f26904b;
        }

        public final ImageView h() {
            return this.f26908f;
        }

        public final TextView i() {
            return this.f26905c;
        }

        public final TextView j() {
            return this.f26906d;
        }
    }

    /* compiled from: CallHarassInterceptMarkedNumberAdapter.kt */
    /* loaded from: classes3.dex */
    public final class c extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public TextView f26910a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f26911b;

        /* renamed from: c, reason: collision with root package name */
        public RadioButton f26912c;

        /* renamed from: d, reason: collision with root package name */
        public View f26913d;

        /* renamed from: e, reason: collision with root package name */
        public View f26914e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ l f26915f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l lVar, View contentView) {
            super(contentView);
            kotlin.jvm.internal.i.f(contentView, "contentView");
            this.f26915f = lVar;
            this.f26910a = (TextView) contentView.findViewById(com.oplus.blacklistapp.p.f27355P0);
            this.f26911b = (TextView) contentView.findViewById(com.oplus.blacklistapp.p.f27361S0);
            this.f26912c = (RadioButton) contentView.findViewById(com.oplus.blacklistapp.p.f27417u0);
            this.f26914e = contentView.findViewById(com.oplus.blacklistapp.p.f27390h);
            this.f26913d = contentView;
        }

        public final View e() {
            return this.f26914e;
        }

        public final View f() {
            return this.f26913d;
        }

        public final RadioButton g() {
            return this.f26912c;
        }

        public final TextView h() {
            return this.f26910a;
        }

        public final TextView i() {
            return this.f26911b;
        }
    }

    /* compiled from: CallHarassInterceptMarkedNumberAdapter.kt */
    /* loaded from: classes3.dex */
    public final class d extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public TextView f26916a;

        /* renamed from: b, reason: collision with root package name */
        public COUISwitch f26917b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l f26918c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(l lVar, View contentView) {
            super(contentView);
            kotlin.jvm.internal.i.f(contentView, "contentView");
            this.f26918c = lVar;
            this.f26916a = (TextView) contentView.findViewById(com.oplus.blacklistapp.p.f27351N0);
            COUISwitch cOUISwitch = (COUISwitch) contentView.findViewById(com.oplus.blacklistapp.p.f27416u);
            this.f26917b = cOUISwitch;
            if (cOUISwitch != null) {
                cOUISwitch.setTactileFeedbackEnabled(true);
            }
        }

        public final COUISwitch e() {
            return this.f26917b;
        }

        public final TextView f() {
            return this.f26916a;
        }
    }

    /* compiled from: CallHarassInterceptMarkedNumberAdapter.kt */
    /* loaded from: classes3.dex */
    public final class e extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public TextView f26919a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f26920b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(l lVar, View contentView) {
            super(contentView);
            kotlin.jvm.internal.i.f(contentView, "contentView");
            this.f26920b = lVar;
            this.f26919a = (TextView) contentView.findViewById(com.oplus.blacklistapp.p.f27414t);
        }

        public final TextView e() {
            return this.f26919a;
        }
    }

    /* compiled from: CallHarassInterceptMarkedNumberAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class f {
        public f() {
        }

        public /* synthetic */ f(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: CallHarassInterceptMarkedNumberAdapter.kt */
    /* loaded from: classes3.dex */
    public interface g {
        void N(int i10);

        void U0(COUISwitch cOUISwitch, boolean z10);

        void l0(COUICheckBox cOUICheckBox, int i10);

        void q(RadioButton radioButton, int i10);
    }

    public l(List<com.oplus.blacklistapp.callintercept.settings.f> data, Context context, g itemClickListener) {
        kotlin.jvm.internal.i.f(data, "data");
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(itemClickListener, "itemClickListener");
        this.f26898a = data;
        this.f26899b = context;
        this.f26900c = itemClickListener;
    }

    public static final void k(d this_apply, l this$0, View view) {
        kotlin.jvm.internal.i.f(this_apply, "$this_apply");
        kotlin.jvm.internal.i.f(this$0, "this$0");
        COUISwitch e10 = this_apply.e();
        if (e10 != null) {
            this$0.f26900c.U0(e10, !e10.isChecked());
            e10.setTactileFeedbackEnabled(true);
        }
    }

    public static final void l(c this_apply, int i10, l this$0, View view) {
        kotlin.jvm.internal.i.f(this_apply, "$this_apply");
        kotlin.jvm.internal.i.f(this$0, "this$0");
        RadioButton g10 = this_apply.g();
        if (g10 != null) {
            this$0.f26900c.q(g10, i10);
        }
        C0846g.i("CallHarassInterceptMarkedNumberAdapter", "itemView click position=" + i10);
    }

    public static final void m(int i10, l this$0, COUICheckBox checkBox, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(checkBox, "$checkBox");
        C0846g.i("steve", "checkBox click position=" + i10);
        this$0.f26900c.l0(checkBox, i10);
    }

    public static final void n(int i10, l this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        C0846g.i("steve", "Right side area click position=" + i10);
        this$0.f26900c.N(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f26898a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        return this.f26898a.get(i10).e();
    }

    public final void o(View view, com.oplus.blacklistapp.callintercept.settings.f fVar, View view2) {
        int i10;
        if (fVar.g()) {
            i10 = 1;
        } else if (fVar.h()) {
            i10 = 3;
        } else {
            i10 = 2;
        }
        if (i10 != 1 && i10 != 2) {
            if (view2 != null) {
                view2.setVisibility(8);
            }
        } else if (view2 != null) {
            view2.setVisibility(0);
        }
        COUICardListHelper.setItemCardBackground(view, i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.B holder, final int i10) {
        final COUICheckBox f10;
        COUISwitch e10;
        kotlin.jvm.internal.i.f(holder, "holder");
        int itemViewType = getItemViewType(i10);
        if (itemViewType != 0) {
            int i11 = 0;
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    if (itemViewType != 3) {
                        if (itemViewType == 4) {
                            final d dVar = (d) holder;
                            com.oplus.blacklistapp.callintercept.settings.f fVar = this.f26898a.get(i10);
                            TextView f11 = dVar.f();
                            if (f11 != null) {
                                f11.setText(fVar.c());
                            }
                            COUISwitch e11 = dVar.e();
                            if ((e11 == null || e11.isChecked() != fVar.b()) && (e10 = dVar.e()) != null) {
                                e10.setChecked(fVar.b());
                            }
                            dVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.blacklistapp.callintercept.settings.k
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    l.k(l.d.this, this, view);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    com.oplus.blacklistapp.callintercept.settings.f fVar2 = this.f26898a.get(i10);
                    View view = ((a) holder).itemView;
                    if (view != null) {
                        if (!fVar2.d()) {
                            i11 = 4;
                        }
                        view.setVisibility(i11);
                        return;
                    }
                    return;
                }
                final c cVar = (c) holder;
                com.oplus.blacklistapp.callintercept.settings.f fVar3 = this.f26898a.get(i10);
                TextView h10 = cVar.h();
                if (h10 != null) {
                    h10.setText(fVar3.c());
                }
                TextView i12 = cVar.i();
                if (i12 != null) {
                    i12.setText(fVar3.f());
                }
                RadioButton g10 = cVar.g();
                if (g10 != null) {
                    g10.setChecked(fVar3.b());
                }
                TextView i13 = cVar.i();
                if (i13 != null) {
                    i13.setEnabled(fVar3.d());
                }
                TextView h11 = cVar.h();
                if (h11 != null) {
                    h11.setEnabled(fVar3.d());
                }
                RadioButton g11 = cVar.g();
                if (g11 != null) {
                    g11.setEnabled(fVar3.d());
                }
                cVar.itemView.setEnabled(fVar3.d());
                o(cVar.f(), fVar3, cVar.e());
                cVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.blacklistapp.callintercept.settings.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        l.l(l.c.this, i10, this, view2);
                    }
                });
                return;
            }
            b bVar = (b) holder;
            com.oplus.blacklistapp.callintercept.settings.f fVar4 = this.f26898a.get(i10);
            COUICheckBox f12 = bVar.f();
            if (f12 != null) {
                if (fVar4.b()) {
                    i11 = 2;
                }
                f12.setState(i11);
            }
            TextView i14 = bVar.i();
            if (i14 != null) {
                i14.setText(fVar4.c());
            }
            TextView j10 = bVar.j();
            if (j10 != null) {
                j10.setText(fVar4.f());
            }
            COUICheckBox f13 = bVar.f();
            if (f13 != null) {
                f13.setEnabled(fVar4.d());
            }
            TextView i15 = bVar.i();
            if (i15 != null) {
                i15.setEnabled(fVar4.d());
            }
            ImageView h12 = bVar.h();
            if (h12 != null) {
                h12.setEnabled(fVar4.d());
            }
            TextView j11 = bVar.j();
            if (j11 != null) {
                j11.setEnabled(fVar4.d());
            }
            bVar.itemView.setEnabled(fVar4.d());
            o(bVar.g(), fVar4, bVar.e());
            if (C1087a.m(this.f26899b) && (f10 = bVar.f()) != null) {
                f10.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.blacklistapp.callintercept.settings.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        l.m(i10, this, f10, view2);
                    }
                });
            }
            bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.blacklistapp.callintercept.settings.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    l.n(i10, this, view2);
                }
            });
            return;
        }
        com.oplus.blacklistapp.callintercept.settings.f fVar5 = this.f26898a.get(i10);
        TextView e12 = ((e) holder).e();
        if (e12 != null) {
            e12.setText(fVar5.c());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.B onCreateViewHolder(ViewGroup parent, int i10) {
        kotlin.jvm.internal.i.f(parent, "parent");
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            View inflate = LayoutInflater.from(this.f26899b).inflate(com.oplus.blacklistapp.r.f27438J, parent, false);
                            kotlin.jvm.internal.i.e(inflate, "from(context).inflate(R.…tem_title, parent, false)");
                            return new e(this, inflate);
                        }
                        View inflate2 = LayoutInflater.from(this.f26899b).inflate(com.oplus.blacklistapp.r.f27437I, parent, false);
                        kotlin.jvm.internal.i.e(inflate2, "from(context).inflate(R.…em_switch, parent, false)");
                        return new d(this, inflate2);
                    }
                    View inflate3 = LayoutInflater.from(this.f26899b).inflate(com.oplus.blacklistapp.r.f27434F, parent, false);
                    kotlin.jvm.internal.i.e(inflate3, "from(context).inflate(R.…m_divider, parent, false)");
                    return new a(this, inflate3);
                }
                View inflate4 = LayoutInflater.from(this.f26899b).inflate(com.oplus.blacklistapp.r.f27436H, parent, false);
                kotlin.jvm.internal.i.e(inflate4, "from(context).inflate(R.…e_options, parent, false)");
                return new c(this, inflate4);
            }
            View inflate5 = LayoutInflater.from(this.f26899b).inflate(com.oplus.blacklistapp.r.f27435G, parent, false);
            kotlin.jvm.internal.i.e(inflate5, "from(context).inflate(R.…ti_choice, parent, false)");
            return new b(this, inflate5);
        }
        View inflate6 = LayoutInflater.from(this.f26899b).inflate(com.oplus.blacklistapp.r.f27438J, parent, false);
        kotlin.jvm.internal.i.e(inflate6, "from(context).inflate(R.…tem_title, parent, false)");
        return new e(this, inflate6);
    }
}

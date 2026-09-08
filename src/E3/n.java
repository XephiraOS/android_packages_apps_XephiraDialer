package E3;

import E3.j;
import android.animation.ObjectAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import androidx.activity.ComponentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.ContactsApplication;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.util.C;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.preference.ListSelectedItemLayout;
import com.coui.appcompat.textviewcompatutil.COUITextViewCompatUtil;
import com.customize.contacts.mediaplayer.RecordPlayerPresenter;
import com.customize.contacts.util.AnimationAnimationListenerC0813y;
import com.customize.contacts.util.O;
import com.oplus.dialer.R;

/* compiled from: CallLogHistoryAdapter.kt */
/* loaded from: classes3.dex */
public final class n extends RecyclerView.Adapter<RecyclerView.B> {

    /* renamed from: n, reason: collision with root package name */
    public static final a f613n = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final ComponentActivity f614a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f615b;

    /* renamed from: c, reason: collision with root package name */
    public PhoneCallDetails[] f616c;

    /* renamed from: d, reason: collision with root package name */
    public O f617d;

    /* renamed from: e, reason: collision with root package name */
    public int f618e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f619f;

    /* renamed from: g, reason: collision with root package name */
    public RecordPlayerPresenter f620g;

    /* renamed from: h, reason: collision with root package name */
    public int f621h;

    /* renamed from: i, reason: collision with root package name */
    public Y0.b f622i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f623j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f624k;

    /* renamed from: l, reason: collision with root package name */
    public final View.OnClickListener f625l;

    /* renamed from: m, reason: collision with root package name */
    public final View.OnLongClickListener f626m;

    /* compiled from: CallLogHistoryAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: CallLogHistoryAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class b extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public j.f f627a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            kotlin.jvm.internal.i.f(view, "view");
            this.f627a = new j.f(view, R.layout.detail_call_history_item, -1);
        }

        public final j.f e() {
            return this.f627a;
        }
    }

    /* compiled from: CallLogHistoryAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j.f f628a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup.MarginLayoutParams f629b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ n f630c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f631d;

        public c(j.f fVar, ViewGroup.MarginLayoutParams marginLayoutParams, n nVar, View view) {
            this.f628a = fVar;
            this.f629b = marginLayoutParams;
            this.f630c = nVar;
            this.f631d = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f628a.f593j.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f629b.setMarginEnd(this.f628a.f593j.getMeasuredWidth() + this.f630c.f621h);
            this.f631d.setLayoutParams(this.f629b);
        }
    }

    /* compiled from: CallLogHistoryAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class d implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j.f f632a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n f633b;

        public d(j.f fVar, n nVar) {
            this.f632a = fVar;
            this.f633b = nVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            this.f633b.f623j = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            this.f632a.f593j.setVisibility(0);
        }
    }

    /* compiled from: CallLogHistoryAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class e implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j.f f634a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n f635b;

        public e(j.f fVar, n nVar) {
            this.f634a = fVar;
            this.f635b = nVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            this.f634a.f593j.setVisibility(8);
            this.f634a.f593j.setChecked(false);
            this.f635b.f624k = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            this.f634a.f593j.setVisibility(0);
        }
    }

    public n(ComponentActivity activity, boolean z10) {
        kotlin.jvm.internal.i.f(activity, "activity");
        this.f614a = activity;
        this.f615b = z10;
        this.f618e = activity.getResources().getDimensionPixelSize(R.dimen.sim_contact_list_padding);
        this.f621h = activity.getResources().getDimensionPixelSize(R.dimen.DP_8);
        this.f625l = new View.OnClickListener() { // from class: E3.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.n(n.this, view);
            }
        };
        this.f626m = new View.OnLongClickListener() { // from class: E3.m
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean o10;
                o10 = n.o(n.this, view);
                return o10;
            }
        };
    }

    public static final void n(n this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        Object tag = view.getTag();
        kotlin.jvm.internal.i.d(tag, "null cannot be cast to non-null type com.customize.contacts.calllog.CallDetailListItemHelper.CallLogViewCache");
        j.f fVar = (j.f) tag;
        Y0.b bVar = this$0.f622i;
        if (bVar != null) {
            bVar.onItemClick(null, view, fVar.f603t, -1L);
        }
    }

    public static final boolean o(n this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        Object tag = view.getTag();
        kotlin.jvm.internal.i.d(tag, "null cannot be cast to non-null type com.customize.contacts.calllog.CallDetailListItemHelper.CallLogViewCache");
        j.f fVar = (j.f) tag;
        Y0.b bVar = this$0.f622i;
        if (bVar != null) {
            bVar.onItemLongClick(null, view, fVar.f603t, -1L);
            return true;
        }
        return true;
    }

    public final Object getItem(int i10) {
        PhoneCallDetails[] phoneCallDetailsArr = this.f616c;
        if (phoneCallDetailsArr != null) {
            return phoneCallDetailsArr[i10];
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        PhoneCallDetails[] phoneCallDetailsArr = this.f616c;
        if (phoneCallDetailsArr != null) {
            return phoneCallDetailsArr.length;
        }
        return 0;
    }

    public final void l(b viewHolder, PhoneCallDetails phoneCallDetails, int i10) {
        int i11;
        kotlin.jvm.internal.i.f(viewHolder, "viewHolder");
        View view = viewHolder.itemView;
        kotlin.jvm.internal.i.e(view, "viewHolder.itemView");
        j jVar = new j(this.f614a);
        jVar.A(this.f620g);
        O o10 = this.f617d;
        if (o10 == null) {
            kotlin.jvm.internal.i.q("actionModeUtils");
            o10 = null;
        }
        jVar.w(view, o10.f(), false, phoneCallDetails, this.f619f, this.f615b, i10);
        j.f e10 = viewHolder.e();
        View view2 = e10.f605v;
        O o11 = this.f617d;
        if (o11 == null) {
            kotlin.jvm.internal.i.q("actionModeUtils");
            o11 = null;
        }
        if (o11.f()) {
            if (this.f623j) {
                if (e10.f593j.getVisibility() != 0) {
                    int i12 = this.f618e;
                    if (ContactsApplication.f13094j) {
                        i12 = -i12;
                    }
                    d dVar = new d(e10, this);
                    e10.f593j.setVisibility(0);
                    AnimationAnimationListenerC0813y.i(this.f614a, null, 0).u(false, dVar, e10.f593j);
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    kotlin.jvm.internal.i.d(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int measuredWidth = e10.f593j.getMeasuredWidth();
                    if (measuredWidth == 0) {
                        e10.f593j.getViewTreeObserver().addOnGlobalLayoutListener(new c(e10, marginLayoutParams, this, view2));
                    } else {
                        marginLayoutParams.setMarginEnd(measuredWidth + this.f621h);
                        view2.setLayoutParams(marginLayoutParams);
                    }
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "translationX", i12, 0.0f);
                    ofFloat.setDuration(230L);
                    ofFloat.start();
                } else {
                    e10.f593j.setVisibility(0);
                }
            } else {
                e10.f593j.setVisibility(0);
            }
            e10.f593j.setTag(phoneCallDetails);
            O o12 = this.f617d;
            if (o12 == null) {
                kotlin.jvm.internal.i.q("actionModeUtils");
                o12 = null;
            }
            boolean e11 = o12.e(phoneCallDetails);
            e10.f593j.setChecked(e11);
            C.b(view, e11);
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnClickListener(this.f625l);
            i11 = 1;
        } else {
            if (this.f624k) {
                if (e10.f593j.getVisibility() == 0) {
                    int i13 = -this.f618e;
                    if (ContactsApplication.f13094j) {
                        i13 = -i13;
                    }
                    AnimationAnimationListenerC0813y.n(this.f614a, null, 0).u(false, new e(e10, this), e10.f593j);
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    kotlin.jvm.internal.i.d(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    marginLayoutParams2.setMarginEnd(0);
                    view2.setLayoutParams(marginLayoutParams2);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "translationX", i13, 0.0f);
                    ofFloat2.setDuration(230L);
                    ofFloat2.start();
                } else {
                    e10.f593j.setVisibility(8);
                    e10.f593j.setChecked(false);
                }
            } else {
                e10.f593j.setVisibility(8);
                e10.f593j.setChecked(false);
            }
            C.b(view, false);
            view.setOnLongClickListener(this.f626m);
            i11 = 1;
            view.setClickable(true);
        }
        if (i10 != i11 && i10 != 2) {
            e10.f602s.setVisibility(4);
        } else {
            e10.f602s.setVisibility(0);
        }
    }

    public final PhoneCallDetails[] m() {
        return this.f616c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.B holder, int i10) {
        m9.q qVar;
        kotlin.jvm.internal.i.f(holder, "holder");
        if (holder instanceof b) {
            PhoneCallDetails[] phoneCallDetailsArr = this.f616c;
            if (phoneCallDetailsArr != null) {
                holder.itemView.setFocusable(false);
                b bVar = (b) holder;
                holder.itemView.setTag(bVar.e());
                holder.itemView.setTag(R.id.call_log_item_position, Integer.valueOf(i10));
                bVar.e().f603t = i10;
                PhoneCallDetails phoneCallDetails = phoneCallDetailsArr[i10];
                int positionInGroup = COUICardListHelper.getPositionInGroup(phoneCallDetailsArr.length, i10);
                COUICardListHelper.setItemCardBackground(bVar.e().f584a, positionInGroup);
                l(bVar, phoneCallDetails, positionInGroup);
                qVar = m9.q.f35511a;
            } else {
                qVar = null;
            }
            if (qVar == null) {
                H7.b.c("ViewGroupAdapter", "no call log");
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.B onCreateViewHolder(ViewGroup parent, int i10) {
        kotlin.jvm.internal.i.f(parent, "parent");
        View inflate = LayoutInflater.from(this.f614a).inflate(R.layout.detail_call_history_item, parent, false);
        kotlin.jvm.internal.i.e(inflate, "from(activity).inflate(R…tory_item, parent, false)");
        b bVar = new b(inflate);
        if (this.f624k) {
            bVar.e().f593j.setVisibility(0);
        } else {
            bVar.e().f593j.setVisibility(8);
        }
        COUITextViewCompatUtil.setPressRippleDrawable(bVar.e().f600q);
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.B holder) {
        ListSelectedItemLayout listSelectedItemLayout;
        kotlin.jvm.internal.i.f(holder, "holder");
        super.onViewRecycled(holder);
        if (holder instanceof b) {
            ((b) holder).e().f593j.setChecked(false);
            View view = holder.itemView;
            if (view instanceof ListSelectedItemLayout) {
                listSelectedItemLayout = (ListSelectedItemLayout) view;
            } else {
                listSelectedItemLayout = null;
            }
            if (listSelectedItemLayout != null) {
                listSelectedItemLayout.resetBackgroundAnimation();
                C.b(listSelectedItemLayout, false);
            }
        }
    }

    public final void p(O actionModeUtils) {
        kotlin.jvm.internal.i.f(actionModeUtils, "actionModeUtils");
        this.f617d = actionModeUtils;
    }

    public final void q(PhoneCallDetails[] phoneCallDetailsArr) {
        this.f616c = phoneCallDetailsArr;
    }

    public final void r(Y0.b itemClickListener) {
        kotlin.jvm.internal.i.f(itemClickListener, "itemClickListener");
        this.f622i = itemClickListener;
    }

    public final void s(RecordPlayerPresenter recordPlayerPresenter) {
        this.f620g = recordPlayerPresenter;
    }

    public final void t(boolean z10) {
        this.f623j = z10;
    }

    public final void u(boolean z10) {
        this.f624k = z10;
    }

    public final void v(boolean z10) {
        this.f619f = z10;
    }
}

package W1;

import P1.d;
import P1.e;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.jvm.internal.i;
import m9.q;
import v9.l;

/* compiled from: SmsDialogRecycleViewAdapter.kt */
/* loaded from: classes.dex */
public final class b extends RecyclerView.Adapter<a> {

    /* renamed from: a, reason: collision with root package name */
    public final List<String> f4134a;

    /* renamed from: b, reason: collision with root package name */
    public final l<String, q> f4135b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4136c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4137d;

    /* compiled from: SmsDialogRecycleViewAdapter.kt */
    /* loaded from: classes.dex */
    public static final class a extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f4138a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            i.f(itemView, "itemView");
            View findViewById = itemView.findViewById(d.f2858q);
            i.e(findViewById, "itemView.findViewById(R.id.sms_item)");
            this.f4138a = (TextView) findViewById;
        }

        public final TextView e() {
            return this.f4138a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<String> smsList, l<? super String, q> onClick) {
        i.f(smsList, "smsList");
        i.f(onClick, "onClick");
        this.f4134a = smsList;
        this.f4135b = onClick;
        this.f4137d = getItemCount() - 1;
    }

    public static final void i(b this$0, String sms, View view) {
        i.f(this$0, "this$0");
        i.f(sms, "$sms");
        this$0.f4135b.invoke(sms);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f4134a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i10) {
        i.f(holder, "holder");
        final String str = this.f4134a.get(i10);
        holder.e().setText(str);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: W1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.i(b.this, str, view);
            }
        });
        if (i10 == this.f4136c) {
            View view = holder.itemView;
            i.e(view, "holder.itemView");
            l(view, P1.b.f2831g);
        } else if (i10 == this.f4137d) {
            View view2 = holder.itemView;
            i.e(view2, "holder.itemView");
            k(view2, P1.b.f2832h);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(e.f2867d, parent, false);
        i.e(itemView, "itemView");
        return new a(itemView);
    }

    public final void k(View view, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = view.getResources().getDimensionPixelSize(i10);
        }
    }

    public final void l(View view, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = view.getResources().getDimensionPixelSize(i10);
        }
    }
}

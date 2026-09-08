package N3;

import N3.h;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.util.C;
import com.oplus.dialer.R;
import java.util.HashSet;
import java.util.List;

/* compiled from: GroupSelectAdapter.kt */
/* loaded from: classes3.dex */
public final class f extends RecyclerView.Adapter<RecyclerView.B> {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2328a;

    /* renamed from: b, reason: collision with root package name */
    public List<? extends h.a> f2329b;

    /* renamed from: c, reason: collision with root package name */
    public final Y0.b f2330c;

    /* renamed from: d, reason: collision with root package name */
    public HashSet<Integer> f2331d;

    /* compiled from: GroupSelectAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a extends RecyclerView.B {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f2332a;

        /* renamed from: b, reason: collision with root package name */
        public final CheckBox f2333b;

        /* renamed from: c, reason: collision with root package name */
        public final View f2334c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            kotlin.jvm.internal.i.f(view, "view");
            View findViewById = view.findViewById(R.id.group_title);
            kotlin.jvm.internal.i.d(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.f2332a = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.check_box);
            kotlin.jvm.internal.i.d(findViewById2, "null cannot be cast to non-null type android.widget.CheckBox");
            this.f2333b = (CheckBox) findViewById2;
            this.f2334c = view.findViewById(R.id.bottom_divider);
        }

        public final View e() {
            return this.f2334c;
        }

        public final CheckBox f() {
            return this.f2333b;
        }

        public final TextView g() {
            return this.f2332a;
        }
    }

    public f(Context context, List<? extends h.a> list, Y0.b clickListener, HashSet<Integer> positions) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(clickListener, "clickListener");
        kotlin.jvm.internal.i.f(positions, "positions");
        this.f2328a = context;
        this.f2329b = list;
        this.f2330c = clickListener;
        this.f2331d = positions;
    }

    public static final void h(f this$0, int i10, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.f2330c.onItemClick(null, view, i10, -1L);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends h.a> list = this.f2329b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.B holder, final int i10) {
        String str;
        int i11;
        h.a aVar;
        kotlin.jvm.internal.i.f(holder, "holder");
        if (holder instanceof a) {
            a aVar2 = (a) holder;
            TextView g10 = aVar2.g();
            List<? extends h.a> list = this.f2329b;
            if (list != null && (aVar = list.get(i10)) != null) {
                str = aVar.f2346b;
            } else {
                str = null;
            }
            g10.setText(str);
            holder.itemView.setTag(R.id.group_list_item_position, Integer.valueOf(i10));
            List<? extends h.a> list2 = this.f2329b;
            if (list2 != null) {
                i11 = list2.size() - 1;
            } else {
                i11 = 0;
            }
            if (i11 == i10) {
                aVar2.f().setVisibility(8);
                aVar2.g().setTextAppearance(this.f2328a, R.style.FocusTitleStyle);
                C.b(holder.itemView, false);
                View e10 = aVar2.e();
                if (e10 != null) {
                    e10.setVisibility(8);
                }
            } else {
                aVar2.f().setVisibility(0);
                aVar2.g().setTextAppearance(this.f2328a, R.style.LargeTextStyle);
                aVar2.f().setChecked(this.f2331d.contains(Integer.valueOf(i10)));
                C.b(holder.itemView, aVar2.f().isChecked());
                View e11 = aVar2.e();
                if (e11 != null) {
                    e11.setVisibility(0);
                }
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: N3.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.h(f.this, i10, view);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.B onCreateViewHolder(ViewGroup parent, int i10) {
        kotlin.jvm.internal.i.f(parent, "parent");
        View inflate = LayoutInflater.from(this.f2328a).inflate(R.layout.select_dialog_multichoice, (ViewGroup) null, false);
        kotlin.jvm.internal.i.e(inflate, "from(context).inflate(R.…multichoice, null, false)");
        return new a(inflate);
    }
}

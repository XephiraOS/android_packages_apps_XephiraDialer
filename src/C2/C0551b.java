package c2;

import O1.s;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import c2.C0551b;
import com.android.incallui.InCallUIAide;
import com.android.incallui.Log;
import com.android.incallui.R;
import com.android.incallui.mvvm.command_model.DialpadCommandModel;
import com.android.incallui.mvvm.command_model.GlobalCommandModel;
import e2.C0967b;
import java.util.List;
import kotlin.jvm.internal.i;

/* compiled from: DialpadButtonAdapter.kt */
/* renamed from: c2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0551b<ITEM extends C0967b> extends RecyclerView.Adapter<C0551b<ITEM>.a> {

    /* renamed from: a, reason: collision with root package name */
    public final DialpadCommandModel f12716a;

    /* renamed from: b, reason: collision with root package name */
    public final List<ITEM> f12717b;

    /* compiled from: DialpadButtonAdapter.kt */
    /* renamed from: c2.b$a */
    /* loaded from: classes.dex */
    public final class a extends RecyclerView.B implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public final s f12718a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C0551b<ITEM> f12719b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C0551b c0551b, s binding) {
            super(binding.K0());
            i.f(binding, "binding");
            this.f12719b = c0551b;
            this.f12718a = binding;
            binding.f2628G.setOnTouchListener(this);
        }

        public static final void g(C0551b this$0) {
            i.f(this$0, "this$0");
            this$0.f12716a.e().invoke();
        }

        public final void f(ITEM data) {
            i.f(data, "data");
            this.f12718a.i1(data);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Integer num;
            StringBuilder sb = new StringBuilder();
            sb.append("onTouch item : ");
            sb.append(getAbsoluteAdapterPosition());
            sb.append(' ');
            Integer num2 = null;
            if (motionEvent != null) {
                num = Integer.valueOf(motionEvent.getAction());
            } else {
                num = null;
            }
            sb.append(num);
            Log.d("DialpadButtonAdapter", sb.toString());
            if (motionEvent != null) {
                num2 = Integer.valueOf(motionEvent.getAction());
            }
            if (num2 != null && num2.intValue() == 0) {
                if (view != null) {
                    view.setPressed(true);
                }
                GlobalCommandModel.f18535a.a();
                this.f12719b.f12716a.d().invoke(Character.valueOf(((C0967b) this.f12719b.f12717b.get(getAbsoluteAdapterPosition())).d()));
                if (view != null) {
                    final C0551b<ITEM> c0551b = this.f12719b;
                    view.postDelayed(new Runnable() { // from class: c2.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            C0551b.a.g(C0551b.this);
                        }
                    }, 50L);
                }
            } else if (((num2 != null && num2.intValue() == 1) || (num2 != null && num2.intValue() == 3)) && view != null) {
                view.setPressed(false);
            }
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0551b(DialpadCommandModel dialpadCommandModel, List<? extends ITEM> datas) {
        i.f(dialpadCommandModel, "dialpadCommandModel");
        i.f(datas, "datas");
        this.f12716a = dialpadCommandModel;
        this.f12717b = datas;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f12717b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C0551b<ITEM>.a holder, int i10) {
        i.f(holder, "holder");
        holder.f(this.f12717b.get(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0551b<ITEM>.a onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        ViewDataBinding h10 = g.h(LayoutInflater.from(parent.getContext()), R.layout.item_dialpad_button, parent, false);
        s sVar = (s) h10;
        sVar.f2631J.setTypeface(InCallUIAide.getInstance().getNumberFontRegularType());
        sVar.f2630I.setTypeface(InCallUIAide.getInstance().getMediumType());
        i.e(h10, "inflate<ItemDialpadButto….mediumType\n            }");
        return new a(this, sVar);
    }
}

package com.coui.appcompat.card;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.coui.appcompat.card.BaseCardInstructionAdapter;
import com.coui.appcompat.card.BaseCardInstructionAdapter.BaseHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: BaseCardInstructionAdapter.kt */
/* loaded from: classes.dex */
public abstract class BaseCardInstructionAdapter<HOLDER extends BaseHolder> extends RecyclerView.Adapter<HOLDER> {
    public static final Companion Companion = new Companion(null);
    public static final String EMPTY_STRING = "";
    private final List<BaseDisplayInfo> displayInfos;
    private int pagerLastHeight;

    /* compiled from: BaseCardInstructionAdapter.kt */
    /* loaded from: classes.dex */
    public static abstract class BaseHolder extends RecyclerView.B {
        private final BaseCardInstructionAdapter<?> adapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseHolder(View itemView, BaseCardInstructionAdapter<?> adapter) {
            super(itemView);
            i.f(itemView, "itemView");
            i.f(adapter, "adapter");
            this.adapter = adapter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setMatchChildrenMaxHeight$lambda$1(BaseHolder this$0) {
            ViewParent viewParent;
            int b10;
            int b11;
            i.f(this$0, "this$0");
            this$0.itemView.measure(View.MeasureSpec.makeMeasureSpec(this$0.itemView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
            ViewParent parent = this$0.itemView.getParent();
            if (parent != null) {
                viewParent = parent.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof ViewPager2) {
                ViewPager2 viewPager2 = (ViewPager2) viewParent;
                int i10 = viewPager2.getLayoutParams().height;
                b10 = B9.i.b(((BaseCardInstructionAdapter) this$0.adapter).pagerLastHeight, this$0.itemView.getMeasuredHeight());
                if (i10 != b10) {
                    ViewGroup.LayoutParams layoutParams = viewPager2.getLayoutParams();
                    b11 = B9.i.b(((BaseCardInstructionAdapter) this$0.adapter).pagerLastHeight, this$0.itemView.getMeasuredHeight());
                    layoutParams.height = b11;
                    ((BaseCardInstructionAdapter) this$0.adapter).pagerLastHeight = b11;
                    viewPager2.setLayoutParams(layoutParams);
                }
            }
        }

        public abstract void bind(BaseDisplayInfo baseDisplayInfo);

        public final BaseCardInstructionAdapter<?> getAdapter() {
            return this.adapter;
        }

        public final void setMatchChildrenMaxHeight() {
            if (((BaseCardInstructionAdapter) this.adapter).displayInfos.size() <= 1) {
                return;
            }
            this.itemView.post(new Runnable() { // from class: com.coui.appcompat.card.a
                @Override // java.lang.Runnable
                public final void run() {
                    BaseCardInstructionAdapter.BaseHolder.setMatchChildrenMaxHeight$lambda$1(BaseCardInstructionAdapter.BaseHolder.this);
                }
            });
        }
    }

    /* compiled from: BaseCardInstructionAdapter.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final void updateContentAndVisibility(TextView textView, CharSequence content) {
            i.f(textView, "<this>");
            i.f(content, "content");
            updateContentAndVisibility(textView, content, textView);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final void updateContentAndVisibility(TextView textView, CharSequence content, View view) {
            i.f(textView, "<this>");
            i.f(content, "content");
            i.f(view, "view");
            if (content.length() > 0) {
                view.setVisibility(0);
                textView.setText(content);
            } else {
                view.setVisibility(8);
            }
        }
    }

    public BaseCardInstructionAdapter() {
        this.displayInfos = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.displayInfos.size();
    }

    public final void updateDisplayInfos(List<? extends BaseDisplayInfo> displayInfos) {
        i.f(displayInfos, "displayInfos");
        this.displayInfos.clear();
        this.displayInfos.addAll(displayInfos);
        this.pagerLastHeight = 0;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(HOLDER holder, int i10) {
        i.f(holder, "holder");
        holder.bind(this.displayInfos.get(i10));
        holder.setMatchChildrenMaxHeight();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseCardInstructionAdapter(List<BaseDisplayInfo> displayInfos) {
        this();
        i.f(displayInfos, "displayInfos");
        this.displayInfos.clear();
        this.displayInfos.addAll(displayInfos);
    }

    public /* synthetic */ BaseCardInstructionAdapter(List list, int i10, f fVar) {
        this((i10 & 1) != 0 ? new ArrayList() : list);
    }
}

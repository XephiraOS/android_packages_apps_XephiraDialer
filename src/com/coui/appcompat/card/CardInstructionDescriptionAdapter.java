package com.coui.appcompat.card;

import Z8.e;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coui.appcompat.card.BaseCardInstructionAdapter;
import com.oplus.anim.EffectiveAnimationView;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: CardInstructionDescriptionAdapter.kt */
/* loaded from: classes.dex */
public final class CardInstructionDescriptionAdapter extends BaseCardInstructionAdapter<DescriptionHolder> {
    public static final Companion Companion = new Companion(null);

    /* compiled from: CardInstructionDescriptionAdapter.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final LinearLayout.LayoutParams getAnimViewLayoutParam(int i10, int i11) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i10 > 0 && i11 > 0) {
                layoutParams.height = i11;
                layoutParams.width = i10;
            }
            return layoutParams;
        }

        public static /* synthetic */ LinearLayout.LayoutParams getAnimViewLayoutParam$default(Companion companion, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = 0;
            }
            return companion.getAnimViewLayoutParam(i10, i11);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* compiled from: CardInstructionDescriptionAdapter.kt */
    /* loaded from: classes.dex */
    public final class DescriptionHolder extends BaseCardInstructionAdapter.BaseHolder {
        private final LinearLayout animContainer;
        private final COUIMutableSizeScrollView scrollViewContainer;
        private final TextView summary;
        private final LinearLayout summaryContainer;
        final /* synthetic */ CardInstructionDescriptionAdapter this$0;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DescriptionHolder(CardInstructionDescriptionAdapter cardInstructionDescriptionAdapter, View itemView, BaseCardInstructionAdapter<?> adapter) {
            super(itemView, adapter);
            i.f(itemView, "itemView");
            i.f(adapter, "adapter");
            this.this$0 = cardInstructionDescriptionAdapter;
            View findViewById = itemView.findViewById(e.f6113d);
            i.e(findViewById, "itemView.findViewById(R.id.anim_container)");
            this.animContainer = (LinearLayout) findViewById;
            View findViewById2 = itemView.findViewById(e.f6152w0);
            i.e(findViewById2, "itemView.findViewById(R.id.title)");
            this.title = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(e.f6148u0);
            i.e(findViewById3, "itemView.findViewById(R.id.summary)");
            this.summary = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(e.f6150v0);
            i.e(findViewById4, "itemView.findViewById(R.id.summary_container)");
            this.summaryContainer = (LinearLayout) findViewById4;
            View findViewById5 = itemView.findViewById(e.f6143s);
            i.e(findViewById5, "itemView.findViewById(R.id.content_container)");
            this.scrollViewContainer = (COUIMutableSizeScrollView) findViewById5;
        }

        private final void bindAnimDisplayInfo(AnimDisplayInfo animDisplayInfo) {
            if ((!animDisplayInfo.getAnimAssets().isEmpty()) && (!animDisplayInfo.getAnimResources().isEmpty())) {
                throw new IllegalArgumentException("imageAssets and imageResources cannot be used at the same time. Please use only one at once.");
            }
            if (animDisplayInfo.getAnimTitles().size() > 0 && animDisplayInfo.getAnimAssets().size() + animDisplayInfo.getAnimResources().size() != animDisplayInfo.getAnimTitles().size()) {
                throw new IllegalArgumentException("the image count must equals to the animTitle count");
            }
            int size = animDisplayInfo.getAnimResources().size();
            for (int i10 = 0; i10 < size; i10++) {
                Context context = this.itemView.getContext();
                i.e(context, "itemView.context");
                AnimViewGroup animViewGroup = new AnimViewGroup(context);
                animViewGroup.bind(animDisplayInfo, i10);
                this.animContainer.addView(animViewGroup.getRootView());
            }
            int size2 = animDisplayInfo.getAnimAssets().size();
            for (int i11 = 0; i11 < size2; i11++) {
                Context context2 = this.itemView.getContext();
                i.e(context2, "itemView.context");
                AnimViewGroup animViewGroup2 = new AnimViewGroup(context2);
                animViewGroup2.bind(animDisplayInfo, i11);
                this.animContainer.addView(animViewGroup2.getRootView());
            }
        }

        private final void bindImageDisplayInfo(ImageDisplayInfo imageDisplayInfo) {
            if (imageDisplayInfo.getAnimTitles().size() > 0 && imageDisplayInfo.getImageResources().length != imageDisplayInfo.getAnimTitles().size()) {
                throw new IllegalArgumentException("the anim count must equals to the animTitle count");
            }
            int length = imageDisplayInfo.getImageResources().length;
            for (int i10 = 0; i10 < length; i10++) {
                Context context = this.itemView.getContext();
                i.e(context, "itemView.context");
                AnimViewGroup animViewGroup = new AnimViewGroup(context);
                animViewGroup.bind(imageDisplayInfo, i10);
                this.animContainer.addView(animViewGroup.getRootView());
            }
        }

        @Override // com.coui.appcompat.card.BaseCardInstructionAdapter.BaseHolder
        public void bind(BaseDisplayInfo displayInfo) {
            int i10;
            int dimenPx;
            i.f(displayInfo, "displayInfo");
            BaseCardInstructionAdapter.Companion companion = BaseCardInstructionAdapter.Companion;
            companion.updateContentAndVisibility(this.title, displayInfo.getTitle());
            companion.updateContentAndVisibility(this.summary, displayInfo.getSummary(), this.summaryContainer);
            if (this.title.getVisibility() == 0) {
                COUIMutableSizeScrollView cOUIMutableSizeScrollView = this.scrollViewContainer;
                cOUIMutableSizeScrollView.setMaxHeight(cOUIMutableSizeScrollView.getResources().getDimensionPixelSize(Z8.c.f6042s));
                i10 = Z8.c.f6048v;
            } else {
                COUIMutableSizeScrollView cOUIMutableSizeScrollView2 = this.scrollViewContainer;
                cOUIMutableSizeScrollView2.setMaxHeight(cOUIMutableSizeScrollView2.getResources().getDimensionPixelSize(Z8.c.f6044t));
                i10 = Z8.c.f6046u;
            }
            LinearLayout linearLayout = this.summaryContainer;
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            i.d(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            dimenPx = CardInstructionDescriptionAdapterKt.getDimenPx(this.summaryContainer, i10);
            layoutParams2.topMargin = dimenPx;
            linearLayout.setLayoutParams(layoutParams2);
            if (displayInfo instanceof AnimDisplayInfo) {
                bindAnimDisplayInfo((AnimDisplayInfo) displayInfo);
            } else if (displayInfo instanceof ImageDisplayInfo) {
                bindImageDisplayInfo((ImageDisplayInfo) displayInfo);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardInstructionDescriptionAdapter(List<BaseDisplayInfo> displayInfos) {
        super(displayInfos);
        i.f(displayInfos, "displayInfos");
    }

    public CardInstructionDescriptionAdapter() {
        this(new ArrayList());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DescriptionHolder onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(Z8.f.f6169e, parent, false);
        i.e(inflate, "from(parent.context)\n   …      false\n            )");
        return new DescriptionHolder(this, inflate, this);
    }

    /* compiled from: CardInstructionDescriptionAdapter.kt */
    /* loaded from: classes.dex */
    public static final class AnimViewGroup {
        private final TextView animTitle;
        private final EffectiveAnimationView animView;
        private final LinearLayout rootView;

        public AnimViewGroup(Context context) {
            i.f(context, "context");
            View inflate = View.inflate(context, Z8.f.f6168d, null);
            i.d(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout = (LinearLayout) inflate;
            this.rootView = linearLayout;
            this.animView = (EffectiveAnimationView) linearLayout.findViewById(e.f6117f);
            this.animTitle = (TextView) linearLayout.findViewById(e.f6115e);
        }

        public final void bind(ImageDisplayInfo displayInfo, int i10) {
            i.f(displayInfo, "displayInfo");
            if (displayInfo.getAnimTitles().size() > 0) {
                TextView animTitle = this.animTitle;
                i.e(animTitle, "animTitle");
                animTitle.setVisibility(0);
                this.animTitle.setText(displayInfo.getAnimTitles().get(i10));
            }
            this.animView.setImageResource(displayInfo.getImageResources()[i10].intValue());
            this.animView.setLayoutParams(CardInstructionDescriptionAdapter.Companion.getAnimViewLayoutParam(displayInfo.getAnimWidth(), displayInfo.getAnimHeight()));
        }

        public final TextView getAnimTitle() {
            return this.animTitle;
        }

        public final EffectiveAnimationView getAnimView() {
            return this.animView;
        }

        public final LinearLayout getRootView() {
            return this.rootView;
        }

        public final void bind(AnimDisplayInfo displayInfo, int i10) {
            i.f(displayInfo, "displayInfo");
            if (displayInfo.getAnimTitles().size() > 0) {
                this.animTitle.setText(displayInfo.getAnimTitles().get(i10));
            } else {
                TextView animTitle = this.animTitle;
                i.e(animTitle, "animTitle");
                animTitle.setVisibility(8);
            }
            if (displayInfo.getAnimResources().size() > 0) {
                this.animView.setAnimation(displayInfo.getAnimResources().get(i10).intValue());
                this.animView.setLayoutParams(CardInstructionDescriptionAdapter.Companion.getAnimViewLayoutParam(displayInfo.getAnimWidth(), displayInfo.getAnimHeight()));
            } else {
                this.animView.setAnimation(displayInfo.getAnimAssets().get(i10));
                this.animView.setLayoutParams(CardInstructionDescriptionAdapter.Companion.getAnimViewLayoutParam(displayInfo.getAnimWidth(), displayInfo.getAnimHeight()));
            }
        }
    }
}

package com.coui.appcompat.card;

import X8.n;
import Z8.e;
import Z8.f;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coui.appcompat.card.BaseCardInstructionAdapter;
import com.coui.appcompat.card.COUICardInstructionPreference;
import com.coui.appcompat.card.CardInstructionSelectorAdapter;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.oplus.anim.EffectiveAnimationView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.i;

/* compiled from: CardInstructionSelectorAdapter.kt */
/* loaded from: classes.dex */
public final class CardInstructionSelectorAdapter extends BaseCardInstructionAdapter<SelectorHolder> {
    private int lastSelectedIndex;
    private COUICardInstructionPreference.OnItemSelectedListener onSelectedCardChangedListener;

    /* compiled from: CardInstructionSelectorAdapter.kt */
    /* loaded from: classes.dex */
    public static final class Selector {
        private final EffectiveAnimationView animView;
        private final RadioButton radio;
        private final View rootView;
        private final TextView title;

        public Selector(Context context) {
            i.f(context, "context");
            View inflate = View.inflate(context, f.f6171g, null);
            i.e(inflate, "inflate(\n            con…_selector, null\n        )");
            this.rootView = inflate;
            View findViewById = inflate.findViewById(e.f6117f);
            i.e(findViewById, "rootView.findViewById(R.id.anim_view)");
            this.animView = (EffectiveAnimationView) findViewById;
            View findViewById2 = inflate.findViewById(e.f6152w0);
            i.e(findViewById2, "rootView.findViewById(R.id.title)");
            this.title = (TextView) findViewById2;
            View findViewById3 = inflate.findViewById(e.f6122h0);
            i.e(findViewById3, "rootView.findViewById(R.id.radio)");
            this.radio = (RadioButton) findViewById3;
        }

        public final EffectiveAnimationView getAnimView() {
            return this.animView;
        }

        public final RadioButton getRadio() {
            return this.radio;
        }

        public final View getRootView() {
            return this.rootView;
        }

        public final TextView getTitle() {
            return this.title;
        }

        public final void setAnimViewSize(int i10, int i11) {
            if (i10 > 0 && i11 > 0) {
                EffectiveAnimationView effectiveAnimationView = this.animView;
                ViewGroup.LayoutParams layoutParams = effectiveAnimationView.getLayoutParams();
                i.d(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = i11;
                ((ViewGroup.MarginLayoutParams) layoutParams2).width = i10;
                effectiveAnimationView.setLayoutParams(layoutParams2);
            }
        }
    }

    /* compiled from: CardInstructionSelectorAdapter.kt */
    /* loaded from: classes.dex */
    public final class SelectorHolder extends BaseCardInstructionAdapter.BaseHolder {
        private final LinearLayout selectorContainer;
        private final List<Selector> selectorGroup;
        final /* synthetic */ CardInstructionSelectorAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectorHolder(CardInstructionSelectorAdapter cardInstructionSelectorAdapter, View itemView, BaseCardInstructionAdapter<?> adapter) {
            super(itemView, adapter);
            i.f(itemView, "itemView");
            i.f(adapter, "adapter");
            this.this$0 = cardInstructionSelectorAdapter;
            this.selectorGroup = new ArrayList();
            View findViewById = itemView.findViewById(e.f6141r);
            i.e(findViewById, "itemView.findViewById(R.id.container)");
            this.selectorContainer = (LinearLayout) findViewById;
        }

        private final void bindAnimDisplayInfo(AnimDisplayInfo animDisplayInfo) {
            if ((!animDisplayInfo.getAnimAssets().isEmpty()) && (!animDisplayInfo.getAnimResources().isEmpty())) {
                throw new IllegalArgumentException("imageAssets and imageResources cannot be used at the same time. Please use only one at once.");
            }
            if (animDisplayInfo.getAnimAssets().size() + animDisplayInfo.getAnimResources().size() == animDisplayInfo.getChoices().size()) {
                Iterator<Integer> it = animDisplayInfo.getAnimResources().iterator();
                int i10 = 0;
                int i11 = 0;
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    Context context = this.itemView.getContext();
                    i.e(context, "itemView.context");
                    Selector selector = new Selector(context);
                    BaseCardInstructionAdapter.Companion.updateContentAndVisibility(selector.getTitle(), animDisplayInfo.getChoices().get(i11));
                    selector.getAnimView().setAnimation(intValue);
                    selector.setAnimViewSize(animDisplayInfo.getAnimWidth(), animDisplayInfo.getAnimHeight());
                    this.selectorContainer.addView(selector.getRootView());
                    this.selectorGroup.add(selector);
                    i11++;
                }
                for (String str : animDisplayInfo.getAnimAssets()) {
                    Context context2 = this.itemView.getContext();
                    i.e(context2, "itemView.context");
                    Selector selector2 = new Selector(context2);
                    BaseCardInstructionAdapter.Companion.updateContentAndVisibility(selector2.getTitle(), animDisplayInfo.getChoices().get(i10));
                    selector2.getAnimView().setAnimation(str);
                    selector2.setAnimViewSize(animDisplayInfo.getAnimWidth(), animDisplayInfo.getAnimHeight());
                    this.selectorContainer.addView(selector2.getRootView());
                    this.selectorGroup.add(selector2);
                    i10++;
                }
                return;
            }
            throw new IllegalArgumentException("the anim count must equal to the choice count");
        }

        private final void bindImageDisplayInfo(ImageDisplayInfo imageDisplayInfo) {
            if (imageDisplayInfo.getImageResources().length == imageDisplayInfo.getChoices().size()) {
                Integer[] imageResources = imageDisplayInfo.getImageResources();
                int length = imageResources.length;
                for (int i10 = 0; i10 < length; i10++) {
                    int intValue = imageResources[i10].intValue();
                    Context context = this.itemView.getContext();
                    i.e(context, "itemView.context");
                    Selector selector = new Selector(context);
                    BaseCardInstructionAdapter.Companion.updateContentAndVisibility(selector.getTitle(), imageDisplayInfo.getChoices().get(i10));
                    selector.getAnimView().setImageResource(intValue);
                    selector.setAnimViewSize(imageDisplayInfo.getAnimWidth(), imageDisplayInfo.getAnimHeight());
                    this.selectorContainer.addView(selector.getRootView());
                    this.selectorGroup.add(selector);
                }
                return;
            }
            throw new IllegalArgumentException("the image count must equal to the choice count");
        }

        private final void dealRadioGroupClickEvents() {
            List<Selector> list = this.selectorGroup;
            final CardInstructionSelectorAdapter cardInstructionSelectorAdapter = this.this$0;
            for (final Selector selector : list) {
                selector.getRootView().setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.card.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CardInstructionSelectorAdapter.SelectorHolder.dealRadioGroupClickEvents$lambda$1$lambda$0(CardInstructionSelectorAdapter.SelectorHolder.this, selector, cardInstructionSelectorAdapter, view);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void dealRadioGroupClickEvents$lambda$1$lambda$0(SelectorHolder this$0, Selector selector, CardInstructionSelectorAdapter this$1, View view) {
            i.f(this$0, "this$0");
            i.f(selector, "$selector");
            i.f(this$1, "this$1");
            int indexOf = this$0.selectorGroup.indexOf(selector);
            if (indexOf != this$1.lastSelectedIndex) {
                this$1.lastSelectedIndex = indexOf;
                COUICardInstructionPreference.OnItemSelectedListener onSelectedCardChangedListener = this$1.getOnSelectedCardChangedListener();
                if (onSelectedCardChangedListener != null) {
                    onSelectedCardChangedListener.onItemSelected(indexOf);
                }
            }
            this$0.setSelectedChoiceIndex(indexOf);
        }

        @Override // com.coui.appcompat.card.BaseCardInstructionAdapter.BaseHolder
        public void bind(BaseDisplayInfo displayInfo) {
            i.f(displayInfo, "displayInfo");
            this.selectorGroup.clear();
            this.selectorContainer.removeAllViews();
            if (displayInfo instanceof AnimDisplayInfo) {
                bindAnimDisplayInfo((AnimDisplayInfo) displayInfo);
            } else if (displayInfo instanceof ImageDisplayInfo) {
                bindImageDisplayInfo((ImageDisplayInfo) displayInfo);
            }
            dealRadioGroupClickEvents();
            setSelectedChoiceIndex(displayInfo.getSelectedIndex());
        }

        public final void setSelectedChoiceIndex(int i10) {
            if (i10 >= 0 && i10 < this.selectorGroup.size()) {
                Selector selector = this.selectorGroup.get(i10);
                selector.getRadio().setChecked(true);
                selector.getTitle().setTextAppearance(n.f5053y);
                selector.getTitle().setTextColor(COUIContextUtil.getAttrColor(this.itemView.getContext(), X8.c.f4347F));
                List<Selector> list = this.selectorGroup;
                ArrayList<Selector> arrayList = new ArrayList();
                for (Object obj : list) {
                    if (!i.b((Selector) obj, selector)) {
                        arrayList.add(obj);
                    }
                }
                for (Selector selector2 : arrayList) {
                    selector2.getRadio().setChecked(false);
                    selector2.getTitle().setTextAppearance(n.f5051w);
                    selector2.getTitle().setTextColor(COUIContextUtil.getAttrColor(this.itemView.getContext(), X8.c.f4351J));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardInstructionSelectorAdapter(List<BaseDisplayInfo> displayInfos) {
        super(displayInfos);
        i.f(displayInfos, "displayInfos");
        this.lastSelectedIndex = -1;
    }

    public final COUICardInstructionPreference.OnItemSelectedListener getOnSelectedCardChangedListener() {
        return this.onSelectedCardChangedListener;
    }

    public final void setOnSelectedCardChangedListener(COUICardInstructionPreference.OnItemSelectedListener onItemSelectedListener) {
        this.onSelectedCardChangedListener = onItemSelectedListener;
    }

    public final void setSelectedIndex(int i10) {
        this.lastSelectedIndex = i10;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SelectorHolder onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(f.f6172h, parent, false);
        i.e(inflate, "from(parent.context)\n   …      false\n            )");
        return new SelectorHolder(this, inflate, this);
    }

    public CardInstructionSelectorAdapter() {
        this(new ArrayList());
    }

    @Override // com.coui.appcompat.card.BaseCardInstructionAdapter
    public void onBindViewHolder(SelectorHolder holder, int i10) {
        i.f(holder, "holder");
        super.onBindViewHolder((CardInstructionSelectorAdapter) holder, i10);
        holder.setSelectedChoiceIndex(this.lastSelectedIndex);
    }
}

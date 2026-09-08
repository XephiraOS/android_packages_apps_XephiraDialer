package com.coui.appcompat.preference;

import X8.c;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.l;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b9.C0532b;
import b9.C0535e;
import b9.C0537g;
import b9.C0539i;
import b9.j;
import b9.k;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.contextutil.COUIContextUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class COUIRecommendedPreference extends Preference {
    private COUIRecommendedDrawable mBackground;
    private int mColor;
    private String mHeaderText;
    private float mRadius;
    private List<RecommendedEntity> mRecommendedEntityList;

    /* loaded from: classes.dex */
    public interface OnRecommendedClickListener {
        void onRecommendedClick(View view);
    }

    /* loaded from: classes.dex */
    public static class RecommendedAdapter extends RecyclerView.Adapter<RecommendedVH> {
        private static final int ITEM_VIEW_TYPE_ENTITY = 1;
        private static final int ITEM_VIEW_TYPE_HEADER = 0;
        private int mBackgroundColor;
        private Context mContext;
        private List<RecommendedEntity> mEntities = new ArrayList();
        private float mRadius;

        public RecommendedAdapter(Context context, List<RecommendedEntity> list, String str, float f10, int i10) {
            this.mContext = context;
            this.mRadius = f10;
            this.mBackgroundColor = i10;
            setData(list, str);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.mEntities.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i10) {
            if (i10 == 0) {
                return 0;
            }
            return 1;
        }

        public void setData(List<RecommendedEntity> list, String str) {
            this.mEntities.clear();
            if (list != null) {
                this.mEntities.addAll(list);
                this.mEntities.add(0, new RecommendedEntity(str));
            }
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecommendedVH recommendedVH, int i10) {
            final RecommendedEntity recommendedEntity = this.mEntities.get(i10);
            recommendedVH.mTitleView.setText(recommendedEntity.title);
            recommendedVH.mLayout.setRadius(this.mRadius);
            recommendedVH.mLayout.setBackgroundColor(this.mBackgroundColor);
            if (i10 <= 0) {
                if (i10 == 0) {
                    recommendedVH.mLayout.setClickable(false);
                    recommendedVH.mLayout.setPositionInGroup(1);
                    return;
                }
                return;
            }
            if (i10 == getItemCount() - 1) {
                recommendedVH.mLayout.setPositionInGroup(3);
                recommendedVH.mLayout.setPaddingRelative(recommendedVH.mLayout.getPaddingStart(), recommendedVH.mLayout.getPaddingTop(), recommendedVH.mLayout.getPaddingEnd(), this.mContext.getResources().getDimensionPixelOffset(C0535e.f12430r0));
            } else if (recommendedVH.mLayout.getPaddingBottom() != this.mContext.getResources().getDimensionPixelOffset(C0535e.f12430r0)) {
                recommendedVH.mLayout.setPositionInGroup(2);
            } else {
                recommendedVH.mLayout.setPaddingRelative(recommendedVH.mLayout.getPaddingStart(), recommendedVH.mLayout.getPaddingTop(), recommendedVH.mLayout.getPaddingEnd(), 0);
                recommendedVH.mLayout.setPositionInGroup(2);
            }
            recommendedVH.mLayout.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.preference.COUIRecommendedPreference.RecommendedAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (recommendedEntity.onRecommendedClickListener != null) {
                        recommendedEntity.onRecommendedClickListener.onRecommendedClick(view);
                    }
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecommendedVH onCreateViewHolder(ViewGroup viewGroup, int i10) {
            if (i10 == 0) {
                return new RecommendedVH(LayoutInflater.from(viewGroup.getContext()).inflate(C0539i.f12518t, viewGroup, false));
            }
            return new RecommendedVH(LayoutInflater.from(viewGroup.getContext()).inflate(C0539i.f12517s, viewGroup, false));
        }
    }

    /* loaded from: classes.dex */
    public static class RecommendedVH extends RecyclerView.B {
        private COUICardListSelectedItemLayout mLayout;
        private TextView mTitleView;

        public RecommendedVH(View view) {
            super(view);
            this.mLayout = (COUICardListSelectedItemLayout) view;
            this.mTitleView = (TextView) view.findViewById(C0537g.f12471T);
            this.mLayout.setClickable(true);
        }
    }

    public COUIRecommendedPreference(Context context) {
        this(context, null);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        RecyclerView recyclerView = (RecyclerView) lVar.itemView;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(new RecommendedAdapter(getContext(), this.mRecommendedEntityList, this.mHeaderText, this.mRadius, this.mColor));
        } else {
            ((RecommendedAdapter) adapter).setData(this.mRecommendedEntityList, this.mHeaderText);
        }
        recyclerView.setFocusable(false);
    }

    public void setData(List<RecommendedEntity> list) {
        if (list != null && !list.isEmpty()) {
            setVisible(true);
            this.mRecommendedEntityList = list;
            notifyChanged();
            return;
        }
        setVisible(false);
    }

    public void setHeaderText(String str) {
        setVisible(true);
        if (!TextUtils.equals(this.mHeaderText, str)) {
            this.mHeaderText = str;
            notifyChanged();
        }
    }

    /* loaded from: classes.dex */
    public static class RecommendedEntity {
        private OnRecommendedClickListener onRecommendedClickListener;
        private String title;

        public RecommendedEntity(String str) {
            this.title = str;
        }

        public RecommendedEntity(String str, OnRecommendedClickListener onRecommendedClickListener) {
            this.title = str;
            this.onRecommendedClickListener = onRecommendedClickListener;
        }
    }

    public COUIRecommendedPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0532b.f12352k);
    }

    public COUIRecommendedPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, k.f12523a);
    }

    public COUIRecommendedPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        setLayoutResource(C0539i.f12513o);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b9.l.f12577P0, i10, 0);
        this.mRadius = obtainStyledAttributes.getDimension(b9.l.f12581R0, COUIContextUtil.getAttrDimens(getContext(), c.f4373c0));
        this.mColor = obtainStyledAttributes.getColor(b9.l.f12579Q0, COUIContextUtil.getAttrColor(getContext(), c.f4390l));
        this.mBackground = new COUIRecommendedDrawable(this.mRadius, this.mColor);
        String string = obtainStyledAttributes.getString(b9.l.f12583S0);
        this.mHeaderText = string;
        if (string == null) {
            this.mHeaderText = getContext().getResources().getString(j.f12519a);
        }
        obtainStyledAttributes.recycle();
    }
}

package com.coui.appcompat.dialog.adapter;

import X8.f;
import X8.h;
import X8.j;
import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class SummaryAdapter extends BaseAdapter {
    private static final int LAYOUT = j.f4970a;
    private Context mContext;
    private boolean mIsBottom;
    private boolean mIsTop;
    private CharSequence[] mItems;
    private CharSequence[] mSummaries;
    private int[] mTextColor;

    /* loaded from: classes.dex */
    public class ViewHolder {
        ImageView mDivider;
        TextView mItemView;
        LinearLayout mMainLayout;
        TextView mSummaryView;

        private ViewHolder() {
        }
    }

    public SummaryAdapter(Context context, boolean z10, boolean z11, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, int[] iArr) {
        this.mIsTop = z10;
        this.mIsBottom = z11;
        this.mContext = context;
        this.mItems = charSequenceArr;
        this.mSummaries = charSequenceArr2;
        this.mTextColor = iArr;
    }

    private void resetPadding(int i10, View view) {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(f.f4716j0);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(f.f4732l0);
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        if (i10 == getCount() - 1 && this.mIsBottom) {
            view.setPadding(paddingLeft, dimensionPixelSize2, paddingRight, dimensionPixelSize + dimensionPixelSize2);
        } else if (i10 == 0 && this.mIsTop) {
            view.setPadding(paddingLeft, dimensionPixelSize + dimensionPixelSize2, paddingRight, dimensionPixelSize2);
        } else {
            view.setPadding(paddingLeft, dimensionPixelSize2, paddingRight, dimensionPixelSize2);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        CharSequence[] charSequenceArr = this.mItems;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    public CharSequence getSummary(int i10) {
        CharSequence[] charSequenceArr = this.mSummaries;
        if (charSequenceArr == null || i10 >= charSequenceArr.length) {
            return null;
        }
        return charSequenceArr[i10];
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(LAYOUT, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.mItemView = (TextView) view.findViewById(R.id.text1);
            viewHolder.mSummaryView = (TextView) view.findViewById(h.f4955w0);
            viewHolder.mDivider = (ImageView) view.findViewById(h.f4902S);
            viewHolder.mMainLayout = (LinearLayout) view.findViewById(h.f4904U);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        CharSequence item = getItem(i10);
        CharSequence summary = getSummary(i10);
        viewHolder.mItemView.setText(item);
        if (TextUtils.isEmpty(summary)) {
            viewHolder.mSummaryView.setVisibility(8);
        } else {
            viewHolder.mSummaryView.setVisibility(0);
            viewHolder.mSummaryView.setText(summary);
        }
        resetPadding(i10, viewHolder.mMainLayout);
        int[] iArr = this.mTextColor;
        if (iArr != null && i10 >= 0 && i10 < iArr.length) {
            viewHolder.mItemView.setTextColor(iArr[i10]);
        }
        if (viewHolder.mDivider != null) {
            if (getCount() > 1 && i10 != getCount() - 1) {
                viewHolder.mDivider.setVisibility(0);
            } else {
                viewHolder.mDivider.setVisibility(8);
            }
        }
        view.requestLayout();
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.Adapter
    public CharSequence getItem(int i10) {
        CharSequence[] charSequenceArr = this.mItems;
        if (charSequenceArr == null) {
            return null;
        }
        return charSequenceArr[i10];
    }
}

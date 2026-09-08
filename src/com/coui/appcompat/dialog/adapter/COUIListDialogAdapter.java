package com.coui.appcompat.dialog.adapter;

import X8.f;
import X8.h;
import X8.j;
import X8.n;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class COUIListDialogAdapter extends BaseAdapter {
    private Context mContext;
    private CharSequence[] mItems;
    private int[] mTextAppearances;
    private final int LAYOUT = j.f4976g;
    private boolean mIsTop = false;
    private boolean mIsBottom = false;

    /* loaded from: classes.dex */
    public class ViewHolder {
        ImageView divider;
        TextView mTextView;
        LinearLayout mainLayout;

        public ViewHolder() {
        }
    }

    public COUIListDialogAdapter(Context context, CharSequence[] charSequenceArr, int[] iArr) {
        this.mContext = context;
        this.mItems = charSequenceArr;
        this.mTextAppearances = iArr;
    }

    private View getViewInternal(int i10, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(this.LAYOUT, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.mTextView = (TextView) view.findViewById(R.id.text1);
            viewHolder.divider = (ImageView) view.findViewById(h.f4902S);
            viewHolder.mainLayout = (LinearLayout) view.findViewById(h.f4904U);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mTextView.setText(getItem(i10));
        int[] iArr = this.mTextAppearances;
        if (iArr != null) {
            int i11 = iArr[i10];
            if (i11 > 0) {
                viewHolder.mTextView.setTextAppearance(this.mContext, i11);
            } else {
                viewHolder.mTextView.setTextAppearance(this.mContext, n.f5040l);
            }
        }
        if (viewHolder.divider != null) {
            if (getCount() > 1 && i10 != getCount() - 1) {
                viewHolder.divider.setVisibility(0);
            } else {
                viewHolder.divider.setVisibility(8);
            }
        }
        return view;
    }

    private void resetPadding(int i10, View view) {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(f.f4716j0);
        Resources resources = this.mContext.getResources();
        int i11 = f.f4732l0;
        int dimensionPixelSize2 = resources.getDimensionPixelSize(i11);
        int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(f.f4651b);
        int dimensionPixelSize4 = this.mContext.getResources().getDimensionPixelSize(i11);
        int dimensionPixelSize5 = this.mContext.getResources().getDimensionPixelSize(f.f4659c);
        this.mContext.getResources().getDimensionPixelSize(f.f4643a);
        if (i10 == getCount() - 1 && this.mIsBottom) {
            view.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize5, dimensionPixelSize4 + dimensionPixelSize);
        } else if (i10 == 0 && this.mIsTop) {
            view.setPadding(dimensionPixelSize3, dimensionPixelSize2 + dimensionPixelSize, dimensionPixelSize5, dimensionPixelSize4);
        } else {
            view.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize5, dimensionPixelSize4);
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

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View viewInternal = getViewInternal(i10, view, viewGroup);
        resetPadding(i10, viewInternal.findViewById(h.f4904U));
        return viewInternal;
    }

    public void setIsBottom(boolean z10) {
        this.mIsBottom = z10;
    }

    public void setIsTop(boolean z10) {
        this.mIsTop = z10;
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

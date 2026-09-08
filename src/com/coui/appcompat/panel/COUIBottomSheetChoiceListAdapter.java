package com.coui.appcompat.panel;

import X8.g;
import X8.h;
import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.checkbox.COUICheckBox;
import java.util.HashSet;

/* loaded from: classes.dex */
public class COUIBottomSheetChoiceListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private HashSet<Integer> mCheckBoxStates;
    private int mCheckedItem;
    private Context mContext;
    private boolean mIsMultiChoice;
    private CharSequence[] mItems;
    private int mLayoutResId;
    private OnItemClickListener mOnItemClickListener;
    private CharSequence[] mSummaries;

    /* loaded from: classes.dex */
    public interface OnItemClickListener {
        void onItemClick(View view, int i10, int i11);
    }

    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.B {
        COUICheckBox checkBox;
        TextView itemText;
        View mLayout;
        RadioButton radioButton;
        TextView summaryText;

        public ViewHolder(View view) {
            super(view);
            this.itemText = (TextView) view.findViewById(R.id.text1);
            this.summaryText = (TextView) view.findViewById(h.f4955w0);
            if (COUIBottomSheetChoiceListAdapter.this.mIsMultiChoice) {
                this.checkBox = (COUICheckBox) view.findViewById(h.f4940p);
            } else {
                this.radioButton = (RadioButton) view.findViewById(h.f4929j0);
            }
            view.setBackground(COUIBottomSheetChoiceListAdapter.this.mContext.getDrawable(g.f4864q));
            this.mLayout = view;
        }
    }

    public COUIBottomSheetChoiceListAdapter(Context context, int i10, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, int i11, boolean[] zArr, boolean z10) {
        this.mCheckedItem = -1;
        this.mContext = context;
        this.mLayoutResId = i10;
        this.mItems = charSequenceArr;
        this.mSummaries = charSequenceArr2;
        this.mIsMultiChoice = z10;
        this.mCheckBoxStates = new HashSet<>();
        this.mCheckedItem = i11;
        if (zArr != null) {
            initCheckboxStates(zArr);
        }
    }

    private void initCheckboxStates(boolean[] zArr) {
        for (int i10 = 0; i10 < zArr.length; i10++) {
            if (zArr[i10]) {
                this.mCheckBoxStates.add(Integer.valueOf(i10));
            }
        }
    }

    public CharSequence getItem(int i10) {
        CharSequence[] charSequenceArr = this.mItems;
        if (charSequenceArr != null && i10 < charSequenceArr.length) {
            return charSequenceArr[i10];
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        CharSequence[] charSequenceArr = this.mItems;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    public CharSequence getSummary(int i10) {
        CharSequence[] charSequenceArr = this.mSummaries;
        if (charSequenceArr != null && i10 < charSequenceArr.length) {
            return charSequenceArr[i10];
        }
        return null;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder viewHolder, final int i10) {
        if (this.mIsMultiChoice) {
            viewHolder.checkBox.setState(this.mCheckBoxStates.contains(Integer.valueOf(i10)) ? 2 : 0);
        } else {
            viewHolder.radioButton.setChecked(this.mCheckedItem == i10);
        }
        CharSequence item = getItem(i10);
        CharSequence summary = getSummary(i10);
        viewHolder.itemText.setText(item);
        if (TextUtils.isEmpty(summary)) {
            viewHolder.summaryText.setVisibility(8);
        } else {
            viewHolder.summaryText.setVisibility(0);
            viewHolder.summaryText.setText(summary);
        }
        if (this.mOnItemClickListener != null) {
            viewHolder.mLayout.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetChoiceListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i11 = 0;
                    if (COUIBottomSheetChoiceListAdapter.this.mIsMultiChoice) {
                        if (viewHolder.checkBox.getState() != 2) {
                            COUIBottomSheetChoiceListAdapter.this.mCheckBoxStates.add(Integer.valueOf(i10));
                        } else {
                            COUIBottomSheetChoiceListAdapter.this.mCheckBoxStates.remove(Integer.valueOf(i10));
                        }
                        if (COUIBottomSheetChoiceListAdapter.this.mCheckBoxStates.contains(Integer.valueOf(i10))) {
                            i11 = 2;
                        }
                        viewHolder.checkBox.setState(i11);
                    } else {
                        if (i10 == COUIBottomSheetChoiceListAdapter.this.mCheckedItem) {
                            COUIBottomSheetChoiceListAdapter.this.mOnItemClickListener.onItemClick(view, i10, 0);
                            return;
                        }
                        boolean isChecked = viewHolder.radioButton.isChecked();
                        i11 = !isChecked ? 1 : 0;
                        viewHolder.radioButton.setChecked(!isChecked);
                        COUIBottomSheetChoiceListAdapter cOUIBottomSheetChoiceListAdapter = COUIBottomSheetChoiceListAdapter.this;
                        cOUIBottomSheetChoiceListAdapter.notifyItemChanged(cOUIBottomSheetChoiceListAdapter.mCheckedItem);
                        COUIBottomSheetChoiceListAdapter.this.mCheckedItem = i10;
                    }
                    COUIBottomSheetChoiceListAdapter.this.mOnItemClickListener.onItemClick(view, i10, i11);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new ViewHolder(LayoutInflater.from(this.mContext).inflate(this.mLayoutResId, viewGroup, false));
    }

    public COUIBottomSheetChoiceListAdapter(Context context, int i10, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, int i11) {
        this(context, i10, charSequenceArr, charSequenceArr2, i11, null, false);
    }
}

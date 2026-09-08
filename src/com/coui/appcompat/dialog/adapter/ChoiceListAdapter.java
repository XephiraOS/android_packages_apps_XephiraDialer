package com.coui.appcompat.dialog.adapter;

import X8.h;
import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.coui.appcompat.checkbox.COUICheckBox;
import f.C0991a;

/* loaded from: classes.dex */
public class ChoiceListAdapter extends BaseAdapter {
    private boolean[] mCheckBoxStates;
    private Context mContext;
    private boolean[] mDisableStatus;
    private int[] mIcons;
    private boolean mIsBottom;
    private boolean mIsMultiChoice;
    private boolean mIsTop;
    private CharSequence[] mItems;
    private int mLayoutResId;
    private MaxCheckedListener mMaxCheckedListener;
    private int mMaxCheckedNum;
    private MultiChoiceItemClickListener mMultiChoiceItemClickListener;
    private CharSequence[] mSummaries;

    /* loaded from: classes.dex */
    public interface MaxCheckedListener {
        void maxCheckedNotice(int i10);
    }

    /* loaded from: classes.dex */
    public interface MultiChoiceItemClickListener {
        void onClick(int i10, boolean z10);
    }

    /* loaded from: classes.dex */
    public static class ViewHolder {
        COUICheckBox checkBox;
        ImageView divider;
        ImageView icon;
        TextView itemText;
        RadioButton radioButton;
        FrameLayout radioLayout;
        TextView summaryText;
        LinearLayout textLayout;
    }

    public ChoiceListAdapter(Context context, int i10, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, boolean[] zArr, boolean z10) {
        this(context, i10, charSequenceArr, charSequenceArr2, zArr, null, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCheckedNum() {
        int i10 = 0;
        for (boolean z10 : this.mCheckBoxStates) {
            if (z10) {
                i10++;
            }
        }
        return i10;
    }

    private void initCheckboxStates(boolean[] zArr) {
        for (int i10 = 0; i10 < zArr.length; i10++) {
            boolean[] zArr2 = this.mCheckBoxStates;
            if (i10 < zArr2.length) {
                zArr2[i10] = zArr[i10];
            } else {
                return;
            }
        }
    }

    private void initCheckboxStatesDisable(boolean[] zArr) {
        for (int i10 = 0; i10 < zArr.length; i10++) {
            boolean[] zArr2 = this.mDisableStatus;
            if (i10 < zArr2.length) {
                zArr2[i10] = zArr[i10];
            } else {
                return;
            }
        }
    }

    private void setPaddingBottom(View view, int i10) {
        if (view == null) {
            return;
        }
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i10);
    }

    public boolean[] getCheckBoxStates() {
        return this.mCheckBoxStates;
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

    public MultiChoiceItemClickListener getMultiChoiceItemClickListener() {
        return this.mMultiChoiceItemClickListener;
    }

    public CharSequence getSummary(int i10) {
        CharSequence[] charSequenceArr = this.mSummaries;
        if (charSequenceArr == null || i10 >= charSequenceArr.length) {
            return null;
        }
        return charSequenceArr[i10];
    }

    @Override // android.widget.Adapter
    public View getView(final int i10, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        int i11;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = LayoutInflater.from(this.mContext).inflate(this.mLayoutResId, viewGroup, false);
            viewHolder.icon = (ImageView) view2.findViewById(h.f4914c);
            viewHolder.textLayout = (LinearLayout) view2.findViewById(h.f4879C0);
            viewHolder.itemText = (TextView) view2.findViewById(R.id.text1);
            viewHolder.summaryText = (TextView) view2.findViewById(h.f4955w0);
            viewHolder.divider = (ImageView) view2.findViewById(h.f4902S);
            if (this.mIsMultiChoice) {
                viewHolder.checkBox = (COUICheckBox) view2.findViewById(h.f4940p);
            } else {
                viewHolder.radioLayout = (FrameLayout) view2.findViewById(h.f4931k0);
                viewHolder.radioButton = (RadioButton) view2.findViewById(h.f4929j0);
            }
            if (this.mDisableStatus[i10]) {
                viewHolder.itemText.setEnabled(false);
                viewHolder.summaryText.setEnabled(false);
                if (this.mIsMultiChoice) {
                    viewHolder.checkBox.setEnabled(false);
                } else {
                    viewHolder.radioButton.setEnabled(false);
                }
                view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.dialog.adapter.ChoiceListAdapter.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view3, MotionEvent motionEvent) {
                        return true;
                    }
                });
            }
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        if (this.mIsMultiChoice) {
            if (this.mCheckBoxStates[i10]) {
                i11 = 2;
            } else {
                i11 = 0;
            }
            viewHolder.checkBox.setState(i11);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.dialog.adapter.ChoiceListAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    View findViewById = view3.findViewById(h.f4940p);
                    boolean z10 = true;
                    if (findViewById instanceof COUICheckBox) {
                        COUICheckBox cOUICheckBox = (COUICheckBox) findViewById;
                        if (cOUICheckBox.getState() == 2) {
                            cOUICheckBox.setState(0);
                            ChoiceListAdapter.this.mCheckBoxStates[i10] = false;
                        } else if (ChoiceListAdapter.this.mMaxCheckedNum > 0 && ChoiceListAdapter.this.mMaxCheckedNum <= ChoiceListAdapter.this.getCheckedNum()) {
                            if (ChoiceListAdapter.this.mMaxCheckedListener != null) {
                                ChoiceListAdapter.this.mMaxCheckedListener.maxCheckedNotice(ChoiceListAdapter.this.mMaxCheckedNum);
                            }
                        } else {
                            cOUICheckBox.setState(2);
                            ChoiceListAdapter.this.mCheckBoxStates[i10] = true;
                        }
                        if (ChoiceListAdapter.this.mMultiChoiceItemClickListener != null) {
                            MultiChoiceItemClickListener multiChoiceItemClickListener = ChoiceListAdapter.this.mMultiChoiceItemClickListener;
                            int i12 = i10;
                            if (cOUICheckBox.getState() != 2) {
                                z10 = false;
                            }
                            multiChoiceItemClickListener.onClick(i12, z10);
                            return;
                        }
                        return;
                    }
                    if (findViewById instanceof CheckBox) {
                        CheckBox checkBox = (CheckBox) findViewById;
                        checkBox.setChecked(!checkBox.isChecked());
                        if (ChoiceListAdapter.this.mMultiChoiceItemClickListener != null) {
                            ChoiceListAdapter.this.mMultiChoiceItemClickListener.onClick(i10, checkBox.isChecked());
                        }
                    }
                }
            });
        } else {
            viewHolder.radioButton.setChecked(this.mCheckBoxStates[i10]);
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
        if (viewHolder.divider != null) {
            if (getCount() != 1 && i10 != getCount() - 1) {
                viewHolder.divider.setVisibility(0);
            } else {
                viewHolder.divider.setVisibility(8);
            }
        }
        int[] iArr = this.mIcons;
        if (iArr != null) {
            Drawable b10 = C0991a.b(this.mContext, iArr[i10]);
            if (b10 != null) {
                viewHolder.icon.setVisibility(0);
                viewHolder.icon.setImageDrawable(b10);
            } else {
                viewHolder.icon.setVisibility(8);
            }
        }
        return view2;
    }

    public void setCheckboxState(int i10, int i11, ListView listView) {
        View childAt;
        COUICheckBox cOUICheckBox;
        boolean z10;
        int firstVisiblePosition = i11 - listView.getFirstVisiblePosition();
        if (firstVisiblePosition < 0 || (childAt = listView.getChildAt(firstVisiblePosition)) == null) {
            return;
        }
        ViewHolder viewHolder = (ViewHolder) childAt.getTag();
        if (this.mIsMultiChoice && (cOUICheckBox = viewHolder.checkBox) != null) {
            cOUICheckBox.setState(i10);
            boolean[] zArr = this.mCheckBoxStates;
            if (i10 == 2) {
                z10 = true;
            } else {
                z10 = false;
            }
            zArr[i11] = z10;
        }
    }

    public void setIcons(int[] iArr) {
        this.mIcons = iArr;
    }

    public void setIsBottom(boolean z10) {
        this.mIsBottom = z10;
    }

    public void setIsTop(boolean z10) {
        this.mIsTop = z10;
    }

    public void setMaxCheckedListener(MaxCheckedListener maxCheckedListener) {
        this.mMaxCheckedListener = maxCheckedListener;
    }

    public void setMultiChoiceItemClickListener(MultiChoiceItemClickListener multiChoiceItemClickListener) {
        this.mMultiChoiceItemClickListener = multiChoiceItemClickListener;
    }

    public ChoiceListAdapter(Context context, int i10, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, boolean[] zArr, boolean[] zArr2, boolean z10) {
        this(context, i10, charSequenceArr, charSequenceArr2, zArr, zArr2, z10, 0);
    }

    @Override // android.widget.Adapter
    public CharSequence getItem(int i10) {
        CharSequence[] charSequenceArr = this.mItems;
        if (charSequenceArr == null) {
            return null;
        }
        return charSequenceArr[i10];
    }

    public ChoiceListAdapter(Context context, int i10, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, boolean[] zArr, boolean[] zArr2, boolean z10, int i11) {
        this.mIsTop = false;
        this.mIsBottom = false;
        this.mContext = context;
        this.mLayoutResId = i10;
        this.mItems = charSequenceArr;
        this.mSummaries = charSequenceArr2;
        this.mIsMultiChoice = z10;
        this.mCheckBoxStates = new boolean[charSequenceArr.length];
        if (zArr != null) {
            initCheckboxStates(zArr);
        }
        this.mDisableStatus = new boolean[this.mItems.length];
        if (zArr2 != null) {
            initCheckboxStatesDisable(zArr2);
        }
        this.mMaxCheckedNum = i11;
    }

    public ChoiceListAdapter(Context context, int i10, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2) {
        this(context, i10, charSequenceArr, charSequenceArr2, null, false);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i10) {
        return i10;
    }
}

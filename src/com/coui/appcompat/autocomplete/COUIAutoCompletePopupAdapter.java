package com.coui.appcompat.autocomplete;

import X8.f;
import Z8.c;
import Z8.e;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coui.appcompat.autocomplete.COUIAutoCompleteHelper;
import java.util.List;

/* loaded from: classes.dex */
public class COUIAutoCompletePopupAdapter extends BaseAdapter {
    private OnDeleteViewOnClickCallback mCallback;
    private Context mContext;
    private List<COUIAutoCompleteHelper.PopupListData> mItemList;
    private int mPopupListItemMinHeight;
    private int mPopupListItemPaddingVertical;
    private int mPopupListPaddingVertical;
    private int mTitleMarginEnd;

    /* loaded from: classes.dex */
    public class ViewHolder {
        ImageView mDel;
        ImageView mIcon;
        LinearLayout mLayout;
        TextView mSummary;
        TextView mTitle;

        private ViewHolder() {
        }
    }

    public COUIAutoCompletePopupAdapter(Context context, List<COUIAutoCompleteHelper.PopupListData> list) {
        this.mContext = context;
        this.mItemList = list;
        Resources resources = context.getResources();
        this.mPopupListPaddingVertical = resources.getDimensionPixelSize(c.f6016f);
        this.mPopupListItemPaddingVertical = resources.getDimensionPixelSize(c.f6006a);
        this.mPopupListItemMinHeight = resources.getDimensionPixelSize(f.f4655b3);
        this.mTitleMarginEnd = resources.getDimensionPixelSize(c.f6008b);
        context.obtainStyledAttributes(new int[]{X8.c.f4364W, X8.c.f4350I}).recycle();
    }

    private void setDelVisible(ImageView imageView, LinearLayout linearLayout, final int i10) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        if (this.mItemList.get(i10).getCanDel()) {
            layoutParams.setMarginEnd(0);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.autocomplete.COUIAutoCompletePopupAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (COUIAutoCompletePopupAdapter.this.mCallback != null) {
                        COUIAutoCompletePopupAdapter.this.mCallback.callback(i10);
                    }
                }
            });
        } else {
            imageView.setVisibility(8);
        }
        linearLayout.setLayoutParams(layoutParams);
    }

    private void setIcon(ImageView imageView, int i10) {
        Drawable icon = this.mItemList.get(i10).getIcon();
        if (icon == null) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageDrawable(icon);
            imageView.setVisibility(0);
        }
    }

    private void setSummary(TextView textView, int i10) {
        String summary = this.mItemList.get(i10).getSummary();
        if (summary == null) {
            textView.setVisibility(8);
        } else {
            textView.setText(summary);
            textView.setVisibility(0);
        }
    }

    private void setTitle(TextView textView, int i10) {
        textView.setText(this.mItemList.get(i10).getTitle());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mItemList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.mItemList.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            ViewHolder viewHolder2 = new ViewHolder();
            View inflate = LayoutInflater.from(this.mContext).inflate(Z8.f.f6163E, viewGroup, false);
            viewHolder2.mLayout = (LinearLayout) inflate.findViewById(e.f6118f0);
            viewHolder2.mIcon = (ImageView) inflate.findViewById(e.f6112c0);
            viewHolder2.mTitle = (TextView) inflate.findViewById(e.f6116e0);
            viewHolder2.mSummary = (TextView) inflate.findViewById(e.f6114d0);
            viewHolder2.mDel = (ImageView) inflate.findViewById(e.f6110b0);
            inflate.setTag(viewHolder2);
            viewHolder = viewHolder2;
            view = inflate;
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (getCount() == 1) {
            view.setMinimumHeight(this.mPopupListItemMinHeight + (this.mPopupListPaddingVertical * 2));
            view.setPaddingRelative(view.getPaddingStart(), this.mPopupListItemPaddingVertical + this.mPopupListPaddingVertical, view.getPaddingEnd(), this.mPopupListItemPaddingVertical + this.mPopupListPaddingVertical);
        } else if (i10 == 0) {
            view.setMinimumHeight(this.mPopupListItemMinHeight + this.mPopupListPaddingVertical);
            view.setPadding(view.getPaddingStart(), this.mPopupListItemPaddingVertical + this.mPopupListPaddingVertical, view.getPaddingEnd(), this.mPopupListItemPaddingVertical);
        } else if (i10 == getCount() - 1) {
            view.setMinimumHeight(this.mPopupListItemMinHeight + this.mPopupListPaddingVertical);
            view.setPadding(view.getPaddingStart(), this.mPopupListItemPaddingVertical, view.getPaddingEnd(), this.mPopupListItemPaddingVertical + this.mPopupListPaddingVertical);
        } else {
            view.setMinimumHeight(this.mPopupListItemMinHeight);
            view.setPadding(view.getPaddingStart(), this.mPopupListItemPaddingVertical, view.getPaddingEnd(), this.mPopupListItemPaddingVertical);
        }
        setIcon(viewHolder.mIcon, i10);
        setTitle(viewHolder.mTitle, i10);
        setSummary(viewHolder.mSummary, i10);
        setDelVisible(viewHolder.mDel, viewHolder.mLayout, i10);
        return view;
    }

    public void setOnDeleteViewOnClickCallback(OnDeleteViewOnClickCallback onDeleteViewOnClickCallback) {
        this.mCallback = onDeleteViewOnClickCallback;
    }

    /* loaded from: classes.dex */
    public interface OnDeleteViewOnClickCallback {
        default void callback(int i10) {
        }
    }
}

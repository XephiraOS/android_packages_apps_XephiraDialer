package com.coui.appcompat.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class COUISupportMenuItem {
    public static final int ITEM_EIGHTH = 7;
    public static final int ITEM_FIFTH = 4;
    public static final int ITEM_FIRST = 0;
    public static final int ITEM_FOURTH = 3;
    public static final int ITEM_NINTH = 8;
    public static final int ITEM_SECOND = 1;
    public static final int ITEM_SEVENTH = 6;
    public static final int ITEM_SIXTH = 5;
    public static final int ITEM_TENTH = 9;
    public static final int ITEM_THIRD = 2;
    private Drawable mBackgroud;
    private Context mContext;
    private Drawable mIcon;
    private OnItemClickListener mOnItemClickListener;
    private String mText;

    /* loaded from: classes.dex */
    public static class Builder {
        private COUISupportMenuItem mCi;

        public Builder(Context context) {
            COUISupportMenuItem cOUISupportMenuItem = new COUISupportMenuItem();
            this.mCi = cOUISupportMenuItem;
            cOUISupportMenuItem.mContext = context;
        }

        public COUISupportMenuItem create() {
            return this.mCi;
        }

        public Builder setBackgroud(Drawable drawable) {
            this.mCi.mBackgroud = drawable;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.mCi.mIcon = drawable;
            return this;
        }

        public Builder setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.mCi.mOnItemClickListener = onItemClickListener;
            return this;
        }

        public Builder setText(String str) {
            this.mCi.mText = str;
            return this;
        }

        public Builder setBackgroud(int i10) {
            COUISupportMenuItem cOUISupportMenuItem = this.mCi;
            cOUISupportMenuItem.mBackgroud = cOUISupportMenuItem.getContext().getResources().getDrawable(i10);
            return this;
        }

        public Builder setIcon(int i10) {
            COUISupportMenuItem cOUISupportMenuItem = this.mCi;
            cOUISupportMenuItem.mIcon = cOUISupportMenuItem.getContext().getResources().getDrawable(i10);
            return this;
        }

        public Builder setText(int i10) {
            COUISupportMenuItem cOUISupportMenuItem = this.mCi;
            cOUISupportMenuItem.mText = cOUISupportMenuItem.getContext().getString(i10);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface OnItemClickListener {
        void onCOUIMenuItemClick(int i10);
    }

    public Drawable getBackgroud() {
        return this.mBackgroud;
    }

    public Context getContext() {
        return this.mContext;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public String getText() {
        return this.mText;
    }

    public void setBackgroud(Drawable drawable) {
        this.mBackgroud = drawable;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setText(String str) {
        this.mText = str;
    }
}

package com.coui.appcompat.floatingactionbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import f.C0991a;

/* loaded from: classes.dex */
public class COUIFloatingButtonItem implements Parcelable {
    public static final Parcelable.Creator<COUIFloatingButtonItem> CREATOR = new Parcelable.Creator<COUIFloatingButtonItem>() { // from class: com.coui.appcompat.floatingactionbutton.COUIFloatingButtonItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public COUIFloatingButtonItem createFromParcel(Parcel parcel) {
            return new COUIFloatingButtonItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public COUIFloatingButtonItem[] newArray(int i10) {
            return new COUIFloatingButtonItem[i10];
        }
    };
    public static final int RESOURCE_NOT_SET = Integer.MIN_VALUE;
    private boolean mCOUIFloatingButtonExpandEnable;
    private final int mCOUIFloatingButtonItemLocation;
    private ColorStateList mFabBackgroundColor;
    private final Drawable mFabImageDrawable;
    private final int mFabImageResource;
    private final String mLabel;
    private ColorStateList mLabelBackgroundColor;
    private ColorStateList mLabelColor;
    private final int mLabelRes;

    /* loaded from: classes.dex */
    public static class Builder {
        private boolean mCOUIFloatingButtonExpandEnable;
        private final int mCOUIFloatingButtonItemLocation;
        private ColorStateList mFabBackgroundColor;
        private Drawable mFabImageDrawable;
        private final int mFabImageResource;
        private String mLabel;
        private ColorStateList mLabelBackgroundColor;
        private ColorStateList mLabelColor;
        private int mLabelRes;

        public Builder(int i10, int i11) {
            this.mLabelRes = Integer.MIN_VALUE;
            this.mFabBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.mLabelColor = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.mLabelBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.mCOUIFloatingButtonExpandEnable = true;
            this.mCOUIFloatingButtonItemLocation = i10;
            this.mFabImageResource = i11;
            this.mFabImageDrawable = null;
        }

        public COUIFloatingButtonItem create() {
            return new COUIFloatingButtonItem(this);
        }

        public Builder setCOUIFloatingButtonExpandEnable(boolean z10) {
            this.mCOUIFloatingButtonExpandEnable = z10;
            return this;
        }

        public Builder setFabBackgroundColor(ColorStateList colorStateList) {
            this.mFabBackgroundColor = colorStateList;
            return this;
        }

        public Builder setLabel(String str) {
            this.mLabel = str;
            return this;
        }

        public Builder setLabelBackgroundColor(ColorStateList colorStateList) {
            this.mLabelBackgroundColor = colorStateList;
            return this;
        }

        public Builder setLabelColor(ColorStateList colorStateList) {
            this.mLabelColor = colorStateList;
            return this;
        }

        public Builder setLabel(int i10) {
            this.mLabelRes = i10;
            return this;
        }

        public Builder(int i10, Drawable drawable) {
            this.mLabelRes = Integer.MIN_VALUE;
            this.mFabBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.mLabelColor = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.mLabelBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.mCOUIFloatingButtonExpandEnable = true;
            this.mCOUIFloatingButtonItemLocation = i10;
            this.mFabImageDrawable = drawable;
            this.mFabImageResource = Integer.MIN_VALUE;
        }

        public Builder(COUIFloatingButtonItem cOUIFloatingButtonItem) {
            this.mLabelRes = Integer.MIN_VALUE;
            this.mFabBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.mLabelColor = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.mLabelBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
            this.mCOUIFloatingButtonExpandEnable = true;
            this.mLabel = cOUIFloatingButtonItem.mLabel;
            this.mLabelRes = cOUIFloatingButtonItem.mLabelRes;
            this.mFabImageResource = cOUIFloatingButtonItem.mFabImageResource;
            this.mFabImageDrawable = cOUIFloatingButtonItem.mFabImageDrawable;
            this.mFabBackgroundColor = cOUIFloatingButtonItem.mFabBackgroundColor;
            this.mLabelColor = cOUIFloatingButtonItem.mLabelColor;
            this.mLabelBackgroundColor = cOUIFloatingButtonItem.mLabelBackgroundColor;
            this.mCOUIFloatingButtonExpandEnable = cOUIFloatingButtonItem.mCOUIFloatingButtonExpandEnable;
            this.mCOUIFloatingButtonItemLocation = cOUIFloatingButtonItem.mCOUIFloatingButtonItemLocation;
        }
    }

    public COUIFloatingButtonLabel createFabWithLabelView(Context context) {
        COUIFloatingButtonLabel cOUIFloatingButtonLabel = new COUIFloatingButtonLabel(context);
        cOUIFloatingButtonLabel.setFloatingButtonItem(this);
        return cOUIFloatingButtonLabel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ColorStateList getFabBackgroundColor() {
        return this.mFabBackgroundColor;
    }

    public Drawable getFabImageDrawable(Context context) {
        Drawable drawable = this.mFabImageDrawable;
        if (drawable != null) {
            return drawable;
        }
        int i10 = this.mFabImageResource;
        if (i10 != Integer.MIN_VALUE) {
            return C0991a.b(context, i10);
        }
        return null;
    }

    public int getFloatingButtonItemLocation() {
        return this.mCOUIFloatingButtonItemLocation;
    }

    public String getLabel(Context context) {
        String str = this.mLabel;
        if (str != null) {
            return str;
        }
        int i10 = this.mLabelRes;
        if (i10 != Integer.MIN_VALUE) {
            return context.getString(i10);
        }
        return null;
    }

    public ColorStateList getLabelBackgroundColor() {
        return this.mLabelBackgroundColor;
    }

    public ColorStateList getLabelColor() {
        return this.mLabelColor;
    }

    public boolean isCOUIFloatingButtonExpandEnable() {
        return this.mCOUIFloatingButtonExpandEnable;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mLabel);
        parcel.writeInt(this.mLabelRes);
        parcel.writeInt(this.mFabImageResource);
        parcel.writeInt(this.mCOUIFloatingButtonItemLocation);
    }

    private COUIFloatingButtonItem(Builder builder) {
        this.mFabBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mLabelColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mLabelBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mCOUIFloatingButtonExpandEnable = true;
        this.mLabel = builder.mLabel;
        this.mLabelRes = builder.mLabelRes;
        this.mFabImageResource = builder.mFabImageResource;
        this.mFabImageDrawable = builder.mFabImageDrawable;
        this.mFabBackgroundColor = builder.mFabBackgroundColor;
        this.mLabelColor = builder.mLabelColor;
        this.mLabelBackgroundColor = builder.mLabelBackgroundColor;
        this.mCOUIFloatingButtonExpandEnable = builder.mCOUIFloatingButtonExpandEnable;
        this.mCOUIFloatingButtonItemLocation = builder.mCOUIFloatingButtonItemLocation;
    }

    public COUIFloatingButtonItem(Parcel parcel) {
        this.mFabBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mLabelColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mLabelBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mCOUIFloatingButtonExpandEnable = true;
        this.mLabel = parcel.readString();
        this.mLabelRes = parcel.readInt();
        this.mFabImageResource = parcel.readInt();
        this.mFabImageDrawable = null;
        this.mCOUIFloatingButtonItemLocation = parcel.readInt();
    }
}

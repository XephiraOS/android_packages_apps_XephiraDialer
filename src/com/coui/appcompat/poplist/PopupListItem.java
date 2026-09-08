package com.coui.appcompat.poplist;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PopupListItem {
    public static final int MENU_GROUP_ITEM_ACTIVATED_IN_MAIN = 1;
    public static final int MENU_GROUP_ITEM_ACTIVATED_IN_SUB = 2;
    public static final int MENU_GROUP_ITEM_INACTIVE = 0;
    public static final int MENU_HINT_TYPE_CUSTOM = 1;
    public static final int MENU_HINT_TYPE_NONE = -1;
    public static final int MENU_HINT_TYPE_RED_DOT = 0;
    public static final int MENU_ITEM_FORCE_TINT_ALL = 7;
    public static final int MENU_ITEM_FORCE_TINT_ICON = 1;
    public static final int MENU_ITEM_FORCE_TINT_NONE = 0;
    public static final int MENU_ITEM_FORCE_TINT_STATE_ICON = 4;
    public static final int MENU_ITEM_FORCE_TINT_TITLE = 2;
    public static final int MENU_ITEM_TYPE_ALERT = 1;
    public static final int MENU_ITEM_TYPE_CUSTOM = 2;
    public static final int MENU_ITEM_TYPE_DEFAULT = 0;
    public static final int MENU_ITEM_TYPE_HEADER = 3;
    private View mCustomHintView;
    private View mCustomItemView;
    private String mDescription;
    private int mForceTint;
    private int mGroupId;
    private int mGroupState;
    private int mHintType;
    private Drawable mIcon;
    private int mIconId;
    private int mId;
    private boolean mIsChecked;
    private boolean mIsEnable;
    private int mItemType;
    private int mRedDotAmount;
    private String mRedDotText;
    private Drawable mStateIcon;
    private int mStateIconId;
    private ArrayList<PopupListItem> mSubMenuItemList;
    private String mTitle;
    private ColorStateList mTitleColor;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface PopupMenuGroupState {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface PopupMenuItemHintType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface PopupMenuItemType {
    }

    public PopupListItem() {
        this.mId = -1;
        this.mGroupId = 0;
        this.mItemType = 0;
        this.mHintType = -1;
        this.mGroupState = 0;
        this.mForceTint = 7;
        this.mRedDotAmount = -1;
        this.mIconId = 0;
        this.mStateIconId = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apply(Builder builder) {
        this.mId = builder.mId;
        this.mIconId = builder.mIconId;
        this.mIcon = builder.mIcon;
        this.mIsEnable = builder.mIsEnable;
        this.mTitle = builder.mTitle;
        this.mDescription = builder.mDescription;
        this.mItemType = builder.mItemType;
        this.mIsChecked = builder.mIsChecked;
        this.mStateIconId = builder.mStateIconId;
        this.mStateIcon = builder.mStateIcon;
        this.mHintType = builder.mHintType;
        this.mRedDotText = builder.mRedDotText;
        this.mRedDotAmount = builder.mRedDotAmount;
        this.mForceTint = builder.mForceTint;
        ColorStateList colorStateList = builder.mTitleColor;
        this.mTitleColor = colorStateList;
        if (colorStateList != null) {
            this.mForceTint &= -3;
        }
        if (this.mHintType == 1) {
            this.mCustomHintView = builder.mCustomHintView;
            builder.mCustomHintView = null;
        }
        this.mGroupId = builder.mGroupId;
        if (builder.mSubMenuItemList != null) {
            this.mSubMenuItemList = builder.mSubMenuItemList;
            builder.mSubMenuItemList = null;
        }
        this.mCustomItemView = builder.mCustomItemView;
    }

    public View getCustomHintView() {
        return this.mCustomHintView;
    }

    public View getCustomItemView() {
        return this.mCustomItemView;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getForceTint() {
        return this.mForceTint;
    }

    public int getGroupId() {
        return this.mGroupId;
    }

    public int getGroupState() {
        return this.mGroupState;
    }

    public int getHintType() {
        return this.mHintType;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public int getIconId() {
        return this.mIconId;
    }

    public int getId() {
        return this.mId;
    }

    @Deprecated
    public int getItemColorSpecial() {
        return -1;
    }

    public int getItemType() {
        return this.mItemType;
    }

    @Deprecated
    public Drawable getOperateIcon() {
        return this.mStateIcon;
    }

    public int getRedDotAmount() {
        return this.mRedDotAmount;
    }

    public String getRedDotText() {
        return this.mRedDotText;
    }

    public Drawable getStateIcon() {
        return this.mStateIcon;
    }

    public int getStateIconId() {
        return this.mStateIconId;
    }

    @Deprecated
    public ArrayList<PopupListItem> getSubArray() {
        return this.mSubMenuItemList;
    }

    public ArrayList<PopupListItem> getSubMenuItemList() {
        return this.mSubMenuItemList;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Deprecated
    public int getTitleColorInt() {
        return -1;
    }

    public ColorStateList getTitleColorList() {
        return this.mTitleColor;
    }

    @Deprecated
    public boolean hasSubArray() {
        return hasSubMenu();
    }

    public boolean hasSubMenu() {
        ArrayList<PopupListItem> arrayList = this.mSubMenuItemList;
        if (arrayList != null && !arrayList.isEmpty()) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean isCheckable() {
        return true;
    }

    public boolean isChecked() {
        return this.mIsChecked;
    }

    public boolean isEnable() {
        return this.mIsEnable;
    }

    public void setChecked(boolean z10) {
        this.mIsChecked = z10;
    }

    public void setCustomHintView(View view) {
        this.mCustomHintView = view;
    }

    public void setCustomItemView(View view) {
        this.mCustomItemView = view;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setEnable(boolean z10) {
        this.mIsEnable = z10;
    }

    public void setForceTint(int i10) {
        this.mForceTint = i10;
    }

    public void setGroupId(int i10) {
        this.mGroupId = i10;
    }

    public void setGroupState(int i10) {
        this.mGroupState = i10;
    }

    public void setHintType(int i10) {
        this.mHintType = i10;
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
    }

    public void setIconId(int i10) {
        this.mIconId = i10;
    }

    public void setId(int i10) {
        this.mId = i10;
    }

    public void setItemType(int i10) {
        this.mItemType = i10;
    }

    @Deprecated
    public void setOperateIcon(Drawable drawable) {
        this.mStateIcon = drawable;
    }

    public void setRedDotAmount(int i10) {
        this.mRedDotAmount = i10;
    }

    public void setRedDotText(String str) {
        this.mRedDotText = str;
    }

    public void setStateIcon(Drawable drawable) {
        this.mStateIcon = drawable;
    }

    public void setStateIconId(int i10) {
        this.mStateIconId = i10;
    }

    @Deprecated
    public void setSubArray(ArrayList<PopupListItem> arrayList) {
        this.mSubMenuItemList = arrayList;
    }

    public void setSubMenuItemList(ArrayList<PopupListItem> arrayList) {
        this.mSubMenuItemList = arrayList;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setTitleColorList(ColorStateList colorStateList) {
        this.mTitleColor = colorStateList;
    }

    @Deprecated
    public PopupListItem(String str, boolean z10) {
        this((Drawable) null, str, z10);
    }

    @Deprecated
    public PopupListItem(int i10, String str, boolean z10) {
        this.mId = -1;
        this.mGroupId = 0;
        this.mItemType = 0;
        this.mHintType = -1;
        this.mGroupState = 0;
        this.mForceTint = 7;
        this.mRedDotAmount = -1;
        this.mStateIconId = 0;
        this.mIconId = i10;
        this.mTitle = str;
        this.mIsEnable = z10;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private String mDescription;
        private String mRedDotText;
        private String mTitle;
        private int mId = -1;
        private int mIconId = 0;
        private int mGroupId = 0;
        private int mStateIconId = 0;
        private int mRedDotAmount = -1;
        private int mForceTint = 7;
        private int mItemType = 0;
        private int mHintType = -1;
        private boolean mIsEnable = true;
        private boolean mIsChecked = false;
        private Drawable mIcon = null;
        private Drawable mStateIcon = null;
        private ColorStateList mTitleColor = null;
        private ArrayList<PopupListItem> mSubMenuItemList = null;
        private View mCustomHintView = null;
        private View mCustomItemView = null;

        public PopupListItem build() {
            PopupListItem popupListItem = new PopupListItem();
            popupListItem.apply(this);
            return popupListItem;
        }

        public Builder reset() {
            this.mId = -1;
            this.mIconId = 0;
            this.mIcon = null;
            this.mIsEnable = true;
            this.mTitle = null;
            this.mDescription = null;
            this.mItemType = 0;
            this.mTitleColor = null;
            this.mIsChecked = false;
            this.mStateIconId = 0;
            this.mStateIcon = null;
            this.mHintType = -1;
            this.mRedDotText = null;
            this.mRedDotAmount = -1;
            this.mForceTint = 7;
            this.mCustomHintView = null;
            this.mGroupId = 0;
            this.mSubMenuItemList = null;
            this.mCustomItemView = null;
            return this;
        }

        public Builder setCustomHintView(View view) {
            this.mCustomHintView = view;
            return this;
        }

        public Builder setCustomItemView(View view) {
            this.mCustomItemView = view;
            return this;
        }

        public Builder setDescription(String str) {
            this.mDescription = str;
            return this;
        }

        public Builder setForceTint(int i10) {
            this.mForceTint = i10;
            return this;
        }

        public Builder setGroupId(int i10) {
            this.mGroupId = i10;
            return this;
        }

        public Builder setHintType(int i10) {
            this.mHintType = i10;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.mIcon = drawable;
            return this;
        }

        public Builder setIconId(int i10) {
            this.mIconId = i10;
            return this;
        }

        public Builder setId(int i10) {
            this.mId = i10;
            return this;
        }

        public Builder setIsChecked(boolean z10) {
            this.mIsChecked = z10;
            return this;
        }

        public Builder setIsEnable(boolean z10) {
            this.mIsEnable = z10;
            return this;
        }

        public Builder setItemType(int i10) {
            this.mItemType = i10;
            return this;
        }

        @Deprecated
        public Builder setOperateIcon(Drawable drawable) {
            this.mStateIcon = drawable;
            return this;
        }

        public Builder setRedDotAmount(int i10) {
            this.mRedDotAmount = i10;
            return this;
        }

        public Builder setRedDotText(String str) {
            this.mRedDotText = str;
            return this;
        }

        public Builder setStateIcon(Drawable drawable) {
            this.mStateIcon = drawable;
            return this;
        }

        public Builder setStateIconId(int i10) {
            this.mStateIconId = i10;
            return this;
        }

        @Deprecated
        public Builder setSubArray(ArrayList<PopupListItem> arrayList) {
            this.mSubMenuItemList = arrayList;
            return this;
        }

        public Builder setSubMenuItemList(ArrayList<PopupListItem> arrayList) {
            this.mSubMenuItemList = arrayList;
            return this;
        }

        public Builder setTitle(String str) {
            this.mTitle = str;
            return this;
        }

        public Builder setTitleColorList(ColorStateList colorStateList) {
            this.mTitleColor = colorStateList;
            return this;
        }

        @Deprecated
        public Builder setHasSubArray(boolean z10) {
            return this;
        }

        @Deprecated
        public Builder setIsCheckable(boolean z10) {
            return this;
        }

        @Deprecated
        public Builder setIsClickSubArray(boolean z10) {
            return this;
        }

        @Deprecated
        public Builder setItemColorSpecial(int i10) {
            return this;
        }

        @Deprecated
        public Builder setTitleColorInt(int i10) {
            return this;
        }
    }

    @Deprecated
    public void setCheckable(boolean z10) {
    }

    @Deprecated
    public void setHasSubArray(boolean z10) {
    }

    @Deprecated
    public void setItemColorSpecial(int i10) {
    }

    @Deprecated
    public void setTitleColorInt(int i10) {
    }

    @Deprecated
    public PopupListItem(String str, boolean z10, int i10) {
        this((Drawable) null, str, z10);
        this.mGroupId = i10;
    }

    @Deprecated
    public PopupListItem(Drawable drawable, String str, boolean z10) {
        this(drawable, str, z10, -1);
    }

    @Deprecated
    public PopupListItem(Drawable drawable, String str, boolean z10, int i10) {
        this(drawable, str, false, false, i10, z10);
    }

    @Deprecated
    public PopupListItem(Drawable drawable, String str, boolean z10, boolean z11) {
        this(drawable, str, z10, false, z11);
    }

    @Deprecated
    public PopupListItem(Drawable drawable, String str, boolean z10, boolean z11, boolean z12) {
        this(drawable, str, z10, z11, -1, z12);
    }

    @Deprecated
    public PopupListItem(Drawable drawable, String str, boolean z10, boolean z11, int i10, boolean z12) {
        this(drawable, str, z10, z11, i10, z12, null);
    }

    @Deprecated
    public PopupListItem(Drawable drawable, String str, boolean z10, boolean z11, int i10, boolean z12, ArrayList<PopupListItem> arrayList) {
        this(drawable, str, z10, z11, i10, z12, arrayList, null);
    }

    @Deprecated
    public PopupListItem(Drawable drawable, String str, boolean z10, boolean z11, int i10, boolean z12, ArrayList<PopupListItem> arrayList, String str2) {
        this(drawable, str, z10, z11, i10, z12, arrayList, str2, null);
    }

    @Deprecated
    public PopupListItem(Drawable drawable, String str, boolean z10, boolean z11, int i10, boolean z12, ArrayList<PopupListItem> arrayList, String str2, Drawable drawable2) {
        this(drawable, str, z10, z11, i10, z12, arrayList, str2, drawable2, -1);
    }

    @Deprecated
    public PopupListItem(Drawable drawable, String str, boolean z10, boolean z11, int i10, boolean z12, ArrayList<PopupListItem> arrayList, String str2, Drawable drawable2, int i11) {
        this(drawable, str, z10, z11, i10, z12, arrayList, str2, drawable2, i11, -1);
    }

    @Deprecated
    public PopupListItem(Drawable drawable, String str, boolean z10, boolean z11, int i10, boolean z12, ArrayList<PopupListItem> arrayList, String str2, Drawable drawable2, int i11, int i12) {
        this.mId = -1;
        this.mItemType = 0;
        this.mHintType = -1;
        this.mGroupState = 0;
        this.mForceTint = 7;
        this.mIconId = 0;
        this.mStateIconId = 0;
        this.mIcon = drawable;
        this.mTitle = str;
        this.mIsChecked = z11;
        this.mIsEnable = z12;
        this.mRedDotAmount = i10;
        this.mSubMenuItemList = arrayList;
        this.mRedDotText = str2;
        this.mStateIcon = drawable2;
        this.mGroupId = i12;
    }
}

package com.coui.appcompat.poplist;

import X8.n;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.view.K;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.reddot.COUIHintRedDot;
import com.coui.appcompat.state.COUIMaskEffectDrawable;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.coui.appcompat.uiutil.UIUtil;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class DefaultAdapter extends BaseAdapter {
    private static final float DESCRIPTION_TEXT_SIZE_DP = 12.0f;
    private static final int FLAG_DESCRIPTION = 2;
    private static final int FLAG_HAS_SUB_MENU = 16;
    private static final int FLAG_HINT = 4;
    private static final int FLAG_ICON = 1;
    private static final int FLAG_STATE_ICON = 8;
    private static final String TAG = "DefaultAdapter";
    private static final int TITLE_MAX_LINE_WITHOUT_DESCRIPTION = 3;
    private static final int TITLE_MAX_LINE_WITH_DESCRIPTION = 2;
    private static final float TITLE_TEXT_SIZE_DP = 16.0f;
    public static final int TYPE_DIVIDER_DEFAULT = 1;
    public static final int TYPE_DIVIDER_GROUP = 2;
    public static final int TYPE_DIVIDER_HEADER = 5;
    public static final int TYPE_ITEM_CUSTOM = 3;
    public static final int TYPE_ITEM_DEFAULT = 0;
    public static final int TYPE_ITEM_HEADER = 4;
    private static final int VIEW_TYPE_COUNT = 6;
    private int mAlertColor;
    private final Context mContext;
    private int mDefaultDividerHeight;
    private int mDefaultDividerMarginHorizontal;
    private int mDefaultDividerMarginStartWithIcon;
    private int mDescriptionColor;
    private int mGroupDividerHeight;
    private boolean mHasSubMenuHeader;
    private ColorStateList mItemTintList;
    private List<PopupListItem> mMenuItemList;
    private int mPopupListItemMinHeight;
    private int mPopupListItemPaddingVertical;
    private int mPopupListMenuItemMinHeight;
    private int mPopupListPaddingVertical;
    private ListItemMaskEffectDrawable mSharedDrawable;
    private ColorStateList mStateIconTintList;
    private static final int[] STATE_SELECTED = {16842910, 16842913};
    private static final int[] STATE_DISABLED = {-16842910};
    private static final Drawable DEFAULT_TRANSPARENT_HOLDER = new ColorDrawable(0);
    private static final Typeface MEDIUM_TYPEFACE = Typeface.create(COUIChangeTextUtil.MEDIUM_FONT, 0);
    private final View.AccessibilityDelegate mAccessibilityDelegate = new View.AccessibilityDelegate() { // from class: com.coui.appcompat.poplist.DefaultAdapter.1
        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("");
        }
    };
    private int mPrivateFlags = 0;
    private boolean mIsAdaptiveFontSize = false;
    private boolean mIsFixedFontSize = false;
    private Set<Integer> mGroupSets = null;

    /* loaded from: classes.dex */
    public static class HeaderViewHolder {
        TextView mTitle;

        /* JADX INFO: Access modifiers changed from: private */
        public void initViewHolder(View view) {
            this.mTitle = (TextView) view.findViewById(X8.h.f4909Z);
        }
    }

    /* loaded from: classes.dex */
    public static class ViewHolder {
        CheckBox mCheckbox;
        TextView mDescription;
        Space mHintEndGap;
        LinearLayout mHintLayout;
        ImageView mIcon;
        TextView mTitle;
        Space mTitleEndGap;

        /* JADX INFO: Access modifiers changed from: private */
        public void initViewHolder(View view) {
            this.mIcon = (ImageView) view.findViewById(X8.h.f4917d0);
            this.mTitle = (TextView) view.findViewById(X8.h.f4921f0);
            this.mDescription = (TextView) view.findViewById(X8.h.f4911a0);
            this.mTitleEndGap = (Space) view.findViewById(X8.h.f4923g0);
            this.mHintLayout = (LinearLayout) view.findViewById(X8.h.f4915c0);
            this.mHintEndGap = (Space) view.findViewById(X8.h.f4913b0);
            this.mCheckbox = (CheckBox) view.findViewById(X8.h.f4919e0);
        }
    }

    public DefaultAdapter(Context context, List<PopupListItem> list) {
        this.mContext = context;
        setItemList(list);
        Resources resources = context.getResources();
        this.mDefaultDividerHeight = resources.getDimensionPixelSize(X8.f.f4590S2);
        this.mGroupDividerHeight = resources.getDimensionPixelSize(X8.f.f4597T2);
        this.mPopupListPaddingVertical = resources.getDimensionPixelSize(X8.f.f4604U2);
        this.mPopupListItemPaddingVertical = resources.getDimensionPixelSize(X8.f.f4663c3);
        this.mPopupListMenuItemMinHeight = resources.getDimensionPixelSize(X8.f.f4639Z2);
        this.mPopupListItemMinHeight = resources.getDimensionPixelSize(X8.f.f4655b3);
        this.mDefaultDividerMarginStartWithIcon = resources.getDimensionPixelSize(X8.f.f4583R2);
        this.mDefaultDividerMarginHorizontal = resources.getDimensionPixelSize(X8.f.f4576Q2);
        this.mItemTintList = UIUtil.getColorStateListCompatNoCache(context, X8.e.f4457w);
        this.mStateIconTintList = UIUtil.getColorStateListCompatNoCache(context, X8.e.f4456v);
        this.mAlertColor = COUIContextUtil.getAttrColor(context, X8.c.f4402r, X8.e.f4443i);
        this.mDescriptionColor = COUIContextUtil.getAttrColor(context, X8.c.f4418z, X8.e.f4445k);
    }

    private void configItemVerticalPadding(View view, int i10) {
        if (this.mMenuItemList.size() == 1) {
            view.setMinimumHeight(this.mPopupListItemMinHeight + (this.mPopupListPaddingVertical * 2));
            view.setPadding(view.getPaddingStart(), this.mPopupListItemPaddingVertical + this.mPopupListPaddingVertical, view.getPaddingEnd(), this.mPopupListItemPaddingVertical + this.mPopupListPaddingVertical);
        } else if (i10 == 0) {
            view.setMinimumHeight(this.mPopupListItemMinHeight + this.mPopupListPaddingVertical);
            view.setPadding(view.getPaddingStart(), this.mPopupListItemPaddingVertical + this.mPopupListPaddingVertical, view.getPaddingEnd(), this.mPopupListItemPaddingVertical);
        } else if (i10 == this.mMenuItemList.size() - 1) {
            view.setMinimumHeight(this.mPopupListItemMinHeight + this.mPopupListPaddingVertical);
            view.setPadding(view.getPaddingStart(), this.mPopupListItemPaddingVertical, view.getPaddingEnd(), this.mPopupListItemPaddingVertical + this.mPopupListPaddingVertical);
        } else {
            view.setMinimumHeight(this.mPopupListItemMinHeight);
            view.setPadding(view.getPaddingStart(), this.mPopupListItemPaddingVertical, view.getPaddingEnd(), this.mPopupListItemPaddingVertical);
        }
    }

    private void configStateEffectBackground(View view, PopupListItem popupListItem) {
        ListItemMaskEffectDrawable listItemMaskEffectDrawable;
        if (popupListItem != null && popupListItem.hasSubMenu() && popupListItem.getGroupState() != 2 && !(view.getBackground() instanceof ListItemMaskEffectDrawable)) {
            view.setBackground(new ListItemMaskEffectDrawable(this.mContext, 1, null));
        } else if (popupListItem != null && popupListItem.hasSubMenu() && popupListItem.getGroupState() == 2 && (listItemMaskEffectDrawable = this.mSharedDrawable) != null) {
            view.setBackground(listItemMaskEffectDrawable.getChild());
        } else if (!(view.getBackground() instanceof COUIMaskEffectDrawable)) {
            COUIMaskEffectDrawable cOUIMaskEffectDrawable = new COUIMaskEffectDrawable(this.mContext, 1);
            cOUIMaskEffectDrawable.enableFocusedState(false);
            cOUIMaskEffectDrawable.setIsRoundStyle(false);
            view.setBackground(cOUIMaskEffectDrawable);
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.poplist.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean lambda$configStateEffectBackground$0;
                lambda$configStateEffectBackground$0 = DefaultAdapter.lambda$configStateEffectBackground$0(view2, motionEvent);
                return lambda$configStateEffectBackground$0;
            }
        });
    }

    public static int dataIndexToRealPosition(int i10) {
        return i10 * 2;
    }

    @Deprecated
    public static final int dataindexToRealPosition(int i10) {
        return (i10 * 2) - 1;
    }

    private static View.AccessibilityDelegate getAccessibilityDelegate(final int i10) {
        return new View.AccessibilityDelegate() { // from class: com.coui.appcompat.poplist.DefaultAdapter.2
            @Override // android.view.View.AccessibilityDelegate
            public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
                super.performAccessibilityAction(view, i11, bundle);
                if (i11 == 16) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof COUITouchListView) {
                        COUITouchListView cOUITouchListView = (COUITouchListView) parent;
                        int firstVisiblePosition = i10 - cOUITouchListView.getFirstVisiblePosition();
                        cOUITouchListView.performItemClick(cOUITouchListView.getChildAt(firstVisiblePosition), firstVisiblePosition, cOUITouchListView.getItemIdAtPosition(firstVisiblePosition));
                        return true;
                    }
                    return true;
                }
                return true;
            }
        };
    }

    private View getCustomItemView(int i10, View view, ViewGroup viewGroup) {
        PopupListItem popupListItem = this.mMenuItemList.get(realPositionToDataIndex(i10));
        View customItemView = popupListItem.getCustomItemView();
        if (customItemView == null) {
            Log.e(TAG, "Popup list item custom view is null! Return an empty view.");
            customItemView = new View(viewGroup.getContext());
        }
        if (view == null) {
            customItemView.setClickable(true);
            view = customItemView;
        }
        view.setAccessibilityDelegate(getAccessibilityDelegate(i10));
        configStateEffectBackground(view, popupListItem);
        view.setEnabled(popupListItem.isEnable());
        return customItemView;
    }

    private InsetDrawable getDefaultDividerDrawable(boolean z10) {
        int i10;
        int i11;
        boolean isLayoutRTL = isLayoutRTL();
        if (isLayoutRTL) {
            i10 = this.mDefaultDividerMarginHorizontal;
        } else if (!z10 && hasIcon()) {
            i10 = this.mDefaultDividerMarginStartWithIcon;
        } else {
            i10 = this.mDefaultDividerMarginHorizontal;
        }
        int i12 = i10;
        if (isLayoutRTL) {
            if (!z10 && hasIcon()) {
                i11 = this.mDefaultDividerMarginStartWithIcon;
            } else {
                i11 = this.mDefaultDividerMarginHorizontal;
            }
        } else {
            i11 = this.mDefaultDividerMarginHorizontal;
        }
        return new InsetDrawable((Drawable) new ColorDrawable(COUIContextUtil.getAttrColor(this.mContext, X8.c.f4400q)), i12, 0, i11, 0);
    }

    private View getDefaultDividerView(View view, boolean z10) {
        if (view == null) {
            View view2 = new View(this.mContext);
            K.t0(view2, 2);
            COUIDarkModeUtil.setForceDarkAllow(view2, false);
            view2.setBackground(getDefaultDividerDrawable(z10));
            view2.setLayoutParams(new ViewGroup.LayoutParams(-1, this.mDefaultDividerHeight));
            view2.setFocusable(false);
            return view2;
        }
        return view;
    }

    private View getDefaultItemView(int i10, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        int realPositionToDataIndex = realPositionToDataIndex(i10);
        if (view != null && (view.getTag() instanceof ViewHolder)) {
            viewHolder = (ViewHolder) view.getTag();
        } else {
            ViewHolder viewHolder2 = new ViewHolder();
            View inflate = LayoutInflater.from(this.mContext).inflate(X8.j.f4980k, viewGroup, false);
            viewHolder2.initViewHolder(inflate);
            inflate.setClickable(true);
            CheckBox checkBox = viewHolder2.mCheckbox;
            if (checkBox != null) {
                checkBox.setAccessibilityDelegate(this.mAccessibilityDelegate);
                viewHolder2.mCheckbox.setBackground(null);
            }
            inflate.setTag(viewHolder2);
            viewHolder = viewHolder2;
            view = inflate;
        }
        view.setAccessibilityDelegate(getAccessibilityDelegate(i10));
        configItemVerticalPadding(view, realPositionToDataIndex);
        PopupListItem popupListItem = this.mMenuItemList.get(realPositionToDataIndex);
        setIcon(viewHolder.mIcon, popupListItem);
        setTitle(viewHolder.mTitle, popupListItem, i10);
        setDescription(viewHolder.mDescription, popupListItem);
        setGap(viewHolder, popupListItem);
        setHint(viewHolder.mHintLayout, popupListItem);
        setStateIcon(viewHolder.mCheckbox, popupListItem);
        view.setEnabled(popupListItem.isEnable());
        configStateEffectBackground(view, popupListItem);
        return view;
    }

    private View getDividerView(int i10, View view, int i11) {
        View groupDividerView;
        if (i11 != 2) {
            if (i11 != 5) {
                groupDividerView = getDefaultDividerView(view, false);
            } else {
                groupDividerView = getDefaultDividerView(view, true);
            }
        } else if (this.mHasSubMenuHeader && i10 == 1) {
            groupDividerView = getDefaultDividerView(view, false);
        } else {
            groupDividerView = getGroupDividerView(view);
        }
        groupDividerView.setFocusable(false);
        return groupDividerView;
    }

    private View getGroupDividerView(View view) {
        if (view == null) {
            View view2 = new View(this.mContext);
            K.t0(view2, 2);
            COUIDarkModeUtil.setForceDarkAllow(view2, false);
            view2.setBackgroundColor(A.h.d(this.mContext.getResources(), X8.e.f4453s, this.mContext.getTheme()));
            view2.setLayoutParams(new ViewGroup.LayoutParams(-1, this.mGroupDividerHeight));
            return view2;
        }
        return view;
    }

    private View getHeaderItemView(int i10, View view, ViewGroup viewGroup) {
        HeaderViewHolder headerViewHolder;
        int realPositionToDataIndex = realPositionToDataIndex(i10);
        if (view != null && (view.getTag() instanceof HeaderViewHolder)) {
            headerViewHolder = (HeaderViewHolder) view.getTag();
        } else {
            HeaderViewHolder headerViewHolder2 = new HeaderViewHolder();
            View inflate = LayoutInflater.from(this.mContext).inflate(X8.j.f4979j, viewGroup, false);
            headerViewHolder2.initViewHolder(inflate);
            inflate.setClickable(false);
            inflate.setTag(headerViewHolder2);
            headerViewHolder = headerViewHolder2;
            view = inflate;
        }
        view.setAccessibilityDelegate(getAccessibilityDelegate(i10));
        configItemVerticalPadding(view, realPositionToDataIndex);
        view.setMinimumHeight(this.mPopupListMenuItemMinHeight);
        headerViewHolder.mTitle.setText(this.mMenuItemList.get(realPositionToDataIndex).getTitle());
        return view;
    }

    private View getItemView(int i10, View view, ViewGroup viewGroup, int i11) {
        if (i11 != 3) {
            if (i11 != 4) {
                return getDefaultItemView(i10, view, viewGroup);
            }
            return getHeaderItemView(i10, view, viewGroup);
        }
        return getCustomItemView(i10, view, viewGroup);
    }

    private View getRedDotHint(PopupListItem popupListItem) {
        COUIHintRedDot cOUIHintRedDot = new COUIHintRedDot(new ContextThemeWrapper(this.mContext, n.f5047s));
        if (!TextUtils.isEmpty(popupListItem.getRedDotText())) {
            cOUIHintRedDot.setPointMode(2);
            cOUIHintRedDot.setPointText(popupListItem.getRedDotText());
        } else {
            cOUIHintRedDot.setPointNumber(popupListItem.getRedDotAmount());
            int redDotAmount = popupListItem.getRedDotAmount();
            if (redDotAmount != -1) {
                if (redDotAmount != 0) {
                    cOUIHintRedDot.setPointMode(2);
                } else {
                    cOUIHintRedDot.setPointMode(1);
                }
            } else {
                cOUIHintRedDot.setPointMode(0);
            }
        }
        return cOUIHintRedDot;
    }

    private int getTintColorByState(ColorStateList colorStateList, PopupListItem popupListItem) {
        return getTintColorByState(colorStateList, popupListItem, false);
    }

    public static boolean isDataIndex(int i10) {
        if (i10 % 2 == 0) {
            return true;
        }
        return false;
    }

    private boolean isLayoutRTL() {
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$configStateEffectBackground$0(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        Drawable background = view.getBackground();
        if (motionEvent.getActionMasked() == 0 && (background instanceof COUIMaskEffectDrawable)) {
            ((COUIMaskEffectDrawable) background).setTouchEntered();
        }
        if ((motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) && (background instanceof COUIMaskEffectDrawable)) {
            ((COUIMaskEffectDrawable) background).setTouchExited();
        }
        return false;
    }

    private boolean listNotEmpty(List<?> list) {
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    public static int realPositionToDataIndex(int i10) {
        return i10 / 2;
    }

    @Deprecated
    public static final int realPositionToDataindex(int i10) {
        return realPositionToDataIndex(i10);
    }

    private void setDescription(TextView textView, PopupListItem popupListItem) {
        if (!TextUtils.isEmpty(popupListItem.getDescription())) {
            textView.setVisibility(0);
            textView.setTextAppearance(n.f5028A);
            textView.setText(popupListItem.getDescription());
            if (this.mIsFixedFontSize) {
                textView.setTextSize(1, 12.0f);
            } else if (this.mIsAdaptiveFontSize) {
                COUIChangeTextUtil.adaptFontSize(textView, 4);
            }
            textView.setTextColor(this.mDescriptionColor);
            textView.setMaxLines(2);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            return;
        }
        textView.setVisibility(8);
    }

    private void setGap(ViewHolder viewHolder, PopupListItem popupListItem) {
        boolean z10;
        boolean z11;
        boolean z12 = false;
        if (popupListItem.getHintType() != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (popupListItem.getStateIcon() == null && popupListItem.getStateIconId() == 0 && popupListItem.isChecked()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (popupListItem.getStateIcon() != null || popupListItem.getStateIconId() != 0 || popupListItem.hasSubMenu() || z11) {
            z12 = true;
        }
        if (!z10 && !z12) {
            viewHolder.mTitleEndGap.setVisibility(8);
            return;
        }
        viewHolder.mTitleEndGap.setVisibility(4);
        if (z10 && z12) {
            viewHolder.mHintEndGap.setVisibility(4);
        } else {
            viewHolder.mHintEndGap.setVisibility(8);
        }
    }

    private void setHint(ViewGroup viewGroup, PopupListItem popupListItem) {
        if (popupListItem.isEnable()) {
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
        }
        viewGroup.removeAllViews();
        if (popupListItem.getHintType() == 0) {
            viewGroup.addView(getRedDotHint(popupListItem), new ViewGroup.LayoutParams(-2, -2));
            return;
        }
        if (popupListItem.getHintType() == 1 && popupListItem.getCustomHintView() != null) {
            ViewParent parent = popupListItem.getCustomHintView().getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(popupListItem.getCustomHintView());
            }
            viewGroup.addView(popupListItem.getCustomHintView());
        }
    }

    private void setIcon(ImageView imageView, PopupListItem popupListItem) {
        Drawable drawable;
        if ((this.mPrivateFlags & 1) != 0) {
            imageView.setVisibility(0);
            if (popupListItem.getIcon() != null) {
                drawable = popupListItem.getIcon();
            } else if (popupListItem.getIconId() != 0) {
                drawable = A.h.f(this.mContext.getResources(), popupListItem.getIconId(), this.mContext.getTheme());
            } else {
                drawable = null;
            }
            if ((popupListItem.getForceTint() & 1) != 0) {
                setIconTint(drawable, this.mItemTintList, popupListItem);
            }
            imageView.setSelected(popupListItem.isChecked());
            imageView.setImageDrawable(drawable);
        } else {
            imageView.setVisibility(8);
        }
        imageView.setEnabled(popupListItem.isEnable());
    }

    private void setIconTint(Drawable drawable, ColorStateList colorStateList, PopupListItem popupListItem) {
        setIconTint(drawable, colorStateList, popupListItem, false);
    }

    private void setStateIcon(CheckBox checkBox, PopupListItem popupListItem) {
        if (popupListItem.getStateIcon() == null && popupListItem.getStateIconId() == 0 && !popupListItem.hasSubMenu() && !popupListItem.isChecked()) {
            checkBox.setVisibility(8);
        } else {
            checkBox.setVisibility(0);
            Drawable drawable = DEFAULT_TRANSPARENT_HOLDER;
            if (popupListItem.hasSubMenu()) {
                drawable = A.h.f(this.mContext.getResources(), X8.g.f4863p, this.mContext.getTheme());
                setIconTint(drawable, this.mStateIconTintList, popupListItem, true);
            } else {
                if (popupListItem.getStateIcon() != null) {
                    drawable = popupListItem.getStateIcon();
                } else if (popupListItem.getStateIconId() != 0) {
                    drawable = A.h.f(this.mContext.getResources(), popupListItem.getStateIconId(), this.mContext.getTheme());
                } else if (popupListItem.isChecked()) {
                    drawable = A.h.f(this.mContext.getResources(), X8.g.f4866s, this.mContext.getTheme());
                }
                if ((popupListItem.getForceTint() & 4) != 0) {
                    setIconTint(drawable, this.mStateIconTintList, popupListItem, true);
                }
            }
            checkBox.setButtonDrawable(drawable);
            checkBox.setChecked(popupListItem.isChecked());
        }
        checkBox.setEnabled(popupListItem.isEnable());
    }

    private void setTextViewTint(TextView textView, ColorStateList colorStateList, PopupListItem popupListItem) {
        if (textView == null) {
            return;
        }
        textView.setTextColor(getTintColorByState(colorStateList, popupListItem));
    }

    private void setTitle(TextView textView, PopupListItem popupListItem, int i10) {
        boolean z10 = !TextUtils.isEmpty(popupListItem.getDescription());
        textView.setTextAppearance(n.f5054z);
        if (popupListItem.getGroupState() == 2 && i10 == 0) {
            textView.setTypeface(MEDIUM_TYPEFACE);
        } else {
            textView.setTypeface(null);
        }
        textView.setText(popupListItem.getTitle());
        if (this.mIsFixedFontSize) {
            textView.setTextSize(1, 16.0f);
        } else if (this.mIsAdaptiveFontSize) {
            COUIChangeTextUtil.adaptFontSize(textView, 4);
        } else {
            COUIChangeTextUtil.adaptFontSize(textView, 5);
        }
        if (z10) {
            textView.setMaxLines(2);
        } else {
            textView.setMaxLines(3);
        }
        textView.setEllipsize(TextUtils.TruncateAt.END);
        if ((popupListItem.getForceTint() & 2) != 0) {
            setTextViewTint(textView, this.mItemTintList, popupListItem);
        } else if (popupListItem.getTitleColorList() != null) {
            textView.setTextColor(popupListItem.getTitleColorList());
        }
        textView.setSelected(popupListItem.isChecked());
        textView.setEnabled(popupListItem.isEnable());
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (!listNotEmpty(this.mMenuItemList)) {
            return 0;
        }
        return dataIndexToRealPosition(this.mMenuItemList.size()) - 1;
    }

    public int getDividerHeight(int i10) {
        if (i10 == 1) {
            return this.mDefaultDividerHeight;
        }
        if (i10 == 2) {
            return this.mGroupDividerHeight;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        if (realPositionToDataIndex(i10) >= this.mMenuItemList.size()) {
            return null;
        }
        return this.mMenuItemList.get(realPositionToDataIndex(i10));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i10) {
        if (isDataIndex(i10)) {
            int realPositionToDataIndex = realPositionToDataIndex(i10);
            if (listNotEmpty(this.mMenuItemList) && realPositionToDataIndex < this.mMenuItemList.size()) {
                int itemType = this.mMenuItemList.get(realPositionToDataIndex).getItemType();
                if (itemType == 2) {
                    return 3;
                }
                if (itemType == 3) {
                    return 4;
                }
                return 0;
            }
            return 0;
        }
        if (isHeaderPosition(i10)) {
            return 5;
        }
        if (isGroupIndex(i10)) {
            return 2;
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i10);
        if (itemViewType != 0) {
            if (itemViewType != 1 && itemViewType != 2) {
                if (itemViewType != 3 && itemViewType != 4) {
                    if (itemViewType != 5) {
                        Log.e(TAG, "View type error!");
                        return null;
                    }
                }
            }
            return getDividerView(i10, view, itemViewType);
        }
        return getItemView(i10, view, viewGroup, itemViewType);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 6;
    }

    public boolean hasIcon() {
        if ((this.mPrivateFlags & 1) != 0) {
            return true;
        }
        return false;
    }

    public boolean hasSubMenu() {
        if ((this.mPrivateFlags & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i10) {
        return isDataIndex(i10);
    }

    public boolean isGroupIndex(int i10) {
        Set<Integer> set = this.mGroupSets;
        if (set == null) {
            return false;
        }
        return set.contains(Integer.valueOf((i10 + 1) / 2));
    }

    public boolean isHeaderPosition(int i10) {
        if (i10 <= 0) {
            return false;
        }
        int realPositionToDataIndex = realPositionToDataIndex(i10 - 1);
        if (!listNotEmpty(this.mMenuItemList) || this.mMenuItemList.get(realPositionToDataIndex).getItemType() != 3) {
            return false;
        }
        return true;
    }

    public void setAdapterFontSize(boolean z10) {
        this.mIsAdaptiveFontSize = z10;
    }

    public void setGroupSets(Set<Integer> set) {
        this.mGroupSets = set;
    }

    public void setIsFixedFontSize(boolean z10) {
        this.mIsFixedFontSize = z10;
    }

    public void setItemList(List<PopupListItem> list) {
        boolean z10;
        this.mMenuItemList = list;
        if (list == null) {
            return;
        }
        PopupListItem popupListItem = list.get(0);
        if (popupListItem != null && popupListItem.getGroupState() != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.mHasSubMenuHeader = z10;
        this.mPrivateFlags = 0;
        for (PopupListItem popupListItem2 : this.mMenuItemList) {
            if (popupListItem2 != null) {
                if (popupListItem2.getIconId() != 0 || popupListItem2.getIcon() != null) {
                    this.mPrivateFlags |= 1;
                }
                if (!TextUtils.isEmpty(popupListItem2.getDescription())) {
                    this.mPrivateFlags |= 2;
                }
                if (popupListItem2.getHintType() != -1) {
                    this.mPrivateFlags |= 4;
                }
                if (popupListItem2.getStateIconId() != 0 || popupListItem2.getStateIcon() != null) {
                    this.mPrivateFlags |= 8;
                }
                if (popupListItem2.hasSubMenu()) {
                    this.mPrivateFlags |= 16;
                }
            }
        }
    }

    public void setSharedBackground(ListItemMaskEffectDrawable listItemMaskEffectDrawable) {
        this.mSharedDrawable = listItemMaskEffectDrawable;
    }

    private int getTintColorByState(ColorStateList colorStateList, PopupListItem popupListItem, boolean z10) {
        if (popupListItem.isEnable()) {
            if (popupListItem.getItemType() == 0) {
                if (!z10 || popupListItem.getGroupState() == 0) {
                    return popupListItem.isChecked() ? colorStateList.getColorForState(STATE_SELECTED, X8.e.f4443i) : colorStateList.getDefaultColor();
                }
                return colorStateList.getColorForState(STATE_SELECTED, X8.e.f4443i);
            }
            if (popupListItem.getItemType() == 1) {
                return this.mAlertColor;
            }
            return colorStateList.getDefaultColor();
        }
        return colorStateList.getColorForState(STATE_DISABLED, X8.e.f4443i);
    }

    private void setIconTint(Drawable drawable, ColorStateList colorStateList, PopupListItem popupListItem, boolean z10) {
        if (drawable == null) {
            return;
        }
        drawable.setTint(getTintColorByState(colorStateList, popupListItem, z10));
    }

    @Deprecated
    public void setGroup(int[] iArr) {
    }

    @Deprecated
    public void setItemTextColor(ColorStateList colorStateList) {
    }

    @Deprecated
    public void setListView(ListView listView) {
    }

    @Deprecated
    public void setMaxLine(int i10) {
    }

    @Deprecated
    public void setSelectItemColor(int i10) {
    }
}

package androidx.appcompat.view.menu;

import C.a;
import D.b;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.view.AbstractC0447b;
import e.h;
import f.C0991a;

/* loaded from: classes.dex */
public final class MenuItemImpl implements b {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int IS_ACTION = 32;
    static final int NO_ICON = 0;
    private static final int SHOW_AS_ACTION_MASK = 3;
    private static final String TAG = "MenuItemImpl";
    private AbstractC0447b mActionProvider;
    private View mActionView;
    private final int mCategoryOrder;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private final int mGroup;
    private Drawable mIconDrawable;
    private final int mId;
    private Intent mIntent;
    private Runnable mItemCallback;
    MenuBuilder mMenu;
    private ContextMenu.ContextMenuInfo mMenuInfo;
    private MenuItem.OnActionExpandListener mOnActionExpandListener;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private char mShortcutNumericChar;
    private int mShowAsAction;
    private SubMenuBuilder mSubMenu;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;
    private int mShortcutNumericModifiers = 4096;
    private int mShortcutAlphabeticModifiers = 4096;
    private int mIconResId = 0;
    private ColorStateList mIconTintList = null;
    private PorterDuff.Mode mIconTintMode = null;
    private boolean mHasIconTint = false;
    private boolean mHasIconTintMode = false;
    private boolean mNeedToApplyIconTint = false;
    private int mFlags = 16;
    private boolean mIsActionViewExpanded = false;

    public MenuItemImpl(MenuBuilder menuBuilder, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.mMenu = menuBuilder;
        this.mId = i11;
        this.mGroup = i10;
        this.mCategoryOrder = i12;
        this.mOrdering = i13;
        this.mTitle = charSequence;
        this.mShowAsAction = i14;
    }

    private static void appendModifier(StringBuilder sb, int i10, int i11, String str) {
        if ((i10 & i11) == i11) {
            sb.append(str);
        }
    }

    private Drawable applyIconTintIfNecessary(Drawable drawable) {
        if (drawable != null && this.mNeedToApplyIconTint && (this.mHasIconTint || this.mHasIconTintMode)) {
            drawable = a.r(drawable).mutate();
            if (this.mHasIconTint) {
                a.o(drawable, this.mIconTintList);
            }
            if (this.mHasIconTintMode) {
                a.p(drawable, this.mIconTintMode);
            }
            this.mNeedToApplyIconTint = false;
        }
        return drawable;
    }

    public void actionFormatChanged() {
        this.mMenu.onItemActionRequestChanged(this);
    }

    @Override // D.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.mShowAsAction & 8) == 0) {
            return false;
        }
        if (this.mActionView == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.mOnActionExpandListener;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionCollapse(this)) {
            return false;
        }
        return this.mMenu.collapseItemActionView(this);
    }

    @Override // D.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!hasCollapsibleActionView()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.mOnActionExpandListener;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionExpand(this)) {
            return false;
        }
        return this.mMenu.expandItemActionView(this);
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // D.b, android.view.MenuItem
    public View getActionView() {
        View view = this.mActionView;
        if (view != null) {
            return view;
        }
        AbstractC0447b abstractC0447b = this.mActionProvider;
        if (abstractC0447b != null) {
            View onCreateActionView = abstractC0447b.onCreateActionView(this);
            this.mActionView = onCreateActionView;
            return onCreateActionView;
        }
        return null;
    }

    @Override // D.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    public Runnable getCallback() {
        return this.mItemCallback;
    }

    @Override // D.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.mGroup;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.mIconDrawable;
        if (drawable != null) {
            return applyIconTintIfNecessary(drawable);
        }
        if (this.mIconResId != 0) {
            Drawable b10 = C0991a.b(this.mMenu.getContext(), this.mIconResId);
            this.mIconResId = 0;
            this.mIconDrawable = b10;
            return applyIconTintIfNecessary(b10);
        }
        return null;
    }

    @Override // D.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.mIconTintList;
    }

    @Override // D.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.mIconTintMode;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.mIntent;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.mId;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mMenuInfo;
    }

    @Override // D.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.mCategoryOrder;
    }

    public int getOrdering() {
        return this.mOrdering;
    }

    public char getShortcut() {
        if (this.mMenu.isQwertyMode()) {
            return this.mShortcutAlphabeticChar;
        }
        return this.mShortcutNumericChar;
    }

    public String getShortcutLabel() {
        int i10;
        char shortcut = getShortcut();
        if (shortcut == 0) {
            return "";
        }
        Resources resources = this.mMenu.getContext().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.mMenu.getContext()).hasPermanentMenuKey()) {
            sb.append(resources.getString(h.f30275o));
        }
        if (this.mMenu.isQwertyMode()) {
            i10 = this.mShortcutAlphabeticModifiers;
        } else {
            i10 = this.mShortcutNumericModifiers;
        }
        appendModifier(sb, i10, 65536, resources.getString(h.f30271k));
        appendModifier(sb, i10, 4096, resources.getString(h.f30267g));
        appendModifier(sb, i10, 2, resources.getString(h.f30266f));
        appendModifier(sb, i10, 1, resources.getString(h.f30272l));
        appendModifier(sb, i10, 4, resources.getString(h.f30274n));
        appendModifier(sb, i10, 8, resources.getString(h.f30270j));
        if (shortcut != '\b') {
            if (shortcut != '\n') {
                if (shortcut != ' ') {
                    sb.append(shortcut);
                } else {
                    sb.append(resources.getString(h.f30273m));
                }
            } else {
                sb.append(resources.getString(h.f30269i));
            }
        } else {
            sb.append(resources.getString(h.f30268h));
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.mSubMenu;
    }

    @Override // D.b
    public AbstractC0447b getSupportActionProvider() {
        return this.mActionProvider;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.mTitle;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.mTitleCondensed;
        if (charSequence == null) {
            return this.mTitle;
        }
        return charSequence;
    }

    public CharSequence getTitleForItemView(MenuView.ItemView itemView) {
        if (itemView != null && itemView.prefersCondensedTitle()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // D.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    public boolean hasCollapsibleActionView() {
        AbstractC0447b abstractC0447b;
        if ((this.mShowAsAction & 8) == 0) {
            return false;
        }
        if (this.mActionView == null && (abstractC0447b = this.mActionProvider) != null) {
            this.mActionView = abstractC0447b.onCreateActionView(this);
        }
        if (this.mActionView == null) {
            return false;
        }
        return true;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        if (this.mSubMenu != null) {
            return true;
        }
        return false;
    }

    public boolean invoke() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.mClickListener;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder.dispatchMenuItemSelected(menuBuilder, this)) {
            return true;
        }
        Runnable runnable = this.mItemCallback;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.mIntent != null) {
            try {
                this.mMenu.getContext().startActivity(this.mIntent);
                return true;
            } catch (ActivityNotFoundException e10) {
                Log.e(TAG, "Can't find activity to handle intent; ignoring", e10);
            }
        }
        AbstractC0447b abstractC0447b = this.mActionProvider;
        if (abstractC0447b != null && abstractC0447b.onPerformDefaultAction()) {
            return true;
        }
        return false;
    }

    public boolean isActionButton() {
        if ((this.mFlags & 32) == 32) {
            return true;
        }
        return false;
    }

    @Override // D.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.mIsActionViewExpanded;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        if ((this.mFlags & 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        if ((this.mFlags & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        if ((this.mFlags & 16) != 0) {
            return true;
        }
        return false;
    }

    public boolean isExclusiveCheckable() {
        if ((this.mFlags & 4) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        AbstractC0447b abstractC0447b = this.mActionProvider;
        if (abstractC0447b != null && abstractC0447b.overridesItemVisibility()) {
            if ((this.mFlags & 8) != 0 || !this.mActionProvider.isVisible()) {
                return false;
            }
            return true;
        }
        if ((this.mFlags & 8) != 0) {
            return false;
        }
        return true;
    }

    public boolean requestsActionButton() {
        if ((this.mShowAsAction & 1) == 1) {
            return true;
        }
        return false;
    }

    public boolean requiresActionButton() {
        if ((this.mShowAsAction & 2) == 2) {
            return true;
        }
        return false;
    }

    public boolean requiresOverflow() {
        if (!requiresActionButton() && !requestsActionButton()) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public void setActionViewExpanded(boolean z10) {
        this.mIsActionViewExpanded = z10;
        this.mMenu.onItemsChanged(false);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        if (this.mShortcutAlphabeticChar == c10) {
            return this;
        }
        this.mShortcutAlphabeticChar = Character.toLowerCase(c10);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setCallback(Runnable runnable) {
        this.mItemCallback = runnable;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        int i10 = this.mFlags;
        int i11 = (z10 ? 1 : 0) | (i10 & (-2));
        this.mFlags = i11;
        if (i10 != i11) {
            this.mMenu.onItemsChanged(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        if ((this.mFlags & 4) != 0) {
            this.mMenu.setExclusiveItemChecked(this);
        } else {
            setCheckedInt(z10);
        }
        return this;
    }

    public void setCheckedInt(boolean z10) {
        int i10;
        int i11 = this.mFlags;
        int i12 = i11 & (-3);
        if (z10) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        int i13 = i10 | i12;
        this.mFlags = i13;
        if (i11 != i13) {
            this.mMenu.onItemsChanged(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        if (z10) {
            this.mFlags |= 16;
        } else {
            this.mFlags &= -17;
        }
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public void setExclusiveCheckable(boolean z10) {
        int i10;
        int i11 = this.mFlags & (-5);
        if (z10) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        this.mFlags = i10 | i11;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.mIconResId = 0;
        this.mIconDrawable = drawable;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // D.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.mIconTintList = colorStateList;
        this.mHasIconTint = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // D.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.mIconTintMode = mode;
        this.mHasIconTintMode = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public void setIsActionButton(boolean z10) {
        if (z10) {
            this.mFlags |= 32;
        } else {
            this.mFlags &= -33;
        }
    }

    public void setMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mMenuInfo = contextMenuInfo;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        if (this.mShortcutNumericChar == c10) {
            return this;
        }
        this.mShortcutNumericChar = c10;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.mOnActionExpandListener = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mClickListener = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.mShortcutNumericChar = c10;
        this.mShortcutAlphabeticChar = Character.toLowerCase(c11);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // D.b, android.view.MenuItem
    public void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 != 0 && i11 != 1 && i11 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.mShowAsAction = i10;
        this.mMenu.onItemActionRequestChanged(this);
    }

    public void setSubMenu(SubMenuBuilder subMenuBuilder) {
        this.mSubMenu = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(getTitle());
    }

    @Override // D.b
    public b setSupportActionProvider(AbstractC0447b abstractC0447b) {
        AbstractC0447b abstractC0447b2 = this.mActionProvider;
        if (abstractC0447b2 != null) {
            abstractC0447b2.reset();
        }
        this.mActionView = null;
        this.mActionProvider = abstractC0447b;
        this.mMenu.onItemsChanged(true);
        AbstractC0447b abstractC0447b3 = this.mActionProvider;
        if (abstractC0447b3 != null) {
            abstractC0447b3.setVisibilityListener(new AbstractC0447b.InterfaceC0110b() { // from class: androidx.appcompat.view.menu.MenuItemImpl.1
                @Override // androidx.core.view.AbstractC0447b.InterfaceC0110b
                public void onActionProviderVisibilityChanged(boolean z10) {
                    MenuItemImpl menuItemImpl = MenuItemImpl.this;
                    menuItemImpl.mMenu.onItemVisibleChanged(menuItemImpl);
                }
            });
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        this.mMenu.onItemsChanged(false);
        SubMenuBuilder subMenuBuilder = this.mSubMenu;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mTitleCondensed = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        if (setVisibleInt(z10)) {
            this.mMenu.onItemVisibleChanged(this);
        }
        return this;
    }

    public boolean setVisibleInt(boolean z10) {
        int i10;
        int i11 = this.mFlags;
        int i12 = i11 & (-9);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        int i13 = i10 | i12;
        this.mFlags = i13;
        if (i11 == i13) {
            return false;
        }
        return true;
    }

    public boolean shouldShowIcon() {
        return this.mMenu.getOptionalIconsVisible();
    }

    public boolean shouldShowShortcut() {
        if (this.mMenu.isShortcutsVisible() && getShortcut() != 0) {
            return true;
        }
        return false;
    }

    public boolean showsTextAsAction() {
        if ((this.mShowAsAction & 4) == 4) {
            return true;
        }
        return false;
    }

    public String toString() {
        CharSequence charSequence = this.mTitle;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // android.view.MenuItem
    public b setContentDescription(CharSequence charSequence) {
        this.mContentDescription = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // D.b, android.view.MenuItem
    public b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public b setTooltipText(CharSequence charSequence) {
        this.mTooltipText = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // D.b, android.view.MenuItem
    public b setActionView(View view) {
        int i10;
        this.mActionView = view;
        this.mActionProvider = null;
        if (view != null && view.getId() == -1 && (i10 = this.mId) > 0) {
            view.setId(i10);
        }
        this.mMenu.onItemActionRequestChanged(this);
        return this;
    }

    @Override // D.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        if (this.mShortcutAlphabeticChar == c10 && this.mShortcutAlphabeticModifiers == i10) {
            return this;
        }
        this.mShortcutAlphabeticChar = Character.toLowerCase(c10);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i10);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // D.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        if (this.mShortcutNumericChar == c10 && this.mShortcutNumericModifiers == i10) {
            return this;
        }
        this.mShortcutNumericChar = c10;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i10);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // D.b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.mShortcutNumericChar = c10;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i10);
        this.mShortcutAlphabeticChar = Character.toLowerCase(c11);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i11);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.mIconDrawable = null;
        this.mIconResId = i10;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        return setTitle(this.mMenu.getContext().getString(i10));
    }

    @Override // D.b, android.view.MenuItem
    public b setActionView(int i10) {
        Context context = this.mMenu.getContext();
        setActionView(LayoutInflater.from(context).inflate(i10, (ViewGroup) new LinearLayout(context), false));
        return this;
    }
}

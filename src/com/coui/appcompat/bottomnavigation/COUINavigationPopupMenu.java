package com.coui.appcompat.bottomnavigation;

import C.a;
import Y8.d;
import Y8.e;
import Y8.f;
import Y8.g;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.view.K;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class COUINavigationPopupMenu implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, View.OnKeyListener, ViewTreeObserver.OnGlobalLayoutListener, View.OnLayoutChangeListener {
    private static final int DROP_DOWN_GRAVITY = 8388693;
    private static final int DROP_DOWN_GRAVITY_RTL = 8388693;
    private static final float POINT_FIVE = 0.5f;
    private final MenuAdapter mAdapter;
    private COUINavigationMenuView mAnchor;
    private final Context mContext;
    private int mDropDownGravity;
    private final LayoutInflater mInflater;
    private ListView mListViewUsedToMeasure;
    private ListPopupWindow mPopup;
    private int mPopupHorizontalMargin;
    private int mPopupMaxHeight;
    private int mPopupVerticalMargin;
    private int mPopupWidth;
    private int mScreenWidth;
    private final float mSuitableFontSize;
    private ViewTreeObserver mTreeObserver;
    private int mUsedSpace;
    private static final int ITEM_LAYOUT = g.f5683b;
    private static final int POPUP_WINDOW_BACKGROUND = e.f5672b;
    private List<COUINavigationItemView> mMenuList = new ArrayList();
    private List<COUINavigationItemView> mVisibleMenus = new ArrayList();

    /* loaded from: classes.dex */
    public class MenuAdapter extends BaseAdapter {
        public MenuAdapter() {
        }

        private void setIcon(ImageView imageView, COUINavigationItemView cOUINavigationItemView) {
            int i10;
            MenuItemImpl itemData = cOUINavigationItemView.getItemData();
            Drawable icon = itemData.getIcon();
            if (icon != null) {
                imageView.setVisibility(0);
                if (icon instanceof AnimatedStateListDrawable) {
                    if (itemData.isChecked()) {
                        i10 = 1;
                    } else {
                        i10 = -1;
                    }
                    imageView.setImageState(new int[]{i10 * R.attr.state_checked}, true);
                } else {
                    Drawable.ConstantState constantState = icon.getConstantState();
                    if (constantState != null) {
                        icon = constantState.newDrawable();
                    }
                    icon = a.r(icon).mutate();
                    a.o(icon, COUINavigationPopupMenu.this.mAnchor.getIconTintList());
                }
            } else {
                imageView.setVisibility(8);
            }
            imageView.setImageDrawable(icon);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return COUINavigationPopupMenu.this.mVisibleMenus.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = COUINavigationPopupMenu.this.mInflater.inflate(COUINavigationPopupMenu.ITEM_LAYOUT, viewGroup, false);
            }
            if (i10 == 0) {
                view.setBackgroundResource(e.f5675e);
            } else if (i10 == getCount() - 1) {
                view.setBackgroundResource(e.f5673c);
            } else {
                view.setBackgroundResource(e.f5674d);
            }
            boolean isEnabled = ((COUINavigationItemView) COUINavigationPopupMenu.this.mVisibleMenus.get(i10)).isEnabled();
            view.setEnabled(isEnabled);
            ImageView imageView = (ImageView) view.findViewById(f.f5679d);
            TextView textView = (TextView) view.findViewById(f.f5680e);
            imageView.setEnabled(isEnabled);
            textView.setEnabled(isEnabled);
            setIcon(imageView, (COUINavigationItemView) COUINavigationPopupMenu.this.mVisibleMenus.get(i10));
            textView.setText(((COUINavigationItemView) COUINavigationPopupMenu.this.mVisibleMenus.get(i10)).getItemData().getTitle());
            textView.setTextColor(COUINavigationPopupMenu.this.mAnchor.getItemTextColor());
            textView.setTextSize(0, COUINavigationPopupMenu.this.mSuitableFontSize);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            if (K.v(viewGroup) == 1) {
                marginLayoutParams.rightMargin = COUINavigationPopupMenu.this.mContext.getResources().getDimensionPixelSize(d.f5658n);
            } else {
                marginLayoutParams.leftMargin = COUINavigationPopupMenu.this.mContext.getResources().getDimensionPixelSize(d.f5658n);
            }
            return view;
        }

        @Override // android.widget.Adapter
        public MenuItemImpl getItem(int i10) {
            return ((COUINavigationItemView) COUINavigationPopupMenu.this.mVisibleMenus.get(i10)).getItemData();
        }
    }

    public COUINavigationPopupMenu(Context context, COUINavigationMenuView cOUINavigationMenuView) {
        this.mContext = context;
        this.mAnchor = cOUINavigationMenuView;
        cOUINavigationMenuView.addOnLayoutChangeListener(this);
        this.mInflater = LayoutInflater.from(context);
        this.mAdapter = new MenuAdapter();
        if (K.v(cOUINavigationMenuView) == 1) {
            this.mDropDownGravity = 8388693;
        } else {
            this.mDropDownGravity = 8388693;
        }
        Resources resources = context.getResources();
        this.mSuitableFontSize = COUIChangeTextUtil.getSuitableFontSize(resources.getDimensionPixelSize(d.f5662r), resources.getConfiguration().fontScale, 5);
        this.mPopupHorizontalMargin = resources.getDimensionPixelOffset(d.f5658n);
        this.mPopupVerticalMargin = resources.getDimensionPixelOffset(d.f5663s);
        this.mUsedSpace = resources.getDimensionPixelSize(d.f5660p);
        this.mPopupWidth = resources.getDimensionPixelOffset(d.f5659o);
        this.mPopupMaxHeight = resources.getDimensionPixelOffset(d.f5661q);
        if (resources.getConfiguration().orientation == 1) {
            this.mScreenWidth = resources.getDisplayMetrics().widthPixels;
        } else {
            this.mScreenWidth = resources.getDisplayMetrics().heightPixels;
        }
        ListView listView = new ListView(context);
        this.mListViewUsedToMeasure = listView;
        listView.setDivider(null);
        this.mListViewUsedToMeasure.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    }

    private int measureHeightOfChildrenCompat(int i10) {
        int makeMeasureSpec;
        int i11;
        MenuAdapter menuAdapter = this.mAdapter;
        int count = menuAdapter.getCount();
        int i12 = 0;
        int i13 = 0;
        View view = null;
        for (int i14 = 0; i14 < count; i14++) {
            int itemViewType = menuAdapter.getItemViewType(i14);
            if (itemViewType != i13) {
                view = null;
                i13 = itemViewType;
            }
            view = menuAdapter.getView(i14, view, this.mListViewUsedToMeasure);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && (i11 = layoutParams.height) > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i10, makeMeasureSpec);
            i12 += view.getMeasuredHeight();
        }
        return i12;
    }

    private boolean tryShow() {
        boolean z10;
        boolean z11;
        ListPopupWindow listPopupWindow = new ListPopupWindow(this.mContext, null, 0);
        this.mPopup = listPopupWindow;
        listPopupWindow.G(this);
        this.mPopup.H(this);
        this.mPopup.k(this.mAdapter);
        this.mPopup.F(true);
        COUINavigationMenuView cOUINavigationMenuView = this.mAnchor;
        if (cOUINavigationMenuView == null) {
            return false;
        }
        if (this.mTreeObserver == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        ViewTreeObserver viewTreeObserver = cOUINavigationMenuView.getViewTreeObserver();
        this.mTreeObserver = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        this.mPopup.y(cOUINavigationMenuView);
        this.mPopup.B(this.mDropDownGravity);
        Rect rect = new Rect();
        Drawable drawable = this.mContext.getResources().getDrawable(POPUP_WINDOW_BACKGROUND);
        drawable.getPadding(rect);
        int i10 = this.mPopupWidth;
        int i11 = rect.left;
        int i12 = rect.right;
        int min = Math.min(i10 + i11 + i12, (this.mScreenWidth - (this.mPopupHorizontalMargin * 2)) + i11 + i12);
        this.mPopup.A(min);
        int measureHeightOfChildrenCompat = measureHeightOfChildrenCompat(View.MeasureSpec.makeMeasureSpec((min - rect.right) - rect.left, 1073741824));
        this.mPopup.a(drawable);
        int i13 = rect.top;
        int i14 = rect.bottom;
        int i15 = measureHeightOfChildrenCompat + i13 + i14;
        int i16 = this.mPopupMaxHeight;
        if (i15 >= i16) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.mPopup.D(Math.min(measureHeightOfChildrenCompat + i13 + i14, i16));
        this.mPopup.E(2);
        int i17 = (-this.mPopupHorizontalMargin) + rect.right;
        int i18 = rect.bottom - this.mPopupVerticalMargin;
        this.mPopup.c(i17);
        this.mPopup.g(i18);
        this.mPopup.show();
        ListView listView = this.mPopup.getListView();
        listView.setBackgroundDrawable(null);
        listView.setSelector(new ColorDrawable(0));
        listView.setOnKeyListener(this);
        if (z11) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) listView.getLayoutParams();
            marginLayoutParams.leftMargin = rect.left;
            marginLayoutParams.rightMargin = rect.right;
            listView.setLayoutParams(marginLayoutParams);
        }
        return true;
    }

    public void addMenuItem(COUINavigationItemView cOUINavigationItemView) {
        this.mMenuList.add(cOUINavigationItemView);
        MenuItemImpl itemData = cOUINavigationItemView.getItemData();
        if (itemData.isVisible()) {
            Paint paint = new Paint();
            paint.setTextSize(this.mSuitableFontSize);
            COUIChangeTextUtil.adaptBoldAndMediumFont(paint, true);
            this.mVisibleMenus.add(cOUINavigationItemView);
            this.mPopupWidth = (int) (Math.max(this.mPopupWidth, paint.measureText(itemData.getTitle().toString()) + this.mUsedSpace) + 0.5f);
        }
    }

    public void clearMenuItems() {
        this.mMenuList.clear();
        this.mVisibleMenus.clear();
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    public boolean isShowing() {
        ListPopupWindow listPopupWindow = this.mPopup;
        if (listPopupWindow != null && listPopupWindow.isShowing()) {
            return true;
        }
        return false;
    }

    public void notifyMenuChange() {
        this.mVisibleMenus.clear();
        for (COUINavigationItemView cOUINavigationItemView : this.mMenuList) {
            MenuItemImpl itemData = cOUINavigationItemView.getItemData();
            if (itemData.isVisible() && itemData.isEnabled()) {
                this.mVisibleMenus.add(cOUINavigationItemView);
            }
        }
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.mTreeObserver;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.mTreeObserver = this.mAnchor.getViewTreeObserver();
            }
            this.mTreeObserver.removeGlobalOnLayoutListener(this);
            this.mTreeObserver = null;
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (isShowing()) {
            COUINavigationMenuView cOUINavigationMenuView = this.mAnchor;
            if (cOUINavigationMenuView != null && cOUINavigationMenuView.isShown()) {
                if (isShowing()) {
                    this.mPopup.show();
                    return;
                }
                return;
            }
            dismiss();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        if (this.mVisibleMenus.get(i10).isEnabled()) {
            this.mPopup.dismiss();
            this.mVisibleMenus.get(i10).performClick();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i10 == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        ListPopupWindow listPopupWindow = this.mPopup;
        if (listPopupWindow != null && listPopupWindow.isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public void setGravity(int i10) {
        this.mDropDownGravity = i10;
    }

    public void show() {
        if (tryShow()) {
        } else {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }
}

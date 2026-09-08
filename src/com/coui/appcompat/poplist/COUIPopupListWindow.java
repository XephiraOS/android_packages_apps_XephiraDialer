package com.coui.appcompat.poplist;

import X8.n;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.K;
import com.coui.appcompat.list.IListSelectedItem;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.poplist.COUIPopupListWindow;
import com.coui.appcompat.poplist.COUIPopupMenuRootView;
import com.coui.appcompat.state.COUIMaskEffectDrawable;
import com.coui.appcompat.state.COUIStateEffectDrawable;
import com.coui.appcompat.state.DrawableStateProxy;
import com.coui.appcompat.uiutil.AnimLevel;
import com.coui.appcompat.uiutil.UIUtil;
import com.coui.component.responsiveui.unit.Dp;
import com.coui.component.responsiveui.window.WindowHeightSizeClass;
import com.coui.component.responsiveui.window.WindowSizeClass;
import com.coui.component.responsiveui.window.WindowWidthSizeClass;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class COUIPopupListWindow extends COUIPopupWindow {
    private static final boolean COUI_DEBUG;
    private static final int GROUP_MIN_ITEMS = 4;
    private static final String TAG = "COUIPopupListWindow";
    private View mAnchorView;
    private COUIPopupMenuRootView mContentView;
    private Context mContext;
    private int mCustomMenuMaxWidth;
    private int mCustomMenuWidth;
    private boolean mDismissWhenLayoutChange;
    private boolean mDismissWhenWindowSizeChange;
    private int mGlobalOffsetX;
    private int mGlobalOffsetY;
    private boolean mIsAdaptiveFontSize;
    private boolean mIsFixedFontSize;
    private int mLastClickedMainMenuItemPosition;
    private ListView mListViewUsedToMeasure;
    private PopupMenuLocateHelper mLocateHelper;
    private ListView mMainListView;
    private DefaultAdapter mMainMenuAdapter;
    private int mMainMenuHeight;
    private final AdapterView.OnItemClickListener mMainMenuItemClickListener;
    private List<PopupListItem> mMainMenuItemList;
    private int mMainMenuWidth;
    private RoundFrameLayout mMainMenuWrapper;
    private final View.OnLayoutChangeListener mMenuDismissWhenRootChange;
    private AdapterView.OnItemClickListener mOnMainMenuItemClickListener;
    private AdapterView.OnItemClickListener mOnSubMenuItemClickListener;
    private View mRootView;
    private int mShowOffsetX;
    private int mShowOffsetY;
    private ListView mSubListView;
    private DefaultAdapter mSubMenuAdapter;
    private View mSubMenuAnchorView;
    private int mSubMenuHeight;
    private final AdapterView.OnItemClickListener mSubMenuItemClickListener;
    private int mSubMenuWidth;
    private RoundFrameLayout mSubMenuWrapper;

    /* renamed from: com.coui.appcompat.poplist.COUIPopupListWindow$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements AdapterView.OnItemClickListener {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0(View view, int i10) {
            COUIPopupListWindow.this.triggerShowSubMenu(view, i10);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, final View view, int i10, long j10) {
            if (!DefaultAdapter.isDataIndex(i10)) {
                return;
            }
            final int realPositionToDataIndex = DefaultAdapter.realPositionToDataIndex(i10);
            if (COUIPopupListWindow.this.mOnMainMenuItemClickListener != null) {
                COUIPopupListWindow.this.mOnMainMenuItemClickListener.onItemClick(adapterView, view, realPositionToDataIndex, j10);
            }
            if (COUIPopupListWindow.this.mSubMenuWrapper.getParent() == null || COUIPopupListWindow.this.mLastClickedMainMenuItemPosition == realPositionToDataIndex) {
                COUIPopupListWindow.this.triggerShowSubMenu(view, realPositionToDataIndex);
            } else {
                COUIPopupListWindow.this.mContentView.hideSubMenu(false);
                COUIPopupListWindow.this.mContentView.postSkipExitAnimationAndShowSubMenu(new Runnable() { // from class: com.coui.appcompat.poplist.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        COUIPopupListWindow.AnonymousClass2.this.lambda$onItemClick$0(view, realPositionToDataIndex);
                    }
                });
            }
        }
    }

    static {
        boolean z10;
        if (!COUILog.LOG_DEBUG && !COUILog.isLoggable(TAG, 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        COUI_DEBUG = z10;
    }

    public COUIPopupListWindow(Context context) {
        super(context);
        this.mMenuDismissWhenRootChange = new View.OnLayoutChangeListener() { // from class: com.coui.appcompat.poplist.COUIPopupListWindow.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                boolean z10;
                if (i10 == i14 && i11 == i15 && i12 == i16 && i13 == i17) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                COUILog.d(COUIPopupListWindow.TAG, "PopupWindow anchor layout changed! left:" + i10 + ",top:" + i11 + ",right:" + i12 + ",bottom:" + i13 + ",oldLeft:" + i14 + ",oldTop:" + i15 + ",oldRight:" + i16 + ",oldBottom:" + i17 + ",layoutChange:" + z10);
                if (z10) {
                    if (COUIPopupListWindow.this.mDismissWhenLayoutChange || (COUIPopupListWindow.this.mDismissWhenWindowSizeChange && COUIPopupListWindow.this.mLocateHelper.checkIfLimitedWindowOrAnchorResized(COUIPopupListWindow.this.mAnchorView, COUIPopupListWindow.this.mShowOffsetX, COUIPopupListWindow.this.mShowOffsetY, COUIPopupListWindow.this.mRootView))) {
                        COUIPopupListWindow.this.dismiss();
                    }
                }
            }
        };
        this.mMainMenuItemClickListener = new AnonymousClass2();
        this.mSubMenuItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.coui.appcompat.poplist.COUIPopupListWindow.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                int realPositionToDataIndex = DefaultAdapter.realPositionToDataIndex(i10);
                if (COUIPopupListWindow.this.mLocateHelper.isCurrentContainerSmallScreen()) {
                    realPositionToDataIndex--;
                }
                int i11 = realPositionToDataIndex;
                if (i11 < 0) {
                    COUIPopupListWindow.this.mContentView.performSubMenuHeader(view);
                } else if (COUIPopupListWindow.this.mOnSubMenuItemClickListener != null) {
                    COUIPopupListWindow.this.mOnSubMenuItemClickListener.onItemClick(adapterView, view, i11, j10);
                    COUIPopupListWindow.this.mSubMenuAdapter.notifyDataSetChanged();
                }
            }
        };
        this.mRootView = null;
        this.mSubMenuAnchorView = null;
        this.mGlobalOffsetX = 0;
        this.mGlobalOffsetY = 0;
        this.mCustomMenuWidth = -1;
        this.mCustomMenuMaxWidth = -1;
        this.mShowOffsetX = Integer.MIN_VALUE;
        this.mShowOffsetY = Integer.MIN_VALUE;
        this.mLastClickedMainMenuItemPosition = -1;
        this.mDismissWhenLayoutChange = false;
        this.mDismissWhenWindowSizeChange = true;
        this.mIsAdaptiveFontSize = false;
        this.mIsFixedFontSize = false;
        this.mContext = context;
        setClippingEnabled(false);
        setTouchModal(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setElevationInPopupwindow(true);
        setExitTransition(null);
        setEnterTransition(null);
        setAnimationStyle(n.f5031c);
        ListView listView = new ListView(context);
        this.mListViewUsedToMeasure = listView;
        listView.setDivider(null);
        this.mListViewUsedToMeasure.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mMainMenuItemList = new ArrayList();
        COUIPopupMenuRootView createContentView = createContentView();
        this.mContentView = createContentView;
        setContentView(createContentView);
        this.mLocateHelper = new PopupMenuLocateHelper(this.mContext);
    }

    private boolean checkListElementsNotNull(List<?> list) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                return false;
            }
        }
        return true;
    }

    private boolean checkListNotNull(List<?> list) {
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    private void configMainListView() {
        this.mLastClickedMainMenuItemPosition = -1;
        this.mMainListView.setAdapter((ListAdapter) this.mMainMenuAdapter);
        if (this.mOnMainMenuItemClickListener != null) {
            this.mMainListView.setOnItemClickListener(this.mMainMenuItemClickListener);
        }
    }

    private void configSubListView() {
        this.mSubListView.setAdapter((ListAdapter) this.mSubMenuAdapter);
        this.mSubListView.setOnItemClickListener(this.mSubMenuItemClickListener);
    }

    private COUIPopupMenuRootView createContentView() {
        COUIPopupMenuRootView cOUIPopupMenuRootView = new COUIPopupMenuRootView(this.mContext);
        cOUIPopupMenuRootView.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.poplist.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                COUIPopupListWindow.this.lambda$createContentView$0(view);
            }
        });
        LayoutInflater from = LayoutInflater.from(this.mContext);
        int i10 = X8.j.f4981l;
        this.mMainMenuWrapper = (RoundFrameLayout) from.inflate(i10, (ViewGroup) cOUIPopupMenuRootView, false);
        this.mSubMenuWrapper = (RoundFrameLayout) LayoutInflater.from(this.mContext).inflate(i10, (ViewGroup) cOUIPopupMenuRootView, false);
        RoundFrameLayout roundFrameLayout = this.mMainMenuWrapper;
        int i11 = X8.h.f4874A;
        this.mMainListView = (ListView) roundFrameLayout.findViewById(i11);
        this.mSubListView = (ListView) this.mSubMenuWrapper.findViewById(i11);
        TypedArray obtainStyledAttributes = this.mContext.getTheme().obtainStyledAttributes(new int[]{X8.c.f4365X});
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable == null) {
            drawable = A.h.f(this.mContext.getResources(), X8.g.f4867t, this.mContext.getTheme());
        }
        if (drawable != null) {
            this.mMainMenuWrapper.setBackground(drawable.getConstantState().newDrawable());
            this.mSubMenuWrapper.setBackground(drawable.getConstantState().newDrawable());
        }
        obtainStyledAttributes.recycle();
        cOUIPopupMenuRootView.setOnSubMenuStateChangedListener(new COUIPopupMenuRootView.OnMenuStateChangedListener() { // from class: com.coui.appcompat.poplist.COUIPopupListWindow.4
            private void requestAccessibilityFocusForListHeader(ViewGroup viewGroup) {
                View childAt = viewGroup.getChildAt(0);
                if (childAt != null) {
                    childAt.performAccessibilityAction(64, null);
                }
            }

            private void setListViewFocusable(ListView listView, boolean z10) {
                if (listView != null) {
                    listView.setFocusable(false);
                    for (int i12 = 0; i12 < listView.getChildCount(); i12++) {
                        listView.getChildAt(i12).setFocusable(z10);
                    }
                }
            }

            @Override // com.coui.appcompat.poplist.COUIPopupMenuRootView.OnMenuStateChangedListener
            public void onMainMenuEntered() {
                requestAccessibilityFocusForListHeader(COUIPopupListWindow.this.mMainListView);
            }

            @Override // com.coui.appcompat.poplist.COUIPopupMenuRootView.OnMenuStateChangedListener
            public void onSubMenuAnimationCanceled() {
                COUIPopupListWindow.this.setSubMenuGroupItemActivation(false);
            }

            @Override // com.coui.appcompat.poplist.COUIPopupMenuRootView.OnMenuStateChangedListener
            public void onSubMenuEntered() {
                requestAccessibilityFocusForListHeader(COUIPopupListWindow.this.mSubListView);
            }

            @Override // com.coui.appcompat.poplist.COUIPopupMenuRootView.OnMenuStateChangedListener
            public void onSubMenuExited() {
                if (COUIPopupListWindow.this.mSubMenuAnchorView != null) {
                    if (COUIPopupListWindow.this.mSubListView != null && COUIPopupListWindow.this.mSubListView.getChildAt(0) != null) {
                        COUIPopupListWindow.this.mSubListView.getChildAt(0).setBackground(null);
                    }
                    COUIPopupListWindow.this.mSubMenuAnchorView = null;
                }
            }

            @Override // com.coui.appcompat.poplist.COUIPopupMenuRootView.OnMenuStateChangedListener
            public void onSubMenuStartToEnter() {
                COUIPopupListWindow.this.setSubMenuGroupItemActivation(true);
                setListViewFocusable(COUIPopupListWindow.this.mMainListView, false);
            }

            @Override // com.coui.appcompat.poplist.COUIPopupMenuRootView.OnMenuStateChangedListener
            public void onSubMenuStartToExit() {
                COUIPopupListWindow.this.setSubMenuGroupItemActivation(false);
                setListViewFocusable(COUIPopupListWindow.this.mMainListView, true);
            }
        });
        return cOUIPopupMenuRootView;
    }

    private int getMainMenuMaxWidth() {
        if (this.mCustomMenuWidth >= 0) {
            if (COUI_DEBUG) {
                Log.i(TAG, "Use custom menu width = " + this.mCustomMenuWidth);
            }
            return this.mCustomMenuWidth;
        }
        if (this.mCustomMenuMaxWidth >= getMainMenuMinWidth()) {
            return this.mCustomMenuMaxWidth;
        }
        Log.w(TAG, "Illegal max width! Custom menu max width smaller than min width!");
        DefaultAdapter defaultAdapter = this.mMainMenuAdapter;
        if (defaultAdapter == null) {
            Log.w(TAG, "Get main menu max width fail! Adapter is NULL!");
            return 0;
        }
        if (defaultAdapter.hasSubMenu()) {
            if (this.mMainMenuAdapter.hasIcon()) {
                return this.mContext.getResources().getDimensionPixelOffset(X8.f.f4687f3);
            }
            return this.mContext.getResources().getDimensionPixelOffset(X8.f.f4743m3);
        }
        return this.mContext.getResources().getDimensionPixelOffset(X8.f.f4687f3);
    }

    private int getMainMenuMinWidth() {
        int i10 = this.mCustomMenuWidth;
        if (i10 >= 0) {
            return i10;
        }
        DefaultAdapter defaultAdapter = this.mMainMenuAdapter;
        if (defaultAdapter == null) {
            Log.w(TAG, "Get main menu min width fail! Adapter is NULL!");
            return 0;
        }
        if (defaultAdapter.hasSubMenu()) {
            if (this.mMainMenuAdapter.hasIcon()) {
                return this.mContext.getResources().getDimensionPixelOffset(X8.f.f4687f3);
            }
            return this.mContext.getResources().getDimensionPixelOffset(X8.f.f4743m3);
        }
        return this.mContext.getResources().getDimensionPixelOffset(X8.f.f4703h3);
    }

    private boolean isRtl(View view) {
        if (K.v(view) == 1) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static boolean isSmallScreen(Context context, int i10, int i11) {
        WindowSizeClass.Companion companion = WindowSizeClass.Companion;
        Dp.Companion companion2 = Dp.Companion;
        WindowSizeClass calculateFromSize = companion.calculateFromSize(companion2.pixel2Dp(context, Math.abs(i10)), companion2.pixel2Dp(context, Math.abs(i11)));
        if (calculateFromSize.getWindowWidthSizeClass() != WindowWidthSizeClass.Compact && calculateFromSize.getWindowHeightSizeClass() != WindowHeightSizeClass.Compact) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createContentView$0(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$setItemListInternal$1(PopupListItem popupListItem, PopupListItem popupListItem2) {
        return popupListItem.getGroupId() - popupListItem2.getGroupId();
    }

    private void refreshAdapter(List<PopupListItem> list, DefaultAdapter defaultAdapter) {
        defaultAdapter.setAdapterFontSize(this.mIsAdaptiveFontSize);
        defaultAdapter.setIsFixedFontSize(this.mIsFixedFontSize);
        defaultAdapter.setItemList(list);
        defaultAdapter.notifyDataSetChanged();
    }

    private void setAnchorHoveredState(boolean z10, View view) {
        if (view != null && (view instanceof IListSelectedItem)) {
            if (view.getBackground() instanceof DrawableStateProxy) {
                ((DrawableStateProxy) view.getBackground()).setStateLocked(16843623, z10, z10, true);
            }
            if (view.getBackground() instanceof COUIStateEffectDrawable) {
                ((COUIStateEffectDrawable) view.getBackground()).setStateLocked(16843623, z10, z10, true);
            }
        }
    }

    private void setItemListInternal(List<PopupListItem> list, DefaultAdapter defaultAdapter, boolean z10) {
        boolean z11;
        HashSet hashSet;
        if (list.size() >= 4) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (z10) {
                Collections.sort(list, new Comparator() { // from class: com.coui.appcompat.poplist.b
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int lambda$setItemListInternal$1;
                        lambda$setItemListInternal$1 = COUIPopupListWindow.lambda$setItemListInternal$1((PopupListItem) obj, (PopupListItem) obj2);
                        return lambda$setItemListInternal$1;
                    }
                });
            }
            hashSet = new HashSet();
            int groupId = list.get(0).getGroupId();
            for (int i10 = 1; i10 < list.size(); i10++) {
                int groupId2 = list.get(i10).getGroupId();
                if (groupId2 != groupId) {
                    hashSet.add(Integer.valueOf(i10));
                    groupId = groupId2;
                }
            }
        } else {
            hashSet = null;
        }
        if (hashSet != null) {
            defaultAdapter.setGroupSets(hashSet);
        }
        refreshAdapter(list, defaultAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubMenuGroupItemActivation(boolean z10) {
        int i10;
        if (this.mSubMenuAdapter == null) {
            return;
        }
        if (this.mLocateHelper.isCurrentContainerSmallScreen()) {
            if (z10) {
                i10 = 2;
            } else {
                i10 = 0;
            }
            Object item = this.mSubMenuAdapter.getItem(0);
            if (item instanceof PopupListItem) {
                ((PopupListItem) item).setGroupState(i10);
                this.mSubMenuAdapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        int i11 = this.mLastClickedMainMenuItemPosition;
        if (i11 != -1) {
            Object item2 = this.mMainMenuAdapter.getItem(DefaultAdapter.dataIndexToRealPosition(i11));
            if (item2 instanceof PopupListItem) {
                ((PopupListItem) item2).setGroupState(z10 ? 1 : 0);
                this.mMainMenuAdapter.notifyDataSetChanged();
            }
        }
        View view = this.mSubMenuAnchorView;
        if (view != null && (view.getBackground() instanceof COUIMaskEffectDrawable)) {
            ((ListItemMaskEffectDrawable) this.mSubMenuAnchorView.getBackground()).setHoverStateLocked(z10, z10, true);
        }
    }

    private void showSub(View view, int i10) {
        if (this.mSubMenuWrapper.getParent() != null && i10 == this.mLastClickedMainMenuItemPosition) {
            this.mContentView.showSubMenu();
            return;
        }
        configSubListView();
        measurePopupWindow(this.mSubMenuAdapter);
        this.mContentView.setSubMenuSize(this.mSubMenuWidth, this.mSubMenuHeight);
        this.mLocateHelper.prepareShowSubMenu(view, this.mSubMenuWidth, this.mSubMenuHeight, isRtl(view));
        this.mContentView.addSubMenuView(this.mSubMenuWrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerShowSubMenu(View view, int i10) {
        PopupListItem popupListItem;
        boolean z10;
        this.mLastClickedMainMenuItemPosition = i10;
        if (!this.mMainMenuItemList.isEmpty() && this.mMainMenuItemList.size() > i10 && (popupListItem = this.mMainMenuItemList.get(i10)) != null && popupListItem.isEnable() && checkListNotNull(popupListItem.getSubMenuItemList()) && checkListElementsNotNull(popupListItem.getSubMenuItemList())) {
            ArrayList arrayList = new ArrayList();
            if (this.mLocateHelper.isCurrentContainerSmallScreen()) {
                arrayList.add(popupListItem);
            }
            PopupMenuLocateHelper popupMenuLocateHelper = this.mLocateHelper;
            if (i10 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            popupMenuLocateHelper.setSubMenuAnchorIsFirstItem(z10);
            arrayList.addAll(popupListItem.getSubMenuItemList());
            if (this.mSubMenuAdapter == null) {
                this.mSubMenuAdapter = new DefaultAdapter(this.mContext, null);
            }
            setItemListInternal(arrayList, this.mSubMenuAdapter, false);
            if (view.getBackground() instanceof ListItemMaskEffectDrawable) {
                this.mSubMenuAdapter.setSharedBackground((ListItemMaskEffectDrawable) view.getBackground());
            }
            this.mSubMenuAnchorView = view;
            showSub(view, i10);
        }
    }

    @Deprecated
    public boolean configPopupValue(View view, boolean z10) {
        return false;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        View view = this.mAnchorView;
        if (view != null && view.getRootView() != null) {
            this.mAnchorView.getRootView().removeOnLayoutChangeListener(this.mMenuDismissWhenRootChange);
        }
        if (this.mLastClickedMainMenuItemPosition != -1 && this.mMainMenuAdapter != null) {
            COUILog.d(TAG, "LastClickedMainMenuItemPosition = " + this.mLastClickedMainMenuItemPosition);
            Object item = this.mMainMenuAdapter.getItem(DefaultAdapter.dataIndexToRealPosition(this.mLastClickedMainMenuItemPosition));
            if (item instanceof PopupListItem) {
                ((PopupListItem) item).setGroupState(0);
                this.mMainMenuAdapter.notifyDataSetChanged();
            }
        }
        this.mSubMenuAnchorView = null;
        setAnchorHoveredState(false, this.mAnchorView);
        super.dismiss();
    }

    public ListAdapter getAdapter() {
        ListView listView = this.mMainListView;
        if (listView != null) {
            return listView.getAdapter();
        }
        return null;
    }

    public View getAnchorView() {
        return this.mAnchorView;
    }

    public List<PopupListItem> getItemList() {
        return this.mMainMenuItemList;
    }

    @Deprecated
    public ListView getListView() {
        return this.mMainListView;
    }

    public PopupMenuLocateHelper getLocateHelper() {
        return this.mLocateHelper;
    }

    public ListView getMainMenuListView() {
        return this.mMainListView;
    }

    public ListView getSubMenuListView() {
        return this.mSubListView;
    }

    @Override // com.coui.appcompat.poplist.COUIPopupWindow
    public void initElevationInPopupwindow() {
        setBackgroundDrawable(null);
    }

    public void measurePopupWindow() {
        measurePopupWindow(this.mMainMenuAdapter);
    }

    public void prepareShowMainMenu(View view, int i10, int i11, boolean z10) {
        configMainListView();
        this.mLocateHelper.prepareWindowAndAnchor(view, i10, i11, this.mRootView);
        this.mContentView.setDomain(this.mLocateHelper.getDomain());
        this.mContentView.addMainMenuView(this.mMainMenuWrapper);
        measurePopupWindow();
        this.mContentView.setMainMenuSize(this.mMainMenuWidth, this.mMainMenuHeight);
        this.mLocateHelper.prepareShowMainMenu(this.mMainMenuWidth, this.mMainMenuHeight, z10, this.mGlobalOffsetX, this.mGlobalOffsetY);
    }

    public void refresh() {
        TypedArray obtainStyledAttributes = this.mContext.getTheme().obtainStyledAttributes(new int[]{X8.c.f4365X});
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        if (drawable == null) {
            drawable = A.h.f(this.mContext.getResources(), X8.g.f4867t, this.mContext.getTheme());
        }
        if (drawable != null) {
            this.mMainMenuWrapper.setBackground(drawable.getConstantState().newDrawable());
            this.mSubMenuWrapper.setBackground(drawable.getConstantState().newDrawable());
        }
    }

    public void resetOffset() {
        setGlobalOffset(0, 0);
    }

    @Deprecated
    public void setAdapter(BaseAdapter baseAdapter, boolean z10) {
    }

    @Deprecated
    public void setAdapterFontSize(boolean z10) {
        setIsAdaptiveFontSize(z10);
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public void setDismissWhenLayoutChange(boolean z10) {
        this.mDismissWhenLayoutChange = z10;
    }

    public void setDismissWhenWindowSizeChange(boolean z10) {
        this.mDismissWhenWindowSizeChange = z10;
    }

    public void setGlobalOffset(int i10, int i11) {
        this.mGlobalOffsetX = i10;
        this.mGlobalOffsetY = i11;
    }

    public void setIsAdaptiveFontSize(boolean z10) {
        this.mIsAdaptiveFontSize = z10;
        DefaultAdapter defaultAdapter = this.mMainMenuAdapter;
        if (defaultAdapter != null) {
            defaultAdapter.setAdapterFontSize(z10);
        }
        DefaultAdapter defaultAdapter2 = this.mSubMenuAdapter;
        if (defaultAdapter2 != null) {
            defaultAdapter2.setAdapterFontSize(this.mIsAdaptiveFontSize);
        }
    }

    public void setIsFixedFontSize(boolean z10) {
        this.mIsFixedFontSize = z10;
        DefaultAdapter defaultAdapter = this.mMainMenuAdapter;
        if (defaultAdapter != null) {
            defaultAdapter.setIsFixedFontSize(z10);
        }
        DefaultAdapter defaultAdapter2 = this.mSubMenuAdapter;
        if (defaultAdapter2 != null) {
            defaultAdapter2.setIsFixedFontSize(this.mIsFixedFontSize);
        }
    }

    public void setItemList(List<PopupListItem> list) {
        setItemList(list, false);
    }

    public void setMenuMaxWidth(int i10) {
        this.mCustomMenuMaxWidth = i10;
    }

    public void setMenuWidth(int i10) {
        this.mCustomMenuWidth = i10;
    }

    public void setNonApplicationType(boolean z10, boolean z11) {
        this.mLocateHelper.useWindowBarrier(z10);
        this.mLocateHelper.setCenterAlign(z11);
    }

    @Deprecated
    public void setOffset(int i10, int i11, int i12, int i13) {
        setGlobalOffset(-i10, -i11);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            COUILog.w(TAG, "set main menu item click listener = null. caller = " + Log.getStackTraceString(new Throwable()));
        }
        this.mOnMainMenuItemClickListener = onItemClickListener;
    }

    public void setPopupWindowLimitedRootView(View view) {
        this.mRootView = view;
    }

    public void setSubMenuClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            COUILog.w(TAG, "set sub menu item click listener = null. caller = " + Log.getStackTraceString(new Throwable()));
        }
        this.mOnSubMenuItemClickListener = onItemClickListener;
    }

    public void setUseBackgroundBlur(boolean z10) {
        setUseBackgroundBlur(z10, UIUtil.ANIM_LEVEL_SUPPORT_BLUR_MIN);
    }

    public void show() {
        View view = this.mAnchorView;
        if (view != null) {
            show(view);
        }
    }

    @Deprecated
    public void showAtAbove(View view) {
        show(view, true);
    }

    @Deprecated
    public void showAtAboveOrBelow(View view) {
        show(view, true);
    }

    @Deprecated
    public void superDismiss() {
        super.dismiss();
    }

    public void measurePopupWindow(DefaultAdapter defaultAdapter) {
        View view;
        int i10;
        boolean z10 = defaultAdapter == this.mMainMenuAdapter;
        PopupMenuLocateHelper popupMenuLocateHelper = this.mLocateHelper;
        int maxMainMenuHeight = z10 ? popupMenuLocateHelper.getMaxMainMenuHeight() : popupMenuLocateHelper.getMaxSubMenuHeight();
        ArrayList arrayList = new ArrayList();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMainMenuMaxWidth(), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = defaultAdapter.getCount();
        View view2 = null;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        View view3 = null;
        boolean z11 = true;
        while (i11 < count) {
            if (DefaultAdapter.isDataIndex(i11)) {
                if (defaultAdapter.getItemViewType(i11) == 3) {
                    view = defaultAdapter.getView(i11, view2, this.mListViewUsedToMeasure);
                } else {
                    view3 = defaultAdapter.getView(i11, view3, this.mListViewUsedToMeasure);
                    view = view3;
                }
                if (view != null) {
                    if ((view.getLayoutParams() instanceof AbsListView.LayoutParams) && (i10 = ((AbsListView.LayoutParams) view.getLayoutParams()).height) != -2) {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    int measuredWidth = view.getMeasuredWidth();
                    int measuredHeight = view.getMeasuredHeight();
                    if (measuredWidth > i13) {
                        i13 = measuredWidth;
                    }
                    if (z11 && i12 + measuredHeight > maxMainMenuHeight) {
                        i12 -= i15;
                        z11 = false;
                    }
                    if (z11) {
                        i12 += measuredHeight;
                    }
                    i14 += measuredHeight;
                    if (i11 != 0 && !arrayList.isEmpty()) {
                        arrayList.add(Integer.valueOf(measuredHeight + ((Integer) arrayList.get(i11 - 1)).intValue()));
                    } else {
                        arrayList.add(Integer.valueOf(measuredHeight));
                    }
                }
            } else {
                if (defaultAdapter.isGroupIndex(i11)) {
                    i15 = defaultAdapter.getDividerHeight(2);
                } else {
                    i15 = defaultAdapter.getDividerHeight(1);
                }
                if (z11) {
                    i12 += i15;
                }
                i14 += i15;
                if (i11 != 0 && !arrayList.isEmpty()) {
                    arrayList.add(Integer.valueOf(i15 + ((Integer) arrayList.get(i11 - 1)).intValue()));
                } else {
                    arrayList.add(Integer.valueOf(i15));
                }
            }
            i11++;
            view2 = null;
        }
        if (i12 != 0) {
            maxMainMenuHeight = i12;
        }
        if (z10) {
            this.mMainMenuWidth = Math.max(i13, getMainMenuMinWidth());
            this.mMainMenuHeight = maxMainMenuHeight;
            ListView listView = this.mMainListView;
            if (listView instanceof COUITouchListView) {
                ((COUITouchListView) listView).setItemHeightMap(arrayList, i14);
                return;
            }
            return;
        }
        this.mSubMenuWidth = this.mMainMenuWidth;
        this.mSubMenuHeight = maxMainMenuHeight;
        ListView listView2 = this.mSubListView;
        if (listView2 instanceof COUITouchListView) {
            ((COUITouchListView) listView2).setItemHeightMap(arrayList, i14);
        }
    }

    @Deprecated
    public void setAdapter(BaseAdapter baseAdapter) {
        setAdapter(baseAdapter, true);
    }

    public void setItemList(List<PopupListItem> list, boolean z10) {
        if (checkListNotNull(list) && checkListElementsNotNull(list)) {
            this.mMainMenuItemList = list;
            if (this.mMainMenuAdapter == null) {
                this.mMainMenuAdapter = new DefaultAdapter(this.mContext, null);
            }
            setItemListInternal(this.mMainMenuItemList, this.mMainMenuAdapter, z10);
            return;
        }
        Log.e(TAG, "Error! Item list must not be empty or null!");
    }

    public void setUseBackgroundBlur(boolean z10, AnimLevel animLevel) {
        this.mSubMenuWrapper.initUseBackgroundBlur(z10, animLevel);
        this.mMainMenuWrapper.initUseBackgroundBlur(z10, animLevel);
    }

    @Deprecated
    public void setSubMenuClickListener(COUISubMenuClickListener cOUISubMenuClickListener) {
        this.mOnSubMenuItemClickListener = cOUISubMenuClickListener;
    }

    public void show(View view) {
        show(view, false);
    }

    public void show(View view, boolean z10) {
        show(view, z10, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public void show(View view, int i10, int i11) {
        show(view, false, i10, i11);
    }

    public void show(View view, boolean z10, int i10, int i11) {
        Context context = this.mContext;
        if (context == null) {
            Log.e(TAG, " The context of COUIPopupListWindow is null ");
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            Log.e(TAG, " The context of COUIPopupListWindow is Finish ");
            return;
        }
        if (view != null && view.getContext() != null && view.getWindowToken() != null) {
            if (this.mMainMenuAdapter == null) {
                Log.e(TAG, "The MainMenuAdapter is null");
                return;
            }
            this.mAnchorView = view;
            this.mShowOffsetX = i10;
            this.mShowOffsetY = i11;
            prepareShowMainMenu(view, i10, i11, z10);
            setWidth(this.mLocateHelper.mApplicationWindow.width());
            setHeight(this.mLocateHelper.mApplicationWindow.height());
            super.showAtLocation(view.getRootView(), 0, 0, 0);
            view.getRootView().addOnLayoutChangeListener(this.mMenuDismissWhenRootChange);
            setAnchorHoveredState(true, view);
            return;
        }
        Log.e(TAG, " COUIPopupListWindow's anchor state is wrong ");
    }

    @Deprecated
    public void setAlwaysBelowAnchor(boolean z10) {
    }

    @Deprecated
    public void setContentHeight(int i10) {
    }

    @Deprecated
    public void setContentWidth(int i10) {
    }

    @Deprecated
    public void setEnableAddExtraWidth(boolean z10) {
    }

    @Deprecated
    public void setItemTextColor(ColorStateList colorStateList) {
    }

    @Deprecated
    public void setMaxShowItemCount(int i10) {
    }

    @Deprecated
    public void setMaxShowItemCountSubWindow(int i10) {
    }

    @Deprecated
    public void setSelectItemColor(int i10) {
    }

    @Deprecated
    public void setShowInBottomSheetDialog(boolean z10) {
    }

    @Deprecated
    public void showEndOfAnchorViewStart(View view) {
    }

    @Deprecated
    public void measurePopupWindow(boolean z10) {
        measurePopupWindow();
    }

    @Deprecated
    public void setSubMenuOffset(int i10, int i11) {
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11, int i12) {
    }
}

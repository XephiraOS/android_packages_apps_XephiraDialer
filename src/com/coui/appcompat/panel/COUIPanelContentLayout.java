package com.coui.appcompat.panel;

import X8.h;
import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import c9.C0570b;
import c9.C0572d;
import c9.C0574f;
import com.coui.appcompat.buttonBar.COUIButtonBarLayout;
import com.coui.appcompat.poplist.PopupMenuConfigRule;

/* loaded from: classes.dex */
public class COUIPanelContentLayout extends LinearLayout implements PopupMenuConfigRule {
    private static final Rect PANEL_OUTSETS = new Rect();
    private COUIPanelPressHelper mCOUIPanelPressHelper;
    private Rect mDisplayFrame;
    private boolean mIsLayoutAtMaxHeight;
    public boolean mIsTurnOnAnim;
    private final int mPanelHorizontalPadding;
    private boolean mPopupRuleEnable;

    public COUIPanelContentLayout(Context context) {
        this(context, null);
    }

    private int getNavigationBarHeight(WindowInsets windowInsets, Configuration configuration) {
        if (windowInsets != null) {
            return windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom;
        }
        int identifier = getContext().getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (configuration != null) {
            return getContext().createConfigurationContext(configuration).getResources().getDimensionPixelSize(identifier);
        }
        return getContext().getResources().getDimensionPixelSize(identifier);
    }

    private void initButton(Button button, String str, View.OnClickListener onClickListener) {
        if (button != null) {
            if (TextUtils.isEmpty(str)) {
                button.setVisibility(8);
                return;
            }
            button.setVisibility(0);
            button.setText(str);
            button.setOnClickListener(onClickListener);
        }
    }

    private boolean isBigScreen(Configuration configuration) {
        if (configuration == null) {
            return getContext().getResources().getBoolean(C0570b.f12869a);
        }
        return getContext().createConfigurationContext(configuration).getResources().getBoolean(C0570b.f12869a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setDragViewPressAnim$0(View view, boolean z10, View view2, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (view != null) {
                view.setVisibility(0);
            }
            if (z10) {
                this.mIsTurnOnAnim = true;
                this.mCOUIPanelPressHelper.startAnim(view);
            }
        }
        return true;
    }

    public void addContentView(View view) {
        if (view != null) {
            ((LinearLayout) findViewById(C0574f.f12917k)).addView(view, new LinearLayout.LayoutParams(-1, -1));
        }
    }

    public void dragBgEndAnim() {
        this.mCOUIPanelPressHelper.endAnim(findViewById(C0574f.f12924r));
    }

    @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
    public int getBarrierDirection() {
        return 4;
    }

    public COUIButtonBarLayout getBtnBarLayout() {
        return (COUIButtonBarLayout) findViewById(C0574f.f12907a);
    }

    @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
    public Rect getDisplayFrame() {
        if (this.mDisplayFrame == null) {
            this.mDisplayFrame = new Rect();
        }
        getGlobalVisibleRect(this.mDisplayFrame);
        Rect rect = this.mDisplayFrame;
        int i10 = rect.left;
        int i11 = this.mPanelHorizontalPadding;
        rect.left = i10 + i11;
        rect.right -= i11;
        return rect;
    }

    public View getDivider() {
        return findViewById(C0574f.f12912f);
    }

    public View getDragBgView() {
        return findViewById(C0574f.f12924r);
    }

    public ImageView getDragView() {
        return (ImageView) findViewById(C0574f.f12913g);
    }

    public FrameLayout getDrawLayout() {
        return (FrameLayout) findViewById(C0574f.f12914h);
    }

    public boolean getLayoutAtMaxHeight() {
        return this.mIsLayoutAtMaxHeight;
    }

    public int getMaxHeight() {
        return COUIPanelMultiWindowUtils.getPanelMaxHeight(getContext(), null);
    }

    @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
    public Rect getOutsets() {
        return PANEL_OUTSETS;
    }

    public COUIPanelBarView getPanelBarView() {
        return (COUIPanelBarView) findViewById(C0574f.f12918l);
    }

    @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
    public boolean getPopupMenuRuleEnabled() {
        return this.mPopupRuleEnable;
    }

    @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
    public int getType() {
        return 2;
    }

    public void removeContentView() {
        ((LinearLayout) findViewById(C0574f.f12917k)).removeAllViews();
    }

    public void removeDragViewPressAnim() {
        View findViewById = findViewById(C0574f.f12924r);
        if (findViewById != null) {
            findViewById.setOnTouchListener(null);
        }
    }

    public void setCenterButton(String str, View.OnClickListener onClickListener) {
        initButton((Button) findViewById(R.id.button3), str, onClickListener);
    }

    public void setDividerVisibility(boolean z10) {
        View findViewById = findViewById(C0574f.f12912f);
        if (z10) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    public void setDragViewDrawable(Drawable drawable) {
        if (drawable != null) {
            ((ImageView) findViewById(C0574f.f12913g)).setImageDrawable(drawable);
        }
    }

    public void setDragViewDrawableTintColor(int i10) {
        ((AppCompatImageView) findViewById(C0574f.f12913g)).getDrawable().setTint(i10);
    }

    public void setDragViewPressAnim(final boolean z10) {
        final View findViewById = findViewById(C0574f.f12924r);
        if (findViewById != null) {
            findViewById.setOnTouchListener(null);
            findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.panel.b
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean lambda$setDragViewPressAnim$0;
                    lambda$setDragViewPressAnim$0 = COUIPanelContentLayout.this.lambda$setDragViewPressAnim$0(findViewById, z10, view, motionEvent);
                    return lambda$setDragViewPressAnim$0;
                }
            });
        }
    }

    public void setLayoutAtMaxHeight(boolean z10) {
        this.mIsLayoutAtMaxHeight = z10;
        if (z10) {
            getLayoutParams().height = -1;
        } else {
            getLayoutParams().height = -2;
        }
        requestLayout();
    }

    public void setLeftButton(String str, View.OnClickListener onClickListener) {
        initButton((Button) findViewById(R.id.button2), str, onClickListener);
    }

    public void setNavigationMargin(Configuration configuration, int i10, WindowInsets windowInsets) {
        boolean z10;
        if (COUINavigationBarUtil.isGestureNavigation(getContext())) {
            boolean isDisplayInUpperWindow = COUIPanelMultiWindowUtils.isDisplayInUpperWindow(COUIPanelMultiWindowUtils.contextToActivity(getContext()));
            boolean isInMultiWindowMode = COUIPanelMultiWindowUtils.isInMultiWindowMode(COUIPanelMultiWindowUtils.contextToActivity(getContext()));
            boolean isBigScreen = isBigScreen(configuration);
            int navigationBarHeight = getNavigationBarHeight(windowInsets, configuration);
            View findViewById = findViewById(C0574f.f12917k);
            View findViewById2 = findViewById.getRootView().findViewById(C0574f.f12910d);
            int i11 = 0;
            if (findViewById2 != null) {
                View findViewById3 = findViewById2.findViewById(h.f4897N);
                if (findViewById3 instanceof COUIPanelPercentFrameLayout) {
                    z10 = ((COUIPanelPercentFrameLayout) findViewById3).isIsHandlePanel();
                    if ((isDisplayInUpperWindow || !isInMultiWindowMode) && isBigScreen && !z10) {
                        i11 = navigationBarHeight;
                        navigationBarHeight = 0;
                    }
                    COUIViewMarginUtil.setMargin(findViewById, 3, navigationBarHeight);
                    COUIViewMarginUtil.setMargin(findViewById2, 3, i11);
                }
            }
            z10 = false;
            if (isDisplayInUpperWindow) {
            }
            i11 = navigationBarHeight;
            navigationBarHeight = 0;
            COUIViewMarginUtil.setMargin(findViewById, 3, navigationBarHeight);
            COUIViewMarginUtil.setMargin(findViewById2, 3, i11);
        }
    }

    @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
    public void setPopupMenuRuleEnabled(boolean z10) {
        this.mPopupRuleEnable = z10;
    }

    public void setRightButton(String str, View.OnClickListener onClickListener) {
        initButton((Button) findViewById(R.id.button1), str, onClickListener);
    }

    public void setUpBottomBar(boolean z10, String str, View.OnClickListener onClickListener, String str2, View.OnClickListener onClickListener2, String str3, View.OnClickListener onClickListener3) {
        setDividerVisibility(z10);
        COUIButtonBarLayout cOUIButtonBarLayout = (COUIButtonBarLayout) findViewById(C0574f.f12907a);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            cOUIButtonBarLayout.setVisibility(8);
            return;
        }
        cOUIButtonBarLayout.setVisibility(0);
        cOUIButtonBarLayout.setVerButDividerVerMargin(getContext().getResources().getDimensionPixelOffset(C0572d.f12891n));
        cOUIButtonBarLayout.setVerButVerPadding(getContext().getResources().getDimensionPixelOffset(C0572d.f12892o));
        cOUIButtonBarLayout.setVerPaddingBottom(getContext().getResources().getDimensionPixelOffset(C0572d.f12890m));
        cOUIButtonBarLayout.setVerButPaddingOffset(0);
        Button button = (Button) findViewById(R.id.button2);
        Button button2 = (Button) findViewById(R.id.button3);
        Button button3 = (Button) findViewById(R.id.button1);
        initButton(button, str, onClickListener);
        initButton(button2, str2, onClickListener2);
        initButton(button3, str3, onClickListener3);
    }

    public COUIPanelContentLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIPanelContentLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mPopupRuleEnable = true;
        this.mCOUIPanelPressHelper = new COUIPanelPressHelper();
        this.mPanelHorizontalPadding = context.getResources().getDimensionPixelOffset(C0572d.f12880c);
    }
}

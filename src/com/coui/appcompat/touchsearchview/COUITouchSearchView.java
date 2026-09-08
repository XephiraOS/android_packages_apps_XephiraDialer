package com.coui.appcompat.touchsearchview;

import J.d;
import X8.c;
import X8.e;
import X8.f;
import android.R;
import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.S;
import androidx.core.content.b;
import androidx.core.view.K;
import androidx.customview.widget.a;
import b9.C0531a;
import b9.C0532b;
import b9.C0534d;
import b9.C0535e;
import b9.C0536f;
import b9.C0537g;
import b9.C0538h;
import b9.C0539i;
import b9.j;
import b9.k;
import b9.l;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.coui.appcompat.uiutil.ShadowUtils;
import com.coui.appcompat.uiutil.UIUtil;
import com.coui.appcompat.vibrateutil.VibrateUtils;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.media.OplusRecorder;
import com.oplus.os.LinearmotorVibrator;
import com.oplus.zoomwindow.OplusZoomWindowManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import u4.C1607c;

/* loaded from: classes3.dex */
public class COUITouchSearchView extends View implements View.OnClickListener {
    private static final float ALPHA_MAX = 1.0f;
    private static final float ALPHA_MIN = 0.0f;
    private static final int BG_ALIGN_MIDDLE = 0;
    private static final int BG_ALIGN_RIGHT = 2;
    private static final boolean DEBUG = false;
    private static final int ENABLED = 0;
    private static final int ENABLED_MASK = 32;
    private static final int FIXED_MIN_DOT_LENGTH = 6;
    private static final int FIXED_MIN_LETTER_LENGTH_FOR_DISPLAY = 8;
    private static final String INIT_STR_LAST_SYM_BOL = "#";
    private static final int INVALID_POINTER = -1;
    private static final int LETTER_DRAW_HEIGHT = 16;
    private static final int LIMIT_DOT_LEVEL0 = 0;
    private static final int LIMIT_DOT_LEVEL1 = 1;
    private static final int LIMIT_DOT_LEVEL2 = 2;
    private static final int LIMIT_DOT_LEVEL3 = 3;
    private static final int LIMIT_DOT_LEVEL4 = 4;
    private static final int LIMIT_DOT_LEVEL5 = 5;
    private static final int LIMIT_DOT_LEVEL6 = 6;
    private static final int MIN_COUNT_RATIO = 3;
    public static final int MIN_SECTIONS_NUM = 8;
    private static final int MIN_SIZE_COUNT = 5;
    private static final COUIMoveEaseInterpolator MOVE_EASE_INTERPOLATOR = new COUIMoveEaseInterpolator();
    private static final int PFLAG_DRAWABLE_STATE_DIRTY = 1024;
    private static final int PFLAG_PRESSED = 16384;
    private static final int POPUP_WINDOW_APPEAR_DURATION = 350;
    private static final int POPUP_WINDOW_DISAPPEAR_DURATION = 300;
    private static final String PROPERTY_FIRST_POPUP_ALPHA = "PROPERTY_FIRST_POPUP_ALPHA";
    private static final String PROPERTY_FIRST_POPUP_SCALE = "PROPERTY_FIRST_POPUP_SCALE";
    private static final float SCALE_MAX = 1.0f;
    private static final float SCALE_MIN = 0.8f;
    private static final int SEC_WINDOW_SHOW_DELAY_DURATION = 1000;
    private static final String TAG = "COUITouchSearchView";
    private static final int VIEW_STATE_ACCELERATED = 64;
    private static final int VIEW_STATE_ACTIVATED = 32;
    private static final int VIEW_STATE_DRAG_CAN_ACCEPT = 256;
    private static final int VIEW_STATE_DRAG_HOVERED = 512;
    private static final int VIEW_STATE_ENABLED = 8;
    private static final int VIEW_STATE_FOCUSED = 4;
    private static final int VIEW_STATE_HOVERED = 128;
    private static final int[] VIEW_STATE_IDS;
    private static final int VIEW_STATE_PRESSED = 16;
    private static final int VIEW_STATE_SELECTED = 2;
    private static final int VIEW_STATE_WINDOW_FOCUSED = 1;
    private static int sSTYLEABLELENGTH;
    private static int[][] sVIEWSETS;
    private static int[][][] sVIEWSTATESETS;
    private AccessibilityManager.AccessibilityStateChangeListener mAccessChangeListener;
    private AccessibilityManager mAccessManager;
    private AccessibilityManager.TouchExplorationStateChangeListener mAccessTouchChangeListener;
    private float mAccessibilityTouchDownY;
    private int mActivePointerId;
    private int mBackgroundAlignMode;
    private int mBackgroundLeftMargin;
    private int mBackgroundRightMargin;
    private int mBackgroundWidth;
    private Drawable mCOUITouchFirstPopTopBg;
    private int mCellHeight;
    private Context mContext;
    private ColorStateList mDefaultDotTextColor;
    private int mDefaultDotTextSize;
    private ColorStateList mDefaultTextColor;
    private int mDefaultTextSize;
    private Runnable mDismissTask;
    private CharSequence mDisplayKey;
    private CharSequence mDot;
    private int mDotLevel;
    private boolean mEnableAdaptiveVibrator;
    private PatternExploreByTouchHelper mExploreByTouchHelper;
    public boolean mFirstIsCharacter;
    private PopupWindow mFirstKeyPopupWindow;
    private boolean mFirstLayout;
    private float mFirstPopupAlpha;
    private float mFirstPopupScale;
    private int mFirstPopupTextOffset;
    private ValueAnimator mFirstPopupValueAppearAnimator;
    private ValueAnimator mFirstPopupValueDisAppearAnimator;
    private Typeface mFontFace;
    private boolean mFrameChanged;
    private Handler mHandler;
    private boolean mHasMotorVibrator;
    private ArrayList<IndexIndicationKey> mHasValueKeyTexts;
    private boolean mHeightNotEnough;
    private List<int[]> mIconState;
    private boolean mInTouching;
    private boolean mIsAccessibilityEnabled;
    private boolean mIsFirstMarginTop;
    private int mItemSpacing;
    private ArrayList<Key> mKey;
    private Drawable mKeyCollectDrawable;
    private int mKeyDrawableHeight;
    private int mKeyDrawableWidth;
    private int[] mKeyIndexAndOriginalIndex;
    private int mKeyIndices;
    private int mKeyPaddingX;
    private int mKeyPaddingY;
    private LayoutInflater mLayoutInflater;
    private ArrayList<LetterLimitLevelInfo> mLimitLevelInfoArray;
    private Object mLinearMotorVibrator;
    private int[] mLocationInWindow;
    private int mLowVelocityThreshold;
    private TextPaint mMeasurePaint;
    private int mMidVelocityThreshold;
    private Drawable mPopupCollectDrawable;
    private ImageView mPopupFirstImageView;
    private LinearLayout mPopupFirstLayout;
    private int mPopupFirstLayoutHeight;
    private int mPopupFirstLayoutWidth;
    private TextView mPopupFirstTextView;
    private int mPopupFirstWidth;
    private int mPopupSecondTextHeight;
    private int mPopupSecondTextViewSize;
    private int mPopupSecondTextWidth;
    private int mPopupWinSecondNameMaxHeight;
    private int mPopupWindowEndGap;
    private int mPopupWindowEndMargin;
    private int mPopupWindowFirstKeyTextSize;
    private int mPopupWindowFirstLocalx;
    private int mPopupWindowFirstLocaly;
    private int mPopupWindowFirstTextColor;
    private int mPopupWindowMinTop;
    private int mPopupWindowSecondLocalx;
    private int mPopupWindowSecondLocaly;
    private Rect mPositionRect;
    private int mPreviousIndex;
    protected List<Integer> mPrivateFlags;
    private int mScrollViewHeight;
    private ViewGroup mSecondKeyContainer;
    private PopupWindow mSecondKeyPopupWindow;
    private ScrollView mSecondKeyScrollView;
    private int mSecondPopupMargin;
    private int mSecondPopupOffset;
    private String mStrLastSymbol;
    private int mStyle;
    private ColorStateList mTextColor;
    private int mTotalItemHeight;
    private int mTouchPaddingEnd;
    private int mTouchPaddingStart;
    private TouchSearchActionListener mTouchSearchActionListener;
    private int mTouchSlop;
    private int mTrackerMaxVelocity;
    private int mTrackerPeriod;
    private ColorStateList mUserTextColor;
    private int mUserTextSize;
    private VelocityTracker mVelocityTracker;
    private float mVibrateIntensity;
    private int mVibrateLevel;
    private OplusZoomWindowManager mZoomWindowManager;

    /* loaded from: classes3.dex */
    public static class IndexIndicationKey {
        public boolean hasValue;
        public String keyText;

        public String toString() {
            return "IndexIndicationKey{keyText='" + this.keyText + "', hasValue=" + this.hasValue + '}';
        }
    }

    /* loaded from: classes3.dex */
    public static class LetterLimitLevelInfo {
        public int dotLevel;
        public int dotSize;
        public int limitHeight;
        public int replenishDotValueTheIndex;
        public int showLetterSize;

        public LetterLimitLevelInfo(int i10, int i11, int i12, int i13, int i14) {
            this.dotLevel = i10;
            this.dotSize = i11;
            this.showLetterSize = i12;
            this.limitHeight = i13;
            this.replenishDotValueTheIndex = i14;
        }
    }

    /* loaded from: classes3.dex */
    public final class PatternExploreByTouchHelper extends a {
        private static final int INIT_VIRTUAL_ID = -1;
        private Rect mTempRect;

        public PatternExploreByTouchHelper(View view) {
            super(view);
            this.mTempRect = new Rect();
        }

        private Rect getBoundsForVirtualView(int i10) {
            Rect rect = this.mTempRect;
            if (i10 >= 0 && i10 <= COUITouchSearchView.this.mKey.size() - 1) {
                Key key = (Key) COUITouchSearchView.this.mKey.get(i10);
                rect.left = key.mLeft;
                rect.top = key.mTop;
                rect.right = COUITouchSearchView.this.getWidth();
                rect.bottom = key.mTouchBottom;
                return rect;
            }
            rect.left = 0;
            rect.top = 0;
            rect.right = COUITouchSearchView.this.getWidth();
            rect.bottom = COUITouchSearchView.this.getHeight();
            return rect;
        }

        @Override // androidx.customview.widget.a
        public int getVirtualViewAt(float f10, float f11) {
            if (!COUITouchSearchView.this.mHasValueKeyTexts.isEmpty() && !COUITouchSearchView.this.mKey.isEmpty()) {
                return COUITouchSearchView.this.virtualViewAtKey((int) f11);
            }
            return -1;
        }

        @Override // androidx.customview.widget.a
        public void getVisibleVirtualViews(List<Integer> list) {
            if (!COUITouchSearchView.this.mHasValueKeyTexts.isEmpty() && !COUITouchSearchView.this.mKey.isEmpty()) {
                for (int i10 = 0; i10 < COUITouchSearchView.this.mHasValueKeyTexts.size(); i10++) {
                    if (((IndexIndicationKey) COUITouchSearchView.this.mHasValueKeyTexts.get(i10)).hasValue) {
                        list.add(Integer.valueOf(i10));
                    }
                }
            }
        }

        @Override // androidx.customview.widget.a, androidx.core.view.C0446a
        public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
        }

        @Override // androidx.customview.widget.a
        public boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle) {
            int i12 = 0;
            if (i11 != 16) {
                return false;
            }
            while (true) {
                if (i12 >= COUITouchSearchView.this.mHasValueKeyTexts.size()) {
                    break;
                }
                IndexIndicationKey indexIndicationKey = (IndexIndicationKey) COUITouchSearchView.this.mHasValueKeyTexts.get(i12);
                if (indexIndicationKey.hasValue && i10 == i12) {
                    COUITouchSearchView.this.invalidateKey(COUITouchSearchView.this.getWillDisplayY(indexIndicationKey.keyText), true);
                    break;
                }
                i12++;
            }
            COUITouchSearchView.this.invalidate();
            return true;
        }

        @Override // androidx.core.view.C0446a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            if (COUITouchSearchView.this.mDisplayKey != null && !COUITouchSearchView.this.mDisplayKey.equals("")) {
                accessibilityEvent.setContentDescription(COUITouchSearchView.this.getContext().getString(j.f12520b, COUITouchSearchView.this.mDisplayKey));
            }
        }

        @Override // androidx.customview.widget.a
        public void onPopulateEventForVirtualView(int i10, AccessibilityEvent accessibilityEvent) {
            String str;
            if (!COUITouchSearchView.this.mHasValueKeyTexts.isEmpty() && !COUITouchSearchView.this.mKey.isEmpty() && (str = ((IndexIndicationKey) COUITouchSearchView.this.mHasValueKeyTexts.get(i10)).keyText) != null && !str.equals("")) {
                accessibilityEvent.getText().add(str);
            }
        }

        @Override // androidx.customview.widget.a
        public void onPopulateNodeForVirtualView(int i10, d dVar) {
            if (i10 == -1) {
                return;
            }
            String str = ((IndexIndicationKey) COUITouchSearchView.this.mHasValueKeyTexts.get(i10)).keyText;
            if (COUITouchSearchView.this.mHeightNotEnough) {
                int i11 = i10;
                i10 = 0;
                while (true) {
                    if (i10 < COUITouchSearchView.this.mKey.size()) {
                        Key key = (Key) COUITouchSearchView.this.mKey.get(i10);
                        if (key.mIsDot) {
                            Iterator<Key> it = key.mHiddenCharList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                } else if (it.next().mText.equals(str)) {
                                    i11 = i10;
                                    break;
                                }
                            }
                        } else if (key.mText.equals(str)) {
                            break;
                        }
                        i10++;
                    } else {
                        i10 = i11;
                        break;
                    }
                }
            }
            dVar.l0(COUITouchSearchView.this.getContext().getString(j.f12520b, str));
            dVar.K0(str);
            dVar.h0(COUITouchSearchView.class.getName());
            dVar.c0(getBoundsForVirtualView(i10));
            dVar.a(16);
        }

        @Override // androidx.customview.widget.a
        public void onVirtualViewKeyboardFocusChanged(int i10, boolean z10) {
            super.onVirtualViewKeyboardFocusChanged(i10, z10);
        }
    }

    /* loaded from: classes3.dex */
    public interface TouchSearchActionListener {
        void onKey(CharSequence charSequence);

        void onLongKey(CharSequence charSequence);

        void onNameClick(CharSequence charSequence);
    }

    static {
        int[] iArr = {R.attr.state_window_focused, 1, 16842913, 2, 16842908, 4, 16842910, 8, 16842919, 16, R.attr.state_activated, 32, R.attr.state_accelerated, 64, 16843623, 128, R.attr.state_drag_can_accept, 256, R.attr.state_drag_hovered, 512};
        VIEW_STATE_IDS = iArr;
        int length = l.f12553E1.length;
        sSTYLEABLELENGTH = length;
        int length2 = iArr.length / 2;
        if (length2 == length) {
            int length3 = iArr.length;
            int[] iArr2 = new int[length3];
            for (int i10 = 0; i10 < sSTYLEABLELENGTH; i10++) {
                int i11 = l.f12553E1[i10];
                int i12 = 0;
                while (true) {
                    int[] iArr3 = VIEW_STATE_IDS;
                    if (i12 < iArr3.length) {
                        if (iArr3[i12] == i11) {
                            int i13 = i10 * 2;
                            iArr2[i13] = i11;
                            iArr2[i13 + 1] = iArr3[i12 + 1];
                        }
                        i12 += 2;
                    }
                }
            }
            int i14 = 1 << length2;
            sVIEWSTATESETS = new int[i14][];
            sVIEWSETS = new int[i14];
            for (int i15 = 0; i15 < sVIEWSETS.length; i15++) {
                sVIEWSETS[i15] = new int[Integer.bitCount(i15)];
                int i16 = 0;
                for (int i17 = 0; i17 < length3; i17 += 2) {
                    if ((iArr2[i17 + 1] & i15) != 0) {
                        sVIEWSETS[i15][i16] = iArr2[i17];
                        i16++;
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("VIEW_STATE_IDS array length does not match ViewDrawableStates style array");
    }

    public COUITouchSearchView(Context context) {
        this(context, null);
    }

    private int calDotRadio(int i10, int i11) {
        int i12 = i10 + i11;
        int i13 = i11 + 1;
        int i14 = i12 / i13;
        if (i13 * i14 >= i12) {
            i14--;
        } else if (i14 == 3) {
            i14 = 2;
        }
        return Math.max(2, i14);
    }

    private void changeTextStatus() {
        ColorStateList colorStateList;
        int i10 = this.mKeyIndices;
        if (i10 != this.mPreviousIndex && -1 != i10) {
            setIconPressed(i10, true);
            Key key = this.mKey.get(this.mKeyIndices);
            refreshIconState(this.mKeyIndices, key.getIcon());
            if (key.mIsDot && (colorStateList = this.mDefaultDotTextColor) != null) {
                key.mTextPaint.setColor(colorStateList.getColorForState(getIconState(this.mKeyIndices), this.mDefaultDotTextColor.getDefaultColor()));
            } else {
                ColorStateList colorStateList2 = this.mTextColor;
                if (colorStateList2 != null) {
                    key.mTextPaint.setColor(colorStateList2.getColorForState(getIconState(this.mKeyIndices), this.mTextColor.getDefaultColor()));
                    invalidate();
                }
            }
        }
        int i11 = this.mPreviousIndex;
        if (-1 != i11 && this.mKeyIndices != i11 && i11 < this.mKey.size()) {
            setItemRestore(this.mPreviousIndex);
        }
        this.mPreviousIndex = this.mKeyIndices;
    }

    private boolean checkLetterLengthSmallLimit(int i10) {
        return i10 >= 8;
    }

    private void computeVelocityWithTouchEvent(int i10, MotionEvent motionEvent) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return;
                    }
                } else {
                    initVelocityTrackerIfNotExists();
                    this.mVelocityTracker.addMovement(motionEvent);
                    return;
                }
            }
            recycleVelocityTracker();
            return;
        }
        initOrResetVelocityTracker();
        this.mVelocityTracker.addMovement(motionEvent);
    }

    private boolean dealWithTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerId(motionEvent.getActionIndex()) > 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action == 6) {
                            onSecondaryPointerUp(motionEvent);
                            COUILog.d(TAG, "onTouchEvent --- pointer up --- mActivePointerId = " + this.mActivePointerId);
                        }
                        return true;
                    }
                }
            }
            dealWithTouchEventCancel();
            return true;
        }
        this.mActivePointerId = motionEvent.getPointerId(0);
        this.mHandler.removeCallbacks(this.mDismissTask);
        stopAnimationRunning();
        restoreAnimation();
        getLocationInWindow(this.mLocationInWindow);
        updatePopupWindow();
        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
        if (findPointerIndex == -1) {
            COUILog.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in dealWithTouchEvent ACTION_DOWN");
            return false;
        }
        invalidateKey((int) motionEvent.getY(findPointerIndex), false);
        int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
        if (findPointerIndex2 != -1) {
            invalidateKey((int) motionEvent.getY(findPointerIndex2), true);
        }
        return true;
    }

    private void dealWithTouchEventCancel() {
        this.mActivePointerId = -1;
        this.mDisplayKey = "";
        if (!this.mSecondKeyPopupWindow.isShowing()) {
            startFirstAnimationToDismiss();
        }
        this.mIsAccessibilityEnabled = false;
    }

    private void detachedFromWindowClosing() {
        stopAnimationRunning();
        if (this.mFirstKeyPopupWindow.isShowing()) {
            this.mFirstKeyPopupWindow.dismiss();
        }
    }

    private boolean displayChange(CharSequence charSequence) {
        if (charSequence != null && !charSequence.toString().equals(this.mDisplayKey.toString())) {
            return true;
        }
        return false;
    }

    private LetterLimitLevelInfo findLetterLimitLevelInfo(int i10) {
        LetterLimitLevelInfo letterLimitLevelInfo = null;
        for (int i11 = 0; i11 < this.mLimitLevelInfoArray.size(); i11++) {
            LetterLimitLevelInfo letterLimitLevelInfo2 = this.mLimitLevelInfoArray.get(i11);
            if (this.mLimitLevelInfoArray.get(i11).dotLevel == i10) {
                letterLimitLevelInfo = letterLimitLevelInfo2;
            }
        }
        return letterLimitLevelInfo;
    }

    private int getCharacterStartIndex() {
        if (!this.mFirstIsCharacter) {
            return 1;
        }
        return 0;
    }

    private int getDefaultLimitHeight() {
        if (this.mLimitLevelInfoArray.isEmpty()) {
            return 0;
        }
        return this.mLimitLevelInfoArray.get(0).limitHeight;
    }

    private int getKeyIndices(int i10) {
        if (this.mKey.size() <= 0) {
            return -1;
        }
        if ((this.mKey.size() == 1 || (this.mKey.size() > 1 && this.mKey.get(1).getTop() > i10)) && this.mHasValueKeyTexts.get(0).hasValue) {
            return 0;
        }
        ArrayList<Key> arrayList = this.mKey;
        if (i10 > arrayList.get(arrayList.size() - 1).getTop()) {
            ArrayList<IndexIndicationKey> arrayList2 = this.mHasValueKeyTexts;
            if (arrayList2.get(arrayList2.size() - 1).hasValue) {
                return this.mKey.size() - 1;
            }
        }
        int i11 = -1;
        for (int i12 = 0; i12 < this.mKey.size(); i12++) {
            Key key = this.mKey.get(i12);
            if (this.mHasValueKeyTexts.get(i12).hasValue) {
                i11 = i12;
            }
            if ((i10 >= key.mTouchTop && i10 <= key.mTouchBottom && i11 != -1) || (i10 <= key.mTouchBottom && i11 != -1)) {
                return i11;
            }
        }
        return -1;
    }

    private int getKeyIndicesByCharacter(String str) {
        if (this.mHeightNotEnough) {
            for (int i10 = 0; i10 < this.mKey.size(); i10++) {
                Key key = this.mKey.get(i10);
                if (key.mIsDot) {
                    for (int i11 = 0; i11 < key.mHiddenCharList.size(); i11++) {
                        if (str.equals(key.mHiddenCharList.get(i11).mText)) {
                            return i10;
                        }
                    }
                } else if (str.equals(key.mText)) {
                    return i10;
                }
            }
        } else {
            for (int i12 = 0; i12 < this.mKey.size(); i12++) {
                if (this.mKey.get(i12).mText.equals(str)) {
                    return i12;
                }
            }
        }
        return 0;
    }

    private void getKeyIndicesWithDots(int i10) {
        int i11;
        int size = this.mKey.size();
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < size; i14++) {
            Key key = this.mKey.get(i14);
            if (key.mIsDot) {
                int max = Math.max(Math.min(((int) Math.ceil((i10 - key.mTouchTop) / ((key.mTouchBottom - key.mTouchTop) / Math.max(key.mHiddenCharList.size(), 1)))) - 1, key.mHiddenCharList.size() - 1), 0);
                for (int i15 = 0; i15 < key.mHiddenCharList.size(); i15++) {
                    int i16 = key.mHiddenCharList.get(i15).mIndexInOriginalArray;
                    if (this.mHasValueKeyTexts.get(i16).hasValue) {
                        i12 = i14;
                        i13 = i16;
                    }
                    if (i15 >= max && i12 != -1) {
                        break;
                    }
                }
            } else if (this.mHasValueKeyTexts.get(key.mIndexInOriginalArray).hasValue) {
                i13 = key.mIndexInOriginalArray;
                i12 = i14;
            }
            if ((i10 >= key.mTouchTop && i10 <= key.mTouchBottom && i12 != -1) || (i10 <= (i11 = key.mTouchBottom) && i12 != -1)) {
                int[] iArr = this.mKeyIndexAndOriginalIndex;
                iArr[0] = i12;
                iArr[1] = i13;
                return;
            } else {
                if (i14 < size - 1 && i10 > i11 && i10 < this.mKey.get(i14 + 1).mTouchTop) {
                    return;
                }
            }
        }
    }

    private int getLetterSizeFromDot(int i10, int i11) {
        LetterLimitLevelInfo findLetterLimitLevelInfo;
        if (i10 == 6 || (findLetterLimitLevelInfo = findLetterLimitLevelInfo(i10)) == null) {
            return 0;
        }
        int size = this.mHasValueKeyTexts.size();
        if (!this.mFirstIsCharacter) {
            size--;
        }
        int i12 = size - findLetterLimitLevelInfo.showLetterSize;
        int i13 = findLetterLimitLevelInfo.dotSize;
        double d10 = i12 + i13;
        int i14 = (int) (d10 / i13);
        if (d10 % i13 == 0.0d) {
            return i14;
        }
        if (d10 % i13 == 1.0d) {
            if (i11 == i13 - 1) {
                return i14 + 1;
            }
            return i14;
        }
        if (i11 >= i13 - findLetterLimitLevelInfo.replenishDotValueTheIndex) {
            return i14 + 1;
        }
        return i14;
    }

    private int getLimitDotLevel(int i10) {
        for (int i11 = 0; i11 < this.mLimitLevelInfoArray.size(); i11++) {
            LetterLimitLevelInfo letterLimitLevelInfo = this.mLimitLevelInfoArray.get(i11);
            if (i10 >= letterLimitLevelInfo.limitHeight) {
                return letterLimitLevelInfo.dotLevel;
            }
        }
        return 6;
    }

    private LetterLimitLevelInfo getShowLettersSize(int i10, int i11, int i12, int i13) {
        int i14;
        int i15 = i10 - i11;
        if (!checkLetterLengthSmallLimit(i15) && i13 != 0) {
            return null;
        }
        double d10 = i15 - 1;
        if (i13 != 0) {
            if (i13 != 1) {
                if (i13 != 2 && i13 != 3 && i13 != 4) {
                    if (i13 != 5) {
                        return null;
                    }
                    return checkLetterLengthSmallLimit(i13, 6, i11 + 8, UIUtil.dip2px(getContext(), r3 * 16) + i12, (int) ((d10 - 1.0d) % 6.0d), i11);
                }
                double d11 = i13 + 1;
                int i16 = (int) (d10 % d11);
                int i17 = (int) (d10 / d11);
                return checkLetterLengthSmallLimit(i13, i17, ((i10 - (i17 * i13)) + i17) - i16, UIUtil.dip2px(getContext(), r4 * 16) + i12, i16, i11);
            }
            if (d10 % (i13 + 1) == 0.0d) {
                i14 = 2;
            } else {
                i14 = 1;
            }
            int i18 = i10 - i14;
            return checkLetterLengthSmallLimit(i13, ((i18 - i11) - 1) / 2, i18, UIUtil.dip2px(getContext(), i18 * 16) + i12, i14, i11);
        }
        return new LetterLimitLevelInfo(i13, 0, i10, UIUtil.dip2px(getContext(), i10 * 16) + i12, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWillDisplayY(CharSequence charSequence) {
        if (this.mHeightNotEnough) {
            for (int i10 = 0; i10 < this.mKey.size(); i10++) {
                Key key = this.mKey.get(i10);
                if (key.mIsDot) {
                    double max = (key.mTouchBottom - key.mTouchTop) / Math.max(key.mHiddenCharList.size(), 1);
                    for (int i11 = 0; i11 < key.mHiddenCharList.size(); i11++) {
                        if (charSequence.toString().equals(key.mHiddenCharList.get(i11).mText)) {
                            return (int) Math.min(key.mTouchTop + (max * (i11 + 1)), key.mTouchBottom);
                        }
                    }
                } else if (charSequence.toString().equals(key.mText)) {
                    int i12 = key.mTouchTop;
                    return i12 + ((key.mTouchBottom - i12) / 2);
                }
            }
            return -1;
        }
        for (int i13 = 0; i13 < this.mKey.size(); i13++) {
            Key key2 = this.mKey.get(i13);
            if (key2.mText.equals(charSequence.toString())) {
                int i14 = key2.mTouchTop;
                return i14 + ((key2.mTouchBottom - i14) / 2);
            }
        }
        return -1;
    }

    private void initAccessibility(Context context) {
        PatternExploreByTouchHelper patternExploreByTouchHelper = new PatternExploreByTouchHelper(this);
        this.mExploreByTouchHelper = patternExploreByTouchHelper;
        K.j0(this, patternExploreByTouchHelper);
        K.t0(this, 1);
        this.mExploreByTouchHelper.invalidateRoot();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setFocusableInTouchMode(true);
    }

    private void initAccessibilityListener(Context context) {
        this.mAccessManager = (AccessibilityManager) context.getApplicationContext().getSystemService("accessibility");
        this.mAccessChangeListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: com.coui.appcompat.touchsearchview.COUITouchSearchView.4
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public void onAccessibilityStateChanged(boolean z10) {
                COUITouchSearchView cOUITouchSearchView = COUITouchSearchView.this;
                cOUITouchSearchView.mIsAccessibilityEnabled = COUIAccessibilityUtil.isTalkbackEnabled(cOUITouchSearchView.getContext());
            }
        };
        this.mAccessTouchChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.coui.appcompat.touchsearchview.COUITouchSearchView.5
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public void onTouchExplorationStateChanged(boolean z10) {
                COUITouchSearchView cOUITouchSearchView = COUITouchSearchView.this;
                cOUITouchSearchView.mIsAccessibilityEnabled = COUIAccessibilityUtil.isTalkbackEnabled(cOUITouchSearchView.getContext());
            }
        };
        this.mAccessManager.addAccessibilityStateChangeListener(this.mAccessChangeListener);
        this.mAccessManager.addTouchExplorationStateChangeListener(this.mAccessTouchChangeListener);
    }

    private void initAttributes(Resources resources, Context context, TypedArray typedArray) {
        this.mBackgroundAlignMode = typedArray.getInt(l.f12630k1, 0);
        this.mBackgroundLeftMargin = typedArray.getDimensionPixelOffset(l.f12648q1, 0);
        this.mBackgroundRightMargin = typedArray.getDimensionPixelOffset(l.f12651r1, 0);
        this.mPopupFirstLayoutHeight = typedArray.getDimensionPixelOffset(l.f12657t1, resources.getDimensionPixelOffset(C0535e.f12396a0));
        this.mPopupFirstLayoutWidth = typedArray.getDimensionPixelOffset(l.f12666w1, resources.getDimensionPixelOffset(C0535e.f12398b0));
        this.mPopupSecondTextHeight = typedArray.getDimensionPixelOffset(l.f12672y1, this.mPopupFirstLayoutHeight);
        this.mPopupSecondTextWidth = typedArray.getDimensionPixelOffset(l.f12547C1, this.mPopupFirstLayoutWidth);
        this.mSecondPopupOffset = typedArray.getDimensionPixelOffset(l.f12541A1, resources.getDimensionPixelOffset(C0535e.f12404e0));
        this.mSecondPopupMargin = typedArray.getDimensionPixelOffset(l.f12675z1, resources.getDimensionPixelOffset(C0535e.f12410h0));
        this.mVibrateLevel = typedArray.getInteger(l.f12550D1, 0);
        this.mPopupWindowMinTop = typedArray.getInteger(l.f12669x1, resources.getInteger(C0538h.f12498a));
        this.mPopupSecondTextViewSize = typedArray.getDimensionPixelSize(l.f12544B1, context.getResources().getDimensionPixelSize(C0535e.f12412i0));
        this.mPopupWinSecondNameMaxHeight = resources.getDimensionPixelSize(C0535e.f12402d0);
        this.mPopupWindowFirstKeyTextSize = typedArray.getDimensionPixelSize(l.f12663v1, resources.getDimensionPixelSize(C0535e.f12406f0));
        this.mPopupWindowFirstTextColor = typedArray.getColor(l.f12660u1, COUIContextUtil.getAttrColor(context, c.f4348G));
        this.mKeyCollectDrawable = C1607c.e(context, typedArray, l.f12639n1);
        this.mPopupCollectDrawable = C1607c.e(context, typedArray, l.f12654s1);
        this.mDefaultTextColor = C1607c.a(context, typedArray, l.f12642o1);
        this.mFirstIsCharacter = typedArray.getBoolean(l.f12633l1, false);
        this.mEnableAdaptiveVibrator = typedArray.getBoolean(l.f12627j1, true);
        this.mDefaultTextSize = typedArray.getDimensionPixelSize(l.f12645p1, resources.getDimensionPixelSize(C0535e.f12392X));
        this.mIsFirstMarginTop = typedArray.getBoolean(l.f12636m1, this.mIsFirstMarginTop);
    }

    private void initDimensionAndColorAttributes(Resources resources, Context context) {
        this.mBackgroundRightMargin += resources.getDimensionPixelOffset(C0535e.f12414j0);
        this.mPopupWindowEndMargin = resources.getDimensionPixelSize(C0535e.f12408g0);
        this.mItemSpacing = resources.getDimensionPixelSize(C0535e.f12390V);
        this.mCellHeight = resources.getDimensionPixelOffset(C0535e.f12389U);
        this.mPopupWindowEndGap = resources.getDimensionPixelOffset(C0535e.f12416k0);
        this.mTouchPaddingStart = resources.getDimensionPixelOffset(C0535e.f12420m0);
        this.mTouchPaddingEnd = resources.getDimensionPixelOffset(C0535e.f12418l0);
        this.mPopupFirstWidth = resources.getDimensionPixelOffset(C0535e.f12400c0);
        this.mCOUITouchFirstPopTopBg = context.getDrawable(C0536f.f12451e);
        this.mDefaultDotTextSize = resources.getDimensionPixelSize(C0535e.f12391W);
        this.mDefaultDotTextColor = b.d(context, C0534d.f12367e);
        this.mBackgroundWidth = resources.getDimensionPixelOffset(C0535e.f12388T);
        setPaddingRelative(0, context.getResources().getDimensionPixelSize(C0535e.f12394Z), 0, context.getResources().getDimensionPixelSize(C0535e.f12393Y));
    }

    private void initHeightRangeSpec() {
        int i10;
        this.mLimitLevelInfoArray.clear();
        int size = this.mHasValueKeyTexts.size();
        if (!this.mFirstIsCharacter) {
            size--;
        }
        int i11 = 1;
        if (TextUtils.isEmpty(this.mStrLastSymbol)) {
            ArrayList<IndexIndicationKey> arrayList = this.mHasValueKeyTexts;
            if (arrayList.get(arrayList.size() - 1).keyText.equals(this.mStrLastSymbol)) {
                i11 = 0;
            }
        }
        if (!this.mFirstIsCharacter) {
            i10 = this.mKeyDrawableHeight;
        } else {
            i10 = 0;
        }
        for (int i12 = 0; i12 < 6; i12++) {
            LetterLimitLevelInfo showLettersSize = getShowLettersSize(size, i11, i10, i12);
            if (showLettersSize != null) {
                this.mLimitLevelInfoArray.add(showLettersSize);
            } else {
                LetterLimitLevelInfo showLettersSize2 = getShowLettersSize(size, i11, i10, 5);
                if (showLettersSize2 != null) {
                    this.mLimitLevelInfoArray.add(showLettersSize2);
                    return;
                }
                return;
            }
        }
    }

    private void initKeyValue(Resources resources) {
        String[] stringArray;
        if (!this.mFirstIsCharacter) {
            stringArray = resources.getStringArray(C0531a.f12340a);
        } else {
            stringArray = resources.getStringArray(C0531a.f12341b);
        }
        ArrayList<IndexIndicationKey> arrayList = new ArrayList<>();
        for (String str : stringArray) {
            IndexIndicationKey indexIndicationKey = new IndexIndicationKey();
            indexIndicationKey.keyText = str;
            indexIndicationKey.hasValue = false;
            arrayList.add(indexIndicationKey);
        }
        setKeys(arrayList, INIT_STR_LAST_SYM_BOL);
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initPopupWindow(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mLayoutInflater = layoutInflater;
        View inflate = layoutInflater.inflate(C0539i.f12514p, (ViewGroup) null);
        this.mPopupFirstTextView = (TextView) inflate.findViewById(C0537g.f12470S);
        this.mPopupFirstLayout = (LinearLayout) inflate.findViewById(C0537g.f12466O);
        ImageView imageView = (ImageView) inflate.findViewById(C0537g.f12467P);
        this.mPopupFirstImageView = imageView;
        imageView.setImageDrawable(this.mPopupCollectDrawable);
        int suitableFontSize = (int) COUIChangeTextUtil.getSuitableFontSize(this.mPopupWindowFirstKeyTextSize, context.getResources().getConfiguration().fontScale, 4);
        this.mPopupWindowFirstKeyTextSize = suitableFontSize;
        this.mPopupFirstTextView.setTextSize(0, suitableFontSize);
        ViewGroup.LayoutParams layoutParams = this.mPopupFirstLayout.getLayoutParams();
        layoutParams.height = this.mPopupFirstLayoutHeight;
        layoutParams.width = this.mPopupFirstLayoutWidth;
        this.mPopupFirstLayout.setLayoutParams(layoutParams);
        this.mPopupFirstLayout.setBackground(this.mCOUITouchFirstPopTopBg);
        ShadowUtils.setElevationToView(this.mPopupFirstLayout, 2, context.getResources().getDimensionPixelOffset(f.f4523I5), this.mContext.getResources().getDimensionPixelOffset(f.f4537K5), COUIContextUtil.getColor(context, e.f4459y));
        this.mFirstKeyPopupWindow = new PopupWindow(context);
        COUIDarkModeUtil.setForceDarkAllow(this.mPopupFirstTextView, false);
        this.mFirstKeyPopupWindow.setWidth(this.mPopupFirstWidth);
        this.mFirstKeyPopupWindow.setHeight(this.mPopupFirstLayoutHeight);
        this.mFirstKeyPopupWindow.setBackgroundDrawable(null);
        this.mFirstKeyPopupWindow.setContentView(inflate);
        this.mFirstKeyPopupWindow.setAnimationStyle(0);
        inflate.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.coui.appcompat.touchsearchview.COUITouchSearchView.6
            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                UIUtil.safeForceHasOverlappingRendering(COUITouchSearchView.this.mFirstKeyPopupWindow.getContentView(), false);
                for (ViewParent parent = COUITouchSearchView.this.mFirstKeyPopupWindow.getContentView().getParent(); parent != null && (parent instanceof ViewGroup); parent = parent.getParent()) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    viewGroup.setClipToOutline(false);
                    viewGroup.setClipChildren(false);
                    UIUtil.safeForceHasOverlappingRendering((View) parent, false);
                }
                return windowInsets;
            }
        });
        this.mFirstKeyPopupWindow.setFocusable(false);
        this.mFirstKeyPopupWindow.setOutsideTouchable(false);
        this.mFirstKeyPopupWindow.setTouchable(false);
        this.mFirstKeyPopupWindow.setClippingEnabled(false);
        View inflate2 = this.mLayoutInflater.inflate(C0539i.f12516r, (ViewGroup) null);
        this.mSecondKeyScrollView = (ScrollView) inflate2.findViewById(C0537g.f12469R);
        this.mSecondKeyContainer = (ViewGroup) inflate2.findViewById(C0537g.f12468Q);
        PopupWindow popupWindow = new PopupWindow(context);
        this.mSecondKeyPopupWindow = popupWindow;
        popupWindow.setWidth(this.mPopupFirstLayoutWidth);
        this.mSecondKeyPopupWindow.setContentView(inflate2);
        this.mSecondKeyPopupWindow.setAnimationStyle(0);
        this.mSecondKeyPopupWindow.setBackgroundDrawable(null);
        this.mSecondKeyPopupWindow.setFocusable(false);
        this.mSecondKeyPopupWindow.setOutsideTouchable(false);
        this.mFirstKeyPopupWindow.setEnterTransition(null);
        this.mFirstKeyPopupWindow.setExitTransition(null);
        this.mSecondKeyPopupWindow.setEnterTransition(null);
        this.mSecondKeyPopupWindow.setExitTransition(null);
    }

    private ValueAnimator initPopupWindowAnimator(final View view, final boolean z10) {
        final ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(MOVE_EASE_INTERPOLATOR);
        if (z10) {
            valueAnimator.setDuration(300L);
            valueAnimator.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.touchsearchview.COUITouchSearchView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (((Float) valueAnimator.getAnimatedValue(COUITouchSearchView.PROPERTY_FIRST_POPUP_ALPHA)).floatValue() <= 0.0f) {
                        COUITouchSearchView.this.mFirstKeyPopupWindow.dismiss();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
        } else {
            valueAnimator.setDuration(350L);
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.touchsearchview.COUITouchSearchView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                if ((!z10 && COUITouchSearchView.this.mFirstPopupAlpha < 1.0f) || z10) {
                    COUITouchSearchView.this.mFirstPopupAlpha = ((Float) valueAnimator2.getAnimatedValue(COUITouchSearchView.PROPERTY_FIRST_POPUP_ALPHA)).floatValue();
                }
                COUITouchSearchView.this.mFirstPopupScale = ((Float) valueAnimator2.getAnimatedValue(COUITouchSearchView.PROPERTY_FIRST_POPUP_SCALE)).floatValue();
                view.setAlpha(COUITouchSearchView.this.mFirstPopupAlpha);
                view.setScaleX(COUITouchSearchView.this.mFirstPopupScale);
                view.setScaleY(COUITouchSearchView.this.mFirstPopupScale);
            }
        });
        return valueAnimator;
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateKey(int i10, boolean z10) {
        String str;
        int i11;
        if (this.mHeightNotEnough) {
            getKeyIndicesWithDots(i10);
            int[] iArr = this.mKeyIndexAndOriginalIndex;
            int i12 = iArr[0];
            if (i12 >= 0 && (i11 = iArr[1]) >= 0) {
                this.mKeyIndices = i12;
                str = this.mHasValueKeyTexts.get(i11).keyText;
            } else {
                return;
            }
        } else {
            int keyIndices = getKeyIndices(i10);
            if (keyIndices < 0) {
                return;
            }
            this.mKeyIndices = keyIndices;
            str = this.mHasValueKeyTexts.get(keyIndices).keyText;
        }
        if (displayChange(str)) {
            if (!this.mIsAccessibilityEnabled) {
                onKeyChanged(str.toString(), this.mKey.get(this.mKeyIndices).getLeft() - this.mKeyPaddingX, this.mKey.get(this.mKeyIndices).getTop(), this.mKeyIndices, z10);
            }
            String charSequence = str.toString();
            this.mDisplayKey = charSequence;
            TouchSearchActionListener touchSearchActionListener = this.mTouchSearchActionListener;
            if (touchSearchActionListener != null) {
                touchSearchActionListener.onKey(charSequence);
            }
            invalidateTouchBarText();
        }
    }

    private void invalidateTouchBarText() {
        int i10 = this.mKeyIndices;
        if (i10 != this.mPreviousIndex && -1 != i10) {
            performFeedback();
        }
        changeTextStatus();
    }

    private boolean isZoomWindowShown() {
        try {
            return OplusZoomWindowManager.getInstance().getCurrentZoomWindowState().windowShown;
        } catch (Error e10) {
            COUILog.d(TAG, "getCurrentZoomWindowState error: " + e10.getMessage());
            return false;
        } catch (Exception e11) {
            COUILog.d(TAG, "getCurrentZoomWindowState exception: " + e11.getMessage());
            return false;
        }
    }

    private void onKeyChanged(CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
        if (this.mFirstKeyPopupWindow == null) {
            return;
        }
        COUILog.d(TAG, "onKeyChanged --- display = " + ((Object) charSequence));
        if (!this.mFirstIsCharacter && this.mHasValueKeyTexts.get(0).keyText.equals(charSequence.toString())) {
            this.mPopupFirstImageView.setVisibility(0);
            this.mPopupFirstTextView.setVisibility(8);
            this.mFirstPopupTextOffset = (this.mLocationInWindow[1] - (this.mPopupFirstLayoutHeight / 2)) + this.mKeyCollectDrawable.getBounds().top + (this.mKeyDrawableHeight / 2);
        } else {
            this.mPopupFirstImageView.setVisibility(8);
            this.mPopupFirstTextView.setText(charSequence);
            this.mPopupFirstTextView.setVisibility(0);
            this.mFirstPopupTextOffset = (this.mLocationInWindow[1] - (this.mPopupFirstLayoutHeight / 2)) + i11 + ((this.mKey.get(i12).mTouchBottom - i11) / 2);
        }
        if (this.mIsFirstMarginTop) {
            this.mFirstPopupTextOffset = this.mLocationInWindow[1] + getPaddingTop();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mPopupFirstLayout.getLayoutParams();
        marginLayoutParams.topMargin = this.mFirstPopupTextOffset;
        this.mPopupFirstLayout.setLayoutParams(marginLayoutParams);
        if (z10) {
            this.mFirstPopupAlpha = 1.0f;
        }
        startFirstAnimationToShow();
        sendAccessibilityEvent(8192);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i10;
        int action = (motionEvent.getAction() & 65280) >> 8;
        int pointerId = motionEvent.getPointerId(action);
        COUILog.d(TAG, "onSecondaryPointerUp --- pointerId = " + pointerId);
        COUILog.d(TAG, "onSecondaryPointerUp --- mActivePointerId = " + this.mActivePointerId);
        if (pointerId == this.mActivePointerId) {
            if (action == 0) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            this.mActivePointerId = motionEvent.getPointerId(i10);
            COUILog.d(TAG, "onSecondaryPointerUp --- newPointerIndex = " + i10);
        }
    }

    private boolean performAdaptiveFeedback() {
        VelocityTracker velocityTracker;
        int i10;
        boolean z10;
        if (this.mLinearMotorVibrator == null) {
            LinearmotorVibrator linearMotorVibrator = VibrateUtils.getLinearMotorVibrator(getContext());
            this.mLinearMotorVibrator = linearMotorVibrator;
            if (linearMotorVibrator != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.mHasMotorVibrator = z10;
        }
        if (this.mLinearMotorVibrator == null || (velocityTracker = this.mVelocityTracker) == null) {
            return false;
        }
        velocityTracker.computeCurrentVelocity(this.mTrackerPeriod, this.mTrackerMaxVelocity);
        int abs = (int) Math.abs(this.mVelocityTracker.getYVelocity());
        if (abs > this.mMidVelocityThreshold) {
            i10 = 0;
        } else {
            i10 = 1;
        }
        VibrateUtils.setLinearMotorVibratorStrength((LinearmotorVibrator) this.mLinearMotorVibrator, i10, abs, this.mTrackerMaxVelocity, 1200, 1600, this.mVibrateLevel, this.mVibrateIntensity);
        return true;
    }

    private void performFeedback() {
        if ((!this.mHasMotorVibrator || !this.mEnableAdaptiveVibrator || !performAdaptiveFeedback()) && !performHapticFeedback(COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE_SYNC)) {
            performHapticFeedback(COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE);
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void refreshIcon() {
        ColorStateList colorStateList;
        int size = this.mKey.size();
        for (int i10 = 0; i10 < size; i10++) {
            int[][][] iArr = sVIEWSTATESETS;
            int[][] iArr2 = sVIEWSETS;
            int[][] iArr3 = new int[iArr2.length];
            iArr[i10] = iArr3;
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        }
        for (int i11 = 0; i11 < size; i11++) {
            this.mIconState.add(new int[sSTYLEABLELENGTH]);
            this.mPrivateFlags.add(0);
            Key key = this.mKey.get(i11);
            refreshIconState(i11, key.getIcon());
            if (key.mIsDot && (colorStateList = this.mDefaultDotTextColor) != null) {
                key.mTextPaint.setColor(colorStateList.getColorForState(getIconState(i11), this.mDefaultDotTextColor.getDefaultColor()));
            } else {
                ColorStateList colorStateList2 = this.mTextColor;
                if (colorStateList2 != null) {
                    key.mTextPaint.setColor(colorStateList2.getColorForState(getIconState(i11), this.mTextColor.getDefaultColor()));
                }
            }
        }
    }

    private void reset() {
        this.mKey.clear();
        this.mIconState.clear();
        this.mPrivateFlags.clear();
        int[] iArr = this.mKeyIndexAndOriginalIndex;
        iArr[0] = -1;
        iArr[1] = -1;
    }

    private void restoreAnimation() {
        this.mFirstPopupAlpha = 0.0f;
        this.mFirstPopupScale = SCALE_MIN;
    }

    private void setIconPressed(int i10, boolean z10) {
        int i11;
        int intValue = this.mPrivateFlags.get(i10).intValue();
        if (z10) {
            i11 = intValue | 16384;
        } else {
            i11 = intValue & (-16385);
        }
        this.mPrivateFlags.set(i10, Integer.valueOf(i11));
    }

    private void setItemRestore(int i10) {
        ColorStateList colorStateList;
        Key key = this.mKey.get(i10);
        setIconPressed(i10, false);
        refreshIconState(i10, key.getIcon());
        if (key.mIsDot && (colorStateList = this.mDefaultDotTextColor) != null) {
            key.mTextPaint.setColor(colorStateList.getColorForState(getIconState(i10), this.mDefaultDotTextColor.getDefaultColor()));
        } else {
            ColorStateList colorStateList2 = this.mTextColor;
            if (colorStateList2 != null) {
                key.mTextPaint.setColor(colorStateList2.getColorForState(getIconState(i10), this.mTextColor.getDefaultColor()));
            }
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPopupWindowAnimatorValues(boolean z10) {
        if (z10) {
            this.mFirstPopupValueDisAppearAnimator.setValues(PropertyValuesHolder.ofFloat(PROPERTY_FIRST_POPUP_ALPHA, this.mFirstPopupAlpha, 0.0f), PropertyValuesHolder.ofFloat(PROPERTY_FIRST_POPUP_SCALE, this.mFirstPopupScale, SCALE_MIN));
        } else {
            this.mFirstPopupValueAppearAnimator.setValues(PropertyValuesHolder.ofFloat(PROPERTY_FIRST_POPUP_ALPHA, this.mFirstPopupAlpha, 1.0f), PropertyValuesHolder.ofFloat(PROPERTY_FIRST_POPUP_SCALE, this.mFirstPopupScale, 1.0f));
        }
    }

    private void startFirstAnimationToDismiss() {
        this.mHandler.postDelayed(this.mDismissTask, 1000L);
    }

    private void startFirstAnimationToShow() {
        if (!this.mFirstKeyPopupWindow.isShowing()) {
            if (S.b(this)) {
                this.mFirstKeyPopupWindow.showAtLocation(this, 0, this.mPopupWindowFirstLocalx + this.mTouchPaddingStart + this.mPopupWindowEndGap, 0);
            } else {
                this.mFirstKeyPopupWindow.showAtLocation(this, 0, (this.mPopupWindowFirstLocalx + this.mTouchPaddingStart) - this.mPopupWindowEndGap, 0);
            }
        }
        this.mHandler.removeCallbacks(this.mDismissTask);
        if (!this.mFirstPopupValueAppearAnimator.isRunning()) {
            setPopupWindowAnimatorValues(false);
            this.mFirstPopupValueAppearAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopAnimationRunning() {
        ValueAnimator valueAnimator = this.mFirstPopupValueAppearAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mFirstPopupValueAppearAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.mFirstPopupValueDisAppearAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.mFirstPopupValueDisAppearAnimator.cancel();
        }
    }

    private void update() {
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        reset();
        updateKeys(height);
        refreshIcon();
        sendAccessibilityEvent(4);
    }

    private void updateBackGroundBound() {
        int i10;
        int i11;
        int i12 = this.mBackgroundAlignMode;
        if (i12 == 0) {
            int width = getWidth();
            int i13 = this.mBackgroundWidth;
            i10 = (width - i13) / 2;
            i11 = i13 + i10;
        } else if (i12 == 2) {
            i11 = getWidth() - this.mBackgroundRightMargin;
            i10 = i11 - this.mBackgroundWidth;
        } else {
            i10 = this.mBackgroundLeftMargin;
            i11 = i10 + this.mBackgroundWidth;
        }
        this.mPositionRect = new Rect(i10, 0, i11, getBottom() - getTop());
    }

    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.lang.String, android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r4v20 */
    private void updateKeys(int i10) {
        Drawable drawable;
        Drawable drawable2;
        int size = this.mHasValueKeyTexts.size();
        int paddingTop = getPaddingTop();
        int defaultLimitHeight = getDefaultLimitHeight();
        Rect rect = this.mPositionRect;
        if (rect != null) {
            int i11 = rect.left;
            int i12 = i11 + (((rect.right - i11) - this.mKeyDrawableWidth) / 2);
            int i13 = this.mTouchPaddingStart;
            this.mKeyPaddingX = (i12 + i13) - ((i13 + this.mTouchPaddingEnd) / 2);
        }
        ?? r42 = 0;
        if (defaultLimitHeight > i10) {
            this.mHeightNotEnough = true;
            int limitDotLevel = getLimitDotLevel(i10);
            this.mDotLevel = limitDotLevel;
            if (limitDotLevel == 6) {
                return;
            }
            LetterLimitLevelInfo findLetterLimitLevelInfo = findLetterLimitLevelInfo(limitDotLevel);
            if (findLetterLimitLevelInfo == null) {
                COUILog.e(TAG, "updateKeys letterLimitLevelInfo is null");
                return;
            }
            if (!this.mFirstIsCharacter && (drawable2 = this.mKeyCollectDrawable) != null) {
                Key key = new Key(drawable2, this.mHasValueKeyTexts.get(0).keyText);
                key.setLeft(this.mKeyPaddingX);
                key.setTop(paddingTop);
                key.mTouchTop = paddingTop;
                key.mTouchBottom = this.mKeyDrawableHeight + paddingTop;
                key.mIndexInOriginalArray = 0;
                this.mKey.add(key);
                paddingTop += this.mKeyDrawableHeight;
            }
            int defaultColor = this.mDefaultDotTextColor.getDefaultColor();
            int characterStartIndex = getCharacterStartIndex();
            int i14 = 0;
            int i15 = 0;
            while (characterStartIndex < size) {
                Key key2 = new Key(r42, r42);
                key2.setLeft(this.mKeyPaddingX);
                key2.setTop(paddingTop);
                if (i14 != 0 && i15 < findLetterLimitLevelInfo.dotSize) {
                    key2.mIsDot = true;
                    key2.mText = this.mDot.toString();
                    key2.mTextPaint.setColor(defaultColor);
                    key2.mTextPaint.setTextSize(this.mDefaultDotTextSize);
                    key2.mTouchTop = paddingTop;
                    key2.mTouchBottom = this.mCellHeight + paddingTop + this.mItemSpacing;
                    key2.mHiddenCharList = new ArrayList();
                    int letterSizeFromDot = getLetterSizeFromDot(this.mDotLevel, i15);
                    i15++;
                    if (this.mDotLevel >= 5) {
                        i14++;
                    } else {
                        i14 = 0;
                    }
                    int i16 = 0;
                    while (i16 < letterSizeFromDot) {
                        Key key3 = new Key();
                        key3.mIndexInOriginalArray = characterStartIndex;
                        key3.mText = this.mHasValueKeyTexts.get(characterStartIndex).keyText;
                        key2.mHiddenCharList.add(key3);
                        i16++;
                        characterStartIndex++;
                    }
                    characterStartIndex--;
                    paddingTop += this.mCellHeight + this.mItemSpacing;
                    this.mKey.add(key2);
                } else {
                    key2.mIndexInOriginalArray = characterStartIndex;
                    key2.mText = this.mHasValueKeyTexts.get(characterStartIndex).keyText;
                    key2.mTouchTop = paddingTop;
                    int i17 = this.mCellHeight;
                    int i18 = this.mItemSpacing;
                    key2.mTouchBottom = paddingTop + i17 + i18;
                    i14++;
                    paddingTop += i17 + i18;
                    this.mKey.add(key2);
                }
                characterStartIndex++;
                r42 = 0;
            }
        } else {
            this.mDotLevel = 0;
            this.mHeightNotEnough = false;
            if (!this.mFirstIsCharacter && (drawable = this.mKeyCollectDrawable) != null) {
                Key key4 = new Key(drawable, this.mHasValueKeyTexts.get(0).keyText);
                key4.setLeft(this.mKeyPaddingX);
                key4.setTop(paddingTop);
                key4.mTouchTop = paddingTop;
                key4.mTouchBottom = this.mKeyDrawableHeight + paddingTop;
                key4.mIndexInOriginalArray = 0;
                this.mKey.add(key4);
                paddingTop += this.mKeyDrawableHeight;
            }
            for (int characterStartIndex2 = getCharacterStartIndex(); characterStartIndex2 < size; characterStartIndex2++) {
                Key key5 = new Key(null, this.mHasValueKeyTexts.get(characterStartIndex2).keyText);
                key5.setLeft(this.mKeyPaddingX);
                key5.setTop(paddingTop);
                key5.mTouchTop = paddingTop;
                key5.mTouchBottom = this.mCellHeight + paddingTop + this.mItemSpacing;
                key5.mIndexInOriginalArray = characterStartIndex2;
                this.mKey.add(key5);
                paddingTop += this.mCellHeight + this.mItemSpacing;
            }
        }
        this.mTotalItemHeight = defaultLimitHeight;
    }

    private void updatePopupWindow() {
        if (this.mKey.size() < 1) {
            return;
        }
        if (S.b(this)) {
            int measuredWidth = this.mLocationInWindow[0] + getMeasuredWidth() + this.mPopupWindowEndMargin;
            this.mPopupWindowFirstLocalx = measuredWidth;
            this.mPopupWindowSecondLocalx = measuredWidth + this.mPopupFirstLayoutWidth + this.mSecondPopupMargin;
        } else {
            int i10 = (this.mLocationInWindow[0] - this.mPopupWindowEndMargin) - this.mPopupFirstWidth;
            this.mPopupWindowFirstLocalx = i10;
            this.mPopupWindowSecondLocalx = (i10 - this.mSecondPopupMargin) - this.mPopupSecondTextWidth;
        }
        int screenHeightMetrics = UIUtil.getScreenHeightMetrics(getContext());
        COUILog.i(TAG, "location in screen : " + this.mLocationInWindow[1] + "  key size : " + this.mKey.size() + "  cell height = " + this.mCellHeight);
        this.mPopupWindowFirstLocaly = this.mLocationInWindow[1] - ((screenHeightMetrics - getHeight()) / 2);
        if (this.mFirstKeyPopupWindow.isShowing() && this.mFirstKeyPopupWindow.getHeight() != screenHeightMetrics) {
            this.mFirstKeyPopupWindow.update(this.mPopupWindowFirstLocalx, this.mPopupWindowFirstLocaly, this.mPopupFirstWidth, screenHeightMetrics);
        } else if (!this.mFirstKeyPopupWindow.isShowing()) {
            this.mFirstKeyPopupWindow.setWidth(this.mPopupFirstWidth);
            this.mFirstKeyPopupWindow.setHeight(screenHeightMetrics);
        }
        COUILog.i(TAG, "first x : " + this.mPopupWindowFirstLocalx + "  first y : " + this.mPopupWindowFirstLocaly + "  second x : " + this.mPopupWindowSecondLocalx + "  second y : " + this.mPopupWindowSecondLocaly);
        if (this.mSecondKeyPopupWindow.isShowing()) {
            updateSecondPopup();
        }
    }

    private void updateSecondPopup() {
        if (this.mSecondKeyPopupWindow.isShowing()) {
            this.mSecondKeyPopupWindow.update(this.mPopupWindowSecondLocalx, this.mPopupWindowSecondLocaly, this.mPopupSecondTextWidth, this.mScrollViewHeight);
            return;
        }
        this.mSecondKeyPopupWindow.setWidth(this.mPopupSecondTextWidth);
        this.mSecondKeyPopupWindow.setHeight(this.mScrollViewHeight);
        this.mSecondKeyPopupWindow.showAtLocation(this, 0, this.mPopupWindowSecondLocalx, this.mPopupWindowSecondLocaly);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int virtualViewAtKey(int i10) {
        int i11;
        if (this.mHeightNotEnough) {
            getKeyIndicesWithDots(i10);
            int[] iArr = this.mKeyIndexAndOriginalIndex;
            if (iArr[0] < 0 || (i11 = iArr[1]) < 0) {
                return -1;
            }
            return i11;
        }
        int keyIndices = getKeyIndices(i10);
        if (keyIndices < 0) {
            return -1;
        }
        return keyIndices;
    }

    public void closing() {
        int i10 = this.mPreviousIndex;
        if (-1 != i10 && this.mKeyIndices != i10 && i10 < this.mKey.size()) {
            setItemRestore(this.mPreviousIndex);
        }
        int size = this.mKey.size();
        int i11 = this.mKeyIndices;
        if (i11 > -1 && i11 < size) {
            setItemRestore(i11);
        }
        this.mPreviousIndex = -1;
        if (this.mFirstKeyPopupWindow.isShowing()) {
            stopAnimationRunning();
            this.mFirstKeyPopupWindow.dismiss();
        }
        if (this.mSecondKeyPopupWindow.isShowing()) {
            this.mSecondKeyPopupWindow.dismiss();
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.mIsAccessibilityEnabled) {
            return this.mExploreByTouchHelper.dispatchHoverEvent(motionEvent) | super.dispatchHoverEvent(motionEvent);
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    public int[] getIconState(int i10) {
        int intValue = this.mPrivateFlags.get(i10).intValue();
        if ((intValue & 1024) != 0) {
            this.mIconState.set(i10, onCreateIconState(i10, 0));
            this.mPrivateFlags.set(i10, Integer.valueOf(intValue & (-1025)));
        }
        return this.mIconState.get(i10);
    }

    public PopupWindow getPopupWindow() {
        return this.mFirstKeyPopupWindow;
    }

    public TouchSearchActionListener getTouchSearchActionListener() {
        return this.mTouchSearchActionListener;
    }

    public void iconStateChanged(int i10, Drawable drawable) {
        int[] iconState = getIconState(i10);
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(iconState);
        }
    }

    public int makeTouchSearchLimitHeight(int i10) {
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i11 = i10 - paddingTop;
        for (int i12 = 0; i12 < this.mLimitLevelInfoArray.size(); i12++) {
            int i13 = this.mLimitLevelInfoArray.get(i12).limitHeight;
            if (i11 >= i13) {
                return i13 + paddingTop;
            }
        }
        return 0;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        VibrateUtils.registerHapticObserver(getContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.mTouchSearchActionListener.onNameClick(((TextView) view).getText());
    }

    public int[] onCreateIconState(int i10, int i11) {
        int i12;
        int intValue = this.mPrivateFlags.get(i10).intValue();
        if ((this.mPrivateFlags.get(i10).intValue() & 16384) != 0) {
            i12 = 16;
        } else {
            i12 = 0;
        }
        if ((intValue & 32) == 0) {
            i12 |= 8;
        }
        if (hasWindowFocus()) {
            i12 |= 1;
        }
        int[] iArr = sVIEWSTATESETS[i10][i12];
        if (i11 == 0) {
            return iArr;
        }
        if (iArr != null) {
            int[] iArr2 = new int[iArr.length + i11];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            return iArr2;
        }
        return new int[i11];
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;
        AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener;
        super.onDetachedFromWindow();
        detachedFromWindowClosing();
        VibrateUtils.unRegisterHapticObserver();
        AccessibilityManager accessibilityManager = this.mAccessManager;
        if (accessibilityManager != null && (accessibilityStateChangeListener = this.mAccessChangeListener) != null) {
            accessibilityManager.removeAccessibilityStateChangeListener(accessibilityStateChangeListener);
        }
        AccessibilityManager accessibilityManager2 = this.mAccessManager;
        if (accessibilityManager2 != null && (touchExplorationStateChangeListener = this.mAccessTouchChangeListener) != null) {
            accessibilityManager2.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDotLevel == 6) {
            return;
        }
        if (!this.mFirstIsCharacter && this.mKey.size() > 0) {
            Key key = this.mKey.get(0);
            if (key.getIcon() != null) {
                int left = key.getLeft();
                int top = key.getTop();
                this.mKeyCollectDrawable.setBounds(left, top, this.mKeyDrawableWidth + left, this.mKeyDrawableHeight + top);
                this.mKeyCollectDrawable.draw(canvas);
            }
        }
        int size = this.mKey.size();
        for (int characterStartIndex = getCharacterStartIndex(); characterStartIndex < size; characterStartIndex++) {
            Key key2 = this.mKey.get(characterStartIndex);
            TextPaint textPaint = key2.mTextPaint;
            String str = key2.mText;
            if (str != null) {
                canvas.drawText(str, key2.getLeft() + ((this.mKeyDrawableWidth - ((int) textPaint.measureText(str))) / 2), (((key2.mTouchBottom - key2.getTop()) / 2) - ((textPaint.descent() + textPaint.ascent()) / 2.0f)) + key2.getTop(), textPaint);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        COUILog.i(TAG, "onLayout left= " + i10 + " top= " + i11 + " right= " + i12 + " bottom= " + i13 + " mFrameChanged= " + this.mFrameChanged + " mFirstLayout= " + this.mFirstLayout);
        if (this.mFirstLayout || this.mFrameChanged) {
            updateBackGroundBound();
            update();
            if (this.mFirstLayout) {
                this.mFirstLayout = false;
            }
            if (this.mFrameChanged) {
                this.mFrameChanged = false;
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        this.mFrameChanged = true;
        super.onSizeChanged(i10, i11, i12, i13);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getVisibility() == 8) {
            if (this.mInTouching) {
                this.mInTouching = false;
                dealWithTouchEventCancel();
            }
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mInTouching = true;
        } else if (action == 3 || action == 1) {
            this.mInTouching = false;
        }
        if (this.mEnableAdaptiveVibrator) {
            computeVelocityWithTouchEvent(action, motionEvent);
        }
        return dealWithTouchEvent(motionEvent);
    }

    public void refresh() {
        ColorStateList colorStateList;
        String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        TypedArray typedArray = null;
        if ("attr".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, l.f12624i1, this.mStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, l.f12624i1, 0, this.mStyle);
        }
        if (typedArray != null) {
            this.mKeyCollectDrawable = typedArray.getDrawable(l.f12639n1);
            this.mTextColor = typedArray.getColorStateList(l.f12642o1);
            Drawable drawable = this.mContext.getDrawable(C0536f.f12451e);
            this.mCOUITouchFirstPopTopBg = drawable;
            setFirstKeyPopupDrawable(drawable);
            setPopupWindowTextColor(typedArray.getColor(l.f12660u1, COUIContextUtil.getAttrColor(this.mContext, c.f4348G)));
            typedArray.recycle();
        }
        if (!this.mKey.isEmpty()) {
            this.mKey.get(0).mIcon = this.mKeyCollectDrawable;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= this.mKey.size()) {
                break;
            }
            this.mIconState.add(new int[sSTYLEABLELENGTH]);
            this.mPrivateFlags.add(0);
            Key key = this.mKey.get(i10);
            refreshIconState(i10, key.getIcon());
            if (key.mIsDot && (colorStateList = this.mDefaultDotTextColor) != null) {
                key.mTextPaint.setColor(colorStateList.getColorForState(getIconState(i10), this.mDefaultDotTextColor.getDefaultColor()));
                break;
            }
            ColorStateList colorStateList2 = this.mTextColor;
            if (colorStateList2 != null) {
                key.mTextPaint.setColor(colorStateList2.getColorForState(getIconState(i10), this.mTextColor.getDefaultColor()));
            }
            i10++;
        }
        invalidate();
    }

    public void refreshIconState(int i10, Drawable drawable) {
        this.mPrivateFlags.set(i10, Integer.valueOf(this.mPrivateFlags.get(i10).intValue() | 1024));
        iconStateChanged(i10, drawable);
    }

    public void setBackgroundAlignMode(int i10) {
        this.mBackgroundAlignMode = i10;
    }

    public void setBackgroundLeftMargin(int i10) {
        this.mBackgroundLeftMargin = i10;
    }

    public void setBackgroundRightMargin(int i10) {
        this.mBackgroundRightMargin = i10;
    }

    public void setCharTextColor(ColorStateList colorStateList) {
        setCharTextColor(colorStateList, false);
    }

    public void setCharTextSize(int i10) {
        if (i10 != 0) {
            this.mUserTextSize = i10;
            this.mMeasurePaint.setTextSize(i10);
        }
    }

    public void setDefaultTextColor(ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        this.mTextColor = colorStateList;
        for (int i10 = 0; i10 < this.mKey.size(); i10++) {
            this.mIconState.add(new int[sSTYLEABLELENGTH]);
            this.mPrivateFlags.add(new Integer(0));
            refreshIconState(i10, this.mKey.get(i10).getIcon());
            Key key = this.mKey.get(i10);
            if (key.mIsDot && (colorStateList2 = this.mDefaultDotTextColor) != null) {
                key.mTextPaint.setColor(colorStateList2.getColorForState(getIconState(i10), this.mDefaultDotTextColor.getDefaultColor()));
            } else {
                ColorStateList colorStateList3 = this.mTextColor;
                if (colorStateList3 != null) {
                    key.mTextPaint.setColor(colorStateList3.getColorForState(getIconState(i10), this.mTextColor.getDefaultColor()));
                }
            }
        }
        invalidate();
    }

    public void setDefaultTextSize(int i10) {
        this.mDefaultTextSize = i10;
    }

    public void setEnableAdaptiveVibrator(boolean z10) {
        this.mEnableAdaptiveVibrator = z10;
    }

    public void setFirstKeyIsCharacter(boolean z10) {
        if (z10 == this.mFirstIsCharacter) {
            return;
        }
        this.mFirstIsCharacter = z10;
        initHeightRangeSpec();
    }

    public void setFirstKeyPopupDrawable(Drawable drawable) {
        if (drawable != null) {
            this.mPopupFirstTextView.setText((CharSequence) null);
            this.mPopupFirstLayout.setBackground(drawable);
        } else {
            this.mPopupFirstTextView.setText(this.mKey.get(this.mKeyIndices).mText);
            this.mPopupFirstLayout.setBackground(this.mCOUITouchFirstPopTopBg);
        }
    }

    public void setFirstKeyPopupWindowSize(int i10, int i11) {
        if (this.mPopupFirstLayoutWidth != i10 || this.mPopupFirstLayoutHeight != i11) {
            this.mPopupFirstLayoutWidth = i10;
            this.mPopupFirstLayoutHeight = i11;
            ViewGroup.LayoutParams layoutParams = this.mPopupFirstLayout.getLayoutParams();
            layoutParams.height = i11;
            layoutParams.width = i10;
            this.mPopupFirstLayout.setLayoutParams(layoutParams);
            updatePopupWindow();
        }
    }

    public void setIsFirstMarginTop(boolean z10) {
        this.mIsFirstMarginTop = z10;
    }

    public void setKeyCollectDrawable(Drawable drawable) {
        this.mKeyCollectDrawable = drawable;
    }

    public void setKeys(ArrayList<IndexIndicationKey> arrayList, String str) {
        if (arrayList.isEmpty()) {
            COUILog.d(TAG, "setKeys indexIndicationKeys is null");
            return;
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            if (TextUtils.isEmpty(arrayList.get(i10).keyText)) {
                COUILog.d(TAG, "setKeys," + i10 + " the value.keyText is null");
                return;
            }
        }
        this.mStrLastSymbol = str;
        this.mHasValueKeyTexts = arrayList;
        initHeightRangeSpec();
        COUILog.d(TAG, "setKeys,the KEYS is " + this.mHasValueKeyTexts.toString());
        update();
        invalidate();
    }

    public void setName(String[] strArr) {
        int length;
        if (strArr == null) {
            length = 0;
        } else {
            length = strArr.length;
        }
        if (length == 0) {
            return;
        }
        int childCount = this.mSecondKeyContainer.getChildCount();
        if (length > childCount) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.mPopupFirstLayoutWidth, this.mPopupFirstLayoutHeight);
            for (int i10 = 0; i10 < length - childCount; i10++) {
                TextView textView = (TextView) this.mLayoutInflater.inflate(C0539i.f12515q, (ViewGroup) null);
                textView.setTextSize(0, (int) COUIChangeTextUtil.getSuitableFontSize(this.mPopupSecondTextViewSize, this.mContext.getResources().getConfiguration().fontScale, 4));
                this.mSecondKeyContainer.addView(textView, layoutParams);
                textView.setOnClickListener(this);
            }
        } else {
            for (int i11 = 0; i11 < childCount - length; i11++) {
                this.mSecondKeyContainer.removeViewAt((childCount - i11) - 1);
            }
        }
        for (int i12 = 0; i12 < length; i12++) {
            ((TextView) this.mSecondKeyContainer.getChildAt(i12)).setText(strArr[i12]);
        }
        int i13 = ((ViewGroup.MarginLayoutParams) this.mPopupFirstLayout.getLayoutParams()).topMargin;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mSecondKeyScrollView.getLayoutParams();
        int i14 = length * this.mPopupSecondTextHeight;
        this.mScrollViewHeight = i14;
        int min = Math.min(i14, this.mPopupWinSecondNameMaxHeight);
        this.mScrollViewHeight = min;
        marginLayoutParams.height = min;
        this.mSecondKeyScrollView.setLayoutParams(marginLayoutParams);
        this.mPopupWindowSecondLocaly = (this.mPopupWindowFirstLocaly + i13) - ((this.mScrollViewHeight - this.mPopupFirstLayoutHeight) / 2);
        int height = this.mLocationInWindow[1] + getHeight();
        int i15 = this.mSecondPopupOffset;
        int i16 = (height + i15) - this.mScrollViewHeight;
        int i17 = this.mLocationInWindow[1] - i15;
        int i18 = this.mPopupWindowSecondLocaly;
        if (i18 < i17) {
            this.mPopupWindowSecondLocaly = i17;
        } else if (i18 > i16) {
            this.mPopupWindowSecondLocaly = i16;
        }
        updateSecondPopup();
    }

    public void setPopText(String str, String str2) {
        stopAnimationRunning();
        startFirstAnimationToShow();
        this.mPopupFirstTextView.setText(str2);
        this.mKeyIndices = str.charAt(0) - '?';
        if (str.equals(INIT_STR_LAST_SYM_BOL)) {
            this.mKeyIndices = 1;
        }
        this.mHasValueKeyTexts.size();
    }

    public void setPopupSecondTextHeight(int i10) {
        this.mPopupSecondTextHeight = i10;
    }

    public void setPopupSecondTextViewSize(int i10) {
        this.mPopupSecondTextViewSize = i10;
    }

    public void setPopupSecondTextWidth(int i10) {
        this.mPopupSecondTextWidth = i10;
    }

    public void setPopupTextView(String str) {
        stopAnimationRunning();
        startFirstAnimationToShow();
        setTouchBarSelectedText(str);
    }

    public void setPopupWindowFirstTextSize(int i10) {
        if (this.mPopupWindowFirstKeyTextSize != i10) {
            this.mPopupWindowFirstKeyTextSize = i10;
            this.mPopupFirstTextView.setTextSize(0, i10);
        }
    }

    public void setPopupWindowTextColor(int i10) {
        if (this.mPopupWindowFirstTextColor != i10) {
            this.mPopupWindowFirstTextColor = i10;
            this.mPopupFirstTextView.setTextColor(i10);
            invalidate();
        }
    }

    public void setPopupWindowTopMinCoordinate(int i10) {
        if (this.mPopupWindowMinTop != i10) {
            this.mPopupWindowMinTop = i10;
        }
    }

    public void setSecondPopupMargin(int i10) {
        this.mSecondPopupMargin = i10;
    }

    public void setSecondPopupOffset(int i10) {
        this.mSecondPopupOffset = i10;
    }

    @Deprecated
    public void setSmartShowMode(String[] strArr, int[] iArr) {
        if (strArr != null && iArr != null && !strArr[0].equals(" ") && strArr.length >= 8) {
            COUILog.e(TAG, "setSmartShowMode is Deprecated");
            update();
            invalidate();
        }
    }

    public void setTouchBarSelectedText(String str) {
        this.mPopupFirstTextView.setText(str);
        this.mPreviousIndex = this.mKeyIndices;
        this.mKeyIndices = getKeyIndicesByCharacter(str);
        this.mDisplayKey = str;
        if (str.equals(INIT_STR_LAST_SYM_BOL)) {
            this.mKeyIndices = 1;
        }
        int size = this.mKey.size();
        int i10 = this.mKeyIndices;
        if (i10 >= 0 && i10 <= size - 1) {
            invalidateTouchBarText();
        }
    }

    public void setTouchSearchActionListener(TouchSearchActionListener touchSearchActionListener) {
        this.mTouchSearchActionListener = touchSearchActionListener;
    }

    public void setVibrateIntensity(float f10) {
        this.mVibrateIntensity = f10;
    }

    public void setVibrateLevel(int i10) {
        this.mVibrateLevel = i10;
    }

    public void updateMoveTouchBarText(CharSequence charSequence) {
        int willDisplayY;
        int i10;
        if (this.mInTouching || (willDisplayY = getWillDisplayY(charSequence)) < 0) {
            return;
        }
        if (this.mHeightNotEnough) {
            getKeyIndicesWithDots(willDisplayY);
            int[] iArr = this.mKeyIndexAndOriginalIndex;
            int i11 = iArr[0];
            if (i11 >= 0 && (i10 = iArr[1]) >= 0) {
                this.mKeyIndices = i11;
                this.mDisplayKey = this.mHasValueKeyTexts.get(i10).keyText;
            } else {
                return;
            }
        } else {
            int keyIndices = getKeyIndices(willDisplayY);
            if (keyIndices < 0) {
                return;
            }
            this.mKeyIndices = keyIndices;
            this.mDisplayKey = this.mHasValueKeyTexts.get(keyIndices).keyText;
        }
        changeTextStatus();
    }

    public COUITouchSearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0532b.f12360s);
    }

    private LetterLimitLevelInfo checkLetterLengthSmallLimit(int i10, int i11, int i12, int i13, int i14, int i15) {
        if (i12 - i15 < 8) {
            return null;
        }
        return new LetterLimitLevelInfo(i10, i11, i12, i13, i14);
    }

    public void setCharTextColor(ColorStateList colorStateList, boolean z10) {
        if (colorStateList != null) {
            this.mUserTextColor = colorStateList;
        }
        if (z10) {
            update();
        }
    }

    public COUITouchSearchView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, k.f12538p);
    }

    /* loaded from: classes3.dex */
    public class Key {
        List<Key> mHiddenCharList;
        Drawable mIcon;
        int mIndexInOriginalArray;
        boolean mIsDot;
        int mLeft;
        String mText;
        TextPaint mTextPaint;
        int mTop;
        int mTouchBottom;
        int mTouchTop;

        public Key() {
            this.mIcon = null;
            this.mText = null;
            this.mTextPaint = null;
        }

        public Drawable getIcon() {
            Drawable drawable = this.mIcon;
            if (drawable != null) {
                return drawable;
            }
            return null;
        }

        public int getLeft() {
            return this.mLeft;
        }

        public String getText() {
            String str = this.mText;
            if (str != null) {
                return str;
            }
            return null;
        }

        public int getTop() {
            return this.mTop;
        }

        public void setLeft(int i10) {
            this.mLeft = i10;
        }

        public void setTop(int i10) {
            this.mTop = i10;
        }

        public Key(Drawable drawable, String str) {
            this.mTextPaint = null;
            this.mIcon = drawable;
            this.mText = str;
            this.mTextPaint = new TextPaint(1);
            this.mTextPaint.setTextSize(COUITouchSearchView.this.mUserTextSize == 0 ? COUITouchSearchView.this.mDefaultTextSize : r3);
            COUITouchSearchView.this.mTextColor = COUITouchSearchView.this.mUserTextColor;
            if (COUITouchSearchView.this.mTextColor == null) {
                COUITouchSearchView.this.mTextColor = COUITouchSearchView.this.mDefaultTextColor;
            }
            if (COUITouchSearchView.this.mFontFace != null) {
                this.mTextPaint.setTypeface(COUITouchSearchView.this.mFontFace);
            }
        }
    }

    public COUITouchSearchView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        this.mPrivateFlags = new ArrayList();
        this.mIconState = new ArrayList();
        this.mFirstLayout = true;
        this.mFrameChanged = false;
        this.mDisplayKey = "";
        this.mActivePointerId = -1;
        this.mKeyIndices = -1;
        this.mKeyIndexAndOriginalIndex = new int[]{-1, -1};
        this.mPopupCollectDrawable = null;
        this.mKeyCollectDrawable = null;
        this.mKey = new ArrayList<>();
        this.mPreviousIndex = -1;
        this.mFirstIsCharacter = false;
        this.mDefaultTextColor = null;
        this.mUserTextColor = null;
        this.mTextColor = null;
        this.mDefaultDotTextColor = null;
        this.mDefaultTextSize = 0;
        this.mDefaultDotTextSize = 0;
        this.mUserTextSize = 0;
        this.mFontFace = null;
        this.mTrackerPeriod = 1000;
        this.mTrackerMaxVelocity = OplusRecorder.NWAV_SAMPLERATE;
        this.mLowVelocityThreshold = AFConstants.BIND_SERVICE_TIMEOUTMILLIS;
        this.mMidVelocityThreshold = 6000;
        this.mEnableAdaptiveVibrator = true;
        this.mHasMotorVibrator = true;
        this.mLinearMotorVibrator = null;
        this.mVibrateIntensity = 1.0f;
        this.mIsFirstMarginTop = false;
        this.mDotLevel = 0;
        this.mLimitLevelInfoArray = new ArrayList<>();
        this.mHasValueKeyTexts = new ArrayList<>();
        this.mFirstPopupAlpha = 0.0f;
        this.mFirstPopupScale = SCALE_MIN;
        this.mDismissTask = new Runnable() { // from class: com.coui.appcompat.touchsearchview.COUITouchSearchView.1
            @Override // java.lang.Runnable
            public void run() {
                COUITouchSearchView.this.stopAnimationRunning();
                COUITouchSearchView.this.setPopupWindowAnimatorValues(true);
                COUITouchSearchView.this.mFirstPopupValueDisAppearAnimator.start();
            }
        };
        this.mLocationInWindow = new int[2];
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        this.mContext = context;
        this.mHandler = new Handler(Looper.getMainLooper());
        Resources resources = getResources();
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.mStyle = attributeSet.getStyleAttribute();
        } else {
            this.mStyle = i11;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f12624i1, i10, i11);
        initAttributes(resources, context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        initDimensionAndColorAttributes(resources, context);
        this.mDot = resources.getString(j.f12521c);
        this.mHasMotorVibrator = VibrateUtils.isLinearMotorVersion(context);
        Drawable drawable = this.mKeyCollectDrawable;
        if (drawable != null) {
            this.mKeyDrawableWidth = drawable.getIntrinsicWidth();
            this.mKeyDrawableHeight = this.mKeyCollectDrawable.getIntrinsicHeight();
        }
        initKeyValue(resources);
        TextPaint textPaint = new TextPaint(1);
        this.mMeasurePaint = textPaint;
        textPaint.setTextSize(this.mDefaultTextSize);
        initPopupWindow(context);
        this.mFontFace = Typeface.create(COUIChangeTextUtil.MEDIUM_FONT, 0);
        this.mIsAccessibilityEnabled = COUIAccessibilityUtil.isTalkbackEnabled(getContext());
        initAccessibility(context);
        initAccessibilityListener(context);
        this.mFirstPopupValueAppearAnimator = initPopupWindowAnimator(this.mPopupFirstLayout, false);
        this.mFirstPopupValueDisAppearAnimator = initPopupWindowAnimator(this.mPopupFirstLayout, true);
    }
}

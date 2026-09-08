package com.coui.appcompat.emptyview;

import Z8.e;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Size;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coui.appcompat.statement.COUIMaxHeightScrollView;
import com.coui.appcompat.textviewcompatutil.COUITextViewCompatUtil;
import com.oplus.anim.EffectiveAnimationView;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.d;
import v9.InterfaceC1637a;
import x9.c;

/* compiled from: COUIEmptyStateView.kt */
/* loaded from: classes.dex */
public final class COUIEmptyStateView extends LinearLayout {
    private static final float ANIM_SIZE_SCALE_VALUE_NORMAL = 1.0f;
    private static final float ANIM_SIZE_SCALE_VALUE_SMALL = 0.6f;
    public static final Companion Companion = new Companion(null);
    private static final String EMPTY_STRING = "";
    public static final int EMPTY_VIEW_SIZE_TYPE_AUTO = 0;
    public static final int EMPTY_VIEW_SIZE_TYPE_LARGE = 3;
    public static final int EMPTY_VIEW_SIZE_TYPE_MEDIUM = 2;
    public static final int EMPTY_VIEW_SIZE_TYPE_SMALL = 1;
    private static final float HEIGHT_RATIO_NORMAL = 0.45f;
    private static final float HEIGHT_RATIO_SMALL = 0.5f;
    private static final int INVALID_VALUE = -1;
    private final d actionBt$delegate;
    private String actionText;
    private String animFileName;
    private int animHeight;
    private final d animView$delegate;
    private int animWidth;
    private boolean autoPlay;
    private final int defaultAnimHeight;
    private final int defaultAnimWidth;
    private final d emptyStateGroup$delegate;
    private int emptyViewSizeType;
    private final int heightThresholdMedium;
    private final int heightThresholdSmall;
    private int imageRes;
    private int rawAnimRes;
    private final d subTitle$delegate;
    private String subtitleText;
    private final d textContent$delegate;
    private final d title$delegate;
    private String titleText;
    private final int widthThresholdMedium;

    /* compiled from: COUIEmptyStateView.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIEmptyStateView(Context context) {
        this(context, null, 0, 0, 14, null);
        i.f(context, "context");
    }

    private final int calculateTopMargin(int i10) {
        int b10;
        int b11;
        b10 = c.b((getMeasuredHeight() - i10) * getMarginTopHeightRatio(getEmptyStateGroupSizeType$default(this, 0, 0, 3, null)));
        b11 = B9.i.b(b10, 0);
        return b11;
    }

    private final void disabledTextContentScroll() {
        getTextContent().post(new Runnable() { // from class: com.coui.appcompat.emptyview.b
            @Override // java.lang.Runnable
            public final void run() {
                COUIEmptyStateView.disabledTextContentScroll$lambda$2(COUIEmptyStateView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void disabledTextContentScroll$lambda$2(COUIEmptyStateView this$0) {
        i.f(this$0, "this$0");
        if (this$0.getTextContent().getHeight() < this$0.getTextContent().getMaxHeight()) {
            this$0.getTextContent().setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.emptyview.a
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean disabledTextContentScroll$lambda$2$lambda$1;
                    disabledTextContentScroll$lambda$2$lambda$1 = COUIEmptyStateView.disabledTextContentScroll$lambda$2$lambda$1(view, motionEvent);
                    return disabledTextContentScroll$lambda$2$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean disabledTextContentScroll$lambda$2$lambda$1(View view, MotionEvent motionEvent) {
        return true;
    }

    private final TextView getActionBt() {
        Object value = this.actionBt$delegate.getValue();
        i.e(value, "<get-actionBt>(...)");
        return (TextView) value;
    }

    private final Size getAnimTargetSize(int i10) {
        float f10;
        if (i10 != 1) {
            if (i10 != 2) {
                f10 = 1.0f;
            } else {
                f10 = 0.6f;
            }
        } else {
            f10 = 0.0f;
        }
        return new Size((int) (this.animWidth * f10), (int) (this.animHeight * f10));
    }

    private final EmptyStateAnimView getAnimView() {
        Object value = this.animView$delegate.getValue();
        i.e(value, "<get-animView>(...)");
        return (EmptyStateAnimView) value;
    }

    private final int getDimenPx(View view, int i10) {
        return view.getContext().getResources().getDimensionPixelSize(i10);
    }

    private final LinearLayout getEmptyStateGroup() {
        return (LinearLayout) this.emptyStateGroup$delegate.getValue();
    }

    private final int getEmptyStateGroupSizeType(int i10, int i11) {
        int i12 = this.emptyViewSizeType;
        if (i12 == 0) {
            if (i11 < this.heightThresholdSmall) {
                return 1;
            }
            if (i10 >= this.widthThresholdMedium && i11 >= this.heightThresholdMedium) {
                return 3;
            }
            return 2;
        }
        return i12;
    }

    public static /* synthetic */ int getEmptyStateGroupSizeType$default(COUIEmptyStateView cOUIEmptyStateView, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = cOUIEmptyStateView.getMeasuredWidth();
        }
        if ((i12 & 2) != 0) {
            i11 = cOUIEmptyStateView.getMeasuredHeight();
        }
        return cOUIEmptyStateView.getEmptyStateGroupSizeType(i10, i11);
    }

    private final float getMarginTopHeightRatio(int i10) {
        if (i10 == 1) {
            return 0.5f;
        }
        return HEIGHT_RATIO_NORMAL;
    }

    private final TextView getSubTitle() {
        Object value = this.subTitle$delegate.getValue();
        i.e(value, "<get-subTitle>(...)");
        return (TextView) value;
    }

    private final COUIMaxHeightScrollView getTextContent() {
        Object value = this.textContent$delegate.getValue();
        i.e(value, "<get-textContent>(...)");
        return (COUIMaxHeightScrollView) value;
    }

    private final TextView getTitle() {
        Object value = this.title$delegate.getValue();
        i.e(value, "<get-title>(...)");
        return (TextView) value;
    }

    private final void updateAnimRes(EffectiveAnimationView effectiveAnimationView, int i10) {
        if (i10 > 0) {
            effectiveAnimationView.setAnimation(i10);
        }
    }

    private final void updateContentOrVisibility(TextView textView, String str) {
        boolean z10;
        textView.setText(str);
        int i10 = 0;
        if (str != null && str.length() != 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!(true ^ z10)) {
            i10 = 8;
        }
        textView.setVisibility(i10);
    }

    private final void updateImageRes(EffectiveAnimationView effectiveAnimationView, int i10) {
        if (i10 != 0) {
            effectiveAnimationView.setImageResource(i10);
        }
    }

    public final void cancelAnimation() {
        getAnimView().cancelAnimation();
    }

    public final String getActionText() {
        return this.actionText;
    }

    public final String getAnimFileName() {
        return this.animFileName;
    }

    public final int getAnimHeight() {
        return this.animHeight;
    }

    public final int getAnimWidth() {
        return this.animWidth;
    }

    public final boolean getAutoPlay() {
        return this.autoPlay;
    }

    public final int getEmptyViewSizeType() {
        return this.emptyViewSizeType;
    }

    public final int getImageRes() {
        return this.imageRes;
    }

    public final int getRawAnimRes() {
        return this.rawAnimRes;
    }

    public final String getSubtitleText() {
        return this.subtitleText;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && getAnimView().getVisibility() != 4) {
            getAnimView().playAnimation();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int paddingTop = getPaddingTop() + calculateTopMargin(getEmptyStateGroup().getMeasuredHeight());
        int measuredHeight = getEmptyStateGroup().getMeasuredHeight() + paddingTop;
        int measuredWidth = (getMeasuredWidth() - getEmptyStateGroup().getMeasuredWidth()) / 2;
        getEmptyStateGroup().layout(measuredWidth, paddingTop, getEmptyStateGroup().getMeasuredWidth() + measuredWidth, measuredHeight);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        getAnimView().setAnimSize(getAnimTargetSize(getEmptyStateGroupSizeType(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11))));
        measureChild(getEmptyStateGroup(), i10, i11);
        if (mode != 1073741824) {
            i11 = View.MeasureSpec.makeMeasureSpec(getEmptyStateGroup().getMeasuredHeight(), mode);
        }
        setMeasuredDimension(i10, i11);
    }

    public final void playAnimation() {
        getAnimView().playAnimation();
    }

    public final void setActionText(String value) {
        i.f(value, "value");
        updateContentOrVisibility(getActionBt(), value);
        this.actionText = value;
    }

    public final void setAnimFileName(String value) {
        i.f(value, "value");
        if (!i.b(value, this.animFileName)) {
            updateAnimRes(getAnimView(), value);
            this.animFileName = value;
        }
    }

    public final void setAnimHeight(int i10) {
        this.animHeight = i10;
    }

    public final void setAnimRes(int i10) {
        updateAnimRes(getAnimView(), i10);
    }

    public final void setAnimWidth(int i10) {
        this.animWidth = i10;
    }

    public final void setAutoPlay(boolean z10) {
        this.autoPlay = z10;
    }

    public final void setEmptyViewSizeType(int i10) {
        if (i10 != this.emptyViewSizeType) {
            getAnimView().requestLayout();
            this.emptyViewSizeType = i10;
        }
    }

    public final void setImageRes(int i10) {
        if (i10 != this.imageRes) {
            updateImageRes(getAnimView(), i10);
            this.imageRes = i10;
        }
    }

    public final void setOnButtonClickListener(View.OnClickListener onClickListener) {
        i.f(onClickListener, "onClickListener");
        getActionBt().setOnClickListener(onClickListener);
    }

    public final void setRawAnimRes(int i10) {
        if (i10 != this.rawAnimRes) {
            updateAnimRes(getAnimView(), i10);
            this.rawAnimRes = i10;
        }
    }

    public final void setSubtitle(int i10) {
        boolean z10;
        TextView subTitle = getSubTitle();
        subTitle.setText(i10);
        CharSequence text = subTitle.getText();
        int i11 = 0;
        if (text != null && text.length() != 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!(!z10)) {
            i11 = 8;
        }
        subTitle.setVisibility(i11);
    }

    public final void setSubtitleText(String value) {
        i.f(value, "value");
        updateContentOrVisibility(getSubTitle(), value);
        this.subtitleText = value;
    }

    public final void setTitleText(String value) {
        i.f(value, "value");
        updateContentOrVisibility(getTitle(), value);
        this.titleText = value;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIEmptyStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        i.f(context, "context");
    }

    private final void updateAnimRes(EffectiveAnimationView effectiveAnimationView, String str) {
        if (str.length() > 0) {
            effectiveAnimationView.setAnimation(str);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIEmptyStateView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        i.f(context, "context");
    }

    public final void setActionText(int i10) {
        getActionBt().setText(i10);
    }

    public final void setTitleText(int i10) {
        TextView title = getTitle();
        title.setText(i10);
        CharSequence text = title.getText();
        title.setVisibility((text == null || text.length() == 0) ^ true ? 0 : 8);
    }

    public /* synthetic */ COUIEmptyStateView(Context context, AttributeSet attributeSet, int i10, int i11, int i12, f fVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIEmptyStateView(final Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        d b10;
        d b11;
        d b12;
        d b13;
        d b14;
        d b15;
        i.f(context, "context");
        String str = "";
        this.actionText = "";
        this.titleText = "";
        this.subtitleText = "";
        this.rawAnimRes = -1;
        this.animFileName = "";
        this.imageRes = -1;
        int dimenPx = getDimenPx(this, Z8.c.f6054y);
        this.defaultAnimHeight = dimenPx;
        int dimenPx2 = getDimenPx(this, Z8.c.f6056z);
        this.defaultAnimWidth = dimenPx2;
        this.widthThresholdMedium = getDimenPx(this, Z8.c.f6049v0);
        this.heightThresholdMedium = getDimenPx(this, Z8.c.f5982C);
        this.heightThresholdSmall = getDimenPx(this, Z8.c.f5983D);
        b10 = kotlin.a.b(new InterfaceC1637a<LinearLayout>() { // from class: com.coui.appcompat.emptyview.COUIEmptyStateView$emptyStateGroup$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final LinearLayout invoke() {
                View inflate = View.inflate(context, Z8.f.f6174j, null);
                i.d(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
                return (LinearLayout) inflate;
            }
        });
        this.emptyStateGroup$delegate = b10;
        b11 = kotlin.a.b(new InterfaceC1637a<TextView>() { // from class: com.coui.appcompat.emptyview.COUIEmptyStateView$title$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final TextView invoke() {
                return (TextView) COUIEmptyStateView.this.findViewById(e.f6098R);
            }
        });
        this.title$delegate = b11;
        b12 = kotlin.a.b(new InterfaceC1637a<TextView>() { // from class: com.coui.appcompat.emptyview.COUIEmptyStateView$subTitle$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final TextView invoke() {
                return (TextView) COUIEmptyStateView.this.findViewById(e.f6097Q);
            }
        });
        this.subTitle$delegate = b12;
        b13 = kotlin.a.b(new InterfaceC1637a<TextView>() { // from class: com.coui.appcompat.emptyview.COUIEmptyStateView$actionBt$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final TextView invoke() {
                return (TextView) COUIEmptyStateView.this.findViewById(e.f6094N);
            }
        });
        this.actionBt$delegate = b13;
        b14 = kotlin.a.b(new InterfaceC1637a<EmptyStateAnimView>() { // from class: com.coui.appcompat.emptyview.COUIEmptyStateView$animView$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final EmptyStateAnimView invoke() {
                return (EmptyStateAnimView) COUIEmptyStateView.this.findViewById(e.f6095O);
            }
        });
        this.animView$delegate = b14;
        b15 = kotlin.a.b(new InterfaceC1637a<COUIMaxHeightScrollView>() { // from class: com.coui.appcompat.emptyview.COUIEmptyStateView$textContent$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final COUIMaxHeightScrollView invoke() {
                return (COUIMaxHeightScrollView) COUIEmptyStateView.this.findViewById(e.f6096P);
            }
        });
        this.textContent$delegate = b15;
        setOverScrollMode(0);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        addView(getEmptyStateGroup(), new LinearLayout.LayoutParams(-1, -2));
        COUITextViewCompatUtil.setPressRippleDrawable(getActionBt());
        disabledTextContentScroll();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Z8.i.f6243t, i10, i11);
        this.autoPlay = obtainStyledAttributes.getBoolean(Z8.i.f6248y, false);
        String string = obtainStyledAttributes.getString(Z8.i.f6245v);
        if (string == null) {
            string = "";
        } else {
            i.e(string, "getString(R.styleable.CO…tionText) ?: EMPTY_STRING");
        }
        setActionText(string);
        String string2 = obtainStyledAttributes.getString(Z8.i.f6198D);
        if (string2 == null) {
            string2 = "";
        } else {
            i.e(string2, "getString(R.styleable.CO…itleText) ?: EMPTY_STRING");
        }
        setTitleText(string2);
        String string3 = obtainStyledAttributes.getString(Z8.i.f6197C);
        if (string3 == null) {
            string3 = "";
        } else {
            i.e(string3, "getString(R.styleable.CO…itleText) ?: EMPTY_STRING");
        }
        setSubtitleText(string3);
        setRawAnimRes(obtainStyledAttributes.getResourceId(Z8.i.f6195A, -1));
        String string4 = obtainStyledAttributes.getString(Z8.i.f6249z);
        if (string4 != null) {
            i.e(string4, "getString(R.styleable.CO…fileName) ?: EMPTY_STRING");
            str = string4;
        }
        setAnimFileName(str);
        setImageRes(obtainStyledAttributes.getResourceId(Z8.i.f6244u, -1));
        this.animHeight = obtainStyledAttributes.getDimensionPixelSize(Z8.i.f6246w, dimenPx);
        this.animWidth = obtainStyledAttributes.getDimensionPixelSize(Z8.i.f6247x, dimenPx2);
        setEmptyViewSizeType(obtainStyledAttributes.getInteger(Z8.i.f6196B, 0));
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
    }
}

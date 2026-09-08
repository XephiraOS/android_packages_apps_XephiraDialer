package com.coui.appcompat.edittext;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.EditText;
import androidx.core.view.C0455j;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public class COUICutoutDrawable extends GradientDrawable {
    private final RectF mCutoutBounds;
    private final Paint mCutoutPaint = new Paint(1);
    private int mSavedLayer;

    /* loaded from: classes.dex */
    public static final class COUICollapseTextHelper {
        private static final boolean DEBUG_DRAW = false;
        public static final int DEFAULT_HINT_LINES = 1;
        public static final int MAX_HINT_LINES = 3;
        private static final float POINT_001 = 0.001f;
        private static final float SCALE_MY = 1.3f;
        private static final String TAG = "COUICollapseTextHelper";
        private boolean mBoundsChanged;
        private final Rect mCollapsedBounds;
        private float mCollapsedDrawX;
        private float mCollapsedDrawY;
        private ColorStateList mCollapsedTextColor;
        private final RectF mCurrentBounds;
        private float mCurrentDrawX;
        private float mCurrentDrawY;
        private float mCurrentTextSize;
        private boolean mDrawTitle;
        private final Rect mExpandedBounds;
        private float mExpandedDrawX;
        private float mExpandedDrawY;
        private float mExpandedFraction;
        private ColorStateList mExpandedTextColor;
        private Bitmap mExpandedTitleTexture;
        private float mHintPaddingStart;
        private boolean mIsRtl;
        private Interpolator mPositionInterpolator;
        private float mScale;
        private int[] mState;
        private CharSequence mText;
        private final TextPaint mTextPaint;
        private Interpolator mTextSizeInterpolator;
        private CharSequence mTextToDraw;
        private float mTextureAscent;
        private float mTextureDescent;
        private Paint mTexturePaint;
        private final TextPaint mTmpPaint;
        private boolean mUseTexture;
        private final View mView;
        private static final boolean USE_SCALING_TEXTURE = false;
        private static final Paint DEBUG_DRAW_PAINT = null;
        private int mExpandedTextGravity = 16;
        private int mCollapsedTextGravity = 16;
        private float mExpandedTextSize = 30.0f;
        private float mCollapsedTextSize = 30.0f;
        private ArrayList<CharSequence> mTextToDrawList = new ArrayList<>();
        private int mHintLines = 1;

        public COUICollapseTextHelper(View view) {
            this.mView = view;
            TextPaint textPaint = new TextPaint(129);
            this.mTextPaint = textPaint;
            this.mTmpPaint = new TextPaint(textPaint);
            this.mCollapsedBounds = new Rect();
            this.mExpandedBounds = new Rect();
            this.mCurrentBounds = new RectF();
        }

        private static int blendColors(int i10, int i11, float f10) {
            float f11 = 1.0f - f10;
            return Color.argb((int) ((Color.alpha(i10) * f11) + (Color.alpha(i11) * f10)), (int) ((Color.red(i10) * f11) + (Color.red(i11) * f10)), (int) ((Color.green(i10) * f11) + (Color.green(i11) * f10)), (int) ((Color.blue(i10) * f11) + (Color.blue(i11) * f10)));
        }

        private void calculateBaseOffsets() {
            float f10;
            float f11 = this.mCurrentTextSize;
            calculateUsingTextSize(this.mCollapsedTextSize);
            CharSequence charSequence = this.mTextToDraw;
            float f12 = 0.0f;
            if (charSequence != null) {
                f10 = this.mTextPaint.measureText(charSequence, 0, charSequence.length());
            } else {
                f10 = 0.0f;
            }
            int b10 = C0455j.b(this.mCollapsedTextGravity, this.mIsRtl ? 1 : 0);
            if (this.mHintLines > 1) {
                if (Locale.getDefault().getLanguage().equals("my")) {
                    this.mCollapsedDrawY = this.mCollapsedBounds.top - (this.mTextPaint.ascent() * SCALE_MY);
                } else {
                    this.mCollapsedDrawY = this.mCollapsedBounds.top - this.mTextPaint.ascent();
                }
            } else {
                int i10 = b10 & 112;
                if (i10 != 48) {
                    if (i10 != 80) {
                        this.mCollapsedDrawY = this.mCollapsedBounds.centerY() + (((this.mTextPaint.descent() - this.mTextPaint.ascent()) / 2.0f) - this.mTextPaint.descent());
                    } else {
                        this.mCollapsedDrawY = this.mCollapsedBounds.bottom;
                    }
                } else if (Locale.getDefault().getLanguage().equals("my")) {
                    this.mCollapsedDrawY = this.mCollapsedBounds.top - (this.mTextPaint.ascent() * SCALE_MY);
                } else {
                    this.mCollapsedDrawY = this.mCollapsedBounds.top - this.mTextPaint.ascent();
                }
            }
            int i11 = b10 & 8388615;
            if (i11 != 1) {
                if (i11 != 5) {
                    this.mCollapsedDrawX = this.mCollapsedBounds.left;
                } else {
                    this.mCollapsedDrawX = this.mCollapsedBounds.right - f10;
                }
            } else {
                this.mCollapsedDrawX = this.mCollapsedBounds.centerX() - (f10 / 2.0f);
            }
            calculateUsingTextSize(this.mExpandedTextSize);
            CharSequence charSequence2 = this.mTextToDraw;
            if (charSequence2 != null) {
                f12 = this.mTextPaint.measureText(charSequence2, 0, charSequence2.length());
            }
            int b11 = C0455j.b(this.mExpandedTextGravity, this.mIsRtl ? 1 : 0);
            if (this.mHintLines > 1) {
                this.mExpandedDrawY = this.mExpandedBounds.top - this.mTextPaint.ascent();
            } else {
                int i12 = b11 & 112;
                if (i12 != 48) {
                    if (i12 != 80) {
                        this.mExpandedDrawY = this.mExpandedBounds.centerY() + (((this.mTextPaint.getFontMetrics().bottom - this.mTextPaint.getFontMetrics().top) / 2.0f) - this.mTextPaint.getFontMetrics().bottom);
                    } else {
                        this.mExpandedDrawY = this.mExpandedBounds.bottom;
                    }
                } else {
                    this.mExpandedDrawY = this.mExpandedBounds.top - this.mTextPaint.ascent();
                }
            }
            int i13 = b11 & 8388615;
            if (i13 != 1) {
                if (i13 != 5) {
                    this.mExpandedDrawX = this.mExpandedBounds.left;
                } else {
                    this.mExpandedDrawX = this.mExpandedBounds.right - f12;
                }
            } else {
                this.mExpandedDrawX = this.mExpandedBounds.centerX() - (f12 / 2.0f);
            }
            clearTexture();
            setInterpolatedTextSize(f11);
        }

        private void calculateCurrentOffsets() {
            calculateOffsets(this.mExpandedFraction);
        }

        private boolean calculateIsRtl(CharSequence charSequence) {
            return isRtlMode();
        }

        private void calculateOffsets(float f10) {
            interpolateBounds(f10);
            this.mCurrentDrawX = lerp(this.mExpandedDrawX, this.mCollapsedDrawX, f10, this.mPositionInterpolator);
            this.mCurrentDrawY = lerp(this.mExpandedDrawY, this.mCollapsedDrawY, f10, this.mPositionInterpolator);
            setInterpolatedTextSize(lerp(this.mExpandedTextSize, this.mCollapsedTextSize, f10, this.mTextSizeInterpolator));
            if (this.mCollapsedTextColor != this.mExpandedTextColor) {
                this.mTextPaint.setColor(blendColors(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), f10));
            } else {
                this.mTextPaint.setColor(getCurrentCollapsedTextColor());
            }
            this.mView.postInvalidate();
        }

        private void calculateUsingTextSize(float f10) {
            float f11;
            boolean z10;
            boolean z11;
            if (this.mText == null) {
                return;
            }
            float width = this.mCollapsedBounds.width();
            float width2 = this.mExpandedBounds.width();
            if (isClose(f10, this.mCollapsedTextSize)) {
                f11 = this.mCollapsedTextSize;
                this.mScale = 1.0f;
            } else {
                float f12 = this.mExpandedTextSize;
                if (isClose(f10, f12)) {
                    this.mScale = 1.0f;
                } else {
                    this.mScale = f10 / this.mExpandedTextSize;
                }
                float f13 = this.mCollapsedTextSize / this.mExpandedTextSize;
                if (width2 * f13 > width) {
                    width = Math.min(width / f13, width2);
                } else {
                    width = width2;
                }
                f11 = f12;
            }
            if (width > 0.0f) {
                if (this.mCurrentTextSize == f11 && !this.mBoundsChanged) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                this.mCurrentTextSize = f11;
                this.mBoundsChanged = false;
            } else {
                z10 = false;
            }
            if (this.mTextToDraw == null || z10) {
                this.mTextPaint.setTextSize(this.mCurrentTextSize);
                TextPaint textPaint = this.mTextPaint;
                if (this.mScale != 1.0f) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                textPaint.setLinearText(z11);
                CharSequence charSequence = this.mText;
                TextPaint textPaint2 = this.mTextPaint;
                float f14 = width - this.mHintPaddingStart;
                TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
                CharSequence ellipsize = TextUtils.ellipsize(charSequence, textPaint2, f14, truncateAt);
                if (!TextUtils.equals(ellipsize, this.mTextToDraw)) {
                    this.mTextToDraw = ellipsize;
                }
                if (this.mHintLines > 1 && !TextUtils.equals(ellipsize, this.mText) && this.mText.length() > ellipsize.length()) {
                    this.mTextToDrawList.clear();
                    int length = ellipsize.length();
                    if (TextUtils.equals(ellipsize, TextUtils.ellipsize(this.mText.subSequence(0, length), this.mTextPaint, width - this.mHintPaddingStart, truncateAt))) {
                        length--;
                    }
                    this.mTextToDrawList.add(this.mText.subSequence(0, length));
                    CharSequence charSequence2 = this.mText;
                    setTextToDrawList(charSequence2.subSequence(length, charSequence2.length()), width - this.mHintPaddingStart);
                }
            }
            this.mIsRtl = isRtlMode();
        }

        private void clearTexture() {
            Bitmap bitmap = this.mExpandedTitleTexture;
            if (bitmap != null) {
                bitmap.recycle();
                this.mExpandedTitleTexture = null;
            }
        }

        private float constrain(float f10, float f11, float f12) {
            return f10 < f11 ? f11 : f10 > f12 ? f12 : f10;
        }

        private void ensureExpandedTexture() {
            if (this.mExpandedTitleTexture == null && !this.mExpandedBounds.isEmpty() && !TextUtils.isEmpty(this.mTextToDraw)) {
                calculateOffsets(0.0f);
                this.mTextureAscent = this.mTextPaint.ascent();
                this.mTextureDescent = this.mTextPaint.descent();
                TextPaint textPaint = this.mTextPaint;
                CharSequence charSequence = this.mTextToDraw;
                int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
                int round2 = Math.round(this.mTextureDescent - this.mTextureAscent);
                if (round > 0 && round2 > 0) {
                    this.mExpandedTitleTexture = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(this.mExpandedTitleTexture);
                    CharSequence charSequence2 = this.mTextToDraw;
                    canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, round2 - this.mTextPaint.descent(), this.mTextPaint);
                    if (this.mTexturePaint == null) {
                        this.mTexturePaint = new Paint(3);
                    }
                }
            }
        }

        private int getCurrentExpandedTextColor() {
            int[] iArr = this.mState;
            if (iArr != null) {
                return this.mExpandedTextColor.getColorForState(iArr, 0);
            }
            return this.mExpandedTextColor.getDefaultColor();
        }

        private void getTextPaintCollapsed(TextPaint textPaint) {
            textPaint.setTextSize(this.mCollapsedTextSize);
        }

        private void interpolateBounds(float f10) {
            this.mCurrentBounds.left = lerp(this.mExpandedBounds.left, this.mCollapsedBounds.left, f10, this.mPositionInterpolator);
            this.mCurrentBounds.top = lerp(this.mExpandedDrawY, this.mCollapsedDrawY, f10, this.mPositionInterpolator);
            this.mCurrentBounds.right = lerp(this.mExpandedBounds.right, this.mCollapsedBounds.right, f10, this.mPositionInterpolator);
            this.mCurrentBounds.bottom = lerp(this.mExpandedBounds.bottom, this.mCollapsedBounds.bottom, f10, this.mPositionInterpolator);
        }

        private static boolean isClose(float f10, float f11) {
            if (Math.abs(f10 - f11) < POINT_001) {
                return true;
            }
            return false;
        }

        private boolean isRtlMode() {
            if (this.mView.getLayoutDirection() == 1) {
                return true;
            }
            return false;
        }

        private static float lerp(float f10, float f11, float f12) {
            return f10 + (f12 * (f11 - f10));
        }

        private void onBoundsChanged() {
            boolean z10;
            if (this.mCollapsedBounds.width() > 0 && this.mCollapsedBounds.height() > 0 && this.mExpandedBounds.width() > 0 && this.mExpandedBounds.height() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.mDrawTitle = z10;
        }

        private static boolean rectEquals(Rect rect, int i10, int i11, int i12, int i13) {
            if (rect.left == i10 && rect.top == i11 && rect.right == i12 && rect.bottom == i13) {
                return true;
            }
            return false;
        }

        private void setInterpolatedTextSize(float f10) {
            boolean z10;
            calculateUsingTextSize(f10);
            if (USE_SCALING_TEXTURE && this.mScale != 1.0f) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.mUseTexture = z10;
            if (z10) {
                ensureExpandedTexture();
            }
            this.mView.postInvalidate();
        }

        private void setTextToDrawList(CharSequence charSequence, float f10) {
            for (int i10 = 1; i10 < this.mHintLines; i10++) {
                TextPaint textPaint = this.mTextPaint;
                TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
                CharSequence ellipsize = TextUtils.ellipsize(charSequence, textPaint, f10, truncateAt);
                if (i10 != this.mHintLines - 1 && !TextUtils.equals(ellipsize, charSequence)) {
                    int length = ellipsize.length();
                    if (TextUtils.equals(ellipsize, TextUtils.ellipsize(charSequence.subSequence(0, length), this.mTextPaint, f10, truncateAt))) {
                        length--;
                    }
                    this.mTextToDrawList.add(charSequence.subSequence(0, length));
                    charSequence = charSequence.subSequence(length, charSequence.length());
                } else {
                    this.mTextToDrawList.add(ellipsize);
                    return;
                }
            }
        }

        public float calculateCollapsedTextWidth() {
            if (this.mText == null) {
                return 0.0f;
            }
            getTextPaintCollapsed(this.mTmpPaint);
            TextPaint textPaint = this.mTmpPaint;
            CharSequence charSequence = this.mText;
            return textPaint.measureText(charSequence, 0, charSequence.length());
        }

        public void draw(Canvas canvas) {
            boolean z10;
            float ascent;
            int i10;
            int save = canvas.save();
            if (this.mTextToDraw != null && this.mDrawTitle) {
                float f10 = this.mCurrentDrawX;
                float f11 = this.mCurrentDrawY;
                if (this.mUseTexture && this.mExpandedTitleTexture != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    ascent = this.mTextureAscent * this.mScale;
                } else {
                    ascent = this.mTextPaint.ascent() * this.mScale;
                    this.mTextPaint.descent();
                }
                if (z10) {
                    f11 += ascent;
                }
                float f12 = f11;
                float f13 = this.mScale;
                if (f13 != 1.0f) {
                    canvas.scale(f13, f13, f10, f12);
                }
                if (z10) {
                    canvas.drawBitmap(this.mExpandedTitleTexture, f10, f12, this.mTexturePaint);
                } else if (this.mHintLines != 1 && this.mTextToDrawList.size() > 1) {
                    View view = this.mView;
                    if (view instanceof EditText) {
                        i10 = ((EditText) view).getLineHeight();
                    } else {
                        i10 = 0;
                    }
                    for (int i11 = 0; i11 < this.mTextToDrawList.size(); i11++) {
                        int i12 = i10 * i11;
                        CharSequence charSequence = this.mTextToDrawList.get(i11);
                        if (isRtlMode()) {
                            canvas.drawText(charSequence, 0, charSequence.length(), Math.max(0.0f, f10 - this.mHintPaddingStart), f12 + i12, this.mTextPaint);
                        } else {
                            canvas.drawText(charSequence, 0, charSequence.length(), f10 + this.mHintPaddingStart, f12 + i12, this.mTextPaint);
                        }
                    }
                } else if (isRtlMode()) {
                    CharSequence charSequence2 = this.mTextToDraw;
                    canvas.drawText(charSequence2, 0, charSequence2.length(), Math.max(0.0f, f10 - this.mHintPaddingStart), f12, this.mTextPaint);
                } else {
                    CharSequence charSequence3 = this.mTextToDraw;
                    canvas.drawText(charSequence3, 0, charSequence3.length(), f10 + this.mHintPaddingStart, f12, this.mTextPaint);
                }
            } else {
                canvas.drawText(" ", 0.0f, 0.0f, this.mTextPaint);
            }
            canvas.restoreToCount(save);
        }

        public Rect getCollapsedBounds() {
            return this.mCollapsedBounds;
        }

        public void getCollapsedTextActualBounds(RectF rectF) {
            float calculateCollapsedTextWidth;
            float f10;
            boolean calculateIsRtl = calculateIsRtl(this.mText);
            if (!calculateIsRtl) {
                calculateCollapsedTextWidth = this.mCollapsedBounds.left;
            } else {
                calculateCollapsedTextWidth = this.mCollapsedBounds.right - calculateCollapsedTextWidth();
            }
            rectF.left = calculateCollapsedTextWidth;
            Rect rect = this.mCollapsedBounds;
            rectF.top = rect.top;
            if (!calculateIsRtl) {
                f10 = calculateCollapsedTextWidth + calculateCollapsedTextWidth();
            } else {
                f10 = rect.right;
            }
            rectF.right = f10;
            rectF.bottom = this.mCollapsedBounds.top + getCollapsedTextHeight();
        }

        public ColorStateList getCollapsedTextColor() {
            return this.mCollapsedTextColor;
        }

        public int getCollapsedTextGravity() {
            return this.mCollapsedTextGravity;
        }

        public float getCollapsedTextHeight() {
            getTextPaintCollapsed(this.mTmpPaint);
            if (Locale.getDefault().getLanguage().equals("my")) {
                return (-this.mTmpPaint.ascent()) * SCALE_MY;
            }
            return -this.mTmpPaint.ascent();
        }

        public float getCollapsedTextSize() {
            return this.mCollapsedTextSize;
        }

        public int getCurrentCollapsedTextColor() {
            ColorStateList colorStateList = this.mCollapsedTextColor;
            if (colorStateList == null) {
                return 0;
            }
            int[] iArr = this.mState;
            if (iArr != null) {
                return colorStateList.getColorForState(iArr, 0);
            }
            return colorStateList.getDefaultColor();
        }

        public Rect getExpandedBounds() {
            return this.mExpandedBounds;
        }

        public float getExpandedFraction() {
            return this.mExpandedFraction;
        }

        public ColorStateList getExpandedTextColor() {
            return this.mExpandedTextColor;
        }

        public int getExpandedTextGravity() {
            return this.mExpandedTextGravity;
        }

        public float getExpandedTextSize() {
            return this.mExpandedTextSize;
        }

        public float getExpansionFraction() {
            return this.mExpandedFraction;
        }

        public float getHintHeight() {
            getTextPaintCollapsed(this.mTmpPaint);
            float descent = this.mTmpPaint.descent() - this.mTmpPaint.ascent();
            if (Locale.getDefault().getLanguage().equals("my")) {
                return descent * SCALE_MY;
            }
            return descent;
        }

        public CharSequence getText() {
            return this.mText;
        }

        public final boolean isStateful() {
            ColorStateList colorStateList;
            ColorStateList colorStateList2 = this.mCollapsedTextColor;
            if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.mExpandedTextColor) != null && colorStateList.isStateful())) {
                return true;
            }
            return false;
        }

        public void recalculate() {
            if (this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
                calculateBaseOffsets();
                calculateCurrentOffsets();
            }
        }

        public void setCollapsedBounds(int i10, int i11, int i12, int i13) {
            if (!rectEquals(this.mCollapsedBounds, i10, i11, i12, i13)) {
                this.mCollapsedBounds.set(i10, i11, i12, i13);
                this.mBoundsChanged = true;
                onBoundsChanged();
                Log.d(TAG, "setCollapsedBounds: " + this.mCollapsedBounds);
            }
        }

        public void setCollapsedTextAppearance(int i10, ColorStateList colorStateList) {
            this.mCollapsedTextColor = colorStateList;
            this.mCollapsedTextSize = i10;
            recalculate();
        }

        public void setCollapsedTextColor(ColorStateList colorStateList) {
            if (this.mCollapsedTextColor != colorStateList) {
                this.mCollapsedTextColor = colorStateList;
                recalculate();
            }
        }

        public void setCollapsedTextGravity(int i10) {
            if (this.mCollapsedTextGravity != i10) {
                this.mCollapsedTextGravity = i10;
                recalculate();
            }
        }

        public void setCollapsedTextSize(float f10) {
            if (this.mCollapsedTextSize != f10) {
                this.mCollapsedTextSize = f10;
                recalculate();
            }
        }

        public void setExpandedBounds(int i10, int i11, int i12, int i13) {
            if (!rectEquals(this.mExpandedBounds, i10, i11, i12, i13)) {
                this.mExpandedBounds.set(i10, i11, i12, i13);
                this.mBoundsChanged = true;
                onBoundsChanged();
                Log.d(TAG, "setExpandedBounds: " + this.mExpandedBounds);
            }
        }

        public void setExpandedTextColor(ColorStateList colorStateList) {
            if (this.mExpandedTextColor != colorStateList) {
                this.mExpandedTextColor = colorStateList;
                recalculate();
            }
        }

        public void setExpandedTextGravity(int i10) {
            if (this.mExpandedTextGravity != i10) {
                this.mExpandedTextGravity = i10;
                recalculate();
            }
        }

        public void setExpandedTextSize(float f10) {
            if (this.mExpandedTextSize != f10) {
                this.mExpandedTextSize = f10;
                recalculate();
            }
        }

        public void setExpansionFraction(float f10) {
            float constrain = constrain(f10, 0.0f, 1.0f);
            if (constrain != this.mExpandedFraction) {
                this.mExpandedFraction = constrain;
                calculateCurrentOffsets();
            }
        }

        public void setHintLines(int i10) {
            this.mHintLines = Math.min(3, Math.max(1, i10));
        }

        public void setHintPaddingStart(float f10) {
            if (f10 > 0.0f) {
                this.mHintPaddingStart = f10;
            }
        }

        public void setPositionInterpolator(Interpolator interpolator) {
            this.mPositionInterpolator = interpolator;
            recalculate();
        }

        public final boolean setState(int[] iArr) {
            this.mState = iArr;
            if (isStateful()) {
                recalculate();
                return true;
            }
            return false;
        }

        public void setText(CharSequence charSequence) {
            if (charSequence == null || !charSequence.equals(this.mText)) {
                this.mText = charSequence;
                this.mTextToDraw = null;
                this.mTextToDrawList.clear();
                clearTexture();
                recalculate();
            }
        }

        public void setTextSizeInterpolator(Interpolator interpolator) {
            this.mTextSizeInterpolator = interpolator;
            recalculate();
        }

        public void setTypefaces(Typeface typeface) {
            COUIChangeTextUtil.adaptBoldAndMediumFont((Paint) this.mTextPaint, true);
            COUIChangeTextUtil.adaptBoldAndMediumFont((Paint) this.mTmpPaint, true);
            recalculate();
        }

        private int constrain(int i10, int i11, int i12) {
            return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
        }

        private static float lerp(float f10, float f11, float f12, Interpolator interpolator) {
            if (interpolator != null) {
                f12 = interpolator.getInterpolation(f12);
            }
            return lerp(f10, f11, f12);
        }
    }

    public COUICutoutDrawable() {
        setPaintStyles();
        this.mCutoutBounds = new RectF();
    }

    private void postDraw(Canvas canvas) {
        if (!useHardwareLayer(getCallback())) {
            canvas.restoreToCount(this.mSavedLayer);
        }
    }

    private void preDraw(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (useHardwareLayer(callback)) {
            ((View) callback).setLayerType(2, null);
        } else {
            saveCanvasLayer(canvas);
        }
    }

    private void saveCanvasLayer(Canvas canvas) {
        this.mSavedLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
    }

    private void setPaintStyles() {
        this.mCutoutPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mCutoutPaint.setColor(-1);
        this.mCutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean useHardwareLayer(Drawable.Callback callback) {
        return callback instanceof View;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        preDraw(canvas);
        super.draw(canvas);
        canvas.drawRect(this.mCutoutBounds, this.mCutoutPaint);
        postDraw(canvas);
    }

    public RectF getCutout() {
        return this.mCutoutBounds;
    }

    public boolean hasCutout() {
        return !this.mCutoutBounds.isEmpty();
    }

    public void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void setCutout(float f10, float f11, float f12, float f13) {
        RectF rectF = this.mCutoutBounds;
        if (f10 == rectF.left && f11 == rectF.top && f12 == rectF.right && f13 == rectF.bottom) {
            return;
        }
        rectF.set(f10, f11, f12, f13);
        invalidateSelf();
    }

    public void setCutout(RectF rectF) {
        setCutout(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}

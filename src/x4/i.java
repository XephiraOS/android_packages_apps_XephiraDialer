package x4;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import e4.C0977c;
import java.util.BitSet;
import l4.C1292a;
import n4.C1370a;
import o4.C1403a;
import w4.C1649a;
import x4.n;
import x4.o;
import x4.p;

/* compiled from: MaterialShapeDrawable.java */
/* loaded from: classes3.dex */
public class i extends Drawable implements r {
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    private static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    private static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    private static final String TAG = "i";
    private static final Paint clearPaint;
    private final BitSet containsIncompatibleShadowOp;
    private final p.g[] cornerShadowOperation;
    private c drawableState;
    private final p.g[] edgeShadowOperation;
    private final Paint fillPaint;
    private final RectF insetRectF;
    private final Matrix matrix;
    private final Path path;
    private final RectF pathBounds;
    private boolean pathDirty;
    private final Path pathInsetByStroke;
    private final o pathProvider;
    private final o.b pathShadowListener;
    private final RectF rectF;
    private int resolvedTintColor;
    private final Region scratchRegion;
    private boolean shadowBitmapDrawingEnable;
    private final C1649a shadowRenderer;
    private final Paint strokePaint;
    private n strokeShapeAppearance;
    private PorterDuffColorFilter strokeTintFilter;
    private PorterDuffColorFilter tintFilter;
    private final Region transparentRegion;

    /* compiled from: MaterialShapeDrawable.java */
    /* loaded from: classes3.dex */
    public class a implements o.b {
        public a() {
        }

        @Override // x4.o.b
        public void a(p pVar, Matrix matrix, int i10) {
            i.this.containsIncompatibleShadowOp.set(i10 + 4, pVar.e());
            i.this.edgeShadowOperation[i10] = pVar.f(matrix);
        }

        @Override // x4.o.b
        public void b(p pVar, Matrix matrix, int i10) {
            i.this.containsIncompatibleShadowOp.set(i10, pVar.e());
            i.this.cornerShadowOperation[i10] = pVar.f(matrix);
        }
    }

    /* compiled from: MaterialShapeDrawable.java */
    /* loaded from: classes3.dex */
    public class b implements n.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f37894a;

        public b(float f10) {
            this.f37894a = f10;
        }

        @Override // x4.n.c
        public d a(d dVar) {
            if (!(dVar instanceof l)) {
                return new x4.b(this.f37894a, dVar);
            }
            return dVar;
        }
    }

    static {
        Paint paint = new Paint(1);
        clearPaint = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public i() {
        this(new n());
    }

    private PorterDuffColorFilter calculatePaintColorTintFilter(Paint paint, boolean z10) {
        if (z10) {
            int color = paint.getColor();
            int compositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded(color);
            this.resolvedTintColor = compositeElevationOverlayIfNeeded;
            if (compositeElevationOverlayIfNeeded != color) {
                return new PorterDuffColorFilter(compositeElevationOverlayIfNeeded, PorterDuff.Mode.SRC_IN);
            }
            return null;
        }
        return null;
    }

    private void calculatePath(RectF rectF, Path path) {
        calculatePathForSize(rectF, path);
        if (this.drawableState.f37905j != 1.0f) {
            this.matrix.reset();
            Matrix matrix = this.matrix;
            float f10 = this.drawableState.f37905j;
            matrix.setScale(f10, f10, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.matrix);
        }
        path.computeBounds(this.pathBounds, true);
    }

    private void calculateStrokePath() {
        n y10 = getShapeAppearanceModel().y(new b(-getStrokeInsetLength()));
        this.strokeShapeAppearance = y10;
        this.pathProvider.d(y10, this.drawableState.f37906k, getBoundsInsetByStroke(), this.pathInsetByStroke);
    }

    private PorterDuffColorFilter calculateTintColorTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z10) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z10) {
            colorForState = compositeElevationOverlayIfNeeded(colorForState);
        }
        this.resolvedTintColor = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter calculateTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z10) {
        if (colorStateList != null && mode != null) {
            return calculateTintColorTintFilter(colorStateList, mode, z10);
        }
        return calculatePaintColorTintFilter(paint, z10);
    }

    public static i createWithElevationOverlay(Context context) {
        return createWithElevationOverlay(context, 0.0f);
    }

    private void drawCompatShadow(Canvas canvas) {
        if (this.containsIncompatibleShadowOp.cardinality() > 0) {
            Log.w(TAG, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.drawableState.f37914s != 0) {
            canvas.drawPath(this.path, this.shadowRenderer.c());
        }
        for (int i10 = 0; i10 < 4; i10++) {
            this.cornerShadowOperation[i10].b(this.shadowRenderer, this.drawableState.f37913r, canvas);
            this.edgeShadowOperation[i10].b(this.shadowRenderer, this.drawableState.f37913r, canvas);
        }
        if (this.shadowBitmapDrawingEnable) {
            int shadowOffsetX = getShadowOffsetX();
            int shadowOffsetY = getShadowOffsetY();
            canvas.translate(-shadowOffsetX, -shadowOffsetY);
            canvas.drawPath(this.path, clearPaint);
            canvas.translate(shadowOffsetX, shadowOffsetY);
        }
    }

    private void drawFillShape(Canvas canvas) {
        drawShape(canvas, this.fillPaint, this.path, this.drawableState.f37896a, getBoundsAsRectF());
    }

    private RectF getBoundsInsetByStroke() {
        this.insetRectF.set(getBoundsAsRectF());
        float strokeInsetLength = getStrokeInsetLength();
        this.insetRectF.inset(strokeInsetLength, strokeInsetLength);
        return this.insetRectF;
    }

    private float getStrokeInsetLength() {
        if (hasStroke()) {
            return this.strokePaint.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean hasCompatShadow() {
        c cVar = this.drawableState;
        int i10 = cVar.f37912q;
        if (i10 != 1 && cVar.f37913r > 0 && (i10 == 2 || requiresCompatShadow())) {
            return true;
        }
        return false;
    }

    private boolean hasFill() {
        Paint.Style style = this.drawableState.f37917v;
        if (style != Paint.Style.FILL_AND_STROKE && style != Paint.Style.FILL) {
            return false;
        }
        return true;
    }

    private boolean hasStroke() {
        Paint.Style style = this.drawableState.f37917v;
        if ((style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.strokePaint.getStrokeWidth() > 0.0f) {
            return true;
        }
        return false;
    }

    private void invalidateSelfIgnoreShape() {
        super.invalidateSelf();
    }

    private void maybeDrawCompatShadow(Canvas canvas) {
        if (!hasCompatShadow()) {
            return;
        }
        canvas.save();
        prepareCanvasForShadow(canvas);
        if (!this.shadowBitmapDrawingEnable) {
            drawCompatShadow(canvas);
            canvas.restore();
            return;
        }
        int width = (int) (this.pathBounds.width() - getBounds().width());
        int height = (int) (this.pathBounds.height() - getBounds().height());
        if (width >= 0 && height >= 0) {
            Bitmap createBitmap = Bitmap.createBitmap(((int) this.pathBounds.width()) + (this.drawableState.f37913r * 2) + width, ((int) this.pathBounds.height()) + (this.drawableState.f37913r * 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f10 = (getBounds().left - this.drawableState.f37913r) - width;
            float f11 = (getBounds().top - this.drawableState.f37913r) - height;
            canvas2.translate(-f10, -f11);
            drawCompatShadow(canvas2);
            canvas.drawBitmap(createBitmap, f10, f11, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
            return;
        }
        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
    }

    private static int modulateAlpha(int i10, int i11) {
        return (i10 * (i11 + (i11 >>> 7))) >>> 8;
    }

    private void prepareCanvasForShadow(Canvas canvas) {
        canvas.translate(getShadowOffsetX(), getShadowOffsetY());
    }

    private boolean updateColorsForState(int[] iArr) {
        boolean z10;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.drawableState.f37899d != null && color2 != (colorForState2 = this.drawableState.f37899d.getColorForState(iArr, (color2 = this.fillPaint.getColor())))) {
            this.fillPaint.setColor(colorForState2);
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.drawableState.f37900e != null && color != (colorForState = this.drawableState.f37900e.getColorForState(iArr, (color = this.strokePaint.getColor())))) {
            this.strokePaint.setColor(colorForState);
            return true;
        }
        return z10;
    }

    private boolean updateTintFilter() {
        PorterDuffColorFilter porterDuffColorFilter = this.tintFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.strokeTintFilter;
        c cVar = this.drawableState;
        this.tintFilter = calculateTintFilter(cVar.f37902g, cVar.f37903h, this.fillPaint, true);
        c cVar2 = this.drawableState;
        this.strokeTintFilter = calculateTintFilter(cVar2.f37901f, cVar2.f37903h, this.strokePaint, false);
        c cVar3 = this.drawableState;
        if (cVar3.f37916u) {
            this.shadowRenderer.d(cVar3.f37902g.getColorForState(getState(), 0));
        }
        if (!I.c.a(porterDuffColorFilter, this.tintFilter) || !I.c.a(porterDuffColorFilter2, this.strokeTintFilter)) {
            return true;
        }
        return false;
    }

    private void updateZ() {
        float z10 = getZ();
        this.drawableState.f37913r = (int) Math.ceil(0.75f * z10);
        this.drawableState.f37914s = (int) Math.ceil(z10 * SHADOW_OFFSET_MULTIPLIER);
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public final void calculatePathForSize(RectF rectF, Path path) {
        o oVar = this.pathProvider;
        c cVar = this.drawableState;
        oVar.e(cVar.f37896a, cVar.f37906k, rectF, this.pathShadowListener, path);
    }

    public int compositeElevationOverlayIfNeeded(int i10) {
        float z10 = getZ() + getParentAbsoluteElevation();
        C1403a c1403a = this.drawableState.f37897b;
        if (c1403a != null) {
            return c1403a.c(i10, z10);
        }
        return i10;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.fillPaint.setColorFilter(this.tintFilter);
        int alpha = this.fillPaint.getAlpha();
        this.fillPaint.setAlpha(modulateAlpha(alpha, this.drawableState.f37908m));
        this.strokePaint.setColorFilter(this.strokeTintFilter);
        this.strokePaint.setStrokeWidth(this.drawableState.f37907l);
        int alpha2 = this.strokePaint.getAlpha();
        this.strokePaint.setAlpha(modulateAlpha(alpha2, this.drawableState.f37908m));
        if (this.pathDirty) {
            calculateStrokePath();
            calculatePath(getBoundsAsRectF(), this.path);
            this.pathDirty = false;
        }
        maybeDrawCompatShadow(canvas);
        if (hasFill()) {
            drawFillShape(canvas);
        }
        if (hasStroke()) {
            drawStrokeShape(canvas);
        }
        this.fillPaint.setAlpha(alpha);
        this.strokePaint.setAlpha(alpha2);
    }

    public void drawShape(Canvas canvas, Paint paint, Path path, RectF rectF) {
        drawShape(canvas, paint, path, this.drawableState.f37896a, rectF);
    }

    public void drawStrokeShape(Canvas canvas) {
        drawShape(canvas, this.strokePaint, this.pathInsetByStroke, this.strokeShapeAppearance, getBoundsInsetByStroke());
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.drawableState.f37908m;
    }

    public float getBottomLeftCornerResolvedSize() {
        return this.drawableState.f37896a.j().a(getBoundsAsRectF());
    }

    public float getBottomRightCornerResolvedSize() {
        return this.drawableState.f37896a.l().a(getBoundsAsRectF());
    }

    public RectF getBoundsAsRectF() {
        this.rectF.set(getBounds());
        return this.rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    public float getElevation() {
        return this.drawableState.f37910o;
    }

    public ColorStateList getFillColor() {
        return this.drawableState.f37899d;
    }

    public float getInterpolation() {
        return this.drawableState.f37906k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.drawableState.f37912q == 2) {
            return;
        }
        if (isRoundRect()) {
            outline.setRoundRect(getBounds(), getTopLeftCornerResolvedSize() * this.drawableState.f37906k);
        } else {
            calculatePath(getBoundsAsRectF(), this.path);
            C1370a.l(outline, this.path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.drawableState.f37904i;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    public Paint.Style getPaintStyle() {
        return this.drawableState.f37917v;
    }

    public float getParentAbsoluteElevation() {
        return this.drawableState.f37909n;
    }

    @Deprecated
    public void getPathForSize(int i10, int i11, Path path) {
        calculatePathForSize(new RectF(0.0f, 0.0f, i10, i11), path);
    }

    public int getResolvedTintColor() {
        return this.resolvedTintColor;
    }

    public float getScale() {
        return this.drawableState.f37905j;
    }

    public int getShadowCompatRotation() {
        return this.drawableState.f37915t;
    }

    public int getShadowCompatibilityMode() {
        return this.drawableState.f37912q;
    }

    @Deprecated
    public int getShadowElevation() {
        return (int) getElevation();
    }

    public int getShadowOffsetX() {
        c cVar = this.drawableState;
        return (int) (cVar.f37914s * Math.sin(Math.toRadians(cVar.f37915t)));
    }

    public int getShadowOffsetY() {
        c cVar = this.drawableState;
        return (int) (cVar.f37914s * Math.cos(Math.toRadians(cVar.f37915t)));
    }

    public int getShadowRadius() {
        return this.drawableState.f37913r;
    }

    public int getShadowVerticalOffset() {
        return this.drawableState.f37914s;
    }

    public n getShapeAppearanceModel() {
        return this.drawableState.f37896a;
    }

    @Deprecated
    public q getShapedViewModel() {
        n shapeAppearanceModel = getShapeAppearanceModel();
        if (shapeAppearanceModel instanceof q) {
            return (q) shapeAppearanceModel;
        }
        return null;
    }

    public ColorStateList getStrokeColor() {
        return this.drawableState.f37900e;
    }

    public ColorStateList getStrokeTintList() {
        return this.drawableState.f37901f;
    }

    public float getStrokeWidth() {
        return this.drawableState.f37907l;
    }

    public ColorStateList getTintList() {
        return this.drawableState.f37902g;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.drawableState.f37896a.r().a(getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        return this.drawableState.f37896a.t().a(getBoundsAsRectF());
    }

    public float getTranslationZ() {
        return this.drawableState.f37911p;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.transparentRegion.set(getBounds());
        calculatePath(getBoundsAsRectF(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public float getZ() {
        return getElevation() + getTranslationZ();
    }

    public void initializeElevationOverlay(Context context) {
        this.drawableState.f37897b = new C1403a(context);
        updateZ();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    public boolean isElevationOverlayEnabled() {
        C1403a c1403a = this.drawableState.f37897b;
        if (c1403a != null && c1403a.e()) {
            return true;
        }
        return false;
    }

    public boolean isElevationOverlayInitialized() {
        if (this.drawableState.f37897b != null) {
            return true;
        }
        return false;
    }

    public boolean isPointInTransparentRegion(int i10, int i11) {
        return getTransparentRegion().contains(i10, i11);
    }

    public boolean isRoundRect() {
        return this.drawableState.f37896a.u(getBoundsAsRectF());
    }

    @Deprecated
    public boolean isShadowEnabled() {
        int i10 = this.drawableState.f37912q;
        if (i10 != 0 && i10 != 2) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        if (!super.isStateful() && (((colorStateList = this.drawableState.f37902g) == null || !colorStateList.isStateful()) && (((colorStateList2 = this.drawableState.f37901f) == null || !colorStateList2.isStateful()) && (((colorStateList3 = this.drawableState.f37900e) == null || !colorStateList3.isStateful()) && ((colorStateList4 = this.drawableState.f37899d) == null || !colorStateList4.isStateful()))))) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.drawableState = new c(this.drawableState);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.pathDirty = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        boolean updateColorsForState = updateColorsForState(iArr);
        boolean updateTintFilter = updateTintFilter();
        if (!updateColorsForState && !updateTintFilter) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            invalidateSelf();
        }
        return z10;
    }

    public boolean requiresCompatShadow() {
        if (!isRoundRect()) {
            this.path.isConvex();
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        c cVar = this.drawableState;
        if (cVar.f37908m != i10) {
            cVar.f37908m = i10;
            invalidateSelfIgnoreShape();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.drawableState.f37898c = colorFilter;
        invalidateSelfIgnoreShape();
    }

    public void setCornerSize(float f10) {
        setShapeAppearanceModel(this.drawableState.f37896a.w(f10));
    }

    public void setEdgeIntersectionCheckEnable(boolean z10) {
        this.pathProvider.n(z10);
    }

    public void setElevation(float f10) {
        c cVar = this.drawableState;
        if (cVar.f37910o != f10) {
            cVar.f37910o = f10;
            updateZ();
        }
    }

    public void setFillColor(ColorStateList colorStateList) {
        c cVar = this.drawableState;
        if (cVar.f37899d != colorStateList) {
            cVar.f37899d = colorStateList;
            onStateChange(getState());
        }
    }

    public void setInterpolation(float f10) {
        c cVar = this.drawableState;
        if (cVar.f37906k != f10) {
            cVar.f37906k = f10;
            this.pathDirty = true;
            invalidateSelf();
        }
    }

    public void setPadding(int i10, int i11, int i12, int i13) {
        c cVar = this.drawableState;
        if (cVar.f37904i == null) {
            cVar.f37904i = new Rect();
        }
        this.drawableState.f37904i.set(i10, i11, i12, i13);
        invalidateSelf();
    }

    public void setPaintStyle(Paint.Style style) {
        this.drawableState.f37917v = style;
        invalidateSelfIgnoreShape();
    }

    public void setParentAbsoluteElevation(float f10) {
        c cVar = this.drawableState;
        if (cVar.f37909n != f10) {
            cVar.f37909n = f10;
            updateZ();
        }
    }

    public void setScale(float f10) {
        c cVar = this.drawableState;
        if (cVar.f37905j != f10) {
            cVar.f37905j = f10;
            invalidateSelf();
        }
    }

    public void setShadowBitmapDrawingEnable(boolean z10) {
        this.shadowBitmapDrawingEnable = z10;
    }

    public void setShadowColor(int i10) {
        this.shadowRenderer.d(i10);
        this.drawableState.f37916u = false;
        invalidateSelfIgnoreShape();
    }

    public void setShadowCompatRotation(int i10) {
        c cVar = this.drawableState;
        if (cVar.f37915t != i10) {
            cVar.f37915t = i10;
            invalidateSelfIgnoreShape();
        }
    }

    public void setShadowCompatibilityMode(int i10) {
        c cVar = this.drawableState;
        if (cVar.f37912q != i10) {
            cVar.f37912q = i10;
            invalidateSelfIgnoreShape();
        }
    }

    @Deprecated
    public void setShadowElevation(int i10) {
        setElevation(i10);
    }

    @Deprecated
    public void setShadowEnabled(boolean z10) {
        setShadowCompatibilityMode(!z10 ? 1 : 0);
    }

    @Deprecated
    public void setShadowRadius(int i10) {
        this.drawableState.f37913r = i10;
    }

    public void setShadowVerticalOffset(int i10) {
        c cVar = this.drawableState;
        if (cVar.f37914s != i10) {
            cVar.f37914s = i10;
            invalidateSelfIgnoreShape();
        }
    }

    @Override // x4.r
    public void setShapeAppearanceModel(n nVar) {
        this.drawableState.f37896a = nVar;
        invalidateSelf();
    }

    @Deprecated
    public void setShapedViewModel(q qVar) {
        setShapeAppearanceModel(qVar);
    }

    public void setStroke(float f10, int i10) {
        setStrokeWidth(f10);
        setStrokeColor(ColorStateList.valueOf(i10));
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        c cVar = this.drawableState;
        if (cVar.f37900e != colorStateList) {
            cVar.f37900e = colorStateList;
            onStateChange(getState());
        }
    }

    public void setStrokeTint(ColorStateList colorStateList) {
        this.drawableState.f37901f = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setStrokeWidth(float f10) {
        this.drawableState.f37907l = f10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.drawableState.f37902g = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.drawableState;
        if (cVar.f37903h != mode) {
            cVar.f37903h = mode;
            updateTintFilter();
            invalidateSelfIgnoreShape();
        }
    }

    public void setTranslationZ(float f10) {
        c cVar = this.drawableState;
        if (cVar.f37911p != f10) {
            cVar.f37911p = f10;
            updateZ();
        }
    }

    public void setUseTintColorForShadow(boolean z10) {
        c cVar = this.drawableState;
        if (cVar.f37916u != z10) {
            cVar.f37916u = z10;
            invalidateSelf();
        }
    }

    public void setZ(float f10) {
        setTranslationZ(f10 - getElevation());
    }

    public i(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(n.e(context, attributeSet, i10, i11).m());
    }

    public static i createWithElevationOverlay(Context context, float f10) {
        return createWithElevationOverlay(context, f10, null);
    }

    private void drawShape(Canvas canvas, Paint paint, Path path, n nVar, RectF rectF) {
        if (nVar.u(rectF)) {
            float a10 = nVar.t().a(rectF) * this.drawableState.f37906k;
            canvas.drawRoundRect(rectF, a10, a10, paint);
        } else {
            canvas.drawPath(path, paint);
        }
    }

    public void setCornerSize(d dVar) {
        setShapeAppearanceModel(this.drawableState.f37896a.x(dVar));
    }

    @Deprecated
    public i(q qVar) {
        this((n) qVar);
    }

    public static i createWithElevationOverlay(Context context, float f10, ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(C1292a.c(context, C0977c.f30697v, i.class.getSimpleName()));
        }
        i iVar = new i();
        iVar.initializeElevationOverlay(context);
        iVar.setFillColor(colorStateList);
        iVar.setElevation(f10);
        return iVar;
    }

    public void setStroke(float f10, ColorStateList colorStateList) {
        setStrokeWidth(f10);
        setStrokeColor(colorStateList);
    }

    public i(n nVar) {
        this(new c(nVar, null));
    }

    public void setStrokeTint(int i10) {
        setStrokeTint(ColorStateList.valueOf(i10));
    }

    public i(c cVar) {
        o oVar;
        this.cornerShadowOperation = new p.g[4];
        this.edgeShadowOperation = new p.g[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        Paint paint = new Paint(1);
        this.fillPaint = paint;
        Paint paint2 = new Paint(1);
        this.strokePaint = paint2;
        this.shadowRenderer = new C1649a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            oVar = o.k();
        } else {
            oVar = new o();
        }
        this.pathProvider = oVar;
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new a();
    }

    /* compiled from: MaterialShapeDrawable.java */
    /* loaded from: classes3.dex */
    public static class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public n f37896a;

        /* renamed from: b, reason: collision with root package name */
        public C1403a f37897b;

        /* renamed from: c, reason: collision with root package name */
        public ColorFilter f37898c;

        /* renamed from: d, reason: collision with root package name */
        public ColorStateList f37899d;

        /* renamed from: e, reason: collision with root package name */
        public ColorStateList f37900e;

        /* renamed from: f, reason: collision with root package name */
        public ColorStateList f37901f;

        /* renamed from: g, reason: collision with root package name */
        public ColorStateList f37902g;

        /* renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f37903h;

        /* renamed from: i, reason: collision with root package name */
        public Rect f37904i;

        /* renamed from: j, reason: collision with root package name */
        public float f37905j;

        /* renamed from: k, reason: collision with root package name */
        public float f37906k;

        /* renamed from: l, reason: collision with root package name */
        public float f37907l;

        /* renamed from: m, reason: collision with root package name */
        public int f37908m;

        /* renamed from: n, reason: collision with root package name */
        public float f37909n;

        /* renamed from: o, reason: collision with root package name */
        public float f37910o;

        /* renamed from: p, reason: collision with root package name */
        public float f37911p;

        /* renamed from: q, reason: collision with root package name */
        public int f37912q;

        /* renamed from: r, reason: collision with root package name */
        public int f37913r;

        /* renamed from: s, reason: collision with root package name */
        public int f37914s;

        /* renamed from: t, reason: collision with root package name */
        public int f37915t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f37916u;

        /* renamed from: v, reason: collision with root package name */
        public Paint.Style f37917v;

        public c(n nVar, C1403a c1403a) {
            this.f37899d = null;
            this.f37900e = null;
            this.f37901f = null;
            this.f37902g = null;
            this.f37903h = PorterDuff.Mode.SRC_IN;
            this.f37904i = null;
            this.f37905j = 1.0f;
            this.f37906k = 1.0f;
            this.f37908m = 255;
            this.f37909n = 0.0f;
            this.f37910o = 0.0f;
            this.f37911p = 0.0f;
            this.f37912q = 0;
            this.f37913r = 0;
            this.f37914s = 0;
            this.f37915t = 0;
            this.f37916u = false;
            this.f37917v = Paint.Style.FILL_AND_STROKE;
            this.f37896a = nVar;
            this.f37897b = c1403a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            i iVar = new i(this);
            iVar.pathDirty = true;
            return iVar;
        }

        public c(c cVar) {
            this.f37899d = null;
            this.f37900e = null;
            this.f37901f = null;
            this.f37902g = null;
            this.f37903h = PorterDuff.Mode.SRC_IN;
            this.f37904i = null;
            this.f37905j = 1.0f;
            this.f37906k = 1.0f;
            this.f37908m = 255;
            this.f37909n = 0.0f;
            this.f37910o = 0.0f;
            this.f37911p = 0.0f;
            this.f37912q = 0;
            this.f37913r = 0;
            this.f37914s = 0;
            this.f37915t = 0;
            this.f37916u = false;
            this.f37917v = Paint.Style.FILL_AND_STROKE;
            this.f37896a = cVar.f37896a;
            this.f37897b = cVar.f37897b;
            this.f37907l = cVar.f37907l;
            this.f37898c = cVar.f37898c;
            this.f37899d = cVar.f37899d;
            this.f37900e = cVar.f37900e;
            this.f37903h = cVar.f37903h;
            this.f37902g = cVar.f37902g;
            this.f37908m = cVar.f37908m;
            this.f37905j = cVar.f37905j;
            this.f37914s = cVar.f37914s;
            this.f37912q = cVar.f37912q;
            this.f37916u = cVar.f37916u;
            this.f37906k = cVar.f37906k;
            this.f37909n = cVar.f37909n;
            this.f37910o = cVar.f37910o;
            this.f37911p = cVar.f37911p;
            this.f37913r = cVar.f37913r;
            this.f37915t = cVar.f37915t;
            this.f37901f = cVar.f37901f;
            this.f37917v = cVar.f37917v;
            if (cVar.f37904i != null) {
                this.f37904i = new Rect(cVar.f37904i);
            }
        }
    }
}

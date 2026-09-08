package com.coui.appcompat.tintimageview;

import C.a;
import X8.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import androidx.core.content.b;
import com.coui.appcompat.theme.COUIThemeUtils;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import p.C1422h;

/* loaded from: classes3.dex */
public final class COUITintManager {
    private static final boolean DEBUG = false;
    private static final String TAG = "TintManager";
    private final WeakReference<Context> mContextRef;
    private ColorStateList mDefaultColorStateList;
    private SparseArray<ColorStateList> mTintLists;
    public static final boolean SHOULD_BE_USED = false;
    private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    private static final WeakHashMap<Context, COUITintManager> INSTANCE_CACHE = new WeakHashMap<>();
    private static final ColorFilterLruCache COLOR_FILTER_CACHE = new ColorFilterLruCache(6);

    /* loaded from: classes3.dex */
    public static class ColorFilterLruCache extends C1422h<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i10) {
            super(i10);
        }

        private static int generateCacheKey(int i10, PorterDuff.Mode mode) {
            return ((i10 + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter get(int i10, PorterDuff.Mode mode) {
            return get(Integer.valueOf(generateCacheKey(i10, mode)));
        }

        public PorterDuffColorFilter put(int i10, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(generateCacheKey(i10, mode)), porterDuffColorFilter);
        }
    }

    private COUITintManager(Context context) {
        this.mContextRef = new WeakReference<>(context);
    }

    private ColorStateList createCOUIDefaultColorStateList(Context context) {
        return new ColorStateList(new int[][]{COUIThemeUtils.DISABLED_STATE_SET, COUIThemeUtils.PRESSED_STATE_SET, COUIThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET}, new int[]{COUIThemeUtils.getDisabledThemeAttrColor(context, c.f4398p), COUIThemeUtils.getThemeAttrColor(context, c.f4346E), COUIThemeUtils.getThemeAttrColor(context, c.f4347F)});
    }

    public static COUITintManager get(Context context) {
        WeakHashMap<Context, COUITintManager> weakHashMap = INSTANCE_CACHE;
        COUITintManager cOUITintManager = weakHashMap.get(context);
        if (cOUITintManager == null) {
            COUITintManager cOUITintManager2 = new COUITintManager(context);
            weakHashMap.put(context, cOUITintManager2);
            return cOUITintManager2;
        }
        return cOUITintManager;
    }

    public static Drawable getDrawable(Context context, int i10) {
        return b.e(context, i10);
    }

    private static void setPorterDuffColorFilter(Drawable drawable, int i10, PorterDuff.Mode mode) {
        if (mode == null) {
            mode = DEFAULT_MODE;
        }
        ColorFilterLruCache colorFilterLruCache = COLOR_FILTER_CACHE;
        PorterDuffColorFilter porterDuffColorFilter = colorFilterLruCache.get(i10, mode);
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i10, mode);
            colorFilterLruCache.put(i10, mode, porterDuffColorFilter);
        }
        drawable.setColorFilter(porterDuffColorFilter);
    }

    public static void tintViewBackground(View view, COUITintInfo cOUITintInfo) {
        PorterDuff.Mode mode;
        Drawable background = view.getBackground();
        if (cOUITintInfo.mHasTintList) {
            int colorForState = cOUITintInfo.mTintList.getColorForState(view.getDrawableState(), cOUITintInfo.mTintList.getDefaultColor());
            if (cOUITintInfo.mHasTintMode) {
                mode = cOUITintInfo.mTintMode;
            } else {
                mode = null;
            }
            setPorterDuffColorFilter(background, colorForState, mode);
            return;
        }
        background.clearColorFilter();
    }

    public final ColorStateList getTintList(int i10) {
        ColorStateList colorStateList = null;
        if (this.mContextRef.get() == null) {
            return null;
        }
        SparseArray<ColorStateList> sparseArray = this.mTintLists;
        if (sparseArray != null) {
            colorStateList = sparseArray.get(i10);
        }
        if (colorStateList != null) {
            if (this.mTintLists == null) {
                this.mTintLists = new SparseArray<>();
            }
            this.mTintLists.append(i10, colorStateList);
        }
        return colorStateList;
    }

    public final PorterDuff.Mode getTintMode(int i10) {
        return null;
    }

    public final boolean tintDrawableUsingColorFilter(int i10, Drawable drawable) {
        this.mContextRef.get();
        return false;
    }

    public Drawable getDrawable(int i10) {
        return getDrawable(i10, false);
    }

    public Drawable getDrawable(int i10, boolean z10) {
        Context context = this.mContextRef.get();
        if (context == null) {
            return null;
        }
        Drawable e10 = b.e(context, i10);
        if (e10 != null) {
            e10 = e10.mutate();
            ColorStateList tintList = getTintList(i10);
            if (tintList != null) {
                Drawable r10 = a.r(e10);
                a.o(r10, tintList);
                PorterDuff.Mode tintMode = getTintMode(i10);
                if (tintMode == null) {
                    return r10;
                }
                a.p(r10, tintMode);
                return r10;
            }
            if (!tintDrawableUsingColorFilter(i10, e10) && z10) {
                return null;
            }
        }
        return e10;
    }
}

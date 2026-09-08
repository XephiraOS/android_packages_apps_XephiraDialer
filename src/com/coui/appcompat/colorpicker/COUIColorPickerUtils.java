package com.coui.appcompat.colorpicker;

import Y.b;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes.dex */
public class COUIColorPickerUtils {
    private static final int MAX_BITMAP_SIZE = 112;
    private static final int MAX_EXTRACTION_AREA = 12544;
    public static final int TYPE_H = 1;
    public static final int TYPE_HSV = 0;

    /* loaded from: classes.dex */
    public static class ColorReferenceField {
        static final float[] DEFAULT_HSV = {0.0f, 0.0f, 0.9f};
        static final float[] DEFAULT_H2HSV = {165.0f, 0.8f, 0.8f};
        static final float[] NORMALIZE_HSV_1 = {360.0f, 0.7f, 0.35f};
        static final float[] NORMALIZE_HSV_2 = {10.0f, 0.7f, 0.35f};
        static final float[] NORMALIZE_HSV_3 = {20.0f, 0.7f, 0.35f};
        static final float[] NORMALIZE_HSV_4 = {30.0f, 0.7f, 0.35f};
        static final float[] NORMALIZE_HSV_5 = {40.0f, 0.7f, 0.35f};
        static final float[] NORMALIZE_HSV_6 = {60.0f, 0.6f, 0.35f};
        static final float[] NORMALIZE_HSV_7 = {80.0f, 0.6f, 0.25f};
        static final float[] NORMALIZE_HSV_8 = {100.0f, 0.6f, 0.25f};
        static final float[] NORMALIZE_HSV_9 = {130.0f, 0.6f, 0.25f};
        static final float[] NORMALIZE_HSV_10 = {160.0f, 0.7f, 0.25f};
        static final float[] NORMALIZE_HSV_11 = {180.0f, 0.7f, 0.75f};
        static final float[] NORMALIZE_HSV_12 = {200.0f, 0.7f, 0.6f};
        static final float[] NORMALIZE_HSV_13 = {220.0f, 0.75f, 0.7f};
        static final float[] NORMALIZE_HSV_14 = {240.0f, 0.7f, 0.4f};
        static final float[] NORMALIZE_HSV_15 = {260.0f, 0.7f, 0.4f};
        static final float[] NORMALIZE_HSV_16 = {280.0f, 0.7f, 0.4f};
        static final float[] NORMALIZE_HSV_17 = {300.0f, 0.7f, 0.4f};
        static final float[] NORMALIZE_HSV_18 = {330.0f, 0.7f, 0.4f};
        static final float[] NORMALIZE_HSV_19 = {350.0f, 0.7f, 0.4f};
        static final float[] NORMALIZE_HSV_20 = {0.0f, 0.0f, 0.2f};
        static final float[] NORMALIZE_H2HSV_1 = {25.0f, 0.9f, 1.0f};
        static final float[] NORMALIZE_H2HSV_2 = {35.0f, 0.9f, 1.0f};
        static final float[] NORMALIZE_H2HSV_3 = {35.0f, 0.9f, 1.0f};
        static final float[] NORMALIZE_H2HSV_4 = {105.0f, 0.7f, 0.7f};
        static final float[] NORMALIZE_H2HSV_5 = {135.0f, 0.7f, 0.7f};
        static final float[] NORMALIZE_H2HSV_6 = {165.0f, 0.8f, 0.8f};
        static final float[] NORMALIZE_H2HSV_7 = {195.0f, 0.9f, 0.9f};
        static final float[] NORMALIZE_H2HSV_8 = {225.0f, 0.65f, 0.9f};
        static final float[] NORMALIZE_H2HSV_9 = {255.0f, 0.7f, 0.9f};
        static final float[] NORMALIZE_H2HSV_10 = {285.0f, 0.7f, 0.9f};
        static final float[] NORMALIZE_H2HSV_11 = {315.0f, 0.7f, 0.85f};
        static final float[] NORMALIZE_H2HSV_12 = {350.0f, 0.7f, 0.95f};

        private ColorReferenceField() {
        }
    }

    private static Size calculateOptimalSize(int i10, int i11) {
        double d10;
        int i12 = i10 * i11;
        if (i12 > MAX_EXTRACTION_AREA) {
            d10 = Math.sqrt(12544.0d / i12);
        } else {
            d10 = 1.0d;
        }
        int i13 = (int) (i10 * d10);
        int i14 = (int) (i11 * d10);
        if (i13 == 0) {
            i13 = 1;
        }
        if (i14 == 0) {
            i14 = 1;
        }
        return new Size(i13, i14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$pickColorFromBitmap$0(b.d dVar, b.d dVar2) {
        return dVar2.d() - dVar.d();
    }

    private static int normalizeHSV(ArrayList<b.d> arrayList, int i10) {
        int normalizeHSVWithHSV;
        float[] fArr = new float[3];
        Iterator<b.d> it = arrayList.iterator();
        while (it.hasNext()) {
            Color.colorToHSV(it.next().e(), fArr);
            if (i10 == 1) {
                normalizeHSVWithHSV = normalizeHSVWithH(fArr);
            } else {
                normalizeHSVWithHSV = normalizeHSVWithHSV(fArr);
            }
            if (normalizeHSVWithHSV != -1) {
                return normalizeHSVWithHSV;
            }
        }
        if (i10 == 1) {
            return Color.HSVToColor(ColorReferenceField.DEFAULT_H2HSV);
        }
        return Color.HSVToColor(ColorReferenceField.DEFAULT_HSV);
    }

    private static int normalizeHSVWithH(float[] fArr) {
        float[] fArr2;
        if (fArr[1] > 0.05f && fArr[2] > 0.05f) {
            float f10 = fArr[0];
            if (f10 <= 39.0f) {
                fArr2 = ColorReferenceField.NORMALIZE_H2HSV_1;
            } else if (f10 <= 59.0f) {
                fArr2 = ColorReferenceField.NORMALIZE_H2HSV_2;
            } else if (f10 <= 89.0f) {
                fArr2 = ColorReferenceField.NORMALIZE_H2HSV_3;
            } else if (f10 <= 119.0f) {
                fArr2 = ColorReferenceField.NORMALIZE_H2HSV_4;
            } else if (f10 <= 149.0f) {
                fArr2 = ColorReferenceField.NORMALIZE_H2HSV_5;
            } else if (f10 <= 180.0f) {
                fArr2 = ColorReferenceField.NORMALIZE_H2HSV_6;
            } else if (f10 <= 209.0f) {
                fArr2 = ColorReferenceField.NORMALIZE_H2HSV_7;
            } else if (f10 <= 239.0f) {
                fArr2 = ColorReferenceField.NORMALIZE_H2HSV_8;
            } else if (f10 <= 269.0f) {
                fArr2 = ColorReferenceField.NORMALIZE_H2HSV_9;
            } else if (f10 <= 299.0f) {
                fArr2 = ColorReferenceField.NORMALIZE_H2HSV_10;
            } else if (f10 <= 329.0f) {
                fArr2 = ColorReferenceField.NORMALIZE_H2HSV_11;
            } else {
                fArr2 = ColorReferenceField.NORMALIZE_H2HSV_12;
            }
            return Color.HSVToColor(fArr2);
        }
        return -1;
    }

    private static int normalizeHSVWithHSV(float[] fArr) {
        float[] fArr2;
        float f10 = fArr[0];
        if (f10 == 0.0f && fArr[1] == 0.0f && fArr[2] == 0.2f) {
            return Color.HSVToColor(ColorReferenceField.NORMALIZE_HSV_20);
        }
        if (fArr[1] >= 0.3f) {
            float f11 = fArr[2];
            if (f11 >= 0.15f) {
                if (f10 >= 166.0f && f10 <= 225.0f && f11 < 0.3f) {
                    return -1;
                }
                if (f10 > 5.0f && f10 < 356.0f) {
                    if (f10 <= 15.0f) {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_2;
                    } else if (f10 <= 25.0f) {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_3;
                    } else if (f10 <= 35.0f) {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_4;
                    } else if (f10 <= 55.0f) {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_5;
                    } else if (f10 <= 75.0f) {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_6;
                    } else if (f10 <= 95.0f) {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_7;
                    } else if (f10 <= 115.0f) {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_8;
                    } else if (f10 <= 145.0f) {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_9;
                    } else if (f10 <= 165.0f) {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_10;
                    } else if (f10 <= 195.0f) {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_11;
                    } else if (f10 <= 205.0f) {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_12;
                    } else if (f10 <= 225.0f) {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_13;
                    } else if (f10 <= 255.0f) {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_14;
                    } else if (f10 <= 275.0f) {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_15;
                    } else if (f10 <= 285.0f) {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_16;
                    } else if (f10 <= 315.0f) {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_17;
                    } else if (f10 <= 335.0f) {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_18;
                    } else {
                        fArr2 = ColorReferenceField.NORMALIZE_HSV_19;
                    }
                } else {
                    fArr2 = ColorReferenceField.NORMALIZE_HSV_1;
                }
                return Color.HSVToColor(fArr2);
            }
        }
        return -1;
    }

    public static int pickColorFromBitmap(Bitmap bitmap, int i10, boolean z10) {
        b a10;
        if (bitmap != null) {
            boolean z11 = true;
            if (i10 != 0 && i10 != 1) {
                throw new IllegalArgumentException("Numerical violation");
            }
            if (bitmap.getWidth() * bitmap.getHeight() > MAX_EXTRACTION_AREA) {
                Size calculateOptimalSize = calculateOptimalSize(bitmap.getWidth(), bitmap.getHeight());
                bitmap = Bitmap.createScaledBitmap(bitmap, calculateOptimalSize.getWidth(), calculateOptimalSize.getHeight(), false);
            } else {
                z11 = false;
            }
            if (z10) {
                a10 = b.b(bitmap).c(5).d(MAX_EXTRACTION_AREA).a();
            } else {
                a10 = b.b(bitmap).c(128).d(MAX_EXTRACTION_AREA).a();
            }
            if (z11) {
                bitmap.recycle();
            }
            ArrayList arrayList = new ArrayList(a10.g());
            arrayList.sort(new Comparator() { // from class: com.coui.appcompat.colorpicker.a
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int lambda$pickColorFromBitmap$0;
                    lambda$pickColorFromBitmap$0 = COUIColorPickerUtils.lambda$pickColorFromBitmap$0((b.d) obj, (b.d) obj2);
                    return lambda$pickColorFromBitmap$0;
                }
            });
            int normalizeHSV = normalizeHSV(arrayList, i10);
            arrayList.clear();
            return normalizeHSV;
        }
        throw new IllegalArgumentException("Bitmap cannot be null");
    }

    public static int pickColorFromDrawable(Drawable drawable, int i10, boolean z10) {
        if (drawable != null) {
            if (i10 != 0 && i10 != 1) {
                throw new IllegalArgumentException("Numerical violation");
            }
            if (drawable instanceof BitmapDrawable) {
                return pickColorFromBitmap(((BitmapDrawable) drawable).getBitmap(), i10, z10);
            }
            Rect copyBounds = drawable.copyBounds();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                intrinsicWidth = 112;
                intrinsicHeight = 112;
            }
            Size calculateOptimalSize = calculateOptimalSize(intrinsicWidth, intrinsicHeight);
            Bitmap createBitmap = Bitmap.createBitmap(calculateOptimalSize.getWidth(), calculateOptimalSize.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, createBitmap.getWidth(), createBitmap.getHeight());
            drawable.draw(canvas);
            int pickColorFromBitmap = pickColorFromBitmap(createBitmap, i10, z10);
            createBitmap.recycle();
            drawable.setBounds(copyBounds);
            return pickColorFromBitmap;
        }
        throw new IllegalArgumentException("Drawable cannot be null");
    }

    public static int pickColorFromImageView(ImageView imageView, int i10, boolean z10) {
        if (imageView != null) {
            if (i10 != 0 && i10 != 1) {
                throw new IllegalArgumentException("Numerical violation");
            }
            return pickColorFromDrawable(imageView.getDrawable(), i10, z10);
        }
        throw new IllegalArgumentException("ImageView cannot be null");
    }
}

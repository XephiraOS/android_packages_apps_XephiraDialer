package com.oua.util;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.Size;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class Transform {
    public static final int ROTATE_180 = 180;
    public static final int ROTATE_90_CLOCKWISE = 90;
    public static final int ROTATE_90_COUNTERCLOCKWISE = -90;
    public static final int ROTATE_NON = 0;
    private static final String TAG = "com.oua.util.Transform";

    /* renamed from: com.oua.util.Transform$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$oua$util$Transform$PaddingOption;

        static {
            int[] iArr = new int[PaddingOption.values().length];
            $SwitchMap$com$oua$util$Transform$PaddingOption = iArr;
            try {
                iArr[PaddingOption.Central.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$oua$util$Transform$PaddingOption[PaddingOption.PadBottomLeft.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public enum PaddingOption {
        PadBottomLeft,
        PadBottomRight,
        Central,
        NoPadding
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface RotateDegree {
    }

    /* loaded from: classes4.dex */
    public static class TransformCrop extends TransformPaddingOrCrop {
        public TransformCrop(Size size, Rect rect) {
            super(size, rect, new Size(rect.width(), rect.height()), new Point(-rect.left, -rect.top));
        }

        @Override // com.oua.util.Transform
        public Rect calcValidRect() {
            return transform(this.srcRect);
        }
    }

    /* loaded from: classes4.dex */
    public static class TransformGroup extends Transform {
        public List<Transform> transforms = new ArrayList();

        public int calcRotation() {
            int i10 = 0;
            for (Transform transform : this.transforms) {
                if (transform instanceof TransformRotate) {
                    i10 += ((TransformRotate) transform).degree;
                }
            }
            return TransformRotate.normalizeDegree(i10);
        }

        @Override // com.oua.util.Transform
        public Rect calcValidRect() {
            if (this.transforms.isEmpty()) {
                return new Rect(0, 0, 0, 0);
            }
            return this.transforms.get(r1.size() - 1).calcValidRect();
        }

        @Override // com.oua.util.Transform
        public Size getDstSize() {
            if (this.transforms.isEmpty()) {
                return new Size(0, 0);
            }
            return this.transforms.get(r1.size() - 1).getDstSize();
        }

        @Override // com.oua.util.Transform
        public Size getSrcSize() {
            if (this.transforms.isEmpty()) {
                return new Size(0, 0);
            }
            return this.transforms.get(0).getSrcSize();
        }

        @Override // com.oua.util.Transform
        public double[] reverseTransform(double d10, double d11) {
            return Transform.reverseTransform(this.transforms, d10, d11);
        }

        @Override // com.oua.util.Transform
        public double[] transform(double d10, double d11) {
            return Transform.transform(this.transforms, d10, d11);
        }
    }

    /* loaded from: classes4.dex */
    public static class TransformPadding extends TransformPaddingOrCrop {
        public TransformPadding(Size size, Size size2, int i10, int i11) {
            super(size, new Rect(0, 0, size.getWidth(), size.getHeight()), size2, new Point(i10, i11));
        }

        public static TransformPadding create(Size size, Size size2, PaddingOption paddingOption) {
            int width;
            int height;
            int i10 = AnonymousClass1.$SwitchMap$com$oua$util$Transform$PaddingOption[paddingOption.ordinal()];
            if (i10 != 1) {
                width = 0;
                if (i10 != 2) {
                    height = 0;
                } else {
                    width = size2.getWidth() - size.getWidth();
                    height = 0;
                }
            } else {
                width = (size2.getWidth() - size.getWidth()) / 2;
                height = (size2.getHeight() - size.getHeight()) / 2;
            }
            return new TransformPadding(size, size2, width, height);
        }

        @Override // com.oua.util.Transform
        public Rect calcValidRect() {
            return transform(this.srcRect);
        }
    }

    /* loaded from: classes4.dex */
    public static class TransformPaddingOrCrop extends Transform {
        public Size dstSize;
        public Point offset;
        public Rect srcRect;
        public Size srcSize;

        public TransformPaddingOrCrop(Size size, Rect rect, Size size2, Point point) {
            this.srcSize = Transform.copy(size);
            this.dstSize = Transform.copy(size2);
            this.srcRect = new Rect(rect);
            this.offset = new Point(point);
        }

        @Override // com.oua.util.Transform
        public Size getDstSize() {
            return this.dstSize;
        }

        @Override // com.oua.util.Transform
        public Size getSrcSize() {
            return this.srcSize;
        }

        @Override // com.oua.util.Transform
        public double[] reverseTransform(double d10, double d11) {
            Point point = this.offset;
            return new double[]{d10 - point.x, d11 - point.y};
        }

        @Override // com.oua.util.Transform
        public double[] transform(double d10, double d11) {
            Point point = this.offset;
            return new double[]{d10 + point.x, d11 + point.y};
        }
    }

    /* loaded from: classes4.dex */
    public static class TransformRotate extends Transform {
        public int degree;
        public Size srcSize;

        public TransformRotate(Size size, int i10) {
            this.degree = 90;
            this.srcSize = Transform.copy(size);
            this.degree = i10;
        }

        public static int normalizeDegree(int i10) {
            int i11;
            if (i10 < 0) {
                i11 = (-(-i10)) % 360;
            } else {
                i11 = i10 % 360;
            }
            if (i11 == 270) {
                return -90;
            }
            return i11;
        }

        public static int reverseDegree(int i10) {
            if (i10 != -90 && i10 != 90) {
                if (i10 == 180) {
                    return 180;
                }
                return 0;
            }
            return -i10;
        }

        @Override // com.oua.util.Transform
        public Size getDstSize() {
            return new Size(this.srcSize.getHeight(), this.srcSize.getWidth());
        }

        @Override // com.oua.util.Transform
        public Size getSrcSize() {
            return this.srcSize;
        }

        @Override // com.oua.util.Transform
        public double[] reverseTransform(double d10, double d11) {
            int i10;
            int i11;
            int i12;
            int reverseDegree = reverseDegree(this.degree);
            int width = this.srcSize.getWidth();
            int height = this.srcSize.getHeight();
            int i13 = this.degree;
            if (i13 != -90 && i13 != 90) {
                i10 = reverseDegree;
                i12 = width;
                i11 = height;
            } else {
                i10 = -i13;
                i11 = width;
                i12 = height;
            }
            return transform(d10, d11, i10, i12, i11);
        }

        public String toString() {
            return String.format("rotate: {degre:%d,srcSize:%s}", Integer.valueOf(this.degree), this.srcSize.toString());
        }

        @Override // com.oua.util.Transform
        public double[] transform(double d10, double d11) {
            return transform(d10, d11, this.degree, this.srcSize.getWidth(), this.srcSize.getHeight());
        }

        private static double[] transform(double d10, double d11, int i10, int i11, int i12) {
            if (i10 == -90) {
                return new double[]{d11, i11 - d10};
            }
            if (i10 == 90) {
                return new double[]{i12 - d11, d10};
            }
            if (i10 == 180) {
                return new double[]{i11 - d10, i12 - d11};
            }
            throw new RuntimeException("Unknow rotation degree " + i10);
        }
    }

    public static Size copy(Size size) {
        return new Size(size.getWidth(), size.getHeight());
    }

    public static List<Transform> createResizeAndPadding(Size size, Size size2, PaddingOption paddingOption) {
        ArrayList arrayList = new ArrayList();
        TransformScale createFixRatioScale = TransformScale.createFixRatioScale(size, size2);
        arrayList.add(createFixRatioScale);
        Size dstSize = createFixRatioScale.getDstSize();
        if (paddingOption != null) {
            arrayList.add(TransformPadding.create(dstSize, size2, paddingOption));
        }
        return arrayList;
    }

    public static List<Transform> createTransforms(Size size, Rect rect, Size size2, PaddingOption paddingOption, int i10) {
        TransformScale transformScale;
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        if (rect != null) {
            TransformCrop transformCrop = new TransformCrop(size, rect);
            size = transformCrop.getDstSize();
            arrayList.add(transformCrop);
        } else {
            rect = new Rect(0, 0, size.getWidth(), size.getHeight());
            arrayList.add(null);
        }
        if (size2 != null) {
            z10 = true;
        }
        if (size2 == null) {
            size2 = new Size(rect.width(), rect.height());
            if (i10 == 90 || i10 == -90) {
                size2 = new Size(size2.getHeight(), size2.getWidth());
            }
        }
        if (z10) {
            if (paddingOption != null) {
                transformScale = TransformScale.createFixRatioScale(size, size2);
            } else {
                transformScale = new TransformScale(size, size2);
            }
            Size dstSize = transformScale.getDstSize();
            arrayList.add(transformScale);
            size = dstSize;
        } else {
            arrayList.add(null);
        }
        if (i10 != 0) {
            TransformRotate transformRotate = new TransformRotate(size, i10);
            size = transformRotate.getDstSize();
            arrayList.add(transformRotate);
        } else {
            arrayList.add(null);
        }
        if (paddingOption != null && paddingOption != PaddingOption.NoPadding) {
            arrayList.add(TransformPadding.create(size, size2, paddingOption));
        } else {
            arrayList.add(null);
        }
        return arrayList;
    }

    public Rect calcValidRect() {
        Size dstSize = getDstSize();
        return new Rect(0, 0, dstSize.getWidth(), dstSize.getHeight());
    }

    public abstract Size getDstSize();

    public abstract Size getSrcSize();

    public abstract double[] reverseTransform(double d10, double d11);

    public double[] reverseTransform(double[] dArr) {
        return reverseTransform(dArr[0], dArr[1]);
    }

    public abstract double[] transform(double d10, double d11);

    public double[] transform(double[] dArr) {
        return transform(dArr[0], dArr[1]);
    }

    public static double[] reverseTransform(List<Transform> list, double[] dArr) {
        for (int size = list.size() - 1; size >= 0; size--) {
            dArr = list.get(size).reverseTransform(dArr);
        }
        return dArr;
    }

    public Rect transform(Rect rect) {
        double[] transform = transform(rect.left, rect.top);
        double[] transform2 = transform(rect.right, rect.bottom);
        return new Rect((int) Math.min(transform[0], transform2[0]), (int) Math.min(transform[1], transform2[1]), (int) Math.max(transform[0], transform2[0]), (int) Math.max(transform[1], transform2[1]));
    }

    public static double[] reverseTransform(List<Transform> list, double d10, double d11) {
        return reverseTransform(list, new double[]{d10, d11});
    }

    /* loaded from: classes4.dex */
    public static class TransformScale extends Transform {
        public Size dstSize;
        public double scaleX;
        public double scaleY;
        public Size srcSize;

        public TransformScale(Size size, double d10) {
            this.srcSize = Transform.copy(size);
            this.dstSize = new Size((int) (size.getWidth() * d10), (int) (size.getHeight() * d10));
            this.scaleX = d10;
            this.scaleY = d10;
        }

        public static TransformScale createFixRatioScale(Size size, Size size2) {
            return new TransformScale(size, getFixRatioSize(size, size2));
        }

        public static Size getFixRatioSize(Size size, Size size2) {
            double width = size.getWidth() / size.getHeight();
            if (width > size2.getWidth() / size2.getHeight()) {
                return new Size(size2.getWidth(), (int) (size2.getWidth() / width));
            }
            return new Size((int) (size2.getHeight() * width), size2.getHeight());
        }

        @Override // com.oua.util.Transform
        public Size getDstSize() {
            return this.dstSize;
        }

        @Override // com.oua.util.Transform
        public Size getSrcSize() {
            return this.srcSize;
        }

        @Override // com.oua.util.Transform
        public double[] reverseTransform(double d10, double d11) {
            return new double[]{d10 / this.scaleX, d11 / this.scaleY};
        }

        @Override // com.oua.util.Transform
        public double[] transform(double d10, double d11) {
            return new double[]{d10 * this.scaleX, d11 * this.scaleY};
        }

        public TransformScale(Size size, Size size2) {
            this.srcSize = Transform.copy(size);
            this.dstSize = Transform.copy(size2);
            this.scaleX = size2.getWidth() / size.getWidth();
            this.scaleY = size2.getHeight() / size.getHeight();
        }
    }

    public static double[] transform(List<Transform> list, double d10, double d11) {
        double[] dArr = {d10, d11};
        Iterator<Transform> it = list.iterator();
        while (it.hasNext()) {
            dArr = it.next().transform(dArr);
        }
        return dArr;
    }
}

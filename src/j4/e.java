package j4;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;

/* compiled from: CarouselOrientationHelper.java */
/* loaded from: classes3.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public final int f33863a;

    /* compiled from: CarouselOrientationHelper.java */
    /* loaded from: classes3.dex */
    public class a extends e {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CarouselLayoutManager f33864b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i10, CarouselLayoutManager carouselLayoutManager) {
            super(i10, null);
            this.f33864b = carouselLayoutManager;
        }

        @Override // j4.e
        public void a(RectF rectF, RectF rectF2, RectF rectF3) {
            float f10 = rectF2.top;
            float f11 = rectF3.top;
            if (f10 < f11 && rectF2.bottom > f11) {
                float f12 = f11 - f10;
                rectF.top += f12;
                rectF3.top += f12;
            }
            float f13 = rectF2.bottom;
            float f14 = rectF3.bottom;
            if (f13 > f14 && rectF2.top < f14) {
                float f15 = f13 - f14;
                rectF.bottom = Math.max(rectF.bottom - f15, rectF.top);
                rectF2.bottom = Math.max(rectF2.bottom - f15, rectF2.top);
            }
        }

        @Override // j4.e
        public float e(RecyclerView.LayoutParams layoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }

        @Override // j4.e
        public RectF f(float f10, float f11, float f12, float f13) {
            return new RectF(0.0f, f12, f11, f10 - f12);
        }

        @Override // j4.e
        public int g() {
            return this.f33864b.getHeight();
        }

        @Override // j4.e
        public int h() {
            return g();
        }

        @Override // j4.e
        public int i() {
            return this.f33864b.getPaddingLeft();
        }

        @Override // j4.e
        public int j() {
            return this.f33864b.getWidth() - this.f33864b.getPaddingRight();
        }

        @Override // j4.e
        public int k() {
            return l();
        }

        @Override // j4.e
        public int l() {
            return 0;
        }

        @Override // j4.e
        public void m(View view, int i10, int i11) {
            int i12 = i();
            this.f33864b.layoutDecoratedWithMargins(view, i12, i10, i12 + p(view), i11);
        }

        @Override // j4.e
        public void n(RectF rectF, RectF rectF2, RectF rectF3) {
            if (rectF2.bottom <= rectF3.top) {
                float floor = ((float) Math.floor(rectF.bottom)) - 1.0f;
                rectF.bottom = floor;
                rectF.top = Math.min(rectF.top, floor);
            }
            if (rectF2.top >= rectF3.bottom) {
                float ceil = ((float) Math.ceil(rectF.top)) + 1.0f;
                rectF.top = ceil;
                rectF.bottom = Math.max(ceil, rectF.bottom);
            }
        }

        @Override // j4.e
        public void o(View view, Rect rect, float f10, float f11) {
            view.offsetTopAndBottom((int) (f11 - (rect.top + f10)));
        }

        public int p(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f33864b.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }
    }

    /* compiled from: CarouselOrientationHelper.java */
    /* loaded from: classes3.dex */
    public class b extends e {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CarouselLayoutManager f33865b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i10, CarouselLayoutManager carouselLayoutManager) {
            super(i10, null);
            this.f33865b = carouselLayoutManager;
        }

        @Override // j4.e
        public void a(RectF rectF, RectF rectF2, RectF rectF3) {
            float f10 = rectF2.left;
            float f11 = rectF3.left;
            if (f10 < f11 && rectF2.right > f11) {
                float f12 = f11 - f10;
                rectF.left += f12;
                rectF2.left += f12;
            }
            float f13 = rectF2.right;
            float f14 = rectF3.right;
            if (f13 > f14 && rectF2.left < f14) {
                float f15 = f13 - f14;
                rectF.right = Math.max(rectF.right - f15, rectF.left);
                rectF2.right = Math.max(rectF2.right - f15, rectF2.left);
            }
        }

        @Override // j4.e
        public float e(RecyclerView.LayoutParams layoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        }

        @Override // j4.e
        public RectF f(float f10, float f11, float f12, float f13) {
            return new RectF(f13, 0.0f, f11 - f13, f10);
        }

        @Override // j4.e
        public int g() {
            return this.f33865b.getHeight() - this.f33865b.getPaddingBottom();
        }

        @Override // j4.e
        public int h() {
            if (this.f33865b.P()) {
                return i();
            }
            return j();
        }

        @Override // j4.e
        public int i() {
            return 0;
        }

        @Override // j4.e
        public int j() {
            return this.f33865b.getWidth();
        }

        @Override // j4.e
        public int k() {
            if (this.f33865b.P()) {
                return j();
            }
            return i();
        }

        @Override // j4.e
        public int l() {
            return this.f33865b.getPaddingTop();
        }

        @Override // j4.e
        public void m(View view, int i10, int i11) {
            int l10 = l();
            this.f33865b.layoutDecoratedWithMargins(view, i10, l10, i11, l10 + p(view));
        }

        @Override // j4.e
        public void n(RectF rectF, RectF rectF2, RectF rectF3) {
            if (rectF2.right <= rectF3.left) {
                float floor = ((float) Math.floor(rectF.right)) - 1.0f;
                rectF.right = floor;
                rectF.left = Math.min(rectF.left, floor);
            }
            if (rectF2.left >= rectF3.right) {
                float ceil = ((float) Math.ceil(rectF.left)) + 1.0f;
                rectF.left = ceil;
                rectF.right = Math.max(ceil, rectF.right);
            }
        }

        @Override // j4.e
        public void o(View view, Rect rect, float f10, float f11) {
            view.offsetLeftAndRight((int) (f11 - (rect.left + f10)));
        }

        public int p(View view) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return this.f33865b.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
    }

    public /* synthetic */ e(int i10, a aVar) {
        this(i10);
    }

    public static e b(CarouselLayoutManager carouselLayoutManager) {
        return new b(0, carouselLayoutManager);
    }

    public static e c(CarouselLayoutManager carouselLayoutManager, int i10) {
        if (i10 != 0) {
            if (i10 == 1) {
                return d(carouselLayoutManager);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return b(carouselLayoutManager);
    }

    public static e d(CarouselLayoutManager carouselLayoutManager) {
        return new a(1, carouselLayoutManager);
    }

    public abstract void a(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract float e(RecyclerView.LayoutParams layoutParams);

    public abstract RectF f(float f10, float f11, float f12, float f13);

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract void m(View view, int i10, int i11);

    public abstract void n(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract void o(View view, Rect rect, float f10, float f11);

    public e(int i10) {
        this.f33863a = i10;
    }
}

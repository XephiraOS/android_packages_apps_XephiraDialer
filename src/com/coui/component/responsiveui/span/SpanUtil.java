package com.coui.component.responsiveui.span;

import B9.i;
import com.coui.component.responsiveui.unit.Dp;
import kotlin.jvm.internal.f;

/* compiled from: SpanUtil.kt */
/* loaded from: classes3.dex */
public final class SpanUtil {
    public static final int DEFAULT_COLUMNS_PER_SPAN = 4;
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public static final Dp f20019a = new Dp(360);

    /* compiled from: SpanUtil.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ float calculateGapBetweenSpans$default(Companion companion, int i10, int i11, int i12, int i13, int i14, int i15, Object obj) {
            if ((i15 & 16) != 0) {
                i14 = 1;
            }
            return companion.calculateGapBetweenSpans(i10, i11, i12, i13, i14);
        }

        public static /* synthetic */ int calculateSpanCount$default(Companion companion, Dp dp, int i10, Dp dp2, int i11, int i12, Object obj) {
            if ((i12 & 8) != 0) {
                i11 = i10;
            }
            return companion.calculateSpanCount(dp, i10, dp2, i11);
        }

        public final float calculateGapBetweenSpans(int i10, int i11, int i12, int i13, int i14) {
            float a10;
            if (i11 > 1) {
                if (i14 >= 0) {
                    a10 = i.a(((i10 - (i13 * 2)) - (i12 * i11)) / (i11 - 1.0f), i14);
                    return a10;
                }
                throw new IllegalArgumentException("minGap must be equal or greater than 0");
            }
            throw new IllegalArgumentException("spanCounts must be greater than 1");
        }

        public final int calculateSpanCount(int i10, int i11) {
            if (i10 <= 0) {
                throw new IllegalArgumentException("totalColumns must be positive".toString());
            }
            if (i11 <= 0) {
                throw new IllegalArgumentException("columnsPerSpan must be positive".toString());
            }
            if (i11 <= i10) {
                return i10 / i11;
            }
            throw new IllegalArgumentException("totalColumns must be equal or greater than columnsPerSpan".toString());
        }

        public final Dp getDEFAULT_BASE_WIDTH() {
            return SpanUtil.f20019a;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final int calculateSpanCount(Dp baseWidth, int i10, Dp layoutGridWindowWidth, int i11) {
            int b10;
            kotlin.jvm.internal.i.f(baseWidth, "baseWidth");
            kotlin.jvm.internal.i.f(layoutGridWindowWidth, "layoutGridWindowWidth");
            if (i10 >= 1) {
                b10 = i.b((int) (layoutGridWindowWidth.div(baseWidth).getValue() * i10), i11);
                return b10;
            }
            throw new IllegalArgumentException("spanCountPerBaseWidth must be equal or greater than 1".toString());
        }
    }
}

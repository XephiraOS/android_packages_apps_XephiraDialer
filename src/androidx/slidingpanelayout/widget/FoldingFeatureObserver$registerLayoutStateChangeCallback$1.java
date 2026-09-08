package androidx.slidingpanelayout.widget;

import android.app.Activity;
import androidx.slidingpanelayout.widget.FoldingFeatureObserver;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.flow.a;
import kotlinx.coroutines.flow.b;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: FoldingFeatureObserver.kt */
@InterfaceC1470d(c = "androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1", f = "FoldingFeatureObserver.kt", l = {97}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class FoldingFeatureObserver$registerLayoutStateChangeCallback$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ Activity $activity;
    int label;
    final /* synthetic */ FoldingFeatureObserver this$0;

    /* compiled from: Collect.kt */
    /* loaded from: classes.dex */
    public static final class a implements b<FoldingFeature> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FoldingFeatureObserver f11427a;

        public a(FoldingFeatureObserver foldingFeatureObserver) {
            this.f11427a = foldingFeatureObserver;
        }

        @Override // kotlinx.coroutines.flow.b
        public Object emit(FoldingFeature foldingFeature, c<? super q> cVar) {
            FoldingFeatureObserver.a aVar;
            q qVar;
            Object c10;
            FoldingFeature foldingFeature2 = foldingFeature;
            aVar = this.f11427a.f11422d;
            if (aVar == null) {
                qVar = null;
            } else {
                aVar.a(foldingFeature2);
                qVar = q.f35511a;
            }
            c10 = kotlin.coroutines.intrinsics.b.c();
            if (qVar == c10) {
                return qVar;
            }
            return q.f35511a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoldingFeatureObserver$registerLayoutStateChangeCallback$1(FoldingFeatureObserver foldingFeatureObserver, Activity activity, c<? super FoldingFeatureObserver$registerLayoutStateChangeCallback$1> cVar) {
        super(2, cVar);
        this.this$0 = foldingFeatureObserver;
        this.$activity = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(this.this$0, this.$activity, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        WindowInfoTracker windowInfoTracker;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            windowInfoTracker = this.this$0.f11419a;
            final kotlinx.coroutines.flow.a<WindowLayoutInfo> b10 = windowInfoTracker.b(this.$activity);
            final FoldingFeatureObserver foldingFeatureObserver = this.this$0;
            kotlinx.coroutines.flow.a e10 = kotlinx.coroutines.flow.c.e(new kotlinx.coroutines.flow.a<FoldingFeature>() { // from class: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1

                /* compiled from: Collect.kt */
                /* renamed from: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass2 implements b<WindowLayoutInfo> {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ b f11425a;

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ FoldingFeatureObserver f11426b;

                    @InterfaceC1470d(c = "androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2", f = "FoldingFeatureObserver.kt", l = {138}, m = "emit")
                    /* renamed from: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                    /* loaded from: classes.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(c cVar) {
                            super(cVar);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(b bVar, FoldingFeatureObserver foldingFeatureObserver) {
                        this.f11425a = bVar;
                        this.f11426b = foldingFeatureObserver;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.b
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public java.lang.Object emit(androidx.window.layout.WindowLayoutInfo r5, kotlin.coroutines.c r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = (androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = new androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.result
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.c()
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            kotlin.b.b(r6)
                            goto L4a
                        L29:
                            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                            r4.<init>(r5)
                            throw r4
                        L31:
                            kotlin.b.b(r6)
                            kotlinx.coroutines.flow.b r6 = r4.f11425a
                            androidx.window.layout.WindowLayoutInfo r5 = (androidx.window.layout.WindowLayoutInfo) r5
                            androidx.slidingpanelayout.widget.FoldingFeatureObserver r4 = r4.f11426b
                            androidx.window.layout.FoldingFeature r4 = androidx.slidingpanelayout.widget.FoldingFeatureObserver.a(r4, r5)
                            if (r4 != 0) goto L41
                            goto L4a
                        L41:
                            r0.label = r3
                            java.lang.Object r4 = r6.emit(r4, r0)
                            if (r4 != r1) goto L4a
                            return r1
                        L4a:
                            m9.q r4 = m9.q.f35511a
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.a
                public Object collect(b<? super FoldingFeature> bVar, c cVar) {
                    Object c11;
                    Object collect = a.this.collect(new AnonymousClass2(bVar, foldingFeatureObserver), cVar);
                    c11 = kotlin.coroutines.intrinsics.b.c();
                    if (collect == c11) {
                        return collect;
                    }
                    return q.f35511a;
                }
            });
            a aVar = new a(this.this$0);
            this.label = 1;
            if (e10.collect(aVar, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((FoldingFeatureObserver$registerLayoutStateChangeCallback$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}

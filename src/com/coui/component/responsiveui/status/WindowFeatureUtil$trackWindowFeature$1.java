package com.coui.component.responsiveui.status;

import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import java.util.function.Consumer;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.flow.a;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: WindowFeatureUtil.kt */
@InterfaceC1470d(c = "com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1", f = "WindowFeatureUtil.kt", l = {47}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WindowFeatureUtil$trackWindowFeature$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ Consumer<WindowFeature> $action;
    final /* synthetic */ ComponentActivity $activity;
    int label;

    /* compiled from: WindowFeatureUtil.kt */
    @InterfaceC1470d(c = "com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1", f = "WindowFeatureUtil.kt", l = {55}, m = "invokeSuspend")
    /* renamed from: com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<E, c<? super q>, Object> {
        final /* synthetic */ Consumer<WindowFeature> $action;
        final /* synthetic */ ComponentActivity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ComponentActivity componentActivity, Consumer<WindowFeature> consumer, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$activity = componentActivity;
            this.$action = consumer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<q> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.$activity, this.$action, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object c10;
            c10 = b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    kotlin.b.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                kotlin.b.b(obj);
                final a<WindowLayoutInfo> b10 = WindowInfoTracker.f12059a.d(this.$activity).b(this.$activity);
                a<WindowFeature> aVar = new a<WindowFeature>() { // from class: com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1

                    /* compiled from: Emitters.kt */
                    /* renamed from: com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass2<T> implements kotlinx.coroutines.flow.b {

                        /* renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ kotlinx.coroutines.flow.b f20026a;

                        /* compiled from: Emitters.kt */
                        @InterfaceC1470d(c = "com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1$2", f = "WindowFeatureUtil.kt", l = {223}, m = "emit")
                        /* renamed from: com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        /* loaded from: classes3.dex */
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

                        public AnonymousClass2(kotlinx.coroutines.flow.b bVar) {
                            this.f20026a = bVar;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                        @Override // kotlinx.coroutines.flow.b
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.c r8) {
                            /*
                                r6 = this;
                                boolean r0 = r8 instanceof com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r8
                                com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r8)
                            L18:
                                java.lang.Object r8 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.c()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.b.b(r8)
                                goto L68
                            L29:
                                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                                r6.<init>(r7)
                                throw r6
                            L31:
                                kotlin.b.b(r8)
                                kotlinx.coroutines.flow.b r6 = r6.f20026a
                                androidx.window.layout.WindowLayoutInfo r7 = (androidx.window.layout.WindowLayoutInfo) r7
                                java.util.List r7 = r7.a()
                                r8 = r7
                                java.lang.Iterable r8 = (java.lang.Iterable) r8
                                java.util.ArrayList r2 = new java.util.ArrayList
                                r2.<init>()
                                java.util.Iterator r8 = r8.iterator()
                            L48:
                                boolean r4 = r8.hasNext()
                                if (r4 == 0) goto L5a
                                java.lang.Object r4 = r8.next()
                                boolean r5 = r4 instanceof androidx.window.layout.FoldingFeature
                                if (r5 == 0) goto L48
                                r2.add(r4)
                                goto L48
                            L5a:
                                com.coui.component.responsiveui.status.WindowFeature r8 = new com.coui.component.responsiveui.status.WindowFeature
                                r8.<init>(r7, r2)
                                r0.label = r3
                                java.lang.Object r6 = r6.emit(r8, r0)
                                if (r6 != r1) goto L68
                                return r1
                            L68:
                                m9.q r6 = m9.q.f35511a
                                return r6
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.coui.component.responsiveui.status.WindowFeatureUtil$trackWindowFeature$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.a
                    public Object collect(kotlinx.coroutines.flow.b<? super WindowFeature> bVar, c cVar) {
                        Object c11;
                        Object collect = a.this.collect(new AnonymousClass2(bVar), cVar);
                        c11 = b.c();
                        if (collect == c11) {
                            return collect;
                        }
                        return q.f35511a;
                    }
                };
                final Consumer<WindowFeature> consumer = this.$action;
                kotlinx.coroutines.flow.b<? super WindowFeature> bVar = new kotlinx.coroutines.flow.b() { // from class: com.coui.component.responsiveui.status.WindowFeatureUtil.trackWindowFeature.1.1.2
                    @Override // kotlinx.coroutines.flow.b
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, c cVar) {
                        return emit((WindowFeature) obj2, (c<? super q>) cVar);
                    }

                    public final Object emit(WindowFeature windowFeature, c<? super q> cVar) {
                        boolean z10;
                        consumer.accept(windowFeature);
                        z10 = WindowFeatureUtil.f20024a;
                        if (z10) {
                            Log.d("WindowFeatureUtil", "[trackWindowFeature] windowFeature = " + windowFeature);
                        }
                        return q.f35511a;
                    }
                };
                this.label = 1;
                if (aVar.collect(bVar, this) == c10) {
                    return c10;
                }
            }
            return q.f35511a;
        }

        @Override // v9.p
        public final Object invoke(E e10, c<? super q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowFeatureUtil$trackWindowFeature$1(ComponentActivity componentActivity, Consumer<WindowFeature> consumer, c<? super WindowFeatureUtil$trackWindowFeature$1> cVar) {
        super(2, cVar);
        this.$activity = componentActivity;
        this.$action = consumer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new WindowFeatureUtil$trackWindowFeature$1(this.$activity, this.$action, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        c10 = b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            Lifecycle lifecycle = this.$activity.getLifecycle();
            i.e(lifecycle, "activity.lifecycle");
            Lifecycle.State state = Lifecycle.State.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$activity, this.$action, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.a(lifecycle, state, anonymousClass1, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((WindowFeatureUtil$trackWindowFeature$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}

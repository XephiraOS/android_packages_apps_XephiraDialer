package com.android.incallui.mvvm.utils;

import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.LiveData;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import v9.InterfaceC1637a;

/* compiled from: IgnoreEqualsLiveData.kt */
/* loaded from: classes.dex */
public final class IgnoreEqualsLiveDataKt {
    public static final <PARAM0, PARAM1, PARAM2, TRIPLE extends Triple<? extends g<PARAM0>, ? extends g<PARAM1>, ? extends g<PARAM2>>, RETURN> y<RETURN> A(final TRIPLE triple, RETURN r32, boolean z10, final v9.q<? super PARAM0, ? super PARAM1, ? super PARAM2, ? extends RETURN> mapFunction) {
        kotlin.jvm.internal.i.f(triple, "<this>");
        kotlin.jvm.internal.i.f(mapFunction, "mapFunction");
        final y<RETURN> yVar = new y<>(r32, z10);
        Object a10 = triple.a();
        kotlin.jvm.internal.i.d(a10, "null cannot be cast to non-null type androidx.lifecycle.LiveData<PARAM0 of com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt.transformNonNullMap$lambda$22>");
        final v9.l<PARAM0, m9.q> lVar = new v9.l<PARAM0, m9.q>() { // from class: com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt$transformNonNullMap$8$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (Lcom/android/incallui/mvvm/utils/y<TRETURN;>;Lv9/q<-TPARAM0;-TPARAM1;-TPARAM2;+TRETURN;>;TTRIPLE;)V */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void b(PARAM0 param0) {
                y.this.o(mapFunction.d(((g) triple.a()).getValue(), ((g) triple.b()).getValue(), ((g) triple.c()).getValue()));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Object obj) {
                b(obj);
                return m9.q.f35511a;
            }
        };
        yVar.p((LiveData) a10, new androidx.lifecycle.w() { // from class: com.android.incallui.mvvm.utils.x
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                IgnoreEqualsLiveDataKt.N(v9.l.this, obj);
            }
        });
        Object b10 = triple.b();
        kotlin.jvm.internal.i.d(b10, "null cannot be cast to non-null type androidx.lifecycle.LiveData<PARAM1 of com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt.transformNonNullMap$lambda$22>");
        final v9.l<PARAM1, m9.q> lVar2 = new v9.l<PARAM1, m9.q>() { // from class: com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt$transformNonNullMap$8$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (Lcom/android/incallui/mvvm/utils/y<TRETURN;>;Lv9/q<-TPARAM0;-TPARAM1;-TPARAM2;+TRETURN;>;TTRIPLE;)V */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void b(PARAM1 param1) {
                y.this.o(mapFunction.d(((g) triple.a()).getValue(), ((g) triple.b()).getValue(), ((g) triple.c()).getValue()));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Object obj) {
                b(obj);
                return m9.q.f35511a;
            }
        };
        yVar.p((LiveData) b10, new androidx.lifecycle.w() { // from class: com.android.incallui.mvvm.utils.j
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                IgnoreEqualsLiveDataKt.O(v9.l.this, obj);
            }
        });
        Object c10 = triple.c();
        kotlin.jvm.internal.i.d(c10, "null cannot be cast to non-null type androidx.lifecycle.LiveData<PARAM2 of com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt.transformNonNullMap$lambda$22>");
        final v9.l<PARAM2, m9.q> lVar3 = new v9.l<PARAM2, m9.q>() { // from class: com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt$transformNonNullMap$8$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (Lcom/android/incallui/mvvm/utils/y<TRETURN;>;Lv9/q<-TPARAM0;-TPARAM1;-TPARAM2;+TRETURN;>;TTRIPLE;)V */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void b(PARAM2 param2) {
                y.this.o(mapFunction.d(((g) triple.a()).getValue(), ((g) triple.b()).getValue(), ((g) triple.c()).getValue()));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Object obj) {
                b(obj);
                return m9.q.f35511a;
            }
        };
        yVar.p((LiveData) c10, new androidx.lifecycle.w() { // from class: com.android.incallui.mvvm.utils.k
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                IgnoreEqualsLiveDataKt.P(v9.l.this, obj);
            }
        });
        return yVar;
    }

    public static final <PARAM0, PARAM1, PARAM2, TRIPLE extends Triple<? extends h<PARAM0>, ? extends h<PARAM1>, ? extends h<PARAM2>>, RETURN> y<RETURN> B(final TRIPLE triple, boolean z10, final v9.q<? super PARAM0, ? super PARAM1, ? super PARAM2, ? extends RETURN> mapFunction) {
        kotlin.jvm.internal.i.f(triple, "<this>");
        kotlin.jvm.internal.i.f(mapFunction, "mapFunction");
        final y<RETURN> yVar = new y<>(mapFunction.d((Object) ((h) triple.a()).getValue(), (Object) ((h) triple.b()).getValue(), (Object) ((h) triple.c()).getValue()), z10);
        LiveData<S> liveData = (LiveData) triple.a();
        final v9.l<PARAM0, m9.q> lVar = new v9.l<PARAM0, m9.q>() { // from class: com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt$transformNonNullMap$7$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (Lcom/android/incallui/mvvm/utils/y<TRETURN;>;Lv9/q<-TPARAM0;-TPARAM1;-TPARAM2;+TRETURN;>;TTRIPLE;)V */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void b(PARAM0 param0) {
                y.this.o(mapFunction.d(((h) triple.a()).getValue(), ((h) triple.b()).getValue(), ((h) triple.c()).getValue()));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Object obj) {
                b(obj);
                return m9.q.f35511a;
            }
        };
        yVar.p(liveData, new androidx.lifecycle.w() { // from class: com.android.incallui.mvvm.utils.p
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                IgnoreEqualsLiveDataKt.K(v9.l.this, obj);
            }
        });
        LiveData<S> liveData2 = (LiveData) triple.b();
        final v9.l<PARAM1, m9.q> lVar2 = new v9.l<PARAM1, m9.q>() { // from class: com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt$transformNonNullMap$7$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (Lcom/android/incallui/mvvm/utils/y<TRETURN;>;Lv9/q<-TPARAM0;-TPARAM1;-TPARAM2;+TRETURN;>;TTRIPLE;)V */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void b(PARAM1 param1) {
                y.this.o(mapFunction.d(((h) triple.a()).getValue(), ((h) triple.b()).getValue(), ((h) triple.c()).getValue()));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Object obj) {
                b(obj);
                return m9.q.f35511a;
            }
        };
        yVar.p(liveData2, new androidx.lifecycle.w() { // from class: com.android.incallui.mvvm.utils.q
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                IgnoreEqualsLiveDataKt.L(v9.l.this, obj);
            }
        });
        LiveData<S> liveData3 = (LiveData) triple.c();
        final v9.l<PARAM2, m9.q> lVar3 = new v9.l<PARAM2, m9.q>() { // from class: com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt$transformNonNullMap$7$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (Lcom/android/incallui/mvvm/utils/y<TRETURN;>;Lv9/q<-TPARAM0;-TPARAM1;-TPARAM2;+TRETURN;>;TTRIPLE;)V */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void b(PARAM2 param2) {
                y.this.o(mapFunction.d(((h) triple.a()).getValue(), ((h) triple.b()).getValue(), ((h) triple.c()).getValue()));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Object obj) {
                b(obj);
                return m9.q.f35511a;
            }
        };
        yVar.p(liveData3, new androidx.lifecycle.w() { // from class: com.android.incallui.mvvm.utils.r
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                IgnoreEqualsLiveDataKt.M(v9.l.this, obj);
            }
        });
        return yVar;
    }

    public static /* synthetic */ y C(h hVar, boolean z10, v9.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return u(hVar, z10, lVar);
    }

    public static /* synthetic */ y D(y yVar, boolean z10, v9.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return v(yVar, z10, lVar);
    }

    public static /* synthetic */ y E(List list, boolean z10, InterfaceC1637a interfaceC1637a, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return x(list, z10, interfaceC1637a);
    }

    public static /* synthetic */ y F(Pair pair, boolean z10, v9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return z(pair, z10, pVar);
    }

    public static /* synthetic */ y G(Triple triple, boolean z10, v9.q qVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return B(triple, z10, qVar);
    }

    public static final void H(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void I(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void J(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void K(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void L(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void M(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void N(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void O(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void P(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Q(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void R(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void S(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void T(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void U(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void V(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final <T extends LiveData<?>> void q(T t10, InterfaceC0492o owner) {
        kotlin.jvm.internal.i.f(t10, "<this>");
        kotlin.jvm.internal.i.f(owner, "owner");
        t10.i(owner, new androidx.lifecycle.w() { // from class: com.android.incallui.mvvm.utils.o
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                IgnoreEqualsLiveDataKt.r(obj);
            }
        });
    }

    public static final <FIRST, SECOND, PAIR extends Pair<? extends FIRST, ? extends SECOND>, THIRD> Triple<FIRST, SECOND, THIRD> s(PAIR pair, THIRD third) {
        kotlin.jvm.internal.i.f(pair, "<this>");
        return new Triple<>(pair.c(), pair.d(), third);
    }

    public static final <X, Y> y<Y> t(LiveData<X> liveData, final Y y10, boolean z10, final v9.l<? super X, ? extends Y> mapFunction) {
        kotlin.jvm.internal.i.f(liveData, "<this>");
        kotlin.jvm.internal.i.f(mapFunction, "mapFunction");
        final y<Y> yVar = new y<>(y10, z10);
        final v9.l<X, m9.q> lVar = new v9.l<X, m9.q>() { // from class: com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt$transformNonNullMap$3$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void b(X x10) {
                Object invoke;
                LiveData liveData2 = yVar;
                if (x10 == null) {
                    invoke = y10;
                } else {
                    invoke = mapFunction.invoke(x10);
                }
                liveData2.o(invoke);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Object obj) {
                b(obj);
                return m9.q.f35511a;
            }
        };
        yVar.p(liveData, new androidx.lifecycle.w() { // from class: com.android.incallui.mvvm.utils.i
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                IgnoreEqualsLiveDataKt.T(v9.l.this, obj);
            }
        });
        return yVar;
    }

    public static final <X, Y> y<Y> u(h<X> hVar, boolean z10, final v9.l<? super X, ? extends Y> mapFunction) {
        kotlin.jvm.internal.i.f(hVar, "<this>");
        kotlin.jvm.internal.i.f(mapFunction, "mapFunction");
        final y<Y> yVar = new y<>(mapFunction.invoke(hVar.getValue()), z10);
        final v9.l<X, m9.q> lVar = new v9.l<X, m9.q>() { // from class: com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt$transformNonNullMap$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void b(X x10) {
                yVar.o(mapFunction.invoke(x10));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Object obj) {
                b(obj);
                return m9.q.f35511a;
            }
        };
        yVar.p(hVar, new androidx.lifecycle.w() { // from class: com.android.incallui.mvvm.utils.l
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                IgnoreEqualsLiveDataKt.H(v9.l.this, obj);
            }
        });
        return yVar;
    }

    public static final <X, Y> y<Y> v(y<X> yVar, boolean z10, final v9.l<? super X, ? extends Y> mapFunction) {
        kotlin.jvm.internal.i.f(yVar, "<this>");
        kotlin.jvm.internal.i.f(mapFunction, "mapFunction");
        final y<Y> yVar2 = new y<>(mapFunction.invoke(yVar.getValue()), z10);
        final v9.l<X, m9.q> lVar = new v9.l<X, m9.q>() { // from class: com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt$transformNonNullMap$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final void b(X x10) {
                yVar2.o(mapFunction.invoke(x10));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Object obj) {
                b(obj);
                return m9.q.f35511a;
            }
        };
        yVar2.p(yVar, new androidx.lifecycle.w() { // from class: com.android.incallui.mvvm.utils.v
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                IgnoreEqualsLiveDataKt.R(v9.l.this, obj);
            }
        });
        return yVar2;
    }

    public static final <LD extends LiveData<?>, Collect extends List<? extends LD>, RETURN> y<RETURN> w(Collect collect, RETURN r32, boolean z10, final InterfaceC1637a<? extends RETURN> mapFunction) {
        kotlin.jvm.internal.i.f(collect, "<this>");
        kotlin.jvm.internal.i.f(mapFunction, "mapFunction");
        final y<RETURN> yVar = new y<>(r32, z10);
        Iterator it = collect.iterator();
        while (it.hasNext()) {
            LiveData<S> liveData = (LiveData) it.next();
            final v9.l lVar = new v9.l() { // from class: com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt$transformNonNullMap$11$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public final void b(Object obj) {
                    yVar.o(mapFunction.invoke());
                }

                @Override // v9.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    b(obj);
                    return m9.q.f35511a;
                }
            };
            yVar.p(liveData, new androidx.lifecycle.w() { // from class: com.android.incallui.mvvm.utils.w
                @Override // androidx.lifecycle.w
                public final void onChanged(Object obj) {
                    IgnoreEqualsLiveDataKt.S(v9.l.this, obj);
                }
            });
        }
        return yVar;
    }

    public static final <LD extends LiveData<?>, Collect extends List<? extends LD>, RETURN> y<RETURN> x(Collect collect, boolean z10, final InterfaceC1637a<? extends RETURN> mapFunction) {
        kotlin.jvm.internal.i.f(collect, "<this>");
        kotlin.jvm.internal.i.f(mapFunction, "mapFunction");
        final y<RETURN> yVar = new y<>(mapFunction.invoke(), z10);
        Iterator it = collect.iterator();
        while (it.hasNext()) {
            LiveData<S> liveData = (LiveData) it.next();
            final v9.l lVar = new v9.l() { // from class: com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt$transformNonNullMap$10$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public final void b(Object obj) {
                    yVar.o(mapFunction.invoke());
                }

                @Override // v9.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    b(obj);
                    return m9.q.f35511a;
                }
            };
            yVar.p(liveData, new androidx.lifecycle.w() { // from class: com.android.incallui.mvvm.utils.s
                @Override // androidx.lifecycle.w
                public final void onChanged(Object obj) {
                    IgnoreEqualsLiveDataKt.Q(v9.l.this, obj);
                }
            });
        }
        return yVar;
    }

    public static final <PARAM0, PARAM1, PAIR extends Pair<? extends g<PARAM0>, ? extends g<PARAM1>>, RETURN> y<RETURN> y(final PAIR pair, RETURN r32, boolean z10, final v9.p<? super PARAM0, ? super PARAM1, ? extends RETURN> mapFunction) {
        kotlin.jvm.internal.i.f(pair, "<this>");
        kotlin.jvm.internal.i.f(mapFunction, "mapFunction");
        final y<RETURN> yVar = new y<>(r32, z10);
        Object c10 = pair.c();
        kotlin.jvm.internal.i.d(c10, "null cannot be cast to non-null type androidx.lifecycle.LiveData<PARAM0 of com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt.transformNonNullMap$lambda$11>");
        final v9.l<PARAM0, m9.q> lVar = new v9.l<PARAM0, m9.q>() { // from class: com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt$transformNonNullMap$5$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (Lcom/android/incallui/mvvm/utils/y<TRETURN;>;Lv9/p<-TPARAM0;-TPARAM1;+TRETURN;>;TPAIR;)V */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void b(PARAM0 param0) {
                y.this.o(mapFunction.invoke(((g) pair.c()).getValue(), ((g) pair.d()).getValue()));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Object obj) {
                b(obj);
                return m9.q.f35511a;
            }
        };
        yVar.p((LiveData) c10, new androidx.lifecycle.w() { // from class: com.android.incallui.mvvm.utils.m
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                IgnoreEqualsLiveDataKt.J(v9.l.this, obj);
            }
        });
        Object d10 = pair.d();
        kotlin.jvm.internal.i.d(d10, "null cannot be cast to non-null type androidx.lifecycle.LiveData<PARAM1 of com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt.transformNonNullMap$lambda$11>");
        final v9.l<PARAM1, m9.q> lVar2 = new v9.l<PARAM1, m9.q>() { // from class: com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt$transformNonNullMap$5$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (Lcom/android/incallui/mvvm/utils/y<TRETURN;>;Lv9/p<-TPARAM0;-TPARAM1;+TRETURN;>;TPAIR;)V */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void b(PARAM1 param1) {
                y.this.o(mapFunction.invoke(((g) pair.c()).getValue(), ((g) pair.d()).getValue()));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Object obj) {
                b(obj);
                return m9.q.f35511a;
            }
        };
        yVar.p((LiveData) d10, new androidx.lifecycle.w() { // from class: com.android.incallui.mvvm.utils.n
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                IgnoreEqualsLiveDataKt.I(v9.l.this, obj);
            }
        });
        return yVar;
    }

    public static final <PARAM0, PARAM1, PAIR extends Pair<? extends g<PARAM0>, ? extends g<PARAM1>>, RETURN> y<RETURN> z(final PAIR pair, boolean z10, final v9.p<? super PARAM0, ? super PARAM1, ? extends RETURN> mapFunction) {
        kotlin.jvm.internal.i.f(pair, "<this>");
        kotlin.jvm.internal.i.f(mapFunction, "mapFunction");
        final y<RETURN> yVar = new y<>(mapFunction.invoke((Object) ((g) pair.c()).getValue(), (Object) ((g) pair.d()).getValue()), z10);
        Object c10 = pair.c();
        kotlin.jvm.internal.i.d(c10, "null cannot be cast to non-null type androidx.lifecycle.LiveData<PARAM0 of com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt.transformNonNullMap$lambda$8>");
        final v9.l<PARAM0, m9.q> lVar = new v9.l<PARAM0, m9.q>() { // from class: com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt$transformNonNullMap$4$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (Lcom/android/incallui/mvvm/utils/y<TRETURN;>;Lv9/p<-TPARAM0;-TPARAM1;+TRETURN;>;TPAIR;)V */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void b(PARAM0 param0) {
                y.this.o(mapFunction.invoke(((g) pair.c()).getValue(), ((g) pair.d()).getValue()));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Object obj) {
                b(obj);
                return m9.q.f35511a;
            }
        };
        yVar.p((LiveData) c10, new androidx.lifecycle.w() { // from class: com.android.incallui.mvvm.utils.t
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                IgnoreEqualsLiveDataKt.U(v9.l.this, obj);
            }
        });
        Object d10 = pair.d();
        kotlin.jvm.internal.i.d(d10, "null cannot be cast to non-null type androidx.lifecycle.LiveData<PARAM1 of com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt.transformNonNullMap$lambda$8>");
        final v9.l<PARAM1, m9.q> lVar2 = new v9.l<PARAM1, m9.q>() { // from class: com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt$transformNonNullMap$4$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (Lcom/android/incallui/mvvm/utils/y<TRETURN;>;Lv9/p<-TPARAM0;-TPARAM1;+TRETURN;>;TPAIR;)V */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void b(PARAM1 param1) {
                y.this.o(mapFunction.invoke(((g) pair.c()).getValue(), ((g) pair.d()).getValue()));
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Object obj) {
                b(obj);
                return m9.q.f35511a;
            }
        };
        yVar.p((LiveData) d10, new androidx.lifecycle.w() { // from class: com.android.incallui.mvvm.utils.u
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                IgnoreEqualsLiveDataKt.V(v9.l.this, obj);
            }
        });
        return yVar;
    }

    public static final void r(Object obj) {
    }
}

package com.android.contacts.framework.omoji.view;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.C1239d0;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import v9.InterfaceC1637a;

/* compiled from: AlphaMovieView.kt */
/* loaded from: classes.dex */
public final class AlphaMovieView$mTaskDispatcher$2 extends Lambda implements InterfaceC1637a<ExecutorCoroutineDispatcher> {

    /* renamed from: a, reason: collision with root package name */
    public static final AlphaMovieView$mTaskDispatcher$2 f16226a = new AlphaMovieView$mTaskDispatcher$2();

    public AlphaMovieView$mTaskDispatcher$2() {
        super(0);
    }

    public static final Thread e(Runnable runnable) {
        return new Thread(runnable, "Media player Task");
    }

    @Override // v9.InterfaceC1637a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final ExecutorCoroutineDispatcher invoke() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.android.contacts.framework.omoji.view.d
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread e10;
                e10 = AlphaMovieView$mTaskDispatcher$2.e(runnable);
                return e10;
            }
        });
        kotlin.jvm.internal.i.e(newSingleThreadExecutor, "newSingleThreadExecutor …r, \"Media player Task\") }");
        return C1239d0.b(newSingleThreadExecutor);
    }
}

package androidx.window.layout;

import android.app.Activity;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: WindowInfoTrackerImpl.kt */
@InterfaceC1470d(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", l = {54, 55}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class WindowInfoTrackerImpl$windowLayoutInfo$1 extends SuspendLambda implements p<kotlinx.coroutines.flow.b<? super WindowLayoutInfo>, c<? super q>, Object> {
    final /* synthetic */ Activity $activity;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ WindowInfoTrackerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowInfoTrackerImpl$windowLayoutInfo$1(WindowInfoTrackerImpl windowInfoTrackerImpl, Activity activity, c<? super WindowInfoTrackerImpl$windowLayoutInfo$1> cVar) {
        super(2, cVar);
        this.this$0 = windowInfoTrackerImpl;
        this.$activity = activity;
    }

    public static final void j(kotlinx.coroutines.channels.a aVar, WindowLayoutInfo info) {
        i.e(info, "info");
        aVar.j(info);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        WindowInfoTrackerImpl$windowLayoutInfo$1 windowInfoTrackerImpl$windowLayoutInfo$1 = new WindowInfoTrackerImpl$windowLayoutInfo$1(this.this$0, this.$activity, cVar);
        windowInfoTrackerImpl$windowLayoutInfo$1.L$0 = obj;
        return windowInfoTrackerImpl$windowLayoutInfo$1;
    }

    @Override // v9.p
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final Object invoke(kotlinx.coroutines.flow.b<? super WindowLayoutInfo> bVar, c<? super q> cVar) {
        return ((WindowInfoTrackerImpl$windowLayoutInfo$1) create(bVar, cVar)).invokeSuspend(q.f35511a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007e A[Catch: all -> 0x001f, TRY_LEAVE, TryCatch #0 {all -> 0x001f, blocks: (B:7:0x001a, B:9:0x0064, B:14:0x0076, B:16:0x007e, B:25:0x0036, B:27:0x0060), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0093  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0090 -> B:8:0x001d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.c()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3a
            if (r1 == r3) goto L2a
            if (r1 != r2) goto L22
            java.lang.Object r1 = r9.L$2
            kotlinx.coroutines.channels.c r1 = (kotlinx.coroutines.channels.c) r1
            java.lang.Object r4 = r9.L$1
            I.a r4 = (I.a) r4
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.flow.b r5 = (kotlinx.coroutines.flow.b) r5
            kotlin.b.b(r10)     // Catch: java.lang.Throwable -> L1f
        L1d:
            r10 = r5
            goto L64
        L1f:
            r10 = move-exception
            goto L9f
        L22:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L2a:
            java.lang.Object r1 = r9.L$2
            kotlinx.coroutines.channels.c r1 = (kotlinx.coroutines.channels.c) r1
            java.lang.Object r4 = r9.L$1
            I.a r4 = (I.a) r4
            java.lang.Object r5 = r9.L$0
            kotlinx.coroutines.flow.b r5 = (kotlinx.coroutines.flow.b) r5
            kotlin.b.b(r10)     // Catch: java.lang.Throwable -> L1f
            goto L76
        L3a:
            kotlin.b.b(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.flow.b r10 = (kotlinx.coroutines.flow.b) r10
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST
            r4 = 4
            r5 = 10
            r6 = 0
            kotlinx.coroutines.channels.a r1 = kotlinx.coroutines.channels.d.b(r5, r1, r6, r4, r6)
            androidx.window.layout.b r4 = new androidx.window.layout.b
            r4.<init>()
            androidx.window.layout.WindowInfoTrackerImpl r5 = r9.this$0
            androidx.window.layout.WindowBackend r5 = androidx.window.layout.WindowInfoTrackerImpl.c(r5)
            android.app.Activity r6 = r9.$activity
            Z.d r7 = new Z.d
            r7.<init>()
            r5.b(r6, r7, r4)
            kotlinx.coroutines.channels.c r1 = r1.iterator()     // Catch: java.lang.Throwable -> L1f
        L64:
            r9.L$0 = r10     // Catch: java.lang.Throwable -> L1f
            r9.L$1 = r4     // Catch: java.lang.Throwable -> L1f
            r9.L$2 = r1     // Catch: java.lang.Throwable -> L1f
            r9.label = r3     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r5 = r1.a(r9)     // Catch: java.lang.Throwable -> L1f
            if (r5 != r0) goto L73
            return r0
        L73:
            r8 = r5
            r5 = r10
            r10 = r8
        L76:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> L1f
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> L1f
            if (r10 == 0) goto L93
            java.lang.Object r10 = r1.next()     // Catch: java.lang.Throwable -> L1f
            androidx.window.layout.WindowLayoutInfo r10 = (androidx.window.layout.WindowLayoutInfo) r10     // Catch: java.lang.Throwable -> L1f
            r9.L$0 = r5     // Catch: java.lang.Throwable -> L1f
            r9.L$1 = r4     // Catch: java.lang.Throwable -> L1f
            r9.L$2 = r1     // Catch: java.lang.Throwable -> L1f
            r9.label = r2     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r10 = r5.emit(r10, r9)     // Catch: java.lang.Throwable -> L1f
            if (r10 != r0) goto L1d
            return r0
        L93:
            androidx.window.layout.WindowInfoTrackerImpl r9 = r9.this$0
            androidx.window.layout.WindowBackend r9 = androidx.window.layout.WindowInfoTrackerImpl.c(r9)
            r9.a(r4)
            m9.q r9 = m9.q.f35511a
            return r9
        L9f:
            androidx.window.layout.WindowInfoTrackerImpl r9 = r9.this$0
            androidx.window.layout.WindowBackend r9 = androidx.window.layout.WindowInfoTrackerImpl.c(r9)
            r9.a(r4)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

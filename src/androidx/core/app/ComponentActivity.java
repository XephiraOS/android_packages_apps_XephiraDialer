package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.C0456k;
import androidx.lifecycle.B;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.q;

/* compiled from: ComponentActivity.kt */
/* loaded from: classes.dex */
public class ComponentActivity extends Activity implements InterfaceC0492o, C0456k.a {
    private final p.i<Class<? extends a>, a> extraDataMap = new p.i<>(0, 1, null);
    private final q lifecycleRegistry = new q(this);

    /* compiled from: ComponentActivity.kt */
    /* loaded from: classes.dex */
    public static class a {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x000e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean shouldSkipDump(java.lang.String[] r3) {
        /*
            r2 = this;
            r2 = 0
            if (r3 == 0) goto L43
            int r0 = r3.length
            if (r0 != 0) goto L7
            goto L43
        L7:
            r3 = r3[r2]
            int r0 = r3.hashCode()
            r1 = 1
            switch(r0) {
                case -645125871: goto L39;
                case 100470631: goto L2f;
                case 472614934: goto L26;
                case 1159329357: goto L1c;
                case 1455016274: goto L12;
                default: goto L11;
            }
        L11:
            goto L43
        L12:
            java.lang.String r0 = "--autofill"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L1b
            goto L43
        L1b:
            return r1
        L1c:
            java.lang.String r0 = "--contentcapture"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L25
            goto L43
        L25:
            return r1
        L26:
            java.lang.String r0 = "--list-dumpables"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L38
            goto L43
        L2f:
            java.lang.String r0 = "--dump-dumpable"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L38
            goto L43
        L38:
            return r1
        L39:
            java.lang.String r0 = "--translation"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L42
            goto L43
        L42:
            return r1
        L43:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.ComponentActivity.shouldSkipDump(java.lang.String[]):boolean");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        kotlin.jvm.internal.i.f(event, "event");
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.i.e(decorView, "window.decorView");
        if (C0456k.a(decorView, event)) {
            return true;
        }
        return C0456k.b(this, decorView, this, event);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        kotlin.jvm.internal.i.f(event, "event");
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.i.e(decorView, "window.decorView");
        if (C0456k.a(decorView, event)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(event);
    }

    public <T extends a> T getExtraData(Class<T> extraDataClass) {
        kotlin.jvm.internal.i.f(extraDataClass, "extraDataClass");
        return (T) this.extraDataMap.get(extraDataClass);
    }

    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        B.f10233b.b(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.i.f(outState, "outState");
        this.lifecycleRegistry.n(Lifecycle.State.CREATED);
        super.onSaveInstanceState(outState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void putExtraData(a extraData) {
        kotlin.jvm.internal.i.f(extraData, "extraData");
        this.extraDataMap.put(extraData.getClass(), extraData);
    }

    public final boolean shouldDumpInternalState(String[] strArr) {
        return !shouldSkipDump(strArr);
    }

    @Override // androidx.core.view.C0456k.a
    public boolean superDispatchKeyEvent(KeyEvent event) {
        kotlin.jvm.internal.i.f(event, "event");
        return super.dispatchKeyEvent(event);
    }

    private static /* synthetic */ void getExtraDataMap$annotations() {
    }

    private static /* synthetic */ void getLifecycleRegistry$annotations() {
    }
}

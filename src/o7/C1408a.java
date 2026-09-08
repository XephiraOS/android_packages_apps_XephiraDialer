package o7;

import android.util.Log;
import kotlin.jvm.internal.f;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.m;
import kotlinx.coroutines.flow.n;

/* compiled from: EditModeManager.kt */
/* renamed from: o7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1408a {

    /* renamed from: c, reason: collision with root package name */
    public static final C0337a f35774c = new C0337a(null);

    /* renamed from: a, reason: collision with root package name */
    public final i<Boolean> f35775a;

    /* renamed from: b, reason: collision with root package name */
    public final m<Boolean> f35776b;

    /* compiled from: EditModeManager.kt */
    /* renamed from: o7.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0337a {
        public C0337a() {
        }

        public /* synthetic */ C0337a(f fVar) {
            this();
        }
    }

    public C1408a() {
        i<Boolean> a10 = n.a(Boolean.FALSE);
        this.f35775a = a10;
        this.f35776b = a10;
    }

    public m<Boolean> a() {
        return this.f35776b;
    }

    public void b(boolean z10) {
        Log.i("EditModeManager", "updateEditMode: new editMode " + z10);
        this.f35775a.setValue(Boolean.valueOf(z10));
    }
}

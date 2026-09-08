package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import androidx.window.core.SpecificationComputer;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.HardwareFoldingFeature;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.o;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import v9.l;

/* compiled from: SidecarAdapter.kt */
/* loaded from: classes.dex */
public final class SidecarAdapter {

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f12023b = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final String f12024c = SidecarAdapter.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    public final SpecificationComputer.VerificationMode f12025a;

    /* compiled from: SidecarAdapter.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final int a(SidecarDeviceState sidecarDeviceState) {
            i.f(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    return sidecarDeviceState.posture;
                } catch (NoSuchFieldError unused) {
                    Object invoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                    if (invoke != null) {
                        return ((Integer) invoke).intValue();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return 0;
            }
        }

        public final int b(SidecarDeviceState sidecarDeviceState) {
            i.f(sidecarDeviceState, "sidecarDeviceState");
            int a10 = a(sidecarDeviceState);
            if (a10 < 0 || a10 > 4) {
                return 0;
            }
            return a10;
        }

        public final List<SidecarDisplayFeature> c(SidecarWindowLayoutInfo info) {
            List<SidecarDisplayFeature> h10;
            List<SidecarDisplayFeature> h11;
            i.f(info, "info");
            try {
                try {
                    List<SidecarDisplayFeature> list = info.displayFeatures;
                    if (list == null) {
                        h11 = o.h();
                        return h11;
                    }
                    return list;
                } catch (NoSuchFieldError unused) {
                    Object invoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(info, null);
                    if (invoke != null) {
                        return (List) invoke;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                h10 = o.h();
                return h10;
            }
        }

        public final void d(SidecarDeviceState sidecarDeviceState, int i10) {
            i.f(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    sidecarDeviceState.posture = i10;
                } catch (NoSuchFieldError unused) {
                    SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, Integer.valueOf(i10));
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SidecarAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final boolean a(SidecarDeviceState sidecarDeviceState, SidecarDeviceState sidecarDeviceState2) {
        if (i.b(sidecarDeviceState, sidecarDeviceState2)) {
            return true;
        }
        if (sidecarDeviceState == null || sidecarDeviceState2 == null) {
            return false;
        }
        Companion companion = f12023b;
        if (companion.b(sidecarDeviceState) == companion.b(sidecarDeviceState2)) {
            return true;
        }
        return false;
    }

    public final boolean b(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (i.b(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return i.b(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    public final boolean c(List<SidecarDisplayFeature> list, List<SidecarDisplayFeature> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!b(list.get(i10), list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public final boolean d(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarWindowLayoutInfo sidecarWindowLayoutInfo2) {
        if (i.b(sidecarWindowLayoutInfo, sidecarWindowLayoutInfo2)) {
            return true;
        }
        if (sidecarWindowLayoutInfo == null || sidecarWindowLayoutInfo2 == null) {
            return false;
        }
        Companion companion = f12023b;
        return c(companion.c(sidecarWindowLayoutInfo), companion.c(sidecarWindowLayoutInfo2));
    }

    public final WindowLayoutInfo e(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState state) {
        List h10;
        i.f(state, "state");
        if (sidecarWindowLayoutInfo == null) {
            h10 = o.h();
            return new WindowLayoutInfo(h10);
        }
        SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
        Companion companion = f12023b;
        companion.d(sidecarDeviceState, companion.b(state));
        return new WindowLayoutInfo(f(companion.c(sidecarWindowLayoutInfo), sidecarDeviceState));
    }

    public final List<DisplayFeature> f(List<SidecarDisplayFeature> sidecarDisplayFeatures, SidecarDeviceState deviceState) {
        i.f(sidecarDisplayFeatures, "sidecarDisplayFeatures");
        i.f(deviceState, "deviceState");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = sidecarDisplayFeatures.iterator();
        while (it.hasNext()) {
            DisplayFeature g10 = g((SidecarDisplayFeature) it.next(), deviceState);
            if (g10 != null) {
                arrayList.add(g10);
            }
        }
        return arrayList;
    }

    public final DisplayFeature g(SidecarDisplayFeature feature, SidecarDeviceState deviceState) {
        HardwareFoldingFeature.Type a10;
        FoldingFeature.State state;
        i.f(feature, "feature");
        i.f(deviceState, "deviceState");
        SpecificationComputer.Companion companion = SpecificationComputer.f11915a;
        String TAG = f12024c;
        i.e(TAG, "TAG");
        SidecarDisplayFeature sidecarDisplayFeature = (SidecarDisplayFeature) SpecificationComputer.Companion.b(companion, feature, TAG, this.f12025a, null, 4, null).c("Type must be either TYPE_FOLD or TYPE_HINGE", new l<SidecarDisplayFeature, Boolean>() { // from class: androidx.window.layout.SidecarAdapter$translate$checkedFeature$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(SidecarDisplayFeature require) {
                i.f(require, "$this$require");
                boolean z10 = true;
                if (require.getType() != 1 && require.getType() != 2) {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }).c("Feature bounds must not be 0", new l<SidecarDisplayFeature, Boolean>() { // from class: androidx.window.layout.SidecarAdapter$translate$checkedFeature$2
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(SidecarDisplayFeature require) {
                boolean z10;
                i.f(require, "$this$require");
                if (require.getRect().width() == 0 && require.getRect().height() == 0) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }
        }).c("TYPE_FOLD must have 0 area", new l<SidecarDisplayFeature, Boolean>() { // from class: androidx.window.layout.SidecarAdapter$translate$checkedFeature$3
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(SidecarDisplayFeature require) {
                i.f(require, "$this$require");
                boolean z10 = true;
                if (require.getType() == 1 && require.getRect().width() != 0 && require.getRect().height() != 0) {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }).c("Feature be pinned to either left or top", new l<SidecarDisplayFeature, Boolean>() { // from class: androidx.window.layout.SidecarAdapter$translate$checkedFeature$4
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(SidecarDisplayFeature require) {
                boolean z10;
                i.f(require, "$this$require");
                if (require.getRect().left != 0 && require.getRect().top != 0) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }
        }).a();
        if (sidecarDisplayFeature == null) {
            return null;
        }
        int type = sidecarDisplayFeature.getType();
        if (type != 1) {
            if (type != 2) {
                return null;
            }
            a10 = HardwareFoldingFeature.Type.f12017b.b();
        } else {
            a10 = HardwareFoldingFeature.Type.f12017b.a();
        }
        int b10 = f12023b.b(deviceState);
        if (b10 == 0 || b10 == 1) {
            return null;
        }
        if (b10 != 2) {
            if (b10 != 3) {
                if (b10 == 4) {
                    return null;
                }
                state = FoldingFeature.State.f12010c;
            } else {
                state = FoldingFeature.State.f12010c;
            }
        } else {
            state = FoldingFeature.State.f12011d;
        }
        Rect rect = feature.getRect();
        i.e(rect, "feature.rect");
        return new HardwareFoldingFeature(new Bounds(rect), a10, state);
    }

    public SidecarAdapter(SpecificationComputer.VerificationMode verificationMode) {
        i.f(verificationMode, "verificationMode");
        this.f12025a = verificationMode;
    }

    public /* synthetic */ SidecarAdapter(SpecificationComputer.VerificationMode verificationMode, int i10, f fVar) {
        this((i10 & 1) != 0 ? SpecificationComputer.VerificationMode.QUIET : verificationMode);
    }
}

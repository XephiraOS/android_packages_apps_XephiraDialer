package androidx.customview.widget;

import J.d;
import J.e;
import J.f;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.C0446a;
import androidx.core.view.K;
import androidx.customview.widget.b;
import com.heytap.accessory.constant.FastPairConstants;
import java.util.ArrayList;
import java.util.List;
import p.j;

/* compiled from: ExploreByTouchHelper.java */
/* loaded from: classes.dex */
public abstract class a extends C0446a {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final b.a<d> NODE_ADAPTER = new C0113a();
    private static final b.InterfaceC0114b<j<d>, d> SPARSE_VALUES_ADAPTER = new b();
    private final View mHost;
    private final AccessibilityManager mManager;
    private c mNodeProvider;
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();
    private final int[] mTempGlobalRect = new int[2];
    int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;

    /* compiled from: ExploreByTouchHelper.java */
    /* renamed from: androidx.customview.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0113a implements b.a<d> {
        @Override // androidx.customview.widget.b.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(d dVar, Rect rect) {
            dVar.k(rect);
        }
    }

    /* compiled from: ExploreByTouchHelper.java */
    /* loaded from: classes.dex */
    public class b implements b.InterfaceC0114b<j<d>, d> {
        @Override // androidx.customview.widget.b.InterfaceC0114b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public d a(j<d> jVar, int i10) {
            return jVar.j(i10);
        }

        @Override // androidx.customview.widget.b.InterfaceC0114b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int b(j<d> jVar) {
            return jVar.i();
        }
    }

    /* compiled from: ExploreByTouchHelper.java */
    /* loaded from: classes.dex */
    public class c extends e {
        public c() {
        }

        @Override // J.e
        public d b(int i10) {
            return d.W(a.this.obtainAccessibilityNodeInfo(i10));
        }

        @Override // J.e
        public d d(int i10) {
            int i11;
            if (i10 == 2) {
                i11 = a.this.mAccessibilityFocusedVirtualViewId;
            } else {
                i11 = a.this.mKeyboardFocusedVirtualViewId;
            }
            if (i11 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i11);
        }

        @Override // J.e
        public boolean f(int i10, int i11, Bundle bundle) {
            return a.this.performAction(i10, i11, bundle);
        }
    }

    public a(View view) {
        if (view != null) {
            this.mHost = view;
            this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (K.t(view) == 0) {
                K.t0(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean clearAccessibilityFocus(int i10) {
        if (this.mAccessibilityFocusedVirtualViewId == i10) {
            this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
            this.mHost.invalidate();
            sendEventForVirtualView(i10, 65536);
            return true;
        }
        return false;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int i10 = this.mKeyboardFocusedVirtualViewId;
        if (i10 != Integer.MIN_VALUE && onPerformActionForVirtualView(i10, 16, null)) {
            return true;
        }
        return false;
    }

    private AccessibilityEvent createEvent(int i10, int i11) {
        if (i10 != -1) {
            return createEventForChild(i10, i11);
        }
        return createEventForHost(i11);
    }

    private AccessibilityEvent createEventForChild(int i10, int i11) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i11);
        d obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i10);
        obtain.getText().add(obtainAccessibilityNodeInfo.y());
        obtain.setContentDescription(obtainAccessibilityNodeInfo.r());
        obtain.setScrollable(obtainAccessibilityNodeInfo.Q());
        obtain.setPassword(obtainAccessibilityNodeInfo.P());
        obtain.setEnabled(obtainAccessibilityNodeInfo.J());
        obtain.setChecked(obtainAccessibilityNodeInfo.G());
        onPopulateEventForVirtualView(i10, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(obtainAccessibilityNodeInfo.o());
        f.c(obtain, this.mHost, i10);
        obtain.setPackageName(this.mHost.getContext().getPackageName());
        return obtain;
    }

    private AccessibilityEvent createEventForHost(int i10) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i10);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private d createNodeForChild(int i10) {
        boolean z10;
        d V10 = d.V();
        V10.n0(true);
        V10.p0(true);
        V10.h0(DEFAULT_CLASS_NAME);
        Rect rect = INVALID_PARENT_BOUNDS;
        V10.c0(rect);
        V10.d0(rect);
        V10.z0(this.mHost);
        onPopulateNodeForVirtualView(i10, V10);
        if (V10.y() == null && V10.r() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        V10.k(this.mTempParentRect);
        if (!this.mTempParentRect.equals(rect)) {
            int i11 = V10.i();
            if ((i11 & 64) == 0) {
                if ((i11 & 128) == 0) {
                    V10.x0(this.mHost.getContext().getPackageName());
                    V10.I0(this.mHost, i10);
                    if (this.mAccessibilityFocusedVirtualViewId == i10) {
                        V10.b0(true);
                        V10.a(128);
                    } else {
                        V10.b0(false);
                        V10.a(64);
                    }
                    if (this.mKeyboardFocusedVirtualViewId == i10) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        V10.a(2);
                    } else if (V10.K()) {
                        V10.a(1);
                    }
                    V10.q0(z10);
                    this.mHost.getLocationOnScreen(this.mTempGlobalRect);
                    V10.l(this.mTempScreenRect);
                    if (this.mTempScreenRect.equals(rect)) {
                        V10.k(this.mTempScreenRect);
                        if (V10.f1366b != -1) {
                            d V11 = d.V();
                            for (int i12 = V10.f1366b; i12 != -1; i12 = V11.f1366b) {
                                V11.A0(this.mHost, -1);
                                V11.c0(INVALID_PARENT_BOUNDS);
                                onPopulateNodeForVirtualView(i12, V11);
                                V11.k(this.mTempParentRect);
                                Rect rect2 = this.mTempScreenRect;
                                Rect rect3 = this.mTempParentRect;
                                rect2.offset(rect3.left, rect3.top);
                            }
                            V11.Z();
                        }
                        this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                    }
                    if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                        this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                        if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                            V10.d0(this.mTempScreenRect);
                            if (isVisibleToUser(this.mTempScreenRect)) {
                                V10.M0(true);
                            }
                        }
                    }
                    return V10;
                }
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    private d createNodeForHost() {
        d X10 = d.X(this.mHost);
        K.W(this.mHost, X10);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (X10.n() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            X10.d(this.mHost, ((Integer) arrayList.get(i10)).intValue());
        }
        return X10;
    }

    private j<d> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        j<d> jVar = new j<>();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            jVar.g(arrayList.get(i10).intValue(), createNodeForChild(arrayList.get(i10).intValue()));
        }
        return jVar;
    }

    private void getBoundsInParent(int i10, Rect rect) {
        obtainAccessibilityNodeInfo(i10).k(rect);
    }

    private static Rect guessPreviouslyFocusedRect(View view, int i10, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i10 != 17) {
            if (i10 != 33) {
                if (i10 != 66) {
                    if (i10 == 130) {
                        rect.set(0, -1, width, -1);
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    rect.set(-1, 0, -1, height);
                }
            } else {
                rect.set(0, height, width, height);
            }
        } else {
            rect.set(width, 0, width, height);
        }
        return rect;
    }

    private boolean isVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent == null) {
            return false;
        }
        return true;
    }

    private static int keyToDirection(int i10) {
        if (i10 != 19) {
            if (i10 != 21) {
                if (i10 != 22) {
                    return 130;
                }
                return 66;
            }
            return 17;
        }
        return 33;
    }

    private boolean moveFocus(int i10, Rect rect) {
        d d10;
        boolean z10;
        d dVar;
        j<d> allNodes = getAllNodes();
        int i11 = this.mKeyboardFocusedVirtualViewId;
        int i12 = Integer.MIN_VALUE;
        if (i11 == Integer.MIN_VALUE) {
            d10 = null;
        } else {
            d10 = allNodes.d(i11);
        }
        d dVar2 = d10;
        if (i10 != 1 && i10 != 2) {
            if (i10 != 17 && i10 != 33 && i10 != 66 && i10 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i13 = this.mKeyboardFocusedVirtualViewId;
            if (i13 != Integer.MIN_VALUE) {
                getBoundsInParent(i13, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                guessPreviouslyFocusedRect(this.mHost, i10, rect2);
            }
            dVar = (d) androidx.customview.widget.b.c(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, dVar2, rect2, i10);
        } else {
            if (K.v(this.mHost) == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            dVar = (d) androidx.customview.widget.b.d(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, dVar2, i10, z10, false);
        }
        if (dVar != null) {
            i12 = allNodes.f(allNodes.e(dVar));
        }
        return requestKeyboardFocusForVirtualView(i12);
    }

    private boolean performActionForChild(int i10, int i11, Bundle bundle) {
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 64) {
                    if (i11 != 128) {
                        return onPerformActionForVirtualView(i10, i11, bundle);
                    }
                    return clearAccessibilityFocus(i10);
                }
                return requestAccessibilityFocus(i10);
            }
            return clearKeyboardFocusForVirtualView(i10);
        }
        return requestKeyboardFocusForVirtualView(i10);
    }

    private boolean performActionForHost(int i10, Bundle bundle) {
        return K.Y(this.mHost, i10, bundle);
    }

    private boolean requestAccessibilityFocus(int i10) {
        int i11;
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || (i11 = this.mAccessibilityFocusedVirtualViewId) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            clearAccessibilityFocus(i11);
        }
        this.mAccessibilityFocusedVirtualViewId = i10;
        this.mHost.invalidate();
        sendEventForVirtualView(i10, FastPairConstants.PAIR_TYPE_BLE_IN_PAIR);
        return true;
    }

    private void updateHoveredVirtualView(int i10) {
        int i11 = this.mHoveredVirtualViewId;
        if (i11 == i10) {
            return;
        }
        this.mHoveredVirtualViewId = i10;
        sendEventForVirtualView(i10, 128);
        sendEventForVirtualView(i11, 256);
    }

    public final boolean clearKeyboardFocusForVirtualView(int i10) {
        if (this.mKeyboardFocusedVirtualViewId != i10) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i10, false);
        sendEventForVirtualView(i10, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7 && action != 9) {
            if (action != 10 || this.mHoveredVirtualViewId == Integer.MIN_VALUE) {
                return false;
            }
            updateHoveredVirtualView(Integer.MIN_VALUE);
            return true;
        }
        int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
        updateHoveredVirtualView(virtualViewAt);
        if (virtualViewAt == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i10 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int keyToDirection = keyToDirection(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z10 = false;
                        while (i10 < repeatCount && moveFocus(keyToDirection, null)) {
                            i10++;
                            z10 = true;
                        }
                        return z10;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            clickKeyboardFocusedVirtualView();
            return true;
        }
        if (keyEvent.hasNoModifiers()) {
            return moveFocus(2, null);
        }
        if (!keyEvent.hasModifiers(1)) {
            return false;
        }
        return moveFocus(1, null);
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    @Override // androidx.core.view.C0446a
    public e getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new c();
        }
        return this.mNodeProvider;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    public abstract int getVirtualViewAt(float f10, float f11);

    public abstract void getVisibleVirtualViews(List<Integer> list);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i10) {
        invalidateVirtualView(i10, 0);
    }

    public d obtainAccessibilityNodeInfo(int i10) {
        if (i10 == -1) {
            return createNodeForHost();
        }
        return createNodeForChild(i10);
    }

    public final void onFocusChanged(boolean z10, int i10, Rect rect) {
        int i11 = this.mKeyboardFocusedVirtualViewId;
        if (i11 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i11);
        }
        if (z10) {
            moveFocus(i10, rect);
        }
    }

    @Override // androidx.core.view.C0446a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    @Override // androidx.core.view.C0446a
    public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
        super.onInitializeAccessibilityNodeInfo(view, dVar);
        onPopulateNodeForHost(dVar);
    }

    public abstract boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle);

    public abstract void onPopulateNodeForVirtualView(int i10, d dVar);

    public boolean performAction(int i10, int i11, Bundle bundle) {
        if (i10 != -1) {
            return performActionForChild(i10, i11, bundle);
        }
        return performActionForHost(i11, bundle);
    }

    public final boolean requestKeyboardFocusForVirtualView(int i10) {
        int i11;
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || (i11 = this.mKeyboardFocusedVirtualViewId) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i11);
        }
        if (i10 == Integer.MIN_VALUE) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = i10;
        onVirtualViewKeyboardFocusChanged(i10, true);
        sendEventForVirtualView(i10, 8);
        return true;
    }

    public final boolean sendEventForVirtualView(int i10, int i11) {
        ViewParent parent;
        if (i10 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.mHost, createEvent(i10, i11));
    }

    public final void invalidateVirtualView(int i10, int i11) {
        ViewParent parent;
        if (i10 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return;
        }
        AccessibilityEvent createEvent = createEvent(i10, 2048);
        J.b.b(createEvent, i11);
        parent.requestSendAccessibilityEvent(this.mHost, createEvent);
    }

    public void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateNodeForHost(d dVar) {
    }

    public void onPopulateEventForVirtualView(int i10, AccessibilityEvent accessibilityEvent) {
    }

    public void onVirtualViewKeyboardFocusChanged(int i10, boolean z10) {
    }
}

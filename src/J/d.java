package J;

import J.g;
import android.R;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUtils;
import com.heytap.accessory.constant.FastPairConstants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeInfoCompat.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfo f1365a;

    /* renamed from: b, reason: collision with root package name */
    public int f1366b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f1367c = -1;

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Object f1412a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1413b;

        /* renamed from: c, reason: collision with root package name */
        public final Class<? extends g.a> f1414c;

        /* renamed from: d, reason: collision with root package name */
        public final J.g f1415d;

        /* renamed from: e, reason: collision with root package name */
        public static final a f1390e = new a(1, null);

        /* renamed from: f, reason: collision with root package name */
        public static final a f1391f = new a(2, null);

        /* renamed from: g, reason: collision with root package name */
        public static final a f1392g = new a(4, null);

        /* renamed from: h, reason: collision with root package name */
        public static final a f1393h = new a(8, null);

        /* renamed from: i, reason: collision with root package name */
        public static final a f1394i = new a(16, null);

        /* renamed from: j, reason: collision with root package name */
        public static final a f1395j = new a(32, null);

        /* renamed from: k, reason: collision with root package name */
        public static final a f1396k = new a(64, null);

        /* renamed from: l, reason: collision with root package name */
        public static final a f1397l = new a(128, null);

        /* renamed from: m, reason: collision with root package name */
        public static final a f1398m = new a(256, (CharSequence) null, (Class<? extends g.a>) g.b.class);

        /* renamed from: n, reason: collision with root package name */
        public static final a f1399n = new a(512, (CharSequence) null, (Class<? extends g.a>) g.b.class);

        /* renamed from: o, reason: collision with root package name */
        public static final a f1400o = new a(1024, (CharSequence) null, (Class<? extends g.a>) g.c.class);

        /* renamed from: p, reason: collision with root package name */
        public static final a f1401p = new a(2048, (CharSequence) null, (Class<? extends g.a>) g.c.class);

        /* renamed from: q, reason: collision with root package name */
        public static final a f1402q = new a(4096, null);

        /* renamed from: r, reason: collision with root package name */
        public static final a f1403r = new a(8192, null);

        /* renamed from: s, reason: collision with root package name */
        public static final a f1404s = new a(16384, null);

        /* renamed from: t, reason: collision with root package name */
        public static final a f1405t = new a(FastPairConstants.PAIR_TYPE_BLE_IN_PAIR, null);

        /* renamed from: u, reason: collision with root package name */
        public static final a f1406u = new a(65536, null);

        /* renamed from: v, reason: collision with root package name */
        public static final a f1407v = new a(131072, (CharSequence) null, (Class<? extends g.a>) g.C0031g.class);

        /* renamed from: w, reason: collision with root package name */
        public static final a f1408w = new a(262144, null);

        /* renamed from: x, reason: collision with root package name */
        public static final a f1409x = new a(524288, null);

        /* renamed from: y, reason: collision with root package name */
        public static final a f1410y = new a(OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS, null);

        /* renamed from: z, reason: collision with root package name */
        public static final a f1411z = new a(OplusPhoneCapabilities.CAPABILITY_INVITE_PARTICIPANTS, (CharSequence) null, (Class<? extends g.a>) g.h.class);

        /* renamed from: A, reason: collision with root package name */
        public static final a f1368A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);

        /* renamed from: B, reason: collision with root package name */
        public static final a f1369B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, g.e.class);

        /* renamed from: C, reason: collision with root package name */
        public static final a f1370C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);

        /* renamed from: D, reason: collision with root package name */
        public static final a f1371D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);

        /* renamed from: E, reason: collision with root package name */
        public static final a f1372E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);

        /* renamed from: F, reason: collision with root package name */
        public static final a f1373F = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);

        /* renamed from: G, reason: collision with root package name */
        public static final a f1374G = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP, R.id.accessibilityActionPageUp, null, null, null);

        /* renamed from: H, reason: collision with root package name */
        public static final a f1375H = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN, R.id.accessibilityActionPageDown, null, null, null);

        /* renamed from: I, reason: collision with root package name */
        public static final a f1376I = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT, R.id.accessibilityActionPageLeft, null, null, null);

        /* renamed from: J, reason: collision with root package name */
        public static final a f1377J = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT, R.id.accessibilityActionPageRight, null, null, null);

        /* renamed from: K, reason: collision with root package name */
        public static final a f1378K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);

        /* renamed from: L, reason: collision with root package name */
        public static final a f1379L = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, g.f.class);

        /* renamed from: M, reason: collision with root package name */
        public static final a f1380M = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, g.d.class);

        /* renamed from: N, reason: collision with root package name */
        public static final a f1381N = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, R.id.accessibilityActionShowTooltip, null, null, null);

        /* renamed from: O, reason: collision with root package name */
        public static final a f1382O = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, R.id.accessibilityActionHideTooltip, null, null, null);

        /* renamed from: P, reason: collision with root package name */
        public static final a f1383P = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD, R.id.accessibilityActionPressAndHold, null, null, null);

        /* renamed from: Q, reason: collision with root package name */
        public static final a f1384Q = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER, R.id.accessibilityActionImeEnter, null, null, null);

        /* renamed from: R, reason: collision with root package name */
        public static final a f1385R = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START, R.id.ALT, null, null, null);

        /* renamed from: S, reason: collision with root package name */
        public static final a f1386S = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP, R.id.CTRL, null, null, null);

        /* renamed from: T, reason: collision with root package name */
        public static final a f1387T = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL, R.id.FUNCTION, null, null, null);

        /* renamed from: U, reason: collision with root package name */
        public static final a f1388U = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS, R.id.KEYCODE_0, null, null, null);

        /* renamed from: V, reason: collision with root package name */
        public static final a f1389V = new a(C0030d.a(), R.id.KEYCODE_3D_MODE, null, null, null);

        public a(int i10, CharSequence charSequence) {
            this(null, i10, charSequence, null, null);
        }

        public a a(CharSequence charSequence, J.g gVar) {
            return new a(null, this.f1413b, charSequence, gVar, this.f1414c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f1412a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f1412a).getLabel();
        }

        public boolean d(View view, Bundle bundle) {
            String name;
            g.a newInstance;
            if (this.f1415d != null) {
                Class<? extends g.a> cls = this.f1414c;
                g.a aVar = null;
                if (cls != null) {
                    try {
                        newInstance = cls.getDeclaredConstructor(null).newInstance(null);
                    } catch (Exception e10) {
                        e = e10;
                    }
                    try {
                        newInstance.a(bundle);
                        aVar = newInstance;
                    } catch (Exception e11) {
                        e = e11;
                        aVar = newInstance;
                        Class<? extends g.a> cls2 = this.f1414c;
                        if (cls2 == null) {
                            name = "null";
                        } else {
                            name = cls2.getName();
                        }
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + name, e);
                        return this.f1415d.perform(view, aVar);
                    }
                }
                return this.f1415d.perform(view, aVar);
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f1412a;
            if (obj2 == null) {
                if (aVar.f1412a != null) {
                    return false;
                }
                return true;
            }
            if (!obj2.equals(aVar.f1412a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            Object obj = this.f1412a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String h10 = d.h(this.f1413b);
            if (h10.equals("ACTION_UNKNOWN") && c() != null) {
                h10 = c().toString();
            }
            sb.append(h10);
            return sb.toString();
        }

        public a(int i10, CharSequence charSequence, J.g gVar) {
            this(null, i10, charSequence, gVar, null);
        }

        public a(Object obj) {
            this(obj, 0, null, null, null);
        }

        public a(int i10, CharSequence charSequence, Class<? extends g.a> cls) {
            this(null, i10, charSequence, null, cls);
        }

        public a(Object obj, int i10, CharSequence charSequence, J.g gVar, Class<? extends g.a> cls) {
            this.f1413b = i10;
            this.f1415d = gVar;
            if (obj == null) {
                this.f1412a = new AccessibilityNodeInfo.AccessibilityAction(i10, charSequence);
            } else {
                this.f1412a = obj;
            }
            this.f1414c = cls;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class b {
        public static CharSequence a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class c {
        public static String a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: J.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0030d {
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final Object f1416a;

        public e(Object obj) {
            this.f1416a = obj;
        }

        public static e a(int i10, int i11, boolean z10) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10));
        }

        public static e b(int i10, int i11, boolean z10, int i12) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10, i12));
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final Object f1417a;

        public f(Object obj) {
            this.f1417a = obj;
        }

        public static f a(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
            return new f(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10, z11));
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public final Object f1418a;

        public g(Object obj) {
            this.f1418a = obj;
        }

        public static g a(int i10, float f10, float f11, float f12) {
            return new g(AccessibilityNodeInfo.RangeInfo.obtain(i10, f10, f11, f12));
        }
    }

    public d(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f1365a = accessibilityNodeInfo;
    }

    public static d O0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new d(accessibilityNodeInfo);
    }

    public static d V() {
        return O0(AccessibilityNodeInfo.obtain());
    }

    public static d W(d dVar) {
        return O0(AccessibilityNodeInfo.obtain(dVar.f1365a));
    }

    public static d X(View view) {
        return O0(AccessibilityNodeInfo.obtain(view));
    }

    public static String h(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                switch (i10) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case 256:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case 512:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case 8192:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case FastPairConstants.PAIR_TYPE_BLE_IN_PAIR /* 32768 */:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case 131072:
                        return "ACTION_SET_SELECTION";
                    case 262144:
                        return "ACTION_EXPAND";
                    case 524288:
                        return "ACTION_COLLAPSE";
                    case OplusPhoneCapabilities.CAPABILITY_INVITE_PARTICIPANTS /* 2097152 */:
                        return "ACTION_SET_TEXT";
                    case R.id.accessibilityActionMoveWindow:
                        return "ACTION_MOVE_WINDOW";
                    case R.id.KEYCODE_3D_MODE:
                        return "ACTION_SCROLL_IN_DIRECTION";
                    default:
                        switch (i10) {
                            case R.id.accessibilityActionShowOnScreen:
                                return "ACTION_SHOW_ON_SCREEN";
                            case R.id.accessibilityActionScrollToPosition:
                                return "ACTION_SCROLL_TO_POSITION";
                            case R.id.accessibilityActionScrollUp:
                                return "ACTION_SCROLL_UP";
                            case R.id.accessibilityActionScrollLeft:
                                return "ACTION_SCROLL_LEFT";
                            case R.id.accessibilityActionScrollDown:
                                return "ACTION_SCROLL_DOWN";
                            case R.id.accessibilityActionScrollRight:
                                return "ACTION_SCROLL_RIGHT";
                            case R.id.accessibilityActionContextClick:
                                return "ACTION_CONTEXT_CLICK";
                            case R.id.accessibilityActionSetProgress:
                                return "ACTION_SET_PROGRESS";
                            default:
                                switch (i10) {
                                    case R.id.accessibilityActionShowTooltip:
                                        return "ACTION_SHOW_TOOLTIP";
                                    case R.id.accessibilityActionHideTooltip:
                                        return "ACTION_HIDE_TOOLTIP";
                                    case R.id.accessibilityActionPageUp:
                                        return "ACTION_PAGE_UP";
                                    case R.id.accessibilityActionPageDown:
                                        return "ACTION_PAGE_DOWN";
                                    case R.id.accessibilityActionPageLeft:
                                        return "ACTION_PAGE_LEFT";
                                    case R.id.accessibilityActionPageRight:
                                        return "ACTION_PAGE_RIGHT";
                                    case R.id.accessibilityActionPressAndHold:
                                        return "ACTION_PRESS_AND_HOLD";
                                    default:
                                        switch (i10) {
                                            case R.id.accessibilityActionImeEnter:
                                                return "ACTION_IME_ENTER";
                                            case R.id.ALT:
                                                return "ACTION_DRAG_START";
                                            case R.id.CTRL:
                                                return "ACTION_DRAG_DROP";
                                            case R.id.FUNCTION:
                                                return "ACTION_DRAG_CANCEL";
                                            default:
                                                return "ACTION_UNKNOWN";
                                        }
                                }
                        }
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    public static ClickableSpan[] p(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public String A() {
        return c.a(this.f1365a);
    }

    public void A0(View view, int i10) {
        this.f1366b = i10;
        this.f1365a.setParent(view, i10);
    }

    public String B() {
        return this.f1365a.getViewIdResourceName();
    }

    public void B0(g gVar) {
        this.f1365a.setRangeInfo((AccessibilityNodeInfo.RangeInfo) gVar.f1418a);
    }

    public final boolean C() {
        return !f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public void C0(CharSequence charSequence) {
        this.f1365a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
    }

    public boolean D() {
        return C0030d.d(this.f1365a);
    }

    public void D0(boolean z10) {
        this.f1365a.setScreenReaderFocusable(z10);
    }

    public boolean E() {
        return this.f1365a.isAccessibilityFocused();
    }

    public void E0(boolean z10) {
        this.f1365a.setScrollable(z10);
    }

    public boolean F() {
        return this.f1365a.isCheckable();
    }

    public void F0(boolean z10) {
        this.f1365a.setSelected(z10);
    }

    public boolean G() {
        return this.f1365a.isChecked();
    }

    public void G0(boolean z10) {
        this.f1365a.setShowingHintText(z10);
    }

    public boolean H() {
        return this.f1365a.isClickable();
    }

    public void H0(View view) {
        this.f1367c = -1;
        this.f1365a.setSource(view);
    }

    public boolean I() {
        return this.f1365a.isContextClickable();
    }

    public void I0(View view, int i10) {
        this.f1367c = i10;
        this.f1365a.setSource(view, i10);
    }

    public boolean J() {
        return this.f1365a.isEnabled();
    }

    public void J0(CharSequence charSequence) {
        b.b(this.f1365a, charSequence);
    }

    public boolean K() {
        return this.f1365a.isFocusable();
    }

    public void K0(CharSequence charSequence) {
        this.f1365a.setText(charSequence);
    }

    public boolean L() {
        return this.f1365a.isFocused();
    }

    public void L0(View view) {
        this.f1365a.setTraversalAfter(view);
    }

    public boolean M() {
        return j(67108864);
    }

    public void M0(boolean z10) {
        this.f1365a.setVisibleToUser(z10);
    }

    public boolean N() {
        return this.f1365a.isImportantForAccessibility();
    }

    public AccessibilityNodeInfo N0() {
        return this.f1365a;
    }

    public boolean O() {
        return this.f1365a.isLongClickable();
    }

    public boolean P() {
        return this.f1365a.isPassword();
    }

    public boolean Q() {
        return this.f1365a.isScrollable();
    }

    public boolean R() {
        return this.f1365a.isSelected();
    }

    public boolean S() {
        return this.f1365a.isShowingHintText();
    }

    public boolean T() {
        return c.b(this.f1365a);
    }

    public boolean U() {
        return this.f1365a.isVisibleToUser();
    }

    public boolean Y(int i10, Bundle bundle) {
        return this.f1365a.performAction(i10, bundle);
    }

    public void a(int i10) {
        this.f1365a.addAction(i10);
    }

    public boolean a0(a aVar) {
        return this.f1365a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f1412a);
    }

    public void b(a aVar) {
        this.f1365a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f1412a);
    }

    public void b0(boolean z10) {
        this.f1365a.setAccessibilityFocused(z10);
    }

    public void c(View view) {
        this.f1365a.addChild(view);
    }

    @Deprecated
    public void c0(Rect rect) {
        this.f1365a.setBoundsInParent(rect);
    }

    public void d(View view, int i10) {
        this.f1365a.addChild(view, i10);
    }

    public void d0(Rect rect) {
        this.f1365a.setBoundsInScreen(rect);
    }

    public void e0(boolean z10) {
        this.f1365a.setCanOpenPopup(z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1365a;
        if (accessibilityNodeInfo == null) {
            if (dVar.f1365a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(dVar.f1365a)) {
            return false;
        }
        if (this.f1367c == dVar.f1367c && this.f1366b == dVar.f1366b) {
            return true;
        }
        return false;
    }

    public final List<Integer> f(String str) {
        ArrayList<Integer> integerArrayList = this.f1365a.getExtras().getIntegerArrayList(str);
        if (integerArrayList == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            this.f1365a.getExtras().putIntegerArrayList(str, arrayList);
            return arrayList;
        }
        return integerArrayList;
    }

    public void f0(boolean z10) {
        this.f1365a.setCheckable(z10);
    }

    public List<a> g() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f1365a.getActionList();
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new a(actionList.get(i10)));
        }
        return arrayList;
    }

    public void g0(boolean z10) {
        this.f1365a.setChecked(z10);
    }

    public void h0(CharSequence charSequence) {
        this.f1365a.setClassName(charSequence);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1365a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f1365a.getActions();
    }

    public void i0(boolean z10) {
        this.f1365a.setClickable(z10);
    }

    public final boolean j(int i10) {
        Bundle t10 = t();
        if (t10 == null || (t10.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i10) != i10) {
            return false;
        }
        return true;
    }

    public void j0(Object obj) {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1365a;
        if (obj == null) {
            collectionInfo = null;
        } else {
            collectionInfo = (AccessibilityNodeInfo.CollectionInfo) ((e) obj).f1416a;
        }
        accessibilityNodeInfo.setCollectionInfo(collectionInfo);
    }

    @Deprecated
    public void k(Rect rect) {
        this.f1365a.getBoundsInParent(rect);
    }

    public void k0(Object obj) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1365a;
        if (obj == null) {
            collectionItemInfo = null;
        } else {
            collectionItemInfo = (AccessibilityNodeInfo.CollectionItemInfo) ((f) obj).f1417a;
        }
        accessibilityNodeInfo.setCollectionItemInfo(collectionItemInfo);
    }

    public void l(Rect rect) {
        this.f1365a.getBoundsInScreen(rect);
    }

    public void l0(CharSequence charSequence) {
        this.f1365a.setContentDescription(charSequence);
    }

    public void m(Rect rect) {
        C0030d.b(this.f1365a, rect);
    }

    public void m0(boolean z10) {
        this.f1365a.setDismissable(z10);
    }

    public int n() {
        return this.f1365a.getChildCount();
    }

    public void n0(boolean z10) {
        this.f1365a.setEnabled(z10);
    }

    public CharSequence o() {
        return this.f1365a.getClassName();
    }

    public void o0(CharSequence charSequence) {
        this.f1365a.setError(charSequence);
    }

    public void p0(boolean z10) {
        this.f1365a.setFocusable(z10);
    }

    public CharSequence q() {
        return C0030d.c(this.f1365a);
    }

    public void q0(boolean z10) {
        this.f1365a.setFocused(z10);
    }

    public CharSequence r() {
        return this.f1365a.getContentDescription();
    }

    public void r0(boolean z10) {
        this.f1365a.setHeading(z10);
    }

    public CharSequence s() {
        return this.f1365a.getError();
    }

    public void s0(CharSequence charSequence) {
        this.f1365a.setHintText(charSequence);
    }

    public Bundle t() {
        return this.f1365a.getExtras();
    }

    public void t0(View view) {
        this.f1365a.setLabelFor(view);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        k(rect);
        sb.append("; boundsInParent: " + rect);
        l(rect);
        sb.append("; boundsInScreen: " + rect);
        m(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(w());
        sb.append("; className: ");
        sb.append(o());
        sb.append("; text: ");
        sb.append(y());
        sb.append("; error: ");
        sb.append(s());
        sb.append("; maxTextLength: ");
        sb.append(u());
        sb.append("; stateDescription: ");
        sb.append(x());
        sb.append("; contentDescription: ");
        sb.append(r());
        sb.append("; tooltipText: ");
        sb.append(z());
        sb.append("; viewIdResName: ");
        sb.append(B());
        sb.append("; uniqueId: ");
        sb.append(A());
        sb.append("; checkable: ");
        sb.append(F());
        sb.append("; checked: ");
        sb.append(G());
        sb.append("; focusable: ");
        sb.append(K());
        sb.append("; focused: ");
        sb.append(L());
        sb.append("; selected: ");
        sb.append(R());
        sb.append("; clickable: ");
        sb.append(H());
        sb.append("; longClickable: ");
        sb.append(O());
        sb.append("; contextClickable: ");
        sb.append(I());
        sb.append("; enabled: ");
        sb.append(J());
        sb.append("; password: ");
        sb.append(P());
        sb.append("; scrollable: " + Q());
        sb.append("; containerTitle: ");
        sb.append(q());
        sb.append("; granularScrollingSupported: ");
        sb.append(M());
        sb.append("; importantForAccessibility: ");
        sb.append(N());
        sb.append("; visible: ");
        sb.append(U());
        sb.append("; isTextSelectable: ");
        sb.append(T());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(D());
        sb.append("; [");
        List<a> g10 = g();
        for (int i10 = 0; i10 < g10.size(); i10++) {
            a aVar = g10.get(i10);
            String h10 = h(aVar.b());
            if (h10.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                h10 = aVar.c().toString();
            }
            sb.append(h10);
            if (i10 != g10.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int u() {
        return this.f1365a.getMaxTextLength();
    }

    public void u0(boolean z10) {
        this.f1365a.setLongClickable(z10);
    }

    public int v() {
        return this.f1365a.getMovementGranularities();
    }

    public void v0(int i10) {
        this.f1365a.setMaxTextLength(i10);
    }

    public CharSequence w() {
        return this.f1365a.getPackageName();
    }

    public void w0(int i10) {
        this.f1365a.setMovementGranularities(i10);
    }

    public CharSequence x() {
        return b.a(this.f1365a);
    }

    public void x0(CharSequence charSequence) {
        this.f1365a.setPackageName(charSequence);
    }

    public CharSequence y() {
        if (C()) {
            List<Integer> f10 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List<Integer> f11 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List<Integer> f12 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List<Integer> f13 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.f1365a.getText(), 0, this.f1365a.getText().length()));
            for (int i10 = 0; i10 < f10.size(); i10++) {
                spannableString.setSpan(new J.a(f13.get(i10).intValue(), this, t().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), f10.get(i10).intValue(), f11.get(i10).intValue(), f12.get(i10).intValue());
            }
            return spannableString;
        }
        return this.f1365a.getText();
    }

    public void y0(CharSequence charSequence) {
        this.f1365a.setPaneTitle(charSequence);
    }

    public CharSequence z() {
        return this.f1365a.getTooltipText();
    }

    public void z0(View view) {
        this.f1366b = -1;
        this.f1365a.setParent(view);
    }

    @Deprecated
    public void Z() {
    }

    public void e(CharSequence charSequence, View view) {
    }
}

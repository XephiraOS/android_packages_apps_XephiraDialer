package P2;

import com.android.incallui.Log;

/* compiled from: OplusCrossProcessDataStructureSet.java */
/* loaded from: classes.dex */
public class a {

    /* compiled from: OplusCrossProcessDataStructureSet.java */
    /* renamed from: P2.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0054a {

        /* renamed from: a, reason: collision with root package name */
        public String f2879a;

        /* renamed from: b, reason: collision with root package name */
        public long f2880b;

        /* renamed from: c, reason: collision with root package name */
        public String f2881c;

        /* renamed from: d, reason: collision with root package name */
        public String f2882d;

        /* renamed from: e, reason: collision with root package name */
        public String f2883e;

        /* renamed from: f, reason: collision with root package name */
        public int f2884f;
    }

    public static String a(int i10) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    return "invalid";
                }
                return "video_show_vibrate";
            }
            return "floating_window";
        }
        return "default";
    }

    public static boolean b(int i10, int i11) {
        boolean z10;
        if ((i10 & i11) == i11) {
            z10 = true;
        } else {
            z10 = false;
        }
        Log.d("OplusCrossProcessDataStructureSet", "isBitmaskKeyValueEnabled bitmask " + i10 + " enabled = " + z10);
        return z10;
    }
}

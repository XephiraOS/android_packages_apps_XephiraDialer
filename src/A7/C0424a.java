package a7;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: ImportContactsTipsUiState.kt */
/* renamed from: a7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0424a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6448a;

    /* renamed from: b, reason: collision with root package name */
    public final C0094a f6449b;

    /* compiled from: ImportContactsTipsUiState.kt */
    /* renamed from: a7.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0094a {

        /* renamed from: a, reason: collision with root package name */
        public final String f6450a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f6451b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f6452c;

        /* JADX WARN: Multi-variable type inference failed */
        public C0094a() {
            this(null, false, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ C0094a b(C0094a c0094a, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = c0094a.f6450a;
            }
            if ((i10 & 2) != 0) {
                z10 = c0094a.f6451b;
            }
            return c0094a.a(str, z10);
        }

        public final C0094a a(String str, boolean z10) {
            return new C0094a(str, z10);
        }

        public final String c() {
            return this.f6450a;
        }

        public final boolean d() {
            return this.f6452c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0094a)) {
                return false;
            }
            C0094a c0094a = (C0094a) obj;
            if (i.b(this.f6450a, c0094a.f6450a) && this.f6451b == c0094a.f6451b) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            String str = this.f6450a;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i10 = hashCode * 31;
            boolean z10 = this.f6451b;
            int i11 = z10;
            if (z10 != 0) {
                i11 = 1;
            }
            return i10 + i11;
        }

        public String toString() {
            return "PhoneCloneState(phoneCloneLabel=" + this.f6450a + ", isPowerSaveMode=" + this.f6451b + ")";
        }

        public C0094a(String str, boolean z10) {
            this.f6450a = str;
            this.f6451b = z10;
            this.f6452c = (str == null || str.length() == 0 || z10 || com.android.contacts.framework.api.appstore.appinfo.a.k()) ? false : true;
        }

        public /* synthetic */ C0094a(String str, boolean z10, int i10, f fVar) {
            this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? true : z10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0424a() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ C0424a b(C0424a c0424a, boolean z10, C0094a c0094a, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = c0424a.f6448a;
        }
        if ((i10 & 2) != 0) {
            c0094a = c0424a.f6449b;
        }
        return c0424a.a(z10, c0094a);
    }

    public final C0424a a(boolean z10, C0094a phoneCloneState) {
        i.f(phoneCloneState, "phoneCloneState");
        return new C0424a(z10, phoneCloneState);
    }

    public final boolean c() {
        return this.f6448a;
    }

    public final C0094a d() {
        return this.f6449b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0424a)) {
            return false;
        }
        C0424a c0424a = (C0424a) obj;
        if (this.f6448a == c0424a.f6448a && i.b(this.f6449b, c0424a.f6449b)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.f6448a;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        return (r02 * 31) + this.f6449b.hashCode();
    }

    public String toString() {
        return "ImportContactsTipsUiState(cloudSyncVisible=" + this.f6448a + ", phoneCloneState=" + this.f6449b + ")";
    }

    public C0424a(boolean z10, C0094a phoneCloneState) {
        i.f(phoneCloneState, "phoneCloneState");
        this.f6448a = z10;
        this.f6449b = phoneCloneState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ C0424a(boolean z10, C0094a c0094a, int i10, f fVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? new C0094a(null, false, 3, 0 == true ? 1 : 0) : c0094a);
    }
}

package com.android.contacts;

import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.PersistableBundle;
import com.android.contacts.DynamicShortcuts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlinx.coroutines.C1244g;

/* compiled from: ContactShortcuts.kt */
/* loaded from: classes.dex */
public final class ContactShortcuts extends DynamicShortcuts {

    /* renamed from: j, reason: collision with root package name */
    public static final ContactShortcuts f13087j = new ContactShortcuts();

    /* compiled from: ContactShortcuts.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f13088a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13089b;

        public a(int i10, int i11) {
            this.f13088a = i10;
            this.f13089b = i11;
        }

        public final int a() {
            return this.f13088a;
        }

        public final int b() {
            return this.f13089b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f13088a == aVar.f13088a && this.f13089b == aVar.f13089b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f13088a) * 31) + Integer.hashCode(this.f13089b);
        }

        public String toString() {
            return "ContactShortCount(callTypeCnt=" + this.f13088a + ", detailTypeCnt=" + this.f13089b + ")";
        }
    }

    /* compiled from: ContactShortcuts.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13090a;

        static {
            int[] iArr = new int[DynamicShortcuts.ShortcutType.values().length];
            try {
                iArr[DynamicShortcuts.ShortcutType.CALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DynamicShortcuts.ShortcutType.DETAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f13090a = iArr;
        }
    }

    public ContactShortcuts() {
        super(P7.a.f2961a.a());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|(1:(1:(6:11|12|13|(1:15)|16|17)(2:20|21))(1:22))(2:39|(1:41))|23|(2:25|26)(7:27|(4:29|(1:31)|32|(2:34|(1:36))(1:37))(1:38)|12|13|(0)|16|17)))|44|6|7|(0)(0)|23|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x002f, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ba, code lost:
    
        r7 = kotlin.Result.f34166a;
        r6 = kotlin.Result.b(kotlin.b.a(r6));
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a A[Catch: all -> 0x002f, TRY_ENTER, TryCatch #0 {all -> 0x002f, blocks: (B:11:0x002a, B:12:0x00b3, B:27:0x007a, B:29:0x0082, B:31:0x0086, B:32:0x0089, B:34:0x0092, B:37:0x00a8, B:38:0x00ae), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A(long r7, com.android.contacts.DynamicShortcuts.ShortcutType r9, kotlin.coroutines.c<? super m9.q> r10) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.ContactShortcuts.A(long, com.android.contacts.DynamicShortcuts$ShortcutType, kotlin.coroutines.c):java.lang.Object");
    }

    public final Object B(long j10, kotlin.coroutines.c<? super m9.q> cVar) {
        Object c10;
        Object g10 = C1244g.g(kotlinx.coroutines.S.b(), new ContactShortcuts$createViewContactPinShortcut$2(j10, null), cVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (g10 == c10) {
            return g10;
        }
        return m9.q.f35511a;
    }

    public final a C() {
        Object b10;
        int i10;
        try {
            Result.a aVar = Result.f34166a;
            List<ShortcutInfo> pinnedShortcuts = this.f13114c.getPinnedShortcuts();
            kotlin.jvm.internal.i.e(pinnedShortcuts, "mShortcutManager.pinnedShortcuts");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = pinnedShortcuts.iterator();
            while (true) {
                i10 = 0;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                PersistableBundle extras = ((ShortcutInfo) next).getExtras();
                if (extras != null && extras.getInt("extraShortcutType", 0) == 1) {
                    arrayList.add(next);
                }
            }
            Iterator it2 = arrayList.iterator();
            int i11 = 0;
            while (it2.hasNext()) {
                int i12 = b.f13090a[DynamicShortcuts.ShortcutType.b(((ShortcutInfo) it2.next()).getId()).ordinal()];
                if (i12 != 1) {
                    if (i12 == 2) {
                        i11++;
                    }
                } else {
                    i10++;
                }
            }
            b10 = Result.b(new a(i10, i11));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("ContactShortcuts", "getContactShortCount " + d10 + " " + d10.getMessage());
        }
        if (Result.f(b10)) {
            b10 = null;
        }
        return (a) b10;
    }

    public final void D(ShortcutInfo shortcutInfo) {
        List<ShortcutInfo> b10;
        try {
            Result.a aVar = Result.f34166a;
            ShortcutManager shortcutManager = this.f13114c;
            b10 = kotlin.collections.n.b(shortcutInfo);
            Result.b(Boolean.valueOf(shortcutManager.updateShortcuts(b10)));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Result.b(kotlin.b.a(th));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(long r7, com.android.contacts.DynamicShortcuts.ShortcutType r9, kotlin.coroutines.c<? super java.lang.Boolean> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.android.contacts.ContactShortcuts$checkPinnedShortcutsExist$1
            if (r0 == 0) goto L13
            r0 = r10
            com.android.contacts.ContactShortcuts$checkPinnedShortcutsExist$1 r0 = (com.android.contacts.ContactShortcuts$checkPinnedShortcutsExist$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.android.contacts.ContactShortcuts$checkPinnedShortcutsExist$1 r0 = new com.android.contacts.ContactShortcuts$checkPinnedShortcutsExist$1
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.c()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            int r6 = r0.I$0
            kotlin.b.b(r10)
            goto La5
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.b.b(r10)
            android.content.pm.ShortcutManager r6 = r6.f13114c
            java.util.List r6 = r6.getPinnedShortcuts()
            java.lang.String r10 = "mShortcutManager.pinnedShortcuts"
            kotlin.jvm.internal.i.e(r6, r10)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r10 = r6 instanceof java.util.Collection
            if (r10 == 0) goto L54
            r10 = r6
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L54
        L52:
            r6 = r3
            goto L8e
        L54:
            java.util.Iterator r6 = r6.iterator()
        L58:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto L52
            java.lang.Object r10 = r6.next()
            android.content.pm.ShortcutInfo r10 = (android.content.pm.ShortcutInfo) r10
            android.os.PersistableBundle r2 = r10.getExtras()
            if (r2 == 0) goto L58
            java.lang.String r5 = "extraShortcutType"
            int r2 = r2.getInt(r5, r3)
            if (r2 != r4) goto L58
            java.lang.String r10 = r10.getId()
            java.lang.String r2 = r9.idPrefix
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r2)
            r5.append(r7)
            java.lang.String r2 = r5.toString()
            boolean r10 = kotlin.jvm.internal.i.b(r10, r2)
            if (r10 == 0) goto L58
            r6 = r4
        L8e:
            if (r6 == 0) goto La5
            kotlinx.coroutines.w0 r7 = kotlinx.coroutines.S.c()
            com.android.contacts.ContactShortcuts$checkPinnedShortcutsExist$2 r8 = new com.android.contacts.ContactShortcuts$checkPinnedShortcutsExist$2
            r9 = 0
            r8.<init>(r9)
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r7 = kotlinx.coroutines.C1244g.g(r7, r8, r0)
            if (r7 != r1) goto La5
            return r1
        La5:
            if (r6 == 0) goto La8
            r3 = r4
        La8:
            java.lang.Boolean r6 = p9.C1467a.a(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.ContactShortcuts.y(long, com.android.contacts.DynamicShortcuts$ShortcutType, kotlin.coroutines.c):java.lang.Object");
    }

    public final Object z(long j10, kotlin.coroutines.c<? super m9.q> cVar) {
        Object c10;
        Object g10 = C1244g.g(kotlinx.coroutines.S.b(), new ContactShortcuts$createCallContactPinShortcut$2(j10, null), cVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (g10 == c10) {
            return g10;
        }
        return m9.q.f35511a;
    }
}

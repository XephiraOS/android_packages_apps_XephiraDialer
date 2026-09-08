package B9;

import kotlin.collections.AbstractC1231l;
import w9.InterfaceC1658a;

/* compiled from: Progressions.kt */
/* loaded from: classes4.dex */
public class a implements Iterable<Character>, InterfaceC1658a {

    /* renamed from: d, reason: collision with root package name */
    public static final C0004a f286d = new C0004a(null);

    /* renamed from: a, reason: collision with root package name */
    public final char f287a;

    /* renamed from: b, reason: collision with root package name */
    public final char f288b;

    /* renamed from: c, reason: collision with root package name */
    public final int f289c;

    /* compiled from: Progressions.kt */
    /* renamed from: B9.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0004a {
        public C0004a() {
        }

        public /* synthetic */ C0004a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public a(char c10, char c11, int i10) {
        if (i10 != 0) {
            if (i10 != Integer.MIN_VALUE) {
                this.f287a = c10;
                this.f288b = (char) r9.c.b(c10, c11, i10);
                this.f289c = i10;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public final char a() {
        return this.f287a;
    }

    public final char c() {
        return this.f288b;
    }

    @Override // java.lang.Iterable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AbstractC1231l iterator() {
        return new b(this.f287a, this.f288b, this.f289c);
    }
}

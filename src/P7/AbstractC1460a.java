package p7;

import android.database.Cursor;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.f;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.S;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.m;
import kotlinx.coroutines.flow.n;

/* compiled from: AbstractCursorSelectManager.kt */
/* renamed from: p7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1460a<E> extends C1462c<E> {

    /* renamed from: h, reason: collision with root package name */
    public Cursor f36082h;

    /* renamed from: i, reason: collision with root package name */
    public final i<C1461b<E>> f36083i;

    /* renamed from: j, reason: collision with root package name */
    public final m<C1461b<E>> f36084j;

    public /* synthetic */ AbstractC1460a(CoroutineDispatcher coroutineDispatcher, int i10, f fVar) {
        this((i10 & 1) != 0 ? S.b() : coroutineDispatcher);
    }

    @Override // p7.C1462c
    public void e() {
        C1461b<E> value;
        Cursor cursor;
        boolean a10;
        Set P10;
        Set P11;
        i<C1461b<E>> iVar = this.f36083i;
        do {
            value = iVar.getValue();
            cursor = this.f36082h;
            a10 = a();
            P10 = CollectionsKt___CollectionsKt.P(b());
            P11 = CollectionsKt___CollectionsKt.P(c());
        } while (!iVar.c(value, new C1461b<>(cursor, a10, P10, P11)));
    }

    public final Cursor g() {
        return this.f36082h;
    }

    public m<C1461b<E>> h() {
        return this.f36084j;
    }

    public final void i(Cursor cursor) {
        this.f36082h = cursor;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC1460a(CoroutineDispatcher workerDispatcher) {
        super(workerDispatcher);
        kotlin.jvm.internal.i.f(workerDispatcher, "workerDispatcher");
        i<C1461b<E>> a10 = n.a(new C1461b(null, false, null, null, 15, null));
        this.f36083i = a10;
        this.f36084j = a10;
    }
}

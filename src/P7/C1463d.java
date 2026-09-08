package p7;

import java.util.List;
import java.util.Set;
import kotlin.collections.K;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.S;

/* compiled from: SelectedDataUiState.kt */
/* renamed from: p7.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1463d<E> {

    /* renamed from: a, reason: collision with root package name */
    public final List<E> f36097a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f36098b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<E> f36099c;

    /* renamed from: d, reason: collision with root package name */
    public final Set<E> f36100d;

    /* renamed from: e, reason: collision with root package name */
    public final CoroutineDispatcher f36101e;

    /* renamed from: f, reason: collision with root package name */
    public final int f36102f;

    /* JADX WARN: Multi-variable type inference failed */
    public C1463d(List<? extends E> itemList, boolean z10, Set<? extends E> notSelectedItemsInMarkAll, Set<? extends E> selectedItems, CoroutineDispatcher workerDispatcher) {
        i.f(itemList, "itemList");
        i.f(notSelectedItemsInMarkAll, "notSelectedItemsInMarkAll");
        i.f(selectedItems, "selectedItems");
        i.f(workerDispatcher, "workerDispatcher");
        this.f36097a = itemList;
        this.f36098b = z10;
        this.f36099c = notSelectedItemsInMarkAll;
        this.f36100d = selectedItems;
        this.f36101e = workerDispatcher;
        this.f36102f = itemList.size();
    }

    public final int a() {
        if (this.f36098b) {
            return b() - this.f36099c.size();
        }
        return this.f36100d.size();
    }

    public int b() {
        return this.f36102f;
    }

    public final boolean c() {
        if (a() == b()) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        return this.f36098b;
    }

    public final boolean e(E e10) {
        if (this.f36098b) {
            if (!this.f36099c.contains(e10)) {
                return true;
            }
            return false;
        }
        return this.f36100d.contains(e10);
    }

    public /* synthetic */ C1463d(List list, boolean z10, Set set, Set set2, CoroutineDispatcher coroutineDispatcher, int i10, f fVar) {
        this(list, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? K.b() : set, (i10 & 8) != 0 ? K.b() : set2, (i10 & 16) != 0 ? S.b() : coroutineDispatcher);
    }
}

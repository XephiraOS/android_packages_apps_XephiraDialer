package w7;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import java.util.Iterator;
import kotlin.Result;
import kotlin.jvm.internal.i;

/* compiled from: RecyclerViewPositionHelper.kt */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f37624a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final Rect f37625b = new Rect();

    public static final int a(HeaderFooterRecyclerView recyclerView, int i10, int i11, int i12) {
        int i13;
        i.f(recyclerView, "recyclerView");
        try {
            Result.a aVar = Result.f34166a;
            Iterator<T> it = recyclerView.getHeaderViews().iterator();
            int i14 = 0;
            while (it.hasNext()) {
                i14 += ((View) it.next()).getHeight();
            }
            View childAt = recyclerView.getChildAt(recyclerView.getHeadersCount());
            if (childAt != null) {
                i13 = childAt.getHeight();
            } else {
                i13 = 0;
            }
            int height = (i14 + (i11 * i13)) - ((recyclerView.getHeight() - recyclerView.getPaddingTop()) - i10);
            if (height <= 0 || height >= i12) {
                return 0;
            }
            return i12 - height;
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Object b10 = Result.b(kotlin.b.a(th));
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.e("RecyclerViewPositionHelper", "calculatePaddingBottomForScroll " + d10 + " " + d10.getMessage());
            }
            if (Result.f(b10)) {
                b10 = 0;
            }
            return ((Number) b10).intValue();
        }
    }

    public static final int b(LinearLayoutManager linearLayoutManager, View view, View view2, int i10) {
        int i11;
        int i12;
        if (linearLayoutManager != null && view != null && view2 != null) {
            Rect rect = f37625b;
            view.getGlobalVisibleRect(rect);
            int i13 = rect.bottom;
            view2.getGlobalVisibleRect(rect);
            int i14 = rect.top;
            int childCount = linearLayoutManager.getChildCount();
            View view3 = null;
            int i15 = 0;
            while (true) {
                if (i15 < childCount) {
                    View childAt = linearLayoutManager.getChildAt(i15);
                    if (childAt != null && childAt.getHeight() != 0) {
                        Rect rect2 = f37625b;
                        childAt.getGlobalVisibleRect(rect2);
                        rect2.offset(0, i10);
                        if (view3 == null && i13 <= (i12 = rect2.top) && i12 <= i14) {
                            view3 = childAt;
                        }
                        if (rect2.top >= i13 && rect2.bottom <= i14) {
                            i11 = linearLayoutManager.getPosition(childAt);
                            break;
                        }
                    }
                    i15++;
                } else {
                    i11 = -1;
                    break;
                }
            }
            if (i11 == -1 && view3 != null) {
                int position = linearLayoutManager.getPosition(view3);
                if (position == -1) {
                    return 0;
                }
                return position;
            }
            return i11;
        }
        H7.b.c("RecyclerViewPositionHelper", "error arguments");
        return 0;
    }
}

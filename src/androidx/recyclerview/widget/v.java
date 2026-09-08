package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: ScrollbarHelper.java */
/* loaded from: classes.dex */
public class v {
    public static int a(RecyclerView.y yVar, s sVar, View view, View view2, RecyclerView.o oVar, boolean z10) {
        if (oVar.getChildCount() != 0 && yVar.b() != 0 && view != null && view2 != null) {
            if (!z10) {
                return Math.abs(oVar.getPosition(view) - oVar.getPosition(view2)) + 1;
            }
            return Math.min(sVar.o(), sVar.d(view2) - sVar.g(view));
        }
        return 0;
    }

    public static int b(RecyclerView.y yVar, s sVar, View view, View view2, RecyclerView.o oVar, boolean z10, boolean z11) {
        int max;
        if (oVar.getChildCount() == 0 || yVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(oVar.getPosition(view), oVar.getPosition(view2));
        int max2 = Math.max(oVar.getPosition(view), oVar.getPosition(view2));
        if (z11) {
            max = Math.max(0, (yVar.b() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (!z10) {
            return max;
        }
        return Math.round((max * (Math.abs(sVar.d(view2) - sVar.g(view)) / (Math.abs(oVar.getPosition(view) - oVar.getPosition(view2)) + 1))) + (sVar.n() - sVar.g(view)));
    }

    public static int c(RecyclerView.y yVar, s sVar, View view, View view2, RecyclerView.o oVar, boolean z10) {
        if (oVar.getChildCount() != 0 && yVar.b() != 0 && view != null && view2 != null) {
            if (!z10) {
                return yVar.b();
            }
            return (int) (((sVar.d(view2) - sVar.g(view)) / (Math.abs(oVar.getPosition(view) - oVar.getPosition(view2)) + 1)) * yVar.b());
        }
        return 0;
    }
}

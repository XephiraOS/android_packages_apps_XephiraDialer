package L1;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.android.incallui.R;
import com.coui.appcompat.panel.COUIBottomSheetDialog;
import kotlin.jvm.internal.i;

/* compiled from: CouiViewPlugin.kt */
/* loaded from: classes.dex */
public final class a {
    public static final void a(COUIBottomSheetDialog cOUIBottomSheetDialog) {
        ViewGroup.LayoutParams layoutParams;
        FrameLayout.LayoutParams layoutParams2;
        View decorView;
        i.f(cOUIBottomSheetDialog, "<this>");
        View findViewById = cOUIBottomSheetDialog.findViewById(R.id.coordinator);
        if (findViewById != null) {
            layoutParams = findViewById.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        } else {
            layoutParams2 = null;
        }
        if (layoutParams2 != null) {
            layoutParams2.topMargin = 0;
        }
        if (findViewById != null) {
            findViewById.setLayoutParams(layoutParams2);
        }
        Window window = cOUIBottomSheetDialog.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.setOnApplyWindowInsetsListener(null);
        }
    }

    public static final boolean b(COUIBottomSheetDialog cOUIBottomSheetDialog) {
        i.f(cOUIBottomSheetDialog, "<this>");
        if (cOUIBottomSheetDialog.getBehavior().getState() == 5) {
            return true;
        }
        return false;
    }
}

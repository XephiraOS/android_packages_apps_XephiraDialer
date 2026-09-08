package U3;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.coui.responsiveui.config.ResponsiveUIConfig;
import com.coui.responsiveui.config.UIConfig;
import com.customize.contacts.camera.CameraSurfaceView;
import com.customize.contacts.widget.FinderView;
import com.oplus.dialer.R;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import kotlin.jvm.internal.i;

/* compiled from: RecognizeCardHelper.kt */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f3851a = new g();

    public final void a(Activity activity, int i10, CameraSurfaceView cameraView, FinderView qrGuideView, int i11, RelativeLayout controlPanel) {
        ViewGroup.LayoutParams layoutParams;
        i.f(activity, "activity");
        i.f(cameraView, "cameraView");
        i.f(qrGuideView, "qrGuideView");
        i.f(controlPanel, "controlPanel");
        ViewGroup.LayoutParams layoutParams2 = cameraView.getLayoutParams();
        i.d(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.camera_layout);
        UIConfig.Status status = null;
        if (frameLayout != null) {
            layoutParams = frameLayout.getLayoutParams();
        } else {
            layoutParams = null;
        }
        i.d(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams;
        UIConfig value = ResponsiveUIConfig.getDefault(activity).getUiConfig().getValue();
        if (value != null) {
            status = value.getStatus();
        }
        if (status != UIConfig.Status.UNFOLD) {
            layoutParams3.height = i10;
            int e10 = (DisplayUtil.e(activity, true) - i10) - i11;
            cameraView.setLayoutParams(layoutParams3);
            qrGuideView.setBottomHeight(e10);
            b(activity, e10, i10, controlPanel);
            layoutParams4.height = i10;
            layoutParams4.setMargins(0, i11, 0, 0);
        } else {
            layoutParams3.width = i10;
            cameraView.setLayoutParams(layoutParams3);
            qrGuideView.setFoldSideWidth(i10);
            b(activity, 1, i10, controlPanel);
            layoutParams4.width = i10;
        }
        frameLayout.setLayoutParams(layoutParams4);
        frameLayout.setVisibility(0);
    }

    public final void b(Activity activity, int i10, int i11, RelativeLayout relativeLayout) {
        UIConfig.Status status;
        boolean z10;
        UIConfig value = ResponsiveUIConfig.getDefault(activity).getUiConfig().getValue();
        if (value != null) {
            status = value.getStatus();
        } else {
            status = null;
        }
        if (status != UIConfig.Status.UNFOLD) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (H7.a.b()) {
            H7.b.b("RecognizeCardHelper", "setControlPanelPosition:bottomHeight = " + i10);
        }
        if (i10 > 0) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            i.d(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (z10 && CommonFeatureOption.k()) {
                i10 = i10 + DisplayUtil.d(activity) + activity.getResources().getDimensionPixelSize(R.dimen.DP_16);
            }
            if (z10) {
                layoutParams2.height = i10;
            } else {
                int f10 = (DisplayUtil.f(activity, true) - i11) / 2;
                if (f10 > relativeLayout.getWidth() && f10 >= activity.getResources().getDimensionPixelSize(R.dimen.DP_94)) {
                    layoutParams2.setMarginEnd((f10 - relativeLayout.getWidth()) / 2);
                } else {
                    layoutParams2.setMarginEnd(0);
                }
            }
            relativeLayout.setLayoutParams(layoutParams2);
        }
    }
}

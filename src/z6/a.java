package Z6;

import Z3.f;
import android.app.Activity;
import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import com.coui.appcompat.floatingactionbutton.COUIFloatingButton;
import com.oplus.dialer.R;
import kotlin.jvm.internal.i;

/* compiled from: ContactsMainListFloatingBtnImpl.kt */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public COUIFloatingButton f5963a;

    public final COUIFloatingButton a(Context context) {
        Activity activity;
        if (this.f5963a == null) {
            COUIFloatingButton cOUIFloatingButton = null;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null) {
                cOUIFloatingButton = (COUIFloatingButton) activity.findViewById(R.id.floating_button);
            }
            this.f5963a = cOUIFloatingButton;
        }
        return this.f5963a;
    }

    public void b(Context context, boolean z10) {
        COUIFloatingButton a10 = a(context);
        if (a10 != null) {
            a10.setEnabled(z10);
        }
    }

    public void c(Context context, boolean z10) {
        COUIFloatingButton a10;
        int i10;
        if (context != null && (a10 = a(context)) != null) {
            a10.setScaleX(1.0f);
            a10.setScaleY(1.0f);
            a10.setMainFabDrawable(context.getDrawable(R.drawable.pb_ic_floating_add_contact));
            a10.getMainFloatingButton().setContentDescription(context.getString(R.string.insertContactDescription));
            int i11 = 8;
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            a10.setVisibility(i10);
            AppCompatImageView mainFloatingButton = a10.getMainFloatingButton();
            i.e(mainFloatingButton, "floatingBtn.mainFloatingButton");
            if (z10) {
                i11 = 0;
            }
            mainFloatingButton.setVisibility(i11);
            if (z10) {
                f.t(a10.getMainFloatingButton());
                a10.animationFloatingButtonEnlarge();
            }
        }
    }
}

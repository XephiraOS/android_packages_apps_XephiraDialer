package x0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oplus.dialer.R;
import l0.C1287a;

/* compiled from: NoContactSelectedFragmentLayoutBinding.java */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f37779a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f37780b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f37781c;

    public s(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.f37779a = constraintLayout;
        this.f37780b = imageView;
        this.f37781c = textView;
    }

    public static s a(View view) {
        int i10 = R.id.img_no_contact_selected;
        ImageView imageView = (ImageView) C1287a.a(view, R.id.img_no_contact_selected);
        if (imageView != null) {
            i10 = R.id.txt_no_contact_selected;
            TextView textView = (TextView) C1287a.a(view, R.id.txt_no_contact_selected);
            if (textView != null) {
                return new s((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static s c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.no_contact_selected_fragment_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public ConstraintLayout b() {
        return this.f37779a;
    }
}

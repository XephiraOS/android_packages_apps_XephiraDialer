package x0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.contacts.framework.baseui.widget.EmptyViewGroup;
import com.oplus.dialer.R;
import l0.C1287a;

/* compiled from: NoContactFragmentLayoutBinding.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f37775a;

    /* renamed from: b, reason: collision with root package name */
    public final EmptyViewGroup f37776b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f37777c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f37778d;

    public r(ConstraintLayout constraintLayout, EmptyViewGroup emptyViewGroup, ImageView imageView, TextView textView) {
        this.f37775a = constraintLayout;
        this.f37776b = emptyViewGroup;
        this.f37777c = imageView;
        this.f37778d = textView;
    }

    public static r a(View view) {
        int i10 = R.id.empty_view_group;
        EmptyViewGroup emptyViewGroup = (EmptyViewGroup) C1287a.a(view, R.id.empty_view_group);
        if (emptyViewGroup != null) {
            i10 = R.id.img_no_content;
            ImageView imageView = (ImageView) C1287a.a(view, R.id.img_no_content);
            if (imageView != null) {
                i10 = R.id.txt_no_content;
                TextView textView = (TextView) C1287a.a(view, R.id.txt_no_content);
                if (textView != null) {
                    return new r((ConstraintLayout) view, emptyViewGroup, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static r c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.no_contact_fragment_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public ConstraintLayout b() {
        return this.f37775a;
    }
}

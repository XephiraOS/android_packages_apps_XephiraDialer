package x0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.coui.appcompat.grid.COUIPercentWidthFrameLayout;
import com.coui.appcompat.scrollview.COUIScrollView;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.SuitableSizeTextView;
import l0.C1287a;

/* compiled from: ImportContactsTipsFragmentLayoutBinding.java */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f37756a;

    /* renamed from: b, reason: collision with root package name */
    public final COUIScrollView f37757b;

    /* renamed from: c, reason: collision with root package name */
    public final FrameLayout f37758c;

    /* renamed from: d, reason: collision with root package name */
    public final SuitableSizeTextView f37759d;

    /* renamed from: e, reason: collision with root package name */
    public final SuitableSizeTextView f37760e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f37761f;

    /* renamed from: g, reason: collision with root package name */
    public final SuitableSizeTextView f37762g;

    /* renamed from: h, reason: collision with root package name */
    public final ImageView f37763h;

    /* renamed from: i, reason: collision with root package name */
    public final SuitableSizeTextView f37764i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f37765j;

    /* renamed from: k, reason: collision with root package name */
    public final SuitableSizeTextView f37766k;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f37767l;

    /* renamed from: m, reason: collision with root package name */
    public final SuitableSizeTextView f37768m;

    /* renamed from: n, reason: collision with root package name */
    public final ImageView f37769n;

    /* renamed from: o, reason: collision with root package name */
    public final SuitableSizeTextView f37770o;

    /* renamed from: p, reason: collision with root package name */
    public final ImageView f37771p;

    /* renamed from: q, reason: collision with root package name */
    public final COUIPercentWidthFrameLayout f37772q;

    /* renamed from: r, reason: collision with root package name */
    public final LinearLayout f37773r;

    /* renamed from: s, reason: collision with root package name */
    public final LinearLayout f37774s;

    public q(FrameLayout frameLayout, COUIScrollView cOUIScrollView, FrameLayout frameLayout2, SuitableSizeTextView suitableSizeTextView, SuitableSizeTextView suitableSizeTextView2, ImageView imageView, SuitableSizeTextView suitableSizeTextView3, ImageView imageView2, SuitableSizeTextView suitableSizeTextView4, ImageView imageView3, SuitableSizeTextView suitableSizeTextView5, ImageView imageView4, SuitableSizeTextView suitableSizeTextView6, ImageView imageView5, SuitableSizeTextView suitableSizeTextView7, ImageView imageView6, COUIPercentWidthFrameLayout cOUIPercentWidthFrameLayout, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.f37756a = frameLayout;
        this.f37757b = cOUIScrollView;
        this.f37758c = frameLayout2;
        this.f37759d = suitableSizeTextView;
        this.f37760e = suitableSizeTextView2;
        this.f37761f = imageView;
        this.f37762g = suitableSizeTextView3;
        this.f37763h = imageView2;
        this.f37764i = suitableSizeTextView4;
        this.f37765j = imageView3;
        this.f37766k = suitableSizeTextView5;
        this.f37767l = imageView4;
        this.f37768m = suitableSizeTextView6;
        this.f37769n = imageView5;
        this.f37770o = suitableSizeTextView7;
        this.f37771p = imageView6;
        this.f37772q = cOUIPercentWidthFrameLayout;
        this.f37773r = linearLayout;
        this.f37774s = linearLayout2;
    }

    public static q a(View view) {
        int i10 = R.id.contact_tips_view;
        COUIScrollView cOUIScrollView = (COUIScrollView) C1287a.a(view, R.id.contact_tips_view);
        if (cOUIScrollView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i10 = R.id.import_from_cloud_sync;
            SuitableSizeTextView suitableSizeTextView = (SuitableSizeTextView) C1287a.a(view, R.id.import_from_cloud_sync);
            if (suitableSizeTextView != null) {
                i10 = R.id.import_from_google_account;
                SuitableSizeTextView suitableSizeTextView2 = (SuitableSizeTextView) C1287a.a(view, R.id.import_from_google_account);
                if (suitableSizeTextView2 != null) {
                    i10 = R.id.import_from_google_account_divider;
                    ImageView imageView = (ImageView) C1287a.a(view, R.id.import_from_google_account_divider);
                    if (imageView != null) {
                        i10 = R.id.import_from_other_account;
                        SuitableSizeTextView suitableSizeTextView3 = (SuitableSizeTextView) C1287a.a(view, R.id.import_from_other_account);
                        if (suitableSizeTextView3 != null) {
                            i10 = R.id.import_from_other_account_divider;
                            ImageView imageView2 = (ImageView) C1287a.a(view, R.id.import_from_other_account_divider);
                            if (imageView2 != null) {
                                i10 = R.id.import_from_other_device;
                                SuitableSizeTextView suitableSizeTextView4 = (SuitableSizeTextView) C1287a.a(view, R.id.import_from_other_device);
                                if (suitableSizeTextView4 != null) {
                                    i10 = R.id.import_from_other_device_divider;
                                    ImageView imageView3 = (ImageView) C1287a.a(view, R.id.import_from_other_device_divider);
                                    if (imageView3 != null) {
                                        i10 = R.id.import_from_phone_clone;
                                        SuitableSizeTextView suitableSizeTextView5 = (SuitableSizeTextView) C1287a.a(view, R.id.import_from_phone_clone);
                                        if (suitableSizeTextView5 != null) {
                                            i10 = R.id.import_from_phone_clone_divider;
                                            ImageView imageView4 = (ImageView) C1287a.a(view, R.id.import_from_phone_clone_divider);
                                            if (imageView4 != null) {
                                                i10 = R.id.import_from_sim;
                                                SuitableSizeTextView suitableSizeTextView6 = (SuitableSizeTextView) C1287a.a(view, R.id.import_from_sim);
                                                if (suitableSizeTextView6 != null) {
                                                    i10 = R.id.import_from_sim_divider;
                                                    ImageView imageView5 = (ImageView) C1287a.a(view, R.id.import_from_sim_divider);
                                                    if (imageView5 != null) {
                                                        i10 = R.id.import_from_vcard;
                                                        SuitableSizeTextView suitableSizeTextView7 = (SuitableSizeTextView) C1287a.a(view, R.id.import_from_vcard);
                                                        if (suitableSizeTextView7 != null) {
                                                            i10 = R.id.import_from_vcard_divider;
                                                            ImageView imageView6 = (ImageView) C1287a.a(view, R.id.import_from_vcard_divider);
                                                            if (imageView6 != null) {
                                                                i10 = R.id.percent_layout;
                                                                COUIPercentWidthFrameLayout cOUIPercentWidthFrameLayout = (COUIPercentWidthFrameLayout) C1287a.a(view, R.id.percent_layout);
                                                                if (cOUIPercentWidthFrameLayout != null) {
                                                                    i10 = R.id.real_scroll_view;
                                                                    LinearLayout linearLayout = (LinearLayout) C1287a.a(view, R.id.real_scroll_view);
                                                                    if (linearLayout != null) {
                                                                        i10 = R.id.root_layout;
                                                                        LinearLayout linearLayout2 = (LinearLayout) C1287a.a(view, R.id.root_layout);
                                                                        if (linearLayout2 != null) {
                                                                            return new q(frameLayout, cOUIScrollView, frameLayout, suitableSizeTextView, suitableSizeTextView2, imageView, suitableSizeTextView3, imageView2, suitableSizeTextView4, imageView3, suitableSizeTextView5, imageView4, suitableSizeTextView6, imageView5, suitableSizeTextView7, imageView6, cOUIPercentWidthFrameLayout, linearLayout, linearLayout2);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static q c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.import_contacts_tips_fragment_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public FrameLayout b() {
        return this.f37756a;
    }
}

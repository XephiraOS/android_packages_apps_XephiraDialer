package t7;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.X;
import com.oplus.foundation.util.display.DisplayUtil;
import kotlin.jvm.internal.i;
import m7.e;
import r7.InterfaceC1512a;

/* compiled from: StatusBarPlaceHolderViewController.kt */
/* renamed from: t7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1595a {

    /* renamed from: a, reason: collision with root package name */
    public final int f37277a = e.f35187i;

    /* renamed from: b, reason: collision with root package name */
    public int f37278b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC1512a f37279c;

    /* renamed from: d, reason: collision with root package name */
    public Context f37280d;

    public final ImageView a(Context context, Drawable drawable, int i10) {
        ImageView imageView = new ImageView(context);
        imageView.setId(this.f37277a);
        imageView.setBackground(drawable);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, i10));
        return imageView;
    }

    public void b(Context context, InterfaceC1512a appBarConfig) {
        i.f(context, "context");
        i.f(appBarConfig, "appBarConfig");
        this.f37280d = context;
        this.f37279c = appBarConfig;
    }

    public void c(View contentView) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        i.f(contentView, "contentView");
        InterfaceC1512a interfaceC1512a = this.f37279c;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = null;
        if (interfaceC1512a == null) {
            i.q("appBarConfig");
            interfaceC1512a = null;
        }
        if (interfaceC1512a.w()) {
            InterfaceC1512a interfaceC1512a2 = this.f37279c;
            if (interfaceC1512a2 == null) {
                i.q("appBarConfig");
                interfaceC1512a2 = null;
            }
            if (!interfaceC1512a2.i0()) {
                InterfaceC1512a interfaceC1512a3 = this.f37279c;
                if (interfaceC1512a3 == null) {
                    i.q("appBarConfig");
                    interfaceC1512a3 = null;
                }
                ViewGroup viewGroup = (ViewGroup) contentView.findViewById(interfaceC1512a3.J());
                if (viewGroup != null) {
                    InterfaceC1512a interfaceC1512a4 = this.f37279c;
                    if (interfaceC1512a4 == null) {
                        i.q("appBarConfig");
                        interfaceC1512a4 = null;
                    }
                    ViewGroup viewGroup2 = (ViewGroup) contentView.findViewById(interfaceC1512a4.a0());
                    if (viewGroup2 != null) {
                        i.e(viewGroup2, "findViewById<ViewGroup>(…ContentContainerLayoutId)");
                        Context context = this.f37280d;
                        if (context == null) {
                            i.q("context");
                            context = null;
                        }
                        int g10 = DisplayUtil.g(context);
                        if (g10 > 0) {
                            Context context2 = this.f37280d;
                            if (context2 == null) {
                                i.q("context");
                                context2 = null;
                            }
                            InterfaceC1512a interfaceC1512a5 = this.f37279c;
                            if (interfaceC1512a5 == null) {
                                i.q("appBarConfig");
                                interfaceC1512a5 = null;
                            }
                            ImageView a10 = a(context2, interfaceC1512a5.Y(), g10);
                            if (a10.getParent() == null) {
                                viewGroup.addView(a10, 0, a10.getLayoutParams());
                            }
                            ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
                            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            } else {
                                marginLayoutParams = null;
                            }
                            if (marginLayoutParams != null) {
                                marginLayoutParams.topMargin = g10;
                                marginLayoutParams2 = marginLayoutParams;
                            }
                            if (marginLayoutParams2 != null) {
                                viewGroup2.setLayoutParams(marginLayoutParams2);
                            }
                        }
                    }
                }
            }
        }
    }

    public void d(View contentView, X windowInsets) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        i.f(contentView, "contentView");
        i.f(windowInsets, "windowInsets");
        InterfaceC1512a interfaceC1512a = this.f37279c;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = null;
        if (interfaceC1512a == null) {
            i.q("appBarConfig");
            interfaceC1512a = null;
        }
        if (interfaceC1512a.w()) {
            InterfaceC1512a interfaceC1512a2 = this.f37279c;
            if (interfaceC1512a2 == null) {
                i.q("appBarConfig");
                interfaceC1512a2 = null;
            }
            if (interfaceC1512a2.i0()) {
                InterfaceC1512a interfaceC1512a3 = this.f37279c;
                if (interfaceC1512a3 == null) {
                    i.q("appBarConfig");
                    interfaceC1512a3 = null;
                }
                ViewGroup viewGroup = (ViewGroup) contentView.findViewById(interfaceC1512a3.J());
                if (viewGroup != null) {
                    InterfaceC1512a interfaceC1512a4 = this.f37279c;
                    if (interfaceC1512a4 == null) {
                        i.q("appBarConfig");
                        interfaceC1512a4 = null;
                    }
                    ViewGroup viewGroup2 = (ViewGroup) contentView.findViewById(interfaceC1512a4.a0());
                    if (viewGroup2 != null) {
                        i.e(viewGroup2, "findViewById<ViewGroup>(…ContentContainerLayoutId)");
                        Context context = this.f37280d;
                        if (context == null) {
                            i.q("context");
                            context = null;
                        }
                        int g10 = DisplayUtil.g(context);
                        if (this.f37278b != g10) {
                            if (g10 > 0) {
                                View findViewById = viewGroup.findViewById(this.f37277a);
                                if (findViewById == null) {
                                    Context context2 = this.f37280d;
                                    if (context2 == null) {
                                        i.q("context");
                                        context2 = null;
                                    }
                                    InterfaceC1512a interfaceC1512a5 = this.f37279c;
                                    if (interfaceC1512a5 == null) {
                                        i.q("appBarConfig");
                                        interfaceC1512a5 = null;
                                    }
                                    findViewById = a(context2, interfaceC1512a5.Y(), g10);
                                } else {
                                    ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                                    if (layoutParams != null) {
                                        i.e(layoutParams, "layoutParams");
                                        layoutParams.height = g10;
                                    } else {
                                        layoutParams = null;
                                    }
                                    findViewById.setLayoutParams(layoutParams);
                                }
                                if (findViewById.getParent() == null) {
                                    viewGroup.addView(findViewById, 0, findViewById.getLayoutParams());
                                }
                            } else {
                                View findViewById2 = viewGroup.findViewById(this.f37277a);
                                if (findViewById2 != null) {
                                    i.e(findViewById2, "findViewById<View>(placeViewNameId)");
                                    viewGroup.removeView(findViewById2);
                                }
                            }
                            ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
                            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                            } else {
                                marginLayoutParams = null;
                            }
                            if (marginLayoutParams != null) {
                                marginLayoutParams.topMargin = g10;
                                marginLayoutParams2 = marginLayoutParams;
                            }
                            if (marginLayoutParams2 != null) {
                                viewGroup2.setLayoutParams(marginLayoutParams2);
                            }
                            this.f37278b = g10;
                        }
                    }
                }
            }
        }
    }
}

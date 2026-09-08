package S3;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.oplus.dialer.R;
import com.oplus.foundation.util.display.DisplayUtil;

/* compiled from: PanelRotateController.kt */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final View f3459a;

    /* renamed from: b, reason: collision with root package name */
    public final Activity f3460b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3461c;

    /* renamed from: d, reason: collision with root package name */
    public int f3462d;

    public i(View view, Activity activity, boolean z10) {
        kotlin.jvm.internal.i.f(view, "view");
        kotlin.jvm.internal.i.f(activity, "activity");
        this.f3459a = view;
        this.f3460b = activity;
        this.f3461c = z10;
    }

    public final void a(int i10, boolean z10) {
        ViewPropertyAnimator viewPropertyAnimator;
        ImageView imageView = (ImageView) this.f3460b.findViewById(R.id.back_icon);
        ViewParent viewParent = null;
        if (imageView != null) {
            viewPropertyAnimator = imageView.animate();
        } else {
            viewPropertyAnimator = null;
        }
        if (imageView != null) {
            viewParent = imageView.getParent();
        }
        kotlin.jvm.internal.i.d(viewParent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) viewParent;
        if (viewPropertyAnimator != null) {
            if (z10) {
                viewPropertyAnimator.setDuration(300L);
            } else {
                viewPropertyAnimator.setDuration(0L);
            }
            float dimension = viewGroup.getResources().getDimension(R.dimen.DP_10);
            float dimension2 = viewGroup.getResources().getDimension(R.dimen.DP_34);
            if (i10 != 0) {
                if (i10 != 90) {
                    if (i10 != 180) {
                        if (i10 == 270) {
                            if (imageView.getRotation() < 0.0f && this.f3462d == 180) {
                                imageView.setRotation(180.0f);
                            }
                            viewPropertyAnimator.rotation(90.0f);
                            viewPropertyAnimator.translationX(((((((-imageView.getHeight()) / 2) - (imageView.getWidth() / 2)) - dimension) + viewGroup.getWidth()) - dimension2) + 0.0f);
                            viewPropertyAnimator.translationY(((((imageView.getHeight() / 2) - (imageView.getWidth() / 2)) + 0.0f) - dimension2) + dimension);
                            viewPropertyAnimator.start();
                            return;
                        }
                        return;
                    }
                    if (this.f3462d == 90) {
                        viewPropertyAnimator.rotation(-180.0f);
                    } else {
                        viewPropertyAnimator.rotation(180.0f);
                    }
                    float f10 = 2;
                    viewPropertyAnimator.translationX((viewGroup.getWidth() - imageView.getWidth()) - (dimension * f10));
                    viewPropertyAnimator.translationY((viewGroup.getHeight() - imageView.getHeight()) - (f10 * dimension2));
                    viewPropertyAnimator.start();
                    return;
                }
                if (imageView.getRotation() > 0.0f && this.f3462d == 180) {
                    imageView.setRotation(-180.0f);
                }
                viewPropertyAnimator.rotation(-90.0f);
                viewPropertyAnimator.translationX(((((imageView.getHeight() / 2) - (imageView.getWidth() / 2)) + dimension2) - dimension) + 0.0f);
                if (!com.android.contacts.framework.baseui.util.n.b()) {
                    viewPropertyAnimator.translationY((((((viewGroup.getHeight() - dimension2) - dimension) - (imageView.getHeight() / 2)) - (imageView.getWidth() / 2)) + 0.0f) - DisplayUtil.d(this.f3460b));
                } else {
                    viewPropertyAnimator.translationY(((((viewGroup.getHeight() - dimension2) - dimension) - (imageView.getHeight() / 2)) - (imageView.getWidth() / 2)) + 0.0f);
                }
                viewPropertyAnimator.start();
                return;
            }
            viewPropertyAnimator.rotation(0.0f);
            viewPropertyAnimator.translationX(0.0f);
            viewPropertyAnimator.translationY(0.0f);
            viewPropertyAnimator.start();
        }
    }

    public final void b(int i10, boolean z10) {
        LinearLayout linearLayout = (LinearLayout) this.f3459a.findViewById(R.id.ll_panel);
        if (linearLayout == null) {
            return;
        }
        ViewPropertyAnimator animate = linearLayout.animate();
        if (animate != null) {
            animate.cancel();
        }
        View view = this.f3459a;
        if (animate != null) {
            float dimension = view.getResources().getDimension(R.dimen.DP_16);
            if (z10) {
                animate.setDuration(300L);
            } else {
                animate.setDuration(0L);
            }
            if (i10 != 0) {
                if (i10 != 90) {
                    if (i10 != 180) {
                        if (i10 == 270) {
                            if (linearLayout.getRotation() < 0.0f && this.f3462d == 180) {
                                linearLayout.setRotation(180.0f);
                            }
                            animate.rotation(90.0f);
                            animate.translationX(-(((view.getWidth() / 2) - dimension) - (linearLayout.getWidth() / 2)));
                            if (!com.android.contacts.framework.baseui.util.n.b()) {
                                animate.translationY((((view.getHeight() - linearLayout.getWidth()) * 0.5f) - dimension) - DisplayUtil.d(this.f3460b));
                            } else {
                                animate.translationY(((view.getHeight() - linearLayout.getWidth()) * 0.5f) - dimension);
                            }
                            animate.start();
                            return;
                        }
                        return;
                    }
                    if (this.f3462d == 90) {
                        animate.rotation(-180.0f);
                    } else {
                        animate.rotation(180.0f);
                    }
                    animate.translationX((-view.getWidth()) + linearLayout.getWidth() + (dimension * 2));
                    animate.translationY(0.0f);
                    animate.start();
                    return;
                }
                if (linearLayout.getRotation() > 0.0f && this.f3462d == 180) {
                    linearLayout.setRotation(-180.0f);
                }
                animate.rotation(-90.0f);
                animate.translationX(-(((view.getWidth() / 2) - dimension) - (linearLayout.getWidth() / 2)));
                animate.translationY((((-view.getHeight()) + linearLayout.getWidth()) * 0.5f) + dimension);
                animate.start();
                return;
            }
            animate.rotation(0.0f);
            animate.translationX(0.0f);
            animate.translationY(0.0f);
            animate.start();
        }
    }

    public final void c(int i10, boolean z10) {
        if (!this.f3461c) {
            b(i10, z10);
            d(i10, z10);
            a(i10, z10);
            this.f3462d = i10;
        }
    }

    public final void d(int i10, boolean z10) {
        RelativeLayout relativeLayout = (RelativeLayout) this.f3459a.findViewById(R.id.rl_menu_panel);
        if (relativeLayout == null) {
            return;
        }
        ViewPropertyAnimator animate = relativeLayout.animate();
        if (animate != null) {
            animate.cancel();
        }
        View view = this.f3459a;
        if (animate != null) {
            float dimension = view.getResources().getDimension(R.dimen.DP_60);
            if (z10) {
                animate.setDuration(300L);
            } else {
                animate.setDuration(0L);
            }
            if (i10 != 0) {
                if (i10 != 90) {
                    if (i10 != 180) {
                        if (i10 == 270) {
                            if (relativeLayout.getRotation() < 0.0f && this.f3462d == 180) {
                                relativeLayout.setRotation(180.0f);
                            }
                            animate.rotation(90.0f);
                            animate.translationX((-((view.getWidth() / 2) - (relativeLayout.getHeight() / 2))) + dimension);
                            animate.translationY((-((view.getHeight() / 2) - (relativeLayout.getHeight() / 2))) + dimension);
                            animate.start();
                            return;
                        }
                        return;
                    }
                    if (this.f3462d == 90) {
                        animate.rotation(-180.0f);
                    } else {
                        animate.rotation(180.0f);
                    }
                    animate.translationX(0.0f);
                    animate.translationY((-(view.getHeight() - relativeLayout.getHeight())) + (dimension * 2));
                    animate.start();
                    return;
                }
                if (relativeLayout.getRotation() > 0.0f && this.f3462d == 180) {
                    relativeLayout.setRotation(-180.0f);
                }
                animate.rotation(-90.0f);
                animate.translationX(((view.getWidth() / 2) - (relativeLayout.getHeight() / 2)) - dimension);
                animate.translationY((-((view.getHeight() / 2) - (relativeLayout.getHeight() / 2))) + dimension);
                animate.start();
                return;
            }
            animate.rotation(0.0f);
            animate.translationX(0.0f);
            animate.translationY(0.0f);
            animate.start();
        }
    }
}

package U0;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.TextView;
import com.android.contacts.framework.baseui.util.StatementUtils;
import com.android.contacts.framework.baseui.util.u;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.panel.COUIBottomSheetDialog;
import com.coui.appcompat.statement.COUILinkMovementMethod;
import com.coui.appcompat.statement.COUIUserStatementDialog;
import com.oplus.anim.EffectiveAnimationView;
import com.oplus.foundation.util.feature.CommonFeatureOption;

/* compiled from: DialogCreator.kt */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a */
    public static final k f3819a = new k();

    /* compiled from: DialogCreator.kt */
    /* loaded from: classes.dex */
    public static final class a implements ViewTreeObserver.OnWindowAttachListener {

        /* renamed from: a */
        public final /* synthetic */ EffectiveAnimationView f3820a;

        public a(EffectiveAnimationView effectiveAnimationView) {
            this.f3820a = effectiveAnimationView;
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowAttached() {
            EffectiveAnimationView effectiveAnimationView = this.f3820a;
            if (effectiveAnimationView != null) {
                effectiveAnimationView.playAnimation();
            }
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowDetached() {
            EffectiveAnimationView effectiveAnimationView = this.f3820a;
            if (effectiveAnimationView != null) {
                effectiveAnimationView.pauseAnimation();
            }
        }
    }

    public static final COUIBottomSheetDialog d(Context context, int i10, CharSequence statementContent, CharSequence referText, int i11, int i12, COUIUserStatementDialog.OnButtonClickListener listener) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(statementContent, "statementContent");
        kotlin.jvm.internal.i.f(referText, "referText");
        kotlin.jvm.internal.i.f(listener, "listener");
        COUIUserStatementDialog cOUIUserStatementDialog = new COUIUserStatementDialog(context, 0, 0.0f, 0.0f, 14, null);
        cOUIUserStatementDialog.setIsShowInMaxHeight(false);
        cOUIUserStatementDialog.setLogoDrawable(context.getDrawable(N0.g.f1905e));
        cOUIUserStatementDialog.setAppName(context.getString(N0.k.f1975q));
        cOUIUserStatementDialog.setTitleText(context.getString(i10));
        cOUIUserStatementDialog.setStatement(statementContent);
        cOUIUserStatementDialog.setProtocolText(referText);
        cOUIUserStatementDialog.setBottomButtonText(context.getString(i11));
        cOUIUserStatementDialog.setExitButtonText(context.getString(i12));
        cOUIUserStatementDialog.setOnButtonClickListener(listener);
        cOUIUserStatementDialog.setCanceledOnTouchOutside(false);
        return cOUIUserStatementDialog;
    }

    public static final androidx.appcompat.app.b e(Context context, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        kotlin.jvm.internal.i.f(context, "context");
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(context);
        cOUIAlertDialogBuilder.setTitle(N0.k.f1963e);
        if (onClickListener != null) {
            cOUIAlertDialogBuilder.setPositiveButton(N0.k.f1971m, onClickListener);
        }
        if (onClickListener2 != null) {
            cOUIAlertDialogBuilder.setNegativeButton(R.string.cancel, onClickListener2);
        }
        androidx.appcompat.app.b show = cOUIAlertDialogBuilder.show();
        kotlin.jvm.internal.i.e(show, "builder.show()");
        return show;
    }

    public static final androidx.appcompat.app.b f(Context context, boolean z10, Runnable runnable, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        kotlin.jvm.internal.i.f(context, "context");
        return h(context, z10, runnable, onClickListener, onClickListener2, null, 32, null);
    }

    public static final androidx.appcompat.app.b g(Context context, boolean z10, final Runnable runnable, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, StatementUtils.DialogType dialogType) {
        int i10;
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(dialogType, "dialogType");
        if (dialogType == StatementUtils.DialogType.UPDATE) {
            i10 = N0.k.f1957G;
        } else {
            i10 = N0.k.f1960b;
        }
        String string = context.getString(i10);
        kotlin.jvm.internal.i.e(string, "context.getString(if (di…e_information_processing)");
        androidx.appcompat.app.b p10 = p(context, string, StatementUtils.l(context, dialogType), u.b(context, false, z10, null, null, null, 56, null), N0.k.f1959a, N0.k.f1967i, onClickListener, onClickListener2);
        p10.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: U0.j
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
                boolean i12;
                i12 = k.i(runnable, dialogInterface, i11, keyEvent);
                return i12;
            }
        });
        p10.setCanceledOnTouchOutside(false);
        return p10;
    }

    public static /* synthetic */ androidx.appcompat.app.b h(Context context, boolean z10, Runnable runnable, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, StatementUtils.DialogType dialogType, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            dialogType = StatementUtils.DialogType.NORMAL;
        }
        return g(context, z10, runnable, onClickListener, onClickListener2, dialogType);
    }

    public static final boolean i(Runnable runnable, DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (i10 == 4 && keyEvent != null && keyEvent.getAction() == 1) {
            if (runnable == null) {
                return true;
            }
            runnable.run();
            return true;
        }
        return false;
    }

    public static final androidx.appcompat.app.b j(Context context, String title, DialogInterface.OnClickListener onClickListener) {
        kotlin.jvm.internal.i.f(title, "title");
        return l(context, title, onClickListener, false, 8, null);
    }

    public static final androidx.appcompat.app.b k(Context context, String title, DialogInterface.OnClickListener onClickListener, boolean z10) {
        kotlin.jvm.internal.i.f(title, "title");
        if (context != null) {
            COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(context, N0.l.f1986b);
            cOUIAlertDialogBuilder.setTitle((CharSequence) title).setCancelable(false);
            if (z10) {
                cOUIAlertDialogBuilder.setPositiveButton((CharSequence) context.getString(R.string.cancel), onClickListener);
            }
            androidx.appcompat.app.b create = cOUIAlertDialogBuilder.create();
            kotlin.jvm.internal.i.e(create, "builder.create()");
            create.setCanceledOnTouchOutside(false);
            return create;
        }
        return null;
    }

    public static /* synthetic */ androidx.appcompat.app.b l(Context context, String str, DialogInterface.OnClickListener onClickListener, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        return k(context, str, onClickListener, z10);
    }

    public static final COUIBottomSheetDialog m(Context context, final Runnable runnable, COUIUserStatementDialog.OnButtonClickListener listener) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(listener, "listener");
        final COUIBottomSheetDialog d10 = d(context, N0.k.f1958H, StatementUtils.o(context, CommonFeatureOption.f28289a.f()), u.g(context, false, null, 6, null), N0.k.f1959a, N0.k.f1968j, listener);
        d10.setIsShowInMaxHeight(true);
        d10.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: U0.i
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                boolean n10;
                n10 = k.n(COUIBottomSheetDialog.this, runnable, dialogInterface, i10, keyEvent);
                return n10;
            }
        });
        return d10;
    }

    public static final boolean n(COUIBottomSheetDialog this_apply, Runnable runnable, DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        kotlin.jvm.internal.i.f(this_apply, "$this_apply");
        if (i10 == 4 && keyEvent != null && keyEvent.getAction() == 1) {
            this_apply.dismiss();
            if (runnable != null) {
                runnable.run();
                return false;
            }
            return false;
        }
        return false;
    }

    public static final androidx.appcompat.app.b o(Context context, String title) {
        kotlin.jvm.internal.i.f(title, "title");
        if (context != null) {
            androidx.appcompat.app.b show = new COUIAlertDialogBuilder(context, N0.l.f1987c).setCancelable(false).show();
            show.setCanceledOnTouchOutside(false);
            f3819a.c(show, title);
            return show;
        }
        return null;
    }

    public static final androidx.appcompat.app.b p(Context context, String title, CharSequence statement, SpannableString referText, int i10, int i11, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(title, "title");
        kotlin.jvm.internal.i.f(statement, "statement");
        kotlin.jvm.internal.i.f(referText, "referText");
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(context);
        cOUIAlertDialogBuilder.setTitle((CharSequence) title);
        cOUIAlertDialogBuilder.setMessage((CharSequence) new SpannableStringBuilder(statement).append((CharSequence) "\n").append((CharSequence) referText));
        if (onClickListener != null) {
            cOUIAlertDialogBuilder.setPositiveButton(i10, onClickListener);
        }
        if (onClickListener2 != null) {
            cOUIAlertDialogBuilder.setNegativeButton(i11, onClickListener2);
        }
        androidx.appcompat.app.b show = cOUIAlertDialogBuilder.show();
        kotlin.jvm.internal.i.e(show, "COUIAlertDialogBuilder(c…       }\n        }.show()");
        TextView textView = (TextView) show.findViewById(R.id.message);
        if (textView != null) {
            textView.setMovementMethod(COUILinkMovementMethod.INSTANCE);
        }
        show.setCanceledOnTouchOutside(false);
        return show;
    }

    public final void c(androidx.appcompat.app.b bVar, String str) {
        Window window;
        View decorView;
        if (bVar != null && (window = bVar.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            EffectiveAnimationView effectiveAnimationView = (EffectiveAnimationView) decorView.findViewById(N0.i.f1941s);
            TextView textView = (TextView) decorView.findViewById(N0.i.f1943u);
            if (textView != null) {
                textView.setText(str);
            }
            ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnWindowAttachListener(new a(effectiveAnimationView));
            }
        }
    }
}

package com.android.incallui.foldscreen.presentation.controller;

import J1.e;
import J1.g;
import P1.c;
import P1.d;
import P1.f;
import W1.b;
import Y1.a;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.K;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.incallui.Log;
import com.android.incallui.foldscreen.presentation.controller.RespondViaSmsManager;
import com.coui.appcompat.panel.COUIBottomSheetDialog;
import com.coui.appcompat.scrollbar.COUIScrollBar;
import com.oplus.anim.EffectiveAnimationView;
import f.C0991a;
import j.C1147d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.i;
import m9.q;
import v9.l;

/* compiled from: RespondViaSmsManager.kt */
/* loaded from: classes.dex */
public final class RespondViaSmsManager extends Handler {

    /* renamed from: b, reason: collision with root package name */
    public static Integer f18414b;

    /* renamed from: e, reason: collision with root package name */
    public static final e f18417e;

    /* renamed from: f, reason: collision with root package name */
    public static final g f18418f;

    /* renamed from: g, reason: collision with root package name */
    public static COUIBottomSheetDialog f18419g;

    /* renamed from: a, reason: collision with root package name */
    public static final RespondViaSmsManager f18413a = new RespondViaSmsManager();

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f18415c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public static final RespondViaSmsManager$messageSentReceiver$1 f18416d = new RespondViaSmsManager$messageSentReceiver$1();

    static {
        a aVar = a.f5520a;
        f18417e = aVar.d();
        f18418f = aVar.g();
    }

    public RespondViaSmsManager() {
        super(Looper.getMainLooper());
    }

    public static final void h(COUIBottomSheetDialog this_apply, Context context, DialogInterface dialogInterface) {
        i.f(this_apply, "$this_apply");
        i.f(context, "$context");
        this_apply.setPanelBackground(C0991a.b(context, c.f2833a));
        L1.a.a(this_apply);
    }

    public static final void i(Context dialogContext, DialogInterface dialogInterface) {
        i.f(dialogContext, "$dialogContext");
        f18416d.b(dialogContext);
    }

    public final void e(int i10) {
        if (hasMessages(9000)) {
            Log.d("RespondViaSmsManager", "checkSmsSentStatus: pending check sms sent status for anim");
            f18414b = Integer.valueOf(i10);
            return;
        }
        Log.d("RespondViaSmsManager", "checkSmsSentStatus: resultCode = " + i10);
        if (i10 == -1) {
            t();
        } else {
            s();
        }
        f18414b = null;
        removeMessages(9001);
        sendEmptyMessageDelayed(9002, COUIScrollBar.SCROLLER_FADE_TIMEOUT);
    }

    public final Context f(Context context) {
        Integer num;
        i.f(context, "context");
        Display c10 = L1.c.c(context);
        StringBuilder sb = new StringBuilder();
        sb.append("createFoldScreenPresentationContext: dragonflyDisplay is ");
        if (c10 != null) {
            num = Integer.valueOf(c10.getDisplayId());
        } else {
            num = null;
        }
        sb.append(num);
        Log.d("RespondViaSmsManager", sb.toString());
        return new C1147d(L1.c.e(context, c10, 2038), P1.g.f2878b);
    }

    public final COUIBottomSheetDialog g(final Context context, ArrayList<String> arrayList) {
        final Context f10 = f(context);
        final COUIBottomSheetDialog cOUIBottomSheetDialog = new COUIBottomSheetDialog(f10, P1.g.f2877a);
        View inflate = cOUIBottomSheetDialog.getLayoutInflater().inflate(P1.e.f2866c, (ViewGroup) null);
        if (inflate != null) {
            i.e(inflate, "inflate(R.layout.fold_sc…log_content_layout, null)");
            COUIRecyclerView cOUIRecyclerView = (COUIRecyclerView) inflate.findViewById(d.f2857p);
            if (cOUIRecyclerView != null) {
                i.e(cOUIRecyclerView, "findViewById<COUIRecyclerView>(R.id.sms_content)");
                cOUIRecyclerView.setLayoutManager(new LinearLayoutManager(f10));
                cOUIRecyclerView.setAdapter(new b(arrayList, new l<String, q>() { // from class: com.android.incallui.foldscreen.presentation.controller.RespondViaSmsManager$createSmsRespondListDialog$1$1$1$1
                    @Override // v9.l
                    public /* bridge */ /* synthetic */ q invoke(String str) {
                        invoke2(str);
                        return q.f35511a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it) {
                        i.f(it, "it");
                        RespondViaSmsManager respondViaSmsManager = RespondViaSmsManager.f18413a;
                        respondViaSmsManager.r();
                        respondViaSmsManager.j(it);
                    }
                }));
                K.y0(cOUIRecyclerView, true);
            }
            cOUIBottomSheetDialog.setContentView(inflate);
        }
        cOUIBottomSheetDialog.getWindow().setType(2038);
        cOUIBottomSheetDialog.setIsShowInMaxHeight(true);
        cOUIBottomSheetDialog.setCanceledOnTouchOutside(false);
        cOUIBottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: X1.a
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                RespondViaSmsManager.h(COUIBottomSheetDialog.this, context, dialogInterface);
            }
        });
        cOUIBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: X1.b
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                RespondViaSmsManager.i(f10, dialogInterface);
            }
        });
        return cOUIBottomSheetDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Integer num;
        if (message != null) {
            num = Integer.valueOf(message.what);
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 9000) {
            Integer num2 = f18414b;
            if (num2 != null) {
                f18413a.e(num2.intValue());
                return;
            }
            return;
        }
        if (num != null && num.intValue() == 9001) {
            e(0);
        } else if (num != null && num.intValue() == 9002) {
            k(true);
        }
    }

    public final void j(String str) {
        Context context;
        f18417e.e().b(str);
        f18418f.i().m(Boolean.TRUE);
        RespondViaSmsManager$messageSentReceiver$1 respondViaSmsManager$messageSentReceiver$1 = f18416d;
        COUIBottomSheetDialog cOUIBottomSheetDialog = f18419g;
        if (cOUIBottomSheetDialog != null) {
            context = cOUIBottomSheetDialog.getContext();
        } else {
            context = null;
        }
        respondViaSmsManager$messageSentReceiver$1.a(context);
    }

    public final void k(boolean z10) {
        if (!z10 && f18415c.get()) {
            Log.d("RespondViaSmsManager", "dismissSmsRespondListDialog: is showing sms result to user , ignore");
            return;
        }
        Log.d("RespondViaSmsManager", "dismissSmsRespondListDialog: isForce = " + z10);
        f18415c.set(false);
        removeMessages(9000);
        removeMessages(9001);
        removeMessages(9002);
        f18414b = null;
        COUIBottomSheetDialog cOUIBottomSheetDialog = f18419g;
        if (cOUIBottomSheetDialog != null) {
            cOUIBottomSheetDialog.dismiss();
        }
        f18419g = null;
    }

    public final COUIRecyclerView l() {
        View contentView;
        COUIBottomSheetDialog cOUIBottomSheetDialog = f18419g;
        if (cOUIBottomSheetDialog != null && (contentView = cOUIBottomSheetDialog.getContentView()) != null) {
            return (COUIRecyclerView) contentView.findViewById(d.f2857p);
        }
        return null;
    }

    public final EffectiveAnimationView m() {
        View contentView;
        COUIBottomSheetDialog cOUIBottomSheetDialog = f18419g;
        if (cOUIBottomSheetDialog != null && (contentView = cOUIBottomSheetDialog.getContentView()) != null) {
            return (EffectiveAnimationView) contentView.findViewById(d.f2859r);
        }
        return null;
    }

    public final EffectiveAnimationView n() {
        View contentView;
        COUIBottomSheetDialog cOUIBottomSheetDialog = f18419g;
        if (cOUIBottomSheetDialog != null && (contentView = cOUIBottomSheetDialog.getContentView()) != null) {
            return (EffectiveAnimationView) contentView.findViewById(d.f2860s);
        }
        return null;
    }

    public final View o() {
        View contentView;
        COUIBottomSheetDialog cOUIBottomSheetDialog = f18419g;
        if (cOUIBottomSheetDialog != null && (contentView = cOUIBottomSheetDialog.getContentView()) != null) {
            return contentView.findViewById(d.f2856o);
        }
        return null;
    }

    public final TextView p() {
        View contentView;
        COUIBottomSheetDialog cOUIBottomSheetDialog = f18419g;
        if (cOUIBottomSheetDialog != null && (contentView = cOUIBottomSheetDialog.getContentView()) != null) {
            return (TextView) contentView.findViewById(d.f2862u);
        }
        return null;
    }

    public final EffectiveAnimationView q() {
        View contentView;
        COUIBottomSheetDialog cOUIBottomSheetDialog = f18419g;
        if (cOUIBottomSheetDialog != null && (contentView = cOUIBottomSheetDialog.getContentView()) != null) {
            return (EffectiveAnimationView) contentView.findViewById(d.f2861t);
        }
        return null;
    }

    public final void r() {
        String str;
        Context context;
        Resources resources;
        Log.d("RespondViaSmsManager", "onDeclineIncomingCallWithSms: ");
        f18415c.set(true);
        sendEmptyMessageDelayed(9000, 500L);
        sendEmptyMessageDelayed(9001, 15000L);
        COUIRecyclerView l10 = l();
        if (l10 != null) {
            l10.setVisibility(8);
        }
        View o10 = o();
        if (o10 != null) {
            o10.setVisibility(0);
        }
        EffectiveAnimationView n10 = n();
        if (n10 != null) {
            n10.setVisibility(0);
            n10.playAnimation();
        }
        EffectiveAnimationView q10 = q();
        if (q10 != null) {
            q10.setVisibility(8);
            q10.cancelAnimation();
        }
        EffectiveAnimationView m10 = m();
        if (m10 != null) {
            m10.setVisibility(8);
            m10.cancelAnimation();
        }
        TextView p10 = p();
        if (p10 != null) {
            p10.setVisibility(0);
            COUIBottomSheetDialog cOUIBottomSheetDialog = f18419g;
            if (cOUIBottomSheetDialog != null && (context = cOUIBottomSheetDialog.getContext()) != null && (resources = context.getResources()) != null) {
                str = resources.getString(f.f2875b);
            } else {
                str = null;
            }
            p10.setText(str);
        }
    }

    public final void s() {
        String str;
        Context context;
        Resources resources;
        Log.d("RespondViaSmsManager", "onDeclineSmsSentFail: ");
        COUIRecyclerView l10 = l();
        if (l10 != null) {
            l10.setVisibility(8);
        }
        View o10 = o();
        if (o10 != null) {
            o10.setVisibility(0);
        }
        EffectiveAnimationView n10 = n();
        if (n10 != null) {
            n10.setVisibility(8);
            n10.cancelAnimation();
        }
        EffectiveAnimationView q10 = q();
        if (q10 != null) {
            q10.setVisibility(8);
            q10.cancelAnimation();
        }
        EffectiveAnimationView m10 = m();
        if (m10 != null) {
            m10.setVisibility(0);
            m10.playAnimation();
        }
        TextView p10 = p();
        if (p10 != null) {
            p10.setVisibility(0);
            COUIBottomSheetDialog cOUIBottomSheetDialog = f18419g;
            if (cOUIBottomSheetDialog != null && (context = cOUIBottomSheetDialog.getContext()) != null && (resources = context.getResources()) != null) {
                str = resources.getString(f.f2874a);
            } else {
                str = null;
            }
            p10.setText(str);
        }
    }

    public final void t() {
        String str;
        Context context;
        Resources resources;
        Log.d("RespondViaSmsManager", "onDeclineSmsSentSuccess: ");
        COUIRecyclerView l10 = l();
        if (l10 != null) {
            l10.setVisibility(8);
        }
        View o10 = o();
        if (o10 != null) {
            o10.setVisibility(0);
        }
        EffectiveAnimationView n10 = n();
        if (n10 != null) {
            n10.setVisibility(8);
            n10.cancelAnimation();
        }
        EffectiveAnimationView q10 = q();
        if (q10 != null) {
            q10.setVisibility(0);
            q10.playAnimation();
        }
        EffectiveAnimationView m10 = m();
        if (m10 != null) {
            m10.setVisibility(8);
            m10.cancelAnimation();
        }
        TextView p10 = p();
        if (p10 != null) {
            p10.setVisibility(0);
            COUIBottomSheetDialog cOUIBottomSheetDialog = f18419g;
            if (cOUIBottomSheetDialog != null && (context = cOUIBottomSheetDialog.getContext()) != null && (resources = context.getResources()) != null) {
                str = resources.getString(f.f2876c);
            } else {
                str = null;
            }
            p10.setText(str);
        }
    }

    public final void u(Context context, ArrayList<String> refuseList) {
        i.f(context, "context");
        i.f(refuseList, "refuseList");
        k(true);
        COUIBottomSheetDialog g10 = g(context, refuseList);
        f18419g = g10;
        if (g10 != null) {
            g10.show();
        }
    }
}

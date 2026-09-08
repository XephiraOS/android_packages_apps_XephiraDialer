package androidx.core.widget;

import H.b;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TextViewCompat.java */
/* loaded from: classes.dex */
public final class k {

    /* compiled from: TextViewCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        public static void a(TextView textView, int i10) {
            textView.setBreakStrategy(i10);
        }

        public static void b(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        public static void c(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        public static void d(TextView textView, int i10) {
            textView.setHyphenationFrequency(i10);
        }
    }

    /* compiled from: TextViewCompat.java */
    /* loaded from: classes.dex */
    public static class c {
        public static void a(TextView textView, int i10, float f10) {
            textView.setLineHeight(i10, f10);
        }
    }

    /* compiled from: TextViewCompat.java */
    /* loaded from: classes.dex */
    public static class d implements ActionMode.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f9566a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f9567b;

        /* renamed from: c, reason: collision with root package name */
        public Class<?> f9568c;

        /* renamed from: d, reason: collision with root package name */
        public Method f9569d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f9570e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f9571f;

        public final Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        public final Intent b(ResolveInfo resolveInfo, TextView textView) {
            Intent putExtra = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !e(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return putExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        public final List<ResolveInfo> c(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(a(), 0)) {
                if (f(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        public ActionMode.Callback d() {
            return this.f9566a;
        }

        public final boolean e(TextView textView) {
            if ((textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled()) {
                return true;
            }
            return false;
        }

        public final boolean f(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            if (str == null || context.checkSelfPermission(str) == 0) {
                return true;
            }
            return false;
        }

        public final void g(Menu menu) {
            Method declaredMethod;
            Context context = this.f9567b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f9571f) {
                this.f9571f = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f9568c = cls;
                    this.f9569d = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.f9570e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f9568c = null;
                    this.f9569d = null;
                    this.f9570e = false;
                }
            }
            try {
                if (this.f9570e && this.f9568c.isInstance(menu)) {
                    declaredMethod = this.f9569d;
                } else {
                    declaredMethod = menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                }
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List<ResolveInfo> c10 = c(context, packageManager);
                for (int i10 = 0; i10 < c10.size(); i10++) {
                    ResolveInfo resolveInfo = c10.get(i10);
                    menu.add(0, 0, i10 + 100, resolveInfo.loadLabel(packageManager)).setIntent(b(resolveInfo, this.f9567b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f9566a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f9566a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f9566a.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            g(menu);
            return this.f9566a.onPrepareActionMode(actionMode, menu);
        }
    }

    @Deprecated
    public static Drawable[] a(TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }

    public static int b(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int c(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    @Deprecated
    public static int d(TextView textView) {
        return textView.getMaxLines();
    }

    public static int e(TextDirectionHeuristic textDirectionHeuristic) {
        TextDirectionHeuristic textDirectionHeuristic2;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        if (textDirectionHeuristic == textDirectionHeuristic3 || textDirectionHeuristic == (textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return 6;
        }
        if (textDirectionHeuristic != textDirectionHeuristic3) {
            return 1;
        }
        return 7;
    }

    public static b.a f(TextView textView) {
        return new b.a(b.b(textView));
    }

    public static void g(TextView textView, ColorStateList colorStateList) {
        I.h.e(textView);
        a.b(textView, colorStateList);
    }

    public static void h(TextView textView, PorterDuff.Mode mode) {
        I.h.e(textView);
        a.c(textView, mode);
    }

    @Deprecated
    public static void i(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Deprecated
    public static void j(TextView textView, ActionMode.Callback callback) {
        textView.setCustomSelectionActionModeCallback(s(textView, callback));
    }

    public static void k(TextView textView, int i10) {
        I.h.c(i10);
        b.c(textView, i10);
    }

    public static void l(TextView textView, int i10) {
        int i11;
        I.h.c(i10);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (textView.getIncludeFontPadding()) {
            i11 = fontMetricsInt.bottom;
        } else {
            i11 = fontMetricsInt.descent;
        }
        if (i10 > Math.abs(i11)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i10 - i11);
        }
    }

    public static void m(TextView textView, int i10) {
        I.h.c(i10);
        if (i10 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i10 - r0, 1.0f);
        }
    }

    public static void n(TextView textView, int i10, float f10) {
        c.a(textView, i10, f10);
    }

    public static void o(TextView textView, H.b bVar) {
        textView.setText(b.a(bVar.a()));
    }

    public static void p(TextView textView, int i10) {
        textView.setTextAppearance(i10);
    }

    public static void q(TextView textView, b.a aVar) {
        textView.setTextDirection(e(aVar.d()));
        textView.getPaint().set(aVar.e());
        a.a(textView, aVar.b());
        a.d(textView, aVar.c());
    }

    public static ActionMode.Callback r(ActionMode.Callback callback) {
        if (callback instanceof d) {
            return ((d) callback).d();
        }
        return callback;
    }

    /* compiled from: TextViewCompat.java */
    /* loaded from: classes.dex */
    public static class b {
        public static PrecomputedText.Params b(TextView textView) {
            return textView.getTextMetricsParams();
        }

        public static void c(TextView textView, int i10) {
            textView.setFirstBaselineToTopHeight(i10);
        }

        public static CharSequence a(PrecomputedText precomputedText) {
            return precomputedText;
        }
    }

    public static ActionMode.Callback s(TextView textView, ActionMode.Callback callback) {
        return callback;
    }
}

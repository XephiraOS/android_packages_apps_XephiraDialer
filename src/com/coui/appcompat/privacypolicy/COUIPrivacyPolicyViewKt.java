package com.coui.appcompat.privacypolicy;

import Z8.c;
import Z8.d;
import Z8.f;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.core.view.N;
import com.coui.appcompat.privacypolicy.COUIPrivacyPolicyView;
import f.C0991a;
import kotlin.jvm.internal.i;
import m9.q;
import v9.l;

/* compiled from: COUIPrivacyPolicyView.kt */
/* loaded from: classes.dex */
public final class COUIPrivacyPolicyViewKt {
    private static final int TAG_INVALID = -1;
    private static final int TAG_SMALL_TITLE = 2;
    private static final int TAG_TABLE = 3;
    private static final int TAG_TITLE = 1;

    public static final TextView body(COUIPrivacyPolicyView.Section section, l<? super TextView, ? extends CharSequence> init) {
        i.f(section, "<this>");
        i.f(init, "init");
        TextView articleBody = getArticleBody(section);
        articleBody.setText(init.invoke(articleBody));
        section.addView(articleBody);
        return articleBody;
    }

    public static final TextView boldBody(COUIPrivacyPolicyView.Section section, l<? super TextView, ? extends CharSequence> init) {
        i.f(section, "<this>");
        i.f(init, "init");
        TextView boldBody = getBoldBody(section);
        boldBody.setText(init.invoke(boldBody));
        section.addView(boldBody);
        return boldBody;
    }

    public static final TextView columnBody(TableRow tableRow, float f10, l<? super TextView, ? extends CharSequence> init) {
        i.f(tableRow, "<this>");
        i.f(init, "init");
        TextView tableColumnBody = getTableColumnBody(tableRow, f10);
        tableColumnBody.setText(init.invoke(tableColumnBody));
        tableRow.addView(tableColumnBody);
        return tableColumnBody;
    }

    public static /* synthetic */ TextView columnBody$default(TableRow tableRow, float f10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 1.0f;
        }
        return columnBody(tableRow, f10, lVar);
    }

    private static final TextView getArticleBody(COUIPrivacyPolicyView.Section section) {
        return getTextView(section, f.f6183s);
    }

    private static final TextView getBoldBody(COUIPrivacyPolicyView.Section section) {
        return getTextView(section, f.f6185u);
    }

    private static final int getDimenPx(View view, int i10) {
        return view.getContext().getResources().getDimensionPixelSize(i10);
    }

    private static final int getIntTag(View view) {
        Integer num;
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            num = (Integer) tag;
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    private static final int getLastIntTag(ViewGroup viewGroup) {
        if (viewGroup != null && viewGroup.getChildCount() != 0) {
            return getIntTag(N.a(viewGroup, viewGroup.getChildCount() - 1));
        }
        return -1;
    }

    private static final LinearLayout.LayoutParams getLpSection(COUIPrivacyPolicyView cOUIPrivacyPolicyView) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = getDimenPx(cOUIPrivacyPolicyView, c.f5990K);
        int i10 = c.f5989J;
        layoutParams.setMarginStart(getDimenPx(cOUIPrivacyPolicyView, i10));
        layoutParams.setMarginEnd(getDimenPx(cOUIPrivacyPolicyView, i10));
        return layoutParams;
    }

    private static final LinearLayout.LayoutParams getLpTitle(COUIPrivacyPolicyView cOUIPrivacyPolicyView) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = getDimenPx(cOUIPrivacyPolicyView, c.f5995P);
        return layoutParams;
    }

    private static final LinearLayout.LayoutParams getMarginTopLp(View view, Integer num) {
        int i10;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (num != null) {
            i10 = Integer.valueOf(getDimenPx(view, num.intValue())).intValue();
        } else {
            i10 = 0;
        }
        layoutParams.topMargin = i10;
        return layoutParams;
    }

    public static /* synthetic */ LinearLayout.LayoutParams getMarginTopLp$default(View view, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        return getMarginTopLp(view, num);
    }

    private static final TextView getSectionTitle(COUIPrivacyPolicyView.Section section) {
        return getTextView(section, f.f6185u);
    }

    private static final TextView getTableColumnBody(TableRow tableRow, float f10) {
        TextView textView = getTextView(tableRow, f.f6186v);
        int dimenPx = getDimenPx(textView, c.f5994O);
        textView.setPadding(dimenPx, dimenPx, dimenPx, dimenPx);
        textView.setLayoutParams(new TableRow.LayoutParams(0, -1, f10));
        return textView;
    }

    private static final TextView getTextView(View view, int i10) {
        View inflate = View.inflate(view.getContext(), i10, null);
        i.d(inflate, "null cannot be cast to non-null type android.widget.TextView");
        return (TextView) inflate;
    }

    private static final TextView getTitle(COUIPrivacyPolicyView cOUIPrivacyPolicyView) {
        TextView textView = getTextView(cOUIPrivacyPolicyView, f.f6184t);
        int dimenPx = getDimenPx(textView, c.f5996Q);
        textView.setPadding(dimenPx, dimenPx, dimenPx, dimenPx);
        textView.setLayoutParams(getLpTitle(cOUIPrivacyPolicyView));
        textView.setTag(1);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void overrideChildLp(ViewGroup viewGroup, View view) {
        LinearLayout.LayoutParams marginTopLp;
        if (viewGroup.getChildCount() == 0) {
            marginTopLp = getMarginTopLp$default(viewGroup, null, 1, null);
        } else if (getIntTag(view) == 2) {
            marginTopLp = getMarginTopLp(viewGroup, Integer.valueOf(c.f5992M));
        } else if ((getIntTag(view) == 3 && viewGroup.getChildCount() > 0) || getLastIntTag(viewGroup) == 3) {
            marginTopLp = getMarginTopLp(viewGroup, Integer.valueOf(c.f5993N));
        } else {
            marginTopLp = getMarginTopLp(viewGroup, Integer.valueOf(c.f5988I));
        }
        view.setLayoutParams(marginTopLp);
    }

    public static final TableRow row(TableLayout tableLayout, l<? super TableRow, q> init) {
        i.f(tableLayout, "<this>");
        i.f(init, "init");
        TableRow tableRow = new TableRow(tableLayout.getContext());
        tableRow.setLayoutParams(new TableLayout.LayoutParams());
        init.invoke(tableRow);
        tableRow.setDividerDrawable(C0991a.b(tableLayout.getContext(), d.f6064g));
        tableRow.setShowDividers(7);
        tableLayout.addView(tableRow);
        return tableRow;
    }

    public static final COUIPrivacyPolicyView.Section section(COUIPrivacyPolicyView cOUIPrivacyPolicyView, l<? super COUIPrivacyPolicyView.Section, q> init) {
        int dimenPx;
        i.f(cOUIPrivacyPolicyView, "<this>");
        i.f(init, "init");
        Context context = cOUIPrivacyPolicyView.getContext();
        i.e(context, "context");
        COUIPrivacyPolicyView.Section section = new COUIPrivacyPolicyView.Section(context);
        section.setOrientation(1);
        LinearLayout.LayoutParams lpSection = getLpSection(cOUIPrivacyPolicyView);
        if (getLastIntTag(cOUIPrivacyPolicyView) == 1) {
            dimenPx = getDimenPx(cOUIPrivacyPolicyView, c.f5991L);
        } else {
            dimenPx = getDimenPx(cOUIPrivacyPolicyView, c.f5990K);
        }
        lpSection.topMargin = dimenPx;
        section.setLayoutParams(lpSection);
        init.invoke(section);
        cOUIPrivacyPolicyView.addView(section);
        return section;
    }

    public static final TextView sectionTitle(COUIPrivacyPolicyView.Section section, l<? super TextView, ? extends CharSequence> init) {
        i.f(section, "<this>");
        i.f(init, "init");
        TextView sectionTitle = getSectionTitle(section);
        sectionTitle.setText(init.invoke(sectionTitle));
        section.addView(sectionTitle);
        return sectionTitle;
    }

    public static final TextView smallTitle(COUIPrivacyPolicyView.Section section, l<? super TextView, ? extends CharSequence> init) {
        i.f(section, "<this>");
        i.f(init, "init");
        TextView articleBody = getArticleBody(section);
        articleBody.setText(init.invoke(articleBody));
        articleBody.setTag(2);
        section.addView(articleBody);
        return articleBody;
    }

    public static final TableLayout table(COUIPrivacyPolicyView.Section section, l<? super TableLayout, q> init) {
        i.f(section, "<this>");
        i.f(init, "init");
        TableLayout tableLayout = new TableLayout(section.getContext());
        tableLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        tableLayout.setTag(3);
        tableLayout.setDividerDrawable(C0991a.b(section.getContext(), d.f6063f));
        tableLayout.setShowDividers(7);
        init.invoke(tableLayout);
        section.addView(tableLayout);
        return tableLayout;
    }

    public static final TextView title(COUIPrivacyPolicyView cOUIPrivacyPolicyView, l<? super TextView, ? extends CharSequence> init) {
        i.f(cOUIPrivacyPolicyView, "<this>");
        i.f(init, "init");
        TextView title = getTitle(cOUIPrivacyPolicyView);
        title.setText(init.invoke(title));
        cOUIPrivacyPolicyView.addView(title);
        return title;
    }
}

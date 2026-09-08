package com.android.contacts.socialwidget;

import H7.b;
import W.c;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.android.contacts.ContactLoader;
import com.android.contacts.activities.CallDetailActivity;
import com.android.contacts.util.f;
import com.oplus.dialer.R;
import p1.C1429a;

/* loaded from: classes.dex */
public class SocialWidgetProvider extends AppWidgetProvider {

    /* renamed from: a, reason: collision with root package name */
    public static SparseArray<ContactLoader> f17300a = new SparseArray<>();

    /* loaded from: classes.dex */
    public class a implements c.InterfaceC0078c<ContactLoader.Result> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f17301a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f17302b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppWidgetManager f17303c;

        public a(Context context, int i10, AppWidgetManager appWidgetManager) {
            this.f17301a = context;
            this.f17302b = i10;
            this.f17303c = appWidgetManager;
        }

        @Override // W.c.InterfaceC0078c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void t(c<ContactLoader.Result> cVar, ContactLoader.Result result) {
            SocialWidgetProvider.b(this.f17301a, this.f17302b, this.f17303c, result);
        }
    }

    public static void b(Context context, int i10, AppWidgetManager appWidgetManager, ContactLoader.Result result) {
        Bitmap b10;
        b.b("SocialWidgetProvider", "Loaded " + result.K() + " for widget with id=" + i10);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.social_widget);
        if (!result.d0()) {
            d(context, remoteViews, context.getString(R.string.contact_does_not_exist), null, null);
            e(remoteViews, f.b(context, false, false));
        } else {
            byte[] R10 = result.R();
            if (R10 != null) {
                b10 = BitmapFactory.decodeByteArray(R10, 0, R10.length);
            } else {
                b10 = f.b(context, false, false);
            }
            e(remoteViews, b10);
            Intent intent = new Intent(context, (Class<?>) CallDetailActivity.class);
            intent.setFlags(337641472);
            intent.setData(result.L());
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 67108864);
            remoteViews.setOnClickPendingIntent(R.id.border, activity);
            d(context, remoteViews, result.B(), result.Q(), activity);
        }
        appWidgetManager.updateAppWidget(i10, remoteViews);
    }

    public static void c(Context context, AppWidgetManager appWidgetManager, int i10, boolean z10) {
        ContactLoader contactLoader = f17300a.get(i10);
        if (contactLoader != null && !z10) {
            contactLoader.y();
            return;
        }
        if (contactLoader != null) {
            contactLoader.w();
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.social_widget);
        remoteViews.setTextViewText(R.id.name, context.getString(R.string.social_widget_loading));
        remoteViews.setViewVisibility(R.id.name, 0);
        remoteViews.setViewVisibility(R.id.name_and_snippet, 8);
        appWidgetManager.updateAppWidget(i10, remoteViews);
        Uri b10 = C1429a.c().b(context, i10);
        if (b10 == null) {
            return;
        }
        ContactLoader contactLoader2 = new ContactLoader(context, b10);
        contactLoader2.u(0, new a(context, i10, appWidgetManager));
        contactLoader2.y();
        f17300a.append(i10, contactLoader2);
    }

    public static void d(Context context, RemoteViews remoteViews, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = context.getString(R.string.missing_name);
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            charSequence = context.getString(R.string.widget_name_and_phonetic, charSequence, charSequence2);
        }
        spannableStringBuilder.append(charSequence);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.SP_14));
        StyleSpan styleSpan = new StyleSpan(1);
        spannableStringBuilder.setSpan(absoluteSizeSpan, 0, charSequence.length(), 0);
        spannableStringBuilder.setSpan(styleSpan, 0, charSequence.length(), 0);
        remoteViews.setTextViewText(R.id.name, spannableStringBuilder);
        remoteViews.setViewVisibility(R.id.name, 0);
        remoteViews.setViewVisibility(R.id.name_and_snippet, 8);
        if (pendingIntent != null) {
            remoteViews.setOnClickPendingIntent(R.id.widget_container, pendingIntent);
        }
    }

    public static void e(RemoteViews remoteViews, Bitmap bitmap) {
        remoteViews.setImageViewBitmap(R.id.image, bitmap);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        for (int i10 : iArr) {
            ContactLoader contactLoader = f17300a.get(i10);
            if (contactLoader != null) {
                b.b("SocialWidgetProvider", "Stopping loader for widget with id=" + i10);
                contactLoader.z();
                f17300a.delete(i10);
            }
        }
        C1429a.c().e(context, iArr);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        for (int i10 : iArr) {
            b.b("SocialWidgetProvider", "onUpdate called for " + i10);
        }
        for (int i11 : iArr) {
            c(context, appWidgetManager, i11, false);
        }
    }
}

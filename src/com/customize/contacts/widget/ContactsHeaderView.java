package com.customize.contacts.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.contacts.model.Account;
import com.android.incallui.OplusNumberMarkUtils;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.customize.contacts.activities.SimAccountsListActivity;
import com.customize.contacts.activities.SimContactsListActivity;
import com.customize.contacts.util.U;
import com.customize.contacts.util.b0;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ContactsHeaderView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public Context f22282a;

    /* renamed from: b, reason: collision with root package name */
    public LinearLayout f22283b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<Integer, b> f22284c;

    /* renamed from: d, reason: collision with root package name */
    public View.OnTouchListener f22285d;

    /* renamed from: e, reason: collision with root package name */
    public View.OnClickListener f22286e;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == 6) {
                ArrayList<Account> m10 = M3.c.m(ContactsHeaderView.this.f22282a);
                int size = m10.size();
                if (size == 1) {
                    Intent intent = new Intent(ContactsHeaderView.this.f22282a, (Class<?>) SimContactsListActivity.class);
                    intent.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI, m10.get(0).f16941a);
                    intent.putExtra("ToSMS", true);
                    Q7.b.b((Activity) ContactsHeaderView.this.f22282a, intent, 340, 0);
                    return;
                }
                if (size > 1) {
                    Intent intent2 = new Intent(ContactsHeaderView.this.f22282a, (Class<?>) SimAccountsListActivity.class);
                    intent2.putExtra("ToSMS", true);
                    Q7.b.b((Activity) ContactsHeaderView.this.f22282a, intent2, 340, 0);
                } else if (b0.O() > 0) {
                    com.oplus.foundation.util.ui.c.b(ContactsHeaderView.this.f22282a, R.string.oplus_refreshing_sim_data);
                } else {
                    com.oplus.foundation.util.ui.c.b(ContactsHeaderView.this.f22282a, R.string.simcard_abnormal_please_check_and_try_again);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f22288a = -1;

        /* renamed from: b, reason: collision with root package name */
        public COUIRoundImageView f22289b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f22290c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f22291d;

        /* renamed from: e, reason: collision with root package name */
        public RelativeLayout f22292e;
    }

    public ContactsHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22283b = null;
        this.f22284c = new HashMap<>();
        this.f22285d = new View.OnTouchListener() { // from class: com.customize.contacts.widget.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean g10;
                g10 = ContactsHeaderView.g(view, motionEvent);
                return g10;
            }
        };
        this.f22286e = new a();
        this.f22282a = context;
    }

    public static /* synthetic */ boolean g(View view, MotionEvent motionEvent) {
        return false;
    }

    public static /* synthetic */ boolean h(View view) {
        return false;
    }

    public void d() {
        LinearLayout linearLayout = this.f22283b;
        Context context = this.f22282a;
        e(linearLayout, context, context.getDrawable(R.drawable.pb_ic_sim_contacts), getResources().getString(R.string.adn_dialog_title));
    }

    public void e(LinearLayout linearLayout, Context context, Drawable drawable, String str) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.contact_header_item, (ViewGroup) null);
        relativeLayout.setBackgroundResource(R.drawable.coui_preference_bg_selector);
        relativeLayout.setId(6);
        linearLayout.addView(relativeLayout);
        f(relativeLayout);
        i(drawable, str, 6);
    }

    public final void f(RelativeLayout relativeLayout) {
        b bVar = new b();
        bVar.f22288a = relativeLayout.getId();
        bVar.f22292e = relativeLayout;
        bVar.f22289b = (COUIRoundImageView) relativeLayout.findViewById(R.id.Photo);
        bVar.f22290c = (TextView) relativeLayout.findViewById(R.id.text);
        bVar.f22291d = (ImageView) relativeLayout.findViewById(R.id.icon);
        this.f22284c.put(Integer.valueOf(bVar.f22288a), bVar);
    }

    public void i(Drawable drawable, String str, int i10) {
        int i11;
        b bVar = this.f22284c.get(Integer.valueOf(i10));
        boolean d10 = U.d();
        if (bVar != null) {
            bVar.f22289b.setImageDrawable(drawable);
            bVar.f22290c.setText(str);
            bVar.f22292e.setOnClickListener(this.f22286e);
            bVar.f22292e.setOnTouchListener(this.f22285d);
            bVar.f22292e.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.customize.contacts.widget.e
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean h10;
                    h10 = ContactsHeaderView.h(view);
                    return h10;
                }
            });
            COUIRoundImageView cOUIRoundImageView = bVar.f22289b;
            if (d10) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            cOUIRoundImageView.setVisibility(i11);
            bVar.f22292e.setOnTouchListener(this.f22285d);
            bVar.f22290c.setPadding(0, U.a(), 0, U.a());
            if (i10 == 6) {
                bVar.f22291d.setVisibility(0);
            } else {
                bVar.f22291d.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f22283b = (LinearLayout) findViewById(R.id.parent);
        View view = new View(getContext());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelOffset(R.dimen.DP_69)));
        view.setVisibility(8);
        this.f22283b.addView(view);
    }
}

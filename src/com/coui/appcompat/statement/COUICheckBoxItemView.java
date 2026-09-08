package com.coui.appcompat.statement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coui.appcompat.checkbox.COUICheckBox;

/* compiled from: COUICheckBoxItemView.kt */
/* loaded from: classes.dex */
public final class COUICheckBoxItemView extends LinearLayout {
    private COUICheckBox checkBox;
    private final PrivacyItem privacyItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUICheckBoxItemView(Context context, PrivacyItem privacyItem) {
        super(context);
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(privacyItem, "privacyItem");
        this.privacyItem = privacyItem;
        View inflate = LayoutInflater.from(context).inflate(Z8.f.f6179o, this);
        ((TextView) inflate.findViewById(Z8.e.f6133n)).setText(privacyItem.getTitleText());
        ((TextView) inflate.findViewById(Z8.e.f6131m)).setText(privacyItem.getSummaryText());
        View findViewById = inflate.findViewById(Z8.e.f6123i);
        kotlin.jvm.internal.i.e(findViewById, "findViewById(R.id.checkbox)");
        this.checkBox = (COUICheckBox) findViewById;
        ((ConstraintLayout) inflate.findViewById(Z8.e.f6125j)).setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.statement.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                COUICheckBoxItemView.lambda$1$lambda$0(COUICheckBoxItemView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$1$lambda$0(COUICheckBoxItemView this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        int state = this$0.checkBox.getState();
        if (state != 0) {
            if (state == 2) {
                this$0.checkBox.setState(0);
                return;
            }
            return;
        }
        this$0.checkBox.setState(2);
    }

    public final PrivacyItem getPrivacyItem() {
        return this.privacyItem;
    }

    public final boolean isChecked() {
        if (this.checkBox.getState() == 2) {
            return true;
        }
        return false;
    }

    public final void setOnStateChangeListener(COUICheckBox.OnStateChangeListener listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        this.checkBox.setOnStateChangeListener(listener);
    }
}

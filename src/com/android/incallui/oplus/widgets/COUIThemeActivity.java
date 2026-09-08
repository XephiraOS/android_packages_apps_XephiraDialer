package com.android.incallui.oplus.widgets;

import androidx.appcompat.app.AppCompatActivity;
import com.android.incallui.R;
import com.coui.appcompat.theme.COUIThemeOverlay;

/* loaded from: classes.dex */
public abstract class COUIThemeActivity extends AppCompatActivity {
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        COUIThemeOverlay.getInstance().applyThemeOverlays(this);
        setTheme(R.style.DarkForceStyle);
        super.setContentView(i10);
    }
}

package com.coui.appcompat.opensource;

import android.content.res.AssetManager;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: COUIOpenSourceStatementAdapter.kt */
/* loaded from: classes.dex */
public final class COUIOpenSourceStatementAdapter extends p<StatementSegment, ViewHolder> {
    private static final int CONTENT_CONTAINER_MAX_LINE_COUNT = 50;
    public static final Companion Companion = new Companion(null);

    /* compiled from: COUIOpenSourceStatementAdapter.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* compiled from: COUIOpenSourceStatementAdapter.kt */
    /* loaded from: classes.dex */
    public static final class TimeConsumingOperationOnMainThreadException extends RuntimeException {
        public TimeConsumingOperationOnMainThreadException() {
            super("The method loadText is time consuming, can not call this method on main thread");
        }
    }

    /* compiled from: COUIOpenSourceStatementAdapter.kt */
    /* loaded from: classes.dex */
    public static final class ViewHolder extends RecyclerView.B {
        private final TextView content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            i.f(itemView, "itemView");
            this.content = (TextView) itemView;
        }

        public final TextView getContent() {
            return this.content;
        }
    }

    public COUIOpenSourceStatementAdapter() {
        super(new DiffCallback());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadContent$lambda$4$lambda$3(COUIOpenSourceStatementAdapter this$0, ArrayList statementSegments) {
        i.f(this$0, "this$0");
        i.f(statementSegments, "$statementSegments");
        this$0.submitList(statementSegments);
    }

    public final String loadContent(RecyclerView recyclerView, String file) {
        Object b10;
        i.f(recyclerView, "<this>");
        i.f(file, "file");
        if (!Looper.getMainLooper().isCurrentThread()) {
            final ArrayList arrayList = new ArrayList();
            AssetManager assets = recyclerView.getContext().getAssets();
            try {
                Result.a aVar = Result.f34166a;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assets.open(file)));
                try {
                    StringBuilder sb = new StringBuilder();
                    int i10 = 0;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        i10++;
                        if (i10 % 50 == 0) {
                            sb.append(readLine);
                            String sb2 = sb.toString();
                            i.e(sb2, "block.toString()");
                            arrayList.add(new StatementSegment(sb2, i10));
                            sb = new StringBuilder();
                        } else {
                            sb.append(readLine);
                            i.e(sb, "append(value)");
                            sb.append('\n');
                            i.e(sb, "append('\\n')");
                        }
                    }
                    if (sb.length() > 0) {
                        String sb3 = sb.toString();
                        i.e(sb3, "block.toString()");
                        arrayList.add(new StatementSegment(sb3, i10 + 1));
                    }
                    q qVar = q.f35511a;
                    kotlin.io.a.a(bufferedReader, null);
                    b10 = Result.b(Boolean.valueOf(recyclerView.post(new Runnable() { // from class: com.coui.appcompat.opensource.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            COUIOpenSourceStatementAdapter.loadContent$lambda$4$lambda$3(COUIOpenSourceStatementAdapter.this, arrayList);
                        }
                    })));
                } finally {
                }
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(b.a(th));
            }
            return Result.h(b10);
        }
        throw new TimeConsumingOperationOnMainThreadException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i10) {
        i.f(holder, "holder");
        holder.getContent().setText(getItem(i10).getContent());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        View textView = View.inflate(parent.getContext(), Z8.f.f6180p, null);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        i.e(textView, "textView");
        return new ViewHolder(textView);
    }
}

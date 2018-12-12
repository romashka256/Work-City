package com.workcity.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.workcity.App;
import com.workcity.R;
import com.workcity.model.AppPOJO;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.AppsVH> {

    List<AppPOJO> appPOJOList;
    private Context context;

    @NonNull
    @Override
    public AppsVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.apps_item, null);

        return new AppsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppsVH appsVH, int i) {
        appsVH.mAppName.setText(appPOJOList.get(i).getAppName());

    }

    @Override
    public int getItemCount() {
        return appPOJOList.size();
    }

    public class AppsVH extends RecyclerView.ViewHolder {

        @BindView(R.id.app_item_name)
        TextView mAppName;
        @BindView(R.id.app_item_switch)
        Switch mSwitch;

        public AppsVH(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}

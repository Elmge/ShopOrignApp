package com.example.xch.scanzxing.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.xch.scanzxing.R;
import com.example.xch.scanzxing.activity.DistributeActivity;
import com.example.xch.scanzxing.activity.informationActivity;
import com.example.xch.scanzxing.utils.zxing.android.CaptureActivity;

public class WareHouseFragment extends BaseFragment implements View.OnClickListener{
    private static final int REQUEST_CODE_SCAN2 = 0x0002;
    LinearLayout rl_distributeInformation,rl_record,rl_distribute;
    public static WareHouseFragment newInstance() {
        return new WareHouseFragment();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_warehouse;
    }

    @Override
    protected void initView() {

        rl_distributeInformation = mRootView.findViewById(R.id.rl_distributeInformation);
        rl_record = mRootView.findViewById(R.id.rl_record);
        rl_distribute = mRootView.findViewById(R.id.rl_distribute);

    }

    @Override
    protected void initData() {
        rl_distributeInformation.setOnClickListener(this);
        rl_record.setOnClickListener(this);
        rl_distribute.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_distributeInformation:
                DistributeInformation();
                break;
            case R.id.rl_record:
                recordQR();
                break;
            case R.id.rl_distribute:
                Distribute();
                break;
        }
    }

    private void DistributeInformation() {
        startActivity(new Intent(getActivity(), informationActivity.class));
    }

    private void recordQR() {
        Intent intent = new Intent(getActivity(), CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SCAN2);
    }

    private void Distribute() {
        startActivity(new Intent(getActivity(), DistributeActivity.class));
    }

}

package chinapex.com.wallet.view.me.portrait;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chinapex.com.wallet.R;
import chinapex.com.wallet.adapter.viewpager.PortraitPagerAdapter;
import chinapex.com.wallet.base.BaseFragment;
import chinapex.com.wallet.global.Constant;
import chinapex.com.wallet.utils.CpLog;
import chinapex.com.wallet.utils.FragmentFactory;

/**
 * Created by SteelCabbage on 2018/7/23 0023 18:44.
 * E-Mail：liuyi_61@163.com
 */

public class MePortraitFragment extends BaseFragment implements MeEnterpriseKeyFragment
        .OnConfirmClickListener {
    private static final String TAG = MePortraitFragment.class.getSimpleName();
    private TabLayout mTl_portrait;
    private ViewPager mVp_portrait;
    private PortraitPagerAdapter mPortraitPagerAdapter;
    private List<BaseFragment> mBaseFragments;
    private List<String> mTitles;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
            savedInstanceState) {
        return inflater.inflate(R.layout.fragment_me_portrait, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        initData();
    }

    private void initView(View view) {
        mTl_portrait = view.findViewById(R.id.tl_portrait);
        mVp_portrait = view.findViewById(R.id.vp_portrait);
    }

    private void initData() {
        mTl_portrait.setupWithViewPager(mVp_portrait);

        mBaseFragments = new ArrayList<>();
//        MeEnterpriseKeyFragment enterpriseKeyFragment = (MeEnterpriseKeyFragment) FragmentFactory
//                .getFragment(Constant.FRAGMENT_TAG_ME_ENTERPRISE_KEY);
        mBaseFragments.add(FragmentFactory.getFragment(Constant.FRAGMENT_TAG_ME_COMMON_PORTRAIT));
        mBaseFragments.add(FragmentFactory.getFragment(Constant
                .FRAGMENT_TAG_ME_ENTERPRISE_PORTRAIT));
//        mBaseFragments.add(enterpriseKeyFragment);
        mTitles = Arrays.asList(getResources().getStringArray(R.array.me_portrait_type));
        mPortraitPagerAdapter = new PortraitPagerAdapter(getFragmentManager(), mBaseFragments,
                mTitles);
        mVp_portrait.setAdapter(mPortraitPagerAdapter);

//        enterpriseKeyFragment.setOnConfirmClickListener(this);
    }


    @Override
    public void onConfirmClick() {
        CpLog.i(TAG, "onConfirmClick");

    }
}

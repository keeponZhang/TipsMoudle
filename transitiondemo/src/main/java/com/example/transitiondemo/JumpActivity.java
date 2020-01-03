package com.example.transitiondemo;

import com.example.base.BaseJumpActivity;
import com.example.base.Utils;

import java.util.List;

/**
 * createBy keepon
 */
public class JumpActivity extends BaseJumpActivity {
    @Override
    protected void onItemClick(int poisiton) {
        switch (poisiton) {
            case 0:
                Utils.startActivity(this,ExampleActivity.class);
                break;
            default:
                break;
        }
    }

    @Override
    protected void setData(List<String> titles) {
        titles.add("ExampleActivity");
    }
}

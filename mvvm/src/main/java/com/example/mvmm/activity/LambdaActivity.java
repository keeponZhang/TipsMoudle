package com.example.mvmm.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.mvmm.R;
import com.example.mvmm.bean.Employee;
import com.example.mvmm.databinding.ActivityLambdaBinding;

public class LambdaActivity extends AppCompatActivity {

    private ActivityLambdaBinding mBinding;

    public class Presenter {
        public void onEmployeeClick(Employee employee) {
            Toast.makeText(LambdaActivity.this, "onEmployeeClick",
                    Toast.LENGTH_SHORT).show();
        }

        public void onEmployeeLongClick(Employee employee, Context context) {
            Toast.makeText(LambdaActivity.this, "onEmployeeLongClick",
                    Toast.LENGTH_SHORT).show();
        }

        public void onFocusChange(Employee employee) {
            Toast.makeText(LambdaActivity.this, "onFocusChange",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_lambda);
        mBinding.setEmployee(new Employee("mark", "zhai"));
        mBinding.setPresenter(new Presenter());
    }


}

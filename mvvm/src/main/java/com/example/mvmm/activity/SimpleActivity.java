package com.example.mvmm.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.Toast;

import com.example.mvmm.R;
import com.example.mvmm.bean.Employee;
import com.example.mvmm.databinding.ActivitySimpleBinding;

public class SimpleActivity extends AppCompatActivity {
    Employee employee = new Employee("Zhai", "Mark");

    ActivitySimpleBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_simple);
        binding.setEmployee(employee);
        binding.setPresenter(new Presenter());
        binding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                Log.e("TAG", "SimpleActivity onInflate:");
            }
        });
        binding.viewStub.getViewStub().inflate();    }

    public class Presenter {
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            employee.setFirstName(s.toString());
            employee.setFired(!employee.isFired.get());
//            binding.setEmployee(employee);
        }

        public void onClick(View view) {
            Toast.makeText(SimpleActivity.this, "点到了", Toast.LENGTH_SHORT).show();
        }

        public void onClickListenerBinding(Employee employee) {
            Toast.makeText(SimpleActivity.this, employee.getLastName(),
                    Toast.LENGTH_SHORT).show();
        }
    }
}

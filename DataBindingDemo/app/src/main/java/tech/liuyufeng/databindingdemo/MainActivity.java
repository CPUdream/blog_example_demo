package tech.liuyufeng.databindingdemo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import tech.liuyufeng.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setName("liuyufeng");
        Log.i("you", "aaa" + mBinding.getName());
        mBinding.setUser(new UserBean("liuxiaoli", "123456"));
       Log.i("you", "bbb" + mBinding.getUser().getPwd());
        mBinding.setMain1(this);
    }
    public void myClick(View view){
        Log.i("you", "dddd" );
       Log.i("you", "ccc" + mBinding.getUser().getName());
        mBinding.setUser(new UserBean("aaa", "bbbb"));
    }
}

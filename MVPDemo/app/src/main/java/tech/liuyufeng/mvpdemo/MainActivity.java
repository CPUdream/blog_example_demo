package tech.liuyufeng.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Login Activity.
 * <p>implements {@link ImainView}.</p>
 *
 * @author CPUdream on 2016/12/27
 */
public class MainActivity extends AppCompatActivity implements ImainView, View.OnClickListener {
    private LoginPresenter mLoginPresenter;

    private EditText mEditUserName;
    private EditText mEditPassword;
    private ProgressBar mProgressLogin;
    private TextView mTextResult;
    private Button mLogin;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditUserName = (EditText) findViewById(R.id.eidt_username);
        mEditPassword = (EditText) findViewById(R.id.edit_password);
        mProgressLogin = (ProgressBar) findViewById(R.id.progress_login);
        mTextResult = (TextView) findViewById(R.id.text_result);
        mLogin = (Button) findViewById(R.id.button_login);

        mLoginPresenter = new LoginPresenterImpl(this);
        mLogin.setOnClickListener(this);

    }

    @Override public void showProgress() {
        mProgressLogin.setVisibility(View.VISIBLE);
    }

    @Override public void hideProgress() {
        mProgressLogin.setVisibility(View.GONE);
    }

    @Override public void setLoginFail() {
        mTextResult.setText("password error");
    }

    @Override public void setLoginSucess() {
        mTextResult.setText(mEditUserName.getText().toString());
    }

    @Override public void onClick(View v) {
        mLoginPresenter.login(mEditUserName.getText().toString(),
                mEditPassword.getText().toString());
    }
}

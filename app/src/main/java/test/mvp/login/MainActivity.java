package test.mvp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import test.mvp.R;
import test.mvp.login.bean.UserBean;
import test.mvp.login.presenter.ILoginPresenter;
import test.mvp.login.presenter.LoginPresenter;
import test.mvp.login.view.ILoginView;
import test.mvp.product.ProductActivity;

/**
 * autour: 樊彦龙
 * date: 2016/12/13 18:44
 * update: 2016/12/13
 */
public class MainActivity extends AppCompatActivity implements ILoginView{

    private EditText mTvName;
    private EditText mTvPwd;
    private Button mBtnSend;

    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        loginPresenter=new LoginPresenter(this);
    }

    private void initView() {
        mTvName = (EditText)findViewById(R.id.name);
        mTvPwd = (EditText)findViewById(R.id.pwd);
        mBtnSend = (Button) findViewById(R.id.login);

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.login(mTvName.getText().toString(),
                        mTvPwd.getText().toString());
            }
        });
    }

    @Override
    public void loginSuccess(UserBean user) {
        System.out.println("登录成功 根据情况 做相应处理");
        Toast.makeText(this, user+"登录成功", Toast.LENGTH_SHORT).show();
        Intent   mIntent=new Intent();
        mIntent.setClass(MainActivity.this, ProductActivity.class);
        startActivity(mIntent);
    }

    @Override
    public void loginFail(String errMsg) {
        Toast.makeText(this,errMsg,Toast.LENGTH_SHORT).show();
    }


}

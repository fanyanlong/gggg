package test.mvp.login.presenter;

import test.mvp.login.bean.ICallBack;
import test.mvp.login.model.ILoginBean;
import test.mvp.login.model.LoginBean;
import test.mvp.login.bean.UserBean;
import test.mvp.login.view.ILoginView;

/**
 * autour: 樊彦龙
 * date: 2016/12/13 18:44
 * update: 2016/12/13
 * 作用：Presenter是从Model中获取数据并提供给View的层或者处理view层的数据逻辑，Presenter还负责处理后台任务
 */

public class LoginPresenter implements ILoginPresenter{

    private ILoginView mLoginView;
    private ILoginBean mLoginBean;

    public LoginPresenter(ILoginView loginView) {
        mLoginView = loginView;
        mLoginBean=new LoginBean();
    }

    @Override
    public void login(String username, String pwd) {
        if(username.trim().length()==0){
            mLoginView.loginFail("用户名不能为空");
            return;
        }
        if(pwd.length()<6){
            mLoginView.loginFail("密码至少6位");
            return;
        }

        mLoginBean.login(username, pwd, new ICallBack() {
            @Override
            public void success(UserBean user) {
                mLoginView.loginSuccess(user);
            }
            @Override
            public void fail(String errMsg) {
                mLoginView.loginFail(errMsg);
            }
        });
    }
}

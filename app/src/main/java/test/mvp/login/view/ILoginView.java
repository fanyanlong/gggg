package test.mvp.login.view;

import test.mvp.login.bean.UserBean;

/**
 * Created by Administrator on 2016/12/3.
 */

public interface ILoginView{
    void loginSuccess(UserBean user);
    void loginFail(String errMsg);
}

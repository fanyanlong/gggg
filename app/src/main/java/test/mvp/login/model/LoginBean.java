package test.mvp.login.model;

import test.mvp.login.bean.ICallBack;
import test.mvp.login.bean.UserBean;

/**
 * autour: 樊彦龙
 * date: 2016/12/13 18:44
 * update: 2016/12/13
 */

public class LoginBean implements ILoginBean{
    @Override
    public void login(String userName, String pwd, ICallBack callBack) {
        try {
            System.out.println("网络请求中。。。。");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if("fanyanlong".equals(userName)&&"123456".equals(pwd)){
            callBack.success(new UserBean());
        }else {
            callBack.fail("用户名或密码错误");
        }
    }
}

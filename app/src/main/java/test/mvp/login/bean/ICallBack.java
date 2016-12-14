package test.mvp.login.bean;

/**
 * autour: 樊彦龙
 * date: 2016/12/13 21:39
 * update: 2016/12/13
 */

public interface ICallBack{
    void success(UserBean user);
    void fail(String errMsg);
}

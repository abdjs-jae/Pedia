package app.rocketship.pedia;


import app.rocketship.natrapharmutil.DataHandler;
import app.rocketship.natrapharmutil.RegisterActivityAbstract;


public class RegisterActivity extends RegisterActivityAbstract {


    @Override
    protected DataHandler.UserType getUserType() {
        return DataHandler.UserType.USER;
    }

    @Override
    protected Class<?> getMenuActivity() {
        return MenuActivity.class;
    }

    @Override
    protected Class<?> getRegisterActivity() {
        return RegisterActivity.class;
    }
}

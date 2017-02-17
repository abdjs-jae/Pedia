package app.rocketship.pedia.pedia;


import app.natrapharmutil.users.DataHandler;
import app.natrapharmutil.users.RegisterActivityAbstract;

public class RegisterActivity extends RegisterActivityAbstract {


    @Override
    protected int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    protected DataHandler.UserType getUserType() {
        return DataHandler.UserType.USER;
    }
}

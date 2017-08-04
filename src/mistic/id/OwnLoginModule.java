package mistic.id;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;


/**
 *
 * @author MISTIC 
 */


public class OwnLoginModule implements LoginModule{
    private Subject subject;
    private CallbackHandler callbackHandler;
    private Map sharedState;
    private Map options;
    private Map<String,String> login_pass = new HashMap<String,String>();
    private SimplePrincipal simplePrincipal;
    @Override
	public void initialize (Subject subject, CallbackHandler handler,Map<java.lang.String, ?> sharedState, Map<java.lang.String, ?> options){
        this.subject = subject;
        this.callbackHandler = handler;
        this.sharedState = sharedState;
        this.options = options;
    }

    @Override
	public boolean login() throws LoginException {

	boolean validation = false;

        if (callbackHandler == null){
            throw new LoginException("no handler");
        }

        try {
            //Define and execute the callback handle
            NameCallback nameCb = new NameCallback("user: ");
            PasswordCallback passwdCb = new PasswordCallback("password: ", true);
            Callback[] cbs = new Callback[]{nameCb, passwdCb};
            this.callbackHandler.handle(cbs);

            //The user is authenticated using their credentials
	    validation = verifyCredentials(nameCb.getName(), new String(passwdCb.getPassword()));

           //The user authentication has been successful. The credentials are stored in the user's "principals". 
	   //obtainPrinciapls(nameCb.getName());
            
           if(!validation){
        	throw new FailedLoginException();
	   }
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedCallbackException e) {
            e.printStackTrace();
        }

	return validation;
    }

    @Override
	public boolean commit() throws LoginException {
        //You can modify this method. 
	//The commit returns true.
        //TODO
        return true;
    }

    @Override
	public boolean abort() throws LoginException {
        //This method is executed when "login" returns false.
        System.out.println("Abort: login has returned false");
        return true;
    }

    @Override
	public boolean logout() throws LoginException {
        return true;
    }

    private boolean verifyCredentials(String name, String password) {
        //MODIFY THIS METHOD
        //You have to modify this method to verify the users' credentials.
	//For instance, Shadowed passwords.
        return true;

    }

    private boolean obtainPrinciapls (String nameCb){
        //You have to develop the principals management (obtain a principal) when there is more than one principal.
        //TODO
	return true;
    }

}

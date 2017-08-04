package mistic.id;

/**
 *
 * @author MISTIC 
 */
import java.io.*;
import javax.security.auth.callback.*;


public class MyCallbackHandler implements CallbackHandler {

    @Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
    for(Callback cb : callbacks) {
        if (cb instanceof NameCallback) {
        //System.out.println("1");    
	//The user can provide this information using the console or a GUI.
	//TODO
            ((NameCallback) cb).setName("TODO"); //The user can provide this information using the console or a GUI.
        //System.out.println("2");
	} else if (cb instanceof PasswordCallback) {
            //System.out.println("3");
	   //The user can provide this information using the console or a GUI.
            //TODO
		((PasswordCallback) cb).setPassword("password".toCharArray());
        //System.out.println("4");
	} else if (cb instanceof TextOutputCallback) {
            System.out.println(((TextOutputCallback) cb).getMessage());
        }
    }
    }

}

package mistic.id;

import java.security.PrivilegedAction;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.util.*;
import java.security.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.SecurityException;

import mistic.utils.*;

/**
 *
 * @author MISTIC ID
 */

public class exv {


public static void main(String[] args) {
        LoginContext lc = null;
        

	//Params
	Params params = new Params(args);
	
	try {
            	
		MyCallbackHandler cbh = new MyCallbackHandler();
            	lc = new LoginContext("Simple", cbh);
            	lc.login();
		
		Subject subject = lc.getSubject();
 		System.out.println("Logged in as "+subject.toString());
            

		Iterator principalIterator = subject.getPrincipals().iterator();
		System.out.println("Authenticated user has the following Principals:");
	
		while (principalIterator.hasNext()) {
	    		Principal p = (Principal)principalIterator.next();
	    		System.out.println("\t" + p.toString());
		}
		
		PrivilegedAction actionN = new testActionNet();
            
		String responseN = (String) Subject.doAsPrivileged(subject, actionN, null);
            
		PrivilegedAction actionF = new testActionFile();

		String responseF = (String) Subject.doAsPrivileged(subject, actionF, null);
		
		//System.out.println("Response Net: "+responseN);
		//System.out.println("Response File: "+responseF);
        
	} catch (LoginException e) {
        	System.out.println("Authentication failure: "+e.getLocalizedMessage());
	}catch(SecurityException e){
		System.out.println("You can not do this action!");
		e.printStackTrace();
	}
    }
}

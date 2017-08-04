package mistic.id;

import java.security.Principal;

/**
 * The principal is the subject's identity, for example, it can be his/her login and password, or digital certificate.
 * The principal stores the user's identity once he/she has been authenticated.
 *
 * @author MISTIC
 */


public class SimplePrincipal implements Principal{
    private final String name;
   
    public SimplePrincipal(String name) {
        this.name = name;
    }

    @Override
	public String getName() {
        return name;
    }

    @Override
	public String toString() {
        return getName();
    }

 public boolean equals(Object o) {
	if (o == null)
	    return false;

        if (this == o)
            return true;
 
        if (!(o instanceof SimplePrincipal))
            return false;
        SimplePrincipal that = (SimplePrincipal)o;

	if (this.getName().equals(that.getName()))
	    return true;
	return false;
    }
	
   //getRoles()
   //addRole()
}

package mistic.utils;

import org.apache.commons.cli.*;

/**
 *
 * @author MISTIC ID
 */

public class Params {

String soperation = null;
String slogin = null;
String spassword = null;
String sprofile1 = null;
String sprofile2 = null;
String sprofile3 = null;
String sfile = null;
String svalue = null;

public String getOperation(){

return soperation;

} 

public String getLogin(){

return slogin;

}

public String getPassword(){

return spassword;

}

public String getProfile1(){

return sprofile1;

}

public String getProfile2(){

return sprofile2;

} 

public String getProfile3(){

return sprofile3;

}

public String getFile(){

return sfile;

}

public String getValue(){

return svalue;

}

public Params(String[] args){

	//Create the options
        Option op = OptionBuilder.withArgName("op")
                                        .hasArg()
                                        .withDescription("Operation: add, delete, modify account")
                                        .create("op");
        Option login = OptionBuilder.withArgName("login")
                                        .hasArg()
                                        .withDescription("Login")
                                        .create("login");
        Option password = OptionBuilder.withArgName("passwd")
                                        .hasArg()
                                        .withDescription("Password")
                                        .create("passwd");
        Option profile1 = OptionBuilder.withArgName("profile1")
                                        .hasArg()
                                        .withDescription("First profile")
                                        .create("profile1");
        Option profile2 = OptionBuilder.withArgName("profile2")
                                        .hasArg()
                                        .withDescription("Second profile")
                                        .create("profile2");
        Option profile3 = OptionBuilder.withArgName("profile3")
                                        .hasArg()
                                        .withDescription("Third profile")
                                        .create("profile3");
 	Option file = OptionBuilder.withArgName("file")
                                        .hasArg()
                                        .withDescription("File")
                                        .create("file");
        Option value = OptionBuilder.withArgName("value")
                                        .hasArg()
                                        .withDescription("Value")
                                        .create("value");
 
	//Add options
        Options options = new Options();

        options.addOption(op);
        options.addOption(login);
        options.addOption(password);
        options.addOption(profile1);
        options.addOption(profile2);
        options.addOption(profile3);
        options.addOption(file);
        options.addOption(value);
        //Parser
        CommandLineParser parser = null;

        try{
                parser = new GnuParser();
        }catch(Exception e){
                e.printStackTrace();
                System.exit(0);
        }

	//Command
        CommandLine cmd = null;

        try{
                cmd = parser.parse(options, args);
        }catch(Exception e){
                e.printStackTrace();
                System.exit(0);
        }

        //Obtain params
        if(cmd.hasOption("op")){
                soperation = cmd.getOptionValue("op");
                System.out.println("Operation: "+soperation);
        }else{
                System.out.println("It lacks the operation");
                //System.exit(0);
        }

        if(cmd.hasOption("login")){
                slogin = cmd.getOptionValue("login");
                System.out.println("Login: "+slogin);
        }else{
                System.out.println("It lacks the login");
                //System.exit(0);
        }

        if(cmd.hasOption("passwd")){
                spassword = cmd.getOptionValue("passwd");
                System.out.println("Password: "+spassword);
        }else{
                System.out.println("It lacks the password");
                //System.exit(0);
        }

        if(cmd.hasOption("profile1")){
                sprofile1 = cmd.getOptionValue("profile1");
                System.out.println("Profile 1: "+sprofile1);
        }else{
                System.out.println("It lacks the Profile 1");
                //System.exit(0);
        }

        if(cmd.hasOption("profile2")){
                sprofile2 = cmd.getOptionValue("profile2");
                System.out.println("Profile 2: "+sprofile2);
        }else{
                System.out.println("It lacks the Profile 2");
                //System.exit(0);
        }

        if(cmd.hasOption("profile3")){
                sprofile3 = cmd.getOptionValue("profile3");
                System.out.println("Profile 3: "+sprofile3);
        }else{
                System.out.println("It lacks the Profile 3");
                //System.exit(0);
        }

        if(cmd.hasOption("file")){
                sfile = cmd.getOptionValue("file");
                System.out.println("File: "+sfile);
        }else{
                System.out.println("It lacks the file");
                //System.exit(0);
        }

        if(cmd.hasOption("value")){
                svalue = cmd.getOptionValue("value");
                System.out.println("Value: "+svalue);
        }else{
                System.out.println("It lacks the value");
                //System.exit(0);
        }


        //Help
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java mistic.id.ex3", options);


}


}

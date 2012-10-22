package com.lz.ma.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.lz.ma.training.commands.AbstractCommand;
import com.lz.ma.training.commands.DeleteByNameCommand;
import com.lz.ma.training.commands.DeleteByNumberCommand;
import com.lz.ma.training.commands.HelpCommand;
import com.lz.ma.training.commands.InsertCommand;
import com.lz.ma.training.commands.LookupByNameCommand;
import com.lz.ma.training.commands.LookupByNumberCommand;
import com.lz.ma.training.commands.PrintAllCommand;
import com.lz.ma.training.commands.QuitCommand;
import com.lz.ma.training.commands.ReadCommand;
import com.lz.ma.training.commands.SaveCommand;

/**
 * <p>
 * This maven project site can only be deployed in Maven 3.0 due to the compatibility
 * <p>
 * Assume each person has only one phone number
 * <p>
 * Usage: You input <tt>mvn clean install</tt> and <tt>java -jar target/addressbook.jar</tt>to run this program
 * <p>
 * You can input <tt>mvn clean site</tt> to generate the webpage
 * 
 * @author eliuzhe
 */

public class SimpleAddressBook implements IAddressBook<AddressItem> {

    public static final String HELP = "-h\nDisplay how to use it\n" + "-p\nPrint all inserted items\n"
            + "-i name,address,phonenumber\nInsert the item with specific name,address,phonenumber\n" + "-D name\nDelete the item with specific name\n"
            + "-d phonenumber\nDelete the item with specific phonenumber\n" + "-L name\nLook up the item with specific name\n"
            + "-l phonenumber\nLook up the item with specific phonenumber\n" + "-s\nSave the addressbook data\n" + "-r\nRead the addressbook data";
    public static final String COPYRIGHTS = "\t*********************************************" + "\n\t*  Copyright James Liu All Rights Reserved  *\n"
            + "\t*********************************************\n";
    public static final String INPUT_TIPS = "Please input the command you want to do, you can input -h to see the help";
    public static final String INPUT_ERROR_TIPS = "Input error,Please input with the correct format";
    public static final String NO_ITEM_TIPS = "There is no item in this addressbook";
    public static final String QUIT = "Exited";

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleAddressBook.class);
    protected List<AddressItem> list = new ArrayList<AddressItem>();
    protected List<AbstractCommand> cmdList = new ArrayList<AbstractCommand>();

    public SimpleAddressBook() {
        super();
        initCmdList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.ma.training.IAddressBook#lookupByName(java.lang.String)
     */
    public AddressItem lookupByName(String name) {
        AddressItem ret = null;
        for (AddressItem item : list) {
            if (name.equals(item.getName())) {
                ret = item;
            }
        }
        return ret;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.ma.training.IAddressBook#lookupByNumber(java.lang.String)
     */
    public AddressItem lookupByNumber(String number) {
        AddressItem ret = null;
        for (AddressItem item : list) {
            if (number.equals(item.getPhoneNumber())) {
                ret = item;
            }
        }
        return ret;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.ma.training.IAddressBook#intertItem(java.lang.Object)
     */
    public void intertItem(AddressItem item) {
        list.add(item);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.ma.training.IAddressBook#deleteItemByName(java.lang.String)
     */
    public AddressItem deleteItemByName(String name) {
        AddressItem ret = null;
        for (Iterator<AddressItem> iterator = list.iterator(); ret == null && iterator.hasNext();) {
            AddressItem item = iterator.next();
            if (name.equals(item.getName())) {
                iterator.remove();
                ret = item;
            }
        }
        return ret;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.ma.training.IAddressBook#deleteItemByNumber(java.lang.String )
     */
    public AddressItem deleteItemByNumber(String number) {
        AddressItem ret = null;
        for (Iterator<AddressItem> iterator = list.iterator(); ret == null && iterator.hasNext();) {
            AddressItem item = iterator.next();
            if (number.equals(item.getPhoneNumber())) {
                iterator.remove();
                ret = item;
            }
        }
        return ret;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.ma.training.IAddressBook#getItemsSize()
     */
    public int getItemsSize() {
        return list.size();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ericsson.ma.training.IAddressBook#printAllItems()
     */
    public String printAllItems() {
        String ret = "";
        for (AddressItem item : list) {
            ret = ret + item.toString() + "\n";
        }
        return ret;
    }

    /**
     * This function is for extend
     * <p>
     * If a new command is added, the user just need to define a new class and add its object into this cmdList
     */
    private void initCmdList() {
        cmdList.add(new DeleteByNameCommand(this));
        cmdList.add(new DeleteByNumberCommand(this));
        cmdList.add(new HelpCommand(this));
        cmdList.add(new InsertCommand(this));
        cmdList.add(new LookupByNameCommand(this));
        cmdList.add(new LookupByNumberCommand(this));
        cmdList.add(new PrintAllCommand(this));
        cmdList.add(new QuitCommand(this));
        cmdList.add(new SaveCommand(this));
        cmdList.add(new ReadCommand(this));
    }

    /**
     * handle the complex logic of the command
     * 
     * @param input
     *            from keyboard
     * @return the out put string
     * @throws Exception
     *             if the input format is not correct
     */
    public String handleLogic(String input) throws IndexOutOfBoundsException {
        String ret = null;
        String operation = input.substring(0, 2);
        String commandStr = "";
        if (input.length() > 3) {
            commandStr = input.substring(3);
        }
        boolean found = false;
        for (Iterator<AbstractCommand> iterator = cmdList.iterator(); found == false && iterator.hasNext();) {
            AbstractCommand cmd = iterator.next();
            if (operation.equals(cmd.getCmdName())) {
                found = true;
                ret = cmd.execute(commandStr);
            }
        }
        if (found == false) {
            ret = INPUT_ERROR_TIPS;
            LOGGER.info("The user input error");
        }
        return ret;
    }

    /**
     * This function is just for increase the coverage otherwise I have no idea how to test main function
     * 
     * @param in
     *            the input stream
     * @param out
     *            the output print stream
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void run(InputStream in, final PrintStream out) throws IOException, InterruptedException, ExecutionException {
        LOGGER.info("The addressbook is running");
        final BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        out.println(COPYRIGHTS);
        boolean loop = true;
        while (loop) {
            out.println(INPUT_TIPS);
            Future<String> future = executorService.submit(new Callable<String>() {
                public String call() throws Exception {
                    String input = reader.readLine();
                    LOGGER.info("The user input [ " + input + " ]");
                    return handleLogic(input);
                }
            });
            String output = future.get();
            if (QUIT.equals(output)) {
                loop = false;
                LOGGER.info("The prgram is exited");
            } else {
                out.println(output);
            }
        }
        executorService.shutdown();
    }

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        SimpleAddressBook addressBook = new SimpleAddressBook();
        addressBook.run(System.in, System.out);
    }
}
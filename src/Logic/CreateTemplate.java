package Logic;

import Data.*;

import Presentation.*;
/**
 *   @author Tessa Henson
 *   @version 11.11.2020
 *   Description:
 *      Collects input from TempGUI to
 *      be inserted into the database (Finally works!)
 * TH: Created construct
 * TH: Added setters for tempName, tempSubject, and tempBody
 * TH: Provided a constructor with no parameters
 * TH: Added non-static getters fr tempName, tempSubject, and tempBody
 * TH: Made static methods that can access non-static variables
 * TH: Cleaned up a lot of the code, removed lots of
 *      unnecessary code
 * TH: Added void method insertTemplate
 * TH: Validation fixed
 * TH:Scroll bar added to GUI form
 * TH: Try-catch for runQuery statement
 */

public class CreateTemplate {
    //var declarations
    private String tempName = "";
    private String tempSubject = "";
    private String tempBody = "";

    private String SQL_MAKE_TEMPLATE = "INSERT INTO MS_Template (TempName, TempSubject, TempText)" +
            "VALUES (?, ?, ?); SELECT * FROM MS_Users;";

    public CreateTemplate() {
        tempName = getTempName();
        tempSubject = getTempSubject();
        tempBody = getTempBody();
    }

    /*
    * insertTemplate takes parameters from CreateTemplate and inserts into the db
    *
     */

    public void insertTemplate(String name, String subject, String body) {
        try {
            Database.runQuery(SQL_MAKE_TEMPLATE, new String[] {name, subject, body});
            System.out.println("Insertion completed!");
        } catch (Exception e) {

            System.out.println("Insertion couldn't be done. Error: " + e);
        };


    }

    public CreateTemplate(String name, String subject, String body){
        //setters for the three parameters
        setName(name);
        setSubject(subject);
        setBody(body);

        //db insert
        insertTemplate(getTempName(), getTempSubject(), getTempBody());
    }

    public void setName(String sName){ tempName = sName; }

    public void setSubject(String sSubject) { tempSubject = sSubject; }

    public void setBody(String sBody) { tempBody = sBody; }

    public String getTempName() { return tempName; }

    public String getTempSubject() { return tempSubject; }

    public String getTempBody() { return tempBody; }


}
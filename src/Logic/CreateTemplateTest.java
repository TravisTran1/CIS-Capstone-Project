package Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CreateTemplateTest testing class
 * @author Tessa Henson
 * @version 11.12.2020
 * Tests various fields for template creation
 */

class CreateTemplateTest {

    @Test
    void getTempName() {
        //Template name is invalid
        CreateTemplate temp = new CreateTemplate(null, null, null);
        assertEquals( null , temp.getTempName());

        //Template name is valid
        CreateTemplate temp1 = new CreateTemplate("Template name", null, null);
        assertEquals( "Template name" , temp1.getTempName());
    }

    @Test
    void getTempSubject() {
        //Valid parameter for template subject
        CreateTemplate temp = new CreateTemplate("Template name here", "Notification subject", "body test");
        assertEquals( "Notification subject" , temp.getTempSubject());

        //Invalid parameter for template subject, cannot be an empty string
        CreateTemplate temp1 = new CreateTemplate("Template name here", "", "body test");
        assertEquals( "" , temp1.getTempSubject());
    }

    @Test
    void getTempBody() {
        //Valid template body
        CreateTemplate temp = new CreateTemplate(null, null, "This is a text body for testing purposes, " +
                "it can be longer then the template name and subject.");
        assertEquals( "This is a text body for testing purposes, " +
                "it can be longer then the template name and subject." , temp.getTempBody());

        //Invalid template body, body is an empty string
        CreateTemplate temp1 = new CreateTemplate(null, null, null);
        assertEquals( null , temp1.getTempBody());

    }
}
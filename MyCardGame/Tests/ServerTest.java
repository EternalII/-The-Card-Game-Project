import com.company.Main;
import com.company.StructureC.DatabaseService;
import com.company.StructureC.MatchmakingServer;
import com.company.StructureC.Server;
import org.junit.Test;

import javax.management.Query;

import static org.junit.Assert.*;

public class ServerTest {

    Server TestServer = new Server();
    DatabaseService TestQ = DatabaseService.getInstance();
    MatchmakingServer TestMatching = new MatchmakingServer();

    @Test
    public void TestQuerries(){

        // Test create user
        assertEquals("Success",TestServer.ConfirmRegistration("TestUser", "12345"));
        // Test validity
        assertTrue(TestServer.Validate("TestUser", "12345"));
        // Test existing user repeated
        assertEquals("User Exists",TestServer.ConfirmRegistration("TestUser", "12345"));
        // Test fake user
        assertEquals(false, TestServer.Validate("Username", "Password"));
        // Test real info
        assertEquals("0@TestUser@1000", TestQ.Query("Player Info",0,"TestUser"));
        // Test fake info
        assertEquals("-1@-1@-1", TestQ.Query("Player Info",0,"ILikeCupcakes69"));
        // Test wrong password
        assertFalse(TestServer.Validate("TestUser", "WrongPassword"));
        // Test create deck
        assertEquals("Success", TestQ.Query("CreateDeck",0,"0")); // Data doesn't matter
    }

    @Test
    public void TestManagement(){
        assertTrue(TestServer.GetManagementPermission("this123"));
        assertFalse(TestServer.GetManagementPermission("urMama"));
    }

    @Test
    public void MatchmakingLoop(){
        for(int i=901; i<=1099; i++) {
            assertEquals("Bot1", TestMatching.FindMatch(i));
        }

        assertEquals("@Error=NoMatch",TestMatching.FindMatch(420));
    }

    @Test
    public void TestValidate(){
        assertTrue(TestServer.ValidateGameLogic(0));
        assertFalse(TestServer.ValidateGameLogic(-1));
    }
}

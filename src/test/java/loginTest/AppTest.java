package loginTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import login.App;

public class AppTest {
  @Test(description="valid test")
  public void validLoginTest() {
	  App ap=new App();
	boolean status=  ap.userLogin("userdemo", "password");
	Assert.assertTrue(status, "Login failed with valid credential"); //checking if status is true or not
//messege will print only if test is failed, or assertion fails
  }
  
  @Test(description="Invalid test")
  public void InvalidLoginTest() {
	  App ap=new App();
	boolean status=  ap.userLogin("userdemo", "password123");
	Assert.assertFalse(status); //checking if status is tru or not
  }
}
//output will fail for invalid test 
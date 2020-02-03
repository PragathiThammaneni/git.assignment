package git.assignment;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

public class CommitObjectTest {

	static CommitObject commitObject;
	static Logger logger = Logger.getLogger(CommitObjectTest.class.getName());

	@BeforeClass
	public static void setUp() throws Exception {
		logger.info("Initializing the CommitObject with sample data ");
		PersonIdentity author = new PersonIdentity("Pragathi", "Pragathu.thammaneni@gmail.com");
		PersonIdentity commiter = new PersonIdentity("Sri Devi", "Sridevi@gmail.com");
		List<Integer>parents= new LinkedList<Integer>();
		parents.add(1234567890);
		commitObject = new CommitObject("This is Test Commit", 123456789,new SimpleDateFormat( "yyyyMMdd" ).parse( "20200202" ), 
				new SimpleDateFormat( "yyyyMMdd" ).parse( "20200202" ), author, commiter, parents);
		logger.info(commitObject.toString());

	}

	@Test
	public void testAuthor(){
		logger.info("Test for checking Author Name: Pragathi");
		assertEquals("Pragathi",commitObject.getAuthor().getName());
	}

	@Test
	public void testHashCode() {

		logger.info("Test for checking the unique hash code: 1230975331");
		assertEquals(1230975331,commitObject.hashCode());
	}

	@Test
	public void ImmutabilityCheck() {
		//Deep copy prevents this data being added to the objects.
		logger.info("Test for checking the the object immutability nature by changing date and parents list");
		commitObject.getAuthoringDate().setTime(1000);
		commitObject.getParents().add(55555551);
		
		assertEquals(1230975331,commitObject.hashCode());
		
		
		
	}




}

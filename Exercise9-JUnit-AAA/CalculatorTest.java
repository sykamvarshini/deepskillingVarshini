
import org.junit.jupiter.api.*;import static org.junit.jupiter.api.Assertions.*;
class Calculator{int add(int a,int b){return a+b;}}
public class CalculatorTest{
 Calculator c;
 @BeforeEach void set(){c=new Calculator();}
 @AfterEach void tear(){c=null;}
 @Test void t(){assertEquals(30,c.add(10,20));}
}

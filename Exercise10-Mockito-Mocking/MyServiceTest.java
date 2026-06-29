
import static org.mockito.Mockito.*;import static org.junit.jupiter.api.Assertions.*;import org.junit.jupiter.api.Test;
interface ExternalApi{String getData();}
class MyService{ExternalApi a;MyService(ExternalApi a){this.a=a;}String fetch(){return a.getData();}}
public class MyServiceTest{@Test void t(){ExternalApi m=mock(ExternalApi.class);when(m.getData()).thenReturn("Mock Data");assertEquals("Mock Data",new MyService(m).fetch());}}

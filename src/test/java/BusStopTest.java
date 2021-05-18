import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusStopTest {

    private BusStop busStop1;
    private Person jimmy;

    @Before
    public void before(){
        busStop1 = new BusStop("Union Square");
        jimmy = new Person();
    }

    @Test
    public void busStopHasName(){
        assertEquals("Union Square", busStop1.getName());
    }

    @Test
    public void busStopQueueStartsEmpty(){
        assertEquals(0, busStop1.getQueueSize());
    }

    @Test
    public void canAddPersonToQueue(){
        busStop1.addPerson(jimmy);
        assertEquals(1, busStop1.getQueueSize());
    }

    @Test
    public void canRemovePersonFromQueue(){
        busStop1.addPerson(jimmy);
        assertEquals(1, busStop1.getQueueSize());
        busStop1.removePerson();
        assertEquals(0, busStop1.getQueueSize());
    }
}

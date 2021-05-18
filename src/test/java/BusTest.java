import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {

    private Bus bus;
    private Person jimmy;
    private BusStop busStop1;

    @Before
    public void before(){
        bus = new Bus("Glasgow", 50);
        jimmy = new Person();
        busStop1 = new BusStop("Union Square");
    }

    @Test
    public void busStartsEmpty(){
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void canAddPassenger(){
        bus.addPassenger(jimmy);
        assertEquals(1, bus.passengerCount());
    }

    @Test
    public void cannotAddPassengerToFullBus(){
        bus = new Bus("Glasgow", 0);
        bus.addPassenger(jimmy);
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void canRemovePassenger(){
        bus.addPassenger(jimmy);
        assertEquals(1, bus.passengerCount());
        bus.removePassenger();
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void canPickUpPassenger(){
        busStop1.addPerson(jimmy);
        bus.pickUpPassenger(busStop1);
        assertEquals(1, bus.passengerCount());
        assertEquals(0, busStop1.getQueueSize());
    }
}

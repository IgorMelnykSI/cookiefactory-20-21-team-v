package customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cookies.Order;
import cookies.customer.Member;
import static org.junit.Assert.*;


public class MemberTest {
    private Member member1;
    private Member member2;

    @BeforeEach
    public void init(){
        member1 = new Member("testLu");
        member2 = new Member("trialYao");
    }

    @Test
    public void registerLoyal() {
        member1.registerLoyal();

        assertTrue(member1.isLoyal());
        assertFalse(member2.isLoyal());
    }

    @Test
    public void applyLoyaltyDiscount() {
        member1.registerLoyal();
        assertEquals(member1.applyLoyaltyDiscount(),0.1,0.01);
        assertEquals(member2.applyLoyaltyDiscount(),0,0.01);
        assertEquals(member1.applyLoyaltyDiscount(),0,0.01);
    }

    @Test
    public void getId() {
        assertEquals(member1.getId() + 1, member2.getId());
        assertTrue(member2.getId() > 0);
    }
}

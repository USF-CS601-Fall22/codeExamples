package junit;

import javaBasics.BankAccount;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountParamTest {
        private int withdrawAmt;
        private int expectedBalance;

        public BankAccountParamTest(int withdrawAmt, int expectedBalance) {
            this.withdrawAmt = withdrawAmt;
            this.expectedBalance = expectedBalance;
        }

        @Test
        public void testCompute() {
            BankAccount ba = new BankAccount(100,"Katrin");
            ba.withdraw(withdrawAmt);
            assertEquals(expectedBalance, ba.getBalance(), 0.00001);
        }

        @Parameterized.Parameters(name = "withdraw({0}) =  {1}")
        public static Iterable<Object[]> loadTestData() {

            List<Object[]> inputExpectedList = new ArrayList<>();
            inputExpectedList.add(new Object[]{0, 100}); // the order of params is specified in the constructor of BankAccountParamTest
            inputExpectedList.add(new Object[]{100, 0});
            inputExpectedList.add(new Object[]{55, 45});
            return inputExpectedList;

        }
}

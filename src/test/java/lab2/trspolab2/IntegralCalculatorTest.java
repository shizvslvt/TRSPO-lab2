package lab2.trspolab2;
import com.example.trspolab2.Function;
import com.example.trspolab2.IntegralCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegralCalculatorTest {

    @Test
    void test1() {
        Function f = new Function();
        IntegralCalculator ic = new IntegralCalculator(8);
        double result = ic.calculate(0, 10, 2, f);
        Assertions.assertEquals(1.8195863517477946, result, 1e-15);
    }

    @Test
    void test2() {
        Function f = new Function();
        IntegralCalculator ic = new IntegralCalculator(8);
        double result = ic.calculate(0, Math.PI/3, 10, f);
        Assertions.assertEquals(0.283547174365597, result, 1e-15);
    }

    @Test
    void test3() {
        Function f = new Function();
        IntegralCalculator ic = new IntegralCalculator(8);
        double result = ic.calculate(0, Math.PI/3, 10_000, f);
        Assertions.assertEquals(0.21661106990980977, result, 1e-15);
    }

    @Test
    void test4() {
        Function f = new Function();
        IntegralCalculator ic = new IntegralCalculator(8);
        double result = ic.calculate(0, Math.PI/3, 100_000, f);
        Assertions.assertEquals(0.2165168229137073, result, 1e-15);
    }

    @Test
    void test5() {
        Function f = new Function();
        IntegralCalculator ic = new IntegralCalculator(8);
        double result = ic.calculate(0, Math.PI/3, 1_000_000, f);
        Assertions.assertEquals(0.21650739814358388, result, 1e-15);
    }
    @Test
    void test6() {
        Function f = new Function();
        IntegralCalculator ic = new IntegralCalculator(8);
        double result = ic.calculate(0, Math.PI/3, 10_000_000, f);
        Assertions.assertEquals(0.21650645566586116, result, 1e-15);
    }
}

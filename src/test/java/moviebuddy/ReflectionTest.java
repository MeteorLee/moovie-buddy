package moviebuddy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class ReflectionTest {

    @Test
    void objectCreateAndMethodCall() throws Exception {
        // Without reflection
        Duck duck = new Duck();
        duck.quack();

        // With reflection
        Class<?> duckClass = Class.forName("moviebuddy.ReflectionTest$Duck");
        Object duckObject = duckClass.getDeclaredConstructor().newInstance();
        Method quackMethod = duckObject.getClass().getDeclaredMethod("quack", new Class<?>[0]);
        quackMethod.invoke(duckObject);

    }

    static class Duck {

        void quack() {
            System.out.println("꽥꽥!");
        }
    }

}

package com.hany.java.rxjavaexample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.BeanProperty;
import java.beans.JavaBean;
import java.util.Arrays;
import java.util.concurrent.Flow.Subscriber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import rx.Observable;

@SpringBootTest
class RxjavaExampleApplicationTests {
	
	Observable observable;

	private String result = "";

	
	
	
	@Test
	void contextLoads() {
	}
	
	@BeforeEach
	void setup()
	{
		
	}
	
	@Test
	void testObservable_Using_Just()
	{
		Observable<String> observable = Observable.just("Hello");
		
		observable.subscribe(s -> result = s);
		
		assertTrue(result.equals("Hello"));
	}
	
	@Test
	public void givenArray_then_Reduce() {
		String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        String temp="";
        temp = Arrays.stream(letters).reduce("initial_", (a,b) -> a.concat(b) );
        assertEquals("initial_abcdefg", temp);
	}
	
	@Test
    public void givenArray_whenFromAndSubscribe_thenEmitsItems() {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        String temp="";
        temp = Arrays.stream(letters).reduce("", (a,b) -> a.concat(b) );
        Observable<String> observable = Observable.from(letters);
        observable.subscribe(
          i -> result += i,
          Throwable::printStackTrace,
          () -> result += "_Complete"
        );
        assertTrue(result.equals("abcdefg_Complete"));
    }
	
	
	@Test
	public void givenInterface_WhenUsingLambda_printCorrect_Output() {
		
		String s1, s2, s3;
		
		Sayable s = new Sayable(){

			@Override
			public String say() {
				return "default";
			}

			@Override
			public String say(int i) {
				// TODO Auto-generated method stub
				return "Parameter "+i ;
			}
		};
		
		assertTrue(s.say().equals("default") );
		assertTrue(s.say(1).equals("Parameter 1"));
		
		
	}
	
	@Test
	public void givenRunnable_whenNotImplemented_shouldImplement()
	{
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
	@Test
	public void givenDefaultMethod_whenUsingLamdbda_printCorrectOutput() {
		
		FuncInterface interfaceX = new FuncInterfaceImpl();
		assertTrue(interfaceX.normalFun().equals("Hello"));
		assertTrue(interfaceX.abstractFun(1).equals("AbstractFun output 1"));
	}

	interface Sayable{
		String say();
		String say (int i );
//		public  String Say(int i , int j);
	}
	
	interface FuncInterface
	{
	    // An abstract function
	    String abstractFun(int x);
	  
	    // A non-abstract (or default) function
	    default String normalFun()
	    {
	       return new String("Hello");
	    }
	}
	
	
	class FuncInterfaceImpl implements FuncInterface {

		/**
		 * @param x
		 */
		@Override
		public String abstractFun(int x) {
			return new String("AbstractFun output "+ x);
			
		}
		
	}
	
	
	
	
	
	
}

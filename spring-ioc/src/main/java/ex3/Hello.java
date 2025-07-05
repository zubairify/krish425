package ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import ex7.Message;

@Component("hi")
public class Hello {
	private String greeting;
	
	@Autowired @Qualifier(value = "sms")
	private Message msg;

	public Hello() {
		System.out.println("Default constructor");
	}
	
	public Hello(String greeting) {
		System.out.println("Parameterised constructor");
		this.greeting = greeting;
	}

	public String getGreeting() {
		System.out.println("Getter method");
		return greeting;
	}

	@Value("Aloha Spring")
	public void setGreeting(String greeting) {
		System.out.println("Setter method");
		this.greeting = greeting;
	}
}

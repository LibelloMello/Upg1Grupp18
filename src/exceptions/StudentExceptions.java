package exceptions;

public class StudentExceptions extends Exception {
	private static final long serialVersionUID = 1L;
	private Exception inner;
	
	public StudentExceptions() {
		super();
	}
	
	public StudentExceptions(String message) {
		super(message);
	}
	
	public StudentExceptions(String message, Exception inner) {
		this(message);
		this.inner = inner;
	}

	public Exception getInner() {
		return inner;
	}

	public void setInner(Exception inner) {
		this.inner = inner;
	}
}
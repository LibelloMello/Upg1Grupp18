package exceptions;

public class CourseExceptions extends Exception {
	private static final long serialVersionUID = 1L;
	private Exception inner;
	
	public CourseExceptions() {
		super();
	}
	
	public CourseExceptions(String message) {
		super(message);
	}
	
	public CourseExceptions(String message, Exception inner) {
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
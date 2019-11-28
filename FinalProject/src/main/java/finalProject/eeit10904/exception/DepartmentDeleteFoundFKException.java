package finalProject.eeit10904.exception;

public class DepartmentDeleteFoundFKException extends RuntimeException {
	Integer depno;
	private static final long serialVersionUID = 1L;

	public DepartmentDeleteFoundFKException() {}

	public DepartmentDeleteFoundFKException(Integer depno) {
		this.depno = depno;
	}

	public Integer getDepno() {
		return depno;
	}

	public void setDepno(Integer depno) {
		this.depno = depno;
	}

	public DepartmentDeleteFoundFKException(String message, Integer depno) {
		super(message);
		this.depno = depno;
	}
	
	public DepartmentDeleteFoundFKException(String message) {
		super(message);
	}

	public DepartmentDeleteFoundFKException(Throwable cause) {
		super(cause);
	}

	public DepartmentDeleteFoundFKException(String message, Throwable cause) {
		super(message, cause);
	}

	public DepartmentDeleteFoundFKException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

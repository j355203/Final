package finalProject.eeit10919.model;

public class PageFormat {
	private int totalPage;
	private int currentPage;
	private int recPerPage;
	private int startRec;
	private int endRec;

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRecPerPage() {
		return recPerPage;
	}

	public void setRecPerPage(int recPerPage) {
		this.recPerPage = recPerPage;
	}

	public int getStartRec() {
		return startRec;
	}

	public void setStartRec(int startRec) {
		this.startRec = startRec;
	}

	public int getEndRec() {
		return endRec;
	}

	public void setEndRec(int endRec) {
		this.endRec = endRec;
	}

}

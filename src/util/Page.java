package util;

public class Page {
	int count;
	int start;
	int total;
	String param;
	public Page(int start, int count) {
		super();
		this.count = count;
		this.start = start;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalPage() {
		int totalPage;
		if (0 == total % count) {
			totalPage = total / count;
		} else
			totalPage = total / count + 1;
		if (0 == totalPage)
			totalPage = 1;
		return totalPage;
	}

	public int getLast() {
		int last;
		if (0 == total % count)
			last = total - count;
		else
			last = total - total % count;

		last = last < 0 ? 0 : last;
		return last;
	}

	public boolean isHasPreviouse() {
		if (start == 0)
			return false;
		return true;

	}

	public boolean isHasNext() {
		if (start == getLast())
			return false;
		return true;
	}
	
	
	/**
	 *  按类别查询文章，。。。
	 * */
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	
	
}

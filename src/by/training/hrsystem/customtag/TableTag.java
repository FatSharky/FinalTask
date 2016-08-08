package by.training.hrsystem.customtag;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TableTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private ArrayList collection;
	private int rowPerPage = Integer.MAX_VALUE;
	private int currentPage = ONE;
	private int rowNumber = ZERO;
	private Object currentElement;

	public ArrayList getCollection() {
		return collection;
	}

	public void setCollection(ArrayList collection) {
		this.collection = collection;
	}

	public int getRowPerPage() {
		return rowPerPage;
	}

	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		if (currentPage > ZERO) {
			this.currentPage = currentPage;
		} else {
			this.currentPage = ONE;
		}
	}

	protected boolean isFirstIteration() {
		return rowNumber == ZERO;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public Object getCurrentElement() {
		return currentElement;
	}

	public void setCurrentElement(Object currentElement) {
		this.currentElement = currentElement;
	}

	public int doStartTag() {
		try {
			rowNumber = ZERO;
			JspWriter out = pageContext.getOut();
			out.write("<table border='1' class='table table-hover active'><thread><tr>");
		} catch (IOException e) {

		}
		if (rowNumber <= collection.size()) {
			return EVAL_BODY_INCLUDE;
		} else {
			return SKIP_BODY;
		}
	}

	public int doAfterBody() {
		if (rowPerPage - rowNumber > 0
				&& collection.size() > rowNumber + (currentPage - 1)
						* rowPerPage) {
			try {
				if (isFirstIteration()) {
					pageContext.getOut().write("</tr></thead><tbody><tr>");
				} else {
					pageContext.getOut().write("</tr><tr>");
				}
				rowNumber++;
			} catch (IOException e) {

			}
			currentElement = collection.get(rowNumber + (currentPage - 1)
					* (rowPerPage) - 1);
			return EVAL_BODY_AGAIN;
		} else {

			return SKIP_BODY;
		}
	}

	public int doEndTag() {
		try {
			pageContext.getOut().write("</tr></tbody></table>");
			writeNavigation();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	private void writeNavigation() {
		double pages = 1;
		if (rowPerPage != 0) {
			pages = Math.ceil((double) collection.size() / rowPerPage);
		}
		JspWriter out = pageContext.getOut();
		for (int i = 1; i <= pages; i++) {
			try {
				String command = pageContext.getRequest().getParameter(
						"command");
				out.write("<a href='controller&command=" + command
						+ "&currentpage=" + i + "&rowperpage=" + rowPerPage
						+ "'>" + i + "</a>");
			} catch (IOException e) {

			}
		}
	}
}

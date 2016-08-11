package by.training.hrsystem.customtag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/*
 * public class ColumnTag extends TagSupport{
 * 
 * private static final long serialVersionUID = 1L;
 * 
 * private String head; private String field;
 * 
 * public String getHead() { return head; } public void setHead(String head) {
 * this.head = head; } public String getField() { return field; } public void
 * setField(String field) { this.field = field; }
 * 
 * protected TableTag getTableTag() { return (TableTag)
 * findAncestorWithClass(this, TableTag.class); }
 * 
 * public int doStartTag(){ TableTag tableTag = getTableTag();
 * if(tableTag.isFirstIteration()){ addHeader(); } else { addCell(tableTag); }
 * return SKIP_BODY; }
 * 
 * private void addHeader() { JspWriter out = pageContext.getOut(); try {
 * out.write("<td>"+head+"</td>"); } catch (IOException e) { } }
 * 
 * private void addCell(TableTag tableTag) { JspWriter out =
 * pageContext.getOut(); try { //out.write("<td>"+
 * TagAttributeUtil.parseFieldValue(field, tableTag.getElement()) + "</td>"); }
 * catch (IOException e) { } }
 * 
 * 
 * }
 */
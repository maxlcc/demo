package com.jxust.svsh.model;
import java.io.Serializable;
import java.util.List;

public class PageSize<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int pageSize;//每页显示多少条记录
	private int currenPage;//当前第几页数据
	private int totalRecord;//一共所烧条记录
	private int totalPage;//一共多少页记录
	private List<T> datalist ;//要显示的数据
	
	
	
	
	public PageSize(int pageNum, int pageSize,List<T>sourceList){
		if(sourceList == null){
			return;
		}
		//总记录条数
		this.totalRecord = sourceList.size();
		//每页显示记录数
		this.pageSize = pageSize;
		//获取总页数
		this.totalPage = this.totalRecord/this.pageSize;
		if(this.totalRecord%this.pageSize !=0){
			this.totalPage = this.totalPage + 1;
		}
		//当前的总页数
		if(this.totalPage < pageNum){
			this.currenPage = this.totalPage;
		}else{
			this.currenPage = pageNum;
		}
		//起始索引
		int fromIndex = this.pageSize*(this.currenPage - 1);
		//结束索引
		int toIndex ;
		if(this.pageSize*this.currenPage>this.totalRecord){
			toIndex = this.totalRecord;
		   }else {
			   toIndex =this.pageSize*this.currenPage;
		   }
			this.datalist = sourceList.subList(fromIndex, toIndex);
		}
	
	
	public PageSize() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageSize(int pageSize, int currenPage, int totalRecord,
			int totalPage, List<T> datalist) {
		super();
		this.pageSize = pageSize;
		this.currenPage = currenPage;
		this.totalRecord = totalRecord;
		this.totalPage = totalPage;
		this.datalist = datalist;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrenPage() {
		return currenPage;
	}
	public void setCurrenPage(int currenPage) {
		this.currenPage = currenPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getDatalist() {
		return datalist;
	}
	public void setDatalist(List<T> datalist) {
		this.datalist = datalist;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}

package com.hefshine.leaves.beans;

public class Leaves {
	
private int	lid;
private int	uid;
private String ltype;
private String applied_date;
private  String formdate;
private String todate;
private String status;
private String discriptions;
private String reason;

public Leaves() {
	// TODO Auto-generated constructor stub
}

public Leaves(int lid, int uid, String ltype, String applied_date, String formdate, String todate, String status,
		String discriptions, String reason) {
	super();
	this.lid = lid;
	this.uid = uid;
	this.ltype = ltype;
	this.applied_date = applied_date;
	this.formdate = formdate;
	this.todate = todate;
	this.status = status;
	this.discriptions = discriptions;
	this.reason = reason;
}

public int getLid() {
	return lid;
}

public void setLid(int lid) {
	this.lid = lid;
}

public int getUid() {
	return uid;
}

public void setUid(int uid) {
	this.uid = uid;
}

public String getLtype() {
	return ltype;
}

public void setLtype(String ltype) {
	this.ltype = ltype;
}

public String getApplied_date() {
	return applied_date;
}

public void setApplied_date(String applied_date) {
	this.applied_date = applied_date;
}

public String getFormdate() {
	return formdate;
}

public void setFormdate(String formdate) {
	this.formdate = formdate;
}

public String getTodate() {
	return todate;
}

public void setTodate(String todate) {
	this.todate = todate;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getDiscriptions() {
	return discriptions;
}

public void setDiscriptions(String discriptions) {
	this.discriptions = discriptions;
}

public String getReason() {
	return reason;
}

public void setReason(String reason) {
	this.reason = reason;
}

@Override
public String toString() {
	return "Leaves [lid=" + lid + ", uid=" + uid + ", ltype=" + ltype + ", applied_date=" + applied_date + ", formdate="
			+ formdate + ", todate=" + todate + ", status=" + status + ", discriptions=" + discriptions + ", reason="
			+ reason + "]";
}
	

}

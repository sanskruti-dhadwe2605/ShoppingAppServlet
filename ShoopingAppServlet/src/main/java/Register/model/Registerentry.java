package Register.model;

public class Registerentry {
	private int rno;
	private String Fname;
	private String Lname;
	private String Uname;
	private String mobno;
	private String spass;
	private String repass;
	private double amount;
	
	public Registerentry(int rno, String fname, String lname, String uname, String mobno, String spass, String repass,
			Double amount) {
		super();
		this.rno = rno;
		Fname = fname;
		Lname = lname;
		Uname = uname;
		this.mobno = mobno;
		this.spass = spass;
		this.repass = repass;
		this.amount = amount;
	}
	public Registerentry() {
		// TODO Auto-generated constructor stub
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getSpass() {
		return spass;
	}
	public void setSpass(String spass) {
		this.spass = spass;
	}
	public String getRepass() {
		return repass;
	}
	public void setRepass(String repass) {
		this.repass = repass;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}

	
	
package Book_Store.dto;

public class User {
	private int id;
	private String name;
	private double wallet;
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", wallet=" + wallet + "]";
	}
	public User(int id, String name, double wallet) {
		super();
		this.id = id;
		this.name = name;
		this.wallet = wallet;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	
	
}

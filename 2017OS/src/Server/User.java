package Server;

public class User {

	// variables
	private String name;
	private String address;
	private String password;
	private String age;
	private String weight;
	private String height;
	private String activity;
	private String minutes;
	private String meal;

	public User() {
		super();
	}

	public User(String name, String address, String password, String age, String weight, String height, String activity,
			String minutes, String meal) {
		super();
		this.name = name;
		this.address = address;
		this.password = password;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.activity = activity;
		this.minutes = minutes;
		this.meal = meal;

	}

	// GETTERS AND SETTERS

	public String getName() {
		return name;
	}

	/*public void setName(String name) {
		this.name = name;
	}*/

	public String getAddress() {
		return address;
	}

	/*public void setAddress(String address) {
		this.address = address;
	}*/

	public String getPassword() {
		return password;
	}

	/*public void setPassword(String password) {
		this.password = password;
	}*/

	public String getAge() {
		return age;
	}

	/*public void setAge(String age) {
		this.age = age;
	}*/

	public String getWeight() {
		return weight;
	}

	/*public void setWeight(String weight) {
		this.weight = weight;
	}*/

	public String getHeight() {
		return height;
	}

	/*public void setHeight(String height) {
		this.height = height;
	}*/

	public String getActivity() {
		return activity;
	}

	/*public void setActivity(String activity) {
		this.activity = activity;
	}*/

	public String getMinutes() {
		return minutes;
	}

	/*public void setMinutes(String minutes) {
		this.minutes = minutes;
	}*/

	public String getMeal() {
		return meal;
	}

	/*public void setMeal(String meal) {
		this.meal = meal;
	}*/

	@Override
	public String toString() {
		return "UserDetails [name=" + name + ", address=" + address + ", password=" + password + ", age=" + age
				+ ", weight=" + weight + ", height=" + height + ", activity=" + activity + ", duration=" + minutes
				+ ", meal=" + meal + "]";
	}

}// UserDetails

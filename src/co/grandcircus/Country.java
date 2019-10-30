package co.grandcircus;

public class Country {
	String name = "";
	int population = 0;
	

	public Country() {
	}
	
	public Country(String inputLine) {
		String[] iArr = inputLine.split(",");
		this.name = iArr[0];
		this.population = Integer.parseInt(iArr[1]);
	}

	public Country(String name, int population) {
		super();
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return name + "," + population;
	}
	
	

}


public class Function {
	FunctionTypes type;
	String text;
	int cost;
	int happiness;
	int maxAmount;
	int usedAmount;
	boolean enabled;
	
	public Function(FunctionTypes type, String text, int cost, int happiness, int maxAmount, int usedAmount, boolean enabled)
	{
		this.type = type;
		this.text = text;
		this.cost = cost;
		this.happiness = happiness;
		this.maxAmount = maxAmount;
		this.usedAmount = usedAmount;
		this.enabled = enabled;
	}
	
	public void affectEarth()
	{
		//Change earth's values and your credit values;
		GameScreen.tempHappiness += happiness;
		GameScreen.tempCredits -= cost;
		usedAmount++;
	}
	
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public int getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}
	
	public int getUsedAmount() {
		return usedAmount;
	}

	public void setUsedAmount(int usedAmount) {
		this.usedAmount = usedAmount;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getText() {
		return text;
	}
	
}

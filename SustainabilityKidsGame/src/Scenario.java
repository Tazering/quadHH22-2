
public class Scenario {
	private String text;
	private int id;
	
	public Scenario (String text, int id)
	{
		this.text = text;
		this.id = id;
	}
	
	public String getText()
	{
		return text;
	}
	
	public void affectPlayer()
	{
		switch (id)
		{
		case 0:
			break;
		case 1:
			Main.functions[FunctionTypes.TREE.ordinal()].setMaxAmount(Main.functions[FunctionTypes.TREE.ordinal()].getMaxAmount() * 2);
			break;
		case 2:
			Main.functions[FunctionTypes.SOLAR.ordinal()].setCost(30);
			break;
		case 3:
			Main.functions[FunctionTypes.PARK.ordinal()].setEnabled(true);
			Main.functions[FunctionTypes.PARK.ordinal()].setMaxAmount(3);
			break;
		case 4:
			Main.functions[FunctionTypes.TURBINE.ordinal()].setEnabled(true);
			Main.functions[FunctionTypes.TURBINE.ordinal()].setMaxAmount(4);
			break;
		case 5:
		case 6:
			break;
		case 7:
			Main.functions[FunctionTypes.TREE.ordinal()].setCost(40);
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
		case 11:
			break;
		case 12:
			Main.functions[FunctionTypes.RECYCLE.ordinal()].setEnabled(false);
			Main.functions[FunctionTypes.RECYCLE.ordinal()].setMaxAmount(0);
			Main.functions[FunctionTypes.RECYCLE.ordinal()].setUsedAmount(0);
			break;
		case 13:
			Main.functions[FunctionTypes.COMPOST.ordinal()].setEnabled(false);
			Main.functions[FunctionTypes.COMPOST.ordinal()].setMaxAmount(0);
			Main.functions[FunctionTypes.COMPOST.ordinal()].setUsedAmount(0);
			break;
		case 14:
			break;
		case -1:
			break;
		default:
			System.out.println("Something's gone very wrong");
			System.exit(0);
			break;
		}
	}
}

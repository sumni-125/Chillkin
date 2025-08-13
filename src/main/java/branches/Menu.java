package branches;

public class Menu {
	
	String Menu_Code;
	String Menu_Name;
	String Price;
	String ingredient_needs;
	
	
	public Menu(String menu_Code, String menu_Name, String price, String ingredient_needs) {
		super();
		Menu_Code = menu_Code;
		Menu_Name = menu_Name;
		Price = price;
		this.ingredient_needs = ingredient_needs;
	}


	public String getMenu_Code() {
		return Menu_Code;
	}


	public String getMenu_Name() {
		return Menu_Name;
	}


	public String getPrice() {
		return Price;
	}


	public String getIngredient_needs() {
		return ingredient_needs;
	}


	@Override
	public String toString() {
		return "Menu [Menu_Code=" + Menu_Code + ", Menu_Name=" + Menu_Name + ", Price=" + Price + ", ingredient_needs="
				+ ingredient_needs + "]";
	}
	
	
	
}

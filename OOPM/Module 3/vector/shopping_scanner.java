import java.util.*;

class ShoppingList
       {
	String item_name;
	int price, quantity;
	static Vector <ShoppingList> shopping_list = new Vector <ShoppingList> (4,2);

	ShoppingList(int quantity, String item_name, int price)
               {
		this.item_name = item_name;
		this.price = price;
		this.quantity = quantity;
	}
	static void add_item(ShoppingList temp){
		System.out.println("Shopping item added: " + temp.item_name);
		System.out.println("Price: " + temp.price);
		System.out.println("Quantity: " + temp.quantity);
		System.out.println();
		shopping_list.add(temp);
	}
	static void add_item_at(ShoppingList temp, int pos){
		System.out.printf("Shopping item %s added at %d.\n", temp.item_name, pos);
		shopping_list.insertElementAt(temp, pos);
	}
	static void  delete(String item_name){
		for(int i=0; i<shopping_list.size(); i++){
			if(shopping_list.get(i).item_name.equals(item_name)){
				shopping_list.remove(i);
				System.out.println("Item deleted successfully.");
				System.out.println();
			}
		}
	}
	static void display(){
		Enumeration items = shopping_list.elements();
        while (items.hasMoreElements()) {
			ShoppingList x = (ShoppingList) items.nextElement();
			System.out.println("ShoppingItem name: "+x.item_name);
			System.out.println("ShoppingItem price: "+x.price);
			System.out.println("ShoppingItem quantity: "+x.quantity);
			System.out.println();
      }
	}
}

class shopping_scanner{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int opt, pr, qua;
		String na;
		for(int i=0; i<args.length-2; i+=3){
			qua = Integer.parseInt(args[i]);
			na = args[i+1];
			pr = Integer.parseInt(args[i+2]);
			ShoppingList temp = new ShoppingList(qua, na, pr);
			ShoppingList.add_item(temp); // Normal addition at end.
		}
	    do{
	        System.out.println("\nEnter your choice:");
	        System.out.println("1. Add Item at the End");
	        System.out.println("2. Add Item at a particular position");
	        System.out.println("3. Delete");
	        System.out.println("4. Display");
	        System.out.println("5. Exit");
	        opt = sc.nextInt();
	        switch(opt){
	            case 1: System.out.println("Enter Quantity:");
	                    int quant = sc.nextInt();
	                    System.out.println("Enter Item:");
	                    String item = sc.next();
	                    System.out.println("Enter Price:");
	                    int price = sc.nextInt();
	                    ShoppingList temp = new ShoppingList(quant ,item ,price);
	                    ShoppingList.add_item(temp);
		    ShoppingList.display();
	                	break;

	            case 2: System.out.println("Enter Quantity:");
	                    quant = sc.nextInt();
	                    System.out.println("Enter Item:");
	                    item = sc.next();
	                    System.out.println("Enter Price:");
	                    price = sc.nextInt();
	                    temp = new ShoppingList(quant ,item ,price);
	                    System.out.println("Enter Position:");
	                    int position = sc.nextInt();
	                    ShoppingList.add_item_at(temp, position);
	                	break;

	            case 3: System.out.println("Enter Item name to delete");
	                    item = sc.next();
	                    ShoppingList.delete(item);
	                	break;
	            case 4: ShoppingList.display();
	                	break;
	            case 5: break;
	        }
    	}while(opt!=5);
	}
}

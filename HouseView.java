package HouseRental.HouseView;

import HouseRental.utility.utility;
import HouseRental.HouseDomain.House;
import HouseRental.HouseService.HouseService;

public class HouseView {
	private boolean loop = true ;
	private char key = ' ';
	private HouseService houseService = new HouseService(10);
	
	
	public void update() {
		System.out.println("=======Modify House information=======");
		System.out.println("choose house you want to update(-1 to exit):");
		int updateId = utility.readInt();
		if(updateId == -1) {
			System.out.println("give up to modify");
			return;
		}
		House house = houseService.find(updateId);
		if(house==null) {
			System.out.println("=======House information not exist=======");
			return;
		}
		System.out.println("name("+house.getName()+"):");
		String name = utility.readString(8, "");
		if(!"".equals(name)) {
			house.setName(name);
		}
		System.out.println("phone("+house.getPhone()+"):");
		String phone = utility.readString(12, "");
		if(!"".equals(phone)) {
			house.setPhone(phone);
		}
		System.out.println("Address("+house.getAddress()+"):");
		String Address = utility.readString(16, "");
		if(!"".equals(Address)) {
			house.setAddress(Address);
		}
		System.out.println("Rent("+house.getRent()+"):");
		int rent = utility.readInt(-1);
		if(rent!=-1) {
			house.setRent(rent);
		}
		System.out.println("State("+house.getState()+"):");
		String state = utility.readString(3, "");
		if(!"".equals(state)) {
			house.setState(state);
		}
		System.out.println("=======Complete modification=======");
		
	}
	public void findHouse() {
		System.out.println("=======Search Houses=======");
		int findId =utility.readInt();
		House house = houseService.find(findId);
		if(house!=null) {
			System.out.println(house);
		}else {
			System.out.println("=======House not exist=======");
		}
	}
	
	public void exit() {
		char c = utility.readConfirmSelection();
		if(c=='Y') {
			loop =false;
			
		}
	}
	
	
	public void delHouse() {
		System.out.println("=======Delete Houses=======");
		System.out.println("Number House you want to delete(enter -1 to exit):");
		int delId = utility.readInt();
		if(delId == -1) {
			System.out.println("give up to delete house information...");
			return;
		}
		char choice = utility.readConfirmSelection();
		if(choice =='Y') {
			if(houseService.del(delId)) {
				System.out.println("=======Delete Houses information success=======");
			}
			else {
				System.out.println("=======Fail to delete=======");
			}
		}else {
			System.out.println("=======give up to delete house information=======");
		}
	}
	
	public void addHouse() {
		System.out.println("=======Add House=======");
		System.out.print("Name");
		String name = utility.readString(8);
		System.out.print("Phone");
		String phone = utility.readString(12);
		System.out.print("Address");
		String address = utility.readString(16);
		System.out.print("Month Rent");
		int rent = utility.readInt();
		System.out.print("Status(Y/N)");
		String status  = utility.readString(3);
		
		House newHouse = new House(0,name,phone,address,rent,status);
		if(houseService.add(newHouse)) {
			System.out.println("=======Successuflly  Add=======");
		}else {
			System.out.println("=======fail to add=======");
		}
		
	}
	
	
	public void listHouses() {
		System.out.println("=======List Houses=======");
		System.out.println("Number\t\tOwner\t\tPhone\t\tAddress\t\tMonthRent\tStatus(Y/N)");
		House[] houses = houseService.list();
		for(int i =0;i<houses.length;i++) {
			if(houses[i]==null) {
				break;
			}
			System.out.println(houses[i]);
			
		}
		
	}
	public void mainMenu() {
		do {
			System.out.println("=======Rental Menu=======");
			System.out.println("\t\t\t1 New house resource");
			System.out.println("\t\t\t2 Search house resource");
			System.out.println("\t\t\t3 Delete house information");
			System.out.println("\t\t\t4 Modify house information");
			System.out.println("\t\t\t5 House list");
			System.out.println("\t\t\t6 Exit");
			System.out.println("Please enter your selection(1-6):");
			key = utility.readChar();
			switch(key) {
			case '1':
				System.out.println("New");
				addHouse();
				break;
			case '2':
				System.out.println("Search");
				findHouse();
				break;
			case '3':
				System.out.println("Delete");
				delHouse();
				break;	
			case '4':
				System.out.println("Modify");
				update();
				break;
			case '5':
				System.out.println("List");
				listHouses();
				break;
			case '6':
				exit();
				break;
				}
		}while(loop);
	}
}

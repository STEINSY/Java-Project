package HouseRental.HouseService;
import  HouseRental.HouseDomain.House;

public class HouseService {
	private House[] houses;
	private int houseNum = 1;
	private int idCounter = 1;
	
	public HouseService(int size) {
		houses = new House[size];
		houses[0] = new House(1,"jack","112","HaiDian",2000,"weichuzu");
		
	}
	public House find(int findId) {
		for(int i  = 0;i<houseNum;i++) {
			if(findId == houses[i].getId()) {
				return houses[i];
			}
		}
		return null;
	}
	
	public boolean del(int delId) {
		int index =-1;
		for(int i = 0 ;i<houseNum;i++) {
			System.out.println(houses[i].getId());
			if(delId == houses[i].getId()) {
				index = i;	
			}
		}
		if(index == -1) {
			return false;
		}
		for(int i = index;i<houseNum -1;i++ ) {
			houses[i]=houses[i+1];
		}
		
//		house[houseNum-1] =null;
//		houseNum--;
		houses[--houseNum]=null;
		return true;
	}
	
	public boolean add(House newHouse) {
		if(houseNum==houses.length) {
			System.out.println("Full Array,cannot add....");
			return false;
		}
		houses[houseNum++] = newHouse;
//		housNum++;		
//		idCounter++;
		newHouse.setId(++idCounter);
		return true;
	}
	
	public House[] list(){
		return houses;
	}
	
	
}

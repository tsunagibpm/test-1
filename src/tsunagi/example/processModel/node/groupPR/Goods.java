package tsunagi.example.processModel.node.groupPR;

import java.util.ArrayList;

public class Goods {
	private static final long serialVersionUID = 1L;
	private ArrayList<Good> goods = new ArrayList<Good>();
	public Goods add(Good newGood) {
		for(Good good: goods) {
			if (newGood.name.equals(good.name)) {
				good.unit = newGood.unit + good.unit;
				return this;
			}
		}
		goods.add(newGood);
		return this;
	}
	public Good get(int index) {
		return goods.get(index);
	}
	public int size(){
		return goods.size();
	}
}

package clients.cashier;

import catalogue.BetterBasket;
import catalogue.Product;
import middle.MiddleFactory;

public class BetterCashierModel extends CashierModel { // same as cashier model however utilises betterbasket instead

    public BetterCashierModel(MiddleFactory mf) {
		super(mf);
		// TODO Auto-generated constructor stub
	}

	@Override
    public BetterBasket makeBasket() {
        return new BetterBasket();
    }

}

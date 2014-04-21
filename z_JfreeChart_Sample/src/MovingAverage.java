import java.util.*;

public class MovingAverage { //extends JDialog {

    public double[] ma;

    MovingAverage() {
    }

    //TODO - write a method to get close price for a stock given from&to dates.
    // it should return a list/linkedlist that can be passed to this method.
     
    /**
     * Calculates moving average just for one or more closing prices as they get added to the stocklist
     * 
     * @param stockList - updated stock list with one or more newly added closing price
     * @param days  - SMA/EMA days
     * @param type - 0 for SMA, 1 for EMA
     * @param ma_value - running sum of closing price from the last SMA calculation
     * @param index - index of the closing price in the list for which SMA was last computed.
     */
    public void calculate(LinkedList stockList, int days, int type, int ma_value, int index) { 
    	// TODO - the linkedlist parameter should get be like LinkedList<T> stockList
    	// where T can be StockDaily, or StockWeekly
    	int size = stockList.size();
    	while(index < size) {
		    Stock stock = (Stock)stockList.get(index);
		    ma_value += stock.getClose();
		    stock = (Stock)stockList.get(index-days);
		    ma_value -= stock.getClose();
		    ma[index++] = ma_value / days; // TODO - instead update the sma attribute of the stock itself.
		}
    	
    }
    
    
    
    public void calculate(LinkedList stockList, int days, int type) {
	int size = stockList.size();
	ma = new double[size];
	////////////////////////
        // Simple Moving Average
	if(type == 0) { 
	    if(days < size) {
		double ma_value = 0.00000;
		for(int a = 0; a < days; a++) {
		    Stock stock = (Stock)stockList.get(a);
		    ma_value += stock.getClose();
		    ma[a] = ma_value / (a+1);
		}
		ma[days-1] = ma_value / days;
		int index = days;
		while(index < size) {
		    Stock stock = (Stock)stockList.get(index);
		    ma_value += stock.getClose();
		    stock = (Stock)stockList.get(index-days);
		    ma_value -= stock.getClose();
		    ma[index++] = ma_value / days;
		}
	    }
	    else {
		for(int a = 0; a < size; a++) 
		    ma[a] = 0.00000;
	    }
	}
	else // Type = 1 -> Exponential moving average
	{
	    if(days < size) {
		double ma_value = 0.00000;
		for(int a = 0; a < days; a++) {
		    Stock stock = (Stock)stockList.get(a);
		    ma_value += stock.getClose();
		    ma[a] = ma_value / (a+1);
		}
		// X = (K x (C - P)) + P (X = Current EMA, C = Current Price, P = Previous period's EMA*, K = Smoothing constant)
		int index = days;		
		double K = 2 / (double)(1 + days);
		while(index < size) {
		    Stock stock = (Stock)stockList.get(index);
		    double C = stock.getClose();
		    double P = ma[index-1];
		    //System.out.println("K=" + K + " C=" + C + " P=" + P + " days=" + days);
		    ma[index++] = (K * (C - P)) + P;		    
		}		    
	    }
	}
    }

    /*
    public static void main(String[] args) {
	MovingAverage ma = new MovingAverage();	
        ma.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });		 
        ma.pack();
        ma.setVisible(true);
    }
    */
}
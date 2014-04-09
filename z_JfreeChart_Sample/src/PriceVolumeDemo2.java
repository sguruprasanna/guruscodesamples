import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.DefaultHighLowDataset;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataItem;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PriceVolumeDemo2 extends ApplicationFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public PriceVolumeDemo2(String s)
        {
                super(s);
                JFreeChart jfreechart = createChart();
                ChartPanel chartpanel = new ChartPanel(jfreechart, true, true, true, false, true);
                chartpanel.setPreferredSize(new Dimension(500, 270));
                setContentPane(chartpanel);
        }

        private static JFreeChart createChart()
        {
                //XYDataset xydataset = createPriceDataset();
        		XYDataset xydataset = getDataSet("IBM");
               
                
                DateAxis    domainAxis       = new DateAxis("Date");
                NumberAxis  rangeAxis        = new NumberAxis("Price");

                CandlestickRenderer renderer = new CandlestickRenderer();
                XYPlot mainPlot = new XYPlot(xydataset, domainAxis, rangeAxis, renderer);
                //Do some setting up, see the API Doc
                renderer.setSeriesPaint(0, Color.BLACK);
                renderer.setDrawVolume(false);
                rangeAxis.setAutoRangeIncludesZero(false);
               
                //JFreeChart jfreechart = ChartFactory.createCandlestickChart(s, "Date", "Price", mainPlot, true);
                JFreeChart jfreechart = new JFreeChart("IBM", null, mainPlot, false);
                
                
/*                double lowestLow = getLowestLow((DefaultOHLCDataset)xydataset);
                double highestHigh = getHighestHigh((DefaultOHLCDataset) xydataset);

                jfreechart.getXYPlot().getRangeAxis().setRange(lowestLow*0.95, highestHigh*1.05);*/
                
                
                
                
                XYPlot xyplot = (XYPlot)jfreechart.getPlot();
                NumberAxis numberaxis = (NumberAxis)xyplot.getRangeAxis();
                numberaxis.setLowerMargin(0.60000000000000002D);
                DecimalFormat decimalformat = new DecimalFormat("00.00");
                numberaxis.setNumberFormatOverride(decimalformat);
                XYItemRenderer xyitemrenderer = xyplot.getRenderer();
                xyitemrenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0.00")));
                
                
                
                NumberAxis numberaxis1 = new NumberAxis("Volume");
                numberaxis1.setUpperMargin(2.0D);
                xyplot.setRangeAxis(1, numberaxis1);
                xyplot.setDataset(1, createVolumeDataset());
                xyplot.setRangeAxis(1, numberaxis1);
                xyplot.mapDatasetToRangeAxis(1, 1);
                XYBarRenderer xybarrenderer = new XYBarRenderer(0.20000000000000001D);
                xybarrenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0,000.00")));
                xyplot.setRenderer(1, xybarrenderer);
                
                
/*                org.jfree.data.xy.XYDataset maDataSet = MovingAverage.createMovingAverage(xydataset, "-MAVG", 50, 0L);
                xyplot.setDataset(2, maDataSet);
                xyplot.setRenderer(2, new StandardXYItemRenderer());*/
                
                
                
                return jfreechart;
        }

        private static XYDataset createPriceDataset()
        {
                TimeSeries timeseries = new TimeSeries("Price", org.jfree.data.time.Day.class);

                File f;
                BufferedReader in = null;
                String inputLine;
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

                try{
        			f = new File("data1.csv");
        			in = new BufferedReader(new FileReader(f));
        			
        			//ignore first line
        			inputLine = in.readLine();
        			
                    while ((inputLine = in.readLine()) != null) {
                        StringTokenizer st = new StringTokenizer(inputLine, ",");
                        Date date = df.parse(st.nextToken());
                        double open = Double.parseDouble(st.nextToken());
                        double high = Double.parseDouble(st.nextToken());
                        double low = Double.parseDouble(st.nextToken());
                        double close = Double.parseDouble(st.nextToken());
                        double volume = Double.parseDouble(st.nextToken());
                        double adjClose = Double.parseDouble(st.nextToken());
                        timeseries.add(new Day(date),close);
                    }                
                } catch(Exception e){
                	e.printStackTrace();
                } finally {
                	try {
                    	if(in!=null){
                    		in.close();	
                    	}
                	}catch(Exception e){
                		e.printStackTrace();
                	}
                }
                return new TimeSeriesCollection(timeseries);
        }

        private static IntervalXYDataset createVolumeDataset()
        {
                TimeSeries timeseries = new TimeSeries("Volume", org.jfree.data.time.Day.class);
                File f;
                BufferedReader in = null;
                String inputLine;
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

                try{
        			f = new File("data1.csv");
        			in = new BufferedReader(new FileReader(f));
        			
        			//ignore first line
        			inputLine = in.readLine();
        			
                    while ((inputLine = in.readLine()) != null) {
                        StringTokenizer st = new StringTokenizer(inputLine, ",");
                        Date date = df.parse(st.nextToken());
                        double open = Double.parseDouble(st.nextToken());
                        double high = Double.parseDouble(st.nextToken());
                        double low = Double.parseDouble(st.nextToken());
                        double close = Double.parseDouble(st.nextToken());
                        double volume = Double.parseDouble(st.nextToken());
                        double adjClose = Double.parseDouble(st.nextToken());
                        timeseries.add(new Day(date),volume);
                    }                
                } catch(Exception e){
                	e.printStackTrace();
                } finally {
                	try {
                    	if(in!=null){
                    		in.close();	
                    	}
                	}catch(Exception e){
                		e.printStackTrace();
                	}
                }
                return new TimeSeriesCollection(timeseries);
        }

        public static JPanel createDemoPanel()
        {
                JFreeChart jfreechart = createChart();
                return new ChartPanel(jfreechart);
        }

        private static DefaultOHLCDataset getDataSet(String stockSymbol) {
            //This is the dataset we are going to create
            DefaultOHLCDataset result;
            //This is the data needed for the dataset
            OHLCDataItem[] data;
            //This is where we go get the data, replace with your own data source
            data = getData(stockSymbol);
            //Create a dataset, an Open, High, Low, Close dataset
            result = new DefaultOHLCDataset(stockSymbol, data);
            
            
            return result;
        }
        //This method uses yahoo finance to get the OHLC data

        protected static OHLCDataItem[] getData(String stockSymbol) {
            List<OHLCDataItem> dataItems = new ArrayList<OHLCDataItem>();
            
            File f;
            BufferedReader in = null;
            String inputLine;
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
    /*        	String strUrl = "http://ichart.yahoo.com/table.csv?s=" + stockSymbol+ "&a=4&b=1&c=2013&d=6&e=1&f=2013&g=d&ignore=.csv";
                URL url = new URL(strUrl);
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
                DateFormat df = new SimpleDateFormat("y-M-d");
                String inputLine;
                in.readLine();
    */            
    			f = new File("data1.csv");
    			in = new BufferedReader(new FileReader(f));
    			
    			//ignore first line
    			inputLine = in.readLine();
    			
                while ((inputLine = in.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(inputLine, ",");
                    Date date = df.parse(st.nextToken());
                    double open = Double.parseDouble(st.nextToken());
                    double high = Double.parseDouble(st.nextToken());
                    double low = Double.parseDouble(st.nextToken());
                    double close = Double.parseDouble(st.nextToken());
                    double volume = Double.parseDouble(st.nextToken());
                    double adjClose = Double.parseDouble(st.nextToken());
                    OHLCDataItem item = new OHLCDataItem(date, open, high, low, close, volume);
                    dataItems.add(item);
                }
            } catch (Exception e) {
                e.printStackTrace(System.err);
            } finally {
            	try {
    				in.close();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            }
            //Data from Yahoo is from newest to oldest. Reverse so it is oldest to newest
            Collections.reverse(dataItems);
            //Convert the list into an array
            OHLCDataItem[] data = dataItems.toArray(new OHLCDataItem[dataItems.size()]);
            return data;
        }        
        
        
        
        private static double getLowestLow(DefaultOHLCDataset xydataset){
            double lowest;
            lowest = xydataset.getLowValue(0,0);
            for(int i=1;i<xydataset.getItemCount(0);i++){
                if(xydataset.getLowValue(0,i) < lowest){
                    lowest = xydataset.getLowValue(0,i);
                }
            }

            return lowest;
        }


        private static double getHighestHigh(DefaultOHLCDataset xydataset){
            double highest;
            highest = xydataset.getHighValue(0,0);
            for(int i=1;i<xydataset.getItemCount(0);i++){
                if(xydataset.getLowValue(0,i) > highest){
                    highest = xydataset.getHighValue(0,i);
                }
            }

            return highest;
        } 
        
        
        public static void calculateSMA(DefaultOHLCDataset dataSet, int period){
        	
        	LinkedList<Stock> stockList = new LinkedList<Stock>();
        	for(int i=0;i<dataSet.getItemCount(0);i++){
        		Stock s = new Stock();
        		s.setClose(dataSet.getCloseValue(i, i));
        		s.setLow(dataSet.getLowValue(i, i));
        		s.setHigh(dataSet.getHighValue(i, i));
        		s.setOpen(dataSet.getOpenValue(i, i));
        		s.setDate(dataSet.getXDate(i, i));
        		stockList.add(s);
        	}
        	MovingAverage avg = new MovingAverage();
        	avg.calculate(stockList, 10, 0);
        	
        	int index = 0;
        	for(double a : avg.ma){
        		
        		System.out.println("SMA on ["+dataSet.getXDate(index, index)+"] : "+a);
        		index++;
        	}
        	
        }
        
        
        public static void calculateEMA(DefaultOHLCDataset dataSet, int period){
        	
        	LinkedList<Stock> stockList = new LinkedList<Stock>();
        	for(int i=0;i<dataSet.getItemCount(0);i++){
        		Stock s = new Stock();
        		s.setClose(dataSet.getCloseValue(i, i));
        		s.setLow(dataSet.getLowValue(i, i));
        		s.setHigh(dataSet.getHighValue(i, i));
        		s.setOpen(dataSet.getOpenValue(i, i));
        		s.setDate(dataSet.getXDate(i, i));
        		stockList.add(s);
        	}
        	MovingAverage avg = new MovingAverage();
        	avg.calculate(stockList, 10, 1);
        	
        	int index = 0;
        	for(double a : avg.ma){
        		
        		System.out.println("SMA on ["+dataSet.getXDate(index, index)+"] : "+a);
        		index++;
        	}
        	
        }       
        
        public static void calculateBB(DefaultOHLCDataset dataSet, int sma, int sdev){
        	
        	LinkedList<Stock> stockList = new LinkedList<Stock>();
        	for(int i=0;i<dataSet.getItemCount(0);i++){
        		Stock s = new Stock();
        		s.setClose(dataSet.getCloseValue(i, i));
        		s.setLow(dataSet.getLowValue(i, i));
        		s.setHigh(dataSet.getHighValue(i, i));
        		s.setOpen(dataSet.getOpenValue(i, i));
        		s.setDate(dataSet.getXDate(i, i));
        		stockList.add(s);
        	}
        	
        	Bollinger bb = new Bollinger(stockList, sma, sdev);
        	int length = bb.upper.length;
        	
        	for(int i=0; i<length; i++){
        		System.out.println("BB values on ["+dataSet.getXDate(i, i)+"]  - {U:"+bb.upper[i]+",M:"+bb.middle[i]+",L:"+bb.lower[i]+"}");
        	}
        	
        }   
        
        
        public static void main(String args[])
        {
/*              PriceVolumeDemo2 pricevolumedemo1 = new PriceVolumeDemo2("Price Volume Chart Demo");
                pricevolumedemo1.pack();
                RefineryUtilities.centerFrameOnScreen(pricevolumedemo1);
                pricevolumedemo1.setVisible(true);*/
        	
        	
        		//calculateSMA(getDataSet("IBM"),50);
        		calculateBB(getDataSet("IBM"),20,2);
        }        
}
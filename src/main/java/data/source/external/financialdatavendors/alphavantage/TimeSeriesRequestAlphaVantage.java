/**
 * 
 */
package data.source.external.financialdatavendors.alphavantage;

import java.util.List;

import data.source.external.database.influxdb.TimeSeriesId;
import data.source.internal.timeseries.TimeSeriesRequestI;
import data.source.internal.timeseries.point.TimeSeriesPointAbstract;
import data.source.internal.timeseries.point.TimeSeriesPointI;

/**
 * @author stefanopenazzi
 *
 */
public class TimeSeriesRequestAlphaVantage implements TimeSeriesRequestI  {

	@Override
	public List<TimeSeriesPointI> getTimeSeries(TimeSeriesId iq) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

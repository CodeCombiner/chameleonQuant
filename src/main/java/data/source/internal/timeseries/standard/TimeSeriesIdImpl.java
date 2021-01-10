/**
 * 
 */
package data.source.internal.timeseries.standard;

import java.time.Instant;
import java.util.Date;

import data.source.internal.timeseries.TimeSeriesIdAbstract;
import data.source.internal.timeseries.point.TimeSeriesPointAbstract;
import data.source.internal.timeseries.point.TimeSeriesPointI;

/**
 * @author stefanopenazzi
 *
 */
public class TimeSeriesIdImpl extends TimeSeriesIdAbstract {

	
	private final Instant startInstant;
	private final Instant endInstant;
	private final String id;
	private final String inter;
	
	public TimeSeriesIdImpl(Instant startInstant, Instant endInstant, String id,String inter) {
		this.startInstant = startInstant;
		this.endInstant = endInstant;
		this.id = id;
		this.inter = inter;
	}
	
	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public Instant getStartInstant() {
		return this.startInstant;
	}

	@Override
	public Instant getEndInstant() {
		return this.endInstant;
	}

	@Override
	public String getInterval() {
		return this.inter;
	}
}

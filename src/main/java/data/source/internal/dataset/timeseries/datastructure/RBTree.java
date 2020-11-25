/**
 * 
 */
package data.source.internal.dataset.timeseries.datastructure;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

import data.source.internal.dataset.timeseries.point.InternalTimeSeriesPoint;

/**
 * @author stefanopenazzi
 *
 */
public class RBTree<T extends InternalTimeSeriesPoint> implements TimeSeriesDataStructureI<T> {

	private TreeMap<Instant,T> map;
	
	
	public RBTree(List<T> input) {
		initialize(input);
	}
	
	private void initialize(List<T> input) {
		map = new TreeMap<Instant,T>();
		for(T tsp: input) {
			map.put(tsp.getTime(), tsp);
		}
	}
	
	@Override
	public TimeSeriesDataStructureI<T> getRange(Instant startTime, Instant endTime) {
		Instant aStart = map.floorEntry(startTime).getKey();
		Instant aEnd = map.ceilingEntry(endTime).getKey();
		NavigableMap<Instant, T> subMap = map.subMap(aStart, true,aEnd,true);
		return new RBTree<T>((List<T>) subMap.values());
	}

	@Override
	public T getPoint(Instant time) {
		return map.get(time);
	}

	@Override
	public T getCeilingPoint(Instant time) {
		return map.ceilingEntry(time).getValue();
	}

	@Override
	public T getFloorPoint(Instant time) {
		return map.floorEntry(time).getValue();
	}

	@Override
	public synchronized void addPoint(T tsp) {
		map.put(tsp.getTime(), tsp);
	}

	@Override
	public synchronized void removePoint(T tsp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getFirst() {
		return map.firstEntry().getValue();
	}

	@Override
	public T getLast() {
		map.lastEntry().getValue();
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		return (Iterator<T>) map.values().iterator();
	}

}

package tripleprice.aggregator.thrift.handler;

import java.util.List;

import org.apache.thrift.TException;

import tripleprice.aggregator.thrift.CrossPlatformResource;
import tripleprice.aggregator.thrift.CrossPlatformService;
import tripleprice.aggregator.thrift.InvalidOperationException;

public class CrossPlatformServiceImpl implements CrossPlatformService.Iface {

	@Override
	public CrossPlatformResource get(int id) throws InvalidOperationException, TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(CrossPlatformResource resource) throws InvalidOperationException, TException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CrossPlatformResource> getList() throws InvalidOperationException, TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ping() throws InvalidOperationException, TException {
		// TODO Auto-generated method stub
		return true;
	}

}
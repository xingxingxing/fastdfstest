package cn.wellcom.fastdfs;

import java.io.IOException;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastClientFactory extends BasePooledObjectFactory<FastClient>{
	
	public FastClientFactory(String confPath) throws IOException, MyException {
		super();
		ClientGlobal.init(confPath);
	}

	@Override
	public FastClient create() throws Exception {
		TrackerClient tracker = new TrackerClient();
		TrackerServer trackerServer = tracker.getConnection();
		StorageServer storageServer = tracker.getStoreStorage(trackerServer);
		FastClient client = new FastClient(trackerServer, storageServer);
		return client;
	}

	@Override
	public PooledObject<FastClient> wrap(FastClient client) {
		return new DefaultPooledObject<FastClient>(client);   
	}

}

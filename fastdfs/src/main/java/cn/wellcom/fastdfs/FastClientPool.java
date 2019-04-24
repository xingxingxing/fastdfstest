package cn.wellcom.fastdfs;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class FastClientPool extends GenericObjectPool<FastClient> {

	public FastClientPool(PooledObjectFactory<FastClient> factory, GenericObjectPoolConfig config) {
		super(factory, config);
	}

}

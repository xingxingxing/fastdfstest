package cn.wellcom.fastdfs;

import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerServer;

public class FastClient extends StorageClient1 {

	public FastClient(TrackerServer trackerServer, StorageServer storageServer) {
		super(trackerServer, storageServer);
	}

}

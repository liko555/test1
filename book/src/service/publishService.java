package service;

import java.util.List;

import dao.publishDAO;
import entity.publish;

public class publishService {
	//²éÑ¯ËùÓĞ
	public List<publish> getPublishs(){
		publishDAO dao = new publishDAO();
		return dao.queryAll();
	}
	
	public int getPublishId(String publishName) {
		publishDAO dao = new publishDAO();
		publish publish=dao.query(publishName);
		if(publish!=null) {
			
			return publish.getPublishId();
		}
		return 0;
	}
}

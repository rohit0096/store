package com.app.service;

import java.util.List;

import com.app.pojos.DeliveryInfo;
import com.app.pojos.Status;

public interface IDeliveryService {
	
	List<DeliveryInfo> getDeliveryInfo();
	List<DeliveryInfo> getMyDeliverInfo(int userId);
	String changeDeliveryInfo(int dId,Status Status);
	String deleteDeliveryInfo(int D_id);
	DeliveryInfo getbyId(int id);

}

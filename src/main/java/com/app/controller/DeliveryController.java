package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ChangeDeliveryStatus;
import com.app.service.IDeliveryService;

@RestController
@CrossOrigin
@RequestMapping("/delivery")
public class DeliveryController {
	
	@Autowired
	private IDeliveryService deliveryInfo;
	
	
	public DeliveryController() {
	
		System.out.println("in const "+getClass().getName() );
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping("/info")
	public ResponseEntity<?> getDeliveryInfo(){
		
		return ResponseEntity.ok(deliveryInfo.getDeliveryInfo());
	}
	
	@GetMapping("/myOrderStatus")
	public ResponseEntity<?> getMyOrderStatus(){
		int userId=Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
		return ResponseEntity.ok(deliveryInfo.getMyDeliverInfo(userId));
	}
	
	@PutMapping("/changeStatus")
	public ResponseEntity<?> changeOrderStatus(@RequestBody ChangeDeliveryStatus cds){
		return ResponseEntity.ok(deliveryInfo.changeDeliveryInfo(cds.getdInt(), cds.getStatus()));
	}
	
	@DeleteMapping("/deleteDelivery/{dId}")
	public ResponseEntity<?> deleteDeliveryInfo(@PathVariable int dId){
		return ResponseEntity.ok(deliveryInfo.deleteDeliveryInfo(dId));
	}
	
	@GetMapping("/orderStatus/{id}")
	public ResponseEntity<?> getOrderStatusById(@PathVariable int id){
		return ResponseEntity.ok(deliveryInfo.getbyId(id));
	}
	
	
	
	
	
	
	

}

package com.nagarro.training.springboot.ServiceInterface;

import com.nagarro.training.springboot.Model.SwalClass;
//interface for pincode validity check for product delivery
public interface PinCodeServiceInterface {

	boolean getPinCodeByID(long pincode);

	SwalClass getSwalmsg(long pincode);

}

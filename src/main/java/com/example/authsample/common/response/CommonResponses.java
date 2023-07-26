package com.example.authsample.common.response;


import com.example.authsample.common.controller.BaseController;

public class CommonResponses<T> extends BaseController {

	private static final String CODE_SUCCESS = "200";
	private static final String CODE_FAILED = "500";
	private static final String STR_FAILED_BILL = "Billing Melebihi Limit, Silahkan Selesaikan Transaksi Sebelumnya!";

	public CustomReturn<T> commonSuccessResponse(T wrapper) {
		CustomReturn<T> customReturn = new CustomReturn<>();
		customReturn.setMessage(STR_SUCCESS);
		customReturn.setStatus(true);
		customReturn.setStatusCode(CODE_SUCCESS);
		customReturn.setDatas(wrapper);
		return customReturn;
	}

	public CustomReturn<T> commonDeleteBillSuccess() {
		CustomReturn<T> customReturn = new CustomReturn<>();
		customReturn.setMessage("Delete Success");
		customReturn.setStatusCode(CODE_SUCCESS);
		customReturn.setStatus(true);
		return customReturn;
	}

	public CustomReturn<T> commonDeleteBillFailed() {
		CustomReturn<T> customReturn = new CustomReturn<>();
		customReturn.setMessage("Delete Failed");
		customReturn.setStatusCode(CODE_FAILED);
		customReturn.setStatus(false);
		return customReturn;
	}

	public CustomReturn<T> commonSavePaymentSuccess() {
		CustomReturn<T> customReturn = new CustomReturn<>();
		customReturn.setMessage(STR_SUCCESS);
		customReturn.setStatus(true);
		customReturn.setStatusCode(CODE_SUCCESS);
		return customReturn;
	}

	public CustomReturn<T> commonApiKeyInvalid() {
		CustomReturn<T> customReturn = new CustomReturn<>();
		customReturn.setMessage("API Invalid");
		customReturn.setStatus(false);
		customReturn.setStatusCode(CODE_FAILED);
		return customReturn;
	}

	public CustomReturn<T> commonSavePaymentFailed() {
		CustomReturn<T> customReturn = new CustomReturn<>();
		customReturn.setMessage(STR_FAILED_BILL);
		customReturn.setStatus(false);
		customReturn.setStatusCode(CODE_FAILED);
		return customReturn;
	}

	public CustomReturn<T> commonFailedResponse() {
		CustomReturn<T> customReturn = new CustomReturn<>();
		customReturn.setMessage(STR_FAILED);
		customReturn.setStatus(true);
		customReturn.setStatusCode(CODE_FAILED);
		return customReturn;
	}

	public CustomReturn<T> commonFailedError() {
		CustomReturn<T> customReturn = new CustomReturn<>();
		customReturn.setMessage(STR_ERROR);
		customReturn.setStatus(false);
		customReturn.setStatusCode(CODE_FAILED);
		return customReturn;
	}

}

package com.example.authsample.common.response;


import com.example.authsample.common.controller.BaseController;

public class CommonResponses<T> extends BaseController {

	private static final String CODE_SUCCESS = "200";
	private static final String CODE_FAILED = "500";
	private static final String CODE_FORBIDDEN = "403";

	public CustomReturn<T> commonSuccessResponse(T wrapper) {
		CustomReturn<T> customReturn = new CustomReturn<>();
		customReturn.setMessage(STR_SUCCESS);
		customReturn.setStatus(true);
		customReturn.setStatusCode(CODE_SUCCESS);
		customReturn.setDatas(wrapper);
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

	public CustomReturn<T> commonSuccessLogin(T wrapper) {
		CustomReturn<T> customReturn = new CustomReturn<>();
		customReturn.setMessage(STR_SUCCESS);
		customReturn.setStatus(true);
		customReturn.setStatusCode(CODE_SUCCESS);
		customReturn.setDatas(wrapper);
		return customReturn;
	}

	public CustomReturn<T> commonFailedLogin() {
		CustomReturn<T> customReturn = new CustomReturn<>();
		customReturn.setMessage(STR_FAILED_LOGIN);
		customReturn.setStatus(false);
		customReturn.setStatusCode(CODE_FAILED);
		return customReturn;
	}

	public CustomReturn<T> commonForbidden() {
		CustomReturn<T> customReturn = new CustomReturn<>();
		customReturn.setMessage(STR_FAILED_FORBIDDEN);
		customReturn.setStatus(false);
		customReturn.setStatusCode(CODE_FORBIDDEN);
		return customReturn;
	}

}

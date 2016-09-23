package xxland.com.common.response.impl;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonResponse {

//	public int value;

	private String errFlg;
	private String errMsg;

	private Map<?, ?> map;

	private List<?> mainList;

//	private static<T> T mainEntity;

	public JsonResponse(){
		errFlg="0";
		errMsg="Nothing";
	}

	public String getErrFlg() {
		return errFlg;
	}

	public void setErrFlg(String errFlg) {
		this.errFlg = errFlg;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Map<?, ?> getMap() {
		return map;
	}

	public void setMap(Map<?, ?> map) {
		this.map = map;
	}

	public List<?> getMainList() {
		return mainList;
	}

	public void setMainList(List<?> mainList) {
		this.mainList = mainList;
	}



}

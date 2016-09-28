package xxland.com.app.control;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kun.common.web.control.BaseControl;

import xxland.com.common.response.impl.JsonConverter;
import xxland.com.common.response.impl.JsonResponse;
import xxland.com.domain.model.KnowLedge;
import xxland.com.service.IBrainService;
import xxland.framework.ComConstant;
import xxland.framework.io.impl.KnowLedgeFileControllerImpl;

@Controller("brainControl")
@RequestMapping("/knowledge")
public class BrainControl extends BaseControl<KnowLedge> {

	@Resource(name = "brainService")
	private IBrainService brainService;

	/**
	 * 検索
	 *
	 * @author songkun
	 * @return String
	 * @date 2011-6-1 午後12:48:45
	 * @since 2.0.0
	 */
	@RequestMapping("/search.do" )
	@ResponseBody
	public String search(KnowLedge knowLedge) {

	    JsonResponse jsonResponse = new JsonResponse();
		try {
//			String errFlg="0";

			KnowLedgeFileControllerImpl knowLedgeFileControllerImpl = new KnowLedgeFileControllerImpl(ComConstant.KNOWLEDGE_PASS+knowLedge.getMainKey()+".txt");
			List<KnowLedge> knowLedgeList = new ArrayList<KnowLedge>();
			knowLedgeList = knowLedgeFileControllerImpl.FindKnowLedge(knowLedge.getMainKey());
			JSONObject obj = new JSONObject();


			if (knowLedgeList.size()!=0){
				obj.put("list", knowLedgeList);
				System.out.println(obj.getJSONArray("list"));
//				errFlg="1";
			}
		    jsonResponse.setMainList(knowLedgeList);

		    System.out.println(JsonConverter.toString(jsonResponse));

		    return JsonConverter.toString(jsonResponse);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 登録
	 *
	 * @author songkun
	 * @return String
	 * @date 2011-6-1 午後12:48:45
	 * @since 2.0.0
	 */
	@RequestMapping("/insert.do" )
	@ResponseBody
	public String insert(KnowLedge knowLedge) {

	    JsonResponse jsonResponse = new JsonResponse();
		try {
//			String errFlg="0";

			KnowLedgeFileControllerImpl knowLedgeFileControllerImpl = new KnowLedgeFileControllerImpl(ComConstant.KNOWLEDGE_PASS+knowLedge.getSubMainKey()+".txt");

			knowLedgeFileControllerImpl.AddKnowLedge(knowLedge);

			JSONObject obj = new JSONObject();
			List<KnowLedge> knowLedgeList = new ArrayList<KnowLedge>();
			knowLedgeList.add(knowLedge);
			obj.put("list", knowLedgeList);
		    jsonResponse.setMainList(knowLedgeList);

		    System.out.println(obj.getJSONArray("list"));
		    return JsonConverter.toString(jsonResponse);

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 削除
	 *
	 * @author songkun
	 * @return String
	 * @date 2011-6-1 午後12:48:45
	 * @since 2.0.0
	 */
	@RequestMapping("/delete.do" )
	@ResponseBody
	public String delete(KnowLedge knowLedge) {

	    JsonResponse jsonResponse = new JsonResponse();
		try {
//			String errFlg="0";

			KnowLedgeFileControllerImpl knowLedgeFileControllerImpl = new KnowLedgeFileControllerImpl(ComConstant.KNOWLEDGE_PASS+knowLedge.getSubMainKey()+".txt");

			knowLedgeFileControllerImpl.AddKnowLedge(knowLedge);

			JSONObject obj = new JSONObject();
			List<KnowLedge> knowLedgeList = new ArrayList<KnowLedge>();
			knowLedgeList.add(knowLedge);
			obj.put("list", knowLedgeList);
		    jsonResponse.setMainList(knowLedgeList);

		    System.out.println(obj.getJSONArray("list"));
		    return JsonConverter.toString(jsonResponse);

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return null;

	}

}

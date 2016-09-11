package xxland.com.app.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import xxland.com.common.response.impl.JsonConverter;
import xxland.com.common.response.impl.JsonResponse;
import xxland.com.domain.model.KnowLedge;
import xxland.com.service.IBrainService;
import xxland.framework.io.impl.KnowLedgeFileControllerImpl;

import com.kun.common.constant.Constants;
import com.kun.common.web.control.BaseControl;
import com.kun.common.web.response.MessageOut;
import com.kun.common.web.response.Out;

@Controller("brainControl")
@RequestMapping("/knowledge")
public class BrainControl extends BaseControl<KnowLedge> {

	@Resource(name = "brainService")
	private IBrainService brainService;

	/**
	 * 登录
	 *
	 * @author songkun
	 * @return String
	 * @date 2011-6-1 午後12:48:45
	 * @since 2.0.0
	 */
	@RequestMapping("/search.do" )
	@ResponseBody
	public String search(KnowLedge knowLedge) {

//			try {
//				KnowLedge tmp = this.brainService.validate(knowLedge);
//			} catch (ServiceException e) {
//				// TODO 自動生成された catch ブロック
//				e.printStackTrace();
//			}
//			if (tmp == null) {// 登録失敗
////				return MessageOut.LOGIN_FAIL_MESSAGE;
//				ModelAndView modelAndView = new ModelAndView();
//				modelAndView.addObject(operater);
//		        modelAndView.setViewName("/menu.jsp");
//				return modelAndView;
//			}
//			((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession(true)
//					.setAttribute(Constants.USER_INFO, tmp);
////			return MessageOut.LOGIN_OK_MESSAGE;
////
	    JsonResponse jsonResponse = new JsonResponse();
		ModelAndView modelAndView = new ModelAndView();
		try {
			String errFlg="0";
           //

			KnowLedgeFileControllerImpl knowLedgeFileControllerImpl = new KnowLedgeFileControllerImpl();
			List<KnowLedge> knowLedgeList = new ArrayList<KnowLedge>();
			knowLedgeList = knowLedgeFileControllerImpl.FindKnowLedge(knowLedge.getMainKey());
			JSONObject obj = new JSONObject();


			if (knowLedgeList.size()!=0){
				obj.put("list", knowLedgeList);
				modelAndView.addObject("knowLedge",obj.getJSONArray("list"));
			System.out.println(obj.getJSONArray("list"));
				errFlg="1";
			}

//			modelAndView.addObject("errFlg",errFlg);
//		    modelAndView.setViewName("/view/brain/knowledge.html");


		    jsonResponse.setMainList(knowLedgeList);

System.out.println(JsonConverter.toString(jsonResponse));



		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
//		return MessageOut.LOGIN_FAIL_MESSAGE;
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject(knowLedge);
//        modelAndView.setViewName("/menu.jsp");
//		return modelAndView;
//		return modelAndView;

//		return null;
		   try {
			return JsonConverter.toString(jsonResponse);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
//		return modelAndView;
		return null;

	}

	/**
	 * ログアウト
	 *
	 * @author songkun
	 * @return String
	 * @date 2011-6-1 午後12:49:55
	 * @since 2.0.0
	 */
	@RequestMapping("/logout.do")
	@ResponseBody
	public Out<Object> logout() {
		try {
			((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession()
					.removeAttribute(Constants.USER_INFO);
		} catch (Exception e) {
			this.getLogger().error(e);
		}
		return MessageOut.LOGOUT_OK_MESSAGE;
	}
}

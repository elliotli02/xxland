package xxland.com.app.control;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.kun.common.constant.Constants;
import com.kun.common.web.control.BaseControl;
import com.kun.common.web.response.MessageOut;
import com.kun.common.web.response.Out;

import xxland.com.common.exception.ServiceException;
import xxland.com.domain.model.KnowLedge;
import xxland.com.service.IBrainService;

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
	public ModelAndView search(KnowLedge knowLedge) {
		try {
			KnowLedge tmp = this.brainService.validate(knowLedge);
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
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("knowLedge",knowLedge);
	        modelAndView.setViewName("/menu.jsp");
			return modelAndView;
		} catch (ServiceException e) {
			this.getLogger().error(e);
		} catch (Exception e) {
			this.getLogger().error(e);
		}
//		return MessageOut.LOGIN_FAIL_MESSAGE;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(knowLedge);
        modelAndView.setViewName("/menu.jsp");
		return modelAndView;
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

package hello.servlet.web.frontcontroller.v1.controller

import hello.servlet.web.frontcontroller.v1.ControllerV1
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberFormControllerV1 : ControllerV1 {
  override fun process(request: HttpServletRequest?, response: HttpServletResponse?) {
    val viewPath = "/WEB-INF/views/new-form.jsp"
    val requestDispatcher = request?.getRequestDispatcher(viewPath)
    // 제어권을 넘김
    requestDispatcher?.forward(request, response)
  }
}
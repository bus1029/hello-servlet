package hello.servlet.web.frontcontroller.v1.controller

import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.v1.ControllerV1
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberListControllerV1 : ControllerV1 {
  // Singleton
  private val memberRepository = MemberRepository
  
  override fun process(request: HttpServletRequest?, response: HttpServletResponse?) {
    val members = memberRepository.findAll()

    request?.also {
      val viewPath = "/WEB-INF/views/members.jsp"
      request.setAttribute("members", members)
      val requestDispatcher = request.getRequestDispatcher(viewPath)
      requestDispatcher.forward(request, response)
    }
  }
}
package hello.servlet.web.frontcontroller.v1.controller

import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.v1.ControllerV1
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberSaveControllerV1 : ControllerV1 {
  // Singleton
  private val memberRepository = MemberRepository

  override fun process(request: HttpServletRequest?, response: HttpServletResponse?) {
    request?.also {
      val userName = request.getParameter("username")
      val age = request.getParameter("age").toInt()

      val member = Member(userName, age)
      memberRepository.save(member)

      // Model 에 데이터 보관
      request.setAttribute("member", member)
      val viewPath = "/WEB-INF/views/save-result.jsp"
      val requestDispatcher = request.getRequestDispatcher(viewPath)
      requestDispatcher.forward(request, response)
    }
  }
}
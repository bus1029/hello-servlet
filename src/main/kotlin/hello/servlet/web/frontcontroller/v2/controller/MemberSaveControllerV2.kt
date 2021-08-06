package hello.servlet.web.frontcontroller.v2.controller

import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v1.ControllerV1
import hello.servlet.web.frontcontroller.v2.ControllerV2
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberSaveControllerV2 : ControllerV2 {
  private val memberRepository = MemberRepository

  override fun process(request: HttpServletRequest?, response: HttpServletResponse?): MyView {
    request?.also {
      val userName = request.getParameter("username")
      val age = request.getParameter("age").toInt()

      val member = Member(userName, age)
      memberRepository.save(member)

      // Model 에 데이터 보관
      request.setAttribute("member", member)
      return MyView("/WEB-INF/views/save-result.jsp")
    }

    return MyView("index.html")
  }
}
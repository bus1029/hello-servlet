package hello.servlet.web.servletmvc

import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = ["/servlet-mvc/members/save"])
class MvcMemberSaveServlet : HttpServlet() {
  // Singleton
  private val memberRepository = MemberRepository

  override fun service(request: HttpServletRequest?, response: HttpServletResponse?) {
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
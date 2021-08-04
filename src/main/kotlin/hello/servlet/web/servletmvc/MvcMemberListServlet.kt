package hello.servlet.web.servletmvc

import hello.servlet.domain.member.MemberRepository
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "mvcMemberListServlet", urlPatterns = ["/servlet-mvc/members"])
class MvcMemberListServlet : HttpServlet() {
  // Singleton
  private val memberRepository = MemberRepository

  override fun service(request: HttpServletRequest?, response: HttpServletResponse?) {
    val members = memberRepository.findAll()

    request?.also {
      val viewPath = "/WEB-INF/views/members.jsp"
      request.setAttribute("members", members)
      val requestDispatcher = request.getRequestDispatcher(viewPath)
      requestDispatcher.forward(request, response)
    }
  }
}
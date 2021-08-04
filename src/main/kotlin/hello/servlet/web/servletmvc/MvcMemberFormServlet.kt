package hello.servlet.web.servletmvc

import hello.servlet.domain.member.MemberRepository
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = ["/servlet-mvc/members/new-form"])
class MvcMemberFormServlet : HttpServlet() {
  // Singleton
  private val memberRepository = MemberRepository

  override fun service(request: HttpServletRequest?, response: HttpServletResponse?) {
    val viewPath = "/WEB-INF/views/new-form.jsp"
    val requestDispatcher = request?.getRequestDispatcher(viewPath)
    // 제어권을 넘김
    requestDispatcher?.forward(request, response)
  }
}